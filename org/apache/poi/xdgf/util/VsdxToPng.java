/*     */ package org.apache.poi.xdgf.util;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.apache.poi.xdgf.geom.Dimension2dDouble;
/*     */ import org.apache.poi.xdgf.usermodel.XDGFPage;
/*     */ import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
/*     */ import org.apache.poi.xdgf.usermodel.shape.ShapeDebuggerRenderer;
/*     */ import org.apache.poi.xdgf.usermodel.shape.ShapeRenderer;
/*     */ import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
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
/*     */ public class VsdxToPng
/*     */ {
/*     */   public static void renderToPng(XDGFPage paramXDGFPage, String paramString, double paramDouble, ShapeRenderer paramShapeRenderer) throws IOException {
/*  47 */     renderToPng(paramXDGFPage, new File(paramString), paramDouble, paramShapeRenderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderToPngDir(XDGFPage paramXDGFPage, File paramFile, double paramDouble, ShapeRenderer paramShapeRenderer) throws IOException {
/*  53 */     File file = new File(paramFile, "page" + paramXDGFPage.getPageNumber() + "-" + Util.sanitizeFilename(paramXDGFPage.getName()) + ".png");
/*     */     
/*  55 */     System.out.println("** Writing image to " + file);
/*     */     
/*  57 */     renderToPng(paramXDGFPage, file, paramDouble, paramShapeRenderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderToPng(XDGFPage paramXDGFPage, File paramFile, double paramDouble, ShapeRenderer paramShapeRenderer) throws IOException {
/*  64 */     Dimension2dDouble dimension2dDouble = paramXDGFPage.getPageSize();
/*     */     
/*  66 */     int i = (int)(paramDouble * dimension2dDouble.getWidth());
/*  67 */     int j = (int)(paramDouble * dimension2dDouble.getHeight());
/*     */     
/*  69 */     BufferedImage bufferedImage = new BufferedImage(i, j, 1);
/*     */     
/*  71 */     Graphics2D graphics2D = bufferedImage.createGraphics();
/*     */ 
/*     */     
/*  74 */     graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */     
/*  76 */     graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*     */     
/*  78 */     graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
/*     */     
/*  80 */     graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
/*     */ 
/*     */     
/*  83 */     graphics2D.setColor(Color.black);
/*  84 */     graphics2D.setBackground(Color.white);
/*  85 */     graphics2D.clearRect(0, 0, i, j);
/*     */ 
/*     */     
/*  88 */     graphics2D.translate(0, bufferedImage.getHeight());
/*  89 */     graphics2D.scale(paramDouble, -paramDouble);
/*     */ 
/*     */     
/*  92 */     paramShapeRenderer.setGraphics(graphics2D);
/*  93 */     paramXDGFPage.getContent().visitShapes((ShapeVisitor)paramShapeRenderer);
/*     */     
/*  95 */     graphics2D.dispose();
/*     */     
/*  97 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/*  98 */     ImageIO.write(bufferedImage, "png", fileOutputStream);
/*  99 */     fileOutputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderToPng(XmlVisioDocument paramXmlVisioDocument, String paramString, double paramDouble, ShapeRenderer paramShapeRenderer) throws IOException {
/* 106 */     File file = new File(paramString);
/*     */     
/* 108 */     for (XDGFPage xDGFPage : paramXmlVisioDocument.getPages())
/* 109 */       renderToPngDir(xDGFPage, file, paramDouble, paramShapeRenderer); 
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*     */     ShapeDebuggerRenderer shapeDebuggerRenderer;
/* 114 */     if (paramArrayOfString.length > 2) {
/* 115 */       System.err.println("Usage: [--debug] in.vsdx outdir");
/* 116 */       System.exit(1);
/*     */     } 
/*     */     
/* 119 */     ShapeRenderer shapeRenderer = new ShapeRenderer();
/*     */     
/* 121 */     String str1 = paramArrayOfString[0];
/* 122 */     String str2 = paramArrayOfString[1];
/*     */     
/* 124 */     if (paramArrayOfString[0].equals("--debug")) {
/* 125 */       str1 = paramArrayOfString[1];
/* 126 */       str2 = paramArrayOfString[2];
/* 127 */       shapeDebuggerRenderer = new ShapeDebuggerRenderer();
/*     */     } 
/*     */     
/* 130 */     XmlVisioDocument xmlVisioDocument = new XmlVisioDocument(new FileInputStream(str1));
/*     */     
/* 132 */     renderToPng(xmlVisioDocument, str2, 181.8181818181818D, (ShapeRenderer)shapeDebuggerRenderer);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\util\VsdxToPng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */