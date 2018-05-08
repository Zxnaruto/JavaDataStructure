package test3;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     编写一个不溢出的随机数发生器，可以返回一个int型的伪随机数，也可以返回一个double型的范围在(0,1)之间的数。
 * 解决方法：
 *     用Lehmer建议用的一个31 bit的素数 M=2^31-1=2147483647,并用A=48271作为全周期发生器的值。
 *     通过以下式子得到一个在随机时间产生的随机数。
 *     M/A 商Q 余R
 *     x(i+1)=Axi mod M
 *     .......
 *     
 *     x(i+1)=A(xi mod Q)-R[xi/Q]+M([xi/Q]-[Axi/M])
 *     注：i+1和i都是下标，具体细节在word文档
 *     
 *     
 *
 */
public class NotSpillRandomGenerator {

	private static final int A=48271;
	private static final int M=2147483647;
	private static final int Q=M/A;
	private static final int R=M%A;
	private int state;
	
	public NotSpillRandomGenerator() {
		state=(int) (System.currentTimeMillis()%Integer.MAX_VALUE);
		
	}
	//返回一个int型伪随机数，同时改变内部的state
	public int randomInt() {
		int tmpState=A*(state%Q)-R*(state/Q);
		if(tmpState>=0) {//余项等于0
			state=tmpState;
		}else {
			state=tmpState+M;//此时xi mod Q=0,即xi=Q;
		}
		return state;
	}
	//返回一个double型的伪随机数，范围在(0,1),同时改变内部的state
	public double random0_1() {
		return (double)randomInt()/M;
	}
	
}

