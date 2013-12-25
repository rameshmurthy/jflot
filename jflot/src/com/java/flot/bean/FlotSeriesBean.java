package com.java.flot.bean;

import com.java.flot.FlotOptions;
import com.java.flot.series.FlotBarSeries;
import com.java.flot.series.FlotLineSeries;
import com.java.flot.series.FlotPointSeries;

/**
 * Abstract super class of all series beans.
 * 
 * Data Format
-----------
 * <br>
 * <br>The data is an array of data series:
 * <br>
 * <br>  [ series1, series2, ... ]
 * <br>
 * <br>A series can either be raw data or an object with properties. The raw data format is an array of points:
 * <br>
 * <br>  [ [x1, y1], [x2, y2], ... ]
 * <br>
 * <br>E.g.
 * <br>
 * <br>  [ [1, 3], [2, 14.01], [3.5, 3.14] ]
 * <br>
 * <br>Note that to simplify the internal logic in Flot both the x and y values must be numbers (even if specifying time series, see below for
 * <br>how to do this). This is a common problem because you might retrieve data from the database and serialize them directly to JSON without
 * <br>noticing the wrong type. If you're getting mysterious errors, double check that you're inputting numbers and not strings.
 * <br>
 * <br>If a null is specified as a point or if one of the coordinates is null
 * <br>or couldn't be converted to a number, the point is ignored when
 * <br>drawing. As a special case, a null value for lines is interpreted as a
 * <br>line segment end, i.e. the points before and after the null value are
 * <br>not connected.
 * <br>
 * <br>Lines and points take two coordinates. For filled lines and bars, you
 * <br>can specify a third coordinate which is the bottom of the filled
 * <br>area/bar (defaults to 0).
 * <br>
 * <br>The format of a single series object is as follows:
 * <br>
 * <br>  {
 * <br>    color: color or number
 * <br>    data: rawdata
 * <br>    label: string
 * <br>    lines: specific lines options
 * <br>    bars: specific bars options
 * <br>    points: specific points options
 * <br>    xaxis: number
 * <br>    yaxis: number
 * <br>    clickable: boolean
 * <br>    hoverable: boolean
 * <br>    shadowSize: number
 * <br>  }
 * <br>
 * <br>You don't have to specify any of them except the data, the rest are
 * <br>options that will get default values. Typically you'd only specify
 * <br>label and data, like this:
 * <br>
 * <br>  {
 * <br>    label: "y = 3",
 * <br>    data: [[0, 3], [10, 3]]
 * <br>  }
 * <br>
 * <br>The label is used for the legend, if you don't specify one, the series will not show up in the legend.
 * <br>
 * <br>If you don't specify color, the series will get a color from the auto-generated colors. The color is either a CSS color specification
 * <br>(like "rgb(255, 100, 123)") or an integer that specifies which of auto-generated colors to select, e.g. 0 will get color no. 0, etc.
 * <br>
 * <br>The latter is mostly useful if you let the user add and remove series,in which case you can hard-code the color index to prevent the colors
 * <br>from jumping around between the series.
 * <br>
 * <br>The "xaxis" and "yaxis" options specify which axis to use. The axes
 * <br>are numbered from 1 (default), so { yaxis: 2} means that the series
 * <br>should be plotted against the second y axis.
 * <br>
 * <br>"clickable" and "hoverable" can be set to false to disable
 * <br>interactivity for specific series if interactivity is turned on in
 * <br>the plot, see below.
 * <br>
 * <br>The rest of the options are all documented below as they are the same
 * <br>as the default options passed in via the options parameter in the plot
 * <br>commmand. When you specify them for a specific data series, they will
 * <br>override the default options for the plot for that data series.
 * <br>
 * <br>Here's a complete example of a simple data specification:
 * <br>
 * <br>  [ { label: "Foo", data: [ [10, 1], [17, -14], [30, 5] ] },
 * <br>    { label: "Bar", data: [ [11, 13], [19, 11], [30, -7] ] } ]
 * 
 * @see com.java.flot.bean.FlotTimeSeriesBean
 * @see com.java.flot.bean.FlotBarSeriesBean
 * @see com.java.flot.bean.FlotPieSeriesBean
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 *
 */
public abstract class FlotSeriesBean extends FlotOptions {
		
	public abstract String getData();

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		put("color",color);
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		put("label",label);
	}

	/**
	 * @param lines the lines to set
	 */
	public void setLines(FlotLineSeries lines) {
		put("lines",lines);
	}

	/**
	 * @param bars the bars to set
	 */
	public void setBars(FlotBarSeries bars) {
		put("bars",bars);
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(FlotPointSeries points) {
		put("points",points);
	}

	/**
	 * The number of the xaxis this graph data to be displayed. useful for mulitple axis.
	 * @param xaxisNumber the xaxisNumber to set
	 */
	public void setXaxisNumber(int xaxisNumber) {
		put("xaxis",xaxisNumber);
	}

	/**
	 * The number of the yaxis this graph data to be displayed. useful for mulitple axis.
	 * @param yaxisNumber the yaxisNumber to set
	 */
	public void setYaxisNumber(int yaxisNumber) {
		put("yaxis",yaxisNumber);
	}

	/**
	 * @param clickable the clickable to set
	 */
	public void setClickable(boolean clickable) {
		put("clickable",clickable);
	}

	/**
	 * @param hoverable the hoverable to set
	 */
	public void setHoverable(boolean hoverable) {
		put("hoverable",hoverable);
	}

	/**
	 * @param shadowSize the shadowSize to set
	 */
	public void setShadowSize(int shadowSize) {
		put("shadowSize",shadowSize);
	}
	
}
