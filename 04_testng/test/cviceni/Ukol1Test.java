package cviceni;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ukol1Test {

	@Test
	public void testFaktorial1() {
		Assert.assertEquals(Ukol1.faktorial(0), 1);
		Assert.assertEquals(Ukol1.faktorial(1), 1);
	}
	
	//test pro záporný vstup (vyhodí vyjimku IllegalArgumentException)
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testFaktorial2() {
		Ukol1.faktorial(-1);
	}
	
	
	@Test(groups = "todo")
	public void testFaktorial3() {
		throw new UnsupportedOperationException("Zatim neimplementovano");
	}
}
