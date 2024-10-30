package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.e;
import org.b.a.a.a.f;
import org.etsi.uri.x01903.v13.impl.CertIDListTypeImpl;

public class e extends XmlComplexContentImpl implements e {
  private static final b h = new b("http://uri.etsi.org/01903/v1.3.2#", "Cert");
  
  public e(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<f> ak() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<f>)new CertIDListTypeImpl.CertList((CertIDListTypeImpl)this);
    } 
  }
  
  public f[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(h, arrayList);
      f[] arrayOfF = new f[arrayList.size()];
      arrayList.toArray((Object[])arrayOfF);
      return arrayOfF;
    } 
  }
  
  public f a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      f f = null;
      f = (f)get_store().find_element_user(h, paramInt);
      if (f == null)
        throw new IndexOutOfBoundsException(); 
      return f;
    } 
  }
  
  public int bp() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(h);
    } 
  }
  
  public void a(f[] paramArrayOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOff, h);
    } 
  }
  
  public void a(int paramInt, f paramf) {
    synchronized (monitor()) {
      check_orphaned();
      f f1 = null;
      f1 = (f)get_store().find_element_user(h, paramInt);
      if (f1 == null)
        throw new IndexOutOfBoundsException(); 
      f1.set((XmlObject)paramf);
    } 
  }
  
  public f b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      f f = null;
      f = (f)get_store().insert_element_user(h, paramInt);
      return f;
    } 
  }
  
  public f a() {
    synchronized (monitor()) {
      check_orphaned();
      f f = null;
      f = (f)get_store().add_element_user(h);
      return f;
    } 
  }
  
  public void aW(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(h, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */