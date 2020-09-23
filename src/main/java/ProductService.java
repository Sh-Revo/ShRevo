import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class ProductService {


    private final DatabaseInitialazer initialazer;




    public BigDecimal calculateTotalCost(String message){

        Map<String, Long> goodsCount = message.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.groupingBy(Object::toString,Collectors.counting()));

        System.out.println("Calculated amount of each products in details: " + goodsCount);
        List<Product> products = initialazer.getProducts();
        return products.stream()
                .filter(product -> goodsCount.keySet().contains(product.getName()))
                .map(product -> calculateCostForGoods(product, goodsCount.get(product.getName())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private BigDecimal calculateCostForGoods(Product product, Long count){

        System.out.println("Starting calculate = {} " +  product.getName());
        BigDecimal totalCost;
        if (Objects.isNull(product.getPromoCost())){
            System.out.println("Product has not promo " + product.getName());
            totalCost= product.getSingleCost().multiply(BigDecimal.valueOf(count));

        } else
        {
            long promoBlocks = count/product.getPromoCount();
            long notPromo = count % product.getPromoCount();
            totalCost = product.getPromoCost().multiply(BigDecimal.valueOf(promoBlocks))
                    .add(product.getSingleCost().multiply(BigDecimal.valueOf(notPromo)));

        }
        System.out.println("Calculated total cost for good {}  "+ product.getName() + " = " + totalCost);
        return totalCost;
    }
}
