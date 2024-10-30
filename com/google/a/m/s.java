/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ public final class s
/*     */ {
/*     */   public static final byte K = 64;
/*     */   
/*     */   public static byte a(long paramLong) {
/*  58 */     byte b = (byte)(int)paramLong;
/*  59 */     D.a((b == paramLong), "Out of range: %s", paramLong);
/*  60 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte b(long paramLong) {
/*  71 */     if (paramLong > 127L) {
/*  72 */       return Byte.MAX_VALUE;
/*     */     }
/*  74 */     if (paramLong < -128L) {
/*  75 */       return Byte.MIN_VALUE;
/*     */     }
/*  77 */     return (byte)(int)paramLong;
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
/*     */   public static int compare(byte paramByte1, byte paramByte2) {
/*  94 */     return paramByte1 - paramByte2;
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
/*     */   public static byte min(byte... paramVarArgs) {
/* 106 */     D.checkArgument((paramVarArgs.length > 0));
/* 107 */     byte b = paramVarArgs[0];
/* 108 */     for (byte b1 = 1; b1 < paramVarArgs.length; b1++) {
/* 109 */       if (paramVarArgs[b1] < b) {
/* 110 */         b = paramVarArgs[b1];
/*     */       }
/*     */     } 
/* 113 */     return b;
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
/*     */   public static byte max(byte... paramVarArgs) {
/* 125 */     D.checkArgument((paramVarArgs.length > 0));
/* 126 */     byte b = paramVarArgs[0];
/* 127 */     for (byte b1 = 1; b1 < paramVarArgs.length; b1++) {
/* 128 */       if (paramVarArgs[b1] > b) {
/* 129 */         b = paramVarArgs[b1];
/*     */       }
/*     */     } 
/* 132 */     return b;
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
/*     */   public static String a(String paramString, byte... paramVarArgs) {
/* 144 */     D.checkNotNull(paramString);
/* 145 */     if (paramVarArgs.length == 0) {
/* 146 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 150 */     StringBuilder stringBuilder = new StringBuilder(paramVarArgs.length * 5);
/* 151 */     stringBuilder.append(paramVarArgs[0]);
/* 152 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 153 */       stringBuilder.append(paramString).append(paramVarArgs[b]);
/*     */     }
/* 155 */     return stringBuilder.toString();
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
/*     */   public static Comparator<byte[]> g() {
/* 173 */     return (Comparator<byte[]>)a.a;
/*     */   }
/*     */   
/*     */   private enum a implements Comparator<byte[]> {
/* 177 */     a;
/*     */ 
/*     */     
/*     */     public int b(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
/* 181 */       int i = Math.min(param1ArrayOfbyte1.length, param1ArrayOfbyte2.length);
/* 182 */       for (byte b = 0; b < i; b++) {
/* 183 */         int j = s.compare(param1ArrayOfbyte1[b], param1ArrayOfbyte2[b]);
/* 184 */         if (j != 0) {
/* 185 */           return j;
/*     */         }
/*     */       } 
/* 188 */       return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 193 */       return "SignedBytes.lexicographicalComparator()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(byte[] paramArrayOfbyte) {
/* 203 */     D.checkNotNull(paramArrayOfbyte);
/* 204 */     b(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 214 */     D.checkNotNull(paramArrayOfbyte);
/* 215 */     D.a(paramInt1, paramInt2, paramArrayOfbyte.length);
/* 216 */     Arrays.sort(paramArrayOfbyte, paramInt1, paramInt2);
/* 217 */     b.reverse(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */