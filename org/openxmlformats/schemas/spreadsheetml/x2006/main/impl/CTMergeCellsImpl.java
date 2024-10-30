package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;

public class CTMergeCellsImpl extends XmlComplexContentImpl implements CTMergeCells {
  private static final b MERGECELL$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "mergeCell");
  
  private static final b COUNT$2 = new b("", "count");
  
  public CTMergeCellsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTMergeCell> getMergeCellList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMergeCell>)new MergeCellList(this);
    } 
  }
  
  public CTMergeCell[] getMergeCellArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MERGECELL$0, arrayList);
      CTMergeCell[] arrayOfCTMergeCell = new CTMergeCell[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMergeCell);
      return arrayOfCTMergeCell;
    } 
  }
  
  public CTMergeCell getMergeCellArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMergeCell cTMergeCell = null;
      cTMergeCell = (CTMergeCell)get_store().find_element_user(MERGECELL$0, paramInt);
      if (cTMergeCell == null)
        throw new IndexOutOfBoundsException(); 
      return cTMergeCell;
    } 
  }
  
  public int sizeOfMergeCellArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MERGECELL$0);
    } 
  }
  
  public void setMergeCellArray(CTMergeCell[] paramArrayOfCTMergeCell) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMergeCell, MERGECELL$0);
    } 
  }
  
  public void setMergeCellArray(int paramInt, CTMergeCell paramCTMergeCell) {
    synchronized (monitor()) {
      check_orphaned();
      CTMergeCell cTMergeCell = null;
      cTMergeCell = (CTMergeCell)get_store().find_element_user(MERGECELL$0, paramInt);
      if (cTMergeCell == null)
        throw new IndexOutOfBoundsException(); 
      cTMergeCell.set((XmlObject)paramCTMergeCell);
    } 
  }
  
  public CTMergeCell insertNewMergeCell(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMergeCell cTMergeCell = null;
      cTMergeCell = (CTMergeCell)get_store().insert_element_user(MERGECELL$0, paramInt);
      return cTMergeCell;
    } 
  }
  
  public CTMergeCell addNewMergeCell() {
    synchronized (monitor()) {
      check_orphaned();
      CTMergeCell cTMergeCell = null;
      cTMergeCell = (CTMergeCell)get_store().add_element_user(MERGECELL$0);
      return cTMergeCell;
    } 
  }
  
  public void removeMergeCell(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MERGECELL$0, paramInt);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$2);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNT$2) != null);
    } 
  }
  
  public void setCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNT$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COUNT$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNT$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTMergeCellsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */