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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTGroupFillProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGroupFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgroupfillpropertiesec66type");
  
  public static final class Factory {
    public static CTGroupFillProperties newInstance() {
      return (CTGroupFillProperties)POIXMLTypeLoader.newInstance(CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTGroupFillProperties)POIXMLTypeLoader.newInstance(CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(String param1String) throws XmlException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1String, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1String, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(File param1File) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1File, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1File, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1URL, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1URL, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1InputStream, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1Reader, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1Reader, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(Node param1Node) throws XmlException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1Node, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1Node, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static CTGroupFillProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupFillProperties.type, null);
    }
    
    public static CTGroupFillProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGroupFillProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupFillProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupFillProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupFillProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGroupFillProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */