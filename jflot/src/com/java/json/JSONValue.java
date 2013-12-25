package com.java.json;

/**
 * A value can be a string in double quotes, or a number, or true or false or null, or an object or an array. These structures can be nested.
 * <br>
 * <p>
 *  JSON (JavaScript Object Notation) is a lightweight data-interchange format. It is easy for humans to read and write. 
 *  It is easy for machines to parse and generate. It is based on a subset of the JavaScript Programming Language,
 *  Standard ECMA-262 3rd Edition - December 1999. JSON is a text format that is completely language independent but uses 
 *  conventions that are familiar to programmers of the C-family of languages, including C, C++, C#, Java, JavaScript, Perl, Python, and many others. 
 *  These properties make JSON an ideal data-interchange language.
 *  <br>
 *  <p>
 *  JSON is built on two structures:
 *  A collection of name/value pairs. In various languages, this is realized as an object, record, struct, dictionary, hash table, 
 *  keyed list, or associative array.
 *  An ordered list of values. In most languages, this is realized as an array, vector, list, or sequence.
 *  These are universal data structures. Virtually all modern programming languages support them in one form or another. 
 *  It makes sense that a data * *  format that is interchangeable with programming languages also be based on these structures.
 *  In JSON, they take on these forms:
 *  
 * <br>
 * <p>
 * The superclass of all JSON value types.
 * 
 * @see com.java.json.JSONArray
 * @see com.java.json.JSONBoolean
 * @see com.java.json.JSONNumber
 * @see com.java.json.JSONObject
 * @see com.java.json.JSONString
 * 
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public abstract class JSONValue {
	/**
	 * Not subclassable outside this package.
	 */
	JSONValue() {
	}

	/**
	 * Returns a non-null reference if this JSONValue is really a JSONArray.
	 * 
	 * @return a reference to a JSONArray if this JSONValue is a JSONArray or
	 *         <code>null</code> otherwise.
	 */
	public JSONArray isArray() {
		return null;
	}

	/**
	 * Returns a non-null reference if this JSONValue is really a JSONBoolean.
	 * 
	 * @return a reference to a JSONBoolean if this JSONValue is a JSONBoolean or
	 *         <code>null</code> otherwise.
	 */
	public JSONBoolean isBoolean() {
		return null;
	}

	/**
	 * Returns a non-null reference if this JSONValue is really a JSONNull.
	 * 
	 * @return a reference to a JSONNull if this JSONValue is a JSONNull or
	 *         <code>null</code> otherwise.
	 */
	public JSONNull isNull() {
		return null;
	}

	/**
	 * Returns a non-null reference if this JSONValue is really a JSONNumber.
	 * 
	 * @return a reference to a JSONNumber if this JSONValue is a JSONNumber or
	 *         <code>null</code> otherwise.
	 */
	public JSONNumber isNumber() {
		return null;
	}

	/**
	 * Returns non-null if this JSONValue is really a JSONObject.
	 * 
	 * @return a reference to a JSONObject if this JSONValue is a JSONObject or
	 *         <code>null</code> otherwise.
	 */
	public JSONObject isObject() {
		return null;
	}

	/**
	 * Returns a non-null reference if this JSONValue is really a JSONString.
	 * 
	 * @return a reference to a JSONString if this JSONValue is a JSONString or
	 *         <code>null</code> otherwise.
	 */
	public JSONString isString() {
		return null;
	}

	/**
	 * Dont ever call this method inside of toString() method of the same object as its implementation is just calling toString() method.
	 * @return
	 */
	public final String toJSONString() {
		return toString();
	}

	/**
	 * Returns a JSON-encoded string for this entity. Use this method to create
	 * JSON strings that can be sent from the client to a server.
	 */
	@Override
	public abstract String toString();

}

