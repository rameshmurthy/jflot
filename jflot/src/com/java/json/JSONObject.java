package com.java.json;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An object is an unordered set of name/value pairs. An object begins with { (left brace) and ends with } (right brace).
 * Each name is followed by : (colon) and the name/value pairs are separated by , (comma).
 * Represents a JSON object. A JSON object consists of a set of properties.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public abstract class JSONObject extends JSONValue {

	private Map<String,JSONValue> members = new LinkedHashMap<String,JSONValue>();

	public JSONObject() {

	}

	protected abstract void loadDefaultOptionsMap();

	protected void put(String key, String value) {
		if(value == null) {
			members.put(key, JSONNull.INSTANCE);
			return;
		}
		members.put(key, new JSONString(value));
	}

	protected void put(String key, Number value) {
		if(value == null)
			members.put(key, JSONNull.INSTANCE);
		else
			members.put(key, new JSONNumber(value));
	}

	protected void put(String key, boolean value) {
		members.put(key, JSONBoolean.getInstance(value));
	}

	protected void put(String key, JSONValue value) {
		members.put(key, value);
	}

	/**
	 * Gets the JSONValue associated with the specified property.
	 * 
	 * @param key the property to access
	 * @return the value of the specified property, or <code>null</code> if the
	 *         property does not exist
	 * @throws NullPointerException if key is <code>null</code>
	 */
	protected JSONValue get(String key) {
		if (key == null) {
			throw new NullPointerException();
		}
		return members.get(key);
	}

	/**
	 * Converts a JSONObject into a JSON representation.
	 * Ex: { show:true, color : #5434FF, borderWidth: 2 }
	 * last part of the value pairs should not append comma (,)
	 * @return a JSON string representation of this JSONObject instance
	 */
	@Override
	public String toString() {
		StringBuffer jsonBuffer = new StringBuffer("{");
		if(members.size() > 0) {
			for(Map.Entry<String, JSONValue> optKeyVal : members.entrySet()){
				jsonBuffer.append(optKeyVal.getKey()+": "+optKeyVal.getValue().toJSONString());
				jsonBuffer.append(",");
			}
			jsonBuffer.deleteCharAt(jsonBuffer.lastIndexOf(","));
		}
		jsonBuffer.append("}");
		return jsonBuffer.toString();
	}

	/**
	 * Returns <code>true</code> if <code>other</code> is a {@link JSONObject}
	 * wrapping the same underlying object.
	 */
	@Override
	public boolean equals(Object o) {
		return (o == this) || (o instanceof JSONObject
				&& ((JSONObject) o).members.equals(members));
	}

	@Override
	public int hashCode() {
		return members.hashCode();
	}

	/**
	 * Returns <code>this</code>, as this is a JSONObject.
	 */
	@Override
	public JSONObject isObject() {
		return this;
	}
}
