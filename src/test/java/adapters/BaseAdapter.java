package adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new Gson();

    String PROJECT_URL = "https://api.qase.io/v1/";

    public String post(String body, int status, String url) {
        return
                given().
                        header("Token", "427c4e87166cb838a6498704ba965e71c8a6cdd1").
                        header("Content-Type", "application/json").
                        header("Accept", "application/json").
                        body(body).
                        log().all().
                when().
                        post(url).
                then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    public String get(int status, String url) {
        return
                given().
                        header("Token", "427c4e87166cb838a6498704ba965e71c8a6cdd1").
                        header("Content-Type", "application/json").
                        header("Accept", "application/json").
                        log().all().
                when().
                        get(url).
                then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }
}
