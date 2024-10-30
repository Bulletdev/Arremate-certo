/*     */ package org.apache.poi.xdgf.usermodel.section.geometry;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*     */ import java.awt.geom.Path2D;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.xdgf.usermodel.XDGFCell;
/*     */ import org.apache.poi.xdgf.usermodel.XDGFShape;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SplineKnot
/*     */   implements GeometryRow
/*     */ {
/*  33 */   SplineKnot _master = null;
/*     */ 
/*     */   
/*  36 */   Double x = null;
/*     */ 
/*     */   
/*  39 */   Double y = null;
/*     */ 
/*     */   
/*  42 */   Double a = null;
/*     */   
/*  44 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SplineKnot(RowType paramRowType) {
/*  50 */     if (paramRowType.isSetDel()) {
/*  51 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  53 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  54 */       String str = cellType.getN();
/*     */       
/*  56 */       if (str.equals("X")) {
/*  57 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  58 */       } else if (str.equals("Y")) {
/*  59 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  60 */       } else if (str.equals("A")) {
/*  61 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  63 */         throw new POIXMLException("Invalid cell '" + str + "' in SplineKnot row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  70 */     if (this.deleted != null) {
/*  71 */       return this.deleted.booleanValue();
/*     */     }
/*  73 */     if (this._master != null) {
/*  74 */       return this._master.getDel();
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  80 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/*  84 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/*  88 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/*  93 */     this._master = (SplineKnot)paramGeometryRow;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/*  98 */     throw new POIXMLException("Error: Use SplineRenderer!");
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     return "{SplineKnot x=" + getX() + " y=" + getY() + " a=" + getA() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\SplineKnot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */