package com.microsoft.schemas.office.x2006.keyEncryptor.password;

import com.microsoft.schemas.office.x2006.encryption.STBlockSize;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STHashSize;
import com.microsoft.schemas.office.x2006.encryption.STKeyBits;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;
import com.microsoft.schemas.office.x2006.encryption.STSpinCount;
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

public interface CTPasswordKeyEncryptor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPasswordKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctpasswordkeyencryptorde24type");
  
  int getSaltSize();
  
  STSaltSize xgetSaltSize();
  
  void setSaltSize(int paramInt);
  
  void xsetSaltSize(STSaltSize paramSTSaltSize);
  
  int getBlockSize();
  
  STBlockSize xgetBlockSize();
  
  void setBlockSize(int paramInt);
  
  void xsetBlockSize(STBlockSize paramSTBlockSize);
  
  long getKeyBits();
  
  STKeyBits xgetKeyBits();
  
  void setKeyBits(long paramLong);
  
  void xsetKeyBits(STKeyBits paramSTKeyBits);
  
  int getHashSize();
  
  STHashSize xgetHashSize();
  
  void setHashSize(int paramInt);
  
  void xsetHashSize(STHashSize paramSTHashSize);
  
  STCipherAlgorithm.Enum getCipherAlgorithm();
  
  STCipherAlgorithm xgetCipherAlgorithm();
  
  void setCipherAlgorithm(STCipherAlgorithm.Enum paramEnum);
  
  void xsetCipherAlgorithm(STCipherAlgorithm paramSTCipherAlgorithm);
  
  STCipherChaining.Enum getCipherChaining();
  
  STCipherChaining xgetCipherChaining();
  
  void setCipherChaining(STCipherChaining.Enum paramEnum);
  
  void xsetCipherChaining(STCipherChaining paramSTCipherChaining);
  
  STHashAlgorithm.Enum getHashAlgorithm();
  
  STHashAlgorithm xgetHashAlgorithm();
  
  void setHashAlgorithm(STHashAlgorithm.Enum paramEnum);
  
  void xsetHashAlgorithm(STHashAlgorithm paramSTHashAlgorithm);
  
  byte[] getSaltValue();
  
  XmlBase64Binary xgetSaltValue();
  
  void setSaltValue(byte[] paramArrayOfbyte);
  
  void xsetSaltValue(XmlBase64Binary paramXmlBase64Binary);
  
  int getSpinCount();
  
  STSpinCount xgetSpinCount();
  
  void setSpinCount(int paramInt);
  
  void xsetSpinCount(STSpinCount paramSTSpinCount);
  
  byte[] getEncryptedVerifierHashInput();
  
  XmlBase64Binary xgetEncryptedVerifierHashInput();
  
  void setEncryptedVerifierHashInput(byte[] paramArrayOfbyte);
  
  void xsetEncryptedVerifierHashInput(XmlBase64Binary paramXmlBase64Binary);
  
  byte[] getEncryptedVerifierHashValue();
  
  XmlBase64Binary xgetEncryptedVerifierHashValue();
  
  void setEncryptedVerifierHashValue(byte[] paramArrayOfbyte);
  
  void xsetEncryptedVerifierHashValue(XmlBase64Binary paramXmlBase64Binary);
  
  byte[] getEncryptedKeyValue();
  
  XmlBase64Binary xgetEncryptedKeyValue();
  
  void setEncryptedKeyValue(byte[] paramArrayOfbyte);
  
  void xsetEncryptedKeyValue(XmlBase64Binary paramXmlBase64Binary);
  
  public static final class Factory {
    public static CTPasswordKeyEncryptor newInstance() {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.newInstance(CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor newInstance(XmlOptions param1XmlOptions) {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.newInstance(CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(String param1String) throws XmlException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1String, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1String, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(File param1File) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1File, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1File, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(URL param1URL) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1URL, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1URL, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1InputStream, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1InputStream, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1Reader, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1Reader, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(Node param1Node) throws XmlException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1Node, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1Node, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static CTPasswordKeyEncryptor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1XMLInputStream, CTPasswordKeyEncryptor.type, null);
    }
    
    public static CTPasswordKeyEncryptor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPasswordKeyEncryptor)POIXMLTypeLoader.parse(param1XMLInputStream, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPasswordKeyEncryptor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPasswordKeyEncryptor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\keyEncryptor\password\CTPasswordKeyEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */