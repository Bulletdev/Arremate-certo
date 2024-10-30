package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class EncryptionDocumentImpl extends XmlComplexContentImpl implements EncryptionDocument {
  private static final b ENCRYPTION$0 = new b("http://schemas.microsoft.com/office/2006/encryption", "encryption");
  
  public EncryptionDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTEncryption getEncryption() {
    synchronized (monitor()) {
      check_orphaned();
      CTEncryption cTEncryption = null;
      cTEncryption = (CTEncryption)get_store().find_element_user(ENCRYPTION$0, 0);
      if (cTEncryption == null)
        return null; 
      return cTEncryption;
    } 
  }
  
  public void setEncryption(CTEncryption paramCTEncryption) {
    synchronized (monitor()) {
      check_orphaned();
      CTEncryption cTEncryption = null;
      cTEncryption = (CTEncryption)get_store().find_element_user(ENCRYPTION$0, 0);
      if (cTEncryption == null)
        cTEncryption = (CTEncryption)get_store().add_element_user(ENCRYPTION$0); 
      cTEncryption.set((XmlObject)paramCTEncryption);
    } 
  }
  
  public CTEncryption addNewEncryption() {
    synchronized (monitor()) {
      check_orphaned();
      CTEncryption cTEncryption = null;
      cTEncryption = (CTEncryption)get_store().add_element_user(ENCRYPTION$0);
      return cTEncryption;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\impl\EncryptionDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */