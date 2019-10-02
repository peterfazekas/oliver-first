package hu.oliver.first;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    private static final int SIZE = 100;
    private static final int BOUND = 300;

    private final List<Integer> numbers;

    private App() {
        this.numbers = initNumbers();
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        print("A tömb elemei:", numbers);
        System.out.println("A számok összege: " + summarize());
        int divisor = 3;
        System.out.println("A sorozatban van-e " + divisor + "-val osztható szám?");
        boolean result = condition(divisor);
        System.out.println(result);
        if (result) {
            System.out.println("A sorozat " + indexOf(divisor) + ". eleme osztható " + divisor + "-val");
        }
        divisor = 12;
        System.out.println("A sorozat " + find(divisor) + ". eleme osztható " + divisor + "-val");
        divisor = 3;
        System.out.println("A sorozatban " + count(divisor) + " db " + divisor + "-al osztahtó szám van!");
        System.out.println("A sorozatban a " + max() + ". elem a legnagyobb értékű!");
//        print("A rendezetlen tömb elemei:", numbers);
//        print("A rendezett tömb elemei:", simpleSort());
//        print("A rendezetlen tömb elemei:", numbers);
//        print("A rendezett tömb elemei:", bubbleSort());
    }

    private List<Integer> initNumbers() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(random.nextInt(BOUND) + 1);
        }
        return numbers;
    }

    private void print(String text, List<Integer> numbers) {
        System.out.println(text);
        System.out.println(getNumbers(numbers));
    }

    private String getNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    private int summarize() {
        return numbers.stream()
                .mapToInt(i -> i)
                .sum();
    }

    private boolean condition(int divisor) {
        return numbers.stream()
                .anyMatch(i -> i % divisor == 0);
    }

    private int indexOf(int divisor) {
        return numbers.indexOf(select(divisor)) + 1;
    }

    private int select(int divisor) {
        return selectOptional(divisor).get();
    }

    private Optional<Integer> selectOptional(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .findFirst();
    }

    private int find(int divisor) {
        return selectOptional(divisor).isPresent() ? indexOf(divisor) : -1;
    }

    private long count(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .count();
    }

    private int max() {
//        return numbers.stream()
//                .mapToInt(i -> i)
//                .max()
//                .getAsInt();
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
    }
}
