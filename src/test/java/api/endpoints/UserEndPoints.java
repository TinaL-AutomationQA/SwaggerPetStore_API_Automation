package api.endpoints;
//userEndPoints.java
//Created for perform create  read update delete request
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.google.gson.Gson;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints {
   
	public static Response createUser(User payload) {//return type is Response
		/*Gson gson = new Gson();
		String jsonPayload = gson.toJson(payload);  
	    System.out.println("Final POST Request JSON: " + jsonPayload);*/
		
	    Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		 .when()
		    .post(Routes.post_url);
		
		return response;
	}
	
	public static Response ReadUser(String userName) {//return type is Response
		Response response=given()
		  .pathParam("username",userName)
		 
		 .when()
		    .get(Routes.get_url);
		
		return response;
	}
	
	public static Response UpdateUser(String userName,User payload) {//return type is Response
		Response response=given()
		  .pathParam("username",userName)
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		 .when()
		    .put(Routes.Update_url);
		
		return response;
	}
	
	public static Response DeleteUser(String userName) {//return type is Response
		Response response=given()
		  .pathParam("username",userName)
		 
		 .when()
		    .delete(Routes.Delete_url);
		
		return response;
	}
}
