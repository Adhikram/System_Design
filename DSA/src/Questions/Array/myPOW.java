package Questions.Array;

public class myPOW {
    public static double myPow(double x, int n) {
        // base case
        if (n == 0 || x == 1)
            return 1;
        if (n == 1)
            return x;

        if (x == -1) {
            if (n % 2 == 0)
                return 1;
            else
                return -1;
        }

        // x ^ (-n) = 1 / (x ^ n)
        if (n < 0)
            return 1 / (x * myPow(x, -(n + 1)));

        if (n % 2 == 0)
            return myPow(x * x, n / 2);

        return x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }
}
