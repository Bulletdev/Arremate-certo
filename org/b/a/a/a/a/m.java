package org.b.a.a.a.a;

import java.util.Calendar;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.m;
import org.b.a.a.a.s;

public class m extends XmlComplexContentImpl implements m {
  private static final b x = new b("http://uri.etsi.org/01903/v1.3.2#", "ResponderID");
  
  private static final b y = new b("http://uri.etsi.org/01903/v1.3.2#", "ProducedAt");
  
  private static final b URI$4 = new b("", "URI");
  
  public m(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public s a() {
    synchronized (monitor()) {
      check_orphaned();
      s s = null;
      s = (s)get_store().find_element_user(x, 0);
      if (s == null)
        return null; 
      return s;
    } 
  }
  
  public void a(s params) {
    synchronized (monitor()) {
      check_orphaned();
      s s1 = null;
      s1 = (s)get_store().find_element_user(x, 0);
      if (s1 == null)
        s1 = (s)get_store().add_element_user(x); 
      s1.set((XmlObject)params);
    } 
  }
  
  public s b() {
    synchronized (monitor()) {
      check_orphaned();
      s s = null;
      s = (s)get_store().add_element_user(x);
      return s;
    } 
  }
  
  public Calendar k() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(y, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime b() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(y, 0);
      return xmlDateTime;
    } 
  }
  
  public void d(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(y, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(y); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void b(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(y, 0);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_element_user(y); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public String getURI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$4);
      return xmlAnyURI;
    } 
  }
  
  public boolean ew() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(URI$4) != null);
    } 
  }
  
  public void bj(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(URI$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void a(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$4);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(URI$4); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void hm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(URI$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */