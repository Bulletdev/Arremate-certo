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

public interface CTTableParts extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableParts.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablepartsf6bbtype");
  
  List<CTTablePart> getTablePartList();
  
  CTTablePart[] getTablePartArray();
  
  CTTablePart getTablePartArray(int paramInt);
  
  int sizeOfTablePartArray();
  
  void setTablePartArray(CTTablePart[] paramArrayOfCTTablePart);
  
  void setTablePartArray(int paramInt, CTTablePart paramCTTablePart);
  
  CTTablePart insertNewTablePart(int paramInt);
  
  CTTablePart addNewTablePart();
  
  void removeTablePart(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTTableParts newInstance() {
      return (CTTableParts)POIXMLTypeLoader.newInstance(CTTableParts.type, null);
    }
    
    public static CTTableParts newInstance(XmlOptions param1XmlOptions) {
      return (CTTableParts)POIXMLTypeLoader.newInstance(CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(String param1String) throws XmlException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1String, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1String, CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(File param1File) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1File, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1File, CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(URL param1URL) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1URL, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1URL, CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1InputStream, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1InputStream, CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1Reader, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1Reader, CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(Node param1Node) throws XmlException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1Node, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1Node, CTTableParts.type, param1XmlOptions);
    }
    
    public static CTTableParts parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableParts.type, null);
    }
    
    public static CTTableParts parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableParts)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableParts.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableParts.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableParts.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTTableParts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */