/**
 * The following file creates a list which can hold up to 10 integers.
 * Integers may be removed, searched for, or converted to a string for easy display.
 * A count of current number of elements in the list may also be returned.
 * <p>
 * The class SimpleList first declares an int array list used to manipulate
 * the list throughout the class. As well as an integer count 
 * to keep track of the number of elements in the array for easy 
 * manipulation of list in the following methods.
 * 
 * @author Dallas Maddox
 * @classID 343
 * @assignment 1
*/
package cse360assign2;
import java.util.*;

public class SimpleList 
{
  private int list[];
  private int count;
  
  /**
   *  Initializes list to hold up to 10 integers. Also initializes count
   *  to 0 since there are no current elements in the list during initliazation.
  */
  public SimpleList()
  {
     this.count = 0;
     list = new int[10];
  }

  /**
   * If there are no current elements in list the method adds the new number
   * to the beginning of the list and increases the count by 1.
   * If there are less than 10 (the max) number of elements in the list
   * the method shifts all current elements to the right and adds
   * the new number in the first position to the far left.
   * If there are already 10 elements in the list, we use a seperate if 
   * statement to avoid a NullPointException, and allow the elements to
   * the far right to be overwritten by the elements shifting to the right.
   * We then add the new number to the beginning of the list.
   * 
   * @param newNum	the integer to be added to the list
   */
  public void add(int newNum)
  {
     if (count == 0)
     {
         list[0] = newNum;
         count++;
     }	 
     else if (count < 10)
     {
         for(int index = count - 1; index >= 0; index--)
         {
             list[index+1] = list[index];
         }
         list[0] = newNum;
         count++;
     }
     else
     {
         for(int index = count - 2; index >= 0; index--)
         {
             list[index+1] = list[index];
         }
         list[0] = newNum;
     } 
  }
  /**
   * If there are no numbers currently in the list a NullPointerException is thrown.
   * If the number is not found in the list, using the search method, the following
   * if statements do not execute and the method exits.
   * If the number to be removed is found at the end, the count of numbers
   * in the list is reduced by 1.
   * If the number to be removed is found anywhere else in the list,
   * the numbers after it are shifted to the left, the number is removed,
   * and the count is reduced by 1.
   * 
   * @param removeNum the number to be removed from the list 
   */
  public void remove(int removeNum)
  {
	 if (count == 0)
	 {
		 throw new NullPointerException();
	 }
	 int toFind = search(removeNum);
	 if (toFind != -1)
	 {
		 if (toFind == count - 1)
		 {
			 count--;
		 }
		 else
		 {
			 for(int index = toFind; index < count - 1; index++)
			 {
				 list[index] = list[index + 1];
			 }
			 count--;
		 } 
		 
	  }
  }
  
  /**
   * The following method returns the current count that represents
   * the number of elements in the list. This number will be 
   * between 0 and 10.
   * 
   * @return the number of elements in list returned as an integer
   */
  public int count()
  {
     return count;
  }
  
  /**
   * If there are currently no elements in the list the method will
   * print an empty list.
   * Else, the numbers in the list will be printed to numString from
   * left to right with spaces in between. The last number will
   * be printed without a space. 
   * This final list of number represented in a string is then returned.
   * 
   * @return a string representing the numbers in the list from left to right
   */
  public String toString()
  {
	  String numString = "";
	  if (count == 0)
	  {
		  numString = "";
	  }
	  else
	  {
		  for (int index = 0; index < count - 1; index++)
		  {
			  numString = numString + list[index] + " ";		  
		  }
		  numString = numString + list[count - 1];
	  }
	  return numString;
  }

  /**
   * If the list is currently empty, the method throws a NullPointerException.
   * If the list consists of elements, and the element being searched for
   * is found within the list, the index of the element is returned.
   * Useful for the remove method above.
   * 
   * @param toFind  the number to be searched for within the list
   * @return 		the index of where the number is in the list
   * 				is returned if the number is found within.
   * 				If the number is not found returns -1
   * 				@see public void remove(int removeNum) method
   */
  public int search(int toFind)
  {
	  if (count == 0)
	  {
		  throw new NullPointerException();
	  }
	  for (int index = 0; index < count; index++)
	  {
		  if (list[index] == toFind)
		  {
			  return index;
		  }
	  } 
	  return -1;	  
  }

}