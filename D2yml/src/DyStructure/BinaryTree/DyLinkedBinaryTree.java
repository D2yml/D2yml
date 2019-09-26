package DyStructure.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import DyStructure.DyBinaryTree;

public class DyLinkedBinaryTree implements DyBinaryTree {

	private DyNode root;

	public DyLinkedBinaryTree(DyNode root) {
		super();
		this.root = root;
	}

	public DyLinkedBinaryTree() {
	}

	@Override
	public boolean isEmpty() {
		return root.value == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DyNode findKey(int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preOrderTraverse() {
		// 输出根节点
		if (root != null)
			System.out.println(root.value);
		// 对左子树进行遍历
		if (root != null) {
			DyBinaryTree left = new DyLinkedBinaryTree(root.leftChild);
			left.preOrderTraverse();
		}
		// 对右子树进行遍历
		if (root != null) {
			DyBinaryTree right = new DyLinkedBinaryTree(root.leftChild);
			right.preOrderTraverse();
		}
	}

	@Override
	public void inOrderTraverse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postOrderTraverse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postOrderTraverse(DyNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inOrderByStack() {
		Deque<DyNode> stack = new LinkedList<DyNode>();
		DyNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.leftChild;
			}

			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.rightChild;
			}
		}
		System.out.println();
	}

	@SuppressWarnings({ "unused", "null" })
	@Override
	public void preOrderByStack() {
//		中序遍历非递归操作 
//		1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。 
//		2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current 
//		3) 重复1、2步操作，直到current为空且栈内节点为空。 
//		前序遍历非递归操作 
//		1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。 
//		2）若左子树为空，栈顶节点出栈，将该节点的右子树置为current 
//		3) 重复1、2步操作，直到current为空且栈内节点为空。
		Deque<DyNode> stack = new LinkedList<DyNode>();
		DyNode current = root;
		while (current !=null || !stack.isEmpty()) {
			while (current !=null) {
				System.out.print(current.value+ " ");
				stack.push(current);
				current = current.leftChild;
				
			}
			if (current == null) {
				stack.pop();
				current = current.rightChild;
			}
		}
	}

	@Override
	public void postOrderByStack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void levelOrderByStack() {
		if (root == null) {
			return;
		}
		Queue<DyNode> queue = new LinkedList<DyNode>();
		queue.add(root);
		while (queue.size() != 0) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				DyNode temp = queue.poll();
				System.out.println(temp.value + " ");
				if (temp.leftChild != null) {
					queue.add(temp.leftChild);
				}
				if (temp.rightChild != null) {
					queue.add(temp.rightChild);
				}
			}
		}
	}

}
