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

public interface CTHeight extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHeight.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctheighta2e1type");
  
  BigInteger getVal();
  
  STTwipsMeasure xgetVal();
  
  boolean isSetVal();
  
  void setVal(BigInteger paramBigInteger);
  
  void xsetVal(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetVal();
  
  STHeightRule$Enum getHRule();
  
  STHeightRule xgetHRule();
  
  boolean isSetHRule();
  
  void setHRule(STHeightRule$Enum paramSTHeightRule$Enum);
  
  void xsetHRule(STHeightRule paramSTHeightRule);
  
  void unsetHRule();
  
  public static final class Factory {
    public static CTHeight newInstance() {
      return (CTHeight)POIXMLTypeLoader.newInstance(CTHeight.type, null);
    }
    
    public static CTHeight newInstance(XmlOptions param1XmlOptions) {
      return (CTHeight)POIXMLTypeLoader.newInstance(CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(String param1String) throws XmlException {
      return (CTHeight)POIXMLTypeLoader.parse(param1String, CTHeight.type, null);
    }
    
    public static CTHeight parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHeight)POIXMLTypeLoader.parse(param1String, CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(File param1File) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1File, CTHeight.type, null);
    }
    
    public static CTHeight parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1File, CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(URL param1URL) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1URL, CTHeight.type, null);
    }
    
    public static CTHeight parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1URL, CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1InputStream, CTHeight.type, null);
    }
    
    public static CTHeight parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1InputStream, CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1Reader, CTHeight.type, null);
    }
    
    public static CTHeight parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHeight)POIXMLTypeLoader.parse(param1Reader, CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHeight)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHeight.type, null);
    }
    
    public static CTHeight parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHeight)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(Node param1Node) throws XmlException {
      return (CTHeight)POIXMLTypeLoader.parse(param1Node, CTHeight.type, null);
    }
    
    public static CTHeight parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHeight)POIXMLTypeLoader.parse(param1Node, CTHeight.type, param1XmlOptions);
    }
    
    public static CTHeight parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHeight)POIXMLTypeLoader.parse(param1XMLInputStream, CTHeight.type, null);
    }
    
    public static CTHeight parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHeight)POIXMLTypeLoader.parse(param1XMLInputStream, CTHeight.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHeight.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHeight.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTHeight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */