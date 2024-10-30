package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import com.microsoft.schemas.office.visio.x2012.main.SheetType;
import com.microsoft.schemas.office.visio.x2012.main.TriggerType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class SheetTypeImpl extends XmlComplexContentImpl implements SheetType {
  private static final b CELL$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Cell");
  
  private static final b TRIGGER$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Trigger");
  
  private static final b SECTION$4 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Section");
  
  private static final b LINESTYLE$6 = new b("", "LineStyle");
  
  private static final b FILLSTYLE$8 = new b("", "FillStyle");
  
  private static final b TEXTSTYLE$10 = new b("", "TextStyle");
  
  public SheetTypeImpl(SchemaType paramSchemaType) {
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
  
  public List<SectionType> getSectionList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<SectionType>)new SectionList(this);
    } 
  }
  
  public SectionType[] getSectionArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SECTION$4, arrayList);
      SectionType[] arrayOfSectionType = new SectionType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSectionType);
      return arrayOfSectionType;
    } 
  }
  
  public SectionType getSectionArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SectionType sectionType = null;
      sectionType = (SectionType)get_store().find_element_user(SECTION$4, paramInt);
      if (sectionType == null)
        throw new IndexOutOfBoundsException(); 
      return sectionType;
    } 
  }
  
  public int sizeOfSectionArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SECTION$4);
    } 
  }
  
  public void setSectionArray(SectionType[] paramArrayOfSectionType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSectionType, SECTION$4);
    } 
  }
  
  public void setSectionArray(int paramInt, SectionType paramSectionType) {
    synchronized (monitor()) {
      check_orphaned();
      SectionType sectionType = null;
      sectionType = (SectionType)get_store().find_element_user(SECTION$4, paramInt);
      if (sectionType == null)
        throw new IndexOutOfBoundsException(); 
      sectionType.set((XmlObject)paramSectionType);
    } 
  }
  
  public SectionType insertNewSection(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SectionType sectionType = null;
      sectionType = (SectionType)get_store().insert_element_user(SECTION$4, paramInt);
      return sectionType;
    } 
  }
  
  public SectionType addNewSection() {
    synchronized (monitor()) {
      check_orphaned();
      SectionType sectionType = null;
      sectionType = (SectionType)get_store().add_element_user(SECTION$4);
      return sectionType;
    } 
  }
  
  public void removeSection(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SECTION$4, paramInt);
    } 
  }
  
  public long getLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINESTYLE$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LINESTYLE$6);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LINESTYLE$6) != null);
    } 
  }
  
  public void setLineStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINESTYLE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LINESTYLE$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetLineStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LINESTYLE$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(LINESTYLE$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LINESTYLE$6);
    } 
  }
  
  public long getFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLSTYLE$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FILLSTYLE$8);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLSTYLE$8) != null);
    } 
  }
  
  public void setFillStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLSTYLE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLSTYLE$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFillStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FILLSTYLE$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FILLSTYLE$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLSTYLE$8);
    } 
  }
  
  public long getTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTSTYLE$10);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TEXTSTYLE$10);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TEXTSTYLE$10) != null);
    } 
  }
  
  public void setTextStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTSTYLE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TEXTSTYLE$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTextStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TEXTSTYLE$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(TEXTSTYLE$10); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TEXTSTYLE$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\SheetTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */