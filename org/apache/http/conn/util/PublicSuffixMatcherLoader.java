/*     */ package org.apache.http.conn.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public final class PublicSuffixMatcherLoader
/*     */ {
/*     */   private static volatile PublicSuffixMatcher DEFAULT_INSTANCE;
/*     */   
/*     */   private static PublicSuffixMatcher load(InputStream paramInputStream) throws IOException {
/*  54 */     List<PublicSuffixList> list = (new PublicSuffixListParser()).parseByType(new InputStreamReader(paramInputStream, Consts.UTF_8));
/*     */     
/*  56 */     return new PublicSuffixMatcher(list);
/*     */   }
/*     */   
/*     */   public static PublicSuffixMatcher load(URL paramURL) throws IOException {
/*  60 */     Args.notNull(paramURL, "URL");
/*  61 */     InputStream inputStream = paramURL.openStream();
/*     */     try {
/*  63 */       return load(inputStream);
/*     */     } finally {
/*  65 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static PublicSuffixMatcher load(File paramFile) throws IOException {
/*  70 */     Args.notNull(paramFile, "File");
/*  71 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     try {
/*  73 */       return load(fileInputStream);
/*     */     } finally {
/*  75 */       fileInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static PublicSuffixMatcher getDefault() {
/*  82 */     if (DEFAULT_INSTANCE == null) {
/*  83 */       synchronized (PublicSuffixMatcherLoader.class) {
/*  84 */         if (DEFAULT_INSTANCE == null) {
/*  85 */           URL uRL = PublicSuffixMatcherLoader.class.getResource("/mozilla/public-suffix-list.txt");
/*     */           
/*  87 */           if (uRL != null) {
/*     */             try {
/*  89 */               DEFAULT_INSTANCE = load(uRL);
/*  90 */             } catch (IOException iOException) {
/*     */               
/*  92 */               Log log = LogFactory.getLog(PublicSuffixMatcherLoader.class);
/*  93 */               if (log.isWarnEnabled()) {
/*  94 */                 log.warn("Failure loading public suffix list from default resource", iOException);
/*     */               }
/*     */             } 
/*     */           } else {
/*  98 */             DEFAULT_INSTANCE = new PublicSuffixMatcher(DomainType.ICANN, Arrays.asList(new String[] { "com" }, ), null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 103 */     return DEFAULT_INSTANCE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\con\\util\PublicSuffixMatcherLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */