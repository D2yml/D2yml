package DyStructure.List;

import java.util.Arrays;

import DyStructure.DyList;
import DyStructure.Exception.DyArrListException;

/**
 * 自定义ArrayList
 * @author Administrator
 * @ Date 2018年12月3日 13:39:31 
 * 			竣工
 * @ Date 2018年12月5日 15:52:05
 * 			修改add方法/remove方法循环体;完善数组扩容流程;整体测试
 */
public class DyArrList<T> implements DyList<T> {
	private Object[] elementData;
	private int size;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private static final int DEFAULT_CAPACITY = 10;
	public DyArrList(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new DyArrListException("传入数据为空:"+initialCapacity);
		}
		this.elementData = new Object[initialCapacity];
	}
	public DyArrList(){
		this.elementData = EMPTY_ELEMENTDATA;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < size; i++) {
			builder.append(elementData[i]);
			if (i < size-1) {
				builder.append(",");
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
		numberIndexOut(i);
		return elementData[i];
	}

	@Override
	public boolean isEmpty() {
		if (elementData.length == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(T e) {
		if (e == null) {
			throw new DyArrListException("传入数据为空");
		}
		for (int i = 0; i < elementData.length; i++) {
			if (e.equals(elementData[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(T e) {
		for (int i = 0; i < elementData.length; i++) {
			if (e.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void add(int i, T e) {
		numberIndexOut(i);
		if (size == elementData.length) {
			System.out.println("准备扩容");
			ensureCapacityInternal(size+1);
		}
		
		for (int j = size; j > i; j--) {
			elementData[j] = elementData[j-1];
		}
		elementData[i] = e;
		size++;
	}

	@Override
	public void add(T e) {
		ensureCapacityInternal(size+1);
		elementData[size++] = e;
	}

	@Override
	public boolean addBefore(T obj, T e) {
		int index = -1;
		for (int i = 0; i < elementData.length; i++) {
			if (obj.equals(elementData[i])) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		}
		if (size == elementData.length) {
			ensureCapacityInternal(size+1);
		}
		add(index,e);
		return true;
	}

	@Override
	public boolean addAfter(T obj, T e) {
		int index = -1;
		for (int i = 0; i < elementData.length; i++) {
			if (obj.equals(elementData[i])) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		}
		if (size == elementData.length) {
			ensureCapacityInternal(size+1);
		}
		add(index+1,e);
		return true;
	}

	@Override
	public Object remove(int i) {
		numberIndexOut(i);
		for (int j = i; j < size; j++) {
			elementData[j] = elementData[j+1];
		}
		size--;
		return elementData[i];
		
	}

	@Override
	public boolean remove(T e) {
		int index = -1;
		for (int i = 0; i < elementData.length; i++) {
			if (e.equals(elementData[i])) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		}
		for (int j = index; j < size; j++) {
			elementData[j] = elementData[j+1];
		}
		size--;
		return true;
		
	}

	@Override
	public Object replace(int i, Object e) {
		numberIndexOut(i);
		elementData[i] = e;
		return elementData[i];
	}
	
	private void ensureCapacityInternal(int min){
		//如果数组是空的min=默认大小与参数较大的那个
		if (elementData == EMPTY_ELEMENTDATA) {
			min = Math.max(DEFAULT_CAPACITY,min);
		}
		if (min - elementData.length > 0) {	
			grow(min);
		}
		
	}
	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		//将数组扩容50%
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		//如果新长度小于参数则赋值
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		elementData = Arrays.copyOf(elementData, newCapacity);
	}
	private void numberIndexOut(int i){
		if (i<0 || i >= elementData.length) {
			throw new DyArrListException("下标越界:"+i);
		}
	}
	




}
