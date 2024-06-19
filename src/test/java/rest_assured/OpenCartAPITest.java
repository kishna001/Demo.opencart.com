package rest_assured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class OpenCartAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://demo.opencart.com";
    }

    @Test
    public void testGetProductById() {
        Response response = RestAssured.given()
                .when()
                .get("/index.php?route=product/product&language=en-gb&product_id=40");
        		assertEquals(response.getStatusCode(), 200);
        		
        String htmlContent = response.getBody().asString();

        Document doc = Jsoup.parse(htmlContent);

        String productName = doc.select("h1").text(); 
        assertNotNull(productName);
        assertTrue(productName.contains("iPhone")); 
        System.out.println(productName);
    }
}