import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetResponseValidator {
    @Test
    public static void validateGetResponse(){
        User user1 = new UserBuilder().setId(1).setFirstname("Kosta").setLastname("Aouzine").createUser();
        User user2 = new UserBuilder().setId(2).setFirstname("Alex").setLastname("Rogov").createUser();
        User[] entitiesTestArray = {user1, user2};

        RestAssured.baseURI = "http://localhost:4567";

        given()
                .body(new Gson().toJson(user1))
                .post("/users")
                .then().statusCode(200);

        given()
                .body(new Gson().toJson(user2))
                .post("/users")
                .then().statusCode(200);

        User[] entitiesResponseArray =
                get("http://localhost:4567/getList").
                then().
                statusCode(200).
                extract().as(User[].class);

        Assert.assertEquals(entitiesResponseArray, entitiesTestArray);
    }
}
