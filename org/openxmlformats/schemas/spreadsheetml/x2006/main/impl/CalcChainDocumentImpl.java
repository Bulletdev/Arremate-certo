package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

public class CalcChainDocumentImpl extends XmlComplexContentImpl implements CalcChainDocument {
  private static final b CALCCHAIN$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calcChain");
  
  public CalcChainDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCalcChain getCalcChain() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcChain cTCalcChain = null;
      cTCalcChain = (CTCalcChain)get_store().find_element_user(CALCCHAIN$0, 0);
      if (cTCalcChain == null)
        return null; 
      return cTCalcChain;
    } 
  }
  
  public void setCalcChain(CTCalcChain paramCTCalcChain) {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcChain cTCalcChain = null;
      cTCalcChain = (CTCalcChain)get_store().find_element_user(CALCCHAIN$0, 0);
      if (cTCalcChain == null)
        cTCalcChain = (CTCalcChain)get_store().add_element_user(CALCCHAIN$0); 
      cTCalcChain.set((XmlObject)paramCTCalcChain);
    } 
  }
  
  public CTCalcChain addNewCalcChain() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcChain cTCalcChain = null;
      cTCalcChain = (CTCalcChain)get_store().add_element_user(CALCCHAIN$0);
      return cTCalcChain;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CalcChainDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */