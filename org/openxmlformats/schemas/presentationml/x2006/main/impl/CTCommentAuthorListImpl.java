package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;

public class CTCommentAuthorListImpl extends XmlComplexContentImpl implements CTCommentAuthorList {
  private static final b CMAUTHOR$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cmAuthor");
  
  public CTCommentAuthorListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCommentAuthor> getCmAuthorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCommentAuthor>)new CmAuthorList(this);
    } 
  }
  
  public CTCommentAuthor[] getCmAuthorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CMAUTHOR$0, arrayList);
      CTCommentAuthor[] arrayOfCTCommentAuthor = new CTCommentAuthor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCommentAuthor);
      return arrayOfCTCommentAuthor;
    } 
  }
  
  public CTCommentAuthor getCmAuthorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentAuthor cTCommentAuthor = null;
      cTCommentAuthor = (CTCommentAuthor)get_store().find_element_user(CMAUTHOR$0, paramInt);
      if (cTCommentAuthor == null)
        throw new IndexOutOfBoundsException(); 
      return cTCommentAuthor;
    } 
  }
  
  public int sizeOfCmAuthorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CMAUTHOR$0);
    } 
  }
  
  public void setCmAuthorArray(CTCommentAuthor[] paramArrayOfCTCommentAuthor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCommentAuthor, CMAUTHOR$0);
    } 
  }
  
  public void setCmAuthorArray(int paramInt, CTCommentAuthor paramCTCommentAuthor) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentAuthor cTCommentAuthor = null;
      cTCommentAuthor = (CTCommentAuthor)get_store().find_element_user(CMAUTHOR$0, paramInt);
      if (cTCommentAuthor == null)
        throw new IndexOutOfBoundsException(); 
      cTCommentAuthor.set((XmlObject)paramCTCommentAuthor);
    } 
  }
  
  public CTCommentAuthor insertNewCmAuthor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentAuthor cTCommentAuthor = null;
      cTCommentAuthor = (CTCommentAuthor)get_store().insert_element_user(CMAUTHOR$0, paramInt);
      return cTCommentAuthor;
    } 
  }
  
  public CTCommentAuthor addNewCmAuthor() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentAuthor cTCommentAuthor = null;
      cTCommentAuthor = (CTCommentAuthor)get_store().add_element_user(CMAUTHOR$0);
      return cTCommentAuthor;
    } 
  }
  
  public void removeCmAuthor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CMAUTHOR$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTCommentAuthorListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */