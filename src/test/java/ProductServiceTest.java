import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ProductServiceTest {

    private  DatabaseInitialazer initialazer;
    private  ProductService productService;

    @Before
    public void setUp(){
        initialazer = Mockito.mock(DatabaseInitialazer.class);
        productService = new ProductService(initialazer);
        Mockito.when(initialazer.getProducts()).thenReturn(products);
    }

    @Test
    public void calculateTotalCost_validInput(){
        String message = "ABCDABA";
        BigDecimal result = productService.calculateTotalCost(message);
        assertEquals(BigDecimal.valueOf(13.25),result);
    }

    @Test
    public void calculateTotalCost_invalidInput(){
        String message = "EFGH";
        BigDecimal result = productService.calculateTotalCost(message);
        assertEquals(BigDecimal.ZERO,result);
    }

    @Test
    public void calculateTotalCost_emptyInput(){
        String message = "";
        BigDecimal result = productService.calculateTotalCost(message);
        assertEquals(BigDecimal.ZERO,result);
    }

    private final List<Product> products = List.of(
            new Product("A", BigDecimal.valueOf(1.25), 3, BigDecimal.valueOf(3)),
            new Product("B",BigDecimal.valueOf(4.25), null, null),
            new Product("C",BigDecimal.valueOf(1), 6, BigDecimal.valueOf(5)),
            new Product("D",BigDecimal.valueOf(0.75), null, null)
    );
}
