package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
import org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument;

public class SldLayoutDocumentImpl extends XmlComplexContentImpl implements SldLayoutDocument {
  private static final b SLDLAYOUT$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldLayout");
  
  public SldLayoutDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSlideLayout getSldLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideLayout cTSlideLayout = null;
      cTSlideLayout = (CTSlideLayout)get_store().find_element_user(SLDLAYOUT$0, 0);
      if (cTSlideLayout == null)
        return null; 
      return cTSlideLayout;
    } 
  }
  
  public void setSldLayout(CTSlideLayout paramCTSlideLayout) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideLayout cTSlideLayout = null;
      cTSlideLayout = (CTSlideLayout)get_store().find_element_user(SLDLAYOUT$0, 0);
      if (cTSlideLayout == null)
        cTSlideLayout = (CTSlideLayout)get_store().add_element_user(SLDLAYOUT$0); 
      cTSlideLayout.set((XmlObject)paramCTSlideLayout);
    } 
  }
  
  public CTSlideLayout addNewSldLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideLayout cTSlideLayout = null;
      cTSlideLayout = (CTSlideLayout)get_store().add_element_user(SLDLAYOUT$0);
      return cTSlideLayout;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\SldLayoutDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */