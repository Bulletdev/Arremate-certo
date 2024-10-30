package org.openxmlformats.schemas.xpackage.x2006.relationships;

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

public interface RelationshipsDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(RelationshipsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("relationships93b3doctype");
  
  CTRelationships getRelationships();
  
  void setRelationships(CTRelationships paramCTRelationships);
  
  CTRelationships addNewRelationships();
  
  public static final class Factory {
    public static RelationshipsDocument newInstance() {
      return (RelationshipsDocument)POIXMLTypeLoader.newInstance(RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument newInstance(XmlOptions param1XmlOptions) {
      return (RelationshipsDocument)POIXMLTypeLoader.newInstance(RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(String param1String) throws XmlException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1String, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1String, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(File param1File) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1File, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1File, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(URL param1URL) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1URL, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1URL, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1InputStream, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1InputStream, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1Reader, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1Reader, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(Node param1Node) throws XmlException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1Node, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1Node, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static RelationshipsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, RelationshipsDocument.type, null);
    }
    
    public static RelationshipsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (RelationshipsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, RelationshipsDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RelationshipsDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RelationshipsDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\relationships\RelationshipsDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */