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
/*     */ public class RelEllipticalArcTo
/*     */   implements GeometryRow
/*     */ {
/*  29 */   RelEllipticalArcTo _master = null;
/*     */ 
/*     */ 
/*     */   
/*  33 */   Double x = null;
/*     */ 
/*     */ 
/*     */   
/*  37 */   Double y = null;
/*     */ 
/*     */ 
/*     */   
/*  41 */   Double a = null;
/*     */ 
/*     */   
/*  44 */   Double b = null;
/*     */ 
/*     */   
/*  47 */   Double c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   Double d = null;
/*     */   
/*  54 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RelEllipticalArcTo(RowType paramRowType) {
/*  60 */     if (paramRowType.isSetDel()) {
/*  61 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  63 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  64 */       String str = cellType.getN();
/*     */       
/*  66 */       if (str.equals("X")) {
/*  67 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  68 */       } else if (str.equals("Y")) {
/*  69 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  70 */       } else if (str.equals("A")) {
/*  71 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*  72 */       } else if (str.equals("B")) {
/*  73 */         this.b = XDGFCell.parseDoubleValue(cellType);
/*  74 */       } else if (str.equals("C")) {
/*  75 */         this.c = XDGFCell.parseDoubleValue(cellType);
/*  76 */       } else if (str.equals("D")) {
/*  77 */         this.d = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  79 */         throw new POIXMLException("Invalid cell '" + str + "' in RelEllipticalArcTo row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  86 */     if (this.deleted != null) {
/*  87 */       return this.deleted.booleanValue();
/*     */     }
/*  89 */     if (this._master != null) {
/*  90 */       return this._master.getDel();
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  96 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/* 100 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/* 104 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 108 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */   
/*     */   public Double getC() {
/* 112 */     return (this.c == null) ? this._master.c : this.c;
/*     */   }
/*     */   
/*     */   public Double getD() {
/* 116 */     return (this.d == null) ? this._master.d : this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 121 */     this._master = (RelEllipticalArcTo)paramGeometryRow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 127 */     if (getDel()) {
/*     */       return;
/*     */     }
/* 130 */     double d1 = paramXDGFShape.getWidth().doubleValue();
/* 131 */     double d2 = paramXDGFShape.getHeight().doubleValue();
/*     */ 
/*     */     
/* 134 */     double d3 = getX().doubleValue() * d1;
/* 135 */     double d4 = getY().doubleValue() * d2;
/* 136 */     double d5 = getA().doubleValue() * d1;
/* 137 */     double d6 = getB().doubleValue() * d2;
/* 138 */     double d7 = getC().doubleValue();
/* 139 */     double d8 = getD().doubleValue();
/*     */     
/* 141 */     EllipticalArcTo.createEllipticalArc(d3, d4, d5, d6, d7, d8, paramDouble);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\RelEllipticalArcTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */