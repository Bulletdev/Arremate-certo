/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import org.apache.poi.sl.usermodel.MasterSheet;
/*    */ import org.apache.poi.sl.usermodel.Placeholder;
/*    */ import org.apache.poi.sl.usermodel.Shape;
/*    */ import org.apache.poi.sl.usermodel.Sheet;
/*    */ import org.apache.poi.sl.usermodel.SimpleShape;
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
/*    */ public class DrawMasterSheet
/*    */   extends DrawSheet
/*    */ {
/*    */   public DrawMasterSheet(MasterSheet<?, ?> paramMasterSheet) {
/* 26 */     super((Sheet<?, ?>)paramMasterSheet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean canDraw(Shape<?, ?> paramShape) {
/* 37 */     if (paramShape instanceof SimpleShape) {
/* 38 */       Placeholder placeholder = ((SimpleShape)paramShape).getPlaceholder();
/* 39 */       return (placeholder == null);
/*    */     } 
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawMasterSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */