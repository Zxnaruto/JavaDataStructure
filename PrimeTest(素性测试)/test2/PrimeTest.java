package test2;



public class PrimeTest {

	
	@SuppressWarnings("unused")
	private static long witness(long a,long i,long n) {
		if(i==0) {
			return 1;
		}
		long x=witness(a,i/2,n);
		
		if(x==0) {
			return 0;
		}
		
		long y=(x*x)%n;
		if(y==1&&x!=1&&x!=n-1) {
			return 0;
		}
		
		if(i%2!=0) {
			y=(a*y)%n;
		}
		
		return y;
		
	}
	
	public static boolean isPrime(long n) {
		temp r=new temp();
		
		
			if(witness(r.temp(2,n-2,n),n-1,n)!=1) 
				{return false;}else {
			
				return true;}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(317));
	}
	
}
