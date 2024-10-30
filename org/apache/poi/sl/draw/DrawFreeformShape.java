/*    */ package org.apache.poi.sl.draw;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.Path2D;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import org.apache.poi.sl.draw.geom.Outline;
/*    */ import org.apache.poi.sl.draw.geom.Path;
/*    */ import org.apache.poi.sl.usermodel.AutoShape;
/*    */ import org.apache.poi.sl.usermodel.FillStyle;
/*    */ import org.apache.poi.sl.usermodel.FreeformShape;
/*    */ import org.apache.poi.sl.usermodel.Shape;
/*    */ import org.apache.poi.sl.usermodel.SimpleShape;
/*    */ import org.apache.poi.sl.usermodel.StrokeStyle;
/*    */ import org.apache.poi.sl.usermodel.TextShape;
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
/*    */ public class DrawFreeformShape
/*    */   extends DrawAutoShape
/*    */ {
/*    */   public DrawFreeformShape(FreeformShape<?, ?> paramFreeformShape) {
/* 33 */     super((AutoShape<?, ?>)paramFreeformShape);
/*    */   }
/*    */   
/*    */   protected Collection<Outline> computeOutlines(Graphics2D paramGraphics2D) {
/* 37 */     ArrayList<Outline> arrayList = new ArrayList();
/* 38 */     Path2D.Double double_ = getShape().getPath();
/* 39 */     FillStyle fillStyle = getShape().getFillStyle();
/* 40 */     StrokeStyle strokeStyle = getShape().getStrokeStyle();
/* 41 */     Path path = new Path((fillStyle != null), (strokeStyle != null));
/* 42 */     arrayList.add(new Outline(double_, path));
/* 43 */     return arrayList;
/*    */   }
/*    */ 
/*    */   
/*    */   protected FreeformShape<?, ?> getShape() {
/* 48 */     return (FreeformShape<?, ?>)this.shape;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawFreeformShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */