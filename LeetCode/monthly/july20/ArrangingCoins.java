package LeetCode.monthly.july20;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int k = 1, count = 0;

        while (n - k >= 0) {
            n -= k;
            k++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int coins = 8;

        System.out.println(new ArrangingCoins().arrangeCoins(coins));
    }

}