package cviceni;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ukol1Test {

	@Test
	public void testFaktorial1() {
		Assert.assertEquals(Ukol1.faktorial(0), 1);
		Assert.assertEquals(Ukol1.faktorial(1), 1);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testFaktorial2() {
		Ukol1.faktorial(-1);
	}
	
}
