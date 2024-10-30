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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTGraphicalObject extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGraphicalObject.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobject1ce3type");
  
  CTGraphicalObjectData getGraphicData();
  
  void setGraphicData(CTGraphicalObjectData paramCTGraphicalObjectData);
  
  CTGraphicalObjectData addNewGraphicData();
  
  public static final class Factory {
    public static CTGraphicalObject newInstance() {
      return (CTGraphicalObject)POIXMLTypeLoader.newInstance(CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject newInstance(XmlOptions param1XmlOptions) {
      return (CTGraphicalObject)POIXMLTypeLoader.newInstance(CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(String param1String) throws XmlException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1String, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1String, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(File param1File) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1File, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1File, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(URL param1URL) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1URL, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1URL, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(Node param1Node) throws XmlException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1Node, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1Node, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static CTGraphicalObject parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObject.type, null);
    }
    
    public static CTGraphicalObject parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGraphicalObject)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObject.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObject.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObject.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGraphicalObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */