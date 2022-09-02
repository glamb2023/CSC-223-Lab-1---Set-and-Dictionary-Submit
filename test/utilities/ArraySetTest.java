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

	@Test
	void testArraySet() {
		//making sure ArraySet is populated
		ArraySet<Integer> testArr = populateArray1_100();
		for (int i =0; i < ARRAY_CONSTANT; i++) {
			testArr.add(i);
		}
		assertFalse(testArr.isEmpty());
		assertTrue(testArr.size()==ARRAY_CONSTANT);
	}

	@Test
	void testArraySetCollectionOfE()
	{
		//testing initialization of ArraySet with Collection
		Collection<Integer> col  = populateCollection1_50();
		ArraySet<Integer> testArr = new ArraySet<Integer>(col);
		assertTrue(testArr.size()==COLLECTION_CONSTANT);
		assertTrue(testArr.containsAll(col));

	}

	@Test
	void testAddE()
	{
		ArraySet<Integer> testArr = populateArray1_100();
		assertFalse(testArr.isEmpty());

		//making sure it can't add duplicates
		for (int i =0; i < ARRAY_CONSTANT; i++) {
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
		//adding collection to empty ArraySet
		arr.addAll(col);
		assertTrue(arr.size() == COLLECTION_CONSTANT);
		assertTrue(arr.containsAll(col));

		//re-adding same collection to make sure no duplicates
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

		for (int i = 50; i < ARRAY_CONSTANT; i++) {
			assertTrue(testArr.contains(i));
		}
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{

		ArraySet<Integer> testArr = new ArraySet<>();
		Collection<Integer> testCollection = populateCollection1_50();
		for (int i = 50; i<60; i++) {
			testArr.add(i);
		}
		testArr.addAll(0, testCollection);
		assertTrue(testArr.size()==60);
		//making sure everything is at proper index
		for (int i =0; i<50; i++) {
			assertTrue(testArr.get(i)==i);
		}
		testArr.clear();
		testCollection.clear();
		
		//adding back values with a duplicate and putting a collection at specified index
		testArr.add(5);
		testArr.add(3);
		testArr.add(7);
		testCollection.add(5);
		testCollection.add(4);
		testCollection.add(6);
		testArr.addAll(1, testCollection);
	
		assertTrue(testArr.size()==5);
		//making sure it is now in updated index
		assertTrue(testArr.get(3)==3);

	}
}
