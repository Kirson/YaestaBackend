package com.yaesta;

public class TestUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "(-158-) 400088501282";
		System.out.println(input);
		String out1[] = input.split("\\(-");
		System.out.println(out1[1]);
		String out2[] = out1[1].split("-\\)");
		
		System.out.println(out2[0]);

	}

}
