package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

public class ThemeDocumentImpl extends XmlComplexContentImpl implements ThemeDocument {
  private static final b THEME$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "theme");
  
  public ThemeDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTOfficeStyleSheet getTheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeStyleSheet cTOfficeStyleSheet = null;
      cTOfficeStyleSheet = (CTOfficeStyleSheet)get_store().find_element_user(THEME$0, 0);
      if (cTOfficeStyleSheet == null)
        return null; 
      return cTOfficeStyleSheet;
    } 
  }
  
  public void setTheme(CTOfficeStyleSheet paramCTOfficeStyleSheet) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeStyleSheet cTOfficeStyleSheet = null;
      cTOfficeStyleSheet = (CTOfficeStyleSheet)get_store().find_element_user(THEME$0, 0);
      if (cTOfficeStyleSheet == null)
        cTOfficeStyleSheet = (CTOfficeStyleSheet)get_store().add_element_user(THEME$0); 
      cTOfficeStyleSheet.set((XmlObject)paramCTOfficeStyleSheet);
    } 
  }
  
  public CTOfficeStyleSheet addNewTheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeStyleSheet cTOfficeStyleSheet = null;
      cTOfficeStyleSheet = (CTOfficeStyleSheet)get_store().add_element_user(THEME$0);
      return cTOfficeStyleSheet;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\ThemeDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */