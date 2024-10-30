package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPivotTableDefinition extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPivotTableDefinition.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivottabledefinitionb188type");
  
  CTLocation getLocation();
  
  void setLocation(CTLocation paramCTLocation);
  
  CTLocation addNewLocation();
  
  CTPivotFields getPivotFields();
  
  boolean isSetPivotFields();
  
  void setPivotFields(CTPivotFields paramCTPivotFields);
  
  CTPivotFields addNewPivotFields();
  
  void unsetPivotFields();
  
  CTRowFields getRowFields();
  
  boolean isSetRowFields();
  
  void setRowFields(CTRowFields paramCTRowFields);
  
  CTRowFields addNewRowFields();
  
  void unsetRowFields();
  
  CTRowItems getRowItems();
  
  boolean isSetRowItems();
  
  void setRowItems(CTRowItems paramCTRowItems);
  
  CTRowItems addNewRowItems();
  
  void unsetRowItems();
  
  CTColFields getColFields();
  
  boolean isSetColFields();
  
  void setColFields(CTColFields paramCTColFields);
  
  CTColFields addNewColFields();
  
  void unsetColFields();
  
  CTColItems getColItems();
  
  boolean isSetColItems();
  
  void setColItems(CTColItems paramCTColItems);
  
  CTColItems addNewColItems();
  
  void unsetColItems();
  
  CTPageFields getPageFields();
  
  boolean isSetPageFields();
  
  void setPageFields(CTPageFields paramCTPageFields);
  
  CTPageFields addNewPageFields();
  
  void unsetPageFields();
  
  CTDataFields getDataFields();
  
  boolean isSetDataFields();
  
  void setDataFields(CTDataFields paramCTDataFields);
  
  CTDataFields addNewDataFields();
  
  void unsetDataFields();
  
  CTFormats getFormats();
  
  boolean isSetFormats();
  
  void setFormats(CTFormats paramCTFormats);
  
  CTFormats addNewFormats();
  
  void unsetFormats();
  
  CTConditionalFormats getConditionalFormats();
  
  boolean isSetConditionalFormats();
  
  void setConditionalFormats(CTConditionalFormats paramCTConditionalFormats);
  
  CTConditionalFormats addNewConditionalFormats();
  
  void unsetConditionalFormats();
  
  CTChartFormats getChartFormats();
  
  boolean isSetChartFormats();
  
  void setChartFormats(CTChartFormats paramCTChartFormats);
  
  CTChartFormats addNewChartFormats();
  
  void unsetChartFormats();
  
  CTPivotHierarchies getPivotHierarchies();
  
  boolean isSetPivotHierarchies();
  
  void setPivotHierarchies(CTPivotHierarchies paramCTPivotHierarchies);
  
  CTPivotHierarchies addNewPivotHierarchies();
  
  void unsetPivotHierarchies();
  
  CTPivotTableStyle getPivotTableStyleInfo();
  
  boolean isSetPivotTableStyleInfo();
  
  void setPivotTableStyleInfo(CTPivotTableStyle paramCTPivotTableStyle);
  
  CTPivotTableStyle addNewPivotTableStyleInfo();
  
  void unsetPivotTableStyleInfo();
  
  CTPivotFilters getFilters();
  
  boolean isSetFilters();
  
  void setFilters(CTPivotFilters paramCTPivotFilters);
  
  CTPivotFilters addNewFilters();
  
  void unsetFilters();
  
  CTRowHierarchiesUsage getRowHierarchiesUsage();
  
  boolean isSetRowHierarchiesUsage();
  
  void setRowHierarchiesUsage(CTRowHierarchiesUsage paramCTRowHierarchiesUsage);
  
  CTRowHierarchiesUsage addNewRowHierarchiesUsage();
  
  void unsetRowHierarchiesUsage();
  
  CTColHierarchiesUsage getColHierarchiesUsage();
  
  boolean isSetColHierarchiesUsage();
  
  void setColHierarchiesUsage(CTColHierarchiesUsage paramCTColHierarchiesUsage);
  
  CTColHierarchiesUsage addNewColHierarchiesUsage();
  
  void unsetColHierarchiesUsage();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getName();
  
  STXstring xgetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  long getCacheId();
  
  XmlUnsignedInt xgetCacheId();
  
  void setCacheId(long paramLong);
  
  void xsetCacheId(XmlUnsignedInt paramXmlUnsignedInt);
  
  boolean getDataOnRows();
  
  XmlBoolean xgetDataOnRows();
  
  boolean isSetDataOnRows();
  
  void setDataOnRows(boolean paramBoolean);
  
  void xsetDataOnRows(XmlBoolean paramXmlBoolean);
  
  void unsetDataOnRows();
  
  long getDataPosition();
  
  XmlUnsignedInt xgetDataPosition();
  
  boolean isSetDataPosition();
  
  void setDataPosition(long paramLong);
  
  void xsetDataPosition(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetDataPosition();
  
  long getAutoFormatId();
  
  XmlUnsignedInt xgetAutoFormatId();
  
  boolean isSetAutoFormatId();
  
  void setAutoFormatId(long paramLong);
  
  void xsetAutoFormatId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetAutoFormatId();
  
  boolean getApplyNumberFormats();
  
  XmlBoolean xgetApplyNumberFormats();
  
  boolean isSetApplyNumberFormats();
  
  void setApplyNumberFormats(boolean paramBoolean);
  
  void xsetApplyNumberFormats(XmlBoolean paramXmlBoolean);
  
  void unsetApplyNumberFormats();
  
  boolean getApplyBorderFormats();
  
  XmlBoolean xgetApplyBorderFormats();
  
  boolean isSetApplyBorderFormats();
  
  void setApplyBorderFormats(boolean paramBoolean);
  
  void xsetApplyBorderFormats(XmlBoolean paramXmlBoolean);
  
  void unsetApplyBorderFormats();
  
  boolean getApplyFontFormats();
  
  XmlBoolean xgetApplyFontFormats();
  
  boolean isSetApplyFontFormats();
  
  void setApplyFontFormats(boolean paramBoolean);
  
  void xsetApplyFontFormats(XmlBoolean paramXmlBoolean);
  
  void unsetApplyFontFormats();
  
  boolean getApplyPatternFormats();
  
  XmlBoolean xgetApplyPatternFormats();
  
  boolean isSetApplyPatternFormats();
  
  void setApplyPatternFormats(boolean paramBoolean);
  
  void xsetApplyPatternFormats(XmlBoolean paramXmlBoolean);
  
  void unsetApplyPatternFormats();
  
  boolean getApplyAlignmentFormats();
  
  XmlBoolean xgetApplyAlignmentFormats();
  
  boolean isSetApplyAlignmentFormats();
  
  void setApplyAlignmentFormats(boolean paramBoolean);
  
  void xsetApplyAlignmentFormats(XmlBoolean paramXmlBoolean);
  
  void unsetApplyAlignmentFormats();
  
  boolean getApplyWidthHeightFormats();
  
  XmlBoolean xgetApplyWidthHeightFormats();
  
  boolean isSetApplyWidthHeightFormats();
  
  void setApplyWidthHeightFormats(boolean paramBoolean);
  
  void xsetApplyWidthHeightFormats(XmlBoolean paramXmlBoolean);
  
  void unsetApplyWidthHeightFormats();
  
  String getDataCaption();
  
  STXstring xgetDataCaption();
  
  void setDataCaption(String paramString);
  
  void xsetDataCaption(STXstring paramSTXstring);
  
  String getGrandTotalCaption();
  
  STXstring xgetGrandTotalCaption();
  
  boolean isSetGrandTotalCaption();
  
  void setGrandTotalCaption(String paramString);
  
  void xsetGrandTotalCaption(STXstring paramSTXstring);
  
  void unsetGrandTotalCaption();
  
  String getErrorCaption();
  
  STXstring xgetErrorCaption();
  
  boolean isSetErrorCaption();
  
  void setErrorCaption(String paramString);
  
  void xsetErrorCaption(STXstring paramSTXstring);
  
  void unsetErrorCaption();
  
  boolean getShowError();
  
  XmlBoolean xgetShowError();
  
  boolean isSetShowError();
  
  void setShowError(boolean paramBoolean);
  
  void xsetShowError(XmlBoolean paramXmlBoolean);
  
  void unsetShowError();
  
  String getMissingCaption();
  
  STXstring xgetMissingCaption();
  
  boolean isSetMissingCaption();
  
  void setMissingCaption(String paramString);
  
  void xsetMissingCaption(STXstring paramSTXstring);
  
  void unsetMissingCaption();
  
  boolean getShowMissing();
  
  XmlBoolean xgetShowMissing();
  
  boolean isSetShowMissing();
  
  void setShowMissing(boolean paramBoolean);
  
  void xsetShowMissing(XmlBoolean paramXmlBoolean);
  
  void unsetShowMissing();
  
  String getPageStyle();
  
  STXstring xgetPageStyle();
  
  boolean isSetPageStyle();
  
  void setPageStyle(String paramString);
  
  void xsetPageStyle(STXstring paramSTXstring);
  
  void unsetPageStyle();
  
  String getPivotTableStyle();
  
  STXstring xgetPivotTableStyle();
  
  boolean isSetPivotTableStyle();
  
  void setPivotTableStyle(String paramString);
  
  void xsetPivotTableStyle(STXstring paramSTXstring);
  
  void unsetPivotTableStyle();
  
  String getVacatedStyle();
  
  STXstring xgetVacatedStyle();
  
  boolean isSetVacatedStyle();
  
  void setVacatedStyle(String paramString);
  
  void xsetVacatedStyle(STXstring paramSTXstring);
  
  void unsetVacatedStyle();
  
  String getTag();
  
  STXstring xgetTag();
  
  boolean isSetTag();
  
  void setTag(String paramString);
  
  void xsetTag(STXstring paramSTXstring);
  
  void unsetTag();
  
  short getUpdatedVersion();
  
  XmlUnsignedByte xgetUpdatedVersion();
  
  boolean isSetUpdatedVersion();
  
  void setUpdatedVersion(short paramShort);
  
  void xsetUpdatedVersion(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetUpdatedVersion();
  
  short getMinRefreshableVersion();
  
  XmlUnsignedByte xgetMinRefreshableVersion();
  
  boolean isSetMinRefreshableVersion();
  
  void setMinRefreshableVersion(short paramShort);
  
  void xsetMinRefreshableVersion(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetMinRefreshableVersion();
  
  boolean getAsteriskTotals();
  
  XmlBoolean xgetAsteriskTotals();
  
  boolean isSetAsteriskTotals();
  
  void setAsteriskTotals(boolean paramBoolean);
  
  void xsetAsteriskTotals(XmlBoolean paramXmlBoolean);
  
  void unsetAsteriskTotals();
  
  boolean getShowItems();
  
  XmlBoolean xgetShowItems();
  
  boolean isSetShowItems();
  
  void setShowItems(boolean paramBoolean);
  
  void xsetShowItems(XmlBoolean paramXmlBoolean);
  
  void unsetShowItems();
  
  boolean getEditData();
  
  XmlBoolean xgetEditData();
  
  boolean isSetEditData();
  
  void setEditData(boolean paramBoolean);
  
  void xsetEditData(XmlBoolean paramXmlBoolean);
  
  void unsetEditData();
  
  boolean getDisableFieldList();
  
  XmlBoolean xgetDisableFieldList();
  
  boolean isSetDisableFieldList();
  
  void setDisableFieldList(boolean paramBoolean);
  
  void xsetDisableFieldList(XmlBoolean paramXmlBoolean);
  
  void unsetDisableFieldList();
  
  boolean getShowCalcMbrs();
  
  XmlBoolean xgetShowCalcMbrs();
  
  boolean isSetShowCalcMbrs();
  
  void setShowCalcMbrs(boolean paramBoolean);
  
  void xsetShowCalcMbrs(XmlBoolean paramXmlBoolean);
  
  void unsetShowCalcMbrs();
  
  boolean getVisualTotals();
  
  XmlBoolean xgetVisualTotals();
  
  boolean isSetVisualTotals();
  
  void setVisualTotals(boolean paramBoolean);
  
  void xsetVisualTotals(XmlBoolean paramXmlBoolean);
  
  void unsetVisualTotals();
  
  boolean getShowMultipleLabel();
  
  XmlBoolean xgetShowMultipleLabel();
  
  boolean isSetShowMultipleLabel();
  
  void setShowMultipleLabel(boolean paramBoolean);
  
  void xsetShowMultipleLabel(XmlBoolean paramXmlBoolean);
  
  void unsetShowMultipleLabel();
  
  boolean getShowDataDropDown();
  
  XmlBoolean xgetShowDataDropDown();
  
  boolean isSetShowDataDropDown();
  
  void setShowDataDropDown(boolean paramBoolean);
  
  void xsetShowDataDropDown(XmlBoolean paramXmlBoolean);
  
  void unsetShowDataDropDown();
  
  boolean getShowDrill();
  
  XmlBoolean xgetShowDrill();
  
  boolean isSetShowDrill();
  
  void setShowDrill(boolean paramBoolean);
  
  void xsetShowDrill(XmlBoolean paramXmlBoolean);
  
  void unsetShowDrill();
  
  boolean getPrintDrill();
  
  XmlBoolean xgetPrintDrill();
  
  boolean isSetPrintDrill();
  
  void setPrintDrill(boolean paramBoolean);
  
  void xsetPrintDrill(XmlBoolean paramXmlBoolean);
  
  void unsetPrintDrill();
  
  boolean getShowMemberPropertyTips();
  
  XmlBoolean xgetShowMemberPropertyTips();
  
  boolean isSetShowMemberPropertyTips();
  
  void setShowMemberPropertyTips(boolean paramBoolean);
  
  void xsetShowMemberPropertyTips(XmlBoolean paramXmlBoolean);
  
  void unsetShowMemberPropertyTips();
  
  boolean getShowDataTips();
  
  XmlBoolean xgetShowDataTips();
  
  boolean isSetShowDataTips();
  
  void setShowDataTips(boolean paramBoolean);
  
  void xsetShowDataTips(XmlBoolean paramXmlBoolean);
  
  void unsetShowDataTips();
  
  boolean getEnableWizard();
  
  XmlBoolean xgetEnableWizard();
  
  boolean isSetEnableWizard();
  
  void setEnableWizard(boolean paramBoolean);
  
  void xsetEnableWizard(XmlBoolean paramXmlBoolean);
  
  void unsetEnableWizard();
  
  boolean getEnableDrill();
  
  XmlBoolean xgetEnableDrill();
  
  boolean isSetEnableDrill();
  
  void setEnableDrill(boolean paramBoolean);
  
  void xsetEnableDrill(XmlBoolean paramXmlBoolean);
  
  void unsetEnableDrill();
  
  boolean getEnableFieldProperties();
  
  XmlBoolean xgetEnableFieldProperties();
  
  boolean isSetEnableFieldProperties();
  
  void setEnableFieldProperties(boolean paramBoolean);
  
  void xsetEnableFieldProperties(XmlBoolean paramXmlBoolean);
  
  void unsetEnableFieldProperties();
  
  boolean getPreserveFormatting();
  
  XmlBoolean xgetPreserveFormatting();
  
  boolean isSetPreserveFormatting();
  
  void setPreserveFormatting(boolean paramBoolean);
  
  void xsetPreserveFormatting(XmlBoolean paramXmlBoolean);
  
  void unsetPreserveFormatting();
  
  boolean getUseAutoFormatting();
  
  XmlBoolean xgetUseAutoFormatting();
  
  boolean isSetUseAutoFormatting();
  
  void setUseAutoFormatting(boolean paramBoolean);
  
  void xsetUseAutoFormatting(XmlBoolean paramXmlBoolean);
  
  void unsetUseAutoFormatting();
  
  long getPageWrap();
  
  XmlUnsignedInt xgetPageWrap();
  
  boolean isSetPageWrap();
  
  void setPageWrap(long paramLong);
  
  void xsetPageWrap(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetPageWrap();
  
  boolean getPageOverThenDown();
  
  XmlBoolean xgetPageOverThenDown();
  
  boolean isSetPageOverThenDown();
  
  void setPageOverThenDown(boolean paramBoolean);
  
  void xsetPageOverThenDown(XmlBoolean paramXmlBoolean);
  
  void unsetPageOverThenDown();
  
  boolean getSubtotalHiddenItems();
  
  XmlBoolean xgetSubtotalHiddenItems();
  
  boolean isSetSubtotalHiddenItems();
  
  void setSubtotalHiddenItems(boolean paramBoolean);
  
  void xsetSubtotalHiddenItems(XmlBoolean paramXmlBoolean);
  
  void unsetSubtotalHiddenItems();
  
  boolean getRowGrandTotals();
  
  XmlBoolean xgetRowGrandTotals();
  
  boolean isSetRowGrandTotals();
  
  void setRowGrandTotals(boolean paramBoolean);
  
  void xsetRowGrandTotals(XmlBoolean paramXmlBoolean);
  
  void unsetRowGrandTotals();
  
  boolean getColGrandTotals();
  
  XmlBoolean xgetColGrandTotals();
  
  boolean isSetColGrandTotals();
  
  void setColGrandTotals(boolean paramBoolean);
  
  void xsetColGrandTotals(XmlBoolean paramXmlBoolean);
  
  void unsetColGrandTotals();
  
  boolean getFieldPrintTitles();
  
  XmlBoolean xgetFieldPrintTitles();
  
  boolean isSetFieldPrintTitles();
  
  void setFieldPrintTitles(boolean paramBoolean);
  
  void xsetFieldPrintTitles(XmlBoolean paramXmlBoolean);
  
  void unsetFieldPrintTitles();
  
  boolean getItemPrintTitles();
  
  XmlBoolean xgetItemPrintTitles();
  
  boolean isSetItemPrintTitles();
  
  void setItemPrintTitles(boolean paramBoolean);
  
  void xsetItemPrintTitles(XmlBoolean paramXmlBoolean);
  
  void unsetItemPrintTitles();
  
  boolean getMergeItem();
  
  XmlBoolean xgetMergeItem();
  
  boolean isSetMergeItem();
  
  void setMergeItem(boolean paramBoolean);
  
  void xsetMergeItem(XmlBoolean paramXmlBoolean);
  
  void unsetMergeItem();
  
  boolean getShowDropZones();
  
  XmlBoolean xgetShowDropZones();
  
  boolean isSetShowDropZones();
  
  void setShowDropZones(boolean paramBoolean);
  
  void xsetShowDropZones(XmlBoolean paramXmlBoolean);
  
  void unsetShowDropZones();
  
  short getCreatedVersion();
  
  XmlUnsignedByte xgetCreatedVersion();
  
  boolean isSetCreatedVersion();
  
  void setCreatedVersion(short paramShort);
  
  void xsetCreatedVersion(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetCreatedVersion();
  
  long getIndent();
  
  XmlUnsignedInt xgetIndent();
  
  boolean isSetIndent();
  
  void setIndent(long paramLong);
  
  void xsetIndent(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetIndent();
  
  boolean getShowEmptyRow();
  
  XmlBoolean xgetShowEmptyRow();
  
  boolean isSetShowEmptyRow();
  
  void setShowEmptyRow(boolean paramBoolean);
  
  void xsetShowEmptyRow(XmlBoolean paramXmlBoolean);
  
  void unsetShowEmptyRow();
  
  boolean getShowEmptyCol();
  
  XmlBoolean xgetShowEmptyCol();
  
  boolean isSetShowEmptyCol();
  
  void setShowEmptyCol(boolean paramBoolean);
  
  void xsetShowEmptyCol(XmlBoolean paramXmlBoolean);
  
  void unsetShowEmptyCol();
  
  boolean getShowHeaders();
  
  XmlBoolean xgetShowHeaders();
  
  boolean isSetShowHeaders();
  
  void setShowHeaders(boolean paramBoolean);
  
  void xsetShowHeaders(XmlBoolean paramXmlBoolean);
  
  void unsetShowHeaders();
  
  boolean getCompact();
  
  XmlBoolean xgetCompact();
  
  boolean isSetCompact();
  
  void setCompact(boolean paramBoolean);
  
  void xsetCompact(XmlBoolean paramXmlBoolean);
  
  void unsetCompact();
  
  boolean getOutline();
  
  XmlBoolean xgetOutline();
  
  boolean isSetOutline();
  
  void setOutline(boolean paramBoolean);
  
  void xsetOutline(XmlBoolean paramXmlBoolean);
  
  void unsetOutline();
  
  boolean getOutlineData();
  
  XmlBoolean xgetOutlineData();
  
  boolean isSetOutlineData();
  
  void setOutlineData(boolean paramBoolean);
  
  void xsetOutlineData(XmlBoolean paramXmlBoolean);
  
  void unsetOutlineData();
  
  boolean getCompactData();
  
  XmlBoolean xgetCompactData();
  
  boolean isSetCompactData();
  
  void setCompactData(boolean paramBoolean);
  
  void xsetCompactData(XmlBoolean paramXmlBoolean);
  
  void unsetCompactData();
  
  boolean getPublished();
  
  XmlBoolean xgetPublished();
  
  boolean isSetPublished();
  
  void setPublished(boolean paramBoolean);
  
  void xsetPublished(XmlBoolean paramXmlBoolean);
  
  void unsetPublished();
  
  boolean getGridDropZones();
  
  XmlBoolean xgetGridDropZones();
  
  boolean isSetGridDropZones();
  
  void setGridDropZones(boolean paramBoolean);
  
  void xsetGridDropZones(XmlBoolean paramXmlBoolean);
  
  void unsetGridDropZones();
  
  boolean getImmersive();
  
  XmlBoolean xgetImmersive();
  
  boolean isSetImmersive();
  
  void setImmersive(boolean paramBoolean);
  
  void xsetImmersive(XmlBoolean paramXmlBoolean);
  
  void unsetImmersive();
  
  boolean getMultipleFieldFilters();
  
  XmlBoolean xgetMultipleFieldFilters();
  
  boolean isSetMultipleFieldFilters();
  
  void setMultipleFieldFilters(boolean paramBoolean);
  
  void xsetMultipleFieldFilters(XmlBoolean paramXmlBoolean);
  
  void unsetMultipleFieldFilters();
  
  long getChartFormat();
  
  XmlUnsignedInt xgetChartFormat();
  
  boolean isSetChartFormat();
  
  void setChartFormat(long paramLong);
  
  void xsetChartFormat(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetChartFormat();
  
  String getRowHeaderCaption();
  
  STXstring xgetRowHeaderCaption();
  
  boolean isSetRowHeaderCaption();
  
  void setRowHeaderCaption(String paramString);
  
  void xsetRowHeaderCaption(STXstring paramSTXstring);
  
  void unsetRowHeaderCaption();
  
  String getColHeaderCaption();
  
  STXstring xgetColHeaderCaption();
  
  boolean isSetColHeaderCaption();
  
  void setColHeaderCaption(String paramString);
  
  void xsetColHeaderCaption(STXstring paramSTXstring);
  
  void unsetColHeaderCaption();
  
  boolean getFieldListSortAscending();
  
  XmlBoolean xgetFieldListSortAscending();
  
  boolean isSetFieldListSortAscending();
  
  void setFieldListSortAscending(boolean paramBoolean);
  
  void xsetFieldListSortAscending(XmlBoolean paramXmlBoolean);
  
  void unsetFieldListSortAscending();
  
  boolean getMdxSubqueries();
  
  XmlBoolean xgetMdxSubqueries();
  
  boolean isSetMdxSubqueries();
  
  void setMdxSubqueries(boolean paramBoolean);
  
  void xsetMdxSubqueries(XmlBoolean paramXmlBoolean);
  
  void unsetMdxSubqueries();
  
  boolean getCustomListSort();
  
  XmlBoolean xgetCustomListSort();
  
  boolean isSetCustomListSort();
  
  void setCustomListSort(boolean paramBoolean);
  
  void xsetCustomListSort(XmlBoolean paramXmlBoolean);
  
  void unsetCustomListSort();
  
  public static final class Factory {
    public static CTPivotTableDefinition newInstance() {
      return (CTPivotTableDefinition)POIXMLTypeLoader.newInstance(CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition newInstance(XmlOptions param1XmlOptions) {
      return (CTPivotTableDefinition)POIXMLTypeLoader.newInstance(CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(String param1String) throws XmlException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1String, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1String, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(File param1File) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1File, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1File, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(URL param1URL) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1URL, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1URL, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1InputStream, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1InputStream, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1Reader, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1Reader, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(Node param1Node) throws XmlException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1Node, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1Node, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotTableDefinition parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotTableDefinition.type, null);
    }
    
    public static CTPivotTableDefinition parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPivotTableDefinition)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotTableDefinition.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotTableDefinition.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotTableDefinition.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPivotTableDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */