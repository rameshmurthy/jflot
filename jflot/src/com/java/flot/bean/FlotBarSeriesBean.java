package com.java.flot.bean;

import java.text.NumberFormat;
import java.util.Map;

/**
 * Coming in next version
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotBarSeriesBean extends FlotSeriesBean {

	private NumberFormat numberFormat = null;
	
	/** name of time series */
	private String barSeriesName;
	/** data to be displayed on Flot chart - a map of time and value*/
	private Map<Double,Double> valueMap;
	/** a factor to be applied on values of data. Multiplication is performed on values.*/
	private double normalizingFactor = 1;
	/** time off set to be applied on time. Addition is performed on time*/
	private long barXAxisOffSet = 0;
	/** units of values ex: seconds, MB etc*/
	private String units = "";
	
	@Override
	public String getData() {
		if(numberFormat ==  null){
			numberFormat = NumberFormat.getInstance();
			numberFormat.setMaximumFractionDigits(2);
			numberFormat.setGroupingUsed(false);
		}
		StringBuffer data = new StringBuffer("");
		data.append("{label: \"").append(barSeriesName + "\", ");
		data.append("timeOffSet: \""+barXAxisOffSet + "\",");
		data.append("normalizingFactor: \""+normalizingFactor + "\",");
		data.append("units: \""+getUnits() + "\",");
		data.append("data: [");
		for( Map.Entry<Double, Double> barValue : valueMap.entrySet()){
			data.append("[").append(barValue.getKey()+barXAxisOffSet).append(",");
			data.append(numberFormat.format(barValue.getValue()/normalizingFactor)).append("]");
			data.append(", ");
		}
		data.deleteCharAt(data.lastIndexOf(","));
		data.append("]}, ");
		return data.toString();
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
	 * @return the barSeriesName
	 */
	public String getBarSeriesName() {
		return barSeriesName;
	}

	/**
	 * @param barSeriesName the barSeriesName to set
	 */
	public void setBarSeriesName(String barSeriesName) {
		this.barSeriesName = barSeriesName;
	}

	/**
	 * @return the valueMap
	 */
	public Map<Double, Double> getValueMap() {
		return valueMap;
	}

	/**
	 * @param valueMap the valueMap to set
	 */
	public void setValueMap(Map<Double, Double> valueMap) {
		this.valueMap = valueMap;
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
		this.normalizingFactor = normalizingFactor;
	}

	/**
	 * @return the timeOffSet
	 */
	public long getTimeOffSet() {
		return barXAxisOffSet;
	}

	/**
	 * @param timeOffSet the timeOffSet to set
	 */
	public void setTimeOffSet(long timeOffSet) {
		this.barXAxisOffSet = timeOffSet;
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
		this.units = units;
	}

	@Override
	protected void loadDefaultOptionsMap() {
		// TODO Auto-generated method stub
		
	}

}
