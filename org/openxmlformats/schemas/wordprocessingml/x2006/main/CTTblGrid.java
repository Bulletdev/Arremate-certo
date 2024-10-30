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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTblGrid extends CTTblGridBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblGrid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblgrid2eeetype");
  
  CTTblGridChange getTblGridChange();
  
  boolean isSetTblGridChange();
  
  void setTblGridChange(CTTblGridChange paramCTTblGridChange);
  
  CTTblGridChange addNewTblGridChange();
  
  void unsetTblGridChange();
  
  public static final class Factory {
    public static CTTblGrid newInstance() {
      return (CTTblGrid)POIXMLTypeLoader.newInstance(CTTblGrid.type, null);
    }
    
    public static CTTblGrid newInstance(XmlOptions param1XmlOptions) {
      return (CTTblGrid)POIXMLTypeLoader.newInstance(CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(String param1String) throws XmlException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1String, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1String, CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(File param1File) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1File, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1File, CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(URL param1URL) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1URL, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1URL, CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1InputStream, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1InputStream, CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1Reader, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1Reader, CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(Node param1Node) throws XmlException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1Node, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1Node, CTTblGrid.type, param1XmlOptions);
    }
    
    public static CTTblGrid parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblGrid.type, null);
    }
    
    public static CTTblGrid parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblGrid)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblGrid.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblGrid.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblGrid.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblGrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */