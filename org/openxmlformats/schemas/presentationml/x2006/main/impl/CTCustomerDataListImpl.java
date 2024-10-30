package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTagsData;

public class CTCustomerDataListImpl extends XmlComplexContentImpl implements CTCustomerDataList {
  private static final b CUSTDATA$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "custData");
  
  private static final b TAGS$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "tags");
  
  public CTCustomerDataListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCustomerData> getCustDataList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCustomerData>)new CustDataList(this);
    } 
  }
  
  public CTCustomerData[] getCustDataArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CUSTDATA$0, arrayList);
      CTCustomerData[] arrayOfCTCustomerData = new CTCustomerData[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCustomerData);
      return arrayOfCTCustomerData;
    } 
  }
  
  public CTCustomerData getCustDataArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerData cTCustomerData = null;
      cTCustomerData = (CTCustomerData)get_store().find_element_user(CUSTDATA$0, paramInt);
      if (cTCustomerData == null)
        throw new IndexOutOfBoundsException(); 
      return cTCustomerData;
    } 
  }
  
  public int sizeOfCustDataArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CUSTDATA$0);
    } 
  }
  
  public void setCustDataArray(CTCustomerData[] paramArrayOfCTCustomerData) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCustomerData, CUSTDATA$0);
    } 
  }
  
  public void setCustDataArray(int paramInt, CTCustomerData paramCTCustomerData) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerData cTCustomerData = null;
      cTCustomerData = (CTCustomerData)get_store().find_element_user(CUSTDATA$0, paramInt);
      if (cTCustomerData == null)
        throw new IndexOutOfBoundsException(); 
      cTCustomerData.set((XmlObject)paramCTCustomerData);
    } 
  }
  
  public CTCustomerData insertNewCustData(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerData cTCustomerData = null;
      cTCustomerData = (CTCustomerData)get_store().insert_element_user(CUSTDATA$0, paramInt);
      return cTCustomerData;
    } 
  }
  
  public CTCustomerData addNewCustData() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerData cTCustomerData = null;
      cTCustomerData = (CTCustomerData)get_store().add_element_user(CUSTDATA$0);
      return cTCustomerData;
    } 
  }
  
  public void removeCustData(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTDATA$0, paramInt);
    } 
  }
  
  public CTTagsData getTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTTagsData cTTagsData = null;
      cTTagsData = (CTTagsData)get_store().find_element_user(TAGS$2, 0);
      if (cTTagsData == null)
        return null; 
      return cTTagsData;
    } 
  }
  
  public boolean isSetTags() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TAGS$2) != 0);
    } 
  }
  
  public void setTags(CTTagsData paramCTTagsData) {
    synchronized (monitor()) {
      check_orphaned();
      CTTagsData cTTagsData = null;
      cTTagsData = (CTTagsData)get_store().find_element_user(TAGS$2, 0);
      if (cTTagsData == null)
        cTTagsData = (CTTagsData)get_store().add_element_user(TAGS$2); 
      cTTagsData.set((XmlObject)paramCTTagsData);
    } 
  }
  
  public CTTagsData addNewTags() {
    synchronized (monitor()) {
      check_orphaned();
      CTTagsData cTTagsData = null;
      cTTagsData = (CTTagsData)get_store().add_element_user(TAGS$2);
      return cTTagsData;
    } 
  }
  
  public void unsetTags() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TAGS$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTCustomerDataListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */