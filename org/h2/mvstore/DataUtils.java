/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.charset.Charset;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.h2.util.New;
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
/*     */ public class DataUtils
/*     */ {
/*     */   public static final int ERROR_READING_FAILED = 1;
/*     */   public static final int ERROR_WRITING_FAILED = 2;
/*     */   public static final int ERROR_INTERNAL = 3;
/*     */   public static final int ERROR_CLOSED = 4;
/*     */   public static final int ERROR_UNSUPPORTED_FORMAT = 5;
/*     */   public static final int ERROR_FILE_CORRUPT = 6;
/*     */   public static final int ERROR_FILE_LOCKED = 7;
/*     */   public static final int ERROR_SERIALIZATION = 8;
/*     */   public static final int ERROR_CHUNK_NOT_FOUND = 9;
/*     */   public static final int ERROR_BLOCK_NOT_FOUND = 50;
/*     */   public static final int ERROR_TRANSACTION_CORRUPT = 100;
/*     */   public static final int ERROR_TRANSACTION_LOCKED = 101;
/*     */   public static final int ERROR_TOO_MANY_OPEN_TRANSACTIONS = 102;
/*     */   public static final int ERROR_TRANSACTION_ILLEGAL_STATE = 103;
/*     */   public static final int PAGE_TYPE_LEAF = 0;
/*     */   public static final int PAGE_TYPE_NODE = 1;
/*     */   public static final int PAGE_COMPRESSED = 2;
/*     */   public static final int PAGE_COMPRESSED_HIGH = 6;
/*     */   public static final int MAX_VAR_INT_LEN = 5;
/*     */   public static final int MAX_VAR_LONG_LEN = 10;
/*     */   public static final int COMPRESSED_VAR_INT_MAX = 2097151;
/*     */   public static final long COMPRESSED_VAR_LONG_MAX = 562949953421311L;
/*     */   public static final int PAGE_MEMORY = 128;
/*     */   public static final int PAGE_MEMORY_CHILD = 16;
/*     */   public static final int PAGE_LARGE = 2097152;
/* 162 */   public static final Charset UTF8 = Charset.forName("UTF-8");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 167 */   public static final Charset LATIN = Charset.forName("ISO-8859-1");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 172 */   private static final byte[] EMPTY_BYTES = new byte[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getVarIntLen(int paramInt) {
/* 181 */     if ((paramInt & 0xFFFFFF80) == 0)
/* 182 */       return 1; 
/* 183 */     if ((paramInt & 0xFFFFC000) == 0)
/* 184 */       return 2; 
/* 185 */     if ((paramInt & 0xFFE00000) == 0)
/* 186 */       return 3; 
/* 187 */     if ((paramInt & 0xF0000000) == 0) {
/* 188 */       return 4;
/*     */     }
/* 190 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getVarLongLen(long paramLong) {
/* 200 */     byte b = 1;
/*     */     while (true) {
/* 202 */       paramLong >>>= 7L;
/* 203 */       if (paramLong == 0L) {
/* 204 */         return b;
/*     */       }
/* 206 */       b++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int readVarInt(ByteBuffer paramByteBuffer) {
/* 217 */     byte b = paramByteBuffer.get();
/* 218 */     if (b >= 0) {
/* 219 */       return b;
/*     */     }
/*     */     
/* 222 */     return readVarIntRest(paramByteBuffer, b);
/*     */   }
/*     */   
/*     */   private static int readVarIntRest(ByteBuffer paramByteBuffer, int paramInt) {
/* 226 */     int i = paramInt & 0x7F;
/* 227 */     paramInt = paramByteBuffer.get();
/* 228 */     if (paramInt >= 0) {
/* 229 */       return i | paramInt << 7;
/*     */     }
/* 231 */     i |= (paramInt & 0x7F) << 7;
/* 232 */     paramInt = paramByteBuffer.get();
/* 233 */     if (paramInt >= 0) {
/* 234 */       return i | paramInt << 14;
/*     */     }
/* 236 */     i |= (paramInt & 0x7F) << 14;
/* 237 */     paramInt = paramByteBuffer.get();
/* 238 */     if (paramInt >= 0) {
/* 239 */       return i | paramInt << 21;
/*     */     }
/* 241 */     i |= (paramInt & 0x7F) << 21 | paramByteBuffer.get() << 28;
/* 242 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long readVarLong(ByteBuffer paramByteBuffer) {
/* 252 */     long l = paramByteBuffer.get();
/* 253 */     if (l >= 0L) {
/* 254 */       return l;
/*     */     }
/* 256 */     l &= 0x7FL;
/* 257 */     for (byte b = 7; b < 64; b += 7) {
/* 258 */       long l1 = paramByteBuffer.get();
/* 259 */       l |= (l1 & 0x7FL) << b;
/* 260 */       if (l1 >= 0L) {
/*     */         break;
/*     */       }
/*     */     } 
/* 264 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeVarInt(OutputStream paramOutputStream, int paramInt) throws IOException {
/* 274 */     while ((paramInt & 0xFFFFFF80) != 0) {
/* 275 */       paramOutputStream.write((byte)(0x80 | paramInt & 0x7F));
/* 276 */       paramInt >>>= 7;
/*     */     } 
/* 278 */     paramOutputStream.write((byte)paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeVarInt(ByteBuffer paramByteBuffer, int paramInt) {
/* 288 */     while ((paramInt & 0xFFFFFF80) != 0) {
/* 289 */       paramByteBuffer.put((byte)(0x80 | paramInt & 0x7F));
/* 290 */       paramInt >>>= 7;
/*     */     } 
/* 292 */     paramByteBuffer.put((byte)paramInt);
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
/*     */   public static void writeStringData(ByteBuffer paramByteBuffer, String paramString, int paramInt) {
/* 304 */     for (byte b = 0; b < paramInt; b++) {
/* 305 */       char c = paramString.charAt(b);
/* 306 */       if (c < '') {
/* 307 */         paramByteBuffer.put((byte)c);
/* 308 */       } else if (c >= 'ࠀ') {
/* 309 */         paramByteBuffer.put((byte)(0xE0 | c >> 12));
/* 310 */         paramByteBuffer.put((byte)(c >> 6 & 0x3F));
/* 311 */         paramByteBuffer.put((byte)(c & 0x3F));
/*     */       } else {
/* 313 */         paramByteBuffer.put((byte)(0xC0 | c >> 6));
/* 314 */         paramByteBuffer.put((byte)(c & 0x3F));
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
/*     */   public static String readString(ByteBuffer paramByteBuffer, int paramInt) {
/* 327 */     char[] arrayOfChar = new char[paramInt];
/* 328 */     for (byte b = 0; b < paramInt; b++) {
/* 329 */       int i = paramByteBuffer.get() & 0xFF;
/* 330 */       if (i < 128) {
/* 331 */         arrayOfChar[b] = (char)i;
/* 332 */       } else if (i >= 224) {
/* 333 */         arrayOfChar[b] = (char)(((i & 0xF) << 12) + ((paramByteBuffer.get() & 0x3F) << 6) + (paramByteBuffer.get() & 0x3F));
/*     */       } else {
/*     */         
/* 336 */         arrayOfChar[b] = (char)(((i & 0x1F) << 6) + (paramByteBuffer.get() & 0x3F));
/*     */       } 
/*     */     } 
/* 339 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeVarLong(ByteBuffer paramByteBuffer, long paramLong) {
/* 349 */     while ((paramLong & 0xFFFFFFFFFFFFFF80L) != 0L) {
/* 350 */       paramByteBuffer.put((byte)(int)(0x80L | paramLong & 0x7FL));
/* 351 */       paramLong >>>= 7L;
/*     */     } 
/* 353 */     paramByteBuffer.put((byte)(int)paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeVarLong(OutputStream paramOutputStream, long paramLong) throws IOException {
/* 364 */     while ((paramLong & 0xFFFFFFFFFFFFFF80L) != 0L) {
/* 365 */       paramOutputStream.write((byte)(int)(0x80L | paramLong & 0x7FL));
/* 366 */       paramLong >>>= 7L;
/*     */     } 
/* 368 */     paramOutputStream.write((byte)(int)paramLong);
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
/*     */   public static void copyWithGap(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2) {
/* 381 */     if (paramInt2 > 0) {
/* 382 */       System.arraycopy(paramObject1, 0, paramObject2, 0, paramInt2);
/*     */     }
/* 384 */     if (paramInt2 < paramInt1) {
/* 385 */       System.arraycopy(paramObject1, paramInt2, paramObject2, paramInt2 + 1, paramInt1 - paramInt2);
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
/*     */   public static void copyExcept(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2) {
/* 400 */     if (paramInt2 > 0 && paramInt1 > 0) {
/* 401 */       System.arraycopy(paramObject1, 0, paramObject2, 0, paramInt2);
/*     */     }
/* 403 */     if (paramInt2 < paramInt1) {
/* 404 */       System.arraycopy(paramObject1, paramInt2 + 1, paramObject2, paramInt2, paramInt1 - paramInt2 - 1);
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
/*     */   public static void readFully(FileChannel paramFileChannel, long paramLong, ByteBuffer paramByteBuffer) {
/*     */     try {
/*     */       while (true)
/* 421 */       { int i = paramFileChannel.read(paramByteBuffer, paramLong);
/* 422 */         if (i < 0) {
/* 423 */           throw new EOFException();
/*     */         }
/* 425 */         paramLong += i;
/* 426 */         if (paramByteBuffer.remaining() <= 0)
/* 427 */         { paramByteBuffer.rewind(); return; }  } 
/* 428 */     } catch (IOException iOException) {
/*     */       long l;
/*     */       try {
/* 431 */         l = paramFileChannel.size();
/* 432 */       } catch (IOException iOException1) {
/* 433 */         l = -1L;
/*     */       } 
/* 435 */       throw newIllegalStateException(1, "Reading from {0} failed; file length {1} read length {2} at {3}", new Object[] { paramFileChannel, Long.valueOf(l), Integer.valueOf(paramByteBuffer.remaining()), Long.valueOf(paramLong), iOException });
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
/*     */   public static void writeFully(FileChannel paramFileChannel, long paramLong, ByteBuffer paramByteBuffer) {
/*     */     try {
/* 452 */       int i = 0;
/*     */       do {
/* 454 */         int j = paramFileChannel.write(paramByteBuffer, paramLong + i);
/* 455 */         i += j;
/* 456 */       } while (paramByteBuffer.remaining() > 0);
/* 457 */     } catch (IOException iOException) {
/* 458 */       throw newIllegalStateException(2, "Writing to {0} failed; length {1} at {2}", new Object[] { paramFileChannel, Integer.valueOf(paramByteBuffer.remaining()), Long.valueOf(paramLong), iOException });
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
/*     */   public static int encodeLength(int paramInt) {
/* 472 */     if (paramInt <= 32) {
/* 473 */       return 0;
/*     */     }
/* 475 */     int i = Integer.numberOfLeadingZeros(paramInt);
/* 476 */     int j = paramInt << i + 1;
/* 477 */     i += i;
/* 478 */     if ((j & Integer.MIN_VALUE) != 0) {
/* 479 */       i--;
/*     */     }
/* 481 */     if (j << 1 != 0) {
/* 482 */       i--;
/*     */     }
/* 484 */     i = Math.min(31, 52 - i);
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
/* 495 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPageChunkId(long paramLong) {
/* 505 */     return (int)(paramLong >>> 38L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPageMaxLength(long paramLong) {
/* 516 */     int i = (int)(paramLong >> 1L & 0x1FL);
/* 517 */     if (i == 31) {
/* 518 */       return 2097152;
/*     */     }
/* 520 */     return 2 + (i & 0x1) << (i >> 1) + 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPageOffset(long paramLong) {
/* 530 */     return (int)(paramLong >> 6L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPageType(long paramLong) {
/* 540 */     return (int)paramLong & 0x1;
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
/*     */   public static long getPagePos(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 556 */     long l = paramInt1 << 38L;
/* 557 */     l |= paramInt2 << 6L;
/* 558 */     l |= (encodeLength(paramInt3) << 1);
/* 559 */     l |= paramInt4;
/* 560 */     return l;
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
/*     */   public static short getCheckValue(int paramInt) {
/* 572 */     return (short)(paramInt >> 16 ^ paramInt);
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
/*     */   public static StringBuilder appendMap(StringBuilder paramStringBuilder, HashMap<String, ?> paramHashMap) {
/* 584 */     ArrayList<Comparable> arrayList = New.arrayList(paramHashMap.keySet());
/* 585 */     Collections.sort(arrayList);
/* 586 */     for (String str : arrayList) {
/* 587 */       appendMap(paramStringBuilder, str, paramHashMap.get(str));
/*     */     }
/* 589 */     return paramStringBuilder;
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
/*     */   public static void appendMap(StringBuilder paramStringBuilder, String paramString, Object paramObject) {
/*     */     String str;
/* 602 */     if (paramStringBuilder.length() > 0) {
/* 603 */       paramStringBuilder.append(',');
/*     */     }
/* 605 */     paramStringBuilder.append(paramString).append(':');
/*     */     
/* 607 */     if (paramObject instanceof Long) {
/* 608 */       str = Long.toHexString(((Long)paramObject).longValue());
/* 609 */     } else if (paramObject instanceof Integer) {
/* 610 */       str = Integer.toHexString(((Integer)paramObject).intValue());
/*     */     } else {
/* 612 */       str = paramObject.toString();
/*     */     } 
/* 614 */     if (str.indexOf(',') < 0 && str.indexOf('"') < 0) {
/* 615 */       paramStringBuilder.append(str);
/*     */     } else {
/* 617 */       paramStringBuilder.append('"'); byte b; int i;
/* 618 */       for (b = 0, i = str.length(); b < i; b++) {
/* 619 */         char c = str.charAt(b);
/* 620 */         if (c == '"') {
/* 621 */           paramStringBuilder.append('\\');
/*     */         }
/* 623 */         paramStringBuilder.append(c);
/*     */       } 
/* 625 */       paramStringBuilder.append('"');
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
/*     */   public static HashMap<String, String> parseMap(String paramString) {
/* 637 */     HashMap<String, String> hashMap = New.hashMap();
/* 638 */     for (int i = 0, j = paramString.length(); i < j; ) {
/* 639 */       int k = i;
/* 640 */       i = paramString.indexOf(':', i);
/* 641 */       if (i < 0) {
/* 642 */         throw newIllegalStateException(6, "Not a map: {0}", new Object[] { paramString });
/*     */       }
/*     */       
/* 645 */       String str = paramString.substring(k, i++);
/* 646 */       StringBuilder stringBuilder = new StringBuilder();
/* 647 */       while (i < j) {
/* 648 */         char c = paramString.charAt(i++);
/* 649 */         if (c == ',')
/*     */           break; 
/* 651 */         if (c == '"') {
/* 652 */           while (i < j) {
/* 653 */             c = paramString.charAt(i++);
/* 654 */             if (c == '\\') {
/* 655 */               if (i == j) {
/* 656 */                 throw newIllegalStateException(6, "Not a map: {0}", new Object[] { paramString });
/*     */               }
/*     */ 
/*     */               
/* 660 */               c = paramString.charAt(i++);
/* 661 */             } else if (c == '"') {
/*     */               break;
/*     */             } 
/* 664 */             stringBuilder.append(c);
/*     */           }  continue;
/*     */         } 
/* 667 */         stringBuilder.append(c);
/*     */       } 
/*     */       
/* 670 */       hashMap.put(str, stringBuilder.toString());
/*     */     } 
/* 672 */     return hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getFletcher32(byte[] paramArrayOfbyte, int paramInt) {
/* 683 */     int i = 65535, j = 65535;
/* 684 */     byte b = 0; int k = paramInt / 2 * 2;
/* 685 */     while (b < k) {
/*     */       
/* 687 */       for (int m = Math.min(b + 720, k); b < m; ) {
/* 688 */         int n = (paramArrayOfbyte[b++] & 0xFF) << 8 | paramArrayOfbyte[b++] & 0xFF;
/* 689 */         j += i += n;
/*     */       } 
/* 691 */       i = (i & 0xFFFF) + (i >>> 16);
/* 692 */       j = (j & 0xFFFF) + (j >>> 16);
/*     */     } 
/* 694 */     if (b < paramInt) {
/*     */       
/* 696 */       int m = (paramArrayOfbyte[b] & 0xFF) << 8;
/* 697 */       j += i += m;
/*     */     } 
/* 699 */     i = (i & 0xFFFF) + (i >>> 16);
/* 700 */     j = (j & 0xFFFF) + (j >>> 16);
/* 701 */     return j << 16 | i;
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
/*     */   public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/* 714 */     if (!paramBoolean) {
/* 715 */       throw newIllegalArgumentException(paramString, paramVarArgs);
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
/*     */   public static IllegalArgumentException newIllegalArgumentException(String paramString, Object... paramVarArgs) {
/* 728 */     return initCause(new IllegalArgumentException(formatMessage(0, paramString, paramVarArgs)), paramVarArgs);
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
/*     */   public static UnsupportedOperationException newUnsupportedOperationException(String paramString) {
/* 741 */     return new UnsupportedOperationException(formatMessage(0, paramString, new Object[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ConcurrentModificationException newConcurrentModificationException(String paramString) {
/* 752 */     return new ConcurrentModificationException(formatMessage(0, paramString, new Object[0]));
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
/*     */   public static IllegalStateException newIllegalStateException(int paramInt, String paramString, Object... paramVarArgs) {
/* 765 */     return initCause(new IllegalStateException(formatMessage(paramInt, paramString, paramVarArgs)), paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T extends Exception> T initCause(T paramT, Object... paramVarArgs) {
/* 771 */     int i = paramVarArgs.length;
/* 772 */     if (i > 0) {
/* 773 */       Object object = paramVarArgs[i - 1];
/* 774 */       if (object instanceof Exception) {
/* 775 */         paramT.initCause((Exception)object);
/*     */       }
/*     */     } 
/* 778 */     return paramT;
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
/*     */   public static String formatMessage(int paramInt, String paramString, Object... paramVarArgs) {
/* 792 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 793 */       Object object = paramVarArgs[b];
/* 794 */       if (!(object instanceof Exception)) {
/* 795 */         String str = (object == null) ? "null" : object.toString();
/* 796 */         if (str.length() > 1000) {
/* 797 */           str = str.substring(0, 1000) + "...";
/*     */         }
/* 799 */         paramVarArgs[b] = str;
/*     */       } 
/*     */     } 
/* 802 */     return MessageFormat.format(paramString, paramVarArgs) + " [" + '\001' + "." + '\004' + "." + 'Á' + "/" + paramInt + "]";
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
/*     */   public static int getErrorCode(String paramString) {
/* 815 */     if (paramString != null && paramString.endsWith("]")) {
/* 816 */       int i = paramString.lastIndexOf('/');
/* 817 */       if (i >= 0) {
/* 818 */         String str = paramString.substring(i + 1, paramString.length() - 1);
/*     */         try {
/* 820 */           return Integer.parseInt(str);
/* 821 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 826 */     return 0;
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
/*     */   public static byte[] newBytes(int paramInt) {
/* 843 */     if (paramInt == 0) {
/* 844 */       return EMPTY_BYTES;
/*     */     }
/*     */     try {
/* 847 */       return new byte[paramInt];
/* 848 */     } catch (OutOfMemoryError outOfMemoryError1) {
/* 849 */       OutOfMemoryError outOfMemoryError2 = new OutOfMemoryError("Requested memory: " + paramInt);
/* 850 */       outOfMemoryError2.initCause(outOfMemoryError1);
/* 851 */       throw outOfMemoryError2;
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
/*     */   public static long readHexLong(Map<String, ? extends Object> paramMap, String paramString, long paramLong) {
/* 866 */     Object object = paramMap.get(paramString);
/* 867 */     if (object == null)
/* 868 */       return paramLong; 
/* 869 */     if (object instanceof Long) {
/* 870 */       return ((Long)object).longValue();
/*     */     }
/*     */     try {
/* 873 */       return parseHexLong((String)object);
/* 874 */     } catch (NumberFormatException numberFormatException) {
/* 875 */       throw newIllegalStateException(6, "Error parsing the value {0}", new Object[] { object, numberFormatException });
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
/*     */   public static long parseHexLong(String paramString) {
/*     */     try {
/* 889 */       if (paramString.length() == 16)
/*     */       {
/*     */         
/* 892 */         return Long.parseLong(paramString.substring(0, 8), 16) << 32L | Long.parseLong(paramString.substring(8, 16), 16);
/*     */       }
/*     */       
/* 895 */       return Long.parseLong(paramString, 16);
/* 896 */     } catch (NumberFormatException numberFormatException) {
/* 897 */       throw newIllegalStateException(6, "Error parsing the value {0}", new Object[] { paramString, numberFormatException });
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
/*     */   public static int parseHexInt(String paramString) {
/*     */     try {
/* 913 */       return (int)Long.parseLong(paramString, 16);
/* 914 */     } catch (NumberFormatException numberFormatException) {
/* 915 */       throw newIllegalStateException(6, "Error parsing the value {0}", new Object[] { paramString, numberFormatException });
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
/*     */   public static int readHexInt(HashMap<String, ? extends Object> paramHashMap, String paramString, int paramInt) {
/* 931 */     Object object = paramHashMap.get(paramString);
/* 932 */     if (object == null)
/* 933 */       return paramInt; 
/* 934 */     if (object instanceof Integer) {
/* 935 */       return ((Integer)object).intValue();
/*     */     }
/*     */     
/*     */     try {
/* 939 */       return (int)Long.parseLong((String)object, 16);
/* 940 */     } catch (NumberFormatException numberFormatException) {
/* 941 */       throw newIllegalStateException(6, "Error parsing the value {0}", new Object[] { object, numberFormatException });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class MapEntry<K, V>
/*     */     implements Map.Entry<K, V>
/*     */   {
/*     */     private final K key;
/*     */ 
/*     */     
/*     */     private V value;
/*     */ 
/*     */ 
/*     */     
/*     */     public MapEntry(K param1K, V param1V) {
/* 958 */       this.key = param1K;
/* 959 */       this.value = param1V;
/*     */     }
/*     */ 
/*     */     
/*     */     public K getKey() {
/* 964 */       return this.key;
/*     */     }
/*     */ 
/*     */     
/*     */     public V getValue() {
/* 969 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 974 */       throw DataUtils.newUnsupportedOperationException("Updating the value is not supported");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\DataUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */