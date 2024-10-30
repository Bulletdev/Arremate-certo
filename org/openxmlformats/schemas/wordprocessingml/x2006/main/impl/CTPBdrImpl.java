package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;

public class CTPBdrImpl extends XmlComplexContentImpl implements CTPBdr {
  private static final b TOP$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
  
  private static final b LEFT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
  
  private static final b BOTTOM$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
  
  private static final b RIGHT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
  
  private static final b BETWEEN$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "between");
  
  private static final b BAR$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bar");
  
  public CTPBdrImpl(SchemaType paramSchemaType) {
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
  
  public CTBorder getBetween() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BETWEEN$8, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetBetween() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BETWEEN$8) != 0);
    } 
  }
  
  public void setBetween(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BETWEEN$8, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(BETWEEN$8); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewBetween() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BETWEEN$8);
      return cTBorder;
    } 
  }
  
  public void unsetBetween() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BETWEEN$8, 0);
    } 
  }
  
  public CTBorder getBar() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BAR$10, 0);
      if (cTBorder == null)
        return null; 
      return cTBorder;
    } 
  }
  
  public boolean isSetBar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BAR$10) != 0);
    } 
  }
  
  public void setBar(CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BAR$10, 0);
      if (cTBorder == null)
        cTBorder = (CTBorder)get_store().add_element_user(BAR$10); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder addNewBar() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BAR$10);
      return cTBorder;
    } 
  }
  
  public void unsetBar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BAR$10, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTPBdrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */