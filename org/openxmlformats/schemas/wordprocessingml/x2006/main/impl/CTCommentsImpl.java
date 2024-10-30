package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments;

public class CTCommentsImpl extends XmlComplexContentImpl implements CTComments {
  private static final b COMMENT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "comment");
  
  public CTCommentsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTComment> getCommentList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTComment>)new CommentList(this);
    } 
  }
  
  public CTComment[] getCommentArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COMMENT$0, arrayList);
      CTComment[] arrayOfCTComment = new CTComment[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTComment);
      return arrayOfCTComment;
    } 
  }
  
  public CTComment getCommentArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().find_element_user(COMMENT$0, paramInt);
      if (cTComment == null)
        throw new IndexOutOfBoundsException(); 
      return cTComment;
    } 
  }
  
  public int sizeOfCommentArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMMENT$0);
    } 
  }
  
  public void setCommentArray(CTComment[] paramArrayOfCTComment) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTComment, COMMENT$0);
    } 
  }
  
  public void setCommentArray(int paramInt, CTComment paramCTComment) {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().find_element_user(COMMENT$0, paramInt);
      if (cTComment == null)
        throw new IndexOutOfBoundsException(); 
      cTComment.set((XmlObject)paramCTComment);
    } 
  }
  
  public CTComment insertNewComment(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().insert_element_user(COMMENT$0, paramInt);
      return cTComment;
    } 
  }
  
  public CTComment addNewComment() {
    synchronized (monitor()) {
      check_orphaned();
      CTComment cTComment = null;
      cTComment = (CTComment)get_store().add_element_user(COMMENT$0);
      return cTComment;
    } 
  }
  
  public void removeComment(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMMENT$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTCommentsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */