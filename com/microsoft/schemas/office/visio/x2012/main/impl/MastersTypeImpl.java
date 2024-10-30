package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MasterShortcutType;
import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class MastersTypeImpl extends XmlComplexContentImpl implements MastersType {
  private static final b MASTER$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Master");
  
  private static final b MASTERSHORTCUT$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "MasterShortcut");
  
  public MastersTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<MasterType> getMasterList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<MasterType>)new MasterList(this);
    } 
  }
  
  public MasterType[] getMasterArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MASTER$0, arrayList);
      MasterType[] arrayOfMasterType = new MasterType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfMasterType);
      return arrayOfMasterType;
    } 
  }
  
  public MasterType getMasterArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      MasterType masterType = null;
      masterType = (MasterType)get_store().find_element_user(MASTER$0, paramInt);
      if (masterType == null)
        throw new IndexOutOfBoundsException(); 
      return masterType;
    } 
  }
  
  public int sizeOfMasterArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MASTER$0);
    } 
  }
  
  public void setMasterArray(MasterType[] paramArrayOfMasterType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfMasterType, MASTER$0);
    } 
  }
  
  public void setMasterArray(int paramInt, MasterType paramMasterType) {
    synchronized (monitor()) {
      check_orphaned();
      MasterType masterType = null;
      masterType = (MasterType)get_store().find_element_user(MASTER$0, paramInt);
      if (masterType == null)
        throw new IndexOutOfBoundsException(); 
      masterType.set((XmlObject)paramMasterType);
    } 
  }
  
  public MasterType insertNewMaster(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      MasterType masterType = null;
      masterType = (MasterType)get_store().insert_element_user(MASTER$0, paramInt);
      return masterType;
    } 
  }
  
  public MasterType addNewMaster() {
    synchronized (monitor()) {
      check_orphaned();
      MasterType masterType = null;
      masterType = (MasterType)get_store().add_element_user(MASTER$0);
      return masterType;
    } 
  }
  
  public void removeMaster(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MASTER$0, paramInt);
    } 
  }
  
  public List<MasterShortcutType> getMasterShortcutList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<MasterShortcutType>)new MasterShortcutList(this);
    } 
  }
  
  public MasterShortcutType[] getMasterShortcutArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MASTERSHORTCUT$2, arrayList);
      MasterShortcutType[] arrayOfMasterShortcutType = new MasterShortcutType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfMasterShortcutType);
      return arrayOfMasterShortcutType;
    } 
  }
  
  public MasterShortcutType getMasterShortcutArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      MasterShortcutType masterShortcutType = null;
      masterShortcutType = (MasterShortcutType)get_store().find_element_user(MASTERSHORTCUT$2, paramInt);
      if (masterShortcutType == null)
        throw new IndexOutOfBoundsException(); 
      return masterShortcutType;
    } 
  }
  
  public int sizeOfMasterShortcutArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MASTERSHORTCUT$2);
    } 
  }
  
  public void setMasterShortcutArray(MasterShortcutType[] paramArrayOfMasterShortcutType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfMasterShortcutType, MASTERSHORTCUT$2);
    } 
  }
  
  public void setMasterShortcutArray(int paramInt, MasterShortcutType paramMasterShortcutType) {
    synchronized (monitor()) {
      check_orphaned();
      MasterShortcutType masterShortcutType = null;
      masterShortcutType = (MasterShortcutType)get_store().find_element_user(MASTERSHORTCUT$2, paramInt);
      if (masterShortcutType == null)
        throw new IndexOutOfBoundsException(); 
      masterShortcutType.set((XmlObject)paramMasterShortcutType);
    } 
  }
  
  public MasterShortcutType insertNewMasterShortcut(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      MasterShortcutType masterShortcutType = null;
      masterShortcutType = (MasterShortcutType)get_store().insert_element_user(MASTERSHORTCUT$2, paramInt);
      return masterShortcutType;
    } 
  }
  
  public MasterShortcutType addNewMasterShortcut() {
    synchronized (monitor()) {
      check_orphaned();
      MasterShortcutType masterShortcutType = null;
      masterShortcutType = (MasterShortcutType)get_store().add_element_user(MASTERSHORTCUT$2);
      return masterShortcutType;
    } 
  }
  
  public void removeMasterShortcut(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MASTERSHORTCUT$2, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\MastersTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */