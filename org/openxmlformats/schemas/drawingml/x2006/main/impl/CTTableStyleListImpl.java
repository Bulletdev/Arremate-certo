package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

public class CTTableStyleListImpl extends XmlComplexContentImpl implements CTTableStyleList {
  private static final b TBLSTYLE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tblStyle");
  
  private static final b DEF$2 = new b("", "def");
  
  public CTTableStyleListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTableStyle> getTblStyleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTableStyle>)new TblStyleList(this);
    } 
  }
  
  public CTTableStyle[] getTblStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TBLSTYLE$0, arrayList);
      CTTableStyle[] arrayOfCTTableStyle = new CTTableStyle[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTableStyle);
      return arrayOfCTTableStyle;
    } 
  }
  
  public CTTableStyle getTblStyleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyle cTTableStyle = null;
      cTTableStyle = (CTTableStyle)get_store().find_element_user(TBLSTYLE$0, paramInt);
      if (cTTableStyle == null)
        throw new IndexOutOfBoundsException(); 
      return cTTableStyle;
    } 
  }
  
  public int sizeOfTblStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TBLSTYLE$0);
    } 
  }
  
  public void setTblStyleArray(CTTableStyle[] paramArrayOfCTTableStyle) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTableStyle, TBLSTYLE$0);
    } 
  }
  
  public void setTblStyleArray(int paramInt, CTTableStyle paramCTTableStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyle cTTableStyle = null;
      cTTableStyle = (CTTableStyle)get_store().find_element_user(TBLSTYLE$0, paramInt);
      if (cTTableStyle == null)
        throw new IndexOutOfBoundsException(); 
      cTTableStyle.set((XmlObject)paramCTTableStyle);
    } 
  }
  
  public CTTableStyle insertNewTblStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyle cTTableStyle = null;
      cTTableStyle = (CTTableStyle)get_store().insert_element_user(TBLSTYLE$0, paramInt);
      return cTTableStyle;
    } 
  }
  
  public CTTableStyle addNewTblStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyle cTTableStyle = null;
      cTTableStyle = (CTTableStyle)get_store().add_element_user(TBLSTYLE$0);
      return cTTableStyle;
    } 
  }
  
  public void removeTblStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLSTYLE$0, paramInt);
    } 
  }
  
  public String getDef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEF$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STGuid xgetDef() {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(DEF$2);
      return sTGuid;
    } 
  }
  
  public void setDef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEF$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEF$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDef(STGuid paramSTGuid) {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(DEF$2);
      if (sTGuid == null)
        sTGuid = (STGuid)get_store().add_attribute_user(DEF$2); 
      sTGuid.set((XmlObject)paramSTGuid);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableStyleListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */