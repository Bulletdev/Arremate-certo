package com.microsoft.schemas.office.x2006.encryption;

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

public interface CTDataIntegrity extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDataIntegrity.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctdataintegrity6eb5type");
  
  byte[] getEncryptedHmacKey();
  
  XmlBase64Binary xgetEncryptedHmacKey();
  
  void setEncryptedHmacKey(byte[] paramArrayOfbyte);
  
  void xsetEncryptedHmacKey(XmlBase64Binary paramXmlBase64Binary);
  
  byte[] getEncryptedHmacValue();
  
  XmlBase64Binary xgetEncryptedHmacValue();
  
  void setEncryptedHmacValue(byte[] paramArrayOfbyte);
  
  void xsetEncryptedHmacValue(XmlBase64Binary paramXmlBase64Binary);
  
  public static final class Factory {
    public static CTDataIntegrity newInstance() {
      return (CTDataIntegrity)POIXMLTypeLoader.newInstance(CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity newInstance(XmlOptions param1XmlOptions) {
      return (CTDataIntegrity)POIXMLTypeLoader.newInstance(CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(String param1String) throws XmlException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1String, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1String, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(File param1File) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1File, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1File, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(URL param1URL) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1URL, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1URL, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1InputStream, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1InputStream, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1Reader, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1Reader, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(Node param1Node) throws XmlException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1Node, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1Node, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static CTDataIntegrity parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataIntegrity.type, null);
    }
    
    public static CTDataIntegrity parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDataIntegrity)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataIntegrity.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataIntegrity.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataIntegrity.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\CTDataIntegrity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */