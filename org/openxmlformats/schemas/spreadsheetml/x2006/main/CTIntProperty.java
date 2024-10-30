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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTIntProperty extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTIntProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctintproperty32c3type");
  
  int getVal();
  
  XmlInt xgetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(XmlInt paramXmlInt);
  
  public static final class Factory {
    public static CTIntProperty newInstance() {
      return (CTIntProperty)POIXMLTypeLoader.newInstance(CTIntProperty.type, null);
    }
    
    public static CTIntProperty newInstance(XmlOptions param1XmlOptions) {
      return (CTIntProperty)POIXMLTypeLoader.newInstance(CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(String param1String) throws XmlException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1String, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1String, CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(File param1File) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1File, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1File, CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(URL param1URL) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1URL, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1URL, CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1InputStream, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1InputStream, CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(Reader param1Reader) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1Reader, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1Reader, CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(Node param1Node) throws XmlException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1Node, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1Node, CTIntProperty.type, param1XmlOptions);
    }
    
    public static CTIntProperty parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTIntProperty.type, null);
    }
    
    public static CTIntProperty parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTIntProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTIntProperty.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIntProperty.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTIntProperty.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTIntProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */