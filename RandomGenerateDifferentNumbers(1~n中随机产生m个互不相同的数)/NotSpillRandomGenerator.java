package test3;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     ��дһ�������������������������Է���һ��int�͵�α�������Ҳ���Է���һ��double�͵ķ�Χ��(0,1)֮�������
 * ���������
 *     ��Lehmer�����õ�һ��31 bit������ M=2^31-1=2147483647,����A=48271��Ϊȫ���ڷ�������ֵ��
 *     ͨ������ʽ�ӵõ�һ�������ʱ��������������
 *     M/A ��Q ��R
 *     x(i+1)=Axi mod M
 *     .......
 *     
 *     x(i+1)=A(xi mod Q)-R[xi/Q]+M([xi/Q]-[Axi/M])
 *     ע��i+1��i�����±꣬����ϸ����word�ĵ�
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
	//����һ��int��α�������ͬʱ�ı��ڲ���state
	public int randomInt() {
		int tmpState=A*(state%Q)-R*(state/Q);
		if(tmpState>=0) {//�������0
			state=tmpState;
		}else {
			state=tmpState+M;//��ʱxi mod Q=0,��xi=Q;
		}
		return state;
	}
	//����һ��double�͵�α���������Χ��(0,1),ͬʱ�ı��ڲ���state
	public double random0_1() {
		return (double)randomInt()/M;
	}
	
}

