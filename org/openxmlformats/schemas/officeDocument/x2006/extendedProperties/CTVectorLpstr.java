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

public interface CTVectorLpstr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTVectorLpstr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctvectorlpstr9b1dtype");
  
  CTVector getVector();
  
  void setVector(CTVector paramCTVector);
  
  CTVector addNewVector();
  
  public static final class Factory {
    public static CTVectorLpstr newInstance() {
      return (CTVectorLpstr)POIXMLTypeLoader.newInstance(CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr newInstance(XmlOptions param1XmlOptions) {
      return (CTVectorLpstr)POIXMLTypeLoader.newInstance(CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(String param1String) throws XmlException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1String, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1String, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(File param1File) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1File, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1File, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(URL param1URL) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1URL, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1URL, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1InputStream, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1InputStream, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1Reader, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1Reader, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(Node param1Node) throws XmlException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1Node, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1Node, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static CTVectorLpstr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1XMLInputStream, CTVectorLpstr.type, null);
    }
    
    public static CTVectorLpstr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTVectorLpstr)POIXMLTypeLoader.parse(param1XMLInputStream, CTVectorLpstr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVectorLpstr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVectorLpstr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\extendedProperties\CTVectorLpstr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */