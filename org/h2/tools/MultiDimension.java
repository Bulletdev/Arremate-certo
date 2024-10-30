/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class MultiDimension
/*     */   implements Comparator<long[]>
/*     */ {
/*  24 */   private static final MultiDimension INSTANCE = new MultiDimension();
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
/*     */   public static MultiDimension getInstance() {
/*  37 */     return INSTANCE;
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
/*     */   public int normalize(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3) {
/*  51 */     if (paramDouble1 < paramDouble2 || paramDouble1 > paramDouble3) {
/*  52 */       throw new IllegalArgumentException(paramDouble2 + "<" + paramDouble1 + "<" + paramDouble3);
/*     */     }
/*  54 */     double d = (paramDouble1 - paramDouble2) / (paramDouble3 - paramDouble2);
/*  55 */     return (int)(d * getMaxValue(paramInt));
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
/*     */   public int getMaxValue(int paramInt) {
/*  67 */     if (paramInt < 2 || paramInt > 32) {
/*  68 */       throw new IllegalArgumentException("" + paramInt);
/*     */     }
/*  70 */     int i = getBitsPerValue(paramInt);
/*  71 */     return (int)((1L << i) - 1L);
/*     */   }
/*     */   
/*     */   private static int getBitsPerValue(int paramInt) {
/*  75 */     return Math.min(31, 64 / paramInt);
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
/*     */   public long interleave(int... paramVarArgs) {
/*  89 */     int i = paramVarArgs.length;
/*  90 */     long l1 = getMaxValue(i);
/*  91 */     int j = getBitsPerValue(i);
/*  92 */     long l2 = 0L;
/*  93 */     for (byte b = 0; b < i; b++) {
/*  94 */       long l = paramVarArgs[b];
/*  95 */       if (l < 0L || l > l1) {
/*  96 */         throw new IllegalArgumentException("0<" + l + "<" + l1);
/*     */       }
/*  98 */       for (byte b1 = 0; b1 < j; b1++) {
/*  99 */         l2 |= (l & 1L << b1) << b + (i - 1) * b1;
/*     */       }
/*     */     } 
/* 102 */     return l2;
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
/*     */   public long interleave(int paramInt1, int paramInt2) {
/* 117 */     if (paramInt1 < 0) {
/* 118 */       throw new IllegalArgumentException("0<" + paramInt1);
/*     */     }
/* 120 */     if (paramInt2 < 0) {
/* 121 */       throw new IllegalArgumentException("0<" + paramInt2);
/*     */     }
/* 123 */     long l = 0L;
/* 124 */     for (byte b = 0; b < 32; b++) {
/* 125 */       l |= (paramInt1 & 1L << b) << b;
/* 126 */       l |= (paramInt2 & 1L << b) << b + 1;
/*     */     } 
/* 128 */     return l;
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
/*     */   public int deinterleave(int paramInt1, long paramLong, int paramInt2) {
/* 140 */     int i = getBitsPerValue(paramInt1);
/* 141 */     int j = 0;
/* 142 */     for (byte b = 0; b < i; b++) {
/* 143 */       j = (int)(j | paramLong >> paramInt2 + (paramInt1 - 1) * b & 1L << b);
/*     */     }
/* 145 */     return j;
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
/*     */   public String generatePreparedQuery(String paramString1, String paramString2, String[] paramArrayOfString) {
/* 159 */     StringBuilder stringBuilder = new StringBuilder("SELECT D.* FROM ");
/* 160 */     stringBuilder.append(StringUtils.quoteIdentifier(paramString1)).append(" D, TABLE(_FROM_ BIGINT=?, _TO_ BIGINT=?) WHERE ").append(StringUtils.quoteIdentifier(paramString2)).append(" BETWEEN _FROM_ AND _TO_");
/*     */ 
/*     */ 
/*     */     
/* 164 */     for (String str : paramArrayOfString) {
/* 165 */       stringBuilder.append(" AND ").append(StringUtils.quoteIdentifier(str)).append("+1 BETWEEN ?+1 AND ?+1");
/*     */     }
/*     */     
/* 168 */     return stringBuilder.toString();
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
/*     */   public ResultSet getResult(PreparedStatement paramPreparedStatement, int[] paramArrayOfint1, int[] paramArrayOfint2) throws SQLException {
/* 181 */     long[][] arrayOfLong = getMortonRanges(paramArrayOfint1, paramArrayOfint2);
/* 182 */     int i = arrayOfLong.length;
/* 183 */     Long[] arrayOfLong1 = new Long[i];
/* 184 */     Long[] arrayOfLong2 = new Long[i]; byte b1;
/* 185 */     for (b1 = 0; b1 < i; b1++) {
/* 186 */       arrayOfLong1[b1] = Long.valueOf(arrayOfLong[b1][0]);
/* 187 */       arrayOfLong2[b1] = Long.valueOf(arrayOfLong[b1][1]);
/*     */     } 
/* 189 */     paramPreparedStatement.setObject(1, arrayOfLong1);
/* 190 */     paramPreparedStatement.setObject(2, arrayOfLong2);
/* 191 */     i = paramArrayOfint1.length; byte b2;
/* 192 */     for (b1 = 0, b2 = 3; b1 < i; b1++) {
/* 193 */       paramPreparedStatement.setInt(b2++, paramArrayOfint1[b1]);
/* 194 */       paramPreparedStatement.setInt(b2++, paramArrayOfint2[b1]);
/*     */     } 
/* 196 */     return paramPreparedStatement.executeQuery();
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
/*     */   private long[][] getMortonRanges(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 210 */     int i = paramArrayOfint1.length;
/* 211 */     if (paramArrayOfint2.length != i)
/* 212 */       throw new IllegalArgumentException(i + "=" + paramArrayOfint2.length); 
/*     */     int j;
/* 214 */     for (j = 0; j < i; j++) {
/* 215 */       if (paramArrayOfint1[j] > paramArrayOfint2[j]) {
/* 216 */         int k = paramArrayOfint1[j];
/* 217 */         paramArrayOfint1[j] = paramArrayOfint2[j];
/* 218 */         paramArrayOfint2[j] = k;
/*     */       } 
/*     */     } 
/* 221 */     j = getSize(paramArrayOfint1, paramArrayOfint2, i);
/* 222 */     ArrayList<long[]> arrayList = New.arrayList();
/* 223 */     addMortonRanges(arrayList, paramArrayOfint1, paramArrayOfint2, i, 0);
/* 224 */     combineEntries(arrayList, j);
/* 225 */     long[][] arrayOfLong = new long[arrayList.size()][2];
/* 226 */     arrayList.toArray(arrayOfLong);
/* 227 */     return arrayOfLong;
/*     */   }
/*     */   
/*     */   private static int getSize(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 231 */     int i = 1;
/* 232 */     for (byte b = 0; b < paramInt; b++) {
/* 233 */       int j = paramArrayOfint2[b] - paramArrayOfint1[b];
/* 234 */       i *= j + 1;
/*     */     } 
/* 236 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void combineEntries(ArrayList<long[]> paramArrayList, int paramInt) {
/* 246 */     Collections.sort(paramArrayList, this);
/* 247 */     for (int i = 10; i < paramInt; i += i / 2) {
/* 248 */       int j; for (j = 0; j < paramArrayList.size() - 1; j++) {
/* 249 */         long[] arrayOfLong1 = paramArrayList.get(j);
/* 250 */         long[] arrayOfLong2 = paramArrayList.get(j + 1);
/* 251 */         if (arrayOfLong1[1] + i >= arrayOfLong2[0]) {
/* 252 */           arrayOfLong1[1] = arrayOfLong2[1];
/* 253 */           paramArrayList.remove(j + 1);
/* 254 */           j--;
/*     */         } 
/*     */       } 
/* 257 */       j = 0;
/* 258 */       for (long[] arrayOfLong : paramArrayList) {
/* 259 */         j = (int)(j + arrayOfLong[1] - arrayOfLong[0] + 1L);
/*     */       }
/* 261 */       if (j > 2 * paramInt || paramArrayList.size() < 100) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int compare(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 269 */     return (paramArrayOflong1[0] > paramArrayOflong2[0]) ? 1 : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addMortonRanges(ArrayList<long[]> paramArrayList, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2) {
/* 274 */     if (paramInt2 > 100) {
/* 275 */       throw new IllegalArgumentException("" + paramInt2);
/*     */     }
/* 277 */     byte b1 = 0; int i = 0;
/* 278 */     long l1 = 1L;
/* 279 */     for (byte b2 = 0; b2 < paramInt1; b2++) {
/* 280 */       int j = paramArrayOfint2[b2] - paramArrayOfint1[b2];
/* 281 */       if (j < 0) {
/* 282 */         throw new IllegalArgumentException("" + j);
/*     */       }
/* 284 */       l1 *= (j + 1);
/* 285 */       if (l1 < 0L) {
/* 286 */         throw new IllegalArgumentException("" + l1);
/*     */       }
/* 288 */       if (j > i) {
/* 289 */         i = j;
/* 290 */         b1 = b2;
/*     */       } 
/*     */     } 
/* 293 */     long l2 = interleave(paramArrayOfint1), l3 = interleave(paramArrayOfint2);
/* 294 */     if (l3 < l2) {
/* 295 */       throw new IllegalArgumentException(l3 + "<" + l2);
/*     */     }
/* 297 */     long l4 = l3 - l2 + 1L;
/* 298 */     if (l4 == l1) {
/* 299 */       long[] arrayOfLong = { l2, l3 };
/* 300 */       paramArrayList.add(arrayOfLong);
/*     */     } else {
/* 302 */       int j = findMiddle(paramArrayOfint1[b1], paramArrayOfint2[b1]);
/* 303 */       int k = paramArrayOfint2[b1];
/* 304 */       paramArrayOfint2[b1] = j;
/* 305 */       addMortonRanges(paramArrayList, paramArrayOfint1, paramArrayOfint2, paramInt1, paramInt2 + 1);
/* 306 */       paramArrayOfint2[b1] = k;
/* 307 */       k = paramArrayOfint1[b1];
/* 308 */       paramArrayOfint1[b1] = j + 1;
/* 309 */       addMortonRanges(paramArrayList, paramArrayOfint1, paramArrayOfint2, paramInt1, paramInt2 + 1);
/* 310 */       paramArrayOfint1[b1] = k;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int roundUp(int paramInt1, int paramInt2) {
/* 315 */     return paramInt1 + paramInt2 - 1 & -paramInt2;
/*     */   }
/*     */   
/*     */   private static int findMiddle(int paramInt1, int paramInt2) {
/* 319 */     int i = paramInt2 - paramInt1 - 1;
/* 320 */     if (i == 0) {
/* 321 */       return paramInt1;
/*     */     }
/* 323 */     if (i == 1) {
/* 324 */       return paramInt1 + 1;
/*     */     }
/* 326 */     byte b = 0;
/* 327 */     while (1 << b < i) {
/* 328 */       b++;
/*     */     }
/* 330 */     b--;
/* 331 */     int j = roundUp(paramInt1 + 2, 1 << b) - 1;
/* 332 */     if (j <= paramInt1 || j >= paramInt2) {
/* 333 */       throw new IllegalArgumentException(paramInt1 + "<" + j + "<" + paramInt2);
/*     */     }
/* 335 */     return j;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\MultiDimension.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */