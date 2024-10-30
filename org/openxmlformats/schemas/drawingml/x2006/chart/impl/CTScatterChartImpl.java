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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

public class CTScatterChartImpl extends XmlComplexContentImpl implements CTScatterChart {
  private static final b SCATTERSTYLE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "scatterStyle");
  
  private static final b VARYCOLORS$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors");
  
  private static final b SER$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser");
  
  private static final b DLBLS$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
  
  private static final b AXID$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId");
  
  private static final b EXTLST$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTScatterChartImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTScatterStyle getScatterStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterStyle cTScatterStyle = null;
      cTScatterStyle = (CTScatterStyle)get_store().find_element_user(SCATTERSTYLE$0, 0);
      if (cTScatterStyle == null)
        return null; 
      return cTScatterStyle;
    } 
  }
  
  public void setScatterStyle(CTScatterStyle paramCTScatterStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterStyle cTScatterStyle = null;
      cTScatterStyle = (CTScatterStyle)get_store().find_element_user(SCATTERSTYLE$0, 0);
      if (cTScatterStyle == null)
        cTScatterStyle = (CTScatterStyle)get_store().add_element_user(SCATTERSTYLE$0); 
      cTScatterStyle.set((XmlObject)paramCTScatterStyle);
    } 
  }
  
  public CTScatterStyle addNewScatterStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterStyle cTScatterStyle = null;
      cTScatterStyle = (CTScatterStyle)get_store().add_element_user(SCATTERSTYLE$0);
      return cTScatterStyle;
    } 
  }
  
  public CTBoolean getVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(VARYCOLORS$2, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VARYCOLORS$2) != 0);
    } 
  }
  
  public void setVaryColors(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(VARYCOLORS$2, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(VARYCOLORS$2); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(VARYCOLORS$2);
      return cTBoolean;
    } 
  }
  
  public void unsetVaryColors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VARYCOLORS$2, 0);
    } 
  }
  
  public List<CTScatterSer> getSerList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTScatterSer>)new SerList(this);
    } 
  }
  
  public CTScatterSer[] getSerArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SER$4, arrayList);
      CTScatterSer[] arrayOfCTScatterSer = new CTScatterSer[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTScatterSer);
      return arrayOfCTScatterSer;
    } 
  }
  
  public CTScatterSer getSerArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterSer cTScatterSer = null;
      cTScatterSer = (CTScatterSer)get_store().find_element_user(SER$4, paramInt);
      if (cTScatterSer == null)
        throw new IndexOutOfBoundsException(); 
      return cTScatterSer;
    } 
  }
  
  public int sizeOfSerArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SER$4);
    } 
  }
  
  public void setSerArray(CTScatterSer[] paramArrayOfCTScatterSer) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTScatterSer, SER$4);
    } 
  }
  
  public void setSerArray(int paramInt, CTScatterSer paramCTScatterSer) {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterSer cTScatterSer = null;
      cTScatterSer = (CTScatterSer)get_store().find_element_user(SER$4, paramInt);
      if (cTScatterSer == null)
        throw new IndexOutOfBoundsException(); 
      cTScatterSer.set((XmlObject)paramCTScatterSer);
    } 
  }
  
  public CTScatterSer insertNewSer(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterSer cTScatterSer = null;
      cTScatterSer = (CTScatterSer)get_store().insert_element_user(SER$4, paramInt);
      return cTScatterSer;
    } 
  }
  
  public CTScatterSer addNewSer() {
    synchronized (monitor()) {
      check_orphaned();
      CTScatterSer cTScatterSer = null;
      cTScatterSer = (CTScatterSer)get_store().add_element_user(SER$4);
      return cTScatterSer;
    } 
  }
  
  public void removeSer(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SER$4, paramInt);
    } 
  }
  
  public CTDLbls getDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().find_element_user(DLBLS$6, 0);
      if (cTDLbls == null)
        return null; 
      return cTDLbls;
    } 
  }
  
  public boolean isSetDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DLBLS$6) != 0);
    } 
  }
  
  public void setDLbls(CTDLbls paramCTDLbls) {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().find_element_user(DLBLS$6, 0);
      if (cTDLbls == null)
        cTDLbls = (CTDLbls)get_store().add_element_user(DLBLS$6); 
      cTDLbls.set((XmlObject)paramCTDLbls);
    } 
  }
  
  public CTDLbls addNewDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().add_element_user(DLBLS$6);
      return cTDLbls;
    } 
  }
  
  public void unsetDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DLBLS$6, 0);
    } 
  }
  
  public List<CTUnsignedInt> getAxIdList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTUnsignedInt>)new AxIdList(this);
    } 
  }
  
  public CTUnsignedInt[] getAxIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AXID$8, arrayList);
      CTUnsignedInt[] arrayOfCTUnsignedInt = new CTUnsignedInt[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTUnsignedInt);
      return arrayOfCTUnsignedInt;
    } 
  }
  
  public CTUnsignedInt getAxIdArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(AXID$8, paramInt);
      if (cTUnsignedInt == null)
        throw new IndexOutOfBoundsException(); 
      return cTUnsignedInt;
    } 
  }
  
  public int sizeOfAxIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AXID$8);
    } 
  }
  
  public void setAxIdArray(CTUnsignedInt[] paramArrayOfCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTUnsignedInt, AXID$8);
    } 
  }
  
  public void setAxIdArray(int paramInt, CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(AXID$8, paramInt);
      if (cTUnsignedInt == null)
        throw new IndexOutOfBoundsException(); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt insertNewAxId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().insert_element_user(AXID$8, paramInt);
      return cTUnsignedInt;
    } 
  }
  
  public CTUnsignedInt addNewAxId() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(AXID$8);
      return cTUnsignedInt;
    } 
  }
  
  public void removeAxId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AXID$8, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$10, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$10) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$10, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$10); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$10);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$10, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTScatterChartImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */