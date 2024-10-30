package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoSortScope;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFieldSortType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STNumFmtId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTPivotFieldImpl extends XmlComplexContentImpl implements CTPivotField {
  private static final b ITEMS$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "items");
  
  private static final b AUTOSORTSCOPE$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "autoSortScope");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b NAME$6 = new b("", "name");
  
  private static final b AXIS$8 = new b("", "axis");
  
  private static final b DATAFIELD$10 = new b("", "dataField");
  
  private static final b SUBTOTALCAPTION$12 = new b("", "subtotalCaption");
  
  private static final b SHOWDROPDOWNS$14 = new b("", "showDropDowns");
  
  private static final b HIDDENLEVEL$16 = new b("", "hiddenLevel");
  
  private static final b UNIQUEMEMBERPROPERTY$18 = new b("", "uniqueMemberProperty");
  
  private static final b COMPACT$20 = new b("", "compact");
  
  private static final b ALLDRILLED$22 = new b("", "allDrilled");
  
  private static final b NUMFMTID$24 = new b("", "numFmtId");
  
  private static final b OUTLINE$26 = new b("", "outline");
  
  private static final b SUBTOTALTOP$28 = new b("", "subtotalTop");
  
  private static final b DRAGTOROW$30 = new b("", "dragToRow");
  
  private static final b DRAGTOCOL$32 = new b("", "dragToCol");
  
  private static final b MULTIPLEITEMSELECTIONALLOWED$34 = new b("", "multipleItemSelectionAllowed");
  
  private static final b DRAGTOPAGE$36 = new b("", "dragToPage");
  
  private static final b DRAGTODATA$38 = new b("", "dragToData");
  
  private static final b DRAGOFF$40 = new b("", "dragOff");
  
  private static final b SHOWALL$42 = new b("", "showAll");
  
  private static final b INSERTBLANKROW$44 = new b("", "insertBlankRow");
  
  private static final b SERVERFIELD$46 = new b("", "serverField");
  
  private static final b INSERTPAGEBREAK$48 = new b("", "insertPageBreak");
  
  private static final b AUTOSHOW$50 = new b("", "autoShow");
  
  private static final b TOPAUTOSHOW$52 = new b("", "topAutoShow");
  
  private static final b HIDENEWITEMS$54 = new b("", "hideNewItems");
  
  private static final b MEASUREFILTER$56 = new b("", "measureFilter");
  
  private static final b INCLUDENEWITEMSINFILTER$58 = new b("", "includeNewItemsInFilter");
  
  private static final b ITEMPAGECOUNT$60 = new b("", "itemPageCount");
  
  private static final b SORTTYPE$62 = new b("", "sortType");
  
  private static final b DATASOURCESORT$64 = new b("", "dataSourceSort");
  
  private static final b NONAUTOSORTDEFAULT$66 = new b("", "nonAutoSortDefault");
  
  private static final b RANKBY$68 = new b("", "rankBy");
  
  private static final b DEFAULTSUBTOTAL$70 = new b("", "defaultSubtotal");
  
  private static final b SUMSUBTOTAL$72 = new b("", "sumSubtotal");
  
  private static final b COUNTASUBTOTAL$74 = new b("", "countASubtotal");
  
  private static final b AVGSUBTOTAL$76 = new b("", "avgSubtotal");
  
  private static final b MAXSUBTOTAL$78 = new b("", "maxSubtotal");
  
  private static final b MINSUBTOTAL$80 = new b("", "minSubtotal");
  
  private static final b PRODUCTSUBTOTAL$82 = new b("", "productSubtotal");
  
  private static final b COUNTSUBTOTAL$84 = new b("", "countSubtotal");
  
  private static final b STDDEVSUBTOTAL$86 = new b("", "stdDevSubtotal");
  
  private static final b STDDEVPSUBTOTAL$88 = new b("", "stdDevPSubtotal");
  
  private static final b VARSUBTOTAL$90 = new b("", "varSubtotal");
  
  private static final b VARPSUBTOTAL$92 = new b("", "varPSubtotal");
  
  private static final b SHOWPROPCELL$94 = new b("", "showPropCell");
  
  private static final b SHOWPROPTIP$96 = new b("", "showPropTip");
  
  private static final b SHOWPROPASCAPTION$98 = new b("", "showPropAsCaption");
  
  private static final b DEFAULTATTRIBUTEDRILLSTATE$100 = new b("", "defaultAttributeDrillState");
  
  public CTPivotFieldImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTItems getItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTItems cTItems = null;
      cTItems = (CTItems)get_store().find_element_user(ITEMS$0, 0);
      if (cTItems == null)
        return null; 
      return cTItems;
    } 
  }
  
  public boolean isSetItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ITEMS$0) != 0);
    } 
  }
  
  public void setItems(CTItems paramCTItems) {
    synchronized (monitor()) {
      check_orphaned();
      CTItems cTItems = null;
      cTItems = (CTItems)get_store().find_element_user(ITEMS$0, 0);
      if (cTItems == null)
        cTItems = (CTItems)get_store().add_element_user(ITEMS$0); 
      cTItems.set((XmlObject)paramCTItems);
    } 
  }
  
  public CTItems addNewItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTItems cTItems = null;
      cTItems = (CTItems)get_store().add_element_user(ITEMS$0);
      return cTItems;
    } 
  }
  
  public void unsetItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ITEMS$0, 0);
    } 
  }
  
  public CTAutoSortScope getAutoSortScope() {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoSortScope cTAutoSortScope = null;
      cTAutoSortScope = (CTAutoSortScope)get_store().find_element_user(AUTOSORTSCOPE$2, 0);
      if (cTAutoSortScope == null)
        return null; 
      return cTAutoSortScope;
    } 
  }
  
  public boolean isSetAutoSortScope() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOSORTSCOPE$2) != 0);
    } 
  }
  
  public void setAutoSortScope(CTAutoSortScope paramCTAutoSortScope) {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoSortScope cTAutoSortScope = null;
      cTAutoSortScope = (CTAutoSortScope)get_store().find_element_user(AUTOSORTSCOPE$2, 0);
      if (cTAutoSortScope == null)
        cTAutoSortScope = (CTAutoSortScope)get_store().add_element_user(AUTOSORTSCOPE$2); 
      cTAutoSortScope.set((XmlObject)paramCTAutoSortScope);
    } 
  }
  
  public CTAutoSortScope addNewAutoSortScope() {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoSortScope cTAutoSortScope = null;
      cTAutoSortScope = (CTAutoSortScope)get_store().add_element_user(AUTOSORTSCOPE$2);
      return cTAutoSortScope;
    } 
  }
  
  public void unsetAutoSortScope() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOSORTSCOPE$2, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$6);
      return sTXstring;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$6) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$6);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$6); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$6);
    } 
  }
  
  public STAxis.Enum getAxis() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AXIS$8);
      if (simpleValue == null)
        return null; 
      return (STAxis.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STAxis xgetAxis() {
    synchronized (monitor()) {
      check_orphaned();
      STAxis sTAxis = null;
      sTAxis = (STAxis)get_store().find_attribute_user(AXIS$8);
      return sTAxis;
    } 
  }
  
  public boolean isSetAxis() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AXIS$8) != null);
    } 
  }
  
  public void setAxis(STAxis.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AXIS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AXIS$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAxis(STAxis paramSTAxis) {
    synchronized (monitor()) {
      check_orphaned();
      STAxis sTAxis = null;
      sTAxis = (STAxis)get_store().find_attribute_user(AXIS$8);
      if (sTAxis == null)
        sTAxis = (STAxis)get_store().add_attribute_user(AXIS$8); 
      sTAxis.set((XmlObject)paramSTAxis);
    } 
  }
  
  public void unsetAxis() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AXIS$8);
    } 
  }
  
  public boolean getDataField() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATAFIELD$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DATAFIELD$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDataField() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATAFIELD$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DATAFIELD$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDataField() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATAFIELD$10) != null);
    } 
  }
  
  public void setDataField(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATAFIELD$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATAFIELD$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDataField(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATAFIELD$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DATAFIELD$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDataField() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATAFIELD$10);
    } 
  }
  
  public String getSubtotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTALCAPTION$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetSubtotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(SUBTOTALCAPTION$12);
      return sTXstring;
    } 
  }
  
  public boolean isSetSubtotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUBTOTALCAPTION$12) != null);
    } 
  }
  
  public void setSubtotalCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTALCAPTION$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUBTOTALCAPTION$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSubtotalCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(SUBTOTALCAPTION$12);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(SUBTOTALCAPTION$12); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetSubtotalCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUBTOTALCAPTION$12);
    } 
  }
  
  public boolean getShowDropDowns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDROPDOWNS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWDROPDOWNS$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowDropDowns() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDROPDOWNS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWDROPDOWNS$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowDropDowns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWDROPDOWNS$14) != null);
    } 
  }
  
  public void setShowDropDowns(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDROPDOWNS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWDROPDOWNS$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowDropDowns(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWDROPDOWNS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWDROPDOWNS$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowDropDowns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWDROPDOWNS$14);
    } 
  }
  
  public boolean getHiddenLevel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDENLEVEL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIDDENLEVEL$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHiddenLevel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDENLEVEL$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIDDENLEVEL$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHiddenLevel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDENLEVEL$16) != null);
    } 
  }
  
  public void setHiddenLevel(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDENLEVEL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDENLEVEL$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHiddenLevel(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDENLEVEL$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDENLEVEL$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHiddenLevel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDENLEVEL$16);
    } 
  }
  
  public String getUniqueMemberProperty() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEMEMBERPROPERTY$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetUniqueMemberProperty() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(UNIQUEMEMBERPROPERTY$18);
      return sTXstring;
    } 
  }
  
  public boolean isSetUniqueMemberProperty() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUEMEMBERPROPERTY$18) != null);
    } 
  }
  
  public void setUniqueMemberProperty(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEMEMBERPROPERTY$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUEMEMBERPROPERTY$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetUniqueMemberProperty(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(UNIQUEMEMBERPROPERTY$18);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(UNIQUEMEMBERPROPERTY$18); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetUniqueMemberProperty() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUEMEMBERPROPERTY$18);
    } 
  }
  
  public boolean getCompact() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPACT$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COMPACT$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCompact() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPACT$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COMPACT$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCompact() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COMPACT$20) != null);
    } 
  }
  
  public void setCompact(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPACT$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COMPACT$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCompact(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPACT$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COMPACT$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCompact() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COMPACT$20);
    } 
  }
  
  public boolean getAllDrilled() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLDRILLED$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ALLDRILLED$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAllDrilled() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLDRILLED$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ALLDRILLED$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAllDrilled() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALLDRILLED$22) != null);
    } 
  }
  
  public void setAllDrilled(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLDRILLED$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLDRILLED$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAllDrilled(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLDRILLED$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ALLDRILLED$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAllDrilled() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALLDRILLED$22);
    } 
  }
  
  public long getNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$24);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STNumFmtId xgetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$24);
      return sTNumFmtId;
    } 
  }
  
  public boolean isSetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NUMFMTID$24) != null);
    } 
  }
  
  public void setNumFmtId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMFMTID$24); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetNumFmtId(STNumFmtId paramSTNumFmtId) {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$24);
      if (sTNumFmtId == null)
        sTNumFmtId = (STNumFmtId)get_store().add_attribute_user(NUMFMTID$24); 
      sTNumFmtId.set((XmlObject)paramSTNumFmtId);
    } 
  }
  
  public void unsetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NUMFMTID$24);
    } 
  }
  
  public boolean getOutline() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINE$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINE$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINE$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(OUTLINE$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINE$26) != null);
    } 
  }
  
  public void setOutline(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINE$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINE$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetOutline(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OUTLINE$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(OUTLINE$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetOutline() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINE$26);
    } 
  }
  
  public boolean getSubtotalTop() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTALTOP$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUBTOTALTOP$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSubtotalTop() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUBTOTALTOP$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SUBTOTALTOP$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSubtotalTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUBTOTALTOP$28) != null);
    } 
  }
  
  public void setSubtotalTop(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTALTOP$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUBTOTALTOP$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSubtotalTop(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUBTOTALTOP$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SUBTOTALTOP$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSubtotalTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUBTOTALTOP$28);
    } 
  }
  
  public boolean getDragToRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTOROW$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DRAGTOROW$30); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDragToRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTOROW$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DRAGTOROW$30); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDragToRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DRAGTOROW$30) != null);
    } 
  }
  
  public void setDragToRow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTOROW$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DRAGTOROW$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDragToRow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTOROW$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DRAGTOROW$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDragToRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DRAGTOROW$30);
    } 
  }
  
  public boolean getDragToCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTOCOL$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DRAGTOCOL$32); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDragToCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTOCOL$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DRAGTOCOL$32); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDragToCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DRAGTOCOL$32) != null);
    } 
  }
  
  public void setDragToCol(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTOCOL$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DRAGTOCOL$32); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDragToCol(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTOCOL$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DRAGTOCOL$32); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDragToCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DRAGTOCOL$32);
    } 
  }
  
  public boolean getMultipleItemSelectionAllowed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MULTIPLEITEMSELECTIONALLOWED$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MULTIPLEITEMSELECTIONALLOWED$34); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMultipleItemSelectionAllowed() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MULTIPLEITEMSELECTIONALLOWED$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MULTIPLEITEMSELECTIONALLOWED$34); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMultipleItemSelectionAllowed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MULTIPLEITEMSELECTIONALLOWED$34) != null);
    } 
  }
  
  public void setMultipleItemSelectionAllowed(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MULTIPLEITEMSELECTIONALLOWED$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MULTIPLEITEMSELECTIONALLOWED$34); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMultipleItemSelectionAllowed(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MULTIPLEITEMSELECTIONALLOWED$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MULTIPLEITEMSELECTIONALLOWED$34); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMultipleItemSelectionAllowed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MULTIPLEITEMSELECTIONALLOWED$34);
    } 
  }
  
  public boolean getDragToPage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTOPAGE$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DRAGTOPAGE$36); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDragToPage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTOPAGE$36);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DRAGTOPAGE$36); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDragToPage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DRAGTOPAGE$36) != null);
    } 
  }
  
  public void setDragToPage(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTOPAGE$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DRAGTOPAGE$36); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDragToPage(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTOPAGE$36);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DRAGTOPAGE$36); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDragToPage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DRAGTOPAGE$36);
    } 
  }
  
  public boolean getDragToData() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTODATA$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DRAGTODATA$38); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDragToData() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTODATA$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DRAGTODATA$38); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDragToData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DRAGTODATA$38) != null);
    } 
  }
  
  public void setDragToData(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGTODATA$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DRAGTODATA$38); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDragToData(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGTODATA$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DRAGTODATA$38); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDragToData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DRAGTODATA$38);
    } 
  }
  
  public boolean getDragOff() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGOFF$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DRAGOFF$40); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDragOff() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGOFF$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DRAGOFF$40); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDragOff() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DRAGOFF$40) != null);
    } 
  }
  
  public void setDragOff(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DRAGOFF$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DRAGOFF$40); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDragOff(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DRAGOFF$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DRAGOFF$40); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDragOff() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DRAGOFF$40);
    } 
  }
  
  public boolean getShowAll() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWALL$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWALL$42); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowAll() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWALL$42);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWALL$42); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowAll() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWALL$42) != null);
    } 
  }
  
  public void setShowAll(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWALL$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWALL$42); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowAll(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWALL$42);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWALL$42); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowAll() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWALL$42);
    } 
  }
  
  public boolean getInsertBlankRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTBLANKROW$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSERTBLANKROW$44); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInsertBlankRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTBLANKROW$44);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INSERTBLANKROW$44); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInsertBlankRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSERTBLANKROW$44) != null);
    } 
  }
  
  public void setInsertBlankRow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTBLANKROW$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSERTBLANKROW$44); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInsertBlankRow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTBLANKROW$44);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INSERTBLANKROW$44); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInsertBlankRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSERTBLANKROW$44);
    } 
  }
  
  public boolean getServerField() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SERVERFIELD$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SERVERFIELD$46); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetServerField() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SERVERFIELD$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SERVERFIELD$46); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetServerField() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SERVERFIELD$46) != null);
    } 
  }
  
  public void setServerField(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SERVERFIELD$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SERVERFIELD$46); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetServerField(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SERVERFIELD$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SERVERFIELD$46); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetServerField() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SERVERFIELD$46);
    } 
  }
  
  public boolean getInsertPageBreak() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTPAGEBREAK$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSERTPAGEBREAK$48); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInsertPageBreak() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTPAGEBREAK$48);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INSERTPAGEBREAK$48); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInsertPageBreak() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSERTPAGEBREAK$48) != null);
    } 
  }
  
  public void setInsertPageBreak(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTPAGEBREAK$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSERTPAGEBREAK$48); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInsertPageBreak(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTPAGEBREAK$48);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INSERTPAGEBREAK$48); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInsertPageBreak() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSERTPAGEBREAK$48);
    } 
  }
  
  public boolean getAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOSHOW$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AUTOSHOW$50); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOSHOW$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(AUTOSHOW$50); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTOSHOW$50) != null);
    } 
  }
  
  public void setAutoShow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOSHOW$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOSHOW$50); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAutoShow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOSHOW$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTOSHOW$50); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTOSHOW$50);
    } 
  }
  
  public boolean getTopAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPAUTOSHOW$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TOPAUTOSHOW$52); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTopAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TOPAUTOSHOW$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TOPAUTOSHOW$52); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTopAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOPAUTOSHOW$52) != null);
    } 
  }
  
  public void setTopAutoShow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPAUTOSHOW$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOPAUTOSHOW$52); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTopAutoShow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TOPAUTOSHOW$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TOPAUTOSHOW$52); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTopAutoShow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOPAUTOSHOW$52);
    } 
  }
  
  public boolean getHideNewItems() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDENEWITEMS$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIDENEWITEMS$54); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHideNewItems() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDENEWITEMS$54);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIDENEWITEMS$54); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHideNewItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDENEWITEMS$54) != null);
    } 
  }
  
  public void setHideNewItems(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDENEWITEMS$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDENEWITEMS$54); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHideNewItems(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDENEWITEMS$54);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDENEWITEMS$54); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHideNewItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDENEWITEMS$54);
    } 
  }
  
  public boolean getMeasureFilter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MEASUREFILTER$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MEASUREFILTER$56); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMeasureFilter() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MEASUREFILTER$56);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MEASUREFILTER$56); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMeasureFilter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MEASUREFILTER$56) != null);
    } 
  }
  
  public void setMeasureFilter(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MEASUREFILTER$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MEASUREFILTER$56); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMeasureFilter(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MEASUREFILTER$56);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MEASUREFILTER$56); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMeasureFilter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MEASUREFILTER$56);
    } 
  }
  
  public boolean getIncludeNewItemsInFilter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INCLUDENEWITEMSINFILTER$58);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INCLUDENEWITEMSINFILTER$58); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIncludeNewItemsInFilter() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INCLUDENEWITEMSINFILTER$58);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INCLUDENEWITEMSINFILTER$58); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIncludeNewItemsInFilter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INCLUDENEWITEMSINFILTER$58) != null);
    } 
  }
  
  public void setIncludeNewItemsInFilter(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INCLUDENEWITEMSINFILTER$58);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INCLUDENEWITEMSINFILTER$58); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIncludeNewItemsInFilter(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INCLUDENEWITEMSINFILTER$58);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INCLUDENEWITEMSINFILTER$58); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIncludeNewItemsInFilter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INCLUDENEWITEMSINFILTER$58);
    } 
  }
  
  public long getItemPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITEMPAGECOUNT$60);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ITEMPAGECOUNT$60); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetItemPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ITEMPAGECOUNT$60);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ITEMPAGECOUNT$60); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetItemPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ITEMPAGECOUNT$60) != null);
    } 
  }
  
  public void setItemPageCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITEMPAGECOUNT$60);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ITEMPAGECOUNT$60); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetItemPageCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ITEMPAGECOUNT$60);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ITEMPAGECOUNT$60); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetItemPageCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ITEMPAGECOUNT$60);
    } 
  }
  
  public STFieldSortType.Enum getSortType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SORTTYPE$62);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SORTTYPE$62); 
      if (simpleValue == null)
        return null; 
      return (STFieldSortType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STFieldSortType xgetSortType() {
    synchronized (monitor()) {
      check_orphaned();
      STFieldSortType sTFieldSortType = null;
      sTFieldSortType = (STFieldSortType)get_store().find_attribute_user(SORTTYPE$62);
      if (sTFieldSortType == null)
        sTFieldSortType = (STFieldSortType)get_default_attribute_value(SORTTYPE$62); 
      return sTFieldSortType;
    } 
  }
  
  public boolean isSetSortType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SORTTYPE$62) != null);
    } 
  }
  
  public void setSortType(STFieldSortType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SORTTYPE$62);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SORTTYPE$62); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSortType(STFieldSortType paramSTFieldSortType) {
    synchronized (monitor()) {
      check_orphaned();
      STFieldSortType sTFieldSortType = null;
      sTFieldSortType = (STFieldSortType)get_store().find_attribute_user(SORTTYPE$62);
      if (sTFieldSortType == null)
        sTFieldSortType = (STFieldSortType)get_store().add_attribute_user(SORTTYPE$62); 
      sTFieldSortType.set((XmlObject)paramSTFieldSortType);
    } 
  }
  
  public void unsetSortType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SORTTYPE$62);
    } 
  }
  
  public boolean getDataSourceSort() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATASOURCESORT$64);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDataSourceSort() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATASOURCESORT$64);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDataSourceSort() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATASOURCESORT$64) != null);
    } 
  }
  
  public void setDataSourceSort(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATASOURCESORT$64);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATASOURCESORT$64); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDataSourceSort(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATASOURCESORT$64);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DATASOURCESORT$64); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDataSourceSort() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATASOURCESORT$64);
    } 
  }
  
  public boolean getNonAutoSortDefault() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NONAUTOSORTDEFAULT$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NONAUTOSORTDEFAULT$66); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNonAutoSortDefault() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NONAUTOSORTDEFAULT$66);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NONAUTOSORTDEFAULT$66); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNonAutoSortDefault() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NONAUTOSORTDEFAULT$66) != null);
    } 
  }
  
  public void setNonAutoSortDefault(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NONAUTOSORTDEFAULT$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NONAUTOSORTDEFAULT$66); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNonAutoSortDefault(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NONAUTOSORTDEFAULT$66);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NONAUTOSORTDEFAULT$66); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNonAutoSortDefault() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NONAUTOSORTDEFAULT$66);
    } 
  }
  
  public long getRankBy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RANKBY$68);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetRankBy() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RANKBY$68);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetRankBy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RANKBY$68) != null);
    } 
  }
  
  public void setRankBy(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RANKBY$68);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RANKBY$68); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetRankBy(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RANKBY$68);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(RANKBY$68); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetRankBy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RANKBY$68);
    } 
  }
  
  public boolean getDefaultSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTSUBTOTAL$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DEFAULTSUBTOTAL$70); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDefaultSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEFAULTSUBTOTAL$70);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DEFAULTSUBTOTAL$70); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDefaultSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTSUBTOTAL$70) != null);
    } 
  }
  
  public void setDefaultSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTSUBTOTAL$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTSUBTOTAL$70); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDefaultSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEFAULTSUBTOTAL$70);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DEFAULTSUBTOTAL$70); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDefaultSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTSUBTOTAL$70);
    } 
  }
  
  public boolean getSumSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUMSUBTOTAL$72);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUMSUBTOTAL$72); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSumSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUMSUBTOTAL$72);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SUMSUBTOTAL$72); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSumSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUMSUBTOTAL$72) != null);
    } 
  }
  
  public void setSumSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUMSUBTOTAL$72);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUMSUBTOTAL$72); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSumSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUMSUBTOTAL$72);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SUMSUBTOTAL$72); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSumSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUMSUBTOTAL$72);
    } 
  }
  
  public boolean getCountASubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNTASUBTOTAL$74);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COUNTASUBTOTAL$74); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCountASubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COUNTASUBTOTAL$74);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COUNTASUBTOTAL$74); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCountASubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNTASUBTOTAL$74) != null);
    } 
  }
  
  public void setCountASubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNTASUBTOTAL$74);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNTASUBTOTAL$74); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCountASubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COUNTASUBTOTAL$74);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COUNTASUBTOTAL$74); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCountASubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNTASUBTOTAL$74);
    } 
  }
  
  public boolean getAvgSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AVGSUBTOTAL$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AVGSUBTOTAL$76); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAvgSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AVGSUBTOTAL$76);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(AVGSUBTOTAL$76); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAvgSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AVGSUBTOTAL$76) != null);
    } 
  }
  
  public void setAvgSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AVGSUBTOTAL$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AVGSUBTOTAL$76); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAvgSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AVGSUBTOTAL$76);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AVGSUBTOTAL$76); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAvgSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AVGSUBTOTAL$76);
    } 
  }
  
  public boolean getMaxSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXSUBTOTAL$78);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MAXSUBTOTAL$78); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMaxSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MAXSUBTOTAL$78);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MAXSUBTOTAL$78); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMaxSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAXSUBTOTAL$78) != null);
    } 
  }
  
  public void setMaxSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXSUBTOTAL$78);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAXSUBTOTAL$78); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMaxSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MAXSUBTOTAL$78);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MAXSUBTOTAL$78); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMaxSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAXSUBTOTAL$78);
    } 
  }
  
  public boolean getMinSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINSUBTOTAL$80);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MINSUBTOTAL$80); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMinSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MINSUBTOTAL$80);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MINSUBTOTAL$80); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMinSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MINSUBTOTAL$80) != null);
    } 
  }
  
  public void setMinSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINSUBTOTAL$80);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MINSUBTOTAL$80); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMinSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MINSUBTOTAL$80);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MINSUBTOTAL$80); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMinSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MINSUBTOTAL$80);
    } 
  }
  
  public boolean getProductSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRODUCTSUBTOTAL$82);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PRODUCTSUBTOTAL$82); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetProductSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRODUCTSUBTOTAL$82);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PRODUCTSUBTOTAL$82); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetProductSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PRODUCTSUBTOTAL$82) != null);
    } 
  }
  
  public void setProductSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRODUCTSUBTOTAL$82);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRODUCTSUBTOTAL$82); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetProductSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRODUCTSUBTOTAL$82);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PRODUCTSUBTOTAL$82); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetProductSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PRODUCTSUBTOTAL$82);
    } 
  }
  
  public boolean getCountSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNTSUBTOTAL$84);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COUNTSUBTOTAL$84); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCountSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COUNTSUBTOTAL$84);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COUNTSUBTOTAL$84); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCountSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNTSUBTOTAL$84) != null);
    } 
  }
  
  public void setCountSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNTSUBTOTAL$84);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNTSUBTOTAL$84); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCountSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COUNTSUBTOTAL$84);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COUNTSUBTOTAL$84); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCountSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNTSUBTOTAL$84);
    } 
  }
  
  public boolean getStdDevSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STDDEVSUBTOTAL$86);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STDDEVSUBTOTAL$86); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetStdDevSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STDDEVSUBTOTAL$86);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(STDDEVSUBTOTAL$86); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetStdDevSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STDDEVSUBTOTAL$86) != null);
    } 
  }
  
  public void setStdDevSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STDDEVSUBTOTAL$86);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STDDEVSUBTOTAL$86); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetStdDevSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STDDEVSUBTOTAL$86);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(STDDEVSUBTOTAL$86); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetStdDevSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STDDEVSUBTOTAL$86);
    } 
  }
  
  public boolean getStdDevPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STDDEVPSUBTOTAL$88);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STDDEVPSUBTOTAL$88); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetStdDevPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STDDEVPSUBTOTAL$88);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(STDDEVPSUBTOTAL$88); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetStdDevPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STDDEVPSUBTOTAL$88) != null);
    } 
  }
  
  public void setStdDevPSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STDDEVPSUBTOTAL$88);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STDDEVPSUBTOTAL$88); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetStdDevPSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STDDEVPSUBTOTAL$88);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(STDDEVPSUBTOTAL$88); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetStdDevPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STDDEVPSUBTOTAL$88);
    } 
  }
  
  public boolean getVarSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VARSUBTOTAL$90);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VARSUBTOTAL$90); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetVarSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VARSUBTOTAL$90);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(VARSUBTOTAL$90); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetVarSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VARSUBTOTAL$90) != null);
    } 
  }
  
  public void setVarSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VARSUBTOTAL$90);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VARSUBTOTAL$90); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetVarSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VARSUBTOTAL$90);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(VARSUBTOTAL$90); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetVarSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VARSUBTOTAL$90);
    } 
  }
  
  public boolean getVarPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VARPSUBTOTAL$92);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VARPSUBTOTAL$92); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetVarPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VARPSUBTOTAL$92);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(VARPSUBTOTAL$92); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetVarPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VARPSUBTOTAL$92) != null);
    } 
  }
  
  public void setVarPSubtotal(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VARPSUBTOTAL$92);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VARPSUBTOTAL$92); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetVarPSubtotal(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VARPSUBTOTAL$92);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(VARPSUBTOTAL$92); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetVarPSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VARPSUBTOTAL$92);
    } 
  }
  
  public boolean getShowPropCell() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPROPCELL$94);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWPROPCELL$94); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowPropCell() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPROPCELL$94);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWPROPCELL$94); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowPropCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWPROPCELL$94) != null);
    } 
  }
  
  public void setShowPropCell(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPROPCELL$94);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWPROPCELL$94); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowPropCell(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPROPCELL$94);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWPROPCELL$94); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowPropCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWPROPCELL$94);
    } 
  }
  
  public boolean getShowPropTip() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPROPTIP$96);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWPROPTIP$96); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowPropTip() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPROPTIP$96);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWPROPTIP$96); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowPropTip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWPROPTIP$96) != null);
    } 
  }
  
  public void setShowPropTip(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPROPTIP$96);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWPROPTIP$96); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowPropTip(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPROPTIP$96);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWPROPTIP$96); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowPropTip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWPROPTIP$96);
    } 
  }
  
  public boolean getShowPropAsCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPROPASCAPTION$98);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWPROPASCAPTION$98); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowPropAsCaption() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPROPASCAPTION$98);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWPROPASCAPTION$98); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowPropAsCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWPROPASCAPTION$98) != null);
    } 
  }
  
  public void setShowPropAsCaption(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPROPASCAPTION$98);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWPROPASCAPTION$98); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowPropAsCaption(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPROPASCAPTION$98);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWPROPASCAPTION$98); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowPropAsCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWPROPASCAPTION$98);
    } 
  }
  
  public boolean getDefaultAttributeDrillState() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTATTRIBUTEDRILLSTATE$100);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DEFAULTATTRIBUTEDRILLSTATE$100); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDefaultAttributeDrillState() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEFAULTATTRIBUTEDRILLSTATE$100);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DEFAULTATTRIBUTEDRILLSTATE$100); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDefaultAttributeDrillState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTATTRIBUTEDRILLSTATE$100) != null);
    } 
  }
  
  public void setDefaultAttributeDrillState(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTATTRIBUTEDRILLSTATE$100);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTATTRIBUTEDRILLSTATE$100); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDefaultAttributeDrillState(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEFAULTATTRIBUTEDRILLSTATE$100);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DEFAULTATTRIBUTEDRILLSTATE$100); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDefaultAttributeDrillState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTATTRIBUTEDRILLSTATE$100);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPivotFieldImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */