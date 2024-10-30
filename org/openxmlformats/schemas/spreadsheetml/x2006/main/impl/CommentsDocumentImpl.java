package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;

public class CommentsDocumentImpl extends XmlComplexContentImpl implements CommentsDocument {
  private static final b COMMENTS$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "comments");
  
  public CommentsDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTComments getComments() {
    synchronized (monitor()) {
      check_orphaned();
      CTComments cTComments = null;
      cTComments = (CTComments)get_store().find_element_user(COMMENTS$0, 0);
      if (cTComments == null)
        return null; 
      return cTComments;
    } 
  }
  
  public void setComments(CTComments paramCTComments) {
    synchronized (monitor()) {
      check_orphaned();
      CTComments cTComments = null;
      cTComments = (CTComments)get_store().find_element_user(COMMENTS$0, 0);
      if (cTComments == null)
        cTComments = (CTComments)get_store().add_element_user(COMMENTS$0); 
      cTComments.set((XmlObject)paramCTComments);
    } 
  }
  
  public CTComments addNewComments() {
    synchronized (monitor()) {
      check_orphaned();
      CTComments cTComments = null;
      cTComments = (CTComments)get_store().add_element_user(COMMENTS$0);
      return cTComments;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CommentsDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */