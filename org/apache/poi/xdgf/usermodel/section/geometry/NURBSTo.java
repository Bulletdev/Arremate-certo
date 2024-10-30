/*     */ package org.apache.poi.xdgf.usermodel.section.geometry;
/*     */ 
/*     */ import com.a.a.f;
/*     */ import com.a.a.p;
/*     */ import com.a.a.r;
/*     */ import com.a.a.t;
/*     */ import com.a.b.d;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.Point2D;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.xdgf.geom.SplineRenderer;
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
/*     */ public class NURBSTo
/*     */   implements GeometryRow
/*     */ {
/*  36 */   NURBSTo _master = null;
/*     */ 
/*     */   
/*  39 */   Double x = null;
/*     */ 
/*     */   
/*  42 */   Double y = null;
/*     */ 
/*     */   
/*  45 */   Double a = null;
/*     */ 
/*     */   
/*  48 */   Double b = null;
/*     */ 
/*     */   
/*  51 */   Double c = null;
/*     */ 
/*     */   
/*  54 */   Double d = null;
/*     */ 
/*     */   
/*  57 */   String e = null;
/*     */   
/*  59 */   Boolean deleted = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NURBSTo(RowType paramRowType) {
/*  65 */     if (paramRowType.isSetDel()) {
/*  66 */       this.deleted = Boolean.valueOf(paramRowType.getDel());
/*     */     }
/*  68 */     for (CellType cellType : paramRowType.getCellArray()) {
/*  69 */       String str = cellType.getN();
/*     */       
/*  71 */       if (str.equals("X")) {
/*  72 */         this.x = XDGFCell.parseDoubleValue(cellType);
/*  73 */       } else if (str.equals("Y")) {
/*  74 */         this.y = XDGFCell.parseDoubleValue(cellType);
/*  75 */       } else if (str.equals("A")) {
/*  76 */         this.a = XDGFCell.parseDoubleValue(cellType);
/*  77 */       } else if (str.equals("B")) {
/*  78 */         this.b = XDGFCell.parseDoubleValue(cellType);
/*  79 */       } else if (str.equals("C")) {
/*  80 */         this.c = XDGFCell.parseDoubleValue(cellType);
/*  81 */       } else if (str.equals("D")) {
/*  82 */         this.d = XDGFCell.parseDoubleValue(cellType);
/*  83 */       } else if (str.equals("E")) {
/*  84 */         this.e = cellType.getV();
/*     */       } else {
/*  86 */         throw new POIXMLException("Invalid cell '" + str + "' in NURBS row");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDel() {
/*  93 */     if (this.deleted != null) {
/*  94 */       return this.deleted.booleanValue();
/*     */     }
/*  96 */     if (this._master != null) {
/*  97 */       return this._master.getDel();
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public Double getX() {
/* 103 */     return (this.x == null) ? this._master.x : this.x;
/*     */   }
/*     */   
/*     */   public Double getY() {
/* 107 */     return (this.y == null) ? this._master.y : this.y;
/*     */   }
/*     */   
/*     */   public Double getA() {
/* 111 */     return (this.a == null) ? this._master.a : this.a;
/*     */   }
/*     */   
/*     */   public Double getB() {
/* 115 */     return (this.b == null) ? this._master.b : this.b;
/*     */   }
/*     */   
/*     */   public Double getC() {
/* 119 */     return (this.c == null) ? this._master.c : this.c;
/*     */   }
/*     */   
/*     */   public Double getD() {
/* 123 */     return (this.d == null) ? this._master.d : this.d;
/*     */   }
/*     */   
/*     */   public String getE() {
/* 127 */     return (this.e == null) ? this._master.e : this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupMaster(GeometryRow paramGeometryRow) {
/* 132 */     this._master = (NURBSTo)paramGeometryRow;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 137 */     if (getDel()) {
/*     */       return;
/*     */     }
/* 140 */     Point2D point2D = paramDouble.getCurrentPoint();
/*     */ 
/*     */ 
/*     */     
/* 144 */     String str = getE().trim();
/* 145 */     if (!str.startsWith("NURBS(") || !str.endsWith(")")) {
/* 146 */       throw new POIXMLException("Invalid NURBS formula: " + str);
/*     */     }
/* 148 */     String[] arrayOfString = str.substring(6, str.length() - 1).split(",");
/*     */ 
/*     */     
/* 151 */     if (arrayOfString.length < 8) {
/* 152 */       throw new POIXMLException("Invalid NURBS formula (not enough arguments)");
/*     */     }
/*     */     
/* 155 */     if ((arrayOfString.length - 4) % 4 != 0) {
/* 156 */       throw new POIXMLException("Invalid NURBS formula -- need 4 + n*4 arguments, got " + arrayOfString.length);
/*     */     }
/*     */ 
/*     */     
/* 160 */     double d1 = getX().doubleValue();
/* 161 */     double d2 = getY().doubleValue();
/* 162 */     double d3 = getA().doubleValue();
/* 163 */     double d4 = getB().doubleValue();
/* 164 */     double d5 = getC().doubleValue();
/* 165 */     double d6 = getD().doubleValue();
/*     */     
/* 167 */     double d7 = Double.parseDouble(arrayOfString[0].trim());
/* 168 */     int i = Integer.parseInt(arrayOfString[1].trim());
/* 169 */     int j = Integer.parseInt(arrayOfString[2].trim());
/* 170 */     int k = Integer.parseInt(arrayOfString[3].trim());
/*     */     
/* 172 */     double d8 = 1.0D;
/* 173 */     double d9 = 1.0D;
/*     */     
/* 175 */     if (j == 0)
/* 176 */       d8 = paramXDGFShape.getWidth().doubleValue(); 
/* 177 */     if (k == 0) {
/* 178 */       d9 = paramXDGFShape.getHeight().doubleValue();
/*     */     }
/*     */     
/* 181 */     f f = new f();
/* 182 */     t t1 = new t();
/* 183 */     t t2 = new t();
/*     */     
/* 185 */     t1.add(d5);
/* 186 */     t2.add(d6);
/* 187 */     f.a((p)d.a(point2D.getX(), point2D.getY()));
/*     */ 
/*     */     
/* 190 */     int m = (arrayOfString.length - 4) / 4;
/* 191 */     for (byte b = 0; b < m; b++) {
/* 192 */       double d10 = Double.parseDouble(arrayOfString[4 + b * 4 + 0].trim());
/* 193 */       double d11 = Double.parseDouble(arrayOfString[4 + b * 4 + 1].trim());
/* 194 */       double d12 = Double.parseDouble(arrayOfString[4 + b * 4 + 2].trim());
/* 195 */       double d13 = Double.parseDouble(arrayOfString[4 + b * 4 + 3].trim());
/*     */       
/* 197 */       f.a((p)d.a(d10 * d8, d11 * d9));
/* 198 */       t1.add(d12);
/* 199 */       t2.add(d13);
/*     */     } 
/*     */ 
/*     */     
/* 203 */     t1.add(d3);
/* 204 */     t1.add(d7);
/*     */     
/* 206 */     t2.add(d4);
/*     */     
/* 208 */     f.a((p)d.a(d1, d2));
/*     */     
/* 210 */     r r = SplineRenderer.createNurbsSpline(f, t1, t2, i);
/*     */     
/* 212 */     paramDouble.append((Shape)r, true);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\NURBSTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */