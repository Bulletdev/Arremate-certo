package org.f.a.a.a.a;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.b;
import org.f.a.a.a.c;
import org.f.a.a.a.e;
import org.w3.x2000.x09.xmldsig.TransformsType;

public class e extends XmlComplexContentImpl implements e {
  private static final b ap = new b("http://www.w3.org/2000/09/xmldsig#", "Transforms");
  
  private static final b aq = new b("http://www.w3.org/2000/09/xmldsig#", "DigestMethod");
  
  private static final b ar = new b("http://www.w3.org/2000/09/xmldsig#", "DigestValue");
  
  private static final b ID$6 = new b("", "Id");
  
  private static final b as = new b("", "URI");
  
  private static final b TYPE$10 = new b("", "Type");
  
  public e(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public TransformsType a() {
    synchronized (monitor()) {
      check_orphaned();
      TransformsType transformsType = null;
      transformsType = (TransformsType)get_store().find_element_user(ap, 0);
      if (transformsType == null)
        return null; 
      return transformsType;
    } 
  }
  
  public boolean gJ() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ap) != 0);
    } 
  }
  
  public void a(TransformsType paramTransformsType) {
    synchronized (monitor()) {
      check_orphaned();
      TransformsType transformsType = null;
      transformsType = (TransformsType)get_store().find_element_user(ap, 0);
      if (transformsType == null)
        transformsType = (TransformsType)get_store().add_element_user(ap); 
      transformsType.set((XmlObject)paramTransformsType);
    } 
  }
  
  public TransformsType b() {
    synchronized (monitor()) {
      check_orphaned();
      TransformsType transformsType = null;
      transformsType = (TransformsType)get_store().add_element_user(ap);
      return transformsType;
    } 
  }
  
  public void iM() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ap, 0);
    } 
  }
  
  public b a() {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().find_element_user(aq, 0);
      if (b1 == null)
        return null; 
      return b1;
    } 
  }
  
  public void a(b paramb) {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().find_element_user(aq, 0);
      if (b1 == null)
        b1 = (b)get_store().add_element_user(aq); 
      b1.set((XmlObject)paramb);
    } 
  }
  
  public b b() {
    synchronized (monitor()) {
      check_orphaned();
      b b1 = null;
      b1 = (b)get_store().add_element_user(aq);
      return b1;
    } 
  }
  
  public byte[] p() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ar, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public c a() {
    synchronized (monitor()) {
      check_orphaned();
      c c = null;
      c = (c)get_store().find_element_user(ar, 0);
      return c;
    } 
  }
  
  public void f(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ar, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(ar); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void a(c paramc) {
    synchronized (monitor()) {
      check_orphaned();
      c c1 = null;
      c1 = (c)get_store().find_element_user(ar, 0);
      if (c1 == null)
        c1 = (c)get_store().add_element_user(ar); 
      c1.set((XmlObject)paramc);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$6);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$6) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$6);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$6); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$6);
    } 
  }
  
  public String getURI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(as);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI a() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(as);
      return xmlAnyURI;
    } 
  }
  
  public boolean ew() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(as) != null);
    } 
  }
  
  public void bj(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(as);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(as); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void a(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(as);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(as); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void hm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(as);
    } 
  }
  
  public String getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TYPE$10);
      return xmlAnyURI;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$10) != null);
    } 
  }
  
  public void setType(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetType(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TYPE$10);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(TYPE$10); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */