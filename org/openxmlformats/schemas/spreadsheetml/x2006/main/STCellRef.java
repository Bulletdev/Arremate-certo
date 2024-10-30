package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STCellRef extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCellRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcellrefe4e0type");
  
  public static final class Factory {
    public static STCellRef newValue(Object param1Object) {
      return (STCellRef)STCellRef.type.newValue(param1Object);
    }
    
    public static STCellRef newInstance() {
      return (STCellRef)POIXMLTypeLoader.newInstance(STCellRef.type, null);
    }
    
    public static STCellRef newInstance(XmlOptions param1XmlOptions) {
      return (STCellRef)POIXMLTypeLoader.newInstance(STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(String param1String) throws XmlException {
      return (STCellRef)POIXMLTypeLoader.parse(param1String, STCellRef.type, null);
    }
    
    public static STCellRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellRef)POIXMLTypeLoader.parse(param1String, STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(File param1File) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1File, STCellRef.type, null);
    }
    
    public static STCellRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1File, STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(URL param1URL) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1URL, STCellRef.type, null);
    }
    
    public static STCellRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1URL, STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1InputStream, STCellRef.type, null);
    }
    
    public static STCellRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1InputStream, STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(Reader param1Reader) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1Reader, STCellRef.type, null);
    }
    
    public static STCellRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCellRef)POIXMLTypeLoader.parse(param1Reader, STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCellRef)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellRef.type, null);
    }
    
    public static STCellRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellRef)POIXMLTypeLoader.parse(param1XMLStreamReader, STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(Node param1Node) throws XmlException {
      return (STCellRef)POIXMLTypeLoader.parse(param1Node, STCellRef.type, null);
    }
    
    public static STCellRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCellRef)POIXMLTypeLoader.parse(param1Node, STCellRef.type, param1XmlOptions);
    }
    
    public static STCellRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCellRef)POIXMLTypeLoader.parse(param1XMLInputStream, STCellRef.type, null);
    }
    
    public static STCellRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCellRef)POIXMLTypeLoader.parse(param1XMLInputStream, STCellRef.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellRef.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCellRef.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCellRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */