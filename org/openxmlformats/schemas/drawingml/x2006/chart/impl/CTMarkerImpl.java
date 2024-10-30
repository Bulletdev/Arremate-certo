package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

public class CTMarkerImpl extends XmlComplexContentImpl implements CTMarker {
  private static final b SYMBOL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "symbol");
  
  private static final b SIZE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "size");
  
  private static final b SPPR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTMarkerImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTMarkerStyle getSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkerStyle cTMarkerStyle = null;
      cTMarkerStyle = (CTMarkerStyle)get_store().find_element_user(SYMBOL$0, 0);
      if (cTMarkerStyle == null)
        return null; 
      return cTMarkerStyle;
    } 
  }
  
  public boolean isSetSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SYMBOL$0) != 0);
    } 
  }
  
  public void setSymbol(CTMarkerStyle paramCTMarkerStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkerStyle cTMarkerStyle = null;
      cTMarkerStyle = (CTMarkerStyle)get_store().find_element_user(SYMBOL$0, 0);
      if (cTMarkerStyle == null)
        cTMarkerStyle = (CTMarkerStyle)get_store().add_element_user(SYMBOL$0); 
      cTMarkerStyle.set((XmlObject)paramCTMarkerStyle);
    } 
  }
  
  public CTMarkerStyle addNewSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkerStyle cTMarkerStyle = null;
      cTMarkerStyle = (CTMarkerStyle)get_store().add_element_user(SYMBOL$0);
      return cTMarkerStyle;
    } 
  }
  
  public void unsetSymbol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SYMBOL$0, 0);
    } 
  }
  
  public CTMarkerSize getSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkerSize cTMarkerSize = null;
      cTMarkerSize = (CTMarkerSize)get_store().find_element_user(SIZE$2, 0);
      if (cTMarkerSize == null)
        return null; 
      return cTMarkerSize;
    } 
  }
  
  public boolean isSetSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SIZE$2) != 0);
    } 
  }
  
  public void setSize(CTMarkerSize paramCTMarkerSize) {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkerSize cTMarkerSize = null;
      cTMarkerSize = (CTMarkerSize)get_store().find_element_user(SIZE$2, 0);
      if (cTMarkerSize == null)
        cTMarkerSize = (CTMarkerSize)get_store().add_element_user(SIZE$2); 
      cTMarkerSize.set((XmlObject)paramCTMarkerSize);
    } 
  }
  
  public CTMarkerSize addNewSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTMarkerSize cTMarkerSize = null;
      cTMarkerSize = (CTMarkerSize)get_store().add_element_user(SIZE$2);
      return cTMarkerSize;
    } 
  }
  
  public void unsetSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SIZE$2, 0);
    } 
  }
  
  public CTShapeProperties getSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$4, 0);
      if (cTShapeProperties == null)
        return null; 
      return cTShapeProperties;
    } 
  }
  
  public boolean isSetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPPR$4) != 0);
    } 
  }
  
  public void setSpPr(CTShapeProperties paramCTShapeProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().find_element_user(SPPR$4, 0);
      if (cTShapeProperties == null)
        cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$4); 
      cTShapeProperties.set((XmlObject)paramCTShapeProperties);
    } 
  }
  
  public CTShapeProperties addNewSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeProperties cTShapeProperties = null;
      cTShapeProperties = (CTShapeProperties)get_store().add_element_user(SPPR$4);
      return cTShapeProperties;
    } 
  }
  
  public void unsetSpPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPPR$4, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTMarkerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */