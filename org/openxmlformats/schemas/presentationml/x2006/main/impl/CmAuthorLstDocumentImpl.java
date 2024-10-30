package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument;

public class CmAuthorLstDocumentImpl extends XmlComplexContentImpl implements CmAuthorLstDocument {
  private static final b CMAUTHORLST$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cmAuthorLst");
  
  public CmAuthorLstDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCommentAuthorList getCmAuthorLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentAuthorList cTCommentAuthorList = null;
      cTCommentAuthorList = (CTCommentAuthorList)get_store().find_element_user(CMAUTHORLST$0, 0);
      if (cTCommentAuthorList == null)
        return null; 
      return cTCommentAuthorList;
    } 
  }
  
  public void setCmAuthorLst(CTCommentAuthorList paramCTCommentAuthorList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentAuthorList cTCommentAuthorList = null;
      cTCommentAuthorList = (CTCommentAuthorList)get_store().find_element_user(CMAUTHORLST$0, 0);
      if (cTCommentAuthorList == null)
        cTCommentAuthorList = (CTCommentAuthorList)get_store().add_element_user(CMAUTHORLST$0); 
      cTCommentAuthorList.set((XmlObject)paramCTCommentAuthorList);
    } 
  }
  
  public CTCommentAuthorList addNewCmAuthorLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommentAuthorList cTCommentAuthorList = null;
      cTCommentAuthorList = (CTCommentAuthorList)get_store().add_element_user(CMAUTHORLST$0);
      return cTCommentAuthorList;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CmAuthorLstDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */