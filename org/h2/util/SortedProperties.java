/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.LineNumberReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.TreeMap;
/*     */ import java.util.Vector;
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
/*     */ public class SortedProperties
/*     */   extends Properties
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public synchronized Enumeration<Object> keys() {
/*  36 */     Vector<String> vector = new Vector();
/*  37 */     for (Object object : keySet()) {
/*  38 */       vector.add(object.toString());
/*     */     }
/*  40 */     Collections.sort(vector);
/*  41 */     return (new Vector(vector)).elements();
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
/*     */   public static boolean getBooleanProperty(Properties paramProperties, String paramString, boolean paramBoolean) {
/*  54 */     String str = paramProperties.getProperty(paramString, "" + paramBoolean);
/*     */     try {
/*  56 */       return Boolean.parseBoolean(str);
/*  57 */     } catch (Exception exception) {
/*  58 */       exception.printStackTrace();
/*  59 */       return paramBoolean;
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
/*     */   public static int getIntProperty(Properties paramProperties, String paramString, int paramInt) {
/*  72 */     String str = paramProperties.getProperty(paramString, "" + paramInt);
/*     */     try {
/*  74 */       return Integer.decode(str).intValue();
/*  75 */     } catch (Exception exception) {
/*  76 */       exception.printStackTrace();
/*  77 */       return paramInt;
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
/*     */   public static synchronized SortedProperties loadProperties(String paramString) throws IOException {
/*  89 */     SortedProperties sortedProperties = new SortedProperties();
/*  90 */     if (FileUtils.exists(paramString)) {
/*  91 */       try (InputStream null = FileUtils.newInputStream(paramString)) {
/*  92 */         sortedProperties.load(inputStream);
/*     */       } 
/*     */     }
/*  95 */     return sortedProperties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void store(String paramString) throws IOException {
/*     */     OutputStreamWriter outputStreamWriter;
/* 104 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 105 */     store(byteArrayOutputStream, (String)null);
/* 106 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/* 107 */     InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream, "ISO8859-1");
/* 108 */     LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
/*     */     
/*     */     try {
/* 111 */       outputStreamWriter = new OutputStreamWriter(FileUtils.newOutputStream(paramString, false));
/* 112 */     } catch (Exception exception) {
/* 113 */       throw new IOException(exception.toString(), exception);
/*     */     } 
/* 115 */     PrintWriter printWriter = new PrintWriter(new BufferedWriter(outputStreamWriter));
/*     */     while (true) {
/* 117 */       String str = lineNumberReader.readLine();
/* 118 */       if (str == null) {
/*     */         break;
/*     */       }
/* 121 */       if (!str.startsWith("#")) {
/* 122 */         printWriter.print(str + "\n");
/*     */       }
/*     */     } 
/* 125 */     printWriter.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized String toLines() {
/* 134 */     StringBuilder stringBuilder = new StringBuilder();
/* 135 */     for (Map.Entry<?, ?> entry : (new TreeMap<>(this)).entrySet()) {
/* 136 */       stringBuilder.append(entry.getKey()).append('=').append(entry.getValue()).append('\n');
/*     */     }
/* 138 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SortedProperties fromLines(String paramString) {
/* 148 */     SortedProperties sortedProperties = new SortedProperties();
/* 149 */     for (String str : StringUtils.arraySplit(paramString, '\n', true)) {
/* 150 */       int i = str.indexOf('=');
/* 151 */       if (i > 0) {
/* 152 */         sortedProperties.put(str.substring(0, i), str.substring(i + 1));
/*     */       }
/*     */     } 
/* 155 */     return sortedProperties;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\SortedProperties.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */