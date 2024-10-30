/*     */ package org.c.a.b.r;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
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
/*     */ public class h
/*     */ {
/*     */   public static String a(Reader paramReader) throws IOException {
/*  46 */     StringWriter stringWriter = new StringWriter();
/*  47 */     a(paramReader, stringWriter);
/*  48 */     String str = stringWriter.toString();
/*     */ 
/*     */     
/*  51 */     if (str.startsWith("﻿")) {
/*  52 */       return str.substring(1);
/*     */     }
/*     */     
/*  55 */     return str;
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
/*     */   public static byte[] a(InputStream paramInputStream) throws IOException {
/*  67 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
/*  68 */     copy(paramInputStream, byteArrayOutputStream);
/*  69 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static void a(Reader paramReader, Writer paramWriter) throws IOException {
/*     */     try {
/*  82 */       char[] arrayOfChar = new char[4096];
/*     */       int i;
/*  84 */       while ((i = paramReader.read(arrayOfChar)) != -1) {
/*  85 */         paramWriter.write(arrayOfChar, 0, i);
/*     */       }
/*  87 */       paramWriter.flush();
/*     */     } finally {
/*  89 */       i.close(paramReader);
/*  90 */       i.close(paramWriter);
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
/*     */   public static int copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/*     */     try {
/* 105 */       int i = 0;
/* 106 */       byte[] arrayOfByte = new byte[4096];
/*     */       int j;
/* 108 */       while ((j = paramInputStream.read(arrayOfByte)) != -1) {
/* 109 */         paramOutputStream.write(arrayOfByte, 0, j);
/* 110 */         i += j;
/*     */       } 
/* 112 */       paramOutputStream.flush();
/* 113 */       return i;
/*     */     } finally {
/* 115 */       i.close(paramInputStream);
/* 116 */       i.close(paramOutputStream);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */