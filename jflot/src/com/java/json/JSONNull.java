package com.java.json;



/**
 * A class representing a JSONNull {@code null} value.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public final class JSONNull extends JSONValue {
	/**
	 * singleton for JsonNull
	 *
	 */
	public static final JSONNull INSTANCE = new JSONNull();

	/**
	 * Creates a new JsonNull object.
	 * Deprecated since Gson version 1.8. Use {@link #INSTANCE} instead
	 */
	public JSONNull() {
		// Do nothing
	}

	/**
	 * All instances of JsonNull have the same hash code since they are indistinguishable
	 */
	@Override
	public int hashCode() {
		return JSONNull.class.hashCode();
	}

	/**
	 * All instances of JsonNull are the same
	 */
	@Override
	public boolean equals(Object other) {
		return this == other || other instanceof JSONNull;
	}

	/**
	 * Returns <code>this</code>, as this is a JSONNull.
	 */
	@Override
	public JSONNull isNull() {
		return this;
	}

	/**
	 * Returns "null" to allow for formatting <code>null</code> values.
	 */
	@Override
	public String toString() {
		return "null";
	}
}
