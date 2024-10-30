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

public interface CTDecimalNumber extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDecimalNumber.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdecimalnumbera518type");
  
  BigInteger getVal();
  
  STDecimalNumber xgetVal();
  
  void setVal(BigInteger paramBigInteger);
  
  void xsetVal(STDecimalNumber paramSTDecimalNumber);
  
  public static final class Factory {
    public static CTDecimalNumber newInstance() {
      return (CTDecimalNumber)POIXMLTypeLoader.newInstance(CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber newInstance(XmlOptions param1XmlOptions) {
      return (CTDecimalNumber)POIXMLTypeLoader.newInstance(CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(String param1String) throws XmlException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1String, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1String, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(File param1File) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1File, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1File, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(URL param1URL) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1URL, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1URL, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1InputStream, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1InputStream, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1Reader, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1Reader, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(Node param1Node) throws XmlException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1Node, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1Node, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static CTDecimalNumber parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1XMLInputStream, CTDecimalNumber.type, null);
    }
    
    public static CTDecimalNumber parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDecimalNumber)POIXMLTypeLoader.parse(param1XMLInputStream, CTDecimalNumber.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDecimalNumber.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDecimalNumber.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTDecimalNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */