package LeetCode.monthly.july20;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        // We can use sum of n natural numbers method n(n+1)/2
        // and use Quadratic equation a*n^2 + b*n + c
        long a = 1, b = 1, c = -2L * n;

        double x = Math.sqrt(b * b - 4 * a * c);
        double val = (-1 * b + x) / 2 * a;

        return (int) val;
    }

    public static void main(String[] args) {
        int coins = 1804289383;

        System.out.println(new ArrangingCoins().arrangeCoins(coins));
    }

}