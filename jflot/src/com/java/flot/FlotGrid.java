package com.java.flot;


/**
 * <p>
 *  Customizing the grid
 *	====================
 *	<p>
 * 		<br>grid: {
 *                 <br> show: true,
 *                 <br> aboveData: false,
 *                 <br> color: "#545454", // primary color used for outline and labels
 *                 <br> backgroundColor: null, // null for transparent, else color
 *                 <br> borderColor: null, // set if different from the grid color
 *                 <br> tickColor: null, // color for the ticks, e.g. "rgba(0,0,0,0.15)"
 *                 <br> labelMargin: 5, // in pixels
 *                 <br> axisMargin: 8, // in pixels
 *                 <br> borderWidth: 2, // in pixels
 *                 <br> minBorderMargin: null, // in pixels, null means taken from points radius
 *                 <br> markings: [ { yaxis: { from: 0.75, to: 0.75 }, color: "#bb0000" } ], // array of ranges or fn: axes -> array of ranges
 *                 <br>  markingsColor: "#f4f4f4",
 *                 <br> markingsLineWidth: 2,
 *                 <br>  // interactive stuff
 *                 <br>  clickable: false,
 *                 <br>  hoverable: false,
 *                 <br>  autoHighlight: true, // highlight in case mouse is near
 *                 <br>  mouseActiveRadius: 10 // how far the mouse can be away to activate an item
 *      <br> },
 *	
 *<p>
 *	The grid is the thing with the axes and a number of ticks. Many of the
 *	things in the grid are configured under the individual axes, but not
 *	all. "color" is the color of the grid itself whereas "backgroundColor"
 *	specifies the background color inside the grid area, here null means
 *	that the background is transparent. You can also set a gradient, see
 *	the gradient documentation below.
 *	
 *<p>
 *	You can turn off the whole grid including tick labels by setting
 *	"show" to false. "aboveData" determines whether the grid is drawn
 *	above the data or below (below is default).
 *	
 *
 *<p>
 *	"labelMargin" is the space in pixels between tick labels and axis
 *	line, and "axisMargin" is the space in pixels between axes when there
 *	are two next to each other. Note that you can style the tick labels
 *	with CSS, e.g. to change the color. They have class "tickLabel".
 *	
 *
 *<p>
 *	"borderWidth" is the width of the border around the plot. Set it to 0
 *	to disable the border. You can also set "borderColor" if you want the
 *	border to have a different color than the grid lines.
 *	"minBorderMargin" controls the default minimum margin around the
 *	border - it's used to make sure that points aren't accidentally
 *	clipped by the canvas edge so by default the value is computed from
 *	the point radius.
 *	
 *<p>
 *	"markings" is used to draw simple lines and rectangular areas in the
 *	background of the plot. You can either specify an array of ranges on
 *	the form { xaxis: { from, to }, yaxis: { from, to } } (with multiple
 *	axes, you can specify coordinates for other axes instead, e.g. as
 *	x2axis/x3axis/...) or with a function that returns such an array given
 *	the axes for the plot in an object as the first parameter.
 *	
 *<p>
 *	You can set the color of markings by specifying "color" in the ranges
 *	object. Here's an example array:
 *	
 *	  markings: [ { xaxis: { from: 0, to: 2 }, yaxis: { from: 10, to: 10 }, color: "#bb0000" }, ... ]
 *	
 *<p>
 *	If you leave out one of the values, that value is assumed to go to the
 *	border of the plot. So for example if you only specify { xaxis: {
 *	from: 0, to: 2 } } it means an area that extends from the top to the
 *	bottom of the plot in the x range 0-2.
 *	
 *	A line is drawn if from and to are the same, e.g.
 *	
 *	  markings: [ { yaxis: { from: 1, to: 1 } }, ... ]
 *	
 *	would draw a line parallel to the x axis at y = 1. You can control the
 *	line width with "lineWidth" in the range object.
 *	
 *
 *<p>
 *	An example function that makes vertical stripes might look like this:
 *	
 *	  markings: function (axes) {
 *	    var markings = [];
 *	    for (var x = Math.floor(axes.xaxis.min); x < axes.xaxis.max; x += 2)
 *	      markings.push({ xaxis: { from: x, to: x + 1 } });
 *	    return markings;
 *	  }
 *	
 *	
 *
 *<p>
 *	If you set "clickable" to true, the plot will listen for click events
 *	on the plot area and fire a "plotclick" event on the placeholder with
 *	a position and a nearby data item object as parameters. The coordinates
 *	are available both in the unit of the axes (not in pixels) and in
 *	global screen coordinates.
 *	
 *
 *<p>
 *	Likewise, if you set "hoverable" to true, the plot will listen for
 *	mouse move events on the plot area and fire a "plothover" event with
 *	the same parameters as the "plotclick" event. If "autoHighlight" is
 *	true (the default), nearby data items are highlighted automatically.
 *	If needed, you can disable highlighting and control it yourself with
 *	the highlight/unhighlight plot methods described elsewhere.
 *	
 *<p>
 *	You can use "plotclick" and "plothover" events like this:
 *	
 *	    $.plot($("#placeholder"), [ d ], { grid: { clickable: true } });
 *	
 *	    $("#placeholder").bind("plotclick", function (event, pos, item) {
 *	        alert("You clicked at " + pos.x + ", " + pos.y);
 *	        // axis coordinates for other axes, if present, are in pos.x2, pos.x3, ...
 *	        // if you need global screen coordinates, they are pos.pageX, pos.pageY
 *	
 *	        if (item) {
 *	          highlight(item.series, item.datapoint);
 *	          alert("You clicked a point!");
 *	        }
 *	    });
 *	
 *
 *
 *<p>
 *	The item object in this example is either null or a nearby object on the form:
 *	
 *	  item: {
 *	      datapoint: the point, e.g. [0, 2]
 *	      dataIndex: the index of the point in the data array
 *	      series: the series object
 *	      seriesIndex: the index of the series
 *	      pageX, pageY: the global screen coordinates of the point
 *	  }
 *	
 *
 *<p>
 *	For instance, if you have specified the data like this 
 *	
 *	    $.plot($("#placeholder"), [ { label: "Foo", data: [[0, 10], [7, 3]] } ], ...);
 *	
 *	and the mouse is near the point (7, 3), "datapoint" is [7, 3],
 *	"dataIndex" will be 1, "series" is a normalized series object with
 *	among other things the "Foo" label in series.label and the color in
 *	series.color, and "seriesIndex" is 0. Note that plugins and options
 *	that transform the data can shift the indexes from what you specified
 *	in the original data array.
 *	
 *
 *<p>
 *	If you use the above events to update some other information and want
 *	to clear out that info in case the mouse goes away, you'll probably
 *	also need to listen to "mouseout" events on the placeholder div.
 *	
 *
 *<p>
 *	"mouseActiveRadius" specifies how far the mouse can be from an item
 *	and still activate it. If there are two or more points within this
 *	radius, Flot chooses the closest item. For bars, the top-most bar
 *	(from the latest specified data series) is chosen.
 *	
 *
 *<p>
 *	If you want to disable interactivity for a specific data series, you
 *	can set "hoverable" and "clickable" to false in the options for that
 *	series, like this { data: [...], label: "Foo", clickable: false }.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 *
 */
