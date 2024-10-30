package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;

public class CTSchemaImpl extends XmlComplexContentImpl implements CTSchema {
  private static final b ID$0 = new b("", "ID");
  
  private static final b SCHEMAREF$2 = new b("", "SchemaRef");
  
  private static final b NAMESPACE$4 = new b("", "Namespace");
  
  public CTSchemaImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$0);
      return xmlString;
    } 
  }
  
  public void setID(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetID(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ID$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public String getSchemaRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMAREF$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSchemaRef() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SCHEMAREF$2);
      return xmlString;
    } 
  }
  
  public boolean isSetSchemaRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SCHEMAREF$2) != null);
    } 
  }
  
  public void setSchemaRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMAREF$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SCHEMAREF$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSchemaRef(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SCHEMAREF$2);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SCHEMAREF$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetSchemaRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SCHEMAREF$2);
    } 
  }
  
  public String getNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMESPACE$4);
      return xmlString;
    } 
  }
  
  public boolean isSetNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAMESPACE$4) != null);
    } 
  }
  
  public void setNamespace(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAMESPACE$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetNamespace(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMESPACE$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAMESPACE$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetNamespace() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAMESPACE$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSchemaImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */