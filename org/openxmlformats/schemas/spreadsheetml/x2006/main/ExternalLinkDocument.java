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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface ExternalLinkDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(ExternalLinkDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("externallinkb4c2doctype");
  
  CTExternalLink getExternalLink();
  
  void setExternalLink(CTExternalLink paramCTExternalLink);
  
  CTExternalLink addNewExternalLink();
  
  public static final class Factory {
    public static ExternalLinkDocument newInstance() {
      return (ExternalLinkDocument)POIXMLTypeLoader.newInstance(ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument newInstance(XmlOptions param1XmlOptions) {
      return (ExternalLinkDocument)POIXMLTypeLoader.newInstance(ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(String param1String) throws XmlException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1String, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1String, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(File param1File) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1File, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1File, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(URL param1URL) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1URL, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1URL, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1InputStream, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1InputStream, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1Reader, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1Reader, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(Node param1Node) throws XmlException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1Node, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1Node, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static ExternalLinkDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ExternalLinkDocument.type, null);
    }
    
    public static ExternalLinkDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (ExternalLinkDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ExternalLinkDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ExternalLinkDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ExternalLinkDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\ExternalLinkDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */