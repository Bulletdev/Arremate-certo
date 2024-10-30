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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTRel extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrel4519type");
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTRel newInstance() {
      return (CTRel)POIXMLTypeLoader.newInstance(CTRel.type, null);
    }
    
    public static CTRel newInstance(XmlOptions param1XmlOptions) {
      return (CTRel)POIXMLTypeLoader.newInstance(CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(String param1String) throws XmlException {
      return (CTRel)POIXMLTypeLoader.parse(param1String, CTRel.type, null);
    }
    
    public static CTRel parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRel)POIXMLTypeLoader.parse(param1String, CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(File param1File) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1File, CTRel.type, null);
    }
    
    public static CTRel parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1File, CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(URL param1URL) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1URL, CTRel.type, null);
    }
    
    public static CTRel parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1URL, CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1InputStream, CTRel.type, null);
    }
    
    public static CTRel parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1InputStream, CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1Reader, CTRel.type, null);
    }
    
    public static CTRel parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRel)POIXMLTypeLoader.parse(param1Reader, CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRel)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRel.type, null);
    }
    
    public static CTRel parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRel)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(Node param1Node) throws XmlException {
      return (CTRel)POIXMLTypeLoader.parse(param1Node, CTRel.type, null);
    }
    
    public static CTRel parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRel)POIXMLTypeLoader.parse(param1Node, CTRel.type, param1XmlOptions);
    }
    
    public static CTRel parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRel)POIXMLTypeLoader.parse(param1XMLInputStream, CTRel.type, null);
    }
    
    public static CTRel parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRel)POIXMLTypeLoader.parse(param1XMLInputStream, CTRel.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRel.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRel.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTRel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */