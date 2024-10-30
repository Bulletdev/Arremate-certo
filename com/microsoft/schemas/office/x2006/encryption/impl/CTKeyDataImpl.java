package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.STBlockSize;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STHashSize;
import com.microsoft.schemas.office.x2006.encryption.STKeyBits;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTKeyDataImpl extends XmlComplexContentImpl implements CTKeyData {
  private static final b SALTSIZE$0 = new b("", "saltSize");
  
  private static final b BLOCKSIZE$2 = new b("", "blockSize");
  
  private static final b KEYBITS$4 = new b("", "keyBits");
  
  private static final b HASHSIZE$6 = new b("", "hashSize");
  
  private static final b CIPHERALGORITHM$8 = new b("", "cipherAlgorithm");
  
  private static final b CIPHERCHAINING$10 = new b("", "cipherChaining");
  
  private static final b HASHALGORITHM$12 = new b("", "hashAlgorithm");
  
  private static final b SALTVALUE$14 = new b("", "saltValue");
  
  public CTKeyDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getSaltSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SALTSIZE$0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STSaltSize xgetSaltSize() {
    synchronized (monitor()) {
      check_orphaned();
      STSaltSize sTSaltSize = null;
      sTSaltSize = (STSaltSize)get_store().find_attribute_user(SALTSIZE$0);
      return sTSaltSize;
    } 
  }
  
  public void setSaltSize(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SALTSIZE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SALTSIZE$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSaltSize(STSaltSize paramSTSaltSize) {
    synchronized (monitor()) {
      check_orphaned();
      STSaltSize sTSaltSize = null;
      sTSaltSize = (STSaltSize)get_store().find_attribute_user(SALTSIZE$0);
      if (sTSaltSize == null)
        sTSaltSize = (STSaltSize)get_store().add_attribute_user(SALTSIZE$0); 
      sTSaltSize.set((XmlObject)paramSTSaltSize);
    } 
  }
  
  public int getBlockSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCKSIZE$2);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STBlockSize xgetBlockSize() {
    synchronized (monitor()) {
      check_orphaned();
      STBlockSize sTBlockSize = null;
      sTBlockSize = (STBlockSize)get_store().find_attribute_user(BLOCKSIZE$2);
      return sTBlockSize;
    } 
  }
  
  public void setBlockSize(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCKSIZE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BLOCKSIZE$2); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetBlockSize(STBlockSize paramSTBlockSize) {
    synchronized (monitor()) {
      check_orphaned();
      STBlockSize sTBlockSize = null;
      sTBlockSize = (STBlockSize)get_store().find_attribute_user(BLOCKSIZE$2);
      if (sTBlockSize == null)
        sTBlockSize = (STBlockSize)get_store().add_attribute_user(BLOCKSIZE$2); 
      sTBlockSize.set((XmlObject)paramSTBlockSize);
    } 
  }
  
  public long getKeyBits() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KEYBITS$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STKeyBits xgetKeyBits() {
    synchronized (monitor()) {
      check_orphaned();
      STKeyBits sTKeyBits = null;
      sTKeyBits = (STKeyBits)get_store().find_attribute_user(KEYBITS$4);
      return sTKeyBits;
    } 
  }
  
  public void setKeyBits(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KEYBITS$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(KEYBITS$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetKeyBits(STKeyBits paramSTKeyBits) {
    synchronized (monitor()) {
      check_orphaned();
      STKeyBits sTKeyBits = null;
      sTKeyBits = (STKeyBits)get_store().find_attribute_user(KEYBITS$4);
      if (sTKeyBits == null)
        sTKeyBits = (STKeyBits)get_store().add_attribute_user(KEYBITS$4); 
      sTKeyBits.set((XmlObject)paramSTKeyBits);
    } 
  }
  
  public int getHashSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASHSIZE$6);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STHashSize xgetHashSize() {
    synchronized (monitor()) {
      check_orphaned();
      STHashSize sTHashSize = null;
      sTHashSize = (STHashSize)get_store().find_attribute_user(HASHSIZE$6);
      return sTHashSize;
    } 
  }
  
  public void setHashSize(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASHSIZE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HASHSIZE$6); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetHashSize(STHashSize paramSTHashSize) {
    synchronized (monitor()) {
      check_orphaned();
      STHashSize sTHashSize = null;
      sTHashSize = (STHashSize)get_store().find_attribute_user(HASHSIZE$6);
      if (sTHashSize == null)
        sTHashSize = (STHashSize)get_store().add_attribute_user(HASHSIZE$6); 
      sTHashSize.set((XmlObject)paramSTHashSize);
    } 
  }
  
  public STCipherAlgorithm.Enum getCipherAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CIPHERALGORITHM$8);
      if (simpleValue == null)
        return null; 
      return (STCipherAlgorithm.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCipherAlgorithm xgetCipherAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      STCipherAlgorithm sTCipherAlgorithm = null;
      sTCipherAlgorithm = (STCipherAlgorithm)get_store().find_attribute_user(CIPHERALGORITHM$8);
      return sTCipherAlgorithm;
    } 
  }
  
  public void setCipherAlgorithm(STCipherAlgorithm.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CIPHERALGORITHM$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CIPHERALGORITHM$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCipherAlgorithm(STCipherAlgorithm paramSTCipherAlgorithm) {
    synchronized (monitor()) {
      check_orphaned();
      STCipherAlgorithm sTCipherAlgorithm = null;
      sTCipherAlgorithm = (STCipherAlgorithm)get_store().find_attribute_user(CIPHERALGORITHM$8);
      if (sTCipherAlgorithm == null)
        sTCipherAlgorithm = (STCipherAlgorithm)get_store().add_attribute_user(CIPHERALGORITHM$8); 
      sTCipherAlgorithm.set((XmlObject)paramSTCipherAlgorithm);
    } 
  }
  
  public STCipherChaining.Enum getCipherChaining() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CIPHERCHAINING$10);
      if (simpleValue == null)
        return null; 
      return (STCipherChaining.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCipherChaining xgetCipherChaining() {
    synchronized (monitor()) {
      check_orphaned();
      STCipherChaining sTCipherChaining = null;
      sTCipherChaining = (STCipherChaining)get_store().find_attribute_user(CIPHERCHAINING$10);
      return sTCipherChaining;
    } 
  }
  
  public void setCipherChaining(STCipherChaining.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CIPHERCHAINING$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CIPHERCHAINING$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCipherChaining(STCipherChaining paramSTCipherChaining) {
    synchronized (monitor()) {
      check_orphaned();
      STCipherChaining sTCipherChaining = null;
      sTCipherChaining = (STCipherChaining)get_store().find_attribute_user(CIPHERCHAINING$10);
      if (sTCipherChaining == null)
        sTCipherChaining = (STCipherChaining)get_store().add_attribute_user(CIPHERCHAINING$10); 
      sTCipherChaining.set((XmlObject)paramSTCipherChaining);
    } 
  }
  
  public STHashAlgorithm.Enum getHashAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASHALGORITHM$12);
      if (simpleValue == null)
        return null; 
      return (STHashAlgorithm.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHashAlgorithm xgetHashAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      STHashAlgorithm sTHashAlgorithm = null;
      sTHashAlgorithm = (STHashAlgorithm)get_store().find_attribute_user(HASHALGORITHM$12);
      return sTHashAlgorithm;
    } 
  }
  
  public void setHashAlgorithm(STHashAlgorithm.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASHALGORITHM$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HASHALGORITHM$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHashAlgorithm(STHashAlgorithm paramSTHashAlgorithm) {
    synchronized (monitor()) {
      check_orphaned();
      STHashAlgorithm sTHashAlgorithm = null;
      sTHashAlgorithm = (STHashAlgorithm)get_store().find_attribute_user(HASHALGORITHM$12);
      if (sTHashAlgorithm == null)
        sTHashAlgorithm = (STHashAlgorithm)get_store().add_attribute_user(HASHALGORITHM$12); 
      sTHashAlgorithm.set((XmlObject)paramSTHashAlgorithm);
    } 
  }
  
  public byte[] getSaltValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SALTVALUE$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetSaltValue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(SALTVALUE$14);
      return xmlBase64Binary;
    } 
  }
  
  public void setSaltValue(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SALTVALUE$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SALTVALUE$14); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetSaltValue(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(SALTVALUE$14);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(SALTVALUE$14); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\impl\CTKeyDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */