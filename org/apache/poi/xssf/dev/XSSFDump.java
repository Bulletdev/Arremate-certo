/*     */ package org.apache.poi.xssf.dev;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.internal.ZipHelper;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.w3c.dom.Document;
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
/*     */ public final class XSSFDump
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  45 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  46 */       System.out.println("Dumping " + paramArrayOfString[b]);
/*  47 */       ZipFile zipFile = ZipHelper.openZipFile(paramArrayOfString[b]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void createDirIfMissing(File paramFile) throws RuntimeException {
/*  57 */     if (!paramFile.exists()) {
/*  58 */       boolean bool = paramFile.mkdir();
/*  59 */       if (!bool) {
/*  60 */         throw new RuntimeException("Unable to create directory: " + paramFile);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void recursivelyCreateDirIfMissing(File paramFile) throws RuntimeException {
/*  66 */     if (!paramFile.exists()) {
/*  67 */       boolean bool = paramFile.mkdirs();
/*  68 */       if (!bool) {
/*  69 */         throw new RuntimeException("Unable to recursively create directory: " + paramFile);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void dump(ZipFile paramZipFile) throws Exception {
/*  76 */     String str = paramZipFile.getName();
/*  77 */     int i = str.lastIndexOf('.');
/*  78 */     File file = new File(str.substring(0, i));
/*  79 */     createDirIfMissing(file);
/*  80 */     System.out.println("Dumping to directory " + file);
/*     */     
/*  82 */     Enumeration<? extends ZipEntry> enumeration = paramZipFile.entries();
/*  83 */     while (enumeration.hasMoreElements()) {
/*  84 */       ZipEntry zipEntry = enumeration.nextElement();
/*  85 */       String str1 = zipEntry.getName();
/*  86 */       int j = str1.lastIndexOf('/');
/*  87 */       if (j != -1) {
/*  88 */         File file2 = new File(file, str1.substring(0, j));
/*  89 */         recursivelyCreateDirIfMissing(file2);
/*     */       } 
/*     */       
/*  92 */       File file1 = new File(file, zipEntry.getName());
/*  93 */       FileOutputStream fileOutputStream = new FileOutputStream(file1);
/*     */       try {
/*  95 */         if (zipEntry.getName().endsWith(".xml") || zipEntry.getName().endsWith(".vml") || zipEntry.getName().endsWith(".rels")) {
/*     */           try {
/*  97 */             Document document = DocumentHelper.readDocument(paramZipFile.getInputStream(zipEntry));
/*  98 */             XmlObject xmlObject = XmlObject.Factory.parse(document, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  99 */             XmlOptions xmlOptions = new XmlOptions();
/* 100 */             xmlOptions.setSavePrettyPrint();
/* 101 */             xmlObject.save(fileOutputStream, xmlOptions);
/* 102 */           } catch (XmlException xmlException) {
/* 103 */             System.err.println("Failed to parse " + zipEntry.getName() + ", dumping raw content");
/* 104 */             IOUtils.copy(paramZipFile.getInputStream(zipEntry), fileOutputStream);
/*     */           } 
/*     */         } else {
/* 107 */           IOUtils.copy(paramZipFile.getInputStream(zipEntry), fileOutputStream);
/*     */         } 
/*     */       } finally {
/* 110 */         fileOutputStream.close();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\dev\XSSFDump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */