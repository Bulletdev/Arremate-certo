package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.b;
import org.b.a.a.a.c;
import org.etsi.uri.x01903.v13.impl.CRLRefsTypeImpl;

public class c extends XmlComplexContentImpl implements c {
  private static final b f = new b("http://uri.etsi.org/01903/v1.3.2#", "CRLRef");
  
  public c(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<b> ai() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<b>)new CRLRefsTypeImpl.CRLRefList((CRLRefsTypeImpl)this);
    } 
  }
  
  public b[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(f, arrayList);
      b[] arrayOfB = new b[arrayList.size()];
      arrayList.toArray((Object[])arrayOfB);
      return arrayOfB;
    } 
  }
  
  public b a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().find_element_user(f, paramInt);
      if (b1 == null)
        throw new IndexOutOfBoundsException(); 
      return b1;
    } 
  }
  
  public int bn() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(f);
    } 
  }
  
  public void a(b[] paramArrayOfb) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfb, f);
    } 
  }
  
  public void a(int paramInt, b paramb) {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().find_element_user(f, paramInt);
      if (b1 == null)
        throw new IndexOutOfBoundsException(); 
      b1.set((XmlObject)paramb);
    } 
  }
  
  public b b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().insert_element_user(f, paramInt);
      return b1;
    } 
  }
  
  public b b() {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().add_element_user(f);
      return b1;
    } 
  }
  
  public void aU(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(f, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */