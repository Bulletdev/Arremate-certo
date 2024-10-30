package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

public class CTStrDataImpl extends XmlComplexContentImpl implements CTStrData {
  private static final b PTCOUNT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "ptCount");
  
  private static final b PT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pt");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTStrDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTUnsignedInt getPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(PTCOUNT$0, 0);
      if (cTUnsignedInt == null)
        return null; 
      return cTUnsignedInt;
    } 
  }
  
  public boolean isSetPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PTCOUNT$0) != 0);
    } 
  }
  
  public void setPtCount(CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(PTCOUNT$0, 0);
      if (cTUnsignedInt == null)
        cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(PTCOUNT$0); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt addNewPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(PTCOUNT$0);
      return cTUnsignedInt;
    } 
  }
  
  public void unsetPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PTCOUNT$0, 0);
    } 
  }
  
  public List<CTStrVal> getPtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTStrVal>)new PtList(this);
    } 
  }
  
  public CTStrVal[] getPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PT$2, arrayList);
      CTStrVal[] arrayOfCTStrVal = new CTStrVal[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTStrVal);
      return arrayOfCTStrVal;
    } 
  }
  
  public CTStrVal getPtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrVal cTStrVal = null;
      cTStrVal = (CTStrVal)get_store().find_element_user(PT$2, paramInt);
      if (cTStrVal == null)
        throw new IndexOutOfBoundsException(); 
      return cTStrVal;
    } 
  }
  
  public int sizeOfPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PT$2);
    } 
  }
  
  public void setPtArray(CTStrVal[] paramArrayOfCTStrVal) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTStrVal, PT$2);
    } 
  }
  
  public void setPtArray(int paramInt, CTStrVal paramCTStrVal) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrVal cTStrVal = null;
      cTStrVal = (CTStrVal)get_store().find_element_user(PT$2, paramInt);
      if (cTStrVal == null)
        throw new IndexOutOfBoundsException(); 
      cTStrVal.set((XmlObject)paramCTStrVal);
    } 
  }
  
  public CTStrVal insertNewPt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrVal cTStrVal = null;
      cTStrVal = (CTStrVal)get_store().insert_element_user(PT$2, paramInt);
      return cTStrVal;
    } 
  }
  
  public CTStrVal addNewPt() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrVal cTStrVal = null;
      cTStrVal = (CTStrVal)get_store().add_element_user(PT$2);
      return cTStrVal;
    } 
  }
  
  public void removePt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PT$2, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTStrDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */