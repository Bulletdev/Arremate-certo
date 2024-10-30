/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.awt.geom.Arc2D;
/*    */ import java.awt.geom.Path2D;
/*    */ import java.awt.geom.Point2D;
/*    */ import org.apache.poi.sl.draw.binding.CTPath2DArcTo;
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
/*    */ public class ArcToCommand
/*    */   implements PathCommand
/*    */ {
/*    */   private String hr;
/*    */   private String wr;
/*    */   private String stAng;
/*    */   private String swAng;
/*    */   
/*    */   ArcToCommand(CTPath2DArcTo paramCTPath2DArcTo) {
/* 45 */     this.hr = paramCTPath2DArcTo.getHR().toString();
/* 46 */     this.wr = paramCTPath2DArcTo.getWR().toString();
/* 47 */     this.stAng = paramCTPath2DArcTo.getStAng().toString();
/* 48 */     this.swAng = paramCTPath2DArcTo.getSwAng().toString();
/*    */   }
/*    */   
/*    */   public void execute(Path2D.Double paramDouble, Context paramContext) {
/* 52 */     double d1 = paramContext.getValue(this.wr);
/* 53 */     double d2 = paramContext.getValue(this.hr);
/* 54 */     double d3 = paramContext.getValue(this.stAng) / 60000.0D;
/* 55 */     double d4 = paramContext.getValue(this.swAng) / 60000.0D;
/* 56 */     Point2D point2D = paramDouble.getCurrentPoint();
/* 57 */     double d5 = point2D.getX() - d1 - d1 * Math.cos(Math.toRadians(d3));
/* 58 */     double d6 = point2D.getY() - d2 - d2 * Math.sin(Math.toRadians(d3));
/*    */     
/* 60 */     Arc2D.Double double_ = new Arc2D.Double(d5, d6, 2.0D * d1, 2.0D * d2, -d3, -d4, 0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 66 */     paramDouble.append(double_, true);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\ArcToCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */