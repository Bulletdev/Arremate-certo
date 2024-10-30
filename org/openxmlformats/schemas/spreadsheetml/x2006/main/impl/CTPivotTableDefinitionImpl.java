package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartFormats;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColHierarchiesUsage;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormats;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFormats;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLocation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFilters;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotHierarchies;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowHierarchiesUsage;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTPivotTableDefinitionImpl extends XmlComplexContentImpl implements CTPivotTableDefinition {
  private static final b LOCATION$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "location");
  
  private static final b PIVOTFIELDS$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotFields");
  
  private static final b ROWFIELDS$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rowFields");
  
  private static final b ROWITEMS$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rowItems");
  
  private static final b COLFIELDS$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colFields");
  
  private static final b COLITEMS$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colItems");
  
  private static final b PAGEFIELDS$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageFields");
  
  private static final b DATAFIELDS$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataFields");
  
  private static final b FORMATS$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formats");
  
  private static final b CONDITIONALFORMATS$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "conditionalFormats");
  
  private static final b CHARTFORMATS$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "chartFormats");
  
  private static final b PIVOTHIERARCHIES$22 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotHierarchies");
  
  private static final b PIVOTTABLESTYLEINFO$24 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotTableStyleInfo");
  
  private static final b FILTERS$26 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "filters");
  
  private static final b ROWHIERARCHIESUSAGE$28 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rowHierarchiesUsage");
  
  private static final b COLHIERARCHIESUSAGE$30 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colHierarchiesUsage");
  
  private static final b EXTLST$32 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b NAME$34 = new b("", "name");
  
  private static final b CACHEID$36 = new b("", "cacheId");
  
  private static final b DATAONROWS$38 = new b("", "dataOnRows");
  
  private static final b DATAPOSITION$40 = new b("", "dataPosition");
  
  private static final b AUTOFORMATID$42 = new b("", "autoFormatId");
  
  private static final b APPLYNUMBERFORMATS$44 = new b("", "applyNumberFormats");
  
  private static final b APPLYBORDERFORMATS$46 = new b("", "applyBorderFormats");
  
  private static final b APPLYFONTFORMATS$48 = new b("", "applyFontFormats");
  
  private static final b APPLYPATTERNFORMATS$50 = new b("", "applyPatternFormats");
  
  private static final b APPLYALIGNMENTFORMATS$52 = new b("", "applyAlignmentFormats");
  
  private static final b APPLYWIDTHHEIGHTFORMATS$54 = new b("", "applyWidthHeightFormats");
  
  private static final b DATACAPTION$56 = new b("", "dataCaption");
  
  private static final b GRANDTOTALCAPTION$58 = new b("", "grandTotalCaption");
  
  private static final b ERRORCAPTION$60 = new b("", "errorCaption");
  
  private static final b SHOWERROR$62 = new b("", "showError");
  
  private static final b MISSINGCAPTION$64 = new b("", "missingCaption");
  
  private static final b SHOWMISSING$66 = new b("", "showMissing");
  
  private static final b PAGESTYLE$68 = new b("", "pageStyle");
  
  private static final b PIVOTTABLESTYLE$70 = new b("", "pivotTableStyle");
  
  private static final b VACATEDSTYLE$72 = new b("", "vacatedStyle");
  
  private static final b TAG$74 = new b("", "tag");
  
  private static final b UPDATEDVERSION$76 = new b("", "updatedVersion");
  
  private static final b MINREFRESHABLEVERSION$78 = new b("", "minRefreshableVersion");
  
  private static final b ASTERISKTOTALS$80 = new b("", "asteriskTotals");
  
  private static final b SHOWITEMS$82 = new b("", "showItems");
  
  private static final b EDITDATA$84 = new b("", "editData");
  
  private static final b DISABLEFIELDLIST$86 = new b("", "disableFieldList");
  
  private static final b SHOWCALCMBRS$88 = new b("", "showCalcMbrs");
  
  private static final b VISUALTOTALS$90 = new b("", "visualTotals");
  
  private static final b SHOWMULTIPLELABEL$92 = new b("", "showMultipleLabel");
  
  private static final b SHOWDATADROPDOWN$94 = new b("", "showDataDropDown");
  
  private static final b SHOWDRILL$96 = new b("", "showDrill");
  
  private static final b PRINTDRILL$98 = new b("", "printDrill");
  
  private static final b SHOWMEMBERPROPERTYTIPS$100 = new b("", "showMemberPropertyTips");
  
  private static final b SHOWDATATIPS$102 = new b("", "showDataTips");
  
  private static final b ENABLEWIZARD$104 = new b("", "enableWizard");
  
  private static final b ENABLEDRILL$106 = new b("", "enableDrill");
  
  private static final b ENABLEFIELDPROPERTIES$108 = new b("", "enableFieldProperties");
  
  private static final b PRESERVEFORMATTING$110 = new b("", "preserveFormatting");
  
  private static final b USEAUTOFORMATTING$112 = new b("", "useAutoFormatting");
  
  private static final b PAGEWRAP$114 = new b("", "pageWrap");
  
  private static final b PAGEOVERTHENDOWN$116 = new b("", "pageOverThenDown");
  
  private static final b SUBTOTALHIDDENITEMS$118 = new b("", "subtotalHiddenItems");
  
  private static final b ROWGRANDTOTALS$120 = new b("", "rowGrandTotals");
  
  private static final b COLGRANDTOTALS$122 = new b("", "colGrandTotals");
  
  private static final b FIELDPRINTTITLES$124 = new b("", "fieldPrintTitles");
  
  private static final b ITEMPRINTTITLES$126 = new b("", "itemPrintTitles");
  
  private static final b MERGEITEM$128 = new b("", "mergeItem");
  
  private static final b SHOWDROPZONES$130 = new b("", "showDropZones");
  
  private static final b CREATEDVERSION$132 = new b("", "createdVersion");
  
  private static final b INDENT$134 = new b("", "indent");
  
  private static final b SHOWEMPTYROW$136 = new b("", "showEmptyRow");
  
  private static final b SHOWEMPTYCOL$138 = new b("", "showEmptyCol");
  
  private static final b SHOWHEADERS$140 = new b("", "showHeaders");
  
  private static final b COMPACT$142 = new b("", "compact");
  
  private static final b OUTLINE$144 = new b("", "outline");
  
  private static final b OUTLINEDATA$146 = new b("", "outlineData");
  
  private static final b COMPACTDATA$148 = new b("", "compactData");
  
  private static final b PUBLISHED$150 = new b("", "published");
  
  private static final b GRIDDROPZONES$152 = new b("", "gridDropZones");
  
  private static final b IMMERSIVE$154 = new b("", "immersive");
  
  private static final b MULTIPLEFIELDFILTERS$156 = new b("", "multipleFieldFilters");
  
  private static final b CHARTFORMAT$158 = new b("", "chartFormat");
  
  private static final b ROWHEADERCAPTION$160 = new b("", "rowHeaderCaption");
  
  private static final b COLHEADERCAPTION$162 = new b("", "colHeaderCaption");
  
  private static final b FIELDLISTSORTASCENDING$164 = new b("", "fieldListSortAscending");
  
  private static final b MDXSUBQUERIES$166 = new b("", "mdxSubqueries");
  
  private static final b CUSTOMLISTSORT$168 = new b("", "customListSort");
  
  public CTPivotTableDefinitionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLocation getLocation() {
    synchronized (monitor()) {
      check_orphaned();
      CTLocation cTLocation = null;
      cTLocation = (CTLocation)get_store().find_element_user(LOCATION$0, 0);
      if (cTLocation == null)
        return null; 
      return cTLocation;
    } 
  }
  
  public void setLocation(CTLocation paramCTLocation) {
    synchronized (monitor()) {
      check_orphaned();
      CTLocation cTLocation = null;
      cTLocation = (CTLocation)get_store().find_element_user(LOCATION$0, 0);
      if (cTLocation == null)
        cTLocation = (CTLocation)get_store().add_element_user(LOCATION$0); 
      cTLocation.set((XmlObject)paramCTLocation);
    } 
  }
  
  public CTLocation addNewLocation() {
    synchronized (monitor()) {
      check_orphaned();
      CTLocation cTLocation = null;
      cTLocation = (CTLocation)get_store().add_element_user(LOCATION$0);
      return cTLocation;
    } 
  }
  
  public CTPivotFields getPivotFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFields cTPivotFields = null;
      cTPivotFields = (CTPivotFields)get_store().find_element_user(PIVOTFIELDS$2, 0);
      if (cTPivotFields == null)
        return null; 
      return cTPivotFields;
    } 
  }
  
  public boolean isSetPivotFields() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PIVOTFIELDS$2) != 0);
    } 
  }
  
  public void setPivotFields(CTPivotFields paramCTPivotFields) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFields cTPivotFields = null;
      cTPivotFields = (CTPivotFields)get_store().find_element_user(PIVOTFIELDS$2, 0);
      if (cTPivotFields == null)
        cTPivotFields = (CTPivotFields)get_store().add_element_user(PIVOTFIELDS$2); 
      cTPivotFields.set((XmlObject)paramCTPivotFields);
    } 
  }
  
  public CTPivotFields addNewPivotFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFields cTPivotFields = null;
      cTPivotFields = (CTPivotFields)get_store().add_element_user(PIVOTFIELDS$2);
      return cTPivotFields;
    } 
  }
  
  public void unsetPivotFields() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTFIELDS$2, 0);
    } 
  }
  
  public CTRowFields getRowFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTRowFields cTRowFields = null;
      cTRowFields = (CTRowFields)get_store().find_element_user(ROWFIELDS$4, 0);
      if (cTRowFields == null)
        return null; 
      return cTRowFields;
    } 
  }
  
  public boolean isSetRowFields() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ROWFIELDS$4) != 0);
    } 
  }
  
  public void setRowFields(CTRowFields paramCTRowFields) {
    synchronized (monitor()) {
      check_orphaned();
      CTRowFields cTRowFields = null;
      cTRowFields = (CTRowFields)get_store().find_element_user(ROWFIELDS$4, 0);
      if (cTRowFields == null)
        cTRowFields = (CTRowFields)get_store().add_element_user(ROWFIELDS$4); 
      cTRowFields.set((XmlObject)paramCTRowFields);
    } 
  }
  
  public CTRowFields addNewRowFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTRowFields cTRowFields = null;
      cTRowFields = (CTRowFields)get_store().add_element_user(ROWFIELDS$4);
      return cTRowFields;
    } 
  }
  
  public void unsetRowFields() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROWFIELDS$4, 0);
    } 
  }
  
  public CTRowItems getRowItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTRowItems cTRowItems = null;
      cTRowItems = (CTRowItems)get_store().find_element_user(ROWITEMS$6, 0);
      if (cTRowItems == null)
        return null; 
      return cTRowItems;
    } 
  }
  
  public boolean isSetRowItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ROWITEMS$6) != 0);
    } 
  }
  
  public void setRowItems(CTRowItems paramCTRowItems) {
    synchronized (monitor()) {
      check_orphaned();
      CTRowItems cTRowItems = null;
      cTRowItems = (CTRowItems)get_store().find_element_user(ROWITEMS$6, 0);
      if (cTRowItems == null)
        cTRowItems = (CTRowItems)get_store().add_element_user(ROWITEMS$6); 
      cTRowItems.set((XmlObject)paramCTRowItems);
    } 
  }
  
  public CTRowItems addNewRowItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTRowItems cTRowItems = null;
      cTRowItems = (CTRowItems)get_store().add_element_user(ROWITEMS$6);
      return cTRowItems;
    } 
  }
  
  public void unsetRowItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROWITEMS$6, 0);
    } 
  }
  
  public CTColFields getColFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTColFields cTColFields = null;
      cTColFields = (CTColFields)get_store().find_element_user(COLFIELDS$8, 0);
      if (cTColFields == null)
        return null; 
      return cTColFields;
    } 
  }
  
  public boolean isSetColFields() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLFIELDS$8) != 0);
    } 
  }
  
  public void setColFields(CTColFields paramCTColFields) {
    synchronized (monitor()) {
      check_orphaned();
      CTColFields cTColFields = null;
      cTColFields = (CTColFields)get_store().find_element_user(COLFIELDS$8, 0);
      if (cTColFields == null)
        cTColFields = (CTColFields)get_store().add_element_user(COLFIELDS$8); 
      cTColFields.set((XmlObject)paramCTColFields);
    } 
  }
  
  public CTColFields addNewColFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTColFields cTColFields = null;
      cTColFields = (CTColFields)get_store().add_element_user(COLFIELDS$8);
      return cTColFields;
    } 
  }
  
  public void unsetColFields() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLFIELDS$8, 0);
    } 
  }
  
  public CTColItems getColItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTColItems cTColItems = null;
      cTColItems = (CTColItems)get_store().find_element_user(COLITEMS$10, 0);
      if (cTColItems == null)
        return null; 
      return cTColItems;
    } 
  }
  
  public boolean isSetColItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLITEMS$10) != 0);
    } 
  }
  
  public void setColItems(CTColItems paramCTColItems) {
    synchronized (monitor()) {
      check_orphaned();
      CTColItems cTColItems = null;
      cTColItems = (CTColItems)get_store().find_element_user(COLITEMS$10, 0);
      if (cTColItems == null)
        cTColItems = (CTColItems)get_store().add_element_user(COLITEMS$10); 
      cTColItems.set((XmlObject)paramCTColItems);
    } 
  }
  
  public CTColItems addNewColItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTColItems cTColItems = null;
      cTColItems = (CTColItems)get_store().add_element_user(COLITEMS$10);
      return cTColItems;
    } 
  }
  
  public void unsetColItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLITEMS$10, 0);
    } 
  }
  
  public CTPageFields getPageFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageFields cTPageFields = null;
      cTPageFields = (CTPageFields)get_store().find_element_user(PAGEFIELDS$12, 0);
      if (cTPageFields == null)
        return null; 
      return cTPageFields;
    } 
  }
  
  public boolean isSetPageFields() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGEFIELDS$12) != 0);
    } 
  }
  
  public void setPageFields(CTPageFields paramCTPageFields) {
    synchronized (monitor()) {
      check_orphaned();
      CTPageFields cTPageFields = null;
      cTPageFields = (CTPageFields)get_store().find_element_user(PAGEFIELDS$12, 0);
      if (cTPageFields == null)
        cTPageFields = (CTPageFields)get_store().add_element_user(PAGEFIELDS$12); 
      cTPageFields.set((XmlObject)paramCTPageFields);
    } 
  }
  
  public CTPageFields addNewPageFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTPageFields cTPageFields = null;
      cTPageFields = (CTPageFields)get_store().add_element_user(PAGEFIELDS$12);
      return cTPageFields;
    } 
  }
  
  public void unsetPageFields() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGEFIELDS$12, 0);
    } 
  }
  
  public CTDataFields getDataFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataFields cTDataFields = null;
      cTDataFields = (CTDataFields)get_store().find_element_user(DATAFIELDS$14, 0);
      if (cTDataFields == null)
        return null; 
      return cTDataFields;
    } 
  }
  
  public boolean isSetDataFields() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATAFIELDS$14) != 0);
    } 
  }
  
  public void setDataFields(CTDataFields paramCTDataFields) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataFields cTDataFields = null;
      cTDataFields = (CTDataFields)get_store().find_element_user(DATAFIELDS$14, 0);
      if (cTDataFields == null)
        cTDataFields = (CTDataFields)get_store().add_element_user(DATAFIELDS$14); 
      cTDataFields.set((XmlObject)paramCTDataFields);
    } 
  }
  
  public CTDataFields addNewDataFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataFields cTDataFields = null;
      cTDataFields = (CTDataFields)get_store().add_element_user(DATAFIELDS$14);
      return cTDataFields;
    } 
  }
  
  public void unsetDataFields() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATAFIELDS$14, 0);
    } 
  }
  
  public CTFormats getFormats() {
    synchronized (monitor()) {
      check_orphaned();
      CTFormats cTFormats = null;
      cTFormats = (CTFormats)get_store().find_element_user(FORMATS$16, 0);
      if (cTFormats == null)
        return null; 
      return cTFormats;
    } 
  }
  
  public boolean isSetFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FORMATS$16) != 0);
    } 
  }
  
  public void setFormats(CTFormats paramCTFormats) {
    synchronized (monitor()) {
      check_orphaned();
      CTFormats cTFormats = null;
      cTFormats = (CTFormats)get_store().find_element_user(FORMATS$16, 0);
      if (cTFormats == null)
        cTFormats = (CTFormats)get_store().add_element_user(FORMATS$16); 
      cTFormats.set((XmlObject)paramCTFormats);
    } 
  }
  
  public CTFormats addNewFormats() {
    synchronized (monitor()) {
      check_orphaned();
      CTFormats cTFormats = null;
      cTFormats = (CTFormats)get_store().add_element_user(FORMATS$16);
      return cTFormats;
    } 
  }
  
  public void unsetFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMATS$16, 0);
    } 
  }
  
  public CTConditionalFormats getConditionalFormats() {
    synchronized (monitor()) {
      check_orphaned();
      CTConditionalFormats cTConditionalFormats = null;
      cTConditionalFormats = (CTConditionalFormats)get_store().find_element_user(CONDITIONALFORMATS$18, 0);
      if (cTConditionalFormats == null)
        return null; 
      return cTConditionalFormats;
    } 
  }
  
  public boolean isSetConditionalFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONDITIONALFORMATS$18) != 0);
    } 
  }
  
  public void setConditionalFormats(CTConditionalFormats paramCTConditionalFormats) {
    synchronized (monitor()) {
      check_orphaned();
      CTConditionalFormats cTConditionalFormats = null;
      cTConditionalFormats = (CTConditionalFormats)get_store().find_element_user(CONDITIONALFORMATS$18, 0);
      if (cTConditionalFormats == null)
        cTConditionalFormats = (CTConditionalFormats)get_store().add_element_user(CONDITIONALFORMATS$18); 
      cTConditionalFormats.set((XmlObject)paramCTConditionalFormats);
    } 
  }
  
  public CTConditionalFormats addNewConditionalFormats() {
    synchronized (monitor()) {
      check_orphaned();
      CTConditionalFormats cTConditionalFormats = null;
      cTConditionalFormats = (CTConditionalFormats)get_store().add_element_user(CONDITIONALFORMATS$18);
      return cTConditionalFormats;
    } 
  }
  
  public void unsetConditionalFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONDITIONALFORMATS$18, 0);
    } 
  }
  
  public CTChartFormats getChartFormats() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartFormats cTChartFormats = null;
      cTChartFormats = (CTChartFormats)get_store().find_element_user(CHARTFORMATS$20, 0);
      if (cTChartFormats == null)
        return null; 
      return cTChartFormats;
    } 
  }
  
  public boolean isSetChartFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CHARTFORMATS$20) != 0);
    } 
  }
  
  public void setChartFormats(CTChartFormats paramCTChartFormats) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartFormats cTChartFormats = null;
      cTChartFormats = (CTChartFormats)get_store().find_element_user(CHARTFORMATS$20, 0);
      if (cTChartFormats == null)
        cTChartFormats = (CTChartFormats)get_store().add_element_user(CHARTFORMATS$20); 
      cTChartFormats.set((XmlObject)paramCTChartFormats);
    } 
  }
  
  public CTChartFormats addNewChartFormats() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartFormats cTChartFormats = null;
      cTChartFormats = (CTChartFormats)get_store().add_element_user(CHARTFORMATS$20);
      return cTChartFormats;
    } 
  }
  
  public void unsetChartFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHARTFORMATS$20, 0);
    } 
  }
  
  public CTPivotHierarchies getPivotHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotHierarchies cTPivotHierarchies = null;
      cTPivotHierarchies = (CTPivotHierarchies)get_store().find_element_user(PIVOTHIERARCHIES$22, 0);
      if (cTPivotHierarchies == null)
        return null; 
      return cTPivotHierarchies;
    } 
  }
  
  public boolean isSetPivotHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PIVOTHIERARCHIES$22) != 0);
    } 
  }
  
  public void setPivotHierarchies(CTPivotHierarchies paramCTPivotHierarchies) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotHierarchies cTPivotHierarchies = null;
      cTPivotHierarchies = (CTPivotHierarchies)get_store().find_element_user(PIVOTHIERARCHIES$22, 0);
      if (cTPivotHierarchies == null)
        cTPivotHierarchies = (CTPivotHierarchies)get_store().add_element_user(PIVOTHIERARCHIES$22); 
      cTPivotHierarchies.set((XmlObject)paramCTPivotHierarchies);
    } 
  }
  
  public CTPivotHierarchies addNewPivotHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotHierarchies cTPivotHierarchies = null;
      cTPivotHierarchies = (CTPivotHierarchies)get_store().add_element_user(PIVOTHIERARCHIES$22);
      return cTPivotHierarchies;
    } 
  }
  
  public void unsetPivotHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTHIERARCHIES$22, 0);
    } 
  }
  
  public CTPivotTableStyle getPivotTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotTableStyle cTPivotTableStyle = null;
      cTPivotTableStyle = (CTPivotTableStyle)get_store().find_element_user(PIVOTTABLESTYLEINFO$24, 0);
      if (cTPivotTableStyle == null)
        return null; 
      return cTPivotTableStyle;
    } 
  }
  
  public boolean isSetPivotTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PIVOTTABLESTYLEINFO$24) != 0);
    } 
  }
  
  public void setPivotTableStyleInfo(CTPivotTableStyle paramCTPivotTableStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotTableStyle cTPivotTableStyle = null;
      cTPivotTableStyle = (CTPivotTableStyle)get_store().find_element_user(PIVOTTABLESTYLEINFO$24, 0);
      if (cTPivotTableStyle == null)
        cTPivotTableStyle = (CTPivotTableStyle)get_store().add_element_user(PIVOTTABLESTYLEINFO$24); 
      cTPivotTableStyle.set((XmlObject)paramCTPivotTableStyle);
    } 
  }
  
  public CTPivotTableStyle addNewPivotTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotTableStyle cTPivotTableStyle = null;
      cTPivotTableStyle = (CTPivotTableStyle)get_store().add_element_user(PIVOTTABLESTYLEINFO$24);
      return cTPivotTableStyle;
    } 
  }
  
  public void unsetPivotTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTTABLESTYLEINFO$24, 0);
    } 
  }
  
  public CTPivotFilters getFilters() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFilters cTPivotFilters = null;
      cTPivotFilters = (CTPivotFilters)get_store().find_element_user(FILTERS$26, 0);
      if (cTPivotFilters == null)
        return null; 
      return cTPivotFilters;
    } 
  }
  
  public boolean isSetFilters() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILTERS$26) != 0);
    } 
  }
  
  public void setFilters(CTPivotFilters paramCTPivotFilters) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFilters cTPivotFilters = null;
      cTPivotFilters = (CTPivotFilters)get_store().find_element_user(FILTERS$26, 0);
      if (cTPivotFilters == null)
        cTPivotFilters = (CTPivotFilters)get_store().add_element_user(FILTERS$26); 
      cTPivotFilters.set((XmlObject)paramCTPivotFilters);
    } 
  }
  
  public CTPivotFilters addNewFilters() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotFilters cTPivotFilters = null;
      cTPivotFilters = (CTPivotFilters)get_store().add_element_user(FILTERS$26);
      return cTPivotFilters;
    } 
  }
  
  public void unsetFilters() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILTERS$26, 0);
    } 
  }
  
  public CTRowHierarchiesUsage getRowHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      CTRowHierarchiesUsage cTRowHierarchiesUsage = null;
      cTRowHierarchiesUsage = (CTRowHierarchiesUsage)get_store().find_element_user(ROWHIERARCHIESUSAGE$28, 0);
      if (cTRowHierarchiesUsage == null)
        return null; 
      return cTRowHierarchiesUsage;
    } 
  }
  
  public boolean isSetRowHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ROWHIERARCHIESUSAGE$28) != 0);
    } 
  }
  
  public void setRowHierarchiesUsage(CTRowHierarchiesUsage paramCTRowHierarchiesUsage) {
    synchronized (monitor()) {
      check_orphaned();
      CTRowHierarchiesUsage cTRowHierarchiesUsage = null;
      cTRowHierarchiesUsage = (CTRowHierarchiesUsage)get_store().find_element_user(ROWHIERARCHIESUSAGE$28, 0);
      if (cTRowHierarchiesUsage == null)
        cTRowHierarchiesUsage = (CTRowHierarchiesUsage)get_store().add_element_user(ROWHIERARCHIESUSAGE$28); 
      cTRowHierarchiesUsage.set((XmlObject)paramCTRowHierarchiesUsage);
    } 
  }
  
  public CTRowHierarchiesUsage addNewRowHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      CTRowHierarchiesUsage cTRowHierarchiesUsage = null;
      cTRowHierarchiesUsage = (CTRowHierarchiesUsage)get_store().add_element_user(ROWHIERARCHIESUSAGE$28);
      return cTRowHierarchiesUsage;
    } 
  }
  
  public void unsetRowHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROWHIERARCHIESUSAGE$28, 0);
    } 
  }
  
  public CTColHierarchiesUsage getColHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      CTColHierarchiesUsage cTColHierarchiesUsage = null;
      cTColHierarchiesUsage = (CTColHierarchiesUsage)get_store().find_element_user(COLHIERARCHIESUSAGE$30, 0);
      if (cTColHierarchiesUsage == null)
        return null; 
      return cTColHierarchiesUsage;
    } 
  }
  
  public boolean isSetColHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLHIERARCHIESUSAGE$30) != 0);
    } 
  }
  
  public void setColHierarchiesUsage(CTColHierarchiesUsage paramCTColHierarchiesUsage) {
    synchronized (monitor()) {
      check_orphaned();
      CTColHierarchiesUsage cTColHierarchiesUsage = null;
      cTColHierarchiesUsage = (CTColHierarchiesUsage)get_store().find_element_user(COLHIERARCHIESUSAGE$30, 0);
      if (cTColHierarchiesUsage == null)
        cTColHierarchiesUsage = (CTColHierarchiesUsage)get_store().add_element_user(COLHIERARCHIESUSAGE$30); 
      cTColHierarchiesUsage.set((XmlObject)paramCTColHierarchiesUsage);
    } 
  }
  
  public CTColHierarchiesUsage addNewColHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      CTColHierarchiesUsage cTColHierarchiesUsage = null;
      cTColHierarchiesUsage = (CTColHierarchiesUsage)get_store().add_element_user(COLHIERARCHIESUSAGE$30);
      return cTColHierarchiesUsage;
    } 
  }
  
  public void unsetColHierarchiesUsage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLHIERARCHIESUSAGE$30, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$32, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$32) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$32, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$32); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$32);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$32, 0);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$34);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$34);
      return sTXstring;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$34); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$34);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$34); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public long getCacheId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CACHEID$36);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCacheId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CACHEID$36);
      return xmlUnsignedInt;
    } 
  }
  
  public void setCacheId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CACHEID$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CACHEID$36); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCacheId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CACHEID$36);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CACHEID$36); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public boolean getDataOnRows() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATAONROWS$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DATAONROWS$38); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDataOnRows() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATAONROWS$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DATAONROWS$38); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDataOnRows() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATAONROWS$38) != null);
    } 
  }
  
  public void setDataOnRows(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATAONROWS$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATAONROWS$38); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDataOnRows(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATAONROWS$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DATAONROWS$38); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDataOnRows() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATAONROWS$38);
    } 
  }
  
  public long getDataPosition() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATAPOSITION$40);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetDataPosition() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DATAPOSITION$40);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetDataPosition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATAPOSITION$40) != null);
    } 
  }
  
  public void setDataPosition(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATAPOSITION$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATAPOSITION$40); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDataPosition(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DATAPOSITION$40);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(DATAPOSITION$40); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetDataPosition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATAPOSITION$40);
    } 
  }
  
  public long getAutoFormatId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFORMATID$42);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetAutoFormatId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(AUTOFORMATID$42);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetAutoFormatId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTOFORMATID$42) != null);
    } 
  }
  
  public void setAutoFormatId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFORMATID$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOFORMATID$42); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetAutoFormatId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(AUTOFORMATID$42);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(AUTOFORMATID$42); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetAutoFormatId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTOFORMATID$42);
    } 
  }
  
  public boolean getApplyNumberFormats() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYNUMBERFORMATS$44);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyNumberFormats() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYNUMBERFORMATS$44);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyNumberFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYNUMBERFORMATS$44) != null);
    } 
  }
  
  public void setApplyNumberFormats(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYNUMBERFORMATS$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYNUMBERFORMATS$44); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyNumberFormats(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYNUMBERFORMATS$44);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYNUMBERFORMATS$44); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyNumberFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYNUMBERFORMATS$44);
    } 
  }
  
  public boolean getApplyBorderFormats() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYBORDERFORMATS$46);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyBorderFormats() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYBORDERFORMATS$46);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyBorderFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYBORDERFORMATS$46) != null);
    } 
  }
  
  public void setApplyBorderFormats(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYBORDERFORMATS$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYBORDERFORMATS$46); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyBorderFormats(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYBORDERFORMATS$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYBORDERFORMATS$46); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyBorderFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYBORDERFORMATS$46);
    } 
  }
  
  public boolean getApplyFontFormats() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYFONTFORMATS$48);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyFontFormats() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYFONTFORMATS$48);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyFontFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYFONTFORMATS$48) != null);
    } 
  }
  
  public void setApplyFontFormats(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYFONTFORMATS$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYFONTFORMATS$48); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyFontFormats(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYFONTFORMATS$48);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYFONTFORMATS$48); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyFontFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYFONTFORMATS$48);
    } 
  }
  
  public boolean getApplyPatternFormats() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYPATTERNFORMATS$50);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyPatternFormats() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYPATTERNFORMATS$50);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyPatternFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYPATTERNFORMATS$50) != null);
    } 
  }
  
  public void setApplyPatternFormats(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYPATTERNFORMATS$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYPATTERNFORMATS$50); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyPatternFormats(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYPATTERNFORMATS$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYPATTERNFORMATS$50); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyPatternFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYPATTERNFORMATS$50);
    } 
  }
  
  public boolean getApplyAlignmentFormats() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYALIGNMENTFORMATS$52);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyAlignmentFormats() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYALIGNMENTFORMATS$52);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyAlignmentFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYALIGNMENTFORMATS$52) != null);
    } 
  }
  
  public void setApplyAlignmentFormats(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYALIGNMENTFORMATS$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYALIGNMENTFORMATS$52); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyAlignmentFormats(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYALIGNMENTFORMATS$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYALIGNMENTFORMATS$52); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyAlignmentFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYALIGNMENTFORMATS$52);
    } 
  }
  
  public boolean getApplyWidthHeightFormats() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYWIDTHHEIGHTFORMATS$54);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyWidthHeightFormats() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYWIDTHHEIGHTFORMATS$54);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyWidthHeightFormats() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYWIDTHHEIGHTFORMATS$54) != null);
    } 
  }
  
  public void setApplyWidthHeightFormats(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYWIDTHHEIGHTFORMATS$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYWIDTHHEIGHTFORMATS$54); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyWidthHeightFormats(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYWIDTHHEIGHTFORMATS$54);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYWIDTHHEIGHTFORMATS$54); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyWidthHeightFormats() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYWIDTHHEIGHTFORMATS$54);
    } 
  }
  
  public String getDataCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATACAPTION$56);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetDataCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DATACAPTION$56);
      return sTXstring;
    } 
  }
  
  public void setDataCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATACAPTION$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATACAPTION$56); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDataCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DATACAPTION$56);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(DATACAPTION$56); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public String getGrandTotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRANDTOTALCAPTION$58);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetGrandTotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(GRANDTOTALCAPTION$58);
      return sTXstring;
    } 
  }
  
  public boolean isSetGrandTotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GRANDTOTALCAPTION$58) != null);
    } 
  }
  
  public void setGrandTotalCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRANDTOTALCAPTION$58);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GRANDTOTALCAPTION$58); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetGrandTotalCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(GRANDTOTALCAPTION$58);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(GRANDTOTALCAPTION$58); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetGrandTotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GRANDTOTALCAPTION$58);
    } 
  }
  
  public String getErrorCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORCAPTION$60);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetErrorCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ERRORCAPTION$60);
      return sTXstring;
    } 
  }
  
  public boolean isSetErrorCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ERRORCAPTION$60) != null);
    } 
  }
  
  public void setErrorCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ERRORCAPTION$60);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ERRORCAPTION$60); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetErrorCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ERRORCAPTION$60);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(ERRORCAPTION$60); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetErrorCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ERRORCAPTION$60);
    } 
  }
  
  public boolean getShowError() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWERROR$62);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWERROR$62); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowError() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWERROR$62);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWERROR$62); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowError() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWERROR$62) != null);
    } 
  }
  
  public void setShowError(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWERROR$62);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWERROR$62); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowError(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWERROR$62);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWERROR$62); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowError() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWERROR$62);
    } 
  }
  
  public String getMissingCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MISSINGCAPTION$64);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetMissingCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(MISSINGCAPTION$64);
      return sTXstring;
    } 
  }
  
  public boolean isSetMissingCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MISSINGCAPTION$64) != null);
    } 
  }
  
  public void setMissingCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MISSINGCAPTION$64);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MISSINGCAPTION$64); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetMissingCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(MISSINGCAPTION$64);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(MISSINGCAPTION$64); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetMissingCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MISSINGCAPTION$64);
    } 
  }
  
  public boolean getShowMissing() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMISSING$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWMISSING$66); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowMissing() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMISSING$66);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWMISSING$66); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowMissing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWMISSING$66) != null);
    } 
  }
  
  public void setShowMissing(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMISSING$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWMISSING$66); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowMissing(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMISSING$66);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWMISSING$66); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowMissing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWMISSING$66);
    } 
  }
  
  public String getPageStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGESTYLE$68);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetPageStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PAGESTYLE$68);
      return sTXstring;
    } 
  }
  
  public boolean isSetPageStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PAGESTYLE$68) != null);
    } 
  }
  
  public void setPageStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGESTYLE$68);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PAGESTYLE$68); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPageStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PAGESTYLE$68);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(PAGESTYLE$68); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetPageStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PAGESTYLE$68);
    } 
  }
  
  public String getPivotTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOTTABLESTYLE$70);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetPivotTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PIVOTTABLESTYLE$70);
      return sTXstring;
    } 
  }
  
  public boolean isSetPivotTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PIVOTTABLESTYLE$70) != null);
    } 
  }
  
  public void setPivotTableStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOTTABLESTYLE$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PIVOTTABLESTYLE$70); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPivotTableStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PIVOTTABLESTYLE$70);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(PIVOTTABLESTYLE$70); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetPivotTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PIVOTTABLESTYLE$70);
    } 
  }
  
  public String getVacatedStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VACATEDSTYLE$72);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetVacatedStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(VACATEDSTYLE$72);
      return sTXstring;
    } 
  }
  
  public boolean isSetVacatedStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VACATEDSTYLE$72) != null);
    } 
  }
  
  public void setVacatedStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VACATEDSTYLE$72);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VACATEDSTYLE$72); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetVacatedStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(VACATEDSTYLE$72);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(VACATEDSTYLE$72); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetVacatedStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VACATEDSTYLE$72);
    } 
  }
  
  public String getTag() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TAG$74);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetTag() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TAG$74);
      return sTXstring;
    } 
  }
  
  public boolean isSetTag() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TAG$74) != null);
    } 
  }
  
  public void setTag(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TAG$74);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TAG$74); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTag(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TAG$74);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(TAG$74); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetTag() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TAG$74);
    } 
  }
  
  public short getUpdatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPDATEDVERSION$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(UPDATEDVERSION$76); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetUpdatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(UPDATEDVERSION$76);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(UPDATEDVERSION$76); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetUpdatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UPDATEDVERSION$76) != null);
    } 
  }
  
  public void setUpdatedVersion(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPDATEDVERSION$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UPDATEDVERSION$76); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetUpdatedVersion(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(UPDATEDVERSION$76);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(UPDATEDVERSION$76); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetUpdatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UPDATEDVERSION$76);
    } 
  }
  
  public short getMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINREFRESHABLEVERSION$78);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MINREFRESHABLEVERSION$78); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(MINREFRESHABLEVERSION$78);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(MINREFRESHABLEVERSION$78); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MINREFRESHABLEVERSION$78) != null);
    } 
  }
  
  public void setMinRefreshableVersion(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINREFRESHABLEVERSION$78);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MINREFRESHABLEVERSION$78); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetMinRefreshableVersion(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(MINREFRESHABLEVERSION$78);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(MINREFRESHABLEVERSION$78); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MINREFRESHABLEVERSION$78);
    } 
  }
  
  public boolean getAsteriskTotals() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASTERISKTOTALS$80);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ASTERISKTOTALS$80); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAsteriskTotals() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ASTERISKTOTALS$80);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ASTERISKTOTALS$80); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAsteriskTotals() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ASTERISKTOTALS$80) != null);
    } 
  }
  
  public void setAsteriskTotals(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASTERISKTOTALS$80);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ASTERISKTOTALS$80); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAsteriskTotals(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ASTERISKTOTALS$80);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ASTERISKTOTALS$80); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAsteriskTotals() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ASTERISKTOTALS$80);
    } 
  }
  
  public boolean getShowItems() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWITEMS$82);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWITEMS$82); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowItems() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWITEMS$82);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWITEMS$82); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWITEMS$82) != null);
    } 
  }
  
  public void setShowItems(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWITEMS$82);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWITEMS$82); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowItems(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWITEMS$82);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWITEMS$82); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWITEMS$82);
    } 
  }
  
  public boolean getEditData() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EDITDATA$84);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(EDITDATA$84); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEditData() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EDITDATA$84);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(EDITDATA$84); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEditData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EDITDATA$84) != null);
    } 
  }
  
  public void setEditData(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EDITDATA$84);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EDITDATA$84); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEditData(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EDITDATA$84);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(EDITDATA$84); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEditData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EDITDATA$84);
    } 
  }
  
  public boolean getDisableFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISABLEFIELDLIST$86);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DISABLEFIELDLIST$86); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDisableFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DISABLEFIELDLIST$86);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DISABLEFIELDLIST$86); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDisableFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISABLEFIELDLIST$86) != null);
    } 
  }
  
  public void setDisableFieldList(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISABLEFIELDLIST$86);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISABLEFIELDLIST$86); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDisableFieldList(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DISABLEFIELDLIST$86);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DISABLEFIELDLIST$86); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDisableFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISABLEFIELDLIST$86);
    } 
  }
  
  public boolean getShowCalcMbrs() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCALCMBRS$88);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWCALCMBRS$88); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowCalcMbrs() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCALCMBRS$88);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWCALCMBRS$88); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowCalcMbrs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWCALCMBRS$88) != null);
    } 
  }
  
  public void setShowCalcMbrs(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWCALCMBRS$88);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWCALCMBRS$88); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowCalcMbrs(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWCALCMBRS$88);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWCALCMBRS$88); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowCalcMbrs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWCALCMBRS$88);
    } 
  }
  
  public boolean getVisualTotals() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VISUALTOTALS$90);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VISUALTOTALS$90); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetVisualTotals() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VISUALTOTALS$90);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(VISUALTOTALS$90); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetVisualTotals() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VISUALTOTALS$90) != null);
    } 
  }
  
  public void setVisualTotals(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VISUALTOTALS$90);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VISUALTOTALS$90); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetVisualTotals(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VISUALTOTALS$90);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(VISUALTOTALS$90); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetVisualTotals() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VISUALTOTALS$90);
    } 
  }
  
  public boolean getShowMultipleLabel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMULTIPLELABEL$92);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWMULTIPLELABEL$92); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowMultipleLabel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMULTIPLELABEL$92);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWMULTIPLELABEL$92); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowMultipleLabel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWMULTIPLELABEL$92) != null);
    } 
  }
  
  public void setShowMultipleLabel(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMULTIPLELABEL$92);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWMULTIPLELABEL$92); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowMultipleLabel(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMULTIPLELABEL$92);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWMULTIPLELABEL$92); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowMultipleLabel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWMULTIPLELABEL$92);
    } 
  }
  
  public boolean getShowDataDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDATADROPDOWN$94);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWDATADROPDOWN$94); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowDataDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDATADROPDOWN$94);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWDATADROPDOWN$94); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowDataDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWDATADROPDOWN$94) != null);
    } 
  }
  
  public void setShowDataDropDown(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDATADROPDOWN$94);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWDATADROPDOWN$94); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowDataDropDown(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDATADROPDOWN$94);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWDATADROPDOWN$94); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowDataDropDown() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWDATADROPDOWN$94);
    } 
  }
  
  public boolean getShowDrill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDRILL$96);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWDRILL$96); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowDrill() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDRILL$96);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWDRILL$96); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowDrill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWDRILL$96) != null);
    } 
  }
  
  public void setShowDrill(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDRILL$96);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWDRILL$96); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowDrill(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDRILL$96);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWDRILL$96); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowDrill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWDRILL$96);
    } 
  }
  
  public boolean getPrintDrill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRINTDRILL$98);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PRINTDRILL$98); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPrintDrill() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRINTDRILL$98);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PRINTDRILL$98); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPrintDrill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PRINTDRILL$98) != null);
    } 
  }
  
  public void setPrintDrill(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRINTDRILL$98);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRINTDRILL$98); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPrintDrill(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRINTDRILL$98);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PRINTDRILL$98); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPrintDrill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PRINTDRILL$98);
    } 
  }
  
  public boolean getShowMemberPropertyTips() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMEMBERPROPERTYTIPS$100);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWMEMBERPROPERTYTIPS$100); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowMemberPropertyTips() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMEMBERPROPERTYTIPS$100);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWMEMBERPROPERTYTIPS$100); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowMemberPropertyTips() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWMEMBERPROPERTYTIPS$100) != null);
    } 
  }
  
  public void setShowMemberPropertyTips(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMEMBERPROPERTYTIPS$100);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWMEMBERPROPERTYTIPS$100); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowMemberPropertyTips(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMEMBERPROPERTYTIPS$100);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWMEMBERPROPERTYTIPS$100); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowMemberPropertyTips() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWMEMBERPROPERTYTIPS$100);
    } 
  }
  
  public boolean getShowDataTips() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDATATIPS$102);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWDATATIPS$102); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowDataTips() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDATATIPS$102);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWDATATIPS$102); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowDataTips() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWDATATIPS$102) != null);
    } 
  }
  
  public void setShowDataTips(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDATATIPS$102);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWDATATIPS$102); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowDataTips(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDATATIPS$102);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWDATATIPS$102); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowDataTips() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWDATATIPS$102);
    } 
  }
  
  public boolean getEnableWizard() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEWIZARD$104);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ENABLEWIZARD$104); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEnableWizard() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEWIZARD$104);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ENABLEWIZARD$104); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEnableWizard() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENABLEWIZARD$104) != null);
    } 
  }
  
  public void setEnableWizard(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEWIZARD$104);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENABLEWIZARD$104); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEnableWizard(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEWIZARD$104);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ENABLEWIZARD$104); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEnableWizard() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENABLEWIZARD$104);
    } 
  }
  
  public boolean getEnableDrill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEDRILL$106);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ENABLEDRILL$106); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEnableDrill() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEDRILL$106);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ENABLEDRILL$106); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEnableDrill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENABLEDRILL$106) != null);
    } 
  }
  
  public void setEnableDrill(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEDRILL$106);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENABLEDRILL$106); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEnableDrill(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEDRILL$106);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ENABLEDRILL$106); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEnableDrill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENABLEDRILL$106);
    } 
  }
  
  public boolean getEnableFieldProperties() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEFIELDPROPERTIES$108);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ENABLEFIELDPROPERTIES$108); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEnableFieldProperties() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEFIELDPROPERTIES$108);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ENABLEFIELDPROPERTIES$108); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEnableFieldProperties() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENABLEFIELDPROPERTIES$108) != null);
    } 
  }
  
  public void setEnableFieldProperties(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEFIELDPROPERTIES$108);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENABLEFIELDPROPERTIES$108); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEnableFieldProperties(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEFIELDPROPERTIES$108);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ENABLEFIELDPROPERTIES$108); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEnableFieldProperties() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENABLEFIELDPROPERTIES$108);
    } 
  }
  
  public boolean getPreserveFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVEFORMATTING$110);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PRESERVEFORMATTING$110); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPreserveFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVEFORMATTING$110);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PRESERVEFORMATTING$110); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPreserveFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PRESERVEFORMATTING$110) != null);
    } 
  }
  
  public void setPreserveFormatting(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVEFORMATTING$110);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRESERVEFORMATTING$110); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPreserveFormatting(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVEFORMATTING$110);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PRESERVEFORMATTING$110); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPreserveFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PRESERVEFORMATTING$110);
    } 
  }
  
  public boolean getUseAutoFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEAUTOFORMATTING$112);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(USEAUTOFORMATTING$112); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUseAutoFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEAUTOFORMATTING$112);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(USEAUTOFORMATTING$112); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUseAutoFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USEAUTOFORMATTING$112) != null);
    } 
  }
  
  public void setUseAutoFormatting(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USEAUTOFORMATTING$112);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USEAUTOFORMATTING$112); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUseAutoFormatting(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USEAUTOFORMATTING$112);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(USEAUTOFORMATTING$112); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUseAutoFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USEAUTOFORMATTING$112);
    } 
  }
  
  public long getPageWrap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGEWRAP$114);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PAGEWRAP$114); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetPageWrap() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(PAGEWRAP$114);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(PAGEWRAP$114); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetPageWrap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PAGEWRAP$114) != null);
    } 
  }
  
  public void setPageWrap(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGEWRAP$114);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PAGEWRAP$114); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetPageWrap(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(PAGEWRAP$114);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(PAGEWRAP$114); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetPageWrap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PAGEWRAP$114);
    } 
  }
  
  public boolean getPageOverThenDown() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGEOVERTHENDOWN$116);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PAGEOVERTHENDOWN$116); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPageOverThenDown() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PAGEOVERTHENDOWN$116);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PAGEOVERTHENDOWN$116); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPageOverThenDown() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PAGEOVERTHENDOWN$116) != null);
    } 
  }
  
  public void setPageOverThenDown(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PAGEOVERTHENDOWN$116);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PAGEOVERTHENDOWN$116); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPageOverThenDown(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PAGEOVERTHENDOWN$116);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PAGEOVERTHENDOWN$116); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPageOverThenDown() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PAGEOVERTHENDOWN$116);
    } 
  }
  
  public boolean getSubtotalHiddenItems() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTALHIDDENITEMS$118);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUBTOTALHIDDENITEMS$118); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSubtotalHiddenItems() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUBTOTALHIDDENITEMS$118);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SUBTOTALHIDDENITEMS$118); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSubtotalHiddenItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUBTOTALHIDDENITEMS$118) != null);
    } 
  }
  
  public void setSubtotalHiddenItems(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTALHIDDENITEMS$118);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUBTOTALHIDDENITEMS$118); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSubtotalHiddenItems(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUBTOTALHIDDENITEMS$118);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SUBTOTALHIDDENITEMS$118); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSubtotalHiddenItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUBTOTALHIDDENITEMS$118);
    } 
  }
  
  public boolean getRowGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWGRANDTOTALS$120);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ROWGRANDTOTALS$120); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRowGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ROWGRANDTOTALS$120);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ROWGRANDTOTALS$120); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRowGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROWGRANDTOTALS$120) != null);
    } 
  }
  
  public void setRowGrandTotals(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWGRANDTOTALS$120);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROWGRANDTOTALS$120); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRowGrandTotals(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ROWGRANDTOTALS$120);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ROWGRANDTOTALS$120); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRowGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROWGRANDTOTALS$120);
    } 
  }
  
  public boolean getColGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLGRANDTOTALS$122);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COLGRANDTOTALS$122); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetColGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COLGRANDTOTALS$122);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COLGRANDTOTALS$122); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetColGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLGRANDTOTALS$122) != null);
    } 
  }
  
  public void setColGrandTotals(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLGRANDTOTALS$122);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLGRANDTOTALS$122); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetColGrandTotals(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COLGRANDTOTALS$122);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COLGRANDTOTALS$122); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetColGrandTotals() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLGRANDTOTALS$122);
    } 
  }
  
  public boolean getFieldPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIELDPRINTTITLES$124);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIELDPRINTTITLES$124); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFieldPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIELDPRINTTITLES$124);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FIELDPRINTTITLES$124); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFieldPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIELDPRINTTITLES$124) != null);
    } 
  }
  
  public void setFieldPrintTitles(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIELDPRINTTITLES$124);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIELDPRINTTITLES$124); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFieldPrintTitles(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIELDPRINTTITLES$124);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FIELDPRINTTITLES$124); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFieldPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIELDPRINTTITLES$124);
    } 
  }
  
  public boolean getItemPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITEMPRINTTITLES$126);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ITEMPRINTTITLES$126); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetItemPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ITEMPRINTTITLES$126);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ITEMPRINTTITLES$126); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetItemPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ITEMPRINTTITLES$126) != null);
    } 
  }
  
  public void setItemPrintTitles(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITEMPRINTTITLES$126);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ITEMPRINTTITLES$126); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetItemPrintTitles(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ITEMPRINTTITLES$126);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ITEMPRINTTITLES$126); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetItemPrintTitles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ITEMPRINTTITLES$126);
    } 
  }
  
  public boolean getMergeItem() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MERGEITEM$128);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MERGEITEM$128); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMergeItem() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MERGEITEM$128);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MERGEITEM$128); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMergeItem() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MERGEITEM$128) != null);
    } 
  }
  
  public void setMergeItem(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MERGEITEM$128);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MERGEITEM$128); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMergeItem(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MERGEITEM$128);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MERGEITEM$128); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMergeItem() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MERGEITEM$128);
    } 
  }
  
  public boolean getShowDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDROPZONES$130);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWDROPZONES$130); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDROPZONES$130);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWDROPZONES$130); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWDROPZONES$130) != null);
    } 
  }
  
  public void setShowDropZones(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDROPZONES$130);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWDROPZONES$130); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowDropZones(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDROPZONES$130);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWDROPZONES$130); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWDROPZONES$130);
    } 
  }
  
  public short getCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CREATEDVERSION$132);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CREATEDVERSION$132); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(CREATEDVERSION$132);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(CREATEDVERSION$132); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CREATEDVERSION$132) != null);
    } 
  }
  
  public void setCreatedVersion(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CREATEDVERSION$132);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CREATEDVERSION$132); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetCreatedVersion(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(CREATEDVERSION$132);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(CREATEDVERSION$132); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CREATEDVERSION$132);
    } 
  }
  
  public long getIndent() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDENT$134);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INDENT$134); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(INDENT$134);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(INDENT$134); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INDENT$134) != null);
    } 
  }
  
  public void setIndent(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDENT$134);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INDENT$134); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIndent(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(INDENT$134);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(INDENT$134); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INDENT$134);
    } 
  }
  
  public boolean getShowEmptyRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWEMPTYROW$136);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWEMPTYROW$136); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowEmptyRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWEMPTYROW$136);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWEMPTYROW$136); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowEmptyRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWEMPTYROW$136) != null);
    } 
  }
  
  public void setShowEmptyRow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWEMPTYROW$136);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWEMPTYROW$136); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowEmptyRow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWEMPTYROW$136);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWEMPTYROW$136); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowEmptyRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWEMPTYROW$136);
    } 
  }
  
  public boolean getShowEmptyCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWEMPTYCOL$138);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWEMPTYCOL$138); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowEmptyCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWEMPTYCOL$138);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWEMPTYCOL$138); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowEmptyCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWEMPTYCOL$138) != null);
    } 
  }
  
  public void setShowEmptyCol(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWEMPTYCOL$138);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWEMPTYCOL$138); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowEmptyCol(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWEMPTYCOL$138);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWEMPTYCOL$138); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowEmptyCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWEMPTYCOL$138);
    } 
  }
  
  public boolean getShowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWHEADERS$140);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWHEADERS$140); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWHEADERS$140);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWHEADERS$140); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWHEADERS$140) != null);
    } 
  }
  
  public void setShowHeaders(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWHEADERS$140);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWHEADERS$140); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowHeaders(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWHEADERS$140);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWHEADERS$140); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowHeaders() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWHEADERS$140);
    } 
  }
  
  public boolean getCompact() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPACT$142);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COMPACT$142); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCompact() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPACT$142);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COMPACT$142); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCompact() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COMPACT$142) != null);
    } 
  }
  
  public void setCompact(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPACT$142);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COMPACT$142); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCompact(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPACT$142);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COMPACT$142); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCompact() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COMPACT$142);
    } 
  }
  
  public boolean getOutline() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINE$144);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINE$144); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINE$144);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(OUTLINE$144); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINE$144) != null);
    } 
  }
  
  public void setOutline(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINE$144);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINE$144); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetOutline(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINE$144);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(OUTLINE$144); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINE$144);
    } 
  }
  
  public boolean getOutlineData() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINEDATA$146);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINEDATA$146); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetOutlineData() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINEDATA$146);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(OUTLINEDATA$146); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetOutlineData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINEDATA$146) != null);
    } 
  }
  
  public void setOutlineData(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINEDATA$146);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINEDATA$146); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetOutlineData(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINEDATA$146);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(OUTLINEDATA$146); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetOutlineData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINEDATA$146);
    } 
  }
  
  public boolean getCompactData() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPACTDATA$148);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COMPACTDATA$148); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCompactData() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPACTDATA$148);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COMPACTDATA$148); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCompactData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COMPACTDATA$148) != null);
    } 
  }
  
  public void setCompactData(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPACTDATA$148);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COMPACTDATA$148); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCompactData(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPACTDATA$148);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COMPACTDATA$148); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCompactData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COMPACTDATA$148);
    } 
  }
  
  public boolean getPublished() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHED$150);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PUBLISHED$150); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHED$150);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PUBLISHED$150); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PUBLISHED$150) != null);
    } 
  }
  
  public void setPublished(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHED$150);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PUBLISHED$150); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPublished(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHED$150);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PUBLISHED$150); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PUBLISHED$150);
    } 
  }
  
  public boolean getGridDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDDROPZONES$152);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(GRIDDROPZONES$152); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetGridDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(GRIDDROPZONES$152);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(GRIDDROPZONES$152); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetGridDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GRIDDROPZONES$152) != null);
    } 
  }
  
  public void setGridDropZones(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDDROPZONES$152);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GRIDDROPZONES$152); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetGridDropZones(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(GRIDDROPZONES$152);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(GRIDDROPZONES$152); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetGridDropZones() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GRIDDROPZONES$152);
    } 
  }
  
  public boolean getImmersive() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMMERSIVE$154);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(IMMERSIVE$154); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetImmersive() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(IMMERSIVE$154);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(IMMERSIVE$154); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetImmersive() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(IMMERSIVE$154) != null);
    } 
  }
  
  public void setImmersive(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IMMERSIVE$154);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IMMERSIVE$154); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetImmersive(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(IMMERSIVE$154);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(IMMERSIVE$154); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetImmersive() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(IMMERSIVE$154);
    } 
  }
  
  public boolean getMultipleFieldFilters() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MULTIPLEFIELDFILTERS$156);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MULTIPLEFIELDFILTERS$156); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMultipleFieldFilters() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MULTIPLEFIELDFILTERS$156);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MULTIPLEFIELDFILTERS$156); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMultipleFieldFilters() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MULTIPLEFIELDFILTERS$156) != null);
    } 
  }
  
  public void setMultipleFieldFilters(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MULTIPLEFIELDFILTERS$156);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MULTIPLEFIELDFILTERS$156); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMultipleFieldFilters(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MULTIPLEFIELDFILTERS$156);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MULTIPLEFIELDFILTERS$156); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMultipleFieldFilters() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MULTIPLEFIELDFILTERS$156);
    } 
  }
  
  public long getChartFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHARTFORMAT$158);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CHARTFORMAT$158); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetChartFormat() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CHARTFORMAT$158);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(CHARTFORMAT$158); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetChartFormat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CHARTFORMAT$158) != null);
    } 
  }
  
  public void setChartFormat(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHARTFORMAT$158);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CHARTFORMAT$158); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetChartFormat(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CHARTFORMAT$158);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CHARTFORMAT$158); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetChartFormat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CHARTFORMAT$158);
    } 
  }
  
  public String getRowHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWHEADERCAPTION$160);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetRowHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ROWHEADERCAPTION$160);
      return sTXstring;
    } 
  }
  
  public boolean isSetRowHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROWHEADERCAPTION$160) != null);
    } 
  }
  
  public void setRowHeaderCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWHEADERCAPTION$160);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROWHEADERCAPTION$160); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRowHeaderCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(ROWHEADERCAPTION$160);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(ROWHEADERCAPTION$160); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetRowHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROWHEADERCAPTION$160);
    } 
  }
  
  public String getColHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLHEADERCAPTION$162);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetColHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(COLHEADERCAPTION$162);
      return sTXstring;
    } 
  }
  
  public boolean isSetColHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLHEADERCAPTION$162) != null);
    } 
  }
  
  public void setColHeaderCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLHEADERCAPTION$162);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLHEADERCAPTION$162); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetColHeaderCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(COLHEADERCAPTION$162);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(COLHEADERCAPTION$162); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetColHeaderCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLHEADERCAPTION$162);
    } 
  }
  
  public boolean getFieldListSortAscending() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIELDLISTSORTASCENDING$164);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIELDLISTSORTASCENDING$164); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFieldListSortAscending() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIELDLISTSORTASCENDING$164);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FIELDLISTSORTASCENDING$164); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFieldListSortAscending() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIELDLISTSORTASCENDING$164) != null);
    } 
  }
  
  public void setFieldListSortAscending(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIELDLISTSORTASCENDING$164);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIELDLISTSORTASCENDING$164); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFieldListSortAscending(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIELDLISTSORTASCENDING$164);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FIELDLISTSORTASCENDING$164); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFieldListSortAscending() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIELDLISTSORTASCENDING$164);
    } 
  }
  
  public boolean getMdxSubqueries() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MDXSUBQUERIES$166);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MDXSUBQUERIES$166); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMdxSubqueries() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MDXSUBQUERIES$166);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MDXSUBQUERIES$166); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMdxSubqueries() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MDXSUBQUERIES$166) != null);
    } 
  }
  
  public void setMdxSubqueries(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MDXSUBQUERIES$166);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MDXSUBQUERIES$166); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMdxSubqueries(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MDXSUBQUERIES$166);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MDXSUBQUERIES$166); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMdxSubqueries() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MDXSUBQUERIES$166);
    } 
  }
  
  public boolean getCustomListSort() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMLISTSORT$168);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CUSTOMLISTSORT$168); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCustomListSort() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMLISTSORT$168);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CUSTOMLISTSORT$168); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCustomListSort() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMLISTSORT$168) != null);
    } 
  }
  
  public void setCustomListSort(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMLISTSORT$168);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMLISTSORT$168); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCustomListSort(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMLISTSORT$168);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CUSTOMLISTSORT$168); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCustomListSort() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMLISTSORT$168);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPivotTableDefinitionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */