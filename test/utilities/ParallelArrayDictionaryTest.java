package utilities;

/**
 * @author taterosen & georgelamb
 * @date 09/02/2022
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{

	private static final int COLLECTION_CONSTANT = 25;
	private static final int PAD_CONSTANT = 50;

	/**
	 * Creates and populates a dictionary with fifty integer
	 * keys and string values.
	 */
	public ParallelArrayDictionary<Integer,String> populatePAD(){
		ParallelArrayDictionary<Integer, String> PAD  = new ParallelArrayDictionary<Integer, String>();
		for (int i =0; i < PAD_CONSTANT; i++) {
			PAD.put(i, "Test" + i);
		}
		return PAD;
	}
	
	/**
	 * Creates and populates a collection with fifty integer
	 * values.
	 */
	public Collection<Integer> populateCollection1_50(){
		Collection<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < COLLECTION_CONSTANT; i++) {
			col.add(i);
		}
		return col;
	}
	
	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, String> PAD  = new ParallelArrayDictionary<Integer, String>();
		assertTrue(PAD.size() == 0);
		assertTrue(PAD.isEmpty());
	}
	
	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, String> PADtest = populatePAD();
		//checks non existent or null key
		assertTrue(PADtest.get(100)==null);
		assertTrue(PADtest.get(null)==null);
		
		
		//checks key for value
		for(int i =0; i < PAD_CONSTANT; i++) {
			assertTrue(PADtest.get(i).equals("Test" + i ));
		}
		
		//checks if null value can be retrieved from valid key
		PADtest.put(PAD_CONSTANT, null);
		assertTrue(PADtest.get(PAD_CONSTANT)==null);

	}

	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> PADtest =  populatePAD();
		assertTrue(PADtest.size()==PAD_CONSTANT);
		//making sure all keys and values are there
		for(int i =0; i < PAD_CONSTANT; i++) {
			assertTrue(PADtest.containsKey(i));
			assertTrue(PADtest.containsValue("Test"+i));
		}
		
		//make sure can't add duplicate keys
		for (int i =0; i < PAD_CONSTANT; i++) {
			PADtest.put(i, "Test" + i);
		}
		assertTrue(PADtest.size()==PAD_CONSTANT);
		
		//add new key/value
		PADtest.put(PADtest.size(), "New Value");
		assertTrue(PADtest.size()==51);
		assertTrue(PADtest.containsKey(PAD_CONSTANT));
		assertTrue(PADtest.containsValue("New Value"));
		
		//duplicate value for new key
		PADtest.put(51, "New Value");
		assertTrue(PADtest.size()==52);
		assertTrue(PADtest.containsKey(51));
		assertTrue(PADtest.containsValue("New Value"));
		
		//checks if null value can be put in valid key
		PADtest.put(52, null);
		assertTrue(PADtest.size()==53);
		assertTrue(PADtest.containsKey(52));
		assertTrue(PADtest.containsValue(null));
		
	}

	@Test
	void testRemove()
	{
		ParallelArrayDictionary<Integer, String> PADtest =  populatePAD();
		//makes sure invalid keys return null
		assertTrue(PADtest.remove(PADtest.size())==null);
		assertTrue(PADtest.remove(null)==null);
		
		//check that value is removed, but key remains
		PADtest.remove(0);
		assertTrue(PADtest.size()==PAD_CONSTANT);
		
		assertTrue(PADtest._keys.size()==PAD_CONSTANT);
	}

	@Test
	void testPutAll()
	{
	//making test hashmap with same keys and some different to make sure it can't add duplicates
	Map<Integer, String> hashmap = new HashMap<Integer, String>();
	hashmap.put(1, "test 1");
	hashmap.put(2, "test 2");
	hashmap.put(3, "test 3");
	hashmap.put(50, "test 1");
	hashmap.put(51, "test 2");
	hashmap.put(52, "test 3");
	ParallelArrayDictionary<Integer,String> PADtest = populatePAD();
	PADtest.putAll(PADtest);
	assertTrue(PADtest.size()==50);
	PADtest.putAll(hashmap);
	assertTrue(PADtest.size()==53);
	
	}

	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, String> PADtest =  populatePAD();
		assertTrue(PADtest.size()==50);
		PADtest.clear();
		assertTrue(PADtest.size()==0);
		PADtest = populatePAD();
		assertTrue(PADtest.size()==50);
	}
}