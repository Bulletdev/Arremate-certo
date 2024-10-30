package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument;

public class NotesMasterDocumentImpl extends XmlComplexContentImpl implements NotesMasterDocument {
  private static final b NOTESMASTER$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "notesMaster");
  
  public NotesMasterDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNotesMaster getNotesMaster() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMaster cTNotesMaster = null;
      cTNotesMaster = (CTNotesMaster)get_store().find_element_user(NOTESMASTER$0, 0);
      if (cTNotesMaster == null)
        return null; 
      return cTNotesMaster;
    } 
  }
  
  public void setNotesMaster(CTNotesMaster paramCTNotesMaster) {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMaster cTNotesMaster = null;
      cTNotesMaster = (CTNotesMaster)get_store().find_element_user(NOTESMASTER$0, 0);
      if (cTNotesMaster == null)
        cTNotesMaster = (CTNotesMaster)get_store().add_element_user(NOTESMASTER$0); 
      cTNotesMaster.set((XmlObject)paramCTNotesMaster);
    } 
  }
  
  public CTNotesMaster addNewNotesMaster() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMaster cTNotesMaster = null;
      cTNotesMaster = (CTNotesMaster)get_store().add_element_user(NOTESMASTER$0);
      return cTNotesMaster;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\NotesMasterDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */