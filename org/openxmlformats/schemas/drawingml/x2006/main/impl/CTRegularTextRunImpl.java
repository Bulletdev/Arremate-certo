package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

public class CTRegularTextRunImpl extends XmlComplexContentImpl implements CTRegularTextRun {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr");
  
  private static final b T$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "t");
  
  public CTRegularTextRunImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextCharacterProperties getRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().find_element_user(RPR$0, 0);
      if (cTTextCharacterProperties == null)
        return null; 
      return cTTextCharacterProperties;
    } 
  }
  
  public boolean isSetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPR$0) != 0);
    } 
  }
  
  public void setRPr(CTTextCharacterProperties paramCTTextCharacterProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().find_element_user(RPR$0, 0);
      if (cTTextCharacterProperties == null)
        cTTextCharacterProperties = (CTTextCharacterProperties)get_store().add_element_user(RPR$0); 
      cTTextCharacterProperties.set((XmlObject)paramCTTextCharacterProperties);
    } 
  }
  
  public CTTextCharacterProperties addNewRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().add_element_user(RPR$0);
      return cTTextCharacterProperties;
    } 
  }
  
  public void unsetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$0, 0);
    } 
  }
  
  public String getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(T$2, 0);
      return xmlString;
    } 
  }
  
  public void setT(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(T$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetT(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(T$2, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(T$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTRegularTextRunImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */