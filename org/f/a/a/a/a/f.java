package org.f.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.f;
import org.f.a.a.a.g;

public class f extends XmlComplexContentImpl implements f {
  private static final b at = new b("http://www.w3.org/2000/09/xmldsig#", "Signature");
  
  public f(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public g a() {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().find_element_user(at, 0);
      if (g == null)
        return null; 
      return g;
    } 
  }
  
  public void a(g paramg) {
    synchronized (monitor()) {
      check_orphaned();
      g g1 = null;
      g1 = (g)get_store().find_element_user(at, 0);
      if (g1 == null)
        g1 = (g)get_store().add_element_user(at); 
      g1.set((XmlObject)paramg);
    } 
  }
  
  public g b() {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().add_element_user(at);
      return g;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */