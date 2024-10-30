package org.openxmlformats.schemas.presentationml.x2006.main;

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

public interface STName extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stnameadaatype");
  
  public static final class Factory {
    public static STName newValue(Object param1Object) {
      return (STName)STName.type.newValue(param1Object);
    }
    
    public static STName newInstance() {
      return (STName)POIXMLTypeLoader.newInstance(STName.type, null);
    }
    
    public static STName newInstance(XmlOptions param1XmlOptions) {
      return (STName)POIXMLTypeLoader.newInstance(STName.type, param1XmlOptions);
    }
    
    public static STName parse(String param1String) throws XmlException {
      return (STName)POIXMLTypeLoader.parse(param1String, STName.type, null);
    }
    
    public static STName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STName)POIXMLTypeLoader.parse(param1String, STName.type, param1XmlOptions);
    }
    
    public static STName parse(File param1File) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1File, STName.type, null);
    }
    
    public static STName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1File, STName.type, param1XmlOptions);
    }
    
    public static STName parse(URL param1URL) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1URL, STName.type, null);
    }
    
    public static STName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1URL, STName.type, param1XmlOptions);
    }
    
    public static STName parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1InputStream, STName.type, null);
    }
    
    public static STName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1InputStream, STName.type, param1XmlOptions);
    }
    
    public static STName parse(Reader param1Reader) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1Reader, STName.type, null);
    }
    
    public static STName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STName)POIXMLTypeLoader.parse(param1Reader, STName.type, param1XmlOptions);
    }
    
    public static STName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STName)POIXMLTypeLoader.parse(param1XMLStreamReader, STName.type, null);
    }
    
    public static STName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STName)POIXMLTypeLoader.parse(param1XMLStreamReader, STName.type, param1XmlOptions);
    }
    
    public static STName parse(Node param1Node) throws XmlException {
      return (STName)POIXMLTypeLoader.parse(param1Node, STName.type, null);
    }
    
    public static STName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STName)POIXMLTypeLoader.parse(param1Node, STName.type, param1XmlOptions);
    }
    
    public static STName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STName)POIXMLTypeLoader.parse(param1XMLInputStream, STName.type, null);
    }
    
    public static STName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STName)POIXMLTypeLoader.parse(param1XMLInputStream, STName.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STName.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STName.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\STName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */