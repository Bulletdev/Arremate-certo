package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
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
import org.w3c.dom.Node;

public interface CTVector extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTVector.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctvectorc3e2type");
  
  List<CTVariant> getVariantList();
  
  CTVariant[] getVariantArray();
  
  CTVariant getVariantArray(int paramInt);
  
  int sizeOfVariantArray();
  
  void setVariantArray(CTVariant[] paramArrayOfCTVariant);
  
  void setVariantArray(int paramInt, CTVariant paramCTVariant);
  
  CTVariant insertNewVariant(int paramInt);
  
  CTVariant addNewVariant();
  
  void removeVariant(int paramInt);
  
  List<Byte> getI1List();
  
  byte[] getI1Array();
  
  byte getI1Array(int paramInt);
  
  List<XmlByte> xgetI1List();
  
  XmlByte[] xgetI1Array();
  
  XmlByte xgetI1Array(int paramInt);
  
  int sizeOfI1Array();
  
  void setI1Array(byte[] paramArrayOfbyte);
  
  void setI1Array(int paramInt, byte paramByte);
  
  void xsetI1Array(XmlByte[] paramArrayOfXmlByte);
  
  void xsetI1Array(int paramInt, XmlByte paramXmlByte);
  
  void insertI1(int paramInt, byte paramByte);
  
  void addI1(byte paramByte);
  
  XmlByte insertNewI1(int paramInt);
  
  XmlByte addNewI1();
  
  void removeI1(int paramInt);
  
  List<Short> getI2List();
  
  short[] getI2Array();
  
  short getI2Array(int paramInt);
  
  List<XmlShort> xgetI2List();
  
  XmlShort[] xgetI2Array();
  
  XmlShort xgetI2Array(int paramInt);
  
  int sizeOfI2Array();
  
  void setI2Array(short[] paramArrayOfshort);
  
  void setI2Array(int paramInt, short paramShort);
  
  void xsetI2Array(XmlShort[] paramArrayOfXmlShort);
  
  void xsetI2Array(int paramInt, XmlShort paramXmlShort);
  
  void insertI2(int paramInt, short paramShort);
  
  void addI2(short paramShort);
  
  XmlShort insertNewI2(int paramInt);
  
  XmlShort addNewI2();
  
  void removeI2(int paramInt);
  
  List<Integer> getI4List();
  
  int[] getI4Array();
  
  int getI4Array(int paramInt);
  
  List<XmlInt> xgetI4List();
  
  XmlInt[] xgetI4Array();
  
  XmlInt xgetI4Array(int paramInt);
  
  int sizeOfI4Array();
  
  void setI4Array(int[] paramArrayOfint);
  
  void setI4Array(int paramInt1, int paramInt2);
  
  void xsetI4Array(XmlInt[] paramArrayOfXmlInt);
  
  void xsetI4Array(int paramInt, XmlInt paramXmlInt);
  
  void insertI4(int paramInt1, int paramInt2);
  
  void addI4(int paramInt);
  
  XmlInt insertNewI4(int paramInt);
  
  XmlInt addNewI4();
  
  void removeI4(int paramInt);
  
  List<Long> getI8List();
  
  long[] getI8Array();
  
  long getI8Array(int paramInt);
  
  List<XmlLong> xgetI8List();
  
  XmlLong[] xgetI8Array();
  
  XmlLong xgetI8Array(int paramInt);
  
  int sizeOfI8Array();
  
  void setI8Array(long[] paramArrayOflong);
  
  void setI8Array(int paramInt, long paramLong);
  
  void xsetI8Array(XmlLong[] paramArrayOfXmlLong);
  
  void xsetI8Array(int paramInt, XmlLong paramXmlLong);
  
  void insertI8(int paramInt, long paramLong);
  
  void addI8(long paramLong);
  
  XmlLong insertNewI8(int paramInt);
  
  XmlLong addNewI8();
  
  void removeI8(int paramInt);
  
  List<Short> getUi1List();
  
  short[] getUi1Array();
  
  short getUi1Array(int paramInt);
  
  List<XmlUnsignedByte> xgetUi1List();
  
  XmlUnsignedByte[] xgetUi1Array();
  
  XmlUnsignedByte xgetUi1Array(int paramInt);
  
  int sizeOfUi1Array();
  
  void setUi1Array(short[] paramArrayOfshort);
  
  void setUi1Array(int paramInt, short paramShort);
  
  void xsetUi1Array(XmlUnsignedByte[] paramArrayOfXmlUnsignedByte);
  
  void xsetUi1Array(int paramInt, XmlUnsignedByte paramXmlUnsignedByte);
  
  void insertUi1(int paramInt, short paramShort);
  
  void addUi1(short paramShort);
  
  XmlUnsignedByte insertNewUi1(int paramInt);
  
  XmlUnsignedByte addNewUi1();
  
  void removeUi1(int paramInt);
  
  List<Integer> getUi2List();
  
  int[] getUi2Array();
  
  int getUi2Array(int paramInt);
  
  List<XmlUnsignedShort> xgetUi2List();
  
  XmlUnsignedShort[] xgetUi2Array();
  
  XmlUnsignedShort xgetUi2Array(int paramInt);
  
  int sizeOfUi2Array();
  
  void setUi2Array(int[] paramArrayOfint);
  
  void setUi2Array(int paramInt1, int paramInt2);
  
  void xsetUi2Array(XmlUnsignedShort[] paramArrayOfXmlUnsignedShort);
  
  void xsetUi2Array(int paramInt, XmlUnsignedShort paramXmlUnsignedShort);
  
  void insertUi2(int paramInt1, int paramInt2);
  
  void addUi2(int paramInt);
  
  XmlUnsignedShort insertNewUi2(int paramInt);
  
  XmlUnsignedShort addNewUi2();
  
  void removeUi2(int paramInt);
  
  List<Long> getUi4List();
  
  long[] getUi4Array();
  
  long getUi4Array(int paramInt);
  
  List<XmlUnsignedInt> xgetUi4List();
  
  XmlUnsignedInt[] xgetUi4Array();
  
  XmlUnsignedInt xgetUi4Array(int paramInt);
  
  int sizeOfUi4Array();
  
  void setUi4Array(long[] paramArrayOflong);
  
  void setUi4Array(int paramInt, long paramLong);
  
  void xsetUi4Array(XmlUnsignedInt[] paramArrayOfXmlUnsignedInt);
  
  void xsetUi4Array(int paramInt, XmlUnsignedInt paramXmlUnsignedInt);
  
  void insertUi4(int paramInt, long paramLong);
  
  void addUi4(long paramLong);
  
  XmlUnsignedInt insertNewUi4(int paramInt);
  
  XmlUnsignedInt addNewUi4();
  
  void removeUi4(int paramInt);
  
  List<BigInteger> getUi8List();
  
  BigInteger[] getUi8Array();
  
  BigInteger getUi8Array(int paramInt);
  
  List<XmlUnsignedLong> xgetUi8List();
  
  XmlUnsignedLong[] xgetUi8Array();
  
  XmlUnsignedLong xgetUi8Array(int paramInt);
  
  int sizeOfUi8Array();
  
  void setUi8Array(BigInteger[] paramArrayOfBigInteger);
  
  void setUi8Array(int paramInt, BigInteger paramBigInteger);
  
  void xsetUi8Array(XmlUnsignedLong[] paramArrayOfXmlUnsignedLong);
  
  void xsetUi8Array(int paramInt, XmlUnsignedLong paramXmlUnsignedLong);
  
  void insertUi8(int paramInt, BigInteger paramBigInteger);
  
  void addUi8(BigInteger paramBigInteger);
  
  XmlUnsignedLong insertNewUi8(int paramInt);
  
  XmlUnsignedLong addNewUi8();
  
  void removeUi8(int paramInt);
  
  List<Float> getR4List();
  
  float[] getR4Array();
  
  float getR4Array(int paramInt);
  
  List<XmlFloat> xgetR4List();
  
  XmlFloat[] xgetR4Array();
  
  XmlFloat xgetR4Array(int paramInt);
  
  int sizeOfR4Array();
  
  void setR4Array(float[] paramArrayOffloat);
  
  void setR4Array(int paramInt, float paramFloat);
  
  void xsetR4Array(XmlFloat[] paramArrayOfXmlFloat);
  
  void xsetR4Array(int paramInt, XmlFloat paramXmlFloat);
  
  void insertR4(int paramInt, float paramFloat);
  
  void addR4(float paramFloat);
  
  XmlFloat insertNewR4(int paramInt);
  
  XmlFloat addNewR4();
  
  void removeR4(int paramInt);
  
  List<Double> getR8List();
  
  double[] getR8Array();
  
  double getR8Array(int paramInt);
  
  List<XmlDouble> xgetR8List();
  
  XmlDouble[] xgetR8Array();
  
  XmlDouble xgetR8Array(int paramInt);
  
  int sizeOfR8Array();
  
  void setR8Array(double[] paramArrayOfdouble);
  
  void setR8Array(int paramInt, double paramDouble);
  
  void xsetR8Array(XmlDouble[] paramArrayOfXmlDouble);
  
  void xsetR8Array(int paramInt, XmlDouble paramXmlDouble);
  
  void insertR8(int paramInt, double paramDouble);
  
  void addR8(double paramDouble);
  
  XmlDouble insertNewR8(int paramInt);
  
  XmlDouble addNewR8();
  
  void removeR8(int paramInt);
  
  List<String> getLpstrList();
  
  String[] getLpstrArray();
  
  String getLpstrArray(int paramInt);
  
  List<XmlString> xgetLpstrList();
  
  XmlString[] xgetLpstrArray();
  
  XmlString xgetLpstrArray(int paramInt);
  
  int sizeOfLpstrArray();
  
  void setLpstrArray(String[] paramArrayOfString);
  
  void setLpstrArray(int paramInt, String paramString);
  
  void xsetLpstrArray(XmlString[] paramArrayOfXmlString);
  
  void xsetLpstrArray(int paramInt, XmlString paramXmlString);
  
  void insertLpstr(int paramInt, String paramString);
  
  void addLpstr(String paramString);
  
  XmlString insertNewLpstr(int paramInt);
  
  XmlString addNewLpstr();
  
  void removeLpstr(int paramInt);
  
  List<String> getLpwstrList();
  
  String[] getLpwstrArray();
  
  String getLpwstrArray(int paramInt);
  
  List<XmlString> xgetLpwstrList();
  
  XmlString[] xgetLpwstrArray();
  
  XmlString xgetLpwstrArray(int paramInt);
  
  int sizeOfLpwstrArray();
  
  void setLpwstrArray(String[] paramArrayOfString);
  
  void setLpwstrArray(int paramInt, String paramString);
  
  void xsetLpwstrArray(XmlString[] paramArrayOfXmlString);
  
  void xsetLpwstrArray(int paramInt, XmlString paramXmlString);
  
  void insertLpwstr(int paramInt, String paramString);
  
  void addLpwstr(String paramString);
  
  XmlString insertNewLpwstr(int paramInt);
  
  XmlString addNewLpwstr();
  
  void removeLpwstr(int paramInt);
  
  List<String> getBstrList();
  
  String[] getBstrArray();
  
  String getBstrArray(int paramInt);
  
  List<XmlString> xgetBstrList();
  
  XmlString[] xgetBstrArray();
  
  XmlString xgetBstrArray(int paramInt);
  
  int sizeOfBstrArray();
  
  void setBstrArray(String[] paramArrayOfString);
  
  void setBstrArray(int paramInt, String paramString);
  
  void xsetBstrArray(XmlString[] paramArrayOfXmlString);
  
  void xsetBstrArray(int paramInt, XmlString paramXmlString);
  
  void insertBstr(int paramInt, String paramString);
  
  void addBstr(String paramString);
  
  XmlString insertNewBstr(int paramInt);
  
  XmlString addNewBstr();
  
  void removeBstr(int paramInt);
  
  List<Calendar> getDateList();
  
  Calendar[] getDateArray();
  
  Calendar getDateArray(int paramInt);
  
  List<XmlDateTime> xgetDateList();
  
  XmlDateTime[] xgetDateArray();
  
  XmlDateTime xgetDateArray(int paramInt);
  
  int sizeOfDateArray();
  
  void setDateArray(Calendar[] paramArrayOfCalendar);
  
  void setDateArray(int paramInt, Calendar paramCalendar);
  
  void xsetDateArray(XmlDateTime[] paramArrayOfXmlDateTime);
  
  void xsetDateArray(int paramInt, XmlDateTime paramXmlDateTime);
  
  void insertDate(int paramInt, Calendar paramCalendar);
  
  void addDate(Calendar paramCalendar);
  
  XmlDateTime insertNewDate(int paramInt);
  
  XmlDateTime addNewDate();
  
  void removeDate(int paramInt);
  
  List<Calendar> getFiletimeList();
  
  Calendar[] getFiletimeArray();
  
  Calendar getFiletimeArray(int paramInt);
  
  List<XmlDateTime> xgetFiletimeList();
  
  XmlDateTime[] xgetFiletimeArray();
  
  XmlDateTime xgetFiletimeArray(int paramInt);
  
  int sizeOfFiletimeArray();
  
  void setFiletimeArray(Calendar[] paramArrayOfCalendar);
  
  void setFiletimeArray(int paramInt, Calendar paramCalendar);
  
  void xsetFiletimeArray(XmlDateTime[] paramArrayOfXmlDateTime);
  
  void xsetFiletimeArray(int paramInt, XmlDateTime paramXmlDateTime);
  
  void insertFiletime(int paramInt, Calendar paramCalendar);
  
  void addFiletime(Calendar paramCalendar);
  
  XmlDateTime insertNewFiletime(int paramInt);
  
  XmlDateTime addNewFiletime();
  
  void removeFiletime(int paramInt);
  
  List<Boolean> getBoolList();
  
  boolean[] getBoolArray();
  
  boolean getBoolArray(int paramInt);
  
  List<XmlBoolean> xgetBoolList();
  
  XmlBoolean[] xgetBoolArray();
  
  XmlBoolean xgetBoolArray(int paramInt);
  
  int sizeOfBoolArray();
  
  void setBoolArray(boolean[] paramArrayOfboolean);
  
  void setBoolArray(int paramInt, boolean paramBoolean);
  
  void xsetBoolArray(XmlBoolean[] paramArrayOfXmlBoolean);
  
  void xsetBoolArray(int paramInt, XmlBoolean paramXmlBoolean);
  
  void insertBool(int paramInt, boolean paramBoolean);
  
  void addBool(boolean paramBoolean);
  
  XmlBoolean insertNewBool(int paramInt);
  
  XmlBoolean addNewBool();
  
  void removeBool(int paramInt);
  
  List<String> getCyList();
  
  String[] getCyArray();
  
  String getCyArray(int paramInt);
  
  List<STCy> xgetCyList();
  
  STCy[] xgetCyArray();
  
  STCy xgetCyArray(int paramInt);
  
  int sizeOfCyArray();
  
  void setCyArray(String[] paramArrayOfString);
  
  void setCyArray(int paramInt, String paramString);
  
  void xsetCyArray(STCy[] paramArrayOfSTCy);
  
  void xsetCyArray(int paramInt, STCy paramSTCy);
  
  void insertCy(int paramInt, String paramString);
  
  void addCy(String paramString);
  
  STCy insertNewCy(int paramInt);
  
  STCy addNewCy();
  
  void removeCy(int paramInt);
  
  List<String> getErrorList();
  
  String[] getErrorArray();
  
  String getErrorArray(int paramInt);
  
  List<STError> xgetErrorList();
  
  STError[] xgetErrorArray();
  
  STError xgetErrorArray(int paramInt);
  
  int sizeOfErrorArray();
  
  void setErrorArray(String[] paramArrayOfString);
  
  void setErrorArray(int paramInt, String paramString);
  
  void xsetErrorArray(STError[] paramArrayOfSTError);
  
  void xsetErrorArray(int paramInt, STError paramSTError);
  
  void insertError(int paramInt, String paramString);
  
  void addError(String paramString);
  
  STError insertNewError(int paramInt);
  
  STError addNewError();
  
  void removeError(int paramInt);
  
  List<String> getClsidList();
  
  String[] getClsidArray();
  
  String getClsidArray(int paramInt);
  
  List<STClsid> xgetClsidList();
  
  STClsid[] xgetClsidArray();
  
  STClsid xgetClsidArray(int paramInt);
  
  int sizeOfClsidArray();
  
  void setClsidArray(String[] paramArrayOfString);
  
  void setClsidArray(int paramInt, String paramString);
  
  void xsetClsidArray(STClsid[] paramArrayOfSTClsid);
  
  void xsetClsidArray(int paramInt, STClsid paramSTClsid);
  
  void insertClsid(int paramInt, String paramString);
  
  void addClsid(String paramString);
  
  STClsid insertNewClsid(int paramInt);
  
  STClsid addNewClsid();
  
  void removeClsid(int paramInt);
  
  List<CTCf> getCfList();
  
  CTCf[] getCfArray();
  
  CTCf getCfArray(int paramInt);
  
  int sizeOfCfArray();
  
  void setCfArray(CTCf[] paramArrayOfCTCf);
  
  void setCfArray(int paramInt, CTCf paramCTCf);
  
  CTCf insertNewCf(int paramInt);
  
  CTCf addNewCf();
  
  void removeCf(int paramInt);
  
  STVectorBaseType$Enum getBaseType();
  
  STVectorBaseType xgetBaseType();
  
  void setBaseType(STVectorBaseType$Enum paramSTVectorBaseType$Enum);
  
  void xsetBaseType(STVectorBaseType paramSTVectorBaseType);
  
  long getSize();
  
  XmlUnsignedInt xgetSize();
  
  void setSize(long paramLong);
  
  void xsetSize(XmlUnsignedInt paramXmlUnsignedInt);
  
  public static final class Factory {
    public static CTVector newInstance() {
      return (CTVector)POIXMLTypeLoader.newInstance(CTVector.type, null);
    }
    
    public static CTVector newInstance(XmlOptions param1XmlOptions) {
      return (CTVector)POIXMLTypeLoader.newInstance(CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(String param1String) throws XmlException {
      return (CTVector)POIXMLTypeLoader.parse(param1String, CTVector.type, null);
    }
    
    public static CTVector parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVector)POIXMLTypeLoader.parse(param1String, CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(File param1File) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1File, CTVector.type, null);
    }
    
    public static CTVector parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1File, CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(URL param1URL) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1URL, CTVector.type, null);
    }
    
    public static CTVector parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1URL, CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1InputStream, CTVector.type, null);
    }
    
    public static CTVector parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1InputStream, CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(Reader param1Reader) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1Reader, CTVector.type, null);
    }
    
    public static CTVector parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVector)POIXMLTypeLoader.parse(param1Reader, CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTVector)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVector.type, null);
    }
    
    public static CTVector parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVector)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(Node param1Node) throws XmlException {
      return (CTVector)POIXMLTypeLoader.parse(param1Node, CTVector.type, null);
    }
    
    public static CTVector parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVector)POIXMLTypeLoader.parse(param1Node, CTVector.type, param1XmlOptions);
    }
    
    public static CTVector parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTVector)POIXMLTypeLoader.parse(param1XMLInputStream, CTVector.type, null);
    }
    
    public static CTVector parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTVector)POIXMLTypeLoader.parse(param1XMLInputStream, CTVector.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVector.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVector.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\docPropsVTypes\CTVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */