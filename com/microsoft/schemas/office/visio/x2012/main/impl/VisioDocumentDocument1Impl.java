package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class VisioDocumentDocument1Impl extends XmlComplexContentImpl implements VisioDocumentDocument1 {
  private static final b VISIODOCUMENT$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "VisioDocument");
  
  public VisioDocumentDocument1Impl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public VisioDocumentType getVisioDocument() {
    synchronized (monitor()) {
      check_orphaned();
      VisioDocumentType visioDocumentType = null;
      visioDocumentType = (VisioDocumentType)get_store().find_element_user(VISIODOCUMENT$0, 0);
      if (visioDocumentType == null)
        return null; 
      return visioDocumentType;
    } 
  }
  
  public void setVisioDocument(VisioDocumentType paramVisioDocumentType) {
    synchronized (monitor()) {
      check_orphaned();
      VisioDocumentType visioDocumentType = null;
      visioDocumentType = (VisioDocumentType)get_store().find_element_user(VISIODOCUMENT$0, 0);
      if (visioDocumentType == null)
        visioDocumentType = (VisioDocumentType)get_store().add_element_user(VISIODOCUMENT$0); 
      visioDocumentType.set((XmlObject)paramVisioDocumentType);
    } 
  }
  
  public VisioDocumentType addNewVisioDocument() {
    synchronized (monitor()) {
      check_orphaned();
      VisioDocumentType visioDocumentType = null;
      visioDocumentType = (VisioDocumentType)get_store().add_element_user(VISIODOCUMENT$0);
      return visioDocumentType;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\VisioDocumentDocument1Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */