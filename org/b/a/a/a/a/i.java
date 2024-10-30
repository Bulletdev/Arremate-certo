package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.c;
import org.b.a.a.a.i;
import org.b.a.a.a.o;
import org.etsi.uri.x01903.v13.OtherCertStatusRefsType;

public class i extends XmlComplexContentImpl implements i {
  private static final b n = new b("http://uri.etsi.org/01903/v1.3.2#", "CRLRefs");
  
  private static final b o = new b("http://uri.etsi.org/01903/v1.3.2#", "OCSPRefs");
  
  private static final b p = new b("http://uri.etsi.org/01903/v1.3.2#", "OtherRefs");
  
  private static final b ID$6 = new b("", "Id");
  
  public i(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public c b() {
    synchronized (monitor()) {
      check_orphaned();
      c c = null;
      c = (c)get_store().find_element_user(n, 0);
      if (c == null)
        return null; 
      return c;
    } 
  }
  
  public boolean ey() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(n) != 0);
    } 
  }
  
  public void a(c paramc) {
    synchronized (monitor()) {
      check_orphaned();
      c c1 = null;
      c1 = (c)get_store().find_element_user(n, 0);
      if (c1 == null)
        c1 = (c)get_store().add_element_user(n); 
      c1.set((XmlObject)paramc);
    } 
  }
  
  public c c() {
    synchronized (monitor()) {
      check_orphaned();
      c c = null;
      c = (c)get_store().add_element_user(n);
      return c;
    } 
  }
  
  public void ho() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(n, 0);
    } 
  }
  
  public o a() {
    synchronized (monitor()) {
      check_orphaned();
      o o = null;
      o = (o)get_store().find_element_user(o, 0);
      if (o == null)
        return null; 
      return o;
    } 
  }
  
  public boolean ez() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(o) != 0);
    } 
  }
  
  public void a(o paramo) {
    synchronized (monitor()) {
      check_orphaned();
      o o1 = null;
      o1 = (o)get_store().find_element_user(o, 0);
      if (o1 == null)
        o1 = (o)get_store().add_element_user(o); 
      o1.set((XmlObject)paramo);
    } 
  }
  
  public o b() {
    synchronized (monitor()) {
      check_orphaned();
      o o = null;
      o = (o)get_store().add_element_user(o);
      return o;
    } 
  }
  
  public void hp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(o, 0);
    } 
  }
  
  public OtherCertStatusRefsType a() {
    synchronized (monitor()) {
      check_orphaned();
      OtherCertStatusRefsType otherCertStatusRefsType = null;
      otherCertStatusRefsType = (OtherCertStatusRefsType)get_store().find_element_user(p, 0);
      if (otherCertStatusRefsType == null)
        return null; 
      return otherCertStatusRefsType;
    } 
  }
  
  public boolean eA() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(p) != 0);
    } 
  }
  
  public void a(OtherCertStatusRefsType paramOtherCertStatusRefsType) {
    synchronized (monitor()) {
      check_orphaned();
      OtherCertStatusRefsType otherCertStatusRefsType = null;
      otherCertStatusRefsType = (OtherCertStatusRefsType)get_store().find_element_user(p, 0);
      if (otherCertStatusRefsType == null)
        otherCertStatusRefsType = (OtherCertStatusRefsType)get_store().add_element_user(p); 
      otherCertStatusRefsType.set((XmlObject)paramOtherCertStatusRefsType);
    } 
  }
  
  public OtherCertStatusRefsType b() {
    synchronized (monitor()) {
      check_orphaned();
      OtherCertStatusRefsType otherCertStatusRefsType = null;
      otherCertStatusRefsType = (OtherCertStatusRefsType)get_store().add_element_user(p);
      return otherCertStatusRefsType;
    } 
  }
  
  public void hq() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(p, 0);
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


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */