package MyLinkList;

import java.util.Iterator;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     ��˫������ʵ��LinkedList��:
 *      1.������������ˣ���Ĵ�С��һЩ����
 *      2.�����ڵ�Node�࣬���������ݼ�����һ���ڵ�����͵�ǰһ���ڵ�������Լ�һЩ���췽����
 *      3.ʵ��һЩ�����磺clear(),remove(),add()�ȡ�
 *      4.����������LinkedListIterator��(˽����)��ʵ��Iterator�ӿڣ��ṩnext,hasNext,remove������
 *
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
  
	private int theSize;//������
	private int modcount=0;//��¼��������������ĸĶ����������Ƶ����������뺯��������ͬ����ֹ����
	private Node<AnyType> beginMarker;//ͷ�ڵ�
	private Node<AnyType> endMarker;//β�ڵ�
	//Node�ڵ�
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		public Node(AnyType d,Node<AnyType> p,Node<AnyType> n) {
			data=d;//����
			prev=p;//ǰһ���ڵ�
			next=n;//��һ���ڵ�
		}
	}
	//���캯����ɳ�ʼ��
	public MyLinkedList() {
		doClear();
	}
	//���
	public void clear() {
		doClear();
	}
	//���ʵ��
	public void doClear() {
		beginMarker=new Node<AnyType>(null,null,null);//����ͷ�ڵ����
		endMarker=new Node<AnyType>(null,beginMarker,null);//����β�ڵ����ǰһ���ڵ���bgM
		beginMarker.next=endMarker;//ͷ�ڵ��nextָ��β�ڵ�
		
		theSize=0;
		modcount++;
	}
	//���������С
	public int size() {
		return theSize;
	}
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return size()==0;
	}
	//ĩβ���뺯��
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	//����λ�ò���
	public void add(int idx,AnyType x) {
		addBefore(getNode(idx,0,size()),x);
	}
	//get���õ�idxλ���ϵ�����
	public AnyType get(int idx) {
		return getNode(idx).data;
	}
	//set����������idxλ���ϵ�ֵ
	public AnyType set(int idx,AnyType newVal) {
		Node<AnyType> p=getNode(idx);
		AnyType oldVal=p.data;
		p.data=newVal;
		return oldVal;
	}
	//remove���Ƴ�idxλ���ϵĽڵ�
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	//addBefore����p֮ǰ�����½ڵ㣬ͨ��getNode�ҵ�p
	private void addBefore(Node<AnyType> p,AnyType x) {
		Node<AnyType> newNode=new Node<>(x,p.prev,p);//�½ڵ��nextָ��p,p.prveָ���½ڵ��ǰһ���ڵ�(��ԭp��ǰһ���ڵ�)
		newNode.prev.next=newNode;//newNode��ǰһ���ڵ��nextָ��newNode(��ԭp��ǰһ���ڵ�)
		p.prev=newNode;//p��ǰָ��ָ��newNode
		theSize++;
		modcount++;
	}
	//remove�ߵķ���ͬ
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
	//Ѱ�ҽڵ㣬�����ǰ�벿�����ͷ��ʼ������ں�벿�ִ�β����ʼ��ǰ��
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
	//������
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
