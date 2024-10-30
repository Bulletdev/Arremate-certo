package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import com.microsoft.schemas.office.visio.x2012.main.TriggerType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class SectionTypeImpl extends XmlComplexContentImpl implements SectionType {
  private static final b CELL$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Cell");
  
  private static final b TRIGGER$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Trigger");
  
  private static final b ROW$4 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Row");
  
  private static final b N$6 = new b("", "N");
  
  private static final b DEL$8 = new b("", "Del");
  
  private static final b IX$10 = new b("", "IX");
  
  public SectionTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CellType> getCellList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CellType>)new CellList(this);
    } 
  }
  
  public CellType[] getCellArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CELL$0, arrayList);
      CellType[] arrayOfCellType = new CellType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCellType);
      return arrayOfCellType;
    } 
  }
  
  public CellType getCellArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CellType cellType = null;
      cellType = (CellType)get_store().find_element_user(CELL$0, paramInt);
      if (cellType == null)
        throw new IndexOutOfBoundsException(); 
      return cellType;
    } 
  }
  
  public int sizeOfCellArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CELL$0);
    } 
  }
  
  public void setCellArray(CellType[] paramArrayOfCellType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCellType, CELL$0);
    } 
  }
  
  public void setCellArray(int paramInt, CellType paramCellType) {
    synchronized (monitor()) {
      check_orphaned();
      CellType cellType = null;
      cellType = (CellType)get_store().find_element_user(CELL$0, paramInt);
      if (cellType == null)
        throw new IndexOutOfBoundsException(); 
      cellType.set((XmlObject)paramCellType);
    } 
  }
  
  public CellType insertNewCell(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CellType cellType = null;
      cellType = (CellType)get_store().insert_element_user(CELL$0, paramInt);
      return cellType;
    } 
  }
  
  public CellType addNewCell() {
    synchronized (monitor()) {
      check_orphaned();
      CellType cellType = null;
      cellType = (CellType)get_store().add_element_user(CELL$0);
      return cellType;
    } 
  }
  
  public void removeCell(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELL$0, paramInt);
    } 
  }
  
  public List<TriggerType> getTriggerList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<TriggerType>)new TriggerList(this);
    } 
  }
  
  public TriggerType[] getTriggerArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TRIGGER$2, arrayList);
      TriggerType[] arrayOfTriggerType = new TriggerType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfTriggerType);
      return arrayOfTriggerType;
    } 
  }
  
  public TriggerType getTriggerArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      TriggerType triggerType = null;
      triggerType = (TriggerType)get_store().find_element_user(TRIGGER$2, paramInt);
      if (triggerType == null)
        throw new IndexOutOfBoundsException(); 
      return triggerType;
    } 
  }
  
  public int sizeOfTriggerArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TRIGGER$2);
    } 
  }
  
  public void setTriggerArray(TriggerType[] paramArrayOfTriggerType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfTriggerType, TRIGGER$2);
    } 
  }
  
  public void setTriggerArray(int paramInt, TriggerType paramTriggerType) {
    synchronized (monitor()) {
      check_orphaned();
      TriggerType triggerType = null;
      triggerType = (TriggerType)get_store().find_element_user(TRIGGER$2, paramInt);
      if (triggerType == null)
        throw new IndexOutOfBoundsException(); 
      triggerType.set((XmlObject)paramTriggerType);
    } 
  }
  
  public TriggerType insertNewTrigger(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      TriggerType triggerType = null;
      triggerType = (TriggerType)get_store().insert_element_user(TRIGGER$2, paramInt);
      return triggerType;
    } 
  }
  
  public TriggerType addNewTrigger() {
    synchronized (monitor()) {
      check_orphaned();
      TriggerType triggerType = null;
      triggerType = (TriggerType)get_store().add_element_user(TRIGGER$2);
      return triggerType;
    } 
  }
  
  public void removeTrigger(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRIGGER$2, paramInt);
    } 
  }
  
  public List<RowType> getRowList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<RowType>)new RowList(this);
    } 
  }
  
  public RowType[] getRowArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ROW$4, arrayList);
      RowType[] arrayOfRowType = new RowType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfRowType);
      return arrayOfRowType;
    } 
  }
  
  public RowType getRowArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      RowType rowType = null;
      rowType = (RowType)get_store().find_element_user(ROW$4, paramInt);
      if (rowType == null)
        throw new IndexOutOfBoundsException(); 
      return rowType;
    } 
  }
  
  public int sizeOfRowArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ROW$4);
    } 
  }
  
  public void setRowArray(RowType[] paramArrayOfRowType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfRowType, ROW$4);
    } 
  }
  
  public void setRowArray(int paramInt, RowType paramRowType) {
    synchronized (monitor()) {
      check_orphaned();
      RowType rowType = null;
      rowType = (RowType)get_store().find_element_user(ROW$4, paramInt);
      if (rowType == null)
        throw new IndexOutOfBoundsException(); 
      rowType.set((XmlObject)paramRowType);
    } 
  }
  
  public RowType insertNewRow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      RowType rowType = null;
      rowType = (RowType)get_store().insert_element_user(ROW$4, paramInt);
      return rowType;
    } 
  }
  
  public RowType addNewRow() {
    synchronized (monitor()) {
      check_orphaned();
      RowType rowType = null;
      rowType = (RowType)get_store().add_element_user(ROW$4);
      return rowType;
    } 
  }
  
  public void removeRow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROW$4, paramInt);
    } 
  }
  
  public String getN() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(N$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetN() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(N$6);
      return xmlString;
    } 
  }
  
  public void setN(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(N$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(N$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetN(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(N$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(N$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public boolean getDel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL$8);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL$8);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEL$8) != null);
    } 
  }
  
  public void setDel(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEL$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDel(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DEL$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEL$8);
    } 
  }
  
  public long getIX() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IX$10);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIX() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IX$10);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetIX() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(IX$10) != null);
    } 
  }
  
  public void setIX(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IX$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IX$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIX(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IX$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(IX$10); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetIX() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(IX$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\SectionTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */