package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

public class CTFtnEdnRefImpl extends XmlComplexContentImpl implements CTFtnEdnRef {
  private static final b CUSTOMMARKFOLLOWS$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customMarkFollows");
  
  private static final b ID$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "id");
  
  public CTFtnEdnRefImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STOnOff.Enum getCustomMarkFollows() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMMARKFOLLOWS$0);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetCustomMarkFollows() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(CUSTOMMARKFOLLOWS$0);
      return sTOnOff;
    } 
  }
  
  public boolean isSetCustomMarkFollows() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMMARKFOLLOWS$0) != null);
    } 
  }
  
  public void setCustomMarkFollows(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMMARKFOLLOWS$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMMARKFOLLOWS$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCustomMarkFollows(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(CUSTOMMARKFOLLOWS$0);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(CUSTOMMARKFOLLOWS$0); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetCustomMarkFollows() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMMARKFOLLOWS$0);
    } 
  }
  
  public BigInteger getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ID$2);
      return sTDecimalNumber;
    } 
  }
  
  public void setId(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$2); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetId(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ID$2);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(ID$2); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTFtnEdnRefImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */