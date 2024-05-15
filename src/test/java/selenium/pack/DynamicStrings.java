package selenium.pack;

import org.apache.commons.lang3.RandomStringUtils;

public class DynamicStrings {
	
	public static void main(String[] args) {
		
	
	String s=RandomStringUtils.randomAlphabetic(10); //random alphabets with dynamic string output for each execution
	
	String s1=RandomStringUtils.randomAlphanumeric(10);
	
	System.out.println(s);
	
	System.out.println(s1);
	
}
}
