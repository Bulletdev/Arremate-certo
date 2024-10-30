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

public interface CTKeyData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTKeyData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctkeydata6bdbtype");
  
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
  
  public static final class Factory {
    public static CTKeyData newInstance() {
      return (CTKeyData)POIXMLTypeLoader.newInstance(CTKeyData.type, null);
    }
    
    public static CTKeyData newInstance(XmlOptions param1XmlOptions) {
      return (CTKeyData)POIXMLTypeLoader.newInstance(CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(String param1String) throws XmlException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1String, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1String, CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(File param1File) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1File, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1File, CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(URL param1URL) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1URL, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1URL, CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1InputStream, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1InputStream, CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1Reader, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1Reader, CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(Node param1Node) throws XmlException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1Node, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1Node, CTKeyData.type, param1XmlOptions);
    }
    
    public static CTKeyData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1XMLInputStream, CTKeyData.type, null);
    }
    
    public static CTKeyData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTKeyData)POIXMLTypeLoader.parse(param1XMLInputStream, CTKeyData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTKeyData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTKeyData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\CTKeyData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */