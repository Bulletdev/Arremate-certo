package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

public class WorkbookDocumentImpl extends XmlComplexContentImpl implements WorkbookDocument {
  private static final b WORKBOOK$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbook");
  
  public WorkbookDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTWorkbook getWorkbook() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbook cTWorkbook = null;
      cTWorkbook = (CTWorkbook)get_store().find_element_user(WORKBOOK$0, 0);
      if (cTWorkbook == null)
        return null; 
      return cTWorkbook;
    } 
  }
  
  public void setWorkbook(CTWorkbook paramCTWorkbook) {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbook cTWorkbook = null;
      cTWorkbook = (CTWorkbook)get_store().find_element_user(WORKBOOK$0, 0);
      if (cTWorkbook == null)
        cTWorkbook = (CTWorkbook)get_store().add_element_user(WORKBOOK$0); 
      cTWorkbook.set((XmlObject)paramCTWorkbook);
    } 
  }
  
  public CTWorkbook addNewWorkbook() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbook cTWorkbook = null;
      cTWorkbook = (CTWorkbook)get_store().add_element_user(WORKBOOK$0);
      return cTWorkbook;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\WorkbookDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */