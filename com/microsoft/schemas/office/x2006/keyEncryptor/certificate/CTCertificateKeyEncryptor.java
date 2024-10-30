package com.microsoft.schemas.office.x2006.keyEncryptor.certificate;

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

public interface CTCertificateKeyEncryptor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCertificateKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctcertificatekeyencryptor1a80type");
  
  byte[] getEncryptedKeyValue();
  
  XmlBase64Binary xgetEncryptedKeyValue();
  
  void setEncryptedKeyValue(byte[] paramArrayOfbyte);
  
  void xsetEncryptedKeyValue(XmlBase64Binary paramXmlBase64Binary);
  
  byte[] getX509Certificate();
  
  XmlBase64Binary xgetX509Certificate();
  
  void setX509Certificate(byte[] paramArrayOfbyte);
  
  void xsetX509Certificate(XmlBase64Binary paramXmlBase64Binary);
  
  byte[] getCertVerifier();
  
  XmlBase64Binary xgetCertVerifier();
  
  void setCertVerifier(byte[] paramArrayOfbyte);
  
  void xsetCertVerifier(XmlBase64Binary paramXmlBase64Binary);
  
  public static final class Factory {
    public static CTCertificateKeyEncryptor newInstance() {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.newInstance(CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor newInstance(XmlOptions param1XmlOptions) {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.newInstance(CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(String param1String) throws XmlException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1String, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1String, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(File param1File) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1File, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1File, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(URL param1URL) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1URL, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1URL, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1InputStream, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1InputStream, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1Reader, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1Reader, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(Node param1Node) throws XmlException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1Node, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1Node, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTCertificateKeyEncryptor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1XMLInputStream, CTCertificateKeyEncryptor.type, null);
    }
    
    public static CTCertificateKeyEncryptor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCertificateKeyEncryptor)POIXMLTypeLoader.parse(param1XMLInputStream, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCertificateKeyEncryptor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCertificateKeyEncryptor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\keyEncryptor\certificate\CTCertificateKeyEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */