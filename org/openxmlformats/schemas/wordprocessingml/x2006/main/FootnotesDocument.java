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

public interface FootnotesDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(FootnotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("footnotes8773doctype");
  
  CTFootnotes getFootnotes();
  
  void setFootnotes(CTFootnotes paramCTFootnotes);
  
  CTFootnotes addNewFootnotes();
  
  public static final class Factory {
    public static FootnotesDocument newInstance() {
      return (FootnotesDocument)POIXMLTypeLoader.newInstance(FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument newInstance(XmlOptions param1XmlOptions) {
      return (FootnotesDocument)POIXMLTypeLoader.newInstance(FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(String param1String) throws XmlException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1String, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1String, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(File param1File) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1File, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1File, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(URL param1URL) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1URL, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1URL, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1InputStream, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1InputStream, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1Reader, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1Reader, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(Node param1Node) throws XmlException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1Node, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1Node, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static FootnotesDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, FootnotesDocument.type, null);
    }
    
    public static FootnotesDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (FootnotesDocument)POIXMLTypeLoader.parse(param1XMLInputStream, FootnotesDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, FootnotesDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, FootnotesDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\FootnotesDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */