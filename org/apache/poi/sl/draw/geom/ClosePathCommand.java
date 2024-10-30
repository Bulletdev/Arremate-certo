/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.awt.geom.Path2D;
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
/*    */ public class ClosePathCommand
/*    */   implements PathCommand
/*    */ {
/*    */   public void execute(Path2D.Double paramDouble, Context paramContext) {
/* 35 */     paramDouble.closePath();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\ClosePathCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */