package com.java.flot.interactive;

import com.java.flot.FlotOptions;

/**
 * Include jquery.flot.navigate.js file.
 * <p>  Flot plugin for adding panning and zooming capabilities to a plot.
 * <br> 
 * <br> The default behaviour is double click and scrollwheel up/down to zoom
 * <br> in, drag to pan. The plugin defines plot.zoom({ center }),
 * <br> plot.zoomOut() and plot.pan(offset) so you easily can add custom
 * <br> controls. It also fires a "plotpan" and "plotzoom" event when
 * <br> something happens, useful for synchronizing plots.
 * <br> <p>
 * <br> Options:
 * <br> 
 * <br>   zoom: {
 * <br>     interactive: false
 * <br>     trigger: "dblclick" // or "click" for single click
 * <br>     amount: 1.5         // 2 = 200% (zoom in), 0.5 = 50% (zoom out)
 * <br>   }
 * <br>   
 * <br>   pan: {
 * <br>     interactive: false
 * <br>     cursor: "move"      // CSS mouse cursor value used when dragging, e.g. "pointer"
 * <br>     frameRate: 20
 * <br>   }
 * <br> 
 * <br>   xaxis, yaxis, x2axis, y2axis: {
 * <br>     zoomRange: null  // or [number, number] (min range, max range) or false
 * <br>     panRange: null   // or [number, number] (min, max) or false
 * <br>   }
 * <br>  <p> 
 * <br> "interactive" enables the built-in drag/click behaviour. If you enable
 * <br> interactive for pan, then you'll have a basic plot that supports
 * <br> moving around; the same for zoom.
 * <br> <p>
 * <br> "amount" specifies the default amount to zoom in (so 1.5 = 150%)
 * <br> relative to the current viewport.
 * <br> <p>
 * <br> "cursor" is a standard CSS mouse cursor string used for visual
 * <br> feedback to the user when dragging.
 * <br> <p>
 * <br> "frameRate" specifies the maximum number of times per second the plot
 * <br> will update itself while the user is panning around on it (set to null
 * <br> to disable intermediate pans, the plot will then not update until the
 * <br> mouse button is released).
 * <br> <p>
 * <br> "zoomRange" is the interval in which zooming can happen, e.g. with
 * <br> zoomRange: [1, 100] the zoom will never scale the axis so that the
 * <br> difference between min and max is smaller than 1 or larger than 100.
 * <br> You can set either end to null to ignore, e.g. [1, null]. If you set
 * <br> zoomRange to false, zooming on that axis will be disabled.
 * <br> <p>
 * <br> "panRange" confines the panning to stay within a range, e.g. with
 * <br> panRange: [-10, 20] panning stops at -10 in one end and at 20 in the
 * <br> other. Either can be null, e.g. [-10, null]. If you set
 * <br> panRange to false, panning on that axis will be disabled.
 * <br> <p>
 * <br> Example API usage:
 * <br> 
 * <br>   plot = $.plot(...);
 * <br>   
 * <br>   // zoom default amount in on the pixel (10, 20) 
 * <br>   plot.zoom({ center: { left: 10, top: 20 } });
 * <br> 
 * <br>   // zoom out again
 * <br>   plot.zoomOut({ center: { left: 10, top: 20 } });
 * <br> 
 * <br>   // zoom 200% in on the pixel (10, 20) 
 * <br>   plot.zoom({ amount: 2, center: { left: 10, top: 20 } });
 * <br>   
 * <br>   // pan 100 pixels to the left and 20 down
 * <br>   plot.pan({ left: -100, top: 20 })
 * <br> <p>
 * <br> Here, "center" specifies where the center of the zooming should
 * <br> happen. Note that this is defined in pixel space, not the space of the
 * <br> data points (you can use the p2c helpers on the axes in Flot to help
 * <br> you convert between these).
 * <br> <p>
 * <br> "amount" is the amount to zoom the viewport relative to the current
 * <br> range, so 1 is 100% (i.e. no change), 1.5 is 150% (zoom in), 0.7 is
 * <br> 70% (zoom out). You can set the default in the options.
 * <br> 
 * @author Venkata SSR Murthy Manda (mvssrmurthy@gmail.com)
 * @version 1.0
 */
public class FlotZoom extends FlotOptions {

	public enum TRIGGER {
		DOUBLE_CLICK("dblclick"),
		CLICK("click");
		String value;
		TRIGGER(String value){
			this.value = value;
		}
		@Override
		public String toString() {
			return value;
		}
	}

	//	/**
	//	 * @return the interactive
	//	 */
	//	public boolean isInteractive() {
	//		return interactive;
	//	}

	/**
	 * <br> "interactive" enables the built-in drag/click behaviour. If you enable
	 * <br> interactive for pan, then you'll have a basic plot that supports
	 * <br> moving around; the same for zoom.
	 * @param interactive the interactive to set
	 */
	public void setInteractive(boolean interactive) {
		put("interactive", interactive);
	}

	//	/**
	//	 * @return the trigger
	//	 */
	//	public TRIGGER getTrigger() {
	//		return trigger;
	//	}

	/**
	 * TRIGGER.DOUBLE_CLICK("dblclick"), TRIGGER.CLICK("click");
	 * @param trigger the trigger to set
	 */
	public void setTrigger(TRIGGER trigger) {
		put("trigger",trigger.toString());
	}

	//	/**
	//	 * @return the amount
	//	 */
	//	public double getAmount() {
	//		
	//	}

	/**
	 * <br> "amount" specifies the default amount to zoom in (so 1.5 = 150%)
	 * <br> relative to the current viewport.
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		put("amount",amount);
	}

	@Override
	protected void loadDefaultOptionsMap() {
		setInteractive(true);
	}
}
