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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBooleanProperty extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBooleanProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbooleanproperty1f3ctype");
  
  boolean getVal();
  
  XmlBoolean xgetVal();
  
  boolean isSetVal();
  
  void setVal(boolean paramBoolean);
  
  void xsetVal(XmlBoolean paramXmlBoolean);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTBooleanProperty newInstance() {
      return (CTBooleanProperty)POIXMLTypeLoader.newInstance(CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty newInstance(XmlOptions param1XmlOptions) {
      return (CTBooleanProperty)POIXMLTypeLoader.newInstance(CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(String param1String) throws XmlException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1String, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1String, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(File param1File) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1File, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1File, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(URL param1URL) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1URL, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1URL, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1InputStream, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1InputStream, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1Reader, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1Reader, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(Node param1Node) throws XmlException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1Node, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1Node, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static CTBooleanProperty parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTBooleanProperty.type, null);
    }
    
    public static CTBooleanProperty parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBooleanProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTBooleanProperty.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBooleanProperty.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBooleanProperty.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTBooleanProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */