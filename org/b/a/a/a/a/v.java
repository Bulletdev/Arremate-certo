package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.v;
import org.b.a.a.a.w;
import org.etsi.uri.x01903.v13.SignedDataObjectPropertiesType;

public class v extends XmlComplexContentImpl implements v {
  private static final b N = new b("http://uri.etsi.org/01903/v1.3.2#", "SignedSignatureProperties");
  
  private static final b O = new b("http://uri.etsi.org/01903/v1.3.2#", "SignedDataObjectProperties");
  
  private static final b ID$4 = new b("", "Id");
  
  public v(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public w a() {
    synchronized (monitor()) {
      check_orphaned();
      w w = null;
      w = (w)get_store().find_element_user(N, 0);
      if (w == null)
        return null; 
      return w;
    } 
  }
  
  public boolean eN() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(N) != 0);
    } 
  }
  
  public void a(w paramw) {
    synchronized (monitor()) {
      check_orphaned();
      w w1 = null;
      w1 = (w)get_store().find_element_user(N, 0);
      if (w1 == null)
        w1 = (w)get_store().add_element_user(N); 
      w1.set((XmlObject)paramw);
    } 
  }
  
  public w b() {
    synchronized (monitor()) {
      check_orphaned();
      w w = null;
      w = (w)get_store().add_element_user(N);
      return w;
    } 
  }
  
  public void hD() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(N, 0);
    } 
  }
  
  public SignedDataObjectPropertiesType a() {
    synchronized (monitor()) {
      check_orphaned();
      SignedDataObjectPropertiesType signedDataObjectPropertiesType = null;
      signedDataObjectPropertiesType = (SignedDataObjectPropertiesType)get_store().find_element_user(O, 0);
      if (signedDataObjectPropertiesType == null)
        return null; 
      return signedDataObjectPropertiesType;
    } 
  }
  
  public boolean eO() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(O) != 0);
    } 
  }
  
  public void a(SignedDataObjectPropertiesType paramSignedDataObjectPropertiesType) {
    synchronized (monitor()) {
      check_orphaned();
      SignedDataObjectPropertiesType signedDataObjectPropertiesType = null;
      signedDataObjectPropertiesType = (SignedDataObjectPropertiesType)get_store().find_element_user(O, 0);
      if (signedDataObjectPropertiesType == null)
        signedDataObjectPropertiesType = (SignedDataObjectPropertiesType)get_store().add_element_user(O); 
      signedDataObjectPropertiesType.set((XmlObject)paramSignedDataObjectPropertiesType);
    } 
  }
  
  public SignedDataObjectPropertiesType b() {
    synchronized (monitor()) {
      check_orphaned();
      SignedDataObjectPropertiesType signedDataObjectPropertiesType = null;
      signedDataObjectPropertiesType = (SignedDataObjectPropertiesType)get_store().add_element_user(O);
      return signedDataObjectPropertiesType;
    } 
  }
  
  public void hE() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(O, 0);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$4);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$4) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$4);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$4); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */