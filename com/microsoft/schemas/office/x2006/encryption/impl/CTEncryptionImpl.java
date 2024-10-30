package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTEncryptionImpl extends XmlComplexContentImpl implements CTEncryption {
  private static final b KEYDATA$0 = new b("http://schemas.microsoft.com/office/2006/encryption", "keyData");
  
  private static final b DATAINTEGRITY$2 = new b("http://schemas.microsoft.com/office/2006/encryption", "dataIntegrity");
  
  private static final b KEYENCRYPTORS$4 = new b("http://schemas.microsoft.com/office/2006/encryption", "keyEncryptors");
  
  public CTEncryptionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTKeyData getKeyData() {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyData cTKeyData = null;
      cTKeyData = (CTKeyData)get_store().find_element_user(KEYDATA$0, 0);
      if (cTKeyData == null)
        return null; 
      return cTKeyData;
    } 
  }
  
  public void setKeyData(CTKeyData paramCTKeyData) {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyData cTKeyData = null;
      cTKeyData = (CTKeyData)get_store().find_element_user(KEYDATA$0, 0);
      if (cTKeyData == null)
        cTKeyData = (CTKeyData)get_store().add_element_user(KEYDATA$0); 
      cTKeyData.set((XmlObject)paramCTKeyData);
    } 
  }
  
  public CTKeyData addNewKeyData() {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyData cTKeyData = null;
      cTKeyData = (CTKeyData)get_store().add_element_user(KEYDATA$0);
      return cTKeyData;
    } 
  }
  
  public CTDataIntegrity getDataIntegrity() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataIntegrity cTDataIntegrity = null;
      cTDataIntegrity = (CTDataIntegrity)get_store().find_element_user(DATAINTEGRITY$2, 0);
      if (cTDataIntegrity == null)
        return null; 
      return cTDataIntegrity;
    } 
  }
  
  public void setDataIntegrity(CTDataIntegrity paramCTDataIntegrity) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataIntegrity cTDataIntegrity = null;
      cTDataIntegrity = (CTDataIntegrity)get_store().find_element_user(DATAINTEGRITY$2, 0);
      if (cTDataIntegrity == null)
        cTDataIntegrity = (CTDataIntegrity)get_store().add_element_user(DATAINTEGRITY$2); 
      cTDataIntegrity.set((XmlObject)paramCTDataIntegrity);
    } 
  }
  
  public CTDataIntegrity addNewDataIntegrity() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataIntegrity cTDataIntegrity = null;
      cTDataIntegrity = (CTDataIntegrity)get_store().add_element_user(DATAINTEGRITY$2);
      return cTDataIntegrity;
    } 
  }
  
  public CTKeyEncryptors getKeyEncryptors() {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptors cTKeyEncryptors = null;
      cTKeyEncryptors = (CTKeyEncryptors)get_store().find_element_user(KEYENCRYPTORS$4, 0);
      if (cTKeyEncryptors == null)
        return null; 
      return cTKeyEncryptors;
    } 
  }
  
  public void setKeyEncryptors(CTKeyEncryptors paramCTKeyEncryptors) {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptors cTKeyEncryptors = null;
      cTKeyEncryptors = (CTKeyEncryptors)get_store().find_element_user(KEYENCRYPTORS$4, 0);
      if (cTKeyEncryptors == null)
        cTKeyEncryptors = (CTKeyEncryptors)get_store().add_element_user(KEYENCRYPTORS$4); 
      cTKeyEncryptors.set((XmlObject)paramCTKeyEncryptors);
    } 
  }
  
  public CTKeyEncryptors addNewKeyEncryptors() {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptors cTKeyEncryptors = null;
      cTKeyEncryptors = (CTKeyEncryptors)get_store().add_element_user(KEYENCRYPTORS$4);
      return cTKeyEncryptors;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\impl\CTEncryptionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */