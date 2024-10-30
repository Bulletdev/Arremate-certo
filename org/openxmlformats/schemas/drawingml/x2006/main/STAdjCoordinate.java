package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STAdjCoordinate extends XmlAnySimpleType {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STAdjCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stadjcoordinated920type");
  
  Object getObjectValue();
  
  void setObjectValue(Object paramObject);
  
  Object objectValue();
  
  void objectSet(Object paramObject);
  
  SchemaType instanceType();
  
  public static final class Factory {
    public static STAdjCoordinate newValue(Object param1Object) {
      return (STAdjCoordinate)STAdjCoordinate.type.newValue(param1Object);
    }
    
    public static STAdjCoordinate newInstance() {
      return (STAdjCoordinate)POIXMLTypeLoader.newInstance(STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate newInstance(XmlOptions param1XmlOptions) {
      return (STAdjCoordinate)POIXMLTypeLoader.newInstance(STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(String param1String) throws XmlException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1String, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1String, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(File param1File) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1File, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1File, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(URL param1URL) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1URL, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1URL, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1InputStream, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1InputStream, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(Reader param1Reader) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1Reader, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1Reader, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1XMLStreamReader, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1XMLStreamReader, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(Node param1Node) throws XmlException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1Node, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1Node, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static STAdjCoordinate parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1XMLInputStream, STAdjCoordinate.type, null);
    }
    
    public static STAdjCoordinate parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STAdjCoordinate)POIXMLTypeLoader.parse(param1XMLInputStream, STAdjCoordinate.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAdjCoordinate.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAdjCoordinate.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STAdjCoordinate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */