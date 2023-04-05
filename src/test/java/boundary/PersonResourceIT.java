package boundary;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(PersonResource.class)
public class PersonResourceIT {

    @Test
    public void get_returns_200_with_json_payload() {
        given().when().get().then().statusCode(is(200))
                .body("size()", is(2));
    }
    
}
