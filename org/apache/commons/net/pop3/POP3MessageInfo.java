/*    */ package org.apache.commons.net.pop3;
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
/*    */ public final class POP3MessageInfo
/*    */ {
/*    */   public int number;
/*    */   public int size;
/*    */   public String identifier;
/*    */   
/*    */   public POP3MessageInfo() {
/* 54 */     this(0, null, 0);
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
/*    */   public POP3MessageInfo(int paramInt1, int paramInt2) {
/* 66 */     this(paramInt1, null, paramInt2);
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
/*    */   public POP3MessageInfo(int paramInt, String paramString) {
/* 78 */     this(paramInt, paramString, -1);
/*    */   }
/*    */   
/*    */   private POP3MessageInfo(int paramInt1, String paramString, int paramInt2) {
/* 82 */     this.number = paramInt1;
/* 83 */     this.size = paramInt2;
/* 84 */     this.identifier = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 92 */     return "Number: " + this.number + ". Size: " + this.size + ". Id: " + this.identifier;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\pop3\POP3MessageInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */