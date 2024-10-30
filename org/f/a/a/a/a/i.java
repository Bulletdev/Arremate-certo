package org.f.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.i;
import org.f.a.a.a.j;

public class i extends XmlComplexContentImpl implements i {
  private static final b aB = new b("http://www.w3.org/2000/09/xmldsig#", "Transform");
  
  public i(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public j a() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().find_element_user(aB, 0);
      if (j == null)
        return null; 
      return j;
    } 
  }
  
  public void a(j paramj) {
    synchronized (monitor()) {
      check_orphaned();
      j j1 = null;
      j1 = (j)get_store().find_element_user(aB, 0);
      if (j1 == null)
        j1 = (j)get_store().add_element_user(aB); 
      j1.set((XmlObject)paramj);
    } 
  }
  
  public j b() {
    synchronized (monitor()) {
      check_orphaned();
      j j = null;
      j = (j)get_store().add_element_user(aB);
      return j;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */