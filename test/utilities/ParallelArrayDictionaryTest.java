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

	public ParallelArrayDictionary<Integer,String> populatePAD(){
		ParallelArrayDictionary<Integer, String> PAD  = new ParallelArrayDictionary<Integer, String>();

		for (int i =0; i < 50; i++) {
			PAD.put(i, "Test" + i);
		}
		return PAD;
	}
	
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


	}
	
	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, String> PADtest = populatePAD();
		//checks non existent or null key
		assertTrue(PADtest.get(100)==null);
		assertTrue(PADtest.get(null)==null);
		
		
		//checks key for value
		for(int i =0; i < 50; i++) {
			assertTrue(PADtest.get(i).equals("Test" + i ));
		}
		
		//checks if null value can be retrieved from valid key
		PADtest.put(50, null);
		assertTrue(PADtest.get(50)==null);

	}

	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> PADtest =  populatePAD();
		assertTrue(PADtest.size()==50);
		//making sure all keys and values are there
		for(int i =0; i < 50; i++) {
			assertTrue(PADtest.containsKey(i));
			assertTrue(PADtest.containsValue("Test"+i));
		}
		
		//make sure can't add duplicate keys
		for (int i =0; i < 50; i++) {
			PADtest.put(i, "Test" + i);
		}
		assertTrue(PADtest.size()==50);
		
		//add new key/value
		PADtest.put(50, "New Value");
		assertTrue(PADtest.size()==51);
		assertTrue(PADtest.containsKey(50));
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
		assertTrue(PADtest.remove(50)==null);
		assertTrue(PADtest.remove(null)==null);
		
		//check that value is removed, but key remains
		PADtest.remove(0);
		assertTrue(PADtest.size()==50);
		
		assertTrue(PADtest._keys.size()==50);
	}
	
	@Test
	void testHash() {
		Map<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "test 1");
		hashmap.put(2, "test 2");
		hashmap.put(3, "test 3");
		assertTrue(hashmap.size()==3);
		hashmap.remove(1);
		assertFalse(hashmap.containsKey(1));
		assertTrue(hashmap.size()==2);
		
	}

	@Test
	void testPutAll()
	{
	Map<Integer, String> hashmap = new HashMap<Integer, String>();
	hashmap.put(1, "test 1231");
	hashmap.put(2, "test 122");
	hashmap.put(3, "test 123");
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