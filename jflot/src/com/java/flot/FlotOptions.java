package com.java.flot;

import com.java.json.JSONObject;

/**
 * It is a subclass of {@link JSONObject}
 * All Flot options class has to extend this class.
 * On construction it loads default values by calling <code>loadDefaultOptionsMap()</code>
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public abstract class FlotOptions extends JSONObject {

	public FlotOptions() {
		loadDefaultOptionsMap();
	}

	protected abstract void loadDefaultOptionsMap();
}
