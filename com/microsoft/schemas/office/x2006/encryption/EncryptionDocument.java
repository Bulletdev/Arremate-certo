package com.microsoft.schemas.office.x2006.encryption;

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

public interface EncryptionDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(EncryptionDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("encryptione8b3doctype");
  
  CTEncryption getEncryption();
  
  void setEncryption(CTEncryption paramCTEncryption);
  
  CTEncryption addNewEncryption();
  
  public static final class Factory {
    public static EncryptionDocument newInstance() {
      return (EncryptionDocument)POIXMLTypeLoader.newInstance(EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument newInstance(XmlOptions param1XmlOptions) {
      return (EncryptionDocument)POIXMLTypeLoader.newInstance(EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(String param1String) throws XmlException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1String, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1String, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(File param1File) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1File, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1File, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(URL param1URL) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1URL, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1URL, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1InputStream, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1InputStream, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1Reader, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1Reader, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(Node param1Node) throws XmlException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1Node, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1Node, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static EncryptionDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1XMLInputStream, EncryptionDocument.type, null);
    }
    
    public static EncryptionDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (EncryptionDocument)POIXMLTypeLoader.parse(param1XMLInputStream, EncryptionDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, EncryptionDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, EncryptionDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\EncryptionDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */