package algorithm.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 队列
 * @author Administrator
 *
 */
public class MyQueue {
	  public static void main(String[] args) {
		  MyQueue re = new MyQueue();
	        System.out.println(re.RecursionNum(10));
	    }
	    public int RecursionNum(int num) {
	        if (num > 0) {
	            return num + RecursionNum(num - 1);
	        } else {
	            return 0;
	        }
	    }

}
