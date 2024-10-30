/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.awt.geom.Path2D;
/*    */ import org.apache.poi.sl.draw.binding.CTAdjPoint2D;
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
/*    */ public class MoveToCommand
/*    */   implements PathCommand
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   
/*    */   MoveToCommand(CTAdjPoint2D paramCTAdjPoint2D) {
/* 35 */     this.arg1 = paramCTAdjPoint2D.getX().toString();
/* 36 */     this.arg2 = paramCTAdjPoint2D.getY().toString();
/*    */   }
/*    */   
/*    */   MoveToCommand(String paramString1, String paramString2) {
/* 40 */     this.arg1 = paramString1;
/* 41 */     this.arg2 = paramString2;
/*    */   }
/*    */   
/*    */   public void execute(Path2D.Double paramDouble, Context paramContext) {
/* 45 */     double d1 = paramContext.getValue(this.arg1);
/* 46 */     double d2 = paramContext.getValue(this.arg2);
/* 47 */     paramDouble.moveTo(d1, d2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\MoveToCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */