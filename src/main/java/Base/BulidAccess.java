package Base;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BulidAccess {
    private static BulidAccess bulidAccess;
    String token;

    public static BulidAccess getInstance(){
        if(bulidAccess == null){
            bulidAccess = new BulidAccess();
        }
        return bulidAccess;
    }

    public String getToken(){
        if(token == null){
            token = given().
                        param("corpid", "wwd6da61649bd66fea")
                        .param("corpsecret", "C7uGOrNyxWWzwBsUyWEbLdbZBDrc71PNOhyQ_YYPhts")
                    .when()
                        .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                    .then()
                        .body("errmsg",equalTo("ok"))
                        .extract()
                        .path("access_token");
        }
        return token;
    }
}
