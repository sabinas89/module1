import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class streamMinMax {

    public static void main(String[] args) {
        List<Product> searchResults = new ArrayList<>();
        searchResults.add(new Product("MADISON OVEREAR HEADPHONES",125.00));
        searchResults.add(new Product("MADISON EARBUDS",35.00));
        searchResults.add(new Product("MP3 PLAYER WITH AUDIO",185.00));

        Product product = searchResults.stream()
                .min(Comparator.comparing(item->item.getPrice()))
                .get();

        System.out.println("Product with lowest price is "+product.getName());

        product = searchResults.stream()
                .max(Comparator.comparing(item->item.getPrice()))
                .get();

        System.out.println("Product with highest price is "+product.getName());

        long count = searchResults.stream()
                .filter(item-> item.getName().startsWith("MADISON"))
                .count();
        System.out.println("Products with name Madison are "+count);
    }
}
