package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTGrouping;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUpDownBars;

public class CTLineChartImpl extends XmlComplexContentImpl implements CTLineChart {
  private static final b GROUPING$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "grouping");
  
  private static final b VARYCOLORS$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors");
  
  private static final b SER$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser");
  
  private static final b DLBLS$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
  
  private static final b DROPLINES$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dropLines");
  
  private static final b HILOWLINES$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "hiLowLines");
  
  private static final b UPDOWNBARS$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "upDownBars");
  
  private static final b MARKER$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "marker");
  
  private static final b SMOOTH$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "smooth");
  
  private static final b AXID$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId");
  
  private static final b EXTLST$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTLineChartImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGrouping getGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      CTGrouping cTGrouping = null;
      cTGrouping = (CTGrouping)get_store().find_element_user(GROUPING$0, 0);
      if (cTGrouping == null)
        return null; 
      return cTGrouping;
    } 
  }
  
  public void setGrouping(CTGrouping paramCTGrouping) {
    synchronized (monitor()) {
      check_orphaned();
      CTGrouping cTGrouping = null;
      cTGrouping = (CTGrouping)get_store().find_element_user(GROUPING$0, 0);
      if (cTGrouping == null)
        cTGrouping = (CTGrouping)get_store().add_element_user(GROUPING$0); 
      cTGrouping.set((XmlObject)paramCTGrouping);
    } 
  }
  
  public CTGrouping addNewGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      CTGrouping cTGrouping = null;
      cTGrouping = (CTGrouping)get_store().add_element_user(GROUPING$0);
      return cTGrouping;
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
  
  public List<CTLineSer> getSerList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLineSer>)new SerList(this);
    } 
  }
  
  public CTLineSer[] getSerArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SER$4, arrayList);
      CTLineSer[] arrayOfCTLineSer = new CTLineSer[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLineSer);
      return arrayOfCTLineSer;
    } 
  }
  
  public CTLineSer getSerArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineSer cTLineSer = null;
      cTLineSer = (CTLineSer)get_store().find_element_user(SER$4, paramInt);
      if (cTLineSer == null)
        throw new IndexOutOfBoundsException(); 
      return cTLineSer;
    } 
  }
  
  public int sizeOfSerArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SER$4);
    } 
  }
  
  public void setSerArray(CTLineSer[] paramArrayOfCTLineSer) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLineSer, SER$4);
    } 
  }
  
  public void setSerArray(int paramInt, CTLineSer paramCTLineSer) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineSer cTLineSer = null;
      cTLineSer = (CTLineSer)get_store().find_element_user(SER$4, paramInt);
      if (cTLineSer == null)
        throw new IndexOutOfBoundsException(); 
      cTLineSer.set((XmlObject)paramCTLineSer);
    } 
  }
  
  public CTLineSer insertNewSer(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineSer cTLineSer = null;
      cTLineSer = (CTLineSer)get_store().insert_element_user(SER$4, paramInt);
      return cTLineSer;
    } 
  }
  
  public CTLineSer addNewSer() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineSer cTLineSer = null;
      cTLineSer = (CTLineSer)get_store().add_element_user(SER$4);
      return cTLineSer;
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
  
  public CTChartLines getDropLines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(DROPLINES$8, 0);
      if (cTChartLines == null)
        return null; 
      return cTChartLines;
    } 
  }
  
  public boolean isSetDropLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DROPLINES$8) != 0);
    } 
  }
  
  public void setDropLines(CTChartLines paramCTChartLines) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(DROPLINES$8, 0);
      if (cTChartLines == null)
        cTChartLines = (CTChartLines)get_store().add_element_user(DROPLINES$8); 
      cTChartLines.set((XmlObject)paramCTChartLines);
    } 
  }
  
  public CTChartLines addNewDropLines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().add_element_user(DROPLINES$8);
      return cTChartLines;
    } 
  }
  
  public void unsetDropLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DROPLINES$8, 0);
    } 
  }
  
  public CTChartLines getHiLowLines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(HILOWLINES$10, 0);
      if (cTChartLines == null)
        return null; 
      return cTChartLines;
    } 
  }
  
  public boolean isSetHiLowLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HILOWLINES$10) != 0);
    } 
  }
  
  public void setHiLowLines(CTChartLines paramCTChartLines) {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().find_element_user(HILOWLINES$10, 0);
      if (cTChartLines == null)
        cTChartLines = (CTChartLines)get_store().add_element_user(HILOWLINES$10); 
      cTChartLines.set((XmlObject)paramCTChartLines);
    } 
  }
  
  public CTChartLines addNewHiLowLines() {
    synchronized (monitor()) {
      check_orphaned();
      CTChartLines cTChartLines = null;
      cTChartLines = (CTChartLines)get_store().add_element_user(HILOWLINES$10);
      return cTChartLines;
    } 
  }
  
  public void unsetHiLowLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HILOWLINES$10, 0);
    } 
  }
  
  public CTUpDownBars getUpDownBars() {
    synchronized (monitor()) {
      check_orphaned();
      CTUpDownBars cTUpDownBars = null;
      cTUpDownBars = (CTUpDownBars)get_store().find_element_user(UPDOWNBARS$12, 0);
      if (cTUpDownBars == null)
        return null; 
      return cTUpDownBars;
    } 
  }
  
  public boolean isSetUpDownBars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UPDOWNBARS$12) != 0);
    } 
  }
  
  public void setUpDownBars(CTUpDownBars paramCTUpDownBars) {
    synchronized (monitor()) {
      check_orphaned();
      CTUpDownBars cTUpDownBars = null;
      cTUpDownBars = (CTUpDownBars)get_store().find_element_user(UPDOWNBARS$12, 0);
      if (cTUpDownBars == null)
        cTUpDownBars = (CTUpDownBars)get_store().add_element_user(UPDOWNBARS$12); 
      cTUpDownBars.set((XmlObject)paramCTUpDownBars);
    } 
  }
  
  public CTUpDownBars addNewUpDownBars() {
    synchronized (monitor()) {
      check_orphaned();
      CTUpDownBars cTUpDownBars = null;
      cTUpDownBars = (CTUpDownBars)get_store().add_element_user(UPDOWNBARS$12);
      return cTUpDownBars;
    } 
  }
  
  public void unsetUpDownBars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UPDOWNBARS$12, 0);
    } 
  }
  
  public CTBoolean getMarker() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(MARKER$14, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetMarker() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MARKER$14) != 0);
    } 
  }
  
  public void setMarker(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(MARKER$14, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(MARKER$14); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewMarker() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(MARKER$14);
      return cTBoolean;
    } 
  }
  
  public void unsetMarker() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MARKER$14, 0);
    } 
  }
  
  public CTBoolean getSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(SMOOTH$16, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMOOTH$16) != 0);
    } 
  }
  
  public void setSmooth(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(SMOOTH$16, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(SMOOTH$16); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(SMOOTH$16);
      return cTBoolean;
    } 
  }
  
  public void unsetSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMOOTH$16, 0);
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
      get_store().find_all_element_users(AXID$18, arrayList);
      CTUnsignedInt[] arrayOfCTUnsignedInt = new CTUnsignedInt[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTUnsignedInt);
      return arrayOfCTUnsignedInt;
    } 
  }
  
  public CTUnsignedInt getAxIdArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(AXID$18, paramInt);
      if (cTUnsignedInt == null)
        throw new IndexOutOfBoundsException(); 
      return cTUnsignedInt;
    } 
  }
  
  public int sizeOfAxIdArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AXID$18);
    } 
  }
  
  public void setAxIdArray(CTUnsignedInt[] paramArrayOfCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTUnsignedInt, AXID$18);
    } 
  }
  
  public void setAxIdArray(int paramInt, CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(AXID$18, paramInt);
      if (cTUnsignedInt == null)
        throw new IndexOutOfBoundsException(); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt insertNewAxId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().insert_element_user(AXID$18, paramInt);
      return cTUnsignedInt;
    } 
  }
  
  public CTUnsignedInt addNewAxId() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(AXID$18);
      return cTUnsignedInt;
    } 
  }
  
  public void removeAxId(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AXID$18, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$20) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$20); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$20);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$20, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLineChartImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */