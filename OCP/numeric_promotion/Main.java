public class Main {

	public static void main(String[] args) {
		short s = 10;
		byte b = 2;
		byte c = 4;
		s = (short) (s + b); //Conversion of s and b to int -> conversion of the result to short has to be carried out by explicit casting due to possibly lossy conversion!
		byte d = (byte) (b + c); //The rule mentioned above holds even if both oprands have the same type... Kind of lame...
		long l = 1_000_000_000_000_000_000l; //You have to remember about the l, becaouse java will thing it is to big of a int.
		float f = 0.1f; //You have to remember about the f, because java cannot figure out you are not thinking of a double - lossy conversion!
		double e = 0.1;
		f = l + f; //f will hold complete garbage, but compiler won't complain.
		e = e + l; //e will hold 10E17, 0.1 will be naturally dropped due to binary representation boundries.
		System.out.println(s + " " + d + " " + l + " " + f + " " + e);

		long ll = 10; //It is fine, 10 literal is interpreted as int and a promotion to long happens.
		//long lll = 3000000000; //Not OK! Java tries first to interpret the literal as int! You have to add L postfix!
		long lll = 30000000000L;

		float ff = 10;//Fine, int -> float is promoted without loss of data.
		//float fff = 1.0;// 1.0 is interpreted as double and double -> float may be lossy!
	}
}
