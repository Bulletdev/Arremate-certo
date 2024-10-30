package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STZoom;

public class CTZoomImpl extends XmlComplexContentImpl implements CTZoom {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b PERCENT$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "percent");
  
  public CTZoomImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STZoom.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STZoom.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STZoom xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STZoom sTZoom = null;
      sTZoom = (STZoom)get_store().find_attribute_user(VAL$0);
      return sTZoom;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STZoom.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STZoom paramSTZoom) {
    synchronized (monitor()) {
      check_orphaned();
      STZoom sTZoom = null;
      sTZoom = (STZoom)get_store().find_attribute_user(VAL$0);
      if (sTZoom == null)
        sTZoom = (STZoom)get_store().add_attribute_user(VAL$0); 
      sTZoom.set((XmlObject)paramSTZoom);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
  
  public BigInteger getPercent() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PERCENT$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetPercent() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(PERCENT$2);
      return sTDecimalNumber;
    } 
  }
  
  public void setPercent(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PERCENT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PERCENT$2); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetPercent(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(PERCENT$2);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(PERCENT$2); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTZoomImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */