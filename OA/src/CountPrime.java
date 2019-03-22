class Solution {
    //output the number of prime smaller than N
    public int countPrimes(int n) {
        if (n <= 1) return 0;

        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i=2; i<n; i++){
            if (notPrime[i] == false){
                count ++;
                for (int j=2; j*i<n; j++){
                    notPrime[j*i] = true;
                }
            }
        }
        return count;
    }


    private boolean isPrime(int n){
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= (int) Math.sqrt(n); i++){
            if (n % i == 0) return false;
        }
        return true;
    }
}
