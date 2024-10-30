/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Iterator;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.stream.ImageInputStream;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.Picture;
/*     */ import org.apache.poi.ss.usermodel.PictureData;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ public class ImageUtils
/*     */ {
/*  49 */   private static final POILogger logger = POILogFactory.getLogger(ImageUtils.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int PIXEL_DPI = 96;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Dimension getImageDimension(InputStream paramInputStream, int paramInt) {
/*  63 */     Dimension dimension = new Dimension();
/*     */     
/*  65 */     switch (paramInt)
/*     */     
/*     */     { case 5:
/*     */       case 6:
/*     */       case 7:
/*     */         
/*     */         try {
/*     */           
/*  73 */           ImageInputStream imageInputStream = ImageIO.createImageInputStream(paramInputStream);
/*     */           try {
/*  75 */             Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
/*  76 */             ImageReader imageReader = iterator.next();
/*     */             try {
/*  78 */               imageReader.setInput(imageInputStream);
/*  79 */               BufferedImage bufferedImage = imageReader.read(0);
/*     */               
/*  81 */               int[] arrayOfInt = getResolution(imageReader);
/*     */ 
/*     */ 
/*     */               
/*  85 */               if (arrayOfInt[0] == 0) arrayOfInt[0] = 96; 
/*  86 */               if (arrayOfInt[1] == 0) arrayOfInt[1] = 96;
/*     */               
/*  88 */               dimension.width = bufferedImage.getWidth() * 96 / arrayOfInt[0];
/*  89 */               dimension.height = bufferedImage.getHeight() * 96 / arrayOfInt[1];
/*     */             } finally {
/*  91 */               imageReader.dispose();
/*     */             } 
/*     */           } finally {
/*  94 */             imageInputStream.close();
/*     */           }
/*     */         
/*  97 */         } catch (IOException iOException) {
/*     */           
/*  99 */           logger.log(5, new Object[] { iOException });
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 106 */         return dimension; }  logger.log(5, new Object[] { "Only JPEG, PNG and DIB pictures can be automatically sized" }); return dimension;
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
/*     */   public static int[] getResolution(ImageReader paramImageReader) throws IOException {
/* 118 */     int i = 96, j = 96;
/* 119 */     double d = 25.4D;
/*     */ 
/*     */     
/* 122 */     Element element = (Element)paramImageReader.getImageMetadata(0).getAsTree("javax_imageio_1.0");
/* 123 */     NodeList nodeList = element.getElementsByTagName("HorizontalPixelSize");
/* 124 */     if (nodeList != null && nodeList.getLength() == 1) i = (int)(d / Float.parseFloat(((Element)nodeList.item(0)).getAttribute("value")));
/*     */     
/* 126 */     nodeList = element.getElementsByTagName("VerticalPixelSize");
/* 127 */     if (nodeList != null && nodeList.getLength() == 1) j = (int)(d / Float.parseFloat(((Element)nodeList.item(0)).getAttribute("value")));
/*     */     
/* 129 */     return new int[] { i, j };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Dimension setPreferredSize(Picture paramPicture, double paramDouble1, double paramDouble2) {
/* 140 */     ClientAnchor clientAnchor = paramPicture.getClientAnchor();
/* 141 */     boolean bool = clientAnchor instanceof org.apache.poi.hssf.usermodel.HSSFClientAnchor;
/* 142 */     PictureData pictureData = paramPicture.getPictureData();
/* 143 */     Sheet sheet = paramPicture.getSheet();
/*     */ 
/*     */     
/* 146 */     Dimension dimension1 = getImageDimension(new ByteArrayInputStream(pictureData.getData()), pictureData.getPictureType());
/*     */     
/* 148 */     Dimension dimension2 = getDimensionFromAnchor(paramPicture);
/* 149 */     double d1 = (paramDouble1 == Double.MAX_VALUE) ? dimension1.getWidth() : (dimension2.getWidth() / 9525.0D * paramDouble1);
/*     */     
/* 151 */     double d2 = (paramDouble2 == Double.MAX_VALUE) ? dimension1.getHeight() : (dimension2.getHeight() / 9525.0D * paramDouble2);
/*     */ 
/*     */     
/* 154 */     double d3 = 0.0D;
/* 155 */     short s = clientAnchor.getCol1();
/* 156 */     int i = 0;
/*     */ 
/*     */     
/* 159 */     d3 = sheet.getColumnWidthInPixels(s++);
/* 160 */     if (bool) {
/* 161 */       d3 *= 1.0D - clientAnchor.getDx1() / 1024.0D;
/*     */     } else {
/* 163 */       d3 -= clientAnchor.getDx1() / 9525.0D;
/*     */     } 
/*     */     
/* 166 */     while (d3 < d1) {
/* 167 */       d3 += sheet.getColumnWidthInPixels(s++);
/*     */     }
/*     */     
/* 170 */     if (d3 > d1) {
/*     */       
/* 172 */       double d5 = sheet.getColumnWidthInPixels(--s);
/* 173 */       double d6 = d3 - d1;
/* 174 */       if (bool) {
/* 175 */         i = (int)((d5 - d6) / d5 * 1024.0D);
/*     */       } else {
/* 177 */         i = (int)((d5 - d6) * 9525.0D);
/*     */       } 
/* 179 */       if (i < 0) i = 0; 
/*     */     } 
/* 181 */     clientAnchor.setCol2(s);
/* 182 */     clientAnchor.setDx2(i);
/*     */     
/* 184 */     double d4 = 0.0D;
/* 185 */     int j = clientAnchor.getRow1();
/* 186 */     int k = 0;
/*     */     
/* 188 */     d4 = getRowHeightInPixels(sheet, j++);
/* 189 */     if (bool) {
/* 190 */       d4 *= 1.0D - clientAnchor.getDy1() / 256.0D;
/*     */     } else {
/* 192 */       d4 -= clientAnchor.getDy1() / 9525.0D;
/*     */     } 
/*     */     
/* 195 */     while (d4 < d2) {
/* 196 */       d4 += getRowHeightInPixels(sheet, j++);
/*     */     }
/*     */     
/* 199 */     if (d4 > d2) {
/* 200 */       double d5 = getRowHeightInPixels(sheet, --j);
/* 201 */       double d6 = d4 - d2;
/* 202 */       if (bool) {
/* 203 */         k = (int)((d5 - d6) / d5 * 256.0D);
/*     */       } else {
/* 205 */         k = (int)((d5 - d6) * 9525.0D);
/*     */       } 
/* 207 */       if (k < 0) k = 0;
/*     */     
/*     */     } 
/* 210 */     clientAnchor.setRow2(j);
/* 211 */     clientAnchor.setDy2(k);
/*     */     
/* 213 */     return new Dimension((int)Math.round(d1 * 9525.0D), (int)Math.round(d2 * 9525.0D));
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
/*     */   public static Dimension getDimensionFromAnchor(Picture paramPicture) {
/* 228 */     ClientAnchor clientAnchor = paramPicture.getClientAnchor();
/* 229 */     boolean bool = clientAnchor instanceof org.apache.poi.hssf.usermodel.HSSFClientAnchor;
/* 230 */     Sheet sheet = paramPicture.getSheet();
/*     */     
/* 232 */     double d1 = 0.0D;
/* 233 */     short s = clientAnchor.getCol1();
/*     */ 
/*     */     
/* 236 */     d1 = sheet.getColumnWidthInPixels(s++);
/* 237 */     if (bool) {
/* 238 */       d1 *= 1.0D - clientAnchor.getDx1() / 1024.0D;
/*     */     } else {
/* 240 */       d1 -= clientAnchor.getDx1() / 9525.0D;
/*     */     } 
/*     */     
/* 243 */     while (s < clientAnchor.getCol2()) {
/* 244 */       d1 += sheet.getColumnWidthInPixels(s++);
/*     */     }
/*     */     
/* 247 */     if (bool) {
/* 248 */       d1 += (sheet.getColumnWidthInPixels(s) * clientAnchor.getDx2()) / 1024.0D;
/*     */     } else {
/* 250 */       d1 += clientAnchor.getDx2() / 9525.0D;
/*     */     } 
/*     */     
/* 253 */     double d2 = 0.0D;
/* 254 */     int i = clientAnchor.getRow1();
/*     */     
/* 256 */     d2 = getRowHeightInPixels(sheet, i++);
/* 257 */     if (bool) {
/* 258 */       d2 *= 1.0D - clientAnchor.getDy1() / 256.0D;
/*     */     } else {
/* 260 */       d2 -= clientAnchor.getDy1() / 9525.0D;
/*     */     } 
/*     */     
/* 263 */     while (i < clientAnchor.getRow2()) {
/* 264 */       d2 += getRowHeightInPixels(sheet, i++);
/*     */     }
/*     */     
/* 267 */     if (bool) {
/* 268 */       d2 += getRowHeightInPixels(sheet, i) * clientAnchor.getDy2() / 256.0D;
/*     */     } else {
/* 270 */       d2 += clientAnchor.getDy2() / 9525.0D;
/*     */     } 
/*     */     
/* 273 */     d1 *= 9525.0D;
/* 274 */     d2 *= 9525.0D;
/*     */     
/* 276 */     return new Dimension((int)Math.rint(d1), (int)Math.rint(d2));
/*     */   }
/*     */ 
/*     */   
/*     */   private static double getRowHeightInPixels(Sheet paramSheet, int paramInt) {
/* 281 */     Row row = paramSheet.getRow(paramInt);
/* 282 */     double d = (row == null) ? paramSheet.getDefaultRowHeightInPoints() : row.getHeightInPoints();
/* 283 */     return Units.toEMU(d) / 9525.0D;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */