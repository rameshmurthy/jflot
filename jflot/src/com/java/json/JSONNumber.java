package com.java.json;


/**
 * Represents a JSON number. Numbers are represented by <code>double</code>s.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class JSONNumber extends JSONValue {

	private Number value;

	/**
	 * Creates a new JSONNumber from the double value.
	 */
	public JSONNumber(Number value) {
		this.value = value;
	}

	/**
	 * Gets the value of this JSONNumber represents.
	 */
	public Number getValue() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof JSONNumber)) {
			return false;
		}
		return value == ((JSONNumber) other).value;
	}

	@Override
	public int hashCode() {
		// Just use the underlying double's hashCode.
		return value.hashCode();
	}

	/**
	 * Returns <code>this</code>, as this is a JSONNumber.
	 */
	@Override
	public JSONNumber isNumber() {
		return this;
	}

	/**
	 * Returns the JSON representation of this number.
	 */
	@Override
	public String toString() {
		return value.toString();
	};
}
