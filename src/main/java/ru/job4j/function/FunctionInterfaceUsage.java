package ru.job4j.function;

import java.util.function.Supplier;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "New String for interface";
        BiConsumer<String, String> biConsumer = (first, second) -> System.out.println(first + second);
        biConsumer.accept(supplier.get(), " and Second String");

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supplier1 = () -> new HashSet<>(list);
        BiConsumer<Integer, String> biConsumer1 = (first, second) ->
                System.out.println(first + second);
        Set<String> strings = supplier1.get();
        int i = 1;
        for (String string : strings) {
            biConsumer1.accept(i++, "is" + string);
        }
        Predicate<String> predicate = string -> string.isEmpty();
        System.out.println("Строка пуста: " + predicate.test(""));
        System.out.println("Строка пуста: " + predicate.test("test"));

        System.out.println("-------------------------------------------");

        BiFunction<String, Integer, String> biFunction = (string, number) ->
                string.concat(" ").concat(number.toString());
        System.out.println("Результат работы бифункции: " + biFunction.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunction.apply("String number", 12345));
        System.out.println("-------------------------------------------");
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));
        System.out.println("-------------------------------------------");
        BinaryOperator<StringBuilder> biBuilder = (first, second) -> first.append(" ").append(second);
        System.out.println("Строка после объединения " + biBuilder.apply(
                        new StringBuilder("First String"),
                        new StringBuilder("Second String")
                )
        );
    }
}