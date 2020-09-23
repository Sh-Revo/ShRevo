import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

public class DatabaseInitialazer {
    @Getter
    private final List<Product> products = List.of(
            new Product("A", BigDecimal.valueOf(1.25), 3, BigDecimal.valueOf(3)),
            new Product("B",BigDecimal.valueOf(4.25), null, null),
            new Product("C",BigDecimal.valueOf(1.00), 6, BigDecimal.valueOf(5)),
            new Product("D",BigDecimal.valueOf(0.75), null, null)
    );
}
