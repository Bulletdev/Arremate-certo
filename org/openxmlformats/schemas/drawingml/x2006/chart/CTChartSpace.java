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
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

public interface CTChartSpace extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTChartSpace.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctchartspacef9b4type");
  
  CTBoolean getDate1904();
  
  boolean isSetDate1904();
  
  void setDate1904(CTBoolean paramCTBoolean);
  
  CTBoolean addNewDate1904();
  
  void unsetDate1904();
  
  CTTextLanguageID getLang();
  
  boolean isSetLang();
  
  void setLang(CTTextLanguageID paramCTTextLanguageID);
  
  CTTextLanguageID addNewLang();
  
  void unsetLang();
  
  CTBoolean getRoundedCorners();
  
  boolean isSetRoundedCorners();
  
  void setRoundedCorners(CTBoolean paramCTBoolean);
  
  CTBoolean addNewRoundedCorners();
  
  void unsetRoundedCorners();
  
  CTStyle getStyle();
  
  boolean isSetStyle();
  
  void setStyle(CTStyle paramCTStyle);
  
  CTStyle addNewStyle();
  
  void unsetStyle();
  
  CTColorMapping getClrMapOvr();
  
  boolean isSetClrMapOvr();
  
  void setClrMapOvr(CTColorMapping paramCTColorMapping);
  
  CTColorMapping addNewClrMapOvr();
  
  void unsetClrMapOvr();
  
  CTPivotSource getPivotSource();
  
  boolean isSetPivotSource();
  
  void setPivotSource(CTPivotSource paramCTPivotSource);
  
  CTPivotSource addNewPivotSource();
  
  void unsetPivotSource();
  
  CTProtection getProtection();
  
  boolean isSetProtection();
  
  void setProtection(CTProtection paramCTProtection);
  
  CTProtection addNewProtection();
  
  void unsetProtection();
  
  CTChart getChart();
  
  void setChart(CTChart paramCTChart);
  
  CTChart addNewChart();
  
  CTShapeProperties getSpPr();
  
  boolean isSetSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  void unsetSpPr();
  
  CTTextBody getTxPr();
  
  boolean isSetTxPr();
  
  void setTxPr(CTTextBody paramCTTextBody);
  
  CTTextBody addNewTxPr();
  
  void unsetTxPr();
  
  CTExternalData getExternalData();
  
  boolean isSetExternalData();
  
  void setExternalData(CTExternalData paramCTExternalData);
  
  CTExternalData addNewExternalData();
  
  void unsetExternalData();
  
  CTPrintSettings getPrintSettings();
  
  boolean isSetPrintSettings();
  
  void setPrintSettings(CTPrintSettings paramCTPrintSettings);
  
  CTPrintSettings addNewPrintSettings();
  
  void unsetPrintSettings();
  
  CTRelId getUserShapes();
  
  boolean isSetUserShapes();
  
  void setUserShapes(CTRelId paramCTRelId);
  
  CTRelId addNewUserShapes();
  
  void unsetUserShapes();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTChartSpace newInstance() {
      return (CTChartSpace)POIXMLTypeLoader.newInstance(CTChartSpace.type, null);
    }
    
    public static CTChartSpace newInstance(XmlOptions param1XmlOptions) {
      return (CTChartSpace)POIXMLTypeLoader.newInstance(CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(String param1String) throws XmlException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1String, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1String, CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(File param1File) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1File, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1File, CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(URL param1URL) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1URL, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1URL, CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1InputStream, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1InputStream, CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(Reader param1Reader) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1Reader, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1Reader, CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1XMLStreamReader, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1XMLStreamReader, CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(Node param1Node) throws XmlException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1Node, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1Node, CTChartSpace.type, param1XmlOptions);
    }
    
    public static CTChartSpace parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1XMLInputStream, CTChartSpace.type, null);
    }
    
    public static CTChartSpace parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTChartSpace)POIXMLTypeLoader.parse(param1XMLInputStream, CTChartSpace.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTChartSpace.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTChartSpace.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTChartSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */