/*    */ package org.apache.poi.xdgf.usermodel.section.geometry;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*    */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*    */ import java.awt.geom.Path2D;
/*    */ import org.apache.poi.POIXMLException;
/*    */ import org.apache.poi.util.NotImplemented;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFCell;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFShape;
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
/*    */ public class PolyLineTo
/*    */   implements GeometryRow
/*    */ {
/* 30 */   PolyLineTo _master = null;
/*    */ 
/*    */   
/* 33 */   Double x = null;
/*    */ 
/*    */   
/* 36 */   Double y = null;
/*    */ 
/*    */   
/* 39 */   String a = null;
/*    */   
/* 41 */   Boolean deleted = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PolyLineTo(RowType paramRowType) {
/* 47 */     if (paramRowType.isSetDel()) {
/* 48 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*    */     }
/* 50 */     for (CellType cellType : paramRowType.getCellArray()) {
/* 51 */       String str = cellType.getN();
/*    */       
/* 53 */       if (str.equals("X")) {
/* 54 */         this.x = XDGFCell.parseDoubleValue(cellType);
/* 55 */       } else if (str.equals("Y")) {
/* 56 */         this.y = XDGFCell.parseDoubleValue(cellType);
/* 57 */       } else if (str.equals("A")) {
/* 58 */         this.a = cellType.getV();
/*    */       } else {
/* 60 */         throw new POIXMLException("Invalid cell '" + str + "' in ArcTo row");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getDel() {
/* 67 */     if (this.deleted != null) {
/* 68 */       return this.deleted.booleanValue();
/*    */     }
/* 70 */     if (this._master != null) {
/* 71 */       return this._master.getDel();
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public Double getX() {
/* 77 */     return (this.x == null) ? this._master.x : this.x;
/*    */   }
/*    */   
/*    */   public Double getY() {
/* 81 */     return (this.y == null) ? this._master.y : this.y;
/*    */   }
/*    */   
/*    */   public String getA() {
/* 85 */     return (this.a == null) ? this._master.a : this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 90 */     this._master = (PolyLineTo)paramGeometryRow;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotImplemented
/*    */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 96 */     if (getDel())
/*    */       return; 
/* 98 */     throw new POIXMLException("Polyline support not implemented");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\PolyLineTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */