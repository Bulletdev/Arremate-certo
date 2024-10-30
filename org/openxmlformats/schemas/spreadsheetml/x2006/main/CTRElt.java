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

public interface CTRElt extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRElt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrelt6464type");
  
  CTRPrElt getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTRPrElt paramCTRPrElt);
  
  CTRPrElt addNewRPr();
  
  void unsetRPr();
  
  String getT();
  
  STXstring xgetT();
  
  void setT(String paramString);
  
  void xsetT(STXstring paramSTXstring);
  
  public static final class Factory {
    public static CTRElt newInstance() {
      return (CTRElt)POIXMLTypeLoader.newInstance(CTRElt.type, null);
    }
    
    public static CTRElt newInstance(XmlOptions param1XmlOptions) {
      return (CTRElt)POIXMLTypeLoader.newInstance(CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(String param1String) throws XmlException {
      return (CTRElt)POIXMLTypeLoader.parse(param1String, CTRElt.type, null);
    }
    
    public static CTRElt parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRElt)POIXMLTypeLoader.parse(param1String, CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(File param1File) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1File, CTRElt.type, null);
    }
    
    public static CTRElt parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1File, CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(URL param1URL) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1URL, CTRElt.type, null);
    }
    
    public static CTRElt parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1URL, CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1InputStream, CTRElt.type, null);
    }
    
    public static CTRElt parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1InputStream, CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1Reader, CTRElt.type, null);
    }
    
    public static CTRElt parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRElt)POIXMLTypeLoader.parse(param1Reader, CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRElt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRElt.type, null);
    }
    
    public static CTRElt parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRElt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(Node param1Node) throws XmlException {
      return (CTRElt)POIXMLTypeLoader.parse(param1Node, CTRElt.type, null);
    }
    
    public static CTRElt parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRElt)POIXMLTypeLoader.parse(param1Node, CTRElt.type, param1XmlOptions);
    }
    
    public static CTRElt parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRElt)POIXMLTypeLoader.parse(param1XMLInputStream, CTRElt.type, null);
    }
    
    public static CTRElt parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRElt)POIXMLTypeLoader.parse(param1XMLInputStream, CTRElt.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRElt.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRElt.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTRElt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */