package algorithm.array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import DyStructure.DyList;
import DyStructure.DyStack;
import DyStructure.List.DyLinkedList;
import DyStructure.List.DyNode;
import DyStructure.List.DySingularLinkedList;
import DyStructure.Stack.DyLinkedStack;

public class test {
	
	public static void main(String[] args) {
//		System.out.println(list);
//		System.out.println(list.poll());
//		System.out.println(list);
		DyList<Object> list = new DyLinkedList<Object>();
		list.add("aaa");
		System.out.println(list);
		System.out.println(list.size());
		list.add(1, "zzz");
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list);
//		list.add(3, "zzz");
//		System.out.println(list);
	}
	  private static int node(int index) {
		  	//index小于size的2/1
	        if (index < (5 >> 1)) {
	        	System.out.println("true");
	        	int x = 0;
	            //得到最后一个节点
	        	for (int i = 0; i < index; i++)
	                x = 5+i;
	            return x;
	        } else {
	        	System.out.println("flase");
	        	int x = 5;
	            for (int i = 5 - 1; i > index; i--)
	                x = 5-i;
	            return x;
	        }
	    }
}
