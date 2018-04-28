package test1;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     48bit随机数发生器，基于式子： x(i+1)=(Axi+C)mod2^B 
 *     A=25214930917,B=48,C=11
 *     
 *     并且为了避免在低阶比特位上的循环问题，使用48bit线性同余发生器只返回高32bit
 */
public class Random48bit {

	private static final long A=25_214_903_917L;
	private static final long B=48;
	private static final long C=11;
	private static final long M=(1L<<B);
	private static final long MASK=M-1;
	private long state;
	public Random48bit() {
		state=System.nanoTime()&MASK;//按位与
	}
	//产生一个int型随机数
	public int randomInt() {
		return next(31);//存放int
	}
	//产生一个(0,1)之间的数
	public double random0_1() {
		return ((long)(next(26))<<27)+next(27)/(double)(1L<<53);//53表示尾数，剩下11表示指数
	}
	//返回一个随机位数
	public int next(int bits) {
		if(bits<=0||bits>32) {//如果bits超过32位或小于等于0抛出异常
			throw new IllegalArgumentException();
		}
		state=(A*state+C)&MASK;
		return (int)(state>>>(B-bits));//高位位移避免负数
	}
}
