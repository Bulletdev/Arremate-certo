/*      */ package org.apache.xmlbeans.impl.richParser;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.InputStream;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Date;
/*      */ import javax.xml.namespace.a;
/*      */ import javax.xml.namespace.b;
/*      */ import javax.xml.stream.Location;
/*      */ import javax.xml.stream.XMLStreamException;
/*      */ import javax.xml.stream.XMLStreamReader;
/*      */ import org.apache.xmlbeans.GDate;
/*      */ import org.apache.xmlbeans.GDateBuilder;
/*      */ import org.apache.xmlbeans.GDuration;
/*      */ import org.apache.xmlbeans.XmlCalendar;
/*      */ import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
/*      */ import org.apache.xmlbeans.impl.common.XMLChar;
/*      */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
/*      */ import org.apache.xmlbeans.impl.util.Base64;
/*      */ import org.apache.xmlbeans.impl.util.HexBin;
/*      */ import org.apache.xmlbeans.impl.util.XsTypeConverter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XMLStreamReaderExtImpl
/*      */   implements XMLStreamReaderExt
/*      */ {
/*      */   private final XMLStreamReader _xmlStream;
/*      */   private final CharSeqTrimWS _charSeq;
/*      */   private String _defaultValue;
/*      */   static Class class$org$apache$xmlbeans$impl$richParser$XMLStreamReaderExtImpl;
/*      */   
/*      */   public XMLStreamReaderExtImpl(XMLStreamReader paramXMLStreamReader) {
/*   53 */     if (paramXMLStreamReader == null) {
/*   54 */       throw new IllegalArgumentException();
/*      */     }
/*   56 */     this._xmlStream = paramXMLStreamReader;
/*   57 */     this._charSeq = new CharSeqTrimWS(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public XMLStreamReader getUnderlyingXmlStream() {
/*   62 */     return this._xmlStream;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStringValue() throws XMLStreamException {
/*   69 */     this._charSeq.reload(1);
/*   70 */     return this._charSeq.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStringValue(int paramInt) throws XMLStreamException {
/*   76 */     this._charSeq.reload(1);
/*      */ 
/*      */     
/*   79 */     return XmlWhitespace.collapse(this._charSeq.toString(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBooleanValue() throws XMLStreamException, InvalidLexicalValueException {
/*   85 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*   88 */       return XsTypeConverter.lexBoolean(this._charSeq);
/*      */     }
/*   90 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/*      */       
/*   92 */       throw new InvalidLexicalValueException(invalidLexicalValueException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getByteValue() throws XMLStreamException, InvalidLexicalValueException {
/*   99 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  102 */       return XsTypeConverter.lexByte(this._charSeq);
/*      */     }
/*  104 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  106 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short getShortValue() throws XMLStreamException, InvalidLexicalValueException {
/*  113 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  116 */       return XsTypeConverter.lexShort(this._charSeq);
/*      */     }
/*  118 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  120 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getIntValue() throws XMLStreamException, InvalidLexicalValueException {
/*  127 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  130 */       return XsTypeConverter.lexInt(this._charSeq);
/*      */     }
/*  132 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  134 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLongValue() throws XMLStreamException, InvalidLexicalValueException {
/*  141 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  144 */       return XsTypeConverter.lexLong(this._charSeq);
/*      */     }
/*  146 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  148 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getBigIntegerValue() throws XMLStreamException, InvalidLexicalValueException {
/*  155 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  158 */       return XsTypeConverter.lexInteger(this._charSeq);
/*      */     }
/*  160 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  162 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getBigDecimalValue() throws XMLStreamException, InvalidLexicalValueException {
/*  169 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  172 */       return XsTypeConverter.lexDecimal(this._charSeq);
/*      */     }
/*  174 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  176 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloatValue() throws XMLStreamException, InvalidLexicalValueException {
/*  183 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  186 */       return XsTypeConverter.lexFloat(this._charSeq);
/*      */     }
/*  188 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  190 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDoubleValue() throws XMLStreamException, InvalidLexicalValueException {
/*  197 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  200 */       return XsTypeConverter.lexDouble(this._charSeq);
/*      */     }
/*  202 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  204 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream getHexBinaryValue() throws XMLStreamException, InvalidLexicalValueException {
/*  211 */     this._charSeq.reload(2);
/*  212 */     String str = this._charSeq.toString();
/*  213 */     byte[] arrayOfByte = HexBin.decode(str.getBytes());
/*  214 */     if (arrayOfByte != null) {
/*  215 */       return new ByteArrayInputStream(arrayOfByte);
/*      */     }
/*  217 */     throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream getBase64Value() throws XMLStreamException, InvalidLexicalValueException {
/*  223 */     this._charSeq.reload(2);
/*  224 */     String str = this._charSeq.toString();
/*  225 */     byte[] arrayOfByte = Base64.decode(str.getBytes());
/*  226 */     if (arrayOfByte != null) {
/*  227 */       return new ByteArrayInputStream(arrayOfByte);
/*      */     }
/*  229 */     throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlCalendar getCalendarValue() throws XMLStreamException, InvalidLexicalValueException {
/*  235 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  238 */       return (new GDateBuilder(this._charSeq)).getCalendar();
/*      */     }
/*  240 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  242 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDateValue() throws XMLStreamException, InvalidLexicalValueException {
/*  249 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  252 */       return (new GDateBuilder(this._charSeq)).getDate();
/*      */     }
/*  254 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  256 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate getGDateValue() throws XMLStreamException, InvalidLexicalValueException {
/*  263 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  266 */       return XsTypeConverter.lexGDate(this._charSeq);
/*      */     }
/*  268 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  270 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GDuration getGDurationValue() throws XMLStreamException, InvalidLexicalValueException {
/*  277 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  280 */       return new GDuration(this._charSeq);
/*      */     }
/*  282 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  284 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public b getQNameValue() throws XMLStreamException, InvalidLexicalValueException {
/*  291 */     this._charSeq.reload(2);
/*      */     
/*      */     try {
/*  294 */       return XsTypeConverter.lexQName(this._charSeq, this._xmlStream.getNamespaceContext());
/*      */     }
/*  296 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/*      */       
/*  298 */       throw new InvalidLexicalValueException(invalidLexicalValueException.getMessage(), this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeStringValue(int paramInt) throws XMLStreamException {
/*  304 */     return this._xmlStream.getAttributeValue(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeStringValue(int paramInt1, int paramInt2) throws XMLStreamException {
/*  309 */     return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(paramInt1), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAttributeBooleanValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  316 */       return XsTypeConverter.lexBoolean(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  318 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/*      */       
/*  320 */       throw new InvalidLexicalValueException(invalidLexicalValueException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getAttributeByteValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  328 */       return XsTypeConverter.lexByte(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  330 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  332 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short getAttributeShortValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  340 */       return XsTypeConverter.lexShort(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  342 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  344 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttributeIntValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  352 */       return XsTypeConverter.lexInt(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  354 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  356 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public long getAttributeLongValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  364 */       return XsTypeConverter.lexLong(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  366 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  368 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getAttributeBigIntegerValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  376 */       return XsTypeConverter.lexInteger(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  378 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  380 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getAttributeBigDecimalValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  388 */       return XsTypeConverter.lexDecimal(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  390 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  392 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getAttributeFloatValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  400 */       return XsTypeConverter.lexFloat(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  402 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  404 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double getAttributeDoubleValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  412 */       return XsTypeConverter.lexDouble(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  414 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  416 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public InputStream getAttributeHexBinaryValue(int paramInt) throws XMLStreamException {
/*  422 */     String str = this._charSeq.reloadAtt(paramInt, 2).toString();
/*  423 */     byte[] arrayOfByte = HexBin.decode(str.getBytes());
/*  424 */     if (arrayOfByte != null) {
/*  425 */       return new ByteArrayInputStream(arrayOfByte);
/*      */     }
/*  427 */     throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
/*      */   }
/*      */ 
/*      */   
/*      */   public InputStream getAttributeBase64Value(int paramInt) throws XMLStreamException {
/*  432 */     String str = this._charSeq.reloadAtt(paramInt, 2).toString();
/*  433 */     byte[] arrayOfByte = Base64.decode(str.getBytes());
/*  434 */     if (arrayOfByte != null) {
/*  435 */       return new ByteArrayInputStream(arrayOfByte);
/*      */     }
/*  437 */     throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlCalendar getAttributeCalendarValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  444 */       return (new GDateBuilder(this._charSeq.reloadAtt(paramInt, 2))).getCalendar();
/*      */     
/*      */     }
/*  447 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  449 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getAttributeDateValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  457 */       return (new GDateBuilder(this._charSeq.reloadAtt(paramInt, 2))).getDate();
/*      */     
/*      */     }
/*  460 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  462 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate getAttributeGDateValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  470 */       return new GDate(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  472 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  474 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GDuration getAttributeGDurationValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  482 */       return new GDuration(this._charSeq.reloadAtt(paramInt, 2));
/*      */     }
/*  484 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  486 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public b getAttributeQNameValue(int paramInt) throws XMLStreamException {
/*      */     try {
/*  494 */       return XsTypeConverter.lexQName(this._charSeq.reloadAtt(paramInt, 2), this._xmlStream.getNamespaceContext());
/*      */     
/*      */     }
/*  497 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/*      */       
/*  499 */       throw new InvalidLexicalValueException(invalidLexicalValueException.getMessage(), this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeStringValue(String paramString1, String paramString2) throws XMLStreamException {
/*  505 */     return this._charSeq.reloadAtt(paramString1, paramString2, 1).toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeStringValue(String paramString1, String paramString2, int paramInt) throws XMLStreamException {
/*  510 */     return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(paramString1, paramString2), paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getAttributeBooleanValue(String paramString1, String paramString2) throws XMLStreamException {
/*  515 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  518 */       return XsTypeConverter.lexBoolean(charSequence);
/*      */     }
/*  520 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/*      */       
/*  522 */       throw new InvalidLexicalValueException(invalidLexicalValueException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public byte getAttributeByteValue(String paramString1, String paramString2) throws XMLStreamException {
/*  528 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  531 */       return XsTypeConverter.lexByte(charSequence);
/*      */     }
/*  533 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  535 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public short getAttributeShortValue(String paramString1, String paramString2) throws XMLStreamException {
/*  541 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  544 */       return XsTypeConverter.lexShort(charSequence);
/*      */     }
/*  546 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  548 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getAttributeIntValue(String paramString1, String paramString2) throws XMLStreamException {
/*  554 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  557 */       return XsTypeConverter.lexInt(charSequence);
/*      */     }
/*  559 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  561 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public long getAttributeLongValue(String paramString1, String paramString2) throws XMLStreamException {
/*  567 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  570 */       return XsTypeConverter.lexLong(charSequence);
/*      */     }
/*  572 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  574 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public BigInteger getAttributeBigIntegerValue(String paramString1, String paramString2) throws XMLStreamException {
/*  580 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  583 */       return XsTypeConverter.lexInteger(charSequence);
/*      */     }
/*  585 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  587 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getAttributeBigDecimalValue(String paramString1, String paramString2) throws XMLStreamException {
/*  593 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  596 */       return XsTypeConverter.lexDecimal(charSequence);
/*      */     }
/*  598 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  600 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getAttributeFloatValue(String paramString1, String paramString2) throws XMLStreamException {
/*  606 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  609 */       return XsTypeConverter.lexFloat(charSequence);
/*      */     }
/*  611 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  613 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public double getAttributeDoubleValue(String paramString1, String paramString2) throws XMLStreamException {
/*  619 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  622 */       return XsTypeConverter.lexDouble(charSequence);
/*      */     }
/*  624 */     catch (NumberFormatException numberFormatException) {
/*      */       
/*  626 */       throw new InvalidLexicalValueException(numberFormatException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public InputStream getAttributeHexBinaryValue(String paramString1, String paramString2) throws XMLStreamException {
/*  632 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*  633 */     String str = charSequence.toString();
/*  634 */     byte[] arrayOfByte = HexBin.decode(str.getBytes());
/*  635 */     if (arrayOfByte != null) {
/*  636 */       return new ByteArrayInputStream(arrayOfByte);
/*      */     }
/*  638 */     throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
/*      */   }
/*      */ 
/*      */   
/*      */   public InputStream getAttributeBase64Value(String paramString1, String paramString2) throws XMLStreamException {
/*  643 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*  644 */     String str = charSequence.toString();
/*  645 */     byte[] arrayOfByte = Base64.decode(str.getBytes());
/*  646 */     if (arrayOfByte != null) {
/*  647 */       return new ByteArrayInputStream(arrayOfByte);
/*      */     }
/*  649 */     throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlCalendar getAttributeCalendarValue(String paramString1, String paramString2) throws XMLStreamException {
/*  654 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  657 */       return (new GDateBuilder(charSequence)).getCalendar();
/*      */     }
/*  659 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  661 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getAttributeDateValue(String paramString1, String paramString2) throws XMLStreamException {
/*      */     try {
/*  669 */       CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*  670 */       return (new GDateBuilder(charSequence)).getDate();
/*      */     }
/*  672 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  674 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GDate getAttributeGDateValue(String paramString1, String paramString2) throws XMLStreamException {
/*      */     try {
/*  682 */       CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*  683 */       return new GDate(charSequence);
/*      */     }
/*  685 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  687 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GDuration getAttributeGDurationValue(String paramString1, String paramString2) throws XMLStreamException {
/*      */     try {
/*  695 */       return new GDuration(this._charSeq.reloadAtt(paramString1, paramString2, 2));
/*      */     }
/*  697 */     catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  699 */       throw new InvalidLexicalValueException(illegalArgumentException, this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public b getAttributeQNameValue(String paramString1, String paramString2) throws XMLStreamException {
/*  705 */     CharSequence charSequence = this._charSeq.reloadAtt(paramString1, paramString2, 2);
/*      */     
/*      */     try {
/*  708 */       return XsTypeConverter.lexQName(charSequence, this._xmlStream.getNamespaceContext());
/*      */     }
/*  710 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/*      */       
/*  712 */       throw new InvalidLexicalValueException(invalidLexicalValueException.getMessage(), this._charSeq.getLocation());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDefaultValue(String paramString) throws XMLStreamException {
/*  718 */     this._defaultValue = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static Class class$(String paramString) {
/*      */     
/*  725 */     try { return Class.forName(paramString); } catch (ClassNotFoundException classNotFoundException) { throw (new NoClassDefFoundError()).initCause(classNotFoundException); }
/*      */   
/*      */   }
/*      */   
/*      */   private static class CharSeqTrimWS implements CharSequence { static final int XMLWHITESPACE_PRESERVE = 1;
/*      */     static final int XMLWHITESPACE_TRIM = 2;
/*  731 */     private static int INITIAL_SIZE = 100;
/*  732 */     private char[] _buf = new char[INITIAL_SIZE]; private int _start;
/*  733 */     private int _length = 0;
/*  734 */     private int _nonWSStart = 0;
/*  735 */     private int _nonWSEnd = 0;
/*      */     
/*      */     private String _toStringValue;
/*      */     private XMLStreamReaderExtImpl _xmlSteam;
/*      */     private final ExtLocation _location;
/*      */     private boolean _hasText;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     CharSeqTrimWS(XMLStreamReaderExtImpl param1XMLStreamReaderExtImpl) {
/*  744 */       this._xmlSteam = param1XMLStreamReaderExtImpl;
/*  745 */       this._location = new ExtLocation();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     void reload(int param1Int) throws XMLStreamException {
/*  751 */       this._toStringValue = null;
/*  752 */       this._location.reset();
/*  753 */       this._hasText = false;
/*      */       
/*  755 */       fillBuffer();
/*      */       
/*  757 */       if (param1Int == 1) {
/*      */         
/*  759 */         this._nonWSStart = 0;
/*  760 */         this._nonWSEnd = this._length;
/*      */ 
/*      */         
/*  763 */         if (!this._hasText && this._xmlSteam._defaultValue != null)
/*      */         {
/*  765 */           this._length = 0;
/*  766 */           fillBufferFromString(this._xmlSteam._defaultValue);
/*      */         }
/*      */       
/*  769 */       } else if (param1Int == 2) {
/*      */         
/*  771 */         for (this._nonWSStart = 0; this._nonWSStart < this._length && 
/*  772 */           XMLChar.isSpace(this._buf[this._nonWSStart]); this._nonWSStart++);
/*      */         
/*  774 */         for (this._nonWSEnd = this._length; this._nonWSEnd > this._nonWSStart && 
/*  775 */           XMLChar.isSpace(this._buf[this._nonWSEnd - 1]); this._nonWSEnd--);
/*      */ 
/*      */ 
/*      */         
/*  779 */         if (length() == 0 && this._xmlSteam._defaultValue != null) {
/*      */           
/*  781 */           this._length = 0;
/*  782 */           fillBufferFromString(this._xmlSteam._defaultValue);
/*      */ 
/*      */           
/*  785 */           for (this._nonWSStart = 0; this._nonWSStart < this._length && 
/*  786 */             XMLChar.isSpace(this._buf[this._nonWSStart]); this._nonWSStart++);
/*      */           
/*  788 */           for (this._nonWSEnd = this._length; this._nonWSEnd > this._nonWSStart && 
/*  789 */             XMLChar.isSpace(this._buf[this._nonWSEnd - 1]); this._nonWSEnd--);
/*      */         } 
/*      */       } 
/*      */       
/*  793 */       this._xmlSteam._defaultValue = null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void fillBuffer() throws XMLStreamException {
/*  799 */       this._length = 0;
/*      */       
/*  801 */       if (this._xmlSteam.getEventType() == 7)
/*  802 */         this._xmlSteam.next(); 
/*  803 */       if (this._xmlSteam.isStartElement()) {
/*  804 */         this._xmlSteam.next();
/*      */       }
/*  806 */       byte b = 0;
/*  807 */       String str = null;
/*  808 */       int i = this._xmlSteam.getEventType();
/*      */ 
/*      */ 
/*      */       
/*      */       while (true) {
/*  813 */         switch (i) {
/*      */           
/*      */           case 4:
/*      */           case 6:
/*      */           case 12:
/*  818 */             this._location.set(this._xmlSteam.getLocation());
/*      */             
/*  820 */             if (!b) {
/*  821 */               addTextToBuffer();
/*      */             }
/*      */             break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           case 8:
/*  837 */             this._location.set(this._xmlSteam.getLocation());
/*      */             break;
/*      */ 
/*      */           
/*      */           case 2:
/*  842 */             this._location.set(this._xmlSteam.getLocation());
/*  843 */             b--;
/*  844 */             if (b < 0) {
/*      */               break;
/*      */             }
/*      */             break;
/*      */           case 9:
/*  849 */             this._location.set(this._xmlSteam.getLocation());
/*      */             
/*  851 */             addEntityToBuffer();
/*      */             break;
/*      */           
/*      */           case 1:
/*  855 */             b++;
/*  856 */             str = "Unexpected element '" + this._xmlSteam.getName() + "' in text content.";
/*  857 */             this._location.set(this._xmlSteam.getLocation());
/*      */             break;
/*      */         } 
/*      */         
/*  861 */         i = this._xmlSteam.next();
/*      */       } 
/*  863 */       if (str != null) {
/*  864 */         throw new XMLStreamException(str);
/*      */       }
/*      */     }
/*      */     
/*      */     private void ensureBufferLength(int param1Int) {
/*  869 */       if (this._length + param1Int > this._buf.length) {
/*      */         
/*  871 */         char[] arrayOfChar = new char[this._length + param1Int];
/*  872 */         if (this._length > 0)
/*  873 */           System.arraycopy(this._buf, 0, arrayOfChar, 0, this._length); 
/*  874 */         this._buf = arrayOfChar;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void fillBufferFromString(CharSequence param1CharSequence) {
/*  880 */       int i = param1CharSequence.length();
/*  881 */       ensureBufferLength(i);
/*      */       
/*  883 */       for (byte b = 0; b < i; b++)
/*      */       {
/*  885 */         this._buf[b] = param1CharSequence.charAt(b);
/*      */       }
/*  887 */       this._length = i;
/*      */     }
/*      */ 
/*      */     
/*      */     private void addTextToBuffer() {
/*  892 */       this._hasText = true;
/*  893 */       int i = this._xmlSteam.getTextLength();
/*  894 */       ensureBufferLength(i);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  917 */       System.arraycopy(this._xmlSteam.getTextCharacters(), this._xmlSteam.getTextStart(), this._buf, this._length, i);
/*  918 */       this._length += i;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void addEntityToBuffer() {
/*  924 */       String str = this._xmlSteam.getText();
/*      */       
/*  926 */       int i = str.length();
/*  927 */       ensureBufferLength(i);
/*      */       
/*  929 */       str.getChars(0, str.length(), this._buf, this._length);
/*  930 */       this._length += str.length();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     CharSequence reloadAtt(int param1Int1, int param1Int2) throws XMLStreamException {
/*  936 */       this._location.reset();
/*  937 */       this._location.set(this._xmlSteam.getLocation());
/*  938 */       String str = this._xmlSteam.getAttributeValue(param1Int1);
/*      */       
/*  940 */       if (str == null && this._xmlSteam._defaultValue != null) {
/*  941 */         str = this._xmlSteam._defaultValue;
/*      */       }
/*  943 */       this._xmlSteam._defaultValue = null;
/*      */       
/*  945 */       int i = str.length();
/*      */       
/*  947 */       if (param1Int2 == 1)
/*      */       {
/*  949 */         return str;
/*      */       }
/*  951 */       if (param1Int2 == 2) {
/*      */         byte b;
/*      */         
/*  954 */         for (b = 0; b < i && 
/*  955 */           XMLChar.isSpace(str.charAt(b)); b++);
/*      */         int j;
/*  957 */         for (j = i; j > b && 
/*  958 */           XMLChar.isSpace(str.charAt(j - 1)); j--);
/*      */         
/*  960 */         if (b == 0 && j == i) {
/*  961 */           return str;
/*      */         }
/*  963 */         return str.subSequence(b, j);
/*      */       } 
/*      */       
/*  966 */       throw new IllegalStateException("unknown style");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     CharSequence reloadAtt(String param1String1, String param1String2, int param1Int) throws XMLStreamException {
/*  972 */       this._location.reset();
/*  973 */       this._location.set(this._xmlSteam.getLocation());
/*  974 */       String str = this._xmlSteam.getAttributeValue(param1String1, param1String2);
/*      */       
/*  976 */       if (str == null && this._xmlSteam._defaultValue != null) {
/*  977 */         str = this._xmlSteam._defaultValue;
/*      */       }
/*  979 */       this._xmlSteam._defaultValue = null;
/*      */       
/*  981 */       int i = str.length();
/*      */       
/*  983 */       if (param1Int == 1)
/*      */       {
/*  985 */         return str;
/*      */       }
/*  987 */       if (param1Int == 2) {
/*      */         
/*  989 */         for (this._nonWSStart = 0; this._nonWSStart < i && 
/*  990 */           XMLChar.isSpace(str.charAt(this._nonWSStart)); this._nonWSStart++);
/*      */         
/*  992 */         for (this._nonWSEnd = i; this._nonWSEnd > this._nonWSStart && 
/*  993 */           XMLChar.isSpace(str.charAt(this._nonWSEnd - 1)); this._nonWSEnd--);
/*      */         
/*  995 */         if (this._nonWSStart == 0 && this._nonWSEnd == i) {
/*  996 */           return str;
/*      */         }
/*  998 */         return str.subSequence(this._nonWSStart, this._nonWSEnd);
/*      */       } 
/* 1000 */       throw new IllegalStateException("unknown style");
/*      */     }
/*      */ 
/*      */     
/*      */     Location getLocation() {
/* 1005 */       ExtLocation extLocation = new ExtLocation();
/* 1006 */       extLocation.set(this._location);
/* 1007 */       return extLocation;
/*      */     }
/*      */ 
/*      */     
/*      */     public int length() {
/* 1012 */       return this._nonWSEnd - this._nonWSStart;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public char charAt(int param1Int) {
/* 1019 */       assert param1Int < this._nonWSEnd - this._nonWSStart && -1 < param1Int : "Index " + param1Int + " must be >-1 and <" + (this._nonWSEnd - this._nonWSStart);
/*      */       
/* 1021 */       return this._buf[this._nonWSStart + param1Int];
/*      */     }
/*      */ 
/*      */     
/*      */     public CharSequence subSequence(int param1Int1, int param1Int2) {
/* 1026 */       return new String(this._buf, this._nonWSStart + param1Int1, param1Int2 - param1Int1);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1031 */       if (this._toStringValue != null) {
/* 1032 */         return this._toStringValue;
/*      */       }
/* 1034 */       this._toStringValue = new String(this._buf, this._nonWSStart, this._nonWSEnd - this._nonWSStart);
/* 1035 */       return this._toStringValue;
/*      */     }
/*      */ 
/*      */     
/*      */     private static class ExtLocation
/*      */       implements Location
/*      */     {
/*      */       private int _line;
/*      */       
/*      */       private int _col;
/*      */       
/*      */       private int _off;
/*      */       
/*      */       private String _pid;
/*      */       
/*      */       private String _sid;
/*      */       private boolean _isSet = false;
/*      */       
/*      */       public int getLineNumber() {
/* 1054 */         if (this._isSet) {
/* 1055 */           return this._line;
/*      */         }
/* 1057 */         throw new IllegalStateException();
/*      */       }
/*      */ 
/*      */       
/*      */       public int getColumnNumber() {
/* 1062 */         if (this._isSet) {
/* 1063 */           return this._col;
/*      */         }
/* 1065 */         throw new IllegalStateException();
/*      */       }
/*      */ 
/*      */       
/*      */       public int getCharacterOffset() {
/* 1070 */         if (this._isSet) {
/* 1071 */           return this._off;
/*      */         }
/* 1073 */         throw new IllegalStateException();
/*      */       }
/*      */ 
/*      */       
/*      */       public String getPublicId() {
/* 1078 */         if (this._isSet) {
/* 1079 */           return this._pid;
/*      */         }
/* 1081 */         throw new IllegalStateException();
/*      */       }
/*      */ 
/*      */       
/*      */       public String getSystemId() {
/* 1086 */         if (this._isSet) {
/* 1087 */           return this._sid;
/*      */         }
/* 1089 */         throw new IllegalStateException();
/*      */       }
/*      */ 
/*      */       
/*      */       void set(Location param2Location) {
/* 1094 */         if (this._isSet) {
/*      */           return;
/*      */         }
/* 1097 */         this._isSet = true;
/* 1098 */         this._line = param2Location.getLineNumber();
/* 1099 */         this._col = param2Location.getColumnNumber();
/* 1100 */         this._off = param2Location.getCharacterOffset();
/* 1101 */         this._pid = param2Location.getPublicId();
/* 1102 */         this._sid = param2Location.getSystemId();
/*      */       }
/*      */ 
/*      */       
/*      */       void reset() {
/* 1107 */         this._isSet = false;
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getProperty(String paramString) throws IllegalArgumentException {
/* 1116 */     return this._xmlStream.getProperty(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int next() throws XMLStreamException {
/* 1122 */     return this._xmlStream.next();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void require(int paramInt, String paramString1, String paramString2) throws XMLStreamException {
/* 1128 */     this._xmlStream.require(paramInt, paramString1, paramString2);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getElementText() throws XMLStreamException {
/* 1133 */     return this._xmlStream.getElementText();
/*      */   }
/*      */ 
/*      */   
/*      */   public int nextTag() throws XMLStreamException {
/* 1138 */     return this._xmlStream.nextTag();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasNext() throws XMLStreamException {
/* 1143 */     return this._xmlStream.hasNext();
/*      */   }
/*      */ 
/*      */   
/*      */   public void close() throws XMLStreamException {
/* 1148 */     this._xmlStream.close();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getNamespaceURI(String paramString) {
/* 1153 */     return this._xmlStream.getNamespaceURI(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isStartElement() {
/* 1158 */     return this._xmlStream.isStartElement();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isEndElement() {
/* 1163 */     return this._xmlStream.isEndElement();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isCharacters() {
/* 1168 */     return this._xmlStream.isCharacters();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isWhiteSpace() {
/* 1173 */     return this._xmlStream.isWhiteSpace();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeValue(String paramString1, String paramString2) {
/* 1178 */     return this._xmlStream.getAttributeValue(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getAttributeCount() {
/* 1183 */     return this._xmlStream.getAttributeCount();
/*      */   }
/*      */ 
/*      */   
/*      */   public b getAttributeName(int paramInt) {
/* 1188 */     return this._xmlStream.getAttributeName(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeNamespace(int paramInt) {
/* 1193 */     return this._xmlStream.getAttributeNamespace(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeLocalName(int paramInt) {
/* 1198 */     return this._xmlStream.getAttributeLocalName(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributePrefix(int paramInt) {
/* 1203 */     return this._xmlStream.getAttributePrefix(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeType(int paramInt) {
/* 1208 */     return this._xmlStream.getAttributeType(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAttributeValue(int paramInt) {
/* 1213 */     return this._xmlStream.getAttributeValue(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAttributeSpecified(int paramInt) {
/* 1218 */     return this._xmlStream.isAttributeSpecified(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNamespaceCount() {
/* 1223 */     return this._xmlStream.getNamespaceCount();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getNamespacePrefix(int paramInt) {
/* 1228 */     return this._xmlStream.getNamespacePrefix(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public String getNamespaceURI(int paramInt) {
/* 1233 */     return this._xmlStream.getNamespaceURI(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public a getNamespaceContext() {
/* 1238 */     return this._xmlStream.getNamespaceContext();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getEventType() {
/* 1243 */     return this._xmlStream.getEventType();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getText() {
/* 1248 */     return this._xmlStream.getText();
/*      */   }
/*      */ 
/*      */   
/*      */   public char[] getTextCharacters() {
/* 1253 */     return this._xmlStream.getTextCharacters();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTextCharacters(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) throws XMLStreamException {
/* 1259 */     return this._xmlStream.getTextCharacters(paramInt1, paramArrayOfchar, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTextStart() {
/* 1264 */     return this._xmlStream.getTextStart();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTextLength() {
/* 1269 */     return this._xmlStream.getTextLength();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getEncoding() {
/* 1274 */     return this._xmlStream.getEncoding();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasText() {
/* 1279 */     return this._xmlStream.hasText();
/*      */   }
/*      */ 
/*      */   
/*      */   public Location getLocation() {
/* 1284 */     return this._xmlStream.getLocation();
/*      */   }
/*      */ 
/*      */   
/*      */   public b getName() {
/* 1289 */     return this._xmlStream.getName();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getLocalName() {
/* 1294 */     return this._xmlStream.getLocalName();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasName() {
/* 1299 */     return this._xmlStream.hasName();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getNamespaceURI() {
/* 1304 */     return this._xmlStream.getNamespaceURI();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPrefix() {
/* 1309 */     return this._xmlStream.getPrefix();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getVersion() {
/* 1314 */     return this._xmlStream.getVersion();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isStandalone() {
/* 1319 */     return this._xmlStream.isStandalone();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean standaloneSet() {
/* 1324 */     return this._xmlStream.standaloneSet();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCharacterEncodingScheme() {
/* 1329 */     return this._xmlStream.getCharacterEncodingScheme();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPITarget() {
/* 1334 */     return this._xmlStream.getPITarget();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPIData() {
/* 1339 */     return this._xmlStream.getPIData();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\richParser\XMLStreamReaderExtImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */