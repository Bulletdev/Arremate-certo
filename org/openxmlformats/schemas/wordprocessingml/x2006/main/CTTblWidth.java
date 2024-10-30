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

public interface CTTblWidth extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblwidthec40type");
  
  BigInteger getW();
  
  STDecimalNumber xgetW();
  
  boolean isSetW();
  
  void setW(BigInteger paramBigInteger);
  
  void xsetW(STDecimalNumber paramSTDecimalNumber);
  
  void unsetW();
  
  STTblWidth.Enum getType();
  
  STTblWidth xgetType();
  
  boolean isSetType();
  
  void setType(STTblWidth.Enum paramEnum);
  
  void xsetType(STTblWidth paramSTTblWidth);
  
  void unsetType();
  
  public static final class Factory {
    public static CTTblWidth newInstance() {
      return (CTTblWidth)POIXMLTypeLoader.newInstance(CTTblWidth.type, null);
    }
    
    public static CTTblWidth newInstance(XmlOptions param1XmlOptions) {
      return (CTTblWidth)POIXMLTypeLoader.newInstance(CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(String param1String) throws XmlException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1String, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1String, CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(File param1File) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1File, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1File, CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(URL param1URL) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1URL, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1URL, CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1InputStream, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1InputStream, CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1Reader, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1Reader, CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(Node param1Node) throws XmlException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1Node, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1Node, CTTblWidth.type, param1XmlOptions);
    }
    
    public static CTTblWidth parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblWidth.type, null);
    }
    
    public static CTTblWidth parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblWidth)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblWidth.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblWidth.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblWidth.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblWidth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */