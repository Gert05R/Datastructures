/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<String> shortList2;
	MyLinkedList<String> shortList3;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> list2;
	MyLinkedList<Integer> list3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		list3 = new MyLinkedList<Integer>();
		shortList3 = new MyLinkedList<String>();
		shortList3.add(0, "A");
		shortList3.add(1, "B");
		shortList3.add(2, "C");
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		String b = shortList3.remove(2);
		assertEquals("Remove: check b is correct ", "C", b);
		assertEquals("Remove: check element 0 is correct ", "B" , shortList3.get(1));
		assertEquals("Remove: check size is correct ", 2, shortList3.size());
		
		try {
			shortList3.remove(10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		list2 = new MyLinkedList<Integer>();
		shortList2 = new MyLinkedList<String>();
			Integer gList = 2000;
			for (int i=0; i<gList; i++) 
			{
				//try {
				
				int x = i + 10;
				String s = Integer.toString(x);
				list2.add(x);
				shortList2.add(s);
				Object D= x;
				Object C = list2.get(i);
				assertEquals(D, C);
				assertEquals(s, shortList2.get(i));
				//assertEquals("Check list2", D, list2.get(i));
				//}
				//catch (NullPointerException n) {};
			}
			
			//try {
			assertEquals("Check size of list 2", 2000, list2.size);
			assertEquals("Check size of Shortlist2", 2000, shortList2.size);
			//}
			//catch (NullPointerException n) {};
			
				
			
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		
		assertEquals("Check size list2", 3, list1.size());
		assertEquals("Check size emptylist", 0, emptyList.size());
		
	
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			list3.add(-1, 22);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		list3.add(0, 24);
		Object D= 24;
		assertEquals(D,list3.get(0));
		
		
		
		try {
			list3.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		assertEquals("C",shortList3.get(2));
		
		try {
			shortList3.add(25, "D");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    shortList3.set(2, "Gert");
	    assertEquals("Gert",shortList3.get(2));
	    
	    try {
			shortList3.set(1, null);
			fail("Check null value");
		}
		catch (NullPointerException n) {
		
		}
	    
	    try {
			shortList3.set(10, "T");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
	    
	    
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
