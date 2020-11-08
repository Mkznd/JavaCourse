package chart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.mariuszgromada.math.mxparser.*;


public class FunctionHandler {
	private static String function;

	public static String getFunction() {
		return function;
	}

	public static void setFunction(String function) {
		FunctionHandler.function = function;
	}
	
	FunctionHandler(String f){
		function = f;
	}
	public static double Val(double x0) {
		Function f = new Function("f(x) = "+function);
		return f.calculate(x0);
		
	}
	public static XYDataset createDataset(double from, double to, double step) {

        var series = new XYSeries(function);
        for(double i = from;i<=to;i+=step) {
        	series.add(i, Val(i));
        }
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }
}
