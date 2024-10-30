package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.e;
import org.b.a.a.a.h;

public class h extends XmlComplexContentImpl implements h {
  private static final b m = new b("http://uri.etsi.org/01903/v1.3.2#", "CertRefs");
  
  private static final b ID$2 = new b("", "Id");
  
  public h(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public e b() {
    synchronized (monitor()) {
      check_orphaned();
      e e = null;
      e = (e)get_store().find_element_user(m, 0);
      if (e == null)
        return null; 
      return e;
    } 
  }
  
  public void a(e parame) {
    synchronized (monitor()) {
      check_orphaned();
      e e1 = null;
      e1 = (e)get_store().find_element_user(m, 0);
      if (e1 == null)
        e1 = (e)get_store().add_element_user(m); 
      e1.set((XmlObject)parame);
    } 
  }
  
  public e c() {
    synchronized (monitor()) {
      check_orphaned();
      e e = null;
      e = (e)get_store().add_element_user(m);
      return e;
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$2);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$2) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$2);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$2); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */