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

public interface CTHighlight extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHighlight.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthighlight071etype");
  
  STHighlightColor.Enum getVal();
  
  STHighlightColor xgetVal();
  
  void setVal(STHighlightColor.Enum paramEnum);
  
  void xsetVal(STHighlightColor paramSTHighlightColor);
  
  public static final class Factory {
    public static CTHighlight newInstance() {
      return (CTHighlight)POIXMLTypeLoader.newInstance(CTHighlight.type, null);
    }
    
    public static CTHighlight newInstance(XmlOptions param1XmlOptions) {
      return (CTHighlight)POIXMLTypeLoader.newInstance(CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(String param1String) throws XmlException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1String, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1String, CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(File param1File) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1File, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1File, CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(URL param1URL) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1URL, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1URL, CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1InputStream, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1InputStream, CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1Reader, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1Reader, CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(Node param1Node) throws XmlException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1Node, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1Node, CTHighlight.type, param1XmlOptions);
    }
    
    public static CTHighlight parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1XMLInputStream, CTHighlight.type, null);
    }
    
    public static CTHighlight parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHighlight)POIXMLTypeLoader.parse(param1XMLInputStream, CTHighlight.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHighlight.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHighlight.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTHighlight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */