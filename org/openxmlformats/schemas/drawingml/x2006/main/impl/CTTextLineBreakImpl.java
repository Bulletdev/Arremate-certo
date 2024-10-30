package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;

public class CTTextLineBreakImpl extends XmlComplexContentImpl implements CTTextLineBreak {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr");
  
  public CTTextLineBreakImpl(SchemaType paramSchemaType) {
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
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextLineBreakImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */