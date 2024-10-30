package org.f.a.a.a.a;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.k;

public class k extends XmlComplexContentImpl implements k {
  private static final b aD = new b("http://www.w3.org/2000/09/xmldsig#", "X509IssuerName");
  
  private static final b aE = new b("http://www.w3.org/2000/09/xmldsig#", "X509SerialNumber");
  
  public k(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String fh() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(aD, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString e() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(aD, 0);
      return xmlString;
    } 
  }
  
  public void bQ(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(aD, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(aD); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void d(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(aD, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(aD); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public BigInteger c() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(aE, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger b() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(aE, 0);
      return xmlInteger;
    } 
  }
  
  public void b(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(aE, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(aE); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void b(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(aE, 0);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_element_user(aE); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */