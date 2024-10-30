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

public interface CTBookmark extends CTBookmarkRange {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBookmark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbookmarkd672type");
  
  String getName();
  
  STString xgetName();
  
  void setName(String paramString);
  
  void xsetName(STString paramSTString);
  
  public static final class Factory {
    public static CTBookmark newInstance() {
      return (CTBookmark)POIXMLTypeLoader.newInstance(CTBookmark.type, null);
    }
    
    public static CTBookmark newInstance(XmlOptions param1XmlOptions) {
      return (CTBookmark)POIXMLTypeLoader.newInstance(CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(String param1String) throws XmlException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1String, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1String, CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(File param1File) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1File, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1File, CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(URL param1URL) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1URL, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1URL, CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1InputStream, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1InputStream, CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1Reader, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1Reader, CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(Node param1Node) throws XmlException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1Node, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1Node, CTBookmark.type, param1XmlOptions);
    }
    
    public static CTBookmark parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookmark.type, null);
    }
    
    public static CTBookmark parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBookmark)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookmark.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookmark.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookmark.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTBookmark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */