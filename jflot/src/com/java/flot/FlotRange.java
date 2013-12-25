package com.java.flot;

/**
 * This class defines range of the axis lines on the graph
 * Creates java script :
 * <p>
 * {from: 0.75, to: 1.5}
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotRange extends FlotOptions {
	
	public FlotRange(double from, double to) {
		put("from", from);
		put("to", to);
	}

	public void setFrom(double from) {
		put("from", from);
	}
	
	public String getFrom() {
		return get("from").toJSONString();
	}

	public void setTo(double to) {
		put("to", to);
	}
	
	public String getTo() {
		return get("to").toJSONString();
	}
	
	/**
	 * No default options to set.
	 */
	@Override
	protected void loadDefaultOptionsMap() {
		
	}
}
