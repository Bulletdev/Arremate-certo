package org.f.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.f.a.a.a.j;
import org.w3.x2000.x09.xmldsig.impl.TransformTypeImpl;

public class j extends XmlComplexContentImpl implements j {
  private static final b XPATH$0 = new b("http://www.w3.org/2000/09/xmldsig#", "XPath");
  
  private static final b aC = new b("", "Algorithm");
  
  public j(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<String> bE() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new TransformTypeImpl.XPathList((TransformTypeImpl)this);
    } 
  }
  
  public String[] p() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(XPATH$0, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String v(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(XPATH$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> bF() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new TransformTypeImpl.XPathList((TransformTypeImpl)this);
    } 
  }
  
  public XmlString[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(XPATH$0, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(XPATH$0, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int ck() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(XPATH$0);
    } 
  }
  
  public void m(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, XPATH$0);
    } 
  }
  
  public void b(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(XPATH$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void a(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, XPATH$0);
    } 
  }
  
  public void a(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(XPATH$0, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void c(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(XPATH$0, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void bP(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(XPATH$0);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(XPATH$0, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString d() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(XPATH$0);
      return xmlString;
    } 
  }
  
  public void bB(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(XPATH$0, paramInt);
    } 
  }
  
  public String getAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(aC);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI c() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(aC);
      return xmlAnyURI;
    } 
  }
  
  public void setAlgorithm(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(aC);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(aC); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void c(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(aC);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(aC); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\f\a\a\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */