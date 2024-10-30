package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;

public class CTTcPrBaseImpl extends XmlComplexContentImpl implements CTTcPrBase {
  private static final b CNFSTYLE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");
  
  private static final b TCW$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcW");
  
  private static final b GRIDSPAN$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridSpan");
  
  private static final b HMERGE$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hMerge");
  
  private static final b VMERGE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vMerge");
  
  private static final b TCBORDERS$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcBorders");
  
  private static final b SHD$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
  
  private static final b NOWRAP$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noWrap");
  
  private static final b TCMAR$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcMar");
  
  private static final b TEXTDIRECTION$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
  
  private static final b TCFITTEXT$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcFitText");
  
  private static final b VALIGN$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vAlign");
  
  private static final b HIDEMARK$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideMark");
  
  public CTTcPrBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCnf getCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().find_element_user(CNFSTYLE$0, 0);
      if (cTCnf == null)
        return null; 
      return cTCnf;
    } 
  }
  
  public boolean isSetCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CNFSTYLE$0) != 0);
    } 
  }
  
  public void setCnfStyle(CTCnf paramCTCnf) {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().find_element_user(CNFSTYLE$0, 0);
      if (cTCnf == null)
        cTCnf = (CTCnf)get_store().add_element_user(CNFSTYLE$0); 
      cTCnf.set((XmlObject)paramCTCnf);
    } 
  }
  
  public CTCnf addNewCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTCnf cTCnf = null;
      cTCnf = (CTCnf)get_store().add_element_user(CNFSTYLE$0);
      return cTCnf;
    } 
  }
  
  public void unsetCnfStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CNFSTYLE$0, 0);
    } 
  }
  
  public CTTblWidth getTcW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TCW$2, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTcW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCW$2) != 0);
    } 
  }
  
  public void setTcW(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TCW$2, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TCW$2); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTcW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TCW$2);
      return cTTblWidth;
    } 
  }
  
  public void unsetTcW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCW$2, 0);
    } 
  }
  
  public CTDecimalNumber getGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(GRIDSPAN$4, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRIDSPAN$4) != 0);
    } 
  }
  
  public void setGridSpan(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(GRIDSPAN$4, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(GRIDSPAN$4); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(GRIDSPAN$4);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRIDSPAN$4, 0);
    } 
  }
  
  public CTHMerge getHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTHMerge cTHMerge = null;
      cTHMerge = (CTHMerge)get_store().find_element_user(HMERGE$6, 0);
      if (cTHMerge == null)
        return null; 
      return cTHMerge;
    } 
  }
  
  public boolean isSetHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HMERGE$6) != 0);
    } 
  }
  
  public void setHMerge(CTHMerge paramCTHMerge) {
    synchronized (monitor()) {
      check_orphaned();
      CTHMerge cTHMerge = null;
      cTHMerge = (CTHMerge)get_store().find_element_user(HMERGE$6, 0);
      if (cTHMerge == null)
        cTHMerge = (CTHMerge)get_store().add_element_user(HMERGE$6); 
      cTHMerge.set((XmlObject)paramCTHMerge);
    } 
  }
  
  public CTHMerge addNewHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTHMerge cTHMerge = null;
      cTHMerge = (CTHMerge)get_store().add_element_user(HMERGE$6);
      return cTHMerge;
    } 
  }
  
  public void unsetHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HMERGE$6, 0);
    } 
  }
  
  public CTVMerge getVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTVMerge cTVMerge = null;
      cTVMerge = (CTVMerge)get_store().find_element_user(VMERGE$8, 0);
      if (cTVMerge == null)
        return null; 
      return cTVMerge;
    } 
  }
  
  public boolean isSetVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VMERGE$8) != 0);
    } 
  }
  
  public void setVMerge(CTVMerge paramCTVMerge) {
    synchronized (monitor()) {
      check_orphaned();
      CTVMerge cTVMerge = null;
      cTVMerge = (CTVMerge)get_store().find_element_user(VMERGE$8, 0);
      if (cTVMerge == null)
        cTVMerge = (CTVMerge)get_store().add_element_user(VMERGE$8); 
      cTVMerge.set((XmlObject)paramCTVMerge);
    } 
  }
  
  public CTVMerge addNewVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTVMerge cTVMerge = null;
      cTVMerge = (CTVMerge)get_store().add_element_user(VMERGE$8);
      return cTVMerge;
    } 
  }
  
  public void unsetVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VMERGE$8, 0);
    } 
  }
  
  public CTTcBorders getTcBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcBorders cTTcBorders = null;
      cTTcBorders = (CTTcBorders)get_store().find_element_user(TCBORDERS$10, 0);
      if (cTTcBorders == null)
        return null; 
      return cTTcBorders;
    } 
  }
  
  public boolean isSetTcBorders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCBORDERS$10) != 0);
    } 
  }
  
  public void setTcBorders(CTTcBorders paramCTTcBorders) {
    synchronized (monitor()) {
      check_orphaned();
      CTTcBorders cTTcBorders = null;
      cTTcBorders = (CTTcBorders)get_store().find_element_user(TCBORDERS$10, 0);
      if (cTTcBorders == null)
        cTTcBorders = (CTTcBorders)get_store().add_element_user(TCBORDERS$10); 
      cTTcBorders.set((XmlObject)paramCTTcBorders);
    } 
  }
  
  public CTTcBorders addNewTcBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcBorders cTTcBorders = null;
      cTTcBorders = (CTTcBorders)get_store().add_element_user(TCBORDERS$10);
      return cTTcBorders;
    } 
  }
  
  public void unsetTcBorders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCBORDERS$10, 0);
    } 
  }
  
  public CTShd getShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$12, 0);
      if (cTShd == null)
        return null; 
      return cTShd;
    } 
  }
  
  public boolean isSetShd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHD$12) != 0);
    } 
  }
  
  public void setShd(CTShd paramCTShd) {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$12, 0);
      if (cTShd == null)
        cTShd = (CTShd)get_store().add_element_user(SHD$12); 
      cTShd.set((XmlObject)paramCTShd);
    } 
  }
  
  public CTShd addNewShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().add_element_user(SHD$12);
      return cTShd;
    } 
  }
  
  public void unsetShd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHD$12, 0);
    } 
  }
  
  public CTOnOff getNoWrap() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOWRAP$14, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetNoWrap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOWRAP$14) != 0);
    } 
  }
  
  public void setNoWrap(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(NOWRAP$14, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(NOWRAP$14); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewNoWrap() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(NOWRAP$14);
      return cTOnOff;
    } 
  }
  
  public void unsetNoWrap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOWRAP$14, 0);
    } 
  }
  
  public CTTcMar getTcMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcMar cTTcMar = null;
      cTTcMar = (CTTcMar)get_store().find_element_user(TCMAR$16, 0);
      if (cTTcMar == null)
        return null; 
      return cTTcMar;
    } 
  }
  
  public boolean isSetTcMar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCMAR$16) != 0);
    } 
  }
  
  public void setTcMar(CTTcMar paramCTTcMar) {
    synchronized (monitor()) {
      check_orphaned();
      CTTcMar cTTcMar = null;
      cTTcMar = (CTTcMar)get_store().find_element_user(TCMAR$16, 0);
      if (cTTcMar == null)
        cTTcMar = (CTTcMar)get_store().add_element_user(TCMAR$16); 
      cTTcMar.set((XmlObject)paramCTTcMar);
    } 
  }
  
  public CTTcMar addNewTcMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcMar cTTcMar = null;
      cTTcMar = (CTTcMar)get_store().add_element_user(TCMAR$16);
      return cTTcMar;
    } 
  }
  
  public void unsetTcMar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCMAR$16, 0);
    } 
  }
  
  public CTTextDirection getTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().find_element_user(TEXTDIRECTION$18, 0);
      if (cTTextDirection == null)
        return null; 
      return cTTextDirection;
    } 
  }
  
  public boolean isSetTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TEXTDIRECTION$18) != 0);
    } 
  }
  
  public void setTextDirection(CTTextDirection paramCTTextDirection) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().find_element_user(TEXTDIRECTION$18, 0);
      if (cTTextDirection == null)
        cTTextDirection = (CTTextDirection)get_store().add_element_user(TEXTDIRECTION$18); 
      cTTextDirection.set((XmlObject)paramCTTextDirection);
    } 
  }
  
  public CTTextDirection addNewTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextDirection cTTextDirection = null;
      cTTextDirection = (CTTextDirection)get_store().add_element_user(TEXTDIRECTION$18);
      return cTTextDirection;
    } 
  }
  
  public void unsetTextDirection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTDIRECTION$18, 0);
    } 
  }
  
  public CTOnOff getTcFitText() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TCFITTEXT$20, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetTcFitText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCFITTEXT$20) != 0);
    } 
  }
  
  public void setTcFitText(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(TCFITTEXT$20, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(TCFITTEXT$20); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewTcFitText() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(TCFITTEXT$20);
      return cTOnOff;
    } 
  }
  
  public void unsetTcFitText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCFITTEXT$20, 0);
    } 
  }
  
  public CTVerticalJc getVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalJc cTVerticalJc = null;
      cTVerticalJc = (CTVerticalJc)get_store().find_element_user(VALIGN$22, 0);
      if (cTVerticalJc == null)
        return null; 
      return cTVerticalJc;
    } 
  }
  
  public boolean isSetVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VALIGN$22) != 0);
    } 
  }
  
  public void setVAlign(CTVerticalJc paramCTVerticalJc) {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalJc cTVerticalJc = null;
      cTVerticalJc = (CTVerticalJc)get_store().find_element_user(VALIGN$22, 0);
      if (cTVerticalJc == null)
        cTVerticalJc = (CTVerticalJc)get_store().add_element_user(VALIGN$22); 
      cTVerticalJc.set((XmlObject)paramCTVerticalJc);
    } 
  }
  
  public CTVerticalJc addNewVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalJc cTVerticalJc = null;
      cTVerticalJc = (CTVerticalJc)get_store().add_element_user(VALIGN$22);
      return cTVerticalJc;
    } 
  }
  
  public void unsetVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VALIGN$22, 0);
    } 
  }
  
  public CTOnOff getHideMark() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDEMARK$24, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetHideMark() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIDEMARK$24) != 0);
    } 
  }
  
  public void setHideMark(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDEMARK$24, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(HIDEMARK$24); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewHideMark() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(HIDEMARK$24);
      return cTOnOff;
    } 
  }
  
  public void unsetHideMark() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIDEMARK$24, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTcPrBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */