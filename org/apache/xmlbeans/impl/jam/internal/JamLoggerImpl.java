/*     */ package org.apache.xmlbeans.impl.jam.internal;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
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
/*     */ public class JamLoggerImpl
/*     */   implements JamLogger
/*     */ {
/*     */   private boolean mShowWarnings = true;
/*  33 */   private Set mVerboseClasses = null;
/*  34 */   private PrintWriter mOut = new PrintWriter(System.out, true);
/*     */   
/*     */   protected void setOut(PrintWriter paramPrintWriter) {
/*  37 */     this.mOut = paramPrintWriter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVerbose(Object paramObject) {
/*  43 */     if (this.mVerboseClasses == null) return false; 
/*  44 */     Iterator iterator = this.mVerboseClasses.iterator();
/*  45 */     while (iterator.hasNext()) {
/*  46 */       Class clazz = iterator.next();
/*  47 */       if (clazz.isAssignableFrom(paramObject.getClass())) return true; 
/*     */     } 
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isVerbose(Class paramClass) {
/*  53 */     if (this.mVerboseClasses == null) return false; 
/*  54 */     Iterator iterator = this.mVerboseClasses.iterator();
/*  55 */     while (iterator.hasNext()) {
/*  56 */       Class clazz = iterator.next();
/*  57 */       if (clazz.isAssignableFrom(paramClass)) return true; 
/*     */     } 
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public void setVerbose(Class paramClass) {
/*  63 */     if (paramClass == null) throw new IllegalArgumentException(); 
/*  64 */     if (this.mVerboseClasses == null) this.mVerboseClasses = new HashSet(); 
/*  65 */     this.mVerboseClasses.add(paramClass);
/*     */   }
/*     */   
/*     */   public void setShowWarnings(boolean paramBoolean) {
/*  69 */     this.mShowWarnings = paramBoolean;
/*     */   }
/*     */   
/*     */   public void verbose(String paramString, Object paramObject) {
/*  73 */     if (isVerbose(paramObject)) verbose(paramString); 
/*     */   }
/*     */   
/*     */   public void verbose(Throwable paramThrowable, Object paramObject) {
/*  77 */     if (isVerbose(paramObject)) verbose(paramThrowable); 
/*     */   }
/*     */   
/*     */   public void verbose(String paramString) {
/*  81 */     printVerbosePrefix();
/*  82 */     this.mOut.println(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void verbose(Throwable paramThrowable) {
/*  87 */     printVerbosePrefix();
/*  88 */     this.mOut.println();
/*  89 */     paramThrowable.printStackTrace(this.mOut);
/*     */   }
/*     */   
/*     */   public void warning(Throwable paramThrowable) {
/*  93 */     if (this.mShowWarnings) {
/*  94 */       this.mOut.println("[JAM] Warning: unexpected exception thrown: ");
/*  95 */       paramThrowable.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void warning(String paramString) {
/* 100 */     if (this.mShowWarnings) {
/*     */       
/* 102 */       this.mOut.print("[JAM] Warning: ");
/* 103 */       this.mOut.println(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void error(Throwable paramThrowable) {
/* 108 */     this.mOut.println("[JAM] Error: unexpected exception thrown: ");
/* 109 */     paramThrowable.printStackTrace(this.mOut);
/*     */   }
/*     */   
/*     */   public void error(String paramString) {
/* 113 */     this.mOut.print("[JAM] Error: ");
/* 114 */     this.mOut.println(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerbose(boolean paramBoolean) {
/* 120 */     setVerbose(Object.class);
/*     */   } public boolean isVerbose() {
/* 122 */     return (this.mVerboseClasses != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void printVerbosePrefix() {
/* 128 */     StackTraceElement[] arrayOfStackTraceElement = (new Exception()).getStackTrace();
/* 129 */     this.mOut.println("[JAM] Verbose: ");
/* 130 */     this.mOut.print('(');
/* 131 */     this.mOut.print(shortName(arrayOfStackTraceElement[2].getClassName()));
/* 132 */     this.mOut.print('.');
/* 133 */     this.mOut.print(arrayOfStackTraceElement[2].getMethodName());
/* 134 */     this.mOut.print(':');
/* 135 */     this.mOut.print(arrayOfStackTraceElement[2].getLineNumber());
/* 136 */     this.mOut.print(")  ");
/*     */   }
/*     */   
/*     */   private static String shortName(String paramString) {
/* 140 */     int i = paramString.lastIndexOf('.');
/*     */     
/* 142 */     if (i != -1) {
/* 143 */       paramString = paramString.substring(i + 1, paramString.length());
/*     */     }
/*     */     
/* 146 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\JamLoggerImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */