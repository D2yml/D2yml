package DyStructure;

public interface DyStack<E> {
	//出栈
	Object pop();
	//查找栈内元素
	int search(E e);
	
	//获取栈顶元素
	Object peek(E e);
	//入栈
	boolean push(E e);
	boolean empty();
	int size();
}