public class FlotGrid extends FlotOptions {
	
	private FlotMarkings flotMarkings;

	public FlotGrid() {
	
	}
	
	/**
	 * Default value -> show: true,
	 * @param show
	 */
	public void setShowGrid(boolean show) {
		put("show",show);
	}
	
	/**
	 * Default value -> aboveData: false,
	 * @param aboveData
	 */
	public void setAboveData(boolean aboveData) {
		put("aboveData",aboveData);
	}

	/**
	 * Default value ->
	 * color: "#545454", // primary color used for outline and labels
	 * "color" is the color of the grid itself whereas "backgroundColor"
	 *	specifies the background color inside the grid area, here null means
	 *	that the background is transparent. You can also set a gradient, see
	 *	the gradient documentation below.
	 * @param color
	 */
	public void setColor(String color) {
		put("color", color);
	}

	/**
	 * Default value ->
	 * backgroundColor: null, // null for transparent, else color
	 * 	"color" is the color of the grid itself whereas "backgroundColor"
	 *	specifies the background color inside the grid area, here null means
	 *	that the background is transparent. You can also set a gradient, see
	 *	the gradient documentation below.
	 * @param color
	 */
	public void setBackgroundColor(String color) {
		put("backgroundColor", color);
	}

	/**
	 * Default value ->
	 * borderColor: null, // set if different from the grid color
	 * @param color
	 */
	public void setBorderColor(String color){
		put("borderColor",color);
	}
	
