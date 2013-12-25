package com.java.flot;

/**
 * 
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public enum FlotAlignment {

	LEFT("left"),
	CENTER("center"),
	RIGHT("right");
	
	private final String align;
	
	FlotAlignment(String align) {
		this.align = align;
	}
	
	@Override
	public String toString() {
		return align;
	}
	
	public String getAlignment() {
		return align;
	}
}
