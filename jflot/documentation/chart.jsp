<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 <HEAD>
<BODY>
<div id="${idOfGraph}" align="center">
	<div id="flotHolder" style="width:${graphWidth};height:${graphHeight}" align="center"></div>
	<div id="legend" style="width:${graphWidth};height:20px" align="center"></div>
</div>
<!--[if IE]><script language="javascript" type="text/javascript" src="flot/excanvas.min.js"></script><![endif]--> 
 <script language="javascript" type="text/javascript" src="flot/jquery.min.js"></script>
 <script language="javascript" type="text/javascript" src="flot/jquery.flot.min.js"></script>
 <script language="javascript" type="text/javascript" src="flot/jquery.flot.axislabel.js"></script>
 <script language="javascript" type="text/javascript" src="flot/jquery.flot.navigate.min.js"></script>

<script type="text/javascript">
$(function () {

	var data = ${data};
    
	var options =  ${flotOptions};
    var plot = $.plot($("#${idOfGraph} #flotHolder"), data , options);

	//Place Holder whether to show axis ticks or not. If plot options is used to do this horizontal or vertical grid lines are not getting displayed.
	// To keep grid lines and to show or not to show axis ticks these place holders are added.
	//${showXAxisGridsWithoutTicks};
	//${showYAxisGridsWithoutTicks};

    function showTooltip(x, y, contents, borderColor) {
		var leftToolTip = x - $("#${idOfGraph}").offset().left + 10;
		var topToolTip = y - $("#${idOfGraph}").offset().top + 20;

		if(leftToolTip >= ($("#${idOfGraph} #flotHolder").width()-20))
			leftToolTip = leftToolTip - 200;

        $('<div id="tooltip">' + contents + '</div>').css( {
            position: 'absolute',
            display: 'none',
			top: topToolTip,
            left: leftToolTip,
			border: '2px solid '+borderColor,
            padding: '2px',
			'border-radius':'0.5em',
            'background-color': '#ffffff',
            opacity: 0.80
        }).appendTo("#${idOfGraph}").fadeIn(200);
    }

    var previousPoint = null;
    $("#${idOfGraph} #flotHolder").bind("plothover", function (event, pos, item) {
    
		if (item) {
			if (previousPoint != item.dataIndex) {
				previousPoint = item.dataIndex;
				
				$("#tooltip").remove();
				var x = item.datapoint[0].toFixed(2),
					y = (item.datapoint[1]*item.series.normalizingFactor).toFixed(2);
				
				var date = new Date(item.datapoint[0]);

				var content =  "<div align='center'> <b>"+item.series.label+"</b>" + "<br>" +
							  " ( " + $.plot.formatDate(date,"%m/%d/%y %h:%M %P",null) + " , " + y +item.series.units+" )</div>";

				showTooltip(item.pageX, item.pageY,content,item.series.color);
			}
		}
		else {
			$("#tooltip").remove();
			previousPoint = null;            
		}
        
    });
    
});
</script>

</BODY>

</HTML>