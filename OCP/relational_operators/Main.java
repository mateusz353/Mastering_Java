public class Main {

	public static void main(String[] args) {

		int x = 10;
		long l = 12l;
		double d = 13.5;
		float f = 15.7f;
		short s = 50;

		System.out.println((x > l) + " " + (s > f) + " " + (d > l));


		System.out.println(true || eval());
		System.out.println(true | eval());
	}

	private static boolean eval() {
		System.out.println("Eval");
		return true;
	}
}
