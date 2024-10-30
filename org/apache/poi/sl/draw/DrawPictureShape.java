/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Insets;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.sl.usermodel.PictureData;
/*     */ import org.apache.poi.sl.usermodel.PictureShape;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.RectAlign;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.SimpleShape;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class DrawPictureShape
/*     */   extends DrawSimpleShape
/*     */ {
/*  35 */   private static final POILogger LOG = POILogFactory.getLogger(DrawPictureShape.class);
/*     */   private static final String WMF_IMAGE_RENDERER = "org.apache.poi.hwmf.draw.HwmfSLImageRenderer";
/*     */   
/*     */   public DrawPictureShape(PictureShape<?, ?> paramPictureShape) {
/*  39 */     super((SimpleShape<?, ?>)paramPictureShape);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawContent(Graphics2D paramGraphics2D) {
/*  44 */     PictureData pictureData = getShape().getPictureData();
/*  45 */     if (pictureData == null)
/*     */       return; 
/*  47 */     Rectangle2D rectangle2D = getAnchor(paramGraphics2D, (PlaceableShape<?, ?>)getShape());
/*  48 */     Insets insets = getShape().getClipping();
/*     */     
/*     */     try {
/*  51 */       ImageRenderer imageRenderer = getImageRenderer(paramGraphics2D, pictureData.getContentType());
/*  52 */       imageRenderer.loadImage(pictureData.getData(), pictureData.getContentType());
/*  53 */       imageRenderer.drawImage(paramGraphics2D, rectangle2D, insets);
/*  54 */     } catch (IOException iOException) {
/*  55 */       LOG.log(7, new Object[] { "image can't be loaded/rendered.", iOException });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ImageRenderer getImageRenderer(Graphics2D paramGraphics2D, String paramString) {
/*  66 */     ImageRenderer imageRenderer = (ImageRenderer)paramGraphics2D.getRenderingHint(Drawable.IMAGE_RENDERER);
/*  67 */     if (imageRenderer != null) {
/*  68 */       return imageRenderer;
/*     */     }
/*     */     
/*  71 */     if (PictureData.PictureType.WMF.contentType.equals(paramString)) {
/*     */       
/*     */       try {
/*  74 */         Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass("org.apache.poi.hwmf.draw.HwmfSLImageRenderer");
/*     */         
/*  76 */         return (ImageRenderer)clazz.newInstance();
/*  77 */       } catch (Exception exception) {
/*     */ 
/*     */         
/*  80 */         LOG.log(7, new Object[] { "WMF image renderer is not on the classpath - include poi-scratchpad jar!", exception });
/*     */       } 
/*     */     }
/*     */     
/*  84 */     return new BitmapImageRenderer();
/*     */   }
/*     */ 
/*     */   
/*     */   protected PictureShape<?, ?> getShape() {
/*  89 */     return (PictureShape<?, ?>)this.shape;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize() {
/*  99 */     PictureShape<?, ?> pictureShape = getShape();
/* 100 */     Dimension dimension = pictureShape.getPictureData().getImageDimension();
/*     */     
/* 102 */     Rectangle2D rectangle2D = pictureShape.getAnchor();
/* 103 */     double d1 = rectangle2D.getX();
/* 104 */     double d2 = rectangle2D.getY();
/* 105 */     double d3 = dimension.getWidth();
/* 106 */     double d4 = dimension.getHeight();
/* 107 */     pictureShape.setAnchor(new Rectangle2D.Double(d1, d2, d3, d4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize(Rectangle2D paramRectangle2D) {
/* 118 */     resize(paramRectangle2D, RectAlign.CENTER);
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
/*     */   public void resize(Rectangle2D paramRectangle2D, RectAlign paramRectAlign) {
/* 133 */     PictureShape<?, ?> pictureShape = getShape();
/* 134 */     Dimension dimension = pictureShape.getPictureData().getImageDimension();
/* 135 */     if (dimension.width <= 0 || dimension.height <= 0) {
/*     */       
/* 137 */       pictureShape.setAnchor(paramRectangle2D);
/*     */       
/*     */       return;
/*     */     } 
/* 141 */     double d1 = paramRectangle2D.getWidth();
/* 142 */     double d2 = paramRectangle2D.getHeight();
/*     */ 
/*     */     
/* 145 */     double d3 = d1 / dimension.width;
/* 146 */     double d4 = d2 / dimension.height;
/*     */ 
/*     */     
/* 149 */     double d5 = 0.0D, d6 = 0.0D;
/*     */     
/* 151 */     if (d3 > d4) {
/*     */       
/* 153 */       d1 = d4 * dimension.width;
/* 154 */       d5 = paramRectangle2D.getWidth() - d1;
/* 155 */     } else if (d4 > d3) {
/*     */       
/* 157 */       d2 = d3 * dimension.height;
/* 158 */       d6 = paramRectangle2D.getHeight() - d2;
/*     */     } else {
/*     */       
/* 161 */       pictureShape.setAnchor(paramRectangle2D);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 166 */     double d7 = paramRectangle2D.getX();
/* 167 */     double d8 = paramRectangle2D.getY();
/* 168 */     switch (paramRectAlign) {
/*     */       case TOP:
/* 170 */         d7 += d5 / 2.0D;
/*     */         break;
/*     */       case TOP_RIGHT:
/* 173 */         d7 += d5;
/*     */         break;
/*     */       case RIGHT:
/* 176 */         d7 += d5;
/* 177 */         d8 += d6 / 2.0D;
/*     */         break;
/*     */       case BOTTOM_RIGHT:
/* 180 */         d7 += d5;
/* 181 */         d8 += d6;
/*     */         break;
/*     */       case BOTTOM:
/* 184 */         d7 += d5 / 2.0D;
/* 185 */         d8 += d6;
/*     */         break;
/*     */       case BOTTOM_LEFT:
/* 188 */         d8 += d6;
/*     */         break;
/*     */       case LEFT:
/* 191 */         d8 += d6 / 2.0D;
/*     */         break;
/*     */       
/*     */       case TOP_LEFT:
/*     */         break;
/*     */       default:
/* 197 */         d7 += d5 / 2.0D;
/* 198 */         d8 += d6 / 2.0D;
/*     */         break;
/*     */     } 
/*     */     
/* 202 */     pictureShape.setAnchor(new Rectangle2D.Double(d7, d8, d1, d2));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawPictureShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */