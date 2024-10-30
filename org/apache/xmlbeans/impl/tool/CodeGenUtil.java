/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileWriter;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class CodeGenUtil
/*     */ {
/*  35 */   public static String DEFAULT_MEM_START = "8m";
/*  36 */   public static String DEFAULT_MEM_MAX = "256m";
/*  37 */   public static String DEFAULT_COMPILER = "javac";
/*  38 */   public static String DEFAULT_JAR = "jar";
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public static URI resolve(URI paramURI1, URI paramURI2) {
/*  43 */     URI uRI = paramURI1.resolve(paramURI2);
/*     */ 
/*     */     
/*  46 */     if ("file".equals(uRI.getScheme()) && !paramURI2.equals(uRI))
/*     */     {
/*  48 */       if (paramURI1.getPath().startsWith("//") && !uRI.getPath().startsWith("//")) {
/*     */         
/*  50 */         String str = "///".concat(uRI.getPath());
/*     */         
/*     */         try {
/*  53 */           uRI = new URI("file", null, str, uRI.getQuery(), uRI.getFragment());
/*     */         }
/*  55 */         catch (URISyntaxException uRISyntaxException) {}
/*     */       } 
/*     */     }
/*     */     
/*  59 */     return uRI;
/*     */   }
/*     */ 
/*     */   
/*     */   static void addAllJavaFiles(List paramList1, List paramList2) {
/*  64 */     for (File file : paramList1) {
/*     */ 
/*     */       
/*  67 */       if (!file.isDirectory()) {
/*     */         
/*  69 */         paramList2.add(quoteAndEscapeFilename(file.getAbsolutePath()));
/*     */         
/*     */         continue;
/*     */       } 
/*  73 */       List list = Arrays.asList(file.listFiles(new FileFilter()
/*     */             {
/*     */               public boolean accept(File param1File)
/*     */               {
/*  77 */                 return ((param1File.isFile() && param1File.getName().endsWith(".java")) || param1File.isDirectory());
/*     */               }
/*     */             }));
/*  80 */       addAllJavaFiles(list, paramList2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String quoteAndEscapeFilename(String paramString) {
/*  88 */     if (paramString.indexOf(" ") < 0) {
/*  89 */       return paramString;
/*     */     }
/*     */ 
/*     */     
/*  93 */     return "\"" + paramString.replaceAll("\\\\", "\\\\\\\\") + "\"";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String quoteNoEscapeFilename(String paramString) {
/*  99 */     if (paramString.indexOf(" ") < 0 || File.separatorChar == '/') {
/* 100 */       return paramString;
/*     */     }
/* 102 */     return "\"" + paramString + "\"";
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
/*     */   public static boolean externalCompile(List paramList, File paramFile, File[] paramArrayOfFile, boolean paramBoolean) {
/* 115 */     return externalCompile(paramList, paramFile, paramArrayOfFile, paramBoolean, DEFAULT_COMPILER, null, DEFAULT_MEM_START, DEFAULT_MEM_MAX, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean externalCompile(List paramList, File paramFile, File[] paramArrayOfFile, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3) {
/* 121 */     return externalCompile(paramList, paramFile, paramArrayOfFile, paramBoolean1, paramString1, null, paramString2, paramString3, paramBoolean2, paramBoolean3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean externalCompile(List paramList, File paramFile, File[] paramArrayOfFile, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, boolean paramBoolean3) {
/* 132 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 134 */     File file1 = findJavaTool((paramString1 == null) ? DEFAULT_COMPILER : paramString1);
/* 135 */     assert file1.exists() : "compiler not found " + file1;
/* 136 */     arrayList.add(file1.getAbsolutePath());
/*     */     
/* 138 */     if (paramFile == null) {
/*     */       
/* 140 */       paramFile = new File(".");
/*     */     }
/*     */     else {
/*     */       
/* 144 */       arrayList.add("-d");
/* 145 */       arrayList.add(quoteAndEscapeFilename(paramFile.getAbsolutePath()));
/*     */     } 
/*     */     
/* 148 */     if (paramArrayOfFile == null)
/*     */     {
/* 150 */       paramArrayOfFile = systemClasspath();
/*     */     }
/*     */     
/* 153 */     if (paramArrayOfFile.length > 0) {
/*     */       
/* 155 */       StringBuffer stringBuffer = new StringBuffer();
/*     */ 
/*     */ 
/*     */       
/* 159 */       stringBuffer.append(paramFile.getAbsolutePath());
/*     */ 
/*     */       
/* 162 */       for (byte b = 0; b < paramArrayOfFile.length; b++) {
/*     */         
/* 164 */         stringBuffer.append(File.pathSeparator);
/* 165 */         stringBuffer.append(paramArrayOfFile[b].getAbsolutePath());
/*     */       } 
/*     */       
/* 168 */       arrayList.add("-classpath");
/*     */ 
/*     */       
/* 171 */       arrayList.add(quoteAndEscapeFilename(stringBuffer.toString()));
/*     */     } 
/*     */     
/* 174 */     if (paramString2 == null) {
/* 175 */       paramString2 = "1.4";
/*     */     }
/* 177 */     arrayList.add("-source");
/* 178 */     arrayList.add(paramString2);
/*     */     
/* 180 */     arrayList.add("-target");
/* 181 */     arrayList.add(paramString2);
/*     */     
/* 183 */     arrayList.add(paramBoolean1 ? "-g" : "-g:none");
/*     */     
/* 185 */     if (paramBoolean3) {
/* 186 */       arrayList.add("-verbose");
/*     */     }
/* 188 */     addAllJavaFiles(paramList, arrayList);
/*     */     
/* 190 */     File file2 = null;
/*     */     
/*     */     try {
/* 193 */       file2 = File.createTempFile("javac", "");
/* 194 */       FileWriter fileWriter = new FileWriter(file2);
/* 195 */       Iterator iterator = arrayList.iterator();
/* 196 */       iterator.next(); while (iterator.hasNext()) {
/*     */         
/* 198 */         String str = iterator.next();
/* 199 */         fileWriter.write(str);
/* 200 */         fileWriter.write(10);
/*     */       } 
/* 202 */       fileWriter.close();
/* 203 */       ArrayList arrayList1 = new ArrayList();
/* 204 */       arrayList1.add(arrayList.get(0));
/*     */       
/* 206 */       if (paramString3 != null && paramString3.length() != 0)
/* 207 */         arrayList1.add("-J-Xms" + paramString3); 
/* 208 */       if (paramString4 != null && paramString4.length() != 0) {
/* 209 */         arrayList1.add("-J-Xmx" + paramString4);
/*     */       }
/* 211 */       arrayList1.add("@" + file2.getAbsolutePath());
/* 212 */       arrayList = arrayList1;
/*     */     }
/* 214 */     catch (Exception exception) {
/*     */       
/* 216 */       System.err.println("Could not create command-line file for javac");
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 221 */       String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
/*     */       
/* 223 */       if (paramBoolean3) {
/*     */         
/* 225 */         System.out.print("compile command:");
/* 226 */         for (byte b = 0; b < arrayOfString.length; b++)
/* 227 */           System.out.print(" " + arrayOfString[b]); 
/* 228 */         System.out.println();
/*     */       } 
/*     */       
/* 231 */       Process process = Runtime.getRuntime().exec(arrayOfString);
/*     */       
/* 233 */       StringBuffer stringBuffer1 = new StringBuffer();
/* 234 */       StringBuffer stringBuffer2 = new StringBuffer();
/*     */       
/* 236 */       ThreadedReader threadedReader1 = new ThreadedReader(process.getInputStream(), stringBuffer2);
/* 237 */       ThreadedReader threadedReader2 = new ThreadedReader(process.getErrorStream(), stringBuffer1);
/*     */       
/* 239 */       process.waitFor();
/*     */       
/* 241 */       if (paramBoolean3 || process.exitValue() != 0) {
/*     */         
/* 243 */         if (stringBuffer2.length() > 0) {
/* 244 */           System.out.println(stringBuffer2.toString());
/* 245 */           System.out.flush();
/*     */         } 
/* 247 */         if (stringBuffer1.length() > 0) {
/* 248 */           System.err.println(stringBuffer1.toString());
/* 249 */           System.err.flush();
/*     */         } 
/*     */         
/* 252 */         if (process.exitValue() != 0) {
/* 253 */           return false;
/*     */         }
/*     */       } 
/* 256 */     } catch (Throwable throwable) {
/*     */       
/* 258 */       System.err.println(throwable.toString());
/* 259 */       System.err.println(throwable.getCause());
/* 260 */       throwable.printStackTrace(System.err);
/* 261 */       return false;
/*     */     } 
/*     */     
/* 264 */     if (file2 != null) {
/* 265 */       file2.delete();
/*     */     }
/* 267 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static File[] systemClasspath() {
/* 272 */     ArrayList arrayList = new ArrayList();
/* 273 */     String[] arrayOfString = SystemProperties.getProperty("java.class.path").split(File.pathSeparator);
/* 274 */     for (byte b = 0; b < arrayOfString.length; b++)
/*     */     {
/* 276 */       arrayList.add(new File(arrayOfString[b]));
/*     */     }
/* 278 */     return arrayList.<File>toArray(new File[arrayList.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean externalJar(File paramFile1, File paramFile2) {
/* 286 */     return externalJar(paramFile1, paramFile2, DEFAULT_JAR, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean externalJar(File paramFile1, File paramFile2, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 294 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 296 */     File file = findJavaTool((paramString == null) ? DEFAULT_JAR : paramString);
/* 297 */     assert file.exists() : "jar not found " + file;
/* 298 */     arrayList.add(file.getAbsolutePath());
/*     */     
/* 300 */     arrayList.add("cf");
/* 301 */     arrayList.add(quoteNoEscapeFilename(paramFile2.getAbsolutePath()));
/*     */     
/* 303 */     arrayList.add("-C");
/* 304 */     arrayList.add(quoteNoEscapeFilename(paramFile1.getAbsolutePath()));
/*     */     
/* 306 */     arrayList.add(".");
/*     */ 
/*     */     
/*     */     try {
/* 310 */       String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
/*     */       
/* 312 */       if (paramBoolean2) {
/*     */         
/* 314 */         System.out.print("jar command:");
/* 315 */         for (byte b = 0; b < arrayOfString.length; b++)
/* 316 */           System.out.print(" " + arrayOfString[b]); 
/* 317 */         System.out.println();
/*     */       } 
/*     */       
/* 320 */       Process process = Runtime.getRuntime().exec(arrayOfString);
/*     */       
/* 322 */       StringBuffer stringBuffer1 = new StringBuffer();
/* 323 */       StringBuffer stringBuffer2 = new StringBuffer();
/*     */       
/* 325 */       ThreadedReader threadedReader1 = new ThreadedReader(process.getInputStream(), stringBuffer2);
/* 326 */       ThreadedReader threadedReader2 = new ThreadedReader(process.getErrorStream(), stringBuffer1);
/*     */       
/* 328 */       process.waitFor();
/*     */       
/* 330 */       if (paramBoolean2 || process.exitValue() != 0) {
/*     */         
/* 332 */         if (stringBuffer2.length() > 0) {
/* 333 */           System.out.println(stringBuffer2.toString());
/* 334 */           System.out.flush();
/*     */         } 
/* 336 */         if (stringBuffer1.length() > 0) {
/* 337 */           System.err.println(stringBuffer1.toString());
/* 338 */           System.err.flush();
/*     */         } 
/*     */         
/* 341 */         if (process.exitValue() != 0) {
/* 342 */           return false;
/*     */         }
/*     */       } 
/* 345 */     } catch (Throwable throwable) {
/*     */       
/* 347 */       throwable.printStackTrace(System.err);
/* 348 */       return false;
/*     */     } 
/* 350 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static File findJavaTool(String paramString) {
/* 359 */     File file1 = new File(paramString);
/* 360 */     if (file1.isFile()) {
/* 361 */       return file1;
/*     */     }
/*     */     
/* 364 */     File file2 = new File(paramString + ".exe");
/* 365 */     if (file2.isFile()) {
/* 366 */       return file2;
/*     */     }
/*     */     
/* 369 */     String str1 = SystemProperties.getProperty("java.home");
/*     */     
/* 371 */     String str2 = File.separator;
/* 372 */     file2 = new File(str1 + str2 + ".." + str2 + "bin", paramString);
/*     */     
/* 374 */     if (file2.isFile()) {
/* 375 */       return file2;
/*     */     }
/*     */     
/* 378 */     file2 = new File(file2.getPath() + ".exe");
/* 379 */     if (file2.isFile()) {
/* 380 */       return file2;
/*     */     }
/*     */     
/* 383 */     file2 = new File(str1 + str2 + "bin", paramString);
/* 384 */     if (file2.isFile()) {
/* 385 */       return file2;
/*     */     }
/*     */     
/* 388 */     file2 = new File(file2.getPath() + ".exe");
/* 389 */     if (file2.isFile()) {
/* 390 */       return file2;
/*     */     }
/*     */ 
/*     */     
/* 394 */     return file1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ThreadedReader
/*     */   {
/*     */     public ThreadedReader(InputStream param1InputStream, final StringBuffer output) {
/* 405 */       final BufferedReader reader = new BufferedReader(new InputStreamReader(param1InputStream));
/*     */ 
/*     */       
/* 408 */       Thread thread = new Thread(new Runnable() {
/*     */             private final BufferedReader val$reader;
/*     */             
/*     */             public void run() {
/*     */               try {
/*     */                 String str;
/* 414 */                 while ((str = reader.readLine()) != null) {
/* 415 */                   output.append(str + "\n");
/*     */                 }
/* 417 */               } catch (Exception exception) {}
/*     */             }
/*     */             private final StringBuffer val$output; private final CodeGenUtil.ThreadedReader this$0;
/*     */           });
/* 421 */       thread.start();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\CodeGenUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */