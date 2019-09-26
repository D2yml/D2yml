package Amaze;


/**
 * 关于String.intern()
 * 
 * 	1. 任何和+的引用类型存储数据会保存在堆内存
 * 	2. 调用intern()后将会保存在常量池
 * 	3. 返回常量池中的引用
 * 	4. 提高程序效率或减少内存占用
 * 
 * 在jdk1.7之前，字符串常量存储在方法区的PermGen Space。在jdk1.7之后，字符串常量重新被移到了堆中。
 * @author Administrator
 *
 */
public class StringIntern {
	public static void main(String[] args) {
		String str1 = "aaa";
        String str2 = "bbb";
        String str3 = "aaabbb";
        String str4 = str1 + str2;
        String str5 = "aaa" + "bbb";
        System.out.println(str3 == str4); // false
        System.out.println(str3 == str4.intern()); // true
        System.out.println(str3 == str5);// true
	}
}
