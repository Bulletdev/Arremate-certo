package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

public class CTIndImpl extends XmlComplexContentImpl implements CTInd {
  private static final b LEFT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
  
  private static final b LEFTCHARS$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "leftChars");
  
  private static final b RIGHT$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
  
  private static final b RIGHTCHARS$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rightChars");
  
  private static final b HANGING$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hanging");
  
  private static final b HANGINGCHARS$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hangingChars");
  
  private static final b FIRSTLINE$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "firstLine");
  
  private static final b FIRSTLINECHARS$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "firstLineChars");
  
  public CTIndImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getLeft() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEFT$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STSignedTwipsMeasure xgetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(LEFT$0);
      return sTSignedTwipsMeasure;
    } 
  }
  
  public boolean isSetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LEFT$0) != null);
    } 
  }
  
  public void setLeft(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEFT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LEFT$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetLeft(STSignedTwipsMeasure paramSTSignedTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(LEFT$0);
      if (sTSignedTwipsMeasure == null)
        sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().add_attribute_user(LEFT$0); 
      sTSignedTwipsMeasure.set((XmlObject)paramSTSignedTwipsMeasure);
    } 
  }
  
  public void unsetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LEFT$0);
    } 
  }
  
  public BigInteger getLeftChars() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEFTCHARS$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetLeftChars() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(LEFTCHARS$2);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetLeftChars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LEFTCHARS$2) != null);
    } 
  }
  
  public void setLeftChars(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEFTCHARS$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LEFTCHARS$2); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetLeftChars(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(LEFTCHARS$2);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(LEFTCHARS$2); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetLeftChars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LEFTCHARS$2);
    } 
  }
  
  public BigInteger getRight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHT$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STSignedTwipsMeasure xgetRight() {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(RIGHT$4);
      return sTSignedTwipsMeasure;
    } 
  }
  
  public boolean isSetRight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RIGHT$4) != null);
    } 
  }
  
  public void setRight(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RIGHT$4); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetRight(STSignedTwipsMeasure paramSTSignedTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(RIGHT$4);
      if (sTSignedTwipsMeasure == null)
        sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().add_attribute_user(RIGHT$4); 
      sTSignedTwipsMeasure.set((XmlObject)paramSTSignedTwipsMeasure);
    } 
  }
  
  public void unsetRight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RIGHT$4);
    } 
  }
  
  public BigInteger getRightChars() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHTCHARS$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetRightChars() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(RIGHTCHARS$6);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetRightChars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RIGHTCHARS$6) != null);
    } 
  }
  
  public void setRightChars(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHTCHARS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RIGHTCHARS$6); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetRightChars(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(RIGHTCHARS$6);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(RIGHTCHARS$6); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetRightChars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RIGHTCHARS$6);
    } 
  }
  
  public BigInteger getHanging() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANGING$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetHanging() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(HANGING$8);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetHanging() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HANGING$8) != null);
    } 
  }
  
  public void setHanging(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANGING$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HANGING$8); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetHanging(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(HANGING$8);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(HANGING$8); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetHanging() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HANGING$8);
    } 
  }
  
  public BigInteger getHangingChars() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANGINGCHARS$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetHangingChars() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(HANGINGCHARS$10);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetHangingChars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HANGINGCHARS$10) != null);
    } 
  }
  
  public void setHangingChars(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANGINGCHARS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HANGINGCHARS$10); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetHangingChars(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(HANGINGCHARS$10);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(HANGINGCHARS$10); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetHangingChars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HANGINGCHARS$10);
    } 
  }
  
  public BigInteger getFirstLine() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTLINE$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetFirstLine() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(FIRSTLINE$12);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetFirstLine() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTLINE$12) != null);
    } 
  }
  
  public void setFirstLine(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTLINE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTLINE$12); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetFirstLine(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(FIRSTLINE$12);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(FIRSTLINE$12); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetFirstLine() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTLINE$12);
    } 
  }
  
  public BigInteger getFirstLineChars() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTLINECHARS$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetFirstLineChars() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(FIRSTLINECHARS$14);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetFirstLineChars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTLINECHARS$14) != null);
    } 
  }
  
  public void setFirstLineChars(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTLINECHARS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTLINECHARS$14); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetFirstLineChars(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(FIRSTLINECHARS$14);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(FIRSTLINECHARS$14); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetFirstLineChars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTLINECHARS$14);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTIndImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */