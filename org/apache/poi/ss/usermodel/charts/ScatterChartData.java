package org.apache.poi.ss.usermodel.charts;

import java.util.List;

public interface ScatterChartData extends ChartData {
  ScatterChartSeries addSerie(ChartDataSource<?> paramChartDataSource, ChartDataSource<? extends Number> paramChartDataSource1);
  
  List<? extends ScatterChartSeries> getSeries();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\ScatterChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */