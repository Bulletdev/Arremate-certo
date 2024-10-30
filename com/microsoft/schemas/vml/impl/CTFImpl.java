package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTF;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTFImpl extends XmlComplexContentImpl implements CTF {
  private static final b EQN$0 = new b("", "eqn");
  
  public CTFImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getEqn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EQN$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetEqn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(EQN$0);
      return xmlString;
    } 
  }
  
  public boolean isSetEqn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EQN$0) != null);
    } 
  }
  
  public void setEqn(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EQN$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EQN$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetEqn(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(EQN$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(EQN$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetEqn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EQN$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTFImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */