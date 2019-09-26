package DyStructure.BinaryTree;

public class DyNode {

	Object value;
	DyNode leftChild;
	DyNode rightChild;

	public DyNode(Object value) {
		super();
		this.value = value;
	}

	public DyNode(Object value, DyNode leftChild, DyNode rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
}
