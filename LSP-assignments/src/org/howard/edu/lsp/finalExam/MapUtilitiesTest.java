package org.howard.edu.lsp.finalExam;
import org.howard.edu.lsp.finalExam.MapUtilities;
import org.howard.edu.lsp.finalExam.NullMapException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapUtilitiesTest {
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs standard input")
	public void standard() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		assertEquals(2, MapUtilities.commonKeyValuePairs(first, second));	
	}

	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs first input 0")
	public void firstZero() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		first.clear();
		assertEquals(0, MapUtilities.commonKeyValuePairs(first, second));
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs second input 0")
	public void secondZero() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		second.clear();
		assertEquals(0, MapUtilities.commonKeyValuePairs(first, second));	
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs both input 0")
	public void bothZero() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		first.clear();
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		second.clear();
		assertEquals(0, MapUtilities.commonKeyValuePairs(first, second));	
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs first input null")
	public void firstNull() throws NullMapException {
		HashMap<String, String> first = null;
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		
		Exception exception = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(first, second);
		});
	
		String expectedMessage = "One or both maps are null!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs second input null")
	public void secondNull() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		
		HashMap<String, String> second = null;
		
		Exception exception = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(first, second);
		});
	
		String expectedMessage = "One or both maps are null!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs both input null")
	public void bothNull() throws NullMapException {
		HashMap<String, String> first = null;
		
		HashMap<String, String> second = null;
		
		Exception exception = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(first, second);
		});
	
		String expectedMessage = "One or both maps are null!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs mixed case keys/values")
	public void mixedCase() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("mary", "ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "happy");
		
		assertEquals(2, MapUtilities.commonKeyValuePairs(first, second));
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs first input longer")
	public void firstLonger() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		first.put("Rachel", "Sad");
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		
		assertEquals(2, MapUtilities.commonKeyValuePairs(first, second));
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs second input longer")
	public void secondLonger() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		second.put("Rachel", "Sad");
		
		assertEquals(2, MapUtilities.commonKeyValuePairs(first, second));
		}
	
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs third common key/value pair")
	public void thirdInCommon() throws NullMapException {
		HashMap<String, String> first = new HashMap<String, String>();
		first.put("Alice", "Healthy");
		first.put("Mary", "Ecstatic");
		first.put("Bob", "Happy");
		first.put("Chuck", "Fine");
		first.put("Felix", "Sick");
		first.put("Ricardo", "Superb");
		
		
		HashMap<String, String> second = new HashMap<String, String>();
		second.put("Mary", "Ecstatic");
		second.put("Felix", "Healthy");
		second.put("Ricardo", "Superb");
		second.put("Tam", "Fine");
		second.put("Bob", "Happy");
		
		assertEquals(3, MapUtilities.commonKeyValuePairs(first, second));
		}


}