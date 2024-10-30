package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.STGeomGuideFormula;
import org.openxmlformats.schemas.drawingml.x2006.main.STGeomGuideName;

public class CTGeomGuideImpl extends XmlComplexContentImpl implements CTGeomGuide {
  private static final b NAME$0 = new b("", "name");
  
  private static final b FMLA$2 = new b("", "fmla");
  
  public CTGeomGuideImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STGeomGuideName xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STGeomGuideName sTGeomGuideName = null;
      sTGeomGuideName = (STGeomGuideName)get_store().find_attribute_user(NAME$0);
      return sTGeomGuideName;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STGeomGuideName paramSTGeomGuideName) {
    synchronized (monitor()) {
      check_orphaned();
      STGeomGuideName sTGeomGuideName = null;
      sTGeomGuideName = (STGeomGuideName)get_store().find_attribute_user(NAME$0);
      if (sTGeomGuideName == null)
        sTGeomGuideName = (STGeomGuideName)get_store().add_attribute_user(NAME$0); 
      sTGeomGuideName.set((XmlObject)paramSTGeomGuideName);
    } 
  }
  
  public String getFmla() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FMLA$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STGeomGuideFormula xgetFmla() {
    synchronized (monitor()) {
      check_orphaned();
      STGeomGuideFormula sTGeomGuideFormula = null;
      sTGeomGuideFormula = (STGeomGuideFormula)get_store().find_attribute_user(FMLA$2);
      return sTGeomGuideFormula;
    } 
  }
  
  public void setFmla(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FMLA$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FMLA$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFmla(STGeomGuideFormula paramSTGeomGuideFormula) {
    synchronized (monitor()) {
      check_orphaned();
      STGeomGuideFormula sTGeomGuideFormula = null;
      sTGeomGuideFormula = (STGeomGuideFormula)get_store().find_attribute_user(FMLA$2);
      if (sTGeomGuideFormula == null)
        sTGeomGuideFormula = (STGeomGuideFormula)get_store().add_attribute_user(FMLA$2); 
      sTGeomGuideFormula.set((XmlObject)paramSTGeomGuideFormula);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGeomGuideImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */