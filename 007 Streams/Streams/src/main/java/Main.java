import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Consumer<String> consumerPrintLambda = System.out::println;

        //TIP to create a stream using Stream.of() method
        Stream<String> cities = Stream.of("Cairo", "Dahab", "Sharm");
        cities.forEach(consumerPrintLambda);

        //TIP to create a stream using Arrays.stream(arr) method
        String[] stringArr = new String[]{"String 1", "String 2", "String 3"};
        Stream<String> arrStream = Arrays.stream(stringArr);
        arrStream.forEach(consumerPrintLambda);

        //TIP to create a stream from a list.
        List<String> stringList = new ArrayList<>();
        stringList.add("String_1");
        stringList.add("String_2");
        stringList.add("String_3");
        Stream<String> listStream = stringList.stream();
        listStream.forEach(consumerPrintLambda);

        //TIP to find a match within the stream using .anyMatch() method
        boolean isOnList = stringList.stream().anyMatch(item->item.contains("_3"));
        System.out.println("isOnList = " + isOnList);

        //TIP using streams to get a new filtered stream.
        Stream<String> filteredStream = stringList.stream().filter(s->s.contains("_2"));
        filteredStream.forEach(consumerPrintLambda);

        //TIP using streams to map current values to new values.
        List<Integer> integersList = new ArrayList<>();
        integersList.add(1);
        integersList.add(2);
        integersList.add(3);
        integersList.add(4);
        Stream<Integer> doubleStream = integersList.stream().map(integer -> integer*integer);
        doubleStream.forEach(System.out::println);

        //TIP using streams to return a list.
        List<String> stringListWithout3 = stringList.stream().map(string->string.replace("_","-")).collect(Collectors.toList());
        stringListWithout3.forEach(System.out::println);

    }
}
