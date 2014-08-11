package test.didia.monlift;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import me.didia.monlift.MonliftPath;

import org.junit.Test;

public class MonliftPathTest extends AbstractTest {
	
	@Test
	public void testBuildPath()
	{
		String id = "113040";
		String field = "username";
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("id", id);
		values.put("field", field);
				
		String expected = "api/" + id + "/" + field;
		assertEquals(expected, MonliftPath.buildPath(MonliftPath.USER_FIELD_PATH, values));
		
		// test with null values
		
		assertEquals(expected, MonliftPath.buildPath(id + "/" + field, null));
	}

}
