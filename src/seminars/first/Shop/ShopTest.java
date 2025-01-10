package seminars.first.Shop;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
public class ShopTest {
    static int numOfProducts;

    static Shop shop = new Shop();
    public static void main(String[] args) {
        shop.setProducts(generateProducts());
        System.out.println(shop.getProducts().size());
        testingShop();
        printList(shop.sortProductsByPrice());

    }

    private static void printList(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static List generateProducts() {
        Random random = new Random();
        List<Product> products = new ArrayList<>();

        numOfProducts = random.nextInt(100);
        for (int i = 0; i < numOfProducts; i++) {
            Product product = new Product();
            int cost = random.nextInt(100);
            product.setTitle("Product" + String.valueOf(i));
            product.setCost(cost);
            products.add(product);
        }
        return products;
    }
    private static void testingShop() {
//        1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов:
//        (правильное количество продуктов, верное содержимое корзины).
        assertThat(shop.getProducts()).isNotEmpty();
        assertThat(shop.getProducts().size()).isEqualTo(numOfProducts);
        assertThat(shop.getProducts().getFirst().getTitle()).isEqualTo("Product0");
        assertThat(shop.getProducts().getLast().getTitle()).isEqualTo("Product" + String.valueOf(numOfProducts - 1));
//        3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
        for (int i = 0; i < shop.sortProductsByPrice().size() - 1; i++) {
            assertThat(shop.sortProductsByPrice().get(i).getCost()).isLessThanOrEqualTo(shop.sortProductsByPrice().get( i + 1).getCost());
        }
//        2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(shop.sortProductsByPrice().getLast().getCost());
    }

}