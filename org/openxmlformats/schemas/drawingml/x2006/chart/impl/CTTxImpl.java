package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

public class CTTxImpl extends XmlComplexContentImpl implements CTTx {
  private static final b STRREF$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "strRef");
  
  private static final b RICH$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "rich");
  
  public CTTxImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTStrRef getStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrRef cTStrRef = null;
      cTStrRef = (CTStrRef)get_store().find_element_user(STRREF$0, 0);
      if (cTStrRef == null)
        return null; 
      return cTStrRef;
    } 
  }
  
  public boolean isSetStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRREF$0) != 0);
    } 
  }
  
  public void setStrRef(CTStrRef paramCTStrRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrRef cTStrRef = null;
      cTStrRef = (CTStrRef)get_store().find_element_user(STRREF$0, 0);
      if (cTStrRef == null)
        cTStrRef = (CTStrRef)get_store().add_element_user(STRREF$0); 
      cTStrRef.set((XmlObject)paramCTStrRef);
    } 
  }
  
  public CTStrRef addNewStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrRef cTStrRef = null;
      cTStrRef = (CTStrRef)get_store().add_element_user(STRREF$0);
      return cTStrRef;
    } 
  }
  
  public void unsetStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRREF$0, 0);
    } 
  }
  
  public CTTextBody getRich() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(RICH$2, 0);
      if (cTTextBody == null)
        return null; 
      return cTTextBody;
    } 
  }
  
  public boolean isSetRich() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RICH$2) != 0);
    } 
  }
  
  public void setRich(CTTextBody paramCTTextBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(RICH$2, 0);
      if (cTTextBody == null)
        cTTextBody = (CTTextBody)get_store().add_element_user(RICH$2); 
      cTTextBody.set((XmlObject)paramCTTextBody);
    } 
  }
  
  public CTTextBody addNewRich() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().add_element_user(RICH$2);
      return cTTextBody;
    } 
  }
  
  public void unsetRich() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RICH$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTTxImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */