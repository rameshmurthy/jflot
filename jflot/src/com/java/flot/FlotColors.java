package com.java.flot;

import java.util.List;

import com.java.json.JSONArray;

/**
 * Colors used for drawing flot graphs, listed in the order of their use.
 * <br>
 * <code>JSONArray</code>
 * <br>
 * Ex: colors: ["#4572A7", "#AA4643", "#89A54E", "#80699B", "#333333", "#058DC7", "#edc240", "#cb4b4b", "#4da74d", "#9440ed"]
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotColors extends JSONArray {

	/**
	 * Colors used for drawing flot graphs, listed in the order of their use.
	 */
	public FlotColors() {
		
	}
	
	/**
	 * adds all colors to the existing list.
	 * 
	 * @param colors
	 */
	public void addColors(List<String> colors) {
		addAll(colors);
	}
	
	/**
	 * adds color to the existing list.
	 * @param color
	 */
	public void addColor(String color) {
		add(color);
	}
	
	/**
	 * Adds 10 colors to flot chart, will be picked in the order of their listing.
	 */
	public void addDefaultColors() {
		add("#4572A7");
		add("#AA4643");
		add("#89A54E");
		add("#80699B");
		add("#333333"); 
		add("#058DC7");
		add("#edc240"); 
		add("#cb4b4b"); 
		add("#4da74d");
		add("#9440ed");
	}
}
