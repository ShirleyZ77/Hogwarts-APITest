package api;

import Base.BulidAccess;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TagManage {
    public Response CreateTag(String tagname,int tagid){
        HashMap<String, Object> map = new HashMap();
        map.put("tagname",tagname);
        map.put("tagid",tagid);
        return given()
                    .queryParam("access_token",BulidAccess.getInstance().getToken())
                    .contentType(ContentType.JSON)
                    .body(map)
                .when().log().all()
                    .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
                .then().log().body()
                    .body("errmsg",equalTo("created"))
                    .extract().response();
    }

    public Response UpdateTagName(String tagname,int tagid){
        HashMap<String, Object> map = new HashMap();
        map.put("tagname",tagname);
        map.put("tagid",tagid);
        return given()
                    .queryParam("access_token",BulidAccess.getInstance().getToken())
                    .contentType(ContentType.JSON)
                    .body(map)
                .when().log().all()
                    .post("https://qyapi.weixin.qq.com/cgi-bin/tag/update")
                .then().log().body()
                    .body("errmsg",equalTo("updated"))
                .extract().response();
    }

    public Response DeleteTag(int tagid){
        return given()
                    .param("access_token",BulidAccess.getInstance().getToken())
                    .param("id",tagid)
                .when().log().all()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete")
                .then().log().body()
                //.body("errmsg",equalTo("deleted"))
                    .extract().response();
    }
}
