package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCsPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomChartsheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetBackgroundPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishItems;

public class CTChartsheetImpl extends XmlComplexContentImpl implements CTChartsheet {
  private static final b SHEETPR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetPr");
  
  private static final b SHEETVIEWS$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetViews");
  
  private static final b SHEETPROTECTION$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetProtection");
  
  private static final b CUSTOMSHEETVIEWS$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetViews");
  
  private static final b PAGEMARGINS$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageMargins");
  
  private static final b PAGESETUP$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetup");
  
  private static final b HEADERFOOTER$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "headerFooter");
  
  private static final b DRAWING$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawing");
  
  private static final b LEGACYDRAWING$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawing");
  
  private static final b LEGACYDRAWINGHF$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawingHF");
  
  private static final b PICTURE$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "picture");
  
  private static final b WEBPUBLISHITEMS$22 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishItems");
  
  private static final b EXTLST$24 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTChartsheetImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTChartsheetPr getSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetPr cTChartsheetPr = null;
      cTChartsheetPr = (CTChartsheetPr)get_store().find_element_user(SHEETPR$0, 0);
      if (cTChartsheetPr == null)
        return null; 
      return cTChartsheetPr;
    } 
  }
  
  public boolean isSetSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETPR$0) != 0);
    } 
  }
  
  public void setSheetPr(CTChartsheetPr paramCTChartsheetPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetPr cTChartsheetPr = null;
      cTChartsheetPr = (CTChartsheetPr)get_store().find_element_user(SHEETPR$0, 0);
      if (cTChartsheetPr == null)
        cTChartsheetPr = (CTChartsheetPr)get_store().add_element_user(SHEETPR$0); 
      cTChartsheetPr.set((XmlObject)paramCTChartsheetPr);
    } 
  }
  
  public CTChartsheetPr addNewSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetPr cTChartsheetPr = null;
      cTChartsheetPr = (CTChartsheetPr)get_store().add_element_user(SHEETPR$0);
      return cTChartsheetPr;
    } 
  }
  
  public void unsetSheetPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETPR$0, 0);
    } 
  }
  
  public CTChartsheetViews getSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetViews cTChartsheetViews = null;
      cTChartsheetViews = (CTChartsheetViews)get_store().find_element_user(SHEETVIEWS$2, 0);
      if (cTChartsheetViews == null)
        return null; 
      return cTChartsheetViews;
    } 
  }
  
  public void setSheetViews(CTChartsheetViews paramCTChartsheetViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetViews cTChartsheetViews = null;
      cTChartsheetViews = (CTChartsheetViews)get_store().find_element_user(SHEETVIEWS$2, 0);
      if (cTChartsheetViews == null)
        cTChartsheetViews = (CTChartsheetViews)get_store().add_element_user(SHEETVIEWS$2); 
      cTChartsheetViews.set((XmlObject)paramCTChartsheetViews);
    } 
  }
  
  public CTChartsheetViews addNewSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetViews cTChartsheetViews = null;
      cTChartsheetViews = (CTChartsheetViews)get_store().add_element_user(SHEETVIEWS$2);
      return cTChartsheetViews;
    } 
  }
  
  public CTChartsheetProtection getSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetProtection cTChartsheetProtection = null;
      cTChartsheetProtection = (CTChartsheetProtection)get_store().find_element_user(SHEETPROTECTION$4, 0);
      if (cTChartsheetProtection == null)
        return null; 
      return cTChartsheetProtection;
    } 
  }
  
  public boolean isSetSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETPROTECTION$4) != 0);
    } 
  }
  
  public void setSheetProtection(CTChartsheetProtection paramCTChartsheetProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetProtection cTChartsheetProtection = null;
      cTChartsheetProtection = (CTChartsheetProtection)get_store().find_element_user(SHEETPROTECTION$4, 0);
      if (cTChartsheetProtection == null)
        cTChartsheetProtection = (CTChartsheetProtection)get_store().add_element_user(SHEETPROTECTION$4); 
      cTChartsheetProtection.set((XmlObject)paramCTChartsheetProtection);
    } 
  }
  
  public CTChartsheetProtection addNewSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartsheetProtection cTChartsheetProtection = null;
      cTChartsheetProtection = (CTChartsheetProtection)get_store().add_element_user(SHEETPROTECTION$4);
      return cTChartsheetProtection;
    } 
  }
  
  public void unsetSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETPROTECTION$4, 0);
    } 
  }
  
  public CTCustomChartsheetViews getCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomChartsheetViews cTCustomChartsheetViews = null;
      cTCustomChartsheetViews = (CTCustomChartsheetViews)get_store().find_element_user(CUSTOMSHEETVIEWS$6, 0);
      if (cTCustomChartsheetViews == null)
        return null; 
      return cTCustomChartsheetViews;
    } 
  }
  
  public boolean isSetCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTOMSHEETVIEWS$6) != 0);
    } 
  }
  
  public void setCustomSheetViews(CTCustomChartsheetViews paramCTCustomChartsheetViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomChartsheetViews cTCustomChartsheetViews = null;
      cTCustomChartsheetViews = (CTCustomChartsheetViews)get_store().find_element_user(CUSTOMSHEETVIEWS$6, 0);
      if (cTCustomChartsheetViews == null)
        cTCustomChartsheetViews = (CTCustomChartsheetViews)get_store().add_element_user(CUSTOMSHEETVIEWS$6); 
      cTCustomChartsheetViews.set((XmlObject)paramCTCustomChartsheetViews);
    } 
  }
  
  public CTCustomChartsheetViews addNewCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomChartsheetViews cTCustomChartsheetViews = null;
      cTCustomChartsheetViews = (CTCustomChartsheetViews)get_store().add_element_user(CUSTOMSHEETVIEWS$6);
      return cTCustomChartsheetViews;
    } 
  }
  
  public void unsetCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMSHEETVIEWS$6, 0);
    } 
  }
  
  public CTPageMargins getPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$8, 0);
      if (cTPageMargins == null)
        return null; 
      return cTPageMargins;
    } 
  }
  
  public boolean isSetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGEMARGINS$8) != 0);
    } 
  }
  
  public void setPageMargins(CTPageMargins paramCTPageMargins) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$8, 0);
      if (cTPageMargins == null)
        cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$8); 
      cTPageMargins.set((XmlObject)paramCTPageMargins);
    } 
  }
  
  public CTPageMargins addNewPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$8);
      return cTPageMargins;
    } 
  }
  
  public void unsetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGEMARGINS$8, 0);
    } 
  }
  
  public CTCsPageSetup getPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTCsPageSetup cTCsPageSetup = null;
      cTCsPageSetup = (CTCsPageSetup)get_store().find_element_user(PAGESETUP$10, 0);
      if (cTCsPageSetup == null)
        return null; 
      return cTCsPageSetup;
    } 
  }
  
  public boolean isSetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGESETUP$10) != 0);
    } 
  }
  
  public void setPageSetup(CTCsPageSetup paramCTCsPageSetup) {
    synchronized (monitor()) {
      check_orphaned();
      CTCsPageSetup cTCsPageSetup = null;
      cTCsPageSetup = (CTCsPageSetup)get_store().find_element_user(PAGESETUP$10, 0);
      if (cTCsPageSetup == null)
        cTCsPageSetup = (CTCsPageSetup)get_store().add_element_user(PAGESETUP$10); 
      cTCsPageSetup.set((XmlObject)paramCTCsPageSetup);
    } 
  }
  
  public CTCsPageSetup addNewPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTCsPageSetup cTCsPageSetup = null;
      cTCsPageSetup = (CTCsPageSetup)get_store().add_element_user(PAGESETUP$10);
      return cTCsPageSetup;
    } 
  }
  
  public void unsetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGESETUP$10, 0);
    } 
  }
  
  public CTHeaderFooter getHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$12, 0);
      if (cTHeaderFooter == null)
        return null; 
      return cTHeaderFooter;
    } 
  }
  
  public boolean isSetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HEADERFOOTER$12) != 0);
    } 
  }
  
  public void setHeaderFooter(CTHeaderFooter paramCTHeaderFooter) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$12, 0);
      if (cTHeaderFooter == null)
        cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$12); 
      cTHeaderFooter.set((XmlObject)paramCTHeaderFooter);
    } 
  }
  
  public CTHeaderFooter addNewHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$12);
      return cTHeaderFooter;
    } 
  }
  
  public void unsetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADERFOOTER$12, 0);
    } 
  }
  
  public CTDrawing getDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$14, 0);
      if (cTDrawing == null)
        return null; 
      return cTDrawing;
    } 
  }
  
  public void setDrawing(CTDrawing paramCTDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$14, 0);
      if (cTDrawing == null)
        cTDrawing = (CTDrawing)get_store().add_element_user(DRAWING$14); 
      cTDrawing.set((XmlObject)paramCTDrawing);
    } 
  }
  
  public CTDrawing addNewDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().add_element_user(DRAWING$14);
      return cTDrawing;
    } 
  }
  
  public CTLegacyDrawing getLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWING$16, 0);
      if (cTLegacyDrawing == null)
        return null; 
      return cTLegacyDrawing;
    } 
  }
  
  public boolean isSetLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACYDRAWING$16) != 0);
    } 
  }
  
  public void setLegacyDrawing(CTLegacyDrawing paramCTLegacyDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWING$16, 0);
      if (cTLegacyDrawing == null)
        cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWING$16); 
      cTLegacyDrawing.set((XmlObject)paramCTLegacyDrawing);
    } 
  }
  
  public CTLegacyDrawing addNewLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWING$16);
      return cTLegacyDrawing;
    } 
  }
  
  public void unsetLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACYDRAWING$16, 0);
    } 
  }
  
  public CTLegacyDrawing getLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWINGHF$18, 0);
      if (cTLegacyDrawing == null)
        return null; 
      return cTLegacyDrawing;
    } 
  }
  
  public boolean isSetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACYDRAWINGHF$18) != 0);
    } 
  }
  
  public void setLegacyDrawingHF(CTLegacyDrawing paramCTLegacyDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWINGHF$18, 0);
      if (cTLegacyDrawing == null)
        cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWINGHF$18); 
      cTLegacyDrawing.set((XmlObject)paramCTLegacyDrawing);
    } 
  }
  
  public CTLegacyDrawing addNewLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWINGHF$18);
      return cTLegacyDrawing;
    } 
  }
  
  public void unsetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACYDRAWINGHF$18, 0);
    } 
  }
  
  public CTSheetBackgroundPicture getPicture() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetBackgroundPicture cTSheetBackgroundPicture = null;
      cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().find_element_user(PICTURE$20, 0);
      if (cTSheetBackgroundPicture == null)
        return null; 
      return cTSheetBackgroundPicture;
    } 
  }
  
  public boolean isSetPicture() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PICTURE$20) != 0);
    } 
  }
  
  public void setPicture(CTSheetBackgroundPicture paramCTSheetBackgroundPicture) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetBackgroundPicture cTSheetBackgroundPicture = null;
      cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().find_element_user(PICTURE$20, 0);
      if (cTSheetBackgroundPicture == null)
        cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().add_element_user(PICTURE$20); 
      cTSheetBackgroundPicture.set((XmlObject)paramCTSheetBackgroundPicture);
    } 
  }
  
  public CTSheetBackgroundPicture addNewPicture() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetBackgroundPicture cTSheetBackgroundPicture = null;
      cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().add_element_user(PICTURE$20);
      return cTSheetBackgroundPicture;
    } 
  }
  
  public void unsetPicture() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PICTURE$20, 0);
    } 
  }
  
  public CTWebPublishItems getWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishItems cTWebPublishItems = null;
      cTWebPublishItems = (CTWebPublishItems)get_store().find_element_user(WEBPUBLISHITEMS$22, 0);
      if (cTWebPublishItems == null)
        return null; 
      return cTWebPublishItems;
    } 
  }
  
  public boolean isSetWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WEBPUBLISHITEMS$22) != 0);
    } 
  }
  
  public void setWebPublishItems(CTWebPublishItems paramCTWebPublishItems) {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishItems cTWebPublishItems = null;
      cTWebPublishItems = (CTWebPublishItems)get_store().find_element_user(WEBPUBLISHITEMS$22, 0);
      if (cTWebPublishItems == null)
        cTWebPublishItems = (CTWebPublishItems)get_store().add_element_user(WEBPUBLISHITEMS$22); 
      cTWebPublishItems.set((XmlObject)paramCTWebPublishItems);
    } 
  }
  
  public CTWebPublishItems addNewWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishItems cTWebPublishItems = null;
      cTWebPublishItems = (CTWebPublishItems)get_store().add_element_user(WEBPUBLISHITEMS$22);
      return cTWebPublishItems;
    } 
  }
  
  public void unsetWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WEBPUBLISHITEMS$22, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$24) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$24); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$24);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$24, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTChartsheetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */