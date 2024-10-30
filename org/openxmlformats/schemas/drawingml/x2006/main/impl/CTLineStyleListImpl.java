package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;

public class CTLineStyleListImpl extends XmlComplexContentImpl implements CTLineStyleList {
  private static final b LN$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ln");
  
  public CTLineStyleListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTLineProperties> getLnList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLineProperties>)new LnList(this);
    } 
  }
  
  public CTLineProperties[] getLnArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LN$0, arrayList);
      CTLineProperties[] arrayOfCTLineProperties = new CTLineProperties[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLineProperties);
      return arrayOfCTLineProperties;
    } 
  }
  
  public CTLineProperties getLnArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LN$0, paramInt);
      if (cTLineProperties == null)
        throw new IndexOutOfBoundsException(); 
      return cTLineProperties;
    } 
  }
  
  public int sizeOfLnArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LN$0);
    } 
  }
  
  public void setLnArray(CTLineProperties[] paramArrayOfCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLineProperties, LN$0);
    } 
  }
  
  public void setLnArray(int paramInt, CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LN$0, paramInt);
      if (cTLineProperties == null)
        throw new IndexOutOfBoundsException(); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties insertNewLn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().insert_element_user(LN$0, paramInt);
      return cTLineProperties;
    } 
  }
  
  public CTLineProperties addNewLn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LN$0);
      return cTLineProperties;
    } 
  }
  
  public void removeLn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LN$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTLineStyleListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */