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
/*    */ public class RelMoveTo
/*    */   implements GeometryRow
/*    */ {
/* 29 */   RelMoveTo _master = null;
/*    */   
/* 31 */   Double x = null;
/* 32 */   Double y = null;
/*    */   
/* 34 */   Boolean deleted = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RelMoveTo(RowType paramRowType) {
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
/* 51 */         throw new POIXMLException("Invalid cell '" + str + "' in RelMoveTo row");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getDel() {
/* 58 */     if (this.deleted != null) {
/* 59 */       return this.deleted.booleanValue();
/*    */     }
/* 61 */     if (this._master != null) {
/* 62 */       return this._master.getDel();
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public Double getX() {
/* 68 */     return (this.x == null) ? this._master.x : this.x;
/*    */   }
/*    */   
/*    */   public Double getY() {
/* 72 */     return (this.y == null) ? this._master.y : this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 77 */     this._master = (RelMoveTo)paramGeometryRow;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 83 */     if (getDel()) {
/*    */       return;
/*    */     }
/* 86 */     paramDouble.moveTo(getX().doubleValue() * paramXDGFShape.getWidth().doubleValue(), getY().doubleValue() * paramXDGFShape.getHeight().doubleValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\RelMoveTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */