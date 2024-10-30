package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

public class StylesDocumentImpl extends XmlComplexContentImpl implements StylesDocument {
  private static final b STYLES$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styles");
  
  public StylesDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTStyles getStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyles cTStyles = null;
      cTStyles = (CTStyles)get_store().find_element_user(STYLES$0, 0);
      if (cTStyles == null)
        return null; 
      return cTStyles;
    } 
  }
  
  public void setStyles(CTStyles paramCTStyles) {
    synchronized (monitor()) {
      check_orphaned();
      CTStyles cTStyles = null;
      cTStyles = (CTStyles)get_store().find_element_user(STYLES$0, 0);
      if (cTStyles == null)
        cTStyles = (CTStyles)get_store().add_element_user(STYLES$0); 
      cTStyles.set((XmlObject)paramCTStyles);
    } 
  }
  
  public CTStyles addNewStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTStyles cTStyles = null;
      cTStyles = (CTStyles)get_store().add_element_user(STYLES$0);
      return cTStyles;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\StylesDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */