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
/*    */ public class CurveToCommand
/*    */   implements PathCommand
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   private String arg3;
/*    */   private String arg4;
/*    */   private String arg5;
/*    */   private String arg6;
/*    */   
/*    */   CurveToCommand(CTAdjPoint2D paramCTAdjPoint2D1, CTAdjPoint2D paramCTAdjPoint2D2, CTAdjPoint2D paramCTAdjPoint2D3) {
/* 35 */     this.arg1 = paramCTAdjPoint2D1.getX().toString();
/* 36 */     this.arg2 = paramCTAdjPoint2D1.getY().toString();
/* 37 */     this.arg3 = paramCTAdjPoint2D2.getX().toString();
/* 38 */     this.arg4 = paramCTAdjPoint2D2.getY().toString();
/* 39 */     this.arg5 = paramCTAdjPoint2D3.getX().toString();
/* 40 */     this.arg6 = paramCTAdjPoint2D3.getY().toString();
/*    */   }
/*    */   
/*    */   public void execute(Path2D.Double paramDouble, Context paramContext) {
/* 44 */     double d1 = paramContext.getValue(this.arg1);
/* 45 */     double d2 = paramContext.getValue(this.arg2);
/* 46 */     double d3 = paramContext.getValue(this.arg3);
/* 47 */     double d4 = paramContext.getValue(this.arg4);
/* 48 */     double d5 = paramContext.getValue(this.arg5);
/* 49 */     double d6 = paramContext.getValue(this.arg6);
/* 50 */     paramDouble.curveTo(d1, d2, d3, d4, d5, d6);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\CurveToCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */