package test2;

public class Random {
	private static final int A=48271;
	private static final int M=2147483647;
	private static final int Q=M/A;
	private static final int R=M%A;
	private int state;
	
	
	public Random() {
		state=(int) (System.currentTimeMillis()%Integer.MAX_VALUE);
		
	}
	//返回一个int型伪随机数，同时改变内部的state
	public int random() {
		int tmpState=A*(state%Q)-R*(state/Q);
		if(tmpState>=0) {//余项等于0
			state=tmpState;
		}else {
			state=tmpState+M;//此时xi mod Q=0,即xi=Q;
		}
		return state;
	}
	
	
}
