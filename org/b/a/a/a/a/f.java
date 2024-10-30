package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.f;
import org.b.a.a.a.j;
import org.f.a.a.a.k;

public class f extends XmlComplexContentImpl implements f {
  private static final b i = new b("http://uri.etsi.org/01903/v1.3.2#", "CertDigest");
  
  private static final b j = new b("http://uri.etsi.org/01903/v1.3.2#", "IssuerSerial");
  
  private static final b URI$4 = new b("", "URI");
  
  public f(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public j c() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().find_element_user(i, 0);
      if (j == null)
        return null; 
      return j;
    } 
  }
  
  public void b(j paramj) {
    synchronized (monitor()) {
      check_orphaned();
      j j1 = null;
      j1 = (j)get_store().find_element_user(i, 0);
      if (j1 == null)
        j1 = (j)get_store().add_element_user(i); 
      j1.set((XmlObject)paramj);
    } 
  }
  
  public j d() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().add_element_user(i);
      return j;
    } 
  }
  
  public k a() {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().find_element_user(j, 0);
      if (k == null)
        return null; 
      return k;
    } 
  }
  
  public void a(k paramk) {
    synchronized (monitor()) {
      check_orphaned();
      k k1 = null;
      k1 = (k)get_store().find_element_user(j, 0);
      if (k1 == null)
        k1 = (k)get_store().add_element_user(j); 
      k1.set((XmlObject)paramk);
    } 
  }
  
  public k b() {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().add_element_user(j);
      return k;
    } 
  }
  
  public String getURI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$4);
      return xmlAnyURI;
    } 
  }
  
  public boolean ew() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(URI$4) != null);
    } 
  }
  
  public void bj(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(URI$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void a(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$4);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(URI$4); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void hm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(URI$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */