package Array;


//Time complexity: O(2^n)- since T(n) = T(n-1) + T(n-2)is an exponential time
//Space complexity: O(n) - space for recursive function call stack


class FibonacciNumber {

    public int fib1(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib1(N-1) + fib1(N-2);
    }


    
//Time complexity: O(n)
//Space complexity: O(n)
    //reduce the time complexity to avoid recompute
    public int fib2(int N){

        if(N <= 1) return N;

		int[] fib_cache = new int[N + 1];
		fib_cache[1] = 1;

		for(int i = 2; i <= N; i++)
		{
			fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
		}
		return fib_cache[N];
    }


    public int fib3(int N){

        
    }
}
