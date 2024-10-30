package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.q;
import org.b.a.a.a.r;

public class q extends XmlComplexContentImpl implements q {
  private static final b D = new b("http://uri.etsi.org/01903/v1.3.2#", "QualifyingProperties");
  
  public q(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public r a() {
    synchronized (monitor()) {
      check_orphaned();
      r r = null;
      r = (r)get_store().find_element_user(D, 0);
      if (r == null)
        return null; 
      return r;
    } 
  }
  
  public void a(r paramr) {
    synchronized (monitor()) {
      check_orphaned();
      r r1 = null;
      r1 = (r)get_store().find_element_user(D, 0);
      if (r1 == null)
        r1 = (r)get_store().add_element_user(D); 
      r1.set((XmlObject)paramr);
    } 
  }
  
  public r b() {
    synchronized (monitor()) {
      check_orphaned();
      r r = null;
      r = (r)get_store().add_element_user(D);
      return r;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */