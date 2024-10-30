package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCalcPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCalcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcalcprd480type");
  
  long getCalcId();
  
  XmlUnsignedInt xgetCalcId();
  
  boolean isSetCalcId();
  
  void setCalcId(long paramLong);
  
  void xsetCalcId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCalcId();
  
  STCalcMode.Enum getCalcMode();
  
  STCalcMode xgetCalcMode();
  
  boolean isSetCalcMode();
  
  void setCalcMode(STCalcMode.Enum paramEnum);
  
  void xsetCalcMode(STCalcMode paramSTCalcMode);
  
  void unsetCalcMode();
  
  boolean getFullCalcOnLoad();
  
  XmlBoolean xgetFullCalcOnLoad();
  
  boolean isSetFullCalcOnLoad();
  
  void setFullCalcOnLoad(boolean paramBoolean);
  
  void xsetFullCalcOnLoad(XmlBoolean paramXmlBoolean);
  
  void unsetFullCalcOnLoad();
  
  STRefMode$Enum getRefMode();
  
  STRefMode xgetRefMode();
  
  boolean isSetRefMode();
  
  void setRefMode(STRefMode$Enum paramSTRefMode$Enum);
  
  void xsetRefMode(STRefMode paramSTRefMode);
  
  void unsetRefMode();
  
  boolean getIterate();
  
  XmlBoolean xgetIterate();
  
  boolean isSetIterate();
  
  void setIterate(boolean paramBoolean);
  
  void xsetIterate(XmlBoolean paramXmlBoolean);
  
  void unsetIterate();
  
  long getIterateCount();
  
  XmlUnsignedInt xgetIterateCount();
  
  boolean isSetIterateCount();
  
  void setIterateCount(long paramLong);
  
  void xsetIterateCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetIterateCount();
  
  double getIterateDelta();
  
  XmlDouble xgetIterateDelta();
  
  boolean isSetIterateDelta();
  
  void setIterateDelta(double paramDouble);
  
  void xsetIterateDelta(XmlDouble paramXmlDouble);
  
  void unsetIterateDelta();
  
  boolean getFullPrecision();
  
  XmlBoolean xgetFullPrecision();
  
  boolean isSetFullPrecision();
  
  void setFullPrecision(boolean paramBoolean);
  
  void xsetFullPrecision(XmlBoolean paramXmlBoolean);
  
  void unsetFullPrecision();
  
  boolean getCalcCompleted();
  
  XmlBoolean xgetCalcCompleted();
  
  boolean isSetCalcCompleted();
  
  void setCalcCompleted(boolean paramBoolean);
  
  void xsetCalcCompleted(XmlBoolean paramXmlBoolean);
  
  void unsetCalcCompleted();
  
  boolean getCalcOnSave();
  
  XmlBoolean xgetCalcOnSave();
  
  boolean isSetCalcOnSave();
  
  void setCalcOnSave(boolean paramBoolean);
  
  void xsetCalcOnSave(XmlBoolean paramXmlBoolean);
  
  void unsetCalcOnSave();
  
  boolean getConcurrentCalc();
  
  XmlBoolean xgetConcurrentCalc();
  
  boolean isSetConcurrentCalc();
  
  void setConcurrentCalc(boolean paramBoolean);
  
  void xsetConcurrentCalc(XmlBoolean paramXmlBoolean);
  
  void unsetConcurrentCalc();
  
  long getConcurrentManualCount();
  
  XmlUnsignedInt xgetConcurrentManualCount();
  
  boolean isSetConcurrentManualCount();
  
  void setConcurrentManualCount(long paramLong);
  
  void xsetConcurrentManualCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetConcurrentManualCount();
  
  boolean getForceFullCalc();
  
  XmlBoolean xgetForceFullCalc();
  
  boolean isSetForceFullCalc();
  
  void setForceFullCalc(boolean paramBoolean);
  
  void xsetForceFullCalc(XmlBoolean paramXmlBoolean);
  
  void unsetForceFullCalc();
  
  public static final class Factory {
    public static CTCalcPr newInstance() {
      return (CTCalcPr)POIXMLTypeLoader.newInstance(CTCalcPr.type, null);
    }
    
    public static CTCalcPr newInstance(XmlOptions param1XmlOptions) {
      return (CTCalcPr)POIXMLTypeLoader.newInstance(CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(String param1String) throws XmlException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1String, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1String, CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(File param1File) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1File, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1File, CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(URL param1URL) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1URL, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1URL, CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1InputStream, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1InputStream, CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1Reader, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1Reader, CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(Node param1Node) throws XmlException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1Node, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1Node, CTCalcPr.type, param1XmlOptions);
    }
    
    public static CTCalcPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTCalcPr.type, null);
    }
    
    public static CTCalcPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCalcPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTCalcPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCalcPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCalcPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCalcPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */