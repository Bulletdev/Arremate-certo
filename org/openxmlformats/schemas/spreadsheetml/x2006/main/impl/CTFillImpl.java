package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTGradientFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;

public class CTFillImpl extends XmlComplexContentImpl implements CTFill {
  private static final b PATTERNFILL$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "patternFill");
  
  private static final b GRADIENTFILL$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "gradientFill");
  
  public CTFillImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPatternFill getPatternFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFill cTPatternFill = null;
      cTPatternFill = (CTPatternFill)get_store().find_element_user(PATTERNFILL$0, 0);
      if (cTPatternFill == null)
        return null; 
      return cTPatternFill;
    } 
  }
  
  public boolean isSetPatternFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTERNFILL$0) != 0);
    } 
  }
  
  public void setPatternFill(CTPatternFill paramCTPatternFill) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFill cTPatternFill = null;
      cTPatternFill = (CTPatternFill)get_store().find_element_user(PATTERNFILL$0, 0);
      if (cTPatternFill == null)
        cTPatternFill = (CTPatternFill)get_store().add_element_user(PATTERNFILL$0); 
      cTPatternFill.set((XmlObject)paramCTPatternFill);
    } 
  }
  
  public CTPatternFill addNewPatternFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFill cTPatternFill = null;
      cTPatternFill = (CTPatternFill)get_store().add_element_user(PATTERNFILL$0);
      return cTPatternFill;
    } 
  }
  
  public void unsetPatternFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTERNFILL$0, 0);
    } 
  }
  
  public CTGradientFill getGradientFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFill cTGradientFill = null;
      cTGradientFill = (CTGradientFill)get_store().find_element_user(GRADIENTFILL$2, 0);
      if (cTGradientFill == null)
        return null; 
      return cTGradientFill;
    } 
  }
  
  public boolean isSetGradientFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRADIENTFILL$2) != 0);
    } 
  }
  
  public void setGradientFill(CTGradientFill paramCTGradientFill) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFill cTGradientFill = null;
      cTGradientFill = (CTGradientFill)get_store().find_element_user(GRADIENTFILL$2, 0);
      if (cTGradientFill == null)
        cTGradientFill = (CTGradientFill)get_store().add_element_user(GRADIENTFILL$2); 
      cTGradientFill.set((XmlObject)paramCTGradientFill);
    } 
  }
  
  public CTGradientFill addNewGradientFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFill cTGradientFill = null;
      cTGradientFill = (CTGradientFill)get_store().add_element_user(GRADIENTFILL$2);
      return cTGradientFill;
    } 
  }
  
  public void unsetGradientFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADIENTFILL$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFillImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */