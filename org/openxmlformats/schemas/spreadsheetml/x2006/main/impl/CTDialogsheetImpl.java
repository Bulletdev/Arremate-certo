package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;

public class CTDialogsheetImpl extends XmlComplexContentImpl implements CTDialogsheet {
  private static final b SHEETPR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetPr");
  
  private static final b SHEETVIEWS$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetViews");
  
  private static final b SHEETFORMATPR$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetFormatPr");
  
  private static final b SHEETPROTECTION$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetProtection");
  
  private static final b CUSTOMSHEETVIEWS$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetViews");
  
  private static final b PRINTOPTIONS$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "printOptions");
  
  private static final b PAGEMARGINS$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageMargins");
  
  private static final b PAGESETUP$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetup");
  
  private static final b HEADERFOOTER$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "headerFooter");
  
  private static final b DRAWING$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawing");
  
  private static final b LEGACYDRAWING$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawing");
  
  private static final b LEGACYDRAWINGHF$22 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawingHF");
  
  private static final b OLEOBJECTS$24 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleObjects");
  
  private static final b EXTLST$26 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTDialogsheetImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSheetPr getSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetPr cTSheetPr = null;
      cTSheetPr = (CTSheetPr)get_store().find_element_user(SHEETPR$0, 0);
      if (cTSheetPr == null)
        return null; 
      return cTSheetPr;
    } 
  }
  
  public boolean isSetSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETPR$0) != 0);
    } 
  }
  
  public void setSheetPr(CTSheetPr paramCTSheetPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetPr cTSheetPr = null;
      cTSheetPr = (CTSheetPr)get_store().find_element_user(SHEETPR$0, 0);
      if (cTSheetPr == null)
        cTSheetPr = (CTSheetPr)get_store().add_element_user(SHEETPR$0); 
      cTSheetPr.set((XmlObject)paramCTSheetPr);
    } 
  }
  
  public CTSheetPr addNewSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetPr cTSheetPr = null;
      cTSheetPr = (CTSheetPr)get_store().add_element_user(SHEETPR$0);
      return cTSheetPr;
    } 
  }
  
  public void unsetSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETPR$0, 0);
    } 
  }
  
  public CTSheetViews getSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetViews cTSheetViews = null;
      cTSheetViews = (CTSheetViews)get_store().find_element_user(SHEETVIEWS$2, 0);
      if (cTSheetViews == null)
        return null; 
      return cTSheetViews;
    } 
  }
  
  public boolean isSetSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETVIEWS$2) != 0);
    } 
  }
  
  public void setSheetViews(CTSheetViews paramCTSheetViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetViews cTSheetViews = null;
      cTSheetViews = (CTSheetViews)get_store().find_element_user(SHEETVIEWS$2, 0);
      if (cTSheetViews == null)
        cTSheetViews = (CTSheetViews)get_store().add_element_user(SHEETVIEWS$2); 
      cTSheetViews.set((XmlObject)paramCTSheetViews);
    } 
  }
  
  public CTSheetViews addNewSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetViews cTSheetViews = null;
      cTSheetViews = (CTSheetViews)get_store().add_element_user(SHEETVIEWS$2);
      return cTSheetViews;
    } 
  }
  
  public void unsetSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETVIEWS$2, 0);
    } 
  }
  
  public CTSheetFormatPr getSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetFormatPr cTSheetFormatPr = null;
      cTSheetFormatPr = (CTSheetFormatPr)get_store().find_element_user(SHEETFORMATPR$4, 0);
      if (cTSheetFormatPr == null)
        return null; 
      return cTSheetFormatPr;
    } 
  }
  
  public boolean isSetSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETFORMATPR$4) != 0);
    } 
  }
  
  public void setSheetFormatPr(CTSheetFormatPr paramCTSheetFormatPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetFormatPr cTSheetFormatPr = null;
      cTSheetFormatPr = (CTSheetFormatPr)get_store().find_element_user(SHEETFORMATPR$4, 0);
      if (cTSheetFormatPr == null)
        cTSheetFormatPr = (CTSheetFormatPr)get_store().add_element_user(SHEETFORMATPR$4); 
      cTSheetFormatPr.set((XmlObject)paramCTSheetFormatPr);
    } 
  }
  
  public CTSheetFormatPr addNewSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetFormatPr cTSheetFormatPr = null;
      cTSheetFormatPr = (CTSheetFormatPr)get_store().add_element_user(SHEETFORMATPR$4);
      return cTSheetFormatPr;
    } 
  }
  
  public void unsetSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETFORMATPR$4, 0);
    } 
  }
  
  public CTSheetProtection getSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetProtection cTSheetProtection = null;
      cTSheetProtection = (CTSheetProtection)get_store().find_element_user(SHEETPROTECTION$6, 0);
      if (cTSheetProtection == null)
        return null; 
      return cTSheetProtection;
    } 
  }
  
  public boolean isSetSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETPROTECTION$6) != 0);
    } 
  }
  
  public void setSheetProtection(CTSheetProtection paramCTSheetProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetProtection cTSheetProtection = null;
      cTSheetProtection = (CTSheetProtection)get_store().find_element_user(SHEETPROTECTION$6, 0);
      if (cTSheetProtection == null)
        cTSheetProtection = (CTSheetProtection)get_store().add_element_user(SHEETPROTECTION$6); 
      cTSheetProtection.set((XmlObject)paramCTSheetProtection);
    } 
  }
  
  public CTSheetProtection addNewSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetProtection cTSheetProtection = null;
      cTSheetProtection = (CTSheetProtection)get_store().add_element_user(SHEETPROTECTION$6);
      return cTSheetProtection;
    } 
  }
  
  public void unsetSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETPROTECTION$6, 0);
    } 
  }
  
  public CTCustomSheetViews getCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomSheetViews cTCustomSheetViews = null;
      cTCustomSheetViews = (CTCustomSheetViews)get_store().find_element_user(CUSTOMSHEETVIEWS$8, 0);
      if (cTCustomSheetViews == null)
        return null; 
      return cTCustomSheetViews;
    } 
  }
  
  public boolean isSetCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTOMSHEETVIEWS$8) != 0);
    } 
  }
  
  public void setCustomSheetViews(CTCustomSheetViews paramCTCustomSheetViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomSheetViews cTCustomSheetViews = null;
      cTCustomSheetViews = (CTCustomSheetViews)get_store().find_element_user(CUSTOMSHEETVIEWS$8, 0);
      if (cTCustomSheetViews == null)
        cTCustomSheetViews = (CTCustomSheetViews)get_store().add_element_user(CUSTOMSHEETVIEWS$8); 
      cTCustomSheetViews.set((XmlObject)paramCTCustomSheetViews);
    } 
  }
  
  public CTCustomSheetViews addNewCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomSheetViews cTCustomSheetViews = null;
      cTCustomSheetViews = (CTCustomSheetViews)get_store().add_element_user(CUSTOMSHEETVIEWS$8);
      return cTCustomSheetViews;
    } 
  }
  
  public void unsetCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMSHEETVIEWS$8, 0);
    } 
  }
  
  public CTPrintOptions getPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintOptions cTPrintOptions = null;
      cTPrintOptions = (CTPrintOptions)get_store().find_element_user(PRINTOPTIONS$10, 0);
      if (cTPrintOptions == null)
        return null; 
      return cTPrintOptions;
    } 
  }
  
  public boolean isSetPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTOPTIONS$10) != 0);
    } 
  }
  
  public void setPrintOptions(CTPrintOptions paramCTPrintOptions) {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintOptions cTPrintOptions = null;
      cTPrintOptions = (CTPrintOptions)get_store().find_element_user(PRINTOPTIONS$10, 0);
      if (cTPrintOptions == null)
        cTPrintOptions = (CTPrintOptions)get_store().add_element_user(PRINTOPTIONS$10); 
      cTPrintOptions.set((XmlObject)paramCTPrintOptions);
    } 
  }
  
  public CTPrintOptions addNewPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintOptions cTPrintOptions = null;
      cTPrintOptions = (CTPrintOptions)get_store().add_element_user(PRINTOPTIONS$10);
      return cTPrintOptions;
    } 
  }
  
  public void unsetPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTOPTIONS$10, 0);
    } 
  }
  
  public CTPageMargins getPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$12, 0);
      if (cTPageMargins == null)
        return null; 
      return cTPageMargins;
    } 
  }
  
  public boolean isSetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGEMARGINS$12) != 0);
    } 
  }
  
  public void setPageMargins(CTPageMargins paramCTPageMargins) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$12, 0);
      if (cTPageMargins == null)
        cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$12); 
      cTPageMargins.set((XmlObject)paramCTPageMargins);
    } 
  }
  
  public CTPageMargins addNewPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$12);
      return cTPageMargins;
    } 
  }
  
  public void unsetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGEMARGINS$12, 0);
    } 
  }
  
  public CTPageSetup getPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().find_element_user(PAGESETUP$14, 0);
      if (cTPageSetup == null)
        return null; 
      return cTPageSetup;
    } 
  }
  
  public boolean isSetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGESETUP$14) != 0);
    } 
  }
  
  public void setPageSetup(CTPageSetup paramCTPageSetup) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().find_element_user(PAGESETUP$14, 0);
      if (cTPageSetup == null)
        cTPageSetup = (CTPageSetup)get_store().add_element_user(PAGESETUP$14); 
      cTPageSetup.set((XmlObject)paramCTPageSetup);
    } 
  }
  
  public CTPageSetup addNewPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().add_element_user(PAGESETUP$14);
      return cTPageSetup;
    } 
  }
  
  public void unsetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGESETUP$14, 0);
    } 
  }
  
  public CTHeaderFooter getHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$16, 0);
      if (cTHeaderFooter == null)
        return null; 
      return cTHeaderFooter;
    } 
  }
  
  public boolean isSetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HEADERFOOTER$16) != 0);
    } 
  }
  
  public void setHeaderFooter(CTHeaderFooter paramCTHeaderFooter) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$16, 0);
      if (cTHeaderFooter == null)
        cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$16); 
      cTHeaderFooter.set((XmlObject)paramCTHeaderFooter);
    } 
  }
  
  public CTHeaderFooter addNewHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$16);
      return cTHeaderFooter;
    } 
  }
  
  public void unsetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADERFOOTER$16, 0);
    } 
  }
  
  public CTDrawing getDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$18, 0);
      if (cTDrawing == null)
        return null; 
      return cTDrawing;
    } 
  }
  
  public boolean isSetDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DRAWING$18) != 0);
    } 
  }
  
  public void setDrawing(CTDrawing paramCTDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$18, 0);
      if (cTDrawing == null)
        cTDrawing = (CTDrawing)get_store().add_element_user(DRAWING$18); 
      cTDrawing.set((XmlObject)paramCTDrawing);
    } 
  }
  
  public CTDrawing addNewDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().add_element_user(DRAWING$18);
      return cTDrawing;
    } 
  }
  
  public void unsetDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DRAWING$18, 0);
    } 
  }
  
  public CTLegacyDrawing getLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWING$20, 0);
      if (cTLegacyDrawing == null)
        return null; 
      return cTLegacyDrawing;
    } 
  }
  
  public boolean isSetLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACYDRAWING$20) != 0);
    } 
  }
  
  public void setLegacyDrawing(CTLegacyDrawing paramCTLegacyDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWING$20, 0);
      if (cTLegacyDrawing == null)
        cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWING$20); 
      cTLegacyDrawing.set((XmlObject)paramCTLegacyDrawing);
    } 
  }
  
  public CTLegacyDrawing addNewLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWING$20);
      return cTLegacyDrawing;
    } 
  }
  
  public void unsetLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACYDRAWING$20, 0);
    } 
  }
  
  public CTLegacyDrawing getLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWINGHF$22, 0);
      if (cTLegacyDrawing == null)
        return null; 
      return cTLegacyDrawing;
    } 
  }
  
  public boolean isSetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACYDRAWINGHF$22) != 0);
    } 
  }
  
  public void setLegacyDrawingHF(CTLegacyDrawing paramCTLegacyDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWINGHF$22, 0);
      if (cTLegacyDrawing == null)
        cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWINGHF$22); 
      cTLegacyDrawing.set((XmlObject)paramCTLegacyDrawing);
    } 
  }
  
  public CTLegacyDrawing addNewLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWINGHF$22);
      return cTLegacyDrawing;
    } 
  }
  
  public void unsetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACYDRAWINGHF$22, 0);
    } 
  }
  
  public CTOleObjects getOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleObjects cTOleObjects = null;
      cTOleObjects = (CTOleObjects)get_store().find_element_user(OLEOBJECTS$24, 0);
      if (cTOleObjects == null)
        return null; 
      return cTOleObjects;
    } 
  }
  
  public boolean isSetOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OLEOBJECTS$24) != 0);
    } 
  }
  
  public void setOleObjects(CTOleObjects paramCTOleObjects) {
    synchronized (monitor()) {
      check_orphaned();
      CTOleObjects cTOleObjects = null;
      cTOleObjects = (CTOleObjects)get_store().find_element_user(OLEOBJECTS$24, 0);
      if (cTOleObjects == null)
        cTOleObjects = (CTOleObjects)get_store().add_element_user(OLEOBJECTS$24); 
      cTOleObjects.set((XmlObject)paramCTOleObjects);
    } 
  }
  
  public CTOleObjects addNewOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleObjects cTOleObjects = null;
      cTOleObjects = (CTOleObjects)get_store().add_element_user(OLEOBJECTS$24);
      return cTOleObjects;
    } 
  }
  
  public void unsetOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OLEOBJECTS$24, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$26, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$26) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$26, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$26); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$26);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$26, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDialogsheetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */