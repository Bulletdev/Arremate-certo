package com.microsoft.schemas.office.x2006.encryption;

import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTKeyEncryptor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctkeyencryptor1205type");
  
  CTPasswordKeyEncryptor getEncryptedPasswordKey();
  
  boolean isSetEncryptedPasswordKey();
  
  void setEncryptedPasswordKey(CTPasswordKeyEncryptor paramCTPasswordKeyEncryptor);
  
  CTPasswordKeyEncryptor addNewEncryptedPasswordKey();
  
  void unsetEncryptedPasswordKey();
  
  CTCertificateKeyEncryptor getEncryptedCertificateKey();
  
  boolean isSetEncryptedCertificateKey();
  
  void setEncryptedCertificateKey(CTCertificateKeyEncryptor paramCTCertificateKeyEncryptor);
  
  CTCertificateKeyEncryptor addNewEncryptedCertificateKey();
  
  void unsetEncryptedCertificateKey();
  
  Uri.Enum getUri();
  
  Uri xgetUri();
  
  boolean isSetUri();
  
  void setUri(Uri.Enum paramEnum);
  
  void xsetUri(Uri paramUri);
  
  void unsetUri();
  
  public static final class Factory {
    public static CTKeyEncryptor newInstance() {
      return (CTKeyEncryptor)POIXMLTypeLoader.newInstance(CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor newInstance(XmlOptions param1XmlOptions) {
      return (CTKeyEncryptor)POIXMLTypeLoader.newInstance(CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(String param1String) throws XmlException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1String, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1String, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(File param1File) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1File, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1File, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(URL param1URL) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1URL, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1URL, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1InputStream, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1InputStream, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1Reader, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1Reader, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(Node param1Node) throws XmlException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1Node, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1Node, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTKeyEncryptor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1XMLInputStream, CTKeyEncryptor.type, null);
    }
    
    public static CTKeyEncryptor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTKeyEncryptor)POIXMLTypeLoader.parse(param1XMLInputStream, CTKeyEncryptor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTKeyEncryptor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTKeyEncryptor.type, param1XmlOptions);
    }
  }
  
  public static interface Uri extends XmlToken {
    public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(Uri.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("uribad9attrtype");
    
    public static final Enum HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = Enum.forString("http://schemas.microsoft.com/office/2006/keyEncryptor/password");
    
    public static final Enum HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = Enum.forString("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate");
    
    public static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = 1;
    
    public static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = 2;
    
    StringEnumAbstractBase enumValue();
    
    void set(StringEnumAbstractBase param1StringEnumAbstractBase);
    
    public static final class Factory {
      public static CTKeyEncryptor.Uri newValue(Object param2Object) {
        return (CTKeyEncryptor.Uri)CTKeyEncryptor.Uri.type.newValue(param2Object);
      }
      
      public static CTKeyEncryptor.Uri newInstance() {
        return (CTKeyEncryptor.Uri)POIXMLTypeLoader.newInstance(CTKeyEncryptor.Uri.type, null);
      }
      
      public static CTKeyEncryptor.Uri newInstance(XmlOptions param2XmlOptions) {
        return (CTKeyEncryptor.Uri)POIXMLTypeLoader.newInstance(CTKeyEncryptor.Uri.type, param2XmlOptions);
      }
    }
    
    public static final class Enum extends StringEnumAbstractBase {
      static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = 1;
      
      static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = 2;
      
      public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/password", 1), new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate", 2) });
      
      private static final long serialVersionUID = 1L;
      
      public static Enum forString(String param2String) {
        return (Enum)table.forString(param2String);
      }
      
      public static Enum forInt(int param2Int) {
        return (Enum)table.forInt(param2Int);
      }
      
      private Enum(String param2String, int param2Int) {
        super(param2String, param2Int);
      }
      
      private Object readResolve() {
        return forInt(intValue());
      }
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = 1;
    
    static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/password", 1), new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate", 2) });
    
    private static final long serialVersionUID = 1L;
    
    public static Enum forString(String param1String) {
      return (Enum)table.forString(param1String);
    }
    
    public static Enum forInt(int param1Int) {
      return (Enum)table.forInt(param1Int);
    }
    
    private Enum(String param1String, int param1Int) {
      super(param1String, param1Int);
    }
    
    private Object readResolve() {
      return forInt(intValue());
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\CTKeyEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */