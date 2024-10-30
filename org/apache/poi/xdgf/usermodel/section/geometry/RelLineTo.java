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
/*    */ public class RelLineTo
/*    */   implements GeometryRow
/*    */ {
/* 33 */   RelLineTo _master = null;
/*    */   
/* 35 */   Double x = null;
/* 36 */   Double y = null;
/*    */   
/* 38 */   Boolean deleted = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RelLineTo(RowType paramRowType) {
/* 44 */     if (paramRowType.isSetDel()) {
/* 45 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*    */     }
/* 47 */     for (CellType cellType : paramRowType.getCellArray()) {
/* 48 */       String str = cellType.getN();
/*    */       
/* 50 */       if (str.equals("X")) {
/* 51 */         this.x = XDGFCell.parseDoubleValue(cellType);
/* 52 */       } else if (str.equals("Y")) {
/* 53 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*    */       } else {
/* 55 */         throw new POIXMLException("Invalid cell '" + str + "' in RelLineTo row");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getDel() {
/* 62 */     if (this.deleted != null) {
/* 63 */       return this.deleted.booleanValue();
/*    */     }
/* 65 */     if (this._master != null) {
/* 66 */       return this._master.getDel();
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public Double getX() {
/* 72 */     return (this.x == null) ? this._master.x : this.x;
/*    */   }
/*    */   
/*    */   public Double getY() {
/* 76 */     return (this.y == null) ? this._master.y : this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 81 */     this._master = (RelLineTo)paramGeometryRow;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 87 */     if (getDel()) {
/*    */       return;
/*    */     }
/* 90 */     paramDouble.lineTo(getX().doubleValue() * paramXDGFShape.getWidth().doubleValue(), getY().doubleValue() * paramXDGFShape.getHeight().doubleValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\RelLineTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */