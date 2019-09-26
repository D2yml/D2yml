package Concurrent;

/**
 *  一、共享性
 *  数据共享性是线程安全的主要原因之一。
 *  如果所有的数据只是在线程内有效，那就不存在线程安全性问题，这也是我们在编程的时候经常不需要考虑线程安全的主要原因之一。
 *  但是，在多线程编程中，数据共享是不可避免的。
 *  最典型的场景是数据库中的数据，为了保证数据的一致性，
 *  我们通常需要共享同一个数据库中数据，即使是在主从的情况下，访问的也同一份数据，主从只是为了访问的效率和数据安全，而对同一份数据做的副本。
 *  我们现在，通过一个简单的示例来演示多线程下共享数据导致的问题：
 */
public class Step1 {
	public static int count = 0;
	 
    public static void main(String[] args) {
        final Step1 data = new Step1();
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
 
    public void addCount() {
        count++;
    }
}
