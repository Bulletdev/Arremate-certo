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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTGraphicalObjectData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGraphicalObjectData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobjectdata66adtype");
  
  String getUri();
  
  XmlToken xgetUri();
  
  boolean isSetUri();
  
  void setUri(String paramString);
  
  void xsetUri(XmlToken paramXmlToken);
  
  void unsetUri();
  
  public static final class Factory {
    public static CTGraphicalObjectData newInstance() {
      return (CTGraphicalObjectData)POIXMLTypeLoader.newInstance(CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData newInstance(XmlOptions param1XmlOptions) {
      return (CTGraphicalObjectData)POIXMLTypeLoader.newInstance(CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(String param1String) throws XmlException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(File param1File) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(URL param1URL) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(Node param1Node) throws XmlException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectData.type, null);
    }
    
    public static CTGraphicalObjectData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectData)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGraphicalObjectData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */