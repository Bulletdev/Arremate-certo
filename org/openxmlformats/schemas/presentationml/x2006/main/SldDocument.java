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

public interface SldDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SldDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sld1b98doctype");
  
  CTSlide getSld();
  
  void setSld(CTSlide paramCTSlide);
  
  CTSlide addNewSld();
  
  public static final class Factory {
    public static SldDocument newInstance() {
      return (SldDocument)POIXMLTypeLoader.newInstance(SldDocument.type, null);
    }
    
    public static SldDocument newInstance(XmlOptions param1XmlOptions) {
      return (SldDocument)POIXMLTypeLoader.newInstance(SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(String param1String) throws XmlException {
      return (SldDocument)POIXMLTypeLoader.parse(param1String, SldDocument.type, null);
    }
    
    public static SldDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SldDocument)POIXMLTypeLoader.parse(param1String, SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(File param1File) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1File, SldDocument.type, null);
    }
    
    public static SldDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1File, SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(URL param1URL) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1URL, SldDocument.type, null);
    }
    
    public static SldDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1URL, SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1InputStream, SldDocument.type, null);
    }
    
    public static SldDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1InputStream, SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1Reader, SldDocument.type, null);
    }
    
    public static SldDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SldDocument)POIXMLTypeLoader.parse(param1Reader, SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SldDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SldDocument.type, null);
    }
    
    public static SldDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SldDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(Node param1Node) throws XmlException {
      return (SldDocument)POIXMLTypeLoader.parse(param1Node, SldDocument.type, null);
    }
    
    public static SldDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SldDocument)POIXMLTypeLoader.parse(param1Node, SldDocument.type, param1XmlOptions);
    }
    
    public static SldDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SldDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SldDocument.type, null);
    }
    
    public static SldDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SldDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SldDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SldDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SldDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\SldDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */