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

public interface CTPictureBase extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPictureBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpicturebase5f83type");
  
  public static final class Factory {
    public static CTPictureBase newInstance() {
      return (CTPictureBase)POIXMLTypeLoader.newInstance(CTPictureBase.type, null);
    }
    
    public static CTPictureBase newInstance(XmlOptions param1XmlOptions) {
      return (CTPictureBase)POIXMLTypeLoader.newInstance(CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(String param1String) throws XmlException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1String, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1String, CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(File param1File) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1File, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1File, CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(URL param1URL) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1URL, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1URL, CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1InputStream, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1InputStream, CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1Reader, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1Reader, CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(Node param1Node) throws XmlException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1Node, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1Node, CTPictureBase.type, param1XmlOptions);
    }
    
    public static CTPictureBase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTPictureBase.type, null);
    }
    
    public static CTPictureBase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPictureBase)POIXMLTypeLoader.parse(param1XMLInputStream, CTPictureBase.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPictureBase.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPictureBase.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTPictureBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */