package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;

public class NumberingDocumentImpl extends XmlComplexContentImpl implements NumberingDocument {
  private static final b NUMBERING$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numbering");
  
  public NumberingDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNumbering getNumbering() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumbering cTNumbering = null;
      cTNumbering = (CTNumbering)get_store().find_element_user(NUMBERING$0, 0);
      if (cTNumbering == null)
        return null; 
      return cTNumbering;
    } 
  }
  
  public void setNumbering(CTNumbering paramCTNumbering) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumbering cTNumbering = null;
      cTNumbering = (CTNumbering)get_store().find_element_user(NUMBERING$0, 0);
      if (cTNumbering == null)
        cTNumbering = (CTNumbering)get_store().add_element_user(NUMBERING$0); 
      cTNumbering.set((XmlObject)paramCTNumbering);
    } 
  }
  
  public CTNumbering addNewNumbering() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumbering cTNumbering = null;
      cTNumbering = (CTNumbering)get_store().add_element_user(NUMBERING$0);
      return cTNumbering;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\NumberingDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */