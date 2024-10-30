package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STTextTypeface extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextTypeface.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttexttypefacea80ftype");
  
  public static final class Factory {
    public static STTextTypeface newValue(Object param1Object) {
      return (STTextTypeface)STTextTypeface.type.newValue(param1Object);
    }
    
    public static STTextTypeface newInstance() {
      return (STTextTypeface)POIXMLTypeLoader.newInstance(STTextTypeface.type, null);
    }
    
    public static STTextTypeface newInstance(XmlOptions param1XmlOptions) {
      return (STTextTypeface)POIXMLTypeLoader.newInstance(STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(String param1String) throws XmlException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1String, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1String, STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(File param1File) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1File, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1File, STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(URL param1URL) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1URL, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1URL, STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1InputStream, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1InputStream, STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1Reader, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1Reader, STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(Node param1Node) throws XmlException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1Node, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1Node, STTextTypeface.type, param1XmlOptions);
    }
    
    public static STTextTypeface parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1XMLInputStream, STTextTypeface.type, null);
    }
    
    public static STTextTypeface parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextTypeface)POIXMLTypeLoader.parse(param1XMLInputStream, STTextTypeface.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextTypeface.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextTypeface.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextTypeface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */