package com.java.flot.bean;

import java.text.NumberFormat;
import java.util.Map;
import java.util.TreeMap;

import com.java.json.JSONArray;

/**
 * FlotTimeSeriesBean holds data to be displayed on Flot charts.
 * <br> timeSeriesName ,timeValueMap, normalizingFactor to be applied on values,
 * timeOffSet to be applied on time, units of the value.
 * 
 * {
 * <br> color: color or number
 * <br> data: rawdata
 * <br> label: string
 * <br> lines: specific lines options
 * <br> bars: specific bars options
 * <br> points: specific points options
 * <br> xaxis: number
 * <br> yaxis: number
 * <br> clickable: boolean
 * <br> hoverable: boolean
 * <br> shadowSize: number
 * <br> }
 * @
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 *
 */
public class FlotTimeSeriesBean extends FlotSeriesBean {
	
	private NumberFormat numberFormat = null;
	
	/** name of time series */
	private String timeSeriesName;
	/** data to be displayed on Flot chart - a map of time and value*/
	private Map<Long,Double> timeValueMap;
	/** a factor to be applied on values of data. Multiplication is performed on values.*/
	private double normalizingFactor = 1;
	/** time off set to be applied on time. Addition is performed on time*/
	private long timeOffSet = 0;
	/** units of values ex: seconds, MB etc*/
	private String units = "";
	
	/**
	 * Construct a FlotTimeSeriesBean withe series name and time values
	 * @param timeSeriesName name of the time series.
	 * @param timeValueMap key is time in <code>long</code> and value is corresponding value in 
	 * <code>double</code>
	 */
	public FlotTimeSeriesBean(String timeSeriesName, Map<Long,Double> timeValueMap) {
		setTimeSeriesName(timeSeriesName);
		setTimeValueMap(timeValueMap);
	}

	/**
	 * @return the timeSeriesName
	 */
	public String getTimeSeriesName() {
		return timeSeriesName;
	}

	/**
	 * @param timeSeriesName the timeSeriesName to set
	 */
	public void setTimeSeriesName(String timeSeriesName) {
		setLabel(timeSeriesName);
		this.timeSeriesName = timeSeriesName;
	}

	/**
	 * @return the timeValueMap
	 */
	public Map<Long, Double> getTimeValueMap() {
		return timeValueMap;
	}

	/**
	 * @param timeValueMap the timeValueMap to set
	 */
	public void setTimeValueMap(Map<Long, Double> timeValueMap) {
		this.timeValueMap = timeValueMap;
	}

	/**
	 * @return the normalizingFactor
	 */
	public double getNormalizingFactor() {
		return normalizingFactor;
	}

	/**
	 * @param normalizingFactor the normalizingFactor to set
	 */
	public void setNormalizingFactor(double normalizingFactor) {
		put("normalizingFactor",normalizingFactor);
		this.normalizingFactor = normalizingFactor;
	}

	/**
	 * @return the timeOffSet
	 */
	public long getTimeOffSet() {
		return timeOffSet;
	}

	/**
	 * @param timeOffSet the timeOffSet to set
	 */
	public void setTimeOffSet(long timeOffSet) {
		put("timeOffSet",timeOffSet);
		this.timeOffSet = timeOffSet;
	}

	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		put("units",units);
		this.units = units;
	}

	/**
	 * @return the numberFormat
	 */
	public NumberFormat getNumberFormat() {
		return numberFormat;
	}

	/**
	 * @param numberFormat the numberFormat to set
	 */
	public void setNumberFormat(NumberFormat numberFormat) {
		this.numberFormat = numberFormat;
	}

	/**
	 * returns timeSeries data
	 */
	@Override
	public String getData() {
		
		if(numberFormat ==  null){
			numberFormat = NumberFormat.getInstance();
			numberFormat.setMaximumFractionDigits(2);
			numberFormat.setGroupingUsed(false);
		}
		
		JSONArray dataArray = new JSONArray();
		
		if(timeValueMap !=null && timeValueMap.size()>0) {
			for( Map.Entry<Long, Double> timeValue : timeValueMap.entrySet()) {
				// [time,value] -- one dataElement
				JSONArray dataElement = new JSONArray();
				dataElement.add(timeValue.getKey()+timeOffSet);
				dataElement.add(Double.parseDouble(numberFormat.format(timeValue.getValue()/normalizingFactor)));
				
				dataArray.add(dataElement);
			}
		}
		put("data",dataArray);
		return toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcom To Java FLOT ----- Testing FLOT TIME SERIES BEAN");
		
		Map<Long,Double> time = new TreeMap<Long,Double>();
		
		time.put(new Long(1), new Double(100.456));
		time.put(new Long(2), new Double(200.23456E-10));
		time.put(new Long(3), new Double(-300));
		time.put(new Long(4), new Double(400));
		time.put(new Long(5), new Double(500));
		time.put(new Long(6), new Double(600));

		
		FlotTimeSeriesBean flotTimeSeriesBean = new FlotTimeSeriesBean("Ramesh Testin", null);
		flotTimeSeriesBean.setClickable(true);
		flotTimeSeriesBean.setColor("black");
		flotTimeSeriesBean.setHoverable(true);
		flotTimeSeriesBean.setXaxisNumber(2);
		
		System.out.println(flotTimeSeriesBean.getData());
		
	}

	@Override
	protected void loadDefaultOptionsMap() {
		put("normalizingFactor",1);
		put("timeOffSet",0);
		put("units","");
	}

}
