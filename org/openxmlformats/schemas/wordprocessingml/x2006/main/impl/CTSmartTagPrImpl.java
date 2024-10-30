package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAttr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr;

public class CTSmartTagPrImpl extends XmlComplexContentImpl implements CTSmartTagPr {
  private static final b ATTR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attr");
  
  public CTSmartTagPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTAttr> getAttrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAttr>)new AttrList(this);
    } 
  }
  
  public CTAttr[] getAttrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ATTR$0, arrayList);
      CTAttr[] arrayOfCTAttr = new CTAttr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAttr);
      return arrayOfCTAttr;
    } 
  }
  
  public CTAttr getAttrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAttr cTAttr = null;
      cTAttr = (CTAttr)get_store().find_element_user(ATTR$0, paramInt);
      if (cTAttr == null)
        throw new IndexOutOfBoundsException(); 
      return cTAttr;
    } 
  }
  
  public int sizeOfAttrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ATTR$0);
    } 
  }
  
  public void setAttrArray(CTAttr[] paramArrayOfCTAttr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAttr, ATTR$0);
    } 
  }
  
  public void setAttrArray(int paramInt, CTAttr paramCTAttr) {
    synchronized (monitor()) {
      check_orphaned();
      CTAttr cTAttr = null;
      cTAttr = (CTAttr)get_store().find_element_user(ATTR$0, paramInt);
      if (cTAttr == null)
        throw new IndexOutOfBoundsException(); 
      cTAttr.set((XmlObject)paramCTAttr);
    } 
  }
  
  public CTAttr insertNewAttr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAttr cTAttr = null;
      cTAttr = (CTAttr)get_store().insert_element_user(ATTR$0, paramInt);
      return cTAttr;
    } 
  }
  
  public CTAttr addNewAttr() {
    synchronized (monitor()) {
      check_orphaned();
      CTAttr cTAttr = null;
      cTAttr = (CTAttr)get_store().add_element_user(ATTR$0);
      return cTAttr;
    } 
  }
  
  public void removeAttr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ATTR$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSmartTagPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */