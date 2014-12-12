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
			{0, 3, 0}};sfù
	}
}