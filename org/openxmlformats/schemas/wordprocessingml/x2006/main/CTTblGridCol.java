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

public interface CTTblGridCol extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblGridCol.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblgridcolbfectype");
  
  BigInteger getW();
  
  STTwipsMeasure xgetW();
  
  boolean isSetW();
  
  void setW(BigInteger paramBigInteger);
  
  void xsetW(STTwipsMeasure paramSTTwipsMeasure);
  
  void unsetW();
  
  public static final class Factory {
    public static CTTblGridCol newInstance() {
      return (CTTblGridCol)POIXMLTypeLoader.newInstance(CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol newInstance(XmlOptions param1XmlOptions) {
      return (CTTblGridCol)POIXMLTypeLoader.newInstance(CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(String param1String) throws XmlException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1String, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1String, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(File param1File) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1File, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1File, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(URL param1URL) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1URL, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1URL, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1InputStream, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1InputStream, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1Reader, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1Reader, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(Node param1Node) throws XmlException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1Node, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1Node, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static CTTblGridCol parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblGridCol.type, null);
    }
    
    public static CTTblGridCol parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblGridCol)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblGridCol.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblGridCol.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblGridCol.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblGridCol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */