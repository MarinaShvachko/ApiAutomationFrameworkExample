import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import resourcesForBodies.pojoClasses.CreateRepoPojo;
import utility.Authentication;
import utility.BodyGenerator;
import utility.CommonUtilityFunctions;
import utility.Url;

//TODO: add log4j
//TODO: move common final variables to a separate class
//:TODO: add start of tests via testNG file
public class CreateRepositoryTests {
    private static final String USER_NAME = "MarinaShvachko";
    String endPoint = Url.getBaseUrI("/user/repos");
    String token = Authentication.getToken();
    Response response;

    @Test
    public void createRepoWithBodyAsString() {
        String requestBody = BodyGenerator.generateBodyFromFileToString("createRepo.json");
        response = BaseClass.postRequest(endPoint, requestBody, token);
        String responseAsString = response.getBody().asString();

        String actualRepoName = CommonUtilityFunctions.getResponseKeyValue(responseAsString, "name");
        String expectedRepoName = CommonUtilityFunctions.getResponseKeyValue(requestBody, "name");
        String actualRepoDescription = CommonUtilityFunctions.getResponseKeyValue(responseAsString, "description");
        String expectedRepoDescription = CommonUtilityFunctions.getResponseKeyValue(requestBody, "description");

        Assert.assertEquals(actualRepoName, expectedRepoName, "The name of the repository in not right");
        Assert.assertEquals(actualRepoDescription, expectedRepoDescription, "The description of the repository in not right");

        //Delete the created repository to clean data
        String deleteEndPoint = Url.getBaseUrI("/repos/" + USER_NAME + "/") + CommonUtilityFunctions.getResponseKeyValue(requestBody, "name");
        response = BaseClass.deleteRequest(deleteEndPoint, token);
    }

    @Test
    public void createRepoWithBodyAsObject() {
        CreateRepoPojo requestBody = new CreateRepoPojo();
        requestBody.setName("API-repository-test-2");
        requestBody.setDescription("This repository was created by API-2");

        response = BaseClass.postRequest(endPoint, requestBody, token);
        String responseAsString = response.getBody().asString();
        Assert.assertEquals(CommonUtilityFunctions.getResponseKeyValue(responseAsString, "name"), requestBody.getName(), "The name of the repository in not right");
        Assert.assertEquals(CommonUtilityFunctions.getResponseKeyValue(responseAsString, "description"), requestBody.getDescription(), "The description of the repository in not right");

        String deleteEndPoint = Url.getBaseUrI("/repos/" + USER_NAME + "/") + requestBody.getName();
        response = BaseClass.deleteRequest(deleteEndPoint, token);
    }
}
