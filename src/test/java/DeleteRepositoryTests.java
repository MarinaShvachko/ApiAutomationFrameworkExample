import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Authentication;
import utility.BodyGenerator;
import utility.CommonUtilityFunctions;
import utility.Url;

public class DeleteRepositoryTests {
    private static final String USER_NAME = "MarinaShvachko";
    String endPoint = Url.getBaseUrI("/user/repos");
    String token = Authentication.getToken();
    Response response;

    @Test
    public void deleteRepository() {
        String requestBody = BodyGenerator.generateBodyFromFileToString("createRepo.json");
        response = BaseClass.postRequest(endPoint, requestBody, token);
        String deleteEndPoint = Url.getBaseUrI("/repos/" + USER_NAME + "/") + CommonUtilityFunctions.getResponseKeyValue(requestBody, "name");
        response = BaseClass.deleteRequest(deleteEndPoint, token);
        Assert.assertEquals(CommonUtilityFunctions.getStatusCode(response), 204, "Error while deleting the repository");
    }
}
