package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTrendline;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

public class CTLineSerImpl extends XmlComplexContentImpl implements CTLineSer {
  private static final b IDX$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "idx");
  
  private static final b ORDER$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "order");
  
  private static final b TX$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "tx");
  
  private static final b SPPR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b MARKER$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "marker");
  
  private static final b DPT$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dPt");
  
  private static final b DLBLS$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
  
  private static final b TRENDLINE$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "trendline");
  
  private static final b ERRBARS$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "errBars");
  
  private static final b CAT$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "cat");
  
  private static final b VAL$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "val");
  
  private static final b SMOOTH$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "smooth");
  
  private static final b EXTLST$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTLineSerImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTUnsignedInt getIdx() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(IDX$0, 0);
      if (cTUnsignedInt == null)
        return null; 
      return cTUnsignedInt;
    } 
  }
  
  public void setIdx(CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(IDX$0, 0);
      if (cTUnsignedInt == null)
        cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(IDX$0); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt addNewIdx() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(IDX$0);
      return cTUnsignedInt;
    } 
  }
  
  public CTUnsignedInt getOrder() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(ORDER$2, 0);
      if (cTUnsignedInt == null)
        return null; 
      return cTUnsignedInt;
    } 
  }
  
  public void setOrder(CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(ORDER$2, 0);
      if (cTUnsignedInt == null)
        cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(ORDER$2); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt addNewOrder() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(ORDER$2);
      return cTUnsignedInt;
    } 
  }
  
  public CTSerTx getTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTSerTx cTSerTx = null;
      cTSerTx = (CTSerTx)get_store().find_element_user(TX$4, 0);
      if (cTSerTx == null)
        return null; 
      return cTSerTx;
    } 
  }
  
  public boolean isSetTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TX$4) != 0);
    } 
  }
  
  public void setTx(CTSerTx paramCTSerTx) {
    synchronized (monitor()) {
      check_orphaned();
      CTSerTx cTSerTx = null;
      cTSerTx = (CTSerTx)get_store().find_element_user(TX$4, 0);
      if (cTSerTx == null)
        cTSerTx = (CTSerTx)get_store().add_element_user(TX$4); 
      cTSerTx.set((XmlObject)paramCTSerTx);
    } 
  }
  
  public CTSerTx addNewTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTSerTx cTSerTx = null;
      cTSerTx = (CTSerTx)get_store().add_element_user(TX$4);
      return cTSerTx;
    } 
  }
  
  public void unsetTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TX$4, 0);
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$6, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public boolean isSetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPPR$6) != 0);
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$6, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$6); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$6);
      return cTShapeProperties;
    } 
  }
  
  public void unsetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPPR$6, 0);
    } 
  }
  
  public CTMarker getMarker() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarker cTMarker = null;
      cTMarker = (CTMarker)get_store().find_element_user(MARKER$8, 0);
      if (cTMarker == null)
        return null; 
      return cTMarker;
    } 
  }
  
  public boolean isSetMarker() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MARKER$8) != 0);
    } 
  }
  
  public void setMarker(CTMarker paramCTMarker) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarker cTMarker = null;
      cTMarker = (CTMarker)get_store().find_element_user(MARKER$8, 0);
      if (cTMarker == null)
        cTMarker = (CTMarker)get_store().add_element_user(MARKER$8); 
      cTMarker.set((XmlObject)paramCTMarker);
    } 
  }
  
  public CTMarker addNewMarker() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarker cTMarker = null;
      cTMarker = (CTMarker)get_store().add_element_user(MARKER$8);
      return cTMarker;
    } 
  }
  
  public void unsetMarker() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MARKER$8, 0);
    } 
  }
  
  public List<CTDPt> getDPtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDPt>)new DPtList(this);
    } 
  }
  
  public CTDPt[] getDPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DPT$10, arrayList);
      CTDPt[] arrayOfCTDPt = new CTDPt[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDPt);
      return arrayOfCTDPt;
    } 
  }
  
  public CTDPt getDPtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDPt cTDPt = null;
      cTDPt = (CTDPt)get_store().find_element_user(DPT$10, paramInt);
      if (cTDPt == null)
        throw new IndexOutOfBoundsException(); 
      return cTDPt;
    } 
  }
  
  public int sizeOfDPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DPT$10);
    } 
  }
  
  public void setDPtArray(CTDPt[] paramArrayOfCTDPt) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDPt, DPT$10);
    } 
  }
  
  public void setDPtArray(int paramInt, CTDPt paramCTDPt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDPt cTDPt = null;
      cTDPt = (CTDPt)get_store().find_element_user(DPT$10, paramInt);
      if (cTDPt == null)
        throw new IndexOutOfBoundsException(); 
      cTDPt.set((XmlObject)paramCTDPt);
    } 
  }
  
  public CTDPt insertNewDPt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDPt cTDPt = null;
      cTDPt = (CTDPt)get_store().insert_element_user(DPT$10, paramInt);
      return cTDPt;
    } 
  }
  
  public CTDPt addNewDPt() {
    synchronized (monitor()) {
      check_orphaned();
      CTDPt cTDPt = null;
      cTDPt = (CTDPt)get_store().add_element_user(DPT$10);
      return cTDPt;
    } 
  }
  
  public void removeDPt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DPT$10, paramInt);
    } 
  }
  
  public CTDLbls getDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().find_element_user(DLBLS$12, 0);
      if (cTDLbls == null)
        return null; 
      return cTDLbls;
    } 
  }
  
  public boolean isSetDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DLBLS$12) != 0);
    } 
  }
  
  public void setDLbls(CTDLbls paramCTDLbls) {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().find_element_user(DLBLS$12, 0);
      if (cTDLbls == null)
        cTDLbls = (CTDLbls)get_store().add_element_user(DLBLS$12); 
      cTDLbls.set((XmlObject)paramCTDLbls);
    } 
  }
  
  public CTDLbls addNewDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      CTDLbls cTDLbls = null;
      cTDLbls = (CTDLbls)get_store().add_element_user(DLBLS$12);
      return cTDLbls;
    } 
  }
  
  public void unsetDLbls() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DLBLS$12, 0);
    } 
  }
  
  public List<CTTrendline> getTrendlineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTrendline>)new TrendlineList(this);
    } 
  }
  
  public CTTrendline[] getTrendlineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TRENDLINE$14, arrayList);
      CTTrendline[] arrayOfCTTrendline = new CTTrendline[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTrendline);
      return arrayOfCTTrendline;
    } 
  }
  
  public CTTrendline getTrendlineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrendline cTTrendline = null;
      cTTrendline = (CTTrendline)get_store().find_element_user(TRENDLINE$14, paramInt);
      if (cTTrendline == null)
        throw new IndexOutOfBoundsException(); 
      return cTTrendline;
    } 
  }
  
  public int sizeOfTrendlineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TRENDLINE$14);
    } 
  }
  
  public void setTrendlineArray(CTTrendline[] paramArrayOfCTTrendline) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTrendline, TRENDLINE$14);
    } 
  }
  
  public void setTrendlineArray(int paramInt, CTTrendline paramCTTrendline) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrendline cTTrendline = null;
      cTTrendline = (CTTrendline)get_store().find_element_user(TRENDLINE$14, paramInt);
      if (cTTrendline == null)
        throw new IndexOutOfBoundsException(); 
      cTTrendline.set((XmlObject)paramCTTrendline);
    } 
  }
  
  public CTTrendline insertNewTrendline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrendline cTTrendline = null;
      cTTrendline = (CTTrendline)get_store().insert_element_user(TRENDLINE$14, paramInt);
      return cTTrendline;
    } 
  }
  
  public CTTrendline addNewTrendline() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrendline cTTrendline = null;
      cTTrendline = (CTTrendline)get_store().add_element_user(TRENDLINE$14);
      return cTTrendline;
    } 
  }
  
  public void removeTrendline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRENDLINE$14, paramInt);
    } 
  }
  
  public CTErrBars getErrBars() {
    synchronized (monitor()) {
      check_orphaned();
      CTErrBars cTErrBars = null;
      cTErrBars = (CTErrBars)get_store().find_element_user(ERRBARS$16, 0);
      if (cTErrBars == null)
        return null; 
      return cTErrBars;
    } 
  }
  
  public boolean isSetErrBars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ERRBARS$16) != 0);
    } 
  }
  
  public void setErrBars(CTErrBars paramCTErrBars) {
    synchronized (monitor()) {
      check_orphaned();
      CTErrBars cTErrBars = null;
      cTErrBars = (CTErrBars)get_store().find_element_user(ERRBARS$16, 0);
      if (cTErrBars == null)
        cTErrBars = (CTErrBars)get_store().add_element_user(ERRBARS$16); 
      cTErrBars.set((XmlObject)paramCTErrBars);
    } 
  }
  
  public CTErrBars addNewErrBars() {
    synchronized (monitor()) {
      check_orphaned();
      CTErrBars cTErrBars = null;
      cTErrBars = (CTErrBars)get_store().add_element_user(ERRBARS$16);
      return cTErrBars;
    } 
  }
  
  public void unsetErrBars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ERRBARS$16, 0);
    } 
  }
  
  public CTAxDataSource getCat() {
    synchronized (monitor()) {
      check_orphaned();
      CTAxDataSource cTAxDataSource = null;
      cTAxDataSource = (CTAxDataSource)get_store().find_element_user(CAT$18, 0);
      if (cTAxDataSource == null)
        return null; 
      return cTAxDataSource;
    } 
  }
  
  public boolean isSetCat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CAT$18) != 0);
    } 
  }
  
  public void setCat(CTAxDataSource paramCTAxDataSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTAxDataSource cTAxDataSource = null;
      cTAxDataSource = (CTAxDataSource)get_store().find_element_user(CAT$18, 0);
      if (cTAxDataSource == null)
        cTAxDataSource = (CTAxDataSource)get_store().add_element_user(CAT$18); 
      cTAxDataSource.set((XmlObject)paramCTAxDataSource);
    } 
  }
  
  public CTAxDataSource addNewCat() {
    synchronized (monitor()) {
      check_orphaned();
      CTAxDataSource cTAxDataSource = null;
      cTAxDataSource = (CTAxDataSource)get_store().add_element_user(CAT$18);
      return cTAxDataSource;
    } 
  }
  
  public void unsetCat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CAT$18, 0);
    } 
  }
  
  public CTNumDataSource getVal() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumDataSource cTNumDataSource = null;
      cTNumDataSource = (CTNumDataSource)get_store().find_element_user(VAL$20, 0);
      if (cTNumDataSource == null)
        return null; 
      return cTNumDataSource;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VAL$20) != 0);
    } 
  }
  
  public void setVal(CTNumDataSource paramCTNumDataSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumDataSource cTNumDataSource = null;
      cTNumDataSource = (CTNumDataSource)get_store().find_element_user(VAL$20, 0);
      if (cTNumDataSource == null)
        cTNumDataSource = (CTNumDataSource)get_store().add_element_user(VAL$20); 
      cTNumDataSource.set((XmlObject)paramCTNumDataSource);
    } 
  }
  
  public CTNumDataSource addNewVal() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumDataSource cTNumDataSource = null;
      cTNumDataSource = (CTNumDataSource)get_store().add_element_user(VAL$20);
      return cTNumDataSource;
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VAL$20, 0);
    } 
  }
  
  public CTBoolean getSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(SMOOTH$22, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMOOTH$22) != 0);
    } 
  }
  
  public void setSmooth(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(SMOOTH$22, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(SMOOTH$22); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(SMOOTH$22);
      return cTBoolean;
    } 
  }
  
  public void unsetSmooth() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMOOTH$22, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$24) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$24, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$24); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$24);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$24, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLineSerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */