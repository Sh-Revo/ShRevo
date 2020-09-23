
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private BigDecimal singleCost;
    private Integer promoCount;
    private BigDecimal promoCost ;



}
