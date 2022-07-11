
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resourcesForBodies.pojoClasses.CreateRepoPojo;


public class BaseClass {
    public static Response getRequest(String requestURI) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        //send request and save response
        Response response = requestSpecification.get(requestURI);
        return response;
    }

    //post method that sends Json as String
    public static Response postRequest(String requestURI, String requestBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.post(requestURI);
        return response;
    }

    //post method that use token for authorization and sends Json as String
    public static Response postRequest(String requestURI, String requestBody, String token) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + token);
        Response response = requestSpecification.post(requestURI);
        return response;
    }

    //post method that use token for authorization and sends Json as an object
    public static Response postRequest(String requestURI, CreateRepoPojo body, String token) {
        RequestSpecification requestSpecification = RestAssured.given().body(body);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + token);
        Response response = requestSpecification.post(requestURI);
        return response;
    }

    public static Response putRequest(String requestURI, String requestBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.put(requestURI);
        return response;
    }

    public static Response deleteRequest(String requestURI) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(requestURI);
        return response;
    }

    public static Response deleteRequest(String requestURI, String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + token);
        Response response = requestSpecification.delete(requestURI);
        return response;
    }

    public static Response deleteRequestWithPayload(String requestURI, String requestBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(requestURI);
        return response;
    }
}
