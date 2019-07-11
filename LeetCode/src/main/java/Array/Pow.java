package Array;

class Pow {
    public double myPow(double x, int n) {
        long N = n;
        // if n is negative, the base use 1/x instead
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            // only happens when i == N and i is odd number
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
