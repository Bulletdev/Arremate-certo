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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTTablePart extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTablePart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablepart1140type");
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTTablePart newInstance() {
      return (CTTablePart)POIXMLTypeLoader.newInstance(CTTablePart.type, null);
    }
    
    public static CTTablePart newInstance(XmlOptions param1XmlOptions) {
      return (CTTablePart)POIXMLTypeLoader.newInstance(CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(String param1String) throws XmlException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1String, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1String, CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(File param1File) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1File, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1File, CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(URL param1URL) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1URL, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1URL, CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1InputStream, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1InputStream, CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1Reader, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1Reader, CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(Node param1Node) throws XmlException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1Node, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1Node, CTTablePart.type, param1XmlOptions);
    }
    
    public static CTTablePart parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1XMLInputStream, CTTablePart.type, null);
    }
    
    public static CTTablePart parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTablePart)POIXMLTypeLoader.parse(param1XMLInputStream, CTTablePart.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTablePart.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTablePart.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTTablePart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */