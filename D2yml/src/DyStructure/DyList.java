package DyStructure;

public interface DyList<T> {
	// 返回线性表的大小，即数据元素的个数。
		public int size();
		
		// 返回线性表中序号为 i 的数据元素
		public Object get(int i);

		// 如果线性表为空返回 true，否则返回 false。
		public boolean isEmpty();

		// 判断线性表是否包含数据元素 e
		public boolean contains(T e);

		// 返回数据元素 e 在线性表中的序号
		public int indexOf(T e);

		// 将数据元素 e 插入到线性表中 i 号位置
		public void add(int i, T e);

		// 将数据元素 e 插入到线性表末尾
		public void add(T e);

		// 将数据元素 e 插入到元素 obj 之前
		public boolean addBefore(T obj, T e);

		// 将数据元素 e 插入到元素 obj 之后
		public boolean addAfter(T obj, T e);

		// 删除线性表中序号为 i 的元素,并返回之
		public Object remove(int i);

		// 删除线性表中第一个与 e 相同的元素
		public boolean remove(T e);

		// 替换线性表中序号为 i 的数据元素为 e，返回原数据元素
		public Object replace(int i, Object e);



}
