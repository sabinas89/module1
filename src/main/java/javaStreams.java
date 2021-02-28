import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class javaStreams {
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Hindi");
        languages.add("Polish");
        languages.add("German");

        // printing List objects without using Streams API
        for(String language: languages){
            System.out.println(language);
        }
        // printing items from List using Streams API
        languages.stream().forEach(System.out::println);

        // Filtering items in List based on starting character
        languages.stream()
                .filter(item->item.startsWith("E"));

        // Sorting the list and then printing the sorted list
        System.out.println("Sorted list");
        languages.stream()
                .sorted()
                .forEach(System.out::println);

        // Converting String items in the list to uppercase and printing the output
        /*languages.stream().map(item->item.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);*/

        // Collect method invokes filtering and mapping and resulting object will be collected
        List<String> upperCaseLanguages = languages.stream()
                .map(item->item.toUpperCase(Locale.ROOT))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(upperCaseLanguages);
    }
}
