import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
public class Main {

    private final ProductService productService;

    public static void main(String[] args) {
        Main main = new Main(new ProductService());
        main.productService.calculateTotalCost("ABCDABA");


    }


}
