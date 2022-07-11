package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilityFunctions {
    public static JsonPath jsonPath;

    //convert response to json and get data from this json
    public static String getResponseKeyValue(String responseBody, String responseKey) {
        jsonPath = new JsonPath(responseBody);
        String keyValue = jsonPath.get(responseKey);
        return keyValue;
    }

    public static int getStatusCode(Response response) {
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    public static String getStatusMessage(Response response) {
        String statusMessage = response.getStatusLine();
        return statusMessage;
    }

    public static String getResponseHeader(Response response, String headerKey) {
        String responseHeader = response.getHeader(headerKey);
        return responseHeader;
    }

    public static String getResponseContentType(Response response) {
        String responseContentType = response.getContentType();
        return responseContentType;
    }
}
