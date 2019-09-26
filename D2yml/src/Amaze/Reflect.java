package Amaze;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Amaze.bean.User;

public class Reflect {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {

		// 获取Class对象的三种方式
		System.out.println("根据类名:  \t" + User.class);
		System.out.println("根据对象:  \t" + new User().getClass());
		System.out.println("根据全限定类名:\t" + Class.forName("Amaze.bean.User"));

		System.out.println("\n");

		// 常用的方法
		Class userClass = Class.forName("Amaze.bean.User");
		System.out.println("获取全限定类名:\t" + userClass.getName());
		System.out.println("获取类名:\t" + userClass.getSimpleName());
		System.out.println("实例化:\t" + userClass.newInstance());

		System.out.println("\n");

		// 获取全部的构造函数
		Constructor<?>[] constructors = userClass.getConstructors();
		// 取消安全性检查,设置后才可以使用private修饰的构造函数，也可以单独对某个构造函数进行设置
		// Constructor.setAccessible(constructors, true);
		for (int i = 0; i < constructors.length; i++) {
			// 获取构造方法所有参数类型
			Class<?> parameterTypesClass[] = constructors[i].getParameterTypes();
			System.out.print("第" + i + "个构造函数:\t (");
			for (int j = 0; j < parameterTypesClass.length; j++) {
				System.out.print(parameterTypesClass[j].getName() + (j == parameterTypesClass.length - 1 ? "" : "\t"));
			}
			System.out.println(")");
		}
		// 调用构造函数,实例化对象
		System.out.println("实例化，调用无参构造:\t" + constructors[0].newInstance());
		System.out.println("实例化，调用有参构造:\t" + constructors[1].newInstance("Anglag", 35));

		User user = (User) userClass.newInstance();
		// 获取当前类所有属性 Field类属性对象
		Field fields[] = userClass.getDeclaredFields();
		// 获取公有属性(包括父类)
		// Field fields[] = cl.getFields();
		// 取消安全性检查,设置后才可以获取或者修改private修饰的属性，也可以单独对某个属性进行设置
		Field.setAccessible(fields, true);
		for (Field field : fields) {
			// 获取属性名 属性值 属性类型
			System.out.println("属性名:" + field.getName() + "\t属性值:" + field.get(user) + "  \t属性类型:" + field.getType());
		}
		//获取Username字段
		Field fieldUserName = userClass.getDeclaredField("name");
		// 取消安全性检查,设置后才可以获取或者修改private修饰的属性，也可以批量对所有属性进行设置
		fieldUserName.setAccessible(true);
		fieldUserName.set(user, "Anglagdd");
		// 可以直接对 private 的属性赋值
		System.out.println("修改属性后对象:\t" + user);

		// User user = (User) userClass.newInstance();
		// 获取当前类的所有方法
		Method[] methods = userClass.getDeclaredMethods();
		// 获取公有方法(包括父类)
		// Method[] methods = userClass.getMethods();
		// 取消安全性检查,设置后才可以调用private修饰的方法，也可以单独对某个方法进行设置
		Method.setAccessible(methods, true);
		for (Method method : methods) {
			// 获取方法名和返回类型 获取参数类型：getParameterTypes
			System.out.println("方法名:" + method.getName() + " \t返回类型:" + method.getReturnType().getName());
		}
		// 获取无参方法
		Method getMethod = userClass.getDeclaredMethod("getName");
		// 取消安全性检查,设置后才可以调用private修饰的方法，也可以批量对所有方法进行设置
		getMethod.setAccessible(true);
		// 调用无参方法
		System.out.println("调用getName方法：" + getMethod.invoke(user));
		// 获取有参方法
		Method setMethod = userClass.getDeclaredMethod("setName", String.class);
		// 取消安全性检查,设置后才可以调用private修饰的方法，也可以批量对所有方法进行设置
		setMethod.setAccessible(true);
		// 调用有参方法
		System.out.println("调用setName方法：" + setMethod.invoke(user, "Angladdddd"));
		System.out.println("通过set方法修改属性后对象:\t" + user);

	}

}
