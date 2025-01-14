import seminars.first.Shop.Product;
import seminars.first.Shop.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {
	static int numOfProducts;

	static Shop shop = new Shop();

	public static void main(String[] args) {
		shop.setProducts(generateProducts(100, 100));
		System.out.println(shop.getProducts().size());
		testingShop();
//        printList(shop.sortProductsByPrice());

	}

	private static void printList(List<Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}
	}

	private static List generateProducts(int maxNumProduct, int maxCost) {
		Random random = new Random();
		List<Product> products = new ArrayList<>();
		if (maxNumProduct != 1) {
			numOfProducts = random.nextInt(maxNumProduct);
		} else {
			numOfProducts = 1;
		}
		for (int i = 0; i < numOfProducts; i++) {
			Product product = new Product();
			int cost = random.nextInt(maxCost);
			product.setTitle("Product" + String.valueOf(i));
			product.setCost(cost);
			products.add(product);
		}
		return products;
	}
	private static Shop shopWithOneElement(){
		Shop shopWithOneElement = new Shop();
		shopWithOneElement.setProducts(generateProducts(1, 100));
		return shopWithOneElement;
	}

	private static void testingShop() {

//        1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов:
//        (правильное количество продуктов, верное содержимое корзины).
		assertThat(shop.getProducts()).isNotEmpty();
		assertThat(shop.getProducts().size()).isEqualTo(numOfProducts);
		assertThat(shop.getProducts().getFirst().getTitle()).isEqualTo("Product0");
		assertThat(shop.getProducts().getLast().getTitle()).isEqualTo("Product" + String.valueOf(numOfProducts - 1));
//        2. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
//          2.1 Проверка основной функции, сортировки списка по возрастанию
		for (int i = 0; i < shop.sortProductsByPrice().size() - 1; i++) {
			assertThat(shop.sortProductsByPrice().get(i).getCost()).isLessThanOrEqualTo(shop.sortProductsByPrice().get(i + 1).getCost());
		}
//          2.2 Проверка сортировки пустого списка

//          2.3 Проверка сортироки списка с одним элементом

		Shop shopTestWithOneElement = new Shop();
		shopTestWithOneElement = shopWithOneElement();
		assertThat(shopTestWithOneElement.sortProductsByPrice()).isEqualTo(shopTestWithOneElement.getProducts());
//			2.3 Проверка сортировки списка с одинаковыми ценами
		Shop shopWithSameCost = new Shop();
		shopWithSameCost.setProducts(generateProducts(10, 1));
		assertThat(shopWithSameCost.sortProductsByPrice()).isEqualTo(shopWithSameCost.getProducts());
//        2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
		assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(shop.sortProductsByPrice().getLast().getCost());
		assertThat(shopTestWithOneElement.getMostExpensiveProduct()).isEqualTo(shopTestWithOneElement.getProducts().getFirst());
		assertThat(shopWithSameCost.getMostExpensiveProduct()).isEqualTo(shopWithSameCost.getProducts().getLast());

	}

}