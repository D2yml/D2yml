package DyStructure.List;

import DyStructure.DyList;
import DyStructure.Exception.DyArrListException;
/**
 * 双链表LinkedList
 * @author Administrator
 *
 * @param <E>
 */
public class DyLinkedList<E> implements DyList<E> {
	
	int size = 0;
	Entry<E> header = new Entry(null,null,null);
	Entry<E> footer = new Entry(null,null,null);
	
	public DyLinkedList() {
		header.next = footer;
		footer.prev = header;
	}
	
	@Override
	public String toString() {
		return header.toString();
	}

	@Override
	public int size() {
		return size;
	}
	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void add(int i, E e) {
		Entry<E> p = entry(i);
		addBefore(e, p);
		
	}
	@Override
	public void add(E e) {
		add(size, e);
		
	}
	@Override
	public boolean addBefore(E obj, E e) {
		
		return false;
	}
	
	@Override
	public boolean addAfter(E obj, E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object replace(int i, Object e) {
		// TODO Auto-generated method stub
		return null;
	}
	private void addBefore(E obj,Entry<E> e) {
		Entry<E> newNode = new Entry<E>(obj, e, e.prev);
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		size++;
	}
	private Entry<E> entry(int i){
		check(i);
		Entry<E> p = header;
		if(i < (size >> 1)){
			for (int j = 0; j <= i; j++) {
				p = p.next;
			}
		} else {
			for (int j = size; j < i; j--) {
				p = p.prev;
			}
		}
		return p;
	}
	private void check(int i){
		if (i < 0 || i> size) {
			throw new DyArrListException("下标越界! index:"+i+" size:"+size);
		}
	}
}

class Entry<E>{
	E data;
	Entry<E> next;
	Entry<E> prev;
	
	@Override
	public String toString() {
		return "Entry [data=" + data + ", next=" + next + ", prev=" + prev + "]";
	}
	public Entry() {}
	public Entry(E data, Entry<E> next, Entry<E> prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
}
