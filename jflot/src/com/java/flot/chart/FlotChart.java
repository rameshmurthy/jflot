package com.java.flot.chart;

import java.util.List;

import com.java.flot.FlotAxisOptions;
import com.java.flot.FlotColors;
import com.java.flot.FlotGrid;
import com.java.flot.FlotLegend;
import com.java.flot.FlotOptions;
import com.java.flot.bean.FlotSeriesBean;
import com.java.flot.interactive.FlotPan;
import com.java.flot.interactive.FlotZoom;
import com.java.flot.series.FlotSeries;

/**
 * The super class of all FlotCharts
 * @see com.java.flot.FlotTimeSeriesChart
 * @see com.java.flot.FlotPieChart
 * @see com.java.flot.FlotBarChart
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 *
 */
public abstract class FlotChart extends FlotOptions {
	
	/**
	 * Data of flot chart
	 */
	protected List<? extends FlotSeriesBean> flotSeriesBeans;
	
	/**
	 * Flot Options
	 */
	private FlotGrid flotGrid;
	private FlotSeries flotSeries;
	private FlotLegend flotLegend;
	private FlotAxisOptions flotXAxisOptions;
	private FlotAxisOptions flotYAxisOptions;
	private FlotColors flotColors;
	private FlotZoom flotZoom;
	private FlotPan flotPan;
	
	/**
	 * Place holder of flot chart
	 */
	private String idOfFlotGraph = "placeholder";
	
	public FlotChart(List<? extends FlotSeriesBean> flotSeriesBeans) {
		this.flotSeriesBeans = flotSeriesBeans;	
	}

	public abstract String getData();
	
	/**
	 * @return the flotGrid
	 */
	public FlotGrid getFlotGrid() {
		return flotGrid;
	}
	
	/**
	 * @param flotGrid the flotGrid to set
	 */
	public void setFlotGrid(FlotGrid flotGrid) {
		this.flotGrid = flotGrid;
		put("grid",flotGrid);
	}
	
	/**
	 * @return the flotSeries
	 */
	public FlotSeries getFlotSeries() {
		return flotSeries;
	}
	
	/**
	 * @param flotSeries the flotSeries to set
	 */
	public void setFlotSeries(FlotSeries flotSeries) {
		this.flotSeries = flotSeries;
		put("series",flotSeries);
	}
	
	/**
	 * @return the flotLegend
	 */
	public FlotLegend getFlotLegend() {
		return flotLegend;
	}
	
	/**
	 * @param flotLegend the flotLegend to set
	 */
	public void setFlotLegend(FlotLegend flotLegend) {
		this.flotLegend = flotLegend;
		put("legend",flotLegend);
	}
	
	/**
	 * @return the flotXAxisOptions
	 */
	public FlotAxisOptions getFlotXAxisOptions() {
		return flotXAxisOptions;
	}
	
	/**
	 * @param flotXAxisOptions the flotXAxisOptions to set
	 */
	public void setFlotXAxisOptions(FlotAxisOptions flotXAxisOptions) {
		this.flotXAxisOptions = flotXAxisOptions;
		put("xaxis",flotXAxisOptions);
	}
	
	/**
	 * @return the flotYAxisOptions
	 */
	public FlotAxisOptions getFlotYAxisOptions() {
		return flotYAxisOptions;
	}
	
	/**
	 * @param flotYAxisOptions the flotYAxisOptions to set
	 */
	public void setFlotYAxisOptions(FlotAxisOptions flotYAxisOptions) {
		this.flotYAxisOptions = flotYAxisOptions;
		put("yaxis",flotYAxisOptions);
	}
	
	/**
	 * @return the idOfFlotGraph
	 */
	public String getIdOfFlotGraph() {
		return idOfFlotGraph;
	}
	
	/**
	 * 
	 * @param flotColors2
	 */
	public void setFlotColors(FlotColors flotColors) {
		this.flotColors = flotColors;
		put("colors",flotColors);
	}
	
	/**
	 * @param idOfFlotGraph the idOfFlotGraph to set
	 */
	public void setIdOfFlotGraph(String idOfFlotGraph) {
		this.idOfFlotGraph = idOfFlotGraph;
	}
	
	@Override
	protected void loadDefaultOptionsMap() {
		//Initializing variables
		flotGrid = new FlotGrid();
		flotLegend = new FlotLegend();
		flotXAxisOptions = new FlotAxisOptions("xaxis");
		flotYAxisOptions = new FlotAxisOptions("yaxis");
		flotColors = new FlotColors();
		
		//Loading default options
		flotColors.addDefaultColors();
		setFlotColors(flotColors);
		setFlotGrid(flotGrid);
		setFlotLegend(flotLegend);
		setFlotXAxisOptions(flotXAxisOptions);
		setFlotYAxisOptions(flotYAxisOptions);
	}

	/**
	 * @return the flotZoom
	 */
	public FlotZoom getFlotZoom() {
		return flotZoom;
	}

	/**
	 * @param flotZoom the flotZoom to set
	 */
	public void setFlotZoom(FlotZoom flotZoom) {
		this.flotZoom = flotZoom;
		put("zoom",flotZoom);
	}

	/**
	 * @return the flotPan
	 */
	public FlotPan getFlotPan() {
		return flotPan;
	}

	/**
	 * @param flotPan the flotPan to set
	 */
	public void setFlotPan(FlotPan flotPan) {
		this.flotPan = flotPan;
		put("pan",flotPan);
	}

	/**
	 * @return the flotSeriesBeans
	 */
	public List<? extends FlotSeriesBean> getFlotSeriesBeans() {
		return flotSeriesBeans;
	}

	/**
	 * @param flotSeriesBeans the flotSeriesBeans to set
	 */
	public void setFlotSeriesBeans(List<? extends FlotSeriesBean> flotSeriesBeans) {
		this.flotSeriesBeans = flotSeriesBeans;
	}
}
