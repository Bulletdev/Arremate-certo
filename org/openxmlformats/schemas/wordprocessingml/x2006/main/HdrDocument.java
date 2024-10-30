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

public interface HdrDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(HdrDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("hdra530doctype");
  
  CTHdrFtr getHdr();
  
  void setHdr(CTHdrFtr paramCTHdrFtr);
  
  CTHdrFtr addNewHdr();
  
  public static final class Factory {
    public static HdrDocument newInstance() {
      return (HdrDocument)POIXMLTypeLoader.newInstance(HdrDocument.type, null);
    }
    
    public static HdrDocument newInstance(XmlOptions param1XmlOptions) {
      return (HdrDocument)POIXMLTypeLoader.newInstance(HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(String param1String) throws XmlException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1String, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1String, HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(File param1File) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1File, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1File, HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(URL param1URL) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1URL, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1URL, HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1InputStream, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1InputStream, HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1Reader, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1Reader, HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(Node param1Node) throws XmlException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1Node, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1Node, HdrDocument.type, param1XmlOptions);
    }
    
    public static HdrDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1XMLInputStream, HdrDocument.type, null);
    }
    
    public static HdrDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (HdrDocument)POIXMLTypeLoader.parse(param1XMLInputStream, HdrDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, HdrDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, HdrDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\HdrDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */