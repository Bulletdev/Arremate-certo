package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

public class CTTblWidthImpl extends XmlComplexContentImpl implements CTTblWidth {
  private static final b W$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
  
  private static final b TYPE$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
  
  public CTTblWidthImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getW() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetW() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(W$0);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(W$0) != null);
    } 
  }
  
  public void setW(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(W$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetW(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(W$0);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(W$0); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(W$0);
    } 
  }
  
  public STTblWidth.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$2);
      if (simpleValue == null)
        return null; 
      return (STTblWidth.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTblWidth xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STTblWidth sTTblWidth = null;
      sTTblWidth = (STTblWidth)get_store().find_attribute_user(TYPE$2);
      return sTTblWidth;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$2) != null);
    } 
  }
  
  public void setType(STTblWidth.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STTblWidth paramSTTblWidth) {
    synchronized (monitor()) {
      check_orphaned();
      STTblWidth sTTblWidth = null;
      sTTblWidth = (STTblWidth)get_store().find_attribute_user(TYPE$2);
      if (sTTblWidth == null)
        sTTblWidth = (STTblWidth)get_store().add_attribute_user(TYPE$2); 
      sTTblWidth.set((XmlObject)paramSTTblWidth);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblWidthImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */