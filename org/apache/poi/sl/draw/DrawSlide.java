/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import org.apache.poi.sl.usermodel.Background;
/*    */ import org.apache.poi.sl.usermodel.Sheet;
/*    */ import org.apache.poi.sl.usermodel.Slide;
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
/*    */ public class DrawSlide
/*    */   extends DrawSheet
/*    */ {
/*    */   public DrawSlide(Slide<?, ?> paramSlide) {
/* 28 */     super((Sheet<?, ?>)paramSlide);
/*    */   }
/*    */   
/*    */   public void draw(Graphics2D paramGraphics2D) {
/* 32 */     Background<?, ?> background = this.sheet.getBackground();
/* 33 */     if (background != null) {
/* 34 */       DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/* 35 */       DrawBackground drawBackground = drawFactory.getDrawable(background);
/* 36 */       drawBackground.draw(paramGraphics2D);
/*    */     } 
/*    */     
/* 39 */     super.draw(paramGraphics2D);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawSlide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */