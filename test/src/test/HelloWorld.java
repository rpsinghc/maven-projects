package test;

import java.util.BitSet;

public class HelloWorld {
	public static void main(String[] args) {
		
		BitSet a  = BitSet.valueOf(new byte[(byte)'A']);
		print(a);
		
		BitSet u  = BitSet.valueOf(new byte[(byte)'U']);
		print(u);
		
		BitSet d  = BitSet.valueOf(new byte[(byte)'D']);
		print(d);
	}
	
	
	private static void print(BitSet bs) {
	
		System.out.println(bs.toString());
	}

}
