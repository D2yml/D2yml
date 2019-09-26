package Amaze;

/**
 * Integer默认缓存问题
 * 详见:http://www.importnew.com/22386.html
 * @author Administrator
 *
 */
public class AboutIntegerCache {
	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Integer aaa = 1000, bbb = 1000;
		System.out.println(aaa == bbb);// 1
		Integer ccc = 100, ddd = 100;
		System.out.println(ccc == ddd);// 2

		Class cache = Integer.class.getDeclaredClasses()[0]; // 1
		java.lang.reflect.Field myCache = cache.getDeclaredField("cache"); // 2
		myCache.setAccessible(true);// 3

		Integer[] newCache = (Integer[]) myCache.get(cache); // 4
		newCache[132] = newCache[133]; // 5

		int a = 2;
		int b = a + a;
		System.out.printf("%d + %d = %d", a, a, b); //
	
	}
}
