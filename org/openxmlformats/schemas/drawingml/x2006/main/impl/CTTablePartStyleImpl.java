package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleCellStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;

public class CTTablePartStyleImpl extends XmlComplexContentImpl implements CTTablePartStyle {
  private static final b TCTXSTYLE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tcTxStyle");
  
  private static final b TCSTYLE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tcStyle");
  
  public CTTablePartStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTableStyleTextStyle getTcTxStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleTextStyle cTTableStyleTextStyle = null;
      cTTableStyleTextStyle = (CTTableStyleTextStyle)get_store().find_element_user(TCTXSTYLE$0, 0);
      if (cTTableStyleTextStyle == null)
        return null; 
      return cTTableStyleTextStyle;
    } 
  }
  
  public boolean isSetTcTxStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCTXSTYLE$0) != 0);
    } 
  }
  
  public void setTcTxStyle(CTTableStyleTextStyle paramCTTableStyleTextStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleTextStyle cTTableStyleTextStyle = null;
      cTTableStyleTextStyle = (CTTableStyleTextStyle)get_store().find_element_user(TCTXSTYLE$0, 0);
      if (cTTableStyleTextStyle == null)
        cTTableStyleTextStyle = (CTTableStyleTextStyle)get_store().add_element_user(TCTXSTYLE$0); 
      cTTableStyleTextStyle.set((XmlObject)paramCTTableStyleTextStyle);
    } 
  }
  
  public CTTableStyleTextStyle addNewTcTxStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleTextStyle cTTableStyleTextStyle = null;
      cTTableStyleTextStyle = (CTTableStyleTextStyle)get_store().add_element_user(TCTXSTYLE$0);
      return cTTableStyleTextStyle;
    } 
  }
  
  public void unsetTcTxStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCTXSTYLE$0, 0);
    } 
  }
  
  public CTTableStyleCellStyle getTcStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleCellStyle cTTableStyleCellStyle = null;
      cTTableStyleCellStyle = (CTTableStyleCellStyle)get_store().find_element_user(TCSTYLE$2, 0);
      if (cTTableStyleCellStyle == null)
        return null; 
      return cTTableStyleCellStyle;
    } 
  }
  
  public boolean isSetTcStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCSTYLE$2) != 0);
    } 
  }
  
  public void setTcStyle(CTTableStyleCellStyle paramCTTableStyleCellStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleCellStyle cTTableStyleCellStyle = null;
      cTTableStyleCellStyle = (CTTableStyleCellStyle)get_store().find_element_user(TCSTYLE$2, 0);
      if (cTTableStyleCellStyle == null)
        cTTableStyleCellStyle = (CTTableStyleCellStyle)get_store().add_element_user(TCSTYLE$2); 
      cTTableStyleCellStyle.set((XmlObject)paramCTTableStyleCellStyle);
    } 
  }
  
  public CTTableStyleCellStyle addNewTcStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleCellStyle cTTableStyleCellStyle = null;
      cTTableStyleCellStyle = (CTTableStyleCellStyle)get_store().add_element_user(TCSTYLE$2);
      return cTTableStyleCellStyle;
    } 
  }
  
  public void unsetTcStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCSTYLE$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTablePartStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */