package Study.Patterns.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyInvocationHandler implements InvocationHandler{
	
	private Costomer c;

	public Object getIns(Costomer c){
		this.c = c;
		Class clazz = c.getClass();
		//自动生成代理对象
		return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		this.c.inputSize();
		System.out.println("身高:" + c.getHight());
		System.out.println("体重:" + c.getBodyWeight());
		System.out.println("你适合穿XXL");
		return null;
	}

}
