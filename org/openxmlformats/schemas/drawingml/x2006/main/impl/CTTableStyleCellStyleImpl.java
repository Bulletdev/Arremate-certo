package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCell3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellBorderStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleCellStyle;

public class CTTableStyleCellStyleImpl extends XmlComplexContentImpl implements CTTableStyleCellStyle {
  private static final b TCBDR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tcBdr");
  
  private static final b FILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fill");
  
  private static final b FILLREF$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fillRef");
  
  private static final b CELL3D$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cell3D");
  
  public CTTableStyleCellStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTableCellBorderStyle getTcBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCellBorderStyle cTTableCellBorderStyle = null;
      cTTableCellBorderStyle = (CTTableCellBorderStyle)get_store().find_element_user(TCBDR$0, 0);
      if (cTTableCellBorderStyle == null)
        return null; 
      return cTTableCellBorderStyle;
    } 
  }
  
  public boolean isSetTcBdr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCBDR$0) != 0);
    } 
  }
  
  public void setTcBdr(CTTableCellBorderStyle paramCTTableCellBorderStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCellBorderStyle cTTableCellBorderStyle = null;
      cTTableCellBorderStyle = (CTTableCellBorderStyle)get_store().find_element_user(TCBDR$0, 0);
      if (cTTableCellBorderStyle == null)
        cTTableCellBorderStyle = (CTTableCellBorderStyle)get_store().add_element_user(TCBDR$0); 
      cTTableCellBorderStyle.set((XmlObject)paramCTTableCellBorderStyle);
    } 
  }
  
  public CTTableCellBorderStyle addNewTcBdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCellBorderStyle cTTableCellBorderStyle = null;
      cTTableCellBorderStyle = (CTTableCellBorderStyle)get_store().add_element_user(TCBDR$0);
      return cTTableCellBorderStyle;
    } 
  }
  
  public void unsetTcBdr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCBDR$0, 0);
    } 
  }
  
  public CTFillProperties getFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFillProperties cTFillProperties = null;
      cTFillProperties = (CTFillProperties)get_store().find_element_user(FILL$2, 0);
      if (cTFillProperties == null)
        return null; 
      return cTFillProperties;
    } 
  }
  
  public boolean isSetFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILL$2) != 0);
    } 
  }
  
  public void setFill(CTFillProperties paramCTFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTFillProperties cTFillProperties = null;
      cTFillProperties = (CTFillProperties)get_store().find_element_user(FILL$2, 0);
      if (cTFillProperties == null)
        cTFillProperties = (CTFillProperties)get_store().add_element_user(FILL$2); 
      cTFillProperties.set((XmlObject)paramCTFillProperties);
    } 
  }
  
  public CTFillProperties addNewFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFillProperties cTFillProperties = null;
      cTFillProperties = (CTFillProperties)get_store().add_element_user(FILL$2);
      return cTFillProperties;
    } 
  }
  
  public void unsetFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILL$2, 0);
    } 
  }
  
  public CTStyleMatrixReference getFillRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(FILLREF$4, 0);
      if (cTStyleMatrixReference == null)
        return null; 
      return cTStyleMatrixReference;
    } 
  }
  
  public boolean isSetFillRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILLREF$4) != 0);
    } 
  }
  
  public void setFillRef(CTStyleMatrixReference paramCTStyleMatrixReference) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().find_element_user(FILLREF$4, 0);
      if (cTStyleMatrixReference == null)
        cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(FILLREF$4); 
      cTStyleMatrixReference.set((XmlObject)paramCTStyleMatrixReference);
    } 
  }
  
  public CTStyleMatrixReference addNewFillRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyleMatrixReference cTStyleMatrixReference = null;
      cTStyleMatrixReference = (CTStyleMatrixReference)get_store().add_element_user(FILLREF$4);
      return cTStyleMatrixReference;
    } 
  }
  
  public void unsetFillRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILLREF$4, 0);
    } 
  }
  
  public CTCell3D getCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTCell3D cTCell3D = null;
      cTCell3D = (CTCell3D)get_store().find_element_user(CELL3D$6, 0);
      if (cTCell3D == null)
        return null; 
      return cTCell3D;
    } 
  }
  
  public boolean isSetCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELL3D$6) != 0);
    } 
  }
  
  public void setCell3D(CTCell3D paramCTCell3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTCell3D cTCell3D = null;
      cTCell3D = (CTCell3D)get_store().find_element_user(CELL3D$6, 0);
      if (cTCell3D == null)
        cTCell3D = (CTCell3D)get_store().add_element_user(CELL3D$6); 
      cTCell3D.set((XmlObject)paramCTCell3D);
    } 
  }
  
  public CTCell3D addNewCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTCell3D cTCell3D = null;
      cTCell3D = (CTCell3D)get_store().add_element_user(CELL3D$6);
      return cTCell3D;
    } 
  }
  
  public void unsetCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELL3D$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableStyleCellStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */