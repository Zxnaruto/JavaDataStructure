package ArrayList;


/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     ����һ�����������������ʵ�֡����������������һ�������
 *     1.���ֻ�����������������Լ���ǰ������
 *     2.�������������������
 *     3.�ṩget��set��ʵ�֡�
 *     4.�ṩsize(),isEmpty(),clear(),remove(),add()��
 *     5.�ṩһ��ʵ�ֵ�����(Iterator)�ӿڵ��࣬������ɶ�����Ԫ�صĲ�������next,hasNext,remove��
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {

	private static final int DEFAULT_CAPACITY=10;//��ʼ����
	private int theSize;//�����С
	private AnyType[] theItems;//��������
	
	//���캯������������ʼ������ʼ����Ϊ10
	public MyArrayList() {
		doClear();
	}
	//�������
	public void clear() {
		doClear();
	}
	//���ʵ��
	public void doClear() {
		theSize=0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	//���������С
	public int size() {
		return theSize;
	}
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return size()==0;
	} 
	//�������飬��������Ԫ�صĸ���С������Ĵ�Сʱ�����������������ʵ�ʳ����������С��ͬ
	public void trimToSize() {
		ensureCapacity(size());
	}
	//���idxλ���ϵ�Ԫ��
	public AnyType get(int idx) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	//���¶�idxλ���ϵ�ֵ��ֵ��������ԭ�е�ֵ
	public AnyType set(int idx,AnyType newVal) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		AnyType old=theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
	
	@SuppressWarnings("unchecked")
	//������������
	public void ensureCapacity(int newCapacity) {
		if(newCapacity<theSize)
			return;
		
		AnyType[] old=theItems;
		theItems=(AnyType[])new Object[newCapacity];
		for(int i=0;i<size();i++) {
			theItems[i]=old[i];
		}
	}
	//������ĩβ����Ԫ��
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	//��idxλ�ò���Ԫ��
	public void add(int idx,AnyType x) {
		if(theItems.length==size())//�жϲ���������
			ensureCapacity(size()*2+1);//+1�����ڴ�СΪ������
		for(int i=theSize;i>idx;i--)
			theItems[i]=theItems[i-1];
		
		theItems[idx]=x;
		
		theSize++;
	}
	//ɾ��idxλ���ϵ�Ԫ�أ������ظ�Ԫ��ֵ
	public AnyType remove(int idx) {
		AnyType removedItem=theItems[idx];
		for(int i=idx;i<size()-1;i++)
			theItems[i]=theItems[i+1];//��ǰ�ƶ����飬��ȱ��λ
		
		theSize--;
		return removedItem;
		
	}
	
	
	
	
	@Override
	//����������
	public java.util.Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	//�ڲ���--��������ʵ��
	private class ArrayListIterator implements java.util.Iterator<AnyType>{

		private int current=0;
		
		@Override
		//�Ƿ�����һ��Ԫ��
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<size();
		}

		@Override
		//��ǰԪ�ص���һ��Ԫ��
		public AnyType next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			return theItems[current++];//������±�0��ʼ����current++
		}
		public void remove() {
			MyArrayList.this.remove(--current);//�����ⲿ���remove,current��Ϊ�˽������next()��current++,Ϊ���Ƴ���ȷ��λ������current--
		}
		
	}
	

}
