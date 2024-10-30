/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlWhitespace
/*    */ {
/*    */   public static final int WS_UNSPECIFIED = 0;
/*    */   public static final int WS_PRESERVE = 1;
/*    */   public static final int WS_REPLACE = 2;
/*    */   public static final int WS_COLLAPSE = 3;
/*    */   
/*    */   public static boolean isSpace(char paramChar) {
/* 30 */     switch (paramChar) {
/*    */       
/*    */       case '\t':
/*    */       case '\n':
/*    */       case '\r':
/*    */       case ' ':
/* 36 */         return true;
/*    */     } 
/* 38 */     return false;
/*    */   }
/*    */   public static boolean isAllSpace(String paramString) {
/*    */     byte b;
/*    */     int i;
/* 43 */     for (b = 0, i = paramString.length(); b < i; b++) {
/*    */       
/* 45 */       if (!isSpace(paramString.charAt(b)))
/* 46 */         return false; 
/*    */     } 
/* 48 */     return true;
/*    */   }
/*    */   public static boolean isAllSpace(CharSequence paramCharSequence) {
/*    */     byte b;
/*    */     int i;
/* 53 */     for (b = 0, i = paramCharSequence.length(); b < i; b++) {
/*    */       
/* 55 */       if (!isSpace(paramCharSequence.charAt(b)))
/* 56 */         return false; 
/*    */     } 
/* 58 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String collapse(String paramString) {
/* 63 */     return collapse(paramString, 3);
/*    */   }
/*    */   
/*    */   public static String collapse(String paramString, int paramInt) {
/*    */     // Byte code:
/*    */     //   0: iload_1
/*    */     //   1: iconst_1
/*    */     //   2: if_icmpeq -> 9
/*    */     //   5: iload_1
/*    */     //   6: ifne -> 11
/*    */     //   9: aload_0
/*    */     //   10: areturn
/*    */     //   11: aload_0
/*    */     //   12: bipush #10
/*    */     //   14: invokevirtual indexOf : (I)I
/*    */     //   17: iflt -> 29
/*    */     //   20: aload_0
/*    */     //   21: bipush #10
/*    */     //   23: bipush #32
/*    */     //   25: invokevirtual replace : (CC)Ljava/lang/String;
/*    */     //   28: astore_0
/*    */     //   29: aload_0
/*    */     //   30: bipush #9
/*    */     //   32: invokevirtual indexOf : (I)I
/*    */     //   35: iflt -> 47
/*    */     //   38: aload_0
/*    */     //   39: bipush #9
/*    */     //   41: bipush #32
/*    */     //   43: invokevirtual replace : (CC)Ljava/lang/String;
/*    */     //   46: astore_0
/*    */     //   47: aload_0
/*    */     //   48: bipush #13
/*    */     //   50: invokevirtual indexOf : (I)I
/*    */     //   53: iflt -> 65
/*    */     //   56: aload_0
/*    */     //   57: bipush #13
/*    */     //   59: bipush #32
/*    */     //   61: invokevirtual replace : (CC)Ljava/lang/String;
/*    */     //   64: astore_0
/*    */     //   65: iload_1
/*    */     //   66: iconst_2
/*    */     //   67: if_icmpne -> 72
/*    */     //   70: aload_0
/*    */     //   71: areturn
/*    */     //   72: iconst_0
/*    */     //   73: istore_2
/*    */     //   74: aload_0
/*    */     //   75: invokevirtual length : ()I
/*    */     //   78: istore_3
/*    */     //   79: iload_3
/*    */     //   80: ifne -> 85
/*    */     //   83: aload_0
/*    */     //   84: areturn
/*    */     //   85: aload_0
/*    */     //   86: iconst_0
/*    */     //   87: invokevirtual charAt : (I)C
/*    */     //   90: bipush #32
/*    */     //   92: if_icmpeq -> 187
/*    */     //   95: iconst_2
/*    */     //   96: istore_2
/*    */     //   97: iload_2
/*    */     //   98: iload_3
/*    */     //   99: if_icmpge -> 159
/*    */     //   102: aload_0
/*    */     //   103: iload_2
/*    */     //   104: invokevirtual charAt : (I)C
/*    */     //   107: bipush #32
/*    */     //   109: if_icmpne -> 153
/*    */     //   112: aload_0
/*    */     //   113: iload_2
/*    */     //   114: iconst_1
/*    */     //   115: isub
/*    */     //   116: invokevirtual charAt : (I)C
/*    */     //   119: bipush #32
/*    */     //   121: if_icmpne -> 127
/*    */     //   124: goto -> 181
/*    */     //   127: iload_2
/*    */     //   128: iload_3
/*    */     //   129: iconst_1
/*    */     //   130: isub
/*    */     //   131: if_icmpne -> 137
/*    */     //   134: goto -> 181
/*    */     //   137: iinc #2, 1
/*    */     //   140: aload_0
/*    */     //   141: iload_2
/*    */     //   142: invokevirtual charAt : (I)C
/*    */     //   145: bipush #32
/*    */     //   147: if_icmpne -> 153
/*    */     //   150: goto -> 181
/*    */     //   153: iinc #2, 2
/*    */     //   156: goto -> 97
/*    */     //   159: iload_2
/*    */     //   160: iload_3
/*    */     //   161: if_icmpne -> 179
/*    */     //   164: aload_0
/*    */     //   165: iload_2
/*    */     //   166: iconst_1
/*    */     //   167: isub
/*    */     //   168: invokevirtual charAt : (I)C
/*    */     //   171: bipush #32
/*    */     //   173: if_icmpne -> 179
/*    */     //   176: goto -> 181
/*    */     //   179: aload_0
/*    */     //   180: areturn
/*    */     //   181: iload_2
/*    */     //   182: istore #4
/*    */     //   184: goto -> 218
/*    */     //   187: iload_2
/*    */     //   188: iconst_1
/*    */     //   189: iadd
/*    */     //   190: aload_0
/*    */     //   191: invokevirtual length : ()I
/*    */     //   194: if_icmpge -> 215
/*    */     //   197: aload_0
/*    */     //   198: iload_2
/*    */     //   199: iconst_1
/*    */     //   200: iadd
/*    */     //   201: invokevirtual charAt : (I)C
/*    */     //   204: bipush #32
/*    */     //   206: if_icmpne -> 215
/*    */     //   209: iinc #2, 1
/*    */     //   212: goto -> 187
/*    */     //   215: iconst_0
/*    */     //   216: istore #4
/*    */     //   218: aload_0
/*    */     //   219: invokevirtual toCharArray : ()[C
/*    */     //   222: astore #5
/*    */     //   224: iinc #2, 1
/*    */     //   227: iload_2
/*    */     //   228: iload_3
/*    */     //   229: if_icmplt -> 235
/*    */     //   232: goto -> 315
/*    */     //   235: aload_0
/*    */     //   236: iload_2
/*    */     //   237: invokevirtual charAt : (I)C
/*    */     //   240: bipush #32
/*    */     //   242: if_icmpeq -> 224
/*    */     //   245: goto -> 248
/*    */     //   248: aload #5
/*    */     //   250: iload #4
/*    */     //   252: iinc #4, 1
/*    */     //   255: aload #5
/*    */     //   257: iload_2
/*    */     //   258: iinc #2, 1
/*    */     //   261: caload
/*    */     //   262: castore
/*    */     //   263: iload_2
/*    */     //   264: iload_3
/*    */     //   265: if_icmplt -> 271
/*    */     //   268: goto -> 315
/*    */     //   271: aload #5
/*    */     //   273: iload_2
/*    */     //   274: caload
/*    */     //   275: bipush #32
/*    */     //   277: if_icmpne -> 248
/*    */     //   280: aload #5
/*    */     //   282: iload #4
/*    */     //   284: iinc #4, 1
/*    */     //   287: aload #5
/*    */     //   289: iload_2
/*    */     //   290: iinc #2, 1
/*    */     //   293: caload
/*    */     //   294: castore
/*    */     //   295: iload_2
/*    */     //   296: iload_3
/*    */     //   297: if_icmplt -> 303
/*    */     //   300: goto -> 315
/*    */     //   303: aload #5
/*    */     //   305: iload_2
/*    */     //   306: caload
/*    */     //   307: bipush #32
/*    */     //   309: if_icmpne -> 248
/*    */     //   312: goto -> 224
/*    */     //   315: new java/lang/String
/*    */     //   318: dup
/*    */     //   319: aload #5
/*    */     //   321: iconst_0
/*    */     //   322: iload #4
/*    */     //   324: ifeq -> 339
/*    */     //   327: aload #5
/*    */     //   329: iload #4
/*    */     //   331: iconst_1
/*    */     //   332: isub
/*    */     //   333: caload
/*    */     //   334: bipush #32
/*    */     //   336: if_icmpeq -> 344
/*    */     //   339: iload #4
/*    */     //   341: goto -> 348
/*    */     //   344: iload #4
/*    */     //   346: iconst_1
/*    */     //   347: isub
/*    */     //   348: invokespecial <init> : ([CII)V
/*    */     //   351: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #71	-> 0
/*    */     //   #72	-> 9
/*    */     //   #74	-> 11
/*    */     //   #75	-> 20
/*    */     //   #76	-> 29
/*    */     //   #77	-> 38
/*    */     //   #78	-> 47
/*    */     //   #79	-> 56
/*    */     //   #81	-> 65
/*    */     //   #82	-> 70
/*    */     //   #84	-> 72
/*    */     //   #85	-> 74
/*    */     //   #86	-> 79
/*    */     //   #87	-> 83
/*    */     //   #92	-> 85
/*    */     //   #95	-> 95
/*    */     //   #97	-> 102
/*    */     //   #99	-> 112
/*    */     //   #100	-> 124
/*    */     //   #101	-> 127
/*    */     //   #102	-> 134
/*    */     //   #103	-> 137
/*    */     //   #104	-> 140
/*    */     //   #105	-> 150
/*    */     //   #95	-> 153
/*    */     //   #108	-> 159
/*    */     //   #109	-> 176
/*    */     //   #110	-> 179
/*    */     //   #113	-> 181
/*    */     //   #120	-> 187
/*    */     //   #121	-> 209
/*    */     //   #122	-> 215
/*    */     //   #125	-> 218
/*    */     //   #132	-> 224
/*    */     //   #133	-> 227
/*    */     //   #134	-> 232
/*    */     //   #135	-> 235
/*    */     //   #136	-> 245
/*    */     //   #141	-> 248
/*    */     //   #142	-> 263
/*    */     //   #143	-> 268
/*    */     //   #144	-> 271
/*    */     //   #146	-> 280
/*    */     //   #147	-> 295
/*    */     //   #148	-> 300
/*    */     //   #149	-> 303
/*    */     //   #150	-> 312
/*    */     //   #155	-> 315
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlWhitespace.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */