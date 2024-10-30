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

public interface CTTextShapeAutofit extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextShapeAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextshapeautofita009type");
  
  public static final class Factory {
    public static CTTextShapeAutofit newInstance() {
      return (CTTextShapeAutofit)POIXMLTypeLoader.newInstance(CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit newInstance(XmlOptions param1XmlOptions) {
      return (CTTextShapeAutofit)POIXMLTypeLoader.newInstance(CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(String param1String) throws XmlException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1String, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1String, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(File param1File) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1File, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1File, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(URL param1URL) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1URL, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1URL, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1InputStream, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1InputStream, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1Reader, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1Reader, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(Node param1Node) throws XmlException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1Node, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1Node, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static CTTextShapeAutofit parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextShapeAutofit.type, null);
    }
    
    public static CTTextShapeAutofit parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextShapeAutofit)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextShapeAutofit.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextShapeAutofit.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextShapeAutofit.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextShapeAutofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */