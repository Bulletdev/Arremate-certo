/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
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
/*     */ public class XSLFImageRenderer
/*     */ {
/*     */   public boolean drawImage(Graphics2D paramGraphics2D, XSLFPictureData paramXSLFPictureData, Rectangle2D paramRectangle2D) {
/*  80 */     return drawImage(paramGraphics2D, paramXSLFPictureData, paramRectangle2D, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Graphics2D paramGraphics2D, XSLFPictureData paramXSLFPictureData, Rectangle2D paramRectangle2D, Insets paramInsets) {
/*     */     BufferedImage bufferedImage;
/*  90 */     boolean bool = true;
/*  91 */     if (paramInsets == null) {
/*  92 */       bool = false;
/*  93 */       paramInsets = new Insets(0, 0, 0, 0);
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/*  98 */       bufferedImage = ImageIO.read(paramXSLFPictureData.getPackagePart().getInputStream());
/*  99 */     } catch (Exception exception) {
/* 100 */       return false;
/*     */     } 
/*     */     
/* 103 */     if (bufferedImage == null) {
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     int i = bufferedImage.getWidth();
/* 108 */     int j = bufferedImage.getHeight();
/*     */     
/* 110 */     double d1 = (100000 - paramInsets.left - paramInsets.right) / 100000.0D;
/* 111 */     double d2 = (100000 - paramInsets.top - paramInsets.bottom) / 100000.0D;
/* 112 */     double d3 = paramRectangle2D.getWidth() / i * d1;
/* 113 */     double d4 = paramRectangle2D.getHeight() / j * d2;
/* 114 */     double d5 = paramRectangle2D.getX() - i * d3 * paramInsets.left / 100000.0D;
/* 115 */     double d6 = paramRectangle2D.getY() - j * d4 * paramInsets.top / 100000.0D;
/* 116 */     AffineTransform affineTransform = new AffineTransform(d3, 0.0D, 0.0D, d4, d5, d6);
/*     */     
/* 118 */     Shape shape = paramGraphics2D.getClip();
/* 119 */     if (bool) paramGraphics2D.clip(paramRectangle2D.getBounds2D()); 
/* 120 */     paramGraphics2D.drawRenderedImage(bufferedImage, affineTransform);
/* 121 */     paramGraphics2D.setClip(shape);
/*     */     
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BufferedImage readImage(PackagePart paramPackagePart) throws IOException {
/* 134 */     return ImageIO.read(paramPackagePart.getInputStream());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFImageRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */