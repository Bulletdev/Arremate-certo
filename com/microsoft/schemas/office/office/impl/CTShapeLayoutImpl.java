package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.CTIdMap;
import com.microsoft.schemas.office.office.CTRegroupTable;
import com.microsoft.schemas.office.office.CTRules;
import com.microsoft.schemas.office.office.CTShapeLayout;
import com.microsoft.schemas.vml.STExt;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTShapeLayoutImpl extends XmlComplexContentImpl implements CTShapeLayout {
  private static final b IDMAP$0 = new b("urn:schemas-microsoft-com:office:office", "idmap");
  
  private static final b REGROUPTABLE$2 = new b("urn:schemas-microsoft-com:office:office", "regrouptable");
  
  private static final b RULES$4 = new b("urn:schemas-microsoft-com:office:office", "rules");
  
  private static final b EXT$6 = new b("urn:schemas-microsoft-com:vml", "ext");
  
  public CTShapeLayoutImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTIdMap getIdmap() {
    synchronized (monitor()) {
      check_orphaned();
      CTIdMap cTIdMap = null;
      cTIdMap = (CTIdMap)get_store().find_element_user(IDMAP$0, 0);
      if (cTIdMap == null)
        return null; 
      return cTIdMap;
    } 
  }
  
  public boolean isSetIdmap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(IDMAP$0) != 0);
    } 
  }
  
  public void setIdmap(CTIdMap paramCTIdMap) {
    synchronized (monitor()) {
      check_orphaned();
      CTIdMap cTIdMap = null;
      cTIdMap = (CTIdMap)get_store().find_element_user(IDMAP$0, 0);
      if (cTIdMap == null)
        cTIdMap = (CTIdMap)get_store().add_element_user(IDMAP$0); 
      cTIdMap.set((XmlObject)paramCTIdMap);
    } 
  }
  
  public CTIdMap addNewIdmap() {
    synchronized (monitor()) {
      check_orphaned();
      CTIdMap cTIdMap = null;
      cTIdMap = (CTIdMap)get_store().add_element_user(IDMAP$0);
      return cTIdMap;
    } 
  }
  
  public void unsetIdmap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IDMAP$0, 0);
    } 
  }
  
  public CTRegroupTable getRegrouptable() {
    synchronized (monitor()) {
      check_orphaned();
      CTRegroupTable cTRegroupTable = null;
      cTRegroupTable = (CTRegroupTable)get_store().find_element_user(REGROUPTABLE$2, 0);
      if (cTRegroupTable == null)
        return null; 
      return cTRegroupTable;
    } 
  }
  
  public boolean isSetRegrouptable() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(REGROUPTABLE$2) != 0);
    } 
  }
  
  public void setRegrouptable(CTRegroupTable paramCTRegroupTable) {
    synchronized (monitor()) {
      check_orphaned();
      CTRegroupTable cTRegroupTable = null;
      cTRegroupTable = (CTRegroupTable)get_store().find_element_user(REGROUPTABLE$2, 0);
      if (cTRegroupTable == null)
        cTRegroupTable = (CTRegroupTable)get_store().add_element_user(REGROUPTABLE$2); 
      cTRegroupTable.set((XmlObject)paramCTRegroupTable);
    } 
  }
  
  public CTRegroupTable addNewRegrouptable() {
    synchronized (monitor()) {
      check_orphaned();
      CTRegroupTable cTRegroupTable = null;
      cTRegroupTable = (CTRegroupTable)get_store().add_element_user(REGROUPTABLE$2);
      return cTRegroupTable;
    } 
  }
  
  public void unsetRegrouptable() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REGROUPTABLE$2, 0);
    } 
  }
  
  public CTRules getRules() {
    synchronized (monitor()) {
      check_orphaned();
      CTRules cTRules = null;
      cTRules = (CTRules)get_store().find_element_user(RULES$4, 0);
      if (cTRules == null)
        return null; 
      return cTRules;
    } 
  }
  
  public boolean isSetRules() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RULES$4) != 0);
    } 
  }
  
  public void setRules(CTRules paramCTRules) {
    synchronized (monitor()) {
      check_orphaned();
      CTRules cTRules = null;
      cTRules = (CTRules)get_store().find_element_user(RULES$4, 0);
      if (cTRules == null)
        cTRules = (CTRules)get_store().add_element_user(RULES$4); 
      cTRules.set((XmlObject)paramCTRules);
    } 
  }
  
  public CTRules addNewRules() {
    synchronized (monitor()) {
      check_orphaned();
      CTRules cTRules = null;
      cTRules = (CTRules)get_store().add_element_user(RULES$4);
      return cTRules;
    } 
  }
  
  public void unsetRules() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RULES$4, 0);
    } 
  }
  
  public STExt.Enum getExt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXT$6);
      if (simpleValue == null)
        return null; 
      return (STExt.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STExt xgetExt() {
    synchronized (monitor()) {
      check_orphaned();
      STExt sTExt = null;
      sTExt = (STExt)get_store().find_attribute_user(EXT$6);
      return sTExt;
    } 
  }
  
  public boolean isSetExt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EXT$6) != null);
    } 
  }
  
  public void setExt(STExt.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EXT$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetExt(STExt paramSTExt) {
    synchronized (monitor()) {
      check_orphaned();
      STExt sTExt = null;
      sTExt = (STExt)get_store().find_attribute_user(EXT$6);
      if (sTExt == null)
        sTExt = (STExt)get_store().add_attribute_user(EXT$6); 
      sTExt.set((XmlObject)paramSTExt);
    } 
  }
  
  public void unsetExt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EXT$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\office\impl\CTShapeLayoutImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */