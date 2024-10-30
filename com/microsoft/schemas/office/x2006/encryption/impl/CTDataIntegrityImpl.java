package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTDataIntegrityImpl extends XmlComplexContentImpl implements CTDataIntegrity {
  private static final b ENCRYPTEDHMACKEY$0 = new b("", "encryptedHmacKey");
  
  private static final b ENCRYPTEDHMACVALUE$2 = new b("", "encryptedHmacValue");
  
  public CTDataIntegrityImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public byte[] getEncryptedHmacKey() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetEncryptedHmacKey() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
      return xmlBase64Binary;
    } 
  }
  
  public void setEncryptedHmacKey(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENCRYPTEDHMACKEY$0); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetEncryptedHmacKey(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(ENCRYPTEDHMACKEY$0); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public byte[] getEncryptedHmacValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetEncryptedHmacValue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
      return xmlBase64Binary;
    } 
  }
  
  public void setEncryptedHmacValue(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENCRYPTEDHMACVALUE$2); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetEncryptedHmacValue(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(ENCRYPTEDHMACVALUE$2); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\impl\CTDataIntegrityImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */