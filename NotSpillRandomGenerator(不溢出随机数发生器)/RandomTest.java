package test;

public class RandomTest {
 public static void main(String[] args) {
	 NotSpillRandomGenerator test=new  NotSpillRandomGenerator();
	 for(int i=0;i<10;i++) {
	 System.out.println(test.random0_1());//可以通过%10,%100等来取想要的数的位数，%10是一位，%100是两位，以此类推。
      }
 }
}
