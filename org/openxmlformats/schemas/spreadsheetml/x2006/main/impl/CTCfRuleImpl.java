package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDxfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTimePeriod;

public class CTCfRuleImpl extends XmlComplexContentImpl implements CTCfRule {
  private static final b FORMULA$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formula");
  
  private static final b COLORSCALE$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colorScale");
  
  private static final b DATABAR$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataBar");
  
  private static final b ICONSET$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "iconSet");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b TYPE$10 = new b("", "type");
  
  private static final b DXFID$12 = new b("", "dxfId");
  
  private static final b PRIORITY$14 = new b("", "priority");
  
  private static final b STOPIFTRUE$16 = new b("", "stopIfTrue");
  
  private static final b ABOVEAVERAGE$18 = new b("", "aboveAverage");
  
  private static final b PERCENT$20 = new b("", "percent");
  
  private static final b BOTTOM$22 = new b("", "bottom");
  
  private static final b OPERATOR$24 = new b("", "operator");
  
  private static final b TEXT$26 = new b("", "text");
  
  private static final b TIMEPERIOD$28 = new b("", "timePeriod");
  
  private static final b RANK$30 = new b("", "rank");
  
  private static final b STDDEV$32 = new b("", "stdDev");
  
  private static final b EQUALAVERAGE$34 = new b("", "equalAverage");
  
  public CTCfRuleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<String> getFormulaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new FormulaList(this);
    } 
  }
  
  public String[] getFormulaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FORMULA$0, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getFormulaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMULA$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<STFormula> xgetFormulaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STFormula>)new FormulaList(this);
    } 
  }
  
  public STFormula[] xgetFormulaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FORMULA$0, arrayList);
      STFormula[] arrayOfSTFormula = new STFormula[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTFormula);
      return arrayOfSTFormula;
    } 
  }
  
  public STFormula xgetFormulaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().find_element_user(FORMULA$0, paramInt);
      if (sTFormula == null)
        throw new IndexOutOfBoundsException(); 
      return sTFormula;
    } 
  }
  
  public int sizeOfFormulaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FORMULA$0);
    } 
  }
  
  public void setFormulaArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, FORMULA$0);
    } 
  }
  
  public void setFormulaArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMULA$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormulaArray(STFormula[] paramArrayOfSTFormula) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTFormula, FORMULA$0);
    } 
  }
  
  public void xsetFormulaArray(int paramInt, STFormula paramSTFormula) {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().find_element_user(FORMULA$0, paramInt);
      if (sTFormula == null)
        throw new IndexOutOfBoundsException(); 
      sTFormula.set((XmlObject)paramSTFormula);
    } 
  }
  
  public void insertFormula(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FORMULA$0, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addFormula(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FORMULA$0);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public STFormula insertNewFormula(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().insert_element_user(FORMULA$0, paramInt);
      return sTFormula;
    } 
  }
  
  public STFormula addNewFormula() {
    synchronized (monitor()) {
      check_orphaned();
      STFormula sTFormula = null;
      sTFormula = (STFormula)get_store().add_element_user(FORMULA$0);
      return sTFormula;
    } 
  }
  
  public void removeFormula(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMULA$0, paramInt);
    } 
  }
  
  public CTColorScale getColorScale() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorScale cTColorScale = null;
      cTColorScale = (CTColorScale)get_store().find_element_user(COLORSCALE$2, 0);
      if (cTColorScale == null)
        return null; 
      return cTColorScale;
    } 
  }
  
  public boolean isSetColorScale() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLORSCALE$2) != 0);
    } 
  }
  
  public void setColorScale(CTColorScale paramCTColorScale) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorScale cTColorScale = null;
      cTColorScale = (CTColorScale)get_store().find_element_user(COLORSCALE$2, 0);
      if (cTColorScale == null)
        cTColorScale = (CTColorScale)get_store().add_element_user(COLORSCALE$2); 
      cTColorScale.set((XmlObject)paramCTColorScale);
    } 
  }
  
  public CTColorScale addNewColorScale() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorScale cTColorScale = null;
      cTColorScale = (CTColorScale)get_store().add_element_user(COLORSCALE$2);
      return cTColorScale;
    } 
  }
  
  public void unsetColorScale() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLORSCALE$2, 0);
    } 
  }
  
  public CTDataBar getDataBar() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBar cTDataBar = null;
      cTDataBar = (CTDataBar)get_store().find_element_user(DATABAR$4, 0);
      if (cTDataBar == null)
        return null; 
      return cTDataBar;
    } 
  }
  
  public boolean isSetDataBar() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATABAR$4) != 0);
    } 
  }
  
  public void setDataBar(CTDataBar paramCTDataBar) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBar cTDataBar = null;
      cTDataBar = (CTDataBar)get_store().find_element_user(DATABAR$4, 0);
      if (cTDataBar == null)
        cTDataBar = (CTDataBar)get_store().add_element_user(DATABAR$4); 
      cTDataBar.set((XmlObject)paramCTDataBar);
    } 
  }
  
  public CTDataBar addNewDataBar() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBar cTDataBar = null;
      cTDataBar = (CTDataBar)get_store().add_element_user(DATABAR$4);
      return cTDataBar;
    } 
  }
  
  public void unsetDataBar() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATABAR$4, 0);
    } 
  }
  
  public CTIconSet getIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      CTIconSet cTIconSet = null;
      cTIconSet = (CTIconSet)get_store().find_element_user(ICONSET$6, 0);
      if (cTIconSet == null)
        return null; 
      return cTIconSet;
    } 
  }
  
  public boolean isSetIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ICONSET$6) != 0);
    } 
  }
  
  public void setIconSet(CTIconSet paramCTIconSet) {
    synchronized (monitor()) {
      check_orphaned();
      CTIconSet cTIconSet = null;
      cTIconSet = (CTIconSet)get_store().find_element_user(ICONSET$6, 0);
      if (cTIconSet == null)
        cTIconSet = (CTIconSet)get_store().add_element_user(ICONSET$6); 
      cTIconSet.set((XmlObject)paramCTIconSet);
    } 
  }
  
  public CTIconSet addNewIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      CTIconSet cTIconSet = null;
      cTIconSet = (CTIconSet)get_store().add_element_user(ICONSET$6);
      return cTIconSet;
    } 
  }
  
  public void unsetIconSet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ICONSET$6, 0);
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
  
  public STCfType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$10);
      if (simpleValue == null)
        return null; 
      return (STCfType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCfType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STCfType sTCfType = null;
      sTCfType = (STCfType)get_store().find_attribute_user(TYPE$10);
      return sTCfType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$10) != null);
    } 
  }
  
  public void setType(STCfType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STCfType paramSTCfType) {
    synchronized (monitor()) {
      check_orphaned();
      STCfType sTCfType = null;
      sTCfType = (STCfType)get_store().find_attribute_user(TYPE$10);
      if (sTCfType == null)
        sTCfType = (STCfType)get_store().add_attribute_user(TYPE$10); 
      sTCfType.set((XmlObject)paramSTCfType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$10);
    } 
  }
  
  public long getDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DXFID$12);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(DXFID$12);
      return sTDxfId;
    } 
  }
  
  public boolean isSetDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DXFID$12) != null);
    } 
  }
  
  public void setDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DXFID$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DXFID$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(DXFID$12);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(DXFID$12); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DXFID$12);
    } 
  }
  
  public int getPriority() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRIORITY$14);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetPriority() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(PRIORITY$14);
      return xmlInt;
    } 
  }
  
  public void setPriority(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRIORITY$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRIORITY$14); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetPriority(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(PRIORITY$14);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(PRIORITY$14); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public boolean getStopIfTrue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STOPIFTRUE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STOPIFTRUE$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetStopIfTrue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STOPIFTRUE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(STOPIFTRUE$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetStopIfTrue() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STOPIFTRUE$16) != null);
    } 
  }
  
  public void setStopIfTrue(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STOPIFTRUE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STOPIFTRUE$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetStopIfTrue(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(STOPIFTRUE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(STOPIFTRUE$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetStopIfTrue() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STOPIFTRUE$16);
    } 
  }
  
  public boolean getAboveAverage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ABOVEAVERAGE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ABOVEAVERAGE$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAboveAverage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ABOVEAVERAGE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ABOVEAVERAGE$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAboveAverage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ABOVEAVERAGE$18) != null);
    } 
  }
  
  public void setAboveAverage(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ABOVEAVERAGE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ABOVEAVERAGE$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAboveAverage(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ABOVEAVERAGE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ABOVEAVERAGE$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAboveAverage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ABOVEAVERAGE$18);
    } 
  }
  
  public boolean getPercent() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PERCENT$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PERCENT$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPercent() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PERCENT$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PERCENT$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPercent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PERCENT$20) != null);
    } 
  }
  
  public void setPercent(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PERCENT$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PERCENT$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPercent(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PERCENT$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PERCENT$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPercent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PERCENT$20);
    } 
  }
  
  public boolean getBottom() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BOTTOM$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BOTTOM$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BOTTOM$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BOTTOM$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BOTTOM$22) != null);
    } 
  }
  
  public void setBottom(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BOTTOM$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BOTTOM$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBottom(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BOTTOM$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BOTTOM$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BOTTOM$22);
    } 
  }
  
  public STConditionalFormattingOperator.Enum getOperator() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPERATOR$24);
      if (simpleValue == null)
        return null; 
      return (STConditionalFormattingOperator.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STConditionalFormattingOperator xgetOperator() {
    synchronized (monitor()) {
      check_orphaned();
      STConditionalFormattingOperator sTConditionalFormattingOperator = null;
      sTConditionalFormattingOperator = (STConditionalFormattingOperator)get_store().find_attribute_user(OPERATOR$24);
      return sTConditionalFormattingOperator;
    } 
  }
  
  public boolean isSetOperator() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OPERATOR$24) != null);
    } 
  }
  
  public void setOperator(STConditionalFormattingOperator.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPERATOR$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OPERATOR$24); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOperator(STConditionalFormattingOperator paramSTConditionalFormattingOperator) {
    synchronized (monitor()) {
      check_orphaned();
      STConditionalFormattingOperator sTConditionalFormattingOperator = null;
      sTConditionalFormattingOperator = (STConditionalFormattingOperator)get_store().find_attribute_user(OPERATOR$24);
      if (sTConditionalFormattingOperator == null)
        sTConditionalFormattingOperator = (STConditionalFormattingOperator)get_store().add_attribute_user(OPERATOR$24); 
      sTConditionalFormattingOperator.set((XmlObject)paramSTConditionalFormattingOperator);
    } 
  }
  
  public void unsetOperator() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OPERATOR$24);
    } 
  }
  
  public String getText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXT$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetText() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TEXT$26);
      return xmlString;
    } 
  }
  
  public boolean isSetText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TEXT$26) != null);
    } 
  }
  
  public void setText(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TEXT$26); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetText(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TEXT$26);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TEXT$26); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TEXT$26);
    } 
  }
  
  public STTimePeriod.Enum getTimePeriod() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TIMEPERIOD$28);
      if (simpleValue == null)
        return null; 
      return (STTimePeriod.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTimePeriod xgetTimePeriod() {
    synchronized (monitor()) {
      check_orphaned();
      STTimePeriod sTTimePeriod = null;
      sTTimePeriod = (STTimePeriod)get_store().find_attribute_user(TIMEPERIOD$28);
      return sTTimePeriod;
    } 
  }
  
  public boolean isSetTimePeriod() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TIMEPERIOD$28) != null);
    } 
  }
  
  public void setTimePeriod(STTimePeriod.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TIMEPERIOD$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TIMEPERIOD$28); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTimePeriod(STTimePeriod paramSTTimePeriod) {
    synchronized (monitor()) {
      check_orphaned();
      STTimePeriod sTTimePeriod = null;
      sTTimePeriod = (STTimePeriod)get_store().find_attribute_user(TIMEPERIOD$28);
      if (sTTimePeriod == null)
        sTTimePeriod = (STTimePeriod)get_store().add_attribute_user(TIMEPERIOD$28); 
      sTTimePeriod.set((XmlObject)paramSTTimePeriod);
    } 
  }
  
  public void unsetTimePeriod() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TIMEPERIOD$28);
    } 
  }
  
  public long getRank() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RANK$30);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetRank() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RANK$30);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetRank() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RANK$30) != null);
    } 
  }
  
  public void setRank(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RANK$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RANK$30); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetRank(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RANK$30);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(RANK$30); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetRank() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RANK$30);
    } 
  }
  
  public int getStdDev() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STDDEV$32);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetStdDev() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(STDDEV$32);
      return xmlInt;
    } 
  }
  
  public boolean isSetStdDev() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STDDEV$32) != null);
    } 
  }
  
  public void setStdDev(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STDDEV$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STDDEV$32); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetStdDev(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(STDDEV$32);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(STDDEV$32); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetStdDev() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STDDEV$32);
    } 
  }
  
  public boolean getEqualAverage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EQUALAVERAGE$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(EQUALAVERAGE$34); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEqualAverage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EQUALAVERAGE$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(EQUALAVERAGE$34); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEqualAverage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EQUALAVERAGE$34) != null);
    } 
  }
  
  public void setEqualAverage(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EQUALAVERAGE$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EQUALAVERAGE$34); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEqualAverage(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EQUALAVERAGE$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(EQUALAVERAGE$34); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEqualAverage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EQUALAVERAGE$34);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCfRuleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */