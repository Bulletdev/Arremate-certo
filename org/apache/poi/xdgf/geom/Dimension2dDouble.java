/*    */ package org.apache.poi.xdgf.geom;
/*    */ 
/*    */ import java.awt.geom.Dimension2D;
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
/*    */ public class Dimension2dDouble
/*    */   extends Dimension2D
/*    */ {
/*    */   double width;
/*    */   double height;
/*    */   
/*    */   public Dimension2dDouble() {
/* 28 */     this.width = 0.0D;
/* 29 */     this.height = 0.0D;
/*    */   }
/*    */   
/*    */   public Dimension2dDouble(double paramDouble1, double paramDouble2) {
/* 33 */     this.width = paramDouble1;
/* 34 */     this.height = paramDouble2;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getWidth() {
/* 39 */     return this.width;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getHeight() {
/* 44 */     return this.height;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setSize(double paramDouble1, double paramDouble2) {
/* 49 */     this.width = paramDouble1;
/* 50 */     this.height = paramDouble2;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 55 */     if (paramObject instanceof Dimension2dDouble) {
/* 56 */       Dimension2dDouble dimension2dDouble = (Dimension2dDouble)paramObject;
/* 57 */       return (this.width == dimension2dDouble.width && this.height == dimension2dDouble.height);
/*    */     } 
/*    */     
/* 60 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 65 */     double d = this.width + this.height;
/* 66 */     return (int)Math.ceil(d * (d + 1.0D) / 2.0D + this.width);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     return "Dimension2dDouble[" + this.width + ", " + this.height + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdgf\geom\Dimension2dDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */