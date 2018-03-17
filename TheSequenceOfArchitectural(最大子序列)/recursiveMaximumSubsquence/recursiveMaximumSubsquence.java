import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * �����÷���˼��ĵݹ鷽��������������еĺ�
 * 
 * ��ʱ�临�Ӷ�Ϊ��(����for��O(N),�����ݹ���2T(N/2))
 *   T(1)=1,T(N)=N+2T(N/2)
 * �Ƶ���
 *      T(2)=2+2T(1)=2*2=4        2^1=2, 2*(1+1)
 *      T(4)=4+2T(2)=4*3=12       2^2=4, 4*(2+1)
 *      T(8)=8+2T(4)==8*4=32      2^3=8, 8*(3+1)
 *      .......
 *      N=2^k,k=logN
 *      T(2^k)=2^k+2T(2^(k-1))=N*(k+1)=N+NlogN
 *      ����T(N)=NlogN
 * 
 * 
 * ͨ���������Ϊ�������֣��ֱ���������ֽ��еݹ飬�������ߵ����ֵ���ұߵ����ֵ���Լ�
 * �������ұ߽�����ֵ�ĺͣ�����ߵݹ�Ĳ��ּ����ұߵݹ�Ĳ��֣��õݹ��Ǵ��м�������������͵ģ�
 * Ȼ���ٿ�������ֵ�Ǹ��������ֵ��Ϊ��������еĺ͵�ֵ
 * 
 * ȱ�㣺Ŀǰ����㷨ֻ���NΪż����Ҫ��Ҳ���������Ļ�������Ľ���
 *
 */
public class recursiveMaximumSubsquence {

	//��������������еĺͺ�����߽���к�
	private static int maxSumRec(int[] Array,int left,int right) {
		if(left==right) 
		if(left>0){//base case
			return Array[left];	
		}else {
			return 0;
		}
		
		int center= (left+right)/2;//����㣨�����������ݹ�����ֵ�����������ߵĺ͵����ֵ��
		int maxLeftSum=maxSumRec(Array,left,center);//������������ֵ�ĺͣ���ߵĺͣ�
		int maxRightSum=maxSumRec(Array,center+1,right);//�ұߵĺͣ�ѭ���Ĵ�����һ��ļ���ѭ����ֵ��
		int maxLeftBorderSum=0,leftBorderSum=0;
		for(int i=center;i>=left;i--) {//������һ������ֵ
			leftBorderSum+=Array[i];
			if(leftBorderSum>maxLeftBorderSum) {
				maxLeftBorderSum=leftBorderSum;
			}
		}
		
		int maxRightBorderSum=0,rightBorderSum=0;
		for(int i=center+1;i<=right;i++) {//����ұ�һ������ֵ
			rightBorderSum+=Array[i];
			if(rightBorderSum>maxRightBorderSum) {
				maxRightBorderSum=rightBorderSum;
			}
		}
		return compare(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);//maxLeftBorderSum+maxRightBorderSum��ÿ��ѭ�������������ĺͣ������ϱ߽�ֵ�ĺ�
	}
	//����������еĺ�
	public static int maxSubSum(int[] Array) {
		return maxSumRec(Array,0,Array.length-1);
	}
	//�ȽϺ���
	public static int compare(int a,int b,int c) {
		int max=0;
		if(a>=b&&a>=c) {
			max=a;
		}
		if(b>=a&&b>=c) {
			max=b;
		}
		if(c>=a&&c>=b) {
			max=c;
		}
		
		return max;
	}
	
	//��ں���
	public static void main(String[] args) throws IOException{
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		int array[];
		int length;//���鳤��
		System.out.println("����������ĳ��ȣ�");
		str=buf.readLine();
		length=Integer.parseInt(str);
		array=new int[length];
		System.out.println("����������Ԫ�أ�");
		for(int i=0;i<length;i++) {
			str1=buf.readLine();
			array[i]=Integer.parseInt(str1);
		}
		System.out.println("���������Ϊ��");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("\n"+"��������е�ֵΪ��"+ maxSubSum(array));
		
	}

	
}
