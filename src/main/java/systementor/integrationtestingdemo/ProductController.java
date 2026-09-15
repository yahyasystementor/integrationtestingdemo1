package systementor.integrationtestingdemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {



    private final ProductClient client;

    public ProductController(ProductClient client) {
        this.client = client;
    }



    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return client.getProduct(id);
    }
}
