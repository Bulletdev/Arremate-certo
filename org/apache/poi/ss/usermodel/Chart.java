package org.apache.poi.ss.usermodel;

import java.util.List;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartAxisFactory;
import org.apache.poi.ss.usermodel.charts.ChartData;
import org.apache.poi.ss.usermodel.charts.ChartDataFactory;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.ManuallyPositionable;

public interface Chart extends ManuallyPositionable {
  ChartDataFactory getChartDataFactory();
  
  ChartAxisFactory getChartAxisFactory();
  
  ChartLegend getOrCreateLegend();
  
  void deleteLegend();
  
  List<? extends ChartAxis> getAxis();
  
  void plot(ChartData paramChartData, ChartAxis... paramVarArgs);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Chart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */