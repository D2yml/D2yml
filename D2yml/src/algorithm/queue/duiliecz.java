package algorithm.queue;


public class duiliecz { // 队列操作类
    private int i = 0; // 队列长
    private duilie top = new duilie(""); // 队列头
    private duilie end = new duilie(""); // 队列尾
    public void add(String s) { // 添加队列
        duilie m = new duilie(s);
        if (i != 0) {
            m.setS(top.getS());
            top.setS(m);
        } else {
            top.setS(m);
            end.setS(m);
        }
        i++;
    }
}