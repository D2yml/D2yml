package algorithm.array;

public class insertArray {
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{68,11,58,85,42};
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * (100));
//			System.out.print(" "+arr[i]);
//		}
		System.out.println();
		insertArray(arr);
		
	}
	public static void insertArray(Integer[] in) {
		int tem = 0;
		int num = 0;
		int upnum = 0;
		for (int i = 0; i < in.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				num++;
				if (in[j + 1] < in[j]) {
					tem = in[j + 1];
					in[j + 1] = in[j];
					in[j] = tem;
					upnum++;
				} else {
					break;
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
		System.out.println("插入排序循环次数:" + num);
		System.out.println("移动次数：" + upnum);
		System.out.print("\n\n\n");
	}
}


