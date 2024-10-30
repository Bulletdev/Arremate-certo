package com.microsoft.schemas.office.x2006.encryption;

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

public interface CTKeyEncryptors extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTKeyEncryptors.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctkeyencryptorsa09ctype");
  
  List<CTKeyEncryptor> getKeyEncryptorList();
  
  CTKeyEncryptor[] getKeyEncryptorArray();
  
  CTKeyEncryptor getKeyEncryptorArray(int paramInt);
  
  int sizeOfKeyEncryptorArray();
  
  void setKeyEncryptorArray(CTKeyEncryptor[] paramArrayOfCTKeyEncryptor);
  
  void setKeyEncryptorArray(int paramInt, CTKeyEncryptor paramCTKeyEncryptor);
  
  CTKeyEncryptor insertNewKeyEncryptor(int paramInt);
  
  CTKeyEncryptor addNewKeyEncryptor();
  
  void removeKeyEncryptor(int paramInt);
  
  public static final class Factory {
    public static CTKeyEncryptors newInstance() {
      return (CTKeyEncryptors)POIXMLTypeLoader.newInstance(CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors newInstance(XmlOptions param1XmlOptions) {
      return (CTKeyEncryptors)POIXMLTypeLoader.newInstance(CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(String param1String) throws XmlException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1String, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1String, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(File param1File) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1File, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1File, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(URL param1URL) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1URL, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1URL, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1InputStream, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1InputStream, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(Reader param1Reader) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1Reader, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1Reader, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1XMLStreamReader, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1XMLStreamReader, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(Node param1Node) throws XmlException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1Node, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1Node, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptors parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1XMLInputStream, CTKeyEncryptors.type, null);
    }
    
    public static CTKeyEncryptors parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTKeyEncryptors)POIXMLTypeLoader.parse(param1XMLInputStream, CTKeyEncryptors.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTKeyEncryptors.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTKeyEncryptors.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\CTKeyEncryptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */