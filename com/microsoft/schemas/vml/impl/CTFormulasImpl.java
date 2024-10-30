package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTF;
import com.microsoft.schemas.vml.CTFormulas;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTFormulasImpl extends XmlComplexContentImpl implements CTFormulas {
  private static final b F$0 = new b("urn:schemas-microsoft-com:vml", "f");
  
  public CTFormulasImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTF> getFList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTF>)new FList(this);
    } 
  }
  
  public CTF[] getFArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(F$0, arrayList);
      CTF[] arrayOfCTF = new CTF[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTF);
      return arrayOfCTF;
    } 
  }
  
  public CTF getFArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().find_element_user(F$0, paramInt);
      if (cTF == null)
        throw new IndexOutOfBoundsException(); 
      return cTF;
    } 
  }
  
  public int sizeOfFArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(F$0);
    } 
  }
  
  public void setFArray(CTF[] paramArrayOfCTF) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTF, F$0);
    } 
  }
  
  public void setFArray(int paramInt, CTF paramCTF) {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().find_element_user(F$0, paramInt);
      if (cTF == null)
        throw new IndexOutOfBoundsException(); 
      cTF.set((XmlObject)paramCTF);
    } 
  }
  
  public CTF insertNewF(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().insert_element_user(F$0, paramInt);
      return cTF;
    } 
  }
  
  public CTF addNewF() {
    synchronized (monitor()) {
      check_orphaned();
      CTF cTF = null;
      cTF = (CTF)get_store().add_element_user(F$0);
      return cTF;
    } 
  }
  
  public void removeF(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(F$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTFormulasImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */