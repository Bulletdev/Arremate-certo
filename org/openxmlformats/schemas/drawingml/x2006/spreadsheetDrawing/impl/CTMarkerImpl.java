package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STColID;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STRowID;

public class CTMarkerImpl extends XmlComplexContentImpl implements CTMarker {
  private static final b COL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "col");
  
  private static final b COLOFF$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "colOff");
  
  private static final b ROW$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "row");
  
  private static final b ROWOFF$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "rowOff");
  
  public CTMarkerImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COL$0, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STColID xgetCol() {
    synchronized (monitor()) {
      check_orphaned();
      STColID sTColID = null;
      sTColID = (STColID)get_store().find_element_user(COL$0, 0);
      return sTColID;
    } 
  }
  
  public void setCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COL$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(COL$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetCol(STColID paramSTColID) {
    synchronized (monitor()) {
      check_orphaned();
      STColID sTColID = null;
      sTColID = (STColID)get_store().find_element_user(COL$0, 0);
      if (sTColID == null)
        sTColID = (STColID)get_store().add_element_user(COL$0); 
      sTColID.set((XmlObject)paramSTColID);
    } 
  }
  
  public long getColOff() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLOFF$2, 0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STCoordinate xgetColOff() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_element_user(COLOFF$2, 0);
      return sTCoordinate;
    } 
  }
  
  public void setColOff(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLOFF$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(COLOFF$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetColOff(STCoordinate paramSTCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_element_user(COLOFF$2, 0);
      if (sTCoordinate == null)
        sTCoordinate = (STCoordinate)get_store().add_element_user(COLOFF$2); 
      sTCoordinate.set((XmlObject)paramSTCoordinate);
    } 
  }
  
  public int getRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROW$4, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STRowID xgetRow() {
    synchronized (monitor()) {
      check_orphaned();
      STRowID sTRowID = null;
      sTRowID = (STRowID)get_store().find_element_user(ROW$4, 0);
      return sTRowID;
    } 
  }
  
  public void setRow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROW$4, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(ROW$4); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetRow(STRowID paramSTRowID) {
    synchronized (monitor()) {
      check_orphaned();
      STRowID sTRowID = null;
      sTRowID = (STRowID)get_store().find_element_user(ROW$4, 0);
      if (sTRowID == null)
        sTRowID = (STRowID)get_store().add_element_user(ROW$4); 
      sTRowID.set((XmlObject)paramSTRowID);
    } 
  }
  
  public long getRowOff() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROWOFF$6, 0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STCoordinate xgetRowOff() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_element_user(ROWOFF$6, 0);
      return sTCoordinate;
    } 
  }
  
  public void setRowOff(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROWOFF$6, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(ROWOFF$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetRowOff(STCoordinate paramSTCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate sTCoordinate = null;
      sTCoordinate = (STCoordinate)get_store().find_element_user(ROWOFF$6, 0);
      if (sTCoordinate == null)
        sTCoordinate = (STCoordinate)get_store().add_element_user(ROWOFF$6); 
      sTCoordinate.set((XmlObject)paramSTCoordinate);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTMarkerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */