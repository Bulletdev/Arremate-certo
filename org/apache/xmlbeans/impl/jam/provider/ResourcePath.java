/*     */ package org.apache.xmlbeans.impl.jam.provider;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.InputStream;
/*     */ import java.io.StringWriter;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
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
/*     */ public class ResourcePath
/*     */ {
/*     */   private File[] mFiles;
/*     */   
/*     */   public static ResourcePath forFiles(File[] paramArrayOfFile) {
/*  38 */     return new ResourcePath(paramArrayOfFile);
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
/*     */   private ResourcePath(File[] paramArrayOfFile) {
/*  55 */     if (paramArrayOfFile == null) throw new IllegalArgumentException("null files"); 
/*  56 */     this.mFiles = paramArrayOfFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI[] toUriPath() {
/*  63 */     URI[] arrayOfURI = new URI[this.mFiles.length];
/*  64 */     for (byte b = 0; b < this.mFiles.length; b++) {
/*  65 */       arrayOfURI[b] = this.mFiles[b].toURI();
/*     */     }
/*  67 */     return arrayOfURI;
/*     */   }
/*     */   
/*     */   public URL[] toUrlPath() throws MalformedURLException {
/*  71 */     URL[] arrayOfURL = new URL[this.mFiles.length];
/*  72 */     for (byte b = 0; b < this.mFiles.length; b++) {
/*  73 */       arrayOfURL[b] = this.mFiles[b].toURL();
/*     */     }
/*  75 */     return arrayOfURL;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream findInPath(String paramString) {
/*  80 */     for (byte b = 0; b < this.mFiles.length; b++) {
/*  81 */       File file = new File(this.mFiles[b], paramString);
/*     */       try {
/*  83 */         if (file.exists()) return new FileInputStream(file); 
/*  84 */       } catch (FileNotFoundException fileNotFoundException) {
/*  85 */         fileNotFoundException.printStackTrace();
/*     */       } 
/*     */     } 
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  99 */     StringWriter stringWriter = new StringWriter();
/* 100 */     for (byte b = 0; b < this.mFiles.length; b++) {
/* 101 */       stringWriter.write(this.mFiles[b].getAbsolutePath());
/* 102 */       stringWriter.write(File.pathSeparatorChar);
/*     */     } 
/* 104 */     return stringWriter.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\provider\ResourcePath.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */