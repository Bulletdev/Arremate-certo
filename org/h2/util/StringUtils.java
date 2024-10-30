/*      */ package org.h2.util;
/*      */ 
/*      */ import java.lang.ref.SoftReference;
/*      */ import java.net.URLEncoder;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Locale;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.message.DbException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StringUtils
/*      */ {
/*   23 */   private static SoftReference<String[]> softCache = (SoftReference)new SoftReference<>(null);
/*      */   
/*      */   private static long softCacheCreated;
/*      */   
/*   27 */   private static final char[] HEX = "0123456789abcdef".toCharArray();
/*   28 */   private static final int[] HEX_DECODE = new int[103];
/*      */   
/*      */   private static final int TO_UPPER_CACHE_LENGTH = 2048;
/*      */   
/*      */   private static final int TO_UPPER_CACHE_MAX_ENTRY_LENGTH = 64;
/*      */   
/*   34 */   private static final String[][] TO_UPPER_CACHE = new String[2048][];
/*      */   static {
/*      */     byte b;
/*   37 */     for (b = 0; b < HEX_DECODE.length; b++) {
/*   38 */       HEX_DECODE[b] = -1;
/*      */     }
/*   40 */     for (b = 0; b <= 9; b++) {
/*   41 */       HEX_DECODE[b + 48] = b;
/*      */     }
/*   43 */     for (b = 0; b <= 5; b++) {
/*   44 */       HEX_DECODE[b + 65] = b + 10; HEX_DECODE[b + 97] = b + 10;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] getCache() {
/*   57 */     if (softCache != null) {
/*   58 */       String[] arrayOfString = softCache.get();
/*   59 */       if (arrayOfString != null) {
/*   60 */         return arrayOfString;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*   65 */     long l = System.currentTimeMillis();
/*   66 */     if (softCacheCreated != 0L && l - softCacheCreated < 5000L) {
/*   67 */       return null;
/*      */     }
/*      */     try {
/*   70 */       String[] arrayOfString = new String[SysProperties.OBJECT_CACHE_SIZE];
/*   71 */       softCache = (SoftReference)new SoftReference<>(arrayOfString);
/*   72 */       return arrayOfString;
/*      */     } finally {
/*   74 */       softCacheCreated = System.currentTimeMillis();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equals(String paramString1, String paramString2) {
/*   86 */     if (paramString1 == null) {
/*   87 */       return (paramString2 == null);
/*      */     }
/*   89 */     return paramString1.equals(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toUpperEnglish(String paramString) {
/*   99 */     if (paramString.length() > 64) {
/*  100 */       return paramString.toUpperCase(Locale.ENGLISH);
/*      */     }
/*  102 */     int i = paramString.hashCode() & 0x7FF;
/*  103 */     String[] arrayOfString = TO_UPPER_CACHE[i];
/*  104 */     if (arrayOfString != null && 
/*  105 */       arrayOfString[0].equals(paramString)) {
/*  106 */       return arrayOfString[1];
/*      */     }
/*      */     
/*  109 */     String str = paramString.toUpperCase(Locale.ENGLISH);
/*  110 */     arrayOfString = new String[] { paramString, str };
/*  111 */     TO_UPPER_CACHE[i] = arrayOfString;
/*  112 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toLowerEnglish(String paramString) {
/*  122 */     return paramString.toLowerCase(Locale.ENGLISH);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean startsWithIgnoreCase(String paramString1, String paramString2) {
/*  133 */     if (paramString1.length() < paramString2.length()) {
/*  134 */       return false;
/*      */     }
/*  136 */     return paramString1.substring(0, paramString2.length()).equalsIgnoreCase(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quoteStringSQL(String paramString) {
/*  148 */     if (paramString == null) {
/*  149 */       return "NULL";
/*      */     }
/*  151 */     int i = paramString.length();
/*  152 */     StringBuilder stringBuilder = new StringBuilder(i + 2);
/*  153 */     stringBuilder.append('\'');
/*  154 */     for (byte b = 0; b < i; b++) {
/*  155 */       char c = paramString.charAt(b);
/*  156 */       if (c == '\'') {
/*  157 */         stringBuilder.append(c);
/*  158 */       } else if (c < ' ' || c > '') {
/*      */ 
/*      */         
/*  161 */         return "STRINGDECODE(" + quoteStringSQL(javaEncode(paramString)) + ")";
/*      */       } 
/*  163 */       stringBuilder.append(c);
/*      */     } 
/*  165 */     stringBuilder.append('\'');
/*  166 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String javaEncode(String paramString) {
/*  178 */     int i = paramString.length();
/*  179 */     StringBuilder stringBuilder = new StringBuilder(i);
/*  180 */     for (byte b = 0; b < i; b++) {
/*  181 */       int j; String str; int k; char c = paramString.charAt(b);
/*  182 */       switch (c) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case '\t':
/*  190 */           stringBuilder.append("\\t");
/*      */           break;
/*      */         
/*      */         case '\n':
/*  194 */           stringBuilder.append("\\n");
/*      */           break;
/*      */         
/*      */         case '\f':
/*  198 */           stringBuilder.append("\\f");
/*      */           break;
/*      */         
/*      */         case '\r':
/*  202 */           stringBuilder.append("\\r");
/*      */           break;
/*      */         
/*      */         case '"':
/*  206 */           stringBuilder.append("\\\"");
/*      */           break;
/*      */         
/*      */         case '\\':
/*  210 */           stringBuilder.append("\\\\");
/*      */           break;
/*      */         default:
/*  213 */           j = c & Character.MAX_VALUE;
/*  214 */           if (j >= 32 && j < 128) {
/*  215 */             stringBuilder.append(c);
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */ 
/*      */           
/*  222 */           stringBuilder.append("\\u");
/*  223 */           str = Integer.toHexString(j);
/*      */           
/*  225 */           for (k = str.length(); k < 4; k++) {
/*  226 */             stringBuilder.append('0');
/*      */           }
/*  228 */           stringBuilder.append(str);
/*      */           break;
/*      */       } 
/*      */     } 
/*  232 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String addAsterisk(String paramString, int paramInt) {
/*  244 */     if (paramString != null) {
/*  245 */       paramInt = Math.min(paramInt, paramString.length());
/*  246 */       paramString = paramString.substring(0, paramInt) + "[*]" + paramString.substring(paramInt);
/*      */     } 
/*  248 */     return paramString;
/*      */   }
/*      */   
/*      */   private static DbException getFormatException(String paramString, int paramInt) {
/*  252 */     return DbException.get(90095, addAsterisk(paramString, paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String javaDecode(String paramString) {
/*  263 */     int i = paramString.length();
/*  264 */     StringBuilder stringBuilder = new StringBuilder(i);
/*  265 */     for (byte b = 0; b < i; b++) {
/*  266 */       char c = paramString.charAt(b);
/*  267 */       if (c == '\\') {
/*  268 */         if (b + 1 >= paramString.length()) {
/*  269 */           throw getFormatException(paramString, b);
/*      */         }
/*  271 */         c = paramString.charAt(++b);
/*  272 */         switch (c) {
/*      */           case 't':
/*  274 */             stringBuilder.append('\t');
/*      */             break;
/*      */           case 'r':
/*  277 */             stringBuilder.append('\r');
/*      */             break;
/*      */           case 'n':
/*  280 */             stringBuilder.append('\n');
/*      */             break;
/*      */           case 'b':
/*  283 */             stringBuilder.append('\b');
/*      */             break;
/*      */           case 'f':
/*  286 */             stringBuilder.append('\f');
/*      */             break;
/*      */           
/*      */           case '#':
/*  290 */             stringBuilder.append('#');
/*      */             break;
/*      */           
/*      */           case '=':
/*  294 */             stringBuilder.append('=');
/*      */             break;
/*      */           
/*      */           case ':':
/*  298 */             stringBuilder.append(':');
/*      */             break;
/*      */           case '"':
/*  301 */             stringBuilder.append('"');
/*      */             break;
/*      */           case '\\':
/*  304 */             stringBuilder.append('\\');
/*      */             break;
/*      */           case 'u':
/*      */             try {
/*  308 */               c = (char)Integer.parseInt(paramString.substring(b + 1, b + 5), 16);
/*  309 */             } catch (NumberFormatException numberFormatException) {
/*  310 */               throw getFormatException(paramString, b);
/*      */             } 
/*  312 */             b += 4;
/*  313 */             stringBuilder.append(c);
/*      */             break;
/*      */           
/*      */           default:
/*  317 */             if (c >= '0' && c <= '9') {
/*      */               try {
/*  319 */                 c = (char)Integer.parseInt(paramString.substring(b, b + 3), 8);
/*  320 */               } catch (NumberFormatException numberFormatException) {
/*  321 */                 throw getFormatException(paramString, b);
/*      */               } 
/*  323 */               b += 2;
/*  324 */               stringBuilder.append(c); break;
/*      */             } 
/*  326 */             throw getFormatException(paramString, b);
/*      */         } 
/*      */       
/*      */       } else {
/*  330 */         stringBuilder.append(c);
/*      */       } 
/*      */     } 
/*  333 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quoteJavaString(String paramString) {
/*  344 */     if (paramString == null) {
/*  345 */       return "null";
/*      */     }
/*  347 */     return "\"" + javaEncode(paramString) + "\"";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quoteJavaStringArray(String[] paramArrayOfString) {
/*  358 */     if (paramArrayOfString == null) {
/*  359 */       return "null";
/*      */     }
/*  361 */     StatementBuilder statementBuilder = new StatementBuilder("new String[]{");
/*  362 */     for (String str : paramArrayOfString) {
/*  363 */       statementBuilder.appendExceptFirst(", ");
/*  364 */       statementBuilder.append(quoteJavaString(str));
/*      */     } 
/*  366 */     return statementBuilder.append('}').toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quoteJavaIntArray(int[] paramArrayOfint) {
/*  377 */     if (paramArrayOfint == null) {
/*  378 */       return "null";
/*      */     }
/*  380 */     StatementBuilder statementBuilder = new StatementBuilder("new int[]{");
/*  381 */     for (int i : paramArrayOfint) {
/*  382 */       statementBuilder.appendExceptFirst(", ");
/*  383 */       statementBuilder.append(i);
/*      */     } 
/*  385 */     return statementBuilder.append('}').toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String enclose(String paramString) {
/*  395 */     if (paramString.startsWith("(")) {
/*  396 */       return paramString;
/*      */     }
/*  398 */     return "(" + paramString + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String unEnclose(String paramString) {
/*  408 */     if (paramString.startsWith("(") && paramString.endsWith(")")) {
/*  409 */       return paramString.substring(1, paramString.length() - 1);
/*      */     }
/*  411 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String urlEncode(String paramString) {
/*      */     try {
/*  422 */       return URLEncoder.encode(paramString, "UTF-8");
/*  423 */     } catch (Exception exception) {
/*      */       
/*  425 */       throw DbException.convert(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String urlDecode(String paramString) {
/*  436 */     int i = paramString.length();
/*  437 */     byte[] arrayOfByte = new byte[i];
/*  438 */     byte b1 = 0;
/*  439 */     for (byte b2 = 0; b2 < i; b2++) {
/*  440 */       char c = paramString.charAt(b2);
/*  441 */       if (c == '+') {
/*  442 */         arrayOfByte[b1++] = 32;
/*  443 */       } else if (c == '%') {
/*  444 */         arrayOfByte[b1++] = (byte)Integer.parseInt(paramString.substring(b2 + 1, b2 + 3), 16);
/*  445 */         b2 += 2;
/*      */       } else {
/*  447 */         if (SysProperties.CHECK && (
/*  448 */           c > '' || c < ' ')) {
/*  449 */           throw new IllegalArgumentException("Unexpected char " + c + " decoding " + paramString);
/*      */         }
/*      */ 
/*      */         
/*  453 */         arrayOfByte[b1++] = (byte)c;
/*      */       } 
/*      */     } 
/*  456 */     return new String(arrayOfByte, 0, b1, Constants.UTF8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] arraySplit(String paramString, char paramChar, boolean paramBoolean) {
/*  471 */     if (paramString == null) {
/*  472 */       return null;
/*      */     }
/*  474 */     int i = paramString.length();
/*  475 */     if (i == 0) {
/*  476 */       return new String[0];
/*      */     }
/*  478 */     ArrayList<?> arrayList = New.arrayList();
/*  479 */     StringBuilder stringBuilder = new StringBuilder(i);
/*  480 */     for (byte b = 0; b < i; b++) {
/*  481 */       char c = paramString.charAt(b);
/*  482 */       if (c == paramChar) {
/*  483 */         String str1 = stringBuilder.toString();
/*  484 */         arrayList.add(paramBoolean ? str1.trim() : str1);
/*  485 */         stringBuilder.setLength(0);
/*  486 */       } else if (c == '\\' && b < i - 1) {
/*  487 */         stringBuilder.append(paramString.charAt(++b));
/*      */       } else {
/*  489 */         stringBuilder.append(c);
/*      */       } 
/*      */     } 
/*  492 */     String str = stringBuilder.toString();
/*  493 */     arrayList.add(paramBoolean ? str.trim() : str);
/*  494 */     String[] arrayOfString = new String[arrayList.size()];
/*  495 */     arrayList.toArray(arrayOfString);
/*  496 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String arrayCombine(String[] paramArrayOfString, char paramChar) {
/*  509 */     StatementBuilder statementBuilder = new StatementBuilder();
/*  510 */     for (String str : paramArrayOfString) {
/*  511 */       statementBuilder.appendExceptFirst(String.valueOf(paramChar));
/*  512 */       if (str == null)
/*  513 */         str = "";  byte b;
/*      */       int i;
/*  515 */       for (b = 0, i = str.length(); b < i; b++) {
/*  516 */         char c = str.charAt(b);
/*  517 */         if (c == '\\' || c == paramChar) {
/*  518 */           statementBuilder.append('\\');
/*      */         }
/*  520 */         statementBuilder.append(c);
/*      */       } 
/*      */     } 
/*  523 */     return statementBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlAttr(String paramString1, String paramString2) {
/*  535 */     return " " + paramString1 + "=\"" + xmlText(paramString2) + "\"";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlNode(String paramString1, String paramString2, String paramString3) {
/*  548 */     return xmlNode(paramString1, paramString2, paramString3, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlNode(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*  564 */     String str = (paramString2 == null) ? paramString1 : (paramString1 + paramString2);
/*  565 */     if (paramString3 == null) {
/*  566 */       return "<" + str + "/>\n";
/*      */     }
/*  568 */     if (paramBoolean && paramString3.indexOf('\n') >= 0) {
/*  569 */       paramString3 = "\n" + indent(paramString3);
/*      */     }
/*  571 */     return "<" + str + ">" + paramString3 + "</" + paramString1 + ">\n";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String indent(String paramString) {
/*  581 */     return indent(paramString, 4, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String indent(String paramString, int paramInt, boolean paramBoolean) {
/*  593 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() + paramInt); int i;
/*  594 */     for (i = 0; i < paramString.length(); ) {
/*  595 */       int j; for (j = 0; j < paramInt; j++) {
/*  596 */         stringBuilder.append(' ');
/*      */       }
/*  598 */       j = paramString.indexOf('\n', i);
/*  599 */       j = (j < 0) ? paramString.length() : (j + 1);
/*  600 */       stringBuilder.append(paramString.substring(i, j));
/*  601 */       i = j;
/*      */     } 
/*  603 */     if (paramBoolean && !paramString.endsWith("\n")) {
/*  604 */       stringBuilder.append('\n');
/*      */     }
/*  606 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlComment(String paramString) {
/*  618 */     int i = 0;
/*      */     while (true) {
/*  620 */       i = paramString.indexOf("--", i);
/*  621 */       if (i < 0) {
/*      */         break;
/*      */       }
/*  624 */       paramString = paramString.substring(0, i + 1) + " " + paramString.substring(i + 1);
/*      */     } 
/*      */ 
/*      */     
/*  628 */     if (paramString.indexOf('\n') >= 0) {
/*  629 */       return "<!--\n" + indent(paramString) + "-->\n";
/*      */     }
/*  631 */     return "<!-- " + paramString + " -->\n";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlCData(String paramString) {
/*  642 */     if (paramString.contains("]]>")) {
/*  643 */       return xmlText(paramString);
/*      */     }
/*  645 */     boolean bool = paramString.endsWith("\n");
/*  646 */     paramString = "<![CDATA[" + paramString + "]]>";
/*  647 */     return bool ? (paramString + "\n") : paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlStartDoc() {
/*  655 */     return "<?xml version=\"1.0\"?>\n";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlText(String paramString) {
/*  665 */     return xmlText(paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String xmlText(String paramString, boolean paramBoolean) {
/*  676 */     int i = paramString.length();
/*  677 */     StringBuilder stringBuilder = new StringBuilder(i);
/*  678 */     for (byte b = 0; b < i; b++) {
/*  679 */       char c = paramString.charAt(b);
/*  680 */       switch (c) {
/*      */         case '<':
/*  682 */           stringBuilder.append("&lt;");
/*      */           break;
/*      */         case '>':
/*  685 */           stringBuilder.append("&gt;");
/*      */           break;
/*      */         case '&':
/*  688 */           stringBuilder.append("&amp;");
/*      */           break;
/*      */         case '\'':
/*  691 */           stringBuilder.append("&apos;");
/*      */           break;
/*      */         case '"':
/*  694 */           stringBuilder.append("&quot;");
/*      */           break;
/*      */         case '\n':
/*      */         case '\r':
/*  698 */           if (paramBoolean) {
/*  699 */             stringBuilder.append("&#x").append(Integer.toHexString(c)).append(';');
/*      */             
/*      */             break;
/*      */           } 
/*  703 */           stringBuilder.append(c);
/*      */           break;
/*      */         
/*      */         case '\t':
/*  707 */           stringBuilder.append(c);
/*      */           break;
/*      */         default:
/*  710 */           if (c < ' ' || c > '') {
/*  711 */             stringBuilder.append("&#x").append(Integer.toHexString(c)).append(';');
/*      */             
/*      */             break;
/*      */           } 
/*  715 */           stringBuilder.append(c);
/*      */           break;
/*      */       } 
/*      */     } 
/*  719 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceAll(String paramString1, String paramString2, String paramString3) {
/*  731 */     int i = paramString1.indexOf(paramString2);
/*  732 */     if (i < 0) {
/*  733 */       return paramString1;
/*      */     }
/*  735 */     StringBuilder stringBuilder = new StringBuilder(paramString1.length() - paramString2.length() + paramString3.length());
/*      */     
/*  737 */     int j = 0;
/*      */     while (true) {
/*  739 */       stringBuilder.append(paramString1.substring(j, i)).append(paramString3);
/*  740 */       j = i + paramString2.length();
/*  741 */       i = paramString1.indexOf(paramString2, j);
/*  742 */       if (i < 0) {
/*  743 */         stringBuilder.append(paramString1.substring(j));
/*      */ 
/*      */ 
/*      */         
/*  747 */         return stringBuilder.toString();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quoteIdentifier(String paramString) {
/*  758 */     int i = paramString.length();
/*  759 */     StringBuilder stringBuilder = new StringBuilder(i + 2);
/*  760 */     stringBuilder.append('"');
/*  761 */     for (byte b = 0; b < i; b++) {
/*  762 */       char c = paramString.charAt(b);
/*  763 */       if (c == '"') {
/*  764 */         stringBuilder.append(c);
/*      */       }
/*  766 */       stringBuilder.append(c);
/*      */     } 
/*  768 */     return stringBuilder.append('"').toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNullOrEmpty(String paramString) {
/*  778 */     return (paramString == null || paramString.length() == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String quoteRemarkSQL(String paramString) {
/*  788 */     paramString = replaceAll(paramString, "*/", "++/");
/*  789 */     return replaceAll(paramString, "/*", "/++");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String pad(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
/*      */     char c;
/*  802 */     if (paramInt < 0) {
/*  803 */       paramInt = 0;
/*      */     }
/*  805 */     if (paramInt < paramString1.length())
/*  806 */       return paramString1.substring(0, paramInt); 
/*  807 */     if (paramInt == paramString1.length()) {
/*  808 */       return paramString1;
/*      */     }
/*      */     
/*  811 */     if (paramString2 == null || paramString2.length() == 0) {
/*  812 */       c = ' ';
/*      */     } else {
/*  814 */       c = paramString2.charAt(0);
/*      */     } 
/*  816 */     StringBuilder stringBuilder = new StringBuilder(paramInt);
/*  817 */     paramInt -= paramString1.length();
/*  818 */     if (paramBoolean) {
/*  819 */       stringBuilder.append(paramString1);
/*      */     }
/*  821 */     for (byte b = 0; b < paramInt; b++) {
/*  822 */       stringBuilder.append(c);
/*      */     }
/*  824 */     if (!paramBoolean) {
/*  825 */       stringBuilder.append(paramString1);
/*      */     }
/*  827 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] cloneCharArray(char[] paramArrayOfchar) {
/*  838 */     if (paramArrayOfchar == null) {
/*  839 */       return null;
/*      */     }
/*  841 */     int i = paramArrayOfchar.length;
/*  842 */     if (i == 0) {
/*  843 */       return paramArrayOfchar;
/*      */     }
/*  845 */     char[] arrayOfChar = new char[i];
/*  846 */     System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, i);
/*  847 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trim(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2) {
/*  862 */     boolean bool = (paramString2 == null || paramString2.length() < 1) ? true : paramString2.charAt(0);
/*  863 */     if (paramBoolean1) {
/*  864 */       int i = paramString1.length(); byte b = 0;
/*  865 */       while (b < i && paramString1.charAt(b) == bool) {
/*  866 */         b++;
/*      */       }
/*  868 */       paramString1 = (b == 0) ? paramString1 : paramString1.substring(b);
/*      */     } 
/*  870 */     if (paramBoolean2) {
/*  871 */       int i = paramString1.length() - 1;
/*  872 */       int j = i;
/*  873 */       while (j >= 0 && paramString1.charAt(j) == bool) {
/*  874 */         j--;
/*      */       }
/*  876 */       paramString1 = (j == i) ? paramString1 : paramString1.substring(0, j + 1);
/*      */     } 
/*  878 */     return paramString1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String cache(String paramString) {
/*  890 */     if (!SysProperties.OBJECT_CACHE) {
/*  891 */       return paramString;
/*      */     }
/*  893 */     if (paramString == null)
/*  894 */       return paramString; 
/*  895 */     if (paramString.length() == 0) {
/*  896 */       return "";
/*      */     }
/*  898 */     int i = paramString.hashCode();
/*  899 */     String[] arrayOfString = getCache();
/*  900 */     if (arrayOfString != null) {
/*  901 */       int j = i & SysProperties.OBJECT_CACHE_SIZE - 1;
/*  902 */       String str = arrayOfString[j];
/*  903 */       if (str != null && 
/*  904 */         paramString.equals(str)) {
/*  905 */         return str;
/*      */       }
/*      */       
/*  908 */       arrayOfString[j] = paramString;
/*      */     } 
/*  910 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String fromCacheOrNew(String paramString) {
/*  923 */     if (!SysProperties.OBJECT_CACHE) {
/*  924 */       return paramString;
/*      */     }
/*  926 */     if (paramString == null)
/*  927 */       return paramString; 
/*  928 */     if (paramString.length() == 0) {
/*  929 */       return "";
/*      */     }
/*  931 */     int i = paramString.hashCode();
/*  932 */     String[] arrayOfString = getCache();
/*  933 */     int j = i & SysProperties.OBJECT_CACHE_SIZE - 1;
/*  934 */     if (arrayOfString == null) {
/*  935 */       return paramString;
/*      */     }
/*  937 */     String str = arrayOfString[j];
/*  938 */     if (str != null && 
/*  939 */       paramString.equals(str)) {
/*  940 */       return str;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  949 */     paramString = new String(paramString);
/*  950 */     arrayOfString[j] = paramString;
/*  951 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void clearCache() {
/*  958 */     softCache = (SoftReference)new SoftReference<>(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] convertHexToBytes(String paramString) {
/*  968 */     int i = paramString.length();
/*  969 */     if (i % 2 != 0) {
/*  970 */       throw DbException.get(90003, paramString);
/*      */     }
/*  972 */     i /= 2;
/*  973 */     byte[] arrayOfByte = new byte[i];
/*  974 */     int j = 0;
/*  975 */     int[] arrayOfInt = HEX_DECODE;
/*      */     try {
/*  977 */       for (byte b = 0; b < i; b++) {
/*  978 */         int k = arrayOfInt[paramString.charAt(b + b)] << 4 | arrayOfInt[paramString.charAt(b + b + 1)];
/*  979 */         j |= k;
/*  980 */         arrayOfByte[b] = (byte)k;
/*      */       } 
/*  982 */     } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*  983 */       throw DbException.get(90004, paramString);
/*      */     } 
/*  985 */     if ((j & 0xFFFFFF00) != 0) {
/*  986 */       throw DbException.get(90004, paramString);
/*      */     }
/*  988 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String convertBytesToHex(byte[] paramArrayOfbyte) {
/*  998 */     return convertBytesToHex(paramArrayOfbyte, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String convertBytesToHex(byte[] paramArrayOfbyte, int paramInt) {
/* 1009 */     char[] arrayOfChar1 = new char[paramInt + paramInt];
/* 1010 */     char[] arrayOfChar2 = HEX;
/* 1011 */     for (byte b = 0; b < paramInt; b++) {
/* 1012 */       int i = paramArrayOfbyte[b] & 0xFF;
/* 1013 */       arrayOfChar1[b + b] = arrayOfChar2[i >> 4];
/* 1014 */       arrayOfChar1[b + b + 1] = arrayOfChar2[i & 0xF];
/*      */     } 
/* 1016 */     return new String(arrayOfChar1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNumber(String paramString) {
/* 1026 */     if (paramString.length() == 0) {
/* 1027 */       return false;
/*      */     }
/* 1029 */     for (char c : paramString.toCharArray()) {
/* 1030 */       if (!Character.isDigit(c)) {
/* 1031 */         return false;
/*      */       }
/*      */     } 
/* 1034 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void appendZeroPadded(StringBuilder paramStringBuilder, int paramInt, long paramLong) {
/* 1046 */     if (paramInt == 2) {
/* 1047 */       if (paramLong < 10L) {
/* 1048 */         paramStringBuilder.append('0');
/*      */       }
/* 1050 */       paramStringBuilder.append(paramLong);
/*      */     } else {
/* 1052 */       String str = Long.toString(paramLong);
/* 1053 */       paramInt -= str.length();
/* 1054 */       while (paramInt > 0) {
/* 1055 */         paramStringBuilder.append('0');
/* 1056 */         paramInt--;
/*      */       } 
/* 1058 */       paramStringBuilder.append(str);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String escapeMetaDataPattern(String paramString) {
/* 1069 */     if (paramString == null || paramString.length() == 0) {
/* 1070 */       return paramString;
/*      */     }
/* 1072 */     return replaceAll(paramString, "\\", "\\\\");
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\StringUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */