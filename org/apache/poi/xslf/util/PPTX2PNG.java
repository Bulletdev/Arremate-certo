/*     */ package org.apache.poi.xslf.util;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.apache.poi.sl.draw.DrawFactory;
/*     */ import org.apache.poi.sl.usermodel.Slide;
/*     */ import org.apache.poi.sl.usermodel.SlideShow;
/*     */ import org.apache.poi.sl.usermodel.SlideShowFactory;
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
/*     */ public class PPTX2PNG
/*     */ {
/*     */   static void usage(String paramString) {
/*  47 */     String str = "Usage: PPTX2PNG [options] <ppt or pptx file>\n" + ((paramString == null) ? "" : ("Error: " + paramString + "\n")) + "Options:\n" + "    -scale <float>   scale factor\n" + "    -slide <integer> 1-based index of a slide to render\n" + "    -format <type>   png,gif,jpg (,null for testing)" + "    -outdir <dir>    output directory, defaults to origin of the ppt/pptx file" + "    -quiet           do not write to console (for normal processing)";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     System.out.println(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  62 */     if (paramArrayOfString.length == 0) {
/*  63 */       usage(null);
/*     */       
/*     */       return;
/*     */     } 
/*  67 */     String str1 = "-1";
/*  68 */     float f = 1.0F;
/*  69 */     File file1 = null;
/*  70 */     String str2 = "png";
/*  71 */     File file2 = null;
/*  72 */     boolean bool = false;
/*     */     
/*  74 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  75 */       if (paramArrayOfString[b].startsWith("-")) {
/*  76 */         if ("-scale".equals(paramArrayOfString[b])) {
/*  77 */           f = Float.parseFloat(paramArrayOfString[++b]);
/*  78 */         } else if ("-slide".equals(paramArrayOfString[b])) {
/*  79 */           str1 = paramArrayOfString[++b];
/*  80 */         } else if ("-format".equals(paramArrayOfString[b])) {
/*  81 */           str2 = paramArrayOfString[++b];
/*  82 */         } else if ("-outdir".equals(paramArrayOfString[b])) {
/*  83 */           file2 = new File(paramArrayOfString[++b]);
/*  84 */         } else if ("-quiet".equals(paramArrayOfString[b])) {
/*  85 */           bool = true;
/*     */         } 
/*     */       } else {
/*  88 */         file1 = new File(paramArrayOfString[b]);
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     if (file1 == null || !file1.exists()) {
/*  93 */       usage("File not specified or it doesn't exist");
/*     */       
/*     */       return;
/*     */     } 
/*  97 */     if (str2 == null || !str2.matches("^(png|gif|jpg|null)$")) {
/*  98 */       usage("Invalid format given");
/*     */       
/*     */       return;
/*     */     } 
/* 102 */     if (file2 == null) {
/* 103 */       file2 = file1.getParentFile();
/*     */     }
/*     */     
/* 106 */     if (!"null".equals(str2) && (file2 == null || !file2.exists() || !file2.isDirectory())) {
/* 107 */       usage("Output directory doesn't exist");
/*     */       
/*     */       return;
/*     */     } 
/* 111 */     if (f < 0.0F) {
/* 112 */       usage("Invalid scale given");
/*     */       
/*     */       return;
/*     */     } 
/* 116 */     if (!bool) {
/* 117 */       System.out.println("Processing " + file1);
/*     */     }
/* 119 */     SlideShow slideShow = SlideShowFactory.create(file1, null, true);
/*     */     try {
/* 121 */       List<Slide> list = slideShow.getSlides();
/*     */       
/* 123 */       Set<Integer> set = slideIndexes(list.size(), str1);
/*     */       
/* 125 */       if (set.isEmpty()) {
/* 126 */         usage("slidenum must be either -1 (for all) or within range: [1.." + list.size() + "] for " + file1);
/*     */         
/*     */         return;
/*     */       } 
/* 130 */       Dimension dimension = slideShow.getPageSize();
/* 131 */       int i = (int)(dimension.width * f);
/* 132 */       int j = (int)(dimension.height * f);
/*     */       
/* 134 */       for (Integer integer : set) {
/* 135 */         Slide slide = list.get(integer.intValue());
/* 136 */         String str = slide.getTitle();
/* 137 */         if (!bool) {
/* 138 */           System.out.println("Rendering slide " + integer + ((str == null) ? "" : (": " + str)));
/*     */         }
/*     */         
/* 141 */         BufferedImage bufferedImage = new BufferedImage(i, j, 2);
/* 142 */         Graphics2D graphics2D = bufferedImage.createGraphics();
/* 143 */         DrawFactory.getInstance(graphics2D).fixFonts(graphics2D);
/*     */ 
/*     */         
/* 146 */         graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 147 */         graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/* 148 */         graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
/* 149 */         graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
/*     */         
/* 151 */         graphics2D.scale(f, f);
/*     */ 
/*     */         
/* 154 */         slide.draw(graphics2D);
/*     */ 
/*     */         
/* 157 */         if (!"null".equals(str2)) {
/* 158 */           String str3 = file1.getName().replaceFirst(".pptx?", "");
/* 159 */           str3 = String.format(Locale.ROOT, "%1$s-%2$04d.%3$s", new Object[] { str3, integer, str2 });
/* 160 */           File file = new File(file2, str3);
/* 161 */           ImageIO.write(bufferedImage, str2, file);
/*     */         } 
/*     */         
/* 164 */         graphics2D.dispose();
/* 165 */         bufferedImage.flush();
/*     */       } 
/*     */     } finally {
/* 168 */       slideShow.close();
/*     */     } 
/*     */     
/* 171 */     if (!bool) {
/* 172 */       System.out.println("Done");
/*     */     }
/*     */   }
/*     */   
/*     */   private static Set<Integer> slideIndexes(int paramInt, String paramString) {
/* 177 */     TreeSet<Integer> treeSet = new TreeSet();
/* 178 */     if ("-1".equals(paramString)) {
/* 179 */       for (byte b = 0; b < paramInt; b++) {
/* 180 */         treeSet.add(Integer.valueOf(b));
/*     */       }
/*     */     } else {
/* 183 */       for (String str : paramString.split(",")) {
/* 184 */         int i, j, k; String[] arrayOfString = str.split("-");
/* 185 */         switch (arrayOfString.length) {
/*     */ 
/*     */           
/*     */           case 1:
/* 189 */             i = Integer.parseInt(arrayOfString[0]);
/* 190 */             if (str.contains("-")) {
/* 191 */               boolean bool = str.startsWith("-") ? false : i;
/* 192 */               int m = str.endsWith("-") ? paramInt : Math.min(i, paramInt);
/* 193 */               for (int n = Math.max(bool, 1); n < m; n++)
/* 194 */                 treeSet.add(Integer.valueOf(n - 1)); 
/*     */               break;
/*     */             } 
/* 197 */             treeSet.add(Integer.valueOf(Math.max(i, 1) - 1));
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 202 */             i = Math.min(Integer.parseInt(arrayOfString[0]), paramInt);
/* 203 */             j = Math.min(Integer.parseInt(arrayOfString[1]), paramInt);
/* 204 */             for (k = Math.max(i, 1); k < j; k++) {
/* 205 */               treeSet.add(Integer.valueOf(k - 1));
/*     */             }
/*     */             break;
/*     */         } 
/*     */       
/*     */       } 
/*     */     } 
/* 212 */     return treeSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\util\PPTX2PNG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */