/*    */ package org.passay;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum u
/*    */ {
/* 13 */   b,
/*    */ 
/*    */   
/* 16 */   c,
/*    */ 
/*    */   
/* 19 */   d;
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
/*    */   public boolean a(String paramString, char paramChar) {
/* 32 */     return i(paramString, String.valueOf(paramChar));
/*    */   }
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
/*    */   public boolean i(String paramString1, String paramString2) {
/*    */     boolean bool;
/* 47 */     switch (null.ap[ordinal()]) {
/*    */       
/*    */       case 1:
/* 50 */         bool = paramString1.startsWith(paramString2);
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
/* 63 */         return bool;case 2: bool = paramString1.endsWith(paramString2); return bool;case 3: bool = paramString1.contains(paramString2); return bool;
/*    */     } 
/*    */     throw new IllegalStateException("Unknown match type: " + this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/*    */     String str;
/* 71 */     switch (null.ap[ordinal()]) {
/*    */       
/*    */       case 1:
/* 74 */         str = "starts with";
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
/* 87 */         return str;case 2: str = "ends with"; return str;case 3: str = "contains"; return str;
/*    */     } 
/*    */     throw new IllegalStateException("Unknown match type: " + this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passa\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */