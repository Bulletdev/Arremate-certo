package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTPBdr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPBdr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpbdre388type");
  
  CTBorder getTop();
  
  boolean isSetTop();
  
  void setTop(CTBorder paramCTBorder);
  
  CTBorder addNewTop();
  
  void unsetTop();
  
  CTBorder getLeft();
  
  boolean isSetLeft();
  
  void setLeft(CTBorder paramCTBorder);
  
  CTBorder addNewLeft();
  
  void unsetLeft();
  
  CTBorder getBottom();
  
  boolean isSetBottom();
  
  void setBottom(CTBorder paramCTBorder);
  
  CTBorder addNewBottom();
  
  void unsetBottom();
  
  CTBorder getRight();
  
  boolean isSetRight();
  
  void setRight(CTBorder paramCTBorder);
  
  CTBorder addNewRight();
  
  void unsetRight();
  
  CTBorder getBetween();
  
  boolean isSetBetween();
  
  void setBetween(CTBorder paramCTBorder);
  
  CTBorder addNewBetween();
  
  void unsetBetween();
  
  CTBorder getBar();
  
  boolean isSetBar();
  
  void setBar(CTBorder paramCTBorder);
  
  CTBorder addNewBar();
  
  void unsetBar();
  
  public static final class Factory {
    public static CTPBdr newInstance() {
      return (CTPBdr)POIXMLTypeLoader.newInstance(CTPBdr.type, null);
    }
    
    public static CTPBdr newInstance(XmlOptions param1XmlOptions) {
      return (CTPBdr)POIXMLTypeLoader.newInstance(CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(String param1String) throws XmlException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1String, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1String, CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(File param1File) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1File, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1File, CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(URL param1URL) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1URL, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1URL, CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1InputStream, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1InputStream, CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1Reader, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1Reader, CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(Node param1Node) throws XmlException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1Node, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1Node, CTPBdr.type, param1XmlOptions);
    }
    
    public static CTPBdr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPBdr.type, null);
    }
    
    public static CTPBdr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPBdr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPBdr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPBdr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPBdr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTPBdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */