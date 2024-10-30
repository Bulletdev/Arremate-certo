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
import org.w3c.dom.Node;

public interface CTProofErr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTProofErr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctprooferr1e07type");
  
  STProofErr$Enum getType();
  
  STProofErr xgetType();
  
  void setType(STProofErr$Enum paramSTProofErr$Enum);
  
  void xsetType(STProofErr paramSTProofErr);
  
  public static final class Factory {
    public static CTProofErr newInstance() {
      return (CTProofErr)POIXMLTypeLoader.newInstance(CTProofErr.type, null);
    }
    
    public static CTProofErr newInstance(XmlOptions param1XmlOptions) {
      return (CTProofErr)POIXMLTypeLoader.newInstance(CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(String param1String) throws XmlException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1String, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1String, CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(File param1File) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1File, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1File, CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(URL param1URL) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1URL, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1URL, CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1InputStream, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1InputStream, CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1Reader, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1Reader, CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(Node param1Node) throws XmlException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1Node, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1Node, CTProofErr.type, param1XmlOptions);
    }
    
    public static CTProofErr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1XMLInputStream, CTProofErr.type, null);
    }
    
    public static CTProofErr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTProofErr)POIXMLTypeLoader.parse(param1XMLInputStream, CTProofErr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProofErr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProofErr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTProofErr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */