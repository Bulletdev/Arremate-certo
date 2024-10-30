package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTFills extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFills.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfills2c6ftype");
  
  List<CTFill> getFillList();
  
  CTFill[] getFillArray();
  
  CTFill getFillArray(int paramInt);
  
  int sizeOfFillArray();
  
  void setFillArray(CTFill[] paramArrayOfCTFill);
  
  void setFillArray(int paramInt, CTFill paramCTFill);
  
  CTFill insertNewFill(int paramInt);
  
  CTFill addNewFill();
  
  void removeFill(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTFills newInstance() {
      return (CTFills)POIXMLTypeLoader.newInstance(CTFills.type, null);
    }
    
    public static CTFills newInstance(XmlOptions param1XmlOptions) {
      return (CTFills)POIXMLTypeLoader.newInstance(CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(String param1String) throws XmlException {
      return (CTFills)POIXMLTypeLoader.parse(param1String, CTFills.type, null);
    }
    
    public static CTFills parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFills)POIXMLTypeLoader.parse(param1String, CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(File param1File) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1File, CTFills.type, null);
    }
    
    public static CTFills parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1File, CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(URL param1URL) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1URL, CTFills.type, null);
    }
    
    public static CTFills parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1URL, CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1InputStream, CTFills.type, null);
    }
    
    public static CTFills parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1InputStream, CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1Reader, CTFills.type, null);
    }
    
    public static CTFills parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFills)POIXMLTypeLoader.parse(param1Reader, CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFills)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFills.type, null);
    }
    
    public static CTFills parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFills)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(Node param1Node) throws XmlException {
      return (CTFills)POIXMLTypeLoader.parse(param1Node, CTFills.type, null);
    }
    
    public static CTFills parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFills)POIXMLTypeLoader.parse(param1Node, CTFills.type, param1XmlOptions);
    }
    
    public static CTFills parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFills)POIXMLTypeLoader.parse(param1XMLInputStream, CTFills.type, null);
    }
    
    public static CTFills parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFills)POIXMLTypeLoader.parse(param1XMLInputStream, CTFills.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFills.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFills.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTFills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */