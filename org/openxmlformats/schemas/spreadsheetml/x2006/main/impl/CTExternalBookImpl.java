package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;

public class CTExternalBookImpl extends XmlComplexContentImpl implements CTExternalBook {
  private static final b SHEETNAMES$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetNames");
  
  private static final b DEFINEDNAMES$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedNames");
  
  private static final b SHEETDATASET$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetDataSet");
  
  private static final b ID$6 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  public CTExternalBookImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTExternalSheetNames getSheetNames() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetNames cTExternalSheetNames = null;
      cTExternalSheetNames = (CTExternalSheetNames)get_store().find_element_user(SHEETNAMES$0, 0);
      if (cTExternalSheetNames == null)
        return null; 
      return cTExternalSheetNames;
    } 
  }
  
  public boolean isSetSheetNames() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETNAMES$0) != 0);
    } 
  }
  
  public void setSheetNames(CTExternalSheetNames paramCTExternalSheetNames) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetNames cTExternalSheetNames = null;
      cTExternalSheetNames = (CTExternalSheetNames)get_store().find_element_user(SHEETNAMES$0, 0);
      if (cTExternalSheetNames == null)
        cTExternalSheetNames = (CTExternalSheetNames)get_store().add_element_user(SHEETNAMES$0); 
      cTExternalSheetNames.set((XmlObject)paramCTExternalSheetNames);
    } 
  }
  
  public CTExternalSheetNames addNewSheetNames() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetNames cTExternalSheetNames = null;
      cTExternalSheetNames = (CTExternalSheetNames)get_store().add_element_user(SHEETNAMES$0);
      return cTExternalSheetNames;
    } 
  }
  
  public void unsetSheetNames() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETNAMES$0, 0);
    } 
  }
  
  public CTExternalDefinedNames getDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalDefinedNames cTExternalDefinedNames = null;
      cTExternalDefinedNames = (CTExternalDefinedNames)get_store().find_element_user(DEFINEDNAMES$2, 0);
      if (cTExternalDefinedNames == null)
        return null; 
      return cTExternalDefinedNames;
    } 
  }
  
  public boolean isSetDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFINEDNAMES$2) != 0);
    } 
  }
  
  public void setDefinedNames(CTExternalDefinedNames paramCTExternalDefinedNames) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalDefinedNames cTExternalDefinedNames = null;
      cTExternalDefinedNames = (CTExternalDefinedNames)get_store().find_element_user(DEFINEDNAMES$2, 0);
      if (cTExternalDefinedNames == null)
        cTExternalDefinedNames = (CTExternalDefinedNames)get_store().add_element_user(DEFINEDNAMES$2); 
      cTExternalDefinedNames.set((XmlObject)paramCTExternalDefinedNames);
    } 
  }
  
  public CTExternalDefinedNames addNewDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalDefinedNames cTExternalDefinedNames = null;
      cTExternalDefinedNames = (CTExternalDefinedNames)get_store().add_element_user(DEFINEDNAMES$2);
      return cTExternalDefinedNames;
    } 
  }
  
  public void unsetDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFINEDNAMES$2, 0);
    } 
  }
  
  public CTExternalSheetDataSet getSheetDataSet() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetDataSet cTExternalSheetDataSet = null;
      cTExternalSheetDataSet = (CTExternalSheetDataSet)get_store().find_element_user(SHEETDATASET$4, 0);
      if (cTExternalSheetDataSet == null)
        return null; 
      return cTExternalSheetDataSet;
    } 
  }
  
  public boolean isSetSheetDataSet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHEETDATASET$4) != 0);
    } 
  }
  
  public void setSheetDataSet(CTExternalSheetDataSet paramCTExternalSheetDataSet) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetDataSet cTExternalSheetDataSet = null;
      cTExternalSheetDataSet = (CTExternalSheetDataSet)get_store().find_element_user(SHEETDATASET$4, 0);
      if (cTExternalSheetDataSet == null)
        cTExternalSheetDataSet = (CTExternalSheetDataSet)get_store().add_element_user(SHEETDATASET$4); 
      cTExternalSheetDataSet.set((XmlObject)paramCTExternalSheetDataSet);
    } 
  }
  
  public CTExternalSheetDataSet addNewSheetDataSet() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetDataSet cTExternalSheetDataSet = null;
      cTExternalSheetDataSet = (CTExternalSheetDataSet)get_store().add_element_user(SHEETDATASET$4);
      return cTExternalSheetDataSet;
    } 
  }
  
  public void unsetSheetDataSet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETDATASET$4, 0);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$6);
      return sTRelationshipId;
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$6);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID$6); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTExternalBookImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */