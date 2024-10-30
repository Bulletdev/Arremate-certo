package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

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
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.w3c.dom.Node;

public interface CTVectorVariant extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTVectorVariant.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctvectorvariant9d75type");
  
  CTVector getVector();
  
  void setVector(CTVector paramCTVector);
  
  CTVector addNewVector();
  
  public static final class Factory {
    public static CTVectorVariant newInstance() {
      return (CTVectorVariant)POIXMLTypeLoader.newInstance(CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant newInstance(XmlOptions param1XmlOptions) {
      return (CTVectorVariant)POIXMLTypeLoader.newInstance(CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(String param1String) throws XmlException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1String, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1String, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(File param1File) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1File, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1File, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(URL param1URL) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1URL, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1URL, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1InputStream, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1InputStream, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(Reader param1Reader) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1Reader, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1Reader, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(Node param1Node) throws XmlException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1Node, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1Node, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static CTVectorVariant parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1XMLInputStream, CTVectorVariant.type, null);
    }
    
    public static CTVectorVariant parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTVectorVariant)POIXMLTypeLoader.parse(param1XMLInputStream, CTVectorVariant.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVectorVariant.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVectorVariant.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\extendedProperties\CTVectorVariant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */