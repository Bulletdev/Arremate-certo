package org.b.a.a.a.a;

import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.a;

public class a extends XmlComplexContentImpl implements a {
  private static final b a = new b("http://uri.etsi.org/01903/v1.3.2#", "Issuer");
  
  private static final b b = new b("http://uri.etsi.org/01903/v1.3.2#", "IssueTime");
  
  private static final b c = new b("http://uri.etsi.org/01903/v1.3.2#", "Number");
  
  private static final b URI$6 = new b("", "URI");
  
  public a(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String ed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(a, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(a, 0);
      return xmlString;
    } 
  }
  
  public void bi(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(a, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(a); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void a(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(a, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(a); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public Calendar j() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(b, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(b, 0);
      return xmlDateTime;
    } 
  }
  
  public void c(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(b, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(b); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void a(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(b, 0);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_element_user(b); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public BigInteger a() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(c, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(c, 0);
      return xmlInteger;
    } 
  }
  
  public boolean ev() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(c) != 0);
    } 
  }
  
  public void a(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(c, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(c); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void a(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(c, 0);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_element_user(c); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void hl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(c, 0);
    } 
  }
  
  public String getURI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$6);
      return xmlAnyURI;
    } 
  }
  
  public boolean ew() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(URI$6) != null);
    } 
  }
  
  public void bj(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(URI$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void a(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(URI$6);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(URI$6); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void hm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(URI$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */