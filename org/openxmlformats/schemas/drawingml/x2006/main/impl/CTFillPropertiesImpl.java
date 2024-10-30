package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;

public class CTFillPropertiesImpl extends XmlComplexContentImpl implements CTFillProperties {
  private static final b NOFILL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  public CTFillPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNoFillProperties getNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$0, 0);
      if (cTNoFillProperties == null)
        return null; 
      return cTNoFillProperties;
    } 
  }
  
  public boolean isSetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOFILL$0) != 0);
    } 
  }
  
  public void setNoFill(CTNoFillProperties paramCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$0, 0);
      if (cTNoFillProperties == null)
        cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$0); 
      cTNoFillProperties.set((XmlObject)paramCTNoFillProperties);
    } 
  }
  
  public CTNoFillProperties addNewNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$0);
      return cTNoFillProperties;
    } 
  }
  
  public void unsetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOFILL$0, 0);
    } 
  }
  
  public CTSolidColorFillProperties getSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$2, 0);
      if (cTSolidColorFillProperties == null)
        return null; 
      return cTSolidColorFillProperties;
    } 
  }
  
  public boolean isSetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SOLIDFILL$2) != 0);
    } 
  }
  
  public void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$2, 0);
      if (cTSolidColorFillProperties == null)
        cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$2); 
      cTSolidColorFillProperties.set((XmlObject)paramCTSolidColorFillProperties);
    } 
  }
  
  public CTSolidColorFillProperties addNewSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$2);
      return cTSolidColorFillProperties;
    } 
  }
  
  public void unsetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOLIDFILL$2, 0);
    } 
  }
  
  public CTGradientFillProperties getGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$4, 0);
      if (cTGradientFillProperties == null)
        return null; 
      return cTGradientFillProperties;
    } 
  }
  
  public boolean isSetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRADFILL$4) != 0);
    } 
  }
  
  public void setGradFill(CTGradientFillProperties paramCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$4, 0);
      if (cTGradientFillProperties == null)
        cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$4); 
      cTGradientFillProperties.set((XmlObject)paramCTGradientFillProperties);
    } 
  }
  
  public CTGradientFillProperties addNewGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$4);
      return cTGradientFillProperties;
    } 
  }
  
  public void unsetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADFILL$4, 0);
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$6, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public boolean isSetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLIPFILL$6) != 0);
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$6, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$6); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$6);
      return cTBlipFillProperties;
    } 
  }
  
  public void unsetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIPFILL$6, 0);
    } 
  }
  
  public CTPatternFillProperties getPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$8, 0);
      if (cTPatternFillProperties == null)
        return null; 
      return cTPatternFillProperties;
    } 
  }
  
  public boolean isSetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTFILL$8) != 0);
    } 
  }
  
  public void setPattFill(CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$8, 0);
      if (cTPatternFillProperties == null)
        cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$8); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$8);
      return cTPatternFillProperties;
    } 
  }
  
  public void unsetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$8, 0);
    } 
  }
  
  public CTGroupFillProperties getGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$10, 0);
      if (cTGroupFillProperties == null)
        return null; 
      return cTGroupFillProperties;
    } 
  }
  
  public boolean isSetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPFILL$10) != 0);
    } 
  }
  
  public void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$10, 0);
      if (cTGroupFillProperties == null)
        cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$10); 
      cTGroupFillProperties.set((XmlObject)paramCTGroupFillProperties);
    } 
  }
  
  public CTGroupFillProperties addNewGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$10);
      return cTGroupFillProperties;
    } 
  }
  
  public void unsetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPFILL$10, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTFillPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */