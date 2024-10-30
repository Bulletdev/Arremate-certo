/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.GDate;
/*     */ import org.apache.xmlbeans.GDateSpecification;
/*     */ import org.apache.xmlbeans.GDuration;
/*     */ import org.apache.xmlbeans.GDurationSpecification;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
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
/*     */ public class XmlUnionImpl
/*     */   extends XmlObjectBase
/*     */   implements XmlAnySimpleType
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   private XmlAnySimpleType _value;
/*     */   private String _textvalue;
/*     */   private static final int JAVA_NUMBER = 47;
/*     */   private static final int JAVA_DATE = 48;
/*     */   private static final int JAVA_CALENDAR = 49;
/*     */   private static final int JAVA_BYTEARRAY = 50;
/*     */   private static final int JAVA_LIST = 51;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public SchemaType schemaType() {
/*     */     return this._schemaType;
/*     */   }
/*     */   
/*     */   public SchemaType instanceType() {
/*     */     check_dated();
/*     */     return (this._value == null) ? null : ((SimpleValue)this._value).instanceType();
/*     */   }
/*     */   
/*     */   public XmlUnionImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/*  59 */     this._textvalue = "";
/*     */     this._schemaType = paramSchemaType;
/*     */     initComplexType(paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  68 */     return this._textvalue;
/*     */   }
/*     */   protected boolean is_defaultable_ws(String paramString) {
/*     */     try {
/*  72 */       XmlAnySimpleType xmlAnySimpleType = this._value;
/*  73 */       set_text(paramString);
/*     */ 
/*     */       
/*  76 */       this._value = xmlAnySimpleType;
/*     */       
/*  78 */       return false;
/*     */     }
/*  80 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*  81 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_text(String paramString) {
/*  88 */     if (!this._schemaType.matchPatternFacet(paramString) && _validateOnSet()) {
/*  89 */       throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.1", new Object[] { "string", paramString, QNameHelper.readable(this._schemaType) });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  94 */     String str = this._textvalue;
/*  95 */     this._textvalue = paramString;
/*     */ 
/*     */     
/*  98 */     SchemaType[] arrayOfSchemaType = this._schemaType.getUnionConstituentTypes();
/*  99 */     assert arrayOfSchemaType != null;
/*     */     
/* 101 */     boolean bool = false;
/*     */     
/* 103 */     if (has_store()) {
/*     */       
/* 105 */       NamespaceContext.push(new NamespaceContext(get_store()));
/* 106 */       bool = true;
/*     */     } 
/*     */     try {
/*     */       boolean bool1;
/* 110 */       for (bool1 = true; bool1 || !_validateOnSet(); bool1 = false) {
/*     */         
/* 112 */         for (byte b = 0; b < arrayOfSchemaType.length; b++) {
/*     */ 
/*     */           
/*     */           try {
/*     */ 
/*     */ 
/*     */             
/* 119 */             XmlAnySimpleType xmlAnySimpleType = ((SchemaTypeImpl)arrayOfSchemaType[b]).newValue(paramString, bool1);
/*     */ 
/*     */             
/* 122 */             if (check((XmlObject)xmlAnySimpleType, this._schemaType)) {
/*     */ 
/*     */ 
/*     */               
/* 126 */               this._value = xmlAnySimpleType;
/*     */               return;
/*     */             } 
/* 129 */           } catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*     */ 
/*     */           
/*     */           }
/* 133 */           catch (Exception exception) {
/*     */             
/* 135 */             throw new RuntimeException("Troublesome union exception caused by unexpected " + exception, exception);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 140 */         if (!bool1) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } finally {
/*     */       
/* 146 */       if (bool) {
/* 147 */         NamespaceContext.pop();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 153 */     this._textvalue = str;
/* 154 */     throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.2.3", new Object[] { paramString, QNameHelper.readable(this._schemaType) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_nil() {
/* 160 */     this._value = null;
/* 161 */     this._textvalue = null;
/*     */   }
/*     */   protected int get_wscanon_rule() {
/* 164 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloatValue() {
/* 169 */     check_dated(); return (this._value == null) ? 0.0F : ((SimpleValue)this._value).getFloatValue();
/*     */   }
/*     */   public double getDoubleValue() {
/* 172 */     check_dated(); return (this._value == null) ? 0.0D : ((SimpleValue)this._value).getDoubleValue();
/*     */   }
/*     */   public BigDecimal getBigDecimalValue() {
/* 175 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getBigDecimalValue();
/*     */   }
/*     */   public BigInteger getBigIntegerValue() {
/* 178 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getBigIntegerValue();
/*     */   }
/*     */   public byte getByteValue() {
/* 181 */     check_dated(); return (this._value == null) ? 0 : ((SimpleValue)this._value).getByteValue();
/*     */   }
/*     */   public short getShortValue() {
/* 184 */     check_dated(); return (this._value == null) ? 0 : ((SimpleValue)this._value).getShortValue();
/*     */   }
/*     */   public int getIntValue() {
/* 187 */     check_dated(); return (this._value == null) ? 0 : ((SimpleValue)this._value).getIntValue();
/*     */   }
/*     */   public long getLongValue() {
/* 190 */     check_dated(); return (this._value == null) ? 0L : ((SimpleValue)this._value).getLongValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getByteArrayValue() {
/* 195 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getByteArrayValue();
/*     */   }
/*     */   public boolean getBooleanValue() {
/* 198 */     check_dated(); return (this._value == null) ? false : ((SimpleValue)this._value).getBooleanValue();
/*     */   }
/*     */   public Calendar getCalendarValue() {
/* 201 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getCalendarValue();
/*     */   }
/*     */   public Date getDateValue() {
/* 204 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getDateValue();
/*     */   }
/*     */   public GDate getGDateValue() {
/* 207 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getGDateValue();
/*     */   }
/*     */   public GDuration getGDurationValue() {
/* 210 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getGDurationValue();
/*     */   }
/*     */   public b getQNameValue() {
/* 213 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getQNameValue();
/*     */   }
/*     */   public List getListValue() {
/* 216 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getListValue();
/*     */   }
/*     */   public List xgetListValue() {
/* 219 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).xgetListValue();
/*     */   }
/*     */   public StringEnumAbstractBase getEnumValue() {
/* 222 */     check_dated(); return (this._value == null) ? null : ((SimpleValue)this._value).getEnumValue();
/*     */   }
/*     */   public String getStringValue() {
/* 225 */     check_dated(); return (this._value == null) ? null : this._value.getStringValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean lexical_overlap(int paramInt1, int paramInt2) {
/* 235 */     if (paramInt1 == paramInt2) {
/* 236 */       return true;
/*     */     }
/*     */     
/* 239 */     if (paramInt1 == 2 || paramInt2 == 2 || paramInt1 == 12 || paramInt2 == 12 || paramInt1 == 6 || paramInt2 == 6)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 245 */       return true;
/*     */     }
/* 247 */     switch (paramInt1) {
/*     */       case 3:
/* 249 */         switch (paramInt2) {
/*     */           
/*     */           case 7:
/*     */           case 8:
/* 253 */             return true;
/*     */         } 
/* 255 */         return false;
/*     */       case 4:
/* 257 */         switch (paramInt2) {
/*     */           
/*     */           case 3:
/*     */           case 5:
/*     */           case 7:
/*     */           case 8:
/*     */           case 9:
/*     */           case 10:
/*     */           case 11:
/*     */           case 13:
/*     */           case 18:
/* 268 */             return true;
/*     */         } 
/* 270 */         return false;
/*     */       case 5:
/* 272 */         switch (paramInt2) {
/*     */           
/*     */           case 3:
/*     */           case 4:
/*     */           case 7:
/*     */           case 8:
/*     */           case 9:
/*     */           case 10:
/*     */           case 11:
/*     */           case 18:
/* 282 */             return true;
/*     */         } 
/* 284 */         return false;
/*     */       case 7:
/*     */       case 8:
/* 287 */         switch (paramInt2) {
/*     */           
/*     */           case 3:
/*     */           case 4:
/*     */           case 5:
/*     */           case 7:
/*     */           case 8:
/*     */           case 13:
/* 295 */             return true;
/*     */         } 
/* 297 */         return false;
/*     */       case 9:
/*     */       case 10:
/*     */       case 11:
/*     */       case 18:
/* 302 */         switch (paramInt2) {
/*     */           
/*     */           case 4:
/*     */           case 5:
/*     */           case 9:
/*     */           case 10:
/*     */           case 11:
/*     */           case 18:
/* 310 */             return true;
/*     */         } 
/* 312 */         return false;
/*     */       case 13:
/* 314 */         switch (paramInt2) {
/*     */           
/*     */           case 4:
/*     */           case 7:
/*     */           case 8:
/* 319 */             return true;
/*     */         } 
/* 321 */         return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 331 */     return false;
/*     */   }
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
/*     */   private static boolean logical_overlap(SchemaType paramSchemaType, int paramInt) {
/* 349 */     assert paramSchemaType.getSimpleVariety() != 2;
/*     */     
/* 351 */     if (paramInt <= 46) {
/*     */       
/* 353 */       if (paramSchemaType.getSimpleVariety() != 1) {
/* 354 */         return false;
/*     */       }
/* 356 */       return (paramSchemaType.getPrimitiveType().getBuiltinTypeCode() == paramInt);
/*     */     } 
/*     */     
/* 359 */     switch (paramInt) {
/*     */ 
/*     */       
/*     */       case 47:
/* 363 */         if (paramSchemaType.getSimpleVariety() != 1) {
/* 364 */           return false;
/*     */         }
/* 366 */         switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*     */           
/*     */           case 9:
/*     */           case 10:
/*     */           case 11:
/*     */           case 18:
/*     */           case 20:
/*     */           case 21:
/* 374 */             return true;
/*     */         } 
/* 376 */         return false;
/*     */ 
/*     */       
/*     */       case 48:
/* 380 */         if (paramSchemaType.getSimpleVariety() != 1) {
/* 381 */           return false;
/*     */         }
/* 383 */         switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*     */           
/*     */           case 14:
/*     */           case 16:
/* 387 */             return true;
/*     */         } 
/* 389 */         return false;
/*     */ 
/*     */       
/*     */       case 49:
/* 393 */         if (paramSchemaType.getSimpleVariety() != 1) {
/* 394 */           return false;
/*     */         }
/* 396 */         switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*     */           
/*     */           case 14:
/*     */           case 15:
/*     */           case 16:
/*     */           case 17:
/*     */           case 18:
/*     */           case 19:
/*     */           case 20:
/*     */           case 21:
/* 406 */             return true;
/*     */         } 
/* 408 */         return false;
/*     */ 
/*     */ 
/*     */       
/*     */       case 50:
/* 413 */         if (paramSchemaType.getSimpleVariety() != 1) {
/* 414 */           return false;
/*     */         }
/* 416 */         switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*     */           
/*     */           case 4:
/*     */           case 5:
/* 420 */             return true;
/*     */         } 
/* 422 */         return false;
/*     */ 
/*     */       
/*     */       case 51:
/* 426 */         return (paramSchemaType.getSimpleVariety() == 3);
/*     */     } 
/*     */ 
/*     */     
/* 430 */     assert false : "missing case";
/* 431 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void set_primitive(int paramInt, Object paramObject) {
/* 440 */     SchemaType[] arrayOfSchemaType = this._schemaType.getUnionConstituentTypes();
/* 441 */     assert arrayOfSchemaType != null;
/*     */     
/* 443 */     boolean bool = false;
/* 444 */     if (has_store()) {
/*     */       
/* 446 */       NamespaceContext.push(new NamespaceContext(get_store()));
/* 447 */       bool = true;
/*     */     } 
/*     */     try {
/*     */       boolean bool1;
/* 451 */       for (bool1 = true; bool1 || !_validateOnSet(); bool1 = false) {
/*     */         
/* 453 */         for (byte b = 0; b < arrayOfSchemaType.length; b++) {
/*     */ 
/*     */           
/* 456 */           if (logical_overlap(arrayOfSchemaType[b], paramInt)) {
/*     */             XmlAnySimpleType xmlAnySimpleType;
/*     */ 
/*     */ 
/*     */             
/*     */             try {
/* 462 */               xmlAnySimpleType = ((SchemaTypeImpl)arrayOfSchemaType[b]).newValue(paramObject, bool1);
/*     */             }
/* 464 */             catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/* 470 */             catch (Exception exception) {
/*     */               
/* 472 */               assert false : "Unexpected " + exception;
/*     */             } 
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
/* 517 */             this._value = xmlAnySimpleType;
/* 518 */             this._textvalue = this._value.stringValue();
/*     */             return;
/*     */           } 
/*     */         } 
/* 522 */         if (!bool1) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } finally {
/*     */       
/* 528 */       if (bool) {
/* 529 */         NamespaceContext.pop();
/*     */       }
/*     */     } 
/*     */     
/* 533 */     throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.2.3", new Object[] { paramObject.toString(), QNameHelper.readable(this._schemaType) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_boolean(boolean paramBoolean) {
/* 540 */     set_primitive(3, new Boolean(paramBoolean));
/*     */   }
/*     */   protected void set_byte(byte paramByte) {
/* 543 */     set_primitive(47, new Byte(paramByte));
/*     */   } protected void set_short(short paramShort) {
/* 545 */     set_primitive(47, new Short(paramShort));
/*     */   } protected void set_int(int paramInt) {
/* 547 */     set_primitive(47, new Integer(paramInt));
/*     */   } protected void set_long(long paramLong) {
/* 549 */     set_primitive(47, new Long(paramLong));
/*     */   } protected void set_float(float paramFloat) {
/* 551 */     set_primitive(47, new Float(paramFloat));
/*     */   } protected void set_double(double paramDouble) {
/* 553 */     set_primitive(47, new Double(paramDouble));
/*     */   }
/*     */   protected void set_ByteArray(byte[] paramArrayOfbyte) {
/* 556 */     set_primitive(50, paramArrayOfbyte);
/*     */   } protected void set_hex(byte[] paramArrayOfbyte) {
/* 558 */     set_primitive(50, paramArrayOfbyte);
/*     */   } protected void set_b64(byte[] paramArrayOfbyte) {
/* 560 */     set_primitive(50, paramArrayOfbyte);
/*     */   } protected void set_BigInteger(BigInteger paramBigInteger) {
/* 562 */     set_primitive(47, paramBigInteger);
/*     */   } protected void set_BigDecimal(BigDecimal paramBigDecimal) {
/* 564 */     set_primitive(47, paramBigDecimal);
/*     */   } protected void set_QName(b paramb) {
/* 566 */     set_primitive(7, paramb);
/*     */   }
/*     */   protected void set_Calendar(Calendar paramCalendar) {
/* 569 */     set_primitive(49, paramCalendar);
/*     */   } protected void set_Date(Date paramDate) {
/* 571 */     set_primitive(48, paramDate);
/*     */   }
/*     */   protected void set_GDate(GDateSpecification paramGDateSpecification) {
/* 574 */     int i = paramGDateSpecification.getBuiltinTypeCode();
/* 575 */     if (i <= 0)
/* 576 */       throw new XmlValueOutOfRangeException(); 
/* 577 */     set_primitive(i, paramGDateSpecification);
/*     */   }
/*     */   
/*     */   protected void set_GDuration(GDurationSpecification paramGDurationSpecification) {
/* 581 */     set_primitive(13, paramGDurationSpecification);
/*     */   }
/*     */   protected void set_enum(StringEnumAbstractBase paramStringEnumAbstractBase) {
/* 584 */     set_primitive(12, paramStringEnumAbstractBase);
/*     */   }
/*     */   protected void set_list(List paramList) {
/* 587 */     set_primitive(51, paramList);
/*     */   }
/*     */   
/*     */   protected void set_xmlfloat(XmlObject paramXmlObject) {
/* 591 */     set_primitive(9, paramXmlObject);
/*     */   } protected void set_xmldouble(XmlObject paramXmlObject) {
/* 593 */     set_primitive(10, paramXmlObject);
/*     */   } protected void set_xmldecimal(XmlObject paramXmlObject) {
/* 595 */     set_primitive(11, paramXmlObject);
/*     */   } protected void set_xmlduration(XmlObject paramXmlObject) {
/* 597 */     set_primitive(13, paramXmlObject);
/*     */   } protected void set_xmldatetime(XmlObject paramXmlObject) {
/* 599 */     set_primitive(14, paramXmlObject);
/*     */   } protected void set_xmltime(XmlObject paramXmlObject) {
/* 601 */     set_primitive(15, paramXmlObject);
/*     */   } protected void set_xmldate(XmlObject paramXmlObject) {
/* 603 */     set_primitive(16, paramXmlObject);
/*     */   } protected void set_xmlgyearmonth(XmlObject paramXmlObject) {
/* 605 */     set_primitive(17, paramXmlObject);
/*     */   } protected void set_xmlgyear(XmlObject paramXmlObject) {
/* 607 */     set_primitive(18, paramXmlObject);
/*     */   } protected void set_xmlgmonthday(XmlObject paramXmlObject) {
/* 609 */     set_primitive(19, paramXmlObject);
/*     */   } protected void set_xmlgday(XmlObject paramXmlObject) {
/* 611 */     set_primitive(20, paramXmlObject);
/*     */   } protected void set_xmlgmonth(XmlObject paramXmlObject) {
/* 613 */     set_primitive(21, paramXmlObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean check(XmlObject paramXmlObject, SchemaType paramSchemaType) {
/* 619 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 620 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 622 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*     */         
/* 624 */         if (arrayOfXmlAnySimpleType[b].valueEquals(paramXmlObject))
/* 625 */           return true; 
/*     */       } 
/* 627 */       return false;
/*     */     } 
/*     */     
/* 630 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 635 */     return this._value.valueEquals(paramXmlObject);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 640 */     return this._value.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/*     */     try {
/* 647 */       check_dated();
/*     */     }
/* 649 */     catch (Exception exception) {
/*     */       
/* 651 */       paramValidationContext.invalid("union", new Object[] { "'" + paramString + "' does not match any of the member types for " + QNameHelper.readable(schemaType()) });
/*     */       return;
/*     */     } 
/* 654 */     if (this._value == null) {
/*     */       
/* 656 */       paramValidationContext.invalid("union", new Object[] { "'" + paramString + "' does not match any of the member types for " + QNameHelper.readable(schemaType()) });
/*     */       
/*     */       return;
/*     */     } 
/* 660 */     ((XmlObjectBase)this._value).validate_simpleval(paramString, paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlUnionImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */