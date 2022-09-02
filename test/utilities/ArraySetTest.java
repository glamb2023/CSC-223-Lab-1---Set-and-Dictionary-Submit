package utilities;

/**
 * @author taterosen & georgelamb
 * @date 09/02/2022
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	static final int ARRAY_CONSTANT = 100;
	static final int COLLECTION_CONSTANT = 50;

	/**
	 * Creates and populates an ArraySet with 100 integer
	 * values (1-100).
	 */
	public ArraySet<Integer> populateArray1_100() {
		ArraySet<Integer> arrInt = new ArraySet<Integer>();
		for (int i = 0; i < ARRAY_CONSTANT; i++) {
			arrInt.add(i);
		}
		return arrInt;
	}

	/**
	 * Creates and populates a collection with fifty integer
	 * values (1-50).
	 */ 
	public Collection<Integer> populateCollection1_50(){
		Collection<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < COLLECTION_CONSTANT; i++) {
			col.add(i);
		}
		return col;
	}

	/**
	 * Creates and populates an ArraySet with several string
	 * values.
	 */
	public ArraySet<String> populateString() {
		ArraySet<String> arrString = new ArraySet<String>();
		arrString.add("Dog");
		arrString.add("Cat");
		arrString.add("Mouse");
		arrString.add("Rat");
		arrString.add("Moose");
		return arrString;
	}
	
	@Test
	void testFullArraySet() {
		ArraySet<Integer> testArr = populateArray1_100();
		for (int i =0; i < ARRAY_CONSTANT; i++) {
			testArr.add(i);
		}
		assertFalse(testArr.isEmpty());
		assertTrue(testArr.size()==100);
	}
	
	@Test
	void testArraySetCollectionOfE()
	{
		
		
	}
	
	@Test
	void testAddE()
	{
		ArraySet<Integer> testArr = populateArray1_100();
		assertFalse(testArr.isEmpty());
		
		//making sure it can't add duplicates
		for (int i =0; i < 100; i++) {
			testArr.add(i);
		}
		assertFalse(testArr.isEmpty());
		assertTrue(testArr.size()==ARRAY_CONSTANT);

		//make sure it can continue adding new numbers (negative as well)
		testArr.add(100);
		testArr.add(-10);
		assertTrue(testArr.size()==102);
		
		assertTrue(testArr.contains(-10));
		assertTrue(testArr.contains(100));
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
		ArraySet<Integer> arr = new ArraySet<Integer>();
		Collection<Integer> col = populateCollection1_50();
		
		arr.addAll(col);
		assertTrue(arr.size() == COLLECTION_CONSTANT);
		assertTrue(arr.containsAll(col));
		
	}
	
	
	@Test
	void testRetainAll()
	{

		ArraySet<Integer> testArr = populateArray1_100();
		Collection<Integer> testCollection = populateCollection1_50();
		testArr.retainAll(testCollection);

		//making sure it only retains 1-50
		assertTrue(testArr.size()==COLLECTION_CONSTANT);
		assertFalse(testArr.contains(COLLECTION_CONSTANT));
		assertTrue(testArr.contains(0));
		for (int i = 0; i < 50; i++) {
			assertTrue(testArr.contains(i));
		}

	}

	@Test
	void testRemoveAll()
	{
		ArraySet<Integer> testArr = populateArray1_100();
		Collection<Integer> testCollection = populateCollection1_50();
		testArr.removeAll(testCollection);

		//testing to see if the collection numbers were removed
		assertTrue(testArr.size()==COLLECTION_CONSTANT);
		assertFalse(testArr.contains(49));
		assertFalse(testArr.contains(100));

		for (int i = 50; i < 100; i++) {
			assertTrue(testArr.contains(i));
		}
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		
	}
}
