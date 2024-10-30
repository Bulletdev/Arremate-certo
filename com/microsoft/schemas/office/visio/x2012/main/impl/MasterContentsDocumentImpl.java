package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MasterContentsDocument;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class MasterContentsDocumentImpl extends XmlComplexContentImpl implements MasterContentsDocument {
  private static final b MASTERCONTENTS$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "MasterContents");
  
  public MasterContentsDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public PageContentsType getMasterContents() {
    synchronized (monitor()) {
      check_orphaned();
      PageContentsType pageContentsType = null;
      pageContentsType = (PageContentsType)get_store().find_element_user(MASTERCONTENTS$0, 0);
      if (pageContentsType == null)
        return null; 
      return pageContentsType;
    } 
  }
  
  public void setMasterContents(PageContentsType paramPageContentsType) {
    synchronized (monitor()) {
      check_orphaned();
      PageContentsType pageContentsType = null;
      pageContentsType = (PageContentsType)get_store().find_element_user(MASTERCONTENTS$0, 0);
      if (pageContentsType == null)
        pageContentsType = (PageContentsType)get_store().add_element_user(MASTERCONTENTS$0); 
      pageContentsType.set((XmlObject)paramPageContentsType);
    } 
  }
  
  public PageContentsType addNewMasterContents() {
    synchronized (monitor()) {
      check_orphaned();
      PageContentsType pageContentsType = null;
      pageContentsType = (PageContentsType)get_store().add_element_user(MASTERCONTENTS$0);
      return pageContentsType;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\MasterContentsDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */