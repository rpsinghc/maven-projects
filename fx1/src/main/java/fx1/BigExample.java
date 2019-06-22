package fx1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigExample {

	public static void main(String[] args) {
		BigDecimal one = new BigDecimal(3888888);
		BigDecimal sec = new BigDecimal(3.026);
		MathContext mc = new MathContext(0);
		BigDecimal result = one.multiply(sec,mc).setScale(-53,RoundingMode.HALF_UP);
		//result.setScale(2,RoundingMode.HALF_UP);
		System.out.println(result);
//    System.out.print(myObject);
	}
}