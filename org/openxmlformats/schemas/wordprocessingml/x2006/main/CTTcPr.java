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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTcPr extends CTTcPrInner {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttcpree37type");
  
  CTTcPrChange getTcPrChange();
  
  boolean isSetTcPrChange();
  
  void setTcPrChange(CTTcPrChange paramCTTcPrChange);
  
  CTTcPrChange addNewTcPrChange();
  
  void unsetTcPrChange();
  
  public static final class Factory {
    public static CTTcPr newInstance() {
      return (CTTcPr)POIXMLTypeLoader.newInstance(CTTcPr.type, null);
    }
    
    public static CTTcPr newInstance(XmlOptions param1XmlOptions) {
      return (CTTcPr)POIXMLTypeLoader.newInstance(CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(String param1String) throws XmlException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1String, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1String, CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(File param1File) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1File, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1File, CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(URL param1URL) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1URL, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1URL, CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1InputStream, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1InputStream, CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1Reader, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1Reader, CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(Node param1Node) throws XmlException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1Node, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1Node, CTTcPr.type, param1XmlOptions);
    }
    
    public static CTTcPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcPr.type, null);
    }
    
    public static CTTcPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTcPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTcPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */