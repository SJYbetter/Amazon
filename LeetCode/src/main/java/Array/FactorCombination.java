package Array;

/*
Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
 */

import java.util.ArrayList;
import java.util.List;

public class FactorCombination {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] primes = primeNumbers(n);
        if (!primes[n]) return ans;
        dfs(ans, primes, n, new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans,
                     boolean[] primes,
                     int num,
                     List<Integer> cur){
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i != 0) continue;
            int factor1 = num / i;
            cur.add(i);
            cur.add(factor1);
            ans.add(cur);
            if (!primes[factor1]) return;
            cur.clear();
            dfs(ans, primes, factor1, cur);
        }

    }

    private boolean[] primeNumbers(int n){
        boolean[] primes = new boolean[n+1];
        if (n <= 2) return primes;
        for (int i = 2; i <= n; i++){
            int j = 1;
            while (i * j <= n){
                primes[i*j] = true;
                j++;
            }
        }
        return primes;
    }
}
