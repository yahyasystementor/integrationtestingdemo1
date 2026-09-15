package systementor.integrationtestingdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductApiTest {



    @Autowired
    MockMvc mvc;


    @Test
    void getProductsWithoutInternet() {
        RestTemplate restTemplate = new RestTemplate();


        MockRestServiceServer server =
                MockRestServiceServer.createServer(restTemplate);

        server.expect(requestTo("https://fakestoreapi.com/products/1"))
                .andRespond(
                        withSuccess()
                                .body("{\"id\": 1, \"title\": \"testprodukt\", \"price\": 100.0}")
                                .contentType(MediaType.APPLICATION_JSON)
                );



        Product p = restTemplate.getForObject("https://fakestoreapi.com/products/1", Product.class);

        assertEquals("testprodukt", p.title());
        assertEquals(100.0, p.price());

    }










/*




    @Test
    void ApiResponsesWithProducts() throws Exception {
        mvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").exists());

    }

 */


}
