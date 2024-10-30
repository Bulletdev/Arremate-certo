package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class CTLsdExceptionImpl extends XmlComplexContentImpl implements CTLsdException {
  private static final b NAME$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
  
  private static final b LOCKED$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "locked");
  
  private static final b UIPRIORITY$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uiPriority");
  
  private static final b SEMIHIDDEN$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "semiHidden");
  
  private static final b UNHIDEWHENUSED$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "unhideWhenUsed");
  
  private static final b QFORMAT$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "qFormat");
  
  public CTLsdExceptionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(NAME$0);
      return sTString;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(NAME$0);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(NAME$0); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public STOnOff.Enum getLocked() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKED$2);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(LOCKED$2);
      return sTOnOff;
    } 
  }
  
  public boolean isSetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LOCKED$2) != null);
    } 
  }
  
  public void setLocked(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCKED$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCKED$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLocked(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(LOCKED$2);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(LOCKED$2); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LOCKED$2);
    } 
  }
  
  public BigInteger getUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UIPRIORITY$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(UIPRIORITY$4);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UIPRIORITY$4) != null);
    } 
  }
  
  public void setUiPriority(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UIPRIORITY$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UIPRIORITY$4); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetUiPriority(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(UIPRIORITY$4);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(UIPRIORITY$4); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UIPRIORITY$4);
    } 
  }
  
  public STOnOff.Enum getSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SEMIHIDDEN$6);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(SEMIHIDDEN$6);
      return sTOnOff;
    } 
  }
  
  public boolean isSetSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SEMIHIDDEN$6) != null);
    } 
  }
  
  public void setSemiHidden(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SEMIHIDDEN$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SEMIHIDDEN$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSemiHidden(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(SEMIHIDDEN$6);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(SEMIHIDDEN$6); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SEMIHIDDEN$6);
    } 
  }
  
  public STOnOff.Enum getUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNHIDEWHENUSED$8);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(UNHIDEWHENUSED$8);
      return sTOnOff;
    } 
  }
  
  public boolean isSetUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNHIDEWHENUSED$8) != null);
    } 
  }
  
  public void setUnhideWhenUsed(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNHIDEWHENUSED$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNHIDEWHENUSED$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUnhideWhenUsed(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(UNHIDEWHENUSED$8);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(UNHIDEWHENUSED$8); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNHIDEWHENUSED$8);
    } 
  }
  
  public STOnOff.Enum getQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(QFORMAT$10);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(QFORMAT$10);
      return sTOnOff;
    } 
  }
  
  public boolean isSetQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(QFORMAT$10) != null);
    } 
  }
  
  public void setQFormat(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(QFORMAT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(QFORMAT$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetQFormat(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(QFORMAT$10);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(QFORMAT$10); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(QFORMAT$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTLsdExceptionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */