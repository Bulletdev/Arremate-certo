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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LastErrorException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int errorCode;
/*    */   
/*    */   private static String formatMessage(int paramInt) {
/* 37 */     return Platform.isWindows() ? ("GetLastError() returned " + paramInt) : ("errno was " + paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static String parseMessage(String paramString) {
/*    */     try {
/* 44 */       return formatMessage(Integer.parseInt(paramString));
/* 45 */     } catch (NumberFormatException numberFormatException) {
/* 46 */       return paramString;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getErrorCode() {
/* 54 */     return this.errorCode;
/*    */   }
/*    */   
/*    */   public LastErrorException(String paramString) {
/* 58 */     super(parseMessage(paramString.trim()));
/*    */     try {
/* 60 */       if (paramString.startsWith("[")) {
/* 61 */         paramString = paramString.substring(1, paramString.indexOf("]"));
/*    */       }
/* 63 */       this.errorCode = Integer.parseInt(paramString);
/* 64 */     } catch (NumberFormatException numberFormatException) {
/* 65 */       this.errorCode = -1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public LastErrorException(int paramInt) {
/* 70 */     this(paramInt, formatMessage(paramInt));
/*    */   }
/*    */   
/*    */   protected LastErrorException(int paramInt, String paramString) {
/* 74 */     super(paramString);
/* 75 */     this.errorCode = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\LastErrorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */