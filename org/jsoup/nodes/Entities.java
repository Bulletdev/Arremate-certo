/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.Properties;
/*     */ import org.jsoup.parser.Parser;
/*     */ 
/*     */ public class Entities
/*     */ {
/*     */   private static final Map<String, Character> full;
/*     */   private static final Map<Character, String> xhtmlByVal;
/*     */   private static final Map<String, Character> base;
/*     */   private static final Map<Character, String> baseByVal;
/*     */   private static final Map<Character, String> fullByVal;
/*     */   
/*     */   public enum EscapeMode
/*     */   {
/*  21 */     xhtml((String)Entities.xhtmlByVal),
/*     */     
/*  23 */     base((String)Entities.baseByVal),
/*     */     
/*  25 */     extended((String)Entities.fullByVal);
/*     */     
/*     */     private Map<Character, String> map;
/*     */     
/*     */     EscapeMode(Map<Character, String> param1Map) {
/*  30 */       this.map = param1Map;
/*     */     }
/*     */     
/*     */     public Map<Character, String> getMap() {
/*  34 */       return this.map;
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
/*     */ 
/*     */   
/*     */   public static boolean isNamedEntity(String paramString) {
/*  52 */     return full.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isBaseNamedEntity(String paramString) {
/*  62 */     return base.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Character getCharacterByName(String paramString) {
/*  71 */     return full.get(paramString);
/*     */   }
/*     */   
/*     */   static String escape(String paramString, Document.OutputSettings paramOutputSettings) {
/*  75 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() * 2);
/*  76 */     escape(stringBuilder, paramString, paramOutputSettings, false, false, false);
/*  77 */     return stringBuilder.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void escape(StringBuilder paramStringBuilder, String paramString, Document.OutputSettings paramOutputSettings, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore #6
/*     */     //   3: iconst_0
/*     */     //   4: istore #7
/*     */     //   6: aload_2
/*     */     //   7: invokevirtual escapeMode : ()Lorg/jsoup/nodes/Entities$EscapeMode;
/*     */     //   10: astore #8
/*     */     //   12: aload_2
/*     */     //   13: invokevirtual encoder : ()Ljava/nio/charset/CharsetEncoder;
/*     */     //   16: astore #9
/*     */     //   18: aload #8
/*     */     //   20: invokevirtual getMap : ()Ljava/util/Map;
/*     */     //   23: astore #10
/*     */     //   25: aload_1
/*     */     //   26: invokevirtual length : ()I
/*     */     //   29: istore #11
/*     */     //   31: iconst_0
/*     */     //   32: istore #13
/*     */     //   34: iload #13
/*     */     //   36: iload #11
/*     */     //   38: if_icmpge -> 432
/*     */     //   41: aload_1
/*     */     //   42: iload #13
/*     */     //   44: invokevirtual codePointAt : (I)I
/*     */     //   47: istore #12
/*     */     //   49: iload #4
/*     */     //   51: ifeq -> 99
/*     */     //   54: iload #12
/*     */     //   56: invokestatic isWhitespace : (I)Z
/*     */     //   59: ifeq -> 93
/*     */     //   62: iload #5
/*     */     //   64: ifeq -> 72
/*     */     //   67: iload #7
/*     */     //   69: ifeq -> 419
/*     */     //   72: iload #6
/*     */     //   74: ifeq -> 80
/*     */     //   77: goto -> 419
/*     */     //   80: aload_0
/*     */     //   81: bipush #32
/*     */     //   83: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   86: pop
/*     */     //   87: iconst_1
/*     */     //   88: istore #6
/*     */     //   90: goto -> 419
/*     */     //   93: iconst_0
/*     */     //   94: istore #6
/*     */     //   96: iconst_1
/*     */     //   97: istore #7
/*     */     //   99: iload #12
/*     */     //   101: ldc 65536
/*     */     //   103: if_icmpge -> 365
/*     */     //   106: iload #12
/*     */     //   108: i2c
/*     */     //   109: istore #14
/*     */     //   111: iload #14
/*     */     //   113: lookupswitch default -> 274, 34 -> 250, 38 -> 164, 60 -> 202, 62 -> 226, 160 -> 174
/*     */     //   164: aload_0
/*     */     //   165: ldc '&amp;'
/*     */     //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   170: pop
/*     */     //   171: goto -> 362
/*     */     //   174: aload #8
/*     */     //   176: getstatic org/jsoup/nodes/Entities$EscapeMode.xhtml : Lorg/jsoup/nodes/Entities$EscapeMode;
/*     */     //   179: if_acmpeq -> 192
/*     */     //   182: aload_0
/*     */     //   183: ldc '&nbsp;'
/*     */     //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   188: pop
/*     */     //   189: goto -> 362
/*     */     //   192: aload_0
/*     */     //   193: iload #14
/*     */     //   195: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   198: pop
/*     */     //   199: goto -> 362
/*     */     //   202: iload_3
/*     */     //   203: ifne -> 216
/*     */     //   206: aload_0
/*     */     //   207: ldc '&lt;'
/*     */     //   209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   212: pop
/*     */     //   213: goto -> 362
/*     */     //   216: aload_0
/*     */     //   217: iload #14
/*     */     //   219: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   222: pop
/*     */     //   223: goto -> 362
/*     */     //   226: iload_3
/*     */     //   227: ifne -> 240
/*     */     //   230: aload_0
/*     */     //   231: ldc '&gt;'
/*     */     //   233: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   236: pop
/*     */     //   237: goto -> 362
/*     */     //   240: aload_0
/*     */     //   241: iload #14
/*     */     //   243: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   246: pop
/*     */     //   247: goto -> 362
/*     */     //   250: iload_3
/*     */     //   251: ifeq -> 264
/*     */     //   254: aload_0
/*     */     //   255: ldc '&quot;'
/*     */     //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   260: pop
/*     */     //   261: goto -> 362
/*     */     //   264: aload_0
/*     */     //   265: iload #14
/*     */     //   267: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   270: pop
/*     */     //   271: goto -> 362
/*     */     //   274: aload #9
/*     */     //   276: iload #14
/*     */     //   278: invokevirtual canEncode : (C)Z
/*     */     //   281: ifeq -> 294
/*     */     //   284: aload_0
/*     */     //   285: iload #14
/*     */     //   287: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   290: pop
/*     */     //   291: goto -> 362
/*     */     //   294: aload #10
/*     */     //   296: iload #14
/*     */     //   298: invokestatic valueOf : (C)Ljava/lang/Character;
/*     */     //   301: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   306: ifeq -> 342
/*     */     //   309: aload_0
/*     */     //   310: bipush #38
/*     */     //   312: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   315: aload #10
/*     */     //   317: iload #14
/*     */     //   319: invokestatic valueOf : (C)Ljava/lang/Character;
/*     */     //   322: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   327: checkcast java/lang/String
/*     */     //   330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   333: bipush #59
/*     */     //   335: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   338: pop
/*     */     //   339: goto -> 362
/*     */     //   342: aload_0
/*     */     //   343: ldc '&#x'
/*     */     //   345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   348: iload #12
/*     */     //   350: invokestatic toHexString : (I)Ljava/lang/String;
/*     */     //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   356: bipush #59
/*     */     //   358: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   361: pop
/*     */     //   362: goto -> 419
/*     */     //   365: new java/lang/String
/*     */     //   368: dup
/*     */     //   369: iload #12
/*     */     //   371: invokestatic toChars : (I)[C
/*     */     //   374: invokespecial <init> : ([C)V
/*     */     //   377: astore #14
/*     */     //   379: aload #9
/*     */     //   381: aload #14
/*     */     //   383: invokevirtual canEncode : (Ljava/lang/CharSequence;)Z
/*     */     //   386: ifeq -> 399
/*     */     //   389: aload_0
/*     */     //   390: aload #14
/*     */     //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   395: pop
/*     */     //   396: goto -> 419
/*     */     //   399: aload_0
/*     */     //   400: ldc '&#x'
/*     */     //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   405: iload #12
/*     */     //   407: invokestatic toHexString : (I)Ljava/lang/String;
/*     */     //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   413: bipush #59
/*     */     //   415: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   418: pop
/*     */     //   419: iload #13
/*     */     //   421: iload #12
/*     */     //   423: invokestatic charCount : (I)I
/*     */     //   426: iadd
/*     */     //   427: istore #13
/*     */     //   429: goto -> 34
/*     */     //   432: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #84	-> 0
/*     */     //   #85	-> 3
/*     */     //   #86	-> 6
/*     */     //   #87	-> 12
/*     */     //   #88	-> 18
/*     */     //   #89	-> 25
/*     */     //   #92	-> 31
/*     */     //   #93	-> 41
/*     */     //   #95	-> 49
/*     */     //   #96	-> 54
/*     */     //   #97	-> 62
/*     */     //   #98	-> 77
/*     */     //   #99	-> 80
/*     */     //   #100	-> 87
/*     */     //   #101	-> 90
/*     */     //   #103	-> 93
/*     */     //   #104	-> 96
/*     */     //   #108	-> 99
/*     */     //   #109	-> 106
/*     */     //   #111	-> 111
/*     */     //   #113	-> 164
/*     */     //   #114	-> 171
/*     */     //   #116	-> 174
/*     */     //   #117	-> 182
/*     */     //   #119	-> 192
/*     */     //   #120	-> 199
/*     */     //   #122	-> 202
/*     */     //   #123	-> 206
/*     */     //   #125	-> 216
/*     */     //   #126	-> 223
/*     */     //   #128	-> 226
/*     */     //   #129	-> 230
/*     */     //   #131	-> 240
/*     */     //   #132	-> 247
/*     */     //   #134	-> 250
/*     */     //   #135	-> 254
/*     */     //   #137	-> 264
/*     */     //   #138	-> 271
/*     */     //   #140	-> 274
/*     */     //   #141	-> 284
/*     */     //   #142	-> 294
/*     */     //   #143	-> 309
/*     */     //   #145	-> 342
/*     */     //   #147	-> 362
/*     */     //   #148	-> 365
/*     */     //   #149	-> 379
/*     */     //   #150	-> 389
/*     */     //   #152	-> 399
/*     */     //   #92	-> 419
/*     */     //   #155	-> 432
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String unescape(String paramString) {
/* 158 */     return unescape(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String unescape(String paramString, boolean paramBoolean) {
/* 168 */     return Parser.unescapeEntities(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 173 */   private static final Object[][] xhtmlArray = new Object[][] { { "quot", Integer.valueOf(34) }, { "amp", Integer.valueOf(38) }, { "lt", Integer.valueOf(60) }, { "gt", Integer.valueOf(62) } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 181 */     xhtmlByVal = new HashMap<Character, String>();
/* 182 */     base = loadEntities("entities-base.properties");
/* 183 */     baseByVal = toCharacterKey(base);
/* 184 */     full = loadEntities("entities-full.properties");
/* 185 */     fullByVal = toCharacterKey(full);
/*     */     
/* 187 */     for (Object[] arrayOfObject : xhtmlArray) {
/* 188 */       Character character = Character.valueOf((char)((Integer)arrayOfObject[1]).intValue());
/* 189 */       xhtmlByVal.put(character, (String)arrayOfObject[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Map<String, Character> loadEntities(String paramString) {
/* 194 */     Properties properties = new Properties();
/* 195 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     try {
/* 197 */       InputStream inputStream = Entities.class.getResourceAsStream(paramString);
/* 198 */       properties.load(inputStream);
/* 199 */       inputStream.close();
/* 200 */     } catch (IOException iOException) {
/* 201 */       throw new MissingResourceException("Error loading entities resource: " + iOException.getMessage(), "Entities", paramString);
/*     */     } 
/*     */     
/* 204 */     for (Map.Entry<Object, Object> entry : properties.entrySet()) {
/* 205 */       Character character = Character.valueOf((char)Integer.parseInt((String)entry.getValue(), 16));
/* 206 */       String str = (String)entry.getKey();
/* 207 */       hashMap.put(str, character);
/*     */     } 
/* 209 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static Map<Character, String> toCharacterKey(Map<String, Character> paramMap) {
/* 213 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 214 */     for (Map.Entry<String, Character> entry : paramMap.entrySet()) {
/* 215 */       Character character = (Character)entry.getValue();
/* 216 */       String str = (String)entry.getKey();
/*     */       
/* 218 */       if (hashMap.containsKey(character)) {
/*     */         
/* 220 */         if (str.toLowerCase().equals(str))
/* 221 */           hashMap.put(character, str);  continue;
/*     */       } 
/* 223 */       hashMap.put(character, str);
/*     */     } 
/*     */     
/* 226 */     return (Map)hashMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\Entities.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */