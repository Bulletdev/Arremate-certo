package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

public class CTPieChartImpl extends XmlComplexContentImpl implements CTPieChart {
  private static final b VARYCOLORS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors");
  
  private static final b SER$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser");
  
  private static final b DLBLS$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
  
  private static final b FIRSTSLICEANG$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "firstSliceAng");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTPieChartImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBoolean getVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(VARYCOLORS$0, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VARYCOLORS$0) != 0);
    } 
  }
  
  public void setVaryColors(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(VARYCOLORS$0, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(VARYCOLORS$0); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(VARYCOLORS$0);
      return cTBoolean;
    } 
  }
  
  public void unsetVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VARYCOLORS$0, 0);
    } 
  }
  
  public List<CTPieSer> getSerList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPieSer>)new SerList(this);
    } 
  }
  
  public CTPieSer[] getSerArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SER$2, arrayList);
      CTPieSer[] arrayOfCTPieSer = new CTPieSer[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPieSer);
      return arrayOfCTPieSer;
    } 
  }
  
  public CTPieSer getSerArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPieSer cTPieSer = null;
      cTPieSer = (CTPieSer)get_store().find_element_user(SER$2, paramInt);
      if (cTPieSer == null)
        throw new IndexOutOfBoundsException(); 
      return cTPieSer;
    } 
  }
  
  public int sizeOfSerArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SER$2);
    } 
  }
  
  public void setSerArray(CTPieSer[] paramArrayOfCTPieSer) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPieSer, SER$2);
    } 
  }
  
  public void setSerArray(int paramInt, CTPieSer paramCTPieSer) {
    synchronized (monitor()) {
      check_orphaned();
      CTPieSer cTPieSer = null;
      cTPieSer = (CTPieSer)get_store().find_element_user(SER$2, paramInt);
      if (cTPieSer == null)
        throw new IndexOutOfBoundsException(); 
      cTPieSer.set((XmlObject)paramCTPieSer);
    } 
  }
  
  public CTPieSer insertNewSer(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPieSer cTPieSer = null;
      cTPieSer = (CTPieSer)get_store().insert_element_user(SER$2, paramInt);
      return cTPieSer;
    } 
  }
  
  public CTPieSer addNewSer() {
    synchronized (monitor()) {
      check_orphaned();
      CTPieSer cTPieSer = null;
      cTPieSer = (CTPieSer)get_store().add_element_user(SER$2);
      return cTPieSer;
    } 
  }
  
  public void removeSer(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SER$2, paramInt);
    } 
  }
  
  public CTDLbls getDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().find_element_user(DLBLS$4, 0);
      if (cTDLbls == null)
        return null; 
      return cTDLbls;
    } 
  }
  
  public boolean isSetDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DLBLS$4) != 0);
    } 
  }
  
  public void setDLbls(CTDLbls paramCTDLbls) {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().find_element_user(DLBLS$4, 0);
      if (cTDLbls == null)
        cTDLbls = (CTDLbls)get_store().add_element_user(DLBLS$4); 
      cTDLbls.set((XmlObject)paramCTDLbls);
    } 
  }
  
  public CTDLbls addNewDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().add_element_user(DLBLS$4);
      return cTDLbls;
    } 
  }
  
  public void unsetDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DLBLS$4, 0);
    } 
  }
  
  public CTFirstSliceAng getFirstSliceAng() {
    synchronized (monitor()) {
      check_orphaned();
      CTFirstSliceAng cTFirstSliceAng = null;
      cTFirstSliceAng = (CTFirstSliceAng)get_store().find_element_user(FIRSTSLICEANG$6, 0);
      if (cTFirstSliceAng == null)
        return null; 
      return cTFirstSliceAng;
    } 
  }
  
  public boolean isSetFirstSliceAng() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FIRSTSLICEANG$6) != 0);
    } 
  }
  
  public void setFirstSliceAng(CTFirstSliceAng paramCTFirstSliceAng) {
    synchronized (monitor()) {
      check_orphaned();
      CTFirstSliceAng cTFirstSliceAng = null;
      cTFirstSliceAng = (CTFirstSliceAng)get_store().find_element_user(FIRSTSLICEANG$6, 0);
      if (cTFirstSliceAng == null)
        cTFirstSliceAng = (CTFirstSliceAng)get_store().add_element_user(FIRSTSLICEANG$6); 
      cTFirstSliceAng.set((XmlObject)paramCTFirstSliceAng);
    } 
  }
  
  public CTFirstSliceAng addNewFirstSliceAng() {
    synchronized (monitor()) {
      check_orphaned();
      CTFirstSliceAng cTFirstSliceAng = null;
      cTFirstSliceAng = (CTFirstSliceAng)get_store().add_element_user(FIRSTSLICEANG$6);
      return cTFirstSliceAng;
    } 
  }
  
  public void unsetFirstSliceAng() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIRSTSLICEANG$6, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTPieChartImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */