package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTEmpty extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTEmpty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctempty3fa5type");
  
  public static final class Factory {
    public static CTEmpty newInstance() {
      return (CTEmpty)POIXMLTypeLoader.newInstance(CTEmpty.type, null);
    }
    
    public static CTEmpty newInstance(XmlOptions param1XmlOptions) {
      return (CTEmpty)POIXMLTypeLoader.newInstance(CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(String param1String) throws XmlException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1String, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1String, CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(File param1File) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1File, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1File, CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(URL param1URL) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1URL, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1URL, CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1InputStream, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1InputStream, CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(Reader param1Reader) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1Reader, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1Reader, CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(Node param1Node) throws XmlException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1Node, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1Node, CTEmpty.type, param1XmlOptions);
    }
    
    public static CTEmpty parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1XMLInputStream, CTEmpty.type, null);
    }
    
    public static CTEmpty parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTEmpty)POIXMLTypeLoader.parse(param1XMLInputStream, CTEmpty.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEmpty.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEmpty.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */