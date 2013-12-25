package com.java.json;


/**
 * Represents a JSON boolean value.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class JSONBoolean extends JSONValue {

	private static final JSONBoolean FALSE = new JSONBoolean(false);
	private static final JSONBoolean TRUE = new JSONBoolean(true);

	/**
	 * Gets a reference to the singleton instance representing either
	 * <code>true</code> or <code>false</code>.
	 * 
	 * @param b controls which value to get
	 * @return if <code>true</code>, the JSONBoolean instance representing
	 *         <code>true</code> is returned; otherwise, the JSONBoolean
	 *         instance representing <code>false</code> is returned
	 */
	public static JSONBoolean getInstance(boolean b) {
		if (b) {
			return TRUE;
		} else {
			return FALSE;
		}
	}

	private final boolean value;

	/*
	 * This private constructor is used to build true and false.
	 */
	private JSONBoolean(boolean value) {
		this.value = value;
	}

	/**
	 * Returns <code>true</code> if this is the instance representing "true",
	 * <code>false</code> otherwise.
	 */
	public boolean booleanValue() {
		return value;
	}

	/**
	 * Returns <code>this</code>, as this is a JSONBoolean.
	 */
	@Override
	public JSONBoolean isBoolean() {
		return this;
	}

	/**
	 * Returns "true" for the true value, and "false" for the false value.
	 */
	@Override
	public String toString() {
		return Boolean.toString(value);
	}
}
