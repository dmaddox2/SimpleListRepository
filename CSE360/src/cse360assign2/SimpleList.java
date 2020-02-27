/**
 * The following file creates an list that initially can hold 10 integers.
 * Integers may be removed, searched for, or converted to a string for easy display.
 * If the list is full its size is increased by 50%. If there is 
 * more than 25% empty spaces in the list, its size will be 
 * reduced by 25%. A count of current number of elements 
 * in the list may also be returned.
 * <p>
 * The class SimpleList first declares an int array list used to manipulate
 * the list throughout the class. As well as an integer count 
 * to keep track of the number of elements in the array for easy 
 * manipulation of list in the following methods.
 * 
 * @author Dallas Maddox
 * @classID 343
 * @assignment 2
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
   * This method adjust the size of the array using a temporary array
   * that is set to the required size, 50% larger, or 25% smaller than
   * orignial list, rounded down.
   * The list is copied to the larger or smaller temporary array.
   * List is set to tempList.
   * 
   * @param changeSize 	the size of increase or decrease of the list
   */
   public void adjustSize(int changeSize)
   {
	  int tempList[] = new int[changeSize];
	  for (int index = 0; index < count; index++)
	  {
		  tempList[index] = list[index];
	  }
	  
	  list = tempList;	  
   }

  /**
   * If the list is currently full, the adjustSize method is called
   * to increase the size of the list by 50%.
   * Otherwise this statement is surpassed.
   * The method then shifts all elements currently in the list 
   * over to the right.
   * The new element is then added to the beginning of the list.
   * 
   * @param newNum	the integer to be added to the list
   */
   public void add(int newNum) 
   {
     if (count == list.length)
     {
    	 int increaseSize = count + (count/2);
    	 adjustSize(increaseSize);
     }
     
     for (int index = count; index > 0; index--)
     {
    	 list[index] = list[index-1];
     }
     
     list[0] = newNum;
     count++;
	  
   }
   /**
    * If there are no numbers currently in the list a NullPointerException is thrown.
    * If the number is not found in the list, using the search method, the following
    * if statements do not execute and the method exits.
    * If the number to be removed is found anywhere  in the list,
    * the numbers after it are shifted to the left, the number is removed,
    * and the count is reduced by 1.
    * If the count is less than 25% of the size of the array, after 
    * the last element was removed, the array is shrank by 25%
    * using the adjustSize function.
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
 	   if (count > 1)
 	   {
 		   if (count < (list.length*3)/4)
 		   {
 		 		adjustSize((list.length*3)/4);
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