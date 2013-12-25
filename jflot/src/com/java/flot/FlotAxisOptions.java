package com.java.flot;

/**
  *		xaxis: {
 * <br>                    show: null, // null = auto-detect, true = always, false = never
 * <br>                    position: "bottom", // or "top"
 * <br>                    mode: null, // null or "time"
 * <br>                    color: null, // base color, labels, ticks
 * <br>                    tickColor: null, // possibly different color of ticks, e.g. "rgba(0,0,0,0.15)"
 * <br>                    transform: null, // null or f: number -> number to transform axis
 * <br>                    inverseTransform: null, // if transform is set, this should be the inverse function
 * <br>                    min: null, // min. value to show, null means set automatically
 * <br>                    max: null, // max. value to show, null means set automatically
 * <br>                    autoscaleMargin: null, // margin in % to add if auto-setting min/max
 * <br>                    ticks: null, // either [1, 3] or [[1, "a"], 3] or (fn: axis info -> ticks) or app. number of ticks for auto-ticks
 * <br>                    tickFormatter: null, // fn: number -> string
 * <br>                    labelWidth: null, // size of tick labels in pixels
 * <br>                    labelHeight: null,
 * <br>                    reserveSpace: null, // whether to reserve space even if axis isn't shown
 * <br>                    tickLength: null, // size in pixels of ticks, or "full" for whole line
 * <br>                    alignTicksWithAxis: null, // axis number or null for no sync
 * <br>                    
 * <br>                    // mode specific options
 * <br>                    tickDecimals: null, // no. of decimals, null means auto
 * <br>                    tickSize: null, // number or [number, "unit"]
 * <br>                    minTickSize: null, // number or [number, "unit"]
 * <br>                    monthNames: null, // list of names of months
 * <br>                    timeformat: null, // format string to use
 * <br>                    twelveHourClock: false // 12 or 24 time in time mode
 * 
 * 
 * 
 * 
 * <p>
 * <p>     // These are added using a jquery.flot.axislabel.js its a hook to flot.
 * <br>				axisLabel: 'foo',
 * <br>           	axisLabelUseCanvas: true,
 * <br>           	axisLabelFontSizePixels: 20,
 * <br>           	axisLabelFontFamily: 'Arial'
 * <br>
 * <br>         }
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 *
 */
public class FlotAxisOptions extends FlotOptions {

	/**
	 * nameOfOptions should be either xaxis or yaxis
	 * @param nameOfOptions
	 */
	public FlotAxisOptions(String nameOfOptions) {
		//To load default values based on nameOfOptions.
		if(nameOfOptions.equals("xaxis")) {
			setMode("time");
		} else if(nameOfOptions.equals("yaxis")) {
			setTickFormatter("function (v) { return v.toFixed(2); }");
		}
	}
	
	/**
	 * To set tick labels using a function.
	 * function (v) { return v.toFixed(2) + "" + yLabel; }
	 * @param tickFormatter
	 */
	private void setTickFormatter(String tickFormatter) {
		put("tickFormatter",tickFormatter);
	}

	/**
	 * show: null, // null = auto-detect, true = always, false = never
	 * @param show
	 */
	public void setShow(boolean show) {
		put("show",show);
	}
	
	/**
	 * XAxis --> position: "bottom", // or "top"
	 * YAxis --> position: "left" // or "right" 
	 * @param position
	 */
	public void setPosition(String position) {
		put("position",position);
	}
	
	/**
	 * mode: null, // null or "time"
	 * @param mode
	 */
	public void setMode(String mode) {
		put("mode",mode);
	}
	
	/**
	 * color: null, // base color, labels, ticks
	 * @param color
	 */
	public void setColor(String color) {
		put("color",color);
	}
	
	/**
	 * tickColor: null, // possibly different color of ticks, e.g. "rgba(0,0,0,0.15)"
	 * @param tickColor
	 */
	public void setTickColor(String tickColor) {
		put("tickColor",tickColor);
	}

