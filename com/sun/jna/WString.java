/*    */ package com.sun.jna;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class WString
/*    */   implements CharSequence, Comparable
/*    */ {
/*    */   private String string;
/*    */   
/*    */   public WString(String paramString) {
/* 32 */     if (paramString == null) {
/* 33 */       throw new NullPointerException("String initializer must be non-null");
/*    */     }
/* 35 */     this.string = paramString;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 39 */     return this.string;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 43 */     return (paramObject instanceof WString && toString().equals(paramObject.toString()));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 47 */     return toString().hashCode();
/*    */   }
/*    */   
/*    */   public int compareTo(Object paramObject) {
/* 51 */     return toString().compareTo(paramObject.toString());
/*    */   }
/*    */   
/*    */   public int length() {
/* 55 */     return toString().length();
/*    */   }
/*    */   
/*    */   public char charAt(int paramInt) {
/* 59 */     return toString().charAt(paramInt);
/*    */   }
/*    */   
/*    */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/* 63 */     return toString().subSequence(paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\WString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */