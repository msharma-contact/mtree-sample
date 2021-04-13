import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/***
 * When i tried to access following URL
 * "http://dummy.restapiexample.com/"
 * The SERRVICE WAS DOWN
 * Therefore i used following URL
 * "https://reqres.in/"
 * ***/
public class ApiDummy {
	@BeforeMethod()
	public void setUp() {
		//RestAssured.baseURI="http://dummy.restapiexample.com/";
		RestAssured.baseURI="https://reqres.in/";
	}
	@Test()
	public void getData() {
		//http://dummy.restapiexample.com/api/v1/employee/3
    RequestSpecification httpRequest =RestAssured.given();
    httpRequest.header("Content-Type","application/json");
    //Response response = httpRequest.request(Method.GET,"/api/v1/employee/12");
    Response response = httpRequest.request(Method.GET,"/api/users/2");
    int code =response.getStatusCode();
    System.out.println("The status code is "+code);
    Assert.assertEquals(code, 200);
    String responseValue = response.body().asPrettyString();
    System.out.println("The response body is ::: "+responseValue);
	}
	
	
@Test
	public void deleteData() {
		//http://dummy.restapiexample.com/api/v1/employee/3
    RequestSpecification httpRequest =RestAssured.given();
    httpRequest.header("Content-Type","application/json");
   // Response response = httpRequest.request(Method.DELETE,"/api/v1/delete/7");
    Response response = httpRequest.request(Method.DELETE,"/api/users/2");
    int code =response.getStatusCode();
    System.out.println("The status code is "+code);
    Assert.assertEquals(code, 204);
   
    String jsonString =response.asString();
    System.out.println("The response body is ::: "+jsonString);
   // Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	 }
	@AfterMethod()
	public void tearDown() {

	}
}

