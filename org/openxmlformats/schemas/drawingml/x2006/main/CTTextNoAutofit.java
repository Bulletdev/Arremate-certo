package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTTextNoAutofit extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextNoAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextnoautofit1045type");
  
  public static final class Factory {
    public static CTTextNoAutofit newInstance() {
      return (CTTextNoAutofit)POIXMLTypeLoader.newInstance(CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit newInstance(XmlOptions param1XmlOptions) {
      return (CTTextNoAutofit)POIXMLTypeLoader.newInstance(CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(String param1String) throws XmlException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1String, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1String, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(File param1File) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1File, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1File, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(URL param1URL) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1URL, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1URL, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1InputStream, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1InputStream, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1Reader, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1Reader, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(Node param1Node) throws XmlException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1Node, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1Node, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static CTTextNoAutofit parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextNoAutofit.type, null);
    }
    
    public static CTTextNoAutofit parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextNoAutofit)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextNoAutofit.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextNoAutofit.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextNoAutofit.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextNoAutofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */