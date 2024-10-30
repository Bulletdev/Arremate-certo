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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTLocation extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLocation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlocationc23etype");
  
  String getRef();
  
  STRef xgetRef();
  
  void setRef(String paramString);
  
  void xsetRef(STRef paramSTRef);
  
  long getFirstHeaderRow();
  
  XmlUnsignedInt xgetFirstHeaderRow();
  
  void setFirstHeaderRow(long paramLong);
  
  void xsetFirstHeaderRow(XmlUnsignedInt paramXmlUnsignedInt);
  
  long getFirstDataRow();
  
  XmlUnsignedInt xgetFirstDataRow();
  
  void setFirstDataRow(long paramLong);
  
  void xsetFirstDataRow(XmlUnsignedInt paramXmlUnsignedInt);
  
  long getFirstDataCol();
  
  XmlUnsignedInt xgetFirstDataCol();
  
  void setFirstDataCol(long paramLong);
  
  void xsetFirstDataCol(XmlUnsignedInt paramXmlUnsignedInt);
  
  long getRowPageCount();
  
  XmlUnsignedInt xgetRowPageCount();
  
  boolean isSetRowPageCount();
  
  void setRowPageCount(long paramLong);
  
  void xsetRowPageCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetRowPageCount();
  
  long getColPageCount();
  
  XmlUnsignedInt xgetColPageCount();
  
  boolean isSetColPageCount();
  
  void setColPageCount(long paramLong);
  
  void xsetColPageCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetColPageCount();
  
  public static final class Factory {
    public static CTLocation newInstance() {
      return (CTLocation)POIXMLTypeLoader.newInstance(CTLocation.type, null);
    }
    
    public static CTLocation newInstance(XmlOptions param1XmlOptions) {
      return (CTLocation)POIXMLTypeLoader.newInstance(CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(String param1String) throws XmlException {
      return (CTLocation)POIXMLTypeLoader.parse(param1String, CTLocation.type, null);
    }
    
    public static CTLocation parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLocation)POIXMLTypeLoader.parse(param1String, CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(File param1File) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1File, CTLocation.type, null);
    }
    
    public static CTLocation parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1File, CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(URL param1URL) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1URL, CTLocation.type, null);
    }
    
    public static CTLocation parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1URL, CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1InputStream, CTLocation.type, null);
    }
    
    public static CTLocation parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1InputStream, CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1Reader, CTLocation.type, null);
    }
    
    public static CTLocation parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLocation)POIXMLTypeLoader.parse(param1Reader, CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLocation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLocation.type, null);
    }
    
    public static CTLocation parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLocation)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(Node param1Node) throws XmlException {
      return (CTLocation)POIXMLTypeLoader.parse(param1Node, CTLocation.type, null);
    }
    
    public static CTLocation parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLocation)POIXMLTypeLoader.parse(param1Node, CTLocation.type, param1XmlOptions);
    }
    
    public static CTLocation parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLocation)POIXMLTypeLoader.parse(param1XMLInputStream, CTLocation.type, null);
    }
    
    public static CTLocation parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLocation)POIXMLTypeLoader.parse(param1XMLInputStream, CTLocation.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLocation.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLocation.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */