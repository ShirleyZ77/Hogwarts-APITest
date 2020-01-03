package api;

import Base.BulidAccess;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DepartmentManage {

    public static int deptId = 2;

    public Response getDepartmentList(int OrignDeptId){
        return given()
                    .param("access_token",BulidAccess.getInstance().getToken())
                    .param("id",deptId)
                .when().log().all()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().body()
                    .body("errmsg",equalTo("ok"))
                    .extract().response();
    }

    public Response createDept(String deptName,int ptId,int Id,int order){
        HashMap<String, Object> map = new HashMap();
        map.put("name",deptName);
        map.put("parentid",ptId);
        map.put("order",order);
        map.put("id",Id);
        Response response =  given()
                    .queryParam("access_token",BulidAccess.getInstance().getToken())
                    .contentType(ContentType.JSON)
                    .body(map)
                .when().log().all()
                    .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().body()
                    .body("errmsg",equalTo("created"))
                    .extract().response();
        return response;
    }

    public Response deleteDept(int ptId){
        return given()
                    .param("access_token",BulidAccess.getInstance().getToken())
                    .param("id",ptId)
                .when().log().all()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().body()
                    //.body("errmsg",equalTo("deleted"))
                    .extract().response();
    }

}
