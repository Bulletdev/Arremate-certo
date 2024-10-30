package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

public class CTLatentStylesImpl extends XmlComplexContentImpl implements CTLatentStyles {
  private static final b LSDEXCEPTION$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lsdException");
  
  private static final b DEFLOCKEDSTATE$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defLockedState");
  
  private static final b DEFUIPRIORITY$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defUIPriority");
  
  private static final b DEFSEMIHIDDEN$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defSemiHidden");
  
  private static final b DEFUNHIDEWHENUSED$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defUnhideWhenUsed");
  
  private static final b DEFQFORMAT$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defQFormat");
  
  private static final b COUNT$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "count");
  
  public CTLatentStylesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTLsdException> getLsdExceptionList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLsdException>)new LsdExceptionList(this);
    } 
  }
  
  public CTLsdException[] getLsdExceptionArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LSDEXCEPTION$0, arrayList);
      CTLsdException[] arrayOfCTLsdException = new CTLsdException[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLsdException);
      return arrayOfCTLsdException;
    } 
  }
  
  public CTLsdException getLsdExceptionArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLsdException cTLsdException = null;
      cTLsdException = (CTLsdException)get_store().find_element_user(LSDEXCEPTION$0, paramInt);
      if (cTLsdException == null)
        throw new IndexOutOfBoundsException(); 
      return cTLsdException;
    } 
  }
  
  public int sizeOfLsdExceptionArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LSDEXCEPTION$0);
    } 
  }
  
  public void setLsdExceptionArray(CTLsdException[] paramArrayOfCTLsdException) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLsdException, LSDEXCEPTION$0);
    } 
  }
  
  public void setLsdExceptionArray(int paramInt, CTLsdException paramCTLsdException) {
    synchronized (monitor()) {
      check_orphaned();
      CTLsdException cTLsdException = null;
      cTLsdException = (CTLsdException)get_store().find_element_user(LSDEXCEPTION$0, paramInt);
      if (cTLsdException == null)
        throw new IndexOutOfBoundsException(); 
      cTLsdException.set((XmlObject)paramCTLsdException);
    } 
  }
  
  public CTLsdException insertNewLsdException(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLsdException cTLsdException = null;
      cTLsdException = (CTLsdException)get_store().insert_element_user(LSDEXCEPTION$0, paramInt);
      return cTLsdException;
    } 
  }
  
  public CTLsdException addNewLsdException() {
    synchronized (monitor()) {
      check_orphaned();
      CTLsdException cTLsdException = null;
      cTLsdException = (CTLsdException)get_store().add_element_user(LSDEXCEPTION$0);
      return cTLsdException;
    } 
  }
  
  public void removeLsdException(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LSDEXCEPTION$0, paramInt);
    } 
  }
  
  public STOnOff.Enum getDefLockedState() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFLOCKEDSTATE$2);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetDefLockedState() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFLOCKEDSTATE$2);
      return sTOnOff;
    } 
  }
  
  public boolean isSetDefLockedState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFLOCKEDSTATE$2) != null);
    } 
  }
  
  public void setDefLockedState(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFLOCKEDSTATE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFLOCKEDSTATE$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDefLockedState(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFLOCKEDSTATE$2);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(DEFLOCKEDSTATE$2); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetDefLockedState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFLOCKEDSTATE$2);
    } 
  }
  
  public BigInteger getDefUIPriority() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFUIPRIORITY$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetDefUIPriority() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(DEFUIPRIORITY$4);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetDefUIPriority() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFUIPRIORITY$4) != null);
    } 
  }
  
  public void setDefUIPriority(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFUIPRIORITY$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFUIPRIORITY$4); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDefUIPriority(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(DEFUIPRIORITY$4);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(DEFUIPRIORITY$4); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetDefUIPriority() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFUIPRIORITY$4);
    } 
  }
  
  public STOnOff.Enum getDefSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFSEMIHIDDEN$6);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetDefSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFSEMIHIDDEN$6);
      return sTOnOff;
    } 
  }
  
  public boolean isSetDefSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFSEMIHIDDEN$6) != null);
    } 
  }
  
  public void setDefSemiHidden(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFSEMIHIDDEN$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFSEMIHIDDEN$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDefSemiHidden(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFSEMIHIDDEN$6);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(DEFSEMIHIDDEN$6); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetDefSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFSEMIHIDDEN$6);
    } 
  }
  
  public STOnOff.Enum getDefUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetDefUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
      return sTOnOff;
    } 
  }
  
  public boolean isSetDefUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFUNHIDEWHENUSED$8) != null);
    } 
  }
  
  public void setDefUnhideWhenUsed(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFUNHIDEWHENUSED$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDefUnhideWhenUsed(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(DEFUNHIDEWHENUSED$8); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetDefUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFUNHIDEWHENUSED$8);
    } 
  }
  
  public STOnOff.Enum getDefQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFQFORMAT$10);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetDefQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFQFORMAT$10);
      return sTOnOff;
    } 
  }
  
  public boolean isSetDefQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFQFORMAT$10) != null);
    } 
  }
  
  public void setDefQFormat(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFQFORMAT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFQFORMAT$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDefQFormat(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFQFORMAT$10);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(DEFQFORMAT$10); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetDefQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFQFORMAT$10);
    } 
  }
  
  public BigInteger getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetCount() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(COUNT$12);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNT$12) != null);
    } 
  }
  
  public void setCount(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNT$12); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetCount(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(COUNT$12);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(COUNT$12); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNT$12);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTLatentStylesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */