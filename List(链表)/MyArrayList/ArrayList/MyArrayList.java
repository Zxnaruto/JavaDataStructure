package ArrayList;


/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     这是一个关于数组链表类的实现。包含对数组链表的一般操作。
 *     1.保持基础数组和其容量，以及当前项数。
 *     2.可以扩增数组的容量。
 *     3.提供get和set的实现。
 *     4.提供size(),isEmpty(),clear(),remove(),add()。
 *     5.提供一个实现迭代器(Iterator)接口的类，可以完成对数组元素的操作，即next,hasNext,remove。
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {

	private static final int DEFAULT_CAPACITY=10;//初始容量
	private int theSize;//数组大小
	private AnyType[] theItems;//声明数组
	
	//构造函数，完成数组初始化，初始长度为10
	public MyArrayList() {
		doClear();
	}
	//清空数组
	public void clear() {
		doClear();
	}
	//清空实现
	public void doClear() {
		theSize=0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	//返回数组大小
	public int size() {
		return theSize;
	}
	//判断数组是否为空
	public boolean isEmpty() {
		return size()==0;
	} 
	//整理数组，当所含有元素的个数小于数组的大小时，对其进行修整，即实际长度与数组大小相同
	public void trimToSize() {
		ensureCapacity(size());
	}
	//获得idx位置上的元素
	public AnyType get(int idx) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	//重新对idx位置上的值赋值，并返回原有的值
	public AnyType set(int idx,AnyType newVal) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		AnyType old=theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
	
	@SuppressWarnings("unchecked")
	//数组容量更新
	public void ensureCapacity(int newCapacity) {
		if(newCapacity<theSize)
			return;
		
		AnyType[] old=theItems;
		theItems=(AnyType[])new Object[newCapacity];
		for(int i=0;i<size();i++) {
			theItems[i]=old[i];
		}
	}
	//在数组末尾插入元素
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	//在idx位置插入元素
	public void add(int idx,AnyType x) {
		if(theItems.length==size())//判断并扩充数组
			ensureCapacity(size()*2+1);//+1适用于大小为零的情况
		for(int i=theSize;i>idx;i--)
			theItems[i]=theItems[i-1];
		
		theItems[idx]=x;
		
		theSize++;
	}
	//删除idx位置上的元素，并返回该元素值
	public AnyType remove(int idx) {
		AnyType removedItem=theItems[idx];
		for(int i=idx;i<size()-1;i++)
			theItems[i]=theItems[i+1];//向前移动数组，补缺空位
		
		theSize--;
		return removedItem;
		
	}
	
	
	
	
	@Override
	//迭代器声明
	public java.util.Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	//内部类--迭代器的实现
	private class ArrayListIterator implements java.util.Iterator<AnyType>{

		private int current=0;
		
		@Override
		//是否有下一个元素
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<size();
		}

		@Override
		//当前元素的下一个元素
		public AnyType next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			return theItems[current++];//数组从下标0开始所以current++
		}
		public void remove() {
			MyArrayList.this.remove(--current);//调用外部类的remove,current是为了解决上面next()的current++,为了移除正确的位置所以current--
		}
		
	}
	

}
