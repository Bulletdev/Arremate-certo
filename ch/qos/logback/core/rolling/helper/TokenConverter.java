/*    */ package ch.qos.logback.core.rolling.helper;
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
/*    */ public class TokenConverter
/*    */ {
/*    */   static final int IDENTITY = 0;
/*    */   static final int INTEGER = 1;
/*    */   static final int DATE = 1;
/*    */   int type;
/*    */   TokenConverter next;
/*    */   
/*    */   protected TokenConverter(int paramInt) {
/* 35 */     this.type = paramInt;
/*    */   }
/*    */   
/*    */   public TokenConverter getNext() {
/* 39 */     return this.next;
/*    */   }
/*    */   
/*    */   public void setNext(TokenConverter paramTokenConverter) {
/* 43 */     this.next = paramTokenConverter;
/*    */   }
/*    */   
/*    */   public int getType() {
/* 47 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(int paramInt) {
/* 51 */     this.type = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\TokenConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */