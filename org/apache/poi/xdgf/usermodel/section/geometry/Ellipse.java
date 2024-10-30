/*     */ package org.apache.poi.xdgf.usermodel.section.geometry;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Ellipse2D;
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
/*     */ public class Ellipse
/*     */   implements GeometryRow
/*     */ {
/*  33 */   Ellipse _master = null;
/*     */ 
/*     */   
/*  36 */   Double x = null;
/*     */   
/*  38 */   Double y = null;
/*     */ 
/*     */   
/*  41 */   Double a = null;
/*     */   
/*  43 */   Double b = null;
/*     */ 
/*     */   
/*  46 */   Double c = null;
/*     */   
/*  48 */   Double d = null;
/*     */   
/*  50 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse(RowType paramRowType) {
/*  56 */     if (paramRowType.isSetDel()) {
/*  57 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  59 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  60 */       String str = cellType.getN();
/*     */       
/*  62 */       if (str.equals("X")) {
/*  63 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  64 */       } else if (str.equals("Y")) {
/*  65 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  66 */       } else if (str.equals("A")) {
/*  67 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*  68 */       } else if (str.equals("B")) {
/*  69 */         this.b = XDGFCell.parseDoubleValue(cellType);
/*  70 */       } else if (str.equals("C")) {
/*  71 */         this.c = XDGFCell.parseDoubleValue(cellType);
/*  72 */       } else if (str.equals("D")) {
/*  73 */         this.d = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  75 */         throw new POIXMLException("Invalid cell '" + str + "' in Ellipse row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  82 */     if (this.deleted != null) {
/*  83 */       return this.deleted.booleanValue();
/*     */     }
/*  85 */     if (this._master != null) {
/*  86 */       return this._master.getDel();
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  92 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/*  96 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/* 100 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 104 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */   
/*     */   public Double getC() {
/* 108 */     return (this.c == null) ? this._master.c : this.c;
/*     */   }
/*     */   
/*     */   public Double getD() {
/* 112 */     return (this.d == null) ? this._master.d : this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 117 */     this._master = (Ellipse)paramGeometryRow;
/*     */   }
/*     */ 
/*     */   
/*     */   public Path2D.Double getPath() {
/* 122 */     if (getDel()) {
/* 123 */       return null;
/*     */     }
/*     */     
/* 126 */     double d1 = getX().doubleValue();
/* 127 */     double d2 = getY().doubleValue();
/* 128 */     double d3 = getA().doubleValue();
/* 129 */     double d4 = getB().doubleValue();
/* 130 */     double d5 = getC().doubleValue();
/* 131 */     double d6 = getD().doubleValue();
/*     */ 
/*     */     
/* 134 */     double d7 = Math.hypot(d3 - d1, d4 - d2);
/* 135 */     double d8 = Math.hypot(d5 - d1, d6 - d2);
/*     */ 
/*     */     
/* 138 */     double d9 = (6.283185307179586D + ((d2 > d4) ? 1.0D : -1.0D) * Math.acos((d1 - d3) / d7)) % 6.283185307179586D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     Ellipse2D.Double double_ = new Ellipse2D.Double(d1 - d7, d2 - d8, d7 * 2.0D, d8 * 2.0D);
/*     */ 
/*     */ 
/*     */     
/* 147 */     Path2D.Double double_1 = new Path2D.Double(double_);
/*     */     
/* 149 */     AffineTransform affineTransform = new AffineTransform();
/* 150 */     affineTransform.rotate(d9, d1, d2);
/* 151 */     double_1.transform(affineTransform);
/*     */     
/* 153 */     return double_1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 158 */     throw new POIXMLException("Ellipse elements cannot be part of a path");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\Ellipse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */