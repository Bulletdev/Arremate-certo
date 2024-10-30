/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import org.apache.poi.sl.draw.binding.CTGeomGuide;
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
/*    */ public class AdjustValue
/*    */   extends Guide
/*    */ {
/*    */   public AdjustValue(CTGeomGuide paramCTGeomGuide) {
/* 32 */     super(paramCTGeomGuide.getName(), paramCTGeomGuide.getFmla());
/*    */   }
/*    */ 
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 37 */     String str = getName();
/* 38 */     Guide guide = paramContext.getAdjustValue(str);
/* 39 */     if (guide != null) {
/* 40 */       return guide.evaluate(paramContext);
/*    */     }
/* 42 */     return super.evaluate(paramContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\AdjustValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */