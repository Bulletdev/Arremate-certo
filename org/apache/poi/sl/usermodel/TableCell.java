/*    */ package org.apache.poi.sl.usermodel;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public interface TableCell<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>>
/*    */   extends TextShape<S, P>
/*    */ {
/*    */   StrokeStyle getBorderStyle(BorderEdge paramBorderEdge);
/*    */   
/*    */   void setBorderStyle(BorderEdge paramBorderEdge, StrokeStyle paramStrokeStyle);
/*    */   
/*    */   void setBorderWidth(BorderEdge paramBorderEdge, double paramDouble);
/*    */   
/*    */   void setBorderColor(BorderEdge paramBorderEdge, Color paramColor);
/*    */   
/*    */   void setBorderCompound(BorderEdge paramBorderEdge, StrokeStyle.LineCompound paramLineCompound);
/*    */   
/*    */   void setBorderDash(BorderEdge paramBorderEdge, StrokeStyle.LineDash paramLineDash);
/*    */   
/*    */   void removeBorder(BorderEdge paramBorderEdge);
/*    */   
/*    */   int getGridSpan();
/*    */   
/*    */   int getRowSpan();
/*    */   
/*    */   boolean isMerged();
/*    */   
/*    */   public enum BorderEdge {
/* 29 */     bottom, left, top, right;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\TableCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */