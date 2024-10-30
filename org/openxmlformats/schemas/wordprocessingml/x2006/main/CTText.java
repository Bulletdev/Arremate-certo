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
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTText extends STString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTText.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttext7f5btype");
  
  SpaceAttribute.Space.Enum getSpace();
  
  SpaceAttribute.Space xgetSpace();
  
  boolean isSetSpace();
  
  void setSpace(SpaceAttribute.Space.Enum paramEnum);
  
  void xsetSpace(SpaceAttribute.Space paramSpace);
  
  void unsetSpace();
  
  public static final class Factory {
    public static CTText newInstance() {
      return (CTText)POIXMLTypeLoader.newInstance(CTText.type, null);
    }
    
    public static CTText newInstance(XmlOptions param1XmlOptions) {
      return (CTText)POIXMLTypeLoader.newInstance(CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(String param1String) throws XmlException {
      return (CTText)POIXMLTypeLoader.parse(param1String, CTText.type, null);
    }
    
    public static CTText parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTText)POIXMLTypeLoader.parse(param1String, CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(File param1File) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1File, CTText.type, null);
    }
    
    public static CTText parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1File, CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(URL param1URL) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1URL, CTText.type, null);
    }
    
    public static CTText parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1URL, CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1InputStream, CTText.type, null);
    }
    
    public static CTText parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1InputStream, CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(Reader param1Reader) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1Reader, CTText.type, null);
    }
    
    public static CTText parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTText)POIXMLTypeLoader.parse(param1Reader, CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTText)POIXMLTypeLoader.parse(param1XMLStreamReader, CTText.type, null);
    }
    
    public static CTText parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTText)POIXMLTypeLoader.parse(param1XMLStreamReader, CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(Node param1Node) throws XmlException {
      return (CTText)POIXMLTypeLoader.parse(param1Node, CTText.type, null);
    }
    
    public static CTText parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTText)POIXMLTypeLoader.parse(param1Node, CTText.type, param1XmlOptions);
    }
    
    public static CTText parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTText)POIXMLTypeLoader.parse(param1XMLInputStream, CTText.type, null);
    }
    
    public static CTText parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTText)POIXMLTypeLoader.parse(param1XMLInputStream, CTText.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTText.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTText.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */