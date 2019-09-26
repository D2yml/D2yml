package DyStructure.List;

import javax.xml.soap.Node;

import DyStructure.DyList;
import DyStructure.Exception.DyArrListException;
/**
 * 单链表实现list
 * @author Administrator
 * @Date 2018年12月10日 13:44:17
 * 		  竣工;按照单链表方式实现
 * @param <T>
 */
public class DySingularLinkedList<T> implements DyList<T>{
	private DyNode head = new DyNode();
	private DyNode foot = new DyNode();
	private int size;
	
	@Override
	public String toString() {
		if (this.size == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		DyNode p = this.head.getNext();
		for (int i = 0; i < this.size; ++i) {
			if (i != this.size - 1){
				builder.append(p.getData() + ",");
			} else {
				builder.append(p.getData());
			}
			if (p.getNext() != null) {
				p = p.getNext();
			} else {
				break;
			}
		}

		builder.append("]");
		return builder.toString();
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public Object get(int i) {
		DyNode p = this.head;
		for (int j = 0; j <= i; ++j) {
			p = p.getNext();
		}
		return p.getData();
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public boolean contains(T e) {
		DyNode p = head;
		for (int i = 0; i < size; i++) {
			p = p.getNext();
			if (p.getData().equals(e)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int indexOf(T e) {
		int index = -1;
		DyNode p = head;
		for (int i = 0; i < size; i++) {
			p = p.getNext();
			if (p.getData().equals(e)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public void add(int i, T e) {
		if ((i < 0) || (i > this.size)) {
			throw new DyArrListException("数组指针越界异常：" + i);
		}
		//新建空结点
		DyNode p = this.head;
		//找到要插入的那一位
		for (int j = 0; j < i; ++j) {
			p = p.getNext();
		}
		DyNode newNode = new DyNode();
		newNode.setData(e);
		newNode.setNext(p.getNext());
		p.setNext(newNode);
		this.size += 1;

	}

	@Override
	public void add(T e) {
		add(this.size, e);
		
	}

	@Override
	public boolean addBefore(T obj, T e) {
		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		add(index-1, e);
		return true;
	}

	@Override
	public boolean addAfter(T obj, T e) {
		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		add(index, e);
		return true;
		
	}

	@Override
	public Object remove(int i) {
		if (i<0 || i>=size) {
			throw new DyArrListException("数组下标越界:"+i);
		}
		DyNode head = this.head;
		DyNode flag = null;
		Object obj = null;
		for (int j = 0; j < size; j++) {
			head = head.getNext();
			//找到要删除的上一位
			if (i-1 == j) {
				flag = head;
			}
			//将要删除的上一位的后继修改为被删除的后继
			if (i+1 == j) {
				flag.setNext(head); 
			}
			if (i == j) {
				obj = head.getData();
			}
		}
		size--;
		return obj;
	}

	@Override
	public boolean remove(T e) {
		int index = indexOf(e);
		if (index != -1) {
			remove(index);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public Object replace(int i, Object e) {
		Object oldData = null;
		DyNode head = this.head;
		for (int j = 0; j < size; j++) {
			head = head.getNext();
			if (i == j) {
				oldData = head.getData();
				head.setData(e);
			}
		}
		return oldData;
	}

}

