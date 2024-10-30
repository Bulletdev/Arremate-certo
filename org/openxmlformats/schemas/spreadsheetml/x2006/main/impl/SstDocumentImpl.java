package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;

public class SstDocumentImpl extends XmlComplexContentImpl implements SstDocument {
  private static final b SST$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sst");
  
  public SstDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSst getSst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSst cTSst = null;
      cTSst = (CTSst)get_store().find_element_user(SST$0, 0);
      if (cTSst == null)
        return null; 
      return cTSst;
    } 
  }
  
  public void setSst(CTSst paramCTSst) {
    synchronized (monitor()) {
      check_orphaned();
      CTSst cTSst = null;
      cTSst = (CTSst)get_store().find_element_user(SST$0, 0);
      if (cTSst == null)
        cTSst = (CTSst)get_store().add_element_user(SST$0); 
      cTSst.set((XmlObject)paramCTSst);
    } 
  }
  
  public CTSst addNewSst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSst cTSst = null;
      cTSst = (CTSst)get_store().add_element_user(SST$0);
      return cTSst;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\SstDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */