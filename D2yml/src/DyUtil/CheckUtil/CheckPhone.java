package DyUtil.CheckUtil;
/**
 * 
 * @author D2yml
 * @Date 2019年1月12日
 *
 */
public class CheckPhone {
	private static final String MATCH = "^(13\\d|14[579]|15[^4\\D]|166|17[^49\\D]|18[^019\\D]|199)\\d{8}$";

	public static boolean checkPhone(String phone) {
		if (phone != null && phone.matches(MATCH)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(checkPhone(null));
	}
}