	/**
	 * min: null, // min. value to show, null means set automatically
	 * @param min
	 */
	public void setMinimum(double min) {
		put("min", new Double(min));
	}
	
	/**
	 *  max: null, // max. value to show, null means set automatically
	 * @param max
	 */
	public void setMaximum(double max) {
		put("max", new Double(max));
	}

	/**
	 * autoscaleMargin: null, // margin in % to add if auto-setting min/max
	 * @param margin
	 */
	public void setAutoscaleMargin(double margin) {
		put("autoscaleMargin", new Double(margin));
	}

	/**
	 * labelWidth: null, // size of tick labels in pixels
	 * @param labelWidth
	 */
	public void setTickLabelWidth(double labelWidth) {
		put("labelWidth", new Double(labelWidth));
	}

	/**
	 * labelHeight: null,
	 * @param labelHeight
	 */
	public void setTickLabelHeight(double labelHeight) {
		put("labelHeight", new Double(labelHeight));
	}

	/**
	 * ticks: null, // either [1, 3] or [[1, "a"], 3] or (fn: axis info -> ticks) or app. number of ticks for auto-ticks
	 * @param ticks
	 */
	public void setTicks(double ticks) {
		put("ticks", new Double(ticks));
	}

//	/**
//	 * ticks: null, // either [1, 3] or [[1, "a"], 3] or (fn: axis info -> ticks) or app. number of ticks for auto-ticks
//	 * @param ticks
//	 */
//	public void setTicks(Tick[] ticks) {
//		//put("ticks", ticks);
//	}

	/**
	 * tickSize: null, // number or [number, "unit"]
	 * @param tickSize
	 */
	public void setTickSize(double tickSize) {
		put("tickSize", new Double(tickSize));
	}
	
	/**
	 * minTickSize: null, // number or [number, "unit"]
	 * @param minTickSize
	 */
	public void setMinTickSize(double minTickSize) {
		put("minTickSize", new Double(minTickSize));
	}
	
	/**
	 * tickDecimals: null, // no. of decimals, null means auto
	 * @param tickDecimals
	 */
	public void setTickDecimals(double tickDecimals) {
		put("tickDecimals", new Double(tickDecimals));
	}
	
	/**
	 * axisLabel: 'foo'
	 * @param axisLabel
	 */
	public void setAxisLabel(String axisLabel) {
		put("axisLabel",axisLabel);
	}
	
	public void setAxisLabelUseCanvas(boolean axisLabelUseCanvas) {
		put("axisLabelUseCanvas",axisLabelUseCanvas);
	}
	
	/**
	 * axisLabelFontSizePixels: 20
	 * @param axisLabelFontSizePixels
	 */
	public void setAxisLabelFontSize(int axisLabelFontSizePixels) {
		put("axisLabelFontSizePixels",axisLabelFontSizePixels);
	}
	
	/**
	 * axisLabelFontFamily: 'Arial'
	 * @param axisLabelFontFamily
	 */
	public void setAxisLabelFontFamily(String axisLabelFontFamily) {
		put("axisLabelFontFamily",axisLabelFontFamily);
	}
	
	/**
	 * to set zoom range.
	 * <br>
	 * zoomRange: [0.1, 10]
	 * @param from
	 * @param to
	 */
	public void setZoomRange(double from, double to) {
		put("zoomRange","["+from+","+to+"]");
	}
	
	
	/**
	 * to set pan range
	 * <br>
	 * panRange: [-10, 10]
	 * @param from
	 * @param to
	 */
	public void setPanRange(double from, double to) {
		put("panRange","["+from+","+to+"]");
	}

	@Override
	protected void loadDefaultOptionsMap() {
		setAxisLabelUseCanvas(true);
		setAxisLabelFontSize(25);
		setAxisLabelFontFamily("Arial");
	}
}
