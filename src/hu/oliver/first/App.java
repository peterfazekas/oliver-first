package hu.oliver.first;

import java.util.Random;

public class App {

    private final int[] numbers;

    public App() {
        this.numbers = initNumbers();
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        print("A tömb elemei:");
        System.out.println("A számok összege: " + summarize());
        int divisor = 104;
        System.out.println("A sorozatban van-e " + divisor + "-val osztható szám?");
        boolean result = condition(divisor);
        System.out.println(result);
        if (result) {
            System.out.println("A sorozat " + select(divisor) + ". eleme osztható " + divisor + "-val");
        }
    }

    private int[] initNumbers() {
        Random random = new Random();
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }
        return numbers;
    }

    private void print(String text) {
        System.out.println(text);
        for (int i = 0; i < 100; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    private int summarize() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }

    private boolean condition(int divisor) {
        int i = 0;
        while (i < 100 && numbers[i] % divisor > 0) {
            i = i + 1;
        }
        return i < 100;
    }

    private int select(int divisor) {
        int i = 0;
        while (numbers[i] % divisor > 0) {
            i = i + 1;
        }
        return i + 1;
    }

}
