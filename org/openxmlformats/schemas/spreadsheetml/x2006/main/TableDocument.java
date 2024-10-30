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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface TableDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(TableDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("table0b99doctype");
  
  CTTable getTable();
  
  void setTable(CTTable paramCTTable);
  
  CTTable addNewTable();
  
  public static final class Factory {
    public static TableDocument newInstance() {
      return (TableDocument)POIXMLTypeLoader.newInstance(TableDocument.type, null);
    }
    
    public static TableDocument newInstance(XmlOptions param1XmlOptions) {
      return (TableDocument)POIXMLTypeLoader.newInstance(TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(String param1String) throws XmlException {
      return (TableDocument)POIXMLTypeLoader.parse(param1String, TableDocument.type, null);
    }
    
    public static TableDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (TableDocument)POIXMLTypeLoader.parse(param1String, TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(File param1File) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1File, TableDocument.type, null);
    }
    
    public static TableDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1File, TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(URL param1URL) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1URL, TableDocument.type, null);
    }
    
    public static TableDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1URL, TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1InputStream, TableDocument.type, null);
    }
    
    public static TableDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1InputStream, TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1Reader, TableDocument.type, null);
    }
    
    public static TableDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TableDocument)POIXMLTypeLoader.parse(param1Reader, TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (TableDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, TableDocument.type, null);
    }
    
    public static TableDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (TableDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(Node param1Node) throws XmlException {
      return (TableDocument)POIXMLTypeLoader.parse(param1Node, TableDocument.type, null);
    }
    
    public static TableDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (TableDocument)POIXMLTypeLoader.parse(param1Node, TableDocument.type, param1XmlOptions);
    }
    
    public static TableDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (TableDocument)POIXMLTypeLoader.parse(param1XMLInputStream, TableDocument.type, null);
    }
    
    public static TableDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (TableDocument)POIXMLTypeLoader.parse(param1XMLInputStream, TableDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, TableDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, TableDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\TableDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */