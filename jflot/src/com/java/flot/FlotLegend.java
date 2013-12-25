package com.java.flot;

/**
 * 
 *  *      Customizing the legend
 * <br> ======================
 * <br> <p>
 * <br>legend: {
 * <br>    show: boolean
 * <br>    labelFormatter: null or (fn: string, series object -> string)
 * <br>    labelBoxBorderColor: color
 * <br>    noColumns: number
 * <br>    position: "ne" or "nw" or "se" or "sw"
 * <br>    margin: number of pixels or [x margin, y margin]
 * <br>    backgroundColor: null or color
 * <br>    backgroundOpacity: number between 0 and 1
 * <br>    container: null or jQuery object/DOM element/jQuery expression
 * <br>   }
 * <br> <p>
 * <br>The legend is generated as a table with the data series labels and 
 * <br>small label boxes with the color of the series. If you want to format the labels in some way, e.g. make them to links, you can pass in a
 * <br>function for "labelFormatter". Here's an example that makes them 
 * <br>clickable:
 * <br>labelFormatter: function(label, series) {
 * <br>  // series is the series object for the label
 * <br>    return '<a href="#' + label + '">' + label + '</a>';
 * <br> }
 * <br> 
 * <br> <p> "noColumns" is the number of columns to divide the legend table into.
 * <br>  "position" specifies the overall placement of the legend within the plot (top-right, top-left, etc.) and margin the distance to the plot
 * <br>  edge (this can be either a number or an array of two numbers like [x,y]). 
 * <br>  "backgroundColor" and "backgroundOpacity" specifies thebackground. 
 * <br>  The default is a partly transparent auto-detected background.
 * <br> <p>
 * <br> If you want the legend to appear somewhere else in the DOM, you can
 * <br> specify "container" as a jQuery object/expression to put the legend table into. The "position" and "margin" etc. options will then be
 * <br> ignored. Note that Flot will overwrite the contents of the container.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotLegend extends FlotOptions {

	public FlotLegend() {
	}
	
	public static final String NORTH_EAST = "ne";
	public static final String NORTH_WEST = "nw";
	public static final String SOUTH_EAST = "se";
	public static final String SOUTH_WEST = "sw";

	public void setShow(boolean show) {
		put("show", show);
	}
	
	public void setLabelBoxBorderColor(String cssColor) {
		put("labelBoxBorderColor", cssColor);
	}

	public void setNumOfColumns(int cols) {
		put("noColumns", new Integer(cols));
	}

	/**
	 * FlotLegend.NORTH_EAST, FlotLegend.NORTH_WEST,  FlotLegend.SOUTH_EAST, FlotLegend.SOUTH_WEST
	 * "ne", "nw", "se", "sw"
	 * @param position
	 */
	public void setPosition(String position) {
		put("position", position);
	}

	public void setMargin(double margin) {
		put("margin", new Double(margin));
	}

	public void setBackgroundColor(String cssColor) {
		put("backgroudColor", cssColor);
	}

	public void setBackgroundOpacity(double opacity) {
		put("backgroundOpacity", new Double(opacity));

	}

	public void setContainer(String container) {
		put("container",container);
	}

	@Override
	protected void loadDefaultOptionsMap() {
		setContainer("$(\"#legend\")");
		setShow(true);
		setNumOfColumns(5);
	}
}
