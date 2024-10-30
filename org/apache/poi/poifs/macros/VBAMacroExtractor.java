/*     */ package org.apache.poi.poifs.macros;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public class VBAMacroExtractor
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*  38 */     if (paramArrayOfString.length == 0) {
/*  39 */       System.err.println("Use:");
/*  40 */       System.err.println("   VBAMacroExtractor <office.doc> [output]");
/*  41 */       System.err.println("");
/*  42 */       System.err.println("If an output directory is given, macros are written there");
/*  43 */       System.err.println("Otherwise they are output to the screen");
/*  44 */       System.exit(1);
/*     */     } 
/*     */     
/*  47 */     File file1 = new File(paramArrayOfString[0]);
/*  48 */     File file2 = null;
/*  49 */     if (paramArrayOfString.length > 1) {
/*  50 */       file2 = new File(paramArrayOfString[1]);
/*     */     }
/*     */     
/*  53 */     VBAMacroExtractor vBAMacroExtractor = new VBAMacroExtractor();
/*  54 */     vBAMacroExtractor.extract(file1, file2);
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
/*     */ 
/*     */   
/*     */   public void extract(File paramFile1, File paramFile2, String paramString) throws IOException {
/*  71 */     if (!paramFile1.exists()) throw new FileNotFoundException(paramFile1.toString()); 
/*  72 */     System.err.print("Extracting VBA Macros from " + paramFile1 + " to ");
/*  73 */     if (paramFile2 != null) {
/*  74 */       if (!paramFile2.exists() && !paramFile2.mkdirs()) {
/*  75 */         throw new IOException("Output directory " + paramFile2 + " could not be created");
/*     */       }
/*  77 */       System.err.println(paramFile2);
/*     */     } else {
/*  79 */       System.err.println("STDOUT");
/*     */     } 
/*     */     
/*  82 */     VBAMacroReader vBAMacroReader = new VBAMacroReader(paramFile1);
/*  83 */     Map<String, String> map = vBAMacroReader.readMacros();
/*  84 */     vBAMacroReader.close();
/*     */     
/*  86 */     String str = "---------------------------------------";
/*  87 */     for (Map.Entry<String, String> entry : map.entrySet()) {
/*  88 */       String str1 = (String)entry.getKey();
/*  89 */       String str2 = (String)entry.getValue();
/*  90 */       if (paramFile2 == null) {
/*  91 */         System.out.println("---------------------------------------");
/*  92 */         System.out.println(str1);
/*  93 */         System.out.println("");
/*  94 */         System.out.println(str2); continue;
/*     */       } 
/*  96 */       File file = new File(paramFile2, str1 + paramString);
/*  97 */       FileOutputStream fileOutputStream = new FileOutputStream(file);
/*  98 */       OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StringUtil.UTF8);
/*  99 */       outputStreamWriter.write(str2);
/* 100 */       outputStreamWriter.close();
/* 101 */       fileOutputStream.close();
/* 102 */       System.out.println("Extracted " + file);
/*     */     } 
/*     */     
/* 105 */     if (paramFile2 == null) {
/* 106 */       System.out.println("---------------------------------------");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void extract(File paramFile1, File paramFile2) throws IOException {
/* 123 */     extract(paramFile1, paramFile2, ".vba");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\macros\VBAMacroExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */