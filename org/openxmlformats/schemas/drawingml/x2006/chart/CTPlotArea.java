package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.w3c.dom.Node;

public interface CTPlotArea extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPlotArea.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctplotarea106etype");
  
  CTLayout getLayout();
  
  boolean isSetLayout();
  
  void setLayout(CTLayout paramCTLayout);
  
  CTLayout addNewLayout();
  
  void unsetLayout();
  
  List<CTAreaChart> getAreaChartList();
  
  CTAreaChart[] getAreaChartArray();
  
  CTAreaChart getAreaChartArray(int paramInt);
  
  int sizeOfAreaChartArray();
  
  void setAreaChartArray(CTAreaChart[] paramArrayOfCTAreaChart);
  
  void setAreaChartArray(int paramInt, CTAreaChart paramCTAreaChart);
  
  CTAreaChart insertNewAreaChart(int paramInt);
  
  CTAreaChart addNewAreaChart();
  
  void removeAreaChart(int paramInt);
  
  List<CTArea3DChart> getArea3DChartList();
  
  CTArea3DChart[] getArea3DChartArray();
  
  CTArea3DChart getArea3DChartArray(int paramInt);
  
  int sizeOfArea3DChartArray();
  
  void setArea3DChartArray(CTArea3DChart[] paramArrayOfCTArea3DChart);
  
  void setArea3DChartArray(int paramInt, CTArea3DChart paramCTArea3DChart);
  
  CTArea3DChart insertNewArea3DChart(int paramInt);
  
  CTArea3DChart addNewArea3DChart();
  
  void removeArea3DChart(int paramInt);
  
  List<CTLineChart> getLineChartList();
  
  CTLineChart[] getLineChartArray();
  
  CTLineChart getLineChartArray(int paramInt);
  
  int sizeOfLineChartArray();
  
  void setLineChartArray(CTLineChart[] paramArrayOfCTLineChart);
  
  void setLineChartArray(int paramInt, CTLineChart paramCTLineChart);
  
  CTLineChart insertNewLineChart(int paramInt);
  
  CTLineChart addNewLineChart();
  
  void removeLineChart(int paramInt);
  
  List<CTLine3DChart> getLine3DChartList();
  
  CTLine3DChart[] getLine3DChartArray();
  
  CTLine3DChart getLine3DChartArray(int paramInt);
  
  int sizeOfLine3DChartArray();
  
  void setLine3DChartArray(CTLine3DChart[] paramArrayOfCTLine3DChart);
  
  void setLine3DChartArray(int paramInt, CTLine3DChart paramCTLine3DChart);
  
  CTLine3DChart insertNewLine3DChart(int paramInt);
  
  CTLine3DChart addNewLine3DChart();
  
  void removeLine3DChart(int paramInt);
  
  List<CTStockChart> getStockChartList();
  
  CTStockChart[] getStockChartArray();
  
  CTStockChart getStockChartArray(int paramInt);
  
  int sizeOfStockChartArray();
  
  void setStockChartArray(CTStockChart[] paramArrayOfCTStockChart);
  
  void setStockChartArray(int paramInt, CTStockChart paramCTStockChart);
  
  CTStockChart insertNewStockChart(int paramInt);
  
  CTStockChart addNewStockChart();
  
  void removeStockChart(int paramInt);
  
  List<CTRadarChart> getRadarChartList();
  
  CTRadarChart[] getRadarChartArray();
  
  CTRadarChart getRadarChartArray(int paramInt);
  
  int sizeOfRadarChartArray();
  
  void setRadarChartArray(CTRadarChart[] paramArrayOfCTRadarChart);
  
  void setRadarChartArray(int paramInt, CTRadarChart paramCTRadarChart);
  
  CTRadarChart insertNewRadarChart(int paramInt);
  
  CTRadarChart addNewRadarChart();
  
  void removeRadarChart(int paramInt);
  
  List<CTScatterChart> getScatterChartList();
  
  CTScatterChart[] getScatterChartArray();
  
  CTScatterChart getScatterChartArray(int paramInt);
  
  int sizeOfScatterChartArray();
  
  void setScatterChartArray(CTScatterChart[] paramArrayOfCTScatterChart);
  
  void setScatterChartArray(int paramInt, CTScatterChart paramCTScatterChart);
  
  CTScatterChart insertNewScatterChart(int paramInt);
  
  CTScatterChart addNewScatterChart();
  
  void removeScatterChart(int paramInt);
  
  List<CTPieChart> getPieChartList();
  
  CTPieChart[] getPieChartArray();
  
  CTPieChart getPieChartArray(int paramInt);
  
  int sizeOfPieChartArray();
  
  void setPieChartArray(CTPieChart[] paramArrayOfCTPieChart);
  
  void setPieChartArray(int paramInt, CTPieChart paramCTPieChart);
  
  CTPieChart insertNewPieChart(int paramInt);
  
  CTPieChart addNewPieChart();
  
  void removePieChart(int paramInt);
  
  List<CTPie3DChart> getPie3DChartList();
  
  CTPie3DChart[] getPie3DChartArray();
  
  CTPie3DChart getPie3DChartArray(int paramInt);
  
  int sizeOfPie3DChartArray();
  
  void setPie3DChartArray(CTPie3DChart[] paramArrayOfCTPie3DChart);
  
  void setPie3DChartArray(int paramInt, CTPie3DChart paramCTPie3DChart);
  
  CTPie3DChart insertNewPie3DChart(int paramInt);
  
  CTPie3DChart addNewPie3DChart();
  
  void removePie3DChart(int paramInt);
  
  List<CTDoughnutChart> getDoughnutChartList();
  
  CTDoughnutChart[] getDoughnutChartArray();
  
  CTDoughnutChart getDoughnutChartArray(int paramInt);
  
  int sizeOfDoughnutChartArray();
  
  void setDoughnutChartArray(CTDoughnutChart[] paramArrayOfCTDoughnutChart);
  
  void setDoughnutChartArray(int paramInt, CTDoughnutChart paramCTDoughnutChart);
  
  CTDoughnutChart insertNewDoughnutChart(int paramInt);
  
  CTDoughnutChart addNewDoughnutChart();
  
  void removeDoughnutChart(int paramInt);
  
  List<CTBarChart> getBarChartList();
  
  CTBarChart[] getBarChartArray();
  
  CTBarChart getBarChartArray(int paramInt);
  
  int sizeOfBarChartArray();
  
  void setBarChartArray(CTBarChart[] paramArrayOfCTBarChart);
  
  void setBarChartArray(int paramInt, CTBarChart paramCTBarChart);
  
  CTBarChart insertNewBarChart(int paramInt);
  
  CTBarChart addNewBarChart();
  
  void removeBarChart(int paramInt);
  
  List<CTBar3DChart> getBar3DChartList();
  
  CTBar3DChart[] getBar3DChartArray();
  
  CTBar3DChart getBar3DChartArray(int paramInt);
  
  int sizeOfBar3DChartArray();
  
  void setBar3DChartArray(CTBar3DChart[] paramArrayOfCTBar3DChart);
  
  void setBar3DChartArray(int paramInt, CTBar3DChart paramCTBar3DChart);
  
  CTBar3DChart insertNewBar3DChart(int paramInt);
  
  CTBar3DChart addNewBar3DChart();
  
  void removeBar3DChart(int paramInt);
  
  List<CTOfPieChart> getOfPieChartList();
  
  CTOfPieChart[] getOfPieChartArray();
  
  CTOfPieChart getOfPieChartArray(int paramInt);
  
  int sizeOfOfPieChartArray();
  
  void setOfPieChartArray(CTOfPieChart[] paramArrayOfCTOfPieChart);
  
  void setOfPieChartArray(int paramInt, CTOfPieChart paramCTOfPieChart);
  
  CTOfPieChart insertNewOfPieChart(int paramInt);
  
  CTOfPieChart addNewOfPieChart();
  
  void removeOfPieChart(int paramInt);
  
  List<CTSurfaceChart> getSurfaceChartList();
  
  CTSurfaceChart[] getSurfaceChartArray();
  
  CTSurfaceChart getSurfaceChartArray(int paramInt);
  
  int sizeOfSurfaceChartArray();
  
  void setSurfaceChartArray(CTSurfaceChart[] paramArrayOfCTSurfaceChart);
  
  void setSurfaceChartArray(int paramInt, CTSurfaceChart paramCTSurfaceChart);
  
  CTSurfaceChart insertNewSurfaceChart(int paramInt);
  
  CTSurfaceChart addNewSurfaceChart();
  
  void removeSurfaceChart(int paramInt);
  
  List<CTSurface3DChart> getSurface3DChartList();
  
  CTSurface3DChart[] getSurface3DChartArray();
  
  CTSurface3DChart getSurface3DChartArray(int paramInt);
  
  int sizeOfSurface3DChartArray();
  
  void setSurface3DChartArray(CTSurface3DChart[] paramArrayOfCTSurface3DChart);
  
  void setSurface3DChartArray(int paramInt, CTSurface3DChart paramCTSurface3DChart);
  
  CTSurface3DChart insertNewSurface3DChart(int paramInt);
  
  CTSurface3DChart addNewSurface3DChart();
  
  void removeSurface3DChart(int paramInt);
  
  List<CTBubbleChart> getBubbleChartList();
  
  CTBubbleChart[] getBubbleChartArray();
  
  CTBubbleChart getBubbleChartArray(int paramInt);
  
  int sizeOfBubbleChartArray();
  
  void setBubbleChartArray(CTBubbleChart[] paramArrayOfCTBubbleChart);
  
  void setBubbleChartArray(int paramInt, CTBubbleChart paramCTBubbleChart);
  
  CTBubbleChart insertNewBubbleChart(int paramInt);
  
  CTBubbleChart addNewBubbleChart();
  
  void removeBubbleChart(int paramInt);
  
  List<CTValAx> getValAxList();
  
  CTValAx[] getValAxArray();
  
  CTValAx getValAxArray(int paramInt);
  
  int sizeOfValAxArray();
  
  void setValAxArray(CTValAx[] paramArrayOfCTValAx);
  
  void setValAxArray(int paramInt, CTValAx paramCTValAx);
  
  CTValAx insertNewValAx(int paramInt);
  
  CTValAx addNewValAx();
  
  void removeValAx(int paramInt);
  
  List<CTCatAx> getCatAxList();
  
  CTCatAx[] getCatAxArray();
  
  CTCatAx getCatAxArray(int paramInt);
  
  int sizeOfCatAxArray();
  
  void setCatAxArray(CTCatAx[] paramArrayOfCTCatAx);
  
  void setCatAxArray(int paramInt, CTCatAx paramCTCatAx);
  
  CTCatAx insertNewCatAx(int paramInt);
  
  CTCatAx addNewCatAx();
  
  void removeCatAx(int paramInt);
  
  List<CTDateAx> getDateAxList();
  
  CTDateAx[] getDateAxArray();
  
  CTDateAx getDateAxArray(int paramInt);
  
  int sizeOfDateAxArray();
  
  void setDateAxArray(CTDateAx[] paramArrayOfCTDateAx);
  
  void setDateAxArray(int paramInt, CTDateAx paramCTDateAx);
  
  CTDateAx insertNewDateAx(int paramInt);
  
  CTDateAx addNewDateAx();
  
  void removeDateAx(int paramInt);
  
  List<CTSerAx> getSerAxList();
  
  CTSerAx[] getSerAxArray();
  
  CTSerAx getSerAxArray(int paramInt);
  
  int sizeOfSerAxArray();
  
  void setSerAxArray(CTSerAx[] paramArrayOfCTSerAx);
  
  void setSerAxArray(int paramInt, CTSerAx paramCTSerAx);
  
  CTSerAx insertNewSerAx(int paramInt);
  
  CTSerAx addNewSerAx();
  
  void removeSerAx(int paramInt);
  
  CTDTable getDTable();
  
  boolean isSetDTable();
  
  void setDTable(CTDTable paramCTDTable);
  
  CTDTable addNewDTable();
  
  void unsetDTable();
  
  CTShapeProperties getSpPr();
  
  boolean isSetSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  void unsetSpPr();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTPlotArea newInstance() {
      return (CTPlotArea)POIXMLTypeLoader.newInstance(CTPlotArea.type, null);
    }
    
    public static CTPlotArea newInstance(XmlOptions param1XmlOptions) {
      return (CTPlotArea)POIXMLTypeLoader.newInstance(CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(String param1String) throws XmlException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1String, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1String, CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(File param1File) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1File, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1File, CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(URL param1URL) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1URL, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1URL, CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1InputStream, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1InputStream, CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1Reader, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1Reader, CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(Node param1Node) throws XmlException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1Node, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1Node, CTPlotArea.type, param1XmlOptions);
    }
    
    public static CTPlotArea parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1XMLInputStream, CTPlotArea.type, null);
    }
    
    public static CTPlotArea parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPlotArea)POIXMLTypeLoader.parse(param1XMLInputStream, CTPlotArea.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPlotArea.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPlotArea.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTPlotArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */