package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTKeyEncryptorImpl extends XmlComplexContentImpl implements CTKeyEncryptor {
  private static final b ENCRYPTEDPASSWORDKEY$0 = new b("http://schemas.microsoft.com/office/2006/keyEncryptor/password", "encryptedKey");
  
  private static final b ENCRYPTEDCERTIFICATEKEY$2 = new b("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate", "encryptedKey");
  
  private static final b URI$4 = new b("", "uri");
  
  public CTKeyEncryptorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPasswordKeyEncryptor getEncryptedPasswordKey() {
    synchronized (monitor()) {
      check_orphaned();
      CTPasswordKeyEncryptor cTPasswordKeyEncryptor = null;
      cTPasswordKeyEncryptor = (CTPasswordKeyEncryptor)get_store().find_element_user(ENCRYPTEDPASSWORDKEY$0, 0);
      if (cTPasswordKeyEncryptor == null)
        return null; 
      return cTPasswordKeyEncryptor;
    } 
  }
  
  public boolean isSetEncryptedPasswordKey() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ENCRYPTEDPASSWORDKEY$0) != 0);
    } 
  }
  
  public void setEncryptedPasswordKey(CTPasswordKeyEncryptor paramCTPasswordKeyEncryptor) {
    synchronized (monitor()) {
      check_orphaned();
      CTPasswordKeyEncryptor cTPasswordKeyEncryptor = null;
      cTPasswordKeyEncryptor = (CTPasswordKeyEncryptor)get_store().find_element_user(ENCRYPTEDPASSWORDKEY$0, 0);
      if (cTPasswordKeyEncryptor == null)
        cTPasswordKeyEncryptor = (CTPasswordKeyEncryptor)get_store().add_element_user(ENCRYPTEDPASSWORDKEY$0); 
      cTPasswordKeyEncryptor.set((XmlObject)paramCTPasswordKeyEncryptor);
    } 
  }
  
  public CTPasswordKeyEncryptor addNewEncryptedPasswordKey() {
    synchronized (monitor()) {
      check_orphaned();
      CTPasswordKeyEncryptor cTPasswordKeyEncryptor = null;
      cTPasswordKeyEncryptor = (CTPasswordKeyEncryptor)get_store().add_element_user(ENCRYPTEDPASSWORDKEY$0);
      return cTPasswordKeyEncryptor;
    } 
  }
  
  public void unsetEncryptedPasswordKey() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENCRYPTEDPASSWORDKEY$0, 0);
    } 
  }
  
  public CTCertificateKeyEncryptor getEncryptedCertificateKey() {
    synchronized (monitor()) {
      check_orphaned();
      CTCertificateKeyEncryptor cTCertificateKeyEncryptor = null;
      cTCertificateKeyEncryptor = (CTCertificateKeyEncryptor)get_store().find_element_user(ENCRYPTEDCERTIFICATEKEY$2, 0);
      if (cTCertificateKeyEncryptor == null)
        return null; 
      return cTCertificateKeyEncryptor;
    } 
  }
  
  public boolean isSetEncryptedCertificateKey() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ENCRYPTEDCERTIFICATEKEY$2) != 0);
    } 
  }
  
  public void setEncryptedCertificateKey(CTCertificateKeyEncryptor paramCTCertificateKeyEncryptor) {
    synchronized (monitor()) {
      check_orphaned();
      CTCertificateKeyEncryptor cTCertificateKeyEncryptor = null;
      cTCertificateKeyEncryptor = (CTCertificateKeyEncryptor)get_store().find_element_user(ENCRYPTEDCERTIFICATEKEY$2, 0);
      if (cTCertificateKeyEncryptor == null)
        cTCertificateKeyEncryptor = (CTCertificateKeyEncryptor)get_store().add_element_user(ENCRYPTEDCERTIFICATEKEY$2); 
      cTCertificateKeyEncryptor.set((XmlObject)paramCTCertificateKeyEncryptor);
    } 
  }
  
  public CTCertificateKeyEncryptor addNewEncryptedCertificateKey() {
    synchronized (monitor()) {
      check_orphaned();
      CTCertificateKeyEncryptor cTCertificateKeyEncryptor = null;
      cTCertificateKeyEncryptor = (CTCertificateKeyEncryptor)get_store().add_element_user(ENCRYPTEDCERTIFICATEKEY$2);
      return cTCertificateKeyEncryptor;
    } 
  }
  
  public void unsetEncryptedCertificateKey() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENCRYPTEDCERTIFICATEKEY$2, 0);
    } 
  }
  
  public CTKeyEncryptor.Uri.Enum getUri() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$4);
      if (simpleValue == null)
        return null; 
      return (CTKeyEncryptor.Uri.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public CTKeyEncryptor.Uri xgetUri() {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptor.Uri uri = null;
      uri = (CTKeyEncryptor.Uri)get_store().find_attribute_user(URI$4);
      return uri;
    } 
  }
  
  public boolean isSetUri() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(URI$4) != null);
    } 
  }
  
  public void setUri(CTKeyEncryptor.Uri.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(URI$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUri(CTKeyEncryptor.Uri paramUri) {
    synchronized (monitor()) {
      check_orphaned();
      CTKeyEncryptor.Uri uri = null;
      uri = (CTKeyEncryptor.Uri)get_store().find_attribute_user(URI$4);
      if (uri == null)
        uri = (CTKeyEncryptor.Uri)get_store().add_attribute_user(URI$4); 
      uri.set((XmlObject)paramUri);
    } 
  }
  
  public void unsetUri() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(URI$4);
    } 
  }
  
  public static class UriImpl extends JavaStringEnumerationHolderEx implements CTKeyEncryptor.Uri {
    public UriImpl(SchemaType param1SchemaType) {
      super(param1SchemaType, false);
    }
    
    protected UriImpl(SchemaType param1SchemaType, boolean param1Boolean) {
      super(param1SchemaType, param1Boolean);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\impl\CTKeyEncryptorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */