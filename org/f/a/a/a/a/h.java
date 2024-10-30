package org.f.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.a;
import org.f.a.a.a.e;
import org.f.a.a.a.h;
import org.w3.x2000.x09.xmldsig.SignatureMethodType;
import org.w3.x2000.x09.xmldsig.impl.SignedInfoTypeImpl;

public class h extends XmlComplexContentImpl implements h {
  private static final b ay = new b("http://www.w3.org/2000/09/xmldsig#", "CanonicalizationMethod");
  
  private static final b az = new b("http://www.w3.org/2000/09/xmldsig#", "SignatureMethod");
  
  private static final b aA = new b("http://www.w3.org/2000/09/xmldsig#", "Reference");
  
  private static final b ID$6 = new b("", "Id");
  
  public h(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public a a() {
    synchronized (monitor()) {
      check_orphaned();
      a a = null;
      a = (a)get_store().find_element_user(ay, 0);
      if (a == null)
        return null; 
      return a;
    } 
  }
  
  public void a(a parama) {
    synchronized (monitor()) {
      check_orphaned();
      a a1 = null;
      a1 = (a)get_store().find_element_user(ay, 0);
      if (a1 == null)
        a1 = (a)get_store().add_element_user(ay); 
      a1.set((XmlObject)parama);
    } 
  }
  
  public a b() {
    synchronized (monitor()) {
      check_orphaned();
      a a = null;
      a = (a)get_store().add_element_user(ay);
      return a;
    } 
  }
  
  public SignatureMethodType a() {
    synchronized (monitor()) {
      check_orphaned();
      SignatureMethodType signatureMethodType = null;
      signatureMethodType = (SignatureMethodType)get_store().find_element_user(az, 0);
      if (signatureMethodType == null)
        return null; 
      return signatureMethodType;
    } 
  }
  
  public void a(SignatureMethodType paramSignatureMethodType) {
    synchronized (monitor()) {
      check_orphaned();
      SignatureMethodType signatureMethodType = null;
      signatureMethodType = (SignatureMethodType)get_store().find_element_user(az, 0);
      if (signatureMethodType == null)
        signatureMethodType = (SignatureMethodType)get_store().add_element_user(az); 
      signatureMethodType.set((XmlObject)paramSignatureMethodType);
    } 
  }
  
  public SignatureMethodType b() {
    synchronized (monitor()) {
      check_orphaned();
      SignatureMethodType signatureMethodType = null;
      signatureMethodType = (SignatureMethodType)get_store().add_element_user(az);
      return signatureMethodType;
    } 
  }
  
  public List<e> bD() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<e>)new SignedInfoTypeImpl.ReferenceList((SignedInfoTypeImpl)this);
    } 
  }
  
  public e[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(aA, arrayList);
      e[] arrayOfE = new e[arrayList.size()];
      arrayList.toArray((Object[])arrayOfE);
      return arrayOfE;
    } 
  }
  
  public e a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      e e = null;
      e = (e)get_store().find_element_user(aA, paramInt);
      if (e == null)
        throw new IndexOutOfBoundsException(); 
      return e;
    } 
  }
  
  public int cj() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(aA);
    } 
  }
  
  public void a(e[] paramArrayOfe) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfe, aA);
    } 
  }
  
  public void a(int paramInt, e parame) {
    synchronized (monitor()) {
      check_orphaned();
      e e1 = null;
      e1 = (e)get_store().find_element_user(aA, paramInt);
      if (e1 == null)
        throw new IndexOutOfBoundsException(); 
      e1.set((XmlObject)parame);
    } 
  }
  
  public e b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      e e = null;
      e = (e)get_store().insert_element_user(aA, paramInt);
      return e;
    } 
  }
  
  public e b() {
    synchronized (monitor()) {
      check_orphaned();
      e e = null;
      e = (e)get_store().add_element_user(aA);
      return e;
    } 
  }
  
  public void bA(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(aA, paramInt);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$6);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$6) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$6);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$6); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */