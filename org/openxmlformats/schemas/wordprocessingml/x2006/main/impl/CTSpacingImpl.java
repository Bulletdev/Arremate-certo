package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

public class CTSpacingImpl extends XmlComplexContentImpl implements CTSpacing {
  private static final b BEFORE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "before");
  
  private static final b BEFORELINES$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "beforeLines");
  
  private static final b BEFOREAUTOSPACING$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "beforeAutospacing");
  
  private static final b AFTER$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "after");
  
  private static final b AFTERLINES$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "afterLines");
  
  private static final b AFTERAUTOSPACING$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "afterAutospacing");
  
  private static final b LINE$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "line");
  
  private static final b LINERULE$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lineRule");
  
  public CTSpacingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getBefore() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEFORE$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetBefore() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(BEFORE$0);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetBefore() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BEFORE$0) != null);
    } 
  }
  
  public void setBefore(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEFORE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BEFORE$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetBefore(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(BEFORE$0);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(BEFORE$0); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetBefore() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BEFORE$0);
    } 
  }
  
  public BigInteger getBeforeLines() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEFORELINES$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetBeforeLines() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(BEFORELINES$2);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetBeforeLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BEFORELINES$2) != null);
    } 
  }
  
  public void setBeforeLines(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEFORELINES$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BEFORELINES$2); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetBeforeLines(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(BEFORELINES$2);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(BEFORELINES$2); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetBeforeLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BEFORELINES$2);
    } 
  }
  
  public STOnOff.Enum getBeforeAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEFOREAUTOSPACING$4);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetBeforeAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(BEFOREAUTOSPACING$4);
      return sTOnOff;
    } 
  }
  
  public boolean isSetBeforeAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BEFOREAUTOSPACING$4) != null);
    } 
  }
  
  public void setBeforeAutospacing(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BEFOREAUTOSPACING$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BEFOREAUTOSPACING$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBeforeAutospacing(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(BEFOREAUTOSPACING$4);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(BEFOREAUTOSPACING$4); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetBeforeAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BEFOREAUTOSPACING$4);
    } 
  }
  
  public BigInteger getAfter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AFTER$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetAfter() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(AFTER$6);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetAfter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AFTER$6) != null);
    } 
  }
  
  public void setAfter(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AFTER$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AFTER$6); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetAfter(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(AFTER$6);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(AFTER$6); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetAfter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AFTER$6);
    } 
  }
  
  public BigInteger getAfterLines() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AFTERLINES$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetAfterLines() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(AFTERLINES$8);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetAfterLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AFTERLINES$8) != null);
    } 
  }
  
  public void setAfterLines(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AFTERLINES$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AFTERLINES$8); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetAfterLines(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(AFTERLINES$8);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(AFTERLINES$8); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetAfterLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AFTERLINES$8);
    } 
  }
  
  public STOnOff.Enum getAfterAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AFTERAUTOSPACING$10);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetAfterAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(AFTERAUTOSPACING$10);
      return sTOnOff;
    } 
  }
  
  public boolean isSetAfterAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AFTERAUTOSPACING$10) != null);
    } 
  }
  
  public void setAfterAutospacing(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AFTERAUTOSPACING$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AFTERAUTOSPACING$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAfterAutospacing(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(AFTERAUTOSPACING$10);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(AFTERAUTOSPACING$10); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetAfterAutospacing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AFTERAUTOSPACING$10);
    } 
  }
  
  public BigInteger getLine() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINE$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STSignedTwipsMeasure xgetLine() {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(LINE$12);
      return sTSignedTwipsMeasure;
    } 
  }
  
  public boolean isSetLine() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LINE$12) != null);
    } 
  }
  
  public void setLine(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LINE$12); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetLine(STSignedTwipsMeasure paramSTSignedTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(LINE$12);
      if (sTSignedTwipsMeasure == null)
        sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().add_attribute_user(LINE$12); 
      sTSignedTwipsMeasure.set((XmlObject)paramSTSignedTwipsMeasure);
    } 
  }
  
  public void unsetLine() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LINE$12);
    } 
  }
  
  public STLineSpacingRule.Enum getLineRule() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINERULE$14);
      if (simpleValue == null)
        return null; 
      return (STLineSpacingRule.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLineSpacingRule xgetLineRule() {
    synchronized (monitor()) {
      check_orphaned();
      STLineSpacingRule sTLineSpacingRule = null;
      sTLineSpacingRule = (STLineSpacingRule)get_store().find_attribute_user(LINERULE$14);
      return sTLineSpacingRule;
    } 
  }
  
  public boolean isSetLineRule() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LINERULE$14) != null);
    } 
  }
  
  public void setLineRule(STLineSpacingRule.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINERULE$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LINERULE$14); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLineRule(STLineSpacingRule paramSTLineSpacingRule) {
    synchronized (monitor()) {
      check_orphaned();
      STLineSpacingRule sTLineSpacingRule = null;
      sTLineSpacingRule = (STLineSpacingRule)get_store().find_attribute_user(LINERULE$14);
      if (sTLineSpacingRule == null)
        sTLineSpacingRule = (STLineSpacingRule)get_store().add_attribute_user(LINERULE$14); 
      sTLineSpacingRule.set((XmlObject)paramSTLineSpacingRule);
    } 
  }
  
  public void unsetLineRule() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LINERULE$14);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSpacingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */