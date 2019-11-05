class testdriver2 {
	
	public static boolean isStringInArray(String str, String[] arr) {
		boolean retVal = false;
		
		if (str != null && arr != null) {
			for (String anArr : arr) {
				if (str.equals(anArr)) {
					retVal = true;
				}
			}
		}
		return retVal;
	}

	public static boolean containsDigit(String test) {
		if (test != null) {
			for (char c : test.toCharArray()) {
				if (Character.isDigit(c)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("HelloWorld! this is new");
		testdriver2 test1 = new testdriver2();
		String[] array = {"Sam","Wright"};
		String sam = "Sam";
		System.out.println(test1.isStringInArray(sam, array));
		System.out.println(test1.containsDigit(sam));
		
	}
}

