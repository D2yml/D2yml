package DyStructure.List;

public class DyNode {
	private Object data;
	private DyNode next;
	private DyNode prev;
	
	public DyNode(){}
	public DyNode(DyNode next, Object data, DyNode prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	public DyNode getPrev() {
		return prev;
	}
	public void setPrev(DyNode prev) {
		this.prev = prev;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public DyNode getNext() {
		return next;
	}
	public void setNext(DyNode next) {
		this.next = next;
	}
	
}
