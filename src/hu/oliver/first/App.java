package hu.oliver.first;

import java.util.Random;

public class App {

    public static final int SIZE = 100;
    public static final int BOUND = 300;
    private final int[] numbers;

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
        print("A rendezetlen tömb elemei:", numbers);
        print("A rendezett tömb elemei:", simpleSort());
        print("A rendezetlen tömb elemei:", numbers);
        print("A rendezett tömb elemei:", bubbleSort());
    }

    private int[] initNumbers() {
        Random random = new Random();
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = random.nextInt(BOUND) + 1;
        }
        return numbers;
    }

    private void print(String text, int[] numbers) {
        System.out.println(text);
        for (int i = 0; i < SIZE; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    private int summarize() {
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }

    private boolean condition(int divisor) {
        int i = 0;
        while (i < SIZE && numbers[i] % divisor > 0) {
            i = i + 1;
        }
        return i < SIZE;
    }

    private int select(int divisor) {
        int i = 0;
        while (numbers[i] % divisor > 0) {
            i = i + 1;
        }
        return i + 1;
    }

    private int find(int divisor) {
        int i = 0;
        while (i < SIZE && numbers[i] % divisor > 0) {
            i = i + 1;
        }
        return i < SIZE ? i + 1 : -1;
    }

    private int count(int divisor) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (numbers[i] % divisor == 0) {
                count = count + 1;
            }
        }
        return count;
    }

    private int max() {
        int max = 0;
        for (int i = 1; i < SIZE; i++) {
            if (numbers[i] > numbers[max]) {
                max = i;
            }
        }
        return max + 1;
    }

    private int[] simpleSort() {
        int[] sortedNumbers = numbers.clone();
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                if (sortedNumbers[i] > sortedNumbers[j]) {
                    int puffer = sortedNumbers[i];
                    sortedNumbers[i] = sortedNumbers[j];
                    sortedNumbers[j] = puffer;
                }
            }
        }
        return sortedNumbers;
    }

    private int[] bubbleSort() {
        int[] sortedNumbers = numbers.clone();
        for (int i = SIZE; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (sortedNumbers[j] > sortedNumbers[j + 1]) {
                    int puffer = sortedNumbers[j];
                    sortedNumbers[j] = sortedNumbers[j + 1];
                    sortedNumbers[j + 1] = puffer;
                }
            }
        }
        return sortedNumbers;
    }
}
