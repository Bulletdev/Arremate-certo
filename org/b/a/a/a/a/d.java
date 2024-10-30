package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.d;
import org.b.a.a.a.k;
import org.etsi.uri.x01903.v13.impl.CRLValuesTypeImpl;

public class d extends XmlComplexContentImpl implements d {
  private static final b g = new b("http://uri.etsi.org/01903/v1.3.2#", "EncapsulatedCRLValue");
  
  public d(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<k> aj() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<k>)new CRLValuesTypeImpl.EncapsulatedCRLValueList((CRLValuesTypeImpl)this);
    } 
  }
  
  public k[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(g, arrayList);
      k[] arrayOfK = new k[arrayList.size()];
      arrayList.toArray((Object[])arrayOfK);
      return arrayOfK;
    } 
  }
  
  public k a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().find_element_user(g, paramInt);
      if (k == null)
        throw new IndexOutOfBoundsException(); 
      return k;
    } 
  }
  
  public int bo() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(g);
    } 
  }
  
  public void a(k[] paramArrayOfk) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfk, g);
    } 
  }
  
  public void a(int paramInt, k paramk) {
    synchronized (monitor()) {
      check_orphaned();
      k k1 = null;
      k1 = (k)get_store().find_element_user(g, paramInt);
      if (k1 == null)
        throw new IndexOutOfBoundsException(); 
      k1.set((XmlObject)paramk);
    } 
  }
  
  public k b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().insert_element_user(g, paramInt);
      return k;
    } 
  }
  
  public k a() {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().add_element_user(g);
      return k;
    } 
  }
  
  public void aV(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(g, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */