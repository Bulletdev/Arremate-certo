/*    */ package org.apache.poi.sl.usermodel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface LineDecoration
/*    */ {
/*    */   DecorationShape getHeadShape();
/*    */   
/*    */   DecorationSize getHeadWidth();
/*    */   
/*    */   DecorationSize getHeadLength();
/*    */   
/*    */   DecorationShape getTailShape();
/*    */   
/*    */   DecorationSize getTailWidth();
/*    */   
/*    */   DecorationSize getTailLength();
/*    */   
/*    */   public enum DecorationShape
/*    */   {
/* 25 */     NONE(0, 1),
/* 26 */     TRIANGLE(1, 2),
/* 27 */     STEALTH(2, 3),
/* 28 */     DIAMOND(3, 4),
/* 29 */     OVAL(4, 5),
/* 30 */     ARROW(5, 6);
/*    */     
/*    */     public final int nativeId;
/*    */     public final int ooxmlId;
/*    */     
/*    */     DecorationShape(int param1Int1, int param1Int2) {
/* 36 */       this.nativeId = param1Int1;
/* 37 */       this.ooxmlId = param1Int2;
/*    */     }
/*    */     
/*    */     public static DecorationShape fromNativeId(int param1Int) {
/* 41 */       for (DecorationShape decorationShape : values()) {
/* 42 */         if (decorationShape.nativeId == param1Int) return decorationShape; 
/*    */       } 
/* 44 */       return null;
/*    */     }
/*    */     
/*    */     public static DecorationShape fromOoxmlId(int param1Int) {
/* 48 */       for (DecorationShape decorationShape : values()) {
/* 49 */         if (decorationShape.ooxmlId == param1Int) return decorationShape; 
/*    */       } 
/* 51 */       return null;
/*    */     }
/*    */   }
/*    */   
/*    */   public enum DecorationSize {
/* 56 */     SMALL(0, 1),
/* 57 */     MEDIUM(1, 2),
/* 58 */     LARGE(2, 3);
/*    */     
/*    */     public final int nativeId;
/*    */     public final int ooxmlId;
/*    */     
/*    */     DecorationSize(int param1Int1, int param1Int2) {
/* 64 */       this.nativeId = param1Int1;
/* 65 */       this.ooxmlId = param1Int2;
/*    */     }
/*    */     
/*    */     public static DecorationSize fromNativeId(int param1Int) {
/* 69 */       for (DecorationSize decorationSize : values()) {
/* 70 */         if (decorationSize.nativeId == param1Int) return decorationSize; 
/*    */       } 
/* 72 */       return null;
/*    */     }
/*    */     
/*    */     public static DecorationSize fromOoxmlId(int param1Int) {
/* 76 */       for (DecorationSize decorationSize : values()) {
/* 77 */         if (decorationSize.ooxmlId == param1Int) return decorationSize; 
/*    */       } 
/* 79 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\LineDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */