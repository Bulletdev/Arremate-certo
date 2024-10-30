package org.apache.xmlbeans.impl.richParser;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.xml.namespace.b;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.XmlCalendar;

public interface XMLStreamReaderExt extends XMLStreamReader {
  public static final int WS_PRESERVE = 1;
  
  public static final int WS_REPLACE = 2;
  
  public static final int WS_COLLAPSE = 3;
  
  String getStringValue() throws XMLStreamException;
  
  String getStringValue(int paramInt) throws XMLStreamException;
  
  boolean getBooleanValue() throws XMLStreamException;
  
  byte getByteValue() throws XMLStreamException;
  
  short getShortValue() throws XMLStreamException;
  
  int getIntValue() throws XMLStreamException;
  
  long getLongValue() throws XMLStreamException;
  
  BigInteger getBigIntegerValue() throws XMLStreamException;
  
  BigDecimal getBigDecimalValue() throws XMLStreamException;
  
  float getFloatValue() throws XMLStreamException;
  
  double getDoubleValue() throws XMLStreamException;
  
  InputStream getHexBinaryValue() throws XMLStreamException;
  
  InputStream getBase64Value() throws XMLStreamException;
  
  XmlCalendar getCalendarValue() throws XMLStreamException;
  
  Date getDateValue() throws XMLStreamException;
  
  GDate getGDateValue() throws XMLStreamException;
  
  GDuration getGDurationValue() throws XMLStreamException;
  
  b getQNameValue() throws XMLStreamException;
  
  String getAttributeStringValue(int paramInt) throws XMLStreamException;
  
  String getAttributeStringValue(int paramInt1, int paramInt2) throws XMLStreamException;
  
  boolean getAttributeBooleanValue(int paramInt) throws XMLStreamException;
  
  byte getAttributeByteValue(int paramInt) throws XMLStreamException;
  
  short getAttributeShortValue(int paramInt) throws XMLStreamException;
  
  int getAttributeIntValue(int paramInt) throws XMLStreamException;
  
  long getAttributeLongValue(int paramInt) throws XMLStreamException;
  
  BigInteger getAttributeBigIntegerValue(int paramInt) throws XMLStreamException;
  
  BigDecimal getAttributeBigDecimalValue(int paramInt) throws XMLStreamException;
  
  float getAttributeFloatValue(int paramInt) throws XMLStreamException;
  
  double getAttributeDoubleValue(int paramInt) throws XMLStreamException;
  
  InputStream getAttributeHexBinaryValue(int paramInt) throws XMLStreamException;
  
  InputStream getAttributeBase64Value(int paramInt) throws XMLStreamException;
  
  XmlCalendar getAttributeCalendarValue(int paramInt) throws XMLStreamException;
  
  Date getAttributeDateValue(int paramInt) throws XMLStreamException;
  
  GDate getAttributeGDateValue(int paramInt) throws XMLStreamException;
  
  GDuration getAttributeGDurationValue(int paramInt) throws XMLStreamException;
  
  b getAttributeQNameValue(int paramInt) throws XMLStreamException;
  
  String getAttributeStringValue(String paramString1, String paramString2) throws XMLStreamException;
  
  String getAttributeStringValue(String paramString1, String paramString2, int paramInt) throws XMLStreamException;
  
  boolean getAttributeBooleanValue(String paramString1, String paramString2) throws XMLStreamException;
  
  byte getAttributeByteValue(String paramString1, String paramString2) throws XMLStreamException;
  
  short getAttributeShortValue(String paramString1, String paramString2) throws XMLStreamException;
  
  int getAttributeIntValue(String paramString1, String paramString2) throws XMLStreamException;
  
  long getAttributeLongValue(String paramString1, String paramString2) throws XMLStreamException;
  
  BigInteger getAttributeBigIntegerValue(String paramString1, String paramString2) throws XMLStreamException;
  
  BigDecimal getAttributeBigDecimalValue(String paramString1, String paramString2) throws XMLStreamException;
  
  float getAttributeFloatValue(String paramString1, String paramString2) throws XMLStreamException;
  
  double getAttributeDoubleValue(String paramString1, String paramString2) throws XMLStreamException;
  
  InputStream getAttributeHexBinaryValue(String paramString1, String paramString2) throws XMLStreamException;
  
  InputStream getAttributeBase64Value(String paramString1, String paramString2) throws XMLStreamException;
  
  XmlCalendar getAttributeCalendarValue(String paramString1, String paramString2) throws XMLStreamException;
  
  Date getAttributeDateValue(String paramString1, String paramString2) throws XMLStreamException;
  
  GDate getAttributeGDateValue(String paramString1, String paramString2) throws XMLStreamException;
  
  GDuration getAttributeGDurationValue(String paramString1, String paramString2) throws XMLStreamException;
  
  b getAttributeQNameValue(String paramString1, String paramString2) throws XMLStreamException;
  
  void setDefaultValue(String paramString) throws XMLStreamException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\richParser\XMLStreamReaderExt.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */