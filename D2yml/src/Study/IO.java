package Study;

import java.io.File;
import java.io.IOException;

public class IO {
	public static void main(String[] args) throws IOException {
		File file = new File("");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		File file0 = new File("D:\\workspace\\YangCW");//传入合法路径名
//		file.
//		File tmpFile = File.createTempFile("abcdefg",".txt",);//文件名,格式,路径
	}
}
