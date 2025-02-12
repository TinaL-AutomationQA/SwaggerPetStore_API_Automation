package api.endpoints;
//userEndPoints.java
//Created for perform create  read update delete request
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import com.google.gson.Gson;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints2_UsePropertiesFile {
	
	//Method created for getting URL's from properties file
	static ResourceBundle getURL()
   {
	   ResourceBundle routes=ResourceBundle.getBundle("routes");
       return routes;
   
   }
	
	public static Response createUser(User payload) {//return type is Response
		String post_url=getURL().getString("post_url");
		
	    Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		 .when()
		    .post(post_url);
		
		return response;
	}
	
	public static Response ReadUser(String userName) {//return type is Response
		String get_url=getURL().getString("get_url");
		Response response=given()
		  .pathParam("username",userName)
		 
		 .when()
		    .get(get_url);
		
		return response;
	}
	
	public static Response UpdateUser(String userName,User payload) {//return type is Response
		String update_url=getURL().getString("update_url");
		Response response=given()
		  .pathParam("username",userName)
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		 .when()
		    .put(update_url);
		
		return response;
	}
	
	public static Response DeleteUser(String userName) {//return type is Response
		String delete_url=getURL().getString("delete_url");
		Response response=given()
		  .pathParam("username",userName)
		 
		 .when()
		    .delete(delete_url);
		
		return response;
	}
}
