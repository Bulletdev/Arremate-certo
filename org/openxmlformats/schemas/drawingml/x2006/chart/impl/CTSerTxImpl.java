package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

public class CTSerTxImpl extends XmlComplexContentImpl implements CTSerTx {
  private static final b STRREF$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "strRef");
  
  private static final b V$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "v");
  
  public CTSerTxImpl(SchemaType paramSchemaType) {
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
  
  public String getV() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(V$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetV() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(V$2, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetV() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(V$2) != 0);
    } 
  }
  
  public void setV(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(V$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(V$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetV(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(V$2, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(V$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetV() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(V$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTSerTxImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */