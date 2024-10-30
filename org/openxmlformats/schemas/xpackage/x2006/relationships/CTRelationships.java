package org.openxmlformats.schemas.xpackage.x2006.relationships;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTRelationships extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRelationships.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctrelationshipse33ftype");
  
  List<CTRelationship> getRelationshipList();
  
  CTRelationship[] getRelationshipArray();
  
  CTRelationship getRelationshipArray(int paramInt);
  
  int sizeOfRelationshipArray();
  
  void setRelationshipArray(CTRelationship[] paramArrayOfCTRelationship);
  
  void setRelationshipArray(int paramInt, CTRelationship paramCTRelationship);
  
  CTRelationship insertNewRelationship(int paramInt);
  
  CTRelationship addNewRelationship();
  
  void removeRelationship(int paramInt);
  
  public static final class Factory {
    public static CTRelationships newInstance() {
      return (CTRelationships)POIXMLTypeLoader.newInstance(CTRelationships.type, null);
    }
    
    public static CTRelationships newInstance(XmlOptions param1XmlOptions) {
      return (CTRelationships)POIXMLTypeLoader.newInstance(CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(String param1String) throws XmlException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1String, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1String, CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(File param1File) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1File, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1File, CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(URL param1URL) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1URL, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1URL, CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1InputStream, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1InputStream, CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1Reader, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1Reader, CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(Node param1Node) throws XmlException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1Node, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1Node, CTRelationships.type, param1XmlOptions);
    }
    
    public static CTRelationships parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelationships.type, null);
    }
    
    public static CTRelationships parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRelationships)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelationships.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelationships.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelationships.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\relationships\CTRelationships.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */