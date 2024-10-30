package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

public class WorksheetDocumentImpl extends XmlComplexContentImpl implements WorksheetDocument {
  private static final b WORKSHEET$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "worksheet");
  
  public WorksheetDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTWorksheet getWorksheet() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorksheet cTWorksheet = null;
      cTWorksheet = (CTWorksheet)get_store().find_element_user(WORKSHEET$0, 0);
      if (cTWorksheet == null)
        return null; 
      return cTWorksheet;
    } 
  }
  
  public void setWorksheet(CTWorksheet paramCTWorksheet) {
    synchronized (monitor()) {
      check_orphaned();
      CTWorksheet cTWorksheet = null;
      cTWorksheet = (CTWorksheet)get_store().find_element_user(WORKSHEET$0, 0);
      if (cTWorksheet == null)
        cTWorksheet = (CTWorksheet)get_store().add_element_user(WORKSHEET$0); 
      cTWorksheet.set((XmlObject)paramCTWorksheet);
    } 
  }
  
  public CTWorksheet addNewWorksheet() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorksheet cTWorksheet = null;
      cTWorksheet = (CTWorksheet)get_store().add_element_user(WORKSHEET$0);
      return cTWorksheet;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\WorksheetDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */