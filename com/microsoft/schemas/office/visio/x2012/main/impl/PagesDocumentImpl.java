package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PagesDocument;
import com.microsoft.schemas.office.visio.x2012.main.PagesType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class PagesDocumentImpl extends XmlComplexContentImpl implements PagesDocument {
  private static final b PAGES$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Pages");
  
  public PagesDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public PagesType getPages() {
    synchronized (monitor()) {
      check_orphaned();
      PagesType pagesType = null;
      pagesType = (PagesType)get_store().find_element_user(PAGES$0, 0);
      if (pagesType == null)
        return null; 
      return pagesType;
    } 
  }
  
  public void setPages(PagesType paramPagesType) {
    synchronized (monitor()) {
      check_orphaned();
      PagesType pagesType = null;
      pagesType = (PagesType)get_store().find_element_user(PAGES$0, 0);
      if (pagesType == null)
        pagesType = (PagesType)get_store().add_element_user(PAGES$0); 
      pagesType.set((XmlObject)paramPagesType);
    } 
  }
  
  public PagesType addNewPages() {
    synchronized (monitor()) {
      check_orphaned();
      PagesType pagesType = null;
      pagesType = (PagesType)get_store().add_element_user(PAGES$0);
      return pagesType;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\PagesDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */