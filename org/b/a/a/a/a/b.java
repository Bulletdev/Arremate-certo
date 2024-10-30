package org.b.a.a.a.a;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.a;
import org.b.a.a.a.b;
import org.b.a.a.a.j;

public class b extends XmlComplexContentImpl implements b {
  private static final javax.xml.namespace.b d = new javax.xml.namespace.b("http://uri.etsi.org/01903/v1.3.2#", "DigestAlgAndValue");
  
  private static final javax.xml.namespace.b e = new javax.xml.namespace.b("http://uri.etsi.org/01903/v1.3.2#", "CRLIdentifier");
  
  public b(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public j a() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().find_element_user(d, 0);
      if (j == null)
        return null; 
      return j;
    } 
  }
  
  public void a(j paramj) {
    synchronized (monitor()) {
      check_orphaned();
      j j1 = null;
      j1 = (j)get_store().find_element_user(d, 0);
      if (j1 == null)
        j1 = (j)get_store().add_element_user(d); 
      j1.set((XmlObject)paramj);
    } 
  }
  
  public j b() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().add_element_user(d);
      return j;
    } 
  }
  
  public a b() {
    synchronized (monitor()) {
      check_orphaned();
      a a = null;
      a = (a)get_store().find_element_user(e, 0);
      if (a == null)
        return null; 
      return a;
    } 
  }
  
  public boolean ex() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(e) != 0);
    } 
  }
  
  public void a(a parama) {
    synchronized (monitor()) {
      check_orphaned();
      a a1 = null;
      a1 = (a)get_store().find_element_user(e, 0);
      if (a1 == null)
        a1 = (a)get_store().add_element_user(e); 
      a1.set((XmlObject)parama);
    } 
  }
  
  public a c() {
    synchronized (monitor()) {
      check_orphaned();
      a a = null;
      a = (a)get_store().add_element_user(e);
      return a;
    } 
  }
  
  public void hn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(e, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */