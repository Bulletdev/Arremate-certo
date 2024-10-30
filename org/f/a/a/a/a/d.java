package org.f.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.d;

public class d extends XmlComplexContentImpl implements d {
  private static final b ID$0 = new b("", "Id");
  
  private static final b an = new b("", "MimeType");
  
  private static final b ao = new b("", "Encoding");
  
  public d(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$0);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$0) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$0);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$0); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$0);
    } 
  }
  
  public String getMimeType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(an);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString c() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(an);
      return xmlString;
    } 
  }
  
  public boolean gI() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(an) != null);
    } 
  }
  
  public void bO(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(an);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(an); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void c(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(an);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(an); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void iL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(an);
    } 
  }
  
  public String getEncoding() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ao);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI b() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(ao);
      return xmlAnyURI;
    } 
  }
  
  public boolean eB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ao) != null);
    } 
  }
  
  public void setEncoding(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ao);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ao); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void b(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(ao);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(ao); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void hr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ao);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */