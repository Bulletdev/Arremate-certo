package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;

public class TableDocumentImpl extends XmlComplexContentImpl implements TableDocument {
  private static final b TABLE$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "table");
  
  public TableDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTable getTable() {
    synchronized (monitor()) {
      check_orphaned();
      CTTable cTTable = null;
      cTTable = (CTTable)get_store().find_element_user(TABLE$0, 0);
      if (cTTable == null)
        return null; 
      return cTTable;
    } 
  }
  
  public void setTable(CTTable paramCTTable) {
    synchronized (monitor()) {
      check_orphaned();
      CTTable cTTable = null;
      cTTable = (CTTable)get_store().find_element_user(TABLE$0, 0);
      if (cTTable == null)
        cTTable = (CTTable)get_store().add_element_user(TABLE$0); 
      cTTable.set((XmlObject)paramCTTable);
    } 
  }
  
  public CTTable addNewTable() {
    synchronized (monitor()) {
      check_orphaned();
      CTTable cTTable = null;
      cTTable = (CTTable)get_store().add_element_user(TABLE$0);
      return cTTable;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\TableDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */