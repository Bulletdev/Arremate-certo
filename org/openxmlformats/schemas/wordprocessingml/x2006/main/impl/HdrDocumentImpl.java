package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;

public class HdrDocumentImpl extends XmlComplexContentImpl implements HdrDocument {
  private static final b HDR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hdr");
  
  public HdrDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTHdrFtr getHdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtr cTHdrFtr = null;
      cTHdrFtr = (CTHdrFtr)get_store().find_element_user(HDR$0, 0);
      if (cTHdrFtr == null)
        return null; 
      return cTHdrFtr;
    } 
  }
  
  public void setHdr(CTHdrFtr paramCTHdrFtr) {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtr cTHdrFtr = null;
      cTHdrFtr = (CTHdrFtr)get_store().find_element_user(HDR$0, 0);
      if (cTHdrFtr == null)
        cTHdrFtr = (CTHdrFtr)get_store().add_element_user(HDR$0); 
      cTHdrFtr.set((XmlObject)paramCTHdrFtr);
    } 
  }
  
  public CTHdrFtr addNewHdr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHdrFtr cTHdrFtr = null;
      cTHdrFtr = (CTHdrFtr)get_store().add_element_user(HDR$0);
      return cTHdrFtr;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\HdrDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */