package com.java.json;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents an array of {@link com.java.json.JSONValue} objects.
 * An array is an ordered collection of values. An array begins with [ (left bracket) and ends with ] (right bracket). 
 * Values are separated by , (comma).
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class JSONArray extends JSONValue implements Iterable<JSONValue> {

	
	private final List<JSONValue> elements;

	/**
	 * Creates an empty JsonArray.
	 */
	public JSONArray() {
		elements = new LinkedList<JSONValue>();
	}
	
	/**
	 * Adds the specified element to self.
	 *
	 * @param element the element that needs to be added to the array.
	 */
	public void add(String element) {
		if (element == null) {
			elements.add(JSONNull.INSTANCE);
			return;
		}
		elements.add(new JSONString(element));
	}
	
	/**
	 * Adds the specified element to self.
	 *
	 * @param element the element that needs to be added to the array.
	 */
	public void add(Number element) {
		if (element == null) {
			elements.add(JSONNull.INSTANCE);
			return;
		}
		elements.add(new JSONNumber(element));
	}
	
	/**
	 * Adds the specified element to self.
	 *
	 * @param element the element that needs to be added to the array.
	 */
	public void add(Boolean element) {
		if (element == null) {
			elements.add(JSONNull.INSTANCE);
			return;
		}
		elements.add(JSONBoolean.getInstance(element));
	}

	/**
	 * Adds the specified element to self.
	 *
	 * @param element the element that needs to be added to the array.
	 */
	public void add(JSONValue element) {
		if (element == null) {
			element = JSONNull.INSTANCE;
		}
		elements.add(element);
	}
	
	/**
	 * Adds all the elements of the specified list to self.
	 *
	 * @param list the list whose elements need to be added to the array.
	 */
	public void addAll(List<String> list) {
		if(list !=null && list.size() > 0) {
			for(String element : list) {
				elements.add(new JSONString(element));
			}
		}
	}

	/**
	 * Adds all the elements of the specified array to self.
	 *
	 * @param array the array whose elements need to be added to the array.
	 */
	public void addAll(JSONArray array) {
		elements.addAll(array.elements);
	}

	/**
	 * Returns the number of elements in the array.
	 *
	 * @return the number of elements in the array.
	 */
	public int size() {
		return elements.size();
	}

	/**
	 * Returns an iterator to navigate the elemetns of the array. Since the array is an ordered list,
	 * the iterator navigates the elements in the order they were inserted.
	 *
	 * @return an iterator to navigate the elements of the array.
	 */
	public Iterator<JSONValue> iterator() {
		return elements.iterator();
	}

	/**
	 * Returns the ith element of the array.
	 *
	 * @param i the index of the element that is being sought.
	 * @return the element present at the ith index.
	 * @throws IndexOutOfBoundsException if i is negative or greater than or equal to the
	 * {@link #size()} of the array.
	 */
	public JSONValue get(int i) {
		return elements.get(i);
	}

	@Override
	public boolean equals(Object o) {
		return (o == this) || (o instanceof JSONArray && ((JSONArray) o).elements.equals(elements));
	}

	@Override
	public int hashCode() {
		return elements.hashCode();
	}

	/**
	 * Create the JSON encoded string representation of this JSONArray instance.
	 * This method may take a long time to execute if the underlying array is
	 * large.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0, c = size(); i < c; i++) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append(get(i));
		}
		sb.append("]");
		return sb.toString();
	}
}
