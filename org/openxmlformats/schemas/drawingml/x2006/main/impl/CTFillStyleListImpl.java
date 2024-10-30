package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;

public class CTFillStyleListImpl extends XmlComplexContentImpl implements CTFillStyleList {
  private static final b NOFILL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  public CTFillStyleListImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTNoFillProperties> getNoFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNoFillProperties>)new NoFillList(this);
    } 
  }
  
  public CTNoFillProperties[] getNoFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NOFILL$0, arrayList);
      CTNoFillProperties[] arrayOfCTNoFillProperties = new CTNoFillProperties[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNoFillProperties);
      return arrayOfCTNoFillProperties;
    } 
  }
  
  public CTNoFillProperties getNoFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$0, paramInt);
      if (cTNoFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      return cTNoFillProperties;
    } 
  }
  
  public int sizeOfNoFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NOFILL$0);
    } 
  }
  
  public void setNoFillArray(CTNoFillProperties[] paramArrayOfCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNoFillProperties, NOFILL$0);
    } 
  }
  
  public void setNoFillArray(int paramInt, CTNoFillProperties paramCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$0, paramInt);
      if (cTNoFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      cTNoFillProperties.set((XmlObject)paramCTNoFillProperties);
    } 
  }
  
  public CTNoFillProperties insertNewNoFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().insert_element_user(NOFILL$0, paramInt);
      return cTNoFillProperties;
    } 
  }
  
  public CTNoFillProperties addNewNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$0);
      return cTNoFillProperties;
    } 
  }
  
  public void removeNoFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOFILL$0, paramInt);
    } 
  }
  
  public List<CTSolidColorFillProperties> getSolidFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSolidColorFillProperties>)new SolidFillList(this);
    } 
  }
  
  public CTSolidColorFillProperties[] getSolidFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SOLIDFILL$2, arrayList);
      CTSolidColorFillProperties[] arrayOfCTSolidColorFillProperties = new CTSolidColorFillProperties[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSolidColorFillProperties);
      return arrayOfCTSolidColorFillProperties;
    } 
  }
  
  public CTSolidColorFillProperties getSolidFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$2, paramInt);
      if (cTSolidColorFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      return cTSolidColorFillProperties;
    } 
  }
  
  public int sizeOfSolidFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SOLIDFILL$2);
    } 
  }
  
  public void setSolidFillArray(CTSolidColorFillProperties[] paramArrayOfCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSolidColorFillProperties, SOLIDFILL$2);
    } 
  }
  
  public void setSolidFillArray(int paramInt, CTSolidColorFillProperties paramCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$2, paramInt);
      if (cTSolidColorFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      cTSolidColorFillProperties.set((XmlObject)paramCTSolidColorFillProperties);
    } 
  }
  
  public CTSolidColorFillProperties insertNewSolidFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().insert_element_user(SOLIDFILL$2, paramInt);
      return cTSolidColorFillProperties;
    } 
  }
  
  public CTSolidColorFillProperties addNewSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$2);
      return cTSolidColorFillProperties;
    } 
  }
  
  public void removeSolidFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOLIDFILL$2, paramInt);
    } 
  }
  
  public List<CTGradientFillProperties> getGradFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGradientFillProperties>)new GradFillList(this);
    } 
  }
  
  public CTGradientFillProperties[] getGradFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRADFILL$4, arrayList);
      CTGradientFillProperties[] arrayOfCTGradientFillProperties = new CTGradientFillProperties[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGradientFillProperties);
      return arrayOfCTGradientFillProperties;
    } 
  }
  
  public CTGradientFillProperties getGradFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$4, paramInt);
      if (cTGradientFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      return cTGradientFillProperties;
    } 
  }
  
  public int sizeOfGradFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRADFILL$4);
    } 
  }
  
  public void setGradFillArray(CTGradientFillProperties[] paramArrayOfCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGradientFillProperties, GRADFILL$4);
    } 
  }
  
  public void setGradFillArray(int paramInt, CTGradientFillProperties paramCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$4, paramInt);
      if (cTGradientFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      cTGradientFillProperties.set((XmlObject)paramCTGradientFillProperties);
    } 
  }
  
  public CTGradientFillProperties insertNewGradFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().insert_element_user(GRADFILL$4, paramInt);
      return cTGradientFillProperties;
    } 
  }
  
  public CTGradientFillProperties addNewGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$4);
      return cTGradientFillProperties;
    } 
  }
  
  public void removeGradFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADFILL$4, paramInt);
    } 
  }
  
  public List<CTBlipFillProperties> getBlipFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBlipFillProperties>)new BlipFillList(this);
    } 
  }
  
  public CTBlipFillProperties[] getBlipFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BLIPFILL$6, arrayList);
      CTBlipFillProperties[] arrayOfCTBlipFillProperties = new CTBlipFillProperties[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBlipFillProperties);
      return arrayOfCTBlipFillProperties;
    } 
  }
  
  public CTBlipFillProperties getBlipFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$6, paramInt);
      if (cTBlipFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      return cTBlipFillProperties;
    } 
  }
  
  public int sizeOfBlipFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BLIPFILL$6);
    } 
  }
  
  public void setBlipFillArray(CTBlipFillProperties[] paramArrayOfCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBlipFillProperties, BLIPFILL$6);
    } 
  }
  
  public void setBlipFillArray(int paramInt, CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$6, paramInt);
      if (cTBlipFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties insertNewBlipFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().insert_element_user(BLIPFILL$6, paramInt);
      return cTBlipFillProperties;
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$6);
      return cTBlipFillProperties;
    } 
  }
  
  public void removeBlipFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIPFILL$6, paramInt);
    } 
  }
  
  public List<CTPatternFillProperties> getPattFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPatternFillProperties>)new PattFillList(this);
    } 
  }
  
  public CTPatternFillProperties[] getPattFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PATTFILL$8, arrayList);
      CTPatternFillProperties[] arrayOfCTPatternFillProperties = new CTPatternFillProperties[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPatternFillProperties);
      return arrayOfCTPatternFillProperties;
    } 
  }
  
  public CTPatternFillProperties getPattFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$8, paramInt);
      if (cTPatternFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      return cTPatternFillProperties;
    } 
  }
  
  public int sizeOfPattFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PATTFILL$8);
    } 
  }
  
  public void setPattFillArray(CTPatternFillProperties[] paramArrayOfCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPatternFillProperties, PATTFILL$8);
    } 
  }
  
  public void setPattFillArray(int paramInt, CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$8, paramInt);
      if (cTPatternFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties insertNewPattFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().insert_element_user(PATTFILL$8, paramInt);
      return cTPatternFillProperties;
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$8);
      return cTPatternFillProperties;
    } 
  }
  
  public void removePattFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$8, paramInt);
    } 
  }
  
  public List<CTGroupFillProperties> getGrpFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGroupFillProperties>)new GrpFillList(this);
    } 
  }
  
  public CTGroupFillProperties[] getGrpFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRPFILL$10, arrayList);
      CTGroupFillProperties[] arrayOfCTGroupFillProperties = new CTGroupFillProperties[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGroupFillProperties);
      return arrayOfCTGroupFillProperties;
    } 
  }
  
  public CTGroupFillProperties getGrpFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$10, paramInt);
      if (cTGroupFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      return cTGroupFillProperties;
    } 
  }
  
  public int sizeOfGrpFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRPFILL$10);
    } 
  }
  
  public void setGrpFillArray(CTGroupFillProperties[] paramArrayOfCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGroupFillProperties, GRPFILL$10);
    } 
  }
  
  public void setGrpFillArray(int paramInt, CTGroupFillProperties paramCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$10, paramInt);
      if (cTGroupFillProperties == null)
        throw new IndexOutOfBoundsException(); 
      cTGroupFillProperties.set((XmlObject)paramCTGroupFillProperties);
    } 
  }
  
  public CTGroupFillProperties insertNewGrpFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().insert_element_user(GRPFILL$10, paramInt);
      return cTGroupFillProperties;
    } 
  }
  
  public CTGroupFillProperties addNewGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$10);
      return cTGroupFillProperties;
    } 
  }
  
  public void removeGrpFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPFILL$10, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTFillStyleListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */