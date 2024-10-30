package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTArray;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTEmpty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTNull;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVstream;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;

public class CTVariantImpl extends XmlComplexContentImpl implements CTVariant {
  private static final b VARIANT$0 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "variant");
  
  private static final b VECTOR$2 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vector");
  
  private static final b ARRAY$4 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "array");
  
  private static final b BLOB$6 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "blob");
  
  private static final b OBLOB$8 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "oblob");
  
  private static final b EMPTY$10 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "empty");
  
  private static final b NULL$12 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "null");
  
  private static final b I1$14 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1");
  
  private static final b I2$16 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2");
  
  private static final b I4$18 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4");
  
  private static final b I8$20 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8");
  
  private static final b INT$22 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "int");
  
  private static final b UI1$24 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1");
  
  private static final b UI2$26 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2");
  
  private static final b UI4$28 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4");
  
  private static final b UI8$30 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8");
  
  private static final b UINT$32 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "uint");
  
  private static final b R4$34 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4");
  
  private static final b R8$36 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8");
  
  private static final b DECIMAL$38 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "decimal");
  
  private static final b LPSTR$40 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr");
  
  private static final b LPWSTR$42 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr");
  
  private static final b BSTR$44 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr");
  
  private static final b DATE$46 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "date");
  
  private static final b FILETIME$48 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime");
  
  private static final b BOOL$50 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool");
  
  private static final b CY$52 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy");
  
  private static final b ERROR$54 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "error");
  
  private static final b STREAM$56 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "stream");
  
  private static final b OSTREAM$58 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostream");
  
  private static final b STORAGE$60 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "storage");
  
  private static final b OSTORAGE$62 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostorage");
  
  private static final b VSTREAM$64 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vstream");
  
  private static final b CLSID$66 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid");
  
  private static final b CF$68 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cf");
  
  public CTVariantImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTVariant getVariant() {
    synchronized (monitor()) {
      check_orphaned();
      CTVariant cTVariant = null;
      cTVariant = (CTVariant)get_store().find_element_user(VARIANT$0, 0);
      if (cTVariant == null)
        return null; 
      return cTVariant;
    } 
  }
  
  public boolean isSetVariant() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VARIANT$0) != 0);
    } 
  }
  
  public void setVariant(CTVariant paramCTVariant) {
    synchronized (monitor()) {
      check_orphaned();
      CTVariant cTVariant = null;
      cTVariant = (CTVariant)get_store().find_element_user(VARIANT$0, 0);
      if (cTVariant == null)
        cTVariant = (CTVariant)get_store().add_element_user(VARIANT$0); 
      cTVariant.set((XmlObject)paramCTVariant);
    } 
  }
  
  public CTVariant addNewVariant() {
    synchronized (monitor()) {
      check_orphaned();
      CTVariant cTVariant = null;
      cTVariant = (CTVariant)get_store().add_element_user(VARIANT$0);
      return cTVariant;
    } 
  }
  
  public void unsetVariant() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VARIANT$0, 0);
    } 
  }
  
  public CTVector getVector() {
    synchronized (monitor()) {
      check_orphaned();
      CTVector cTVector = null;
      cTVector = (CTVector)get_store().find_element_user(VECTOR$2, 0);
      if (cTVector == null)
        return null; 
      return cTVector;
    } 
  }
  
  public boolean isSetVector() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VECTOR$2) != 0);
    } 
  }
  
  public void setVector(CTVector paramCTVector) {
    synchronized (monitor()) {
      check_orphaned();
      CTVector cTVector = null;
      cTVector = (CTVector)get_store().find_element_user(VECTOR$2, 0);
      if (cTVector == null)
        cTVector = (CTVector)get_store().add_element_user(VECTOR$2); 
      cTVector.set((XmlObject)paramCTVector);
    } 
  }
  
  public CTVector addNewVector() {
    synchronized (monitor()) {
      check_orphaned();
      CTVector cTVector = null;
      cTVector = (CTVector)get_store().add_element_user(VECTOR$2);
      return cTVector;
    } 
  }
  
  public void unsetVector() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VECTOR$2, 0);
    } 
  }
  
  public CTArray getArray() {
    synchronized (monitor()) {
      check_orphaned();
      CTArray cTArray = null;
      cTArray = (CTArray)get_store().find_element_user(ARRAY$4, 0);
      if (cTArray == null)
        return null; 
      return cTArray;
    } 
  }
  
  public boolean isSetArray() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ARRAY$4) != 0);
    } 
  }
  
  public void setArray(CTArray paramCTArray) {
    synchronized (monitor()) {
      check_orphaned();
      CTArray cTArray = null;
      cTArray = (CTArray)get_store().find_element_user(ARRAY$4, 0);
      if (cTArray == null)
        cTArray = (CTArray)get_store().add_element_user(ARRAY$4); 
      cTArray.set((XmlObject)paramCTArray);
    } 
  }
  
  public CTArray addNewArray() {
    synchronized (monitor()) {
      check_orphaned();
      CTArray cTArray = null;
      cTArray = (CTArray)get_store().add_element_user(ARRAY$4);
      return cTArray;
    } 
  }
  
  public void unsetArray() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ARRAY$4, 0);
    } 
  }
  
  public byte[] getBlob() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BLOB$6, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetBlob() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(BLOB$6, 0);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetBlob() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLOB$6) != 0);
    } 
  }
  
  public void setBlob(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BLOB$6, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(BLOB$6); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetBlob(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(BLOB$6, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(BLOB$6); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetBlob() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLOB$6, 0);
    } 
  }
  
  public byte[] getOblob() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OBLOB$8, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetOblob() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(OBLOB$8, 0);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetOblob() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OBLOB$8) != 0);
    } 
  }
  
  public void setOblob(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OBLOB$8, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(OBLOB$8); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetOblob(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(OBLOB$8, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(OBLOB$8); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetOblob() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OBLOB$8, 0);
    } 
  }
  
  public CTEmpty getEmpty() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(EMPTY$10, 0);
      if (cTEmpty == null)
        return null; 
      return cTEmpty;
    } 
  }
  
  public boolean isSetEmpty() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EMPTY$10) != 0);
    } 
  }
  
  public void setEmpty(CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(EMPTY$10, 0);
      if (cTEmpty == null)
        cTEmpty = (CTEmpty)get_store().add_element_user(EMPTY$10); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty addNewEmpty() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(EMPTY$10);
      return cTEmpty;
    } 
  }
  
  public void unsetEmpty() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EMPTY$10, 0);
    } 
  }
  
  public CTNull getNull() {
    synchronized (monitor()) {
      check_orphaned();
      CTNull cTNull = null;
      cTNull = (CTNull)get_store().find_element_user(NULL$12, 0);
      if (cTNull == null)
        return null; 
      return cTNull;
    } 
  }
  
  public boolean isSetNull() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NULL$12) != 0);
    } 
  }
  
  public void setNull(CTNull paramCTNull) {
    synchronized (monitor()) {
      check_orphaned();
      CTNull cTNull = null;
      cTNull = (CTNull)get_store().find_element_user(NULL$12, 0);
      if (cTNull == null)
        cTNull = (CTNull)get_store().add_element_user(NULL$12); 
      cTNull.set((XmlObject)paramCTNull);
    } 
  }
  
  public CTNull addNewNull() {
    synchronized (monitor()) {
      check_orphaned();
      CTNull cTNull = null;
      cTNull = (CTNull)get_store().add_element_user(NULL$12);
      return cTNull;
    } 
  }
  
  public void unsetNull() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NULL$12, 0);
    } 
  }
  
  public byte getI1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I1$14, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getByteValue();
    } 
  }
  
  public XmlByte xgetI1() {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_element_user(I1$14, 0);
      return xmlByte;
    } 
  }
  
  public boolean isSetI1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(I1$14) != 0);
    } 
  }
  
  public void setI1(byte paramByte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I1$14, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(I1$14); 
      simpleValue.setByteValue(paramByte);
    } 
  }
  
  public void xsetI1(XmlByte paramXmlByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_element_user(I1$14, 0);
      if (xmlByte == null)
        xmlByte = (XmlByte)get_store().add_element_user(I1$14); 
      xmlByte.set((XmlObject)paramXmlByte);
    } 
  }
  
  public void unsetI1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I1$14, 0);
    } 
  }
  
  public short getI2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I2$16, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlShort xgetI2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlShort xmlShort = null;
      xmlShort = (XmlShort)get_store().find_element_user(I2$16, 0);
      return xmlShort;
    } 
  }
  
  public boolean isSetI2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(I2$16) != 0);
    } 
  }
  
  public void setI2(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I2$16, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(I2$16); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetI2(XmlShort paramXmlShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlShort xmlShort = null;
      xmlShort = (XmlShort)get_store().find_element_user(I2$16, 0);
      if (xmlShort == null)
        xmlShort = (XmlShort)get_store().add_element_user(I2$16); 
      xmlShort.set((XmlObject)paramXmlShort);
    } 
  }
  
  public void unsetI2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I2$16, 0);
    } 
  }
  
  public int getI4() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I4$18, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetI4() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(I4$18, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetI4() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(I4$18) != 0);
    } 
  }
  
  public void setI4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I4$18, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(I4$18); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetI4(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(I4$18, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(I4$18); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetI4() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I4$18, 0);
    } 
  }
  
  public long getI8() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I8$20, 0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlLong xgetI8() {
    synchronized (monitor()) {
      check_orphaned();
      XmlLong xmlLong = null;
      xmlLong = (XmlLong)get_store().find_element_user(I8$20, 0);
      return xmlLong;
    } 
  }
  
  public boolean isSetI8() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(I8$20) != 0);
    } 
  }
  
  public void setI8(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I8$20, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(I8$20); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetI8(XmlLong paramXmlLong) {
    synchronized (monitor()) {
      check_orphaned();
      XmlLong xmlLong = null;
      xmlLong = (XmlLong)get_store().find_element_user(I8$20, 0);
      if (xmlLong == null)
        xmlLong = (XmlLong)get_store().add_element_user(I8$20); 
      xmlLong.set((XmlObject)paramXmlLong);
    } 
  }
  
  public void unsetI8() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I8$20, 0);
    } 
  }
  
  public int getInt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(INT$22, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetInt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(INT$22, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetInt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(INT$22) != 0);
    } 
  }
  
  public void setInt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(INT$22, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(INT$22); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetInt(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(INT$22, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(INT$22); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetInt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INT$22, 0);
    } 
  }
  
  public short getUi1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI1$24, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetUi1() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_element_user(UI1$24, 0);
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetUi1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UI1$24) != 0);
    } 
  }
  
  public void setUi1(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI1$24, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(UI1$24); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetUi1(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_element_user(UI1$24, 0);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_element_user(UI1$24); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetUi1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI1$24, 0);
    } 
  }
  
  public int getUi2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI2$26, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlUnsignedShort xgetUi2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_element_user(UI2$26, 0);
      return xmlUnsignedShort;
    } 
  }
  
  public boolean isSetUi2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UI2$26) != 0);
    } 
  }
  
  public void setUi2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI2$26, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(UI2$26); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetUi2(XmlUnsignedShort paramXmlUnsignedShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_element_user(UI2$26, 0);
      if (xmlUnsignedShort == null)
        xmlUnsignedShort = (XmlUnsignedShort)get_store().add_element_user(UI2$26); 
      xmlUnsignedShort.set((XmlObject)paramXmlUnsignedShort);
    } 
  }
  
  public void unsetUi2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI2$26, 0);
    } 
  }
  
  public long getUi4() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI4$28, 0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetUi4() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_element_user(UI4$28, 0);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetUi4() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UI4$28) != 0);
    } 
  }
  
  public void setUi4(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI4$28, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(UI4$28); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetUi4(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_element_user(UI4$28, 0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_element_user(UI4$28); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetUi4() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI4$28, 0);
    } 
  }
  
  public BigInteger getUi8() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI8$30, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlUnsignedLong xgetUi8() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedLong xmlUnsignedLong = null;
      xmlUnsignedLong = (XmlUnsignedLong)get_store().find_element_user(UI8$30, 0);
      return xmlUnsignedLong;
    } 
  }
  
  public boolean isSetUi8() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UI8$30) != 0);
    } 
  }
  
  public void setUi8(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI8$30, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(UI8$30); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetUi8(XmlUnsignedLong paramXmlUnsignedLong) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedLong xmlUnsignedLong = null;
      xmlUnsignedLong = (XmlUnsignedLong)get_store().find_element_user(UI8$30, 0);
      if (xmlUnsignedLong == null)
        xmlUnsignedLong = (XmlUnsignedLong)get_store().add_element_user(UI8$30); 
      xmlUnsignedLong.set((XmlObject)paramXmlUnsignedLong);
    } 
  }
  
  public void unsetUi8() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI8$30, 0);
    } 
  }
  
  public long getUint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UINT$32, 0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetUint() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_element_user(UINT$32, 0);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetUint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UINT$32) != 0);
    } 
  }
  
  public void setUint(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UINT$32, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(UINT$32); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetUint(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_element_user(UINT$32, 0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_element_user(UINT$32); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetUint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UINT$32, 0);
    } 
  }
  
  public float getR4() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R4$34, 0);
      if (simpleValue == null)
        return 0.0F; 
      return simpleValue.getFloatValue();
    } 
  }
  
  public XmlFloat xgetR4() {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_element_user(R4$34, 0);
      return xmlFloat;
    } 
  }
  
  public boolean isSetR4() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(R4$34) != 0);
    } 
  }
  
  public void setR4(float paramFloat) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R4$34, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(R4$34); 
      simpleValue.setFloatValue(paramFloat);
    } 
  }
  
  public void xsetR4(XmlFloat paramXmlFloat) {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_element_user(R4$34, 0);
      if (xmlFloat == null)
        xmlFloat = (XmlFloat)get_store().add_element_user(R4$34); 
      xmlFloat.set((XmlObject)paramXmlFloat);
    } 
  }
  
  public void unsetR4() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R4$34, 0);
    } 
  }
  
  public double getR8() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R8$36, 0);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetR8() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_element_user(R8$36, 0);
      return xmlDouble;
    } 
  }
  
  public boolean isSetR8() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(R8$36) != 0);
    } 
  }
  
  public void setR8(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R8$36, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(R8$36); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetR8(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_element_user(R8$36, 0);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_element_user(R8$36); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetR8() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R8$36, 0);
    } 
  }
  
  public BigDecimal getDecimal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DECIMAL$38, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigDecimalValue();
    } 
  }
  
  public XmlDecimal xgetDecimal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDecimal xmlDecimal = null;
      xmlDecimal = (XmlDecimal)get_store().find_element_user(DECIMAL$38, 0);
      return xmlDecimal;
    } 
  }
  
  public boolean isSetDecimal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DECIMAL$38) != 0);
    } 
  }
  
  public void setDecimal(BigDecimal paramBigDecimal) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DECIMAL$38, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(DECIMAL$38); 
      simpleValue.setBigDecimalValue(paramBigDecimal);
    } 
  }
  
  public void xsetDecimal(XmlDecimal paramXmlDecimal) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDecimal xmlDecimal = null;
      xmlDecimal = (XmlDecimal)get_store().find_element_user(DECIMAL$38, 0);
      if (xmlDecimal == null)
        xmlDecimal = (XmlDecimal)get_store().add_element_user(DECIMAL$38); 
      xmlDecimal.set((XmlObject)paramXmlDecimal);
    } 
  }
  
  public void unsetDecimal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DECIMAL$38, 0);
    } 
  }
  
  public String getLpstr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPSTR$40, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetLpstr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPSTR$40, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetLpstr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LPSTR$40) != 0);
    } 
  }
  
  public void setLpstr(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPSTR$40, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(LPSTR$40); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLpstr(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPSTR$40, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(LPSTR$40); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetLpstr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LPSTR$40, 0);
    } 
  }
  
  public String getLpwstr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPWSTR$42, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetLpwstr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPWSTR$42, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetLpwstr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LPWSTR$42) != 0);
    } 
  }
  
  public void setLpwstr(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPWSTR$42, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(LPWSTR$42); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLpwstr(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPWSTR$42, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(LPWSTR$42); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetLpwstr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LPWSTR$42, 0);
    } 
  }
  
  public String getBstr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BSTR$44, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBstr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(BSTR$44, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetBstr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BSTR$44) != 0);
    } 
  }
  
  public void setBstr(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BSTR$44, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(BSTR$44); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBstr(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(BSTR$44, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(BSTR$44); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBstr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BSTR$44, 0);
    } 
  }
  
  public Calendar getDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DATE$46, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime xgetDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(DATE$46, 0);
      return xmlDateTime;
    } 
  }
  
  public boolean isSetDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATE$46) != 0);
    } 
  }
  
  public void setDate(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DATE$46, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(DATE$46); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetDate(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(DATE$46, 0);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_element_user(DATE$46); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void unsetDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATE$46, 0);
    } 
  }
  
  public Calendar getFiletime() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FILETIME$48, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime xgetFiletime() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(FILETIME$48, 0);
      return xmlDateTime;
    } 
  }
  
  public boolean isSetFiletime() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILETIME$48) != 0);
    } 
  }
  
  public void setFiletime(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FILETIME$48, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(FILETIME$48); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetFiletime(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(FILETIME$48, 0);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_element_user(FILETIME$48); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void unsetFiletime() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILETIME$48, 0);
    } 
  }
  
  public boolean getBool() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BOOL$50, 0);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBool() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(BOOL$50, 0);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBool() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOOL$50) != 0);
    } 
  }
  
  public void setBool(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BOOL$50, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(BOOL$50); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBool(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(BOOL$50, 0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_element_user(BOOL$50); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBool() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOL$50, 0);
    } 
  }
  
  public String getCy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CY$52, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCy xgetCy() {
    synchronized (monitor()) {
      check_orphaned();
      STCy sTCy = null;
      sTCy = (STCy)get_store().find_element_user(CY$52, 0);
      return sTCy;
    } 
  }
  
  public boolean isSetCy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CY$52) != 0);
    } 
  }
  
  public void setCy(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CY$52, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(CY$52); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCy(STCy paramSTCy) {
    synchronized (monitor()) {
      check_orphaned();
      STCy sTCy = null;
      sTCy = (STCy)get_store().find_element_user(CY$52, 0);
      if (sTCy == null)
        sTCy = (STCy)get_store().add_element_user(CY$52); 
      sTCy.set((XmlObject)paramSTCy);
    } 
  }
  
  public void unsetCy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CY$52, 0);
    } 
  }
  
  public String getError() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ERROR$54, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STError xgetError() {
    synchronized (monitor()) {
      check_orphaned();
      STError sTError = null;
      sTError = (STError)get_store().find_element_user(ERROR$54, 0);
      return sTError;
    } 
  }
  
  public boolean isSetError() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ERROR$54) != 0);
    } 
  }
  
  public void setError(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ERROR$54, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(ERROR$54); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetError(STError paramSTError) {
    synchronized (monitor()) {
      check_orphaned();
      STError sTError = null;
      sTError = (STError)get_store().find_element_user(ERROR$54, 0);
      if (sTError == null)
        sTError = (STError)get_store().add_element_user(ERROR$54); 
      sTError.set((XmlObject)paramSTError);
    } 
  }
  
  public void unsetError() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ERROR$54, 0);
    } 
  }
  
  public byte[] getStream() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(STREAM$56, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetStream() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(STREAM$56, 0);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetStream() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STREAM$56) != 0);
    } 
  }
  
  public void setStream(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(STREAM$56, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(STREAM$56); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetStream(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(STREAM$56, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(STREAM$56); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetStream() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STREAM$56, 0);
    } 
  }
  
  public byte[] getOstream() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OSTREAM$58, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetOstream() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(OSTREAM$58, 0);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetOstream() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OSTREAM$58) != 0);
    } 
  }
  
  public void setOstream(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OSTREAM$58, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(OSTREAM$58); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetOstream(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(OSTREAM$58, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(OSTREAM$58); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetOstream() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OSTREAM$58, 0);
    } 
  }
  
  public byte[] getStorage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(STORAGE$60, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetStorage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(STORAGE$60, 0);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetStorage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STORAGE$60) != 0);
    } 
  }
  
  public void setStorage(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(STORAGE$60, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(STORAGE$60); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetStorage(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(STORAGE$60, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(STORAGE$60); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetStorage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STORAGE$60, 0);
    } 
  }
  
  public byte[] getOstorage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OSTORAGE$62, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetOstorage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(OSTORAGE$62, 0);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetOstorage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OSTORAGE$62) != 0);
    } 
  }
  
  public void setOstorage(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OSTORAGE$62, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(OSTORAGE$62); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetOstorage(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(OSTORAGE$62, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(OSTORAGE$62); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetOstorage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OSTORAGE$62, 0);
    } 
  }
  
  public CTVstream getVstream() {
    synchronized (monitor()) {
      check_orphaned();
      CTVstream cTVstream = null;
      cTVstream = (CTVstream)get_store().find_element_user(VSTREAM$64, 0);
      if (cTVstream == null)
        return null; 
      return cTVstream;
    } 
  }
  
  public boolean isSetVstream() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VSTREAM$64) != 0);
    } 
  }
  
  public void setVstream(CTVstream paramCTVstream) {
    synchronized (monitor()) {
      check_orphaned();
      CTVstream cTVstream = null;
      cTVstream = (CTVstream)get_store().find_element_user(VSTREAM$64, 0);
      if (cTVstream == null)
        cTVstream = (CTVstream)get_store().add_element_user(VSTREAM$64); 
      cTVstream.set((XmlObject)paramCTVstream);
    } 
  }
  
  public CTVstream addNewVstream() {
    synchronized (monitor()) {
      check_orphaned();
      CTVstream cTVstream = null;
      cTVstream = (CTVstream)get_store().add_element_user(VSTREAM$64);
      return cTVstream;
    } 
  }
  
  public void unsetVstream() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VSTREAM$64, 0);
    } 
  }
  
  public String getClsid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CLSID$66, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STClsid xgetClsid() {
    synchronized (monitor()) {
      check_orphaned();
      STClsid sTClsid = null;
      sTClsid = (STClsid)get_store().find_element_user(CLSID$66, 0);
      return sTClsid;
    } 
  }
  
  public boolean isSetClsid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CLSID$66) != 0);
    } 
  }
  
  public void setClsid(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CLSID$66, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(CLSID$66); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetClsid(STClsid paramSTClsid) {
    synchronized (monitor()) {
      check_orphaned();
      STClsid sTClsid = null;
      sTClsid = (STClsid)get_store().find_element_user(CLSID$66, 0);
      if (sTClsid == null)
        sTClsid = (STClsid)get_store().add_element_user(CLSID$66); 
      sTClsid.set((XmlObject)paramSTClsid);
    } 
  }
  
  public void unsetClsid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLSID$66, 0);
    } 
  }
  
  public CTCf getCf() {
    synchronized (monitor()) {
      check_orphaned();
      CTCf cTCf = null;
      cTCf = (CTCf)get_store().find_element_user(CF$68, 0);
      if (cTCf == null)
        return null; 
      return cTCf;
    } 
  }
  
  public boolean isSetCf() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CF$68) != 0);
    } 
  }
  
  public void setCf(CTCf paramCTCf) {
    synchronized (monitor()) {
      check_orphaned();
      CTCf cTCf = null;
      cTCf = (CTCf)get_store().find_element_user(CF$68, 0);
      if (cTCf == null)
        cTCf = (CTCf)get_store().add_element_user(CF$68); 
      cTCf.set((XmlObject)paramCTCf);
    } 
  }
  
  public CTCf addNewCf() {
    synchronized (monitor()) {
      check_orphaned();
      CTCf cTCf = null;
      cTCf = (CTCf)get_store().add_element_user(CF$68);
      return cTCf;
    } 
  }
  
  public void unsetCf() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CF$68, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\docPropsVTypes\impl\CTVariantImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */