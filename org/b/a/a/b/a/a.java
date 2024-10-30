package org.b.a.a.b.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.g;
import org.b.a.a.a.t;
import org.b.a.a.b.a;

public class a extends XmlComplexContentImpl implements a {
  private static final b ak = new b("http://uri.etsi.org/01903/v1.3.2#", "CertificateValues");
  
  private static final b al = new b("http://uri.etsi.org/01903/v1.3.2#", "RevocationValues");
  
  private static final b ID$4 = new b("", "Id");
  
  private static final b URI$6 = new b("", "URI");
  
  public a(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public g d() {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().find_element_user(ak, 0);
      if (g == null)
        return null; 
      return g;
    } 
  }
  
  public boolean eW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ak) != 0);
    } 
  }
  
  public void a(g paramg) {
    synchronized (monitor()) {
      check_orphaned();
      g g1 = null;
      g1 = (g)get_store().find_element_user(ak, 0);
      if (g1 == null)
        g1 = (g)get_store().add_element_user(ak); 
      g1.set((XmlObject)paramg);
    } 
  }
  
  public g b() {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().add_element_user(ak);
      return g;
    } 
  }
  
  public void hM() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ak, 0);
    } 
  }
  
  public t d() {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().find_element_user(al, 0);
      if (t == null)
        return null; 
      return t;
    } 
  }
  
  public boolean eX() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(al) != 0);
    } 
  }
  
  public void a(t paramt) {
    synchronized (monitor()) {
      check_orphaned();
      t t1 = null;
      t1 = (t)get_store().find_element_user(al, 0);
      if (t1 == null)
        t1 = (t)get_store().add_element_user(al); 
      t1.set((XmlObject)paramt);
    } 
  }
  
  public t b() {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().add_element_user(al);
      return t;
    } 
  }
  
  public void hN() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(al, 0);
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
  
  public String getURI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$6);
      return xmlAnyURI;
    } 
  }
  
  public boolean ew() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(URI$6) != null);
    } 
  }
  
  public void bj(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(URI$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void a(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$6);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(URI$6); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void hm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(URI$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */