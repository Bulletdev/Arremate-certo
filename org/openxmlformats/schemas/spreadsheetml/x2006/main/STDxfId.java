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

public interface STDxfId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDxfId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdxfid9fdctype");
  
  public static final class Factory {
    public static STDxfId newValue(Object param1Object) {
      return (STDxfId)STDxfId.type.newValue(param1Object);
    }
    
    public static STDxfId newInstance() {
      return (STDxfId)POIXMLTypeLoader.newInstance(STDxfId.type, null);
    }
    
    public static STDxfId newInstance(XmlOptions param1XmlOptions) {
      return (STDxfId)POIXMLTypeLoader.newInstance(STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(String param1String) throws XmlException {
      return (STDxfId)POIXMLTypeLoader.parse(param1String, STDxfId.type, null);
    }
    
    public static STDxfId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDxfId)POIXMLTypeLoader.parse(param1String, STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(File param1File) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1File, STDxfId.type, null);
    }
    
    public static STDxfId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1File, STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(URL param1URL) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1URL, STDxfId.type, null);
    }
    
    public static STDxfId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1URL, STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1InputStream, STDxfId.type, null);
    }
    
    public static STDxfId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1InputStream, STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(Reader param1Reader) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1Reader, STDxfId.type, null);
    }
    
    public static STDxfId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDxfId)POIXMLTypeLoader.parse(param1Reader, STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDxfId)POIXMLTypeLoader.parse(param1XMLStreamReader, STDxfId.type, null);
    }
    
    public static STDxfId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDxfId)POIXMLTypeLoader.parse(param1XMLStreamReader, STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(Node param1Node) throws XmlException {
      return (STDxfId)POIXMLTypeLoader.parse(param1Node, STDxfId.type, null);
    }
    
    public static STDxfId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDxfId)POIXMLTypeLoader.parse(param1Node, STDxfId.type, param1XmlOptions);
    }
    
    public static STDxfId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDxfId)POIXMLTypeLoader.parse(param1XMLInputStream, STDxfId.type, null);
    }
    
    public static STDxfId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDxfId)POIXMLTypeLoader.parse(param1XMLInputStream, STDxfId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDxfId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDxfId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STDxfId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */