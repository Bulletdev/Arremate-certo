package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.r;
import org.b.a.a.a.v;
import org.b.a.a.a.x;

public class r extends XmlComplexContentImpl implements r {
  private static final b E = new b("http://uri.etsi.org/01903/v1.3.2#", "SignedProperties");
  
  private static final b F = new b("http://uri.etsi.org/01903/v1.3.2#", "UnsignedProperties");
  
  private static final b TARGET$4 = new b("", "Target");
  
  private static final b ID$6 = new b("", "Id");
  
  public r(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public v a() {
    synchronized (monitor()) {
      check_orphaned();
      v v = null;
      v = (v)get_store().find_element_user(E, 0);
      if (v == null)
        return null; 
      return v;
    } 
  }
  
  public boolean eE() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(E) != 0);
    } 
  }
  
  public void a(v paramv) {
    synchronized (monitor()) {
      check_orphaned();
      v v1 = null;
      v1 = (v)get_store().find_element_user(E, 0);
      if (v1 == null)
        v1 = (v)get_store().add_element_user(E); 
      v1.set((XmlObject)paramv);
    } 
  }
  
  public v b() {
    synchronized (monitor()) {
      check_orphaned();
      v v = null;
      v = (v)get_store().add_element_user(E);
      return v;
    } 
  }
  
  public void hu() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(E, 0);
    } 
  }
  
  public x a() {
    synchronized (monitor()) {
      check_orphaned();
      x x = null;
      x = (x)get_store().find_element_user(F, 0);
      if (x == null)
        return null; 
      return x;
    } 
  }
  
  public boolean eF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(F) != 0);
    } 
  }
  
  public void a(x paramx) {
    synchronized (monitor()) {
      check_orphaned();
      x x1 = null;
      x1 = (x)get_store().find_element_user(F, 0);
      if (x1 == null)
        x1 = (x)get_store().add_element_user(F); 
      x1.set((XmlObject)paramx);
    } 
  }
  
  public x b() {
    synchronized (monitor()) {
      check_orphaned();
      x x = null;
      x = (x)get_store().add_element_user(F);
      return x;
    } 
  }
  
  public void hv() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(F, 0);
    } 
  }
  
  public String getTarget() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI xgetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TARGET$4);
      return xmlAnyURI;
    } 
  }
  
  public void setTarget(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TARGET$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTarget(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TARGET$4);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(TARGET$4); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
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


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */