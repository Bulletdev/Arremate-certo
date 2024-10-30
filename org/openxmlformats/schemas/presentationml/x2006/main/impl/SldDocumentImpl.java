package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;

public class SldDocumentImpl extends XmlComplexContentImpl implements SldDocument {
  private static final b SLD$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sld");
  
  public SldDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSlide getSld() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlide cTSlide = null;
      cTSlide = (CTSlide)get_store().find_element_user(SLD$0, 0);
      if (cTSlide == null)
        return null; 
      return cTSlide;
    } 
  }
  
  public void setSld(CTSlide paramCTSlide) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlide cTSlide = null;
      cTSlide = (CTSlide)get_store().find_element_user(SLD$0, 0);
      if (cTSlide == null)
        cTSlide = (CTSlide)get_store().add_element_user(SLD$0); 
      cTSlide.set((XmlObject)paramCTSlide);
    } 
  }
  
  public CTSlide addNewSld() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlide cTSlide = null;
      cTSlide = (CTSlide)get_store().add_element_user(SLD$0);
      return cTSlide;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\SldDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */