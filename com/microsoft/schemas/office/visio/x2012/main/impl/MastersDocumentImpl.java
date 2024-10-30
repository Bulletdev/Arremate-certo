package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MastersDocument;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class MastersDocumentImpl extends XmlComplexContentImpl implements MastersDocument {
  private static final b MASTERS$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Masters");
  
  public MastersDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public MastersType getMasters() {
    synchronized (monitor()) {
      check_orphaned();
      MastersType mastersType = null;
      mastersType = (MastersType)get_store().find_element_user(MASTERS$0, 0);
      if (mastersType == null)
        return null; 
      return mastersType;
    } 
  }
  
  public void setMasters(MastersType paramMastersType) {
    synchronized (monitor()) {
      check_orphaned();
      MastersType mastersType = null;
      mastersType = (MastersType)get_store().find_element_user(MASTERS$0, 0);
      if (mastersType == null)
        mastersType = (MastersType)get_store().add_element_user(MASTERS$0); 
      mastersType.set((XmlObject)paramMastersType);
    } 
  }
  
  public MastersType addNewMasters() {
    synchronized (monitor()) {
      check_orphaned();
      MastersType mastersType = null;
      mastersType = (MastersType)get_store().add_element_user(MASTERS$0);
      return mastersType;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\MastersDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */