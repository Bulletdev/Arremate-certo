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
/*    */ public class QuadToCommand
/*    */   implements PathCommand
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   private String arg3;
/*    */   private String arg4;
/*    */   
/*    */   QuadToCommand(CTAdjPoint2D paramCTAdjPoint2D1, CTAdjPoint2D paramCTAdjPoint2D2) {
/* 35 */     this.arg1 = paramCTAdjPoint2D1.getX().toString();
/* 36 */     this.arg2 = paramCTAdjPoint2D1.getY().toString();
/* 37 */     this.arg3 = paramCTAdjPoint2D2.getX().toString();
/* 38 */     this.arg4 = paramCTAdjPoint2D2.getY().toString();
/*    */   }
/*    */   
/*    */   public void execute(Path2D.Double paramDouble, Context paramContext) {
/* 42 */     double d1 = paramContext.getValue(this.arg1);
/* 43 */     double d2 = paramContext.getValue(this.arg2);
/* 44 */     double d3 = paramContext.getValue(this.arg3);
/* 45 */     double d4 = paramContext.getValue(this.arg4);
/* 46 */     paramDouble.quadTo(d1, d2, d3, d4);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\QuadToCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */