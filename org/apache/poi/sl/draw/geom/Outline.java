/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.awt.Shape;
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
/*    */ public class Outline
/*    */ {
/*    */   private Shape shape;
/*    */   private Path path;
/*    */   
/*    */   public Outline(Shape paramShape, Path paramPath) {
/* 34 */     this.shape = paramShape;
/* 35 */     this.path = paramPath;
/*    */   }
/*    */   
/*    */   public Path getPath() {
/* 39 */     return this.path;
/*    */   }
/*    */   
/*    */   public Shape getOutline() {
/* 43 */     return this.shape;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\Outline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */