package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.CpType;
import com.microsoft.schemas.office.visio.x2012.main.FldType;
import com.microsoft.schemas.office.visio.x2012.main.PpType;
import com.microsoft.schemas.office.visio.x2012.main.TextType;
import com.microsoft.schemas.office.visio.x2012.main.TpType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class TextTypeImpl extends XmlComplexContentImpl implements TextType {
  private static final b CP$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "cp");
  
  private static final b PP$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "pp");
  
  private static final b TP$4 = new b("http://schemas.microsoft.com/office/visio/2012/main", "tp");
  
  private static final b FLD$6 = new b("http://schemas.microsoft.com/office/visio/2012/main", "fld");
  
  public TextTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CpType> getCpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CpType>)new CpList(this);
    } 
  }
  
  public CpType[] getCpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CP$0, arrayList);
      CpType[] arrayOfCpType = new CpType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCpType);
      return arrayOfCpType;
    } 
  }
  
  public CpType getCpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CpType cpType = null;
      cpType = (CpType)get_store().find_element_user(CP$0, paramInt);
      if (cpType == null)
        throw new IndexOutOfBoundsException(); 
      return cpType;
    } 
  }
  
  public int sizeOfCpArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CP$0);
    } 
  }
  
  public void setCpArray(CpType[] paramArrayOfCpType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCpType, CP$0);
    } 
  }
  
  public void setCpArray(int paramInt, CpType paramCpType) {
    synchronized (monitor()) {
      check_orphaned();
      CpType cpType = null;
      cpType = (CpType)get_store().find_element_user(CP$0, paramInt);
      if (cpType == null)
        throw new IndexOutOfBoundsException(); 
      cpType.set((XmlObject)paramCpType);
    } 
  }
  
  public CpType insertNewCp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CpType cpType = null;
      cpType = (CpType)get_store().insert_element_user(CP$0, paramInt);
      return cpType;
    } 
  }
  
  public CpType addNewCp() {
    synchronized (monitor()) {
      check_orphaned();
      CpType cpType = null;
      cpType = (CpType)get_store().add_element_user(CP$0);
      return cpType;
    } 
  }
  
  public void removeCp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CP$0, paramInt);
    } 
  }
  
  public List<PpType> getPpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<PpType>)new PpList(this);
    } 
  }
  
  public PpType[] getPpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PP$2, arrayList);
      PpType[] arrayOfPpType = new PpType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfPpType);
      return arrayOfPpType;
    } 
  }
  
  public PpType getPpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      PpType ppType = null;
      ppType = (PpType)get_store().find_element_user(PP$2, paramInt);
      if (ppType == null)
        throw new IndexOutOfBoundsException(); 
      return ppType;
    } 
  }
  
  public int sizeOfPpArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PP$2);
    } 
  }
  
  public void setPpArray(PpType[] paramArrayOfPpType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfPpType, PP$2);
    } 
  }
  
  public void setPpArray(int paramInt, PpType paramPpType) {
    synchronized (monitor()) {
      check_orphaned();
      PpType ppType = null;
      ppType = (PpType)get_store().find_element_user(PP$2, paramInt);
      if (ppType == null)
        throw new IndexOutOfBoundsException(); 
      ppType.set((XmlObject)paramPpType);
    } 
  }
  
  public PpType insertNewPp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      PpType ppType = null;
      ppType = (PpType)get_store().insert_element_user(PP$2, paramInt);
      return ppType;
    } 
  }
  
  public PpType addNewPp() {
    synchronized (monitor()) {
      check_orphaned();
      PpType ppType = null;
      ppType = (PpType)get_store().add_element_user(PP$2);
      return ppType;
    } 
  }
  
  public void removePp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PP$2, paramInt);
    } 
  }
  
  public List<TpType> getTpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<TpType>)new TpList(this);
    } 
  }
  
  public TpType[] getTpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TP$4, arrayList);
      TpType[] arrayOfTpType = new TpType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfTpType);
      return arrayOfTpType;
    } 
  }
  
  public TpType getTpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      TpType tpType = null;
      tpType = (TpType)get_store().find_element_user(TP$4, paramInt);
      if (tpType == null)
        throw new IndexOutOfBoundsException(); 
      return tpType;
    } 
  }
  
  public int sizeOfTpArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TP$4);
    } 
  }
  
  public void setTpArray(TpType[] paramArrayOfTpType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfTpType, TP$4);
    } 
  }
  
  public void setTpArray(int paramInt, TpType paramTpType) {
    synchronized (monitor()) {
      check_orphaned();
      TpType tpType = null;
      tpType = (TpType)get_store().find_element_user(TP$4, paramInt);
      if (tpType == null)
        throw new IndexOutOfBoundsException(); 
      tpType.set((XmlObject)paramTpType);
    } 
  }
  
  public TpType insertNewTp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      TpType tpType = null;
      tpType = (TpType)get_store().insert_element_user(TP$4, paramInt);
      return tpType;
    } 
  }
  
  public TpType addNewTp() {
    synchronized (monitor()) {
      check_orphaned();
      TpType tpType = null;
      tpType = (TpType)get_store().add_element_user(TP$4);
      return tpType;
    } 
  }
  
  public void removeTp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TP$4, paramInt);
    } 
  }
  
  public List<FldType> getFldList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<FldType>)new FldList(this);
    } 
  }
  
  public FldType[] getFldArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FLD$6, arrayList);
      FldType[] arrayOfFldType = new FldType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfFldType);
      return arrayOfFldType;
    } 
  }
  
  public FldType getFldArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      FldType fldType = null;
      fldType = (FldType)get_store().find_element_user(FLD$6, paramInt);
      if (fldType == null)
        throw new IndexOutOfBoundsException(); 
      return fldType;
    } 
  }
  
  public int sizeOfFldArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FLD$6);
    } 
  }
  
  public void setFldArray(FldType[] paramArrayOfFldType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfFldType, FLD$6);
    } 
  }
  
  public void setFldArray(int paramInt, FldType paramFldType) {
    synchronized (monitor()) {
      check_orphaned();
      FldType fldType = null;
      fldType = (FldType)get_store().find_element_user(FLD$6, paramInt);
      if (fldType == null)
        throw new IndexOutOfBoundsException(); 
      fldType.set((XmlObject)paramFldType);
    } 
  }
  
  public FldType insertNewFld(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      FldType fldType = null;
      fldType = (FldType)get_store().insert_element_user(FLD$6, paramInt);
      return fldType;
    } 
  }
  
  public FldType addNewFld() {
    synchronized (monitor()) {
      check_orphaned();
      FldType fldType = null;
      fldType = (FldType)get_store().add_element_user(FLD$6);
      return fldType;
    } 
  }
  
  public void removeFld(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FLD$6, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\TextTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */