package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;

public class CTCommentsImpl extends XmlComplexContentImpl implements CTComments {
  private static final b AUTHORS$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "authors");
  
  private static final b COMMENTLIST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "commentList");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTCommentsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTAuthors getAuthors() {
    synchronized (monitor()) {
      check_orphaned();
      CTAuthors cTAuthors = null;
      cTAuthors = (CTAuthors)get_store().find_element_user(AUTHORS$0, 0);
      if (cTAuthors == null)
        return null; 
      return cTAuthors;
    } 
  }
  
  public void setAuthors(CTAuthors paramCTAuthors) {
    synchronized (monitor()) {
      check_orphaned();
      CTAuthors cTAuthors = null;
      cTAuthors = (CTAuthors)get_store().find_element_user(AUTHORS$0, 0);
      if (cTAuthors == null)
        cTAuthors = (CTAuthors)get_store().add_element_user(AUTHORS$0); 
      cTAuthors.set((XmlObject)paramCTAuthors);
    } 
  }
  
  public CTAuthors addNewAuthors() {
    synchronized (monitor()) {
      check_orphaned();
      CTAuthors cTAuthors = null;
      cTAuthors = (CTAuthors)get_store().add_element_user(AUTHORS$0);
      return cTAuthors;
    } 
  }
  
  public CTCommentList getCommentList() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentList cTCommentList = null;
      cTCommentList = (CTCommentList)get_store().find_element_user(COMMENTLIST$2, 0);
      if (cTCommentList == null)
        return null; 
      return cTCommentList;
    } 
  }
  
  public void setCommentList(CTCommentList paramCTCommentList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentList cTCommentList = null;
      cTCommentList = (CTCommentList)get_store().find_element_user(COMMENTLIST$2, 0);
      if (cTCommentList == null)
        cTCommentList = (CTCommentList)get_store().add_element_user(COMMENTLIST$2); 
      cTCommentList.set((XmlObject)paramCTCommentList);
    } 
  }
  
  public CTCommentList addNewCommentList() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentList cTCommentList = null;
      cTCommentList = (CTCommentList)get_store().add_element_user(COMMENTLIST$2);
      return cTCommentList;
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
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCommentsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */