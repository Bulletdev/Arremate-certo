package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.PagesType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class PagesTypeImpl extends XmlComplexContentImpl implements PagesType {
  private static final b PAGE$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Page");
  
  public PagesTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<PageType> getPageList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<PageType>)new PageList(this);
    } 
  }
  
  public PageType[] getPageArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PAGE$0, arrayList);
      PageType[] arrayOfPageType = new PageType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfPageType);
      return arrayOfPageType;
    } 
  }
  
  public PageType getPageArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      PageType pageType = null;
      pageType = (PageType)get_store().find_element_user(PAGE$0, paramInt);
      if (pageType == null)
        throw new IndexOutOfBoundsException(); 
      return pageType;
    } 
  }
  
  public int sizeOfPageArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PAGE$0);
    } 
  }
  
  public void setPageArray(PageType[] paramArrayOfPageType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfPageType, PAGE$0);
    } 
  }
  
  public void setPageArray(int paramInt, PageType paramPageType) {
    synchronized (monitor()) {
      check_orphaned();
      PageType pageType = null;
      pageType = (PageType)get_store().find_element_user(PAGE$0, paramInt);
      if (pageType == null)
        throw new IndexOutOfBoundsException(); 
      pageType.set((XmlObject)paramPageType);
    } 
  }
  
  public PageType insertNewPage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      PageType pageType = null;
      pageType = (PageType)get_store().insert_element_user(PAGE$0, paramInt);
      return pageType;
    } 
  }
  
  public PageType addNewPage() {
    synchronized (monitor()) {
      check_orphaned();
      PageType pageType = null;
      pageType = (PageType)get_store().add_element_user(PAGE$0);
      return pageType;
    } 
  }
  
  public void removePage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGE$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\PagesTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */