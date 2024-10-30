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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPane extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPane.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpaneaab1type");
  
  double getXSplit();
  
  XmlDouble xgetXSplit();
  
  boolean isSetXSplit();
  
  void setXSplit(double paramDouble);
  
  void xsetXSplit(XmlDouble paramXmlDouble);
  
  void unsetXSplit();
  
  double getYSplit();
  
  XmlDouble xgetYSplit();
  
  boolean isSetYSplit();
  
  void setYSplit(double paramDouble);
  
  void xsetYSplit(XmlDouble paramXmlDouble);
  
  void unsetYSplit();
  
  String getTopLeftCell();
  
  STCellRef xgetTopLeftCell();
  
  boolean isSetTopLeftCell();
  
  void setTopLeftCell(String paramString);
  
  void xsetTopLeftCell(STCellRef paramSTCellRef);
  
  void unsetTopLeftCell();
  
  STPane.Enum getActivePane();
  
  STPane xgetActivePane();
  
  boolean isSetActivePane();
  
  void setActivePane(STPane.Enum paramEnum);
  
  void xsetActivePane(STPane paramSTPane);
  
  void unsetActivePane();
  
  STPaneState.Enum getState();
  
  STPaneState xgetState();
  
  boolean isSetState();
  
  void setState(STPaneState.Enum paramEnum);
  
  void xsetState(STPaneState paramSTPaneState);
  
  void unsetState();
  
  public static final class Factory {
    public static CTPane newInstance() {
      return (CTPane)POIXMLTypeLoader.newInstance(CTPane.type, null);
    }
    
    public static CTPane newInstance(XmlOptions param1XmlOptions) {
      return (CTPane)POIXMLTypeLoader.newInstance(CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(String param1String) throws XmlException {
      return (CTPane)POIXMLTypeLoader.parse(param1String, CTPane.type, null);
    }
    
    public static CTPane parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPane)POIXMLTypeLoader.parse(param1String, CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(File param1File) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1File, CTPane.type, null);
    }
    
    public static CTPane parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1File, CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(URL param1URL) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1URL, CTPane.type, null);
    }
    
    public static CTPane parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1URL, CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1InputStream, CTPane.type, null);
    }
    
    public static CTPane parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1InputStream, CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1Reader, CTPane.type, null);
    }
    
    public static CTPane parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPane)POIXMLTypeLoader.parse(param1Reader, CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPane)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPane.type, null);
    }
    
    public static CTPane parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPane)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(Node param1Node) throws XmlException {
      return (CTPane)POIXMLTypeLoader.parse(param1Node, CTPane.type, null);
    }
    
    public static CTPane parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPane)POIXMLTypeLoader.parse(param1Node, CTPane.type, param1XmlOptions);
    }
    
    public static CTPane parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPane)POIXMLTypeLoader.parse(param1XMLInputStream, CTPane.type, null);
    }
    
    public static CTPane parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPane)POIXMLTypeLoader.parse(param1XMLInputStream, CTPane.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPane.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPane.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */