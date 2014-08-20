package test.didia.monlift;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import me.didia.monlift.MonliftRoutes;

import org.junit.Test;

public class MonliftRoutesTest extends AbstractTest {
	
	@Test
	public void testBuildPath()
	{
		String id = "113040";
		String field = "username";
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("id", id);
		values.put("field", field);
				
		String expected = "api/" + id + "/" + field;
		assertEquals(expected, MonliftRoutes.buildPath(MonliftRoutes.USER_FIELD_PATH, values));
		
		// test with null values
		
		assertEquals(expected, MonliftRoutes.buildPath(id + "/" + field, null));
	}

}
