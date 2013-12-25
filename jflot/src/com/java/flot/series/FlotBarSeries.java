package com.java.flot.series;

import com.java.flot.FlotAlignment;
import com.java.flot.FlotOptions;


/**
 *	bars: {
 * <br>		show: false,
 * <br>		lineWidth: 2, // in pixels
 * <br>		barWidth: 1, // in units of the x axis
 * <br>		fill: 0.7, opacity
 * <br>		fillColor: null,
 * <br>		align: "left", // or "center" 
 * <br>		horizontal: false
 * <br>    }
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotBarSeries extends FlotOptions {

	public FlotBarSeries() {
		
	}
	
	/**
	 * show: false
	 * @param show
	 */
	public void setShow(boolean show) {
		put("show",show);
	}
		
	/**
	 * lineWidth: 2 // in pixels
	 * @param lineWidth
	 */
	public void setLineWidth(double lineWidth) {
		put("lineWidth",lineWidth);
	}
	
	/**
	 * barWidth: 1, // in units of the x axis
	 * @param barWidth
	 */
	public void setBarWidht(double barWidth) {
		put("barWidth",barWidth);
	}
	
	/**
	 * fill: 0.8 opacity percentage
	 * @param fill
	 */
	public void setFill(double fill) {
		put("fill",fill);
	}
	
	/**
	 * fillColor: null
	 * @param fillColor
	 */
	public void setFillColor(String fillColor) {
		put("fillColor",fillColor);
	}
	
	/**
	 * align: "left", // or "center" 
	 * @param align
	 */
	public void setAlign(FlotAlignment align) {
		put("align",align.getAlignment());
	}
	
	/**
	 * horizontal: false
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		put("horizontal",horizontal);
	}

	@Override
	protected void loadDefaultOptionsMap() {
		setShow(true);
		setBarWidht(0.3d);
		setFill(0.7);
	}

}
