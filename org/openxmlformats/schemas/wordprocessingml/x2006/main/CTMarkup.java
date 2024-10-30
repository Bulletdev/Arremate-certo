package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

public interface CTMarkup extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMarkup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmarkup2d80type");
  
  BigInteger getId();
  
  STDecimalNumber xgetId();
  
  void setId(BigInteger paramBigInteger);
  
  void xsetId(STDecimalNumber paramSTDecimalNumber);
  
  public static final class Factory {
    public static CTMarkup newInstance() {
      return (CTMarkup)POIXMLTypeLoader.newInstance(CTMarkup.type, null);
    }
    
    public static CTMarkup newInstance(XmlOptions param1XmlOptions) {
      return (CTMarkup)POIXMLTypeLoader.newInstance(CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(String param1String) throws XmlException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1String, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1String, CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(File param1File) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1File, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1File, CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(URL param1URL) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1URL, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1URL, CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1InputStream, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1InputStream, CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1Reader, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1Reader, CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(Node param1Node) throws XmlException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1Node, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1Node, CTMarkup.type, param1XmlOptions);
    }
    
    public static CTMarkup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarkup.type, null);
    }
    
    public static CTMarkup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMarkup)POIXMLTypeLoader.parse(param1XMLInputStream, CTMarkup.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarkup.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMarkup.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTMarkup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */