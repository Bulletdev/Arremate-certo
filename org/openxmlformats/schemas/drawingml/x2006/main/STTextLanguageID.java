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

public interface STTextLanguageID extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextLanguageID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextlanguageid806btype");
  
  public static final class Factory {
    public static STTextLanguageID newValue(Object param1Object) {
      return (STTextLanguageID)STTextLanguageID.type.newValue(param1Object);
    }
    
    public static STTextLanguageID newInstance() {
      return (STTextLanguageID)POIXMLTypeLoader.newInstance(STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID newInstance(XmlOptions param1XmlOptions) {
      return (STTextLanguageID)POIXMLTypeLoader.newInstance(STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(String param1String) throws XmlException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1String, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1String, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(File param1File) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1File, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1File, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(URL param1URL) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1URL, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1URL, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1InputStream, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1InputStream, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1Reader, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1Reader, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(Node param1Node) throws XmlException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1Node, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1Node, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static STTextLanguageID parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1XMLInputStream, STTextLanguageID.type, null);
    }
    
    public static STTextLanguageID parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextLanguageID)POIXMLTypeLoader.parse(param1XMLInputStream, STTextLanguageID.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextLanguageID.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextLanguageID.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextLanguageID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */