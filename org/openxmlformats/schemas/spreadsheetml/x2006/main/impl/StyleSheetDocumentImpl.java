package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument;

public class StyleSheetDocumentImpl extends XmlComplexContentImpl implements StyleSheetDocument {
  private static final b STYLESHEET$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "styleSheet");
  
  public StyleSheetDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTStylesheet getStyleSheet() {
    synchronized (monitor()) {
      check_orphaned();
      CTStylesheet cTStylesheet = null;
      cTStylesheet = (CTStylesheet)get_store().find_element_user(STYLESHEET$0, 0);
      if (cTStylesheet == null)
        return null; 
      return cTStylesheet;
    } 
  }
  
  public void setStyleSheet(CTStylesheet paramCTStylesheet) {
    synchronized (monitor()) {
      check_orphaned();
      CTStylesheet cTStylesheet = null;
      cTStylesheet = (CTStylesheet)get_store().find_element_user(STYLESHEET$0, 0);
      if (cTStylesheet == null)
        cTStylesheet = (CTStylesheet)get_store().add_element_user(STYLESHEET$0); 
      cTStylesheet.set((XmlObject)paramCTStylesheet);
    } 
  }
  
  public CTStylesheet addNewStyleSheet() {
    synchronized (monitor()) {
      check_orphaned();
      CTStylesheet cTStylesheet = null;
      cTStylesheet = (CTStylesheet)get_store().add_element_user(STYLESHEET$0);
      return cTStylesheet;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\StyleSheetDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */