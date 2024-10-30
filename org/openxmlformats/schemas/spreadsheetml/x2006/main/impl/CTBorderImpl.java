package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;

public class CTBorderImpl extends XmlComplexContentImpl implements CTBorder {
  private static final b LEFT$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "left");
  
  private static final b RIGHT$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "right");
  
  private static final b TOP$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "top");
  
  private static final b BOTTOM$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "bottom");
  
  private static final b DIAGONAL$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "diagonal");
  
  private static final b VERTICAL$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "vertical");
  
  private static final b HORIZONTAL$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "horizontal");
  
  private static final b DIAGONALUP$14 = new b("", "diagonalUp");
  
  private static final b DIAGONALDOWN$16 = new b("", "diagonalDown");
  
  private static final b OUTLINE$18 = new b("", "outline");
  
  public CTBorderImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBorderPr getLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(LEFT$0, 0);
      if (cTBorderPr == null)
        return null; 
      return cTBorderPr;
    } 
  }
  
  public boolean isSetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEFT$0) != 0);
    } 
  }
  
  public void setLeft(CTBorderPr paramCTBorderPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(LEFT$0, 0);
      if (cTBorderPr == null)
        cTBorderPr = (CTBorderPr)get_store().add_element_user(LEFT$0); 
      cTBorderPr.set((XmlObject)paramCTBorderPr);
    } 
  }
  
  public CTBorderPr addNewLeft() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().add_element_user(LEFT$0);
      return cTBorderPr;
    } 
  }
  
  public void unsetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEFT$0, 0);
    } 
  }
  
  public CTBorderPr getRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(RIGHT$2, 0);
      if (cTBorderPr == null)
        return null; 
      return cTBorderPr;
    } 
  }
  
  public boolean isSetRight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RIGHT$2) != 0);
    } 
  }
  
  public void setRight(CTBorderPr paramCTBorderPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(RIGHT$2, 0);
      if (cTBorderPr == null)
        cTBorderPr = (CTBorderPr)get_store().add_element_user(RIGHT$2); 
      cTBorderPr.set((XmlObject)paramCTBorderPr);
    } 
  }
  
  public CTBorderPr addNewRight() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().add_element_user(RIGHT$2);
      return cTBorderPr;
    } 
  }
  
  public void unsetRight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RIGHT$2, 0);
    } 
  }
  
  public CTBorderPr getTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(TOP$4, 0);
      if (cTBorderPr == null)
        return null; 
      return cTBorderPr;
    } 
  }
  
  public boolean isSetTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TOP$4) != 0);
    } 
  }
  
  public void setTop(CTBorderPr paramCTBorderPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(TOP$4, 0);
      if (cTBorderPr == null)
        cTBorderPr = (CTBorderPr)get_store().add_element_user(TOP$4); 
      cTBorderPr.set((XmlObject)paramCTBorderPr);
    } 
  }
  
  public CTBorderPr addNewTop() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().add_element_user(TOP$4);
      return cTBorderPr;
    } 
  }
  
  public void unsetTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TOP$4, 0);
    } 
  }
  
  public CTBorderPr getBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(BOTTOM$6, 0);
      if (cTBorderPr == null)
        return null; 
      return cTBorderPr;
    } 
  }
  
  public boolean isSetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOTTOM$6) != 0);
    } 
  }
  
  public void setBottom(CTBorderPr paramCTBorderPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(BOTTOM$6, 0);
      if (cTBorderPr == null)
        cTBorderPr = (CTBorderPr)get_store().add_element_user(BOTTOM$6); 
      cTBorderPr.set((XmlObject)paramCTBorderPr);
    } 
  }
  
  public CTBorderPr addNewBottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().add_element_user(BOTTOM$6);
      return cTBorderPr;
    } 
  }
  
  public void unsetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOTTOM$6, 0);
    } 
  }
  
  public CTBorderPr getDiagonal() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(DIAGONAL$8, 0);
      if (cTBorderPr == null)
        return null; 
      return cTBorderPr;
    } 
  }
  
  public boolean isSetDiagonal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DIAGONAL$8) != 0);
    } 
  }
  
  public void setDiagonal(CTBorderPr paramCTBorderPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(DIAGONAL$8, 0);
      if (cTBorderPr == null)
        cTBorderPr = (CTBorderPr)get_store().add_element_user(DIAGONAL$8); 
      cTBorderPr.set((XmlObject)paramCTBorderPr);
    } 
  }
  
  public CTBorderPr addNewDiagonal() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().add_element_user(DIAGONAL$8);
      return cTBorderPr;
    } 
  }
  
  public void unsetDiagonal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DIAGONAL$8, 0);
    } 
  }
  
  public CTBorderPr getVertical() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(VERTICAL$10, 0);
      if (cTBorderPr == null)
        return null; 
      return cTBorderPr;
    } 
  }
  
  public boolean isSetVertical() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VERTICAL$10) != 0);
    } 
  }
  
  public void setVertical(CTBorderPr paramCTBorderPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(VERTICAL$10, 0);
      if (cTBorderPr == null)
        cTBorderPr = (CTBorderPr)get_store().add_element_user(VERTICAL$10); 
      cTBorderPr.set((XmlObject)paramCTBorderPr);
    } 
  }
  
  public CTBorderPr addNewVertical() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().add_element_user(VERTICAL$10);
      return cTBorderPr;
    } 
  }
  
  public void unsetVertical() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VERTICAL$10, 0);
    } 
  }
  
  public CTBorderPr getHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(HORIZONTAL$12, 0);
      if (cTBorderPr == null)
        return null; 
      return cTBorderPr;
    } 
  }
  
  public boolean isSetHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HORIZONTAL$12) != 0);
    } 
  }
  
  public void setHorizontal(CTBorderPr paramCTBorderPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().find_element_user(HORIZONTAL$12, 0);
      if (cTBorderPr == null)
        cTBorderPr = (CTBorderPr)get_store().add_element_user(HORIZONTAL$12); 
      cTBorderPr.set((XmlObject)paramCTBorderPr);
    } 
  }
  
  public CTBorderPr addNewHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorderPr cTBorderPr = null;
      cTBorderPr = (CTBorderPr)get_store().add_element_user(HORIZONTAL$12);
      return cTBorderPr;
    } 
  }
  
  public void unsetHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HORIZONTAL$12, 0);
    } 
  }
  
  public boolean getDiagonalUp() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIAGONALUP$14);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDiagonalUp() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIAGONALUP$14);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDiagonalUp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIAGONALUP$14) != null);
    } 
  }
  
  public void setDiagonalUp(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIAGONALUP$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIAGONALUP$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDiagonalUp(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIAGONALUP$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DIAGONALUP$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDiagonalUp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIAGONALUP$14);
    } 
  }
  
  public boolean getDiagonalDown() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIAGONALDOWN$16);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDiagonalDown() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIAGONALDOWN$16);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDiagonalDown() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIAGONALDOWN$16) != null);
    } 
  }
  
  public void setDiagonalDown(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIAGONALDOWN$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIAGONALDOWN$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDiagonalDown(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DIAGONALDOWN$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DIAGONALDOWN$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDiagonalDown() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIAGONALDOWN$16);
    } 
  }
  
  public boolean getOutline() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINE$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(OUTLINE$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINE$18) != null);
    } 
  }
  
  public void setOutline(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINE$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetOutline(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(OUTLINE$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINE$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTBorderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */