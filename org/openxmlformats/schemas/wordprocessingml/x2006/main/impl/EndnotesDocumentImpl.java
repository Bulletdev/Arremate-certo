package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;

public class EndnotesDocumentImpl extends XmlComplexContentImpl implements EndnotesDocument {
  private static final b ENDNOTES$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnotes");
  
  public EndnotesDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTEndnotes getEndnotes() {
    synchronized (monitor()) {
      check_orphaned();
      CTEndnotes cTEndnotes = null;
      cTEndnotes = (CTEndnotes)get_store().find_element_user(ENDNOTES$0, 0);
      if (cTEndnotes == null)
        return null; 
      return cTEndnotes;
    } 
  }
  
  public void setEndnotes(CTEndnotes paramCTEndnotes) {
    synchronized (monitor()) {
      check_orphaned();
      CTEndnotes cTEndnotes = null;
      cTEndnotes = (CTEndnotes)get_store().find_element_user(ENDNOTES$0, 0);
      if (cTEndnotes == null)
        cTEndnotes = (CTEndnotes)get_store().add_element_user(ENDNOTES$0); 
      cTEndnotes.set((XmlObject)paramCTEndnotes);
    } 
  }
  
  public CTEndnotes addNewEndnotes() {
    synchronized (monitor()) {
      check_orphaned();
      CTEndnotes cTEndnotes = null;
      cTEndnotes = (CTEndnotes)get_store().add_element_user(ENDNOTES$0);
      return cTEndnotes;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\EndnotesDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */