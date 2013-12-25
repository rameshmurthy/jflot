package com.java.json;



/**
 * Represents a JSON string.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class JSONString extends JSONValue {

	private String value;

	/**
	 * Creates a new JSONString from the supplied String.
	 * 
	 * @param value a String value
	 * @throws NullPointerException if <code>value</code> is <code>null</code>
	 */
	public JSONString(String value) {
		if (value == null) {
			throw new NullPointerException();
		}
		//to consider special cases like zoomRange : [0.1,10] where it should not insert the value as '[0.1,10]'
		//for FlotLegend  setContainer("$(\"#legend\")") method, jquery selector is passed which has $ and for this also ' should not be added.
		if(value.contains("$") || value.contains("["))
			this.value = value;
		else
			this.value = "'"+value+"'";
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof JSONString)) {
			return false;
		}
		return value.equals(((JSONString) other).value);
	}

	@Override
	public int hashCode() {
		// Just use the underlying String's hashCode.
		return value.hashCode();
	}

	/**
	 * Returns <code>this</code>, as this is a JSONString.
	 */
	@Override
	public JSONString isString() {
		return this;
	}

	/**
	 * Returns the raw Java string value of this item.
	 */
	public String stringValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
