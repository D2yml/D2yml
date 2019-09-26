package DyUtil.CheckUtil;

public class checkIP {
	public static boolean checkIP(String ip) {
		ip = ip.trim();
		if (ip != null && !ip.isEmpty()) {
			String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
			if (ip.matches(regex)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(checkIP("123.131.99.137"));
	}
}
