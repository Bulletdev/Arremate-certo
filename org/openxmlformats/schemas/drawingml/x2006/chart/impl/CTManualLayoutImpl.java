package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout;

public class CTManualLayoutImpl extends XmlComplexContentImpl implements CTManualLayout {
  private static final b LAYOUTTARGET$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "layoutTarget");
  
  private static final b XMODE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "xMode");
  
  private static final b YMODE$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "yMode");
  
  private static final b WMODE$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "wMode");
  
  private static final b HMODE$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "hMode");
  
  private static final b X$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "x");
  
  private static final b Y$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "y");
  
  private static final b W$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "w");
  
  private static final b H$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "h");
  
  private static final b EXTLST$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTManualLayoutImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLayoutTarget getLayoutTarget() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutTarget cTLayoutTarget = null;
      cTLayoutTarget = (CTLayoutTarget)get_store().find_element_user(LAYOUTTARGET$0, 0);
      if (cTLayoutTarget == null)
        return null; 
      return cTLayoutTarget;
    } 
  }
  
  public boolean isSetLayoutTarget() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LAYOUTTARGET$0) != 0);
    } 
  }
  
  public void setLayoutTarget(CTLayoutTarget paramCTLayoutTarget) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutTarget cTLayoutTarget = null;
      cTLayoutTarget = (CTLayoutTarget)get_store().find_element_user(LAYOUTTARGET$0, 0);
      if (cTLayoutTarget == null)
        cTLayoutTarget = (CTLayoutTarget)get_store().add_element_user(LAYOUTTARGET$0); 
      cTLayoutTarget.set((XmlObject)paramCTLayoutTarget);
    } 
  }
  
  public CTLayoutTarget addNewLayoutTarget() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutTarget cTLayoutTarget = null;
      cTLayoutTarget = (CTLayoutTarget)get_store().add_element_user(LAYOUTTARGET$0);
      return cTLayoutTarget;
    } 
  }
  
  public void unsetLayoutTarget() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LAYOUTTARGET$0, 0);
    } 
  }
  
  public CTLayoutMode getXMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(XMODE$2, 0);
      if (cTLayoutMode == null)
        return null; 
      return cTLayoutMode;
    } 
  }
  
  public boolean isSetXMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(XMODE$2) != 0);
    } 
  }
  
  public void setXMode(CTLayoutMode paramCTLayoutMode) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(XMODE$2, 0);
      if (cTLayoutMode == null)
        cTLayoutMode = (CTLayoutMode)get_store().add_element_user(XMODE$2); 
      cTLayoutMode.set((XmlObject)paramCTLayoutMode);
    } 
  }
  
  public CTLayoutMode addNewXMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().add_element_user(XMODE$2);
      return cTLayoutMode;
    } 
  }
  
  public void unsetXMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(XMODE$2, 0);
    } 
  }
  
  public CTLayoutMode getYMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(YMODE$4, 0);
      if (cTLayoutMode == null)
        return null; 
      return cTLayoutMode;
    } 
  }
  
  public boolean isSetYMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(YMODE$4) != 0);
    } 
  }
  
  public void setYMode(CTLayoutMode paramCTLayoutMode) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(YMODE$4, 0);
      if (cTLayoutMode == null)
        cTLayoutMode = (CTLayoutMode)get_store().add_element_user(YMODE$4); 
      cTLayoutMode.set((XmlObject)paramCTLayoutMode);
    } 
  }
  
  public CTLayoutMode addNewYMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().add_element_user(YMODE$4);
      return cTLayoutMode;
    } 
  }
  
  public void unsetYMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(YMODE$4, 0);
    } 
  }
  
  public CTLayoutMode getWMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(WMODE$6, 0);
      if (cTLayoutMode == null)
        return null; 
      return cTLayoutMode;
    } 
  }
  
  public boolean isSetWMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WMODE$6) != 0);
    } 
  }
  
  public void setWMode(CTLayoutMode paramCTLayoutMode) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(WMODE$6, 0);
      if (cTLayoutMode == null)
        cTLayoutMode = (CTLayoutMode)get_store().add_element_user(WMODE$6); 
      cTLayoutMode.set((XmlObject)paramCTLayoutMode);
    } 
  }
  
  public CTLayoutMode addNewWMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().add_element_user(WMODE$6);
      return cTLayoutMode;
    } 
  }
  
  public void unsetWMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WMODE$6, 0);
    } 
  }
  
  public CTLayoutMode getHMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(HMODE$8, 0);
      if (cTLayoutMode == null)
        return null; 
      return cTLayoutMode;
    } 
  }
  
  public boolean isSetHMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HMODE$8) != 0);
    } 
  }
  
  public void setHMode(CTLayoutMode paramCTLayoutMode) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().find_element_user(HMODE$8, 0);
      if (cTLayoutMode == null)
        cTLayoutMode = (CTLayoutMode)get_store().add_element_user(HMODE$8); 
      cTLayoutMode.set((XmlObject)paramCTLayoutMode);
    } 
  }
  
  public CTLayoutMode addNewHMode() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayoutMode cTLayoutMode = null;
      cTLayoutMode = (CTLayoutMode)get_store().add_element_user(HMODE$8);
      return cTLayoutMode;
    } 
  }
  
  public void unsetHMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HMODE$8, 0);
    } 
  }
  
  public CTDouble getX() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(X$10, 0);
      if (cTDouble == null)
        return null; 
      return cTDouble;
    } 
  }
  
  public boolean isSetX() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(X$10) != 0);
    } 
  }
  
  public void setX(CTDouble paramCTDouble) {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(X$10, 0);
      if (cTDouble == null)
        cTDouble = (CTDouble)get_store().add_element_user(X$10); 
      cTDouble.set((XmlObject)paramCTDouble);
    } 
  }
  
  public CTDouble addNewX() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().add_element_user(X$10);
      return cTDouble;
    } 
  }
  
  public void unsetX() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(X$10, 0);
    } 
  }
  
  public CTDouble getY() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(Y$12, 0);
      if (cTDouble == null)
        return null; 
      return cTDouble;
    } 
  }
  
  public boolean isSetY() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(Y$12) != 0);
    } 
  }
  
  public void setY(CTDouble paramCTDouble) {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(Y$12, 0);
      if (cTDouble == null)
        cTDouble = (CTDouble)get_store().add_element_user(Y$12); 
      cTDouble.set((XmlObject)paramCTDouble);
    } 
  }
  
  public CTDouble addNewY() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().add_element_user(Y$12);
      return cTDouble;
    } 
  }
  
  public void unsetY() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(Y$12, 0);
    } 
  }
  
  public CTDouble getW() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(W$14, 0);
      if (cTDouble == null)
        return null; 
      return cTDouble;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(W$14) != 0);
    } 
  }
  
  public void setW(CTDouble paramCTDouble) {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(W$14, 0);
      if (cTDouble == null)
        cTDouble = (CTDouble)get_store().add_element_user(W$14); 
      cTDouble.set((XmlObject)paramCTDouble);
    } 
  }
  
  public CTDouble addNewW() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().add_element_user(W$14);
      return cTDouble;
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(W$14, 0);
    } 
  }
  
  public CTDouble getH() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(H$16, 0);
      if (cTDouble == null)
        return null; 
      return cTDouble;
    } 
  }
  
  public boolean isSetH() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(H$16) != 0);
    } 
  }
  
  public void setH(CTDouble paramCTDouble) {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().find_element_user(H$16, 0);
      if (cTDouble == null)
        cTDouble = (CTDouble)get_store().add_element_user(H$16); 
      cTDouble.set((XmlObject)paramCTDouble);
    } 
  }
  
  public CTDouble addNewH() {
    synchronized (monitor()) {
      check_orphaned();
      CTDouble cTDouble = null;
      cTDouble = (CTDouble)get_store().add_element_user(H$16);
      return cTDouble;
    } 
  }
  
  public void unsetH() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(H$16, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$18, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$18) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$18, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$18); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$18);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$18, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTManualLayoutImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */