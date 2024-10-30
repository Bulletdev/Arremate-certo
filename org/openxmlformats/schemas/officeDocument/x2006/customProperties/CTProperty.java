package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTArray;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTEmpty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTNull;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVstream;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;
import org.w3c.dom.Node;

public interface CTProperty extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctproperty5ffatype");
  
  CTVector getVector();
  
  boolean isSetVector();
  
  void setVector(CTVector paramCTVector);
  
  CTVector addNewVector();
  
  void unsetVector();
  
  CTArray getArray();
  
  boolean isSetArray();
  
  void setArray(CTArray paramCTArray);
  
  CTArray addNewArray();
  
  void unsetArray();
  
  byte[] getBlob();
  
  XmlBase64Binary xgetBlob();
  
  boolean isSetBlob();
  
  void setBlob(byte[] paramArrayOfbyte);
  
  void xsetBlob(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetBlob();
  
  byte[] getOblob();
  
  XmlBase64Binary xgetOblob();
  
  boolean isSetOblob();
  
  void setOblob(byte[] paramArrayOfbyte);
  
  void xsetOblob(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetOblob();
  
  CTEmpty getEmpty();
  
  boolean isSetEmpty();
  
  void setEmpty(CTEmpty paramCTEmpty);
  
  CTEmpty addNewEmpty();
  
  void unsetEmpty();
  
  CTNull getNull();
  
  boolean isSetNull();
  
  void setNull(CTNull paramCTNull);
  
  CTNull addNewNull();
  
  void unsetNull();
  
  byte getI1();
  
  XmlByte xgetI1();
  
  boolean isSetI1();
  
  void setI1(byte paramByte);
  
  void xsetI1(XmlByte paramXmlByte);
  
  void unsetI1();
  
  short getI2();
  
  XmlShort xgetI2();
  
  boolean isSetI2();
  
  void setI2(short paramShort);
  
  void xsetI2(XmlShort paramXmlShort);
  
  void unsetI2();
  
  int getI4();
  
  XmlInt xgetI4();
  
  boolean isSetI4();
  
  void setI4(int paramInt);
  
  void xsetI4(XmlInt paramXmlInt);
  
  void unsetI4();
  
  long getI8();
  
  XmlLong xgetI8();
  
  boolean isSetI8();
  
  void setI8(long paramLong);
  
  void xsetI8(XmlLong paramXmlLong);
  
  void unsetI8();
  
  int getInt();
  
  XmlInt xgetInt();
  
  boolean isSetInt();
  
  void setInt(int paramInt);
  
  void xsetInt(XmlInt paramXmlInt);
  
  void unsetInt();
  
  short getUi1();
  
  XmlUnsignedByte xgetUi1();
  
  boolean isSetUi1();
  
  void setUi1(short paramShort);
  
  void xsetUi1(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetUi1();
  
  int getUi2();
  
  XmlUnsignedShort xgetUi2();
  
  boolean isSetUi2();
  
  void setUi2(int paramInt);
  
  void xsetUi2(XmlUnsignedShort paramXmlUnsignedShort);
  
  void unsetUi2();
  
  long getUi4();
  
  XmlUnsignedInt xgetUi4();
  
  boolean isSetUi4();
  
  void setUi4(long paramLong);
  
  void xsetUi4(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetUi4();
  
  BigInteger getUi8();
  
  XmlUnsignedLong xgetUi8();
  
  boolean isSetUi8();
  
  void setUi8(BigInteger paramBigInteger);
  
  void xsetUi8(XmlUnsignedLong paramXmlUnsignedLong);
  
  void unsetUi8();
  
  long getUint();
  
  XmlUnsignedInt xgetUint();
  
  boolean isSetUint();
  
  void setUint(long paramLong);
  
  void xsetUint(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetUint();
  
  float getR4();
  
  XmlFloat xgetR4();
  
  boolean isSetR4();
  
  void setR4(float paramFloat);
  
  void xsetR4(XmlFloat paramXmlFloat);
  
  void unsetR4();
  
  double getR8();
  
  XmlDouble xgetR8();
  
  boolean isSetR8();
  
  void setR8(double paramDouble);
  
  void xsetR8(XmlDouble paramXmlDouble);
  
  void unsetR8();
  
  BigDecimal getDecimal();
  
  XmlDecimal xgetDecimal();
  
  boolean isSetDecimal();
  
  void setDecimal(BigDecimal paramBigDecimal);
  
  void xsetDecimal(XmlDecimal paramXmlDecimal);
  
  void unsetDecimal();
  
  String getLpstr();
  
  XmlString xgetLpstr();
  
  boolean isSetLpstr();
  
  void setLpstr(String paramString);
  
  void xsetLpstr(XmlString paramXmlString);
  
  void unsetLpstr();
  
  String getLpwstr();
  
  XmlString xgetLpwstr();
  
  boolean isSetLpwstr();
  
  void setLpwstr(String paramString);
  
  void xsetLpwstr(XmlString paramXmlString);
  
  void unsetLpwstr();
  
  String getBstr();
  
  XmlString xgetBstr();
  
  boolean isSetBstr();
  
  void setBstr(String paramString);
  
  void xsetBstr(XmlString paramXmlString);
  
  void unsetBstr();
  
  Calendar getDate();
  
  XmlDateTime xgetDate();
  
  boolean isSetDate();
  
  void setDate(Calendar paramCalendar);
  
  void xsetDate(XmlDateTime paramXmlDateTime);
  
  void unsetDate();
  
  Calendar getFiletime();
  
  XmlDateTime xgetFiletime();
  
  boolean isSetFiletime();
  
  void setFiletime(Calendar paramCalendar);
  
  void xsetFiletime(XmlDateTime paramXmlDateTime);
  
  void unsetFiletime();
  
  boolean getBool();
  
  XmlBoolean xgetBool();
  
  boolean isSetBool();
  
  void setBool(boolean paramBoolean);
  
  void xsetBool(XmlBoolean paramXmlBoolean);
  
  void unsetBool();
  
  String getCy();
  
  STCy xgetCy();
  
  boolean isSetCy();
  
  void setCy(String paramString);
  
  void xsetCy(STCy paramSTCy);
  
  void unsetCy();
  
  String getError();
  
  STError xgetError();
  
  boolean isSetError();
  
  void setError(String paramString);
  
  void xsetError(STError paramSTError);
  
  void unsetError();
  
  byte[] getStream();
  
  XmlBase64Binary xgetStream();
  
  boolean isSetStream();
  
  void setStream(byte[] paramArrayOfbyte);
  
  void xsetStream(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetStream();
  
  byte[] getOstream();
  
  XmlBase64Binary xgetOstream();
  
  boolean isSetOstream();
  
  void setOstream(byte[] paramArrayOfbyte);
  
  void xsetOstream(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetOstream();
  
  byte[] getStorage();
  
  XmlBase64Binary xgetStorage();
  
  boolean isSetStorage();
  
  void setStorage(byte[] paramArrayOfbyte);
  
  void xsetStorage(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetStorage();
  
  byte[] getOstorage();
  
  XmlBase64Binary xgetOstorage();
  
  boolean isSetOstorage();
  
  void setOstorage(byte[] paramArrayOfbyte);
  
  void xsetOstorage(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetOstorage();
  
  CTVstream getVstream();
  
  boolean isSetVstream();
  
  void setVstream(CTVstream paramCTVstream);
  
  CTVstream addNewVstream();
  
  void unsetVstream();
  
  String getClsid();
  
  STClsid xgetClsid();
  
  boolean isSetClsid();
  
  void setClsid(String paramString);
  
  void xsetClsid(STClsid paramSTClsid);
  
  void unsetClsid();
  
  CTCf getCf();
  
  boolean isSetCf();
  
  void setCf(CTCf paramCTCf);
  
  CTCf addNewCf();
  
  void unsetCf();
  
  String getFmtid();
  
  STClsid xgetFmtid();
  
  void setFmtid(String paramString);
  
  void xsetFmtid(STClsid paramSTClsid);
  
  int getPid();
  
  XmlInt xgetPid();
  
  void setPid(int paramInt);
  
  void xsetPid(XmlInt paramXmlInt);
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  String getLinkTarget();
  
  XmlString xgetLinkTarget();
  
  boolean isSetLinkTarget();
  
  void setLinkTarget(String paramString);
  
  void xsetLinkTarget(XmlString paramXmlString);
  
  void unsetLinkTarget();
  
  public static final class Factory {
    public static CTProperty newInstance() {
      return (CTProperty)POIXMLTypeLoader.newInstance(CTProperty.type, null);
    }
    
    public static CTProperty newInstance(XmlOptions param1XmlOptions) {
      return (CTProperty)POIXMLTypeLoader.newInstance(CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(String param1String) throws XmlException {
      return (CTProperty)POIXMLTypeLoader.parse(param1String, CTProperty.type, null);
    }
    
    public static CTProperty parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperty)POIXMLTypeLoader.parse(param1String, CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(File param1File) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1File, CTProperty.type, null);
    }
    
    public static CTProperty parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1File, CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(URL param1URL) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1URL, CTProperty.type, null);
    }
    
    public static CTProperty parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1URL, CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1InputStream, CTProperty.type, null);
    }
    
    public static CTProperty parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1InputStream, CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(Reader param1Reader) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1Reader, CTProperty.type, null);
    }
    
    public static CTProperty parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperty)POIXMLTypeLoader.parse(param1Reader, CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProperty.type, null);
    }
    
    public static CTProperty parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperty)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(Node param1Node) throws XmlException {
      return (CTProperty)POIXMLTypeLoader.parse(param1Node, CTProperty.type, null);
    }
    
    public static CTProperty parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperty)POIXMLTypeLoader.parse(param1Node, CTProperty.type, param1XmlOptions);
    }
    
    public static CTProperty parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTProperty.type, null);
    }
    
    public static CTProperty parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTProperty)POIXMLTypeLoader.parse(param1XMLInputStream, CTProperty.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProperty.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProperty.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\customProperties\CTProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */