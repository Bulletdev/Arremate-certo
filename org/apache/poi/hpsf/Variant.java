/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Variant
/*     */ {
/*     */   public static final int VT_EMPTY = 0;
/*     */   public static final int VT_NULL = 1;
/*     */   public static final int VT_I2 = 2;
/*     */   public static final int VT_I4 = 3;
/*     */   public static final int VT_R4 = 4;
/*     */   public static final int VT_R8 = 5;
/*     */   public static final int VT_CY = 6;
/*     */   public static final int VT_DATE = 7;
/*     */   public static final int VT_BSTR = 8;
/*     */   public static final int VT_DISPATCH = 9;
/*     */   public static final int VT_ERROR = 10;
/*     */   public static final int VT_BOOL = 11;
/*     */   public static final int VT_VARIANT = 12;
/*     */   public static final int VT_UNKNOWN = 13;
/*     */   public static final int VT_DECIMAL = 14;
/*     */   public static final int VT_I1 = 16;
/*     */   public static final int VT_UI1 = 17;
/*     */   public static final int VT_UI2 = 18;
/*     */   public static final int VT_UI4 = 19;
/*     */   public static final int VT_I8 = 20;
/*     */   public static final int VT_UI8 = 21;
/*     */   public static final int VT_INT = 22;
/*     */   public static final int VT_UINT = 23;
/*     */   public static final int VT_VOID = 24;
/*     */   public static final int VT_HRESULT = 25;
/*     */   public static final int VT_PTR = 26;
/*     */   public static final int VT_SAFEARRAY = 27;
/*     */   public static final int VT_CARRAY = 28;
/*     */   public static final int VT_USERDEFINED = 29;
/*     */   public static final int VT_LPSTR = 30;
/*     */   public static final int VT_LPWSTR = 31;
/*     */   public static final int VT_FILETIME = 64;
/*     */   public static final int VT_BLOB = 65;
/*     */   public static final int VT_STREAM = 66;
/*     */   public static final int VT_STORAGE = 67;
/*     */   public static final int VT_STREAMED_OBJECT = 68;
/*     */   public static final int VT_STORED_OBJECT = 69;
/*     */   public static final int VT_BLOB_OBJECT = 70;
/*     */   public static final int VT_CF = 71;
/*     */   public static final int VT_CLSID = 72;
/*     */   public static final int VT_VERSIONED_STREAM = 73;
/*     */   public static final int VT_VECTOR = 4096;
/*     */   public static final int VT_ARRAY = 8192;
/*     */   public static final int VT_BYREF = 16384;
/*     */   public static final int VT_RESERVED = 32768;
/*     */   public static final int VT_ILLEGAL = 65535;
/*     */   public static final int VT_ILLEGALMASKED = 4095;
/*     */   public static final int VT_TYPEMASK = 4095;
/*     */   private static Map<Long, String> numberToName;
/*     */   private static Map<Long, Integer> numberToLength;
/* 360 */   public static final Integer LENGTH_UNKNOWN = Integer.valueOf(-2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 365 */   public static final Integer LENGTH_VARIABLE = Integer.valueOf(-1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 370 */   public static final Integer LENGTH_0 = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 375 */   public static final Integer LENGTH_2 = Integer.valueOf(2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 380 */   public static final Integer LENGTH_4 = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 385 */   public static final Integer LENGTH_8 = Integer.valueOf(8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 392 */     HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 393 */     hashMap1.put(Long.valueOf(0L), "VT_EMPTY");
/* 394 */     hashMap1.put(Long.valueOf(1L), "VT_NULL");
/* 395 */     hashMap1.put(Long.valueOf(2L), "VT_I2");
/* 396 */     hashMap1.put(Long.valueOf(3L), "VT_I4");
/* 397 */     hashMap1.put(Long.valueOf(4L), "VT_R4");
/* 398 */     hashMap1.put(Long.valueOf(5L), "VT_R8");
/* 399 */     hashMap1.put(Long.valueOf(6L), "VT_CY");
/* 400 */     hashMap1.put(Long.valueOf(7L), "VT_DATE");
/* 401 */     hashMap1.put(Long.valueOf(8L), "VT_BSTR");
/* 402 */     hashMap1.put(Long.valueOf(9L), "VT_DISPATCH");
/* 403 */     hashMap1.put(Long.valueOf(10L), "VT_ERROR");
/* 404 */     hashMap1.put(Long.valueOf(11L), "VT_BOOL");
/* 405 */     hashMap1.put(Long.valueOf(12L), "VT_VARIANT");
/* 406 */     hashMap1.put(Long.valueOf(13L), "VT_UNKNOWN");
/* 407 */     hashMap1.put(Long.valueOf(14L), "VT_DECIMAL");
/* 408 */     hashMap1.put(Long.valueOf(16L), "VT_I1");
/* 409 */     hashMap1.put(Long.valueOf(17L), "VT_UI1");
/* 410 */     hashMap1.put(Long.valueOf(18L), "VT_UI2");
/* 411 */     hashMap1.put(Long.valueOf(19L), "VT_UI4");
/* 412 */     hashMap1.put(Long.valueOf(20L), "VT_I8");
/* 413 */     hashMap1.put(Long.valueOf(21L), "VT_UI8");
/* 414 */     hashMap1.put(Long.valueOf(22L), "VT_INT");
/* 415 */     hashMap1.put(Long.valueOf(23L), "VT_UINT");
/* 416 */     hashMap1.put(Long.valueOf(24L), "VT_VOID");
/* 417 */     hashMap1.put(Long.valueOf(25L), "VT_HRESULT");
/* 418 */     hashMap1.put(Long.valueOf(26L), "VT_PTR");
/* 419 */     hashMap1.put(Long.valueOf(27L), "VT_SAFEARRAY");
/* 420 */     hashMap1.put(Long.valueOf(28L), "VT_CARRAY");
/* 421 */     hashMap1.put(Long.valueOf(29L), "VT_USERDEFINED");
/* 422 */     hashMap1.put(Long.valueOf(30L), "VT_LPSTR");
/* 423 */     hashMap1.put(Long.valueOf(31L), "VT_LPWSTR");
/* 424 */     hashMap1.put(Long.valueOf(64L), "VT_FILETIME");
/* 425 */     hashMap1.put(Long.valueOf(65L), "VT_BLOB");
/* 426 */     hashMap1.put(Long.valueOf(66L), "VT_STREAM");
/* 427 */     hashMap1.put(Long.valueOf(67L), "VT_STORAGE");
/* 428 */     hashMap1.put(Long.valueOf(68L), "VT_STREAMED_OBJECT");
/* 429 */     hashMap1.put(Long.valueOf(69L), "VT_STORED_OBJECT");
/* 430 */     hashMap1.put(Long.valueOf(70L), "VT_BLOB_OBJECT");
/* 431 */     hashMap1.put(Long.valueOf(71L), "VT_CF");
/* 432 */     hashMap1.put(Long.valueOf(72L), "VT_CLSID");
/* 433 */     HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>(hashMap1.size(), 1.0F);
/* 434 */     hashMap2.putAll(hashMap1);
/* 435 */     numberToName = Collections.unmodifiableMap(hashMap2);
/*     */ 
/*     */     
/* 438 */     HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
/* 439 */     hashMap3.put(Long.valueOf(0L), LENGTH_0);
/* 440 */     hashMap3.put(Long.valueOf(1L), LENGTH_UNKNOWN);
/* 441 */     hashMap3.put(Long.valueOf(2L), LENGTH_2);
/* 442 */     hashMap3.put(Long.valueOf(3L), LENGTH_4);
/* 443 */     hashMap3.put(Long.valueOf(4L), LENGTH_4);
/* 444 */     hashMap3.put(Long.valueOf(5L), LENGTH_8);
/* 445 */     hashMap3.put(Long.valueOf(6L), LENGTH_UNKNOWN);
/* 446 */     hashMap3.put(Long.valueOf(7L), LENGTH_UNKNOWN);
/* 447 */     hashMap3.put(Long.valueOf(8L), LENGTH_UNKNOWN);
/* 448 */     hashMap3.put(Long.valueOf(9L), LENGTH_UNKNOWN);
/* 449 */     hashMap3.put(Long.valueOf(10L), LENGTH_UNKNOWN);
/* 450 */     hashMap3.put(Long.valueOf(11L), LENGTH_UNKNOWN);
/* 451 */     hashMap3.put(Long.valueOf(12L), LENGTH_UNKNOWN);
/* 452 */     hashMap3.put(Long.valueOf(13L), LENGTH_UNKNOWN);
/* 453 */     hashMap3.put(Long.valueOf(14L), LENGTH_UNKNOWN);
/* 454 */     hashMap3.put(Long.valueOf(16L), LENGTH_UNKNOWN);
/* 455 */     hashMap3.put(Long.valueOf(17L), LENGTH_UNKNOWN);
/* 456 */     hashMap3.put(Long.valueOf(18L), LENGTH_UNKNOWN);
/* 457 */     hashMap3.put(Long.valueOf(19L), LENGTH_UNKNOWN);
/* 458 */     hashMap3.put(Long.valueOf(20L), LENGTH_UNKNOWN);
/* 459 */     hashMap3.put(Long.valueOf(21L), LENGTH_UNKNOWN);
/* 460 */     hashMap3.put(Long.valueOf(22L), LENGTH_UNKNOWN);
/* 461 */     hashMap3.put(Long.valueOf(23L), LENGTH_UNKNOWN);
/* 462 */     hashMap3.put(Long.valueOf(24L), LENGTH_UNKNOWN);
/* 463 */     hashMap3.put(Long.valueOf(25L), LENGTH_UNKNOWN);
/* 464 */     hashMap3.put(Long.valueOf(26L), LENGTH_UNKNOWN);
/* 465 */     hashMap3.put(Long.valueOf(27L), LENGTH_UNKNOWN);
/* 466 */     hashMap3.put(Long.valueOf(28L), LENGTH_UNKNOWN);
/* 467 */     hashMap3.put(Long.valueOf(29L), LENGTH_UNKNOWN);
/* 468 */     hashMap3.put(Long.valueOf(30L), LENGTH_VARIABLE);
/* 469 */     hashMap3.put(Long.valueOf(31L), LENGTH_UNKNOWN);
/* 470 */     hashMap3.put(Long.valueOf(64L), LENGTH_8);
/* 471 */     hashMap3.put(Long.valueOf(65L), LENGTH_UNKNOWN);
/* 472 */     hashMap3.put(Long.valueOf(66L), LENGTH_UNKNOWN);
/* 473 */     hashMap3.put(Long.valueOf(67L), LENGTH_UNKNOWN);
/* 474 */     hashMap3.put(Long.valueOf(68L), LENGTH_UNKNOWN);
/* 475 */     hashMap3.put(Long.valueOf(69L), LENGTH_UNKNOWN);
/* 476 */     hashMap3.put(Long.valueOf(70L), LENGTH_UNKNOWN);
/* 477 */     hashMap3.put(Long.valueOf(71L), LENGTH_UNKNOWN);
/* 478 */     hashMap3.put(Long.valueOf(72L), LENGTH_UNKNOWN);
/* 479 */     HashMap<Object, Object> hashMap4 = new HashMap<Object, Object>(hashMap1.size(), 1.0F);
/* 480 */     hashMap4.putAll(hashMap3);
/* 481 */     numberToLength = Collections.unmodifiableMap(hashMap4);
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
/*     */   public static String getVariantName(long paramLong) {
/* 495 */     String str = numberToName.get(Long.valueOf(paramLong));
/* 496 */     return (str != null) ? str : "unknown variant type";
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
/*     */   public static int getVariantLength(long paramLong) {
/* 510 */     Long long_ = Long.valueOf((int)paramLong);
/* 511 */     Integer integer = numberToLength.get(long_);
/* 512 */     if (integer == null)
/* 513 */       return -2; 
/* 514 */     return integer.intValue();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */