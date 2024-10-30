package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

public class CTPieSerImpl extends XmlComplexContentImpl implements CTPieSer {
  private static final b IDX$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "idx");
  
  private static final b ORDER$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "order");
  
  private static final b TX$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "tx");
  
  private static final b SPPR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b EXPLOSION$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "explosion");
  
  private static final b DPT$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dPt");
  
  private static final b DLBLS$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls");
  
  private static final b CAT$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "cat");
  
  private static final b VAL$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "val");
  
  private static final b EXTLST$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTPieSerImpl(SchemaType paramSchemaType) {
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
  
  public CTUnsignedInt getExplosion() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(EXPLOSION$8, 0);
      if (cTUnsignedInt == null)
        return null; 
      return cTUnsignedInt;
    } 
  }
  
  public boolean isSetExplosion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXPLOSION$8) != 0);
    } 
  }
  
  public void setExplosion(CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(EXPLOSION$8, 0);
      if (cTUnsignedInt == null)
        cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(EXPLOSION$8); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt addNewExplosion() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(EXPLOSION$8);
      return cTUnsignedInt;
    } 
  }
  
  public void unsetExplosion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXPLOSION$8, 0);
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
  
  public CTAxDataSource getCat() {
    synchronized (monitor()) {
      check_orphaned();
      CTAxDataSource cTAxDataSource = null;
      cTAxDataSource = (CTAxDataSource)get_store().find_element_user(CAT$14, 0);
      if (cTAxDataSource == null)
        return null; 
      return cTAxDataSource;
    } 
  }
  
  public boolean isSetCat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CAT$14) != 0);
    } 
  }
  
  public void setCat(CTAxDataSource paramCTAxDataSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTAxDataSource cTAxDataSource = null;
      cTAxDataSource = (CTAxDataSource)get_store().find_element_user(CAT$14, 0);
      if (cTAxDataSource == null)
        cTAxDataSource = (CTAxDataSource)get_store().add_element_user(CAT$14); 
      cTAxDataSource.set((XmlObject)paramCTAxDataSource);
    } 
  }
  
  public CTAxDataSource addNewCat() {
    synchronized (monitor()) {
      check_orphaned();
      CTAxDataSource cTAxDataSource = null;
      cTAxDataSource = (CTAxDataSource)get_store().add_element_user(CAT$14);
      return cTAxDataSource;
    } 
  }
  
  public void unsetCat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CAT$14, 0);
    } 
  }
  
  public CTNumDataSource getVal() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumDataSource cTNumDataSource = null;
      cTNumDataSource = (CTNumDataSource)get_store().find_element_user(VAL$16, 0);
      if (cTNumDataSource == null)
        return null; 
      return cTNumDataSource;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VAL$16) != 0);
    } 
  }
  
  public void setVal(CTNumDataSource paramCTNumDataSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumDataSource cTNumDataSource = null;
      cTNumDataSource = (CTNumDataSource)get_store().find_element_user(VAL$16, 0);
      if (cTNumDataSource == null)
        cTNumDataSource = (CTNumDataSource)get_store().add_element_user(VAL$16); 
      cTNumDataSource.set((XmlObject)paramCTNumDataSource);
    } 
  }
  
  public CTNumDataSource addNewVal() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumDataSource cTNumDataSource = null;
      cTNumDataSource = (CTNumDataSource)get_store().add_element_user(VAL$16);
      return cTNumDataSource;
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VAL$16, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$18, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$18) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$18, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$18); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$18);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$18, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTPieSerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */