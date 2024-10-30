/*      */ package oshi.util;
/*      */ 
/*      */ import java.math.BigInteger;
/*      */ import java.net.InetAddress;
/*      */ import java.net.UnknownHostException;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.ByteOrder;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import java.time.LocalTime;
/*      */ import java.time.OffsetDateTime;
/*      */ import java.time.format.DateTimeFormatter;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.EnumMap;
/*      */ import java.util.EnumSet;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.TimeZone;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ import oshi.annotation.concurrent.ThreadSafe;
/*      */ import oshi.util.tuples.Pair;
/*      */ import oshi.util.tuples.Triplet;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @ThreadSafe
/*      */ public final class ParseUtil
/*      */ {
/*   62 */   private static final Logger LOG = LoggerFactory.getLogger(ParseUtil.class);
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String DEFAULT_LOG_MSG = "{} didn't parse. Returning default. {}";
/*      */ 
/*      */   
/*   69 */   private static final Pattern HERTZ_PATTERN = Pattern.compile("(\\d+(.\\d+)?) ?([kMGT]?Hz).*");
/*   70 */   private static final Pattern BYTES_PATTERN = Pattern.compile("(\\d+) ?([kMGT]?B).*");
/*   71 */   private static final Pattern UNITS_PATTERN = Pattern.compile("(\\d+(.\\d+)?)[\\s]?([kKMGT])?");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   76 */   private static final Pattern VALID_HEX = Pattern.compile("[0-9a-fA-F]+");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   81 */   private static final Pattern DHMS = Pattern.compile("(?:(\\d+)-)?(?:(\\d+):)??(?:(\\d+):)?(\\d+)(?:\\.(\\d+))?");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   87 */   private static final Pattern UUID_PATTERN = Pattern.compile(".*([0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}).*");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   93 */   private static final Pattern VENDOR_PRODUCT_ID_SERIAL = Pattern.compile(".*(?:VID|VEN)_(\\p{XDigit}{4})&(?:PID|DEV)_(\\p{XDigit}{4})(.*)\\\\(.*)");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   98 */   private static final Pattern LSPCI_MACHINE_READABLE = Pattern.compile("(.+)\\s\\[(.*?)\\]");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  103 */   private static final Pattern LSPCI_MEMORY_SIZE = Pattern.compile(".+\\s\\[size=(\\d+)([kKMGT])\\]");
/*      */   
/*      */   private static final String HZ = "Hz";
/*      */   
/*      */   private static final String KHZ = "kHz";
/*      */   
/*      */   private static final String MHZ = "MHz";
/*      */   
/*      */   private static final String GHZ = "GHz";
/*      */   
/*      */   private static final String THZ = "THz";
/*      */   
/*      */   private static final String PHZ = "PHz";
/*      */   
/*      */   private static final Map<String, Long> multipliers;
/*      */   
/*      */   private static final long EPOCH_DIFF = 11644473600000L;
/*  120 */   private static final int TZ_OFFSET = TimeZone.getDefault().getOffset(System.currentTimeMillis());
/*      */ 
/*      */   
/*  123 */   public static final Pattern whitespacesColonWhitespace = Pattern.compile("\\s+:\\s");
/*      */ 
/*      */   
/*  126 */   public static final Pattern whitespaces = Pattern.compile("\\s+");
/*      */ 
/*      */   
/*  129 */   public static final Pattern notDigits = Pattern.compile("[^0-9]+");
/*      */ 
/*      */   
/*  132 */   public static final Pattern startWithNotDigits = Pattern.compile("^[^0-9]*");
/*      */ 
/*      */   
/*  135 */   public static final Pattern slash = Pattern.compile("\\/"); private static final long[] POWERS_OF_TEN;
/*      */   
/*      */   static {
/*  138 */     multipliers = new HashMap<>();
/*  139 */     multipliers.put("Hz", Long.valueOf(1L));
/*  140 */     multipliers.put("kHz", Long.valueOf(1000L));
/*  141 */     multipliers.put("MHz", Long.valueOf(1000000L));
/*  142 */     multipliers.put("GHz", Long.valueOf(1000000000L));
/*  143 */     multipliers.put("THz", Long.valueOf(1000000000000L));
/*  144 */     multipliers.put("PHz", Long.valueOf(1000000000000000L));
/*      */ 
/*      */ 
/*      */     
/*  148 */     POWERS_OF_TEN = new long[] { 1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  154 */     CIM_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSSSSSZZZZZ", Locale.US);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final DateTimeFormatter CIM_FORMAT;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long parseHertz(String paramString) {
/*  168 */     Matcher matcher = HERTZ_PATTERN.matcher(paramString.trim());
/*  169 */     if (matcher.find() && matcher.groupCount() == 3) {
/*      */       
/*  171 */       double d = Double.valueOf(matcher.group(1)).doubleValue() * ((Long)multipliers.getOrDefault(matcher.group(3), Long.valueOf(-1L))).longValue();
/*  172 */       if (d >= 0.0D) {
/*  173 */         return (long)d;
/*      */       }
/*      */     } 
/*  176 */     return -1L;
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
/*      */   public static int parseLastInt(String paramString, int paramInt) {
/*      */     try {
/*  190 */       String str = parseLastString(paramString);
/*  191 */       if (str.toLowerCase().startsWith("0x")) {
/*  192 */         return Integer.decode(str).intValue();
/*      */       }
/*  194 */       return Integer.parseInt(str);
/*      */     }
/*  196 */     catch (NumberFormatException numberFormatException) {
/*  197 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*  198 */       return paramInt;
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
/*      */   
/*      */   public static long parseLastLong(String paramString, long paramLong) {
/*      */     try {
/*  213 */       String str = parseLastString(paramString);
/*  214 */       if (str.toLowerCase().startsWith("0x")) {
/*  215 */         return Long.decode(str).longValue();
/*      */       }
/*  217 */       return Long.parseLong(str);
/*      */     }
/*  219 */     catch (NumberFormatException numberFormatException) {
/*  220 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*  221 */       return paramLong;
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
/*      */   
/*      */   public static double parseLastDouble(String paramString, double paramDouble) {
/*      */     try {
/*  236 */       return Double.parseDouble(parseLastString(paramString));
/*  237 */     } catch (NumberFormatException numberFormatException) {
/*  238 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*  239 */       return paramDouble;
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
/*      */   public static String parseLastString(String paramString) {
/*  251 */     String[] arrayOfString = whitespaces.split(paramString);
/*      */     
/*  253 */     return arrayOfString[arrayOfString.length - 1];
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
/*      */   public static String byteArrayToHexString(byte[] paramArrayOfbyte) {
/*  266 */     StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
/*  267 */     for (byte b : paramArrayOfbyte) {
/*  268 */       stringBuilder.append(Character.forDigit((b & 0xF0) >>> 4, 16));
/*  269 */       stringBuilder.append(Character.forDigit(b & 0xF, 16));
/*      */     } 
/*  271 */     return stringBuilder.toString().toUpperCase();
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
/*      */   public static byte[] hexStringToByteArray(String paramString) {
/*  283 */     int i = paramString.length();
/*      */     
/*  285 */     if (!VALID_HEX.matcher(paramString).matches() || (i & 0x1) != 0) {
/*  286 */       LOG.warn("Invalid hexadecimal string: {}", paramString);
/*  287 */       return new byte[0];
/*      */     } 
/*  289 */     byte[] arrayOfByte = new byte[i / 2];
/*  290 */     for (byte b = 0; b < i; b += 2) {
/*  291 */       arrayOfByte[b / 2] = 
/*  292 */         (byte)(Character.digit(paramString.charAt(b), 16) << 4 | Character.digit(paramString.charAt(b + 1), 16));
/*      */     }
/*  294 */     return arrayOfByte;
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
/*      */   public static byte[] asciiStringToByteArray(String paramString, int paramInt) {
/*  310 */     return Arrays.copyOf(paramString.getBytes(StandardCharsets.US_ASCII), paramInt);
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
/*      */   
/*      */   public static byte[] longToByteArray(long paramLong, int paramInt1, int paramInt2) {
/*  327 */     long l = paramLong;
/*      */     
/*  329 */     byte[] arrayOfByte = new byte[8];
/*  330 */     for (byte b = 7; b >= 0 && l != 0L; b--) {
/*  331 */       arrayOfByte[b] = (byte)(int)l;
/*  332 */       l >>>= 8L;
/*      */     } 
/*      */ 
/*      */     
/*  336 */     return Arrays.copyOfRange(arrayOfByte, 8 - paramInt1, 8 + paramInt2 - paramInt1);
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
/*      */   public static long strToLong(String paramString, int paramInt) {
/*  350 */     return byteArrayToLong(paramString.getBytes(StandardCharsets.US_ASCII), paramInt);
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
/*      */   public static long byteArrayToLong(byte[] paramArrayOfbyte, int paramInt) {
/*  364 */     return byteArrayToLong(paramArrayOfbyte, paramInt, true);
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
/*      */   public static long byteArrayToLong(byte[] paramArrayOfbyte, int paramInt, boolean paramBoolean) {
/*  380 */     if (paramInt > 8) {
/*  381 */       throw new IllegalArgumentException("Can't convert more than 8 bytes.");
/*      */     }
/*  383 */     if (paramInt > paramArrayOfbyte.length) {
/*  384 */       throw new IllegalArgumentException("Size can't be larger than array length.");
/*      */     }
/*  386 */     long l = 0L;
/*  387 */     for (byte b = 0; b < paramInt; b++) {
/*  388 */       if (paramBoolean) {
/*  389 */         l = l << 8L | (paramArrayOfbyte[b] & 0xFF);
/*      */       } else {
/*  391 */         l = l << 8L | (paramArrayOfbyte[paramInt - b - 1] & 0xFF);
/*      */       } 
/*      */     } 
/*  394 */     return l;
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
/*      */   
/*      */   public static float byteArrayToFloat(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  411 */     return (float)byteArrayToLong(paramArrayOfbyte, paramInt1) / (1 << paramInt2);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long unsignedIntToLong(int paramInt) {
/*  431 */     long l = paramInt;
/*  432 */     return l & 0xFFFFFFFFL;
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
/*      */   public static long unsignedLongToSignedLong(long paramLong) {
/*  445 */     return paramLong & Long.MAX_VALUE;
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
/*      */   public static String hexStringToString(String paramString) {
/*  459 */     if (paramString.length() % 2 > 0) {
/*  460 */       return paramString;
/*      */     }
/*      */     
/*  463 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     try {
/*  465 */       for (byte b = 0; b < paramString.length(); b += 2) {
/*  466 */         int i = Integer.parseInt(paramString.substring(b, b + 2), 16);
/*  467 */         if (i < 32 || i > 127) {
/*  468 */           return paramString;
/*      */         }
/*  470 */         stringBuilder.append((char)i);
/*      */       } 
/*  472 */     } catch (NumberFormatException numberFormatException) {
/*  473 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*      */       
/*  475 */       return paramString;
/*      */     } 
/*  477 */     return stringBuilder.toString();
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
/*      */   public static int parseIntOrDefault(String paramString, int paramInt) {
/*      */     try {
/*  491 */       return Integer.parseInt(paramString);
/*  492 */     } catch (NumberFormatException numberFormatException) {
/*  493 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*  494 */       return paramInt;
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
/*      */   
/*      */   public static long parseLongOrDefault(String paramString, long paramLong) {
/*      */     try {
/*  509 */       return Long.parseLong(paramString);
/*  510 */     } catch (NumberFormatException numberFormatException) {
/*  511 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*  512 */       return paramLong;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static long parseUnsignedLongOrDefault(String paramString, long paramLong) {
/*      */     try {
/*  529 */       return (new BigInteger(paramString)).longValue();
/*  530 */     } catch (NumberFormatException numberFormatException) {
/*  531 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*  532 */       return paramLong;
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
/*      */   
/*      */   public static double parseDoubleOrDefault(String paramString, double paramDouble) {
/*      */     try {
/*  547 */       return Double.parseDouble(paramString);
/*  548 */     } catch (NumberFormatException numberFormatException) {
/*  549 */       LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*  550 */       return paramDouble;
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
/*      */ 
/*      */   
/*      */   public static long parseDHMSOrDefault(String paramString, long paramLong) {
/*  565 */     Matcher matcher = DHMS.matcher(paramString);
/*  566 */     if (matcher.matches()) {
/*  567 */       long l = 0L;
/*  568 */       if (matcher.group(1) != null) {
/*  569 */         l += parseLongOrDefault(matcher.group(1), 0L) * 86400000L;
/*      */       }
/*  571 */       if (matcher.group(2) != null) {
/*  572 */         l += parseLongOrDefault(matcher.group(2), 0L) * 3600000L;
/*      */       }
/*  574 */       if (matcher.group(3) != null) {
/*  575 */         l += parseLongOrDefault(matcher.group(3), 0L) * 60000L;
/*      */       }
/*  577 */       l += parseLongOrDefault(matcher.group(4), 0L) * 1000L;
/*  578 */       l += (long)(1000.0D * parseDoubleOrDefault("0." + matcher.group(5), 0.0D));
/*  579 */       return l;
/*      */     } 
/*  581 */     return paramLong;
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
/*      */   public static String parseUuidOrDefault(String paramString1, String paramString2) {
/*  594 */     Matcher matcher = UUID_PATTERN.matcher(paramString1.toLowerCase());
/*  595 */     if (matcher.matches()) {
/*  596 */       return matcher.group(1);
/*      */     }
/*  598 */     return paramString2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getSingleQuoteStringValue(String paramString) {
/*  609 */     return getStringBetween(paramString, '\'');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getDoubleQuoteStringValue(String paramString) {
/*  620 */     return getStringBetween(paramString, '"');
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getStringBetween(String paramString, char paramChar) {
/*  639 */     int i = paramString.indexOf(paramChar);
/*  640 */     if (i < 0) {
/*  641 */       return "";
/*      */     }
/*  643 */     return paramString.substring(i + 1, paramString.lastIndexOf(paramChar)).trim();
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
/*      */   public static int getFirstIntValue(String paramString) {
/*  655 */     return getNthIntValue(paramString, 1);
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
/*      */   public static int getNthIntValue(String paramString, int paramInt) {
/*  670 */     String[] arrayOfString = notDigits.split(startWithNotDigits.matcher(paramString).replaceFirst(""));
/*  671 */     if (arrayOfString.length >= paramInt) {
/*  672 */       return parseIntOrDefault(arrayOfString[paramInt - 1], 0);
/*      */     }
/*  674 */     return 0;
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
/*      */   public static String removeMatchingString(String paramString1, String paramString2) {
/*  687 */     if (paramString1 == null || paramString1.isEmpty() || paramString2 == null || paramString2.isEmpty()) {
/*  688 */       return paramString1;
/*      */     }
/*      */     
/*  691 */     int i = paramString1.indexOf(paramString2, 0);
/*  692 */     if (i == -1) {
/*  693 */       return paramString1;
/*      */     }
/*      */     
/*  696 */     StringBuilder stringBuilder = new StringBuilder(paramString1.length() - paramString2.length());
/*  697 */     int j = 0;
/*      */     do {
/*  699 */       stringBuilder.append(paramString1.substring(j, i));
/*  700 */       j = i + paramString2.length();
/*  701 */       i = paramString1.indexOf(paramString2, j);
/*  702 */     } while (i != -1);
/*      */     
/*  704 */     stringBuilder.append(paramString1.substring(j));
/*  705 */     return stringBuilder.toString();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long[] parseStringToLongArray(String paramString, int[] paramArrayOfint, int paramInt, char paramChar) {
/*  740 */     long[] arrayOfLong = new long[paramArrayOfint.length];
/*      */ 
/*      */     
/*  743 */     int i = paramString.length();
/*  744 */     int j = paramArrayOfint.length - 1;
/*  745 */     int k = paramInt - 1;
/*      */     
/*  747 */     byte b = 0;
/*      */     
/*  749 */     boolean bool1 = false;
/*  750 */     boolean bool2 = true;
/*  751 */     boolean bool3 = false;
/*  752 */     boolean bool4 = false;
/*  753 */     while (--i > 0 && j >= 0) {
/*  754 */       char c = paramString.charAt(i);
/*  755 */       if (c == paramChar) {
/*      */         
/*  757 */         if (!bool3 && bool2) {
/*  758 */           bool3 = true;
/*      */         }
/*  760 */         if (!bool1) {
/*  761 */           if (bool3 && paramArrayOfint[j] == k--) {
/*  762 */             j--;
/*      */           }
/*  764 */           bool1 = true;
/*  765 */           b = 0;
/*  766 */           bool4 = false;
/*  767 */           bool2 = true;
/*      */         }  continue;
/*  769 */       }  if (paramArrayOfint[j] != k || c == '+' || !bool2) {
/*      */         
/*  771 */         bool1 = false; continue;
/*  772 */       }  if (c >= '0' && c <= '9' && !bool4) {
/*  773 */         if (b > 18 || (b == 17 && c == '9' && arrayOfLong[j] > 223372036854775807L)) {
/*  774 */           arrayOfLong[j] = Long.MAX_VALUE;
/*      */         } else {
/*  776 */           arrayOfLong[j] = arrayOfLong[j] + (c - 48) * POWERS_OF_TEN[b++];
/*      */         } 
/*  778 */         bool1 = false; continue;
/*  779 */       }  if (c == '-') {
/*  780 */         arrayOfLong[j] = arrayOfLong[j] * -1L;
/*  781 */         bool1 = false;
/*  782 */         bool4 = true;
/*      */         
/*      */         continue;
/*      */       } 
/*  786 */       if (bool3) {
/*  787 */         if (!noLog(paramString)) {
/*  788 */           LOG.error("Illegal character parsing string '{}' to long array: {}", paramString, Character.valueOf(paramString.charAt(i)));
/*      */         }
/*  790 */         return new long[paramArrayOfint.length];
/*      */       } 
/*  792 */       arrayOfLong[j] = 0L;
/*  793 */       bool2 = false;
/*      */     } 
/*      */     
/*  796 */     if (j > 0) {
/*  797 */       if (!noLog(paramString)) {
/*  798 */         LOG.error("Not enough fields in string '{}' parsing to long array: {}", paramString, 
/*  799 */             Integer.valueOf(paramArrayOfint.length - j));
/*      */       }
/*  801 */       return new long[paramArrayOfint.length];
/*      */     } 
/*  803 */     return arrayOfLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean noLog(String paramString) {
/*  814 */     return paramString.startsWith("NOLOG: ");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int countStringToLongArray(String paramString, char paramChar) {
/*  835 */     int i = paramString.length();
/*  836 */     byte b = 0;
/*      */ 
/*      */     
/*  839 */     boolean bool1 = false;
/*  840 */     boolean bool2 = true;
/*  841 */     boolean bool3 = false;
/*  842 */     while (--i > 0) {
/*  843 */       char c = paramString.charAt(i);
/*  844 */       if (c == paramChar) {
/*  845 */         if (!bool1) {
/*  846 */           if (bool2) {
/*  847 */             b++;
/*      */           }
/*  849 */           bool1 = true;
/*  850 */           bool3 = false;
/*  851 */           bool2 = true;
/*      */         }  continue;
/*  853 */       }  if (c == '+' || !bool2) {
/*      */         
/*  855 */         bool1 = false; continue;
/*  856 */       }  if (c >= '0' && c <= '9' && !bool3) {
/*  857 */         bool1 = false; continue;
/*  858 */       }  if (c == '-') {
/*  859 */         bool1 = false;
/*  860 */         bool3 = true;
/*      */         continue;
/*      */       } 
/*  863 */       if (b > 0) {
/*  864 */         return b;
/*      */       }
/*      */       
/*  867 */       bool2 = false;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  872 */     return b + 1;
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
/*      */   
/*      */   public static String getTextBetweenStrings(String paramString1, String paramString2, String paramString3) {
/*  889 */     String str = "";
/*      */     
/*  891 */     if (paramString1.indexOf(paramString2) >= 0 && paramString1.indexOf(paramString3) >= 0) {
/*  892 */       str = paramString1.substring(paramString1.indexOf(paramString2) + paramString2.length(), paramString1.length());
/*  893 */       str = str.substring(0, str.indexOf(paramString3));
/*      */     } 
/*  895 */     return str;
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
/*      */   public static long filetimeToUtcMs(long paramLong, boolean paramBoolean) {
/*  910 */     return paramLong / 10000L - 11644473600000L - (paramBoolean ? TZ_OFFSET : 0L);
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
/*      */   public static String parseMmDdYyyyToYyyyMmDD(String paramString) {
/*      */     try {
/*  924 */       return String.format("%s-%s-%s", new Object[] { paramString.substring(6, 10), paramString.substring(0, 2), paramString
/*  925 */             .substring(3, 5) });
/*  926 */     } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
/*  927 */       return paramString;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static OffsetDateTime parseCimDateTimeToOffset(String paramString) {
/*      */     try {
/*  946 */       int i = Integer.parseInt(paramString.substring(22));
/*      */       
/*  948 */       LocalTime localTime = LocalTime.MIDNIGHT.plusMinutes(i);
/*  949 */       return OffsetDateTime.parse(paramString
/*  950 */           .substring(0, 22) + localTime.format(DateTimeFormatter.ISO_LOCAL_TIME), CIM_FORMAT);
/*      */     }
/*  952 */     catch (IndexOutOfBoundsException|NumberFormatException|java.time.format.DateTimeParseException indexOutOfBoundsException) {
/*      */ 
/*      */       
/*  955 */       LOG.trace("Unable to parse {} to CIM DateTime.", paramString);
/*  956 */       return Constants.UNIX_EPOCH;
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
/*      */ 
/*      */   
/*      */   public static boolean filePathStartsWith(List<String> paramList, String paramString) {
/*  971 */     for (String str : paramList) {
/*  972 */       if (paramString.equals(str) || paramString.startsWith(str + "/")) {
/*  973 */         return true;
/*      */       }
/*      */     } 
/*  976 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long parseMultipliedToLongs(String paramString) {
/*      */     String[] arrayOfString;
/*  987 */     Matcher matcher = UNITS_PATTERN.matcher(paramString.trim());
/*      */     
/*  989 */     if (matcher.find() && matcher.groupCount() == 3) {
/*  990 */       arrayOfString = new String[2];
/*  991 */       arrayOfString[0] = matcher.group(1);
/*  992 */       arrayOfString[1] = matcher.group(3);
/*      */     } else {
/*  994 */       arrayOfString = new String[] { paramString };
/*      */     } 
/*      */     
/*  997 */     double d = parseDoubleOrDefault(arrayOfString[0], 0.0D);
/*  998 */     if (arrayOfString.length == 2 && arrayOfString[1] != null && arrayOfString[1].length() >= 1) {
/*  999 */       switch (arrayOfString[1].charAt(0)) {
/*      */         case 'T':
/* 1001 */           d *= 1.0E12D;
/*      */           break;
/*      */         case 'G':
/* 1004 */           d *= 1.0E9D;
/*      */           break;
/*      */         case 'M':
/* 1007 */           d *= 1000000.0D;
/*      */           break;
/*      */         case 'K':
/*      */         case 'k':
/* 1011 */           d *= 1000.0D;
/*      */           break;
/*      */       } 
/*      */     
/*      */     }
/* 1016 */     return (long)d;
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
/*      */   public static long parseDecimalMemorySizeToBinary(String paramString) {
/* 1029 */     String[] arrayOfString = whitespaces.split(paramString);
/* 1030 */     if (arrayOfString.length < 2) {
/*      */       
/* 1032 */       Matcher matcher = BYTES_PATTERN.matcher(paramString.trim());
/* 1033 */       if (matcher.find() && matcher.groupCount() == 2) {
/* 1034 */         arrayOfString = new String[2];
/* 1035 */         arrayOfString[0] = matcher.group(1);
/* 1036 */         arrayOfString[1] = matcher.group(2);
/*      */       } 
/*      */     } 
/* 1039 */     long l = parseLongOrDefault(arrayOfString[0], 0L);
/* 1040 */     if (arrayOfString.length == 2 && arrayOfString[1].length() > 1) {
/* 1041 */       switch (arrayOfString[1].charAt(0)) {
/*      */         case 'T':
/* 1043 */           l <<= 40L;
/*      */           break;
/*      */         case 'G':
/* 1046 */           l <<= 30L;
/*      */           break;
/*      */         case 'M':
/* 1049 */           l <<= 20L;
/*      */           break;
/*      */         case 'K':
/*      */         case 'k':
/* 1053 */           l <<= 10L;
/*      */           break;
/*      */       } 
/*      */ 
/*      */     
/*      */     }
/* 1059 */     return l;
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
/*      */   public static Triplet<String, String, String> parseDeviceIdToVendorProductSerial(String paramString) {
/* 1073 */     Matcher matcher = VENDOR_PRODUCT_ID_SERIAL.matcher(paramString);
/* 1074 */     if (matcher.matches()) {
/* 1075 */       String str1 = "0x" + matcher.group(1).toLowerCase();
/* 1076 */       String str2 = "0x" + matcher.group(2).toLowerCase();
/* 1077 */       String str3 = matcher.group(4);
/* 1078 */       return new Triplet(str1, str2, (!matcher.group(3).isEmpty() || str3.contains("&")) ? "" : str3);
/*      */     } 
/* 1080 */     return null;
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
/*      */   public static long parseLshwResourceString(String paramString) {
/* 1093 */     long l = 0L;
/*      */     
/* 1095 */     String[] arrayOfString = whitespaces.split(paramString);
/* 1096 */     for (String str : arrayOfString) {
/*      */       
/* 1098 */       if (str.startsWith("memory:")) {
/*      */         
/* 1100 */         String[] arrayOfString1 = str.substring(7).split("-");
/* 1101 */         if (arrayOfString1.length == 2) {
/*      */           
/*      */           try {
/* 1104 */             l += Long.parseLong(arrayOfString1[1], 16) - Long.parseLong(arrayOfString1[0], 16) + 1L;
/* 1105 */           } catch (NumberFormatException numberFormatException) {
/* 1106 */             LOG.trace("{} didn't parse. Returning default. {}", str, numberFormatException);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1111 */     return l;
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
/*      */   public static Pair<String, String> parseLspciMachineReadable(String paramString) {
/* 1123 */     Matcher matcher = LSPCI_MACHINE_READABLE.matcher(paramString);
/* 1124 */     if (matcher.matches()) {
/* 1125 */       return new Pair(matcher.group(1), matcher.group(2));
/*      */     }
/* 1127 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long parseLspciMemorySize(String paramString) {
/* 1138 */     Matcher matcher = LSPCI_MEMORY_SIZE.matcher(paramString);
/* 1139 */     if (matcher.matches()) {
/* 1140 */       return parseDecimalMemorySizeToBinary(matcher.group(1) + " " + matcher.group(2) + "B");
/*      */     }
/* 1142 */     return 0L;
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
/*      */   public static List<Integer> parseHyphenatedIntList(String paramString) {
/* 1156 */     ArrayList<Integer> arrayList = new ArrayList();
/* 1157 */     for (String str : whitespaces.split(paramString)) {
/* 1158 */       if (str.contains("-")) {
/* 1159 */         int i = getFirstIntValue(str);
/* 1160 */         int j = getNthIntValue(str, 2);
/* 1161 */         for (int k = i; k <= j; k++) {
/* 1162 */           arrayList.add(Integer.valueOf(k));
/*      */         }
/*      */       } else {
/* 1165 */         int i = parseIntOrDefault(str, -1);
/* 1166 */         if (i >= 0) {
/* 1167 */           arrayList.add(Integer.valueOf(i));
/*      */         }
/*      */       } 
/*      */     } 
/* 1171 */     return arrayList;
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
/*      */   public static byte[] parseIntToIP(int paramInt) {
/* 1183 */     return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt).array();
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
/*      */   public static byte[] parseIntArrayToIP(int[] paramArrayOfint) {
/* 1195 */     ByteBuffer byteBuffer = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN);
/* 1196 */     for (int i : paramArrayOfint) {
/* 1197 */       byteBuffer.putInt(i);
/*      */     }
/* 1199 */     return byteBuffer.array();
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
/*      */   
/*      */   public static int bigEndian16ToLittleEndian(int paramInt) {
/* 1216 */     return paramInt >> 8 & 0xFF | paramInt << 8 & 0xFF00;
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
/*      */   public static String parseUtAddrV6toIP(int[] paramArrayOfint) {
/* 1230 */     if (paramArrayOfint.length != 4) {
/* 1231 */       throw new IllegalArgumentException("ut_addr_v6 must have exactly 4 elements");
/*      */     }
/*      */     
/* 1234 */     if (paramArrayOfint[1] == 0 && paramArrayOfint[2] == 0 && paramArrayOfint[3] == 0) {
/*      */       
/* 1236 */       if (paramArrayOfint[0] == 0) {
/* 1237 */         return "::";
/*      */       }
/*      */       
/* 1240 */       byte[] arrayOfByte1 = ByteBuffer.allocate(4).putInt(paramArrayOfint[0]).array();
/*      */       try {
/* 1242 */         return InetAddress.getByAddress(arrayOfByte1).getHostAddress();
/* 1243 */       } catch (UnknownHostException unknownHostException) {
/*      */         
/* 1245 */         return "unknown";
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1250 */     byte[] arrayOfByte = ByteBuffer.allocate(16).putInt(paramArrayOfint[0]).putInt(paramArrayOfint[1]).putInt(paramArrayOfint[2]).putInt(paramArrayOfint[3]).array();
/*      */     try {
/* 1252 */       return InetAddress.getByAddress(arrayOfByte).getHostAddress()
/* 1253 */         .replaceAll("((?:(?:^|:)0+\\b){2,}):?(?!\\S*\\b\\1:0+\\b)(\\S*)", "::$2");
/* 1254 */     } catch (UnknownHostException unknownHostException) {
/*      */       
/* 1256 */       return "unknown";
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
/*      */   
/*      */   public static int hexStringToInt(String paramString, int paramInt) {
/* 1270 */     if (paramString != null) {
/*      */       try {
/* 1272 */         if (paramString.startsWith("0x")) {
/* 1273 */           return (new BigInteger(paramString.substring(2), 16)).intValue();
/*      */         }
/* 1275 */         return (new BigInteger(paramString, 16)).intValue();
/*      */       }
/* 1277 */       catch (NumberFormatException numberFormatException) {
/* 1278 */         LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*      */       } 
/*      */     }
/*      */     
/* 1282 */     return paramInt;
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
/*      */   public static long hexStringToLong(String paramString, long paramLong) {
/* 1295 */     if (paramString != null) {
/*      */       try {
/* 1297 */         if (paramString.startsWith("0x")) {
/* 1298 */           return (new BigInteger(paramString.substring(2), 16)).longValue();
/*      */         }
/* 1300 */         return (new BigInteger(paramString, 16)).longValue();
/*      */       }
/* 1302 */       catch (NumberFormatException numberFormatException) {
/* 1303 */         LOG.trace("{} didn't parse. Returning default. {}", paramString, numberFormatException);
/*      */       } 
/*      */     }
/*      */     
/* 1307 */     return paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeLeadingDots(String paramString) {
/* 1318 */     byte b = 0;
/* 1319 */     while (b < paramString.length() && paramString.charAt(b) == '.') {
/* 1320 */       b++;
/*      */     }
/* 1322 */     return (b < paramString.length()) ? paramString.substring(b) : "";
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
/*      */   public static List<String> parseByteArrayToStrings(byte[] paramArrayOfbyte) {
/* 1334 */     ArrayList<String> arrayList = new ArrayList();
/* 1335 */     int i = 0;
/* 1336 */     byte b = 0;
/*      */ 
/*      */     
/*      */     do {
/* 1340 */       if (b != paramArrayOfbyte.length && paramArrayOfbyte[b] != 0)
/*      */         continue; 
/* 1342 */       if (i == b) {
/*      */         break;
/*      */       }
/*      */ 
/*      */       
/* 1347 */       arrayList.add(new String(paramArrayOfbyte, i, b - i));
/* 1348 */       i = b + 1;
/*      */     }
/* 1350 */     while (b++ < paramArrayOfbyte.length);
/* 1351 */     return arrayList;
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
/*      */   public static Map<String, String> parseByteArrayToStringMap(byte[] paramArrayOfbyte) {
/* 1367 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 1368 */     int i = 0;
/* 1369 */     byte b = 0;
/* 1370 */     String str = null;
/*      */ 
/*      */     
/*      */     do {
/* 1374 */       if (b == paramArrayOfbyte.length || paramArrayOfbyte[b] == 0) {
/*      */         
/* 1376 */         if (i == b && str == null) {
/*      */           break;
/*      */         }
/*      */ 
/*      */         
/* 1381 */         linkedHashMap.put(str, new String(paramArrayOfbyte, i, b - i));
/* 1382 */         str = null;
/* 1383 */         i = b + 1;
/* 1384 */       } else if (paramArrayOfbyte[b] == 61 && str == null) {
/* 1385 */         str = new String(paramArrayOfbyte, i, b - i);
/* 1386 */         i = b + 1;
/*      */       } 
/* 1388 */     } while (b++ < paramArrayOfbyte.length);
/* 1389 */     return (Map)linkedHashMap;
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
/*      */   public static Map<String, String> parseCharArrayToStringMap(char[] paramArrayOfchar) {
/* 1405 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 1406 */     int i = 0;
/* 1407 */     byte b = 0;
/* 1408 */     String str = null;
/*      */ 
/*      */     
/*      */     do {
/* 1412 */       if (b == paramArrayOfchar.length || paramArrayOfchar[b] == '\000') {
/*      */         
/* 1414 */         if (i == b && str == null) {
/*      */           break;
/*      */         }
/*      */ 
/*      */         
/* 1419 */         linkedHashMap.put(str, new String(paramArrayOfchar, i, b - i));
/* 1420 */         str = null;
/* 1421 */         i = b + 1;
/* 1422 */       } else if (paramArrayOfchar[b] == '=' && str == null) {
/* 1423 */         str = new String(paramArrayOfchar, i, b - i);
/* 1424 */         i = b + 1;
/*      */       } 
/* 1426 */     } while (b++ < paramArrayOfchar.length);
/* 1427 */     return (Map)linkedHashMap;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K extends Enum<K>> Map<K, String> stringToEnumMap(Class<K> paramClass, String paramString, char paramChar) {
/* 1448 */     EnumMap<K, Object> enumMap = new EnumMap<>(paramClass);
/* 1449 */     int i = 0;
/* 1450 */     int j = paramString.length();
/* 1451 */     EnumSet<K> enumSet = EnumSet.allOf(paramClass);
/* 1452 */     int k = enumSet.size();
/* 1453 */     for (Enum enum_ : enumSet) {
/*      */ 
/*      */       
/* 1456 */       int m = (--k == 0) ? j : paramString.indexOf(paramChar, i);
/* 1457 */       if (m >= 0) {
/* 1458 */         enumMap.put((K)enum_, paramString.substring(i, m));
/* 1459 */         i = m;
/*      */         do {
/* 1461 */           i++;
/* 1462 */         } while (i < j && paramString.charAt(i) == paramChar); continue;
/*      */       } 
/* 1464 */       enumMap.put((K)enum_, paramString.substring(i));
/*      */     } 
/*      */ 
/*      */     
/* 1468 */     return (Map)enumMap;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\ParseUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */