package com.java.flot;

import com.java.json.JSONArray;

/**
 * 
 * This class defines Markings
 * Markings --> [{ xaxis: { from: 0, to: 2 }, yaxis: { from: 10, to: 10 }, color: "#bb0000" }, .....]
 * 
 * Markings as a java script contains array of Marking.
 * 
 * "markings" is used to draw simple lines and rectangular areas in the
 * background of the plot. You can either specify an array of ranges on
 * the form { xaxis: { from, to }, yaxis: { from, to } } (with multiple
 * axes, you can specify coordinates for other axes instead, e.g. as
 * x2axis/x3axis/...) or with a function that returns such an array given
 * the axes for the plot in an object as the first paramenter.
 * 
 * <p>
 * You can set the color of markings by specifying "color" in the ranges object. Here's an example array:
 * markings: [ { xaxis: { from: 0, to: 2 }, yaxis: { from: 10, to: 10 }, color: "#bb0000" }, ... ]
 * If you leave out one of the values, that value is assumed to go to the
 * border of the plot. So for example if you only specify 
 * { xaxis: {from: 0, to: 2 } } it means an area that extends from the top to the
 * bottom of the plot in the x range 0-2.
 * 
 * <p>
 * A line is drawn if from and to are the same, e.g.  markings: [ { yaxis: { from: 1, to: 1 } }, ... ]
 * would draw a line parallel to the x axis at y = 1. You can control the 
 * line width with "lineWidth" in the range object.
 * 
 * <p>
 * An example function that makes vertical stripes might look like this:
 * 
 * <p>
 * markings: function (axes) {
 * 		var markings = [];
 * 		for (var x = Math.floor(axes.xaxis.min); x < axes.xaxis.max; x += 2)
 * 			markings.push({ xaxis: { from: x, to: x + 1 } });
 * 			return markings;
 * }
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotMarkings extends JSONArray {
	
	public FlotMarkings() {
		
	}
	
	public void addMarking(FlotMarking flotMarking) {
		add(flotMarking);
	}
}
