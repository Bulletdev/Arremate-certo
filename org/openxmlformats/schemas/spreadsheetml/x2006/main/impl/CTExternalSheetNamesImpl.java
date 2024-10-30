package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;

public class CTExternalSheetNamesImpl extends XmlComplexContentImpl implements CTExternalSheetNames {
  private static final b SHEETNAME$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetName");
  
  public CTExternalSheetNamesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTExternalSheetName> getSheetNameList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTExternalSheetName>)new SheetNameList(this);
    } 
  }
  
  public CTExternalSheetName[] getSheetNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHEETNAME$0, arrayList);
      CTExternalSheetName[] arrayOfCTExternalSheetName = new CTExternalSheetName[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTExternalSheetName);
      return arrayOfCTExternalSheetName;
    } 
  }
  
  public CTExternalSheetName getSheetNameArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetName cTExternalSheetName = null;
      cTExternalSheetName = (CTExternalSheetName)get_store().find_element_user(SHEETNAME$0, paramInt);
      if (cTExternalSheetName == null)
        throw new IndexOutOfBoundsException(); 
      return cTExternalSheetName;
    } 
  }
  
  public int sizeOfSheetNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHEETNAME$0);
    } 
  }
  
  public void setSheetNameArray(CTExternalSheetName[] paramArrayOfCTExternalSheetName) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTExternalSheetName, SHEETNAME$0);
    } 
  }
  
  public void setSheetNameArray(int paramInt, CTExternalSheetName paramCTExternalSheetName) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetName cTExternalSheetName = null;
      cTExternalSheetName = (CTExternalSheetName)get_store().find_element_user(SHEETNAME$0, paramInt);
      if (cTExternalSheetName == null)
        throw new IndexOutOfBoundsException(); 
      cTExternalSheetName.set((XmlObject)paramCTExternalSheetName);
    } 
  }
  
  public CTExternalSheetName insertNewSheetName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetName cTExternalSheetName = null;
      cTExternalSheetName = (CTExternalSheetName)get_store().insert_element_user(SHEETNAME$0, paramInt);
      return cTExternalSheetName;
    } 
  }
  
  public CTExternalSheetName addNewSheetName() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalSheetName cTExternalSheetName = null;
      cTExternalSheetName = (CTExternalSheetName)get_store().add_element_user(SHEETNAME$0);
      return cTExternalSheetName;
    } 
  }
  
  public void removeSheetName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHEETNAME$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTExternalSheetNamesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */