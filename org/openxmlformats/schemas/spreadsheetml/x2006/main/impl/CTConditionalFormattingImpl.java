package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSqref;

public class CTConditionalFormattingImpl extends XmlComplexContentImpl implements CTConditionalFormatting {
  private static final b CFRULE$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfRule");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b PIVOT$4 = new b("", "pivot");
  
  private static final b SQREF$6 = new b("", "sqref");
  
  public CTConditionalFormattingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCfRule> getCfRuleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCfRule>)new CfRuleList(this);
    } 
  }
  
  public CTCfRule[] getCfRuleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CFRULE$0, arrayList);
      CTCfRule[] arrayOfCTCfRule = new CTCfRule[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCfRule);
      return arrayOfCTCfRule;
    } 
  }
  
  public CTCfRule getCfRuleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfRule cTCfRule = null;
      cTCfRule = (CTCfRule)get_store().find_element_user(CFRULE$0, paramInt);
      if (cTCfRule == null)
        throw new IndexOutOfBoundsException(); 
      return cTCfRule;
    } 
  }
  
  public int sizeOfCfRuleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CFRULE$0);
    } 
  }
  
  public void setCfRuleArray(CTCfRule[] paramArrayOfCTCfRule) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCfRule, CFRULE$0);
    } 
  }
  
  public void setCfRuleArray(int paramInt, CTCfRule paramCTCfRule) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfRule cTCfRule = null;
      cTCfRule = (CTCfRule)get_store().find_element_user(CFRULE$0, paramInt);
      if (cTCfRule == null)
        throw new IndexOutOfBoundsException(); 
      cTCfRule.set((XmlObject)paramCTCfRule);
    } 
  }
  
  public CTCfRule insertNewCfRule(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfRule cTCfRule = null;
      cTCfRule = (CTCfRule)get_store().insert_element_user(CFRULE$0, paramInt);
      return cTCfRule;
    } 
  }
  
  public CTCfRule addNewCfRule() {
    synchronized (monitor()) {
      check_orphaned();
      CTCfRule cTCfRule = null;
      cTCfRule = (CTCfRule)get_store().add_element_user(CFRULE$0);
      return cTCfRule;
    } 
  }
  
  public void removeCfRule(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CFRULE$0, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
  
  public boolean getPivot() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PIVOT$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPivot() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PIVOT$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PIVOT$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPivot() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PIVOT$4) != null);
    } 
  }
  
  public void setPivot(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PIVOT$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPivot(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PIVOT$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PIVOT$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPivot() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PIVOT$4);
    } 
  }
  
  public List getSqref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getListValue();
    } 
  }
  
  public STSqref xgetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$6);
      return sTSqref;
    } 
  }
  
  public boolean isSetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SQREF$6) != null);
    } 
  }
  
  public void setSqref(List paramList) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SQREF$6); 
      simpleValue.setListValue(paramList);
    } 
  }
  
  public void xsetSqref(STSqref paramSTSqref) {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$6);
      if (sTSqref == null)
        sTSqref = (STSqref)get_store().add_attribute_user(SQREF$6); 
      sTSqref.set((XmlObject)paramSTSqref);
    } 
  }
  
  public void unsetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SQREF$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTConditionalFormattingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */