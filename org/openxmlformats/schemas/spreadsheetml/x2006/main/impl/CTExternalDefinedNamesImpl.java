package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames;

public class CTExternalDefinedNamesImpl extends XmlComplexContentImpl implements CTExternalDefinedNames {
  private static final b DEFINEDNAME$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedName");
  
  public CTExternalDefinedNamesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTExternalDefinedName> getDefinedNameList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTExternalDefinedName>)new DefinedNameList(this);
    } 
  }
  
  public CTExternalDefinedName[] getDefinedNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DEFINEDNAME$0, arrayList);
      CTExternalDefinedName[] arrayOfCTExternalDefinedName = new CTExternalDefinedName[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTExternalDefinedName);
      return arrayOfCTExternalDefinedName;
    } 
  }
  
  public CTExternalDefinedName getDefinedNameArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalDefinedName cTExternalDefinedName = null;
      cTExternalDefinedName = (CTExternalDefinedName)get_store().find_element_user(DEFINEDNAME$0, paramInt);
      if (cTExternalDefinedName == null)
        throw new IndexOutOfBoundsException(); 
      return cTExternalDefinedName;
    } 
  }
  
  public int sizeOfDefinedNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DEFINEDNAME$0);
    } 
  }
  
  public void setDefinedNameArray(CTExternalDefinedName[] paramArrayOfCTExternalDefinedName) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTExternalDefinedName, DEFINEDNAME$0);
    } 
  }
  
  public void setDefinedNameArray(int paramInt, CTExternalDefinedName paramCTExternalDefinedName) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalDefinedName cTExternalDefinedName = null;
      cTExternalDefinedName = (CTExternalDefinedName)get_store().find_element_user(DEFINEDNAME$0, paramInt);
      if (cTExternalDefinedName == null)
        throw new IndexOutOfBoundsException(); 
      cTExternalDefinedName.set((XmlObject)paramCTExternalDefinedName);
    } 
  }
  
  public CTExternalDefinedName insertNewDefinedName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalDefinedName cTExternalDefinedName = null;
      cTExternalDefinedName = (CTExternalDefinedName)get_store().insert_element_user(DEFINEDNAME$0, paramInt);
      return cTExternalDefinedName;
    } 
  }
  
  public CTExternalDefinedName addNewDefinedName() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalDefinedName cTExternalDefinedName = null;
      cTExternalDefinedName = (CTExternalDefinedName)get_store().add_element_user(DEFINEDNAME$0);
      return cTExternalDefinedName;
    } 
  }
  
  public void removeDefinedName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFINEDNAME$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTExternalDefinedNamesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */