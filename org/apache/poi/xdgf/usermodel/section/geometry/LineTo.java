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
/*    */ public class LineTo
/*    */   implements GeometryRow
/*    */ {
/* 29 */   LineTo _master = null;
/*    */   
/* 31 */   Double x = null;
/* 32 */   Double y = null;
/*    */   
/* 34 */   Boolean deleted = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LineTo(RowType paramRowType) {
/* 40 */     if (paramRowType.isSetDel()) {
/* 41 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*    */     }
/* 43 */     for (CellType cellType : paramRowType.getCellArray()) {
/* 44 */       String str = cellType.getN();
/*    */       
/* 46 */       if (str.equals("X")) {
/* 47 */         this.x = XDGFCell.parseDoubleValue(cellType);
/* 48 */       } else if (str.equals("Y")) {
/* 49 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*    */       } else {
/* 51 */         throw new POIXMLException("Invalid cell '" + str + "' in LineTo row");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 59 */     return "LineTo: x=" + getX() + "; y=" + getY();
/*    */   }
/*    */   
/*    */   public boolean getDel() {
/* 63 */     if (this.deleted != null) {
/* 64 */       return this.deleted.booleanValue();
/*    */     }
/* 66 */     if (this._master != null) {
/* 67 */       return this._master.getDel();
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public Double getX() {
/* 73 */     return (this.x == null) ? this._master.x : this.x;
/*    */   }
/*    */   
/*    */   public Double getY() {
/* 77 */     return (this.y == null) ? this._master.y : this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 82 */     this._master = (LineTo)paramGeometryRow;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 87 */     if (getDel())
/*    */       return; 
/* 89 */     paramDouble.lineTo(getX().doubleValue(), getY().doubleValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\LineTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */