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

public interface CTDocumentBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDocumentBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdocumentbasedf5ctype");
  
  CTBackground getBackground();
  
  boolean isSetBackground();
  
  void setBackground(CTBackground paramCTBackground);
  
  CTBackground addNewBackground();
  
  void unsetBackground();
  
  public static final class Factory {
    public static CTDocumentBase newInstance() {
      return (CTDocumentBase)POIXMLTypeLoader.newInstance(CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase newInstance(XmlOptions param1XmlOptions) {
      return (CTDocumentBase)POIXMLTypeLoader.newInstance(CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(String param1String) throws XmlException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1String, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1String, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(File param1File) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1File, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1File, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(URL param1URL) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1URL, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1URL, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1InputStream, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1InputStream, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1Reader, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1Reader, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(Node param1Node) throws XmlException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1Node, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1Node, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static CTDocumentBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocumentBase.type, null);
    }
    
    public static CTDocumentBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDocumentBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocumentBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocumentBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocumentBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTDocumentBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */