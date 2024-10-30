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
/*     */ public class SplineStart
/*     */   implements GeometryRow
/*     */ {
/*  32 */   SplineStart _master = null;
/*     */ 
/*     */   
/*  35 */   Double x = null;
/*     */ 
/*     */   
/*  38 */   Double y = null;
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
/*  50 */   Integer d = null;
/*     */   
/*  52 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SplineStart(RowType paramRowType) {
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
/*  72 */       } else if (str.equals("C")) {
/*  73 */         this.c = XDGFCell.parseDoubleValue(cellType);
/*  74 */       } else if (str.equals("D")) {
/*  75 */         this.d = XDGFCell.parseIntegerValue(cellType);
/*     */       } else {
/*  77 */         throw new POIXMLException("Invalid cell '" + str + "' in SplineStart row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  84 */     if (this.deleted != null) {
/*  85 */       return this.deleted.booleanValue();
/*     */     }
/*  87 */     if (this._master != null) {
/*  88 */       return this._master.getDel();
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/*  94 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/*  98 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/* 102 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 106 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */   
/*     */   public Double getC() {
/* 110 */     return (this.c == null) ? this._master.c : this.c;
/*     */   }
/*     */   
/*     */   public Integer getD() {
/* 114 */     return (this.d == null) ? this._master.d : this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 119 */     this._master = (SplineStart)paramGeometryRow;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 124 */     throw new POIXMLException("Error: Use SplineRenderer!");
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 129 */     return "{SplineStart x=" + getX() + " y=" + getY() + " a=" + getA() + " b=" + getB() + " c=" + getC() + " d=" + getD() + "}";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\SplineStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */