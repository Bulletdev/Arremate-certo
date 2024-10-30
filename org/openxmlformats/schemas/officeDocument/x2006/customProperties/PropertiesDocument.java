package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface PropertiesDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PropertiesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("properties288cdoctype");
  
  CTProperties getProperties();
  
  void setProperties(CTProperties paramCTProperties);
  
  CTProperties addNewProperties();
  
  public static final class Factory {
    public static PropertiesDocument newInstance() {
      return (PropertiesDocument)POIXMLTypeLoader.newInstance(PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument newInstance(XmlOptions param1XmlOptions) {
      return (PropertiesDocument)POIXMLTypeLoader.newInstance(PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(String param1String) throws XmlException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1String, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1String, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(File param1File) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1File, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1File, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(URL param1URL) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1URL, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1URL, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1InputStream, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1InputStream, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1Reader, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1Reader, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(Node param1Node) throws XmlException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1Node, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1Node, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static PropertiesDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PropertiesDocument.type, null);
    }
    
    public static PropertiesDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PropertiesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PropertiesDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PropertiesDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PropertiesDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\customProperties\PropertiesDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */