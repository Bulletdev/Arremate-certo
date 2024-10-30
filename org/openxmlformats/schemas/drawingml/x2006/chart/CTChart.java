package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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

public interface CTChart extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctchartc108type");
  
  CTTitle getTitle();
  
  boolean isSetTitle();
  
  void setTitle(CTTitle paramCTTitle);
  
  CTTitle addNewTitle();
  
  void unsetTitle();
  
  CTBoolean getAutoTitleDeleted();
  
  boolean isSetAutoTitleDeleted();
  
  void setAutoTitleDeleted(CTBoolean paramCTBoolean);
  
  CTBoolean addNewAutoTitleDeleted();
  
  void unsetAutoTitleDeleted();
  
  CTPivotFmts getPivotFmts();
  
  boolean isSetPivotFmts();
  
  void setPivotFmts(CTPivotFmts paramCTPivotFmts);
  
  CTPivotFmts addNewPivotFmts();
  
  void unsetPivotFmts();
  
  CTView3D getView3D();
  
  boolean isSetView3D();
  
  void setView3D(CTView3D paramCTView3D);
  
  CTView3D addNewView3D();
  
  void unsetView3D();
  
  CTSurface getFloor();
  
  boolean isSetFloor();
  
  void setFloor(CTSurface paramCTSurface);
  
  CTSurface addNewFloor();
  
  void unsetFloor();
  
  CTSurface getSideWall();
  
  boolean isSetSideWall();
  
  void setSideWall(CTSurface paramCTSurface);
  
  CTSurface addNewSideWall();
  
  void unsetSideWall();
  
  CTSurface getBackWall();
  
  boolean isSetBackWall();
  
  void setBackWall(CTSurface paramCTSurface);
  
  CTSurface addNewBackWall();
  
  void unsetBackWall();
  
  CTPlotArea getPlotArea();
  
  void setPlotArea(CTPlotArea paramCTPlotArea);
  
  CTPlotArea addNewPlotArea();
  
  CTLegend getLegend();
  
  boolean isSetLegend();
  
  void setLegend(CTLegend paramCTLegend);
  
  CTLegend addNewLegend();
  
  void unsetLegend();
  
  CTBoolean getPlotVisOnly();
  
  boolean isSetPlotVisOnly();
  
  void setPlotVisOnly(CTBoolean paramCTBoolean);
  
  CTBoolean addNewPlotVisOnly();
  
  void unsetPlotVisOnly();
  
  CTDispBlanksAs getDispBlanksAs();
  
  boolean isSetDispBlanksAs();
  
  void setDispBlanksAs(CTDispBlanksAs paramCTDispBlanksAs);
  
  CTDispBlanksAs addNewDispBlanksAs();
  
  void unsetDispBlanksAs();
  
  CTBoolean getShowDLblsOverMax();
  
  boolean isSetShowDLblsOverMax();
  
  void setShowDLblsOverMax(CTBoolean paramCTBoolean);
  
  CTBoolean addNewShowDLblsOverMax();
  
  void unsetShowDLblsOverMax();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTChart newInstance() {
      return (CTChart)POIXMLTypeLoader.newInstance(CTChart.type, null);
    }
    
    public static CTChart newInstance(XmlOptions param1XmlOptions) {
      return (CTChart)POIXMLTypeLoader.newInstance(CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(String param1String) throws XmlException {
      return (CTChart)POIXMLTypeLoader.parse(param1String, CTChart.type, null);
    }
    
    public static CTChart parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChart)POIXMLTypeLoader.parse(param1String, CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(File param1File) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1File, CTChart.type, null);
    }
    
    public static CTChart parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1File, CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(URL param1URL) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1URL, CTChart.type, null);
    }
    
    public static CTChart parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1URL, CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1InputStream, CTChart.type, null);
    }
    
    public static CTChart parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1InputStream, CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(Reader param1Reader) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1Reader, CTChart.type, null);
    }
    
    public static CTChart parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChart)POIXMLTypeLoader.parse(param1Reader, CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTChart.type, null);
    }
    
    public static CTChart parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(Node param1Node) throws XmlException {
      return (CTChart)POIXMLTypeLoader.parse(param1Node, CTChart.type, null);
    }
    
    public static CTChart parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChart)POIXMLTypeLoader.parse(param1Node, CTChart.type, param1XmlOptions);
    }
    
    public static CTChart parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTChart.type, null);
    }
    
    public static CTChart parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTChart)POIXMLTypeLoader.parse(param1XMLInputStream, CTChart.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTChart.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTChart.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */