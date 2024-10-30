package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;

public class PresentationDocumentImpl extends XmlComplexContentImpl implements PresentationDocument {
  private static final b PRESENTATION$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "presentation");
  
  public PresentationDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPresentation getPresentation() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresentation cTPresentation = null;
      cTPresentation = (CTPresentation)get_store().find_element_user(PRESENTATION$0, 0);
      if (cTPresentation == null)
        return null; 
      return cTPresentation;
    } 
  }
  
  public void setPresentation(CTPresentation paramCTPresentation) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresentation cTPresentation = null;
      cTPresentation = (CTPresentation)get_store().find_element_user(PRESENTATION$0, 0);
      if (cTPresentation == null)
        cTPresentation = (CTPresentation)get_store().add_element_user(PRESENTATION$0); 
      cTPresentation.set((XmlObject)paramCTPresentation);
    } 
  }
  
  public CTPresentation addNewPresentation() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresentation cTPresentation = null;
      cTPresentation = (CTPresentation)get_store().add_element_user(PRESENTATION$0);
      return cTPresentation;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\PresentationDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */