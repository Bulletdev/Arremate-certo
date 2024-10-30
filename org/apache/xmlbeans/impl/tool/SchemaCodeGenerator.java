/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.apache.xmlbeans.Filer;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.SystemProperties;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.util.FilerImpl;
/*     */ import repackage.a;
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
/*     */ public class SchemaCodeGenerator
/*     */ {
/*     */   public static void saveTypeSystem(SchemaTypeSystem paramSchemaTypeSystem, File paramFile1, File paramFile2, a parama, XmlOptions paramXmlOptions) throws IOException {
/*  64 */     FilerImpl filerImpl = new FilerImpl(paramFile1, null, parama, false, false);
/*  65 */     paramSchemaTypeSystem.save((Filer)filerImpl);
/*     */   }
/*     */ 
/*     */   
/*     */   static void deleteObsoleteFiles(File paramFile1, File paramFile2, Set paramSet) {
/*  70 */     if (!paramFile1.isDirectory() || !paramFile2.isDirectory())
/*  71 */       throw new IllegalArgumentException(); 
/*  72 */     String str = paramFile2.getAbsolutePath();
/*     */     
/*  74 */     if (str.length() <= 5)
/*     */       return; 
/*  76 */     if (str.startsWith("/home/") && (str.indexOf("/", 6) >= str.length() - 1 || str.indexOf("/", 6) < 0)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     File[] arrayOfFile = paramFile2.listFiles();
/*  84 */     for (byte b = 0; b < arrayOfFile.length; b++) {
/*     */       
/*  86 */       if (arrayOfFile[b].isDirectory()) {
/*  87 */         deleteObsoleteFiles(paramFile1, arrayOfFile[b], paramSet);
/*  88 */       } else if (!paramSet.contains(arrayOfFile[b])) {
/*     */ 
/*     */ 
/*     */         
/*  92 */         deleteXmlBeansFile(arrayOfFile[b]);
/*  93 */         deleteDirRecursively(paramFile1, arrayOfFile[b].getParentFile());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void deleteXmlBeansFile(File paramFile) {
/* 100 */     if (paramFile.getName().endsWith(".java")) {
/* 101 */       paramFile.delete();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void deleteDirRecursively(File paramFile1, File paramFile2) {
/* 106 */     String[] arrayOfString = paramFile2.list();
/* 107 */     while (arrayOfString != null && arrayOfString.length == 0 && !paramFile2.equals(paramFile1)) {
/*     */       
/* 109 */       paramFile2.delete();
/* 110 */       paramFile2 = paramFile2.getParentFile();
/* 111 */       arrayOfString = paramFile2.list();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static File createTempDir() throws IOException {
/*     */     
/* 121 */     try { File file = new File(SystemProperties.getProperty("java.io.tmpdir"));
/* 122 */       file.mkdirs(); }
/* 123 */     catch (Exception exception) { exception.printStackTrace(); }
/*     */     
/* 125 */     File file1 = File.createTempFile("xbean", null);
/* 126 */     String str = file1.getAbsolutePath();
/* 127 */     if (!str.endsWith(".tmp"))
/* 128 */       throw new IOException("Error: createTempFile did not create a file ending with .tmp"); 
/* 129 */     str = str.substring(0, str.length() - 4);
/* 130 */     File file2 = null;
/*     */     
/* 132 */     for (byte b = 0; b < 100; b++) {
/*     */       
/* 134 */       String str1 = str + ".d" + ((b == 0) ? "" : Integer.toString(b++));
/*     */       
/* 136 */       file2 = new File(str1);
/*     */       
/* 138 */       if (!file2.exists()) {
/*     */         
/* 140 */         boolean bool = file2.mkdirs();
/* 141 */         assert bool : "Could not create " + file2.getAbsolutePath();
/*     */         break;
/*     */       } 
/*     */     } 
/* 145 */     file1.deleteOnExit();
/*     */     
/* 147 */     return file2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void tryHardToDelete(File paramFile) {
/* 152 */     tryToDelete(paramFile);
/* 153 */     if (paramFile.exists()) {
/* 154 */       tryToDeleteLater(paramFile);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void tryToDelete(File paramFile) {
/* 159 */     if (paramFile.exists()) {
/*     */       
/* 161 */       if (paramFile.isDirectory()) {
/*     */         
/* 163 */         String[] arrayOfString = paramFile.list();
/* 164 */         if (arrayOfString != null)
/* 165 */           for (byte b = 0; b < arrayOfString.length; b++)
/* 166 */             tryToDelete(new File(paramFile, arrayOfString[b]));  
/*     */       } 
/* 168 */       if (!paramFile.delete())
/*     */         return; 
/*     */     } 
/*     */   }
/*     */   
/* 173 */   private static Set deleteFileQueue = new HashSet();
/* 174 */   private static int triesRemaining = 0;
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static boolean tryNowThatItsLater() {
/*     */     ArrayList arrayList;
/* 180 */     synchronized (deleteFileQueue) {
/*     */       
/* 182 */       arrayList = new ArrayList(deleteFileQueue);
/* 183 */       deleteFileQueue.clear();
/*     */     } 
/*     */     
/* 186 */     ArrayList arrayList1 = new ArrayList();
/*     */     
/* 188 */     for (File file : arrayList) {
/*     */ 
/*     */       
/* 191 */       tryToDelete(file);
/* 192 */       if (file.exists()) {
/* 193 */         arrayList1.add(file);
/*     */       }
/*     */     } 
/* 196 */     synchronized (deleteFileQueue) {
/*     */       
/* 198 */       if (triesRemaining > 0) {
/* 199 */         triesRemaining--;
/*     */       }
/* 201 */       if (triesRemaining <= 0 || arrayList1.size() == 0) {
/* 202 */         triesRemaining = 0;
/*     */       } else {
/* 204 */         deleteFileQueue.addAll(arrayList1);
/*     */       } 
/* 206 */       return (triesRemaining <= 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void giveUp() {
/* 212 */     synchronized (deleteFileQueue) {
/*     */       
/* 214 */       deleteFileQueue.clear();
/* 215 */       triesRemaining = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void tryToDeleteLater(File paramFile) {
/* 221 */     synchronized (deleteFileQueue) {
/*     */       
/* 223 */       deleteFileQueue.add(paramFile);
/* 224 */       if (triesRemaining == 0)
/*     */       {
/* 226 */         new Thread()
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*     */             public void run()
/*     */             {
/*     */               try {
/*     */                 while (true) {
/* 235 */                   if (SchemaCodeGenerator.tryNowThatItsLater())
/*     */                     return; 
/* 237 */                   Thread.sleep(3000L);
/*     */                 }
/*     */               
/* 240 */               } catch (InterruptedException interruptedException) {
/*     */                 
/* 242 */                 SchemaCodeGenerator.giveUp();
/*     */                 return;
/*     */               } 
/*     */             }
/*     */           };
/*     */       }
/* 248 */       if (triesRemaining < 10)
/* 249 */         triesRemaining = 10; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\SchemaCodeGenerator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */