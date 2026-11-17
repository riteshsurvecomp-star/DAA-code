import java.util.*;

class Knapsack {
    public static void main(String[] args) {

        int[] weight = {10, 20, 30};
        int[] profit = {60, 100, 120};

        int capacity = 50;
        double totalProfit = 0;

        double[] ratio = new double[weight.length];

        // Calculate profit/weight ratio
        for (int i = 0; i < weight.length; i++) {
            ratio[i] = (double) profit[i] / weight[i];
        }

        // Sort items in descending order of ratio
        for (int i = 0; i < ratio.length; i++) {
            for (int j = i + 1; j < ratio.length; j++) {

                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    int t = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t;

                    t = profit[i];
                    profit[i] = profit[j];
                    profit[j] = t;
                }
            }
        }

        // Greedy approach
        for (int i = 0; i < weight.length; i++) {

            if (capacity >= weight[i]) {

                totalProfit += profit[i];
                capacity -= weight[i];

            } else {

                totalProfit += ratio[i] * capacity;
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }
}