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

public interface CTPPrDefault extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPPrDefault.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpprdefaultf839type");
  
  CTPPr getPPr();
  
  boolean isSetPPr();
  
  void setPPr(CTPPr paramCTPPr);
  
  CTPPr addNewPPr();
  
  void unsetPPr();
  
  public static final class Factory {
    public static CTPPrDefault newInstance() {
      return (CTPPrDefault)POIXMLTypeLoader.newInstance(CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault newInstance(XmlOptions param1XmlOptions) {
      return (CTPPrDefault)POIXMLTypeLoader.newInstance(CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(String param1String) throws XmlException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1String, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1String, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(File param1File) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1File, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1File, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(URL param1URL) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1URL, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1URL, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1InputStream, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1InputStream, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1Reader, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1Reader, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(Node param1Node) throws XmlException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1Node, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1Node, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static CTPPrDefault parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1XMLInputStream, CTPPrDefault.type, null);
    }
    
    public static CTPPrDefault parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPPrDefault)POIXMLTypeLoader.parse(param1XMLInputStream, CTPPrDefault.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPPrDefault.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPPrDefault.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTPPrDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */