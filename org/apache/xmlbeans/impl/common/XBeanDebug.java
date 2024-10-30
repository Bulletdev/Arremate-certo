/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import org.apache.xmlbeans.SystemProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XBeanDebug
/*     */ {
/*     */   public static final int TRACE_SCHEMA_LOADING = 1;
/*     */   public static final String traceProp = "org.apache.xmlbeans.impl.debug";
/*     */   public static final String defaultProp = "";
/*  31 */   private static int _enabled = initializeBitsFromProperty();
/*  32 */   private static int _indent = 0;
/*  33 */   private static String _indentspace = "                                                                                ";
/*     */   static PrintStream _err;
/*     */   
/*     */   private static int initializeBitsFromProperty() {
/*  37 */     int i = 0;
/*  38 */     String str = SystemProperties.getProperty("org.apache.xmlbeans.impl.debug", "");
/*  39 */     if (str.indexOf("TRACE_SCHEMA_LOADING") >= 0)
/*  40 */       i |= 0x1; 
/*  41 */     return i;
/*     */   }
/*     */   
/*     */   public static void enable(int paramInt) {
/*  45 */     _enabled |= paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void disable(int paramInt) {
/*  50 */     _enabled &= paramInt ^ 0xFFFFFFFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void trace(int paramInt1, String paramString, int paramInt2) {
/*  55 */     if (test(paramInt1))
/*     */     {
/*  57 */       synchronized (XBeanDebug.class) {
/*     */         
/*  59 */         if (paramInt2 < 0) {
/*  60 */           _indent += paramInt2;
/*     */         }
/*  62 */         String str1 = (_indent < 0) ? "" : ((_indent > _indentspace.length()) ? _indentspace : _indentspace.substring(0, _indent));
/*  63 */         String str2 = Thread.currentThread().getName() + ": " + str1 + paramString + "\n";
/*  64 */         System.err.print(str2);
/*     */         
/*  66 */         if (paramInt2 > 0) {
/*  67 */           _indent += paramInt2;
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean test(int paramInt) {
/*  74 */     return ((_enabled & paramInt) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String log(String paramString) {
/*  81 */     log(paramString, null);
/*  82 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String logStackTrace(String paramString) {
/*  87 */     log(paramString, new Throwable());
/*  88 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private static synchronized String log(String paramString, Throwable paramThrowable) {
/*  93 */     if (_err == null) {
/*     */       
/*     */       try {
/*     */         
/*  97 */         File file = File.createTempFile("xmlbeandebug", ".log");
/*  98 */         _err = new PrintStream(new FileOutputStream(file));
/*  99 */         System.err.println("Diagnostic XML Bean debug log file created: " + file);
/*     */       }
/* 101 */       catch (IOException iOException) {
/*     */         
/* 103 */         _err = System.err;
/*     */       } 
/*     */     }
/* 106 */     _err.println(paramString);
/* 107 */     if (paramThrowable != null)
/*     */     {
/* 109 */       paramThrowable.printStackTrace(_err);
/*     */     }
/* 111 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Throwable logException(Throwable paramThrowable) {
/* 116 */     log(paramThrowable.getMessage(), paramThrowable);
/* 117 */     return paramThrowable;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XBeanDebug.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */