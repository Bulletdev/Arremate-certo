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
/*     */ public class EllipticalArcTo
/*     */   implements GeometryRow
/*     */ {
/*  33 */   EllipticalArcTo _master = null;
/*     */ 
/*     */   
/*  36 */   Double x = null;
/*     */ 
/*     */   
/*  39 */   Double y = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   Double a = null;
/*     */ 
/*     */   
/*  49 */   Double b = null;
/*     */ 
/*     */ 
/*     */   
/*  53 */   Double c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   Double d = null;
/*     */   
/*  62 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EllipticalArcTo(RowType paramRowType) {
/*  68 */     if (paramRowType.isSetDel()) {
/*  69 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  71 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  72 */       String str = cellType.getN();
/*     */       
/*  74 */       if (str.equals("X")) {
/*  75 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  76 */       } else if (str.equals("Y")) {
/*  77 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  78 */       } else if (str.equals("A")) {
/*  79 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*  80 */       } else if (str.equals("B")) {
/*  81 */         this.b = XDGFCell.parseDoubleValue(cellType);
/*  82 */       } else if (str.equals("C")) {
/*  83 */         this.c = XDGFCell.parseDoubleValue(cellType);
/*  84 */       } else if (str.equals("D")) {
/*  85 */         this.d = XDGFCell.parseDoubleValue(cellType);
/*     */       } else {
/*  87 */         throw new POIXMLException("Invalid cell '" + str + "' in EllipticalArcTo row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  94 */     if (this.deleted != null) {
/*  95 */       return this.deleted.booleanValue();
/*     */     }
/*  97 */     if (this._master != null) {
/*  98 */       return this._master.getDel();
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/* 104 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/* 108 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/* 112 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 116 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */   
/*     */   public Double getC() {
/* 120 */     return (this.c == null) ? this._master.c : this.c;
/*     */   }
/*     */   
/*     */   public Double getD() {
/* 124 */     return (this.d == null) ? this._master.d : this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 129 */     this._master = (EllipticalArcTo)paramGeometryRow;
/*     */   }
/*     */   
/* 132 */   public static int draw = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 137 */     if (getDel()) {
/*     */       return;
/*     */     }
/*     */     
/* 141 */     double d1 = getX().doubleValue();
/* 142 */     double d2 = getY().doubleValue();
/* 143 */     double d3 = getA().doubleValue();
/* 144 */     double d4 = getB().doubleValue();
/* 145 */     double d5 = getC().doubleValue();
/* 146 */     double d6 = getD().doubleValue();
/*     */     
/* 148 */     createEllipticalArc(d1, d2, d3, d4, d5, d6, paramDouble);
/*     */   }
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
/*     */   public static void createEllipticalArc(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, Path2D.Double paramDouble) {
/* 166 */     Point2D point2D = paramDouble.getCurrentPoint();
/* 167 */     double d1 = point2D.getX();
/* 168 */     double d2 = point2D.getY();
/*     */ 
/*     */     
/* 171 */     AffineTransform affineTransform = AffineTransform.getRotateInstance(-paramDouble5);
/* 172 */     double[] arrayOfDouble = { d1, d2, paramDouble1, paramDouble2, paramDouble3, paramDouble4 };
/* 173 */     affineTransform.transform(arrayOfDouble, 0, arrayOfDouble, 0, 3);
/*     */     
/* 175 */     d1 = arrayOfDouble[0];
/* 176 */     d2 = arrayOfDouble[1];
/* 177 */     paramDouble1 = arrayOfDouble[2];
/* 178 */     paramDouble2 = arrayOfDouble[3];
/* 179 */     paramDouble3 = arrayOfDouble[4];
/* 180 */     paramDouble4 = arrayOfDouble[5];
/*     */ 
/*     */ 
/*     */     
/* 184 */     double d3 = paramDouble6 * paramDouble6;
/* 185 */     double d4 = ((d1 - paramDouble1) * (d1 + paramDouble1) * (paramDouble2 - paramDouble4) - (paramDouble1 - paramDouble3) * (paramDouble1 + paramDouble3) * (d2 - paramDouble2) + d3 * (d2 - paramDouble2) * (paramDouble2 - paramDouble4) * (d2 - paramDouble4)) / 2.0D * ((d1 - paramDouble1) * (paramDouble2 - paramDouble4) - (paramDouble1 - paramDouble3) * (d2 - paramDouble2));
/*     */ 
/*     */     
/* 188 */     double d5 = ((d1 - paramDouble1) * (paramDouble1 - paramDouble3) * (d1 - paramDouble3) / d3 + (paramDouble1 - paramDouble3) * (d2 - paramDouble2) * (d2 + paramDouble2) - (d1 - paramDouble1) * (paramDouble2 - paramDouble4) * (paramDouble2 + paramDouble4)) / 2.0D * ((paramDouble1 - paramDouble3) * (d2 - paramDouble2) - (d1 - paramDouble1) * (paramDouble2 - paramDouble4));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     double d6 = Math.sqrt(Math.pow(d1 - d4, 2.0D) + Math.pow(d2 - d5, 2.0D) * d3);
/* 194 */     double d7 = d6 / paramDouble6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     double d8 = Math.toDegrees(Math.atan2((paramDouble4 - d5) / d7, (paramDouble3 - d4) / d6));
/*     */     
/* 204 */     double d9 = Math.toDegrees(Math.atan2((d2 - d5) / d7, (d1 - d4) / d6));
/*     */     
/* 206 */     double d10 = Math.toDegrees(Math.atan2((paramDouble2 - d5) / d7, (paramDouble1 - d4) / d6));
/*     */ 
/*     */     
/* 209 */     double d11 = computeSweep(d9, d10, d8);
/*     */ 
/*     */     
/* 212 */     Arc2D.Double double_ = new Arc2D.Double(d4 - d6, d5 - d7, d6 * 2.0D, d7 * 2.0D, -d9, d11, 0);
/*     */ 
/*     */ 
/*     */     
/* 216 */     affineTransform.setToRotation(paramDouble5);
/* 217 */     paramDouble.append(affineTransform.createTransformedShape(double_), false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static double computeSweep(double paramDouble1, double paramDouble2, double paramDouble3) {
/*     */     double d;
/* 224 */     paramDouble1 = (360.0D + paramDouble1) % 360.0D;
/* 225 */     paramDouble2 = (360.0D + paramDouble2) % 360.0D;
/* 226 */     paramDouble3 = (360.0D + paramDouble3) % 360.0D;
/*     */ 
/*     */ 
/*     */     
/* 230 */     if (paramDouble1 < paramDouble2) {
/* 231 */       if (paramDouble1 < paramDouble3 && paramDouble3 < paramDouble2) {
/* 232 */         d = paramDouble1 - paramDouble2;
/*     */       } else {
/* 234 */         d = 360.0D + paramDouble1 - paramDouble2;
/*     */       }
/*     */     
/* 237 */     } else if (paramDouble2 < paramDouble3 && paramDouble3 < paramDouble1) {
/* 238 */       d = paramDouble1 - paramDouble2;
/*     */     } else {
/* 240 */       d = -(360.0D - paramDouble1 - paramDouble2);
/*     */     } 
/*     */ 
/*     */     
/* 244 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\EllipticalArcTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */