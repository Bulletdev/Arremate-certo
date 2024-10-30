/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.net.URI;
/*     */ import java.security.SecureClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import javax.tools.FileObject;
/*     */ import javax.tools.ForwardingJavaFileManager;
/*     */ import javax.tools.JavaCompiler;
/*     */ import javax.tools.JavaFileManager;
/*     */ import javax.tools.JavaFileObject;
/*     */ import javax.tools.SimpleJavaFileObject;
/*     */ import javax.tools.StandardJavaFileManager;
/*     */ import javax.tools.ToolProvider;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
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
/*     */ public class SourceCompiler
/*     */ {
/*     */   static final JavaCompiler JAVA_COMPILER;
/*     */   private static final Class<?> JAVAC_SUN;
/*  55 */   private static final String COMPILE_DIR = Utils.getProperty("java.io.tmpdir", ".");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   final HashMap<String, String> sources = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   final HashMap<String, Class<?>> compiled = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   boolean useJavaSystemCompiler = SysProperties.JAVA_SYSTEM_COMPILER;
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  76 */       javaCompiler = ToolProvider.getSystemJavaCompiler();
/*  77 */     } catch (Exception null) {
/*     */       
/*  79 */       javaCompiler = null;
/*     */     } 
/*  81 */     JAVA_COMPILER = javaCompiler;
/*     */     
/*     */     try {
/*  84 */       clazz = Class.forName("com.sun.tools.javac.Main");
/*  85 */     } catch (Exception exception) {
/*  86 */       clazz = null;
/*     */     } 
/*  88 */     JAVAC_SUN = clazz;
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/*     */     JavaCompiler javaCompiler;
/*     */     Class clazz;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSource(String paramString1, String paramString2) {
/*  99 */     this.sources.put(paramString1, paramString2);
/* 100 */     this.compiled.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJavaSystemCompiler(boolean paramBoolean) {
/* 109 */     this.useJavaSystemCompiler = paramBoolean;
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
/*     */   public Class<?> getClass(String paramString) throws ClassNotFoundException {
/* 121 */     Class<?> clazz = this.compiled.get(paramString);
/* 122 */     if (clazz != null) {
/* 123 */       return clazz;
/*     */     }
/* 125 */     String str = this.sources.get(paramString);
/* 126 */     if (isGroovySource(str)) {
/* 127 */       Class<?> clazz1 = GroovyCompiler.parseClass(str, paramString);
/* 128 */       this.compiled.put(paramString, clazz1);
/* 129 */       return clazz1;
/*     */     } 
/*     */     
/* 132 */     ClassLoader classLoader = new ClassLoader(getClass().getClassLoader())
/*     */       {
/*     */         public Class<?> findClass(String param1String) throws ClassNotFoundException
/*     */         {
/* 136 */           Class<?> clazz = SourceCompiler.this.compiled.get(param1String);
/* 137 */           if (clazz == null) {
/* 138 */             String str3, str1 = SourceCompiler.this.sources.get(param1String);
/* 139 */             String str2 = null;
/* 140 */             int i = param1String.lastIndexOf('.');
/*     */             
/* 142 */             if (i >= 0) {
/* 143 */               str2 = param1String.substring(0, i);
/* 144 */               str3 = param1String.substring(i + 1);
/*     */             } else {
/* 146 */               str3 = param1String;
/*     */             } 
/* 148 */             String str4 = SourceCompiler.getCompleteSourceCode(str2, str3, str1);
/* 149 */             if (SourceCompiler.JAVA_COMPILER != null && SourceCompiler.this.useJavaSystemCompiler) {
/* 150 */               clazz = SourceCompiler.this.javaxToolsJavac(str2, str3, str4);
/*     */             } else {
/* 152 */               byte[] arrayOfByte = SourceCompiler.this.javacCompile(str2, str3, str4);
/* 153 */               if (arrayOfByte == null) {
/* 154 */                 clazz = findSystemClass(param1String);
/*     */               } else {
/* 156 */                 clazz = defineClass(param1String, arrayOfByte, 0, arrayOfByte.length);
/*     */               } 
/*     */             } 
/* 159 */             SourceCompiler.this.compiled.put(param1String, clazz);
/*     */           } 
/* 161 */           return clazz;
/*     */         }
/*     */       };
/* 164 */     return classLoader.loadClass(paramString);
/*     */   }
/*     */   
/*     */   private static boolean isGroovySource(String paramString) {
/* 168 */     return (paramString.startsWith("//groovy") || paramString.startsWith("@groovy"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Method getMethod(String paramString) throws ClassNotFoundException {
/* 178 */     Class<?> clazz = getClass(paramString);
/* 179 */     Method[] arrayOfMethod = clazz.getDeclaredMethods();
/* 180 */     for (Method method : arrayOfMethod) {
/* 181 */       int i = method.getModifiers();
/* 182 */       if (Modifier.isPublic(i) && Modifier.isStatic(i)) {
/* 183 */         String str = method.getName();
/* 184 */         if (!str.startsWith("_") && !method.getName().equals("main")) {
/* 185 */           return method;
/*     */         }
/*     */       } 
/*     */     } 
/* 189 */     return null;
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
/*     */   byte[] javacCompile(String paramString1, String paramString2, String paramString3) {
/* 203 */     File file1 = new File(COMPILE_DIR);
/* 204 */     if (paramString1 != null) {
/* 205 */       file1 = new File(file1, paramString1.replace('.', '/'));
/* 206 */       FileUtils.createDirectories(file1.getAbsolutePath());
/*     */     } 
/* 208 */     File file2 = new File(file1, paramString2 + ".java");
/* 209 */     File file3 = new File(file1, paramString2 + ".class");
/*     */     try {
/* 211 */       OutputStream outputStream = FileUtils.newOutputStream(file2.getAbsolutePath(), false);
/* 212 */       Writer writer = IOUtils.getBufferedWriter(outputStream);
/* 213 */       file3.delete();
/* 214 */       writer.write(paramString3);
/* 215 */       writer.close();
/* 216 */       if (JAVAC_SUN != null) {
/* 217 */         javacSun(file2);
/*     */       } else {
/* 219 */         javacProcess(file2);
/*     */       } 
/* 221 */       byte[] arrayOfByte = new byte[(int)file3.length()];
/* 222 */       DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file3));
/* 223 */       dataInputStream.readFully(arrayOfByte);
/* 224 */       dataInputStream.close();
/* 225 */       return arrayOfByte;
/* 226 */     } catch (Exception exception) {
/* 227 */       throw DbException.convert(exception);
/*     */     } finally {
/* 229 */       file2.delete();
/* 230 */       file3.delete();
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
/*     */   static String getCompleteSourceCode(String paramString1, String paramString2, String paramString3) {
/* 245 */     if (paramString3.startsWith("package ")) {
/* 246 */       return paramString3;
/*     */     }
/* 248 */     StringBuilder stringBuilder = new StringBuilder();
/* 249 */     if (paramString1 != null) {
/* 250 */       stringBuilder.append("package ").append(paramString1).append(";\n");
/*     */     }
/* 252 */     int i = paramString3.indexOf("@CODE");
/* 253 */     String str = "import java.util.*;\nimport java.math.*;\nimport java.sql.*;\n";
/*     */ 
/*     */ 
/*     */     
/* 257 */     if (i >= 0) {
/* 258 */       str = paramString3.substring(0, i);
/* 259 */       paramString3 = paramString3.substring("@CODE".length() + i);
/*     */     } 
/* 261 */     stringBuilder.append(str);
/* 262 */     stringBuilder.append("public class ").append(paramString2).append(" {\n    public static ").append(paramString3).append("\n}\n");
/*     */ 
/*     */ 
/*     */     
/* 266 */     return stringBuilder.toString();
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
/*     */   Class<?> javaxToolsJavac(String paramString1, String paramString2, String paramString3) {
/* 278 */     String str1 = paramString1 + "." + paramString2;
/* 279 */     StringWriter stringWriter = new StringWriter();
/* 280 */     ClassFileManager classFileManager = new ClassFileManager(JAVA_COMPILER.getStandardFileManager(null, null, null));
/*     */ 
/*     */     
/* 283 */     ArrayList<StringJavaFileObject> arrayList = new ArrayList();
/* 284 */     arrayList.add(new StringJavaFileObject(str1, paramString3));
/*     */     
/* 286 */     synchronized (JAVA_COMPILER) {
/* 287 */       JAVA_COMPILER.getTask(stringWriter, classFileManager, null, null, null, (Iterable)arrayList).call();
/*     */     } 
/*     */     
/* 290 */     String str2 = stringWriter.toString();
/* 291 */     handleSyntaxError(str2);
/*     */     try {
/* 293 */       return classFileManager.getClassLoader(null).loadClass(str1);
/* 294 */     } catch (ClassNotFoundException classNotFoundException) {
/* 295 */       throw DbException.convert(classNotFoundException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void javacProcess(File paramFile) {
/* 300 */     exec(new String[] { "javac", "-sourcepath", COMPILE_DIR, "-d", COMPILE_DIR, "-encoding", "UTF-8", paramFile.getAbsolutePath() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int exec(String... paramVarArgs) {
/* 308 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 310 */       ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 315 */       processBuilder.environment().remove("JAVA_TOOL_OPTIONS");
/* 316 */       processBuilder.command(paramVarArgs);
/*     */       
/* 318 */       Process process = processBuilder.start();
/* 319 */       copyInThread(process.getInputStream(), byteArrayOutputStream);
/* 320 */       copyInThread(process.getErrorStream(), byteArrayOutputStream);
/* 321 */       process.waitFor();
/* 322 */       String str = new String(byteArrayOutputStream.toByteArray(), Constants.UTF8);
/* 323 */       handleSyntaxError(str);
/* 324 */       return process.exitValue();
/* 325 */     } catch (Exception exception) {
/* 326 */       throw DbException.convert(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void copyInThread(final InputStream in, final OutputStream out) {
/* 331 */     (new Task()
/*     */       {
/*     */         public void call() throws IOException {
/* 334 */           IOUtils.copy(in, out);
/*     */         }
/*     */       }).execute();
/*     */   }
/*     */   
/*     */   private static synchronized void javacSun(File paramFile) {
/* 340 */     PrintStream printStream1 = System.err;
/* 341 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 342 */     PrintStream printStream2 = new PrintStream(byteArrayOutputStream);
/*     */     try {
/* 344 */       System.setErr(printStream2);
/*     */       
/* 346 */       Method method = JAVAC_SUN.getMethod("compile", new Class[] { String[].class });
/* 347 */       Object object = JAVAC_SUN.newInstance();
/* 348 */       method.invoke(object, new Object[] { { "-sourcepath", COMPILE_DIR, "-d", COMPILE_DIR, "-encoding", "UTF-8", paramFile.getAbsolutePath() } });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 354 */       String str = new String(byteArrayOutputStream.toByteArray(), Constants.UTF8);
/* 355 */       handleSyntaxError(str);
/* 356 */     } catch (Exception exception) {
/* 357 */       throw DbException.convert(exception);
/*     */     } finally {
/* 359 */       System.setErr(printStream1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void handleSyntaxError(String paramString) {
/* 364 */     boolean bool = false;
/* 365 */     BufferedReader bufferedReader = new BufferedReader(new StringReader(paramString)); try {
/*     */       String str;
/* 367 */       while ((str = bufferedReader.readLine()) != null) {
/* 368 */         if (str.endsWith("warning"))
/*     */           continue; 
/* 370 */         if (str.startsWith("Note:") || str.startsWith("warning:")) {
/*     */           continue;
/*     */         }
/*     */         
/* 374 */         bool = true;
/*     */       }
/*     */     
/*     */     }
/* 378 */     catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */     
/* 382 */     if (bool) {
/* 383 */       paramString = StringUtils.replaceAll(paramString, COMPILE_DIR, "");
/* 384 */       throw DbException.get(42000, paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class GroovyCompiler
/*     */   {
/*     */     private static final Object LOADER;
/*     */ 
/*     */     
/*     */     private static final Throwable INIT_FAIL_EXCEPTION;
/*     */ 
/*     */     
/*     */     static {
/* 399 */       Object object = null;
/* 400 */       Exception exception = null;
/*     */       
/*     */       try {
/* 403 */         Class<?> clazz = Class.forName("org.codehaus.groovy.control.customizers.ImportCustomizer");
/*     */         
/* 405 */         Object object1 = Utils.newInstance("org.codehaus.groovy.control.customizers.ImportCustomizer", new Object[0]);
/*     */ 
/*     */         
/* 408 */         String[] arrayOfString = { "java.sql.Connection", "java.sql.Types", "java.sql.ResultSet", "groovy.sql.Sql", "org.h2.tools.SimpleResultSet" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 415 */         Utils.callMethod(object1, "addImports", new Object[] { arrayOfString });
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 420 */         Object object2 = Array.newInstance(clazz, 1);
/* 421 */         Array.set(object2, 0, object1);
/* 422 */         Object object3 = Utils.newInstance("org.codehaus.groovy.control.CompilerConfiguration", new Object[0]);
/*     */         
/* 424 */         Utils.callMethod(object3, "addCompilationCustomizers", new Object[] { object2 });
/*     */ 
/*     */         
/* 427 */         ClassLoader classLoader = GroovyCompiler.class.getClassLoader();
/* 428 */         object = Utils.newInstance("groovy.lang.GroovyClassLoader", new Object[] { classLoader, object3 });
/*     */       }
/* 430 */       catch (Exception exception1) {
/* 431 */         exception = exception1;
/*     */       } 
/* 433 */       LOADER = object;
/* 434 */       INIT_FAIL_EXCEPTION = exception;
/*     */     }
/*     */ 
/*     */     
/*     */     public static Class<?> parseClass(String param1String1, String param1String2) {
/* 439 */       if (LOADER == null) {
/* 440 */         throw new RuntimeException("Compile fail: no Groovy jar in the classpath", INIT_FAIL_EXCEPTION);
/*     */       }
/*     */       
/*     */       try {
/* 444 */         Object object = Utils.newInstance("groovy.lang.GroovyCodeSource", new Object[] { param1String1, param1String2 + ".groovy", "UTF-8" });
/*     */         
/* 446 */         Utils.callMethod(object, "setCachable", new Object[] { Boolean.valueOf(false) });
/* 447 */         return (Class)Utils.callMethod(LOADER, "parseClass", new Object[] { object });
/*     */       
/*     */       }
/* 450 */       catch (Exception exception) {
/* 451 */         throw new RuntimeException(exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class StringJavaFileObject
/*     */     extends SimpleJavaFileObject
/*     */   {
/*     */     private final String sourceCode;
/*     */ 
/*     */     
/*     */     public StringJavaFileObject(String param1String1, String param1String2) {
/* 464 */       super(URI.create("string:///" + param1String1.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
/*     */       
/* 466 */       this.sourceCode = param1String2;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getCharContent(boolean param1Boolean) {
/* 471 */       return this.sourceCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class JavaClassObject
/*     */     extends SimpleJavaFileObject
/*     */   {
/* 481 */     private final ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */     
/*     */     public JavaClassObject(String param1String, JavaFileObject.Kind param1Kind) {
/* 484 */       super(URI.create("string:///" + param1String.replace('.', '/') + param1Kind.extension), param1Kind);
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] getBytes() {
/* 489 */       return this.out.toByteArray();
/*     */     }
/*     */ 
/*     */     
/*     */     public OutputStream openOutputStream() throws IOException {
/* 494 */       return this.out;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class ClassFileManager
/*     */     extends ForwardingJavaFileManager<StandardJavaFileManager>
/*     */   {
/*     */     SourceCompiler.JavaClassObject classObject;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ClassFileManager(StandardJavaFileManager param1StandardJavaFileManager) {
/* 510 */       super(param1StandardJavaFileManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public ClassLoader getClassLoader(JavaFileManager.Location param1Location) {
/* 515 */       return new SecureClassLoader()
/*     */         {
/*     */           protected Class<?> findClass(String param2String) throws ClassNotFoundException
/*     */           {
/* 519 */             byte[] arrayOfByte = SourceCompiler.ClassFileManager.this.classObject.getBytes();
/* 520 */             return defineClass(param2String, arrayOfByte, 0, arrayOfByte.length);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public JavaFileObject getJavaFileForOutput(JavaFileManager.Location param1Location, String param1String, JavaFileObject.Kind param1Kind, FileObject param1FileObject) throws IOException {
/* 529 */       this.classObject = new SourceCompiler.JavaClassObject(param1String, param1Kind);
/* 530 */       return this.classObject;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\SourceCompiler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */