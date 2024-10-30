package org.apache.poi.ss.usermodel.charts;

import java.util.List;

public interface LineChartData extends ChartData {
  LineChartSeries addSeries(ChartDataSource<?> paramChartDataSource, ChartDataSource<? extends Number> paramChartDataSource1);
  
  List<? extends LineChartSeries> getSeries();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\LineChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */