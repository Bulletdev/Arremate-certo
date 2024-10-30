package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTKeyEncryptorsImpl extends XmlComplexContentImpl implements CTKeyEncryptors {
  private static final b KEYENCRYPTOR$0 = new b("http://schemas.microsoft.com/office/2006/encryption", "keyEncryptor");
  
  public CTKeyEncryptorsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTKeyEncryptor> getKeyEncryptorList() {
    synchronized (monitor()) {
      check_orphaned();
      final class KeyEncryptorList extends AbstractList<CTKeyEncryptor> {
        public CTKeyEncryptor get(int param1Int) {
          return CTKeyEncryptorsImpl.this.getKeyEncryptorArray(param1Int);
        }
        
        public CTKeyEncryptor set(int param1Int, CTKeyEncryptor param1CTKeyEncryptor) {
          CTKeyEncryptor cTKeyEncryptor = CTKeyEncryptorsImpl.this.getKeyEncryptorArray(param1Int);
          CTKeyEncryptorsImpl.this.setKeyEncryptorArray(param1Int, param1CTKeyEncryptor);
          return cTKeyEncryptor;
        }
        
        public void add(int param1Int, CTKeyEncryptor param1CTKeyEncryptor) {
          CTKeyEncryptorsImpl.this.insertNewKeyEncryptor(param1Int).set((XmlObject)param1CTKeyEncryptor);
        }
        
        public CTKeyEncryptor remove(int param1Int) {
          CTKeyEncryptor cTKeyEncryptor = CTKeyEncryptorsImpl.this.getKeyEncryptorArray(param1Int);
          CTKeyEncryptorsImpl.this.removeKeyEncryptor(param1Int);
          return cTKeyEncryptor;
        }
        
        public int size() {
          return CTKeyEncryptorsImpl.this.sizeOfKeyEncryptorArray();
        }
      };
      return new KeyEncryptorList();
    } 
  }
  
  public CTKeyEncryptor[] getKeyEncryptorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(KEYENCRYPTOR$0, arrayList);
      CTKeyEncryptor[] arrayOfCTKeyEncryptor = new CTKeyEncryptor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTKeyEncryptor);
      return arrayOfCTKeyEncryptor;
    } 
  }
  
  public CTKeyEncryptor getKeyEncryptorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptor cTKeyEncryptor = null;
      cTKeyEncryptor = (CTKeyEncryptor)get_store().find_element_user(KEYENCRYPTOR$0, paramInt);
      if (cTKeyEncryptor == null)
        throw new IndexOutOfBoundsException(); 
      return cTKeyEncryptor;
    } 
  }
  
  public int sizeOfKeyEncryptorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(KEYENCRYPTOR$0);
    } 
  }
  
  public void setKeyEncryptorArray(CTKeyEncryptor[] paramArrayOfCTKeyEncryptor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTKeyEncryptor, KEYENCRYPTOR$0);
    } 
  }
  
  public void setKeyEncryptorArray(int paramInt, CTKeyEncryptor paramCTKeyEncryptor) {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptor cTKeyEncryptor = null;
      cTKeyEncryptor = (CTKeyEncryptor)get_store().find_element_user(KEYENCRYPTOR$0, paramInt);
      if (cTKeyEncryptor == null)
        throw new IndexOutOfBoundsException(); 
      cTKeyEncryptor.set((XmlObject)paramCTKeyEncryptor);
    } 
  }
  
  public CTKeyEncryptor insertNewKeyEncryptor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptor cTKeyEncryptor = null;
      cTKeyEncryptor = (CTKeyEncryptor)get_store().insert_element_user(KEYENCRYPTOR$0, paramInt);
      return cTKeyEncryptor;
    } 
  }
  
  public CTKeyEncryptor addNewKeyEncryptor() {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptor cTKeyEncryptor = null;
      cTKeyEncryptor = (CTKeyEncryptor)get_store().add_element_user(KEYENCRYPTOR$0);
      return cTKeyEncryptor;
    } 
  }
  
  public void removeKeyEncryptor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KEYENCRYPTOR$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\impl\CTKeyEncryptorsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */