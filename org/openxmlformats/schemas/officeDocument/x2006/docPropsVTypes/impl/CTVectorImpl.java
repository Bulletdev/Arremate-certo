package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
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
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STVectorBaseType;

public class CTVectorImpl extends XmlComplexContentImpl implements CTVector {
  private static final b VARIANT$0 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "variant");
  
  private static final b I1$2 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1");
  
  private static final b I2$4 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2");
  
  private static final b I4$6 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4");
  
  private static final b I8$8 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8");
  
  private static final b UI1$10 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1");
  
  private static final b UI2$12 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2");
  
  private static final b UI4$14 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4");
  
  private static final b UI8$16 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8");
  
  private static final b R4$18 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4");
  
  private static final b R8$20 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8");
  
  private static final b LPSTR$22 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr");
  
  private static final b LPWSTR$24 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr");
  
  private static final b BSTR$26 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr");
  
  private static final b DATE$28 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "date");
  
  private static final b FILETIME$30 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime");
  
  private static final b BOOL$32 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool");
  
  private static final b CY$34 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy");
  
  private static final b ERROR$36 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "error");
  
  private static final b CLSID$38 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid");
  
  private static final b CF$40 = new b("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cf");
  
  private static final b BASETYPE$42 = new b("", "baseType");
  
  private static final b SIZE$44 = new b("", "size");
  
  public CTVectorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTVariant> getVariantList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTVariant>)new VariantList(this);
    } 
  }
  
  public CTVariant[] getVariantArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VARIANT$0, arrayList);
      CTVariant[] arrayOfCTVariant = new CTVariant[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTVariant);
      return arrayOfCTVariant;
    } 
  }
  
  public CTVariant getVariantArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTVariant cTVariant = null;
      cTVariant = (CTVariant)get_store().find_element_user(VARIANT$0, paramInt);
      if (cTVariant == null)
        throw new IndexOutOfBoundsException(); 
      return cTVariant;
    } 
  }
  
  public int sizeOfVariantArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VARIANT$0);
    } 
  }
  
  public void setVariantArray(CTVariant[] paramArrayOfCTVariant) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTVariant, VARIANT$0);
    } 
  }
  
  public void setVariantArray(int paramInt, CTVariant paramCTVariant) {
    synchronized (monitor()) {
      check_orphaned();
      CTVariant cTVariant = null;
      cTVariant = (CTVariant)get_store().find_element_user(VARIANT$0, paramInt);
      if (cTVariant == null)
        throw new IndexOutOfBoundsException(); 
      cTVariant.set((XmlObject)paramCTVariant);
    } 
  }
  
  public CTVariant insertNewVariant(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTVariant cTVariant = null;
      cTVariant = (CTVariant)get_store().insert_element_user(VARIANT$0, paramInt);
      return cTVariant;
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
  
  public void removeVariant(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VARIANT$0, paramInt);
    } 
  }
  
  public List<Byte> getI1List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Byte>)new I1List(this);
    } 
  }
  
  public byte[] getI1Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I1$2, arrayList);
      byte[] arrayOfByte = new byte[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfByte[b1] = ((SimpleValue)arrayList.get(b1)).getByteValue();
        b1++;
      } 
      return arrayOfByte;
    } 
  }
  
  public byte getI1Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I1$2, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getByteValue();
    } 
  }
  
  public List<XmlByte> xgetI1List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlByte>)new I1List(this);
    } 
  }
  
  public XmlByte[] xgetI1Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I1$2, arrayList);
      XmlByte[] arrayOfXmlByte = new XmlByte[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlByte);
      return arrayOfXmlByte;
    } 
  }
  
  public XmlByte xgetI1Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_element_user(I1$2, paramInt);
      if (xmlByte == null)
        throw new IndexOutOfBoundsException(); 
      return xmlByte;
    } 
  }
  
  public int sizeOfI1Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(I1$2);
    } 
  }
  
  public void setI1Array(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfbyte, I1$2);
    } 
  }
  
  public void setI1Array(int paramInt, byte paramByte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I1$2, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setByteValue(paramByte);
    } 
  }
  
  public void xsetI1Array(XmlByte[] paramArrayOfXmlByte) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlByte, I1$2);
    } 
  }
  
  public void xsetI1Array(int paramInt, XmlByte paramXmlByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().find_element_user(I1$2, paramInt);
      if (xmlByte == null)
        throw new IndexOutOfBoundsException(); 
      xmlByte.set((XmlObject)paramXmlByte);
    } 
  }
  
  public void insertI1(int paramInt, byte paramByte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(I1$2, paramInt);
      simpleValue.setByteValue(paramByte);
    } 
  }
  
  public void addI1(byte paramByte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(I1$2);
      simpleValue.setByteValue(paramByte);
    } 
  }
  
  public XmlByte insertNewI1(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().insert_element_user(I1$2, paramInt);
      return xmlByte;
    } 
  }
  
  public XmlByte addNewI1() {
    synchronized (monitor()) {
      check_orphaned();
      XmlByte xmlByte = null;
      xmlByte = (XmlByte)get_store().add_element_user(I1$2);
      return xmlByte;
    } 
  }
  
  public void removeI1(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I1$2, paramInt);
    } 
  }
  
  public List<Short> getI2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Short>)new I2List(this);
    } 
  }
  
  public short[] getI2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I2$4, arrayList);
      short[] arrayOfShort = new short[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfShort[b1] = ((SimpleValue)arrayList.get(b1)).getShortValue();
        b1++;
      } 
      return arrayOfShort;
    } 
  }
  
  public short getI2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I2$4, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getShortValue();
    } 
  }
  
  public List<XmlShort> xgetI2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlShort>)new I2List(this);
    } 
  }
  
  public XmlShort[] xgetI2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I2$4, arrayList);
      XmlShort[] arrayOfXmlShort = new XmlShort[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlShort);
      return arrayOfXmlShort;
    } 
  }
  
  public XmlShort xgetI2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlShort xmlShort = null;
      xmlShort = (XmlShort)get_store().find_element_user(I2$4, paramInt);
      if (xmlShort == null)
        throw new IndexOutOfBoundsException(); 
      return xmlShort;
    } 
  }
  
  public int sizeOfI2Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(I2$4);
    } 
  }
  
  public void setI2Array(short[] paramArrayOfshort) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfshort, I2$4);
    } 
  }
  
  public void setI2Array(int paramInt, short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I2$4, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetI2Array(XmlShort[] paramArrayOfXmlShort) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlShort, I2$4);
    } 
  }
  
  public void xsetI2Array(int paramInt, XmlShort paramXmlShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlShort xmlShort = null;
      xmlShort = (XmlShort)get_store().find_element_user(I2$4, paramInt);
      if (xmlShort == null)
        throw new IndexOutOfBoundsException(); 
      xmlShort.set((XmlObject)paramXmlShort);
    } 
  }
  
  public void insertI2(int paramInt, short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(I2$4, paramInt);
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void addI2(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(I2$4);
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public XmlShort insertNewI2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlShort xmlShort = null;
      xmlShort = (XmlShort)get_store().insert_element_user(I2$4, paramInt);
      return xmlShort;
    } 
  }
  
  public XmlShort addNewI2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlShort xmlShort = null;
      xmlShort = (XmlShort)get_store().add_element_user(I2$4);
      return xmlShort;
    } 
  }
  
  public void removeI2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I2$4, paramInt);
    } 
  }
  
  public List<Integer> getI4List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Integer>)new I4List(this);
    } 
  }
  
  public int[] getI4Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I4$6, arrayList);
      int[] arrayOfInt = new int[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfInt[b1] = ((SimpleValue)arrayList.get(b1)).getIntValue();
        b1++;
      } 
      return arrayOfInt;
    } 
  }
  
  public int getI4Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I4$6, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getIntValue();
    } 
  }
  
  public List<XmlInt> xgetI4List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInt>)new I4List(this);
    } 
  }
  
  public XmlInt[] xgetI4Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I4$6, arrayList);
      XmlInt[] arrayOfXmlInt = new XmlInt[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInt);
      return arrayOfXmlInt;
    } 
  }
  
  public XmlInt xgetI4Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(I4$6, paramInt);
      if (xmlInt == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInt;
    } 
  }
  
  public int sizeOfI4Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(I4$6);
    } 
  }
  
  public void setI4Array(int[] paramArrayOfint) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfint, I4$6);
    } 
  }
  
  public void setI4Array(int paramInt1, int paramInt2) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I4$6, paramInt1);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setIntValue(paramInt2);
    } 
  }
  
  public void xsetI4Array(XmlInt[] paramArrayOfXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInt, I4$6);
    } 
  }
  
  public void xsetI4Array(int paramInt, XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(I4$6, paramInt);
      if (xmlInt == null)
        throw new IndexOutOfBoundsException(); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void insertI4(int paramInt1, int paramInt2) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(I4$6, paramInt1);
      simpleValue.setIntValue(paramInt2);
    } 
  }
  
  public void addI4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(I4$6);
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public XmlInt insertNewI4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().insert_element_user(I4$6, paramInt);
      return xmlInt;
    } 
  }
  
  public XmlInt addNewI4() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().add_element_user(I4$6);
      return xmlInt;
    } 
  }
  
  public void removeI4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I4$6, paramInt);
    } 
  }
  
  public List<Long> getI8List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Long>)new I8List(this);
    } 
  }
  
  public long[] getI8Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I8$8, arrayList);
      long[] arrayOfLong = new long[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfLong[b1] = ((SimpleValue)arrayList.get(b1)).getLongValue();
        b1++;
      } 
      return arrayOfLong;
    } 
  }
  
  public long getI8Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I8$8, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getLongValue();
    } 
  }
  
  public List<XmlLong> xgetI8List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlLong>)new I8List(this);
    } 
  }
  
  public XmlLong[] xgetI8Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I8$8, arrayList);
      XmlLong[] arrayOfXmlLong = new XmlLong[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlLong);
      return arrayOfXmlLong;
    } 
  }
  
  public XmlLong xgetI8Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlLong xmlLong = null;
      xmlLong = (XmlLong)get_store().find_element_user(I8$8, paramInt);
      if (xmlLong == null)
        throw new IndexOutOfBoundsException(); 
      return xmlLong;
    } 
  }
  
  public int sizeOfI8Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(I8$8);
    } 
  }
  
  public void setI8Array(long[] paramArrayOflong) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOflong, I8$8);
    } 
  }
  
  public void setI8Array(int paramInt, long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(I8$8, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetI8Array(XmlLong[] paramArrayOfXmlLong) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlLong, I8$8);
    } 
  }
  
  public void xsetI8Array(int paramInt, XmlLong paramXmlLong) {
    synchronized (monitor()) {
      check_orphaned();
      XmlLong xmlLong = null;
      xmlLong = (XmlLong)get_store().find_element_user(I8$8, paramInt);
      if (xmlLong == null)
        throw new IndexOutOfBoundsException(); 
      xmlLong.set((XmlObject)paramXmlLong);
    } 
  }
  
  public void insertI8(int paramInt, long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(I8$8, paramInt);
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void addI8(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(I8$8);
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public XmlLong insertNewI8(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlLong xmlLong = null;
      xmlLong = (XmlLong)get_store().insert_element_user(I8$8, paramInt);
      return xmlLong;
    } 
  }
  
  public XmlLong addNewI8() {
    synchronized (monitor()) {
      check_orphaned();
      XmlLong xmlLong = null;
      xmlLong = (XmlLong)get_store().add_element_user(I8$8);
      return xmlLong;
    } 
  }
  
  public void removeI8(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I8$8, paramInt);
    } 
  }
  
  public List<Short> getUi1List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Short>)new Ui1List(this);
    } 
  }
  
  public short[] getUi1Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UI1$10, arrayList);
      short[] arrayOfShort = new short[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfShort[b1] = ((SimpleValue)arrayList.get(b1)).getShortValue();
        b1++;
      } 
      return arrayOfShort;
    } 
  }
  
  public short getUi1Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI1$10, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getShortValue();
    } 
  }
  
  public List<XmlUnsignedByte> xgetUi1List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlUnsignedByte>)new Ui1List(this);
    } 
  }
  
  public XmlUnsignedByte[] xgetUi1Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UI1$10, arrayList);
      XmlUnsignedByte[] arrayOfXmlUnsignedByte = new XmlUnsignedByte[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlUnsignedByte);
      return arrayOfXmlUnsignedByte;
    } 
  }
  
  public XmlUnsignedByte xgetUi1Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_element_user(UI1$10, paramInt);
      if (xmlUnsignedByte == null)
        throw new IndexOutOfBoundsException(); 
      return xmlUnsignedByte;
    } 
  }
  
  public int sizeOfUi1Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(UI1$10);
    } 
  }
  
  public void setUi1Array(short[] paramArrayOfshort) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfshort, UI1$10);
    } 
  }
  
  public void setUi1Array(int paramInt, short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI1$10, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetUi1Array(XmlUnsignedByte[] paramArrayOfXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlUnsignedByte, UI1$10);
    } 
  }
  
  public void xsetUi1Array(int paramInt, XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_element_user(UI1$10, paramInt);
      if (xmlUnsignedByte == null)
        throw new IndexOutOfBoundsException(); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void insertUi1(int paramInt, short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(UI1$10, paramInt);
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void addUi1(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(UI1$10);
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public XmlUnsignedByte insertNewUi1(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().insert_element_user(UI1$10, paramInt);
      return xmlUnsignedByte;
    } 
  }
  
  public XmlUnsignedByte addNewUi1() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().add_element_user(UI1$10);
      return xmlUnsignedByte;
    } 
  }
  
  public void removeUi1(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI1$10, paramInt);
    } 
  }
  
  public List<Integer> getUi2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Integer>)new Ui2List(this);
    } 
  }
  
  public int[] getUi2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UI2$12, arrayList);
      int[] arrayOfInt = new int[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfInt[b1] = ((SimpleValue)arrayList.get(b1)).getIntValue();
        b1++;
      } 
      return arrayOfInt;
    } 
  }
  
  public int getUi2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI2$12, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getIntValue();
    } 
  }
  
  public List<XmlUnsignedShort> xgetUi2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlUnsignedShort>)new Ui2List(this);
    } 
  }
  
  public XmlUnsignedShort[] xgetUi2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UI2$12, arrayList);
      XmlUnsignedShort[] arrayOfXmlUnsignedShort = new XmlUnsignedShort[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlUnsignedShort);
      return arrayOfXmlUnsignedShort;
    } 
  }
  
  public XmlUnsignedShort xgetUi2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_element_user(UI2$12, paramInt);
      if (xmlUnsignedShort == null)
        throw new IndexOutOfBoundsException(); 
      return xmlUnsignedShort;
    } 
  }
  
  public int sizeOfUi2Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(UI2$12);
    } 
  }
  
  public void setUi2Array(int[] paramArrayOfint) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfint, UI2$12);
    } 
  }
  
  public void setUi2Array(int paramInt1, int paramInt2) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI2$12, paramInt1);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setIntValue(paramInt2);
    } 
  }
  
  public void xsetUi2Array(XmlUnsignedShort[] paramArrayOfXmlUnsignedShort) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlUnsignedShort, UI2$12);
    } 
  }
  
  public void xsetUi2Array(int paramInt, XmlUnsignedShort paramXmlUnsignedShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_element_user(UI2$12, paramInt);
      if (xmlUnsignedShort == null)
        throw new IndexOutOfBoundsException(); 
      xmlUnsignedShort.set((XmlObject)paramXmlUnsignedShort);
    } 
  }
  
  public void insertUi2(int paramInt1, int paramInt2) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(UI2$12, paramInt1);
      simpleValue.setIntValue(paramInt2);
    } 
  }
  
  public void addUi2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(UI2$12);
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public XmlUnsignedShort insertNewUi2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().insert_element_user(UI2$12, paramInt);
      return xmlUnsignedShort;
    } 
  }
  
  public XmlUnsignedShort addNewUi2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().add_element_user(UI2$12);
      return xmlUnsignedShort;
    } 
  }
  
  public void removeUi2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI2$12, paramInt);
    } 
  }
  
  public List<Long> getUi4List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Long>)new Ui4List(this);
    } 
  }
  
  public long[] getUi4Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UI4$14, arrayList);
      long[] arrayOfLong = new long[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfLong[b1] = ((SimpleValue)arrayList.get(b1)).getLongValue();
        b1++;
      } 
      return arrayOfLong;
    } 
  }
  
  public long getUi4Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI4$14, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getLongValue();
    } 
  }
  
  public List<XmlUnsignedInt> xgetUi4List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlUnsignedInt>)new Ui4List(this);
    } 
  }
  
  public XmlUnsignedInt[] xgetUi4Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UI4$14, arrayList);
      XmlUnsignedInt[] arrayOfXmlUnsignedInt = new XmlUnsignedInt[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlUnsignedInt);
      return arrayOfXmlUnsignedInt;
    } 
  }
  
  public XmlUnsignedInt xgetUi4Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_element_user(UI4$14, paramInt);
      if (xmlUnsignedInt == null)
        throw new IndexOutOfBoundsException(); 
      return xmlUnsignedInt;
    } 
  }
  
  public int sizeOfUi4Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(UI4$14);
    } 
  }
  
  public void setUi4Array(long[] paramArrayOflong) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOflong, UI4$14);
    } 
  }
  
  public void setUi4Array(int paramInt, long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI4$14, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetUi4Array(XmlUnsignedInt[] paramArrayOfXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlUnsignedInt, UI4$14);
    } 
  }
  
  public void xsetUi4Array(int paramInt, XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_element_user(UI4$14, paramInt);
      if (xmlUnsignedInt == null)
        throw new IndexOutOfBoundsException(); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void insertUi4(int paramInt, long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(UI4$14, paramInt);
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void addUi4(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(UI4$14);
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public XmlUnsignedInt insertNewUi4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().insert_element_user(UI4$14, paramInt);
      return xmlUnsignedInt;
    } 
  }
  
  public XmlUnsignedInt addNewUi4() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().add_element_user(UI4$14);
      return xmlUnsignedInt;
    } 
  }
  
  public void removeUi4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI4$14, paramInt);
    } 
  }
  
  public List<BigInteger> getUi8List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new Ui8List(this);
    } 
  }
  
  public BigInteger[] getUi8Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(UI8$16, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getUi8Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI8$16, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlUnsignedLong> xgetUi8List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlUnsignedLong>)new Ui8List(this);
    } 
  }
  
  public XmlUnsignedLong[] xgetUi8Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UI8$16, arrayList);
      XmlUnsignedLong[] arrayOfXmlUnsignedLong = new XmlUnsignedLong[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlUnsignedLong);
      return arrayOfXmlUnsignedLong;
    } 
  }
  
  public XmlUnsignedLong xgetUi8Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedLong xmlUnsignedLong = null;
      xmlUnsignedLong = (XmlUnsignedLong)get_store().find_element_user(UI8$16, paramInt);
      if (xmlUnsignedLong == null)
        throw new IndexOutOfBoundsException(); 
      return xmlUnsignedLong;
    } 
  }
  
  public int sizeOfUi8Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(UI8$16);
    } 
  }
  
  public void setUi8Array(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, UI8$16);
    } 
  }
  
  public void setUi8Array(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UI8$16, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetUi8Array(XmlUnsignedLong[] paramArrayOfXmlUnsignedLong) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlUnsignedLong, UI8$16);
    } 
  }
  
  public void xsetUi8Array(int paramInt, XmlUnsignedLong paramXmlUnsignedLong) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedLong xmlUnsignedLong = null;
      xmlUnsignedLong = (XmlUnsignedLong)get_store().find_element_user(UI8$16, paramInt);
      if (xmlUnsignedLong == null)
        throw new IndexOutOfBoundsException(); 
      xmlUnsignedLong.set((XmlObject)paramXmlUnsignedLong);
    } 
  }
  
  public void insertUi8(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(UI8$16, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addUi8(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(UI8$16);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlUnsignedLong insertNewUi8(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedLong xmlUnsignedLong = null;
      xmlUnsignedLong = (XmlUnsignedLong)get_store().insert_element_user(UI8$16, paramInt);
      return xmlUnsignedLong;
    } 
  }
  
  public XmlUnsignedLong addNewUi8() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedLong xmlUnsignedLong = null;
      xmlUnsignedLong = (XmlUnsignedLong)get_store().add_element_user(UI8$16);
      return xmlUnsignedLong;
    } 
  }
  
  public void removeUi8(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UI8$16, paramInt);
    } 
  }
  
  public List<Float> getR4List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Float>)new R4List(this);
    } 
  }
  
  public float[] getR4Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R4$18, arrayList);
      float[] arrayOfFloat = new float[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfFloat[b1] = ((SimpleValue)arrayList.get(b1)).getFloatValue();
        b1++;
      } 
      return arrayOfFloat;
    } 
  }
  
  public float getR4Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R4$18, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getFloatValue();
    } 
  }
  
  public List<XmlFloat> xgetR4List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlFloat>)new R4List(this);
    } 
  }
  
  public XmlFloat[] xgetR4Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R4$18, arrayList);
      XmlFloat[] arrayOfXmlFloat = new XmlFloat[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlFloat);
      return arrayOfXmlFloat;
    } 
  }
  
  public XmlFloat xgetR4Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_element_user(R4$18, paramInt);
      if (xmlFloat == null)
        throw new IndexOutOfBoundsException(); 
      return xmlFloat;
    } 
  }
  
  public int sizeOfR4Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(R4$18);
    } 
  }
  
  public void setR4Array(float[] paramArrayOffloat) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOffloat, R4$18);
    } 
  }
  
  public void setR4Array(int paramInt, float paramFloat) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R4$18, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setFloatValue(paramFloat);
    } 
  }
  
  public void xsetR4Array(XmlFloat[] paramArrayOfXmlFloat) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlFloat, R4$18);
    } 
  }
  
  public void xsetR4Array(int paramInt, XmlFloat paramXmlFloat) {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_element_user(R4$18, paramInt);
      if (xmlFloat == null)
        throw new IndexOutOfBoundsException(); 
      xmlFloat.set((XmlObject)paramXmlFloat);
    } 
  }
  
  public void insertR4(int paramInt, float paramFloat) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(R4$18, paramInt);
      simpleValue.setFloatValue(paramFloat);
    } 
  }
  
  public void addR4(float paramFloat) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(R4$18);
      simpleValue.setFloatValue(paramFloat);
    } 
  }
  
  public XmlFloat insertNewR4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().insert_element_user(R4$18, paramInt);
      return xmlFloat;
    } 
  }
  
  public XmlFloat addNewR4() {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().add_element_user(R4$18);
      return xmlFloat;
    } 
  }
  
  public void removeR4(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R4$18, paramInt);
    } 
  }
  
  public List<Double> getR8List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Double>)new R8List(this);
    } 
  }
  
  public double[] getR8Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R8$20, arrayList);
      double[] arrayOfDouble = new double[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfDouble[b1] = ((SimpleValue)arrayList.get(b1)).getDoubleValue();
        b1++;
      } 
      return arrayOfDouble;
    } 
  }
  
  public double getR8Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R8$20, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public List<XmlDouble> xgetR8List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlDouble>)new R8List(this);
    } 
  }
  
  public XmlDouble[] xgetR8Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R8$20, arrayList);
      XmlDouble[] arrayOfXmlDouble = new XmlDouble[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlDouble);
      return arrayOfXmlDouble;
    } 
  }
  
  public XmlDouble xgetR8Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_element_user(R8$20, paramInt);
      if (xmlDouble == null)
        throw new IndexOutOfBoundsException(); 
      return xmlDouble;
    } 
  }
  
  public int sizeOfR8Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(R8$20);
    } 
  }
  
  public void setR8Array(double[] paramArrayOfdouble) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfdouble, R8$20);
    } 
  }
  
  public void setR8Array(int paramInt, double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(R8$20, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetR8Array(XmlDouble[] paramArrayOfXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlDouble, R8$20);
    } 
  }
  
  public void xsetR8Array(int paramInt, XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_element_user(R8$20, paramInt);
      if (xmlDouble == null)
        throw new IndexOutOfBoundsException(); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void insertR8(int paramInt, double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(R8$20, paramInt);
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void addR8(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(R8$20);
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public XmlDouble insertNewR8(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().insert_element_user(R8$20, paramInt);
      return xmlDouble;
    } 
  }
  
  public XmlDouble addNewR8() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().add_element_user(R8$20);
      return xmlDouble;
    } 
  }
  
  public void removeR8(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R8$20, paramInt);
    } 
  }
  
  public List<String> getLpstrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new LpstrList(this);
    } 
  }
  
  public String[] getLpstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(LPSTR$22, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getLpstrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPSTR$22, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetLpstrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new LpstrList(this);
    } 
  }
  
  public XmlString[] xgetLpstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LPSTR$22, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetLpstrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPSTR$22, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfLpstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LPSTR$22);
    } 
  }
  
  public void setLpstrArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, LPSTR$22);
    } 
  }
  
  public void setLpstrArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPSTR$22, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLpstrArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, LPSTR$22);
    } 
  }
  
  public void xsetLpstrArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPSTR$22, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertLpstr(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(LPSTR$22, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addLpstr(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(LPSTR$22);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewLpstr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(LPSTR$22, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewLpstr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(LPSTR$22);
      return xmlString;
    } 
  }
  
  public void removeLpstr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LPSTR$22, paramInt);
    } 
  }
  
  public List<String> getLpwstrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new LpwstrList(this);
    } 
  }
  
  public String[] getLpwstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(LPWSTR$24, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getLpwstrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPWSTR$24, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetLpwstrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new LpwstrList(this);
    } 
  }
  
  public XmlString[] xgetLpwstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LPWSTR$24, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetLpwstrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPWSTR$24, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfLpwstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LPWSTR$24);
    } 
  }
  
  public void setLpwstrArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, LPWSTR$24);
    } 
  }
  
  public void setLpwstrArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LPWSTR$24, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLpwstrArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, LPWSTR$24);
    } 
  }
  
  public void xsetLpwstrArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LPWSTR$24, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertLpwstr(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(LPWSTR$24, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addLpwstr(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(LPWSTR$24);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewLpwstr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(LPWSTR$24, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewLpwstr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(LPWSTR$24);
      return xmlString;
    } 
  }
  
  public void removeLpwstr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LPWSTR$24, paramInt);
    } 
  }
  
  public List<String> getBstrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new BstrList(this);
    } 
  }
  
  public String[] getBstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(BSTR$26, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getBstrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BSTR$26, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetBstrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new BstrList(this);
    } 
  }
  
  public XmlString[] xgetBstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BSTR$26, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetBstrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(BSTR$26, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfBstrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BSTR$26);
    } 
  }
  
  public void setBstrArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, BSTR$26);
    } 
  }
  
  public void setBstrArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BSTR$26, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBstrArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, BSTR$26);
    } 
  }
  
  public void xsetBstrArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(BSTR$26, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertBstr(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(BSTR$26, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addBstr(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(BSTR$26);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewBstr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(BSTR$26, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewBstr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(BSTR$26);
      return xmlString;
    } 
  }
  
  public void removeBstr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BSTR$26, paramInt);
    } 
  }
  
  public List<Calendar> getDateList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Calendar>)new DateList(this);
    } 
  }
  
  public Calendar[] getDateArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DATE$28, arrayList);
      Calendar[] arrayOfCalendar = new Calendar[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfCalendar[b1] = ((SimpleValue)arrayList.get(b1)).getCalendarValue();
        b1++;
      } 
      return arrayOfCalendar;
    } 
  }
  
  public Calendar getDateArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DATE$28, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public List<XmlDateTime> xgetDateList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlDateTime>)new DateList(this);
    } 
  }
  
  public XmlDateTime[] xgetDateArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DATE$28, arrayList);
      XmlDateTime[] arrayOfXmlDateTime = new XmlDateTime[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlDateTime);
      return arrayOfXmlDateTime;
    } 
  }
  
  public XmlDateTime xgetDateArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(DATE$28, paramInt);
      if (xmlDateTime == null)
        throw new IndexOutOfBoundsException(); 
      return xmlDateTime;
    } 
  }
  
  public int sizeOfDateArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DATE$28);
    } 
  }
  
  public void setDateArray(Calendar[] paramArrayOfCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfCalendar, DATE$28);
    } 
  }
  
  public void setDateArray(int paramInt, Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DATE$28, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetDateArray(XmlDateTime[] paramArrayOfXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlDateTime, DATE$28);
    } 
  }
  
  public void xsetDateArray(int paramInt, XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(DATE$28, paramInt);
      if (xmlDateTime == null)
        throw new IndexOutOfBoundsException(); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void insertDate(int paramInt, Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DATE$28, paramInt);
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void addDate(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DATE$28);
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public XmlDateTime insertNewDate(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().insert_element_user(DATE$28, paramInt);
      return xmlDateTime;
    } 
  }
  
  public XmlDateTime addNewDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().add_element_user(DATE$28);
      return xmlDateTime;
    } 
  }
  
  public void removeDate(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATE$28, paramInt);
    } 
  }
  
  public List<Calendar> getFiletimeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Calendar>)new FiletimeList(this);
    } 
  }
  
  public Calendar[] getFiletimeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FILETIME$30, arrayList);
      Calendar[] arrayOfCalendar = new Calendar[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfCalendar[b1] = ((SimpleValue)arrayList.get(b1)).getCalendarValue();
        b1++;
      } 
      return arrayOfCalendar;
    } 
  }
  
  public Calendar getFiletimeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FILETIME$30, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public List<XmlDateTime> xgetFiletimeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlDateTime>)new FiletimeList(this);
    } 
  }
  
  public XmlDateTime[] xgetFiletimeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FILETIME$30, arrayList);
      XmlDateTime[] arrayOfXmlDateTime = new XmlDateTime[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlDateTime);
      return arrayOfXmlDateTime;
    } 
  }
  
  public XmlDateTime xgetFiletimeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(FILETIME$30, paramInt);
      if (xmlDateTime == null)
        throw new IndexOutOfBoundsException(); 
      return xmlDateTime;
    } 
  }
  
  public int sizeOfFiletimeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FILETIME$30);
    } 
  }
  
  public void setFiletimeArray(Calendar[] paramArrayOfCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfCalendar, FILETIME$30);
    } 
  }
  
  public void setFiletimeArray(int paramInt, Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FILETIME$30, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetFiletimeArray(XmlDateTime[] paramArrayOfXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlDateTime, FILETIME$30);
    } 
  }
  
  public void xsetFiletimeArray(int paramInt, XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(FILETIME$30, paramInt);
      if (xmlDateTime == null)
        throw new IndexOutOfBoundsException(); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void insertFiletime(int paramInt, Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FILETIME$30, paramInt);
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void addFiletime(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FILETIME$30);
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public XmlDateTime insertNewFiletime(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().insert_element_user(FILETIME$30, paramInt);
      return xmlDateTime;
    } 
  }
  
  public XmlDateTime addNewFiletime() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().add_element_user(FILETIME$30);
      return xmlDateTime;
    } 
  }
  
  public void removeFiletime(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILETIME$30, paramInt);
    } 
  }
  
  public List<Boolean> getBoolList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<Boolean>)new BoolList(this);
    } 
  }
  
  public boolean[] getBoolArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BOOL$32, arrayList);
      boolean[] arrayOfBoolean = new boolean[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBoolean[b1] = ((SimpleValue)arrayList.get(b1)).getBooleanValue();
        b1++;
      } 
      return arrayOfBoolean;
    } 
  }
  
  public boolean getBoolArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BOOL$32, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public List<XmlBoolean> xgetBoolList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlBoolean>)new BoolList(this);
    } 
  }
  
  public XmlBoolean[] xgetBoolArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BOOL$32, arrayList);
      XmlBoolean[] arrayOfXmlBoolean = new XmlBoolean[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlBoolean);
      return arrayOfXmlBoolean;
    } 
  }
  
  public XmlBoolean xgetBoolArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(BOOL$32, paramInt);
      if (xmlBoolean == null)
        throw new IndexOutOfBoundsException(); 
      return xmlBoolean;
    } 
  }
  
  public int sizeOfBoolArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BOOL$32);
    } 
  }
  
  public void setBoolArray(boolean[] paramArrayOfboolean) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfboolean, BOOL$32);
    } 
  }
  
  public void setBoolArray(int paramInt, boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(BOOL$32, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBoolArray(XmlBoolean[] paramArrayOfXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlBoolean, BOOL$32);
    } 
  }
  
  public void xsetBoolArray(int paramInt, XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(BOOL$32, paramInt);
      if (xmlBoolean == null)
        throw new IndexOutOfBoundsException(); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void insertBool(int paramInt, boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(BOOL$32, paramInt);
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void addBool(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(BOOL$32);
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public XmlBoolean insertNewBool(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().insert_element_user(BOOL$32, paramInt);
      return xmlBoolean;
    } 
  }
  
  public XmlBoolean addNewBool() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().add_element_user(BOOL$32);
      return xmlBoolean;
    } 
  }
  
  public void removeBool(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOL$32, paramInt);
    } 
  }
  
  public List<String> getCyList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new CyList(this);
    } 
  }
  
  public String[] getCyArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(CY$34, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getCyArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CY$34, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<STCy> xgetCyList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STCy>)new CyList(this);
    } 
  }
  
  public STCy[] xgetCyArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CY$34, arrayList);
      STCy[] arrayOfSTCy = new STCy[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTCy);
      return arrayOfSTCy;
    } 
  }
  
  public STCy xgetCyArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STCy sTCy = null;
      sTCy = (STCy)get_store().find_element_user(CY$34, paramInt);
      if (sTCy == null)
        throw new IndexOutOfBoundsException(); 
      return sTCy;
    } 
  }
  
  public int sizeOfCyArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CY$34);
    } 
  }
  
  public void setCyArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, CY$34);
    } 
  }
  
  public void setCyArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CY$34, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCyArray(STCy[] paramArrayOfSTCy) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTCy, CY$34);
    } 
  }
  
  public void xsetCyArray(int paramInt, STCy paramSTCy) {
    synchronized (monitor()) {
      check_orphaned();
      STCy sTCy = null;
      sTCy = (STCy)get_store().find_element_user(CY$34, paramInt);
      if (sTCy == null)
        throw new IndexOutOfBoundsException(); 
      sTCy.set((XmlObject)paramSTCy);
    } 
  }
  
  public void insertCy(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(CY$34, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addCy(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(CY$34);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public STCy insertNewCy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STCy sTCy = null;
      sTCy = (STCy)get_store().insert_element_user(CY$34, paramInt);
      return sTCy;
    } 
  }
  
  public STCy addNewCy() {
    synchronized (monitor()) {
      check_orphaned();
      STCy sTCy = null;
      sTCy = (STCy)get_store().add_element_user(CY$34);
      return sTCy;
    } 
  }
  
  public void removeCy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CY$34, paramInt);
    } 
  }
  
  public List<String> getErrorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new ErrorList(this);
    } 
  }
  
  public String[] getErrorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(ERROR$36, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getErrorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ERROR$36, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<STError> xgetErrorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STError>)new ErrorList(this);
    } 
  }
  
  public STError[] xgetErrorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ERROR$36, arrayList);
      STError[] arrayOfSTError = new STError[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTError);
      return arrayOfSTError;
    } 
  }
  
  public STError xgetErrorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STError sTError = null;
      sTError = (STError)get_store().find_element_user(ERROR$36, paramInt);
      if (sTError == null)
        throw new IndexOutOfBoundsException(); 
      return sTError;
    } 
  }
  
  public int sizeOfErrorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ERROR$36);
    } 
  }
  
  public void setErrorArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, ERROR$36);
    } 
  }
  
  public void setErrorArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ERROR$36, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetErrorArray(STError[] paramArrayOfSTError) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTError, ERROR$36);
    } 
  }
  
  public void xsetErrorArray(int paramInt, STError paramSTError) {
    synchronized (monitor()) {
      check_orphaned();
      STError sTError = null;
      sTError = (STError)get_store().find_element_user(ERROR$36, paramInt);
      if (sTError == null)
        throw new IndexOutOfBoundsException(); 
      sTError.set((XmlObject)paramSTError);
    } 
  }
  
  public void insertError(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(ERROR$36, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addError(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(ERROR$36);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public STError insertNewError(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STError sTError = null;
      sTError = (STError)get_store().insert_element_user(ERROR$36, paramInt);
      return sTError;
    } 
  }
  
  public STError addNewError() {
    synchronized (monitor()) {
      check_orphaned();
      STError sTError = null;
      sTError = (STError)get_store().add_element_user(ERROR$36);
      return sTError;
    } 
  }
  
  public void removeError(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ERROR$36, paramInt);
    } 
  }
  
  public List<String> getClsidList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new ClsidList(this);
    } 
  }
  
  public String[] getClsidArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(CLSID$38, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getClsidArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CLSID$38, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<STClsid> xgetClsidList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STClsid>)new ClsidList(this);
    } 
  }
  
  public STClsid[] xgetClsidArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CLSID$38, arrayList);
      STClsid[] arrayOfSTClsid = new STClsid[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTClsid);
      return arrayOfSTClsid;
    } 
  }
  
  public STClsid xgetClsidArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STClsid sTClsid = null;
      sTClsid = (STClsid)get_store().find_element_user(CLSID$38, paramInt);
      if (sTClsid == null)
        throw new IndexOutOfBoundsException(); 
      return sTClsid;
    } 
  }
  
  public int sizeOfClsidArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CLSID$38);
    } 
  }
  
  public void setClsidArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, CLSID$38);
    } 
  }
  
  public void setClsidArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CLSID$38, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetClsidArray(STClsid[] paramArrayOfSTClsid) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTClsid, CLSID$38);
    } 
  }
  
  public void xsetClsidArray(int paramInt, STClsid paramSTClsid) {
    synchronized (monitor()) {
      check_orphaned();
      STClsid sTClsid = null;
      sTClsid = (STClsid)get_store().find_element_user(CLSID$38, paramInt);
      if (sTClsid == null)
        throw new IndexOutOfBoundsException(); 
      sTClsid.set((XmlObject)paramSTClsid);
    } 
  }
  
  public void insertClsid(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(CLSID$38, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addClsid(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(CLSID$38);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public STClsid insertNewClsid(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STClsid sTClsid = null;
      sTClsid = (STClsid)get_store().insert_element_user(CLSID$38, paramInt);
      return sTClsid;
    } 
  }
  
  public STClsid addNewClsid() {
    synchronized (monitor()) {
      check_orphaned();
      STClsid sTClsid = null;
      sTClsid = (STClsid)get_store().add_element_user(CLSID$38);
      return sTClsid;
    } 
  }
  
  public void removeClsid(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLSID$38, paramInt);
    } 
  }
  
  public List<CTCf> getCfList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCf>)new CfList(this);
    } 
  }
  
  public CTCf[] getCfArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CF$40, arrayList);
      CTCf[] arrayOfCTCf = new CTCf[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCf);
      return arrayOfCTCf;
    } 
  }
  
  public CTCf getCfArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCf cTCf = null;
      cTCf = (CTCf)get_store().find_element_user(CF$40, paramInt);
      if (cTCf == null)
        throw new IndexOutOfBoundsException(); 
      return cTCf;
    } 
  }
  
  public int sizeOfCfArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CF$40);
    } 
  }
  
  public void setCfArray(CTCf[] paramArrayOfCTCf) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCf, CF$40);
    } 
  }
  
  public void setCfArray(int paramInt, CTCf paramCTCf) {
    synchronized (monitor()) {
      check_orphaned();
      CTCf cTCf = null;
      cTCf = (CTCf)get_store().find_element_user(CF$40, paramInt);
      if (cTCf == null)
        throw new IndexOutOfBoundsException(); 
      cTCf.set((XmlObject)paramCTCf);
    } 
  }
  
  public CTCf insertNewCf(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCf cTCf = null;
      cTCf = (CTCf)get_store().insert_element_user(CF$40, paramInt);
      return cTCf;
    } 
  }
  
  public CTCf addNewCf() {
    synchronized (monitor()) {
      check_orphaned();
      CTCf cTCf = null;
      cTCf = (CTCf)get_store().add_element_user(CF$40);
      return cTCf;
    } 
  }
  
  public void removeCf(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CF$40, paramInt);
    } 
  }
  
  public STVectorBaseType.Enum getBaseType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASETYPE$42);
      if (simpleValue == null)
        return null; 
      return (STVectorBaseType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STVectorBaseType xgetBaseType() {
    synchronized (monitor()) {
      check_orphaned();
      STVectorBaseType sTVectorBaseType = null;
      sTVectorBaseType = (STVectorBaseType)get_store().find_attribute_user(BASETYPE$42);
      return sTVectorBaseType;
    } 
  }
  
  public void setBaseType(STVectorBaseType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASETYPE$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BASETYPE$42); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBaseType(STVectorBaseType paramSTVectorBaseType) {
    synchronized (monitor()) {
      check_orphaned();
      STVectorBaseType sTVectorBaseType = null;
      sTVectorBaseType = (STVectorBaseType)get_store().find_attribute_user(BASETYPE$42);
      if (sTVectorBaseType == null)
        sTVectorBaseType = (STVectorBaseType)get_store().add_attribute_user(BASETYPE$42); 
      sTVectorBaseType.set((XmlObject)paramSTVectorBaseType);
    } 
  }
  
  public long getSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SIZE$44);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetSize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SIZE$44);
      return xmlUnsignedInt;
    } 
  }
  
  public void setSize(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SIZE$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SIZE$44); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetSize(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SIZE$44);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(SIZE$44); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\docPropsVTypes\impl\CTVectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */