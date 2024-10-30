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

public interface CTField extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfieldc999type");
  
  int getX();
  
  XmlInt xgetX();
  
  void setX(int paramInt);
  
  void xsetX(XmlInt paramXmlInt);
  
  public static final class Factory {
    public static CTField newInstance() {
      return (CTField)POIXMLTypeLoader.newInstance(CTField.type, null);
    }
    
    public static CTField newInstance(XmlOptions param1XmlOptions) {
      return (CTField)POIXMLTypeLoader.newInstance(CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(String param1String) throws XmlException {
      return (CTField)POIXMLTypeLoader.parse(param1String, CTField.type, null);
    }
    
    public static CTField parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTField)POIXMLTypeLoader.parse(param1String, CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(File param1File) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1File, CTField.type, null);
    }
    
    public static CTField parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1File, CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(URL param1URL) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1URL, CTField.type, null);
    }
    
    public static CTField parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1URL, CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1InputStream, CTField.type, null);
    }
    
    public static CTField parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1InputStream, CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(Reader param1Reader) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1Reader, CTField.type, null);
    }
    
    public static CTField parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTField)POIXMLTypeLoader.parse(param1Reader, CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTField.type, null);
    }
    
    public static CTField parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(Node param1Node) throws XmlException {
      return (CTField)POIXMLTypeLoader.parse(param1Node, CTField.type, null);
    }
    
    public static CTField parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTField)POIXMLTypeLoader.parse(param1Node, CTField.type, param1XmlOptions);
    }
    
    public static CTField parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTField)POIXMLTypeLoader.parse(param1XMLInputStream, CTField.type, null);
    }
    
    public static CTField parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTField)POIXMLTypeLoader.parse(param1XMLInputStream, CTField.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTField.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTField.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */