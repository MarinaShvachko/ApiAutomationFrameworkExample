Different information and examples of code. Everything refers to atomization of software. 
There is NO purpose to show good architecture or code writing. The only aim to show the simplest 
examples how to set up software and understand logic of approaches, so based on it start learning it.

**Package "Example of API framework GitHub**

To run the tests you need to have a GitHub repository, generate an access token and change username:
- Log in to GitHub
- Open the account settings
- Open "<> Developer settings"
- Open "Personal access tokens"
- Generate new token
- Copy the token that is shown, as later only the name of token will be shown on UI
- Insert this token in the class Authentication*


- In classes CreateRepositoryTests and DeleteRepositoryTests change value of the variable USER_NAME, insert there the name of your GitHub account.

**About classes**

Url: has 2 overloaded methods, so you can put in parameters only base URI or URI with resources

BodyGenerator: creates bodies for sending in put, post, delete requests. Can take Json from a file and convert to a String, or create an object.

Authentication: has a token for logging in to GitHub

CommonUtilityFunctions: different methods that can be used for all tests

BaseClass: contains basic methods for sending put, post, get, delete requests

**About packages**

resources: contains json files for creating requests and the package "pojoClasses" that contains objects for creating requests

tests: contains classes to run tests

utility: contains classes with basic methods and data that is needed for creating tests





