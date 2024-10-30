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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface SldLayoutDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SldLayoutDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sldlayout638edoctype");
  
  CTSlideLayout getSldLayout();
  
  void setSldLayout(CTSlideLayout paramCTSlideLayout);
  
  CTSlideLayout addNewSldLayout();
  
  public static final class Factory {
    public static SldLayoutDocument newInstance() {
      return (SldLayoutDocument)POIXMLTypeLoader.newInstance(SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument newInstance(XmlOptions param1XmlOptions) {
      return (SldLayoutDocument)POIXMLTypeLoader.newInstance(SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(String param1String) throws XmlException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1String, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1String, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(File param1File) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1File, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1File, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(URL param1URL) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1URL, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1URL, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1InputStream, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1InputStream, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1Reader, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1Reader, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(Node param1Node) throws XmlException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1Node, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1Node, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static SldLayoutDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SldLayoutDocument.type, null);
    }
    
    public static SldLayoutDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SldLayoutDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SldLayoutDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SldLayoutDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SldLayoutDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\SldLayoutDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */