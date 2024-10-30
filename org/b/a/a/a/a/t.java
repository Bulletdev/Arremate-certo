package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.d;
import org.b.a.a.a.p;
import org.b.a.a.a.t;
import org.etsi.uri.x01903.v13.OtherCertStatusValuesType;

public class t extends XmlComplexContentImpl implements t {
  private static final b I = new b("http://uri.etsi.org/01903/v1.3.2#", "CRLValues");
  
  private static final b J = new b("http://uri.etsi.org/01903/v1.3.2#", "OCSPValues");
  
  private static final b K = new b("http://uri.etsi.org/01903/v1.3.2#", "OtherValues");
  
  private static final b ID$6 = new b("", "Id");
  
  public t(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public d b() {
    synchronized (monitor()) {
      check_orphaned();
      d d = null;
      d = (d)get_store().find_element_user(I, 0);
      if (d == null)
        return null; 
      return d;
    } 
  }
  
  public boolean eI() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(I) != 0);
    } 
  }
  
  public void a(d paramd) {
    synchronized (monitor()) {
      check_orphaned();
      d d1 = null;
      d1 = (d)get_store().find_element_user(I, 0);
      if (d1 == null)
        d1 = (d)get_store().add_element_user(I); 
      d1.set((XmlObject)paramd);
    } 
  }
  
  public d c() {
    synchronized (monitor()) {
      check_orphaned();
      d d = null;
      d = (d)get_store().add_element_user(I);
      return d;
    } 
  }
  
  public void hy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I, 0);
    } 
  }
  
  public p b() {
    synchronized (monitor()) {
      check_orphaned();
      p p = null;
      p = (p)get_store().find_element_user(J, 0);
      if (p == null)
        return null; 
      return p;
    } 
  }
  
  public boolean eJ() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(J) != 0);
    } 
  }
  
  public void a(p paramp) {
    synchronized (monitor()) {
      check_orphaned();
      p p1 = null;
      p1 = (p)get_store().find_element_user(J, 0);
      if (p1 == null)
        p1 = (p)get_store().add_element_user(J); 
      p1.set((XmlObject)paramp);
    } 
  }
  
  public p c() {
    synchronized (monitor()) {
      check_orphaned();
      p p = null;
      p = (p)get_store().add_element_user(J);
      return p;
    } 
  }
  
  public void hz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(J, 0);
    } 
  }
  
  public OtherCertStatusValuesType a() {
    synchronized (monitor()) {
      check_orphaned();
      OtherCertStatusValuesType otherCertStatusValuesType = null;
      otherCertStatusValuesType = (OtherCertStatusValuesType)get_store().find_element_user(K, 0);
      if (otherCertStatusValuesType == null)
        return null; 
      return otherCertStatusValuesType;
    } 
  }
  
  public boolean eK() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(K) != 0);
    } 
  }
  
  public void a(OtherCertStatusValuesType paramOtherCertStatusValuesType) {
    synchronized (monitor()) {
      check_orphaned();
      OtherCertStatusValuesType otherCertStatusValuesType = null;
      otherCertStatusValuesType = (OtherCertStatusValuesType)get_store().find_element_user(K, 0);
      if (otherCertStatusValuesType == null)
        otherCertStatusValuesType = (OtherCertStatusValuesType)get_store().add_element_user(K); 
      otherCertStatusValuesType.set((XmlObject)paramOtherCertStatusValuesType);
    } 
  }
  
  public OtherCertStatusValuesType b() {
    synchronized (monitor()) {
      check_orphaned();
      OtherCertStatusValuesType otherCertStatusValuesType = null;
      otherCertStatusValuesType = (OtherCertStatusValuesType)get_store().add_element_user(K);
      return otherCertStatusValuesType;
    } 
  }
  
  public void hA() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(K, 0);
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


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */