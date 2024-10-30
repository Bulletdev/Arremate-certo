package org.f.a.a.a.a;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.b;

public class b extends XmlComplexContentImpl implements b {
  private static final javax.xml.namespace.b am = new javax.xml.namespace.b("", "Algorithm");
  
  public b(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(am);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI c() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(am);
      return xmlAnyURI;
    } 
  }
  
  public void setAlgorithm(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(am);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(am); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void c(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(am);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(am); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */