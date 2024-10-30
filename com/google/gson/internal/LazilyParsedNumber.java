/*    */ package com.google.gson.internal;
/*    */ 
/*    */ import java.io.ObjectStreamException;
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LazilyParsedNumber
/*    */   extends Number
/*    */ {
/*    */   private final String value;
/*    */   
/*    */   public LazilyParsedNumber(String paramString) {
/* 31 */     this.value = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int intValue() {
/*    */     try {
/* 37 */       return Integer.parseInt(this.value);
/* 38 */     } catch (NumberFormatException numberFormatException) {
/*    */       try {
/* 40 */         return (int)Long.parseLong(this.value);
/* 41 */       } catch (NumberFormatException numberFormatException1) {
/* 42 */         return (new BigDecimal(this.value)).intValue();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public long longValue() {
/*    */     try {
/* 50 */       return Long.parseLong(this.value);
/* 51 */     } catch (NumberFormatException numberFormatException) {
/* 52 */       return (new BigDecimal(this.value)).longValue();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public float floatValue() {
/* 58 */     return Float.parseFloat(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public double doubleValue() {
/* 63 */     return Double.parseDouble(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     return this.value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Object writeReplace() throws ObjectStreamException {
/* 77 */     return new BigDecimal(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 82 */     return this.value.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 87 */     if (this == paramObject) {
/* 88 */       return true;
/*    */     }
/* 90 */     if (paramObject instanceof LazilyParsedNumber) {
/* 91 */       LazilyParsedNumber lazilyParsedNumber = (LazilyParsedNumber)paramObject;
/* 92 */       return (this.value == lazilyParsedNumber.value || this.value.equals(lazilyParsedNumber.value));
/*    */     } 
/* 94 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\LazilyParsedNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */