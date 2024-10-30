package org.apache.poi.ss.usermodel.charts;

public interface ScatterChartSeries extends ChartSeries {
  ChartDataSource<?> getXValues();
  
  ChartDataSource<? extends Number> getYValues();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\ScatterChartSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */