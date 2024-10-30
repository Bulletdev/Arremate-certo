package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr;

public class CTSdtEndPrImpl extends XmlComplexContentImpl implements CTSdtEndPr {
  private static final b RPR$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
  
  public CTSdtEndPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTRPr> getRPrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRPr>)new RPrList(this);
    } 
  }
  
  public CTRPr[] getRPrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RPR$0, arrayList);
      CTRPr[] arrayOfCTRPr = new CTRPr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRPr);
      return arrayOfCTRPr;
    } 
  }
  
  public CTRPr getRPrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, paramInt);
      if (cTRPr == null)
        throw new IndexOutOfBoundsException(); 
      return cTRPr;
    } 
  }
  
  public int sizeOfRPrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RPR$0);
    } 
  }
  
  public void setRPrArray(CTRPr[] paramArrayOfCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRPr, RPR$0);
    } 
  }
  
  public void setRPrArray(int paramInt, CTRPr paramCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$0, paramInt);
      if (cTRPr == null)
        throw new IndexOutOfBoundsException(); 
      cTRPr.set((XmlObject)paramCTRPr);
    } 
  }
  
  public CTRPr insertNewRPr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().insert_element_user(RPR$0, paramInt);
      return cTRPr;
    } 
  }
  
  public CTRPr addNewRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().add_element_user(RPR$0);
      return cTRPr;
    } 
  }
  
  public void removeRPr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSdtEndPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */