package systementor.integrationtestingdemo;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;




public class FakeStoreApiTest {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ProductClient client = new ProductClient();


    @Test
    void getProductViaClient(){
        Product p = client.getProduct(1L);
        assertNotNull(p);
        assertEquals(1L, p.id());


    }




















    /*
    @Test
    void getProductWithIdOne(){

        // AAA

        // ARRANGE
        String url = "https://fakestoreapi.com/products/1";

        // ACT
        Product p = restTemplate.getForObject(url, Product.class);

        // ASSERT
        assertNotNull(p);
        assertEquals(1, p.id());
        assertNotNull(p.title());
        assertTrue(p.price() > 0);

    }




    @Test
    void productThatDoesntExistReturnError(){

        // AAA

        // ARRANGE
        String url = "https://fakestoreapi.com/products/0983274923479823";

       assertThrows(HttpClientErrorException.class,
               () -> restTemplate.getForObject(url, Product.class));
    }




     */




}
