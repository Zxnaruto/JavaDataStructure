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
	//����һ��int��α�������ͬʱ�ı��ڲ���state
	public int random() {
		int tmpState=A*(state%Q)-R*(state/Q);
		if(tmpState>=0) {//�������0
			state=tmpState;
		}else {
			state=tmpState+M;//��ʱxi mod Q=0,��xi=Q;
		}
		return state;
	}
	
	
}
