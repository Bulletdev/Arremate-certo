package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.b;

public interface SimpleValue extends XmlObject {
  SchemaType instanceType();
  
  String getStringValue();
  
  boolean getBooleanValue();
  
  byte getByteValue();
  
  short getShortValue();
  
  int getIntValue();
  
  long getLongValue();
  
  BigInteger getBigIntegerValue();
  
  BigDecimal getBigDecimalValue();
  
  float getFloatValue();
  
  double getDoubleValue();
  
  byte[] getByteArrayValue();
  
  StringEnumAbstractBase getEnumValue();
  
  Calendar getCalendarValue();
  
  Date getDateValue();
  
  GDate getGDateValue();
  
  GDuration getGDurationValue();
  
  b getQNameValue();
  
  List getListValue();
  
  List xgetListValue();
  
  Object getObjectValue();
  
  void setStringValue(String paramString);
  
  void setBooleanValue(boolean paramBoolean);
  
  void setByteValue(byte paramByte);
  
  void setShortValue(short paramShort);
  
  void setIntValue(int paramInt);
  
  void setLongValue(long paramLong);
  
  void setBigIntegerValue(BigInteger paramBigInteger);
  
  void setBigDecimalValue(BigDecimal paramBigDecimal);
  
  void setFloatValue(float paramFloat);
  
  void setDoubleValue(double paramDouble);
  
  void setByteArrayValue(byte[] paramArrayOfbyte);
  
  void setEnumValue(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  void setCalendarValue(Calendar paramCalendar);
  
  void setDateValue(Date paramDate);
  
  void setGDateValue(GDate paramGDate);
  
  void setGDurationValue(GDuration paramGDuration);
  
  void setQNameValue(b paramb);
  
  void setListValue(List paramList);
  
  void setObjectValue(Object paramObject);
  
  String stringValue();
  
  boolean booleanValue();
  
  byte byteValue();
  
  short shortValue();
  
  int intValue();
  
  long longValue();
  
  BigInteger bigIntegerValue();
  
  BigDecimal bigDecimalValue();
  
  float floatValue();
  
  double doubleValue();
  
  byte[] byteArrayValue();
  
  StringEnumAbstractBase enumValue();
  
  Calendar calendarValue();
  
  Date dateValue();
  
  GDate gDateValue();
  
  GDuration gDurationValue();
  
  b qNameValue();
  
  List listValue();
  
  List xlistValue();
  
  Object objectValue();
  
  void set(String paramString);
  
  void set(boolean paramBoolean);
  
  void set(byte paramByte);
  
  void set(short paramShort);
  
  void set(int paramInt);
  
  void set(long paramLong);
  
  void set(BigInteger paramBigInteger);
  
  void set(BigDecimal paramBigDecimal);
  
  void set(float paramFloat);
  
  void set(double paramDouble);
  
  void set(byte[] paramArrayOfbyte);
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  void set(Calendar paramCalendar);
  
  void set(Date paramDate);
  
  void set(GDateSpecification paramGDateSpecification);
  
  void set(GDurationSpecification paramGDurationSpecification);
  
  void set(b paramb);
  
  void set(List paramList);
  
  void objectSet(Object paramObject);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SimpleValue.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */