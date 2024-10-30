package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;

public class CTDocument1Impl extends CTDocumentBaseImpl implements CTDocument1 {
  private static final b BODY$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "body");
  
  public CTDocument1Impl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBody getBody() {
    synchronized (monitor()) {
      check_orphaned();
      CTBody cTBody = null;
      cTBody = (CTBody)get_store().find_element_user(BODY$0, 0);
      if (cTBody == null)
        return null; 
      return cTBody;
    } 
  }
  
  public boolean isSetBody() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BODY$0) != 0);
    } 
  }
  
  public void setBody(CTBody paramCTBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTBody cTBody = null;
      cTBody = (CTBody)get_store().find_element_user(BODY$0, 0);
      if (cTBody == null)
        cTBody = (CTBody)get_store().add_element_user(BODY$0); 
      cTBody.set((XmlObject)paramCTBody);
    } 
  }
  
  public CTBody addNewBody() {
    synchronized (monitor()) {
      check_orphaned();
      CTBody cTBody = null;
      cTBody = (CTBody)get_store().add_element_user(BODY$0);
      return cTBody;
    } 
  }
  
  public void unsetBody() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BODY$0, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTDocument1Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */