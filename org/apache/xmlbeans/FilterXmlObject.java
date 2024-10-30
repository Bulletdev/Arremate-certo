/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.w3c.dom.Node;
/*     */ import org.xml.sax.ContentHandler;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.ext.LexicalHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FilterXmlObject
/*     */   implements DelegateXmlObject, SimpleValue, XmlObject
/*     */ {
/*     */   public SchemaType schemaType() {
/*  57 */     return underlyingXmlObject().schemaType();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validate() {
/*  62 */     return underlyingXmlObject().validate();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validate(XmlOptions paramXmlOptions) {
/*  67 */     return underlyingXmlObject().validate(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] selectPath(String paramString) {
/*  72 */     return underlyingXmlObject().selectPath(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] selectPath(String paramString, XmlOptions paramXmlOptions) {
/*  77 */     return underlyingXmlObject().selectPath(paramString, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] execQuery(String paramString) {
/*  82 */     return underlyingXmlObject().execQuery(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] execQuery(String paramString, XmlOptions paramXmlOptions) {
/*  87 */     return underlyingXmlObject().execQuery(paramString, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject changeType(SchemaType paramSchemaType) {
/*  92 */     return underlyingXmlObject().changeType(paramSchemaType);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNil() {
/*  97 */     return underlyingXmlObject().isNil();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNil() {
/* 102 */     underlyingXmlObject().setNil();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isImmutable() {
/* 107 */     return underlyingXmlObject().isImmutable();
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject set(XmlObject paramXmlObject) {
/* 112 */     return underlyingXmlObject().set(paramXmlObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject copy() {
/* 117 */     return underlyingXmlObject().copy();
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject copy(XmlOptions paramXmlOptions) {
/* 122 */     return underlyingXmlObject().copy(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean valueEquals(XmlObject paramXmlObject) {
/* 127 */     return underlyingXmlObject().valueEquals(paramXmlObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int valueHashCode() {
/* 132 */     return underlyingXmlObject().valueHashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Object paramObject) {
/* 137 */     return underlyingXmlObject().compareTo(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareValue(XmlObject paramXmlObject) {
/* 142 */     return underlyingXmlObject().compareValue(paramXmlObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object monitor() {
/* 147 */     return underlyingXmlObject().monitor();
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlDocumentProperties documentProperties() {
/* 152 */     return underlyingXmlObject().documentProperties();
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlCursor newCursor() {
/* 157 */     return underlyingXmlObject().newCursor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLInputStream newXMLInputStream() {
/* 165 */     return underlyingXmlObject().newXMLInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public XMLStreamReader newXMLStreamReader() {
/* 170 */     return underlyingXmlObject().newXMLStreamReader();
/*     */   }
/*     */ 
/*     */   
/*     */   public String xmlText() {
/* 175 */     return underlyingXmlObject().xmlText();
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() {
/* 180 */     return underlyingXmlObject().newInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public Reader newReader() {
/* 185 */     return underlyingXmlObject().newReader();
/*     */   }
/*     */ 
/*     */   
/*     */   public Node newDomNode() {
/* 190 */     return underlyingXmlObject().newDomNode();
/*     */   }
/*     */ 
/*     */   
/*     */   public Node getDomNode() {
/* 195 */     return underlyingXmlObject().getDomNode();
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler) throws SAXException {
/* 200 */     underlyingXmlObject().save(paramContentHandler, paramLexicalHandler);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(File paramFile) throws IOException {
/* 205 */     underlyingXmlObject().save(paramFile);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(OutputStream paramOutputStream) throws IOException {
/* 210 */     underlyingXmlObject().save(paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(Writer paramWriter) throws IOException {
/* 215 */     underlyingXmlObject().save(paramWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLInputStream newXMLInputStream(XmlOptions paramXmlOptions) {
/* 223 */     return underlyingXmlObject().newXMLInputStream(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XMLStreamReader newXMLStreamReader(XmlOptions paramXmlOptions) {
/* 228 */     return underlyingXmlObject().newXMLStreamReader(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public String xmlText(XmlOptions paramXmlOptions) {
/* 233 */     return underlyingXmlObject().xmlText(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream(XmlOptions paramXmlOptions) {
/* 238 */     return underlyingXmlObject().newInputStream(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public Reader newReader(XmlOptions paramXmlOptions) {
/* 243 */     return underlyingXmlObject().newReader(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public Node newDomNode(XmlOptions paramXmlOptions) {
/* 248 */     return underlyingXmlObject().newDomNode(paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler, XmlOptions paramXmlOptions) throws SAXException {
/* 253 */     underlyingXmlObject().save(paramContentHandler, paramLexicalHandler, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(File paramFile, XmlOptions paramXmlOptions) throws IOException {
/* 258 */     underlyingXmlObject().save(paramFile, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(OutputStream paramOutputStream, XmlOptions paramXmlOptions) throws IOException {
/* 263 */     underlyingXmlObject().save(paramOutputStream, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(Writer paramWriter, XmlOptions paramXmlOptions) throws IOException {
/* 268 */     underlyingXmlObject().save(paramWriter, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType instanceType() {
/* 273 */     return ((SimpleValue)underlyingXmlObject()).instanceType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String stringValue() {
/* 281 */     return ((SimpleValue)underlyingXmlObject()).stringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean booleanValue() {
/* 289 */     return ((SimpleValue)underlyingXmlObject()).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte byteValue() {
/* 297 */     return ((SimpleValue)underlyingXmlObject()).byteValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short shortValue() {
/* 305 */     return ((SimpleValue)underlyingXmlObject()).shortValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int intValue() {
/* 313 */     return ((SimpleValue)underlyingXmlObject()).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 321 */     return ((SimpleValue)underlyingXmlObject()).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger bigIntegerValue() {
/* 329 */     return ((SimpleValue)underlyingXmlObject()).bigIntegerValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal bigDecimalValue() {
/* 337 */     return ((SimpleValue)underlyingXmlObject()).bigDecimalValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 345 */     return ((SimpleValue)underlyingXmlObject()).floatValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 353 */     return ((SimpleValue)underlyingXmlObject()).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] byteArrayValue() {
/* 361 */     return ((SimpleValue)underlyingXmlObject()).byteArrayValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringEnumAbstractBase enumValue() {
/* 369 */     return ((SimpleValue)underlyingXmlObject()).enumValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar calendarValue() {
/* 377 */     return ((SimpleValue)underlyingXmlObject()).calendarValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date dateValue() {
/* 385 */     return ((SimpleValue)underlyingXmlObject()).dateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDate gDateValue() {
/* 393 */     return ((SimpleValue)underlyingXmlObject()).gDateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDuration gDurationValue() {
/* 401 */     return ((SimpleValue)underlyingXmlObject()).gDurationValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b qNameValue() {
/* 409 */     return ((SimpleValue)underlyingXmlObject()).qNameValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List listValue() {
/* 417 */     return ((SimpleValue)underlyingXmlObject()).listValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List xlistValue() {
/* 425 */     return ((SimpleValue)underlyingXmlObject()).xlistValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object objectValue() {
/* 433 */     return ((SimpleValue)underlyingXmlObject()).objectValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(String paramString) {
/* 441 */     ((SimpleValue)underlyingXmlObject()).set(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(boolean paramBoolean) {
/* 449 */     ((SimpleValue)underlyingXmlObject()).set(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(byte paramByte) {
/* 457 */     ((SimpleValue)underlyingXmlObject()).set(paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(short paramShort) {
/* 465 */     ((SimpleValue)underlyingXmlObject()).set(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int paramInt) {
/* 473 */     ((SimpleValue)underlyingXmlObject()).set(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(long paramLong) {
/* 481 */     ((SimpleValue)underlyingXmlObject()).set(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(BigInteger paramBigInteger) {
/* 489 */     ((SimpleValue)underlyingXmlObject()).set(paramBigInteger);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(BigDecimal paramBigDecimal) {
/* 497 */     ((SimpleValue)underlyingXmlObject()).set(paramBigDecimal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(float paramFloat) {
/* 505 */     ((SimpleValue)underlyingXmlObject()).set(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(double paramDouble) {
/* 513 */     ((SimpleValue)underlyingXmlObject()).set(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(byte[] paramArrayOfbyte) {
/* 521 */     ((SimpleValue)underlyingXmlObject()).set(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(StringEnumAbstractBase paramStringEnumAbstractBase) {
/* 529 */     ((SimpleValue)underlyingXmlObject()).set(paramStringEnumAbstractBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Calendar paramCalendar) {
/* 537 */     ((SimpleValue)underlyingXmlObject()).set(paramCalendar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Date paramDate) {
/* 545 */     ((SimpleValue)underlyingXmlObject()).set(paramDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(GDateSpecification paramGDateSpecification) {
/* 553 */     ((SimpleValue)underlyingXmlObject()).set(paramGDateSpecification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(GDurationSpecification paramGDurationSpecification) {
/* 561 */     ((SimpleValue)underlyingXmlObject()).set(paramGDurationSpecification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(b paramb) {
/* 569 */     ((SimpleValue)underlyingXmlObject()).set(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(List paramList) {
/* 577 */     ((SimpleValue)underlyingXmlObject()).set(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 582 */     return ((SimpleValue)underlyingXmlObject()).getStringValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBooleanValue() {
/* 587 */     return ((SimpleValue)underlyingXmlObject()).getBooleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getByteValue() {
/* 592 */     return ((SimpleValue)underlyingXmlObject()).getByteValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public short getShortValue() {
/* 597 */     return ((SimpleValue)underlyingXmlObject()).getShortValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIntValue() {
/* 602 */     return ((SimpleValue)underlyingXmlObject()).getIntValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLongValue() {
/* 607 */     return ((SimpleValue)underlyingXmlObject()).getLongValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public BigInteger getBigIntegerValue() {
/* 612 */     return ((SimpleValue)underlyingXmlObject()).getBigIntegerValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimalValue() {
/* 617 */     return ((SimpleValue)underlyingXmlObject()).getBigDecimalValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloatValue() {
/* 622 */     return ((SimpleValue)underlyingXmlObject()).getFloatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDoubleValue() {
/* 627 */     return ((SimpleValue)underlyingXmlObject()).getDoubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getByteArrayValue() {
/* 632 */     return ((SimpleValue)underlyingXmlObject()).getByteArrayValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public StringEnumAbstractBase getEnumValue() {
/* 637 */     return ((SimpleValue)underlyingXmlObject()).getEnumValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public Calendar getCalendarValue() {
/* 642 */     return ((SimpleValue)underlyingXmlObject()).getCalendarValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 647 */     return ((SimpleValue)underlyingXmlObject()).getDateValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public GDate getGDateValue() {
/* 652 */     return ((SimpleValue)underlyingXmlObject()).getGDateValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public GDuration getGDurationValue() {
/* 657 */     return ((SimpleValue)underlyingXmlObject()).getGDurationValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public b getQNameValue() {
/* 662 */     return ((SimpleValue)underlyingXmlObject()).getQNameValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public List getListValue() {
/* 667 */     return ((SimpleValue)underlyingXmlObject()).getListValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public List xgetListValue() {
/* 672 */     return ((SimpleValue)underlyingXmlObject()).xgetListValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObjectValue() {
/* 677 */     return ((SimpleValue)underlyingXmlObject()).getObjectValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStringValue(String paramString) {
/* 682 */     ((SimpleValue)underlyingXmlObject()).setStringValue(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBooleanValue(boolean paramBoolean) {
/* 687 */     ((SimpleValue)underlyingXmlObject()).setBooleanValue(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setByteValue(byte paramByte) {
/* 692 */     ((SimpleValue)underlyingXmlObject()).setByteValue(paramByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShortValue(short paramShort) {
/* 697 */     ((SimpleValue)underlyingXmlObject()).setShortValue(paramShort);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIntValue(int paramInt) {
/* 702 */     ((SimpleValue)underlyingXmlObject()).setIntValue(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLongValue(long paramLong) {
/* 707 */     ((SimpleValue)underlyingXmlObject()).setLongValue(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBigIntegerValue(BigInteger paramBigInteger) {
/* 712 */     ((SimpleValue)underlyingXmlObject()).setBigIntegerValue(paramBigInteger);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBigDecimalValue(BigDecimal paramBigDecimal) {
/* 717 */     ((SimpleValue)underlyingXmlObject()).setBigDecimalValue(paramBigDecimal);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFloatValue(float paramFloat) {
/* 722 */     ((SimpleValue)underlyingXmlObject()).setFloatValue(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDoubleValue(double paramDouble) {
/* 727 */     ((SimpleValue)underlyingXmlObject()).setDoubleValue(paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setByteArrayValue(byte[] paramArrayOfbyte) {
/* 732 */     ((SimpleValue)underlyingXmlObject()).setByteArrayValue(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEnumValue(StringEnumAbstractBase paramStringEnumAbstractBase) {
/* 737 */     ((SimpleValue)underlyingXmlObject()).setEnumValue(paramStringEnumAbstractBase);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCalendarValue(Calendar paramCalendar) {
/* 742 */     ((SimpleValue)underlyingXmlObject()).setCalendarValue(paramCalendar);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDateValue(Date paramDate) {
/* 747 */     ((SimpleValue)underlyingXmlObject()).setDateValue(paramDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGDateValue(GDate paramGDate) {
/* 752 */     ((SimpleValue)underlyingXmlObject()).setGDateValue(paramGDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGDurationValue(GDuration paramGDuration) {
/* 757 */     ((SimpleValue)underlyingXmlObject()).setGDurationValue(paramGDuration);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setQNameValue(b paramb) {
/* 762 */     ((SimpleValue)underlyingXmlObject()).setQNameValue(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setListValue(List paramList) {
/* 767 */     ((SimpleValue)underlyingXmlObject()).setListValue(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setObjectValue(Object paramObject) {
/* 772 */     ((SimpleValue)underlyingXmlObject()).setObjectValue(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void objectSet(Object paramObject) {
/* 780 */     ((SimpleValue)underlyingXmlObject()).objectSet(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] selectChildren(b paramb) {
/* 785 */     return underlyingXmlObject().selectChildren(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] selectChildren(String paramString1, String paramString2) {
/* 790 */     return underlyingXmlObject().selectChildren(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] selectChildren(QNameSet paramQNameSet) {
/* 795 */     return underlyingXmlObject().selectChildren(paramQNameSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject selectAttribute(b paramb) {
/* 800 */     return underlyingXmlObject().selectAttribute(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject selectAttribute(String paramString1, String paramString2) {
/* 805 */     return underlyingXmlObject().selectAttribute(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject[] selectAttributes(QNameSet paramQNameSet) {
/* 810 */     return underlyingXmlObject().selectAttributes(paramQNameSet);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\FilterXmlObject.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */