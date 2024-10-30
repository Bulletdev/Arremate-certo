package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTArea3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBar3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDTable;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLine3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPie3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStockChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

public class CTPlotAreaImpl extends XmlComplexContentImpl implements CTPlotArea {
  private static final b LAYOUT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout");
  
  private static final b AREACHART$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "areaChart");
  
  private static final b AREA3DCHART$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "area3DChart");
  
  private static final b LINECHART$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "lineChart");
  
  private static final b LINE3DCHART$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "line3DChart");
  
  private static final b STOCKCHART$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "stockChart");
  
  private static final b RADARCHART$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "radarChart");
  
  private static final b SCATTERCHART$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "scatterChart");
  
  private static final b PIECHART$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pieChart");
  
  private static final b PIE3DCHART$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pie3DChart");
  
  private static final b DOUGHNUTCHART$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "doughnutChart");
  
  private static final b BARCHART$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "barChart");
  
  private static final b BAR3DCHART$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "bar3DChart");
  
  private static final b OFPIECHART$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "ofPieChart");
  
  private static final b SURFACECHART$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "surfaceChart");
  
  private static final b SURFACE3DCHART$30 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "surface3DChart");
  
  private static final b BUBBLECHART$32 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "bubbleChart");
  
  private static final b VALAX$34 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "valAx");
  
  private static final b CATAX$36 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "catAx");
  
  private static final b DATEAX$38 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dateAx");
  
  private static final b SERAX$40 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "serAx");
  
  private static final b DTABLE$42 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dTable");
  
  private static final b SPPR$44 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b EXTLST$46 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTPlotAreaImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLayout getLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().find_element_user(LAYOUT$0, 0);
      if (cTLayout == null)
        return null; 
      return cTLayout;
    } 
  }
  
  public boolean isSetLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LAYOUT$0) != 0);
    } 
  }
  
  public void setLayout(CTLayout paramCTLayout) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().find_element_user(LAYOUT$0, 0);
      if (cTLayout == null)
        cTLayout = (CTLayout)get_store().add_element_user(LAYOUT$0); 
      cTLayout.set((XmlObject)paramCTLayout);
    } 
  }
  
  public CTLayout addNewLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().add_element_user(LAYOUT$0);
      return cTLayout;
    } 
  }
  
  public void unsetLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LAYOUT$0, 0);
    } 
  }
  
  public List<CTAreaChart> getAreaChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAreaChart>)new AreaChartList(this);
    } 
  }
  
  public CTAreaChart[] getAreaChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AREACHART$2, arrayList);
      CTAreaChart[] arrayOfCTAreaChart = new CTAreaChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAreaChart);
      return arrayOfCTAreaChart;
    } 
  }
  
  public CTAreaChart getAreaChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAreaChart cTAreaChart = null;
      cTAreaChart = (CTAreaChart)get_store().find_element_user(AREACHART$2, paramInt);
      if (cTAreaChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTAreaChart;
    } 
  }
  
  public int sizeOfAreaChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AREACHART$2);
    } 
  }
  
  public void setAreaChartArray(CTAreaChart[] paramArrayOfCTAreaChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAreaChart, AREACHART$2);
    } 
  }
  
  public void setAreaChartArray(int paramInt, CTAreaChart paramCTAreaChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTAreaChart cTAreaChart = null;
      cTAreaChart = (CTAreaChart)get_store().find_element_user(AREACHART$2, paramInt);
      if (cTAreaChart == null)
        throw new IndexOutOfBoundsException(); 
      cTAreaChart.set((XmlObject)paramCTAreaChart);
    } 
  }
  
  public CTAreaChart insertNewAreaChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAreaChart cTAreaChart = null;
      cTAreaChart = (CTAreaChart)get_store().insert_element_user(AREACHART$2, paramInt);
      return cTAreaChart;
    } 
  }
  
  public CTAreaChart addNewAreaChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTAreaChart cTAreaChart = null;
      cTAreaChart = (CTAreaChart)get_store().add_element_user(AREACHART$2);
      return cTAreaChart;
    } 
  }
  
  public void removeAreaChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AREACHART$2, paramInt);
    } 
  }
  
  public List<CTArea3DChart> getArea3DChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTArea3DChart>)new Area3DChartList(this);
    } 
  }
  
  public CTArea3DChart[] getArea3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AREA3DCHART$4, arrayList);
      CTArea3DChart[] arrayOfCTArea3DChart = new CTArea3DChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTArea3DChart);
      return arrayOfCTArea3DChart;
    } 
  }
  
  public CTArea3DChart getArea3DChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTArea3DChart cTArea3DChart = null;
      cTArea3DChart = (CTArea3DChart)get_store().find_element_user(AREA3DCHART$4, paramInt);
      if (cTArea3DChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTArea3DChart;
    } 
  }
  
  public int sizeOfArea3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AREA3DCHART$4);
    } 
  }
  
  public void setArea3DChartArray(CTArea3DChart[] paramArrayOfCTArea3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTArea3DChart, AREA3DCHART$4);
    } 
  }
  
  public void setArea3DChartArray(int paramInt, CTArea3DChart paramCTArea3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTArea3DChart cTArea3DChart = null;
      cTArea3DChart = (CTArea3DChart)get_store().find_element_user(AREA3DCHART$4, paramInt);
      if (cTArea3DChart == null)
        throw new IndexOutOfBoundsException(); 
      cTArea3DChart.set((XmlObject)paramCTArea3DChart);
    } 
  }
  
  public CTArea3DChart insertNewArea3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTArea3DChart cTArea3DChart = null;
      cTArea3DChart = (CTArea3DChart)get_store().insert_element_user(AREA3DCHART$4, paramInt);
      return cTArea3DChart;
    } 
  }
  
  public CTArea3DChart addNewArea3DChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTArea3DChart cTArea3DChart = null;
      cTArea3DChart = (CTArea3DChart)get_store().add_element_user(AREA3DCHART$4);
      return cTArea3DChart;
    } 
  }
  
  public void removeArea3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AREA3DCHART$4, paramInt);
    } 
  }
  
  public List<CTLineChart> getLineChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLineChart>)new LineChartList(this);
    } 
  }
  
  public CTLineChart[] getLineChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LINECHART$6, arrayList);
      CTLineChart[] arrayOfCTLineChart = new CTLineChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLineChart);
      return arrayOfCTLineChart;
    } 
  }
  
  public CTLineChart getLineChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineChart cTLineChart = null;
      cTLineChart = (CTLineChart)get_store().find_element_user(LINECHART$6, paramInt);
      if (cTLineChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTLineChart;
    } 
  }
  
  public int sizeOfLineChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LINECHART$6);
    } 
  }
  
  public void setLineChartArray(CTLineChart[] paramArrayOfCTLineChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLineChart, LINECHART$6);
    } 
  }
  
  public void setLineChartArray(int paramInt, CTLineChart paramCTLineChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineChart cTLineChart = null;
      cTLineChart = (CTLineChart)get_store().find_element_user(LINECHART$6, paramInt);
      if (cTLineChart == null)
        throw new IndexOutOfBoundsException(); 
      cTLineChart.set((XmlObject)paramCTLineChart);
    } 
  }
  
  public CTLineChart insertNewLineChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineChart cTLineChart = null;
      cTLineChart = (CTLineChart)get_store().insert_element_user(LINECHART$6, paramInt);
      return cTLineChart;
    } 
  }
  
  public CTLineChart addNewLineChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineChart cTLineChart = null;
      cTLineChart = (CTLineChart)get_store().add_element_user(LINECHART$6);
      return cTLineChart;
    } 
  }
  
  public void removeLineChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LINECHART$6, paramInt);
    } 
  }
  
  public List<CTLine3DChart> getLine3DChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLine3DChart>)new Line3DChartList(this);
    } 
  }
  
  public CTLine3DChart[] getLine3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LINE3DCHART$8, arrayList);
      CTLine3DChart[] arrayOfCTLine3DChart = new CTLine3DChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLine3DChart);
      return arrayOfCTLine3DChart;
    } 
  }
  
  public CTLine3DChart getLine3DChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLine3DChart cTLine3DChart = null;
      cTLine3DChart = (CTLine3DChart)get_store().find_element_user(LINE3DCHART$8, paramInt);
      if (cTLine3DChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTLine3DChart;
    } 
  }
  
  public int sizeOfLine3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LINE3DCHART$8);
    } 
  }
  
  public void setLine3DChartArray(CTLine3DChart[] paramArrayOfCTLine3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLine3DChart, LINE3DCHART$8);
    } 
  }
  
  public void setLine3DChartArray(int paramInt, CTLine3DChart paramCTLine3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTLine3DChart cTLine3DChart = null;
      cTLine3DChart = (CTLine3DChart)get_store().find_element_user(LINE3DCHART$8, paramInt);
      if (cTLine3DChart == null)
        throw new IndexOutOfBoundsException(); 
      cTLine3DChart.set((XmlObject)paramCTLine3DChart);
    } 
  }
  
  public CTLine3DChart insertNewLine3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLine3DChart cTLine3DChart = null;
      cTLine3DChart = (CTLine3DChart)get_store().insert_element_user(LINE3DCHART$8, paramInt);
      return cTLine3DChart;
    } 
  }
  
  public CTLine3DChart addNewLine3DChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTLine3DChart cTLine3DChart = null;
      cTLine3DChart = (CTLine3DChart)get_store().add_element_user(LINE3DCHART$8);
      return cTLine3DChart;
    } 
  }
  
  public void removeLine3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LINE3DCHART$8, paramInt);
    } 
  }
  
  public List<CTStockChart> getStockChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTStockChart>)new StockChartList(this);
    } 
  }
  
  public CTStockChart[] getStockChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(STOCKCHART$10, arrayList);
      CTStockChart[] arrayOfCTStockChart = new CTStockChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTStockChart);
      return arrayOfCTStockChart;
    } 
  }
  
  public CTStockChart getStockChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStockChart cTStockChart = null;
      cTStockChart = (CTStockChart)get_store().find_element_user(STOCKCHART$10, paramInt);
      if (cTStockChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTStockChart;
    } 
  }
  
  public int sizeOfStockChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(STOCKCHART$10);
    } 
  }
  
  public void setStockChartArray(CTStockChart[] paramArrayOfCTStockChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTStockChart, STOCKCHART$10);
    } 
  }
  
  public void setStockChartArray(int paramInt, CTStockChart paramCTStockChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTStockChart cTStockChart = null;
      cTStockChart = (CTStockChart)get_store().find_element_user(STOCKCHART$10, paramInt);
      if (cTStockChart == null)
        throw new IndexOutOfBoundsException(); 
      cTStockChart.set((XmlObject)paramCTStockChart);
    } 
  }
  
  public CTStockChart insertNewStockChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStockChart cTStockChart = null;
      cTStockChart = (CTStockChart)get_store().insert_element_user(STOCKCHART$10, paramInt);
      return cTStockChart;
    } 
  }
  
  public CTStockChart addNewStockChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTStockChart cTStockChart = null;
      cTStockChart = (CTStockChart)get_store().add_element_user(STOCKCHART$10);
      return cTStockChart;
    } 
  }
  
  public void removeStockChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STOCKCHART$10, paramInt);
    } 
  }
  
  public List<CTRadarChart> getRadarChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRadarChart>)new RadarChartList(this);
    } 
  }
  
  public CTRadarChart[] getRadarChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RADARCHART$12, arrayList);
      CTRadarChart[] arrayOfCTRadarChart = new CTRadarChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRadarChart);
      return arrayOfCTRadarChart;
    } 
  }
  
  public CTRadarChart getRadarChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRadarChart cTRadarChart = null;
      cTRadarChart = (CTRadarChart)get_store().find_element_user(RADARCHART$12, paramInt);
      if (cTRadarChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTRadarChart;
    } 
  }
  
  public int sizeOfRadarChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RADARCHART$12);
    } 
  }
  
  public void setRadarChartArray(CTRadarChart[] paramArrayOfCTRadarChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRadarChart, RADARCHART$12);
    } 
  }
  
  public void setRadarChartArray(int paramInt, CTRadarChart paramCTRadarChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTRadarChart cTRadarChart = null;
      cTRadarChart = (CTRadarChart)get_store().find_element_user(RADARCHART$12, paramInt);
      if (cTRadarChart == null)
        throw new IndexOutOfBoundsException(); 
      cTRadarChart.set((XmlObject)paramCTRadarChart);
    } 
  }
  
  public CTRadarChart insertNewRadarChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRadarChart cTRadarChart = null;
      cTRadarChart = (CTRadarChart)get_store().insert_element_user(RADARCHART$12, paramInt);
      return cTRadarChart;
    } 
  }
  
  public CTRadarChart addNewRadarChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTRadarChart cTRadarChart = null;
      cTRadarChart = (CTRadarChart)get_store().add_element_user(RADARCHART$12);
      return cTRadarChart;
    } 
  }
  
  public void removeRadarChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RADARCHART$12, paramInt);
    } 
  }
  
  public List<CTScatterChart> getScatterChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTScatterChart>)new ScatterChartList(this);
    } 
  }
  
  public CTScatterChart[] getScatterChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SCATTERCHART$14, arrayList);
      CTScatterChart[] arrayOfCTScatterChart = new CTScatterChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTScatterChart);
      return arrayOfCTScatterChart;
    } 
  }
  
  public CTScatterChart getScatterChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterChart cTScatterChart = null;
      cTScatterChart = (CTScatterChart)get_store().find_element_user(SCATTERCHART$14, paramInt);
      if (cTScatterChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTScatterChart;
    } 
  }
  
  public int sizeOfScatterChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SCATTERCHART$14);
    } 
  }
  
  public void setScatterChartArray(CTScatterChart[] paramArrayOfCTScatterChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTScatterChart, SCATTERCHART$14);
    } 
  }
  
  public void setScatterChartArray(int paramInt, CTScatterChart paramCTScatterChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterChart cTScatterChart = null;
      cTScatterChart = (CTScatterChart)get_store().find_element_user(SCATTERCHART$14, paramInt);
      if (cTScatterChart == null)
        throw new IndexOutOfBoundsException(); 
      cTScatterChart.set((XmlObject)paramCTScatterChart);
    } 
  }
  
  public CTScatterChart insertNewScatterChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterChart cTScatterChart = null;
      cTScatterChart = (CTScatterChart)get_store().insert_element_user(SCATTERCHART$14, paramInt);
      return cTScatterChart;
    } 
  }
  
  public CTScatterChart addNewScatterChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterChart cTScatterChart = null;
      cTScatterChart = (CTScatterChart)get_store().add_element_user(SCATTERCHART$14);
      return cTScatterChart;
    } 
  }
  
  public void removeScatterChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCATTERCHART$14, paramInt);
    } 
  }
  
  public List<CTPieChart> getPieChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPieChart>)new PieChartList(this);
    } 
  }
  
  public CTPieChart[] getPieChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PIECHART$16, arrayList);
      CTPieChart[] arrayOfCTPieChart = new CTPieChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPieChart);
      return arrayOfCTPieChart;
    } 
  }
  
  public CTPieChart getPieChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPieChart cTPieChart = null;
      cTPieChart = (CTPieChart)get_store().find_element_user(PIECHART$16, paramInt);
      if (cTPieChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTPieChart;
    } 
  }
  
  public int sizeOfPieChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PIECHART$16);
    } 
  }
  
  public void setPieChartArray(CTPieChart[] paramArrayOfCTPieChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPieChart, PIECHART$16);
    } 
  }
  
  public void setPieChartArray(int paramInt, CTPieChart paramCTPieChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTPieChart cTPieChart = null;
      cTPieChart = (CTPieChart)get_store().find_element_user(PIECHART$16, paramInt);
      if (cTPieChart == null)
        throw new IndexOutOfBoundsException(); 
      cTPieChart.set((XmlObject)paramCTPieChart);
    } 
  }
  
  public CTPieChart insertNewPieChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPieChart cTPieChart = null;
      cTPieChart = (CTPieChart)get_store().insert_element_user(PIECHART$16, paramInt);
      return cTPieChart;
    } 
  }
  
  public CTPieChart addNewPieChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTPieChart cTPieChart = null;
      cTPieChart = (CTPieChart)get_store().add_element_user(PIECHART$16);
      return cTPieChart;
    } 
  }
  
  public void removePieChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIECHART$16, paramInt);
    } 
  }
  
  public List<CTPie3DChart> getPie3DChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPie3DChart>)new Pie3DChartList(this);
    } 
  }
  
  public CTPie3DChart[] getPie3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PIE3DCHART$18, arrayList);
      CTPie3DChart[] arrayOfCTPie3DChart = new CTPie3DChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPie3DChart);
      return arrayOfCTPie3DChart;
    } 
  }
  
  public CTPie3DChart getPie3DChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPie3DChart cTPie3DChart = null;
      cTPie3DChart = (CTPie3DChart)get_store().find_element_user(PIE3DCHART$18, paramInt);
      if (cTPie3DChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTPie3DChart;
    } 
  }
  
  public int sizeOfPie3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PIE3DCHART$18);
    } 
  }
  
  public void setPie3DChartArray(CTPie3DChart[] paramArrayOfCTPie3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPie3DChart, PIE3DCHART$18);
    } 
  }
  
  public void setPie3DChartArray(int paramInt, CTPie3DChart paramCTPie3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTPie3DChart cTPie3DChart = null;
      cTPie3DChart = (CTPie3DChart)get_store().find_element_user(PIE3DCHART$18, paramInt);
      if (cTPie3DChart == null)
        throw new IndexOutOfBoundsException(); 
      cTPie3DChart.set((XmlObject)paramCTPie3DChart);
    } 
  }
  
  public CTPie3DChart insertNewPie3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPie3DChart cTPie3DChart = null;
      cTPie3DChart = (CTPie3DChart)get_store().insert_element_user(PIE3DCHART$18, paramInt);
      return cTPie3DChart;
    } 
  }
  
  public CTPie3DChart addNewPie3DChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTPie3DChart cTPie3DChart = null;
      cTPie3DChart = (CTPie3DChart)get_store().add_element_user(PIE3DCHART$18);
      return cTPie3DChart;
    } 
  }
  
  public void removePie3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIE3DCHART$18, paramInt);
    } 
  }
  
  public List<CTDoughnutChart> getDoughnutChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDoughnutChart>)new DoughnutChartList(this);
    } 
  }
  
  public CTDoughnutChart[] getDoughnutChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DOUGHNUTCHART$20, arrayList);
      CTDoughnutChart[] arrayOfCTDoughnutChart = new CTDoughnutChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDoughnutChart);
      return arrayOfCTDoughnutChart;
    } 
  }
  
  public CTDoughnutChart getDoughnutChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDoughnutChart cTDoughnutChart = null;
      cTDoughnutChart = (CTDoughnutChart)get_store().find_element_user(DOUGHNUTCHART$20, paramInt);
      if (cTDoughnutChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTDoughnutChart;
    } 
  }
  
  public int sizeOfDoughnutChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DOUGHNUTCHART$20);
    } 
  }
  
  public void setDoughnutChartArray(CTDoughnutChart[] paramArrayOfCTDoughnutChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDoughnutChart, DOUGHNUTCHART$20);
    } 
  }
  
  public void setDoughnutChartArray(int paramInt, CTDoughnutChart paramCTDoughnutChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTDoughnutChart cTDoughnutChart = null;
      cTDoughnutChart = (CTDoughnutChart)get_store().find_element_user(DOUGHNUTCHART$20, paramInt);
      if (cTDoughnutChart == null)
        throw new IndexOutOfBoundsException(); 
      cTDoughnutChart.set((XmlObject)paramCTDoughnutChart);
    } 
  }
  
  public CTDoughnutChart insertNewDoughnutChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDoughnutChart cTDoughnutChart = null;
      cTDoughnutChart = (CTDoughnutChart)get_store().insert_element_user(DOUGHNUTCHART$20, paramInt);
      return cTDoughnutChart;
    } 
  }
  
  public CTDoughnutChart addNewDoughnutChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTDoughnutChart cTDoughnutChart = null;
      cTDoughnutChart = (CTDoughnutChart)get_store().add_element_user(DOUGHNUTCHART$20);
      return cTDoughnutChart;
    } 
  }
  
  public void removeDoughnutChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOUGHNUTCHART$20, paramInt);
    } 
  }
  
  public List<CTBarChart> getBarChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBarChart>)new BarChartList(this);
    } 
  }
  
  public CTBarChart[] getBarChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BARCHART$22, arrayList);
      CTBarChart[] arrayOfCTBarChart = new CTBarChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBarChart);
      return arrayOfCTBarChart;
    } 
  }
  
  public CTBarChart getBarChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBarChart cTBarChart = null;
      cTBarChart = (CTBarChart)get_store().find_element_user(BARCHART$22, paramInt);
      if (cTBarChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTBarChart;
    } 
  }
  
  public int sizeOfBarChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BARCHART$22);
    } 
  }
  
  public void setBarChartArray(CTBarChart[] paramArrayOfCTBarChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBarChart, BARCHART$22);
    } 
  }
  
  public void setBarChartArray(int paramInt, CTBarChart paramCTBarChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTBarChart cTBarChart = null;
      cTBarChart = (CTBarChart)get_store().find_element_user(BARCHART$22, paramInt);
      if (cTBarChart == null)
        throw new IndexOutOfBoundsException(); 
      cTBarChart.set((XmlObject)paramCTBarChart);
    } 
  }
  
  public CTBarChart insertNewBarChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBarChart cTBarChart = null;
      cTBarChart = (CTBarChart)get_store().insert_element_user(BARCHART$22, paramInt);
      return cTBarChart;
    } 
  }
  
  public CTBarChart addNewBarChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTBarChart cTBarChart = null;
      cTBarChart = (CTBarChart)get_store().add_element_user(BARCHART$22);
      return cTBarChart;
    } 
  }
  
  public void removeBarChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BARCHART$22, paramInt);
    } 
  }
  
  public List<CTBar3DChart> getBar3DChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBar3DChart>)new Bar3DChartList(this);
    } 
  }
  
  public CTBar3DChart[] getBar3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BAR3DCHART$24, arrayList);
      CTBar3DChart[] arrayOfCTBar3DChart = new CTBar3DChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBar3DChart);
      return arrayOfCTBar3DChart;
    } 
  }
  
  public CTBar3DChart getBar3DChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBar3DChart cTBar3DChart = null;
      cTBar3DChart = (CTBar3DChart)get_store().find_element_user(BAR3DCHART$24, paramInt);
      if (cTBar3DChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTBar3DChart;
    } 
  }
  
  public int sizeOfBar3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BAR3DCHART$24);
    } 
  }
  
  public void setBar3DChartArray(CTBar3DChart[] paramArrayOfCTBar3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBar3DChart, BAR3DCHART$24);
    } 
  }
  
  public void setBar3DChartArray(int paramInt, CTBar3DChart paramCTBar3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTBar3DChart cTBar3DChart = null;
      cTBar3DChart = (CTBar3DChart)get_store().find_element_user(BAR3DCHART$24, paramInt);
      if (cTBar3DChart == null)
        throw new IndexOutOfBoundsException(); 
      cTBar3DChart.set((XmlObject)paramCTBar3DChart);
    } 
  }
  
  public CTBar3DChart insertNewBar3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBar3DChart cTBar3DChart = null;
      cTBar3DChart = (CTBar3DChart)get_store().insert_element_user(BAR3DCHART$24, paramInt);
      return cTBar3DChart;
    } 
  }
  
  public CTBar3DChart addNewBar3DChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTBar3DChart cTBar3DChart = null;
      cTBar3DChart = (CTBar3DChart)get_store().add_element_user(BAR3DCHART$24);
      return cTBar3DChart;
    } 
  }
  
  public void removeBar3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BAR3DCHART$24, paramInt);
    } 
  }
  
  public List<CTOfPieChart> getOfPieChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOfPieChart>)new OfPieChartList(this);
    } 
  }
  
  public CTOfPieChart[] getOfPieChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(OFPIECHART$26, arrayList);
      CTOfPieChart[] arrayOfCTOfPieChart = new CTOfPieChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOfPieChart);
      return arrayOfCTOfPieChart;
    } 
  }
  
  public CTOfPieChart getOfPieChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfPieChart cTOfPieChart = null;
      cTOfPieChart = (CTOfPieChart)get_store().find_element_user(OFPIECHART$26, paramInt);
      if (cTOfPieChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTOfPieChart;
    } 
  }
  
  public int sizeOfOfPieChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OFPIECHART$26);
    } 
  }
  
  public void setOfPieChartArray(CTOfPieChart[] paramArrayOfCTOfPieChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOfPieChart, OFPIECHART$26);
    } 
  }
  
  public void setOfPieChartArray(int paramInt, CTOfPieChart paramCTOfPieChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfPieChart cTOfPieChart = null;
      cTOfPieChart = (CTOfPieChart)get_store().find_element_user(OFPIECHART$26, paramInt);
      if (cTOfPieChart == null)
        throw new IndexOutOfBoundsException(); 
      cTOfPieChart.set((XmlObject)paramCTOfPieChart);
    } 
  }
  
  public CTOfPieChart insertNewOfPieChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfPieChart cTOfPieChart = null;
      cTOfPieChart = (CTOfPieChart)get_store().insert_element_user(OFPIECHART$26, paramInt);
      return cTOfPieChart;
    } 
  }
  
  public CTOfPieChart addNewOfPieChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfPieChart cTOfPieChart = null;
      cTOfPieChart = (CTOfPieChart)get_store().add_element_user(OFPIECHART$26);
      return cTOfPieChart;
    } 
  }
  
  public void removeOfPieChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OFPIECHART$26, paramInt);
    } 
  }
  
  public List<CTSurfaceChart> getSurfaceChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSurfaceChart>)new SurfaceChartList(this);
    } 
  }
  
  public CTSurfaceChart[] getSurfaceChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SURFACECHART$28, arrayList);
      CTSurfaceChart[] arrayOfCTSurfaceChart = new CTSurfaceChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSurfaceChart);
      return arrayOfCTSurfaceChart;
    } 
  }
  
  public CTSurfaceChart getSurfaceChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurfaceChart cTSurfaceChart = null;
      cTSurfaceChart = (CTSurfaceChart)get_store().find_element_user(SURFACECHART$28, paramInt);
      if (cTSurfaceChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTSurfaceChart;
    } 
  }
  
  public int sizeOfSurfaceChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SURFACECHART$28);
    } 
  }
  
  public void setSurfaceChartArray(CTSurfaceChart[] paramArrayOfCTSurfaceChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSurfaceChart, SURFACECHART$28);
    } 
  }
  
  public void setSurfaceChartArray(int paramInt, CTSurfaceChart paramCTSurfaceChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurfaceChart cTSurfaceChart = null;
      cTSurfaceChart = (CTSurfaceChart)get_store().find_element_user(SURFACECHART$28, paramInt);
      if (cTSurfaceChart == null)
        throw new IndexOutOfBoundsException(); 
      cTSurfaceChart.set((XmlObject)paramCTSurfaceChart);
    } 
  }
  
  public CTSurfaceChart insertNewSurfaceChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurfaceChart cTSurfaceChart = null;
      cTSurfaceChart = (CTSurfaceChart)get_store().insert_element_user(SURFACECHART$28, paramInt);
      return cTSurfaceChart;
    } 
  }
  
  public CTSurfaceChart addNewSurfaceChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurfaceChart cTSurfaceChart = null;
      cTSurfaceChart = (CTSurfaceChart)get_store().add_element_user(SURFACECHART$28);
      return cTSurfaceChart;
    } 
  }
  
  public void removeSurfaceChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SURFACECHART$28, paramInt);
    } 
  }
  
  public List<CTSurface3DChart> getSurface3DChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSurface3DChart>)new Surface3DChartList(this);
    } 
  }
  
  public CTSurface3DChart[] getSurface3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SURFACE3DCHART$30, arrayList);
      CTSurface3DChart[] arrayOfCTSurface3DChart = new CTSurface3DChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSurface3DChart);
      return arrayOfCTSurface3DChart;
    } 
  }
  
  public CTSurface3DChart getSurface3DChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface3DChart cTSurface3DChart = null;
      cTSurface3DChart = (CTSurface3DChart)get_store().find_element_user(SURFACE3DCHART$30, paramInt);
      if (cTSurface3DChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTSurface3DChart;
    } 
  }
  
  public int sizeOfSurface3DChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SURFACE3DCHART$30);
    } 
  }
  
  public void setSurface3DChartArray(CTSurface3DChart[] paramArrayOfCTSurface3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSurface3DChart, SURFACE3DCHART$30);
    } 
  }
  
  public void setSurface3DChartArray(int paramInt, CTSurface3DChart paramCTSurface3DChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface3DChart cTSurface3DChart = null;
      cTSurface3DChart = (CTSurface3DChart)get_store().find_element_user(SURFACE3DCHART$30, paramInt);
      if (cTSurface3DChart == null)
        throw new IndexOutOfBoundsException(); 
      cTSurface3DChart.set((XmlObject)paramCTSurface3DChart);
    } 
  }
  
  public CTSurface3DChart insertNewSurface3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface3DChart cTSurface3DChart = null;
      cTSurface3DChart = (CTSurface3DChart)get_store().insert_element_user(SURFACE3DCHART$30, paramInt);
      return cTSurface3DChart;
    } 
  }
  
  public CTSurface3DChart addNewSurface3DChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTSurface3DChart cTSurface3DChart = null;
      cTSurface3DChart = (CTSurface3DChart)get_store().add_element_user(SURFACE3DCHART$30);
      return cTSurface3DChart;
    } 
  }
  
  public void removeSurface3DChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SURFACE3DCHART$30, paramInt);
    } 
  }
  
  public List<CTBubbleChart> getBubbleChartList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBubbleChart>)new BubbleChartList(this);
    } 
  }
  
  public CTBubbleChart[] getBubbleChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BUBBLECHART$32, arrayList);
      CTBubbleChart[] arrayOfCTBubbleChart = new CTBubbleChart[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBubbleChart);
      return arrayOfCTBubbleChart;
    } 
  }
  
  public CTBubbleChart getBubbleChartArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBubbleChart cTBubbleChart = null;
      cTBubbleChart = (CTBubbleChart)get_store().find_element_user(BUBBLECHART$32, paramInt);
      if (cTBubbleChart == null)
        throw new IndexOutOfBoundsException(); 
      return cTBubbleChart;
    } 
  }
  
  public int sizeOfBubbleChartArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BUBBLECHART$32);
    } 
  }
  
  public void setBubbleChartArray(CTBubbleChart[] paramArrayOfCTBubbleChart) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBubbleChart, BUBBLECHART$32);
    } 
  }
  
  public void setBubbleChartArray(int paramInt, CTBubbleChart paramCTBubbleChart) {
    synchronized (monitor()) {
      check_orphaned();
      CTBubbleChart cTBubbleChart = null;
      cTBubbleChart = (CTBubbleChart)get_store().find_element_user(BUBBLECHART$32, paramInt);
      if (cTBubbleChart == null)
        throw new IndexOutOfBoundsException(); 
      cTBubbleChart.set((XmlObject)paramCTBubbleChart);
    } 
  }
  
  public CTBubbleChart insertNewBubbleChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBubbleChart cTBubbleChart = null;
      cTBubbleChart = (CTBubbleChart)get_store().insert_element_user(BUBBLECHART$32, paramInt);
      return cTBubbleChart;
    } 
  }
  
  public CTBubbleChart addNewBubbleChart() {
    synchronized (monitor()) {
      check_orphaned();
      CTBubbleChart cTBubbleChart = null;
      cTBubbleChart = (CTBubbleChart)get_store().add_element_user(BUBBLECHART$32);
      return cTBubbleChart;
    } 
  }
  
  public void removeBubbleChart(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BUBBLECHART$32, paramInt);
    } 
  }
  
  public List<CTValAx> getValAxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTValAx>)new ValAxList(this);
    } 
  }
  
  public CTValAx[] getValAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VALAX$34, arrayList);
      CTValAx[] arrayOfCTValAx = new CTValAx[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTValAx);
      return arrayOfCTValAx;
    } 
  }
  
  public CTValAx getValAxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTValAx cTValAx = null;
      cTValAx = (CTValAx)get_store().find_element_user(VALAX$34, paramInt);
      if (cTValAx == null)
        throw new IndexOutOfBoundsException(); 
      return cTValAx;
    } 
  }
  
  public int sizeOfValAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VALAX$34);
    } 
  }
  
  public void setValAxArray(CTValAx[] paramArrayOfCTValAx) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTValAx, VALAX$34);
    } 
  }
  
  public void setValAxArray(int paramInt, CTValAx paramCTValAx) {
    synchronized (monitor()) {
      check_orphaned();
      CTValAx cTValAx = null;
      cTValAx = (CTValAx)get_store().find_element_user(VALAX$34, paramInt);
      if (cTValAx == null)
        throw new IndexOutOfBoundsException(); 
      cTValAx.set((XmlObject)paramCTValAx);
    } 
  }
  
  public CTValAx insertNewValAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTValAx cTValAx = null;
      cTValAx = (CTValAx)get_store().insert_element_user(VALAX$34, paramInt);
      return cTValAx;
    } 
  }
  
  public CTValAx addNewValAx() {
    synchronized (monitor()) {
      check_orphaned();
      CTValAx cTValAx = null;
      cTValAx = (CTValAx)get_store().add_element_user(VALAX$34);
      return cTValAx;
    } 
  }
  
  public void removeValAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VALAX$34, paramInt);
    } 
  }
  
  public List<CTCatAx> getCatAxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCatAx>)new CatAxList(this);
    } 
  }
  
  public CTCatAx[] getCatAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CATAX$36, arrayList);
      CTCatAx[] arrayOfCTCatAx = new CTCatAx[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCatAx);
      return arrayOfCTCatAx;
    } 
  }
  
  public CTCatAx getCatAxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCatAx cTCatAx = null;
      cTCatAx = (CTCatAx)get_store().find_element_user(CATAX$36, paramInt);
      if (cTCatAx == null)
        throw new IndexOutOfBoundsException(); 
      return cTCatAx;
    } 
  }
  
  public int sizeOfCatAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CATAX$36);
    } 
  }
  
  public void setCatAxArray(CTCatAx[] paramArrayOfCTCatAx) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCatAx, CATAX$36);
    } 
  }
  
  public void setCatAxArray(int paramInt, CTCatAx paramCTCatAx) {
    synchronized (monitor()) {
      check_orphaned();
      CTCatAx cTCatAx = null;
      cTCatAx = (CTCatAx)get_store().find_element_user(CATAX$36, paramInt);
      if (cTCatAx == null)
        throw new IndexOutOfBoundsException(); 
      cTCatAx.set((XmlObject)paramCTCatAx);
    } 
  }
  
  public CTCatAx insertNewCatAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCatAx cTCatAx = null;
      cTCatAx = (CTCatAx)get_store().insert_element_user(CATAX$36, paramInt);
      return cTCatAx;
    } 
  }
  
  public CTCatAx addNewCatAx() {
    synchronized (monitor()) {
      check_orphaned();
      CTCatAx cTCatAx = null;
      cTCatAx = (CTCatAx)get_store().add_element_user(CATAX$36);
      return cTCatAx;
    } 
  }
  
  public void removeCatAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CATAX$36, paramInt);
    } 
  }
  
  public List<CTDateAx> getDateAxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDateAx>)new DateAxList(this);
    } 
  }
  
  public CTDateAx[] getDateAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DATEAX$38, arrayList);
      CTDateAx[] arrayOfCTDateAx = new CTDateAx[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDateAx);
      return arrayOfCTDateAx;
    } 
  }
  
  public CTDateAx getDateAxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDateAx cTDateAx = null;
      cTDateAx = (CTDateAx)get_store().find_element_user(DATEAX$38, paramInt);
      if (cTDateAx == null)
        throw new IndexOutOfBoundsException(); 
      return cTDateAx;
    } 
  }
  
  public int sizeOfDateAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DATEAX$38);
    } 
  }
  
  public void setDateAxArray(CTDateAx[] paramArrayOfCTDateAx) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDateAx, DATEAX$38);
    } 
  }
  
  public void setDateAxArray(int paramInt, CTDateAx paramCTDateAx) {
    synchronized (monitor()) {
      check_orphaned();
      CTDateAx cTDateAx = null;
      cTDateAx = (CTDateAx)get_store().find_element_user(DATEAX$38, paramInt);
      if (cTDateAx == null)
        throw new IndexOutOfBoundsException(); 
      cTDateAx.set((XmlObject)paramCTDateAx);
    } 
  }
  
  public CTDateAx insertNewDateAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDateAx cTDateAx = null;
      cTDateAx = (CTDateAx)get_store().insert_element_user(DATEAX$38, paramInt);
      return cTDateAx;
    } 
  }
  
  public CTDateAx addNewDateAx() {
    synchronized (monitor()) {
      check_orphaned();
      CTDateAx cTDateAx = null;
      cTDateAx = (CTDateAx)get_store().add_element_user(DATEAX$38);
      return cTDateAx;
    } 
  }
  
  public void removeDateAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATEAX$38, paramInt);
    } 
  }
  
  public List<CTSerAx> getSerAxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSerAx>)new SerAxList(this);
    } 
  }
  
  public CTSerAx[] getSerAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SERAX$40, arrayList);
      CTSerAx[] arrayOfCTSerAx = new CTSerAx[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSerAx);
      return arrayOfCTSerAx;
    } 
  }
  
  public CTSerAx getSerAxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSerAx cTSerAx = null;
      cTSerAx = (CTSerAx)get_store().find_element_user(SERAX$40, paramInt);
      if (cTSerAx == null)
        throw new IndexOutOfBoundsException(); 
      return cTSerAx;
    } 
  }
  
  public int sizeOfSerAxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SERAX$40);
    } 
  }
  
  public void setSerAxArray(CTSerAx[] paramArrayOfCTSerAx) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSerAx, SERAX$40);
    } 
  }
  
  public void setSerAxArray(int paramInt, CTSerAx paramCTSerAx) {
    synchronized (monitor()) {
      check_orphaned();
      CTSerAx cTSerAx = null;
      cTSerAx = (CTSerAx)get_store().find_element_user(SERAX$40, paramInt);
      if (cTSerAx == null)
        throw new IndexOutOfBoundsException(); 
      cTSerAx.set((XmlObject)paramCTSerAx);
    } 
  }
  
  public CTSerAx insertNewSerAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSerAx cTSerAx = null;
      cTSerAx = (CTSerAx)get_store().insert_element_user(SERAX$40, paramInt);
      return cTSerAx;
    } 
  }
  
  public CTSerAx addNewSerAx() {
    synchronized (monitor()) {
      check_orphaned();
      CTSerAx cTSerAx = null;
      cTSerAx = (CTSerAx)get_store().add_element_user(SERAX$40);
      return cTSerAx;
    } 
  }
  
  public void removeSerAx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SERAX$40, paramInt);
    } 
  }
  
  public CTDTable getDTable() {
    synchronized (monitor()) {
      check_orphaned();
      CTDTable cTDTable = null;
      cTDTable = (CTDTable)get_store().find_element_user(DTABLE$42, 0);
      if (cTDTable == null)
        return null; 
      return cTDTable;
    } 
  }
  
  public boolean isSetDTable() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DTABLE$42) != 0);
    } 
  }
  
  public void setDTable(CTDTable paramCTDTable) {
    synchronized (monitor()) {
      check_orphaned();
      CTDTable cTDTable = null;
      cTDTable = (CTDTable)get_store().find_element_user(DTABLE$42, 0);
      if (cTDTable == null)
        cTDTable = (CTDTable)get_store().add_element_user(DTABLE$42); 
      cTDTable.set((XmlObject)paramCTDTable);
    } 
  }
  
  public CTDTable addNewDTable() {
    synchronized (monitor()) {
      check_orphaned();
      CTDTable cTDTable = null;
      cTDTable = (CTDTable)get_store().add_element_user(DTABLE$42);
      return cTDTable;
    } 
  }
  
  public void unsetDTable() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DTABLE$42, 0);
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$44, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public boolean isSetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPPR$44) != 0);
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$44, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$44); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$44);
      return cTShapeProperties;
    } 
  }
  
  public void unsetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPPR$44, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$46, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$46) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$46, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$46); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$46);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$46, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTPlotAreaImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */