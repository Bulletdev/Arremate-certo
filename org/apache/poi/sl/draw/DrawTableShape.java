/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.geom.Line2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.poi.sl.usermodel.GroupShape;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.StrokeStyle;
/*     */ import org.apache.poi.sl.usermodel.TableCell;
/*     */ import org.apache.poi.sl.usermodel.TableShape;
/*     */ import org.apache.poi.sl.usermodel.TextShape;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ public class DrawTableShape
/*     */   extends DrawShape
/*     */ {
/*     */   @Internal
/*     */   public static final int borderSize = 2;
/*     */   
/*     */   public DrawTableShape(TableShape<?, ?> paramTableShape) {
/*  43 */     super((Shape<?, ?>)paramTableShape);
/*     */   }
/*     */   
/*     */   protected Drawable getGroupShape(Graphics2D paramGraphics2D) {
/*  47 */     if (this.shape instanceof GroupShape) {
/*  48 */       DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/*  49 */       return drawFactory.getDrawable((GroupShape<?, ?>)this.shape);
/*     */     } 
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public void applyTransform(Graphics2D paramGraphics2D) {
/*  55 */     Drawable drawable = getGroupShape(paramGraphics2D);
/*  56 */     if (drawable != null) {
/*  57 */       drawable.applyTransform(paramGraphics2D);
/*     */     } else {
/*  59 */       super.applyTransform(paramGraphics2D);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {
/*  64 */     Drawable drawable = getGroupShape(paramGraphics2D);
/*  65 */     if (drawable != null) {
/*  66 */       drawable.draw(paramGraphics2D);
/*     */       
/*     */       return;
/*     */     } 
/*  70 */     TableShape<?, ?> tableShape = getShape();
/*  71 */     DrawPaint drawPaint = DrawFactory.getInstance(paramGraphics2D).getPaint((PlaceableShape<?, ?>)tableShape);
/*  72 */     int i = tableShape.getNumberOfRows();
/*  73 */     int j = tableShape.getNumberOfColumns();
/*     */ 
/*     */     
/*  76 */     for (byte b = 0; b < i; b++) {
/*  77 */       for (byte b1 = 0; b1 < j; b1++) {
/*  78 */         TableCell tableCell = tableShape.getCell(b, b1);
/*  79 */         if (tableCell != null && !tableCell.isMerged()) {
/*     */ 
/*     */ 
/*     */           
/*  83 */           Paint paint = drawPaint.getPaint(paramGraphics2D, tableCell.getFillStyle().getPaint());
/*  84 */           paramGraphics2D.setPaint(paint);
/*  85 */           Rectangle2D rectangle2D = tableCell.getAnchor();
/*  86 */           paramGraphics2D.fill(rectangle2D);
/*     */           
/*  88 */           for (TableCell.BorderEdge borderEdge : TableCell.BorderEdge.values()) {
/*  89 */             StrokeStyle strokeStyle = tableCell.getBorderStyle(borderEdge);
/*  90 */             if (strokeStyle != null) {
/*     */               Line2D.Double double_;
/*     */               
/*  93 */               paramGraphics2D.setStroke(getStroke(strokeStyle));
/*  94 */               Paint paint1 = drawPaint.getPaint(paramGraphics2D, strokeStyle.getPaint());
/*  95 */               paramGraphics2D.setPaint(paint1);
/*     */               
/*  97 */               double d1 = rectangle2D.getX(), d2 = rectangle2D.getY(), d3 = rectangle2D.getWidth(), d4 = rectangle2D.getHeight();
/*     */               
/*  99 */               switch (borderEdge) {
/*     */                 
/*     */                 default:
/* 102 */                   double_ = new Line2D.Double(d1 - 2.0D, d2 + d4, d1 + d3 + 2.0D, d2 + d4);
/*     */                   break;
/*     */                 case left:
/* 105 */                   double_ = new Line2D.Double(d1, d2, d1, d2 + d4 + 2.0D);
/*     */                   break;
/*     */                 case right:
/* 108 */                   double_ = new Line2D.Double(d1 + d3, d2, d1 + d3, d2 + d4 + 2.0D);
/*     */                   break;
/*     */                 case top:
/* 111 */                   double_ = new Line2D.Double(d1 - 2.0D, d2, d1 + d3 + 2.0D, d2);
/*     */                   break;
/*     */               } 
/*     */               
/* 115 */               paramGraphics2D.draw(double_);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 121 */     drawContent(paramGraphics2D);
/*     */   }
/*     */   
/*     */   public void drawContent(Graphics2D paramGraphics2D) {
/* 125 */     Drawable drawable = getGroupShape(paramGraphics2D);
/* 126 */     if (drawable != null) {
/* 127 */       drawable.drawContent(paramGraphics2D);
/*     */       
/*     */       return;
/*     */     } 
/* 131 */     TableShape<?, ?> tableShape = getShape();
/* 132 */     DrawFactory drawFactory = DrawFactory.getInstance(paramGraphics2D);
/*     */     
/* 134 */     int i = tableShape.getNumberOfRows();
/* 135 */     int j = tableShape.getNumberOfColumns();
/*     */     
/* 137 */     for (byte b = 0; b < i; b++) {
/* 138 */       for (byte b1 = 0; b1 < j; b1++) {
/* 139 */         TableCell tableCell = tableShape.getCell(b, b1);
/* 140 */         DrawTextShape drawTextShape = drawFactory.getDrawable((TextShape<?, ?>)tableCell);
/* 141 */         drawTextShape.drawContent(paramGraphics2D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected TableShape<?, ?> getShape() {
/* 148 */     return (TableShape<?, ?>)this.shape;
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
/*     */   public void setAllBorders(Object... paramVarArgs) {
/* 160 */     TableShape<?, ?> tableShape = getShape();
/* 161 */     int i = tableShape.getNumberOfRows();
/* 162 */     int j = tableShape.getNumberOfColumns();
/*     */     
/* 164 */     TableCell.BorderEdge[] arrayOfBorderEdge = { TableCell.BorderEdge.top, TableCell.BorderEdge.left, null, null };
/* 165 */     for (byte b = 0; b < i; b++) {
/* 166 */       for (byte b1 = 0; b1 < j; b1++) {
/* 167 */         arrayOfBorderEdge[2] = (b1 == j - 1) ? TableCell.BorderEdge.right : null;
/* 168 */         arrayOfBorderEdge[3] = (b == i - 1) ? TableCell.BorderEdge.bottom : null;
/* 169 */         setEdges(tableShape.getCell(b, b1), arrayOfBorderEdge, paramVarArgs);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutsideBorders(Object... paramVarArgs) {
/* 182 */     if (paramVarArgs.length == 0)
/*     */       return; 
/* 184 */     TableShape<?, ?> tableShape = getShape();
/* 185 */     int i = tableShape.getNumberOfRows();
/* 186 */     int j = tableShape.getNumberOfColumns();
/*     */     
/* 188 */     TableCell.BorderEdge[] arrayOfBorderEdge = new TableCell.BorderEdge[4];
/* 189 */     for (byte b = 0; b < i; b++) {
/* 190 */       for (byte b1 = 0; b1 < j; b1++) {
/* 191 */         arrayOfBorderEdge[0] = (b1 == 0) ? TableCell.BorderEdge.left : null;
/* 192 */         arrayOfBorderEdge[1] = (b1 == j - 1) ? TableCell.BorderEdge.right : null;
/* 193 */         arrayOfBorderEdge[2] = (b == 0) ? TableCell.BorderEdge.top : null;
/* 194 */         arrayOfBorderEdge[3] = (b == i - 1) ? TableCell.BorderEdge.bottom : null;
/* 195 */         setEdges(tableShape.getCell(b, b1), arrayOfBorderEdge, paramVarArgs);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInsideBorders(Object... paramVarArgs) {
/* 208 */     if (paramVarArgs.length == 0)
/*     */       return; 
/* 210 */     TableShape<?, ?> tableShape = getShape();
/* 211 */     int i = tableShape.getNumberOfRows();
/* 212 */     int j = tableShape.getNumberOfColumns();
/*     */     
/* 214 */     TableCell.BorderEdge[] arrayOfBorderEdge = new TableCell.BorderEdge[2];
/* 215 */     for (byte b = 0; b < i; b++) {
/* 216 */       for (byte b1 = 0; b1 < j; b1++) {
/* 217 */         arrayOfBorderEdge[0] = (b1 > 0 && b1 < j - 1) ? TableCell.BorderEdge.right : null;
/* 218 */         arrayOfBorderEdge[1] = (b > 0 && b < i - 1) ? TableCell.BorderEdge.bottom : null;
/* 219 */         setEdges(tableShape.getCell(b, b1), arrayOfBorderEdge, paramVarArgs);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void setEdges(TableCell<?, ?> paramTableCell, TableCell.BorderEdge[] paramArrayOfBorderEdge, Object... paramVarArgs) {
/* 232 */     for (TableCell.BorderEdge borderEdge : paramArrayOfBorderEdge) {
/* 233 */       if (borderEdge != null)
/* 234 */         if (paramVarArgs.length == 0) {
/* 235 */           paramTableCell.removeBorder(borderEdge);
/*     */         } else {
/* 237 */           for (Object object : paramVarArgs) {
/* 238 */             if (object instanceof Double) {
/* 239 */               paramTableCell.setBorderWidth(borderEdge, ((Double)object).doubleValue());
/* 240 */             } else if (object instanceof Color) {
/* 241 */               paramTableCell.setBorderColor(borderEdge, (Color)object);
/* 242 */             } else if (object instanceof StrokeStyle.LineDash) {
/* 243 */               paramTableCell.setBorderDash(borderEdge, (StrokeStyle.LineDash)object);
/* 244 */             } else if (object instanceof StrokeStyle.LineCompound) {
/* 245 */               paramTableCell.setBorderCompound(borderEdge, (StrokeStyle.LineCompound)object);
/*     */             } 
/*     */           } 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawTableShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */