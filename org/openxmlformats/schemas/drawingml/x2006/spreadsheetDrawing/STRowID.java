package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STRowID extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STRowID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("strowidf4cftype");
  
  public static final class Factory {
    public static STRowID newValue(Object param1Object) {
      return (STRowID)STRowID.type.newValue(param1Object);
    }
    
    public static STRowID newInstance() {
      return (STRowID)POIXMLTypeLoader.newInstance(STRowID.type, null);
    }
    
    public static STRowID newInstance(XmlOptions param1XmlOptions) {
      return (STRowID)POIXMLTypeLoader.newInstance(STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(String param1String) throws XmlException {
      return (STRowID)POIXMLTypeLoader.parse(param1String, STRowID.type, null);
    }
    
    public static STRowID parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STRowID)POIXMLTypeLoader.parse(param1String, STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(File param1File) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1File, STRowID.type, null);
    }
    
    public static STRowID parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1File, STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(URL param1URL) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1URL, STRowID.type, null);
    }
    
    public static STRowID parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1URL, STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1InputStream, STRowID.type, null);
    }
    
    public static STRowID parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1InputStream, STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(Reader param1Reader) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1Reader, STRowID.type, null);
    }
    
    public static STRowID parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STRowID)POIXMLTypeLoader.parse(param1Reader, STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STRowID)POIXMLTypeLoader.parse(param1XMLStreamReader, STRowID.type, null);
    }
    
    public static STRowID parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STRowID)POIXMLTypeLoader.parse(param1XMLStreamReader, STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(Node param1Node) throws XmlException {
      return (STRowID)POIXMLTypeLoader.parse(param1Node, STRowID.type, null);
    }
    
    public static STRowID parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STRowID)POIXMLTypeLoader.parse(param1Node, STRowID.type, param1XmlOptions);
    }
    
    public static STRowID parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STRowID)POIXMLTypeLoader.parse(param1XMLInputStream, STRowID.type, null);
    }
    
    public static STRowID parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STRowID)POIXMLTypeLoader.parse(param1XMLInputStream, STRowID.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STRowID.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STRowID.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\STRowID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */