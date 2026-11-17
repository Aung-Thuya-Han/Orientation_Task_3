import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[][] ageDistribution = {
            {16, 20}, {34, 21}, {52, 22}, {68, 23}, {82, 24},
            {89, 25}, {94, 26}, {96, 28}, {98, 30}, {100, 35}
        };
        int total = 1000;


        for (int seed = 1; seed <= 3; seed++) {
            Random random = new Random(seed);
            int[] counts = new int[36]; // Index = age, value = count.

            for (int i = 0; i < total; i++) {
                int draw = random.nextInt(100) + 1; // 1 to 100.
                int row = 0;
                while (draw > ageDistribution[row][0]) {
                    row++;
                }
                int age = ageDistribution[row][1];
                counts[age]++;
            }

            System.out.println("\nSeed: " + seed);
            System.out.println("Age   Expected count   Actual count   Actual %");
            int previousLimit = 0;
            int countTotal = 0;
            for (int row = 0; row < ageDistribution.length; row++) {
                int limit = ageDistribution[row][0];
                int age = ageDistribution[row][1];
                int percentage = limit - previousLimit;
                int expectedCount = total * percentage / 100;
                System.out.printf("%-5d %-16d %-14d %.1f%%%n",
                        age, expectedCount, counts[age], counts[age] * 100.0 / total);
                countTotal += counts[age];
                previousLimit = limit;
            }
            System.out.println("Total ages: " + countTotal);
        }
    }
}
