import java.util.Scanner;

class Knapsack_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, capacity;

        System.out.print("Enter number of items: ");
        n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        System.out.print("Enter capacity of knapsack: ");
        capacity = sc.nextInt();

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter profits of items:");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {

                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Profit = " + dp[n][capacity]);

        sc.close();
    }
}