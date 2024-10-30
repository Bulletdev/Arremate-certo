/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StaticFontMetrics
/*     */ {
/*  40 */   private static final POILogger LOGGER = POILogFactory.getLogger(StaticFontMetrics.class);
/*     */   
/*     */   private static Properties fontMetricsProps;
/*     */   
/*  44 */   private static final Map<String, FontDetails> fontDetailsMap = new HashMap<String, FontDetails>();
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
/*     */   public static synchronized FontDetails getFontDetails(Font paramFont) {
/*  58 */     if (fontMetricsProps == null) {
/*     */       try {
/*  60 */         fontMetricsProps = loadMetrics();
/*  61 */       } catch (IOException iOException) {
/*  62 */         throw new RuntimeException("Could not load font metrics", iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  67 */     String str1 = paramFont.getName();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     String str2 = "";
/*  73 */     if (paramFont.isPlain()) {
/*  74 */       str2 = str2 + "plain";
/*     */     }
/*  76 */     if (paramFont.isBold()) {
/*  77 */       str2 = str2 + "bold";
/*     */     }
/*  79 */     if (paramFont.isItalic()) {
/*  80 */       str2 = str2 + "italic";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  85 */     String str3 = FontDetails.buildFontHeightProperty(str1);
/*  86 */     String str4 = FontDetails.buildFontHeightProperty(str1 + "." + str2);
/*     */     
/*  88 */     if (fontMetricsProps.get(str3) == null && fontMetricsProps.get(str4) != null)
/*     */     {
/*     */       
/*  91 */       str1 = str1 + "." + str2;
/*     */     }
/*     */ 
/*     */     
/*  95 */     FontDetails fontDetails = fontDetailsMap.get(str1);
/*  96 */     if (fontDetails == null) {
/*  97 */       fontDetails = FontDetails.create(str1, fontMetricsProps);
/*  98 */       fontDetailsMap.put(str1, fontDetails);
/*     */     } 
/* 100 */     return fontDetails;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Properties loadMetrics() throws IOException {
/* 106 */     File file = null;
/*     */     try {
/* 108 */       String str = System.getProperty("font.metrics.filename");
/* 109 */       if (str != null) {
/* 110 */         file = new File(str);
/* 111 */         if (!file.exists()) {
/* 112 */           LOGGER.log(5, new Object[] { "font_metrics.properties not found at path " + file.getAbsolutePath() });
/* 113 */           file = null;
/*     */         } 
/*     */       } 
/* 116 */     } catch (SecurityException securityException) {
/* 117 */       LOGGER.log(5, new Object[] { "Can't access font.metrics.filename system property", securityException });
/*     */     } 
/*     */     
/* 120 */     InputStream inputStream = null;
/*     */     try {
/* 122 */       if (file != null) {
/* 123 */         inputStream = new FileInputStream(file);
/*     */       } else {
/*     */         
/* 126 */         inputStream = FontDetails.class.getResourceAsStream("/font_metrics.properties");
/* 127 */         if (inputStream == null) {
/* 128 */           String str = "font_metrics.properties not found in classpath";
/* 129 */           throw new IOException(str);
/*     */         } 
/*     */       } 
/*     */       
/* 133 */       Properties properties = new Properties();
/* 134 */       properties.load(inputStream);
/* 135 */       return properties;
/*     */     } finally {
/* 137 */       if (inputStream != null)
/* 138 */         inputStream.close(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\StaticFontMetrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */