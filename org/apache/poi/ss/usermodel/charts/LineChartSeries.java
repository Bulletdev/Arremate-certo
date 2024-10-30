package org.apache.poi.ss.usermodel.charts;

public interface LineChartSeries extends ChartSeries {
  ChartDataSource<?> getCategoryAxisData();
  
  ChartDataSource<? extends Number> getValues();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\LineChartSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */