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

public interface PresentationDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PresentationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("presentation02f7doctype");
  
  CTPresentation getPresentation();
  
  void setPresentation(CTPresentation paramCTPresentation);
  
  CTPresentation addNewPresentation();
  
  public static final class Factory {
    public static PresentationDocument newInstance() {
      return (PresentationDocument)POIXMLTypeLoader.newInstance(PresentationDocument.type, null);
    }
    
    public static PresentationDocument newInstance(XmlOptions param1XmlOptions) {
      return (PresentationDocument)POIXMLTypeLoader.newInstance(PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(String param1String) throws XmlException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1String, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1String, PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(File param1File) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1File, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1File, PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(URL param1URL) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1URL, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1URL, PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1InputStream, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1InputStream, PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1Reader, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1Reader, PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(Node param1Node) throws XmlException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1Node, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1Node, PresentationDocument.type, param1XmlOptions);
    }
    
    public static PresentationDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PresentationDocument.type, null);
    }
    
    public static PresentationDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PresentationDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PresentationDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PresentationDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PresentationDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\PresentationDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */