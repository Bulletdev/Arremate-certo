package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTControl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

public class CTObjectImpl extends CTPictureBaseImpl implements CTObject {
  private static final b CONTROL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "control");
  
  private static final b DXAORIG$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dxaOrig");
  
  private static final b DYAORIG$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dyaOrig");
  
  public CTObjectImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTControl getControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTControl cTControl = null;
      cTControl = (CTControl)get_store().find_element_user(CONTROL$0, 0);
      if (cTControl == null)
        return null; 
      return cTControl;
    } 
  }
  
  public boolean isSetControl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONTROL$0) != 0);
    } 
  }
  
  public void setControl(CTControl paramCTControl) {
    synchronized (monitor()) {
      check_orphaned();
      CTControl cTControl = null;
      cTControl = (CTControl)get_store().find_element_user(CONTROL$0, 0);
      if (cTControl == null)
        cTControl = (CTControl)get_store().add_element_user(CONTROL$0); 
      cTControl.set((XmlObject)paramCTControl);
    } 
  }
  
  public CTControl addNewControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTControl cTControl = null;
      cTControl = (CTControl)get_store().add_element_user(CONTROL$0);
      return cTControl;
    } 
  }
  
  public void unsetControl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONTROL$0, 0);
    } 
  }
  
  public BigInteger getDxaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DXAORIG$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetDxaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(DXAORIG$2);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetDxaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DXAORIG$2) != null);
    } 
  }
  
  public void setDxaOrig(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DXAORIG$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DXAORIG$2); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDxaOrig(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(DXAORIG$2);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(DXAORIG$2); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetDxaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DXAORIG$2);
    } 
  }
  
  public BigInteger getDyaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DYAORIG$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetDyaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(DYAORIG$4);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetDyaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DYAORIG$4) != null);
    } 
  }
  
  public void setDyaOrig(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DYAORIG$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DYAORIG$4); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDyaOrig(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(DYAORIG$4);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(DYAORIG$4); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetDyaOrig() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DYAORIG$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTObjectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */