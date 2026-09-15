package systementor.integrationtestingdemo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductClient {



    private final RestTemplate restTemplate = new RestTemplate();
    private static final String baseUrl = "https://fakestoreapi.com";

    public Product getProduct(Long productId) {
        return restTemplate.getForObject(baseUrl + "/products/" + productId, Product.class);
    }


    public double reducedPrice(Long id, double reducedPrice) {
        Product p = getProduct(id);
        return p.price() * (1 - reducedPrice);
    }

}
