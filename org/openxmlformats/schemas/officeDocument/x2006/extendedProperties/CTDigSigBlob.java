package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDigSigBlob extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDigSigBlob.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdigsigblob73c9type");
  
  byte[] getBlob();
  
  XmlBase64Binary xgetBlob();
  
  void setBlob(byte[] paramArrayOfbyte);
  
  void xsetBlob(XmlBase64Binary paramXmlBase64Binary);
  
  public static final class Factory {
    public static CTDigSigBlob newInstance() {
      return (CTDigSigBlob)POIXMLTypeLoader.newInstance(CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob newInstance(XmlOptions param1XmlOptions) {
      return (CTDigSigBlob)POIXMLTypeLoader.newInstance(CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(String param1String) throws XmlException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1String, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1String, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(File param1File) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1File, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1File, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(URL param1URL) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1URL, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1URL, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1InputStream, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1InputStream, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1Reader, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1Reader, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(Node param1Node) throws XmlException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1Node, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1Node, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static CTDigSigBlob parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1XMLInputStream, CTDigSigBlob.type, null);
    }
    
    public static CTDigSigBlob parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDigSigBlob)POIXMLTypeLoader.parse(param1XMLInputStream, CTDigSigBlob.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDigSigBlob.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDigSigBlob.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\extendedProperties\CTDigSigBlob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */