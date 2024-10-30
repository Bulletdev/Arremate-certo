package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList;

public class CTEffectStyleListImpl extends XmlComplexContentImpl implements CTEffectStyleList {
  private static final b EFFECTSTYLE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectStyle");
  
  public CTEffectStyleListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTEffectStyleItem> getEffectStyleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEffectStyleItem>)new EffectStyleList(this);
    } 
  }
  
  public CTEffectStyleItem[] getEffectStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EFFECTSTYLE$0, arrayList);
      CTEffectStyleItem[] arrayOfCTEffectStyleItem = new CTEffectStyleItem[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEffectStyleItem);
      return arrayOfCTEffectStyleItem;
    } 
  }
  
  public CTEffectStyleItem getEffectStyleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectStyleItem cTEffectStyleItem = null;
      cTEffectStyleItem = (CTEffectStyleItem)get_store().find_element_user(EFFECTSTYLE$0, paramInt);
      if (cTEffectStyleItem == null)
        throw new IndexOutOfBoundsException(); 
      return cTEffectStyleItem;
    } 
  }
  
  public int sizeOfEffectStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EFFECTSTYLE$0);
    } 
  }
  
  public void setEffectStyleArray(CTEffectStyleItem[] paramArrayOfCTEffectStyleItem) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEffectStyleItem, EFFECTSTYLE$0);
    } 
  }
  
  public void setEffectStyleArray(int paramInt, CTEffectStyleItem paramCTEffectStyleItem) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectStyleItem cTEffectStyleItem = null;
      cTEffectStyleItem = (CTEffectStyleItem)get_store().find_element_user(EFFECTSTYLE$0, paramInt);
      if (cTEffectStyleItem == null)
        throw new IndexOutOfBoundsException(); 
      cTEffectStyleItem.set((XmlObject)paramCTEffectStyleItem);
    } 
  }
  
  public CTEffectStyleItem insertNewEffectStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectStyleItem cTEffectStyleItem = null;
      cTEffectStyleItem = (CTEffectStyleItem)get_store().insert_element_user(EFFECTSTYLE$0, paramInt);
      return cTEffectStyleItem;
    } 
  }
  
  public CTEffectStyleItem addNewEffectStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectStyleItem cTEffectStyleItem = null;
      cTEffectStyleItem = (CTEffectStyleItem)get_store().add_element_user(EFFECTSTYLE$0);
      return cTEffectStyleItem;
    } 
  }
  
  public void removeEffectStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTSTYLE$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTEffectStyleListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */