package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.g;
import org.b.a.a.a.k;
import org.etsi.uri.x01903.v13.AnyType;
import org.etsi.uri.x01903.v13.impl.CertificateValuesTypeImpl;

public class g extends XmlComplexContentImpl implements g {
  private static final b k = new b("http://uri.etsi.org/01903/v1.3.2#", "EncapsulatedX509Certificate");
  
  private static final b l = new b("http://uri.etsi.org/01903/v1.3.2#", "OtherCertificate");
  
  private static final b ID$4 = new b("", "Id");
  
  public g(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<k> al() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<k>)new CertificateValuesTypeImpl.EncapsulatedX509CertificateList((CertificateValuesTypeImpl)this);
    } 
  }
  
  public k[] b() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(k, arrayList);
      k[] arrayOfK = new k[arrayList.size()];
      arrayList.toArray((Object[])arrayOfK);
      return arrayOfK;
    } 
  }
  
  public k c(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().find_element_user(k, paramInt);
      if (k == null)
        throw new IndexOutOfBoundsException(); 
      return k;
    } 
  }
  
  public int bq() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(k);
    } 
  }
  
  public void b(k[] paramArrayOfk) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfk, k);
    } 
  }
  
  public void b(int paramInt, k paramk) {
    synchronized (monitor()) {
      check_orphaned();
      k k1 = null;
      k1 = (k)get_store().find_element_user(k, paramInt);
      if (k1 == null)
        throw new IndexOutOfBoundsException(); 
      k1.set((XmlObject)paramk);
    } 
  }
  
  public k d(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().insert_element_user(k, paramInt);
      return k;
    } 
  }
  
  public k b() {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().add_element_user(k);
      return k;
    } 
  }
  
  public void aX(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(k, paramInt);
    } 
  }
  
  public List<AnyType> am() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<AnyType>)new CertificateValuesTypeImpl.OtherCertificateList((CertificateValuesTypeImpl)this);
    } 
  }
  
  public AnyType[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(l, arrayList);
      AnyType[] arrayOfAnyType = new AnyType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfAnyType);
      return arrayOfAnyType;
    } 
  }
  
  public AnyType a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().find_element_user(l, paramInt);
      if (anyType == null)
        throw new IndexOutOfBoundsException(); 
      return anyType;
    } 
  }
  
  public int br() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(l);
    } 
  }
  
  public void a(AnyType[] paramArrayOfAnyType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfAnyType, l);
    } 
  }
  
  public void a(int paramInt, AnyType paramAnyType) {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().find_element_user(l, paramInt);
      if (anyType == null)
        throw new IndexOutOfBoundsException(); 
      anyType.set((XmlObject)paramAnyType);
    } 
  }
  
  public AnyType b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().insert_element_user(l, paramInt);
      return anyType;
    } 
  }
  
  public AnyType a() {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().add_element_user(l);
      return anyType;
    } 
  }
  
  public void aY(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(l, paramInt);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$4);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$4) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$4);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$4); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */