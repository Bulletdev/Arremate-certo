/*    */ package org.apache.xmlbeans.impl.regex;
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
/*    */ public class ParseException
/*    */   extends RuntimeException
/*    */ {
/*    */   int location;
/*    */   
/*    */   public ParseException(String paramString, int paramInt) {
/* 34 */     super(paramString);
/* 35 */     this.location = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLocation() {
/* 43 */     return this.location;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\ParseException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */