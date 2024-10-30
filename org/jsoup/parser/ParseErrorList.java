/*    */ package org.jsoup.parser;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ParseErrorList
/*    */   extends ArrayList<ParseError>
/*    */ {
/*    */   private static final int INITIAL_CAPACITY = 16;
/*    */   private final int maxSize;
/*    */   
/*    */   ParseErrorList(int paramInt1, int paramInt2) {
/* 15 */     super(paramInt1);
/* 16 */     this.maxSize = paramInt2;
/*    */   }
/*    */   
/*    */   boolean canAddError() {
/* 20 */     return (size() < this.maxSize);
/*    */   }
/*    */   
/*    */   int getMaxSize() {
/* 24 */     return this.maxSize;
/*    */   }
/*    */   
/*    */   static ParseErrorList noTracking() {
/* 28 */     return new ParseErrorList(0, 0);
/*    */   }
/*    */   
/*    */   static ParseErrorList tracking(int paramInt) {
/* 32 */     return new ParseErrorList(16, paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\ParseErrorList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */