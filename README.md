jflot
=====

Java Library for flot charting tool
JFlot creates JAVA Objects to generate JSON objects for constructing flot charts. For any charting module, data , options (how to diplay,
labels, grids, threshold lines, back ground color, line width, poin size, bar, pie, time series etc) are needed. Flot is not different from it.
JFlot has all required java classes to support all types of flot charts. 

Flot is a Javascript plotting library for jQuery. Read more at the
website:

  http://code.google.com/p/flot/

The steps to follow to construct flot chart using PFJFlot is listed below.

Requirements
--------------
1) download java script flot charting library from http://code.google.com/p/flot/
2) add chart.jsp into your web project (like WEB-INF/jsp/.)
3) add FlotChartView.java if the web project is built on spring MVC. If your project is not built on spring mvc,
   then controller  class (Struts) or  Serverlet class (j2ee application without any mvc) add
   flotOptions, idOfGraph, data, graphHeight, graphWidth objects which are used in chart.jsp.

Steps creating FlotChart
-------------------------
1) Creation of time series chart :
----------------------------------
		1) FlotTimeSeriesBean flotTimeSeriesBean = new FlotTimeSeriesBean(timeSeriesName, timeValueMap);
		   create FlotTimeSeriesBean with paraments series name (String) and time value map (Map<Long,Double>) in the ascending order of time.
		   This order is important, as the values are displayed in the same order.
		2) Set normalizing factor to add normalization on the values, Default value is set to 1.
			ex : if the value is 1200 and normalizating factor is 10 then the value is displayed as 120, but tool tip shows it as 1200.
			flotTimeSeriesBean.setNormalizingFactor(normalizingFactor);
		3) Set units of values. Default is empty string "".
  		   flotTimeSeriesBean.setUnits(yAxisMeter);
		

		4) Add the flotTimeSeriesBean to List<FlotTimeSeriesBean> flotTimeSeriesBeans, repeat steps 1 to 4 if more than one series needs to be displayed in the
		   same chart.

		5) Construct FlotTimeSeriesChart by passing flotTimeSeriesBeans
			FlotTimeSeriesChart flotTimeSeriesChart = new FlotTimeSeriesChart(flotTimeSeriesBeans);
		
		6) set id of flot graph, this is important if you have multiple flot charts in the same page (not multiple series in same chart)
		   default id is "placeholder". If only one chart is present in the same page then no need to set this property.
			singleAttributeFlotChart.setIdOfFlotGraph(idOFGraph);
	        7) Construct FlotChartView object, if the framework is spring mvc. If not just check the code of FlotChartView and replicate it into
		   Servelet or controller (struts) class.
			FlotChartView flotChartView = new FlotChartView(singleAttributeFlotChart,graphWidth,graphHeight);
		8) This completes entire process of creation of FlotChart.

2) Adding Zoom and pan, interative ness :
-----------------------------------------
	1) add <script language="javascript" type="text/javascript" src="flot/jquery.flot.navigate.min.js"></script> in chart.jsp if not present.
	
	2) Create FlotZoom and FlotPan objects and set it to FlotChart.
		flotTimeSeriesChart.setFlotZoom(new FlotZoom());
		flotTimeSeriesChart.setFlotPan(new FlotPan());

3) Adding Threshold lines (horizontal or vertical lines to flot chart) :
-----------------------------------------------------------------------
			//holds all FlotMarking objects
			FlotMarkings flotMarkings = new FlotMarkings();		
			
			//Create a FlotMarking object and setYRange for horizontal line, setXRange for vertical line.
			FlotMarking flotMarking = new FlotMarking();

			//FlotRange takes from and to values. If both are equal only single line is drawn 
			//other wise area covering by from and to values is drawn
			FlotRange yRange = new FlotRange(criticalThresholdValue,criticalThresholdValue);
		
			flotMarking.setYRange(yRange);
			flotMarking.setColor("#ff0000");
			flotMarkings.addMarking(flotMarking);
			
			//Markings are added to FlotGrid object, get the flot grid from the FlotChart object
			FlotGrid flotGrid = flotTimeSeriesChart.getFlotGrid();
			flotGrid.setMarkings(flotMarkings);
