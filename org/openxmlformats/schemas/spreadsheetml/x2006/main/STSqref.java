package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STSqref extends XmlAnySimpleType {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSqref.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsqrefb044type");
  
  List getListValue();
  
  List xgetListValue();
  
  void setListValue(List paramList);
  
  List listValue();
  
  List xlistValue();
  
  void set(List paramList);
  
  public static final class Factory {
    public static STSqref newValue(Object param1Object) {
      return (STSqref)STSqref.type.newValue(param1Object);
    }
    
    public static STSqref newInstance() {
      return (STSqref)POIXMLTypeLoader.newInstance(STSqref.type, null);
    }
    
    public static STSqref newInstance(XmlOptions param1XmlOptions) {
      return (STSqref)POIXMLTypeLoader.newInstance(STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(String param1String) throws XmlException {
      return (STSqref)POIXMLTypeLoader.parse(param1String, STSqref.type, null);
    }
    
    public static STSqref parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSqref)POIXMLTypeLoader.parse(param1String, STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(File param1File) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1File, STSqref.type, null);
    }
    
    public static STSqref parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1File, STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(URL param1URL) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1URL, STSqref.type, null);
    }
    
    public static STSqref parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1URL, STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1InputStream, STSqref.type, null);
    }
    
    public static STSqref parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1InputStream, STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(Reader param1Reader) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1Reader, STSqref.type, null);
    }
    
    public static STSqref parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSqref)POIXMLTypeLoader.parse(param1Reader, STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSqref)POIXMLTypeLoader.parse(param1XMLStreamReader, STSqref.type, null);
    }
    
    public static STSqref parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSqref)POIXMLTypeLoader.parse(param1XMLStreamReader, STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(Node param1Node) throws XmlException {
      return (STSqref)POIXMLTypeLoader.parse(param1Node, STSqref.type, null);
    }
    
    public static STSqref parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSqref)POIXMLTypeLoader.parse(param1Node, STSqref.type, param1XmlOptions);
    }
    
    public static STSqref parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSqref)POIXMLTypeLoader.parse(param1XMLInputStream, STSqref.type, null);
    }
    
    public static STSqref parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSqref)POIXMLTypeLoader.parse(param1XMLInputStream, STSqref.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSqref.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSqref.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STSqref.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */