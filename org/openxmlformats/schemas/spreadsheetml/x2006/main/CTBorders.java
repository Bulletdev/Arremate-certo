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

public interface CTBorders extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBorders.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctborders0d66type");
  
  List<CTBorder> getBorderList();
  
  CTBorder[] getBorderArray();
  
  CTBorder getBorderArray(int paramInt);
  
  int sizeOfBorderArray();
  
  void setBorderArray(CTBorder[] paramArrayOfCTBorder);
  
  void setBorderArray(int paramInt, CTBorder paramCTBorder);
  
  CTBorder insertNewBorder(int paramInt);
  
  CTBorder addNewBorder();
  
  void removeBorder(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTBorders newInstance() {
      return (CTBorders)POIXMLTypeLoader.newInstance(CTBorders.type, null);
    }
    
    public static CTBorders newInstance(XmlOptions param1XmlOptions) {
      return (CTBorders)POIXMLTypeLoader.newInstance(CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(String param1String) throws XmlException {
      return (CTBorders)POIXMLTypeLoader.parse(param1String, CTBorders.type, null);
    }
    
    public static CTBorders parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorders)POIXMLTypeLoader.parse(param1String, CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(File param1File) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1File, CTBorders.type, null);
    }
    
    public static CTBorders parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1File, CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(URL param1URL) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1URL, CTBorders.type, null);
    }
    
    public static CTBorders parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1URL, CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1InputStream, CTBorders.type, null);
    }
    
    public static CTBorders parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1InputStream, CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1Reader, CTBorders.type, null);
    }
    
    public static CTBorders parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorders)POIXMLTypeLoader.parse(param1Reader, CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBorders)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorders.type, null);
    }
    
    public static CTBorders parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorders)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(Node param1Node) throws XmlException {
      return (CTBorders)POIXMLTypeLoader.parse(param1Node, CTBorders.type, null);
    }
    
    public static CTBorders parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorders)POIXMLTypeLoader.parse(param1Node, CTBorders.type, param1XmlOptions);
    }
    
    public static CTBorders parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBorders)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorders.type, null);
    }
    
    public static CTBorders parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBorders)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorders.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorders.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorders.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTBorders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */