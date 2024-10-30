package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument;

public class SingleXmlCellsDocumentImpl extends XmlComplexContentImpl implements SingleXmlCellsDocument {
  private static final b SINGLEXMLCELLS$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "singleXmlCells");
  
  public SingleXmlCellsDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSingleXmlCells getSingleXmlCells() {
    synchronized (monitor()) {
      check_orphaned();
      CTSingleXmlCells cTSingleXmlCells = null;
      cTSingleXmlCells = (CTSingleXmlCells)get_store().find_element_user(SINGLEXMLCELLS$0, 0);
      if (cTSingleXmlCells == null)
        return null; 
      return cTSingleXmlCells;
    } 
  }
  
  public void setSingleXmlCells(CTSingleXmlCells paramCTSingleXmlCells) {
    synchronized (monitor()) {
      check_orphaned();
      CTSingleXmlCells cTSingleXmlCells = null;
      cTSingleXmlCells = (CTSingleXmlCells)get_store().find_element_user(SINGLEXMLCELLS$0, 0);
      if (cTSingleXmlCells == null)
        cTSingleXmlCells = (CTSingleXmlCells)get_store().add_element_user(SINGLEXMLCELLS$0); 
      cTSingleXmlCells.set((XmlObject)paramCTSingleXmlCells);
    } 
  }
  
  public CTSingleXmlCells addNewSingleXmlCells() {
    synchronized (monitor()) {
      check_orphaned();
      CTSingleXmlCells cTSingleXmlCells = null;
      cTSingleXmlCells = (CTSingleXmlCells)get_store().add_element_user(SINGLEXMLCELLS$0);
      return cTSingleXmlCells;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\SingleXmlCellsDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */