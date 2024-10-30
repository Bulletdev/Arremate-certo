/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Writer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.h2.compress.CompressDeflate;
/*     */ import org.h2.compress.CompressLZF;
/*     */ import org.h2.compress.Compressor;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.type.DataType;
/*     */ import org.h2.mvstore.type.StringDataType;
/*     */ import org.h2.store.fs.FilePath;
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
/*     */ public class MVStoreTool
/*     */ {
/*     */   public static void main(String... paramVarArgs) {
/*  51 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  52 */       if ("-dump".equals(paramVarArgs[b])) {
/*  53 */         String str = paramVarArgs[++b];
/*  54 */         dump(str, new PrintWriter(System.out), true);
/*  55 */       } else if ("-info".equals(paramVarArgs[b])) {
/*  56 */         String str = paramVarArgs[++b];
/*  57 */         info(str, new PrintWriter(System.out));
/*  58 */       } else if ("-compact".equals(paramVarArgs[b])) {
/*  59 */         String str = paramVarArgs[++b];
/*  60 */         compact(str, false);
/*  61 */       } else if ("-compress".equals(paramVarArgs[b])) {
/*  62 */         String str = paramVarArgs[++b];
/*  63 */         compact(str, true);
/*  64 */       } else if ("-rollback".equals(paramVarArgs[b])) {
/*  65 */         String str = paramVarArgs[++b];
/*  66 */         long l = Long.decode(paramVarArgs[++b]).longValue();
/*  67 */         rollback(str, l, new PrintWriter(System.out));
/*  68 */       } else if ("-repair".equals(paramVarArgs[b])) {
/*  69 */         String str = paramVarArgs[++b];
/*  70 */         repair(str);
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
/*     */   public static void dump(String paramString, boolean paramBoolean) {
/*  82 */     dump(paramString, new PrintWriter(System.out), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void info(String paramString) {
/*  91 */     info(paramString, new PrintWriter(System.out));
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
/*     */   public static void dump(String paramString, Writer paramWriter, boolean paramBoolean) {
/* 103 */     PrintWriter printWriter = new PrintWriter(paramWriter, true);
/* 104 */     if (!FilePath.get(paramString).exists()) {
/* 105 */       printWriter.println("File not found: " + paramString);
/*     */       return;
/*     */     } 
/* 108 */     long l1 = FileUtils.size(paramString);
/* 109 */     printWriter.printf("File %s, %d bytes, %d MB\n", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l1 / 1024L / 1024L) });
/* 110 */     FileChannel fileChannel = null;
/* 111 */     char c = 'က';
/* 112 */     TreeMap<Object, Object> treeMap = new TreeMap<>();
/*     */     
/* 114 */     long l2 = 0L;
/*     */     try {
/* 116 */       fileChannel = FilePath.get(paramString).open("r");
/* 117 */       long l3 = fileChannel.size();
/* 118 */       int i = Long.toHexString(l3).length();
/* 119 */       ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
/* 120 */       long l4 = 0L;
/* 121 */       for (long l5 = 0L; l5 < l3; ) {
/* 122 */         byteBuffer.rewind();
/* 123 */         DataUtils.readFully(fileChannel, l5, byteBuffer);
/* 124 */         byteBuffer.rewind();
/* 125 */         byte b = byteBuffer.get();
/* 126 */         if (b == 72) {
/* 127 */           String str = (new String(byteBuffer.array(), DataUtils.LATIN)).trim();
/* 128 */           printWriter.printf("%0" + i + "x fileHeader %s%n", new Object[] { Long.valueOf(l5), str });
/*     */           
/* 130 */           l5 += c;
/*     */           continue;
/*     */         } 
/* 133 */         if (b != 99) {
/* 134 */           l5 += c;
/*     */           continue;
/*     */         } 
/* 137 */         byteBuffer.position(0);
/* 138 */         Chunk chunk = null;
/*     */         try {
/* 140 */           chunk = Chunk.readChunkHeader(byteBuffer, l5);
/* 141 */         } catch (IllegalStateException illegalStateException) {
/* 142 */           l5 += c;
/*     */           continue;
/*     */         } 
/* 145 */         if (chunk.len <= 0) {
/*     */           
/* 147 */           l5 += c;
/*     */           continue;
/*     */         } 
/* 150 */         int j = chunk.len * 4096;
/* 151 */         printWriter.printf("%n%0" + i + "x chunkHeader %s%n", new Object[] { Long.valueOf(l5), chunk.toString() });
/*     */         
/* 153 */         ByteBuffer byteBuffer1 = ByteBuffer.allocate(j);
/* 154 */         DataUtils.readFully(fileChannel, l5, byteBuffer1);
/* 155 */         int k = byteBuffer.position();
/* 156 */         l5 += j;
/* 157 */         int m = chunk.pageCount;
/* 158 */         l4 += chunk.pageCount;
/* 159 */         TreeMap<Object, Object> treeMap1 = new TreeMap<>();
/*     */         
/* 161 */         int n = 0;
/* 162 */         while (m > 0) {
/* 163 */           int i2 = k;
/*     */           try {
/* 165 */             byteBuffer1.position(k);
/* 166 */           } catch (IllegalArgumentException illegalArgumentException) {
/*     */             
/* 168 */             printWriter.printf("ERROR illegal position %d%n", new Object[] { Integer.valueOf(k) });
/*     */             break;
/*     */           } 
/* 171 */           int i3 = byteBuffer1.getInt();
/*     */           
/* 173 */           byteBuffer1.getShort();
/* 174 */           int i4 = DataUtils.readVarInt(byteBuffer1);
/* 175 */           int i5 = DataUtils.readVarInt(byteBuffer1);
/* 176 */           byte b1 = byteBuffer1.get();
/* 177 */           boolean bool1 = ((b1 & 0x2) != 0) ? true : false;
/* 178 */           boolean bool2 = ((b1 & 0x1) != 0) ? true : false;
/* 179 */           if (paramBoolean) {
/* 180 */             printWriter.printf("+%0" + i + "x %s, map %x, %d entries, %d bytes, maxLen %x%n", new Object[] { Integer.valueOf(k), (bool2 ? "node" : "leaf") + (bool1 ? " compressed" : ""), Integer.valueOf(i4), Integer.valueOf(bool2 ? (i5 + 1) : i5), Integer.valueOf(i3), Integer.valueOf(DataUtils.getPageMaxLength(DataUtils.getPagePos(0, 0, i3, 0))) });
/*     */           }
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
/* 192 */           k += i3;
/* 193 */           Integer integer = (Integer)treeMap1.get(Integer.valueOf(i4));
/* 194 */           if (integer == null) {
/* 195 */             integer = Integer.valueOf(0);
/*     */           }
/* 197 */           treeMap1.put(Integer.valueOf(i4), Integer.valueOf(integer.intValue() + i3));
/* 198 */           Long long_ = (Long)treeMap.get(Integer.valueOf(i4));
/* 199 */           if (long_ == null) {
/* 200 */             long_ = Long.valueOf(0L);
/*     */           }
/* 202 */           treeMap.put(Integer.valueOf(i4), Long.valueOf(long_.longValue() + i3));
/* 203 */           n += i3;
/* 204 */           l2 += i3;
/* 205 */           m--;
/* 206 */           long[] arrayOfLong1 = null;
/* 207 */           long[] arrayOfLong2 = null;
/* 208 */           if (bool2) {
/* 209 */             arrayOfLong1 = new long[i5 + 1]; byte b2;
/* 210 */             for (b2 = 0; b2 <= i5; b2++) {
/* 211 */               arrayOfLong1[b2] = byteBuffer1.getLong();
/*     */             }
/* 213 */             arrayOfLong2 = new long[i5 + 1];
/* 214 */             for (b2 = 0; b2 <= i5; b2++) {
/* 215 */               long l = DataUtils.readVarLong(byteBuffer1);
/* 216 */               arrayOfLong2[b2] = l;
/*     */             } 
/*     */           } 
/* 219 */           String[] arrayOfString = new String[i5];
/* 220 */           if (i4 == 0 && paramBoolean) {
/*     */             ByteBuffer byteBuffer2;
/* 222 */             if (bool1) {
/* 223 */               boolean bool = ((b1 & 0x6) != 6) ? true : false;
/*     */               
/* 225 */               Compressor compressor = getCompressor(bool);
/* 226 */               int i6 = DataUtils.readVarInt(byteBuffer1);
/* 227 */               int i7 = i3 + i2 - byteBuffer1.position();
/* 228 */               byte[] arrayOfByte = DataUtils.newBytes(i7);
/* 229 */               byteBuffer1.get(arrayOfByte);
/* 230 */               int i8 = i7 + i6;
/* 231 */               byteBuffer2 = ByteBuffer.allocate(i8);
/* 232 */               compressor.expand(arrayOfByte, 0, i7, byteBuffer2.array(), 0, i8);
/*     */             } else {
/* 234 */               byteBuffer2 = byteBuffer1;
/*     */             }  byte b2;
/* 236 */             for (b2 = 0; b2 < i5; b2++) {
/* 237 */               String str = StringDataType.INSTANCE.read(byteBuffer2);
/* 238 */               arrayOfString[b2] = str;
/*     */             } 
/* 240 */             if (bool2) {
/*     */               
/* 242 */               for (b2 = 0; b2 < i5; b2++) {
/* 243 */                 long l6 = arrayOfLong1[b2];
/* 244 */                 printWriter.printf("    %d children < %s @ chunk %x +%0" + i + "x%n", new Object[] { Long.valueOf(arrayOfLong2[b2]), arrayOfString[b2], Integer.valueOf(DataUtils.getPageChunkId(l6)), Integer.valueOf(DataUtils.getPageOffset(l6)) });
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 252 */               long l = arrayOfLong1[i5];
/* 253 */               printWriter.printf("    %d children >= %s @ chunk %x +%0" + i + "x%n", new Object[] { Long.valueOf(arrayOfLong2[i5]), (arrayOfString.length >= i5) ? null : arrayOfString[i5], Integer.valueOf(DataUtils.getPageChunkId(l)), Integer.valueOf(DataUtils.getPageOffset(l)) });
/*     */ 
/*     */ 
/*     */               
/*     */               continue;
/*     */             } 
/*     */ 
/*     */             
/* 261 */             String[] arrayOfString1 = new String[i5]; byte b3;
/* 262 */             for (b3 = 0; b3 < i5; b3++) {
/* 263 */               String str = StringDataType.INSTANCE.read(byteBuffer2);
/* 264 */               arrayOfString1[b3] = str;
/*     */             } 
/* 266 */             for (b3 = 0; b3 < i5; b3++) {
/* 267 */               printWriter.println("    " + arrayOfString[b3] + " = " + arrayOfString1[b3]);
/*     */             }
/*     */             
/*     */             continue;
/*     */           } 
/* 272 */           if (bool2 && paramBoolean) {
/* 273 */             for (byte b2 = 0; b2 <= i5; b2++) {
/* 274 */               long l = arrayOfLong1[b2];
/* 275 */               printWriter.printf("    %d children @ chunk %x +%0" + i + "x%n", new Object[] { Long.valueOf(arrayOfLong2[b2]), Integer.valueOf(DataUtils.getPageChunkId(l)), Integer.valueOf(DataUtils.getPageOffset(l)) });
/*     */             } 
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 284 */         n = Math.max(1, n);
/* 285 */         for (Integer integer : treeMap1.keySet()) {
/* 286 */           int i2 = 100 * ((Integer)treeMap1.get(integer)).intValue() / n;
/* 287 */           printWriter.printf("map %x: %d bytes, %d%%%n", new Object[] { integer, treeMap1.get(integer), Integer.valueOf(i2) });
/*     */         } 
/* 289 */         int i1 = byteBuffer1.limit() - 128;
/*     */         try {
/* 291 */           byteBuffer1.position(i1);
/* 292 */           printWriter.printf("+%0" + i + "x chunkFooter %s%n", new Object[] { Integer.valueOf(i1), (new String(byteBuffer1.array(), byteBuffer1.position(), 128, DataUtils.LATIN)).trim() });
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 297 */         catch (IllegalArgumentException illegalArgumentException) {
/*     */           
/* 299 */           printWriter.printf("ERROR illegal footer position %d%n", new Object[] { Integer.valueOf(i1) });
/*     */         } 
/*     */       } 
/* 302 */       printWriter.printf("%n%0" + i + "x eof%n", new Object[] { Long.valueOf(l3) });
/* 303 */       printWriter.printf("\n", new Object[0]);
/* 304 */       l4 = Math.max(1L, l4);
/* 305 */       printWriter.printf("page size total: %d bytes, page count: %d, average page size: %d bytes\n", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l2 / l4) });
/*     */       
/* 307 */       l2 = Math.max(1L, l2);
/* 308 */       for (Integer integer : treeMap.keySet()) {
/* 309 */         int j = (int)(100L * ((Long)treeMap.get(integer)).longValue() / l2);
/* 310 */         printWriter.printf("map %x: %d bytes, %d%%%n", new Object[] { integer, treeMap.get(integer), Integer.valueOf(j) });
/*     */       } 
/* 312 */     } catch (IOException iOException) {
/* 313 */       printWriter.println("ERROR: " + iOException);
/* 314 */       iOException.printStackTrace(printWriter);
/*     */     } finally {
/* 316 */       if (fileChannel != null) {
/*     */         try {
/* 318 */           fileChannel.close();
/* 319 */         } catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 324 */     printWriter.flush();
/*     */   }
/*     */   
/*     */   private static Compressor getCompressor(boolean paramBoolean) {
/* 328 */     return paramBoolean ? (Compressor)new CompressLZF() : (Compressor)new CompressDeflate();
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
/*     */   public static String info(String paramString, Writer paramWriter) {
/* 340 */     PrintWriter printWriter = new PrintWriter(paramWriter, true);
/* 341 */     if (!FilePath.get(paramString).exists()) {
/* 342 */       printWriter.println("File not found: " + paramString);
/* 343 */       return "File not found: " + paramString;
/*     */     } 
/* 345 */     long l = FileUtils.size(paramString);
/* 346 */     MVStore mVStore = (new MVStore.Builder()).fileName(paramString).readOnly().open();
/*     */ 
/*     */     
/*     */     try {
/* 350 */       MVMap<String, String> mVMap = mVStore.getMetaMap();
/* 351 */       Map<String, Object> map = mVStore.getStoreHeader();
/* 352 */       long l1 = DataUtils.readHexLong(map, "created", 0L);
/* 353 */       TreeMap<Object, Object> treeMap = new TreeMap<>();
/* 354 */       long l2 = 0L;
/* 355 */       long l3 = 0L;
/* 356 */       long l4 = 0L;
/* 357 */       long l5 = 0L;
/* 358 */       for (Map.Entry<String, String> entry : mVMap.entrySet()) {
/* 359 */         String str = (String)entry.getKey();
/* 360 */         if (str.startsWith("chunk.")) {
/* 361 */           Chunk chunk = Chunk.fromString((String)entry.getValue());
/* 362 */           treeMap.put(Integer.valueOf(chunk.id), chunk);
/* 363 */           l2 += (chunk.len * 4096);
/* 364 */           l3 += chunk.maxLen;
/* 365 */           l4 += chunk.maxLenLive;
/* 366 */           if (chunk.maxLenLive > 0L) {
/* 367 */             l5 += chunk.maxLen;
/*     */           }
/*     */         } 
/*     */       } 
/* 371 */       printWriter.printf("Created: %s\n", new Object[] { formatTimestamp(l1, l1) });
/* 372 */       printWriter.printf("Last modified: %s\n", new Object[] { formatTimestamp(FileUtils.lastModified(paramString), l1) });
/*     */       
/* 374 */       printWriter.printf("File length: %d\n", new Object[] { Long.valueOf(l) });
/* 375 */       printWriter.printf("The last chunk is not listed\n", new Object[0]);
/* 376 */       printWriter.printf("Chunk length: %d\n", new Object[] { Long.valueOf(l2) });
/* 377 */       printWriter.printf("Chunk count: %d\n", new Object[] { Integer.valueOf(treeMap.size()) });
/* 378 */       printWriter.printf("Used space: %d%%\n", new Object[] { Integer.valueOf(getPercent(l2, l)) });
/* 379 */       printWriter.printf("Chunk fill rate: %d%%\n", new Object[] { Integer.valueOf((l3 == 0L) ? 100 : getPercent(l4, l3)) });
/*     */       
/* 381 */       printWriter.printf("Chunk fill rate excluding empty chunks: %d%%\n", new Object[] { Integer.valueOf((l5 == 0L) ? 100 : getPercent(l4, l5)) });
/*     */ 
/*     */       
/* 384 */       for (Map.Entry<Object, Object> entry : treeMap.entrySet()) {
/* 385 */         Chunk chunk = (Chunk)entry.getValue();
/* 386 */         long l6 = l1 + chunk.time;
/* 387 */         printWriter.printf("  Chunk %d: %s, %d%% used, %d blocks", new Object[] { Integer.valueOf(chunk.id), formatTimestamp(l6, l1), Integer.valueOf(getPercent(chunk.maxLenLive, chunk.maxLen)), Integer.valueOf(chunk.len) });
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 392 */         if (chunk.maxLenLive == 0L) {
/* 393 */           printWriter.printf(", unused: %s", new Object[] { formatTimestamp(l1 + chunk.unused, l1) });
/*     */         }
/*     */         
/* 396 */         printWriter.printf("\n", new Object[0]);
/*     */       } 
/* 398 */       printWriter.printf("\n", new Object[0]);
/* 399 */     } catch (Exception exception) {
/* 400 */       printWriter.println("ERROR: " + exception);
/* 401 */       exception.printStackTrace(printWriter);
/* 402 */       return exception.getMessage();
/*     */     } finally {
/* 404 */       mVStore.close();
/*     */     } 
/* 406 */     printWriter.flush();
/* 407 */     return null;
/*     */   }
/*     */   
/*     */   private static String formatTimestamp(long paramLong1, long paramLong2) {
/* 411 */     String str1 = (new Timestamp(paramLong1)).toString();
/* 412 */     String str2 = str1.substring(0, 19);
/* 413 */     str2 = str2 + " (+" + ((paramLong1 - paramLong2) / 1000L) + " s)";
/* 414 */     return str2;
/*     */   }
/*     */   
/*     */   private static int getPercent(long paramLong1, long paramLong2) {
/* 418 */     if (paramLong1 == 0L)
/* 419 */       return 0; 
/* 420 */     if (paramLong1 == paramLong2) {
/* 421 */       return 100;
/*     */     }
/* 423 */     return (int)(1L + 98L * paramLong1 / Math.max(1L, paramLong2));
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
/*     */   public static void compact(String paramString, boolean paramBoolean) {
/* 438 */     String str = paramString + ".tempFile";
/* 439 */     FileUtils.delete(str);
/* 440 */     compact(paramString, str, paramBoolean);
/*     */     try {
/* 442 */       FileUtils.moveAtomicReplace(str, paramString);
/* 443 */     } catch (DbException dbException) {
/* 444 */       String str1 = paramString + ".newFile";
/* 445 */       FileUtils.delete(str1);
/* 446 */       FileUtils.move(str, str1);
/* 447 */       FileUtils.delete(paramString);
/* 448 */       FileUtils.move(str1, paramString);
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
/*     */   public static void compactCleanUp(String paramString) {
/* 461 */     String str1 = paramString + ".tempFile";
/* 462 */     if (FileUtils.exists(str1)) {
/* 463 */       FileUtils.delete(str1);
/*     */     }
/* 465 */     String str2 = paramString + ".newFile";
/* 466 */     if (FileUtils.exists(str2)) {
/* 467 */       if (FileUtils.exists(paramString)) {
/* 468 */         FileUtils.delete(str2);
/*     */       } else {
/* 470 */         FileUtils.move(str2, paramString);
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
/*     */   public static void compact(String paramString1, String paramString2, boolean paramBoolean) {
/* 483 */     MVStore mVStore1 = (new MVStore.Builder()).fileName(paramString1).readOnly().open();
/*     */ 
/*     */ 
/*     */     
/* 487 */     FileUtils.delete(paramString2);
/* 488 */     MVStore.Builder builder = (new MVStore.Builder()).fileName(paramString2);
/*     */     
/* 490 */     if (paramBoolean) {
/* 491 */       builder.compress();
/*     */     }
/* 493 */     MVStore mVStore2 = builder.open();
/* 494 */     compact(mVStore1, mVStore2);
/* 495 */     mVStore2.close();
/* 496 */     mVStore1.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void compact(MVStore paramMVStore1, MVStore paramMVStore2) {
/* 506 */     MVMap<String, String> mVMap1 = paramMVStore1.getMetaMap();
/* 507 */     MVMap<String, String> mVMap2 = paramMVStore2.getMetaMap();
/* 508 */     for (Map.Entry<String, String> entry : mVMap1.entrySet()) {
/* 509 */       String str = (String)entry.getKey();
/* 510 */       if (str.startsWith("chunk."))
/*     */         continue; 
/* 512 */       if (str.startsWith("map."))
/*     */         continue; 
/* 514 */       if (str.startsWith("name."))
/*     */         continue; 
/* 516 */       if (str.startsWith("root.")) {
/*     */         continue;
/*     */       }
/* 519 */       mVMap2.put(str, (String)entry.getValue());
/*     */     } 
/*     */     
/* 522 */     for (String str : paramMVStore1.getMapNames()) {
/* 523 */       MVMap.Builder<Object, ?, ?> builder = (new MVMap.Builder<>()).keyType(new GenericDataType()).valueType(new GenericDataType());
/*     */ 
/*     */ 
/*     */       
/* 527 */       MVMap mVMap3 = (MVMap)paramMVStore1.openMap(str, (MVMap.MapBuilder)builder);
/* 528 */       MVMap mVMap4 = (MVMap)paramMVStore2.openMap(str, (MVMap.MapBuilder)builder);
/* 529 */       mVMap4.copyFrom(mVMap3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void repair(String paramString) {
/* 539 */     PrintWriter printWriter = new PrintWriter(System.out);
/* 540 */     long l = Long.MAX_VALUE;
/* 541 */     OutputStream outputStream = new OutputStream()
/*     */       {
/*     */         public void write(int param1Int) throws IOException {}
/*     */       };
/*     */ 
/*     */     
/* 547 */     while (l >= 0L) {
/* 548 */       printWriter.println((l == Long.MAX_VALUE) ? "Trying latest version" : ("Trying version " + l));
/*     */       
/* 550 */       printWriter.flush();
/* 551 */       l = rollback(paramString, l, new PrintWriter(outputStream));
/*     */       try {
/* 553 */         String str = info(paramString + ".temp", new PrintWriter(outputStream));
/* 554 */         if (str == null) {
/* 555 */           FilePath.get(paramString).moveTo(FilePath.get(paramString + ".back"), true);
/* 556 */           FilePath.get(paramString + ".temp").moveTo(FilePath.get(paramString), true);
/* 557 */           printWriter.println("Success");
/*     */           break;
/*     */         } 
/* 560 */         printWriter.println("    ... failed: " + str);
/* 561 */       } catch (Exception exception) {
/* 562 */         printWriter.println("Fail: " + exception.getMessage());
/* 563 */         printWriter.flush();
/*     */       } 
/* 565 */       l--;
/*     */     } 
/* 567 */     printWriter.flush();
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
/*     */   public static long rollback(String paramString, long paramLong, Writer paramWriter) {
/* 580 */     long l = -1L;
/* 581 */     PrintWriter printWriter = new PrintWriter(paramWriter, true);
/* 582 */     if (!FilePath.get(paramString).exists()) {
/* 583 */       printWriter.println("File not found: " + paramString);
/* 584 */       return l;
/*     */     } 
/* 586 */     FileChannel fileChannel1 = null;
/* 587 */     FileChannel fileChannel2 = null;
/* 588 */     char c = 'က';
/*     */     try {
/* 590 */       fileChannel1 = FilePath.get(paramString).open("r");
/* 591 */       FilePath.get(paramString + ".temp").delete();
/* 592 */       fileChannel2 = FilePath.get(paramString + ".temp").open("rw");
/* 593 */       long l1 = fileChannel1.size();
/* 594 */       ByteBuffer byteBuffer1 = ByteBuffer.allocate(4096);
/* 595 */       Chunk chunk = null; long l2;
/* 596 */       for (l2 = 0L; l2 < l1; ) {
/* 597 */         byteBuffer1.rewind();
/* 598 */         DataUtils.readFully(fileChannel1, l2, byteBuffer1);
/* 599 */         byteBuffer1.rewind();
/* 600 */         byte b = byteBuffer1.get();
/* 601 */         if (b == 72) {
/* 602 */           byteBuffer1.rewind();
/* 603 */           fileChannel2.write(byteBuffer1, l2);
/* 604 */           l2 += c;
/*     */           continue;
/*     */         } 
/* 607 */         if (b != 99) {
/* 608 */           l2 += c;
/*     */           continue;
/*     */         } 
/* 611 */         Chunk chunk1 = null;
/*     */         try {
/* 613 */           chunk1 = Chunk.readChunkHeader(byteBuffer1, l2);
/* 614 */         } catch (IllegalStateException illegalStateException) {
/* 615 */           l2 += c;
/*     */           continue;
/*     */         } 
/* 618 */         if (chunk1.len <= 0) {
/*     */           
/* 620 */           l2 += c;
/*     */           continue;
/*     */         } 
/* 623 */         int j = chunk1.len * 4096;
/* 624 */         ByteBuffer byteBuffer = ByteBuffer.allocate(j);
/* 625 */         DataUtils.readFully(fileChannel1, l2, byteBuffer);
/* 626 */         if (chunk1.version > paramLong) {
/*     */           
/* 628 */           l2 += j;
/*     */           continue;
/*     */         } 
/* 631 */         byteBuffer.rewind();
/* 632 */         fileChannel2.write(byteBuffer, l2);
/* 633 */         if (chunk == null || chunk1.version > chunk.version) {
/* 634 */           chunk = chunk1;
/* 635 */           l = chunk1.version;
/*     */         } 
/* 637 */         l2 += j;
/*     */       } 
/* 639 */       int i = chunk.len * 4096;
/* 640 */       ByteBuffer byteBuffer2 = ByteBuffer.allocate(i);
/* 641 */       DataUtils.readFully(fileChannel1, chunk.block * 4096L, byteBuffer2);
/* 642 */       byteBuffer2.rewind();
/* 643 */       fileChannel2.write(byteBuffer2, l1);
/* 644 */     } catch (IOException iOException) {
/* 645 */       printWriter.println("ERROR: " + iOException);
/* 646 */       iOException.printStackTrace(printWriter);
/*     */     } finally {
/* 648 */       if (fileChannel1 != null) {
/*     */         try {
/* 650 */           fileChannel1.close();
/* 651 */         } catch (IOException iOException) {}
/*     */       }
/*     */ 
/*     */       
/* 655 */       if (fileChannel2 != null) {
/*     */         try {
/* 657 */           fileChannel2.close();
/* 658 */         } catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 663 */     printWriter.flush();
/* 664 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class GenericDataType
/*     */     implements DataType
/*     */   {
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 675 */       throw DataUtils.newUnsupportedOperationException("Can not compare");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getMemory(Object param1Object) {
/* 680 */       return (param1Object == null) ? 0 : (((byte[])param1Object).length * 8);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 685 */       if (param1Object != null) {
/* 686 */         param1WriteBuffer.put((byte[])param1Object);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(WriteBuffer param1WriteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/* 692 */       for (Object object : param1ArrayOfObject) {
/* 693 */         write(param1WriteBuffer, object);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public Object read(ByteBuffer param1ByteBuffer) {
/* 699 */       int i = param1ByteBuffer.remaining();
/* 700 */       if (i == 0) {
/* 701 */         return null;
/*     */       }
/* 703 */       byte[] arrayOfByte = new byte[i];
/* 704 */       param1ByteBuffer.get(arrayOfByte);
/* 705 */       return arrayOfByte;
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(ByteBuffer param1ByteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/* 710 */       for (byte b = 0; b < param1ArrayOfObject.length; b++)
/* 711 */         param1ArrayOfObject[b] = read(param1ByteBuffer); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\MVStoreTool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */