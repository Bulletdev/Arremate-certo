package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

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

public interface STClsid extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STClsid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stclsida7datype");
  
  public static final class Factory {
    public static STClsid newValue(Object param1Object) {
      return (STClsid)STClsid.type.newValue(param1Object);
    }
    
    public static STClsid newInstance() {
      return (STClsid)POIXMLTypeLoader.newInstance(STClsid.type, null);
    }
    
    public static STClsid newInstance(XmlOptions param1XmlOptions) {
      return (STClsid)POIXMLTypeLoader.newInstance(STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(String param1String) throws XmlException {
      return (STClsid)POIXMLTypeLoader.parse(param1String, STClsid.type, null);
    }
    
    public static STClsid parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STClsid)POIXMLTypeLoader.parse(param1String, STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(File param1File) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1File, STClsid.type, null);
    }
    
    public static STClsid parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1File, STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(URL param1URL) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1URL, STClsid.type, null);
    }
    
    public static STClsid parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1URL, STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1InputStream, STClsid.type, null);
    }
    
    public static STClsid parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1InputStream, STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(Reader param1Reader) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1Reader, STClsid.type, null);
    }
    
    public static STClsid parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STClsid)POIXMLTypeLoader.parse(param1Reader, STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STClsid)POIXMLTypeLoader.parse(param1XMLStreamReader, STClsid.type, null);
    }
    
    public static STClsid parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STClsid)POIXMLTypeLoader.parse(param1XMLStreamReader, STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(Node param1Node) throws XmlException {
      return (STClsid)POIXMLTypeLoader.parse(param1Node, STClsid.type, null);
    }
    
    public static STClsid parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STClsid)POIXMLTypeLoader.parse(param1Node, STClsid.type, param1XmlOptions);
    }
    
    public static STClsid parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STClsid)POIXMLTypeLoader.parse(param1XMLInputStream, STClsid.type, null);
    }
    
    public static STClsid parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STClsid)POIXMLTypeLoader.parse(param1XMLInputStream, STClsid.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STClsid.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STClsid.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\docPropsVTypes\STClsid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */