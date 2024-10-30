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
/*    */ public class Guide
/*    */   extends Formula
/*    */ {
/*    */   private String name;
/*    */   private String fmla;
/*    */   private Expression expr;
/*    */   
/*    */   public Guide(CTGeomGuide paramCTGeomGuide) {
/* 34 */     this(paramCTGeomGuide.getName(), paramCTGeomGuide.getFmla());
/*    */   }
/*    */   
/*    */   public Guide(String paramString1, String paramString2) {
/* 38 */     this.name = paramString1;
/* 39 */     this.fmla = paramString2;
/* 40 */     this.expr = ExpressionParser.parse(paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   String getName() {
/* 45 */     return this.name;
/*    */   }
/*    */   
/*    */   String getFormula() {
/* 49 */     return this.fmla;
/*    */   }
/*    */ 
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 54 */     return this.expr.evaluate(paramContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\Guide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */