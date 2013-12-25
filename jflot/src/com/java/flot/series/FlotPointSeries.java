package com.java.flot.series;

import com.java.flot.FlotOptions;

/**
 * FlotPointSeries -- to define a graph with points. 
 * If points are required on lines setFlotPointSeries(FlotPointSeries flotPointSeries) in FlotLineSeries.
 * points: {
 * <br>	show: false,
 * <br>	radius: 3,
 * <br>	lineWidth: 2, // in pixels
 * <br>	fill: true,
 * <br>	fillColor: "#ffffff",
 * <br>	symbol: "circle" // or callback
 * <br>    }
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotPointSeries extends FlotOptions {
	
	public enum PointSymbol
    {
        CIRCLE( "circle" ), SQUARE( "square" ), DIAMOND( "diamond" ), TRIANGLE( "triangle" ), CROSS( "cross" );

        private String symbol;

        PointSymbol( String symbol )
        {
            this.symbol = symbol;
        }

        public String getSymbol()
        {
            return symbol;
        }
    }

	public FlotPointSeries() {
	}
	
	/**
	 * show: false
	 * @param show
	 */
	public void setShow(boolean show) {
		put("show",show);
	}
	
	/**
	 * radius: 3
	 * @param radius
	 */
	public void setRadius(double radius) {
		put("radius",radius);
	}
	
	/**
	 * lineWidth: 2 // in pixels
	 * @param lineWidth
	 */
	public void setLineWidth(int lineWidth) {
		put("lineWidth",lineWidth);
	}
	
	/**
	 * fill: true
	 * @param fill
	 */
	public void setFill(boolean fill) {
		put("fill",fill);
	}
	
	/**
	 * fillColor: "#ffffff"
	 * @param fillColor
	 */
	public void setFillColor(String fillColor) {
		put("fillColor",fillColor);
	}
	
	
	/**
	 * symbol: "circle"
	 * @param symbol
	 */
	public void setSymbol(String symbol) {
		put("symbol",symbol);
	}

	@Override
	protected void loadDefaultOptionsMap() {
		setShow(true);
		setRadius(2);
		setFillColor("#ffffff");
	}

}
