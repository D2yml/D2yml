package algorithm.array;

public class efferArray {
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{68,11,58,85,42};
		efferArray(arr);
	}
	public static void efferArray(Integer[] in) {
		int tem = 0;
		int num = 0;
		int upnum = 0;
		for (int i = 0; i < in.length; i++) {
			for (int j = i; j < in.length - 1; j++) {
				num++;
				if (in[j + 1] < in[i]) {
					tem = in[j + 1];
					in[j + 1] = in[i];
					in[i] = tem;
					upnum++;
				}
			}
		}
		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i]);
			if (i < in.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("冒泡排序循环次数:" + num);
		System.out.println("移动次数：" + upnum);
		System.out.print("\n\n\n");
		;
	}
}
