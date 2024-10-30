package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

public class CTHeightImpl extends XmlComplexContentImpl implements CTHeight {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b HRULE$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hRule");
  
  public CTHeightImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(VAL$0);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetVal(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(VAL$0);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(VAL$0); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
  
  public STHeightRule.Enum getHRule() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRULE$2);
      if (simpleValue == null)
        return null; 
      return (STHeightRule.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHeightRule xgetHRule() {
    synchronized (monitor()) {
      check_orphaned();
      STHeightRule sTHeightRule = null;
      sTHeightRule = (STHeightRule)get_store().find_attribute_user(HRULE$2);
      return sTHeightRule;
    } 
  }
  
  public boolean isSetHRule() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRULE$2) != null);
    } 
  }
  
  public void setHRule(STHeightRule.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRULE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRULE$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHRule(STHeightRule paramSTHeightRule) {
    synchronized (monitor()) {
      check_orphaned();
      STHeightRule sTHeightRule = null;
      sTHeightRule = (STHeightRule)get_store().find_attribute_user(HRULE$2);
      if (sTHeightRule == null)
        sTHeightRule = (STHeightRule)get_store().add_attribute_user(HRULE$2); 
      sTHeightRule.set((XmlObject)paramSTHeightRule);
    } 
  }
  
  public void unsetHRule() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRULE$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTHeightImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */