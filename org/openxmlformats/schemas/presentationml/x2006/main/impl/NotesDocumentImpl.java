package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;

public class NotesDocumentImpl extends XmlComplexContentImpl implements NotesDocument {
  private static final b NOTES$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "notes");
  
  public NotesDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNotesSlide getNotes() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesSlide cTNotesSlide = null;
      cTNotesSlide = (CTNotesSlide)get_store().find_element_user(NOTES$0, 0);
      if (cTNotesSlide == null)
        return null; 
      return cTNotesSlide;
    } 
  }
  
  public void setNotes(CTNotesSlide paramCTNotesSlide) {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesSlide cTNotesSlide = null;
      cTNotesSlide = (CTNotesSlide)get_store().find_element_user(NOTES$0, 0);
      if (cTNotesSlide == null)
        cTNotesSlide = (CTNotesSlide)get_store().add_element_user(NOTES$0); 
      cTNotesSlide.set((XmlObject)paramCTNotesSlide);
    } 
  }
  
  public CTNotesSlide addNewNotes() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesSlide cTNotesSlide = null;
      cTNotesSlide = (CTNotesSlide)get_store().add_element_user(NOTES$0);
      return cTNotesSlide;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\NotesDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */