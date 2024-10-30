package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBackground;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase;

public class CTDocumentBaseImpl extends XmlComplexContentImpl implements CTDocumentBase {
  private static final b BACKGROUND$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "background");
  
  public CTDocumentBaseImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBackground getBackground() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackground cTBackground = null;
      cTBackground = (CTBackground)get_store().find_element_user(BACKGROUND$0, 0);
      if (cTBackground == null)
        return null; 
      return cTBackground;
    } 
  }
  
  public boolean isSetBackground() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BACKGROUND$0) != 0);
    } 
  }
  
  public void setBackground(CTBackground paramCTBackground) {
    synchronized (monitor()) {
      check_orphaned();
      CTBackground cTBackground = null;
      cTBackground = (CTBackground)get_store().find_element_user(BACKGROUND$0, 0);
      if (cTBackground == null)
        cTBackground = (CTBackground)get_store().add_element_user(BACKGROUND$0); 
      cTBackground.set((XmlObject)paramCTBackground);
    } 
  }
  
  public CTBackground addNewBackground() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackground cTBackground = null;
      cTBackground = (CTBackground)get_store().add_element_user(BACKGROUND$0);
      return cTBackground;
    } 
  }
  
  public void unsetBackground() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BACKGROUND$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTDocumentBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */