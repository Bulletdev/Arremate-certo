/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.security.AccessController;
/*     */ import java.security.CodeSource;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Vector;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.regex.Pattern;
/*     */ import junit.b.j;
/*     */ import org.junit.c.k;
/*     */ import org.junit.m;
/*     */ import org.junit.runner.JUnitCore;
/*     */ import org.junit.runner.b.b;
/*     */ import org.junit.runner.k;
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
/*     */ public final class OOXMLLite
/*     */ {
/*     */   private File _destDest;
/*     */   private File _testDir;
/*     */   private File _ooxmlJar;
/*     */   
/*     */   OOXMLLite(String paramString1, String paramString2, String paramString3) {
/*  73 */     this._destDest = new File(paramString1);
/*  74 */     this._testDir = new File(paramString2);
/*  75 */     this._ooxmlJar = new File(paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException, ClassNotFoundException {
/*  80 */     String str1 = null, str2 = null, str3 = null;
/*     */     
/*  82 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  83 */       if (paramArrayOfString[b].equals("-dest")) { str1 = paramArrayOfString[++b]; }
/*  84 */       else if (paramArrayOfString[b].equals("-test")) { str2 = paramArrayOfString[++b]; }
/*  85 */       else if (paramArrayOfString[b].equals("-ooxml")) { str3 = paramArrayOfString[++b]; }
/*     */     
/*  87 */     }  OOXMLLite oOXMLLite = new OOXMLLite(str1, str2, str3);
/*  88 */     oOXMLLite.build();
/*     */   }
/*     */   
/*     */   void build() throws IOException, ClassNotFoundException {
/*  92 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*     */     
/*  94 */     String str = StringUtil.join("|", new Object[] { "BaseTestXWorkbook", "BaseTestXSheet", "BaseTestXRow", "BaseTestXCell", "TestSXSSFWorkbook\\$\\d", "TestSXSSFWorkbook\\$NullOutputStream", "TestUnfixedBugs", "MemoryUsage", "TestDataProvider", "TestDataSamples", "All.+Tests", "ZipFileAssert", "PkiTestUtils", "TestCellFormatPart\\$\\d", "TestSignatureInfo\\$\\d", "TestCertificateEncryption\\$CertData", "TestPOIXMLDocument\\$OPCParser", "TestPOIXMLDocument\\$TestFactory", "TestXSLFTextParagraph\\$DrawTextParagraphProxy", "TestXSSFExportToXML\\$\\d", "TestXSSFExportToXML\\$DummyEntityResolver", "TestFormulaEvaluatorOnXSSF\\$Result", "TestFormulaEvaluatorOnXSSF\\$SS", "TestMultiSheetFormulaEvaluatorOnXSSF\\$Result", "TestMultiSheetFormulaEvaluatorOnXSSF\\$SS", "TestXSSFBugs\\$\\d" });
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
/* 122 */     System.out.println("Collecting unit tests from " + this._testDir);
/* 123 */     collectTests(this._testDir, this._testDir, arrayList, ".+.class$", ".+(" + str + ").class");
/* 124 */     System.out.println("Found " + arrayList.size() + " classes");
/*     */ 
/*     */     
/* 127 */     JUnitCore jUnitCore = new JUnitCore();
/* 128 */     jUnitCore.a((b)new k(System.out));
/* 129 */     k k = jUnitCore.b((Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[arrayList.size()]));
/* 130 */     if (!k.er()) {
/* 131 */       throw new RuntimeException("Tests did not succeed, cannot build ooxml-lite jar");
/*     */     }
/*     */ 
/*     */     
/* 135 */     System.out.println("Copying classes to " + this._destDest);
/* 136 */     Map<String, Class<?>> map = getLoadedClasses(this._ooxmlJar.getName());
/* 137 */     for (Class<?> clazz : map.values()) {
/* 138 */       String str1 = clazz.getName();
/* 139 */       String str2 = str1.replace('.', '/') + ".class";
/* 140 */       File file = new File(this._destDest, str2);
/* 141 */       copyFile(clazz.getResourceAsStream('/' + str2), file);
/*     */       
/* 143 */       if (clazz.isInterface())
/*     */       {
/*     */ 
/*     */         
/* 147 */         for (Class<?> clazz1 : clazz.getDeclaredClasses()) {
/* 148 */           str1 = clazz1.getName();
/* 149 */           str2 = str1.replace('.', '/') + ".class";
/* 150 */           file = new File(this._destDest, str2);
/* 151 */           copyFile(clazz1.getResourceAsStream('/' + str2), file);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 157 */     System.out.println("Copying .xsb resources");
/* 158 */     JarFile jarFile = new JarFile(this._ooxmlJar);
/* 159 */     Pattern pattern = Pattern.compile("schemaorg_apache_xmlbeans/(system|element)/.*\\.xsb");
/*     */     try {
/* 161 */       for (Enumeration<JarEntry> enumeration = jarFile.entries(); enumeration.hasMoreElements(); ) {
/* 162 */         JarEntry jarEntry = enumeration.nextElement();
/* 163 */         if (pattern.matcher(jarEntry.getName()).matches()) {
/* 164 */           File file = new File(this._destDest, jarEntry.getName());
/* 165 */           copyFile(jarFile.getInputStream(jarEntry), file);
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 169 */       jarFile.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean checkForTestAnnotation(Class<?> paramClass) {
/* 174 */     for (Method method : paramClass.getDeclaredMethods()) {
/* 175 */       if (method.isAnnotationPresent((Class)m.class)) {
/* 176 */         return true;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 181 */     if (paramClass.getSuperclass() != null) {
/* 182 */       for (Method method : paramClass.getSuperclass().getDeclaredMethods()) {
/* 183 */         if (method.isAnnotationPresent((Class)m.class)) {
/* 184 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 189 */     System.out.println("Class " + paramClass.getName() + " does not derive from TestCase and does not have a @Test annotation");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     return false;
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
/*     */   private static void collectTests(File paramFile1, File paramFile2, List<Class<?>> paramList, String paramString1, String paramString2) throws ClassNotFoundException {
/* 207 */     if (paramFile2.isDirectory()) {
/* 208 */       for (File file : paramFile2.listFiles()) {
/* 209 */         collectTests(paramFile1, file, paramList, paramString1, paramString2);
/*     */       }
/*     */     } else {
/* 212 */       String str1 = paramFile2.getAbsolutePath();
/* 213 */       String str2 = paramFile1.getAbsolutePath();
/* 214 */       String str3 = str1.substring(str2.length() + 1).replace(File.separator, ".");
/* 215 */       if (!str3.matches(paramString1))
/* 216 */         return;  if (str3.matches(paramString2))
/*     */         return; 
/* 218 */       if (str3.indexOf('$') != -1) {
/* 219 */         System.out.println("Inner class " + str3 + " not included");
/*     */         
/*     */         return;
/*     */       } 
/* 223 */       str3 = str3.replace(".class", "");
/*     */       
/* 225 */       Class<?> clazz = Class.forName(str3);
/* 226 */       if (j.class.isAssignableFrom(clazz) || checkForTestAnnotation(clazz))
/*     */       {
/* 228 */         paramList.add(clazz);
/*     */       }
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
/*     */   private static Map<String, Class<?>> getLoadedClasses(String paramString) {
/* 243 */     Field field = AccessController.<Field>doPrivileged(new PrivilegedAction<Field>() {
/*     */           @SuppressForbidden("TODO: Reflection works until Java 8 on Oracle/Sun JDKs, but breaks afterwards (different classloader types, access checks)")
/*     */           public Field run() {
/*     */             try {
/* 247 */               Field field = ClassLoader.class.getDeclaredField("classes");
/* 248 */               field.setAccessible(true);
/* 249 */               return field;
/* 250 */             } catch (Exception exception) {
/* 251 */               throw new RuntimeException(exception);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 257 */     ClassLoader classLoader = ClassLoader.getSystemClassLoader();
/*     */     try {
/* 259 */       Vector vector = (Vector)field.get(classLoader);
/* 260 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 261 */       for (Class clazz : vector) {
/*     */         
/* 263 */         ProtectionDomain protectionDomain = clazz.getProtectionDomain();
/* 264 */         if (protectionDomain == null)
/* 265 */           continue;  CodeSource codeSource = protectionDomain.getCodeSource();
/* 266 */         if (codeSource == null)
/* 267 */           continue;  URL uRL = codeSource.getLocation();
/* 268 */         if (uRL == null)
/*     */           continue; 
/* 270 */         String str = uRL.toString();
/* 271 */         if (str.indexOf(paramString) != -1) hashMap.put(clazz.getName(), clazz); 
/*     */       } 
/* 273 */       return (Map)hashMap;
/* 274 */     } catch (IllegalAccessException illegalAccessException) {
/* 275 */       throw new RuntimeException(illegalAccessException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void copyFile(InputStream paramInputStream, File paramFile) throws IOException {
/* 280 */     File file = paramFile.getParentFile();
/* 281 */     if (!file.exists() && !file.mkdirs()) {
/* 282 */       throw new RuntimeException("Can't create destination directory: " + file);
/*     */     }
/*     */     
/* 285 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/*     */     try {
/* 287 */       IOUtils.copy(paramInputStream, fileOutputStream);
/*     */     } finally {
/* 289 */       fileOutputStream.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\OOXMLLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */