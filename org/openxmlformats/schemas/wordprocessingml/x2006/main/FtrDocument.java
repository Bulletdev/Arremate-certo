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

public interface FtrDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(FtrDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ftre182doctype");
  
  CTHdrFtr getFtr();
  
  void setFtr(CTHdrFtr paramCTHdrFtr);
  
  CTHdrFtr addNewFtr();
  
  public static final class Factory {
    public static FtrDocument newInstance() {
      return (FtrDocument)POIXMLTypeLoader.newInstance(FtrDocument.type, null);
    }
    
    public static FtrDocument newInstance(XmlOptions param1XmlOptions) {
      return (FtrDocument)POIXMLTypeLoader.newInstance(FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(String param1String) throws XmlException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1String, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1String, FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(File param1File) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1File, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1File, FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(URL param1URL) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1URL, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1URL, FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1InputStream, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1InputStream, FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1Reader, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1Reader, FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(Node param1Node) throws XmlException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1Node, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1Node, FtrDocument.type, param1XmlOptions);
    }
    
    public static FtrDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1XMLInputStream, FtrDocument.type, null);
    }
    
    public static FtrDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (FtrDocument)POIXMLTypeLoader.parse(param1XMLInputStream, FtrDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, FtrDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, FtrDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\FtrDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */