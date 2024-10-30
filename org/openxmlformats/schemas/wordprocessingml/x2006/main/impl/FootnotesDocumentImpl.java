package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;

public class FootnotesDocumentImpl extends XmlComplexContentImpl implements FootnotesDocument {
  private static final b FOOTNOTES$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnotes");
  
  public FootnotesDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTFootnotes getFootnotes() {
    synchronized (monitor()) {
      check_orphaned();
      CTFootnotes cTFootnotes = null;
      cTFootnotes = (CTFootnotes)get_store().find_element_user(FOOTNOTES$0, 0);
      if (cTFootnotes == null)
        return null; 
      return cTFootnotes;
    } 
  }
  
  public void setFootnotes(CTFootnotes paramCTFootnotes) {
    synchronized (monitor()) {
      check_orphaned();
      CTFootnotes cTFootnotes = null;
      cTFootnotes = (CTFootnotes)get_store().find_element_user(FOOTNOTES$0, 0);
      if (cTFootnotes == null)
        cTFootnotes = (CTFootnotes)get_store().add_element_user(FOOTNOTES$0); 
      cTFootnotes.set((XmlObject)paramCTFootnotes);
    } 
  }
  
  public CTFootnotes addNewFootnotes() {
    synchronized (monitor()) {
      check_orphaned();
      CTFootnotes cTFootnotes = null;
      cTFootnotes = (CTFootnotes)get_store().add_element_user(FOOTNOTES$0);
      return cTFootnotes;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\FootnotesDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */