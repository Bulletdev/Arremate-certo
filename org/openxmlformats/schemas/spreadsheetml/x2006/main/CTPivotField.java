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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPivotField extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPivotField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotfieldf961type");
  
  CTItems getItems();
  
  boolean isSetItems();
  
  void setItems(CTItems paramCTItems);
  
  CTItems addNewItems();
  
  void unsetItems();
  
  CTAutoSortScope getAutoSortScope();
  
  boolean isSetAutoSortScope();
  
  void setAutoSortScope(CTAutoSortScope paramCTAutoSortScope);
  
  CTAutoSortScope addNewAutoSortScope();
  
  void unsetAutoSortScope();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getName();
  
  STXstring xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  void unsetName();
  
  STAxis.Enum getAxis();
  
  STAxis xgetAxis();
  
  boolean isSetAxis();
  
  void setAxis(STAxis.Enum paramEnum);
  
  void xsetAxis(STAxis paramSTAxis);
  
  void unsetAxis();
  
  boolean getDataField();
  
  XmlBoolean xgetDataField();
  
  boolean isSetDataField();
  
  void setDataField(boolean paramBoolean);
  
  void xsetDataField(XmlBoolean paramXmlBoolean);
  
  void unsetDataField();
  
  String getSubtotalCaption();
  
  STXstring xgetSubtotalCaption();
  
  boolean isSetSubtotalCaption();
  
  void setSubtotalCaption(String paramString);
  
  void xsetSubtotalCaption(STXstring paramSTXstring);
  
  void unsetSubtotalCaption();
  
  boolean getShowDropDowns();
  
  XmlBoolean xgetShowDropDowns();
  
  boolean isSetShowDropDowns();
  
  void setShowDropDowns(boolean paramBoolean);
  
  void xsetShowDropDowns(XmlBoolean paramXmlBoolean);
  
  void unsetShowDropDowns();
  
  boolean getHiddenLevel();
  
  XmlBoolean xgetHiddenLevel();
  
  boolean isSetHiddenLevel();
  
  void setHiddenLevel(boolean paramBoolean);
  
  void xsetHiddenLevel(XmlBoolean paramXmlBoolean);
  
  void unsetHiddenLevel();
  
  String getUniqueMemberProperty();
  
  STXstring xgetUniqueMemberProperty();
  
  boolean isSetUniqueMemberProperty();
  
  void setUniqueMemberProperty(String paramString);
  
  void xsetUniqueMemberProperty(STXstring paramSTXstring);
  
  void unsetUniqueMemberProperty();
  
  boolean getCompact();
  
  XmlBoolean xgetCompact();
  
  boolean isSetCompact();
  
  void setCompact(boolean paramBoolean);
  
  void xsetCompact(XmlBoolean paramXmlBoolean);
  
  void unsetCompact();
  
  boolean getAllDrilled();
  
  XmlBoolean xgetAllDrilled();
  
  boolean isSetAllDrilled();
  
  void setAllDrilled(boolean paramBoolean);
  
  void xsetAllDrilled(XmlBoolean paramXmlBoolean);
  
  void unsetAllDrilled();
  
  long getNumFmtId();
  
  STNumFmtId xgetNumFmtId();
  
  boolean isSetNumFmtId();
  
  void setNumFmtId(long paramLong);
  
  void xsetNumFmtId(STNumFmtId paramSTNumFmtId);
  
  void unsetNumFmtId();
  
  boolean getOutline();
  
  XmlBoolean xgetOutline();
  
  boolean isSetOutline();
  
  void setOutline(boolean paramBoolean);
  
  void xsetOutline(XmlBoolean paramXmlBoolean);
  
  void unsetOutline();
  
  boolean getSubtotalTop();
  
  XmlBoolean xgetSubtotalTop();
  
  boolean isSetSubtotalTop();
  
  void setSubtotalTop(boolean paramBoolean);
  
  void xsetSubtotalTop(XmlBoolean paramXmlBoolean);
  
  void unsetSubtotalTop();
  
  boolean getDragToRow();
  
  XmlBoolean xgetDragToRow();
  
  boolean isSetDragToRow();
  
  void setDragToRow(boolean paramBoolean);
  
  void xsetDragToRow(XmlBoolean paramXmlBoolean);
  
  void unsetDragToRow();
  
  boolean getDragToCol();
  
  XmlBoolean xgetDragToCol();
  
  boolean isSetDragToCol();
  
  void setDragToCol(boolean paramBoolean);
  
  void xsetDragToCol(XmlBoolean paramXmlBoolean);
  
  void unsetDragToCol();
  
  boolean getMultipleItemSelectionAllowed();
  
  XmlBoolean xgetMultipleItemSelectionAllowed();
  
  boolean isSetMultipleItemSelectionAllowed();
  
  void setMultipleItemSelectionAllowed(boolean paramBoolean);
  
  void xsetMultipleItemSelectionAllowed(XmlBoolean paramXmlBoolean);
  
  void unsetMultipleItemSelectionAllowed();
  
  boolean getDragToPage();
  
  XmlBoolean xgetDragToPage();
  
  boolean isSetDragToPage();
  
  void setDragToPage(boolean paramBoolean);
  
  void xsetDragToPage(XmlBoolean paramXmlBoolean);
  
  void unsetDragToPage();
  
  boolean getDragToData();
  
  XmlBoolean xgetDragToData();
  
  boolean isSetDragToData();
  
  void setDragToData(boolean paramBoolean);
  
  void xsetDragToData(XmlBoolean paramXmlBoolean);
  
  void unsetDragToData();
  
  boolean getDragOff();
  
  XmlBoolean xgetDragOff();
  
  boolean isSetDragOff();
  
  void setDragOff(boolean paramBoolean);
  
  void xsetDragOff(XmlBoolean paramXmlBoolean);
  
  void unsetDragOff();
  
  boolean getShowAll();
  
  XmlBoolean xgetShowAll();
  
  boolean isSetShowAll();
  
  void setShowAll(boolean paramBoolean);
  
  void xsetShowAll(XmlBoolean paramXmlBoolean);
  
  void unsetShowAll();
  
  boolean getInsertBlankRow();
  
  XmlBoolean xgetInsertBlankRow();
  
  boolean isSetInsertBlankRow();
  
  void setInsertBlankRow(boolean paramBoolean);
  
  void xsetInsertBlankRow(XmlBoolean paramXmlBoolean);
  
  void unsetInsertBlankRow();
  
  boolean getServerField();
  
  XmlBoolean xgetServerField();
  
  boolean isSetServerField();
  
  void setServerField(boolean paramBoolean);
  
  void xsetServerField(XmlBoolean paramXmlBoolean);
  
  void unsetServerField();
  
  boolean getInsertPageBreak();
  
  XmlBoolean xgetInsertPageBreak();
  
  boolean isSetInsertPageBreak();
  
  void setInsertPageBreak(boolean paramBoolean);
  
  void xsetInsertPageBreak(XmlBoolean paramXmlBoolean);
  
  void unsetInsertPageBreak();
  
  boolean getAutoShow();
  
  XmlBoolean xgetAutoShow();
  
  boolean isSetAutoShow();
  
  void setAutoShow(boolean paramBoolean);
  
  void xsetAutoShow(XmlBoolean paramXmlBoolean);
  
  void unsetAutoShow();
  
  boolean getTopAutoShow();
  
  XmlBoolean xgetTopAutoShow();
  
  boolean isSetTopAutoShow();
  
  void setTopAutoShow(boolean paramBoolean);
  
  void xsetTopAutoShow(XmlBoolean paramXmlBoolean);
  
  void unsetTopAutoShow();
  
  boolean getHideNewItems();
  
  XmlBoolean xgetHideNewItems();
  
  boolean isSetHideNewItems();
  
  void setHideNewItems(boolean paramBoolean);
  
  void xsetHideNewItems(XmlBoolean paramXmlBoolean);
  
  void unsetHideNewItems();
  
  boolean getMeasureFilter();
  
  XmlBoolean xgetMeasureFilter();
  
  boolean isSetMeasureFilter();
  
  void setMeasureFilter(boolean paramBoolean);
  
  void xsetMeasureFilter(XmlBoolean paramXmlBoolean);
  
  void unsetMeasureFilter();
  
  boolean getIncludeNewItemsInFilter();
  
  XmlBoolean xgetIncludeNewItemsInFilter();
  
  boolean isSetIncludeNewItemsInFilter();
  
  void setIncludeNewItemsInFilter(boolean paramBoolean);
  
  void xsetIncludeNewItemsInFilter(XmlBoolean paramXmlBoolean);
  
  void unsetIncludeNewItemsInFilter();
  
  long getItemPageCount();
  
  XmlUnsignedInt xgetItemPageCount();
  
  boolean isSetItemPageCount();
  
  void setItemPageCount(long paramLong);
  
  void xsetItemPageCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetItemPageCount();
  
  STFieldSortType$Enum getSortType();
  
  STFieldSortType xgetSortType();
  
  boolean isSetSortType();
  
  void setSortType(STFieldSortType$Enum paramSTFieldSortType$Enum);
  
  void xsetSortType(STFieldSortType paramSTFieldSortType);
  
  void unsetSortType();
  
  boolean getDataSourceSort();
  
  XmlBoolean xgetDataSourceSort();
  
  boolean isSetDataSourceSort();
  
  void setDataSourceSort(boolean paramBoolean);
  
  void xsetDataSourceSort(XmlBoolean paramXmlBoolean);
  
  void unsetDataSourceSort();
  
  boolean getNonAutoSortDefault();
  
  XmlBoolean xgetNonAutoSortDefault();
  
  boolean isSetNonAutoSortDefault();
  
  void setNonAutoSortDefault(boolean paramBoolean);
  
  void xsetNonAutoSortDefault(XmlBoolean paramXmlBoolean);
  
  void unsetNonAutoSortDefault();
  
  long getRankBy();
  
  XmlUnsignedInt xgetRankBy();
  
  boolean isSetRankBy();
  
  void setRankBy(long paramLong);
  
  void xsetRankBy(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetRankBy();
  
  boolean getDefaultSubtotal();
  
  XmlBoolean xgetDefaultSubtotal();
  
  boolean isSetDefaultSubtotal();
  
  void setDefaultSubtotal(boolean paramBoolean);
  
  void xsetDefaultSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetDefaultSubtotal();
  
  boolean getSumSubtotal();
  
  XmlBoolean xgetSumSubtotal();
  
  boolean isSetSumSubtotal();
  
  void setSumSubtotal(boolean paramBoolean);
  
  void xsetSumSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetSumSubtotal();
  
  boolean getCountASubtotal();
  
  XmlBoolean xgetCountASubtotal();
  
  boolean isSetCountASubtotal();
  
  void setCountASubtotal(boolean paramBoolean);
  
  void xsetCountASubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetCountASubtotal();
  
  boolean getAvgSubtotal();
  
  XmlBoolean xgetAvgSubtotal();
  
  boolean isSetAvgSubtotal();
  
  void setAvgSubtotal(boolean paramBoolean);
  
  void xsetAvgSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetAvgSubtotal();
  
  boolean getMaxSubtotal();
  
  XmlBoolean xgetMaxSubtotal();
  
  boolean isSetMaxSubtotal();
  
  void setMaxSubtotal(boolean paramBoolean);
  
  void xsetMaxSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetMaxSubtotal();
  
  boolean getMinSubtotal();
  
  XmlBoolean xgetMinSubtotal();
  
  boolean isSetMinSubtotal();
  
  void setMinSubtotal(boolean paramBoolean);
  
  void xsetMinSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetMinSubtotal();
  
  boolean getProductSubtotal();
  
  XmlBoolean xgetProductSubtotal();
  
  boolean isSetProductSubtotal();
  
  void setProductSubtotal(boolean paramBoolean);
  
  void xsetProductSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetProductSubtotal();
  
  boolean getCountSubtotal();
  
  XmlBoolean xgetCountSubtotal();
  
  boolean isSetCountSubtotal();
  
  void setCountSubtotal(boolean paramBoolean);
  
  void xsetCountSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetCountSubtotal();
  
  boolean getStdDevSubtotal();
  
  XmlBoolean xgetStdDevSubtotal();
  
  boolean isSetStdDevSubtotal();
  
  void setStdDevSubtotal(boolean paramBoolean);
  
  void xsetStdDevSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetStdDevSubtotal();
  
  boolean getStdDevPSubtotal();
  
  XmlBoolean xgetStdDevPSubtotal();
  
  boolean isSetStdDevPSubtotal();
  
  void setStdDevPSubtotal(boolean paramBoolean);
  
  void xsetStdDevPSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetStdDevPSubtotal();
  
  boolean getVarSubtotal();
  
  XmlBoolean xgetVarSubtotal();
  
  boolean isSetVarSubtotal();
  
  void setVarSubtotal(boolean paramBoolean);
  
  void xsetVarSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetVarSubtotal();
  
  boolean getVarPSubtotal();
  
  XmlBoolean xgetVarPSubtotal();
  
  boolean isSetVarPSubtotal();
  
  void setVarPSubtotal(boolean paramBoolean);
  
  void xsetVarPSubtotal(XmlBoolean paramXmlBoolean);
  
  void unsetVarPSubtotal();
  
  boolean getShowPropCell();
  
  XmlBoolean xgetShowPropCell();
  
  boolean isSetShowPropCell();
  
  void setShowPropCell(boolean paramBoolean);
  
  void xsetShowPropCell(XmlBoolean paramXmlBoolean);
  
  void unsetShowPropCell();
  
  boolean getShowPropTip();
  
  XmlBoolean xgetShowPropTip();
  
  boolean isSetShowPropTip();
  
  void setShowPropTip(boolean paramBoolean);
  
  void xsetShowPropTip(XmlBoolean paramXmlBoolean);
  
  void unsetShowPropTip();
  
  boolean getShowPropAsCaption();
  
  XmlBoolean xgetShowPropAsCaption();
  
  boolean isSetShowPropAsCaption();
  
  void setShowPropAsCaption(boolean paramBoolean);
  
  void xsetShowPropAsCaption(XmlBoolean paramXmlBoolean);
  
  void unsetShowPropAsCaption();
  
  boolean getDefaultAttributeDrillState();
  
  XmlBoolean xgetDefaultAttributeDrillState();
  
  boolean isSetDefaultAttributeDrillState();
  
  void setDefaultAttributeDrillState(boolean paramBoolean);
  
  void xsetDefaultAttributeDrillState(XmlBoolean paramXmlBoolean);
  
  void unsetDefaultAttributeDrillState();
  
  public static final class Factory {
    public static CTPivotField newInstance() {
      return (CTPivotField)POIXMLTypeLoader.newInstance(CTPivotField.type, null);
    }
    
    public static CTPivotField newInstance(XmlOptions param1XmlOptions) {
      return (CTPivotField)POIXMLTypeLoader.newInstance(CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(String param1String) throws XmlException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1String, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1String, CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(File param1File) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1File, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1File, CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(URL param1URL) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1URL, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1URL, CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1InputStream, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1InputStream, CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1Reader, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1Reader, CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(Node param1Node) throws XmlException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1Node, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1Node, CTPivotField.type, param1XmlOptions);
    }
    
    public static CTPivotField parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotField.type, null);
    }
    
    public static CTPivotField parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPivotField)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotField.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotField.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotField.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPivotField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */