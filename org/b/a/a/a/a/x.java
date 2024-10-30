package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.x;
import org.b.a.a.a.y;
import org.etsi.uri.x01903.v13.UnsignedDataObjectPropertiesType;

public class x extends XmlComplexContentImpl implements x {
  private static final b U = new b("http://uri.etsi.org/01903/v1.3.2#", "UnsignedSignatureProperties");
  
  private static final b V = new b("http://uri.etsi.org/01903/v1.3.2#", "UnsignedDataObjectProperties");
  
  private static final b ID$4 = new b("", "Id");
  
  public x(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public y a() {
    synchronized (monitor()) {
      check_orphaned();
      y y = null;
      y = (y)get_store().find_element_user(U, 0);
      if (y == null)
        return null; 
      return y;
    } 
  }
  
  public boolean eU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(U) != 0);
    } 
  }
  
  public void a(y paramy) {
    synchronized (monitor()) {
      check_orphaned();
      y y1 = null;
      y1 = (y)get_store().find_element_user(U, 0);
      if (y1 == null)
        y1 = (y)get_store().add_element_user(U); 
      y1.set((XmlObject)paramy);
    } 
  }
  
  public y b() {
    synchronized (monitor()) {
      check_orphaned();
      y y = null;
      y = (y)get_store().add_element_user(U);
      return y;
    } 
  }
  
  public void hK() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(U, 0);
    } 
  }
  
  public UnsignedDataObjectPropertiesType a() {
    synchronized (monitor()) {
      check_orphaned();
      UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesType = null;
      unsignedDataObjectPropertiesType = (UnsignedDataObjectPropertiesType)get_store().find_element_user(V, 0);
      if (unsignedDataObjectPropertiesType == null)
        return null; 
      return unsignedDataObjectPropertiesType;
    } 
  }
  
  public boolean eV() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(V) != 0);
    } 
  }
  
  public void a(UnsignedDataObjectPropertiesType paramUnsignedDataObjectPropertiesType) {
    synchronized (monitor()) {
      check_orphaned();
      UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesType = null;
      unsignedDataObjectPropertiesType = (UnsignedDataObjectPropertiesType)get_store().find_element_user(V, 0);
      if (unsignedDataObjectPropertiesType == null)
        unsignedDataObjectPropertiesType = (UnsignedDataObjectPropertiesType)get_store().add_element_user(V); 
      unsignedDataObjectPropertiesType.set((XmlObject)paramUnsignedDataObjectPropertiesType);
    } 
  }
  
  public UnsignedDataObjectPropertiesType b() {
    synchronized (monitor()) {
      check_orphaned();
      UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesType = null;
      unsignedDataObjectPropertiesType = (UnsignedDataObjectPropertiesType)get_store().add_element_user(V);
      return unsignedDataObjectPropertiesType;
    } 
  }
  
  public void hL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(V, 0);
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


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */