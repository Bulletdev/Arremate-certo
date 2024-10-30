/*     */ package org.apache.xmlbeans.impl.jam.internal.javadoc;
/*     */ 
/*     */ import com.sun.javadoc.Doclet;
/*     */ import com.sun.javadoc.RootDoc;
/*     */ import com.sun.tools.javadoc.Main;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
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
/*     */ public class JavadocRunner
/*     */   extends Doclet
/*     */ {
/*     */   private static final String JAVADOC_RUNNER_150 = "org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocRunner_150";
/*     */   
/*     */   public static JavadocRunner newInstance() {
/*     */     try {
/*  54 */       Class.forName("com.sun.javadoc.AnnotationDesc");
/*  55 */     } catch (ClassNotFoundException classNotFoundException) {
/*  56 */       return new JavadocRunner();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  61 */     try { Class clazz = Class.forName("org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocRunner_150");
/*  62 */       return (JavadocRunner)clazz.newInstance(); }
/*  63 */     catch (ClassNotFoundException classNotFoundException) {  }
/*  64 */     catch (IllegalAccessException illegalAccessException) {  }
/*  65 */     catch (InstantiationException instantiationException) {}
/*     */     
/*  67 */     return new JavadocRunner();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized RootDoc run(File[] paramArrayOfFile, PrintWriter paramPrintWriter, String paramString1, String paramString2, String[] paramArrayOfString, JamLogger paramJamLogger) throws IOException, FileNotFoundException {
/*     */     PrintWriter printWriter;
/*  90 */     if (paramArrayOfFile == null || paramArrayOfFile.length == 0) {
/*  91 */       throw new FileNotFoundException("No input files found.");
/*     */     }
/*  93 */     ArrayList arrayList = new ArrayList();
/*  94 */     if (paramArrayOfString != null) {
/*  95 */       arrayList.addAll(Arrays.asList(paramArrayOfString));
/*     */     }
/*  97 */     arrayList.add("-private");
/*  98 */     if (paramString1 != null) {
/*  99 */       arrayList.add("-sourcepath");
/* 100 */       arrayList.add(paramString1);
/*     */     } 
/* 102 */     if (paramString2 != null) {
/* 103 */       arrayList.add("-classpath");
/* 104 */       arrayList.add(paramString2);
/* 105 */       arrayList.add("-docletpath");
/* 106 */       arrayList.add(paramString2);
/*     */     } 
/* 108 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/* 109 */       arrayList.add(paramArrayOfFile[b].toString());
/* 110 */       if (paramPrintWriter != null) paramPrintWriter.println(paramArrayOfFile[b].toString()); 
/*     */     } 
/* 112 */     String[] arrayOfString = new String[arrayList.size()];
/* 113 */     arrayList.toArray(arrayOfString);
/*     */ 
/*     */ 
/*     */     
/* 117 */     StringWriter stringWriter = null;
/* 118 */     if (paramPrintWriter == null) {
/* 119 */       printWriter = new PrintWriter(stringWriter = new StringWriter());
/*     */     } else {
/* 121 */       printWriter = paramPrintWriter;
/*     */     } 
/* 123 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/*     */     try {
/* 125 */       JavadocResults.prepare();
/* 126 */       if (paramJamLogger.isVerbose(this)) {
/* 127 */         paramJamLogger.verbose("Invoking javadoc.  Command line equivalent is: ");
/* 128 */         StringWriter stringWriter1 = new StringWriter();
/* 129 */         stringWriter1.write("javadoc ");
/* 130 */         for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/* 131 */           stringWriter1.write("'");
/* 132 */           stringWriter1.write(arrayOfString[b1]);
/* 133 */           stringWriter1.write("' ");
/*     */         } 
/* 135 */         paramJamLogger.verbose("  " + stringWriter1.toString());
/*     */       } 
/* 137 */       int i = Main.execute("JAM", printWriter, printWriter, printWriter, getClass().getName(), arrayOfString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 143 */       RootDoc rootDoc = JavadocResults.getRoot();
/* 144 */       if (i != 0 || rootDoc == null) {
/* 145 */         printWriter.flush();
/* 146 */         if (JavadocClassloadingException.isClassloadingProblemPresent()) {
/* 147 */           throw new JavadocClassloadingException();
/*     */         }
/* 149 */         throw new RuntimeException("Unknown javadoc problem: result=" + i + ", root=" + rootDoc + ":\n" + ((stringWriter == null) ? "" : stringWriter.toString()));
/*     */       } 
/*     */ 
/*     */       
/* 153 */       return rootDoc;
/* 154 */     } catch (RuntimeException runtimeException) {
/* 155 */       throw runtimeException;
/*     */     } finally {
/*     */       
/* 158 */       Thread.currentThread().setContextClassLoader(classLoader);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean start(RootDoc paramRootDoc) {
/* 166 */     JavadocResults.setRoot(paramRootDoc);
/* 167 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\javadoc\JavadocRunner.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */