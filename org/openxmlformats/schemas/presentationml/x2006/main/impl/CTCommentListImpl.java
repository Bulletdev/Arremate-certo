package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;

public class CTCommentListImpl extends XmlComplexContentImpl implements CTCommentList {
  private static final b CM$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cm");
  
  public CTCommentListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTComment> getCmList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTComment>)new CmList(this);
    } 
  }
  
  public CTComment[] getCmArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CM$0, arrayList);
      CTComment[] arrayOfCTComment = new CTComment[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTComment);
      return arrayOfCTComment;
    } 
  }
  
  public CTComment getCmArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().find_element_user(CM$0, paramInt);
      if (cTComment == null)
        throw new IndexOutOfBoundsException(); 
      return cTComment;
    } 
  }
  
  public int sizeOfCmArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CM$0);
    } 
  }
  
  public void setCmArray(CTComment[] paramArrayOfCTComment) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTComment, CM$0);
    } 
  }
  
  public void setCmArray(int paramInt, CTComment paramCTComment) {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().find_element_user(CM$0, paramInt);
      if (cTComment == null)
        throw new IndexOutOfBoundsException(); 
      cTComment.set((XmlObject)paramCTComment);
    } 
  }
  
  public CTComment insertNewCm(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().insert_element_user(CM$0, paramInt);
      return cTComment;
    } 
  }
  
  public CTComment addNewCm() {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().add_element_user(CM$0);
      return cTComment;
    } 
  }
  
  public void removeCm(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CM$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTCommentListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */