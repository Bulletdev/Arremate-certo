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

public interface STColID extends XmlInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STColID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcolidb7f5type");
  
  public static final class Factory {
    public static STColID newValue(Object param1Object) {
      return (STColID)STColID.type.newValue(param1Object);
    }
    
    public static STColID newInstance() {
      return (STColID)POIXMLTypeLoader.newInstance(STColID.type, null);
    }
    
    public static STColID newInstance(XmlOptions param1XmlOptions) {
      return (STColID)POIXMLTypeLoader.newInstance(STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(String param1String) throws XmlException {
      return (STColID)POIXMLTypeLoader.parse(param1String, STColID.type, null);
    }
    
    public static STColID parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STColID)POIXMLTypeLoader.parse(param1String, STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(File param1File) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1File, STColID.type, null);
    }
    
    public static STColID parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1File, STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(URL param1URL) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1URL, STColID.type, null);
    }
    
    public static STColID parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1URL, STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1InputStream, STColID.type, null);
    }
    
    public static STColID parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1InputStream, STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(Reader param1Reader) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1Reader, STColID.type, null);
    }
    
    public static STColID parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STColID)POIXMLTypeLoader.parse(param1Reader, STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STColID)POIXMLTypeLoader.parse(param1XMLStreamReader, STColID.type, null);
    }
    
    public static STColID parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STColID)POIXMLTypeLoader.parse(param1XMLStreamReader, STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(Node param1Node) throws XmlException {
      return (STColID)POIXMLTypeLoader.parse(param1Node, STColID.type, null);
    }
    
    public static STColID parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STColID)POIXMLTypeLoader.parse(param1Node, STColID.type, param1XmlOptions);
    }
    
    public static STColID parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STColID)POIXMLTypeLoader.parse(param1XMLInputStream, STColID.type, null);
    }
    
    public static STColID parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STColID)POIXMLTypeLoader.parse(param1XMLInputStream, STColID.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STColID.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STColID.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\STColID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */