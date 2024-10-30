/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import org.apache.xmlbeans.GDate;
/*     */ import org.apache.xmlbeans.GDateBuilder;
/*     */ import org.apache.xmlbeans.GDateSpecification;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
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
/*     */ public abstract class JavaGDateHolderEx
/*     */   extends XmlObjectBase
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   private GDate _value;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public JavaGDateHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  34 */     this._schemaType = paramSchemaType;
/*  35 */     initComplexType(paramBoolean, false);
/*     */   }
/*     */   
/*     */   public SchemaType schemaType() {
/*  39 */     return this._schemaType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  48 */     return (this._value == null) ? "" : this._value.toString();
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*     */     GDate gDate;
/*  53 */     if (_validateOnSet()) {
/*  54 */       gDate = validateLexical(paramString, this._schemaType, _voorVc);
/*     */     } else {
/*  56 */       gDate = lex(paramString, this._schemaType, _voorVc);
/*     */     } 
/*  58 */     if (_validateOnSet() && gDate != null) {
/*  59 */       validateValue((GDateSpecification)gDate, this._schemaType, _voorVc);
/*     */     }
/*  61 */     this._value = gDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GDate lex(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  66 */     GDate gDate = null;
/*     */ 
/*     */     
/*     */     try {
/*  70 */       gDate = new GDate(paramString);
/*     */     }
/*  72 */     catch (Exception exception) {
/*     */       
/*  74 */       paramValidationContext.invalid("date", new Object[] { paramString });
/*     */     } 
/*     */     
/*  77 */     if (gDate != null)
/*     */     {
/*  79 */       if (gDate.getBuiltinTypeCode() != paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*     */         
/*  81 */         paramValidationContext.invalid("date", new Object[] { "wrong type: " + paramString });
/*  82 */         gDate = null;
/*     */       }
/*  84 */       else if (!gDate.isValid()) {
/*     */         
/*  86 */         paramValidationContext.invalid("date", new Object[] { paramString });
/*  87 */         gDate = null;
/*     */       } 
/*     */     }
/*     */     
/*  91 */     return gDate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GDate validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  97 */     GDate gDate = lex(paramString, paramSchemaType, paramValidationContext);
/*     */     
/*  99 */     if (gDate != null && paramSchemaType.hasPatternFacet() && 
/* 100 */       !paramSchemaType.matchPatternFacet(paramString)) {
/* 101 */       paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "date", paramString, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 104 */     return gDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateValue(GDateSpecification paramGDateSpecification, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/* 112 */     if (paramGDateSpecification.getBuiltinTypeCode() != paramSchemaType.getPrimitiveType().getBuiltinTypeCode())
/* 113 */       paramValidationContext.invalid("date", new Object[] { "Date (" + paramGDateSpecification + ") does not have the set of fields required for " + QNameHelper.readable(paramSchemaType) });  XmlAnySimpleType xmlAnySimpleType;
/*     */     GDate gDate;
/* 115 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(3)) != null && 
/* 116 */       paramGDateSpecification.compareToGDate((GDateSpecification)(gDate = ((XmlObjectBase)xmlAnySimpleType).gDateValue())) <= 0) {
/* 117 */       paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "date", paramGDateSpecification, gDate, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 120 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(4)) != null && 
/* 121 */       paramGDateSpecification.compareToGDate((GDateSpecification)(gDate = ((XmlObjectBase)xmlAnySimpleType).gDateValue())) < 0) {
/* 122 */       paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "date", paramGDateSpecification, gDate, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 125 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(6)) != null && 
/* 126 */       paramGDateSpecification.compareToGDate((GDateSpecification)(gDate = ((XmlObjectBase)xmlAnySimpleType).gDateValue())) >= 0) {
/* 127 */       paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "date", paramGDateSpecification, gDate, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 130 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(5)) != null && 
/* 131 */       paramGDateSpecification.compareToGDate((GDateSpecification)(gDate = ((XmlObjectBase)xmlAnySimpleType).gDateValue())) > 0) {
/* 132 */       paramValidationContext.invalid("cvc-maxInclusive-valid", new Object[] { "date", paramGDateSpecification, gDate, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 135 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 136 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 138 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/* 139 */         if (paramGDateSpecification.compareToGDate((GDateSpecification)((XmlObjectBase)arrayOfXmlAnySimpleType[b]).gDateValue()) == 0)
/*     */           return; 
/* 141 */       }  paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "date", paramGDateSpecification, QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_nil() {
/* 148 */     this._value = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntValue() {
/* 154 */     int i = schemaType().getPrimitiveType().getBuiltinTypeCode();
/*     */     
/* 156 */     if (i != 20 && i != 21 && i != 18)
/*     */     {
/*     */       
/* 159 */       throw new XmlValueOutOfRangeException();
/*     */     }
/* 161 */     check_dated();
/*     */     
/* 163 */     if (this._value == null) {
/* 164 */       return 0;
/*     */     }
/* 166 */     switch (i) {
/*     */       
/*     */       case 20:
/* 169 */         return this._value.getDay();
/*     */       case 21:
/* 171 */         return this._value.getMonth();
/*     */       case 18:
/* 173 */         return this._value.getYear();
/*     */     } 
/*     */     assert false;
/* 176 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GDate getGDateValue() {
/* 182 */     check_dated();
/*     */     
/* 184 */     if (this._value == null) {
/* 185 */       return null;
/*     */     }
/* 187 */     return this._value;
/*     */   }
/*     */ 
/*     */   
/*     */   public Calendar getCalendarValue() {
/* 192 */     check_dated();
/*     */     
/* 194 */     if (this._value == null) {
/* 195 */       return null;
/*     */     }
/* 197 */     return (Calendar)this._value.getCalendar();
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDateValue() {
/* 202 */     check_dated();
/*     */     
/* 204 */     if (this._value == null) {
/* 205 */       return null;
/*     */     }
/* 207 */     return this._value.getDate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_int(int paramInt) {
/* 213 */     int i = schemaType().getPrimitiveType().getBuiltinTypeCode();
/*     */     
/* 215 */     if (i != 20 && i != 21 && i != 18)
/*     */     {
/*     */       
/* 218 */       throw new XmlValueOutOfRangeException();
/*     */     }
/* 220 */     GDateBuilder gDateBuilder = new GDateBuilder();
/*     */     
/* 222 */     switch (i) {
/*     */       
/*     */       case 20:
/* 225 */         gDateBuilder.setDay(paramInt); break;
/*     */       case 21:
/* 227 */         gDateBuilder.setMonth(paramInt); break;
/*     */       case 18:
/* 229 */         gDateBuilder.setYear(paramInt);
/*     */         break;
/*     */     } 
/* 232 */     if (_validateOnSet()) {
/* 233 */       validateValue((GDateSpecification)gDateBuilder, this._schemaType, _voorVc);
/*     */     }
/* 235 */     this._value = gDateBuilder.toGDate();
/*     */   }
/*     */   
/*     */   protected void set_GDate(GDateSpecification paramGDateSpecification) {
/*     */     GDate gDate;
/* 240 */     int i = schemaType().getPrimitiveType().getBuiltinTypeCode();
/*     */ 
/*     */ 
/*     */     
/* 244 */     if (paramGDateSpecification.isImmutable() && paramGDateSpecification instanceof GDate && paramGDateSpecification.getBuiltinTypeCode() == i) {
/* 245 */       gDate = (GDate)paramGDateSpecification;
/*     */     } else {
/*     */       GDateBuilder gDateBuilder;
/*     */       
/* 249 */       if (paramGDateSpecification.getBuiltinTypeCode() != i) {
/*     */         
/* 251 */         GDateBuilder gDateBuilder1 = new GDateBuilder(paramGDateSpecification);
/* 252 */         gDateBuilder1.setBuiltinTypeCode(i);
/* 253 */         gDateBuilder = gDateBuilder1;
/*     */       } 
/* 255 */       gDate = new GDate((GDateSpecification)gDateBuilder);
/*     */     } 
/*     */     
/* 258 */     if (_validateOnSet()) {
/* 259 */       validateValue((GDateSpecification)gDate, this._schemaType, _voorVc);
/*     */     }
/* 261 */     this._value = gDate;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_Calendar(Calendar paramCalendar) {
/* 266 */     int i = schemaType().getPrimitiveType().getBuiltinTypeCode();
/*     */     
/* 268 */     GDateBuilder gDateBuilder = new GDateBuilder(paramCalendar);
/* 269 */     gDateBuilder.setBuiltinTypeCode(i);
/* 270 */     GDate gDate = gDateBuilder.toGDate();
/*     */     
/* 272 */     if (_validateOnSet()) {
/* 273 */       validateValue((GDateSpecification)gDate, this._schemaType, _voorVc);
/*     */     }
/* 275 */     this._value = gDate;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_Date(Date paramDate) {
/* 280 */     int i = schemaType().getPrimitiveType().getBuiltinTypeCode();
/*     */     
/* 282 */     if ((i != 16 && i != 14) || paramDate == null)
/*     */     {
/* 284 */       throw new XmlValueOutOfRangeException();
/*     */     }
/* 286 */     GDateBuilder gDateBuilder = new GDateBuilder(paramDate);
/* 287 */     gDateBuilder.setBuiltinTypeCode(i);
/* 288 */     GDate gDate = gDateBuilder.toGDate();
/*     */     
/* 290 */     if (_validateOnSet()) {
/* 291 */       validateValue((GDateSpecification)gDate, this._schemaType, _voorVc);
/*     */     }
/* 293 */     this._value = gDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int compare_to(XmlObject paramXmlObject) {
/* 300 */     return this._value.compareToGDate((GDateSpecification)((XmlObjectBase)paramXmlObject).gDateValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 305 */     return this._value.equals(((XmlObjectBase)paramXmlObject).gDateValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 310 */     return this._value.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 315 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 316 */     validateValue((GDateSpecification)gDateValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaGDateHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */