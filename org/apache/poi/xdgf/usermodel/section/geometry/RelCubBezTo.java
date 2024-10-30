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
/*     */ public class RelCubBezTo
/*     */   implements GeometryRow
/*     */ {
/*  29 */   RelCubBezTo _master = null;
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
/*     */   
/*  42 */   Double a = null;
/*     */ 
/*     */ 
/*     */   
/*  46 */   Double b = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   Double c = null;
/*     */ 
/*     */ 
/*     */   
/*  55 */   Double d = null;
/*     */   
/*  57 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RelCubBezTo(RowType paramRowType) {
/*  63 */     if (paramRowType.isSetDel()) {
/*  64 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  66 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  67 */       String str = cellType.getN();
/*     */       
/*  69 */       if (str.equals("X")) {
/*  70 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  71 */       } else if (str.equals("Y")) {
/*  72 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  73 */       } else if (str.equals("A")) {
/*  74 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*  75 */       } else if (str.equals("B")) {
/*  76 */         this.b = XDGFCell.parseDoubleValue(cellType);
/*  77 */       } else if (str.equals("C")) {
/*  78 */         this.c = XDGFCell.parseDoubleValue(cellType);
/*  79 */       } else if (str.equals("D")) {
/*  80 */         this.d = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  82 */         throw new POIXMLException("Invalid cell '" + str + "' in RelCubBezTo row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  89 */     if (this.deleted != null) {
/*  90 */       return this.deleted.booleanValue();
/*     */     }
/*  92 */     if (this._master != null) {
/*  93 */       return this._master.getDel();
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  99 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/* 103 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/* 107 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 111 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */   
/*     */   public Double getC() {
/* 115 */     return (this.c == null) ? this._master.c : this.c;
/*     */   }
/*     */   
/*     */   public Double getD() {
/* 119 */     return (this.d == null) ? this._master.d : this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 124 */     this._master = (RelCubBezTo)paramGeometryRow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 130 */     if (getDel()) {
/*     */       return;
/*     */     }
/* 133 */     double d1 = paramXDGFShape.getWidth().doubleValue();
/* 134 */     double d2 = paramXDGFShape.getHeight().doubleValue();
/*     */     
/* 136 */     paramDouble.curveTo(getA().doubleValue() * d1, getB().doubleValue() * d2, getC().doubleValue() * d1, getD().doubleValue() * d2, getX().doubleValue() * d1, getY().doubleValue() * d2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\RelCubBezTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */