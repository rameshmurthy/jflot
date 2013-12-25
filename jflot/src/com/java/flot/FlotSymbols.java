package com.java.flot;

import com.java.flot.series.FlotPointSeries.PointSymbol;
import com.java.json.JSONArray;

/**
 * symbols used for drawing point flot graphs.
 * <code>JSONArray</code>
 * <br>
 * Ex: symbols: ["circle","square","diamond","triangle","cross"]
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotSymbols extends JSONArray {
	
	/**
	 * symbols used for drawing point flot graphs.
	 */
	public FlotSymbols() {

	}
	
	/**
	 * adds "circle", "square"0, "diamond", "triangle" and "corss" symbols. 
	 */
	public void addAllSymbols() {
		add(PointSymbol.CIRCLE.getSymbol());
		add(PointSymbol.SQUARE.getSymbol());
		add(PointSymbol.DIAMOND.getSymbol());
		add(PointSymbol.TRIANGLE.getSymbol());
		add(PointSymbol.CROSS.getSymbol());
	}
	/**
	 * 
	 * @param pointSymbol
	 */
	public void pushSymbol(PointSymbol pointSymbol) {
		add(pointSymbol.getSymbol());
	}

}
