package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STWrapDistance extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STWrapDistance.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stwrapdistanceea50type");
  
  public static final class Factory {
    public static STWrapDistance newValue(Object param1Object) {
      return (STWrapDistance)STWrapDistance.type.newValue(param1Object);
    }
    
    public static STWrapDistance newInstance() {
      return (STWrapDistance)POIXMLTypeLoader.newInstance(STWrapDistance.type, null);
    }
    
    public static STWrapDistance newInstance(XmlOptions param1XmlOptions) {
      return (STWrapDistance)POIXMLTypeLoader.newInstance(STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(String param1String) throws XmlException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1String, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1String, STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(File param1File) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1File, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1File, STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(URL param1URL) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1URL, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1URL, STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1InputStream, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1InputStream, STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(Reader param1Reader) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1Reader, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1Reader, STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1XMLStreamReader, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1XMLStreamReader, STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(Node param1Node) throws XmlException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1Node, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1Node, STWrapDistance.type, param1XmlOptions);
    }
    
    public static STWrapDistance parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1XMLInputStream, STWrapDistance.type, null);
    }
    
    public static STWrapDistance parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STWrapDistance)POIXMLTypeLoader.parse(param1XMLInputStream, STWrapDistance.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STWrapDistance.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STWrapDistance.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\wordprocessingDrawing\STWrapDistance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */