/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Collections;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Charsets
/*     */ {
/*     */   private static final SortedMap<String, Charset> STANDARD_CHARSET_MAP;
/*     */   
/*     */   static {
/*  65 */     TreeMap<String, Object> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
/*  66 */     treeMap.put(StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1);
/*  67 */     treeMap.put(StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII);
/*  68 */     treeMap.put(StandardCharsets.UTF_16.name(), StandardCharsets.UTF_16);
/*  69 */     treeMap.put(StandardCharsets.UTF_16BE.name(), StandardCharsets.UTF_16BE);
/*  70 */     treeMap.put(StandardCharsets.UTF_16LE.name(), StandardCharsets.UTF_16LE);
/*  71 */     treeMap.put(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8);
/*  72 */     STANDARD_CHARSET_MAP = Collections.unmodifiableSortedMap(treeMap);
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
/*     */   public static SortedMap<String, Charset> requiredCharsets() {
/*  88 */     return STANDARD_CHARSET_MAP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Charset toCharset(Charset paramCharset) {
/*  99 */     return (paramCharset == null) ? Charset.defaultCharset() : paramCharset;
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
/*     */   public static Charset toCharset(String paramString) {
/* 112 */     return (paramString == null) ? Charset.defaultCharset() : Charset.forName(paramString);
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
/*     */   @Deprecated
/* 125 */   public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
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
/*     */   @Deprecated
/* 139 */   public static final Charset US_ASCII = StandardCharsets.US_ASCII;
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
/*     */   @Deprecated
/* 154 */   public static final Charset UTF_16 = StandardCharsets.UTF_16;
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
/*     */   @Deprecated
/* 168 */   public static final Charset UTF_16BE = StandardCharsets.UTF_16BE;
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
/*     */   @Deprecated
/* 182 */   public static final Charset UTF_16LE = StandardCharsets.UTF_16LE;
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
/*     */   @Deprecated
/* 196 */   public static final Charset UTF_8 = StandardCharsets.UTF_8;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\Charsets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */