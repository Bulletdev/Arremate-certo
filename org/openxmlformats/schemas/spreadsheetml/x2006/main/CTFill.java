package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTFill extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfill550ctype");
  
  CTPatternFill getPatternFill();
  
  boolean isSetPatternFill();
  
  void setPatternFill(CTPatternFill paramCTPatternFill);
  
  CTPatternFill addNewPatternFill();
  
  void unsetPatternFill();
  
  CTGradientFill getGradientFill();
  
  boolean isSetGradientFill();
  
  void setGradientFill(CTGradientFill paramCTGradientFill);
  
  CTGradientFill addNewGradientFill();
  
  void unsetGradientFill();
  
  public static final class Factory {
    public static CTFill newInstance() {
      return (CTFill)POIXMLTypeLoader.newInstance(CTFill.type, null);
    }
    
    public static CTFill newInstance(XmlOptions param1XmlOptions) {
      return (CTFill)POIXMLTypeLoader.newInstance(CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(String param1String) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1String, CTFill.type, null);
    }
    
    public static CTFill parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1String, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(File param1File) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1File, CTFill.type, null);
    }
    
    public static CTFill parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1File, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(URL param1URL) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1URL, CTFill.type, null);
    }
    
    public static CTFill parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1URL, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1InputStream, CTFill.type, null);
    }
    
    public static CTFill parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1InputStream, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1Reader, CTFill.type, null);
    }
    
    public static CTFill parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1Reader, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFill.type, null);
    }
    
    public static CTFill parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(Node param1Node) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1Node, CTFill.type, null);
    }
    
    public static CTFill parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1Node, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLInputStream, CTFill.type, null);
    }
    
    public static CTFill parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLInputStream, CTFill.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFill.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFill.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTFill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */