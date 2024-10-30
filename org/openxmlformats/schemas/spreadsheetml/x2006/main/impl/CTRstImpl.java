package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticRun;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTRstImpl extends XmlComplexContentImpl implements CTRst {
  private static final b T$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "t");
  
  private static final b R$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "r");
  
  private static final b RPH$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rPh");
  
  private static final b PHONETICPR$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "phoneticPr");
  
  public CTRstImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(T$0, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(T$0) != 0);
    } 
  }
  
  public void setT(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(T$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(T$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetT(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(T$0, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(T$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(T$0, 0);
    } 
  }
  
  public List<CTRElt> getRList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRElt>)new RList(this);
    } 
  }
  
  public CTRElt[] getRArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R$2, arrayList);
      CTRElt[] arrayOfCTRElt = new CTRElt[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRElt);
      return arrayOfCTRElt;
    } 
  }
  
  public CTRElt getRArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRElt cTRElt = null;
      cTRElt = (CTRElt)get_store().find_element_user(R$2, paramInt);
      if (cTRElt == null)
        throw new IndexOutOfBoundsException(); 
      return cTRElt;
    } 
  }
  
  public int sizeOfRArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(R$2);
    } 
  }
  
  public void setRArray(CTRElt[] paramArrayOfCTRElt) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRElt, R$2);
    } 
  }
  
  public void setRArray(int paramInt, CTRElt paramCTRElt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRElt cTRElt = null;
      cTRElt = (CTRElt)get_store().find_element_user(R$2, paramInt);
      if (cTRElt == null)
        throw new IndexOutOfBoundsException(); 
      cTRElt.set((XmlObject)paramCTRElt);
    } 
  }
  
  public CTRElt insertNewR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRElt cTRElt = null;
      cTRElt = (CTRElt)get_store().insert_element_user(R$2, paramInt);
      return cTRElt;
    } 
  }
  
  public CTRElt addNewR() {
    synchronized (monitor()) {
      check_orphaned();
      CTRElt cTRElt = null;
      cTRElt = (CTRElt)get_store().add_element_user(R$2);
      return cTRElt;
    } 
  }
  
  public void removeR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R$2, paramInt);
    } 
  }
  
  public List<CTPhoneticRun> getRPhList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPhoneticRun>)new RPhList(this);
    } 
  }
  
  public CTPhoneticRun[] getRPhArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RPH$4, arrayList);
      CTPhoneticRun[] arrayOfCTPhoneticRun = new CTPhoneticRun[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPhoneticRun);
      return arrayOfCTPhoneticRun;
    } 
  }
  
  public CTPhoneticRun getRPhArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticRun cTPhoneticRun = null;
      cTPhoneticRun = (CTPhoneticRun)get_store().find_element_user(RPH$4, paramInt);
      if (cTPhoneticRun == null)
        throw new IndexOutOfBoundsException(); 
      return cTPhoneticRun;
    } 
  }
  
  public int sizeOfRPhArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RPH$4);
    } 
  }
  
  public void setRPhArray(CTPhoneticRun[] paramArrayOfCTPhoneticRun) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPhoneticRun, RPH$4);
    } 
  }
  
  public void setRPhArray(int paramInt, CTPhoneticRun paramCTPhoneticRun) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticRun cTPhoneticRun = null;
      cTPhoneticRun = (CTPhoneticRun)get_store().find_element_user(RPH$4, paramInt);
      if (cTPhoneticRun == null)
        throw new IndexOutOfBoundsException(); 
      cTPhoneticRun.set((XmlObject)paramCTPhoneticRun);
    } 
  }
  
  public CTPhoneticRun insertNewRPh(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticRun cTPhoneticRun = null;
      cTPhoneticRun = (CTPhoneticRun)get_store().insert_element_user(RPH$4, paramInt);
      return cTPhoneticRun;
    } 
  }
  
  public CTPhoneticRun addNewRPh() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticRun cTPhoneticRun = null;
      cTPhoneticRun = (CTPhoneticRun)get_store().add_element_user(RPH$4);
      return cTPhoneticRun;
    } 
  }
  
  public void removeRPh(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPH$4, paramInt);
    } 
  }
  
  public CTPhoneticPr getPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticPr cTPhoneticPr = null;
      cTPhoneticPr = (CTPhoneticPr)get_store().find_element_user(PHONETICPR$6, 0);
      if (cTPhoneticPr == null)
        return null; 
      return cTPhoneticPr;
    } 
  }
  
  public boolean isSetPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PHONETICPR$6) != 0);
    } 
  }
  
  public void setPhoneticPr(CTPhoneticPr paramCTPhoneticPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticPr cTPhoneticPr = null;
      cTPhoneticPr = (CTPhoneticPr)get_store().find_element_user(PHONETICPR$6, 0);
      if (cTPhoneticPr == null)
        cTPhoneticPr = (CTPhoneticPr)get_store().add_element_user(PHONETICPR$6); 
      cTPhoneticPr.set((XmlObject)paramCTPhoneticPr);
    } 
  }
  
  public CTPhoneticPr addNewPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPhoneticPr cTPhoneticPr = null;
      cTPhoneticPr = (CTPhoneticPr)get_store().add_element_user(PHONETICPR$6);
      return cTPhoneticPr;
    } 
  }
  
  public void unsetPhoneticPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PHONETICPR$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTRstImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */