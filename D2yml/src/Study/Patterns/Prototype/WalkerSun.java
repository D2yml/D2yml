package Study.Patterns.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


public class WalkerSun extends Monkey implements Cloneable, Serializable{
	GoldStick g = null;
	
	//clone不会走构造方法
	WalkerSun(){
		g = new GoldStick();
		super.setHeight(150);
		super.setBodyweight(40);
		super.setBirthday(new Date());
	}

	@Override
	protected Object clone()  {
		//浅克隆,只克隆byte,short,int,long,float,double,char,boolean,String
//		try {
//			return super.clone();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//			return null;
//		}
		//深克隆,通过重写clone来克隆更多数据类型;这里使用序列化/反序列化实现
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis= null;
		ObjectInputStream ois = null;
		try {
			//序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			//反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			try {
				WalkerSun sun = (WalkerSun)ois.readObject();
				sun.setBirthday(new Date());
				return sun;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				bos.close();
				oos.close();
				bis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void change() {
		WalkerSun sun = (WalkerSun)clone();
		System.out.println("本体生日是:" + this.getBirthday().getTime());
		System.out.println("克隆体生日是:" + sun.getBirthday().getTime());
		System.out.println("是否为同一个对象:" + (this == sun));
		System.out.println("是否用同一个金箍棒:" + (this.g == sun.g));
		
		
	}
	
	
}
