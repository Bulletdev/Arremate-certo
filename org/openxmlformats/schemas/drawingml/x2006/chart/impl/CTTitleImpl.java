package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

public class CTTitleImpl extends XmlComplexContentImpl implements CTTitle {
  private static final b TX$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "tx");
  
  private static final b LAYOUT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout");
  
  private static final b OVERLAY$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "overlay");
  
  private static final b SPPR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b TXPR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr");
  
  private static final b EXTLST$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTTitleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTx getTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTx cTTx = null;
      cTTx = (CTTx)get_store().find_element_user(TX$0, 0);
      if (cTTx == null)
        return null; 
      return cTTx;
    } 
  }
  
  public boolean isSetTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TX$0) != 0);
    } 
  }
  
  public void setTx(CTTx paramCTTx) {
    synchronized (monitor()) {
      check_orphaned();
      CTTx cTTx = null;
      cTTx = (CTTx)get_store().find_element_user(TX$0, 0);
      if (cTTx == null)
        cTTx = (CTTx)get_store().add_element_user(TX$0); 
      cTTx.set((XmlObject)paramCTTx);
    } 
  }
  
  public CTTx addNewTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTTx cTTx = null;
      cTTx = (CTTx)get_store().add_element_user(TX$0);
      return cTTx;
    } 
  }
  
  public void unsetTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TX$0, 0);
    } 
  }
  
  public CTLayout getLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().find_element_user(LAYOUT$2, 0);
      if (cTLayout == null)
        return null; 
      return cTLayout;
    } 
  }
  
  public boolean isSetLayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LAYOUT$2) != 0);
    } 
  }
  
  public void setLayout(CTLayout paramCTLayout) {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().find_element_user(LAYOUT$2, 0);
      if (cTLayout == null)
        cTLayout = (CTLayout)get_store().add_element_user(LAYOUT$2); 
      cTLayout.set((XmlObject)paramCTLayout);
    } 
  }
  
  public CTLayout addNewLayout() {
    synchronized (monitor()) {
      check_orphaned();
      CTLayout cTLayout = null;
      cTLayout = (CTLayout)get_store().add_element_user(LAYOUT$2);
      return cTLayout;
    } 
  }
  
  public void unsetLayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LAYOUT$2, 0);
    } 
  }
  
  public CTBoolean getOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(OVERLAY$4, 0);
      if (cTBoolean == null)
        return null; 
      return cTBoolean;
    } 
  }
  
  public boolean isSetOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OVERLAY$4) != 0);
    } 
  }
  
  public void setOverlay(CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(OVERLAY$4, 0);
      if (cTBoolean == null)
        cTBoolean = (CTBoolean)get_store().add_element_user(OVERLAY$4); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean addNewOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(OVERLAY$4);
      return cTBoolean;
    } 
  }
  
  public void unsetOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OVERLAY$4, 0);
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
  
  public CTTextBody getTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$8, 0);
      if (cTTextBody == null)
        return null; 
      return cTTextBody;
    } 
  }
  
  public boolean isSetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXPR$8) != 0);
    } 
  }
  
  public void setTxPr(CTTextBody paramCTTextBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXPR$8, 0);
      if (cTTextBody == null)
        cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$8); 
      cTTextBody.set((XmlObject)paramCTTextBody);
    } 
  }
  
  public CTTextBody addNewTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().add_element_user(TXPR$8);
      return cTTextBody;
    } 
  }
  
  public void unsetTxPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXPR$8, 0);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTTitleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */