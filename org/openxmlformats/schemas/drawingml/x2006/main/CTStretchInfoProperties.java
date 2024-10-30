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

public interface CTStretchInfoProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStretchInfoProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstretchinfopropertiesde57type");
  
  CTRelativeRect getFillRect();
  
  boolean isSetFillRect();
  
  void setFillRect(CTRelativeRect paramCTRelativeRect);
  
  CTRelativeRect addNewFillRect();
  
  void unsetFillRect();
  
  public static final class Factory {
    public static CTStretchInfoProperties newInstance() {
      return (CTStretchInfoProperties)POIXMLTypeLoader.newInstance(CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTStretchInfoProperties)POIXMLTypeLoader.newInstance(CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(String param1String) throws XmlException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1String, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1String, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(File param1File) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1File, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1File, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1URL, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1URL, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1InputStream, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1InputStream, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1Reader, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1Reader, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(Node param1Node) throws XmlException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1Node, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1Node, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static CTStretchInfoProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTStretchInfoProperties.type, null);
    }
    
    public static CTStretchInfoProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStretchInfoProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTStretchInfoProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStretchInfoProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStretchInfoProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTStretchInfoProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */