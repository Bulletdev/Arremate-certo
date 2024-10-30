package org.b.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.s;

public class s extends XmlComplexContentImpl implements s {
  private static final b G = new b("http://uri.etsi.org/01903/v1.3.2#", "ByName");
  
  private static final b H = new b("http://uri.etsi.org/01903/v1.3.2#", "ByKey");
  
  public s(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String ee() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(G, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString b() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(G, 0);
      return xmlString;
    } 
  }
  
  public boolean eG() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(G) != 0);
    } 
  }
  
  public void bk(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(G, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(G); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void b(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(G, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(G); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void hw() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(G, 0);
    } 
  }
  
  public byte[] q() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(H, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(H, 0);
      return xmlBase64Binary;
    } 
  }
  
  public boolean eH() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(H) != 0);
    } 
  }
  
  public void g(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(H, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(H); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void a(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(H, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(H); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void hx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(H, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */