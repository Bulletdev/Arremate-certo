/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.AffineTransformOp;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.RescaleOp;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Iterator;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReadParam;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.ImageTypeSpecifier;
/*     */ import javax.imageio.stream.MemoryCacheImageInputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BitmapImageRenderer
/*     */   implements ImageRenderer
/*     */ {
/*  49 */   private static final POILogger LOG = POILogFactory.getLogger(ImageRenderer.class);
/*     */   
/*     */   protected BufferedImage img;
/*     */ 
/*     */   
/*     */   public void loadImage(InputStream paramInputStream, String paramString) throws IOException {
/*  55 */     this.img = readImage(paramInputStream, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadImage(byte[] paramArrayOfbyte, String paramString) throws IOException {
/*  60 */     this.img = readImage(new ByteArrayInputStream(paramArrayOfbyte), paramString);
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
/*     */   private static BufferedImage readImage(InputStream paramInputStream, String paramString) throws IOException {
/*  73 */     IOException iOException = null;
/*  74 */     BufferedImage bufferedImage = null;
/*     */ 
/*     */     
/*  77 */     MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(paramInputStream);
/*     */     try {
/*  79 */       memoryCacheImageInputStream = new MemoryCacheImageInputStream(paramInputStream);
/*  80 */       memoryCacheImageInputStream.mark();
/*     */       
/*  82 */       Iterator<ImageReader> iterator = ImageIO.getImageReaders(memoryCacheImageInputStream);
/*  83 */       while (bufferedImage == null && iterator.hasNext()) {
/*  84 */         ImageReader imageReader = iterator.next();
/*  85 */         ImageReadParam imageReadParam = imageReader.getDefaultReadParam();
/*     */         
/*  87 */         for (byte b = 0; bufferedImage == null && b < 2; b++) {
/*  88 */           memoryCacheImageInputStream.reset();
/*  89 */           memoryCacheImageInputStream.mark();
/*     */           
/*  91 */           if (b == 1) {
/*     */ 
/*     */             
/*  94 */             Iterator<ImageTypeSpecifier> iterator1 = imageReader.getImageTypes(0);
/*  95 */             while (iterator1.hasNext()) {
/*  96 */               ImageTypeSpecifier imageTypeSpecifier = iterator1.next();
/*  97 */               int i = imageTypeSpecifier.getBufferedImageType();
/*  98 */               if (i == 10) {
/*  99 */                 imageReadParam.setDestinationType(imageTypeSpecifier);
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           try {
/* 106 */             imageReader.setInput(memoryCacheImageInputStream, false, true);
/* 107 */             bufferedImage = imageReader.read(0, imageReadParam);
/* 108 */           } catch (IOException iOException1) {
/* 109 */             iOException = iOException1;
/* 110 */           } catch (RuntimeException runtimeException) {
/* 111 */             iOException = new IOException("ImageIO runtime exception - " + ((b == 0) ? "normal" : "fallback"), runtimeException);
/*     */           } 
/*     */         } 
/* 114 */         imageReader.dispose();
/*     */       } 
/*     */     } finally {
/* 117 */       memoryCacheImageInputStream.close();
/*     */     } 
/*     */ 
/*     */     
/* 121 */     if (bufferedImage == null) {
/* 122 */       if (iOException != null)
/*     */       {
/*     */         
/* 125 */         throw iOException;
/*     */       }
/* 127 */       LOG.log(5, new Object[] { "Content-type: " + paramString + " is not support. Image ignored." });
/* 128 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 132 */     if (bufferedImage.getType() != 2) {
/* 133 */       BufferedImage bufferedImage1 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
/* 134 */       Graphics graphics = bufferedImage1.getGraphics();
/* 135 */       graphics.drawImage(bufferedImage, 0, 0, null);
/* 136 */       graphics.dispose();
/* 137 */       return bufferedImage1;
/*     */     } 
/*     */     
/* 140 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */   
/*     */   public BufferedImage getImage() {
/* 145 */     return this.img;
/*     */   }
/*     */ 
/*     */   
/*     */   public BufferedImage getImage(Dimension paramDimension) {
/* 150 */     double d1 = this.img.getWidth();
/* 151 */     double d2 = this.img.getHeight();
/* 152 */     BufferedImage bufferedImage = new BufferedImage((int)d1, (int)d2, 2);
/* 153 */     double d3 = paramDimension.getWidth();
/* 154 */     double d4 = paramDimension.getHeight();
/* 155 */     AffineTransform affineTransform = new AffineTransform();
/* 156 */     affineTransform.scale(d3 / d1, d4 / d2);
/* 157 */     AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, 2);
/* 158 */     affineTransformOp.filter(this.img, bufferedImage);
/* 159 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getDimension() {
/* 164 */     return (this.img == null) ? new Dimension(0, 0) : new Dimension(this.img.getWidth(), this.img.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlpha(double paramDouble) {
/* 171 */     if (this.img == null)
/*     */       return; 
/* 173 */     Dimension dimension = getDimension();
/* 174 */     BufferedImage bufferedImage = new BufferedImage((int)dimension.getWidth(), (int)dimension.getHeight(), 2);
/* 175 */     Graphics2D graphics2D = bufferedImage.createGraphics();
/* 176 */     RescaleOp rescaleOp = new RescaleOp(new float[] { 1.0F, 1.0F, 1.0F, (float)paramDouble }, new float[] { 0.0F, 0.0F, 0.0F, 0.0F }, null);
/* 177 */     graphics2D.drawImage(this.img, rescaleOp, 0, 0);
/* 178 */     graphics2D.dispose();
/*     */     
/* 180 */     this.img = bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D) {
/* 188 */     return drawImage(paramGraphics2D, paramRectangle2D, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drawImage(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D, Insets paramInsets) {
/* 196 */     if (this.img == null) return false;
/*     */     
/* 198 */     boolean bool = true;
/* 199 */     if (paramInsets == null) {
/* 200 */       bool = false;
/* 201 */       paramInsets = new Insets(0, 0, 0, 0);
/*     */     } 
/*     */     
/* 204 */     int i = this.img.getWidth();
/* 205 */     int j = this.img.getHeight();
/*     */ 
/*     */     
/* 208 */     double d1 = (100000 - paramInsets.left - paramInsets.right) / 100000.0D;
/* 209 */     double d2 = (100000 - paramInsets.top - paramInsets.bottom) / 100000.0D;
/* 210 */     double d3 = paramRectangle2D.getWidth() / i * d1;
/* 211 */     double d4 = paramRectangle2D.getHeight() / j * d2;
/* 212 */     double d5 = paramRectangle2D.getX() - i * d3 * paramInsets.left / 100000.0D;
/* 213 */     double d6 = paramRectangle2D.getY() - j * d4 * paramInsets.top / 100000.0D;
/*     */     
/* 215 */     AffineTransform affineTransform = new AffineTransform(d3, 0.0D, 0.0D, d4, d5, d6);
/*     */     
/* 217 */     Shape shape = paramGraphics2D.getClip();
/* 218 */     if (bool) paramGraphics2D.clip(paramRectangle2D.getBounds2D()); 
/* 219 */     paramGraphics2D.drawRenderedImage(this.img, affineTransform);
/* 220 */     paramGraphics2D.setClip(shape);
/*     */     
/* 222 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\BitmapImageRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */