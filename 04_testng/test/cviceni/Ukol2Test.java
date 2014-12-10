package cviceni;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Ukol2Test {
	@Test(dataProvider = "dataP")
	public void testKrat(int a, int b, int result) {
		Assert.assertEquals(Ukol2.krat(a, b), result);
	}

	@DataProvider(name = "dataP")
	public Object[][] data() {
		return new Object[][] {
			{2, 3, 6},
			{0, 3, 0},
			//tento test neprojde (špatná implementace metody Ukol2.krat)
			{-1, -1, 1},
			{1000000000, 1, 1000000000}};
	}
	
	
	/*
	 * Testování, zda jdou metody thread-safe
	 * Porovnání staticky vytvoøeného øetìzce s øetìzcem vytváøeným pomocí více vláken
	 * 
	 * StringBuilder není thread-safe
	 * StringBuffer je thread-safe
	 * */
	 
	public String string = "10";
	public StringBuilder builder = new StringBuilder();
	public StringBuffer buffer = new StringBuffer();
	
	@Test(threadPoolSize = 10, invocationCount = 1000)
	public void testBuilder() {		
		builder.append(string);
		builder.setLength(builder.length() - 1);
	}
	
	@Test(dependsOnMethods = "testBuilder")
	public void testThreadSafetyBuilder() {
		StringBuilder builder2 = new StringBuilder();
		for(int i = 0; i < 1000; i++)
		{
			builder2.append("1");
		}
		Assert.assertEquals(builder.toString(), builder2.toString());
	}
	
	@Test(threadPoolSize = 10, invocationCount = 100)
	public void testBuffer() {		

		buffer.append(string);
		buffer.setLength(buffer.length() - 1);
	}
	
	@Test(dependsOnMethods = "testBuffer")
	public void testThreadSafetyBuffer() {
			StringBuffer buffer2 = new StringBuffer();
			for(int i = 0; i < 1000; i++)
			{
				buffer2.append("1");
			}
		Assert.assertEquals(buffer.toString(), buffer2.toString());
	}
}
