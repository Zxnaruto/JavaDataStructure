package test1;



public class Random48bitTest {
	 public static void main(String[] args) {
		Random48bit test=new  Random48bit();
		 for(int i=0;i<10;i++) {
		 System.out.println(test.random0_1());//可以通过%10,%100等来取想要的数的位数，%10是一位，%100是两位，以此类推。
	      }
	 }
}
