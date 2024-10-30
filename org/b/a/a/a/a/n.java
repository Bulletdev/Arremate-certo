package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.j;
import org.b.a.a.a.m;
import org.b.a.a.a.n;

public class n extends XmlComplexContentImpl implements n {
  private static final b z = new b("http://uri.etsi.org/01903/v1.3.2#", "OCSPIdentifier");
  
  private static final b A = new b("http://uri.etsi.org/01903/v1.3.2#", "DigestAlgAndValue");
  
  public n(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public m b() {
    synchronized (monitor()) {
      check_orphaned();
      m m = null;
      m = (m)get_store().find_element_user(z, 0);
      if (m == null)
        return null; 
      return m;
    } 
  }
  
  public void a(m paramm) {
    synchronized (monitor()) {
      check_orphaned();
      m m1 = null;
      m1 = (m)get_store().find_element_user(z, 0);
      if (m1 == null)
        m1 = (m)get_store().add_element_user(z); 
      m1.set((XmlObject)paramm);
    } 
  }
  
  public m c() {
    synchronized (monitor()) {
      check_orphaned();
      m m = null;
      m = (m)get_store().add_element_user(z);
      return m;
    } 
  }
  
  public j a() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().find_element_user(A, 0);
      if (j == null)
        return null; 
      return j;
    } 
  }
  
  public boolean eD() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(A) != 0);
    } 
  }
  
  public void a(j paramj) {
    synchronized (monitor()) {
      check_orphaned();
      j j1 = null;
      j1 = (j)get_store().find_element_user(A, 0);
      if (j1 == null)
        j1 = (j)get_store().add_element_user(A); 
      j1.set((XmlObject)paramj);
    } 
  }
  
  public j b() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().add_element_user(A);
      return j;
    } 
  }
  
  public void ht() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(A, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */