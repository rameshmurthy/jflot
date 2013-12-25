package com.java.flot.chart;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.java.flot.bean.FlotSeriesBean;
import com.java.flot.bean.FlotTimeSeriesBean;
import com.java.flot.series.FlotLineSeries;
import com.java.flot.series.FlotPointSeries;
import com.java.flot.series.FlotSeries;
import com.java.json.JSONArray;

/**
 * Time Series Chart - xAxis represents time and yAxis represents data (values).
 * These charts are displayed with Lines and points.
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotTimeSeriesChart extends FlotChart {
	
	/**
	 * FlotTimeSeriesChart is constructed with lines and points.
	 * @param flotTimeSeriesBeans
	 */
	public FlotTimeSeriesChart(List<FlotTimeSeriesBean> flotTimeSeriesBeans) {
		super(flotTimeSeriesBeans);
		FlotLineSeries flotLineSeries = new FlotLineSeries();
		flotLineSeries.setFlotPointSeries(new FlotPointSeries());
		
		FlotSeries flotSeries = new FlotSeries(flotLineSeries);
		setFlotSeries(flotSeries);
	}
	
	/**
	 * This method returns data for flot graph construction. Flot graph needs, palce holder, data and options for
	 * constructing a graph. This method gives data.
	 */
	public String getData(){
		JSONArray jsonArray = new JSONArray();
		if(flotSeriesBeans !=null){
			for(FlotSeriesBean flotSeriesBean : flotSeriesBeans){
				jsonArray.add(flotSeriesBean.getData());
			}
		}
		return jsonArray.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcom To Java FLOT ----- Testing FLOT TIME SERIES CHART");
		
		Map<Long,Double> time = new TreeMap<Long,Double>();
		
		time.put(new Long(1), new Double(100.456));
		time.put(new Long(2), new Double(200.23456E-10));
		time.put(new Long(3), new Double(-300));
		time.put(new Long(4), new Double(400));
		time.put(new Long(5), new Double(500));
		time.put(new Long(6), new Double(600));

		
		FlotTimeSeriesBean flotTimeSeriesBean = new FlotTimeSeriesBean("Ramesh Testin", time);
		flotTimeSeriesBean.setClickable(true);
		flotTimeSeriesBean.setColor("black");
		flotTimeSeriesBean.setHoverable(true);
		flotTimeSeriesBean.setXaxisNumber(2);
		
		
		Map<Long,Double> time2 = new TreeMap<Long,Double>();
		
		time.put(new Long(21), new Double(2100.456));
		time.put(new Long(22), new Double(2200.23456E-10));
		time.put(new Long(23), new Double(-2300));
		time.put(new Long(24), new Double(2400));
		time.put(new Long(25), new Double(2500));
		time.put(new Long(26), new Double(2600));

		
		FlotTimeSeriesBean flotTimeSeriesBean2 = new FlotTimeSeriesBean("Ramesh Testin", null);
		flotTimeSeriesBean2.setClickable(true);
		flotTimeSeriesBean2.setColor("black");
		flotTimeSeriesBean2.setHoverable(true);
		flotTimeSeriesBean2.setXaxisNumber(2);
		
		
		java.util.List<FlotTimeSeriesBean> flotTimeSeriesBeans = new java.util.ArrayList<FlotTimeSeriesBean>();
		flotTimeSeriesBeans.add(flotTimeSeriesBean);
		flotTimeSeriesBeans.add(flotTimeSeriesBean2);
		
		FlotTimeSeriesChart flotTimeSeriesChart = new FlotTimeSeriesChart(flotTimeSeriesBeans);
		
		System.out.println(flotTimeSeriesChart.getData());
		
		
	}
}
