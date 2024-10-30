package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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

public interface RelationshipReferenceDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(RelationshipReferenceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("relationshipreference8903doctype");
  
  CTRelationshipReference getRelationshipReference();
  
  void setRelationshipReference(CTRelationshipReference paramCTRelationshipReference);
  
  CTRelationshipReference addNewRelationshipReference();
  
  public static final class Factory {
    public static RelationshipReferenceDocument newInstance() {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.newInstance(RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument newInstance(XmlOptions param1XmlOptions) {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.newInstance(RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(String param1String) throws XmlException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1String, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1String, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(File param1File) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1File, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1File, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(URL param1URL) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1URL, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1URL, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1InputStream, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1InputStream, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1Reader, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1Reader, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(Node param1Node) throws XmlException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1Node, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1Node, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static RelationshipReferenceDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1XMLInputStream, RelationshipReferenceDocument.type, null);
    }
    
    public static RelationshipReferenceDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (RelationshipReferenceDocument)POIXMLTypeLoader.parse(param1XMLInputStream, RelationshipReferenceDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RelationshipReferenceDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RelationshipReferenceDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\RelationshipReferenceDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */