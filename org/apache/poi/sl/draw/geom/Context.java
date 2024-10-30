/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class Context
/*    */ {
/* 32 */   final Map<String, Double> _ctx = new HashMap<String, Double>();
/*    */   final IAdjustableShape _props;
/*    */   final Rectangle2D _anchor;
/*    */   
/*    */   public Context(CustomGeometry paramCustomGeometry, Rectangle2D paramRectangle2D, IAdjustableShape paramIAdjustableShape) {
/* 37 */     this._props = paramIAdjustableShape;
/* 38 */     this._anchor = paramRectangle2D;
/* 39 */     for (Guide guide : paramCustomGeometry.adjusts) evaluate(guide); 
/* 40 */     for (Guide guide : paramCustomGeometry.guides) evaluate(guide); 
/*    */   }
/*    */   
/*    */   public Rectangle2D getShapeAnchor() {
/* 44 */     return this._anchor;
/*    */   }
/*    */   
/*    */   public Guide getAdjustValue(String paramString) {
/* 48 */     return this._props.getAdjustValue(paramString);
/*    */   }
/*    */   
/*    */   public double getValue(String paramString) {
/* 52 */     if (paramString.matches("(\\+|-)?\\d+")) {
/* 53 */       return Double.parseDouble(paramString);
/*    */     }
/*    */     
/* 56 */     Formula formula = Formula.builtInFormulas.get(paramString);
/* 57 */     if (formula != null) {
/* 58 */       return formula.evaluate(this);
/*    */     }
/*    */     
/* 61 */     if (!this._ctx.containsKey(paramString)) {
/* 62 */       throw new RuntimeException("undefined variable: " + paramString);
/*    */     }
/*    */     
/* 65 */     return ((Double)this._ctx.get(paramString)).doubleValue();
/*    */   }
/*    */   
/*    */   public double evaluate(Formula paramFormula) {
/* 69 */     double d = paramFormula.evaluate(this);
/* 70 */     String str = paramFormula.getName();
/* 71 */     if (str != null) this._ctx.put(str, Double.valueOf(d)); 
/* 72 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */