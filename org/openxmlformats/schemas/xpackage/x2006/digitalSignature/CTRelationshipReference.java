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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTRelationshipReference extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRelationshipReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctrelationshipreferencee68ftype");
  
  String getSourceId();
  
  XmlString xgetSourceId();
  
  void setSourceId(String paramString);
  
  void xsetSourceId(XmlString paramXmlString);
  
  public static final class Factory {
    public static CTRelationshipReference newInstance() {
      return (CTRelationshipReference)POIXMLTypeLoader.newInstance(CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference newInstance(XmlOptions param1XmlOptions) {
      return (CTRelationshipReference)POIXMLTypeLoader.newInstance(CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(String param1String) throws XmlException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1String, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1String, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(File param1File) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1File, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1File, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(URL param1URL) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1URL, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1URL, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1InputStream, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1InputStream, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1Reader, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1Reader, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(Node param1Node) throws XmlException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1Node, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1Node, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static CTRelationshipReference parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelationshipReference.type, null);
    }
    
    public static CTRelationshipReference parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRelationshipReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelationshipReference.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelationshipReference.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelationshipReference.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\CTRelationshipReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */