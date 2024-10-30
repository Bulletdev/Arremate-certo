package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.k;
import org.b.a.a.a.l;
import org.etsi.uri.x01903.v13.AnyType;
import org.etsi.uri.x01903.v13.IncludeType;
import org.etsi.uri.x01903.v13.ReferenceInfoType;
import org.etsi.uri.x01903.v13.impl.GenericTimeStampTypeImpl;
import org.f.a.a.a.a;

public class l extends XmlComplexContentImpl implements l {
  private static final b INCLUDE$0 = new b("http://uri.etsi.org/01903/v1.3.2#", "Include");
  
  private static final b t = new b("http://uri.etsi.org/01903/v1.3.2#", "ReferenceInfo");
  
  private static final b u = new b("http://www.w3.org/2000/09/xmldsig#", "CanonicalizationMethod");
  
  private static final b v = new b("http://uri.etsi.org/01903/v1.3.2#", "EncapsulatedTimeStamp");
  
  private static final b w = new b("http://uri.etsi.org/01903/v1.3.2#", "XMLTimeStamp");
  
  private static final b ID$10 = new b("", "Id");
  
  public l(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<IncludeType> an() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<IncludeType>)new GenericTimeStampTypeImpl.IncludeList((GenericTimeStampTypeImpl)this);
    } 
  }
  
  public IncludeType[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INCLUDE$0, arrayList);
      IncludeType[] arrayOfIncludeType = new IncludeType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfIncludeType);
      return arrayOfIncludeType;
    } 
  }
  
  public IncludeType a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      IncludeType includeType = null;
      includeType = (IncludeType)get_store().find_element_user(INCLUDE$0, paramInt);
      if (includeType == null)
        throw new IndexOutOfBoundsException(); 
      return includeType;
    } 
  }
  
  public int sizeOfIncludeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INCLUDE$0);
    } 
  }
  
  public void a(IncludeType[] paramArrayOfIncludeType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfIncludeType, INCLUDE$0);
    } 
  }
  
  public void a(int paramInt, IncludeType paramIncludeType) {
    synchronized (monitor()) {
      check_orphaned();
      IncludeType includeType = null;
      includeType = (IncludeType)get_store().find_element_user(INCLUDE$0, paramInt);
      if (includeType == null)
        throw new IndexOutOfBoundsException(); 
      includeType.set((XmlObject)paramIncludeType);
    } 
  }
  
  public IncludeType b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      IncludeType includeType = null;
      includeType = (IncludeType)get_store().insert_element_user(INCLUDE$0, paramInt);
      return includeType;
    } 
  }
  
  public IncludeType a() {
    synchronized (monitor()) {
      check_orphaned();
      IncludeType includeType = null;
      includeType = (IncludeType)get_store().add_element_user(INCLUDE$0);
      return includeType;
    } 
  }
  
  public void removeInclude(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INCLUDE$0, paramInt);
    } 
  }
  
  public List<ReferenceInfoType> ao() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<ReferenceInfoType>)new GenericTimeStampTypeImpl.ReferenceInfoList((GenericTimeStampTypeImpl)this);
    } 
  }
  
  public ReferenceInfoType[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(t, arrayList);
      ReferenceInfoType[] arrayOfReferenceInfoType = new ReferenceInfoType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfReferenceInfoType);
      return arrayOfReferenceInfoType;
    } 
  }
  
  public ReferenceInfoType a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      ReferenceInfoType referenceInfoType = null;
      referenceInfoType = (ReferenceInfoType)get_store().find_element_user(t, paramInt);
      if (referenceInfoType == null)
        throw new IndexOutOfBoundsException(); 
      return referenceInfoType;
    } 
  }
  
  public int bs() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(t);
    } 
  }
  
  public void a(ReferenceInfoType[] paramArrayOfReferenceInfoType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfReferenceInfoType, t);
    } 
  }
  
  public void a(int paramInt, ReferenceInfoType paramReferenceInfoType) {
    synchronized (monitor()) {
      check_orphaned();
      ReferenceInfoType referenceInfoType = null;
      referenceInfoType = (ReferenceInfoType)get_store().find_element_user(t, paramInt);
      if (referenceInfoType == null)
        throw new IndexOutOfBoundsException(); 
      referenceInfoType.set((XmlObject)paramReferenceInfoType);
    } 
  }
  
  public ReferenceInfoType b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      ReferenceInfoType referenceInfoType = null;
      referenceInfoType = (ReferenceInfoType)get_store().insert_element_user(t, paramInt);
      return referenceInfoType;
    } 
  }
  
  public ReferenceInfoType a() {
    synchronized (monitor()) {
      check_orphaned();
      ReferenceInfoType referenceInfoType = null;
      referenceInfoType = (ReferenceInfoType)get_store().add_element_user(t);
      return referenceInfoType;
    } 
  }
  
  public void aZ(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(t, paramInt);
    } 
  }
  
  public a a() {
    synchronized (monitor()) {
      check_orphaned();
      a a = null;
      a = (a)get_store().find_element_user(u, 0);
      if (a == null)
        return null; 
      return a;
    } 
  }
  
  public boolean eC() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(u) != 0);
    } 
  }
  
  public void a(a parama) {
    synchronized (monitor()) {
      check_orphaned();
      a a1 = null;
      a1 = (a)get_store().find_element_user(u, 0);
      if (a1 == null)
        a1 = (a)get_store().add_element_user(u); 
      a1.set((XmlObject)parama);
    } 
  }
  
  public a b() {
    synchronized (monitor()) {
      check_orphaned();
      a a = null;
      a = (a)get_store().add_element_user(u);
      return a;
    } 
  }
  
  public void hs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(u, 0);
    } 
  }
  
  public List<k> ap() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<k>)new GenericTimeStampTypeImpl.EncapsulatedTimeStampList((GenericTimeStampTypeImpl)this);
    } 
  }
  
  public k[] c() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(v, arrayList);
      k[] arrayOfK = new k[arrayList.size()];
      arrayList.toArray((Object[])arrayOfK);
      return arrayOfK;
    } 
  }
  
  public k e(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().find_element_user(v, paramInt);
      if (k == null)
        throw new IndexOutOfBoundsException(); 
      return k;
    } 
  }
  
  public int bt() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(v);
    } 
  }
  
  public void c(k[] paramArrayOfk) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfk, v);
    } 
  }
  
  public void c(int paramInt, k paramk) {
    synchronized (monitor()) {
      check_orphaned();
      k k1 = null;
      k1 = (k)get_store().find_element_user(v, paramInt);
      if (k1 == null)
        throw new IndexOutOfBoundsException(); 
      k1.set((XmlObject)paramk);
    } 
  }
  
  public k f(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().insert_element_user(v, paramInt);
      return k;
    } 
  }
  
  public k d() {
    synchronized (monitor()) {
      check_orphaned();
      k k = null;
      k = (k)get_store().add_element_user(v);
      return k;
    } 
  }
  
  public void ba(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(v, paramInt);
    } 
  }
  
  public List<AnyType> aq() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<AnyType>)new GenericTimeStampTypeImpl.XMLTimeStampList((GenericTimeStampTypeImpl)this);
    } 
  }
  
  public AnyType[] b() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(w, arrayList);
      AnyType[] arrayOfAnyType = new AnyType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfAnyType);
      return arrayOfAnyType;
    } 
  }
  
  public AnyType c(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().find_element_user(w, paramInt);
      if (anyType == null)
        throw new IndexOutOfBoundsException(); 
      return anyType;
    } 
  }
  
  public int bu() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(w);
    } 
  }
  
  public void b(AnyType[] paramArrayOfAnyType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfAnyType, w);
    } 
  }
  
  public void b(int paramInt, AnyType paramAnyType) {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().find_element_user(w, paramInt);
      if (anyType == null)
        throw new IndexOutOfBoundsException(); 
      anyType.set((XmlObject)paramAnyType);
    } 
  }
  
  public AnyType d(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().insert_element_user(w, paramInt);
      return anyType;
    } 
  }
  
  public AnyType b() {
    synchronized (monitor()) {
      check_orphaned();
      AnyType anyType = null;
      anyType = (AnyType)get_store().add_element_user(w);
      return anyType;
    } 
  }
  
  public void bb(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(w, paramInt);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$10);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$10) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$10);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$10); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */