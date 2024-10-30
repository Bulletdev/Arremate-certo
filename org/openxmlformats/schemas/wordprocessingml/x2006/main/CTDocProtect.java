package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

public interface CTDocProtect extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDocProtect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdocprotectc611type");
  
  STDocProtect.Enum getEdit();
  
  STDocProtect xgetEdit();
  
  boolean isSetEdit();
  
  void setEdit(STDocProtect.Enum paramEnum);
  
  void xsetEdit(STDocProtect paramSTDocProtect);
  
  void unsetEdit();
  
  STOnOff.Enum getFormatting();
  
  STOnOff xgetFormatting();
  
  boolean isSetFormatting();
  
  void setFormatting(STOnOff.Enum paramEnum);
  
  void xsetFormatting(STOnOff paramSTOnOff);
  
  void unsetFormatting();
  
  STOnOff.Enum getEnforcement();
  
  STOnOff xgetEnforcement();
  
  boolean isSetEnforcement();
  
  void setEnforcement(STOnOff.Enum paramEnum);
  
  void xsetEnforcement(STOnOff paramSTOnOff);
  
  void unsetEnforcement();
  
  STCryptProv.Enum getCryptProviderType();
  
  STCryptProv xgetCryptProviderType();
  
  boolean isSetCryptProviderType();
  
  void setCryptProviderType(STCryptProv.Enum paramEnum);
  
  void xsetCryptProviderType(STCryptProv paramSTCryptProv);
  
  void unsetCryptProviderType();
  
  STAlgClass.Enum getCryptAlgorithmClass();
  
  STAlgClass xgetCryptAlgorithmClass();
  
  boolean isSetCryptAlgorithmClass();
  
  void setCryptAlgorithmClass(STAlgClass.Enum paramEnum);
  
  void xsetCryptAlgorithmClass(STAlgClass paramSTAlgClass);
  
  void unsetCryptAlgorithmClass();
  
  STAlgType.Enum getCryptAlgorithmType();
  
  STAlgType xgetCryptAlgorithmType();
  
  boolean isSetCryptAlgorithmType();
  
  void setCryptAlgorithmType(STAlgType.Enum paramEnum);
  
  void xsetCryptAlgorithmType(STAlgType paramSTAlgType);
  
  void unsetCryptAlgorithmType();
  
  BigInteger getCryptAlgorithmSid();
  
  STDecimalNumber xgetCryptAlgorithmSid();
  
  boolean isSetCryptAlgorithmSid();
  
  void setCryptAlgorithmSid(BigInteger paramBigInteger);
  
  void xsetCryptAlgorithmSid(STDecimalNumber paramSTDecimalNumber);
  
  void unsetCryptAlgorithmSid();
  
  BigInteger getCryptSpinCount();
  
  STDecimalNumber xgetCryptSpinCount();
  
  boolean isSetCryptSpinCount();
  
  void setCryptSpinCount(BigInteger paramBigInteger);
  
  void xsetCryptSpinCount(STDecimalNumber paramSTDecimalNumber);
  
  void unsetCryptSpinCount();
  
  String getCryptProvider();
  
  STString xgetCryptProvider();
  
  boolean isSetCryptProvider();
  
  void setCryptProvider(String paramString);
  
  void xsetCryptProvider(STString paramSTString);
  
  void unsetCryptProvider();
  
  byte[] getAlgIdExt();
  
  STLongHexNumber xgetAlgIdExt();
  
  boolean isSetAlgIdExt();
  
  void setAlgIdExt(byte[] paramArrayOfbyte);
  
  void xsetAlgIdExt(STLongHexNumber paramSTLongHexNumber);
  
  void unsetAlgIdExt();
  
  String getAlgIdExtSource();
  
  STString xgetAlgIdExtSource();
  
  boolean isSetAlgIdExtSource();
  
  void setAlgIdExtSource(String paramString);
  
  void xsetAlgIdExtSource(STString paramSTString);
  
  void unsetAlgIdExtSource();
  
  byte[] getCryptProviderTypeExt();
  
  STLongHexNumber xgetCryptProviderTypeExt();
  
  boolean isSetCryptProviderTypeExt();
  
  void setCryptProviderTypeExt(byte[] paramArrayOfbyte);
  
  void xsetCryptProviderTypeExt(STLongHexNumber paramSTLongHexNumber);
  
  void unsetCryptProviderTypeExt();
  
  String getCryptProviderTypeExtSource();
  
  STString xgetCryptProviderTypeExtSource();
  
  boolean isSetCryptProviderTypeExtSource();
  
  void setCryptProviderTypeExtSource(String paramString);
  
  void xsetCryptProviderTypeExtSource(STString paramSTString);
  
  void unsetCryptProviderTypeExtSource();
  
  byte[] getHash();
  
  XmlBase64Binary xgetHash();
  
  boolean isSetHash();
  
  void setHash(byte[] paramArrayOfbyte);
  
  void xsetHash(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetHash();
  
  byte[] getSalt();
  
  XmlBase64Binary xgetSalt();
  
  boolean isSetSalt();
  
  void setSalt(byte[] paramArrayOfbyte);
  
  void xsetSalt(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetSalt();
  
  public static final class Factory {
    public static CTDocProtect newInstance() {
      return (CTDocProtect)POIXMLTypeLoader.newInstance(CTDocProtect.type, null);
    }
    
    public static CTDocProtect newInstance(XmlOptions param1XmlOptions) {
      return (CTDocProtect)POIXMLTypeLoader.newInstance(CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(String param1String) throws XmlException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1String, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1String, CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(File param1File) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1File, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1File, CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(URL param1URL) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1URL, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1URL, CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1InputStream, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1InputStream, CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1Reader, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1Reader, CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(Node param1Node) throws XmlException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1Node, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1Node, CTDocProtect.type, param1XmlOptions);
    }
    
    public static CTDocProtect parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocProtect.type, null);
    }
    
    public static CTDocProtect parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDocProtect)POIXMLTypeLoader.parse(param1XMLInputStream, CTDocProtect.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocProtect.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDocProtect.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTDocProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */