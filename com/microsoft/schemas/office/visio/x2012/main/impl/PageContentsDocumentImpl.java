package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class PageContentsDocumentImpl extends XmlComplexContentImpl implements PageContentsDocument {
  private static final b PAGECONTENTS$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "PageContents");
  
  public PageContentsDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public PageContentsType getPageContents() {
    synchronized (monitor()) {
      check_orphaned();
      PageContentsType pageContentsType = null;
      pageContentsType = (PageContentsType)get_store().find_element_user(PAGECONTENTS$0, 0);
      if (pageContentsType == null)
        return null; 
      return pageContentsType;
    } 
  }
  
  public void setPageContents(PageContentsType paramPageContentsType) {
    synchronized (monitor()) {
      check_orphaned();
      PageContentsType pageContentsType = null;
      pageContentsType = (PageContentsType)get_store().find_element_user(PAGECONTENTS$0, 0);
      if (pageContentsType == null)
        pageContentsType = (PageContentsType)get_store().add_element_user(PAGECONTENTS$0); 
      pageContentsType.set((XmlObject)paramPageContentsType);
    } 
  }
  
  public PageContentsType addNewPageContents() {
    synchronized (monitor()) {
      check_orphaned();
      PageContentsType pageContentsType = null;
      pageContentsType = (PageContentsType)get_store().add_element_user(PAGECONTENTS$0);
      return pageContentsType;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\PageContentsDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */