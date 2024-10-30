package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdListEntry;

public class CTNotesMasterIdListImpl extends XmlComplexContentImpl implements CTNotesMasterIdList {
  private static final b NOTESMASTERID$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "notesMasterId");
  
  public CTNotesMasterIdListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNotesMasterIdListEntry getNotesMasterId() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMasterIdListEntry cTNotesMasterIdListEntry = null;
      cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry)get_store().find_element_user(NOTESMASTERID$0, 0);
      if (cTNotesMasterIdListEntry == null)
        return null; 
      return cTNotesMasterIdListEntry;
    } 
  }
  
  public boolean isSetNotesMasterId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOTESMASTERID$0) != 0);
    } 
  }
  
  public void setNotesMasterId(CTNotesMasterIdListEntry paramCTNotesMasterIdListEntry) {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMasterIdListEntry cTNotesMasterIdListEntry = null;
      cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry)get_store().find_element_user(NOTESMASTERID$0, 0);
      if (cTNotesMasterIdListEntry == null)
        cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry)get_store().add_element_user(NOTESMASTERID$0); 
      cTNotesMasterIdListEntry.set((XmlObject)paramCTNotesMasterIdListEntry);
    } 
  }
  
  public CTNotesMasterIdListEntry addNewNotesMasterId() {
    synchronized (monitor()) {
      check_orphaned();
      CTNotesMasterIdListEntry cTNotesMasterIdListEntry = null;
      cTNotesMasterIdListEntry = (CTNotesMasterIdListEntry)get_store().add_element_user(NOTESMASTERID$0);
      return cTNotesMasterIdListEntry;
    } 
  }
  
  public void unsetNotesMasterId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOTESMASTERID$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTNotesMasterIdListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */