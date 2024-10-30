package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.j;
import org.f.a.a.a.b;
import org.f.a.a.a.c;

public class j extends XmlComplexContentImpl implements j {
  private static final b q = new b("http://www.w3.org/2000/09/xmldsig#", "DigestMethod");
  
  private static final b r = new b("http://www.w3.org/2000/09/xmldsig#", "DigestValue");
  
  public j(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public b a() {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().find_element_user(q, 0);
      if (b1 == null)
        return null; 
      return b1;
    } 
  }
  
  public void a(b paramb) {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().find_element_user(q, 0);
      if (b1 == null)
        b1 = (b)get_store().add_element_user(q); 
      b1.set((XmlObject)paramb);
    } 
  }
  
  public b b() {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().add_element_user(q);
      return b1;
    } 
  }
  
  public byte[] p() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(r, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public c a() {
    synchronized (monitor()) {
      check_orphaned();
      c c = null;
      c = (c)get_store().find_element_user(r, 0);
      return c;
    } 
  }
  
  public void f(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(r, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(r); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void a(c paramc) {
    synchronized (monitor()) {
      check_orphaned();
      c c1 = null;
      c1 = (c)get_store().find_element_user(r, 0);
      if (c1 == null)
        c1 = (c)get_store().add_element_user(r); 
      c1.set((XmlObject)paramc);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */