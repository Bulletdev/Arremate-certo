package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

public class CTBookmarkRangeImpl extends CTMarkupRangeImpl implements CTBookmarkRange {
  private static final b COLFIRST$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "colFirst");
  
  private static final b COLLAST$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "colLast");
  
  public CTBookmarkRangeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getColFirst() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLFIRST$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetColFirst() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(COLFIRST$0);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetColFirst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLFIRST$0) != null);
    } 
  }
  
  public void setColFirst(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLFIRST$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLFIRST$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetColFirst(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(COLFIRST$0);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(COLFIRST$0); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetColFirst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLFIRST$0);
    } 
  }
  
  public BigInteger getColLast() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLLAST$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetColLast() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(COLLAST$2);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetColLast() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLLAST$2) != null);
    } 
  }
  
  public void setColLast(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLLAST$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLLAST$2); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetColLast(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(COLLAST$2);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(COLLAST$2); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetColLast() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLLAST$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTBookmarkRangeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */