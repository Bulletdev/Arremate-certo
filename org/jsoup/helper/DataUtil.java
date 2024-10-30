/*     */ package org.jsoup.helper;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.IllegalCharsetNameException;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.parser.Parser;
/*     */ 
/*     */ public class DataUtil
/*     */ {
/*  20 */   private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final String defaultCharset = "UTF-8";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int bufferSize = 131072;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document load(File paramFile, String paramString1, String paramString2) throws IOException {
/*  35 */     ByteBuffer byteBuffer = readFileToByteBuffer(paramFile);
/*  36 */     return parseByteData(byteBuffer, paramString1, paramString2, Parser.htmlParser());
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
/*     */   public static Document load(InputStream paramInputStream, String paramString1, String paramString2) throws IOException {
/*  48 */     ByteBuffer byteBuffer = readToByteBuffer(paramInputStream);
/*  49 */     return parseByteData(byteBuffer, paramString1, paramString2, Parser.htmlParser());
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
/*     */   public static Document load(InputStream paramInputStream, String paramString1, String paramString2, Parser paramParser) throws IOException {
/*  62 */     ByteBuffer byteBuffer = readToByteBuffer(paramInputStream);
/*  63 */     return parseByteData(byteBuffer, paramString1, paramString2, paramParser);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Document parseByteData(ByteBuffer paramByteBuffer, String paramString1, String paramString2, Parser paramParser) {
/*     */     String str;
/*  71 */     Document document = null;
/*  72 */     if (paramString1 == null) {
/*     */       
/*  74 */       str = Charset.forName("UTF-8").decode(paramByteBuffer).toString();
/*  75 */       document = paramParser.parseInput(str, paramString2);
/*  76 */       Element element = document.select("meta[http-equiv=content-type], meta[charset]").first();
/*  77 */       if (element != null) {
/*     */         String str1;
/*  79 */         if (element.hasAttr("http-equiv")) {
/*  80 */           str1 = getCharsetFromContentType(element.attr("content"));
/*  81 */           if (str1 == null && element.hasAttr("charset")) {
/*     */             try {
/*  83 */               if (Charset.isSupported(element.attr("charset"))) {
/*  84 */                 str1 = element.attr("charset");
/*     */               }
/*  86 */             } catch (IllegalCharsetNameException illegalCharsetNameException) {
/*  87 */               str1 = null;
/*     */             } 
/*     */           }
/*     */         } else {
/*  91 */           str1 = element.attr("charset");
/*     */         } 
/*     */         
/*  94 */         if (str1 != null && str1.length() != 0 && !str1.equals("UTF-8")) {
/*  95 */           str1 = str1.trim().replaceAll("[\"']", "");
/*  96 */           paramString1 = str1;
/*  97 */           paramByteBuffer.rewind();
/*  98 */           str = Charset.forName(str1).decode(paramByteBuffer).toString();
/*  99 */           document = null;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 103 */       Validate.notEmpty(paramString1, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
/* 104 */       str = Charset.forName(paramString1).decode(paramByteBuffer).toString();
/*     */     } 
/*     */     
/* 107 */     if (str.length() > 0 && str.charAt(0) == '﻿') {
/* 108 */       paramByteBuffer.rewind();
/* 109 */       str = Charset.forName("UTF-8").decode(paramByteBuffer).toString();
/* 110 */       str = str.substring(1);
/* 111 */       paramString1 = "UTF-8";
/* 112 */       document = null;
/*     */     } 
/* 114 */     if (document == null) {
/* 115 */       document = paramParser.parseInput(str, paramString2);
/* 116 */       document.outputSettings().charset(paramString1);
/*     */     } 
/* 118 */     return document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static ByteBuffer readToByteBuffer(InputStream paramInputStream, int paramInt) throws IOException {
/* 129 */     Validate.isTrue((paramInt >= 0), "maxSize must be 0 (unlimited) or larger");
/* 130 */     boolean bool = (paramInt > 0) ? true : false;
/* 131 */     byte[] arrayOfByte = new byte[131072];
/* 132 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(131072);
/*     */     
/* 134 */     int i = paramInt;
/*     */     
/*     */     while (true) {
/* 137 */       int j = paramInputStream.read(arrayOfByte);
/* 138 */       if (j == -1)
/* 139 */         break;  if (bool) {
/* 140 */         if (j > i) {
/* 141 */           byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */           break;
/*     */         } 
/* 144 */         i -= j;
/*     */       } 
/* 146 */       byteArrayOutputStream.write(arrayOfByte, 0, j);
/*     */     } 
/* 148 */     return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
/*     */   }
/*     */ 
/*     */   
/*     */   static ByteBuffer readToByteBuffer(InputStream paramInputStream) throws IOException {
/* 153 */     return readToByteBuffer(paramInputStream, 0);
/*     */   }
/*     */   
/*     */   static ByteBuffer readFileToByteBuffer(File paramFile) throws IOException {
/* 157 */     RandomAccessFile randomAccessFile = null;
/*     */     try {
/* 159 */       randomAccessFile = new RandomAccessFile(paramFile, "r");
/* 160 */       byte[] arrayOfByte = new byte[(int)randomAccessFile.length()];
/* 161 */       randomAccessFile.readFully(arrayOfByte);
/* 162 */       return ByteBuffer.wrap(arrayOfByte);
/*     */     } finally {
/* 164 */       if (randomAccessFile != null) {
/* 165 */         randomAccessFile.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getCharsetFromContentType(String paramString) {
/* 176 */     if (paramString == null) return null; 
/* 177 */     Matcher matcher = charsetPattern.matcher(paramString);
/* 178 */     if (matcher.find()) {
/* 179 */       String str = matcher.group(1).trim();
/* 180 */       str = str.replace("charset=", "");
/* 181 */       if (str.length() == 0) return null; 
/*     */       try {
/* 183 */         if (Charset.isSupported(str)) return str; 
/* 184 */         str = str.toUpperCase(Locale.ENGLISH);
/* 185 */         if (Charset.isSupported(str)) return str; 
/* 186 */       } catch (IllegalCharsetNameException illegalCharsetNameException) {
/*     */         
/* 188 */         return null;
/*     */       } 
/*     */     } 
/* 191 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\helper\DataUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */