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
import org.w3c.dom.Node;

public interface CTLineChart extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLineChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinechart249ctype");
  
  CTGrouping getGrouping();
  
  void setGrouping(CTGrouping paramCTGrouping);
  
  CTGrouping addNewGrouping();
  
  CTBoolean getVaryColors();
  
  boolean isSetVaryColors();
  
  void setVaryColors(CTBoolean paramCTBoolean);
  
  CTBoolean addNewVaryColors();
  
  void unsetVaryColors();
  
  List<CTLineSer> getSerList();
  
  CTLineSer[] getSerArray();
  
  CTLineSer getSerArray(int paramInt);
  
  int sizeOfSerArray();
  
  void setSerArray(CTLineSer[] paramArrayOfCTLineSer);
  
  void setSerArray(int paramInt, CTLineSer paramCTLineSer);
  
  CTLineSer insertNewSer(int paramInt);
  
  CTLineSer addNewSer();
  
  void removeSer(int paramInt);
  
  CTDLbls getDLbls();
  
  boolean isSetDLbls();
  
  void setDLbls(CTDLbls paramCTDLbls);
  
  CTDLbls addNewDLbls();
  
  void unsetDLbls();
  
  CTChartLines getDropLines();
  
  boolean isSetDropLines();
  
  void setDropLines(CTChartLines paramCTChartLines);
  
  CTChartLines addNewDropLines();
  
  void unsetDropLines();
  
  CTChartLines getHiLowLines();
  
  boolean isSetHiLowLines();
  
  void setHiLowLines(CTChartLines paramCTChartLines);
  
  CTChartLines addNewHiLowLines();
  
  void unsetHiLowLines();
  
  CTUpDownBars getUpDownBars();
  
  boolean isSetUpDownBars();
  
  void setUpDownBars(CTUpDownBars paramCTUpDownBars);
  
  CTUpDownBars addNewUpDownBars();
  
  void unsetUpDownBars();
  
  CTBoolean getMarker();
  
  boolean isSetMarker();
  
  void setMarker(CTBoolean paramCTBoolean);
  
  CTBoolean addNewMarker();
  
  void unsetMarker();
  
  CTBoolean getSmooth();
  
  boolean isSetSmooth();
  
  void setSmooth(CTBoolean paramCTBoolean);
  
  CTBoolean addNewSmooth();
  
  void unsetSmooth();
  
  List<CTUnsignedInt> getAxIdList();
  
  CTUnsignedInt[] getAxIdArray();
  
  CTUnsignedInt getAxIdArray(int paramInt);
  
  int sizeOfAxIdArray();
  
  void setAxIdArray(CTUnsignedInt[] paramArrayOfCTUnsignedInt);
  
  void setAxIdArray(int paramInt, CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt insertNewAxId(int paramInt);
  
  CTUnsignedInt addNewAxId();
  
  void removeAxId(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTLineChart newInstance() {
      return (CTLineChart)POIXMLTypeLoader.newInstance(CTLineChart.type, null);
    }
    
    public static CTLineChart newInstance(XmlOptions param1XmlOptions) {
      return (CTLineChart)POIXMLTypeLoader.newInstance(CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(String param1String) throws XmlException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1String, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1String, CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(File param1File) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1File, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1File, CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(URL param1URL) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1URL, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1URL, CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1InputStream, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1InputStream, CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1Reader, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1Reader, CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(Node param1Node) throws XmlException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1Node, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1Node, CTLineChart.type, param1XmlOptions);
    }
    
    public static CTLineChart parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineChart.type, null);
    }
    
    public static CTLineChart parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLineChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineChart.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineChart.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineChart.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLineChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */