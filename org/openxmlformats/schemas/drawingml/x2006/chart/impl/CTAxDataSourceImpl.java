package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMultiLvlStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;

public class CTAxDataSourceImpl extends XmlComplexContentImpl implements CTAxDataSource {
  private static final b MULTILVLSTRREF$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "multiLvlStrRef");
  
  private static final b NUMREF$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "numRef");
  
  private static final b NUMLIT$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "numLit");
  
  private static final b STRREF$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "strRef");
  
  private static final b STRLIT$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "strLit");
  
  public CTAxDataSourceImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTMultiLvlStrRef getMultiLvlStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTMultiLvlStrRef cTMultiLvlStrRef = null;
      cTMultiLvlStrRef = (CTMultiLvlStrRef)get_store().find_element_user(MULTILVLSTRREF$0, 0);
      if (cTMultiLvlStrRef == null)
        return null; 
      return cTMultiLvlStrRef;
    } 
  }
  
  public boolean isSetMultiLvlStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MULTILVLSTRREF$0) != 0);
    } 
  }
  
  public void setMultiLvlStrRef(CTMultiLvlStrRef paramCTMultiLvlStrRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTMultiLvlStrRef cTMultiLvlStrRef = null;
      cTMultiLvlStrRef = (CTMultiLvlStrRef)get_store().find_element_user(MULTILVLSTRREF$0, 0);
      if (cTMultiLvlStrRef == null)
        cTMultiLvlStrRef = (CTMultiLvlStrRef)get_store().add_element_user(MULTILVLSTRREF$0); 
      cTMultiLvlStrRef.set((XmlObject)paramCTMultiLvlStrRef);
    } 
  }
  
  public CTMultiLvlStrRef addNewMultiLvlStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTMultiLvlStrRef cTMultiLvlStrRef = null;
      cTMultiLvlStrRef = (CTMultiLvlStrRef)get_store().add_element_user(MULTILVLSTRREF$0);
      return cTMultiLvlStrRef;
    } 
  }
  
  public void unsetMultiLvlStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MULTILVLSTRREF$0, 0);
    } 
  }
  
  public CTNumRef getNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumRef cTNumRef = null;
      cTNumRef = (CTNumRef)get_store().find_element_user(NUMREF$2, 0);
      if (cTNumRef == null)
        return null; 
      return cTNumRef;
    } 
  }
  
  public boolean isSetNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMREF$2) != 0);
    } 
  }
  
  public void setNumRef(CTNumRef paramCTNumRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumRef cTNumRef = null;
      cTNumRef = (CTNumRef)get_store().find_element_user(NUMREF$2, 0);
      if (cTNumRef == null)
        cTNumRef = (CTNumRef)get_store().add_element_user(NUMREF$2); 
      cTNumRef.set((XmlObject)paramCTNumRef);
    } 
  }
  
  public CTNumRef addNewNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumRef cTNumRef = null;
      cTNumRef = (CTNumRef)get_store().add_element_user(NUMREF$2);
      return cTNumRef;
    } 
  }
  
  public void unsetNumRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMREF$2, 0);
    } 
  }
  
  public CTNumData getNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().find_element_user(NUMLIT$4, 0);
      if (cTNumData == null)
        return null; 
      return cTNumData;
    } 
  }
  
  public boolean isSetNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMLIT$4) != 0);
    } 
  }
  
  public void setNumLit(CTNumData paramCTNumData) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().find_element_user(NUMLIT$4, 0);
      if (cTNumData == null)
        cTNumData = (CTNumData)get_store().add_element_user(NUMLIT$4); 
      cTNumData.set((XmlObject)paramCTNumData);
    } 
  }
  
  public CTNumData addNewNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().add_element_user(NUMLIT$4);
      return cTNumData;
    } 
  }
  
  public void unsetNumLit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMLIT$4, 0);
    } 
  }
  
  public CTStrRef getStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrRef cTStrRef = null;
      cTStrRef = (CTStrRef)get_store().find_element_user(STRREF$6, 0);
      if (cTStrRef == null)
        return null; 
      return cTStrRef;
    } 
  }
  
  public boolean isSetStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRREF$6) != 0);
    } 
  }
  
  public void setStrRef(CTStrRef paramCTStrRef) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrRef cTStrRef = null;
      cTStrRef = (CTStrRef)get_store().find_element_user(STRREF$6, 0);
      if (cTStrRef == null)
        cTStrRef = (CTStrRef)get_store().add_element_user(STRREF$6); 
      cTStrRef.set((XmlObject)paramCTStrRef);
    } 
  }
  
  public CTStrRef addNewStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrRef cTStrRef = null;
      cTStrRef = (CTStrRef)get_store().add_element_user(STRREF$6);
      return cTStrRef;
    } 
  }
  
  public void unsetStrRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRREF$6, 0);
    } 
  }
  
  public CTStrData getStrLit() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrData cTStrData = null;
      cTStrData = (CTStrData)get_store().find_element_user(STRLIT$8, 0);
      if (cTStrData == null)
        return null; 
      return cTStrData;
    } 
  }
  
  public boolean isSetStrLit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRLIT$8) != 0);
    } 
  }
  
  public void setStrLit(CTStrData paramCTStrData) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrData cTStrData = null;
      cTStrData = (CTStrData)get_store().find_element_user(STRLIT$8, 0);
      if (cTStrData == null)
        cTStrData = (CTStrData)get_store().add_element_user(STRLIT$8); 
      cTStrData.set((XmlObject)paramCTStrData);
    } 
  }
  
  public CTStrData addNewStrLit() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrData cTStrData = null;
      cTStrData = (CTStrData)get_store().add_element_user(STRLIT$8);
      return cTStrData;
    } 
  }
  
  public void unsetStrLit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRLIT$8, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTAxDataSourceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */