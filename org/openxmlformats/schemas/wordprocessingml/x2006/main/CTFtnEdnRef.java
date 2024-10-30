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

public interface CTFtnEdnRef extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFtnEdnRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctftnednref89eetype");
  
  STOnOff.Enum getCustomMarkFollows();
  
  STOnOff xgetCustomMarkFollows();
  
  boolean isSetCustomMarkFollows();
  
  void setCustomMarkFollows(STOnOff.Enum paramEnum);
  
  void xsetCustomMarkFollows(STOnOff paramSTOnOff);
  
  void unsetCustomMarkFollows();
  
  BigInteger getId();
  
  STDecimalNumber xgetId();
  
  void setId(BigInteger paramBigInteger);
  
  void xsetId(STDecimalNumber paramSTDecimalNumber);
  
  public static final class Factory {
    public static CTFtnEdnRef newInstance() {
      return (CTFtnEdnRef)POIXMLTypeLoader.newInstance(CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef newInstance(XmlOptions param1XmlOptions) {
      return (CTFtnEdnRef)POIXMLTypeLoader.newInstance(CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(String param1String) throws XmlException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1String, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1String, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(File param1File) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1File, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1File, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(URL param1URL) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1URL, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1URL, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1InputStream, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1InputStream, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1Reader, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1Reader, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(Node param1Node) throws XmlException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1Node, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1Node, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static CTFtnEdnRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTFtnEdnRef.type, null);
    }
    
    public static CTFtnEdnRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFtnEdnRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTFtnEdnRef.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFtnEdnRef.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFtnEdnRef.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTFtnEdnRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */