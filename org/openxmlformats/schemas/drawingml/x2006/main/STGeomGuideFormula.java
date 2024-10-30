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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STGeomGuideFormula extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STGeomGuideFormula.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stgeomguideformula4b51type");
  
  public static final class Factory {
    public static STGeomGuideFormula newValue(Object param1Object) {
      return (STGeomGuideFormula)STGeomGuideFormula.type.newValue(param1Object);
    }
    
    public static STGeomGuideFormula newInstance() {
      return (STGeomGuideFormula)POIXMLTypeLoader.newInstance(STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula newInstance(XmlOptions param1XmlOptions) {
      return (STGeomGuideFormula)POIXMLTypeLoader.newInstance(STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(String param1String) throws XmlException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1String, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1String, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(File param1File) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1File, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1File, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(URL param1URL) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1URL, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1URL, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1InputStream, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1InputStream, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(Reader param1Reader) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1Reader, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1Reader, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1XMLStreamReader, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1XMLStreamReader, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(Node param1Node) throws XmlException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1Node, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1Node, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static STGeomGuideFormula parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1XMLInputStream, STGeomGuideFormula.type, null);
    }
    
    public static STGeomGuideFormula parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STGeomGuideFormula)POIXMLTypeLoader.parse(param1XMLInputStream, STGeomGuideFormula.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STGeomGuideFormula.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STGeomGuideFormula.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STGeomGuideFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */