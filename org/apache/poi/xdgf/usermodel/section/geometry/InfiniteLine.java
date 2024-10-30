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
/*     */ public class InfiniteLine
/*     */   implements GeometryRow
/*     */ {
/*  34 */   InfiniteLine _master = null;
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
/*  46 */   Double a = null;
/*     */ 
/*     */ 
/*     */   
/*  50 */   Double b = null;
/*     */   
/*  52 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InfiniteLine(RowType paramRowType) {
/*  58 */     if (paramRowType.isSetDel()) {
/*  59 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  61 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  62 */       String str = cellType.getN();
/*     */       
/*  64 */       if (str.equals("X")) {
/*  65 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  66 */       } else if (str.equals("Y")) {
/*  67 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  68 */       } else if (str.equals("A")) {
/*  69 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*  70 */       } else if (str.equals("B")) {
/*  71 */         this.b = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  73 */         throw new POIXMLException("Invalid cell '" + str + "' in InfiniteLine row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  80 */     if (this.deleted != null) {
/*  81 */       return this.deleted.booleanValue();
/*     */     }
/*  83 */     if (this._master != null) {
/*  84 */       return this._master.getDel();
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  90 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/*  94 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/*  98 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 102 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 107 */     this._master = (InfiniteLine)paramGeometryRow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 113 */     if (getDel()) {
/*     */       return;
/*     */     }
/* 116 */     throw new POIXMLException("InfiniteLine elements cannot be part of a path");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path2D.Double getPath() {
/* 123 */     Path2D.Double double_ = new Path2D.Double();
/*     */ 
/*     */     
/* 126 */     double d1 = 100000.0D;
/*     */ 
/*     */     
/* 129 */     double d2 = getX().doubleValue();
/* 130 */     double d3 = getY().doubleValue();
/* 131 */     double d4 = getA().doubleValue();
/* 132 */     double d5 = getB().doubleValue();
/*     */     
/* 134 */     if (d2 == d4) {
/* 135 */       double_.moveTo(d2, -d1);
/* 136 */       double_.lineTo(d2, d1);
/* 137 */     } else if (d3 == d5) {
/* 138 */       double_.moveTo(-d1, d3);
/* 139 */       double_.lineTo(d1, d3);
/*     */     }
/*     */     else {
/*     */       
/* 143 */       double d6 = (d5 - d3) / (d4 - d2);
/* 144 */       double d7 = d3 - d6 * d2;
/*     */ 
/*     */ 
/*     */       
/* 148 */       double_.moveTo(d1, d6 * d1 + d7);
/* 149 */       double_.lineTo(d1, (d1 - d7) / d6);
/*     */     } 
/*     */     
/* 152 */     return double_;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\InfiniteLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */