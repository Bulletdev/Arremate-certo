package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;

public class CTTcBordersImpl extends XmlComplexContentImpl implements CTTcBorders {
  private static final b TOP$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
  
  private static final b LEFT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
  
  private static final b BOTTOM$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
  
  private static final b RIGHT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
  
  private static final b INSIDEH$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "insideH");
  
  private static final b INSIDEV$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "insideV");
  
  private static final b TL2BR$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tl2br");
  
  private static final b TR2BL$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tr2bl");
  
  public CTTcBordersImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBorder getTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(TOP$0, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TOP$0) != 0);
    } 
  }
  
  public void setTop(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(TOP$0, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(TOP$0); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(TOP$0);
      return cTBorder;
    } 
  }
  
  public void unsetTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TOP$0, 0);
    } 
  }
  
  public CTBorder getLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(LEFT$2, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEFT$2) != 0);
    } 
  }
  
  public void setLeft(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(LEFT$2, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(LEFT$2); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(LEFT$2);
      return cTBorder;
    } 
  }
  
  public void unsetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEFT$2, 0);
    } 
  }
  
  public CTBorder getBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BOTTOM$4, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOTTOM$4) != 0);
    } 
  }
  
  public void setBottom(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BOTTOM$4, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(BOTTOM$4); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BOTTOM$4);
      return cTBorder;
    } 
  }
  
  public void unsetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOTTOM$4, 0);
    } 
  }
  
  public CTBorder getRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(RIGHT$6, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetRight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RIGHT$6) != 0);
    } 
  }
  
  public void setRight(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(RIGHT$6, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(RIGHT$6); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(RIGHT$6);
      return cTBorder;
    } 
  }
  
  public void unsetRight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RIGHT$6, 0);
    } 
  }
  
  public CTBorder getInsideH() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(INSIDEH$8, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetInsideH() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(INSIDEH$8) != 0);
    } 
  }
  
  public void setInsideH(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(INSIDEH$8, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(INSIDEH$8); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewInsideH() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(INSIDEH$8);
      return cTBorder;
    } 
  }
  
  public void unsetInsideH() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INSIDEH$8, 0);
    } 
  }
  
  public CTBorder getInsideV() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(INSIDEV$10, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetInsideV() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(INSIDEV$10) != 0);
    } 
  }
  
  public void setInsideV(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(INSIDEV$10, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(INSIDEV$10); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewInsideV() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(INSIDEV$10);
      return cTBorder;
    } 
  }
  
  public void unsetInsideV() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INSIDEV$10, 0);
    } 
  }
  
  public CTBorder getTl2Br() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(TL2BR$12, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetTl2Br() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TL2BR$12) != 0);
    } 
  }
  
  public void setTl2Br(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(TL2BR$12, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(TL2BR$12); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewTl2Br() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(TL2BR$12);
      return cTBorder;
    } 
  }
  
  public void unsetTl2Br() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TL2BR$12, 0);
    } 
  }
  
  public CTBorder getTr2Bl() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(TR2BL$14, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetTr2Bl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TR2BL$14) != 0);
    } 
  }
  
  public void setTr2Bl(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(TR2BL$14, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(TR2BL$14); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewTr2Bl() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(TR2BL$14);
      return cTBorder;
    } 
  }
  
  public void unsetTr2Bl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TR2BL$14, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTcBordersImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */