package DyStructure.Stack;

import DyStructure.DyStack;
import DyStructure.List.DySingularLinkedList;
import DyStructure.List.DyNode;
/**
 * 基于单链表实现栈
 * @author Administrator
 *
 * @param <E>
 */
public class DyLinkedStack<E> extends DySingularLinkedList<E> implements DyStack<E> {
	private int size = 0;
	public int size() {
		return size;
	}
	@Override
	public Object peek(E e) {
		return super.get(super.size());
	}
	@Override
	public Object pop() {
		size--;
		return super.remove(super.size()-1);
	}
	@Override
	public int search(E e) {
		return super.indexOf(e);
	}
	@Override
	public boolean push(E e) {
		size++;
		super.add(e);
		return true;
	}
	@Override
	public boolean empty() {
		return super.size() == 0;
	}
	
}
