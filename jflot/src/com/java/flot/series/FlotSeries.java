package com.java.flot.series;

import com.java.flot.FlotOptions;
import com.java.json.JSONObject;

/**
 * 
 * FlotSeries contains one of the series like pie, line, bar, point and shadow size.
 * 
 * The java script options are defined below.
 * <br>
 * <br>
 * <p>
 * series: {
 * <br>	pie: {
 * <br>			show: false,
 * <br>			radius: 'auto',	// actual radius of the visible pie (based on full calculated radius if <=1, or hard pixel value)
 * <br>			innerRadius:0, // for donut
 * <br>			startAngle: 3/2,
 * <br>			tilt: 1,
 * <br>			offset: {
 * <br>				top: 0,
 * <br>				left: 'auto'
 * <br>			},
 * <br>			stroke: {
 * <br>				color: '#FFF',
 * <br>				width: 1
 * <br>			},
 * <br>			label: {
 * <br>				show: 'auto',
 * <br>				formatter: function(label, slice){
 * <br>					return '<div style="font-size:x-small;text-align:center;padding:2px;color:'+slice.color+';">'+label+'<br/>'+Math.round(slice.percent)+'%</div>';
 * <br>				},	// formatter function
 * <br>				radius: 1,	// radius at which to place the labels (based on full calculated radius if <=1, or hard pixel value)
 * <br>				background: {
 * <br>					color: null,
 * <br>					opacity: 0
 * <br>				},
 * <br>				threshold: 0	// percentage at which to hide the label (i.e. the slice is too narrow)
 * <br>			},
 * <br>			combine: {
 * <br>					threshold: -1,	// percentage at which to combine little slices into one larger slice
 * <br>					color: null,	// color to give the new slice (auto-generated if null)
 * <br>					label: 'Other'	// label to give the new slice
 * <br>			},
 * <br>			highlight: {
 * <br>					//color: '#FFF',		// will add this functionality once parseColor is available
 * <br>					opacity: 0.5
 * <br>			}
 * <br>	},
 * <br>    points: {
 * <br>	show: false,
 * <br>	radius: 3,
 * <br>	lineWidth: 2, // in pixels
 * <br>	fill: true,
 * <br>	fillColor: "#ffffff",
 * <br>	symbol: "circle" // or callback
 * <br>    },
 * <br>    lines: {
 * <br>	// we don't put in show: false so we can see
 * <br>	// whether lines were actively disabled 
 * <br>	lineWidth: 2, // in pixels
 * <br>	fill: false,
 * <br>	fillColor: null,
 * <br>	steps: false
 * <br>    },
 * <br>    bars: {
 * <br>	show: false,
 * <br>	lineWidth: 2, // in pixels
 * <br>	barWidth: 1, // in units of the x axis
 * <br>	fill: true,
 * <br>	fillColor: null,
 * <br>	align: "left", // or "center" 
 * <br>	horizontal: false
 * <br>    },
 * <br>    shadowSize: 3
 * <br>}
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotSeries extends JSONObject {

	/**
	 * Defines the type of series
	 * Ex: line, pie, point, bar.
	 */
	private FlotOptions flotSeries;
	
	public FlotSeries(FlotOptions flotSeries) {
		setFlotSeries(flotSeries);
	}

	/**
	 * get the type of series
	 * Ex: line, pie, point, bar.
	 * @return the flotSeriesOptions
	 */
	public FlotOptions getFlotSeries() {
		return flotSeries;
	}

	/**
	 * set the type of series
	 * <br> Ex: {@link FlotLineSeries}, {@link FlotPointSeries}, {@link FlotPieSeries}, {@link FlotBarSeries}
	 * @param flotSeries the flotSeries to set
	 */
	public void setFlotSeries(FlotOptions flotSeries) {
		this.flotSeries = flotSeries;
		if(flotSeries instanceof FlotLineSeries) {
			put("lines",flotSeries);
		} else if (flotSeries instanceof FlotPointSeries) {
			put("points", flotSeries);
		} else if (flotSeries instanceof FlotPieSeries) {
			put("pie", flotSeries);
		} else if (flotSeries instanceof FlotBarSeries) {
			put("bars", flotSeries);
		}
	}

	@Override
	protected void loadDefaultOptionsMap() {
		// TODO Auto-generated method stub
		
	}
}
