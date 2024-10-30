package com.microsoft.schemas.office.x2006.keyEncryptor.certificate.impl;

import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTCertificateKeyEncryptorImpl extends XmlComplexContentImpl implements CTCertificateKeyEncryptor {
  private static final b ENCRYPTEDKEYVALUE$0 = new b("", "encryptedKeyValue");
  
  private static final b X509CERTIFICATE$2 = new b("", "X509Certificate");
  
  private static final b CERTVERIFIER$4 = new b("", "certVerifier");
  
  public CTCertificateKeyEncryptorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public byte[] getEncryptedKeyValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENCRYPTEDKEYVALUE$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetEncryptedKeyValue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(ENCRYPTEDKEYVALUE$0);
      return xmlBase64Binary;
    } 
  }
  
  public void setEncryptedKeyValue(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENCRYPTEDKEYVALUE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENCRYPTEDKEYVALUE$0); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetEncryptedKeyValue(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(ENCRYPTEDKEYVALUE$0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(ENCRYPTEDKEYVALUE$0); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public byte[] getX509Certificate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X509CERTIFICATE$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetX509Certificate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(X509CERTIFICATE$2);
      return xmlBase64Binary;
    } 
  }
  
  public void setX509Certificate(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X509CERTIFICATE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(X509CERTIFICATE$2); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetX509Certificate(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(X509CERTIFICATE$2);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(X509CERTIFICATE$2); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public byte[] getCertVerifier() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CERTVERIFIER$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetCertVerifier() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(CERTVERIFIER$4);
      return xmlBase64Binary;
    } 
  }
  
  public void setCertVerifier(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CERTVERIFIER$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CERTVERIFIER$4); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetCertVerifier(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(CERTVERIFIER$4);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(CERTVERIFIER$4); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\keyEncryptor\certificate\impl\CTCertificateKeyEncryptorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */