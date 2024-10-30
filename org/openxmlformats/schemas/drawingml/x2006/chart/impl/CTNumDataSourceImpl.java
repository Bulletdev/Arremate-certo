package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;

public class CTNumDataSourceImpl extends XmlComplexContentImpl implements CTNumDataSource {
  private static final b NUMREF$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "numRef");
  
  private static final b NUMLIT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "numLit");
  
  public CTNumDataSourceImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNumRef getNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumRef cTNumRef = null;
      cTNumRef = (CTNumRef)get_store().find_element_user(NUMREF$0, 0);
      if (cTNumRef == null)
        return null; 
      return cTNumRef;
    } 
  }
  
  public boolean isSetNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMREF$0) != 0);
    } 
  }
  
  public void setNumRef(CTNumRef paramCTNumRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumRef cTNumRef = null;
      cTNumRef = (CTNumRef)get_store().find_element_user(NUMREF$0, 0);
      if (cTNumRef == null)
        cTNumRef = (CTNumRef)get_store().add_element_user(NUMREF$0); 
      cTNumRef.set((XmlObject)paramCTNumRef);
    } 
  }
  
  public CTNumRef addNewNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumRef cTNumRef = null;
      cTNumRef = (CTNumRef)get_store().add_element_user(NUMREF$0);
      return cTNumRef;
    } 
  }
  
  public void unsetNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMREF$0, 0);
    } 
  }
  
  public CTNumData getNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().find_element_user(NUMLIT$2, 0);
      if (cTNumData == null)
        return null; 
      return cTNumData;
    } 
  }
  
  public boolean isSetNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMLIT$2) != 0);
    } 
  }
  
  public void setNumLit(CTNumData paramCTNumData) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().find_element_user(NUMLIT$2, 0);
      if (cTNumData == null)
        cTNumData = (CTNumData)get_store().add_element_user(NUMLIT$2); 
      cTNumData.set((XmlObject)paramCTNumData);
    } 
  }
  
  public CTNumData addNewNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().add_element_user(NUMLIT$2);
      return cTNumData;
    } 
  }
  
  public void unsetNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMLIT$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTNumDataSourceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */