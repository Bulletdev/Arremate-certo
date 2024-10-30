/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XMLChar
/*     */ {
/*  48 */   private static final byte[] CHARS = new byte[65536];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_VALID = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_SPACE = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_NAME_START = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_NAME = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_PUBID = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_CONTENT = 32;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_NCNAME_START = 64;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MASK_NCNAME = 128;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  92 */     int[] arrayOfInt1 = { 9, 10, 13, 13, 32, 55295, 57344, 65533 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     int[] arrayOfInt2 = { 32, 9, 13, 10 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     int[] arrayOfInt3 = { 45, 46 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     int[] arrayOfInt4 = { 58, 95 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     int[] arrayOfInt5 = { 10, 13, 32, 33, 35, 36, 37, 61, 95 };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     int[] arrayOfInt6 = { 39, 59, 63, 90, 97, 122 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     int[] arrayOfInt7 = { 65, 90, 97, 122, 192, 214, 216, 246, 248, 305, 308, 318, 321, 328, 330, 382, 384, 451, 461, 496, 500, 501, 506, 535, 592, 680, 699, 705, 904, 906, 910, 929, 931, 974, 976, 982, 994, 1011, 1025, 1036, 1038, 1103, 1105, 1116, 1118, 1153, 1168, 1220, 1223, 1224, 1227, 1228, 1232, 1259, 1262, 1269, 1272, 1273, 1329, 1366, 1377, 1414, 1488, 1514, 1520, 1522, 1569, 1594, 1601, 1610, 1649, 1719, 1722, 1726, 1728, 1742, 1744, 1747, 1765, 1766, 2309, 2361, 2392, 2401, 2437, 2444, 2447, 2448, 2451, 2472, 2474, 2480, 2486, 2489, 2524, 2525, 2527, 2529, 2544, 2545, 2565, 2570, 2575, 2576, 2579, 2600, 2602, 2608, 2610, 2611, 2613, 2614, 2616, 2617, 2649, 2652, 2674, 2676, 2693, 2699, 2703, 2705, 2707, 2728, 2730, 2736, 2738, 2739, 2741, 2745, 2821, 2828, 2831, 2832, 2835, 2856, 2858, 2864, 2866, 2867, 2870, 2873, 2908, 2909, 2911, 2913, 2949, 2954, 2958, 2960, 2962, 2965, 2969, 2970, 2974, 2975, 2979, 2980, 2984, 2986, 2990, 2997, 2999, 3001, 3077, 3084, 3086, 3088, 3090, 3112, 3114, 3123, 3125, 3129, 3168, 3169, 3205, 3212, 3214, 3216, 3218, 3240, 3242, 3251, 3253, 3257, 3296, 3297, 3333, 3340, 3342, 3344, 3346, 3368, 3370, 3385, 3424, 3425, 3585, 3630, 3634, 3635, 3648, 3653, 3713, 3714, 3719, 3720, 3732, 3735, 3737, 3743, 3745, 3747, 3754, 3755, 3757, 3758, 3762, 3763, 3776, 3780, 3904, 3911, 3913, 3945, 4256, 4293, 4304, 4342, 4354, 4355, 4357, 4359, 4363, 4364, 4366, 4370, 4436, 4437, 4447, 4449, 4461, 4462, 4466, 4467, 4526, 4527, 4535, 4536, 4540, 4546, 7680, 7835, 7840, 7929, 7936, 7957, 7960, 7965, 7968, 8005, 8008, 8013, 8016, 8023, 8031, 8061, 8064, 8116, 8118, 8124, 8130, 8132, 8134, 8140, 8144, 8147, 8150, 8155, 8160, 8172, 8178, 8180, 8182, 8188, 8490, 8491, 8576, 8578, 12353, 12436, 12449, 12538, 12549, 12588, 44032, 55203, 12321, 12329, 19968, 40869 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     int[] arrayOfInt8 = { 902, 908, 986, 988, 990, 992, 1369, 1749, 2365, 2482, 2654, 2701, 2749, 2784, 2877, 2972, 3294, 3632, 3716, 3722, 3725, 3749, 3751, 3760, 3773, 4352, 4361, 4412, 4414, 4416, 4428, 4430, 4432, 4441, 4451, 4453, 4455, 4457, 4469, 4510, 4520, 4523, 4538, 4587, 4592, 4601, 8025, 8027, 8029, 8126, 8486, 8494, 12295 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     int[] arrayOfInt9 = { 768, 837, 864, 865, 1155, 1158, 1425, 1441, 1443, 1465, 1467, 1469, 1473, 1474, 1611, 1618, 1750, 1756, 1757, 1759, 1760, 1764, 1767, 1768, 1770, 1773, 2305, 2307, 2366, 2380, 2385, 2388, 2402, 2403, 2433, 2435, 2496, 2500, 2503, 2504, 2507, 2509, 2530, 2531, 2624, 2626, 2631, 2632, 2635, 2637, 2672, 2673, 2689, 2691, 2750, 2757, 2759, 2761, 2763, 2765, 2817, 2819, 2878, 2883, 2887, 2888, 2891, 2893, 2902, 2903, 2946, 2947, 3006, 3010, 3014, 3016, 3018, 3021, 3073, 3075, 3134, 3140, 3142, 3144, 3146, 3149, 3157, 3158, 3202, 3203, 3262, 3268, 3270, 3272, 3274, 3277, 3285, 3286, 3330, 3331, 3390, 3395, 3398, 3400, 3402, 3405, 3636, 3642, 3655, 3662, 3764, 3769, 3771, 3772, 3784, 3789, 3864, 3865, 3953, 3972, 3974, 3979, 3984, 3989, 3993, 4013, 4017, 4023, 8400, 8412, 12330, 12335 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     int[] arrayOfInt10 = { 1471, 1476, 1648, 2364, 2381, 2492, 2494, 2495, 2519, 2562, 2620, 2622, 2623, 2748, 2876, 3031, 3415, 3633, 3761, 3893, 3895, 3897, 3902, 3903, 3991, 4025, 8417, 12441, 12442 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     int[] arrayOfInt11 = { 48, 57, 1632, 1641, 1776, 1785, 2406, 2415, 2534, 2543, 2662, 2671, 2790, 2799, 2918, 2927, 3047, 3055, 3174, 3183, 3302, 3311, 3430, 3439, 3664, 3673, 3792, 3801, 3872, 3881 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     int[] arrayOfInt12 = { 12337, 12341, 12445, 12446, 12540, 12542 };
/*     */ 
/*     */ 
/*     */     
/* 244 */     int[] arrayOfInt13 = { 183, 720, 721, 903, 1600, 3654, 3782, 12293 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     int[] arrayOfInt14 = { 60, 38, 10, 13, 93 };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */ 
/*     */     
/* 261 */     for (b = 0; b < arrayOfInt1.length; b += 2) {
/* 262 */       for (int i = arrayOfInt1[b]; i <= arrayOfInt1[b + 1]; i++) {
/* 263 */         CHARS[i] = (byte)(CHARS[i] | 0x21);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 268 */     for (b = 0; b < arrayOfInt14.length; b++) {
/* 269 */       CHARS[arrayOfInt14[b]] = (byte)(CHARS[arrayOfInt14[b]] & 0xFFFFFFDF);
/*     */     }
/*     */ 
/*     */     
/* 273 */     for (b = 0; b < arrayOfInt2.length; b++) {
/* 274 */       CHARS[arrayOfInt2[b]] = (byte)(CHARS[arrayOfInt2[b]] | 0x2);
/*     */     }
/*     */ 
/*     */     
/* 278 */     for (b = 0; b < arrayOfInt4.length; b++) {
/* 279 */       CHARS[arrayOfInt4[b]] = (byte)(CHARS[arrayOfInt4[b]] | 0xCC);
/*     */     }
/*     */     
/* 282 */     for (b = 0; b < arrayOfInt7.length; b += 2) {
/* 283 */       for (int i = arrayOfInt7[b]; i <= arrayOfInt7[b + 1]; i++) {
/* 284 */         CHARS[i] = (byte)(CHARS[i] | 0xCC);
/*     */       }
/*     */     } 
/*     */     
/* 288 */     for (b = 0; b < arrayOfInt8.length; b++) {
/* 289 */       CHARS[arrayOfInt8[b]] = (byte)(CHARS[arrayOfInt8[b]] | 0xCC);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 294 */     for (b = 0; b < arrayOfInt3.length; b++) {
/* 295 */       CHARS[arrayOfInt3[b]] = (byte)(CHARS[arrayOfInt3[b]] | 0x88);
/*     */     }
/* 297 */     for (b = 0; b < arrayOfInt11.length; b += 2) {
/* 298 */       for (int i = arrayOfInt11[b]; i <= arrayOfInt11[b + 1]; i++) {
/* 299 */         CHARS[i] = (byte)(CHARS[i] | 0x88);
/*     */       }
/*     */     } 
/* 302 */     for (b = 0; b < arrayOfInt9.length; b += 2) {
/* 303 */       for (int i = arrayOfInt9[b]; i <= arrayOfInt9[b + 1]; i++) {
/* 304 */         CHARS[i] = (byte)(CHARS[i] | 0x88);
/*     */       }
/*     */     } 
/* 307 */     for (b = 0; b < arrayOfInt10.length; b++) {
/* 308 */       CHARS[arrayOfInt10[b]] = (byte)(CHARS[arrayOfInt10[b]] | 0x88);
/*     */     }
/* 310 */     for (b = 0; b < arrayOfInt12.length; b += 2) {
/* 311 */       for (int i = arrayOfInt12[b]; i <= arrayOfInt12[b + 1]; i++) {
/* 312 */         CHARS[i] = (byte)(CHARS[i] | 0x88);
/*     */       }
/*     */     } 
/* 315 */     for (b = 0; b < arrayOfInt13.length; b++) {
/* 316 */       CHARS[arrayOfInt13[b]] = (byte)(CHARS[arrayOfInt13[b]] | 0x88);
/*     */     }
/*     */ 
/*     */     
/* 320 */     CHARS[58] = (byte)(CHARS[58] & 0xFFFFFF3F);
/*     */ 
/*     */     
/* 323 */     for (b = 0; b < arrayOfInt5.length; b++) {
/* 324 */       CHARS[arrayOfInt5[b]] = (byte)(CHARS[arrayOfInt5[b]] | 0x10);
/*     */     }
/* 326 */     for (b = 0; b < arrayOfInt6.length; b += 2) {
/* 327 */       for (int i = arrayOfInt6[b]; i <= arrayOfInt6[b + 1]; i++) {
/* 328 */         CHARS[i] = (byte)(CHARS[i] | 0x10);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSupplemental(int paramInt) {
/* 344 */     return (paramInt >= 65536 && paramInt <= 1114111);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int supplemental(char paramChar1, char paramChar2) {
/* 355 */     return (paramChar1 - 55296) * 1024 + paramChar2 - 56320 + 65536;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char highSurrogate(int paramInt) {
/* 364 */     return (char)((paramInt - 65536 >> 10) + 55296);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char lowSurrogate(int paramInt) {
/* 373 */     return (char)((paramInt - 65536 & 0x3FF) + 56320);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isHighSurrogate(int paramInt) {
/* 382 */     return (55296 <= paramInt && paramInt <= 56319);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isLowSurrogate(int paramInt) {
/* 391 */     return (56320 <= paramInt && paramInt <= 57343);
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
/*     */   public static boolean isValid(int paramInt) {
/* 406 */     return ((paramInt < 65536 && (CHARS[paramInt] & 0x1) != 0) || (65536 <= paramInt && paramInt <= 1114111));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isInvalid(int paramInt) {
/* 416 */     return !isValid(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isContent(int paramInt) {
/* 425 */     return ((paramInt < 65536 && (CHARS[paramInt] & 0x20) != 0) || (65536 <= paramInt && paramInt <= 1114111));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMarkup(int paramInt) {
/* 436 */     return (paramInt == 60 || paramInt == 38 || paramInt == 37);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSpace(int paramInt) {
/* 446 */     return (paramInt < 65536 && (CHARS[paramInt] & 0x2) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isXML11Space(int paramInt) {
/* 456 */     return ((paramInt < 65536 && (CHARS[paramInt] & 0x2) != 0) || paramInt == 133 || paramInt == 8232);
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
/*     */   public static boolean isNameStart(int paramInt) {
/* 468 */     return (paramInt < 65536 && (CHARS[paramInt] & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isName(int paramInt) {
/* 479 */     return (paramInt < 65536 && (CHARS[paramInt] & 0x8) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isNCNameStart(int paramInt) {
/* 490 */     return (paramInt < 65536 && (CHARS[paramInt] & 0x40) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isNCName(int paramInt) {
/* 501 */     return (paramInt < 65536 && (CHARS[paramInt] & 0x80) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isPubid(int paramInt) {
/* 512 */     return (paramInt < 65536 && (CHARS[paramInt] & 0x10) != 0);
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
/*     */   public static boolean isValidName(String paramString) {
/* 526 */     if (paramString.length() == 0)
/* 527 */       return false; 
/* 528 */     char c = paramString.charAt(0);
/* 529 */     if (!isNameStart(c))
/* 530 */       return false; 
/* 531 */     for (byte b = 1; b < paramString.length(); b++) {
/* 532 */       c = paramString.charAt(b);
/* 533 */       if (!isName(c)) {
/* 534 */         return false;
/*     */       }
/*     */     } 
/* 537 */     return true;
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
/*     */   public static boolean isValidNCName(String paramString) {
/* 553 */     if (paramString.length() == 0)
/* 554 */       return false; 
/* 555 */     char c = paramString.charAt(0);
/* 556 */     if (!isNCNameStart(c))
/* 557 */       return false; 
/* 558 */     for (byte b = 1; b < paramString.length(); b++) {
/* 559 */       c = paramString.charAt(b);
/* 560 */       if (!isNCName(c)) {
/* 561 */         return false;
/*     */       }
/*     */     } 
/* 564 */     return true;
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
/*     */   public static boolean isValidNmtoken(String paramString) {
/* 578 */     if (paramString.length() == 0)
/* 579 */       return false; 
/* 580 */     for (byte b = 0; b < paramString.length(); b++) {
/* 581 */       char c = paramString.charAt(b);
/* 582 */       if (!isName(c)) {
/* 583 */         return false;
/*     */       }
/*     */     } 
/* 586 */     return true;
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
/*     */   public static boolean isValidIANAEncoding(String paramString) {
/* 604 */     if (paramString != null) {
/* 605 */       int i = paramString.length();
/* 606 */       if (i > 0) {
/* 607 */         char c = paramString.charAt(0);
/* 608 */         if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
/* 609 */           for (byte b = 1; b < i; b++) {
/* 610 */             c = paramString.charAt(b);
/* 611 */             if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '.' && c != '_' && c != '-')
/*     */             {
/*     */               
/* 614 */               return false;
/*     */             }
/*     */           } 
/* 617 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 621 */     return false;
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
/*     */   public static boolean isValidJavaEncoding(String paramString) {
/* 633 */     if (paramString != null) {
/* 634 */       int i = paramString.length();
/* 635 */       if (i > 0) {
/* 636 */         for (byte b = 1; b < i; b++) {
/* 637 */           char c = paramString.charAt(b);
/* 638 */           if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '.' && c != '_' && c != '-')
/*     */           {
/*     */             
/* 641 */             return false;
/*     */           }
/*     */         } 
/* 644 */         return true;
/*     */       } 
/*     */     } 
/* 647 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XMLChar.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */