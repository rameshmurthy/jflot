package com.java.flot.chart;

import java.util.List;

import com.java.flot.bean.FlotBarSeriesBean;
import com.java.flot.bean.FlotSeriesBean;
import com.java.flot.series.FlotBarSeries;
import com.java.flot.series.FlotSeries;

/**
 * Coming in next version
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 *
 */
public class FlotBarChart extends FlotChart {

	public FlotBarChart(List<FlotBarSeriesBean> flotBarSeriesBeans) {
		super(flotBarSeriesBeans);
		FlotBarSeries flotBarSeries = new FlotBarSeries();
		FlotSeries flotSeries = new FlotSeries(flotBarSeries);
		setFlotSeries(flotSeries);
	}

	@Override
	public String getData() {
		StringBuffer data = new StringBuffer("[");
		for(FlotSeriesBean timeSeries : flotSeriesBeans){
			data.append(timeSeries.getData());
		}
		data.deleteCharAt(data.lastIndexOf(","));
		data.append("]");
		return data.toString();
	}
}
