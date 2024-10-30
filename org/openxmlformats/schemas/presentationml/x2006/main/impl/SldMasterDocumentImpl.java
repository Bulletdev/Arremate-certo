package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

public class SldMasterDocumentImpl extends XmlComplexContentImpl implements SldMasterDocument {
  private static final b SLDMASTER$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMaster");
  
  public SldMasterDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSlideMaster getSldMaster() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMaster cTSlideMaster = null;
      cTSlideMaster = (CTSlideMaster)get_store().find_element_user(SLDMASTER$0, 0);
      if (cTSlideMaster == null)
        return null; 
      return cTSlideMaster;
    } 
  }
  
  public void setSldMaster(CTSlideMaster paramCTSlideMaster) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMaster cTSlideMaster = null;
      cTSlideMaster = (CTSlideMaster)get_store().find_element_user(SLDMASTER$0, 0);
      if (cTSlideMaster == null)
        cTSlideMaster = (CTSlideMaster)get_store().add_element_user(SLDMASTER$0); 
      cTSlideMaster.set((XmlObject)paramCTSlideMaster);
    } 
  }
  
  public CTSlideMaster addNewSldMaster() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMaster cTSlideMaster = null;
      cTSlideMaster = (CTSlideMaster)get_store().add_element_user(SLDMASTER$0);
      return cTSlideMaster;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\SldMasterDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */