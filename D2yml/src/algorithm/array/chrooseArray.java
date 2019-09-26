package algorithm.array;

public class chrooseArray {
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{68,11,58,85,42};
		chooseArray(arr);
		
	}
	public static void chooseArray(Integer[] in) {
		int tem = 0;
		int num = 0;
		int upnum = 0;
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in.length - 1; j++) {
				num++;
				if (in[j + 1] < in[j]) {
					tem = in[j + 1];
					in[j + 1] = in[j];
					in[j] = tem;
					upnum++;
				}
			}
		}
		for (int k = 0; k < in.length; k++) {
			System.out.print(in[k]);
			if (k < in.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("选择排序循环次数:" + num);
		System.out.println("移动次数：" + upnum);
		System.out.print("\n\n\n");
	}
	public void insert(Integer[] i){
		for (int j = 0; j < i.length; j++) {
			for (int j2 = 0; j2 < i.length-1; j2++) {
				
			}
		}
	}

}
