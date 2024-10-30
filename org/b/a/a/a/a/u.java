package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.u;
import org.etsi.uri.x01903.v13.SignaturePolicyIdType;

public class u extends XmlComplexContentImpl implements u {
  private static final b L = new b("http://uri.etsi.org/01903/v1.3.2#", "SignaturePolicyId");
  
  private static final b M = new b("http://uri.etsi.org/01903/v1.3.2#", "SignaturePolicyImplied");
  
  public u(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public SignaturePolicyIdType a() {
    synchronized (monitor()) {
      check_orphaned();
      SignaturePolicyIdType signaturePolicyIdType = null;
      signaturePolicyIdType = (SignaturePolicyIdType)get_store().find_element_user(L, 0);
      if (signaturePolicyIdType == null)
        return null; 
      return signaturePolicyIdType;
    } 
  }
  
  public boolean eL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(L) != 0);
    } 
  }
  
  public void a(SignaturePolicyIdType paramSignaturePolicyIdType) {
    synchronized (monitor()) {
      check_orphaned();
      SignaturePolicyIdType signaturePolicyIdType = null;
      signaturePolicyIdType = (SignaturePolicyIdType)get_store().find_element_user(L, 0);
      if (signaturePolicyIdType == null)
        signaturePolicyIdType = (SignaturePolicyIdType)get_store().add_element_user(L); 
      signaturePolicyIdType.set((XmlObject)paramSignaturePolicyIdType);
    } 
  }
  
  public SignaturePolicyIdType b() {
    synchronized (monitor()) {
      check_orphaned();
      SignaturePolicyIdType signaturePolicyIdType = null;
      signaturePolicyIdType = (SignaturePolicyIdType)get_store().add_element_user(L);
      return signaturePolicyIdType;
    } 
  }
  
  public void hB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(L, 0);
    } 
  }
  
  public XmlObject a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlObject xmlObject = null;
      xmlObject = (XmlObject)get_store().find_element_user(M, 0);
      if (xmlObject == null)
        return null; 
      return xmlObject;
    } 
  }
  
  public boolean eM() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(M) != 0);
    } 
  }
  
  public void a(XmlObject paramXmlObject) {
    synchronized (monitor()) {
      check_orphaned();
      XmlObject xmlObject = null;
      xmlObject = (XmlObject)get_store().find_element_user(M, 0);
      if (xmlObject == null)
        xmlObject = (XmlObject)get_store().add_element_user(M); 
      xmlObject.set(paramXmlObject);
    } 
  }
  
  public XmlObject b() {
    synchronized (monitor()) {
      check_orphaned();
      XmlObject xmlObject = null;
      xmlObject = (XmlObject)get_store().add_element_user(M);
      return xmlObject;
    } 
  }
  
  public void hC() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(M, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */