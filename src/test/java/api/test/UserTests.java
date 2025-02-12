package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserTests {
   Faker faker;
   User userPayload;
   public Logger logger;
   @BeforeClass
   public void setupData()
   {
	   faker=new Faker();
	   userPayload=new User();
	   userPayload.setId(faker.idNumber().hashCode());
	   userPayload.setUsername(faker.name().username());
	   userPayload.setFirstName(faker.name().firstName());
	   userPayload.setLastName(faker.name().lastName());
	   userPayload.setEmail(faker.internet().emailAddress());
	   userPayload.setPassword(faker.internet().password(5,10));
	   userPayload.setPhone(faker.phoneNumber().cellPhone());
	  
	   //logs
	   logger=(Logger) LogManager.getLogger(this.getClass());
   }
  @Test(priority=1)
   public void testPostUser() {
   
	   logger.info("******Creating user******");
	   Response response= UserEndPoints.createUser(userPayload);
       response.then().assertThat()
       .log().all() 
       .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/User_PostJsonSchema.json"));
       Assert.assertEquals(response.getStatusCode(),200 );
       logger.info("******User is created******");
}
  @Test(priority=2)
   public void testGetUser() throws InterruptedException {
	   logger.info("******Reading user Info******");
	   Response response= UserEndPoints.ReadUser(this.userPayload.getUsername());
       Assert.assertEquals(response.getStatusCode(),200 );
       Assert.assertEquals(response.jsonPath().get("username".toString()),this.userPayload.getUsername());
       Assert.assertEquals(response.jsonPath().getInt("id"), this.userPayload.getId());  
       response.then().assertThat()
       .log().all()
       .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/User_GetJsonSchema.json"));
        logger.info("******User Info is displayed******");
  }
  

  @Test(priority=3)
   public void testUpdateUser() {
	   logger.info("******Updating user Info******");
	   userPayload.setEmail(faker.internet().emailAddress());
	   userPayload.setPhone(faker.phoneNumber().cellPhone());
	   
	   Response response= UserEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(),200 );
       
       //check the data after update
       Response responseAfterupdate= UserEndPoints.ReadUser(this.userPayload.getUsername());
       Assert.assertEquals(responseAfterupdate.getStatusCode(),200 );
       logger.info("******User Info updated******");
}
  @Test(priority=4)
  public void testDeleteUser() {
	  logger.info("******Deleting user Info******");
	  Response response= UserEndPoints.DeleteUser(this.userPayload.getUsername());
      response.then().log().all();
      Assert.assertEquals(response.getStatusCode(),200 );
      logger.info("******User Info deleted******");
}
   
   
   
   
   
   
   
}

       
