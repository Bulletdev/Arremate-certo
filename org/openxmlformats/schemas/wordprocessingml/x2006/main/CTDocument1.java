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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDocument1 extends CTDocumentBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDocument1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdocument64adtype");
  
  CTBody getBody();
  
  boolean isSetBody();
  
  void setBody(CTBody paramCTBody);
  
  CTBody addNewBody();
  
  void unsetBody();
  
  public static final class Factory {
    public static CTDocument1 newInstance() {
      return (CTDocument1)POIXMLTypeLoader.newInstance(CTDocument1.type, null);
    }
    
    public static CTDocument1 newInstance(XmlOptions param1XmlOptions) {
      return (CTDocument1)POIXMLTypeLoader.newInstance(CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(String param1String) throws XmlException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1String, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1String, CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(File param1File) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1File, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1File, CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(URL param1URL) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1URL, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1URL, CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1InputStream, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1InputStream, CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1Reader, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1Reader, CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(Node param1Node) throws XmlException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1Node, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1Node, CTDocument1.type, param1XmlOptions);
    }
    
    public static CTDocument1 parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocument1.type, null);
    }
    
    public static CTDocument1 parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDocument1)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocument1.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocument1.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocument1.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTDocument1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */