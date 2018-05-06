package MyLinkList;

import java.util.Iterator;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     用双向链表实现LinkedList类:
 *      1.包含链表的两端，表的大小及一些方法
 *      2.包含节点Node类，它包含数据及到下一个节点的链和到前一个节点的链，以及一些构造方法。
 *      3.实现一些方法如：clear(),remove(),add()等。
 *      4.包含迭代器LinkedListIterator类(私有类)，实现Iterator接口，提供next,hasNext,remove方法。
 *
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
  
	private int theSize;//链表长度
	private int modcount=0;//记录构造以来对链表的改动次数，控制迭代器操作与函数操作相同，防止出错
	private Node<AnyType> beginMarker;//头节点
	private Node<AnyType> endMarker;//尾节点
	//Node节点
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		public Node(AnyType d,Node<AnyType> p,Node<AnyType> n) {
			data=d;//数据
			prev=p;//前一个节点
			next=n;//下一个节点
		}
	}
	//构造函数完成初始化
	public MyLinkedList() {
		doClear();
	}
	//清空
	public void clear() {
		doClear();
	}
	//清空实现
	public void doClear() {
		beginMarker=new Node<AnyType>(null,null,null);//创建头节点对象
		endMarker=new Node<AnyType>(null,beginMarker,null);//创建尾节点对象，前一个节点是bgM
		beginMarker.next=endMarker;//头节点的next指向尾节点
		
		theSize=0;
		modcount++;
	}
	//返回链表大小
	public int size() {
		return theSize;
	}
	//判断链表是否为空
	public boolean isEmpty() {
		return size()==0;
	}
	//末尾插入函数
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	//任意位置插入
	public void add(int idx,AnyType x) {
		addBefore(getNode(idx,0,size()),x);
	}
	//get，得到idx位置上的数据
	public AnyType get(int idx) {
		return getNode(idx).data;
	}
	//set，重新设置idx位置上的值
	public AnyType set(int idx,AnyType newVal) {
		Node<AnyType> p=getNode(idx);
		AnyType oldVal=p.data;
		p.data=newVal;
		return oldVal;
	}
	//remove，移除idx位置上的节点
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	//addBefore，在p之前插入新节点，通过getNode找到p
	private void addBefore(Node<AnyType> p,AnyType x) {
		Node<AnyType> newNode=new Node<>(x,p.prev,p);//新节点的next指向p,p.prve指向新节点的前一个节点(即原p的前一个节点)
		newNode.prev.next=newNode;//newNode的前一个节点的next指向newNode(即原p的前一个节点)
		p.prev=newNode;//p的前指针指向newNode
		theSize++;
		modcount++;
	}
	//remove走的方向不同
	private AnyType remove(Node<AnyType> p) {
		p.next.prev=p.prev;
		p.prev.next=p.next;
		theSize--;
		modcount++;
		return p.data;
	}
	//getNode
	private Node<AnyType> getNode(int idx){
		return getNode(idx,0,size()-1);
	}
	//寻找节点，如果在前半部分则从头开始，如果在后半部分从尾部开始向前找
	private Node<AnyType> getNode(int idx,int lower,int upper){
		Node<AnyType> p;
		if(idx<lower||idx>upper)
			throw new IndexOutOfBoundsException();
		if(idx<size()/2) {
			p=beginMarker.next;
			for(int i=0;i<idx;i++) {
				p=p.next;
			}
		}else {
			p=endMarker;
			for(int i=size();i>idx;i--) {
				p=p.prev;
			}
		}
		
		return p;
	}
	//迭代器
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<AnyType>{

		private Node<AnyType> current=beginMarker.next;
		private int expectedModCount=modcount;
		private boolean okToRemove=false;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=endMarker;
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			if(modcount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			AnyType nextItem=current.data;
			current=current.next;
			okToRemove=true;
			return nextItem;
		}
		
		public void remove() {
			if(modcount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			
			MyLinkedList.this.remove(current.prev);
			expectedModCount++;
			okToRemove=false;
			
		}
	}
	
	
}
