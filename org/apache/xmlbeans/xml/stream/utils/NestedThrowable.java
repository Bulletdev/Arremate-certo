/*     */ package org.apache.xmlbeans.xml.stream.utils;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.lang.reflect.InvocationTargetException;
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
/*     */ public interface NestedThrowable
/*     */ {
/*     */   Throwable getNested();
/*     */   
/*     */   String superToString();
/*     */   
/*     */   void superPrintStackTrace(PrintStream paramPrintStream);
/*     */   
/*     */   void superPrintStackTrace(PrintWriter paramPrintWriter);
/*     */   
/*     */   public static class Util
/*     */   {
/*  47 */     private static String EOL = System.getProperty("line.separator");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static String toString(NestedThrowable param1NestedThrowable) {
/*  55 */       Throwable throwable = param1NestedThrowable.getNested();
/*  56 */       if (throwable == null) {
/*  57 */         return param1NestedThrowable.superToString();
/*     */       }
/*  59 */       return param1NestedThrowable.superToString() + " - with nested exception:" + EOL + "[" + nestedToString(throwable) + "]";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static String nestedToString(Throwable param1Throwable) {
/*  65 */       if (param1Throwable instanceof InvocationTargetException) {
/*  66 */         InvocationTargetException invocationTargetException = (InvocationTargetException)param1Throwable;
/*  67 */         return param1Throwable.toString() + " - with target exception:" + EOL + "[" + invocationTargetException.getTargetException().toString() + "]";
/*     */       } 
/*     */ 
/*     */       
/*  71 */       return param1Throwable.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static void printStackTrace(NestedThrowable param1NestedThrowable, PrintStream param1PrintStream) {
/*  81 */       Throwable throwable = param1NestedThrowable.getNested();
/*  82 */       if (throwable != null) {
/*  83 */         throwable.printStackTrace(param1PrintStream);
/*  84 */         param1PrintStream.println("--------------- nested within: ------------------");
/*     */       } 
/*  86 */       param1NestedThrowable.superPrintStackTrace(param1PrintStream);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static void printStackTrace(NestedThrowable param1NestedThrowable, PrintWriter param1PrintWriter) {
/*  96 */       Throwable throwable = param1NestedThrowable.getNested();
/*  97 */       if (throwable != null) {
/*  98 */         throwable.printStackTrace(param1PrintWriter);
/*  99 */         param1PrintWriter.println("--------------- nested within: ------------------");
/*     */       } 
/* 101 */       param1NestedThrowable.superPrintStackTrace(param1PrintWriter);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\strea\\utils\NestedThrowable.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */