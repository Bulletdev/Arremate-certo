package org.f.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.d;
import org.f.a.a.a.g;
import org.f.a.a.a.h;
import org.w3.x2000.x09.xmldsig.KeyInfoType;
import org.w3.x2000.x09.xmldsig.SignatureValueType;
import org.w3.x2000.x09.xmldsig.impl.SignatureTypeImpl;

public class g extends XmlComplexContentImpl implements g {
  private static final b au = new b("http://www.w3.org/2000/09/xmldsig#", "SignedInfo");
  
  private static final b av = new b("http://www.w3.org/2000/09/xmldsig#", "SignatureValue");
  
  private static final b aw = new b("http://www.w3.org/2000/09/xmldsig#", "KeyInfo");
  
  private static final b ax = new b("http://www.w3.org/2000/09/xmldsig#", "Object");
  
  private static final b ID$8 = new b("", "Id");
  
  public g(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public h a() {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().find_element_user(au, 0);
      if (h == null)
        return null; 
      return h;
    } 
  }
  
  public void a(h paramh) {
    synchronized (monitor()) {
      check_orphaned();
      h h1 = null;
      h1 = (h)get_store().find_element_user(au, 0);
      if (h1 == null)
        h1 = (h)get_store().add_element_user(au); 
      h1.set((XmlObject)paramh);
    } 
  }
  
  public h b() {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().add_element_user(au);
      return h;
    } 
  }
  
  public SignatureValueType a() {
    synchronized (monitor()) {
      check_orphaned();
      SignatureValueType signatureValueType = null;
      signatureValueType = (SignatureValueType)get_store().find_element_user(av, 0);
      if (signatureValueType == null)
        return null; 
      return signatureValueType;
    } 
  }
  
  public void a(SignatureValueType paramSignatureValueType) {
    synchronized (monitor()) {
      check_orphaned();
      SignatureValueType signatureValueType = null;
      signatureValueType = (SignatureValueType)get_store().find_element_user(av, 0);
      if (signatureValueType == null)
        signatureValueType = (SignatureValueType)get_store().add_element_user(av); 
      signatureValueType.set((XmlObject)paramSignatureValueType);
    } 
  }
  
  public SignatureValueType b() {
    synchronized (monitor()) {
      check_orphaned();
      SignatureValueType signatureValueType = null;
      signatureValueType = (SignatureValueType)get_store().add_element_user(av);
      return signatureValueType;
    } 
  }
  
  public KeyInfoType a() {
    synchronized (monitor()) {
      check_orphaned();
      KeyInfoType keyInfoType = null;
      keyInfoType = (KeyInfoType)get_store().find_element_user(aw, 0);
      if (keyInfoType == null)
        return null; 
      return keyInfoType;
    } 
  }
  
  public boolean gK() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(aw) != 0);
    } 
  }
  
  public void a(KeyInfoType paramKeyInfoType) {
    synchronized (monitor()) {
      check_orphaned();
      KeyInfoType keyInfoType = null;
      keyInfoType = (KeyInfoType)get_store().find_element_user(aw, 0);
      if (keyInfoType == null)
        keyInfoType = (KeyInfoType)get_store().add_element_user(aw); 
      keyInfoType.set((XmlObject)paramKeyInfoType);
    } 
  }
  
  public KeyInfoType b() {
    synchronized (monitor()) {
      check_orphaned();
      KeyInfoType keyInfoType = null;
      keyInfoType = (KeyInfoType)get_store().add_element_user(aw);
      return keyInfoType;
    } 
  }
  
  public void iN() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(aw, 0);
    } 
  }
  
  public List<d> getObjectList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<d>)new SignatureTypeImpl.ObjectList((SignatureTypeImpl)this);
    } 
  }
  
  public d[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ax, arrayList);
      d[] arrayOfD = new d[arrayList.size()];
      arrayList.toArray((Object[])arrayOfD);
      return arrayOfD;
    } 
  }
  
  public d a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      d d = null;
      d = (d)get_store().find_element_user(ax, paramInt);
      if (d == null)
        throw new IndexOutOfBoundsException(); 
      return d;
    } 
  }
  
  public int sizeOfObjectArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ax);
    } 
  }
  
  public void a(d[] paramArrayOfd) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfd, ax);
    } 
  }
  
  public void a(int paramInt, d paramd) {
    synchronized (monitor()) {
      check_orphaned();
      d d1 = null;
      d1 = (d)get_store().find_element_user(ax, paramInt);
      if (d1 == null)
        throw new IndexOutOfBoundsException(); 
      d1.set((XmlObject)paramd);
    } 
  }
  
  public d b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      d d = null;
      d = (d)get_store().insert_element_user(ax, paramInt);
      return d;
    } 
  }
  
  public d b() {
    synchronized (monitor()) {
      check_orphaned();
      d d = null;
      d = (d)get_store().add_element_user(ax);
      return d;
    } 
  }
  
  public void removeObject(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ax, paramInt);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$8);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$8) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$8);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$8); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */