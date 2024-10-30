package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.k;
import org.b.a.a.a.p;
import org.etsi.uri.x01903.v13.impl.OCSPValuesTypeImpl;

public class p extends XmlComplexContentImpl implements p {
  private static final b C = new b("http://uri.etsi.org/01903/v1.3.2#", "EncapsulatedOCSPValue");
  
  public p(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<k> as() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<k>)new OCSPValuesTypeImpl.EncapsulatedOCSPValueList((OCSPValuesTypeImpl)this);
    } 
  }
  
  public k[] d() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(C, arrayList);
      k[] arrayOfK = new k[arrayList.size()];
      arrayList.toArray((Object[])arrayOfK);
      return arrayOfK;
    } 
  }
  
  public k g(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().find_element_user(C, paramInt);
      if (k == null)
        throw new IndexOutOfBoundsException(); 
      return k;
    } 
  }
  
  public int bw() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(C);
    } 
  }
  
  public void d(k[] paramArrayOfk) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfk, C);
    } 
  }
  
  public void d(int paramInt, k paramk) {
    synchronized (monitor()) {
      check_orphaned();
      k k1 = null;
      k1 = (k)get_store().find_element_user(C, paramInt);
      if (k1 == null)
        throw new IndexOutOfBoundsException(); 
      k1.set((XmlObject)paramk);
    } 
  }
  
  public k h(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().insert_element_user(C, paramInt);
      return k;
    } 
  }
  
  public k e() {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().add_element_user(C);
      return k;
    } 
  }
  
  public void bd(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(C, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */