public class PrimeCounter {

	boolean [] mixFound;
	int numPrime = 0;
	int newList = 0;

	public int countPrimes(int limit){

		mixFound = new boolean [limit/2];
		for (int x = 3; x < limit; x++){
			if (!(x %2 ==0)){
				mixFound[newList]=true;
				newList++;
			}
		}

		for (int x =0; 2*x+3 < Math.sqrt(limit);x++){
			if (mixFound[x]){
				for (int y = x+(2*x+3)*(x+1); y<limit/2; y+=2*x+3){
					//for (int y = x+(2*x+3); y<limit/2; y+=2*x+3){ 
					// without the last enhancement
					mixFound[y]=false;
				}
			}
		}

		for (int x =0; x < limit/2; x++){
			if (mixFound[x]){
				numPrime++;
			}
		}
		// Don't forget 2 is also a prime number
		return numPrime+1;
	}

	public static void main(String[] args) {
		for (int x = 10; x<=1000000000; x*=10){

			long startTime;
			long endTime;
			PrimeCounter test1 = new PrimeCounter();

			System.out.println("From 1 to " + x);
			startTime = System.currentTimeMillis();
			System.out.println("Result: " + test1.countPrimes(x));
			endTime = System.currentTimeMillis();
			System.out.println("Time spent: " 
					+ (endTime-startTime)+" milliseconds\n");
		}
	}

	/*
	 PrimeCounter Output

From 1 to 10
Result: 4
Time spent: 0 milliseconds

From 1 to 100
Result: 25
Time spent: 0 milliseconds

From 1 to 1000
Result: 168
Time spent: 1 milliseconds

From 1 to 10000
Result: 1229
Time spent: 1 milliseconds

From 1 to 100000
Result: 9592
Time spent: 19 milliseconds

From 1 to 1000000
Result: 78498
Time spent: 6 milliseconds

From 1 to 10000000
Result: 664579
Time spent: 122 milliseconds

From 1 to 100000000
Result: 5761455
Time spent: 1451 milliseconds

From 1 to 1000000000
Result: 50847534
Time spent: 17516 milliseconds

	 */

}
