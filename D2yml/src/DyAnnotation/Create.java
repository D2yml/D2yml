package DyAnnotation;

import java.lang.reflect.Field;

public class Create {
	public static void init(Class<?> clazz) {
		String name = "";
		String brand = "";
		// 获取所有本类声明的字段
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			// 如果包含Brand注解
			if (field.isAnnotationPresent(Brand.class)) {
				// 得到指定注解(枚举方式)
				Brand brand2 = field.getAnnotation(Brand.class);
				// 获取选择的值(枚举方式)
				brand = brand + brand2.brand().toString();
				System.out.println(brand);
			}
			// 如果包含Name注解
			if (field.isAnnotationPresent(Name.class)) {
				// 得到指定注解
				Name name2 = field.getAnnotation(Name.class);
				// 获取选择的值
				name = name + name2.value();
				System.out.println(name);
			}
		}
	}

	public static void main(String[] args) {
		init(Bean.class);
	}
}
