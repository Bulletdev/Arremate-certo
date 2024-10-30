package org.openxmlformats.schemas.xpackage.x2006.relationships;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTRelationship extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRelationship.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctrelationship8cf8type");
  
  STTargetMode.Enum getTargetMode();
  
  STTargetMode xgetTargetMode();
  
  boolean isSetTargetMode();
  
  void setTargetMode(STTargetMode.Enum paramEnum);
  
  void xsetTargetMode(STTargetMode paramSTTargetMode);
  
  void unsetTargetMode();
  
  String getTarget();
  
  XmlAnyURI xgetTarget();
  
  void setTarget(String paramString);
  
  void xsetTarget(XmlAnyURI paramXmlAnyURI);
  
  String getType();
  
  XmlAnyURI xgetType();
  
  void setType(String paramString);
  
  void xsetType(XmlAnyURI paramXmlAnyURI);
  
  String getId();
  
  XmlID xgetId();
  
  void setId(String paramString);
  
  void xsetId(XmlID paramXmlID);
  
  public static final class Factory {
    public static CTRelationship newInstance() {
      return (CTRelationship)POIXMLTypeLoader.newInstance(CTRelationship.type, null);
    }
    
    public static CTRelationship newInstance(XmlOptions param1XmlOptions) {
      return (CTRelationship)POIXMLTypeLoader.newInstance(CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(String param1String) throws XmlException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1String, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1String, CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(File param1File) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1File, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1File, CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(URL param1URL) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1URL, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1URL, CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1InputStream, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1InputStream, CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1Reader, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1Reader, CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(Node param1Node) throws XmlException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1Node, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1Node, CTRelationship.type, param1XmlOptions);
    }
    
    public static CTRelationship parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelationship.type, null);
    }
    
    public static CTRelationship parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRelationship)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelationship.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelationship.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelationship.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\relationships\CTRelationship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */