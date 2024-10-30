package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConsolidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

public class CTCacheSourceImpl extends XmlComplexContentImpl implements CTCacheSource {
  private static final b WORKSHEETSOURCE$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "worksheetSource");
  
  private static final b CONSOLIDATION$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "consolidation");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b TYPE$6 = new b("", "type");
  
  private static final b CONNECTIONID$8 = new b("", "connectionId");
  
  public CTCacheSourceImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTWorksheetSource getWorksheetSource() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorksheetSource cTWorksheetSource = null;
      cTWorksheetSource = (CTWorksheetSource)get_store().find_element_user(WORKSHEETSOURCE$0, 0);
      if (cTWorksheetSource == null)
        return null; 
      return cTWorksheetSource;
    } 
  }
  
  public boolean isSetWorksheetSource() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WORKSHEETSOURCE$0) != 0);
    } 
  }
  
  public void setWorksheetSource(CTWorksheetSource paramCTWorksheetSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTWorksheetSource cTWorksheetSource = null;
      cTWorksheetSource = (CTWorksheetSource)get_store().find_element_user(WORKSHEETSOURCE$0, 0);
      if (cTWorksheetSource == null)
        cTWorksheetSource = (CTWorksheetSource)get_store().add_element_user(WORKSHEETSOURCE$0); 
      cTWorksheetSource.set((XmlObject)paramCTWorksheetSource);
    } 
  }
  
  public CTWorksheetSource addNewWorksheetSource() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorksheetSource cTWorksheetSource = null;
      cTWorksheetSource = (CTWorksheetSource)get_store().add_element_user(WORKSHEETSOURCE$0);
      return cTWorksheetSource;
    } 
  }
  
  public void unsetWorksheetSource() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WORKSHEETSOURCE$0, 0);
    } 
  }
  
  public CTConsolidation getConsolidation() {
    synchronized (monitor()) {
      check_orphaned();
      CTConsolidation cTConsolidation = null;
      cTConsolidation = (CTConsolidation)get_store().find_element_user(CONSOLIDATION$2, 0);
      if (cTConsolidation == null)
        return null; 
      return cTConsolidation;
    } 
  }
  
  public boolean isSetConsolidation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONSOLIDATION$2) != 0);
    } 
  }
  
  public void setConsolidation(CTConsolidation paramCTConsolidation) {
    synchronized (monitor()) {
      check_orphaned();
      CTConsolidation cTConsolidation = null;
      cTConsolidation = (CTConsolidation)get_store().find_element_user(CONSOLIDATION$2, 0);
      if (cTConsolidation == null)
        cTConsolidation = (CTConsolidation)get_store().add_element_user(CONSOLIDATION$2); 
      cTConsolidation.set((XmlObject)paramCTConsolidation);
    } 
  }
  
  public CTConsolidation addNewConsolidation() {
    synchronized (monitor()) {
      check_orphaned();
      CTConsolidation cTConsolidation = null;
      cTConsolidation = (CTConsolidation)get_store().add_element_user(CONSOLIDATION$2);
      return cTConsolidation;
    } 
  }
  
  public void unsetConsolidation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONSOLIDATION$2, 0);
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
  
  public STSourceType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$6);
      if (simpleValue == null)
        return null; 
      return (STSourceType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STSourceType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STSourceType sTSourceType = null;
      sTSourceType = (STSourceType)get_store().find_attribute_user(TYPE$6);
      return sTSourceType;
    } 
  }
  
  public void setType(STSourceType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STSourceType paramSTSourceType) {
    synchronized (monitor()) {
      check_orphaned();
      STSourceType sTSourceType = null;
      sTSourceType = (STSourceType)get_store().find_attribute_user(TYPE$6);
      if (sTSourceType == null)
        sTSourceType = (STSourceType)get_store().add_attribute_user(TYPE$6); 
      sTSourceType.set((XmlObject)paramSTSourceType);
    } 
  }
  
  public long getConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTIONID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONNECTIONID$8); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONNECTIONID$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(CONNECTIONID$8); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONNECTIONID$8) != null);
    } 
  }
  
  public void setConnectionId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTIONID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONNECTIONID$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetConnectionId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONNECTIONID$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CONNECTIONID$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONNECTIONID$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCacheSourceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */