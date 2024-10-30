package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface NumberingDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(NumberingDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("numbering1c4ddoctype");
  
  CTNumbering getNumbering();
  
  void setNumbering(CTNumbering paramCTNumbering);
  
  CTNumbering addNewNumbering();
  
  public static final class Factory {
    public static NumberingDocument newInstance() {
      return (NumberingDocument)POIXMLTypeLoader.newInstance(NumberingDocument.type, null);
    }
    
    public static NumberingDocument newInstance(XmlOptions param1XmlOptions) {
      return (NumberingDocument)POIXMLTypeLoader.newInstance(NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(String param1String) throws XmlException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1String, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1String, NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(File param1File) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1File, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1File, NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(URL param1URL) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1URL, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1URL, NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1InputStream, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1InputStream, NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1Reader, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1Reader, NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(Node param1Node) throws XmlException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1Node, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1Node, NumberingDocument.type, param1XmlOptions);
    }
    
    public static NumberingDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1XMLInputStream, NumberingDocument.type, null);
    }
    
    public static NumberingDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (NumberingDocument)POIXMLTypeLoader.parse(param1XMLInputStream, NumberingDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, NumberingDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, NumberingDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\NumberingDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */