package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate32;
import org.w3c.dom.Node;

public interface STSlideSizeCoordinate extends STPositiveCoordinate32 {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSlideSizeCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stslidesizecoordinate24b5type");
  
  public static final class Factory {
    public static STSlideSizeCoordinate newValue(Object param1Object) {
      return (STSlideSizeCoordinate)STSlideSizeCoordinate.type.newValue(param1Object);
    }
    
    public static STSlideSizeCoordinate newInstance() {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.newInstance(STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate newInstance(XmlOptions param1XmlOptions) {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.newInstance(STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(String param1String) throws XmlException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1String, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1String, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(File param1File) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1File, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1File, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(URL param1URL) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1URL, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1URL, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1InputStream, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1InputStream, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(Reader param1Reader) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1Reader, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1Reader, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1XMLStreamReader, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1XMLStreamReader, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(Node param1Node) throws XmlException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1Node, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1Node, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static STSlideSizeCoordinate parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1XMLInputStream, STSlideSizeCoordinate.type, null);
    }
    
    public static STSlideSizeCoordinate parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSlideSizeCoordinate)POIXMLTypeLoader.parse(param1XMLInputStream, STSlideSizeCoordinate.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSlideSizeCoordinate.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSlideSizeCoordinate.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\STSlideSizeCoordinate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */