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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STDrawingElementId extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDrawingElementId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdrawingelementid75a4type");
  
  public static final class Factory {
    public static STDrawingElementId newValue(Object param1Object) {
      return (STDrawingElementId)STDrawingElementId.type.newValue(param1Object);
    }
    
    public static STDrawingElementId newInstance() {
      return (STDrawingElementId)POIXMLTypeLoader.newInstance(STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId newInstance(XmlOptions param1XmlOptions) {
      return (STDrawingElementId)POIXMLTypeLoader.newInstance(STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(String param1String) throws XmlException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1String, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1String, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(File param1File) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1File, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1File, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(URL param1URL) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1URL, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1URL, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1InputStream, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1InputStream, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(Reader param1Reader) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1Reader, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1Reader, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1XMLStreamReader, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1XMLStreamReader, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(Node param1Node) throws XmlException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1Node, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1Node, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static STDrawingElementId parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1XMLInputStream, STDrawingElementId.type, null);
    }
    
    public static STDrawingElementId parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDrawingElementId)POIXMLTypeLoader.parse(param1XMLInputStream, STDrawingElementId.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDrawingElementId.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDrawingElementId.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STDrawingElementId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */