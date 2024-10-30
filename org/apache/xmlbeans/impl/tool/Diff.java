/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.apache.xmlbeans.SystemProperties;
/*     */ import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Diff
/*     */ {
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*  34 */     if (paramArrayOfString.length != 2) {
/*     */       
/*  36 */       System.out.println("Usage: diff <jarname1> <jarname2> to compare two jars");
/*  37 */       System.out.println("  or   diff <dirname1> <dirname2> to compare two dirs");
/*     */       return;
/*     */     } 
/*  40 */     File file1 = new File(paramArrayOfString[0]);
/*  41 */     if (!file1.exists()) {
/*     */       
/*  43 */       System.out.println("File \"" + paramArrayOfString[0] + "\" not found.");
/*     */       return;
/*     */     } 
/*  46 */     File file2 = new File(paramArrayOfString[1]);
/*  47 */     if (!file2.exists()) {
/*     */       
/*  49 */       System.out.println("File \"" + paramArrayOfString[1] + "\" not found.");
/*     */       return;
/*     */     } 
/*  52 */     ArrayList arrayList = new ArrayList();
/*  53 */     if (file1.isDirectory()) {
/*     */       
/*  55 */       if (!file2.isDirectory()) {
/*     */         
/*  57 */         System.out.println("Both parameters have to be directories if the first parameter is a directory.");
/*     */         return;
/*     */       } 
/*  60 */       dirsAsTypeSystems(file1, file2, arrayList);
/*     */     }
/*     */     else {
/*     */       
/*  64 */       if (file2.isDirectory()) {
/*     */         
/*  66 */         System.out.println("Both parameters have to be jar files if the first parameter is a jar file.");
/*     */         
/*     */         return;
/*     */       } 
/*     */       try {
/*  71 */         JarFile jarFile1 = new JarFile(file1);
/*  72 */         JarFile jarFile2 = new JarFile(file2);
/*  73 */         jarsAsTypeSystems(jarFile1, jarFile2, arrayList);
/*     */       }
/*  75 */       catch (IOException iOException) {
/*  76 */         iOException.printStackTrace();
/*     */       } 
/*  78 */     }  if (arrayList.size() < 1) {
/*  79 */       System.out.println("No differences encountered.");
/*     */     } else {
/*     */       
/*  82 */       System.out.println("Differences:");
/*  83 */       for (byte b = 0; b < arrayList.size(); b++) {
/*  84 */         System.out.println(arrayList.get(b).toString());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void jarsAsTypeSystems(JarFile paramJarFile1, JarFile paramJarFile2, List paramList) {
/*  94 */     Enumeration enumeration1 = paramJarFile1.entries();
/*  95 */     Enumeration enumeration2 = paramJarFile2.entries();
/*  96 */     ArrayList arrayList1 = new ArrayList();
/*  97 */     ArrayList arrayList2 = new ArrayList();
/*  98 */     while (enumeration1.hasMoreElements()) {
/*     */       
/* 100 */       ZipEntry zipEntry = enumeration1.nextElement();
/* 101 */       String str = zipEntry.getName();
/* 102 */       if (str.startsWith("schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system/s") && str.endsWith(".xsb"))
/* 103 */         arrayList1.add(zipEntry); 
/*     */     } 
/* 105 */     while (enumeration2.hasMoreElements()) {
/*     */       
/* 107 */       ZipEntry zipEntry = enumeration2.nextElement();
/* 108 */       String str = zipEntry.getName();
/* 109 */       if (str.startsWith("schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system/s") && str.endsWith(".xsb"))
/* 110 */         arrayList2.add(zipEntry); 
/*     */     } 
/* 112 */     ZipEntry[] arrayOfZipEntry1 = arrayList1.<ZipEntry>toArray(new ZipEntry[arrayList1.size()]);
/* 113 */     ZipEntry[] arrayOfZipEntry2 = arrayList2.<ZipEntry>toArray(new ZipEntry[arrayList2.size()]);
/* 114 */     ZipEntryNameComparator zipEntryNameComparator = new ZipEntryNameComparator();
/* 115 */     Arrays.sort(arrayOfZipEntry1, zipEntryNameComparator);
/* 116 */     Arrays.sort(arrayOfZipEntry2, zipEntryNameComparator);
/* 117 */     byte b1 = 0;
/* 118 */     byte b2 = 0;
/* 119 */     while (b1 < arrayOfZipEntry1.length && b2 < arrayOfZipEntry2.length) {
/*     */       
/* 121 */       String str1 = arrayOfZipEntry1[b1].getName();
/* 122 */       String str2 = arrayOfZipEntry2[b2].getName();
/* 123 */       int i = str1.compareTo(str2);
/* 124 */       if (i == 0) {
/*     */ 
/*     */         
/* 127 */         zipEntriesAsXsb(arrayOfZipEntry1[b1], paramJarFile1, arrayOfZipEntry2[b2], paramJarFile2, paramList);
/* 128 */         b1++; b2++; continue;
/*     */       } 
/* 130 */       if (i < 0) {
/*     */ 
/*     */         
/* 133 */         paramList.add("Jar \"" + paramJarFile1.getName() + "\" contains an extra file: \"" + str1 + "\"");
/*     */         
/* 135 */         b1++; continue;
/*     */       } 
/* 137 */       if (i > 0) {
/*     */ 
/*     */         
/* 140 */         paramList.add("Jar \"" + paramJarFile2.getName() + "\" contains an extra file: \"" + str2 + "\"");
/*     */         
/* 142 */         b2++;
/*     */       } 
/*     */     } 
/* 145 */     while (b1 < arrayOfZipEntry1.length) {
/*     */       
/* 147 */       paramList.add("Jar \"" + paramJarFile1.getName() + "\" contains an extra file: \"" + arrayOfZipEntry1[b1].getName() + "\"");
/*     */       
/* 149 */       b1++;
/*     */     } 
/* 151 */     while (b2 < arrayOfZipEntry2.length) {
/*     */       
/* 153 */       paramList.add("Jar \"" + paramJarFile2.getName() + "\" contains an extra file: \"" + arrayOfZipEntry2[b2].getName() + "\"");
/*     */       
/* 155 */       b2++;
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
/*     */   public static void dirsAsTypeSystems(File paramFile1, File paramFile2, List paramList) {
/* 167 */     assert paramFile1.isDirectory() : "Parameters must be directories";
/* 168 */     assert paramFile2.isDirectory() : "Parameters must be directories";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     File file1 = new File(paramFile1, "schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system");
/* 175 */     File file2 = new File(paramFile2, "schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system");
/* 176 */     if (file1.exists() && file2.exists()) {
/*     */       
/* 178 */       File[] arrayOfFile3 = file1.listFiles();
/* 179 */       File[] arrayOfFile4 = file2.listFiles();
/* 180 */       if (arrayOfFile3.length == 1 && arrayOfFile4.length == 1) {
/*     */         
/* 182 */         file1 = arrayOfFile3[0];
/* 183 */         file2 = arrayOfFile4[0];
/*     */       }
/*     */       else {
/*     */         
/* 187 */         if (arrayOfFile3.length == 0)
/* 188 */           file1 = null; 
/* 189 */         if (arrayOfFile4.length == 0)
/* 190 */           file2 = null; 
/* 191 */         if (arrayOfFile3.length > 1) {
/*     */           
/* 193 */           paramList.add("More than one typesystem found in dir \"" + paramFile1.getName() + "\"");
/*     */           
/*     */           return;
/*     */         } 
/* 197 */         if (arrayOfFile4.length > 1) {
/*     */           
/* 199 */           paramList.add("More than one typesystem found in dir \"" + paramFile2.getName() + "\"");
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 207 */       if (!file1.exists())
/* 208 */         file1 = null; 
/* 209 */       if (!file2.exists())
/* 210 */         file2 = null; 
/*     */     } 
/* 212 */     if (file1 == null && file2 == null)
/*     */       return; 
/* 214 */     if (file1 == null || file2 == null) {
/*     */       
/* 216 */       if (file1 == null)
/* 217 */         paramList.add("No typesystems found in dir \"" + paramFile1 + "\""); 
/* 218 */       if (file2 == null) {
/* 219 */         paramList.add("No typesystems found in dir \"" + paramFile2 + "\"");
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 224 */     paramFile1 = file1;
/* 225 */     paramFile2 = file2;
/*     */ 
/*     */     
/* 228 */     boolean bool = isDiffIndex();
/* 229 */     XsbFilenameFilter xsbFilenameFilter = new XsbFilenameFilter();
/* 230 */     File[] arrayOfFile1 = paramFile1.listFiles(xsbFilenameFilter);
/* 231 */     File[] arrayOfFile2 = paramFile2.listFiles(xsbFilenameFilter);
/* 232 */     FileNameComparator fileNameComparator = new FileNameComparator();
/* 233 */     Arrays.sort(arrayOfFile1, fileNameComparator);
/* 234 */     Arrays.sort(arrayOfFile2, fileNameComparator);
/* 235 */     byte b1 = 0;
/* 236 */     byte b2 = 0;
/* 237 */     while (b1 < arrayOfFile1.length && b2 < arrayOfFile2.length) {
/*     */       
/* 239 */       String str1 = arrayOfFile1[b1].getName();
/* 240 */       String str2 = arrayOfFile2[b2].getName();
/* 241 */       int i = str1.compareTo(str2);
/* 242 */       if (i == 0) {
/*     */         
/* 244 */         if (bool || !arrayOfFile1[b1].getName().equals("index.xsb"))
/* 245 */           filesAsXsb(arrayOfFile1[b1], arrayOfFile2[b2], paramList); 
/* 246 */         b1++; b2++; continue;
/*     */       } 
/* 248 */       if (i < 0) {
/*     */ 
/*     */         
/* 251 */         paramList.add("Dir \"" + paramFile1.getName() + "\" contains an extra file: \"" + str1 + "\"");
/*     */         
/* 253 */         b1++; continue;
/*     */       } 
/* 255 */       if (i > 0) {
/*     */ 
/*     */         
/* 258 */         paramList.add("Dir \"" + paramFile2.getName() + "\" contains an extra file: \"" + str2 + "\"");
/*     */         
/* 260 */         b2++;
/*     */       } 
/*     */     } 
/* 263 */     while (b1 < arrayOfFile1.length) {
/*     */       
/* 265 */       paramList.add("Dir \"" + paramFile1.getName() + "\" contains an extra file: \"" + arrayOfFile1[b1].getName() + "\"");
/*     */       
/* 267 */       b1++;
/*     */     } 
/* 269 */     while (b2 < arrayOfFile2.length) {
/*     */       
/* 271 */       paramList.add("Dir \"" + paramFile2.getName() + "\" contains an extra file: \"" + arrayOfFile2[b2].getName() + "\"");
/*     */       
/* 273 */       b2++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isDiffIndex() {
/* 279 */     String str = SystemProperties.getProperty("xmlbeans.diff.diffIndex");
/* 280 */     if (str == null)
/* 281 */       return true; 
/* 282 */     if ("0".equals(str) || "false".equalsIgnoreCase(str))
/* 283 */       return false; 
/* 284 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void filesAsXsb(File paramFile1, File paramFile2, List paramList) {
/* 293 */     assert paramFile1.exists() : "File \"" + paramFile1.getAbsolutePath() + "\" does not exist.";
/* 294 */     assert paramFile2.exists() : "File \"" + paramFile2.getAbsolutePath() + "\" does not exist.";
/*     */     
/*     */     try {
/* 297 */       FileInputStream fileInputStream1 = new FileInputStream(paramFile1);
/* 298 */       FileInputStream fileInputStream2 = new FileInputStream(paramFile2);
/* 299 */       streamsAsXsb(fileInputStream1, paramFile1.getName(), fileInputStream2, paramFile2.getName(), paramList);
/*     */     }
/* 301 */     catch (FileNotFoundException fileNotFoundException) {
/*     */     
/* 303 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void zipEntriesAsXsb(ZipEntry paramZipEntry1, JarFile paramJarFile1, ZipEntry paramZipEntry2, JarFile paramJarFile2, List paramList) {
/*     */     try {
/* 312 */       InputStream inputStream1 = paramJarFile1.getInputStream(paramZipEntry1);
/* 313 */       InputStream inputStream2 = paramJarFile2.getInputStream(paramZipEntry2);
/* 314 */       streamsAsXsb(inputStream1, paramZipEntry1.getName(), inputStream2, paramZipEntry2.getName(), paramList);
/*     */     }
/* 316 */     catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void streamsAsXsb(InputStream paramInputStream1, String paramString1, InputStream paramInputStream2, String paramString2, List paramList) throws IOException {
/* 324 */     ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
/* 325 */     ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
/* 326 */     XsbDumper.dump(paramInputStream1, "", new PrintStream(byteArrayOutputStream1));
/* 327 */     XsbDumper.dump(paramInputStream2, "", new PrintStream(byteArrayOutputStream2));
/* 328 */     paramInputStream1.close();
/* 329 */     paramInputStream2.close();
/* 330 */     readersAsText(new StringReader(byteArrayOutputStream1.toString()), paramString1, new StringReader(byteArrayOutputStream2.toString()), paramString2, paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void readersAsText(Reader paramReader1, String paramString1, Reader paramReader2, String paramString2, List paramList) throws IOException {
/* 338 */     org.apache.xmlbeans.impl.util.Diff.readersAsText(paramReader1, paramString1, paramReader2, paramString2, paramList);
/*     */   }
/*     */   
/*     */   private static class XsbFilenameFilter implements FilenameFilter {
/*     */     private XsbFilenameFilter() {}
/*     */     
/*     */     public boolean accept(File param1File, String param1String) {
/* 345 */       return param1String.endsWith(".xsb");
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ZipEntryNameComparator implements Comparator {
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 353 */       return (this == param1Object);
/*     */     }
/*     */     private ZipEntryNameComparator() {}
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 358 */       assert param1Object1 instanceof ZipEntry : "Must pass in a java.util.zip.ZipEntry as argument";
/* 359 */       assert param1Object2 instanceof ZipEntry : "Must pass in a java.util.zip.ZipEntry as argument";
/*     */       
/* 361 */       String str1 = ((ZipEntry)param1Object1).getName();
/* 362 */       String str2 = ((ZipEntry)param1Object2).getName();
/* 363 */       return str1.compareTo(str2);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class FileNameComparator implements Comparator {
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 371 */       return (this == param1Object);
/*     */     }
/*     */     private FileNameComparator() {}
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 376 */       assert param1Object1 instanceof File : "Must pass in a java.io.File as argument";
/* 377 */       assert param1Object2 instanceof File : "Must pass in a java.io.File as argument";
/*     */       
/* 379 */       String str1 = ((File)param1Object1).getName();
/* 380 */       String str2 = ((File)param1Object2).getName();
/* 381 */       return str1.compareTo(str2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\Diff.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */