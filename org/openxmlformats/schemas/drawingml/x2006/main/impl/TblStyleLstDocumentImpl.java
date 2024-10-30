package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument;

public class TblStyleLstDocumentImpl extends XmlComplexContentImpl implements TblStyleLstDocument {
  private static final b TBLSTYLELST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tblStyleLst");
  
  public TblStyleLstDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTableStyleList getTblStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleList cTTableStyleList = null;
      cTTableStyleList = (CTTableStyleList)get_store().find_element_user(TBLSTYLELST$0, 0);
      if (cTTableStyleList == null)
        return null; 
      return cTTableStyleList;
    } 
  }
  
  public void setTblStyleLst(CTTableStyleList paramCTTableStyleList) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleList cTTableStyleList = null;
      cTTableStyleList = (CTTableStyleList)get_store().find_element_user(TBLSTYLELST$0, 0);
      if (cTTableStyleList == null)
        cTTableStyleList = (CTTableStyleList)get_store().add_element_user(TBLSTYLELST$0); 
      cTTableStyleList.set((XmlObject)paramCTTableStyleList);
    } 
  }
  
  public CTTableStyleList addNewTblStyleLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyleList cTTableStyleList = null;
      cTTableStyleList = (CTTableStyleList)get_store().add_element_user(TBLSTYLELST$0);
      return cTTableStyleList;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\TblStyleLstDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */