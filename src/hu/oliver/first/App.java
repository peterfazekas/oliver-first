package hu.oliver.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        int divisor = 103;
        System.out.println("A sorozatban van-e " + divisor + "-val osztható szám?");
        boolean result = condition(divisor);
        System.out.println(result);
        if (result) {
            System.out.println("A sorozat " + select(divisor) + ". eleme osztható " + divisor + "-val");
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
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }

    private int summarize() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + numbers.get(i);
        }
        return sum;
    }

    private boolean condition(int divisor) {
        int i = 0;
        while (i < numbers.size() && numbers.get(i) % divisor > 0) {
            i = i + 1;
        }
        return i < numbers.size();
    }

    private int select(int divisor) {
        int i = 0;
        while (numbers.get(i) % divisor > 0) {
            i = i + 1;
        }
        return i + 1;
    }

    private int find(int divisor) {
        int i = 0;
        while (i < numbers.size() && numbers.get(i) % divisor > 0) {
            i = i + 1;
        }
        return i < numbers.size() ? i + 1 : -1;
    }

    private int count(int divisor) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % divisor == 0) {
                count = count + 1;
            }
        }
        return count;
    }

    private int max() {
        int max = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(max)) {
                max = i;
            }
        }
        return max + 1;
    }
}
