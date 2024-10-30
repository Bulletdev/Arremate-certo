package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

public class CTTextFieldImpl extends XmlComplexContentImpl implements CTTextField {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr");
  
  private static final b PPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pPr");
  
  private static final b T$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "t");
  
  private static final b ID$6 = new b("", "id");
  
  private static final b TYPE$8 = new b("", "type");
  
  public CTTextFieldImpl(SchemaType paramSchemaType) {
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
  
  public CTTextParagraphProperties getPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(PPR$2, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PPR$2) != 0);
    } 
  }
  
  public void setPPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(PPR$2, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(PPR$2); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(PPR$2);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PPR$2, 0);
    } 
  }
  
  public String getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$4, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(T$4, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(T$4) != 0);
    } 
  }
  
  public void setT(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$4, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(T$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetT(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(T$4, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(T$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(T$4, 0);
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
  
  public STGuid xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(ID$6);
      return sTGuid;
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
  
  public void xsetId(STGuid paramSTGuid) {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(ID$6);
      if (sTGuid == null)
        sTGuid = (STGuid)get_store().add_attribute_user(ID$6); 
      sTGuid.set((XmlObject)paramSTGuid);
    } 
  }
  
  public String getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TYPE$8);
      return xmlString;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$8) != null);
    } 
  }
  
  public void setType(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetType(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TYPE$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TYPE$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextFieldImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */