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

public interface STFillId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFillId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfillida097type");
  
  public static final class Factory {
    public static STFillId newValue(Object param1Object) {
      return (STFillId)STFillId.type.newValue(param1Object);
    }
    
    public static STFillId newInstance() {
      return (STFillId)POIXMLTypeLoader.newInstance(STFillId.type, null);
    }
    
    public static STFillId newInstance(XmlOptions param1XmlOptions) {
      return (STFillId)POIXMLTypeLoader.newInstance(STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(String param1String) throws XmlException {
      return (STFillId)POIXMLTypeLoader.parse(param1String, STFillId.type, null);
    }
    
    public static STFillId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFillId)POIXMLTypeLoader.parse(param1String, STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(File param1File) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1File, STFillId.type, null);
    }
    
    public static STFillId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1File, STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(URL param1URL) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1URL, STFillId.type, null);
    }
    
    public static STFillId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1URL, STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1InputStream, STFillId.type, null);
    }
    
    public static STFillId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1InputStream, STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(Reader param1Reader) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1Reader, STFillId.type, null);
    }
    
    public static STFillId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFillId)POIXMLTypeLoader.parse(param1Reader, STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFillId)POIXMLTypeLoader.parse(param1XMLStreamReader, STFillId.type, null);
    }
    
    public static STFillId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFillId)POIXMLTypeLoader.parse(param1XMLStreamReader, STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(Node param1Node) throws XmlException {
      return (STFillId)POIXMLTypeLoader.parse(param1Node, STFillId.type, null);
    }
    
    public static STFillId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFillId)POIXMLTypeLoader.parse(param1Node, STFillId.type, param1XmlOptions);
    }
    
    public static STFillId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFillId)POIXMLTypeLoader.parse(param1XMLInputStream, STFillId.type, null);
    }
    
    public static STFillId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFillId)POIXMLTypeLoader.parse(param1XMLInputStream, STFillId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFillId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFillId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STFillId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */