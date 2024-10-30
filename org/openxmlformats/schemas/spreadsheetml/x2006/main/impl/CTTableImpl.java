package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDxfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTableType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTTableImpl extends XmlComplexContentImpl implements CTTable {
  private static final b AUTOFILTER$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "autoFilter");
  
  private static final b SORTSTATE$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sortState");
  
  private static final b TABLECOLUMNS$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableColumns");
  
  private static final b TABLESTYLEINFO$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableStyleInfo");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b ID$10 = new b("", "id");
  
  private static final b NAME$12 = new b("", "name");
  
  private static final b DISPLAYNAME$14 = new b("", "displayName");
  
  private static final b COMMENT$16 = new b("", "comment");
  
  private static final b REF$18 = new b("", "ref");
  
  private static final b TABLETYPE$20 = new b("", "tableType");
  
  private static final b HEADERROWCOUNT$22 = new b("", "headerRowCount");
  
  private static final b INSERTROW$24 = new b("", "insertRow");
  
  private static final b INSERTROWSHIFT$26 = new b("", "insertRowShift");
  
  private static final b TOTALSROWCOUNT$28 = new b("", "totalsRowCount");
  
  private static final b TOTALSROWSHOWN$30 = new b("", "totalsRowShown");
  
  private static final b PUBLISHED$32 = new b("", "published");
  
  private static final b HEADERROWDXFID$34 = new b("", "headerRowDxfId");
  
  private static final b DATADXFID$36 = new b("", "dataDxfId");
  
  private static final b TOTALSROWDXFID$38 = new b("", "totalsRowDxfId");
  
  private static final b HEADERROWBORDERDXFID$40 = new b("", "headerRowBorderDxfId");
  
  private static final b TABLEBORDERDXFID$42 = new b("", "tableBorderDxfId");
  
  private static final b TOTALSROWBORDERDXFID$44 = new b("", "totalsRowBorderDxfId");
  
  private static final b HEADERROWCELLSTYLE$46 = new b("", "headerRowCellStyle");
  
  private static final b DATACELLSTYLE$48 = new b("", "dataCellStyle");
  
  private static final b TOTALSROWCELLSTYLE$50 = new b("", "totalsRowCellStyle");
  
  private static final b CONNECTIONID$52 = new b("", "connectionId");
  
  public CTTableImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTAutoFilter getAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoFilter cTAutoFilter = null;
      cTAutoFilter = (CTAutoFilter)get_store().find_element_user(AUTOFILTER$0, 0);
      if (cTAutoFilter == null)
        return null; 
      return cTAutoFilter;
    } 
  }
  
  public boolean isSetAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOFILTER$0) != 0);
    } 
  }
  
  public void setAutoFilter(CTAutoFilter paramCTAutoFilter) {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoFilter cTAutoFilter = null;
      cTAutoFilter = (CTAutoFilter)get_store().find_element_user(AUTOFILTER$0, 0);
      if (cTAutoFilter == null)
        cTAutoFilter = (CTAutoFilter)get_store().add_element_user(AUTOFILTER$0); 
      cTAutoFilter.set((XmlObject)paramCTAutoFilter);
    } 
  }
  
  public CTAutoFilter addNewAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      CTAutoFilter cTAutoFilter = null;
      cTAutoFilter = (CTAutoFilter)get_store().add_element_user(AUTOFILTER$0);
      return cTAutoFilter;
    } 
  }
  
  public void unsetAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOFILTER$0, 0);
    } 
  }
  
  public CTSortState getSortState() {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().find_element_user(SORTSTATE$2, 0);
      if (cTSortState == null)
        return null; 
      return cTSortState;
    } 
  }
  
  public boolean isSetSortState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SORTSTATE$2) != 0);
    } 
  }
  
  public void setSortState(CTSortState paramCTSortState) {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().find_element_user(SORTSTATE$2, 0);
      if (cTSortState == null)
        cTSortState = (CTSortState)get_store().add_element_user(SORTSTATE$2); 
      cTSortState.set((XmlObject)paramCTSortState);
    } 
  }
  
  public CTSortState addNewSortState() {
    synchronized (monitor()) {
      check_orphaned();
      CTSortState cTSortState = null;
      cTSortState = (CTSortState)get_store().add_element_user(SORTSTATE$2);
      return cTSortState;
    } 
  }
  
  public void unsetSortState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SORTSTATE$2, 0);
    } 
  }
  
  public CTTableColumns getTableColumns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableColumns cTTableColumns = null;
      cTTableColumns = (CTTableColumns)get_store().find_element_user(TABLECOLUMNS$4, 0);
      if (cTTableColumns == null)
        return null; 
      return cTTableColumns;
    } 
  }
  
  public void setTableColumns(CTTableColumns paramCTTableColumns) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableColumns cTTableColumns = null;
      cTTableColumns = (CTTableColumns)get_store().find_element_user(TABLECOLUMNS$4, 0);
      if (cTTableColumns == null)
        cTTableColumns = (CTTableColumns)get_store().add_element_user(TABLECOLUMNS$4); 
      cTTableColumns.set((XmlObject)paramCTTableColumns);
    } 
  }
  
  public CTTableColumns addNewTableColumns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableColumns cTTableColumns = null;
      cTTableColumns = (CTTableColumns)get_store().add_element_user(TABLECOLUMNS$4);
      return cTTableColumns;
    } 
  }
  
  public CTTableStyleInfo getTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleInfo cTTableStyleInfo = null;
      cTTableStyleInfo = (CTTableStyleInfo)get_store().find_element_user(TABLESTYLEINFO$6, 0);
      if (cTTableStyleInfo == null)
        return null; 
      return cTTableStyleInfo;
    } 
  }
  
  public boolean isSetTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABLESTYLEINFO$6) != 0);
    } 
  }
  
  public void setTableStyleInfo(CTTableStyleInfo paramCTTableStyleInfo) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleInfo cTTableStyleInfo = null;
      cTTableStyleInfo = (CTTableStyleInfo)get_store().find_element_user(TABLESTYLEINFO$6, 0);
      if (cTTableStyleInfo == null)
        cTTableStyleInfo = (CTTableStyleInfo)get_store().add_element_user(TABLESTYLEINFO$6); 
      cTTableStyleInfo.set((XmlObject)paramCTTableStyleInfo);
    } 
  }
  
  public CTTableStyleInfo addNewTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleInfo cTTableStyleInfo = null;
      cTTableStyleInfo = (CTTableStyleInfo)get_store().add_element_user(TABLESTYLEINFO$6);
      return cTTableStyleInfo;
    } 
  }
  
  public void unsetTableStyleInfo() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLESTYLEINFO$6, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
  
  public long getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$10);
      return xmlUnsignedInt;
    } 
  }
  
  public void setId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$10); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$12);
      return sTXstring;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$12) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$12);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$12); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$12);
    } 
  }
  
  public String getDisplayName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISPLAYNAME$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetDisplayName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DISPLAYNAME$14);
      return sTXstring;
    } 
  }
  
  public void setDisplayName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISPLAYNAME$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISPLAYNAME$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDisplayName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DISPLAYNAME$14);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(DISPLAYNAME$14); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public String getComment() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMMENT$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetComment() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(COMMENT$16);
      return sTXstring;
    } 
  }
  
  public boolean isSetComment() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COMMENT$16) != null);
    } 
  }
  
  public void setComment(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMMENT$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COMMENT$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetComment(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(COMMENT$16);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(COMMENT$16); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetComment() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COMMENT$16);
    } 
  }
  
  public String getRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRef xgetRef() {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$18);
      return sTRef;
    } 
  }
  
  public void setRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REF$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRef(STRef paramSTRef) {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$18);
      if (sTRef == null)
        sTRef = (STRef)get_store().add_attribute_user(REF$18); 
      sTRef.set((XmlObject)paramSTRef);
    } 
  }
  
  public STTableType.Enum getTableType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLETYPE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TABLETYPE$20); 
      if (simpleValue == null)
        return null; 
      return (STTableType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTableType xgetTableType() {
    synchronized (monitor()) {
      check_orphaned();
      STTableType sTTableType = null;
      sTTableType = (STTableType)get_store().find_attribute_user(TABLETYPE$20);
      if (sTTableType == null)
        sTTableType = (STTableType)get_default_attribute_value(TABLETYPE$20); 
      return sTTableType;
    } 
  }
  
  public boolean isSetTableType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TABLETYPE$20) != null);
    } 
  }
  
  public void setTableType(STTableType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLETYPE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TABLETYPE$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTableType(STTableType paramSTTableType) {
    synchronized (monitor()) {
      check_orphaned();
      STTableType sTTableType = null;
      sTTableType = (STTableType)get_store().find_attribute_user(TABLETYPE$20);
      if (sTTableType == null)
        sTTableType = (STTableType)get_store().add_attribute_user(TABLETYPE$20); 
      sTTableType.set((XmlObject)paramSTTableType);
    } 
  }
  
  public void unsetTableType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TABLETYPE$20);
    } 
  }
  
  public long getHeaderRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWCOUNT$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HEADERROWCOUNT$22); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetHeaderRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(HEADERROWCOUNT$22);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(HEADERROWCOUNT$22); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetHeaderRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HEADERROWCOUNT$22) != null);
    } 
  }
  
  public void setHeaderRowCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWCOUNT$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADERROWCOUNT$22); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetHeaderRowCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(HEADERROWCOUNT$22);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(HEADERROWCOUNT$22); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetHeaderRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HEADERROWCOUNT$22);
    } 
  }
  
  public boolean getInsertRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTROW$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSERTROW$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInsertRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTROW$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INSERTROW$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInsertRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSERTROW$24) != null);
    } 
  }
  
  public void setInsertRow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTROW$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSERTROW$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInsertRow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTROW$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INSERTROW$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInsertRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSERTROW$24);
    } 
  }
  
  public boolean getInsertRowShift() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTROWSHIFT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSERTROWSHIFT$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInsertRowShift() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTROWSHIFT$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INSERTROWSHIFT$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInsertRowShift() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSERTROWSHIFT$26) != null);
    } 
  }
  
  public void setInsertRowShift(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTROWSHIFT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSERTROWSHIFT$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInsertRowShift(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTROWSHIFT$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INSERTROWSHIFT$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInsertRowShift() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSERTROWSHIFT$26);
    } 
  }
  
  public long getTotalsRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWCOUNT$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TOTALSROWCOUNT$28); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetTotalsRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TOTALSROWCOUNT$28);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(TOTALSROWCOUNT$28); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetTotalsRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWCOUNT$28) != null);
    } 
  }
  
  public void setTotalsRowCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWCOUNT$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWCOUNT$28); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTotalsRowCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TOTALSROWCOUNT$28);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(TOTALSROWCOUNT$28); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetTotalsRowCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWCOUNT$28);
    } 
  }
  
  public boolean getTotalsRowShown() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWSHOWN$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TOTALSROWSHOWN$30); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTotalsRowShown() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TOTALSROWSHOWN$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TOTALSROWSHOWN$30); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTotalsRowShown() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWSHOWN$30) != null);
    } 
  }
  
  public void setTotalsRowShown(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWSHOWN$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWSHOWN$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTotalsRowShown(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TOTALSROWSHOWN$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TOTALSROWSHOWN$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTotalsRowShown() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWSHOWN$30);
    } 
  }
  
  public boolean getPublished() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHED$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PUBLISHED$32); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHED$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PUBLISHED$32); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PUBLISHED$32) != null);
    } 
  }
  
  public void setPublished(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHED$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PUBLISHED$32); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPublished(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHED$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PUBLISHED$32); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPublished() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PUBLISHED$32);
    } 
  }
  
  public long getHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWDXFID$34);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(HEADERROWDXFID$34);
      return sTDxfId;
    } 
  }
  
  public boolean isSetHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HEADERROWDXFID$34) != null);
    } 
  }
  
  public void setHeaderRowDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWDXFID$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADERROWDXFID$34); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetHeaderRowDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(HEADERROWDXFID$34);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(HEADERROWDXFID$34); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HEADERROWDXFID$34);
    } 
  }
  
  public long getDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATADXFID$36);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(DATADXFID$36);
      return sTDxfId;
    } 
  }
  
  public boolean isSetDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATADXFID$36) != null);
    } 
  }
  
  public void setDataDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATADXFID$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATADXFID$36); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDataDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(DATADXFID$36);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(DATADXFID$36); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATADXFID$36);
    } 
  }
  
  public long getTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWDXFID$38);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TOTALSROWDXFID$38);
      return sTDxfId;
    } 
  }
  
  public boolean isSetTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWDXFID$38) != null);
    } 
  }
  
  public void setTotalsRowDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWDXFID$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWDXFID$38); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTotalsRowDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TOTALSROWDXFID$38);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(TOTALSROWDXFID$38); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWDXFID$38);
    } 
  }
  
  public long getHeaderRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWBORDERDXFID$40);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetHeaderRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(HEADERROWBORDERDXFID$40);
      return sTDxfId;
    } 
  }
  
  public boolean isSetHeaderRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HEADERROWBORDERDXFID$40) != null);
    } 
  }
  
  public void setHeaderRowBorderDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWBORDERDXFID$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADERROWBORDERDXFID$40); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetHeaderRowBorderDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(HEADERROWBORDERDXFID$40);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(HEADERROWBORDERDXFID$40); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetHeaderRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HEADERROWBORDERDXFID$40);
    } 
  }
  
  public long getTableBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLEBORDERDXFID$42);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetTableBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TABLEBORDERDXFID$42);
      return sTDxfId;
    } 
  }
  
  public boolean isSetTableBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TABLEBORDERDXFID$42) != null);
    } 
  }
  
  public void setTableBorderDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLEBORDERDXFID$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TABLEBORDERDXFID$42); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTableBorderDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TABLEBORDERDXFID$42);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(TABLEBORDERDXFID$42); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetTableBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TABLEBORDERDXFID$42);
    } 
  }
  
  public long getTotalsRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWBORDERDXFID$44);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetTotalsRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TOTALSROWBORDERDXFID$44);
      return sTDxfId;
    } 
  }
  
  public boolean isSetTotalsRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWBORDERDXFID$44) != null);
    } 
  }
  
  public void setTotalsRowBorderDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWBORDERDXFID$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWBORDERDXFID$44); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTotalsRowBorderDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TOTALSROWBORDERDXFID$44);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(TOTALSROWBORDERDXFID$44); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetTotalsRowBorderDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWBORDERDXFID$44);
    } 
  }
  
  public String getHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWCELLSTYLE$46);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(HEADERROWCELLSTYLE$46);
      return sTXstring;
    } 
  }
  
  public boolean isSetHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HEADERROWCELLSTYLE$46) != null);
    } 
  }
  
  public void setHeaderRowCellStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWCELLSTYLE$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADERROWCELLSTYLE$46); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHeaderRowCellStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(HEADERROWCELLSTYLE$46);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(HEADERROWCELLSTYLE$46); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HEADERROWCELLSTYLE$46);
    } 
  }
  
  public String getDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATACELLSTYLE$48);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DATACELLSTYLE$48);
      return sTXstring;
    } 
  }
  
  public boolean isSetDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATACELLSTYLE$48) != null);
    } 
  }
  
  public void setDataCellStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATACELLSTYLE$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATACELLSTYLE$48); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDataCellStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DATACELLSTYLE$48);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(DATACELLSTYLE$48); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATACELLSTYLE$48);
    } 
  }
  
  public String getTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWCELLSTYLE$50);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOTALSROWCELLSTYLE$50);
      return sTXstring;
    } 
  }
  
  public boolean isSetTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWCELLSTYLE$50) != null);
    } 
  }
  
  public void setTotalsRowCellStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWCELLSTYLE$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWCELLSTYLE$50); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTotalsRowCellStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOTALSROWCELLSTYLE$50);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(TOTALSROWCELLSTYLE$50); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWCELLSTYLE$50);
    } 
  }
  
  public long getConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTIONID$52);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONNECTIONID$52);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONNECTIONID$52) != null);
    } 
  }
  
  public void setConnectionId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTIONID$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONNECTIONID$52); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetConnectionId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONNECTIONID$52);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CONNECTIONID$52); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONNECTIONID$52);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTTableImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */