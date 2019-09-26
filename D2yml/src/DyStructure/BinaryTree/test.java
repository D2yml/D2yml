package DyStructure.BinaryTree;

import DyStructure.DyBinaryTree;

public class test {
	public static void main(String[] args) {
		DyNode DyNode5 = new DyNode(5, null, null);
		DyNode DyNode4 = new DyNode(4, null, DyNode5);
		
		DyNode DyNode3 = new DyNode(3, null, null);
		DyNode DyNode7 = new DyNode(7, null, null);
		DyNode DyNode6 = new DyNode(6, null, DyNode7);
		
		DyNode DyNode2 = new DyNode(2, DyNode3, DyNode6);
		
		DyNode DyNode1 = new DyNode(1,DyNode4,DyNode2);
		
		DyBinaryTree  btree = new DyLinkedBinaryTree(DyNode1);
		System.out.println(btree.isEmpty());
	}

}