	/**
	 * Default value ->
	 * tickColor: null, // color for the ticks, e.g. "rgba(0,0,0,0.15)"
	 * @param color
	 */
	public void setTickColor(String color) {
		put("tickColor", color);
	}

	/**
	 *labelMargin: 5, // in pixels
	 * @param labelMargin
	 */
	public void setLabelMargin(int labelMargin) {
		put("labelMargin", new Integer(labelMargin));
	}

	/**
	 * axisMargin: 8, // in pixels
	 * @param axisMargin
	 */
	public void setAxisMargin(int axisMargin) {
		put("axisMargin",axisMargin);
	}
	
	/**
	 * borderWidth: 2, // in pixels
	 * @param borderWidth
	 */
	public void setBorderWidth(int borderWidth) {
		put("borderWidth", new Integer(borderWidth));
	}
	
	/**
	 * minBorderMargin: null, // in pixels, null means taken from points radius
	 * @param minBorderMargin
	 */
	public void setMinBorderMargin(int minBorderMargin) {
		put("minBorderMargin",minBorderMargin);
	}
	
	/**
	 *"markings" is used to draw simple lines and rectangular areas in the
	 *	background of the plot. You can either specify an array of ranges on
	 *	the form { xaxis: { from, to }, yaxis: { from, to } } (with multiple
	 *	axes, you can specify coordinates for other axes instead, e.g. as
	 *	x2axis/x3axis/...) or with a function that returns such an array given
	 *	the axes for the plot in an object as the first parameter.
	 *	
	 *<p>
	 *	You can set the color of markings by specifying "color" in the ranges
	 *	object. Here's an example array:
	 *	
	 *	  markings: [ { xaxis: { from: 0, to: 2 }, yaxis: { from: 10, to: 10 }, color: "#bb0000" }, ... ]
	 *	
	 * @param flotMarkings
	 */
	public void setMarkings(FlotMarkings flotMarkings) {
		this.flotMarkings = flotMarkings;
		put("markings", flotMarkings);
	}
	
	/**
	 * @return the flotMarkings
	 */
	public FlotMarkings getMarkings() {
		return flotMarkings;
	}

	/**
	 * markingsColor: "#f4f4f4",
	 * @param markingsColor
	 */
	public void setMarkingsColor(String markingsColor) {
		put("markingsColor",markingsColor);
	}
	
	/**
	 * markingsLineWidth: 2,
	 */
	public void setMarkingsLineWidth(int markingsLineWidth) {
		put("markingsLineWidth",markingsLineWidth);
	}
	
	/**
	 * // interactive stuff
	 * clickable: false,
	 * @param clickable
	 */
	public void setClickable(boolean clickable) {
		put("clickable", clickable);
	}

	/**
	 * hoverable: false,
	 * @param hoverable
	 */
	public void setHoverable(boolean hoverable) {
		put("hoverable", hoverable);
	}

	/**
	 * autoHighlight: true, // highlight in case mouse is near
	 * @param autoHighlight
	 */
	public void setAutoHighlight(boolean autoHighlight) {
		put("autoHighlight", autoHighlight);
	}

	/**
	 * mouseActiveRadius: 10 // how far the mouse can be away to activate an item
	 * @param mouseActiveRadius
	 */
	public void setMouseActiveRadius(int mouseActiveRadius) {
		put("mouseActiveRadius", new Integer(mouseActiveRadius));
	}

	@Override
	protected void loadDefaultOptionsMap() {
		setHoverable(true);
		setAutoHighlight(true);
		setMouseActiveRadius(50);
	}
}
