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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STFormula extends STXstring {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STFormula.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stformula7e35type");
  
  public static final class Factory {
    public static STFormula newValue(Object param1Object) {
      return (STFormula)STFormula.type.newValue(param1Object);
    }
    
    public static STFormula newInstance() {
      return (STFormula)POIXMLTypeLoader.newInstance(STFormula.type, null);
    }
    
    public static STFormula newInstance(XmlOptions param1XmlOptions) {
      return (STFormula)POIXMLTypeLoader.newInstance(STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(String param1String) throws XmlException {
      return (STFormula)POIXMLTypeLoader.parse(param1String, STFormula.type, null);
    }
    
    public static STFormula parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STFormula)POIXMLTypeLoader.parse(param1String, STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(File param1File) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1File, STFormula.type, null);
    }
    
    public static STFormula parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1File, STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(URL param1URL) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1URL, STFormula.type, null);
    }
    
    public static STFormula parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1URL, STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1InputStream, STFormula.type, null);
    }
    
    public static STFormula parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1InputStream, STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(Reader param1Reader) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1Reader, STFormula.type, null);
    }
    
    public static STFormula parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STFormula)POIXMLTypeLoader.parse(param1Reader, STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STFormula)POIXMLTypeLoader.parse(param1XMLStreamReader, STFormula.type, null);
    }
    
    public static STFormula parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STFormula)POIXMLTypeLoader.parse(param1XMLStreamReader, STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(Node param1Node) throws XmlException {
      return (STFormula)POIXMLTypeLoader.parse(param1Node, STFormula.type, null);
    }
    
    public static STFormula parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STFormula)POIXMLTypeLoader.parse(param1Node, STFormula.type, param1XmlOptions);
    }
    
    public static STFormula parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STFormula)POIXMLTypeLoader.parse(param1XMLInputStream, STFormula.type, null);
    }
    
    public static STFormula parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STFormula)POIXMLTypeLoader.parse(param1XMLInputStream, STFormula.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFormula.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STFormula.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */