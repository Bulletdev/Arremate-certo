package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint;

public class CTTextSpacingImpl extends XmlComplexContentImpl implements CTTextSpacing {
  private static final b SPCPCT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "spcPct");
  
  private static final b SPCPTS$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "spcPts");
  
  public CTTextSpacingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextSpacingPercent getSpcPct() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacingPercent cTTextSpacingPercent = null;
      cTTextSpacingPercent = (CTTextSpacingPercent)get_store().find_element_user(SPCPCT$0, 0);
      if (cTTextSpacingPercent == null)
        return null; 
      return cTTextSpacingPercent;
    } 
  }
  
  public boolean isSetSpcPct() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPCPCT$0) != 0);
    } 
  }
  
  public void setSpcPct(CTTextSpacingPercent paramCTTextSpacingPercent) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacingPercent cTTextSpacingPercent = null;
      cTTextSpacingPercent = (CTTextSpacingPercent)get_store().find_element_user(SPCPCT$0, 0);
      if (cTTextSpacingPercent == null)
        cTTextSpacingPercent = (CTTextSpacingPercent)get_store().add_element_user(SPCPCT$0); 
      cTTextSpacingPercent.set((XmlObject)paramCTTextSpacingPercent);
    } 
  }
  
  public CTTextSpacingPercent addNewSpcPct() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacingPercent cTTextSpacingPercent = null;
      cTTextSpacingPercent = (CTTextSpacingPercent)get_store().add_element_user(SPCPCT$0);
      return cTTextSpacingPercent;
    } 
  }
  
  public void unsetSpcPct() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPCPCT$0, 0);
    } 
  }
  
  public CTTextSpacingPoint getSpcPts() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacingPoint cTTextSpacingPoint = null;
      cTTextSpacingPoint = (CTTextSpacingPoint)get_store().find_element_user(SPCPTS$2, 0);
      if (cTTextSpacingPoint == null)
        return null; 
      return cTTextSpacingPoint;
    } 
  }
  
  public boolean isSetSpcPts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPCPTS$2) != 0);
    } 
  }
  
  public void setSpcPts(CTTextSpacingPoint paramCTTextSpacingPoint) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacingPoint cTTextSpacingPoint = null;
      cTTextSpacingPoint = (CTTextSpacingPoint)get_store().find_element_user(SPCPTS$2, 0);
      if (cTTextSpacingPoint == null)
        cTTextSpacingPoint = (CTTextSpacingPoint)get_store().add_element_user(SPCPTS$2); 
      cTTextSpacingPoint.set((XmlObject)paramCTTextSpacingPoint);
    } 
  }
  
  public CTTextSpacingPoint addNewSpcPts() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextSpacingPoint cTTextSpacingPoint = null;
      cTTextSpacingPoint = (CTTextSpacingPoint)get_store().add_element_user(SPCPTS$2);
      return cTTextSpacingPoint;
    } 
  }
  
  public void unsetSpcPts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPCPTS$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextSpacingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */