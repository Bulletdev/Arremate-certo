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

public interface CTTextAlignment extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextalignment495ctype");
  
  STTextAlignment.Enum getVal();
  
  STTextAlignment xgetVal();
  
  void setVal(STTextAlignment.Enum paramEnum);
  
  void xsetVal(STTextAlignment paramSTTextAlignment);
  
  public static final class Factory {
    public static CTTextAlignment newInstance() {
      return (CTTextAlignment)POIXMLTypeLoader.newInstance(CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment newInstance(XmlOptions param1XmlOptions) {
      return (CTTextAlignment)POIXMLTypeLoader.newInstance(CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(String param1String) throws XmlException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1String, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1String, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(File param1File) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1File, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1File, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(URL param1URL) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1URL, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1URL, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1InputStream, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1InputStream, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1Reader, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1Reader, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(Node param1Node) throws XmlException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1Node, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1Node, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static CTTextAlignment parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextAlignment.type, null);
    }
    
    public static CTTextAlignment parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextAlignment.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextAlignment.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextAlignment.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTextAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */