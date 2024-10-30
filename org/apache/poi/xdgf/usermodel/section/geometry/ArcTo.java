/*     */ package org.apache.poi.xdgf.usermodel.section.geometry;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Arc2D;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.Point2D;
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
/*     */ public class ArcTo
/*     */   implements GeometryRow
/*     */ {
/*  34 */   ArcTo _master = null;
/*     */ 
/*     */   
/*  37 */   Double x = null;
/*     */ 
/*     */   
/*  40 */   Double y = null;
/*     */ 
/*     */   
/*  43 */   Double a = null;
/*     */   
/*  45 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArcTo(RowType paramRowType) {
/*  51 */     if (paramRowType.isSetDel()) {
/*  52 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  54 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  55 */       String str = cellType.getN();
/*     */       
/*  57 */       if (str.equals("X")) {
/*  58 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  59 */       } else if (str.equals("Y")) {
/*  60 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  61 */       } else if (str.equals("A")) {
/*  62 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  64 */         throw new POIXMLException("Invalid cell '" + str + "' in ArcTo row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  71 */     if (this.deleted != null) {
/*  72 */       return this.deleted.booleanValue();
/*     */     }
/*  74 */     if (this._master != null) {
/*  75 */       return this._master.getDel();
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  81 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/*  85 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/*  89 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/*  94 */     this._master = (ArcTo)paramGeometryRow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 100 */     if (getDel()) {
/*     */       return;
/*     */     }
/* 103 */     Point2D point2D = paramDouble.getCurrentPoint();
/*     */ 
/*     */     
/* 106 */     double d1 = getX().doubleValue();
/* 107 */     double d2 = getY().doubleValue();
/* 108 */     double d3 = getA().doubleValue();
/*     */     
/* 110 */     if (d3 == 0.0D) {
/* 111 */       paramDouble.lineTo(d1, d2);
/*     */       
/*     */       return;
/*     */     } 
/* 115 */     double d4 = point2D.getX();
/* 116 */     double d5 = point2D.getY();
/*     */     
/* 118 */     double d6 = Math.hypot(d2 - d5, d1 - d4);
/* 119 */     double d7 = (4.0D * d3 * d3 + d6 * d6) / 8.0D * Math.abs(d3);
/*     */ 
/*     */ 
/*     */     
/* 123 */     double d8 = d4 + (d1 - d4) / 2.0D;
/* 124 */     double d9 = d5 + (d2 - d5) / 2.0D;
/*     */     
/* 126 */     double d10 = Math.atan2(d2 - d9, d1 - d8);
/*     */     
/* 128 */     Arc2D.Double double_ = new Arc2D.Double(d4, d5 - d7, d6, 2.0D * d7, 180.0D, (d4 < d1) ? 180.0D : -180.0D, 0);
/*     */ 
/*     */     
/* 131 */     paramDouble.append(AffineTransform.getRotateInstance(d10, d4, d5).createTransformedShape(double_), true);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\ArcTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */