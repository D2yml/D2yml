package DyUtil.CheckUtil;

public class CheckEmail {
	// private static final String MATCH =
	// "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
	private static final String MATCH = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

	public static boolean checkEmail(String email) {
		email = email.trim();
		try {
			if (email == null) {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}

		if (email.matches(MATCH)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkEmail(" d2tml123@163.com "));
	}
}
