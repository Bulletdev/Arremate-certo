package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

public class CTTblPrExBaseImpl extends XmlComplexContentImpl implements CTTblPrExBase {
  private static final b TBLW$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblW");
  
  private static final b JC$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
  
  private static final b TBLCELLSPACING$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing");
  
  private static final b TBLIND$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblInd");
  
  private static final b TBLBORDERS$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblBorders");
  
  private static final b SHD$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
  
  private static final b TBLLAYOUT$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLayout");
  
  private static final b TBLCELLMAR$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellMar");
  
  private static final b TBLLOOK$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLook");
  
  public CTTblPrExBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTblWidth getTblW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLW$0, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTblW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLW$0) != 0);
    } 
  }
  
  public void setTblW(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLW$0, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLW$0); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTblW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLW$0);
      return cTTblWidth;
    } 
  }
  
  public void unsetTblW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLW$0, 0);
    } 
  }
  
  public CTJc getJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$2, 0);
      if (cTJc == null)
        return null; 
      return cTJc;
    } 
  }
  
  public boolean isSetJc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(JC$2) != 0);
    } 
  }
  
  public void setJc(CTJc paramCTJc) {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$2, 0);
      if (cTJc == null)
        cTJc = (CTJc)get_store().add_element_user(JC$2); 
      cTJc.set((XmlObject)paramCTJc);
    } 
  }
  
  public CTJc addNewJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().add_element_user(JC$2);
      return cTJc;
    } 
  }
  
  public void unsetJc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(JC$2, 0);
    } 
  }
  
  public CTTblWidth getTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLCELLSPACING$4, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLCELLSPACING$4) != 0);
    } 
  }
  
  public void setTblCellSpacing(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLCELLSPACING$4, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLCELLSPACING$4); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLCELLSPACING$4);
      return cTTblWidth;
    } 
  }
  
  public void unsetTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLCELLSPACING$4, 0);
    } 
  }
  
  public CTTblWidth getTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLIND$6, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLIND$6) != 0);
    } 
  }
  
  public void setTblInd(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLIND$6, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLIND$6); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLIND$6);
      return cTTblWidth;
    } 
  }
  
  public void unsetTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLIND$6, 0);
    } 
  }
  
  public CTTblBorders getTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblBorders cTTblBorders = null;
      cTTblBorders = (CTTblBorders)get_store().find_element_user(TBLBORDERS$8, 0);
      if (cTTblBorders == null)
        return null; 
      return cTTblBorders;
    } 
  }
  
  public boolean isSetTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLBORDERS$8) != 0);
    } 
  }
  
  public void setTblBorders(CTTblBorders paramCTTblBorders) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblBorders cTTblBorders = null;
      cTTblBorders = (CTTblBorders)get_store().find_element_user(TBLBORDERS$8, 0);
      if (cTTblBorders == null)
        cTTblBorders = (CTTblBorders)get_store().add_element_user(TBLBORDERS$8); 
      cTTblBorders.set((XmlObject)paramCTTblBorders);
    } 
  }
  
  public CTTblBorders addNewTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblBorders cTTblBorders = null;
      cTTblBorders = (CTTblBorders)get_store().add_element_user(TBLBORDERS$8);
      return cTTblBorders;
    } 
  }
  
  public void unsetTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLBORDERS$8, 0);
    } 
  }
  
  public CTShd getShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$10, 0);
      if (cTShd == null)
        return null; 
      return cTShd;
    } 
  }
  
  public boolean isSetShd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHD$10) != 0);
    } 
  }
  
  public void setShd(CTShd paramCTShd) {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$10, 0);
      if (cTShd == null)
        cTShd = (CTShd)get_store().add_element_user(SHD$10); 
      cTShd.set((XmlObject)paramCTShd);
    } 
  }
  
  public CTShd addNewShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().add_element_user(SHD$10);
      return cTShd;
    } 
  }
  
  public void unsetShd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHD$10, 0);
    } 
  }
  
  public CTTblLayoutType getTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblLayoutType cTTblLayoutType = null;
      cTTblLayoutType = (CTTblLayoutType)get_store().find_element_user(TBLLAYOUT$12, 0);
      if (cTTblLayoutType == null)
        return null; 
      return cTTblLayoutType;
    } 
  }
  
  public boolean isSetTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLLAYOUT$12) != 0);
    } 
  }
  
  public void setTblLayout(CTTblLayoutType paramCTTblLayoutType) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblLayoutType cTTblLayoutType = null;
      cTTblLayoutType = (CTTblLayoutType)get_store().find_element_user(TBLLAYOUT$12, 0);
      if (cTTblLayoutType == null)
        cTTblLayoutType = (CTTblLayoutType)get_store().add_element_user(TBLLAYOUT$12); 
      cTTblLayoutType.set((XmlObject)paramCTTblLayoutType);
    } 
  }
  
  public CTTblLayoutType addNewTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblLayoutType cTTblLayoutType = null;
      cTTblLayoutType = (CTTblLayoutType)get_store().add_element_user(TBLLAYOUT$12);
      return cTTblLayoutType;
    } 
  }
  
  public void unsetTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLLAYOUT$12, 0);
    } 
  }
  
  public CTTblCellMar getTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblCellMar cTTblCellMar = null;
      cTTblCellMar = (CTTblCellMar)get_store().find_element_user(TBLCELLMAR$14, 0);
      if (cTTblCellMar == null)
        return null; 
      return cTTblCellMar;
    } 
  }
  
  public boolean isSetTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLCELLMAR$14) != 0);
    } 
  }
  
  public void setTblCellMar(CTTblCellMar paramCTTblCellMar) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblCellMar cTTblCellMar = null;
      cTTblCellMar = (CTTblCellMar)get_store().find_element_user(TBLCELLMAR$14, 0);
      if (cTTblCellMar == null)
        cTTblCellMar = (CTTblCellMar)get_store().add_element_user(TBLCELLMAR$14); 
      cTTblCellMar.set((XmlObject)paramCTTblCellMar);
    } 
  }
  
  public CTTblCellMar addNewTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblCellMar cTTblCellMar = null;
      cTTblCellMar = (CTTblCellMar)get_store().add_element_user(TBLCELLMAR$14);
      return cTTblCellMar;
    } 
  }
  
  public void unsetTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLCELLMAR$14, 0);
    } 
  }
  
  public CTShortHexNumber getTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(TBLLOOK$16, 0);
      if (cTShortHexNumber == null)
        return null; 
      return cTShortHexNumber;
    } 
  }
  
  public boolean isSetTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLLOOK$16) != 0);
    } 
  }
  
  public void setTblLook(CTShortHexNumber paramCTShortHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(TBLLOOK$16, 0);
      if (cTShortHexNumber == null)
        cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(TBLLOOK$16); 
      cTShortHexNumber.set((XmlObject)paramCTShortHexNumber);
    } 
  }
  
  public CTShortHexNumber addNewTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(TBLLOOK$16);
      return cTShortHexNumber;
    } 
  }
  
  public void unsetTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLLOOK$16, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblPrExBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */