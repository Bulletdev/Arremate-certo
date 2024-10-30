package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;

public class CmLstDocumentImpl extends XmlComplexContentImpl implements CmLstDocument {
  private static final b CMLST$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cmLst");
  
  public CmLstDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCommentList getCmLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentList cTCommentList = null;
      cTCommentList = (CTCommentList)get_store().find_element_user(CMLST$0, 0);
      if (cTCommentList == null)
        return null; 
      return cTCommentList;
    } 
  }
  
  public void setCmLst(CTCommentList paramCTCommentList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentList cTCommentList = null;
      cTCommentList = (CTCommentList)get_store().find_element_user(CMLST$0, 0);
      if (cTCommentList == null)
        cTCommentList = (CTCommentList)get_store().add_element_user(CMLST$0); 
      cTCommentList.set((XmlObject)paramCTCommentList);
    } 
  }
  
  public CTCommentList addNewCmLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentList cTCommentList = null;
      cTCommentList = (CTCommentList)get_store().add_element_user(CMLST$0);
      return cTCommentList;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CmLstDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */