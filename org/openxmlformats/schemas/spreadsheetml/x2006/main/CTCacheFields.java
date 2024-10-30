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

public interface CTCacheFields extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCacheFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcachefieldsf5fatype");
  
  List<CTCacheField> getCacheFieldList();
  
  CTCacheField[] getCacheFieldArray();
  
  CTCacheField getCacheFieldArray(int paramInt);
  
  int sizeOfCacheFieldArray();
  
  void setCacheFieldArray(CTCacheField[] paramArrayOfCTCacheField);
  
  void setCacheFieldArray(int paramInt, CTCacheField paramCTCacheField);
  
  CTCacheField insertNewCacheField(int paramInt);
  
  CTCacheField addNewCacheField();
  
  void removeCacheField(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTCacheFields newInstance() {
      return (CTCacheFields)POIXMLTypeLoader.newInstance(CTCacheFields.type, null);
    }
    
    public static CTCacheFields newInstance(XmlOptions param1XmlOptions) {
      return (CTCacheFields)POIXMLTypeLoader.newInstance(CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(String param1String) throws XmlException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1String, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1String, CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(File param1File) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1File, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1File, CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(URL param1URL) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1URL, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1URL, CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1InputStream, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1InputStream, CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1Reader, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1Reader, CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(Node param1Node) throws XmlException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1Node, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1Node, CTCacheFields.type, param1XmlOptions);
    }
    
    public static CTCacheFields parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTCacheFields.type, null);
    }
    
    public static CTCacheFields parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCacheFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTCacheFields.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCacheFields.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCacheFields.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCacheFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */