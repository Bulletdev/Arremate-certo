/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
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
/*     */ public class HexRead
/*     */ {
/*     */   public static byte[] readData(String paramString) throws IOException {
/*  40 */     File file = new File(paramString);
/*  41 */     FileInputStream fileInputStream = new FileInputStream(file);
/*     */     
/*     */     try {
/*  44 */       return readData(fileInputStream, -1);
/*     */     }
/*     */     finally {
/*     */       
/*  48 */       fileInputStream.close();
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
/*     */   
/*     */   public static byte[] readData(InputStream paramInputStream, String paramString) throws IOException {
/*     */     try {
/*  65 */       StringBuffer stringBuffer = new StringBuffer();
/*  66 */       boolean bool = false;
/*  67 */       int i = paramInputStream.read();
/*  68 */       while (i != -1)
/*     */       {
/*  70 */         switch (i) {
/*     */           
/*     */           case 91:
/*  73 */             bool = true;
/*     */             break;
/*     */           case 10:
/*     */           case 13:
/*  77 */             bool = false;
/*  78 */             stringBuffer = new StringBuffer();
/*     */             break;
/*     */           case 93:
/*  81 */             bool = false;
/*  82 */             if (stringBuffer.toString().equals(paramString)) return readData(paramInputStream, 91); 
/*  83 */             stringBuffer = new StringBuffer();
/*     */             break;
/*     */           default:
/*  86 */             if (bool) stringBuffer.append((char)i);  break;
/*     */         } 
/*  88 */         i = paramInputStream.read();
/*     */       }
/*     */     
/*     */     } finally {
/*     */       
/*  93 */       paramInputStream.close();
/*     */     } 
/*  95 */     throw new IOException("Section '" + paramString + "' not found");
/*     */   }
/*     */   
/*     */   public static byte[] readData(String paramString1, String paramString2) throws IOException {
/*  99 */     File file = new File(paramString1);
/* 100 */     FileInputStream fileInputStream = new FileInputStream(file);
/* 101 */     return readData(fileInputStream, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] readData(InputStream paramInputStream, int paramInt) throws IOException {
/* 108 */     byte b1 = 0;
/* 109 */     byte b = 0;
/* 110 */     ArrayList<Byte> arrayList = new ArrayList();
/* 111 */     byte b2 = 87;
/* 112 */     byte b3 = 55;
/*     */     
/*     */     while (true) {
/* 115 */       int i = paramInputStream.read();
/* 116 */       int j = -1;
/* 117 */       if (48 <= i && i <= 57) {
/* 118 */         j = i - 48;
/* 119 */       } else if (65 <= i && i <= 70) {
/* 120 */         j = i - 55;
/* 121 */       } else if (97 <= i && i <= 102) {
/* 122 */         j = i - 87;
/* 123 */       } else if (35 == i) {
/* 124 */         readToEOL(paramInputStream);
/* 125 */       } else if (-1 == i || paramInt == i) {
/*     */         break;
/*     */       } 
/*     */ 
/*     */       
/* 130 */       if (j != -1) {
/* 131 */         b = (byte)(b << 4);
/* 132 */         b = (byte)(b + (byte)j);
/* 133 */         b1++;
/* 134 */         if (b1 == 2) {
/*     */           
/* 136 */           arrayList.add(Byte.valueOf(b));
/* 137 */           b1 = 0;
/* 138 */           b = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/* 142 */     Byte[] arrayOfByte = arrayList.<Byte>toArray(new Byte[arrayList.size()]);
/* 143 */     byte[] arrayOfByte1 = new byte[arrayOfByte.length];
/* 144 */     for (byte b4 = 0; b4 < arrayOfByte.length; b4++)
/*     */     {
/* 146 */       arrayOfByte1[b4] = arrayOfByte[b4].byteValue();
/*     */     }
/* 148 */     return arrayOfByte1;
/*     */   }
/*     */   
/*     */   public static byte[] readFromString(String paramString) {
/*     */     try {
/* 153 */       return readData(new ByteArrayInputStream(paramString.getBytes(StringUtil.UTF8)), -1);
/* 154 */     } catch (IOException iOException) {
/* 155 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void readToEOL(InputStream paramInputStream) throws IOException {
/* 161 */     int i = paramInputStream.read();
/* 162 */     while (i != -1 && i != 10 && i != 13)
/*     */     {
/* 164 */       i = paramInputStream.read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\HexRead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */