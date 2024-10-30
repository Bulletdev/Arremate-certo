package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

public class CTTblCellMarImpl extends XmlComplexContentImpl implements CTTblCellMar {
  private static final b TOP$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
  
  private static final b LEFT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
  
  private static final b BOTTOM$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
  
  private static final b RIGHT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
  
  public CTTblCellMarImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTblWidth getTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TOP$0, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TOP$0) != 0);
    } 
  }
  
  public void setTop(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TOP$0, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TOP$0); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TOP$0);
      return cTTblWidth;
    } 
  }
  
  public void unsetTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TOP$0, 0);
    } 
  }
  
  public CTTblWidth getLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(LEFT$2, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEFT$2) != 0);
    } 
  }
  
  public void setLeft(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(LEFT$2, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(LEFT$2); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(LEFT$2);
      return cTTblWidth;
    } 
  }
  
  public void unsetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEFT$2, 0);
    } 
  }
  
  public CTTblWidth getBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(BOTTOM$4, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOTTOM$4) != 0);
    } 
  }
  
  public void setBottom(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(BOTTOM$4, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(BOTTOM$4); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(BOTTOM$4);
      return cTTblWidth;
    } 
  }
  
  public void unsetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOTTOM$4, 0);
    } 
  }
  
  public CTTblWidth getRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(RIGHT$6, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetRight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RIGHT$6) != 0);
    } 
  }
  
  public void setRight(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(RIGHT$6, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(RIGHT$6); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(RIGHT$6);
      return cTTblWidth;
    } 
  }
  
  public void unsetRight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RIGHT$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblCellMarImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */