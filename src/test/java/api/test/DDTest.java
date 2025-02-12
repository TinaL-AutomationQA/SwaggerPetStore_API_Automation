package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class DDTest {
	  
    
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	   public void testPostUser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph) {
	   
		 
		   User userPayload=new User();
		   userPayload.setId(Integer.parseInt(userID));
		   userPayload.setUsername(userName);
		   userPayload.setFirstName(fname);
		   userPayload.setLastName(lname);
		   userPayload.setEmail(useremail);
		   userPayload.setPassword(pwd);
		   userPayload.setPhone(ph);
		   Response response= UserEndPoints.createUser(userPayload);
	       Assert.assertEquals(response.getStatusCode(),200 );
	       System.out.println("Created user: " + userName);


	}
	
	 @Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	  public void testDeleteUser(String userName) throws InterruptedException {
	      Thread.sleep(2000);
		  Response response= UserEndPoints.DeleteUser(userName);
	      Assert.assertEquals(response.getStatusCode(),200 );
	      
	}
}
