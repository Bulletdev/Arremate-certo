package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;

public class CTTableRowImpl extends XmlComplexContentImpl implements CTTableRow {
  private static final b TC$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tc");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b H$4 = new b("", "h");
  
  public CTTableRowImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTableCell> getTcList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTableCell>)new TcList(this);
    } 
  }
  
  public CTTableCell[] getTcArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TC$0, arrayList);
      CTTableCell[] arrayOfCTTableCell = new CTTableCell[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTableCell);
      return arrayOfCTTableCell;
    } 
  }
  
  public CTTableCell getTcArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCell cTTableCell = null;
      cTTableCell = (CTTableCell)get_store().find_element_user(TC$0, paramInt);
      if (cTTableCell == null)
        throw new IndexOutOfBoundsException(); 
      return cTTableCell;
    } 
  }
  
  public int sizeOfTcArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TC$0);
    } 
  }
  
  public void setTcArray(CTTableCell[] paramArrayOfCTTableCell) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTableCell, TC$0);
    } 
  }
  
  public void setTcArray(int paramInt, CTTableCell paramCTTableCell) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCell cTTableCell = null;
      cTTableCell = (CTTableCell)get_store().find_element_user(TC$0, paramInt);
      if (cTTableCell == null)
        throw new IndexOutOfBoundsException(); 
      cTTableCell.set((XmlObject)paramCTTableCell);
    } 
  }
  
  public CTTableCell insertNewTc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCell cTTableCell = null;
      cTTableCell = (CTTableCell)get_store().insert_element_user(TC$0, paramInt);
      return cTTableCell;
    } 
  }
  
  public CTTableCell addNewTc() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCell cTTableCell = null;
      cTTableCell = (CTTableCell)get_store().add_element_user(TC$0);
      return cTTableCell;
    } 
  }
  
  public void removeTc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TC$0, paramInt);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
  
  public long getH() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(H$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STCoordinate xgetH() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(H$4);
      return sTCoordinate;
    } 
  }
  
  public void setH(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(H$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(H$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetH(STCoordinate paramSTCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_attribute_user(H$4);
      if (sTCoordinate == null)
        sTCoordinate = (STCoordinate)get_store().add_attribute_user(H$4); 
      sTCoordinate.set((XmlObject)paramSTCoordinate);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableRowImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */