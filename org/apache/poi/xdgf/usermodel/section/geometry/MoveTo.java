/*    */ package org.apache.poi.xdgf.usermodel.section.geometry;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*    */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*    */ import java.awt.geom.Path2D;
/*    */ import org.apache.poi.POIXMLException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MoveTo
/*    */   implements GeometryRow
/*    */ {
/* 34 */   MoveTo _master = null;
/*    */   
/* 36 */   Double x = null;
/* 37 */   Double y = null;
/*    */   
/* 39 */   Boolean deleted = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MoveTo(RowType paramRowType) {
/* 45 */     if (paramRowType.isSetDel()) {
/* 46 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*    */     }
/* 48 */     for (CellType cellType : paramRowType.getCellArray()) {
/* 49 */       String str = cellType.getN();
/*    */       
/* 51 */       if (str.equals("X")) {
/* 52 */         this.x = XDGFCell.parseDoubleValue(cellType);
/* 53 */       } else if (str.equals("Y")) {
/* 54 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*    */       } else {
/* 56 */         throw new POIXMLException("Invalid cell '" + str + "' in MoveTo row");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     return "MoveTo: x=" + getX() + "; y=" + getY();
/*    */   }
/*    */   
/*    */   public boolean getDel() {
/* 68 */     if (this.deleted != null) {
/* 69 */       return this.deleted.booleanValue();
/*    */     }
/* 71 */     if (this._master != null) {
/* 72 */       return this._master.getDel();
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public Double getX() {
/* 78 */     return (this.x == null) ? this._master.x : this.x;
/*    */   }
/*    */   
/*    */   public Double getY() {
/* 82 */     return (this.y == null) ? this._master.y : this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 87 */     this._master = (MoveTo)paramGeometryRow;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 92 */     if (getDel())
/*    */       return; 
/* 94 */     paramDouble.moveTo(getX().doubleValue(), getY().doubleValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\MoveTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */