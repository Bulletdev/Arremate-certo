/*     */ package com.google.gson;
/*     */ 
/*     */ import com.google.gson.internal.JavaVersion;
/*     */ import com.google.gson.internal.PreJava9DateFormatProvider;
/*     */ import com.google.gson.internal.bind.util.ISO8601Utils;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.sql.Date;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
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
/*     */ final class DefaultDateTypeAdapter
/*     */   extends TypeAdapter<Date>
/*     */ {
/*     */   private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
/*     */   private final Class<? extends Date> dateType;
/*  54 */   private final List<DateFormat> dateFormats = new ArrayList<DateFormat>();
/*     */   
/*     */   DefaultDateTypeAdapter(Class<? extends Date> paramClass) {
/*  57 */     this.dateType = verifyDateType(paramClass);
/*  58 */     this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
/*  59 */     if (!Locale.getDefault().equals(Locale.US)) {
/*  60 */       this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
/*     */     }
/*  62 */     if (JavaVersion.isJava9OrLater()) {
/*  63 */       this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
/*     */     }
/*     */   }
/*     */   
/*     */   DefaultDateTypeAdapter(Class<? extends Date> paramClass, String paramString) {
/*  68 */     this.dateType = verifyDateType(paramClass);
/*  69 */     this.dateFormats.add(new SimpleDateFormat(paramString, Locale.US));
/*  70 */     if (!Locale.getDefault().equals(Locale.US)) {
/*  71 */       this.dateFormats.add(new SimpleDateFormat(paramString));
/*     */     }
/*     */   }
/*     */   
/*     */   DefaultDateTypeAdapter(Class<? extends Date> paramClass, int paramInt) {
/*  76 */     this.dateType = verifyDateType(paramClass);
/*  77 */     this.dateFormats.add(DateFormat.getDateInstance(paramInt, Locale.US));
/*  78 */     if (!Locale.getDefault().equals(Locale.US)) {
/*  79 */       this.dateFormats.add(DateFormat.getDateInstance(paramInt));
/*     */     }
/*  81 */     if (JavaVersion.isJava9OrLater()) {
/*  82 */       this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(paramInt));
/*     */     }
/*     */   }
/*     */   
/*     */   public DefaultDateTypeAdapter(int paramInt1, int paramInt2) {
/*  87 */     this(Date.class, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public DefaultDateTypeAdapter(Class<? extends Date> paramClass, int paramInt1, int paramInt2) {
/*  91 */     this.dateType = verifyDateType(paramClass);
/*  92 */     this.dateFormats.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US));
/*  93 */     if (!Locale.getDefault().equals(Locale.US)) {
/*  94 */       this.dateFormats.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2));
/*     */     }
/*  96 */     if (JavaVersion.isJava9OrLater()) {
/*  97 */       this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(paramInt1, paramInt2));
/*     */     }
/*     */   }
/*     */   
/*     */   private static Class<? extends Date> verifyDateType(Class<? extends Date> paramClass) {
/* 102 */     if (paramClass != Date.class && paramClass != Date.class && paramClass != Timestamp.class) {
/* 103 */       throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + Date.class + " but was " + paramClass);
/*     */     }
/* 105 */     return paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(JsonWriter paramJsonWriter, Date paramDate) throws IOException {
/* 112 */     if (paramDate == null) {
/* 113 */       paramJsonWriter.nullValue();
/*     */       return;
/*     */     } 
/* 116 */     synchronized (this.dateFormats) {
/* 117 */       String str = ((DateFormat)this.dateFormats.get(0)).format(paramDate);
/* 118 */       paramJsonWriter.value(str);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Date read(JsonReader paramJsonReader) throws IOException {
/* 124 */     if (paramJsonReader.peek() == JsonToken.NULL) {
/* 125 */       paramJsonReader.nextNull();
/* 126 */       return null;
/*     */     } 
/* 128 */     Date date = deserializeToDate(paramJsonReader.nextString());
/* 129 */     if (this.dateType == Date.class)
/* 130 */       return date; 
/* 131 */     if (this.dateType == Timestamp.class)
/* 132 */       return new Timestamp(date.getTime()); 
/* 133 */     if (this.dateType == Date.class) {
/* 134 */       return new Date(date.getTime());
/*     */     }
/*     */     
/* 137 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */   
/*     */   private Date deserializeToDate(String paramString) {
/* 142 */     synchronized (this.dateFormats) {
/* 143 */       for (DateFormat dateFormat : this.dateFormats) {
/*     */         try {
/* 145 */           return dateFormat.parse(paramString);
/* 146 */         } catch (ParseException parseException) {}
/*     */       } 
/*     */       try {
/* 149 */         return ISO8601Utils.parse(paramString, new ParsePosition(0));
/* 150 */       } catch (ParseException parseException) {
/* 151 */         throw new JsonSyntaxException(paramString, parseException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 158 */     DateFormat dateFormat = this.dateFormats.get(0);
/* 159 */     if (dateFormat instanceof SimpleDateFormat) {
/* 160 */       return "DefaultDateTypeAdapter(" + ((SimpleDateFormat)dateFormat).toPattern() + ')';
/*     */     }
/* 162 */     return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\DefaultDateTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */