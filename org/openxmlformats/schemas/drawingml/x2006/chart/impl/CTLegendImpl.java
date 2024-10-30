package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendEntry;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

public class CTLegendImpl extends XmlComplexContentImpl implements CTLegend {
  private static final b LEGENDPOS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "legendPos");
  
  private static final b LEGENDENTRY$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "legendEntry");
  
  private static final b LAYOUT$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout");
  
  private static final b OVERLAY$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "overlay");
  
  private static final b SPPR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b TXPR$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr");
  
  private static final b EXTLST$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTLegendImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLegendPos getLegendPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegendPos cTLegendPos = null;
      cTLegendPos = (CTLegendPos)get_store().find_element_user(LEGENDPOS$0, 0);
      if (cTLegendPos == null)
        return null; 
      return cTLegendPos;
    } 
  }
  
  public boolean isSetLegendPos() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LEGENDPOS$0) != 0);
    } 
  }
  
  public void setLegendPos(CTLegendPos paramCTLegendPos) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegendPos cTLegendPos = null;
      cTLegendPos = (CTLegendPos)get_store().find_element_user(LEGENDPOS$0, 0);
      if (cTLegendPos == null)
        cTLegendPos = (CTLegendPos)get_store().add_element_user(LEGENDPOS$0); 
      cTLegendPos.set((XmlObject)paramCTLegendPos);
    } 
  }
  
  public CTLegendPos addNewLegendPos() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegendPos cTLegendPos = null;
      cTLegendPos = (CTLegendPos)get_store().add_element_user(LEGENDPOS$0);
      return cTLegendPos;
    } 
  }
  
  public void unsetLegendPos() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGENDPOS$0, 0);
    } 
  }
  
  public List<CTLegendEntry> getLegendEntryList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLegendEntry>)new LegendEntryList(this);
    } 
  }
  
  public CTLegendEntry[] getLegendEntryArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LEGENDENTRY$2, arrayList);
      CTLegendEntry[] arrayOfCTLegendEntry = new CTLegendEntry[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLegendEntry);
      return arrayOfCTLegendEntry;
    } 
  }
  
  public CTLegendEntry getLegendEntryArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegendEntry cTLegendEntry = null;
      cTLegendEntry = (CTLegendEntry)get_store().find_element_user(LEGENDENTRY$2, paramInt);
      if (cTLegendEntry == null)
        throw new IndexOutOfBoundsException(); 
      return cTLegendEntry;
    } 
  }
  
  public int sizeOfLegendEntryArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LEGENDENTRY$2);
    } 
  }
  
  public void setLegendEntryArray(CTLegendEntry[] paramArrayOfCTLegendEntry) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLegendEntry, LEGENDENTRY$2);
    } 
  }
  
  public void setLegendEntryArray(int paramInt, CTLegendEntry paramCTLegendEntry) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegendEntry cTLegendEntry = null;
      cTLegendEntry = (CTLegendEntry)get_store().find_element_user(LEGENDENTRY$2, paramInt);
      if (cTLegendEntry == null)
        throw new IndexOutOfBoundsException(); 
      cTLegendEntry.set((XmlObject)paramCTLegendEntry);
    } 
  }
  
  public CTLegendEntry insertNewLegendEntry(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLegendEntry cTLegendEntry = null;
      cTLegendEntry = (CTLegendEntry)get_store().insert_element_user(LEGENDENTRY$2, paramInt);
      return cTLegendEntry;
    } 
  }
  
  public CTLegendEntry addNewLegendEntry() {
    synchronized (monitor()) {
      check_orphaned();
      CTLegendEntry cTLegendEntry = null;
      cTLegendEntry = (CTLegendEntry)get_store().add_element_user(LEGENDENTRY$2);
      return cTLegendEntry;
    } 
  }
  
  public void removeLegendEntry(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LEGENDENTRY$2, paramInt);
    } 
  }
  
  public CTLayout getLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().find_element_user(LAYOUT$4, 0);
      if (cTLayout == null)
        return null; 
      return cTLayout;
    } 
  }
  
  public boolean isSetLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LAYOUT$4) != 0);
    } 
  }
  
  public void setLayout(CTLayout paramCTLayout) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().find_element_user(LAYOUT$4, 0);
      if (cTLayout == null)
        cTLayout = (CTLayout)get_store().add_element_user(LAYOUT$4); 
      cTLayout.set((XmlObject)paramCTLayout);
    } 
  }
  
  public CTLayout addNewLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().add_element_user(LAYOUT$4);
      return cTLayout;
    } 
  }
  
  public void unsetLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LAYOUT$4, 0);
    } 
  }
  
  public CTBoolean getOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(OVERLAY$6, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OVERLAY$6) != 0);
    } 
  }
  
  public void setOverlay(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(OVERLAY$6, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(OVERLAY$6); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(OVERLAY$6);
      return cTBoolean;
    } 
  }
  
  public void unsetOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OVERLAY$6, 0);
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$8, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public boolean isSetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPPR$8) != 0);
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$8, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$8); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$8);
      return cTShapeProperties;
    } 
  }
  
  public void unsetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPPR$8, 0);
    } 
  }
  
  public CTTextBody getTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$10, 0);
      if (cTTextBody == null)
        return null; 
      return cTTextBody;
    } 
  }
  
  public boolean isSetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXPR$10) != 0);
    } 
  }
  
  public void setTxPr(CTTextBody paramCTTextBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$10, 0);
      if (cTTextBody == null)
        cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$10); 
      cTTextBody.set((XmlObject)paramCTTextBody);
    } 
  }
  
  public CTTextBody addNewTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$10);
      return cTTextBody;
    } 
  }
  
  public void unsetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXPR$10, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$12, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$12) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$12, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$12); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$12);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$12, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTLegendImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */