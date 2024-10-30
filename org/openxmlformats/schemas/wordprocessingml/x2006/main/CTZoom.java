package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

public interface CTZoom extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTZoom.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctzoomc275type");
  
  STZoom$Enum getVal();
  
  STZoom xgetVal();
  
  boolean isSetVal();
  
  void setVal(STZoom$Enum paramSTZoom$Enum);
  
  void xsetVal(STZoom paramSTZoom);
  
  void unsetVal();
  
  BigInteger getPercent();
  
  STDecimalNumber xgetPercent();
  
  void setPercent(BigInteger paramBigInteger);
  
  void xsetPercent(STDecimalNumber paramSTDecimalNumber);
  
  public static final class Factory {
    public static CTZoom newInstance() {
      return (CTZoom)POIXMLTypeLoader.newInstance(CTZoom.type, null);
    }
    
    public static CTZoom newInstance(XmlOptions param1XmlOptions) {
      return (CTZoom)POIXMLTypeLoader.newInstance(CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(String param1String) throws XmlException {
      return (CTZoom)POIXMLTypeLoader.parse(param1String, CTZoom.type, null);
    }
    
    public static CTZoom parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTZoom)POIXMLTypeLoader.parse(param1String, CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(File param1File) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1File, CTZoom.type, null);
    }
    
    public static CTZoom parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1File, CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(URL param1URL) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1URL, CTZoom.type, null);
    }
    
    public static CTZoom parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1URL, CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1InputStream, CTZoom.type, null);
    }
    
    public static CTZoom parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1InputStream, CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(Reader param1Reader) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1Reader, CTZoom.type, null);
    }
    
    public static CTZoom parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTZoom)POIXMLTypeLoader.parse(param1Reader, CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTZoom)POIXMLTypeLoader.parse(param1XMLStreamReader, CTZoom.type, null);
    }
    
    public static CTZoom parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTZoom)POIXMLTypeLoader.parse(param1XMLStreamReader, CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(Node param1Node) throws XmlException {
      return (CTZoom)POIXMLTypeLoader.parse(param1Node, CTZoom.type, null);
    }
    
    public static CTZoom parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTZoom)POIXMLTypeLoader.parse(param1Node, CTZoom.type, param1XmlOptions);
    }
    
    public static CTZoom parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTZoom)POIXMLTypeLoader.parse(param1XMLInputStream, CTZoom.type, null);
    }
    
    public static CTZoom parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTZoom)POIXMLTypeLoader.parse(param1XMLInputStream, CTZoom.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTZoom.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTZoom.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTZoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */