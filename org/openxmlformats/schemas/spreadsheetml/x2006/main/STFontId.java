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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STFontId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFontId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfontid9d63type");
  
  public static final class Factory {
    public static STFontId newValue(Object param1Object) {
      return (STFontId)STFontId.type.newValue(param1Object);
    }
    
    public static STFontId newInstance() {
      return (STFontId)POIXMLTypeLoader.newInstance(STFontId.type, null);
    }
    
    public static STFontId newInstance(XmlOptions param1XmlOptions) {
      return (STFontId)POIXMLTypeLoader.newInstance(STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(String param1String) throws XmlException {
      return (STFontId)POIXMLTypeLoader.parse(param1String, STFontId.type, null);
    }
    
    public static STFontId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontId)POIXMLTypeLoader.parse(param1String, STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(File param1File) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1File, STFontId.type, null);
    }
    
    public static STFontId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1File, STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(URL param1URL) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1URL, STFontId.type, null);
    }
    
    public static STFontId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1URL, STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1InputStream, STFontId.type, null);
    }
    
    public static STFontId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1InputStream, STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(Reader param1Reader) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1Reader, STFontId.type, null);
    }
    
    public static STFontId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFontId)POIXMLTypeLoader.parse(param1Reader, STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFontId)POIXMLTypeLoader.parse(param1XMLStreamReader, STFontId.type, null);
    }
    
    public static STFontId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontId)POIXMLTypeLoader.parse(param1XMLStreamReader, STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(Node param1Node) throws XmlException {
      return (STFontId)POIXMLTypeLoader.parse(param1Node, STFontId.type, null);
    }
    
    public static STFontId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFontId)POIXMLTypeLoader.parse(param1Node, STFontId.type, param1XmlOptions);
    }
    
    public static STFontId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFontId)POIXMLTypeLoader.parse(param1XMLInputStream, STFontId.type, null);
    }
    
    public static STFontId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFontId)POIXMLTypeLoader.parse(param1XMLInputStream, STFontId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFontId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFontId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STFontId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */