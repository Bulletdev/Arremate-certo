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

public interface CTItems extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTItems.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctitemsecdftype");
  
  List<CTItem> getItemList();
  
  CTItem[] getItemArray();
  
  CTItem getItemArray(int paramInt);
  
  int sizeOfItemArray();
  
  void setItemArray(CTItem[] paramArrayOfCTItem);
  
  void setItemArray(int paramInt, CTItem paramCTItem);
  
  CTItem insertNewItem(int paramInt);
  
  CTItem addNewItem();
  
  void removeItem(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTItems newInstance() {
      return (CTItems)POIXMLTypeLoader.newInstance(CTItems.type, null);
    }
    
    public static CTItems newInstance(XmlOptions param1XmlOptions) {
      return (CTItems)POIXMLTypeLoader.newInstance(CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(String param1String) throws XmlException {
      return (CTItems)POIXMLTypeLoader.parse(param1String, CTItems.type, null);
    }
    
    public static CTItems parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTItems)POIXMLTypeLoader.parse(param1String, CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(File param1File) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1File, CTItems.type, null);
    }
    
    public static CTItems parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1File, CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(URL param1URL) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1URL, CTItems.type, null);
    }
    
    public static CTItems parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1URL, CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1InputStream, CTItems.type, null);
    }
    
    public static CTItems parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1InputStream, CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(Reader param1Reader) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1Reader, CTItems.type, null);
    }
    
    public static CTItems parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTItems)POIXMLTypeLoader.parse(param1Reader, CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTItems)POIXMLTypeLoader.parse(param1XMLStreamReader, CTItems.type, null);
    }
    
    public static CTItems parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTItems)POIXMLTypeLoader.parse(param1XMLStreamReader, CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(Node param1Node) throws XmlException {
      return (CTItems)POIXMLTypeLoader.parse(param1Node, CTItems.type, null);
    }
    
    public static CTItems parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTItems)POIXMLTypeLoader.parse(param1Node, CTItems.type, param1XmlOptions);
    }
    
    public static CTItems parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTItems)POIXMLTypeLoader.parse(param1XMLInputStream, CTItems.type, null);
    }
    
    public static CTItems parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTItems)POIXMLTypeLoader.parse(param1XMLInputStream, CTItems.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTItems.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTItems.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */