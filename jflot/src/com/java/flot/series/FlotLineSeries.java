package com.java.flot.series;

import com.java.flot.FlotOptions;


/**
 * FlotLineSeries -- to define a graph with lines. If points are required on lines setFlotPointSeries(FlotPointSeries flotPointSeries)
 * 
 * lines: {
 * 
 * <br>    // we don't put in show: false so we can see
 * <br>    // whether lines were actively disabled 
 * <br>    lineWidth: 2, // in pixels
 * <br>    fill: false,
 * <br>    fillColor: null,
 * <br>    steps: false
 * <br>    }
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotLineSeries extends FlotOptions {
	
	private FlotPointSeries flotPointSeries;
	
	public FlotLineSeries() {

	}
	
	/**
	 * lineWidth: 2, // in pixels
	 * @param lineWidth
	 */
	public void setLineWidth(int lineWidth) {
		put("lineWidth",lineWidth);
	}
	
	/**
	 * fill: false
	 * @param fill
	 */
	public void setFill(boolean fill) {
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
	 * steps: false
	 * @param steps
	 */
	public void setSteps(boolean steps) {
		put("steps",steps);
	}
	
	/**
	 * @return the flotPointSeries
	 */
	public FlotPointSeries getFlotPointSeries() {
		return flotPointSeries;
	}

	/**
	 * @param flotPointSeries the flotPointSeries to set
	 */
	public void setFlotPointSeries(FlotPointSeries flotPointSeries) {
		this.flotPointSeries = flotPointSeries;
	}
	
	@Override
	public String toString() {
		StringBuilder options = new StringBuilder(super.toString());
		if(flotPointSeries !=null)
			options.append(", points: ").append(flotPointSeries.toJSONString());
		return options.toString();
	}

	@Override
	protected void loadDefaultOptionsMap() {
		put("show",true);
	}
}
