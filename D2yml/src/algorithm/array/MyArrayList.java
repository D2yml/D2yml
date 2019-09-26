package algorithm.array;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    //初始化集合的容量
    private static final int DEFAULT_CAPACITY=10;
    //当前元素的个数
    private int theSize;
    //使用一个数组来实现这个List
    private T [] theItems;
    public MyArrayList(){
        clear();
    }
    //清空集合元素,初始化时使用
    public void clear(){
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    
    
    //通过传入的int值大小决定是否需要扩充集合空间大小
    public void ensureCapacity(int newCapacity) {
//    	java.util.ArrayList
        if(newCapacity<theSize)
            return;
        T[] old=theItems;
        theItems=(T[]) new Object[newCapacity];
        for(int i=0;i<size();i++){
            theItems[i]=old[i];
        }
    }

    //返回当前集合元素的个数
    public int size() {
        return theSize;
    }
    //返回当前集合是否为空
    public boolean isEmpty(){
        return size()==0;
    }
    
    public void trimToSize(){
        ensureCapacity(size());
    }

    //获取指定索引下的元素值
    public T get(int index){
        if(index<0||index>=size())
            throw new ArrayIndexOutOfBoundsException("索引越界");
        
        return theItems[index];
    }
    //修改指定索引上的元素值
    public T set(int index,T value){
        if(index<0||index>=size())
            throw new ArrayIndexOutOfBoundsException("索引越界");
        T old=theItems[index];
        theItems[index]=value;
        
        return old;
    }
    
    //添加元素,直接指定元素,默认添加在数组末尾
    public boolean add(T value){
        add(size(),value);
        return true;
    }
    //添加元素,指定添加位置和元素值
    public void add(int index, T value) {
        //如果数组元素个数已经达到指定size();那么扩展该数组,使数组容量加倍
        if(theItems.length==size()){
            ensureCapacity(size()*2+1);
        }
        //从末尾元素向前遍历,一直到index处,使index处之后的所有元素向后移动一位
        for(int i=theSize;i>index;i--){
            theItems[i]=theItems[i-1];
        }
        theItems[index]=value;
        //添加完元素,是集合元素个数加一
        theSize++;
    }

    //移除指定索引处的元素值,
    public T remove(int index){
        T val=theItems[index];
        for(int i=index;i<size()-1;i++){
            theItems[i]=theItems[i+1];
        }
        theSize--;
        return val;
    }
    //重写迭代器的方法,使用下面的静态内部类实现,注意static,如果没有该关键字,会使内部类访问不到外部的成员
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator implements java.util.Iterator<T>{

        private int current=0;
        
        
        @Override
        public boolean hasNext() {
            return current<size();
        }

        
        @Override
        public T next() {
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
        
    }
    
}