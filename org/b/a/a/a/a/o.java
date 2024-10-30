package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.n;
import org.b.a.a.a.o;
import org.etsi.uri.x01903.v13.impl.OCSPRefsTypeImpl;

public class o extends XmlComplexContentImpl implements o {
  private static final b B = new b("http://uri.etsi.org/01903/v1.3.2#", "OCSPRef");
  
  public o(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<n> ar() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<n>)new OCSPRefsTypeImpl.OCSPRefList((OCSPRefsTypeImpl)this);
    } 
  }
  
  public n[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(B, arrayList);
      n[] arrayOfN = new n[arrayList.size()];
      arrayList.toArray((Object[])arrayOfN);
      return arrayOfN;
    } 
  }
  
  public n a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      n n = null;
      n = (n)get_store().find_element_user(B, paramInt);
      if (n == null)
        throw new IndexOutOfBoundsException(); 
      return n;
    } 
  }
  
  public int bv() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(B);
    } 
  }
  
  public void a(n[] paramArrayOfn) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfn, B);
    } 
  }
  
  public void a(int paramInt, n paramn) {
    synchronized (monitor()) {
      check_orphaned();
      n n1 = null;
      n1 = (n)get_store().find_element_user(B, paramInt);
      if (n1 == null)
        throw new IndexOutOfBoundsException(); 
      n1.set((XmlObject)paramn);
    } 
  }
  
  public n b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      n n = null;
      n = (n)get_store().insert_element_user(B, paramInt);
      return n;
    } 
  }
  
  public n b() {
    synchronized (monitor()) {
      check_orphaned();
      n n = null;
      n = (n)get_store().add_element_user(B);
      return n;
    } 
  }
  
  public void bc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(B, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */