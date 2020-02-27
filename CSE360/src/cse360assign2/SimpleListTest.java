/**
 * The following file tests the file SimpleList.java in 
 * a multitude of ways to confirm SimpleList works correctly.
 * The following test file makes sure exceptions are handled properly 
 * within individual methods and that the code will not produce any
 * unexcepted errors.
 * 
 * @author Dallas Maddox 
 * @classID 343
 * @assignment 1
*/

package cse360assign2;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class SimpleListTest {

	@Test
	public void testSimpleList() 
	{
		SimpleList testList = new SimpleList();
		assertNotNull(testList);
	}
	
	
	@Test
	public void testAddSuccess()
	{
		SimpleList testList = new SimpleList();
		testList.add(10);
		testList.add(9);
		testList.add(8);
		assertEquals(testList.toString(), "8 9 10");
	}
	
	@Test
	public void testAddLastNumberFallsOff()
	{
		SimpleList testList = new SimpleList();
		testList.add(10);
		testList.add(9);
	    testList.add(8);
	    testList.add(7);
	    testList.add(6);
	    testList.add(5);
	    testList.add(4);
	    testList.add(3);
	    testList.add(2);
	    testList.add(1);
	    testList.add(0);
	    assertEquals(testList.toString(), "0 1 2 3 4 5 6 7 8 9 10");
	} 
	
	@Test
	public void testRemoveSuccess() 
	{
		SimpleList testList = new SimpleList();
		testList.add(6);
		testList.add(10);
		testList.remove(6);
		assertEquals(testList.toString(), "10");
		
	}
	
	@Test(expected=NullPointerException.class) 
	public void testRemoveFailWithException()
	{
	
		SimpleList testList = new SimpleList();
		testList.add(10);
		testList.remove(10);
		testList.remove(9);
		
	}
	
	@Test
	public void testCountSuccess() 
	{
		SimpleList testList = new SimpleList();
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.remove(8);
		int testCount = testList.count();
		assertEquals(testCount, 2);
	}
	
	@Test
	public void testCountNoList() 
	{
		SimpleList testList = new SimpleList();
		int testCount = testList.count();
		assertEquals(testCount, 0);
	}
	
	@Test
	public void testCountTooManyAdded()
	{
		SimpleList testList = new SimpleList();
		testList.add(10);
		testList.add(9);
	    testList.add(8);
	    testList.add(7);
	    testList.add(6);
	    testList.add(5);
	    testList.add(4);
	    testList.add(3);
	    testList.add(2);
	    testList.add(1);
	    testList.add(0);
	    int testCount = testList.count();
	    assertEquals(testCount, 11);
	}
	
	@Test
	public void testToString()
	{
		SimpleList testList = new SimpleList();
		testList.add(8);
		testList.add(9);
		testList.add(10);
		String testString = testList.toString();
		assertEquals(testString, "10 9 8");
	}
	
	@Test
	public void testToStringNoList()
	{
		SimpleList testList = new SimpleList();
		String testString = testList.toString();
		assertEquals(testString, "");
	}
	
	@Test
	public void testSearch()  //
	{
		SimpleList testList = new SimpleList();
		testList.add(8);
		testList.add(9);
		testList.add(10);
		int findIndex = testList.search(8);
		assertEquals(2, findIndex);	
	}
	
	@Test(expected=NullPointerException.class) //
	public void testSearchNotFound()
	{
		SimpleList testList = new SimpleList();
		int findIndex = testList.search(1);
	}

}
