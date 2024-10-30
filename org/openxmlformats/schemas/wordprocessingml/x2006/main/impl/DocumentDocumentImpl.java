package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument;

public class DocumentDocumentImpl extends XmlComplexContentImpl implements DocumentDocument {
  private static final b DOCUMENT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "document");
  
  public DocumentDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTDocument1 getDocument() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocument1 cTDocument1 = null;
      cTDocument1 = (CTDocument1)get_store().find_element_user(DOCUMENT$0, 0);
      if (cTDocument1 == null)
        return null; 
      return cTDocument1;
    } 
  }
  
  public void setDocument(CTDocument1 paramCTDocument1) {
    synchronized (monitor()) {
      check_orphaned();
      CTDocument1 cTDocument1 = null;
      cTDocument1 = (CTDocument1)get_store().find_element_user(DOCUMENT$0, 0);
      if (cTDocument1 == null)
        cTDocument1 = (CTDocument1)get_store().add_element_user(DOCUMENT$0); 
      cTDocument1.set((XmlObject)paramCTDocument1);
    } 
  }
  
  public CTDocument1 addNewDocument() {
    synchronized (monitor()) {
      check_orphaned();
      CTDocument1 cTDocument1 = null;
      cTDocument1 = (CTDocument1)get_store().add_element_user(DOCUMENT$0);
      return cTDocument1;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\DocumentDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */