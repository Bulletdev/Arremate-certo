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
/*     */ 
/*     */ public class RelQuadBezTo
/*     */   implements GeometryRow
/*     */ {
/*  34 */   RelQuadBezTo _master = null;
/*     */ 
/*     */ 
/*     */   
/*  38 */   Double x = null;
/*     */ 
/*     */ 
/*     */   
/*  42 */   Double y = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   Double a = null;
/*     */ 
/*     */ 
/*     */   
/*  51 */   Double b = null;
/*     */   
/*  53 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RelQuadBezTo(RowType paramRowType) {
/*  59 */     if (paramRowType.isSetDel()) {
/*  60 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  62 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  63 */       String str = cellType.getN();
/*     */       
/*  65 */       if (str.equals("X")) {
/*  66 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  67 */       } else if (str.equals("Y")) {
/*  68 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  69 */       } else if (str.equals("A")) {
/*  70 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*  71 */       } else if (str.equals("B")) {
/*  72 */         this.b = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  74 */         throw new POIXMLException("Invalid cell '" + str + "' in RelQuadBezTo row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  81 */     if (this.deleted != null) {
/*  82 */       return this.deleted.booleanValue();
/*     */     }
/*  84 */     if (this._master != null) {
/*  85 */       return this._master.getDel();
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  91 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/*  95 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/*  99 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 103 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 108 */     this._master = (RelQuadBezTo)paramGeometryRow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 114 */     if (getDel()) {
/*     */       return;
/*     */     }
/* 117 */     double d1 = paramXDGFShape.getWidth().doubleValue();
/* 118 */     double d2 = paramXDGFShape.getHeight().doubleValue();
/*     */     
/* 120 */     paramDouble.quadTo(getA().doubleValue() * d1, getB().doubleValue() * d2, getX().doubleValue() * d1, getY().doubleValue() * d2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\RelQuadBezTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */