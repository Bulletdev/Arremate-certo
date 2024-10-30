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

public interface CTEncryption extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTEncryption.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctencryption365ftype");
  
  CTKeyData getKeyData();
  
  void setKeyData(CTKeyData paramCTKeyData);
  
  CTKeyData addNewKeyData();
  
  CTDataIntegrity getDataIntegrity();
  
  void setDataIntegrity(CTDataIntegrity paramCTDataIntegrity);
  
  CTDataIntegrity addNewDataIntegrity();
  
  CTKeyEncryptors getKeyEncryptors();
  
  void setKeyEncryptors(CTKeyEncryptors paramCTKeyEncryptors);
  
  CTKeyEncryptors addNewKeyEncryptors();
  
  public static final class Factory {
    public static CTEncryption newInstance() {
      return (CTEncryption)POIXMLTypeLoader.newInstance(CTEncryption.type, null);
    }
    
    public static CTEncryption newInstance(XmlOptions param1XmlOptions) {
      return (CTEncryption)POIXMLTypeLoader.newInstance(CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(String param1String) throws XmlException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1String, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1String, CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(File param1File) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1File, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1File, CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(URL param1URL) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1URL, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1URL, CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1InputStream, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1InputStream, CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(Reader param1Reader) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1Reader, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1Reader, CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(Node param1Node) throws XmlException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1Node, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1Node, CTEncryption.type, param1XmlOptions);
    }
    
    public static CTEncryption parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1XMLInputStream, CTEncryption.type, null);
    }
    
    public static CTEncryption parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTEncryption)POIXMLTypeLoader.parse(param1XMLInputStream, CTEncryption.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEncryption.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEncryption.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\CTEncryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */