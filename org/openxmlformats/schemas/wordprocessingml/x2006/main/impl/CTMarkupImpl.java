package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

public class CTMarkupImpl extends XmlComplexContentImpl implements CTMarkup {
  private static final b ID$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "id");
  
  public CTMarkupImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ID$0);
      return sTDecimalNumber;
    } 
  }
  
  public void setId(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetId(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(ID$0);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(ID$0); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTMarkupImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */