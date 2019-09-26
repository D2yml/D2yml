package Concurrent;

/**
 * 二、互斥性
 *资源互斥是指同时只允许一个访问者对其进行访问，具有唯一性和排它性。
 *我们通常允许多个线程同时对数据进行读操作，但同一时间内只允许一个线程对数据进行写操作。
 *所以我们通常将锁分为共享锁和排它锁，也叫做读锁和写锁。如果资源不具有互斥性，即使是共享资源，我们也不需要担心线程安全。
 *例如，对于不可变的数据共享，所有线程都只能对其进行读操作，所以不用考虑线程安全问题。
 *但是对共享数据的写操作，一般就需要保证互斥性，上述例子中就是因为没有保证互斥性才导致数据的修改产生问题。
 *Java 中提供多种机制来保证互斥性，最简单的方式是使用Synchronized。现在我们在上面程序中加上Synchronized再执行：
 */
public class Step2 {
	 public static int count = 0;
	 
	    public static void main(String[] args) {
	        final Step2 data = new Step2();
	        for (int i = 0; i < 10; i++) {
	            new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    try {
	                        //进入的时候暂停1毫秒，增加并发问题出现的几率
	                        Thread.sleep(1);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    for (int j = 0; j < 100; j++) {
	                        data.addCount();
	                    }
	                    System.out.print(count + " ");
	                }
	            }).start();
	 
	        }
	        try {
	            //主程序暂停3秒，以保证上面的程序执行完成
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("count=" + count);
	    }
	 
	    /**
	     * 增加 synchronized 关键字
	     */
	    public synchronized void addCount() {
	        count++;
	    }
}
