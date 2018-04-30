package test2;

public class temp {
	
	public long temp(long a,long b,long n) {
		Random r=new Random();
		boolean flag=true;
		long temp = 0;
		while(flag) {
			temp=r.random()%n;
		if(temp>=a&&temp<=b) 
			
			flag=false; 
		}
	
		return temp; 
		
		
		
	}

	
}
