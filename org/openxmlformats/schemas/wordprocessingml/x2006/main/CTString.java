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

public interface CTString extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTString.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstring9c37type");
  
  String getVal();
  
  STString xgetVal();
  
  void setVal(String paramString);
  
  void xsetVal(STString paramSTString);
  
  public static final class Factory {
    public static CTString newInstance() {
      return (CTString)POIXMLTypeLoader.newInstance(CTString.type, null);
    }
    
    public static CTString newInstance(XmlOptions param1XmlOptions) {
      return (CTString)POIXMLTypeLoader.newInstance(CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(String param1String) throws XmlException {
      return (CTString)POIXMLTypeLoader.parse(param1String, CTString.type, null);
    }
    
    public static CTString parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTString)POIXMLTypeLoader.parse(param1String, CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(File param1File) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1File, CTString.type, null);
    }
    
    public static CTString parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1File, CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(URL param1URL) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1URL, CTString.type, null);
    }
    
    public static CTString parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1URL, CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1InputStream, CTString.type, null);
    }
    
    public static CTString parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1InputStream, CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(Reader param1Reader) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1Reader, CTString.type, null);
    }
    
    public static CTString parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTString)POIXMLTypeLoader.parse(param1Reader, CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTString)POIXMLTypeLoader.parse(param1XMLStreamReader, CTString.type, null);
    }
    
    public static CTString parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTString)POIXMLTypeLoader.parse(param1XMLStreamReader, CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(Node param1Node) throws XmlException {
      return (CTString)POIXMLTypeLoader.parse(param1Node, CTString.type, null);
    }
    
    public static CTString parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTString)POIXMLTypeLoader.parse(param1Node, CTString.type, param1XmlOptions);
    }
    
    public static CTString parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTString)POIXMLTypeLoader.parse(param1XMLInputStream, CTString.type, null);
    }
    
    public static CTString parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTString)POIXMLTypeLoader.parse(param1XMLInputStream, CTString.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTString.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTString.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */