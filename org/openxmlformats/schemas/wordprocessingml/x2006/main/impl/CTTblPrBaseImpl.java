package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

public class CTTblPrBaseImpl extends XmlComplexContentImpl implements CTTblPrBase {
  private static final b TBLSTYLE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyle");
  
  private static final b TBLPPR$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblpPr");
  
  private static final b TBLOVERLAP$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblOverlap");
  
  private static final b BIDIVISUAL$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidiVisual");
  
  private static final b TBLSTYLEROWBANDSIZE$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyleRowBandSize");
  
  private static final b TBLSTYLECOLBANDSIZE$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyleColBandSize");
  
  private static final b TBLW$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblW");
  
  private static final b JC$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
  
  private static final b TBLCELLSPACING$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing");
  
  private static final b TBLIND$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblInd");
  
  private static final b TBLBORDERS$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblBorders");
  
  private static final b SHD$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
  
  private static final b TBLLAYOUT$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLayout");
  
  private static final b TBLCELLMAR$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellMar");
  
  private static final b TBLLOOK$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLook");
  
  public CTTblPrBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTString getTblStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(TBLSTYLE$0, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetTblStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLSTYLE$0) != 0);
    } 
  }
  
  public void setTblStyle(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(TBLSTYLE$0, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(TBLSTYLE$0); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewTblStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(TBLSTYLE$0);
      return cTString;
    } 
  }
  
  public void unsetTblStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLSTYLE$0, 0);
    } 
  }
  
  public CTTblPPr getTblpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPPr cTTblPPr = null;
      cTTblPPr = (CTTblPPr)get_store().find_element_user(TBLPPR$2, 0);
      if (cTTblPPr == null)
        return null; 
      return cTTblPPr;
    } 
  }
  
  public boolean isSetTblpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLPPR$2) != 0);
    } 
  }
  
  public void setTblpPr(CTTblPPr paramCTTblPPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPPr cTTblPPr = null;
      cTTblPPr = (CTTblPPr)get_store().find_element_user(TBLPPR$2, 0);
      if (cTTblPPr == null)
        cTTblPPr = (CTTblPPr)get_store().add_element_user(TBLPPR$2); 
      cTTblPPr.set((XmlObject)paramCTTblPPr);
    } 
  }
  
  public CTTblPPr addNewTblpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPPr cTTblPPr = null;
      cTTblPPr = (CTTblPPr)get_store().add_element_user(TBLPPR$2);
      return cTTblPPr;
    } 
  }
  
  public void unsetTblpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLPPR$2, 0);
    } 
  }
  
  public CTTblOverlap getTblOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblOverlap cTTblOverlap = null;
      cTTblOverlap = (CTTblOverlap)get_store().find_element_user(TBLOVERLAP$4, 0);
      if (cTTblOverlap == null)
        return null; 
      return cTTblOverlap;
    } 
  }
  
  public boolean isSetTblOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLOVERLAP$4) != 0);
    } 
  }
  
  public void setTblOverlap(CTTblOverlap paramCTTblOverlap) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblOverlap cTTblOverlap = null;
      cTTblOverlap = (CTTblOverlap)get_store().find_element_user(TBLOVERLAP$4, 0);
      if (cTTblOverlap == null)
        cTTblOverlap = (CTTblOverlap)get_store().add_element_user(TBLOVERLAP$4); 
      cTTblOverlap.set((XmlObject)paramCTTblOverlap);
    } 
  }
  
  public CTTblOverlap addNewTblOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblOverlap cTTblOverlap = null;
      cTTblOverlap = (CTTblOverlap)get_store().add_element_user(TBLOVERLAP$4);
      return cTTblOverlap;
    } 
  }
  
  public void unsetTblOverlap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLOVERLAP$4, 0);
    } 
  }
  
  public CTOnOff getBidiVisual() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BIDIVISUAL$6, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetBidiVisual() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BIDIVISUAL$6) != 0);
    } 
  }
  
  public void setBidiVisual(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(BIDIVISUAL$6, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(BIDIVISUAL$6); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewBidiVisual() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(BIDIVISUAL$6);
      return cTOnOff;
    } 
  }
  
  public void unsetBidiVisual() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BIDIVISUAL$6, 0);
    } 
  }
  
  public CTDecimalNumber getTblStyleRowBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(TBLSTYLEROWBANDSIZE$8, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetTblStyleRowBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLSTYLEROWBANDSIZE$8) != 0);
    } 
  }
  
  public void setTblStyleRowBandSize(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(TBLSTYLEROWBANDSIZE$8, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(TBLSTYLEROWBANDSIZE$8); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewTblStyleRowBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(TBLSTYLEROWBANDSIZE$8);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetTblStyleRowBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLSTYLEROWBANDSIZE$8, 0);
    } 
  }
  
  public CTDecimalNumber getTblStyleColBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(TBLSTYLECOLBANDSIZE$10, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetTblStyleColBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLSTYLECOLBANDSIZE$10) != 0);
    } 
  }
  
  public void setTblStyleColBandSize(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(TBLSTYLECOLBANDSIZE$10, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(TBLSTYLECOLBANDSIZE$10); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewTblStyleColBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(TBLSTYLECOLBANDSIZE$10);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetTblStyleColBandSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLSTYLECOLBANDSIZE$10, 0);
    } 
  }
  
  public CTTblWidth getTblW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLW$12, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTblW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLW$12) != 0);
    } 
  }
  
  public void setTblW(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLW$12, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLW$12); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTblW() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLW$12);
      return cTTblWidth;
    } 
  }
  
  public void unsetTblW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLW$12, 0);
    } 
  }
  
  public CTJc getJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$14, 0);
      if (cTJc == null)
        return null; 
      return cTJc;
    } 
  }
  
  public boolean isSetJc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(JC$14) != 0);
    } 
  }
  
  public void setJc(CTJc paramCTJc) {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().find_element_user(JC$14, 0);
      if (cTJc == null)
        cTJc = (CTJc)get_store().add_element_user(JC$14); 
      cTJc.set((XmlObject)paramCTJc);
    } 
  }
  
  public CTJc addNewJc() {
    synchronized (monitor()) {
      check_orphaned();
      CTJc cTJc = null;
      cTJc = (CTJc)get_store().add_element_user(JC$14);
      return cTJc;
    } 
  }
  
  public void unsetJc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(JC$14, 0);
    } 
  }
  
  public CTTblWidth getTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLCELLSPACING$16, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLCELLSPACING$16) != 0);
    } 
  }
  
  public void setTblCellSpacing(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLCELLSPACING$16, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLCELLSPACING$16); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLCELLSPACING$16);
      return cTTblWidth;
    } 
  }
  
  public void unsetTblCellSpacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLCELLSPACING$16, 0);
    } 
  }
  
  public CTTblWidth getTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLIND$18, 0);
      if (cTTblWidth == null)
        return null; 
      return cTTblWidth;
    } 
  }
  
  public boolean isSetTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLIND$18) != 0);
    } 
  }
  
  public void setTblInd(CTTblWidth paramCTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().find_element_user(TBLIND$18, 0);
      if (cTTblWidth == null)
        cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLIND$18); 
      cTTblWidth.set((XmlObject)paramCTTblWidth);
    } 
  }
  
  public CTTblWidth addNewTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblWidth cTTblWidth = null;
      cTTblWidth = (CTTblWidth)get_store().add_element_user(TBLIND$18);
      return cTTblWidth;
    } 
  }
  
  public void unsetTblInd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLIND$18, 0);
    } 
  }
  
  public CTTblBorders getTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblBorders cTTblBorders = null;
      cTTblBorders = (CTTblBorders)get_store().find_element_user(TBLBORDERS$20, 0);
      if (cTTblBorders == null)
        return null; 
      return cTTblBorders;
    } 
  }
  
  public boolean isSetTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLBORDERS$20) != 0);
    } 
  }
  
  public void setTblBorders(CTTblBorders paramCTTblBorders) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblBorders cTTblBorders = null;
      cTTblBorders = (CTTblBorders)get_store().find_element_user(TBLBORDERS$20, 0);
      if (cTTblBorders == null)
        cTTblBorders = (CTTblBorders)get_store().add_element_user(TBLBORDERS$20); 
      cTTblBorders.set((XmlObject)paramCTTblBorders);
    } 
  }
  
  public CTTblBorders addNewTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblBorders cTTblBorders = null;
      cTTblBorders = (CTTblBorders)get_store().add_element_user(TBLBORDERS$20);
      return cTTblBorders;
    } 
  }
  
  public void unsetTblBorders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLBORDERS$20, 0);
    } 
  }
  
  public CTShd getShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$22, 0);
      if (cTShd == null)
        return null; 
      return cTShd;
    } 
  }
  
  public boolean isSetShd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHD$22) != 0);
    } 
  }
  
  public void setShd(CTShd paramCTShd) {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().find_element_user(SHD$22, 0);
      if (cTShd == null)
        cTShd = (CTShd)get_store().add_element_user(SHD$22); 
      cTShd.set((XmlObject)paramCTShd);
    } 
  }
  
  public CTShd addNewShd() {
    synchronized (monitor()) {
      check_orphaned();
      CTShd cTShd = null;
      cTShd = (CTShd)get_store().add_element_user(SHD$22);
      return cTShd;
    } 
  }
  
  public void unsetShd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHD$22, 0);
    } 
  }
  
  public CTTblLayoutType getTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblLayoutType cTTblLayoutType = null;
      cTTblLayoutType = (CTTblLayoutType)get_store().find_element_user(TBLLAYOUT$24, 0);
      if (cTTblLayoutType == null)
        return null; 
      return cTTblLayoutType;
    } 
  }
  
  public boolean isSetTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLLAYOUT$24) != 0);
    } 
  }
  
  public void setTblLayout(CTTblLayoutType paramCTTblLayoutType) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblLayoutType cTTblLayoutType = null;
      cTTblLayoutType = (CTTblLayoutType)get_store().find_element_user(TBLLAYOUT$24, 0);
      if (cTTblLayoutType == null)
        cTTblLayoutType = (CTTblLayoutType)get_store().add_element_user(TBLLAYOUT$24); 
      cTTblLayoutType.set((XmlObject)paramCTTblLayoutType);
    } 
  }
  
  public CTTblLayoutType addNewTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblLayoutType cTTblLayoutType = null;
      cTTblLayoutType = (CTTblLayoutType)get_store().add_element_user(TBLLAYOUT$24);
      return cTTblLayoutType;
    } 
  }
  
  public void unsetTblLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLLAYOUT$24, 0);
    } 
  }
  
  public CTTblCellMar getTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblCellMar cTTblCellMar = null;
      cTTblCellMar = (CTTblCellMar)get_store().find_element_user(TBLCELLMAR$26, 0);
      if (cTTblCellMar == null)
        return null; 
      return cTTblCellMar;
    } 
  }
  
  public boolean isSetTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLCELLMAR$26) != 0);
    } 
  }
  
  public void setTblCellMar(CTTblCellMar paramCTTblCellMar) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblCellMar cTTblCellMar = null;
      cTTblCellMar = (CTTblCellMar)get_store().find_element_user(TBLCELLMAR$26, 0);
      if (cTTblCellMar == null)
        cTTblCellMar = (CTTblCellMar)get_store().add_element_user(TBLCELLMAR$26); 
      cTTblCellMar.set((XmlObject)paramCTTblCellMar);
    } 
  }
  
  public CTTblCellMar addNewTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblCellMar cTTblCellMar = null;
      cTTblCellMar = (CTTblCellMar)get_store().add_element_user(TBLCELLMAR$26);
      return cTTblCellMar;
    } 
  }
  
  public void unsetTblCellMar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLCELLMAR$26, 0);
    } 
  }
  
  public CTShortHexNumber getTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(TBLLOOK$28, 0);
      if (cTShortHexNumber == null)
        return null; 
      return cTShortHexNumber;
    } 
  }
  
  public boolean isSetTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLLOOK$28) != 0);
    } 
  }
  
  public void setTblLook(CTShortHexNumber paramCTShortHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().find_element_user(TBLLOOK$28, 0);
      if (cTShortHexNumber == null)
        cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(TBLLOOK$28); 
      cTShortHexNumber.set((XmlObject)paramCTShortHexNumber);
    } 
  }
  
  public CTShortHexNumber addNewTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      CTShortHexNumber cTShortHexNumber = null;
      cTShortHexNumber = (CTShortHexNumber)get_store().add_element_user(TBLLOOK$28);
      return cTShortHexNumber;
    } 
  }
  
  public void unsetTblLook() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLLOOK$28, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblPrBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */