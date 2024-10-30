package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataConsolidate;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTScenarios;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetBackgroundPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetDimension;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTags;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

public class CTWorksheetImpl extends XmlComplexContentImpl implements CTWorksheet {
  private static final b SHEETPR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetPr");
  
  private static final b DIMENSION$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dimension");
  
  private static final b SHEETVIEWS$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetViews");
  
  private static final b SHEETFORMATPR$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetFormatPr");
  
  private static final b COLS$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cols");
  
  private static final b SHEETDATA$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetData");
  
  private static final b SHEETCALCPR$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetCalcPr");
  
  private static final b SHEETPROTECTION$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetProtection");
  
  private static final b PROTECTEDRANGES$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "protectedRanges");
  
  private static final b SCENARIOS$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "scenarios");
  
  private static final b AUTOFILTER$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "autoFilter");
  
  private static final b SORTSTATE$22 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sortState");
  
  private static final b DATACONSOLIDATE$24 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataConsolidate");
  
  private static final b CUSTOMSHEETVIEWS$26 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetViews");
  
  private static final b MERGECELLS$28 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "mergeCells");
  
  private static final b PHONETICPR$30 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "phoneticPr");
  
  private static final b CONDITIONALFORMATTING$32 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "conditionalFormatting");
  
  private static final b DATAVALIDATIONS$34 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataValidations");
  
  private static final b HYPERLINKS$36 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "hyperlinks");
  
  private static final b PRINTOPTIONS$38 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "printOptions");
  
  private static final b PAGEMARGINS$40 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageMargins");
  
  private static final b PAGESETUP$42 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetup");
  
  private static final b HEADERFOOTER$44 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "headerFooter");
  
  private static final b ROWBREAKS$46 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rowBreaks");
  
  private static final b COLBREAKS$48 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colBreaks");
  
  private static final b CUSTOMPROPERTIES$50 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customProperties");
  
  private static final b CELLWATCHES$52 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellWatches");
  
  private static final b IGNOREDERRORS$54 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "ignoredErrors");
  
  private static final b SMARTTAGS$56 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTags");
  
  private static final b DRAWING$58 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawing");
  
  private static final b LEGACYDRAWING$60 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawing");
  
  private static final b LEGACYDRAWINGHF$62 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawingHF");
  
  private static final b PICTURE$64 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "picture");
  
  private static final b OLEOBJECTS$66 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleObjects");
  
  private static final b CONTROLS$68 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "controls");
  
  private static final b WEBPUBLISHITEMS$70 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishItems");
  
  private static final b TABLEPARTS$72 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableParts");
  
  private static final b EXTLST$74 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTWorksheetImpl(SchemaType paramSchemaType) {
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
  
  public CTSheetDimension getDimension() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetDimension cTSheetDimension = null;
      cTSheetDimension = (CTSheetDimension)get_store().find_element_user(DIMENSION$2, 0);
      if (cTSheetDimension == null)
        return null; 
      return cTSheetDimension;
    } 
  }
  
  public boolean isSetDimension() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DIMENSION$2) != 0);
    } 
  }
  
  public void setDimension(CTSheetDimension paramCTSheetDimension) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetDimension cTSheetDimension = null;
      cTSheetDimension = (CTSheetDimension)get_store().find_element_user(DIMENSION$2, 0);
      if (cTSheetDimension == null)
        cTSheetDimension = (CTSheetDimension)get_store().add_element_user(DIMENSION$2); 
      cTSheetDimension.set((XmlObject)paramCTSheetDimension);
    } 
  }
  
  public CTSheetDimension addNewDimension() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetDimension cTSheetDimension = null;
      cTSheetDimension = (CTSheetDimension)get_store().add_element_user(DIMENSION$2);
      return cTSheetDimension;
    } 
  }
  
  public void unsetDimension() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DIMENSION$2, 0);
    } 
  }
  
  public CTSheetViews getSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetViews cTSheetViews = null;
      cTSheetViews = (CTSheetViews)get_store().find_element_user(SHEETVIEWS$4, 0);
      if (cTSheetViews == null)
        return null; 
      return cTSheetViews;
    } 
  }
  
  public boolean isSetSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETVIEWS$4) != 0);
    } 
  }
  
  public void setSheetViews(CTSheetViews paramCTSheetViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetViews cTSheetViews = null;
      cTSheetViews = (CTSheetViews)get_store().find_element_user(SHEETVIEWS$4, 0);
      if (cTSheetViews == null)
        cTSheetViews = (CTSheetViews)get_store().add_element_user(SHEETVIEWS$4); 
      cTSheetViews.set((XmlObject)paramCTSheetViews);
    } 
  }
  
  public CTSheetViews addNewSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetViews cTSheetViews = null;
      cTSheetViews = (CTSheetViews)get_store().add_element_user(SHEETVIEWS$4);
      return cTSheetViews;
    } 
  }
  
  public void unsetSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETVIEWS$4, 0);
    } 
  }
  
  public CTSheetFormatPr getSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetFormatPr cTSheetFormatPr = null;
      cTSheetFormatPr = (CTSheetFormatPr)get_store().find_element_user(SHEETFORMATPR$6, 0);
      if (cTSheetFormatPr == null)
        return null; 
      return cTSheetFormatPr;
    } 
  }
  
  public boolean isSetSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETFORMATPR$6) != 0);
    } 
  }
  
  public void setSheetFormatPr(CTSheetFormatPr paramCTSheetFormatPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetFormatPr cTSheetFormatPr = null;
      cTSheetFormatPr = (CTSheetFormatPr)get_store().find_element_user(SHEETFORMATPR$6, 0);
      if (cTSheetFormatPr == null)
        cTSheetFormatPr = (CTSheetFormatPr)get_store().add_element_user(SHEETFORMATPR$6); 
      cTSheetFormatPr.set((XmlObject)paramCTSheetFormatPr);
    } 
  }
  
  public CTSheetFormatPr addNewSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetFormatPr cTSheetFormatPr = null;
      cTSheetFormatPr = (CTSheetFormatPr)get_store().add_element_user(SHEETFORMATPR$6);
      return cTSheetFormatPr;
    } 
  }
  
  public void unsetSheetFormatPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETFORMATPR$6, 0);
    } 
  }
  
  public List<CTCols> getColsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCols>)new ColsList(this);
    } 
  }
  
  public CTCols[] getColsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COLS$8, arrayList);
      CTCols[] arrayOfCTCols = new CTCols[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCols);
      return arrayOfCTCols;
    } 
  }
  
  public CTCols getColsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCols cTCols = null;
      cTCols = (CTCols)get_store().find_element_user(COLS$8, paramInt);
      if (cTCols == null)
        throw new IndexOutOfBoundsException(); 
      return cTCols;
    } 
  }
  
  public int sizeOfColsArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COLS$8);
    } 
  }
  
  public void setColsArray(CTCols[] paramArrayOfCTCols) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCols, COLS$8);
    } 
  }
  
  public void setColsArray(int paramInt, CTCols paramCTCols) {
    synchronized (monitor()) {
      check_orphaned();
      CTCols cTCols = null;
      cTCols = (CTCols)get_store().find_element_user(COLS$8, paramInt);
      if (cTCols == null)
        throw new IndexOutOfBoundsException(); 
      cTCols.set((XmlObject)paramCTCols);
    } 
  }
  
  public CTCols insertNewCols(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCols cTCols = null;
      cTCols = (CTCols)get_store().insert_element_user(COLS$8, paramInt);
      return cTCols;
    } 
  }
  
  public CTCols addNewCols() {
    synchronized (monitor()) {
      check_orphaned();
      CTCols cTCols = null;
      cTCols = (CTCols)get_store().add_element_user(COLS$8);
      return cTCols;
    } 
  }
  
  public void removeCols(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLS$8, paramInt);
    } 
  }
  
  public CTSheetData getSheetData() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetData cTSheetData = null;
      cTSheetData = (CTSheetData)get_store().find_element_user(SHEETDATA$10, 0);
      if (cTSheetData == null)
        return null; 
      return cTSheetData;
    } 
  }
  
  public void setSheetData(CTSheetData paramCTSheetData) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetData cTSheetData = null;
      cTSheetData = (CTSheetData)get_store().find_element_user(SHEETDATA$10, 0);
      if (cTSheetData == null)
        cTSheetData = (CTSheetData)get_store().add_element_user(SHEETDATA$10); 
      cTSheetData.set((XmlObject)paramCTSheetData);
    } 
  }
  
  public CTSheetData addNewSheetData() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetData cTSheetData = null;
      cTSheetData = (CTSheetData)get_store().add_element_user(SHEETDATA$10);
      return cTSheetData;
    } 
  }
  
  public CTSheetCalcPr getSheetCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetCalcPr cTSheetCalcPr = null;
      cTSheetCalcPr = (CTSheetCalcPr)get_store().find_element_user(SHEETCALCPR$12, 0);
      if (cTSheetCalcPr == null)
        return null; 
      return cTSheetCalcPr;
    } 
  }
  
  public boolean isSetSheetCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETCALCPR$12) != 0);
    } 
  }
  
  public void setSheetCalcPr(CTSheetCalcPr paramCTSheetCalcPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetCalcPr cTSheetCalcPr = null;
      cTSheetCalcPr = (CTSheetCalcPr)get_store().find_element_user(SHEETCALCPR$12, 0);
      if (cTSheetCalcPr == null)
        cTSheetCalcPr = (CTSheetCalcPr)get_store().add_element_user(SHEETCALCPR$12); 
      cTSheetCalcPr.set((XmlObject)paramCTSheetCalcPr);
    } 
  }
  
  public CTSheetCalcPr addNewSheetCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetCalcPr cTSheetCalcPr = null;
      cTSheetCalcPr = (CTSheetCalcPr)get_store().add_element_user(SHEETCALCPR$12);
      return cTSheetCalcPr;
    } 
  }
  
  public void unsetSheetCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETCALCPR$12, 0);
    } 
  }
  
  public CTSheetProtection getSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetProtection cTSheetProtection = null;
      cTSheetProtection = (CTSheetProtection)get_store().find_element_user(SHEETPROTECTION$14, 0);
      if (cTSheetProtection == null)
        return null; 
      return cTSheetProtection;
    } 
  }
  
  public boolean isSetSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETPROTECTION$14) != 0);
    } 
  }
  
  public void setSheetProtection(CTSheetProtection paramCTSheetProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetProtection cTSheetProtection = null;
      cTSheetProtection = (CTSheetProtection)get_store().find_element_user(SHEETPROTECTION$14, 0);
      if (cTSheetProtection == null)
        cTSheetProtection = (CTSheetProtection)get_store().add_element_user(SHEETPROTECTION$14); 
      cTSheetProtection.set((XmlObject)paramCTSheetProtection);
    } 
  }
  
  public CTSheetProtection addNewSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetProtection cTSheetProtection = null;
      cTSheetProtection = (CTSheetProtection)get_store().add_element_user(SHEETPROTECTION$14);
      return cTSheetProtection;
    } 
  }
  
  public void unsetSheetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETPROTECTION$14, 0);
    } 
  }
  
  public CTProtectedRanges getProtectedRanges() {
    synchronized (monitor()) {
      check_orphaned();
      CTProtectedRanges cTProtectedRanges = null;
      cTProtectedRanges = (CTProtectedRanges)get_store().find_element_user(PROTECTEDRANGES$16, 0);
      if (cTProtectedRanges == null)
        return null; 
      return cTProtectedRanges;
    } 
  }
  
  public boolean isSetProtectedRanges() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTEDRANGES$16) != 0);
    } 
  }
  
  public void setProtectedRanges(CTProtectedRanges paramCTProtectedRanges) {
    synchronized (monitor()) {
      check_orphaned();
      CTProtectedRanges cTProtectedRanges = null;
      cTProtectedRanges = (CTProtectedRanges)get_store().find_element_user(PROTECTEDRANGES$16, 0);
      if (cTProtectedRanges == null)
        cTProtectedRanges = (CTProtectedRanges)get_store().add_element_user(PROTECTEDRANGES$16); 
      cTProtectedRanges.set((XmlObject)paramCTProtectedRanges);
    } 
  }
  
  public CTProtectedRanges addNewProtectedRanges() {
    synchronized (monitor()) {
      check_orphaned();
      CTProtectedRanges cTProtectedRanges = null;
      cTProtectedRanges = (CTProtectedRanges)get_store().add_element_user(PROTECTEDRANGES$16);
      return cTProtectedRanges;
    } 
  }
  
  public void unsetProtectedRanges() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTEDRANGES$16, 0);
    } 
  }
  
  public CTScenarios getScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      CTScenarios cTScenarios = null;
      cTScenarios = (CTScenarios)get_store().find_element_user(SCENARIOS$18, 0);
      if (cTScenarios == null)
        return null; 
      return cTScenarios;
    } 
  }
  
  public boolean isSetScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCENARIOS$18) != 0);
    } 
  }
  
  public void setScenarios(CTScenarios paramCTScenarios) {
    synchronized (monitor()) {
      check_orphaned();
      CTScenarios cTScenarios = null;
      cTScenarios = (CTScenarios)get_store().find_element_user(SCENARIOS$18, 0);
      if (cTScenarios == null)
        cTScenarios = (CTScenarios)get_store().add_element_user(SCENARIOS$18); 
      cTScenarios.set((XmlObject)paramCTScenarios);
    } 
  }
  
  public CTScenarios addNewScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      CTScenarios cTScenarios = null;
      cTScenarios = (CTScenarios)get_store().add_element_user(SCENARIOS$18);
      return cTScenarios;
    } 
  }
  
  public void unsetScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCENARIOS$18, 0);
    } 
  }
  
  public CTAutoFilter getAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoFilter cTAutoFilter = null;
      cTAutoFilter = (CTAutoFilter)get_store().find_element_user(AUTOFILTER$20, 0);
      if (cTAutoFilter == null)
        return null; 
      return cTAutoFilter;
    } 
  }
  
  public boolean isSetAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOFILTER$20) != 0);
    } 
  }
  
  public void setAutoFilter(CTAutoFilter paramCTAutoFilter) {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoFilter cTAutoFilter = null;
      cTAutoFilter = (CTAutoFilter)get_store().find_element_user(AUTOFILTER$20, 0);
      if (cTAutoFilter == null)
        cTAutoFilter = (CTAutoFilter)get_store().add_element_user(AUTOFILTER$20); 
      cTAutoFilter.set((XmlObject)paramCTAutoFilter);
    } 
  }
  
  public CTAutoFilter addNewAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoFilter cTAutoFilter = null;
      cTAutoFilter = (CTAutoFilter)get_store().add_element_user(AUTOFILTER$20);
      return cTAutoFilter;
    } 
  }
  
  public void unsetAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOFILTER$20, 0);
    } 
  }
  
  public CTSortState getSortState() {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().find_element_user(SORTSTATE$22, 0);
      if (cTSortState == null)
        return null; 
      return cTSortState;
    } 
  }
  
  public boolean isSetSortState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SORTSTATE$22) != 0);
    } 
  }
  
  public void setSortState(CTSortState paramCTSortState) {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().find_element_user(SORTSTATE$22, 0);
      if (cTSortState == null)
        cTSortState = (CTSortState)get_store().add_element_user(SORTSTATE$22); 
      cTSortState.set((XmlObject)paramCTSortState);
    } 
  }
  
  public CTSortState addNewSortState() {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().add_element_user(SORTSTATE$22);
      return cTSortState;
    } 
  }
  
  public void unsetSortState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SORTSTATE$22, 0);
    } 
  }
  
  public CTDataConsolidate getDataConsolidate() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataConsolidate cTDataConsolidate = null;
      cTDataConsolidate = (CTDataConsolidate)get_store().find_element_user(DATACONSOLIDATE$24, 0);
      if (cTDataConsolidate == null)
        return null; 
      return cTDataConsolidate;
    } 
  }
  
  public boolean isSetDataConsolidate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATACONSOLIDATE$24) != 0);
    } 
  }
  
  public void setDataConsolidate(CTDataConsolidate paramCTDataConsolidate) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataConsolidate cTDataConsolidate = null;
      cTDataConsolidate = (CTDataConsolidate)get_store().find_element_user(DATACONSOLIDATE$24, 0);
      if (cTDataConsolidate == null)
        cTDataConsolidate = (CTDataConsolidate)get_store().add_element_user(DATACONSOLIDATE$24); 
      cTDataConsolidate.set((XmlObject)paramCTDataConsolidate);
    } 
  }
  
  public CTDataConsolidate addNewDataConsolidate() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataConsolidate cTDataConsolidate = null;
      cTDataConsolidate = (CTDataConsolidate)get_store().add_element_user(DATACONSOLIDATE$24);
      return cTDataConsolidate;
    } 
  }
  
  public void unsetDataConsolidate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATACONSOLIDATE$24, 0);
    } 
  }
  
  public CTCustomSheetViews getCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomSheetViews cTCustomSheetViews = null;
      cTCustomSheetViews = (CTCustomSheetViews)get_store().find_element_user(CUSTOMSHEETVIEWS$26, 0);
      if (cTCustomSheetViews == null)
        return null; 
      return cTCustomSheetViews;
    } 
  }
  
  public boolean isSetCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTOMSHEETVIEWS$26) != 0);
    } 
  }
  
  public void setCustomSheetViews(CTCustomSheetViews paramCTCustomSheetViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomSheetViews cTCustomSheetViews = null;
      cTCustomSheetViews = (CTCustomSheetViews)get_store().find_element_user(CUSTOMSHEETVIEWS$26, 0);
      if (cTCustomSheetViews == null)
        cTCustomSheetViews = (CTCustomSheetViews)get_store().add_element_user(CUSTOMSHEETVIEWS$26); 
      cTCustomSheetViews.set((XmlObject)paramCTCustomSheetViews);
    } 
  }
  
  public CTCustomSheetViews addNewCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomSheetViews cTCustomSheetViews = null;
      cTCustomSheetViews = (CTCustomSheetViews)get_store().add_element_user(CUSTOMSHEETVIEWS$26);
      return cTCustomSheetViews;
    } 
  }
  
  public void unsetCustomSheetViews() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMSHEETVIEWS$26, 0);
    } 
  }
  
  public CTMergeCells getMergeCells() {
    synchronized (monitor()) {
      check_orphaned();
      CTMergeCells cTMergeCells = null;
      cTMergeCells = (CTMergeCells)get_store().find_element_user(MERGECELLS$28, 0);
      if (cTMergeCells == null)
        return null; 
      return cTMergeCells;
    } 
  }
  
  public boolean isSetMergeCells() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MERGECELLS$28) != 0);
    } 
  }
  
  public void setMergeCells(CTMergeCells paramCTMergeCells) {
    synchronized (monitor()) {
      check_orphaned();
      CTMergeCells cTMergeCells = null;
      cTMergeCells = (CTMergeCells)get_store().find_element_user(MERGECELLS$28, 0);
      if (cTMergeCells == null)
        cTMergeCells = (CTMergeCells)get_store().add_element_user(MERGECELLS$28); 
      cTMergeCells.set((XmlObject)paramCTMergeCells);
    } 
  }
  
  public CTMergeCells addNewMergeCells() {
    synchronized (monitor()) {
      check_orphaned();
      CTMergeCells cTMergeCells = null;
      cTMergeCells = (CTMergeCells)get_store().add_element_user(MERGECELLS$28);
      return cTMergeCells;
    } 
  }
  
  public void unsetMergeCells() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MERGECELLS$28, 0);
    } 
  }
  
  public CTPhoneticPr getPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticPr cTPhoneticPr = null;
      cTPhoneticPr = (CTPhoneticPr)get_store().find_element_user(PHONETICPR$30, 0);
      if (cTPhoneticPr == null)
        return null; 
      return cTPhoneticPr;
    } 
  }
  
  public boolean isSetPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PHONETICPR$30) != 0);
    } 
  }
  
  public void setPhoneticPr(CTPhoneticPr paramCTPhoneticPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticPr cTPhoneticPr = null;
      cTPhoneticPr = (CTPhoneticPr)get_store().find_element_user(PHONETICPR$30, 0);
      if (cTPhoneticPr == null)
        cTPhoneticPr = (CTPhoneticPr)get_store().add_element_user(PHONETICPR$30); 
      cTPhoneticPr.set((XmlObject)paramCTPhoneticPr);
    } 
  }
  
  public CTPhoneticPr addNewPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticPr cTPhoneticPr = null;
      cTPhoneticPr = (CTPhoneticPr)get_store().add_element_user(PHONETICPR$30);
      return cTPhoneticPr;
    } 
  }
  
  public void unsetPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PHONETICPR$30, 0);
    } 
  }
  
  public List<CTConditionalFormatting> getConditionalFormattingList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTConditionalFormatting>)new ConditionalFormattingList(this);
    } 
  }
  
  public CTConditionalFormatting[] getConditionalFormattingArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CONDITIONALFORMATTING$32, arrayList);
      CTConditionalFormatting[] arrayOfCTConditionalFormatting = new CTConditionalFormatting[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTConditionalFormatting);
      return arrayOfCTConditionalFormatting;
    } 
  }
  
  public CTConditionalFormatting getConditionalFormattingArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTConditionalFormatting cTConditionalFormatting = null;
      cTConditionalFormatting = (CTConditionalFormatting)get_store().find_element_user(CONDITIONALFORMATTING$32, paramInt);
      if (cTConditionalFormatting == null)
        throw new IndexOutOfBoundsException(); 
      return cTConditionalFormatting;
    } 
  }
  
  public int sizeOfConditionalFormattingArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CONDITIONALFORMATTING$32);
    } 
  }
  
  public void setConditionalFormattingArray(CTConditionalFormatting[] paramArrayOfCTConditionalFormatting) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTConditionalFormatting, CONDITIONALFORMATTING$32);
    } 
  }
  
  public void setConditionalFormattingArray(int paramInt, CTConditionalFormatting paramCTConditionalFormatting) {
    synchronized (monitor()) {
      check_orphaned();
      CTConditionalFormatting cTConditionalFormatting = null;
      cTConditionalFormatting = (CTConditionalFormatting)get_store().find_element_user(CONDITIONALFORMATTING$32, paramInt);
      if (cTConditionalFormatting == null)
        throw new IndexOutOfBoundsException(); 
      cTConditionalFormatting.set((XmlObject)paramCTConditionalFormatting);
    } 
  }
  
  public CTConditionalFormatting insertNewConditionalFormatting(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTConditionalFormatting cTConditionalFormatting = null;
      cTConditionalFormatting = (CTConditionalFormatting)get_store().insert_element_user(CONDITIONALFORMATTING$32, paramInt);
      return cTConditionalFormatting;
    } 
  }
  
  public CTConditionalFormatting addNewConditionalFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      CTConditionalFormatting cTConditionalFormatting = null;
      cTConditionalFormatting = (CTConditionalFormatting)get_store().add_element_user(CONDITIONALFORMATTING$32);
      return cTConditionalFormatting;
    } 
  }
  
  public void removeConditionalFormatting(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONDITIONALFORMATTING$32, paramInt);
    } 
  }
  
  public CTDataValidations getDataValidations() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataValidations cTDataValidations = null;
      cTDataValidations = (CTDataValidations)get_store().find_element_user(DATAVALIDATIONS$34, 0);
      if (cTDataValidations == null)
        return null; 
      return cTDataValidations;
    } 
  }
  
  public boolean isSetDataValidations() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATAVALIDATIONS$34) != 0);
    } 
  }
  
  public void setDataValidations(CTDataValidations paramCTDataValidations) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataValidations cTDataValidations = null;
      cTDataValidations = (CTDataValidations)get_store().find_element_user(DATAVALIDATIONS$34, 0);
      if (cTDataValidations == null)
        cTDataValidations = (CTDataValidations)get_store().add_element_user(DATAVALIDATIONS$34); 
      cTDataValidations.set((XmlObject)paramCTDataValidations);
    } 
  }
  
  public CTDataValidations addNewDataValidations() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataValidations cTDataValidations = null;
      cTDataValidations = (CTDataValidations)get_store().add_element_user(DATAVALIDATIONS$34);
      return cTDataValidations;
    } 
  }
  
  public void unsetDataValidations() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATAVALIDATIONS$34, 0);
    } 
  }
  
  public CTHyperlinks getHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlinks cTHyperlinks = null;
      cTHyperlinks = (CTHyperlinks)get_store().find_element_user(HYPERLINKS$36, 0);
      if (cTHyperlinks == null)
        return null; 
      return cTHyperlinks;
    } 
  }
  
  public boolean isSetHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HYPERLINKS$36) != 0);
    } 
  }
  
  public void setHyperlinks(CTHyperlinks paramCTHyperlinks) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlinks cTHyperlinks = null;
      cTHyperlinks = (CTHyperlinks)get_store().find_element_user(HYPERLINKS$36, 0);
      if (cTHyperlinks == null)
        cTHyperlinks = (CTHyperlinks)get_store().add_element_user(HYPERLINKS$36); 
      cTHyperlinks.set((XmlObject)paramCTHyperlinks);
    } 
  }
  
  public CTHyperlinks addNewHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlinks cTHyperlinks = null;
      cTHyperlinks = (CTHyperlinks)get_store().add_element_user(HYPERLINKS$36);
      return cTHyperlinks;
    } 
  }
  
  public void unsetHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HYPERLINKS$36, 0);
    } 
  }
  
  public CTPrintOptions getPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintOptions cTPrintOptions = null;
      cTPrintOptions = (CTPrintOptions)get_store().find_element_user(PRINTOPTIONS$38, 0);
      if (cTPrintOptions == null)
        return null; 
      return cTPrintOptions;
    } 
  }
  
  public boolean isSetPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRINTOPTIONS$38) != 0);
    } 
  }
  
  public void setPrintOptions(CTPrintOptions paramCTPrintOptions) {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintOptions cTPrintOptions = null;
      cTPrintOptions = (CTPrintOptions)get_store().find_element_user(PRINTOPTIONS$38, 0);
      if (cTPrintOptions == null)
        cTPrintOptions = (CTPrintOptions)get_store().add_element_user(PRINTOPTIONS$38); 
      cTPrintOptions.set((XmlObject)paramCTPrintOptions);
    } 
  }
  
  public CTPrintOptions addNewPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      CTPrintOptions cTPrintOptions = null;
      cTPrintOptions = (CTPrintOptions)get_store().add_element_user(PRINTOPTIONS$38);
      return cTPrintOptions;
    } 
  }
  
  public void unsetPrintOptions() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTOPTIONS$38, 0);
    } 
  }
  
  public CTPageMargins getPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$40, 0);
      if (cTPageMargins == null)
        return null; 
      return cTPageMargins;
    } 
  }
  
  public boolean isSetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGEMARGINS$40) != 0);
    } 
  }
  
  public void setPageMargins(CTPageMargins paramCTPageMargins) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().find_element_user(PAGEMARGINS$40, 0);
      if (cTPageMargins == null)
        cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$40); 
      cTPageMargins.set((XmlObject)paramCTPageMargins);
    } 
  }
  
  public CTPageMargins addNewPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageMargins cTPageMargins = null;
      cTPageMargins = (CTPageMargins)get_store().add_element_user(PAGEMARGINS$40);
      return cTPageMargins;
    } 
  }
  
  public void unsetPageMargins() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGEMARGINS$40, 0);
    } 
  }
  
  public CTPageSetup getPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().find_element_user(PAGESETUP$42, 0);
      if (cTPageSetup == null)
        return null; 
      return cTPageSetup;
    } 
  }
  
  public boolean isSetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGESETUP$42) != 0);
    } 
  }
  
  public void setPageSetup(CTPageSetup paramCTPageSetup) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().find_element_user(PAGESETUP$42, 0);
      if (cTPageSetup == null)
        cTPageSetup = (CTPageSetup)get_store().add_element_user(PAGESETUP$42); 
      cTPageSetup.set((XmlObject)paramCTPageSetup);
    } 
  }
  
  public CTPageSetup addNewPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageSetup cTPageSetup = null;
      cTPageSetup = (CTPageSetup)get_store().add_element_user(PAGESETUP$42);
      return cTPageSetup;
    } 
  }
  
  public void unsetPageSetup() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGESETUP$42, 0);
    } 
  }
  
  public CTHeaderFooter getHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$44, 0);
      if (cTHeaderFooter == null)
        return null; 
      return cTHeaderFooter;
    } 
  }
  
  public boolean isSetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HEADERFOOTER$44) != 0);
    } 
  }
  
  public void setHeaderFooter(CTHeaderFooter paramCTHeaderFooter) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HEADERFOOTER$44, 0);
      if (cTHeaderFooter == null)
        cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$44); 
      cTHeaderFooter.set((XmlObject)paramCTHeaderFooter);
    } 
  }
  
  public CTHeaderFooter addNewHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HEADERFOOTER$44);
      return cTHeaderFooter;
    } 
  }
  
  public void unsetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADERFOOTER$44, 0);
    } 
  }
  
  public CTPageBreak getRowBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBreak cTPageBreak = null;
      cTPageBreak = (CTPageBreak)get_store().find_element_user(ROWBREAKS$46, 0);
      if (cTPageBreak == null)
        return null; 
      return cTPageBreak;
    } 
  }
  
  public boolean isSetRowBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ROWBREAKS$46) != 0);
    } 
  }
  
  public void setRowBreaks(CTPageBreak paramCTPageBreak) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBreak cTPageBreak = null;
      cTPageBreak = (CTPageBreak)get_store().find_element_user(ROWBREAKS$46, 0);
      if (cTPageBreak == null)
        cTPageBreak = (CTPageBreak)get_store().add_element_user(ROWBREAKS$46); 
      cTPageBreak.set((XmlObject)paramCTPageBreak);
    } 
  }
  
  public CTPageBreak addNewRowBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBreak cTPageBreak = null;
      cTPageBreak = (CTPageBreak)get_store().add_element_user(ROWBREAKS$46);
      return cTPageBreak;
    } 
  }
  
  public void unsetRowBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROWBREAKS$46, 0);
    } 
  }
  
  public CTPageBreak getColBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBreak cTPageBreak = null;
      cTPageBreak = (CTPageBreak)get_store().find_element_user(COLBREAKS$48, 0);
      if (cTPageBreak == null)
        return null; 
      return cTPageBreak;
    } 
  }
  
  public boolean isSetColBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLBREAKS$48) != 0);
    } 
  }
  
  public void setColBreaks(CTPageBreak paramCTPageBreak) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBreak cTPageBreak = null;
      cTPageBreak = (CTPageBreak)get_store().find_element_user(COLBREAKS$48, 0);
      if (cTPageBreak == null)
        cTPageBreak = (CTPageBreak)get_store().add_element_user(COLBREAKS$48); 
      cTPageBreak.set((XmlObject)paramCTPageBreak);
    } 
  }
  
  public CTPageBreak addNewColBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageBreak cTPageBreak = null;
      cTPageBreak = (CTPageBreak)get_store().add_element_user(COLBREAKS$48);
      return cTPageBreak;
    } 
  }
  
  public void unsetColBreaks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLBREAKS$48, 0);
    } 
  }
  
  public CTCustomProperties getCustomProperties() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomProperties cTCustomProperties = null;
      cTCustomProperties = (CTCustomProperties)get_store().find_element_user(CUSTOMPROPERTIES$50, 0);
      if (cTCustomProperties == null)
        return null; 
      return cTCustomProperties;
    } 
  }
  
  public boolean isSetCustomProperties() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTOMPROPERTIES$50) != 0);
    } 
  }
  
  public void setCustomProperties(CTCustomProperties paramCTCustomProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomProperties cTCustomProperties = null;
      cTCustomProperties = (CTCustomProperties)get_store().find_element_user(CUSTOMPROPERTIES$50, 0);
      if (cTCustomProperties == null)
        cTCustomProperties = (CTCustomProperties)get_store().add_element_user(CUSTOMPROPERTIES$50); 
      cTCustomProperties.set((XmlObject)paramCTCustomProperties);
    } 
  }
  
  public CTCustomProperties addNewCustomProperties() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomProperties cTCustomProperties = null;
      cTCustomProperties = (CTCustomProperties)get_store().add_element_user(CUSTOMPROPERTIES$50);
      return cTCustomProperties;
    } 
  }
  
  public void unsetCustomProperties() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMPROPERTIES$50, 0);
    } 
  }
  
  public CTCellWatches getCellWatches() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellWatches cTCellWatches = null;
      cTCellWatches = (CTCellWatches)get_store().find_element_user(CELLWATCHES$52, 0);
      if (cTCellWatches == null)
        return null; 
      return cTCellWatches;
    } 
  }
  
  public boolean isSetCellWatches() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELLWATCHES$52) != 0);
    } 
  }
  
  public void setCellWatches(CTCellWatches paramCTCellWatches) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellWatches cTCellWatches = null;
      cTCellWatches = (CTCellWatches)get_store().find_element_user(CELLWATCHES$52, 0);
      if (cTCellWatches == null)
        cTCellWatches = (CTCellWatches)get_store().add_element_user(CELLWATCHES$52); 
      cTCellWatches.set((XmlObject)paramCTCellWatches);
    } 
  }
  
  public CTCellWatches addNewCellWatches() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellWatches cTCellWatches = null;
      cTCellWatches = (CTCellWatches)get_store().add_element_user(CELLWATCHES$52);
      return cTCellWatches;
    } 
  }
  
  public void unsetCellWatches() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELLWATCHES$52, 0);
    } 
  }
  
  public CTIgnoredErrors getIgnoredErrors() {
    synchronized (monitor()) {
      check_orphaned();
      CTIgnoredErrors cTIgnoredErrors = null;
      cTIgnoredErrors = (CTIgnoredErrors)get_store().find_element_user(IGNOREDERRORS$54, 0);
      if (cTIgnoredErrors == null)
        return null; 
      return cTIgnoredErrors;
    } 
  }
  
  public boolean isSetIgnoredErrors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(IGNOREDERRORS$54) != 0);
    } 
  }
  
  public void setIgnoredErrors(CTIgnoredErrors paramCTIgnoredErrors) {
    synchronized (monitor()) {
      check_orphaned();
      CTIgnoredErrors cTIgnoredErrors = null;
      cTIgnoredErrors = (CTIgnoredErrors)get_store().find_element_user(IGNOREDERRORS$54, 0);
      if (cTIgnoredErrors == null)
        cTIgnoredErrors = (CTIgnoredErrors)get_store().add_element_user(IGNOREDERRORS$54); 
      cTIgnoredErrors.set((XmlObject)paramCTIgnoredErrors);
    } 
  }
  
  public CTIgnoredErrors addNewIgnoredErrors() {
    synchronized (monitor()) {
      check_orphaned();
      CTIgnoredErrors cTIgnoredErrors = null;
      cTIgnoredErrors = (CTIgnoredErrors)get_store().add_element_user(IGNOREDERRORS$54);
      return cTIgnoredErrors;
    } 
  }
  
  public void unsetIgnoredErrors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IGNOREDERRORS$54, 0);
    } 
  }
  
  public CTSmartTags getSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTags cTSmartTags = null;
      cTSmartTags = (CTSmartTags)get_store().find_element_user(SMARTTAGS$56, 0);
      if (cTSmartTags == null)
        return null; 
      return cTSmartTags;
    } 
  }
  
  public boolean isSetSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMARTTAGS$56) != 0);
    } 
  }
  
  public void setSmartTags(CTSmartTags paramCTSmartTags) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTags cTSmartTags = null;
      cTSmartTags = (CTSmartTags)get_store().find_element_user(SMARTTAGS$56, 0);
      if (cTSmartTags == null)
        cTSmartTags = (CTSmartTags)get_store().add_element_user(SMARTTAGS$56); 
      cTSmartTags.set((XmlObject)paramCTSmartTags);
    } 
  }
  
  public CTSmartTags addNewSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTags cTSmartTags = null;
      cTSmartTags = (CTSmartTags)get_store().add_element_user(SMARTTAGS$56);
      return cTSmartTags;
    } 
  }
  
  public void unsetSmartTags() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMARTTAGS$56, 0);
    } 
  }
  
  public CTDrawing getDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$58, 0);
      if (cTDrawing == null)
        return null; 
      return cTDrawing;
    } 
  }
  
  public boolean isSetDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DRAWING$58) != 0);
    } 
  }
  
  public void setDrawing(CTDrawing paramCTDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().find_element_user(DRAWING$58, 0);
      if (cTDrawing == null)
        cTDrawing = (CTDrawing)get_store().add_element_user(DRAWING$58); 
      cTDrawing.set((XmlObject)paramCTDrawing);
    } 
  }
  
  public CTDrawing addNewDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTDrawing cTDrawing = null;
      cTDrawing = (CTDrawing)get_store().add_element_user(DRAWING$58);
      return cTDrawing;
    } 
  }
  
  public void unsetDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DRAWING$58, 0);
    } 
  }
  
  public CTLegacyDrawing getLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWING$60, 0);
      if (cTLegacyDrawing == null)
        return null; 
      return cTLegacyDrawing;
    } 
  }
  
  public boolean isSetLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACYDRAWING$60) != 0);
    } 
  }
  
  public void setLegacyDrawing(CTLegacyDrawing paramCTLegacyDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWING$60, 0);
      if (cTLegacyDrawing == null)
        cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWING$60); 
      cTLegacyDrawing.set((XmlObject)paramCTLegacyDrawing);
    } 
  }
  
  public CTLegacyDrawing addNewLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWING$60);
      return cTLegacyDrawing;
    } 
  }
  
  public void unsetLegacyDrawing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACYDRAWING$60, 0);
    } 
  }
  
  public CTLegacyDrawing getLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWINGHF$62, 0);
      if (cTLegacyDrawing == null)
        return null; 
      return cTLegacyDrawing;
    } 
  }
  
  public boolean isSetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGACYDRAWINGHF$62) != 0);
    } 
  }
  
  public void setLegacyDrawingHF(CTLegacyDrawing paramCTLegacyDrawing) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().find_element_user(LEGACYDRAWINGHF$62, 0);
      if (cTLegacyDrawing == null)
        cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWINGHF$62); 
      cTLegacyDrawing.set((XmlObject)paramCTLegacyDrawing);
    } 
  }
  
  public CTLegacyDrawing addNewLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegacyDrawing cTLegacyDrawing = null;
      cTLegacyDrawing = (CTLegacyDrawing)get_store().add_element_user(LEGACYDRAWINGHF$62);
      return cTLegacyDrawing;
    } 
  }
  
  public void unsetLegacyDrawingHF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGACYDRAWINGHF$62, 0);
    } 
  }
  
  public CTSheetBackgroundPicture getPicture() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetBackgroundPicture cTSheetBackgroundPicture = null;
      cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().find_element_user(PICTURE$64, 0);
      if (cTSheetBackgroundPicture == null)
        return null; 
      return cTSheetBackgroundPicture;
    } 
  }
  
  public boolean isSetPicture() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PICTURE$64) != 0);
    } 
  }
  
  public void setPicture(CTSheetBackgroundPicture paramCTSheetBackgroundPicture) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetBackgroundPicture cTSheetBackgroundPicture = null;
      cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().find_element_user(PICTURE$64, 0);
      if (cTSheetBackgroundPicture == null)
        cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().add_element_user(PICTURE$64); 
      cTSheetBackgroundPicture.set((XmlObject)paramCTSheetBackgroundPicture);
    } 
  }
  
  public CTSheetBackgroundPicture addNewPicture() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheetBackgroundPicture cTSheetBackgroundPicture = null;
      cTSheetBackgroundPicture = (CTSheetBackgroundPicture)get_store().add_element_user(PICTURE$64);
      return cTSheetBackgroundPicture;
    } 
  }
  
  public void unsetPicture() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PICTURE$64, 0);
    } 
  }
  
  public CTOleObjects getOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleObjects cTOleObjects = null;
      cTOleObjects = (CTOleObjects)get_store().find_element_user(OLEOBJECTS$66, 0);
      if (cTOleObjects == null)
        return null; 
      return cTOleObjects;
    } 
  }
  
  public boolean isSetOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OLEOBJECTS$66) != 0);
    } 
  }
  
  public void setOleObjects(CTOleObjects paramCTOleObjects) {
    synchronized (monitor()) {
      check_orphaned();
      CTOleObjects cTOleObjects = null;
      cTOleObjects = (CTOleObjects)get_store().find_element_user(OLEOBJECTS$66, 0);
      if (cTOleObjects == null)
        cTOleObjects = (CTOleObjects)get_store().add_element_user(OLEOBJECTS$66); 
      cTOleObjects.set((XmlObject)paramCTOleObjects);
    } 
  }
  
  public CTOleObjects addNewOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleObjects cTOleObjects = null;
      cTOleObjects = (CTOleObjects)get_store().add_element_user(OLEOBJECTS$66);
      return cTOleObjects;
    } 
  }
  
  public void unsetOleObjects() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OLEOBJECTS$66, 0);
    } 
  }
  
  public CTControls getControls() {
    synchronized (monitor()) {
      check_orphaned();
      CTControls cTControls = null;
      cTControls = (CTControls)get_store().find_element_user(CONTROLS$68, 0);
      if (cTControls == null)
        return null; 
      return cTControls;
    } 
  }
  
  public boolean isSetControls() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONTROLS$68) != 0);
    } 
  }
  
  public void setControls(CTControls paramCTControls) {
    synchronized (monitor()) {
      check_orphaned();
      CTControls cTControls = null;
      cTControls = (CTControls)get_store().find_element_user(CONTROLS$68, 0);
      if (cTControls == null)
        cTControls = (CTControls)get_store().add_element_user(CONTROLS$68); 
      cTControls.set((XmlObject)paramCTControls);
    } 
  }
  
  public CTControls addNewControls() {
    synchronized (monitor()) {
      check_orphaned();
      CTControls cTControls = null;
      cTControls = (CTControls)get_store().add_element_user(CONTROLS$68);
      return cTControls;
    } 
  }
  
  public void unsetControls() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONTROLS$68, 0);
    } 
  }
  
  public CTWebPublishItems getWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishItems cTWebPublishItems = null;
      cTWebPublishItems = (CTWebPublishItems)get_store().find_element_user(WEBPUBLISHITEMS$70, 0);
      if (cTWebPublishItems == null)
        return null; 
      return cTWebPublishItems;
    } 
  }
  
  public boolean isSetWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WEBPUBLISHITEMS$70) != 0);
    } 
  }
  
  public void setWebPublishItems(CTWebPublishItems paramCTWebPublishItems) {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishItems cTWebPublishItems = null;
      cTWebPublishItems = (CTWebPublishItems)get_store().find_element_user(WEBPUBLISHITEMS$70, 0);
      if (cTWebPublishItems == null)
        cTWebPublishItems = (CTWebPublishItems)get_store().add_element_user(WEBPUBLISHITEMS$70); 
      cTWebPublishItems.set((XmlObject)paramCTWebPublishItems);
    } 
  }
  
  public CTWebPublishItems addNewWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishItems cTWebPublishItems = null;
      cTWebPublishItems = (CTWebPublishItems)get_store().add_element_user(WEBPUBLISHITEMS$70);
      return cTWebPublishItems;
    } 
  }
  
  public void unsetWebPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WEBPUBLISHITEMS$70, 0);
    } 
  }
  
  public CTTableParts getTableParts() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableParts cTTableParts = null;
      cTTableParts = (CTTableParts)get_store().find_element_user(TABLEPARTS$72, 0);
      if (cTTableParts == null)
        return null; 
      return cTTableParts;
    } 
  }
  
  public boolean isSetTableParts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABLEPARTS$72) != 0);
    } 
  }
  
  public void setTableParts(CTTableParts paramCTTableParts) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableParts cTTableParts = null;
      cTTableParts = (CTTableParts)get_store().find_element_user(TABLEPARTS$72, 0);
      if (cTTableParts == null)
        cTTableParts = (CTTableParts)get_store().add_element_user(TABLEPARTS$72); 
      cTTableParts.set((XmlObject)paramCTTableParts);
    } 
  }
  
  public CTTableParts addNewTableParts() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableParts cTTableParts = null;
      cTTableParts = (CTTableParts)get_store().add_element_user(TABLEPARTS$72);
      return cTTableParts;
    } 
  }
  
  public void unsetTableParts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLEPARTS$72, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$74, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$74) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$74, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$74); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$74);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$74, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTWorksheetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */