package test1;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     48bit�����������������ʽ�ӣ� x(i+1)=(Axi+C)mod2^B 
 *     A=25214930917,B=48,C=11
 *     
 *     ����Ϊ�˱����ڵͽױ���λ�ϵ�ѭ�����⣬ʹ��48bit����ͬ�෢����ֻ���ظ�32bit
 */
public class Random48bit {

	private static final long A=25_214_903_917L;
	private static final long B=48;
	private static final long C=11;
	private static final long M=(1L<<B);
	private static final long MASK=M-1;
	private long state;
	public Random48bit() {
		state=System.nanoTime()&MASK;//��λ��
	}
	//����һ��int�������
	public int randomInt() {
		return next(31);//���int
	}
	//����һ��(0,1)֮�����
	public double random0_1() {
		return ((long)(next(26))<<27)+next(27)/(double)(1L<<53);//53��ʾβ����ʣ��11��ʾָ��
	}
	//����һ�����λ��
	public int next(int bits) {
		if(bits<=0||bits>32) {//���bits����32λ��С�ڵ���0�׳��쳣
			throw new IllegalArgumentException();
		}
		state=(A*state+C)&MASK;
		return (int)(state>>>(B-bits));//��λλ�Ʊ��⸺��
	}
}
