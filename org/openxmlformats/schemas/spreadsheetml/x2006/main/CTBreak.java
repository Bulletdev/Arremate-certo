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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBreak extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbreak815etype");
  
  long getId();
  
  XmlUnsignedInt xgetId();
  
  boolean isSetId();
  
  void setId(long paramLong);
  
  void xsetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetId();
  
  long getMin();
  
  XmlUnsignedInt xgetMin();
  
  boolean isSetMin();
  
  void setMin(long paramLong);
  
  void xsetMin(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMin();
  
  long getMax();
  
  XmlUnsignedInt xgetMax();
  
  boolean isSetMax();
  
  void setMax(long paramLong);
  
  void xsetMax(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMax();
  
  boolean getMan();
  
  XmlBoolean xgetMan();
  
  boolean isSetMan();
  
  void setMan(boolean paramBoolean);
  
  void xsetMan(XmlBoolean paramXmlBoolean);
  
  void unsetMan();
  
  boolean getPt();
  
  XmlBoolean xgetPt();
  
  boolean isSetPt();
  
  void setPt(boolean paramBoolean);
  
  void xsetPt(XmlBoolean paramXmlBoolean);
  
  void unsetPt();
  
  public static final class Factory {
    public static CTBreak newInstance() {
      return (CTBreak)POIXMLTypeLoader.newInstance(CTBreak.type, null);
    }
    
    public static CTBreak newInstance(XmlOptions param1XmlOptions) {
      return (CTBreak)POIXMLTypeLoader.newInstance(CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(String param1String) throws XmlException {
      return (CTBreak)POIXMLTypeLoader.parse(param1String, CTBreak.type, null);
    }
    
    public static CTBreak parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBreak)POIXMLTypeLoader.parse(param1String, CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(File param1File) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1File, CTBreak.type, null);
    }
    
    public static CTBreak parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1File, CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(URL param1URL) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1URL, CTBreak.type, null);
    }
    
    public static CTBreak parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1URL, CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1InputStream, CTBreak.type, null);
    }
    
    public static CTBreak parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1InputStream, CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1Reader, CTBreak.type, null);
    }
    
    public static CTBreak parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBreak)POIXMLTypeLoader.parse(param1Reader, CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBreak)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBreak.type, null);
    }
    
    public static CTBreak parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBreak)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(Node param1Node) throws XmlException {
      return (CTBreak)POIXMLTypeLoader.parse(param1Node, CTBreak.type, null);
    }
    
    public static CTBreak parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBreak)POIXMLTypeLoader.parse(param1Node, CTBreak.type, param1XmlOptions);
    }
    
    public static CTBreak parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBreak)POIXMLTypeLoader.parse(param1XMLInputStream, CTBreak.type, null);
    }
    
    public static CTBreak parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBreak)POIXMLTypeLoader.parse(param1XMLInputStream, CTBreak.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBreak.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBreak.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTBreak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */