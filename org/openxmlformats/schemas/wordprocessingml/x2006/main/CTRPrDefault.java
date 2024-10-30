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

public interface CTRPrDefault extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRPrDefault.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrprdefault5ebbtype");
  
  CTRPr getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTRPr paramCTRPr);
  
  CTRPr addNewRPr();
  
  void unsetRPr();
  
  public static final class Factory {
    public static CTRPrDefault newInstance() {
      return (CTRPrDefault)POIXMLTypeLoader.newInstance(CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault newInstance(XmlOptions param1XmlOptions) {
      return (CTRPrDefault)POIXMLTypeLoader.newInstance(CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(String param1String) throws XmlException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1String, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1String, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(File param1File) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1File, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1File, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(URL param1URL) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1URL, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1URL, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1InputStream, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1InputStream, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1Reader, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1Reader, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(Node param1Node) throws XmlException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1Node, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1Node, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static CTRPrDefault parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1XMLInputStream, CTRPrDefault.type, null);
    }
    
    public static CTRPrDefault parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRPrDefault)POIXMLTypeLoader.parse(param1XMLInputStream, CTRPrDefault.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRPrDefault.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRPrDefault.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTRPrDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */