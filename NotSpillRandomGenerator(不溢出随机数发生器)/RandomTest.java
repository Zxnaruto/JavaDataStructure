package test;

public class RandomTest {
 public static void main(String[] args) {
	 NotSpillRandomGenerator test=new  NotSpillRandomGenerator();
	 for(int i=0;i<10;i++) {
	 System.out.println(test.random0_1());//����ͨ��%10,%100����ȡ��Ҫ������λ����%10��һλ��%100����λ���Դ����ơ�
      }
 }
}
