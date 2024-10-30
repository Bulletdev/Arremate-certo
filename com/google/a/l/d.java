/*      */ package com.google.a.l;
/*      */ 
/*      */ import com.google.a.a.a;
/*      */ import com.google.a.a.c;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.e;
/*      */ import com.google.a.b.x;
/*      */ import com.google.a.h.q;
/*      */ import com.google.a.j.h;
/*      */ import com.google.a.m.k;
/*      */ import java.math.BigInteger;
/*      */ import java.net.Inet4Address;
/*      */ import java.net.Inet6Address;
/*      */ import java.net.InetAddress;
/*      */ import java.net.UnknownHostException;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.Arrays;
/*      */ import java.util.Locale;
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
/*      */ @a
/*      */ @c
/*      */ public final class d
/*      */ {
/*      */   private static final int gd = 4;
/*      */   private static final int ge = 8;
/*      */   private static final char n = '.';
/*      */   private static final char o = ':';
/*  105 */   private static final e h = e.a('.');
/*  106 */   private static final e i = e.a(':');
/*  107 */   private static final Inet4Address a = (Inet4Address)a("127.0.0.1");
/*  108 */   private static final Inet4Address b = (Inet4Address)a("0.0.0.0");
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
/*      */   private static Inet4Address a(byte[] paramArrayOfbyte) {
/*  120 */     D.a((paramArrayOfbyte.length == 4), "Byte array has invalid length for an IPv4 address: %s != 4.", paramArrayOfbyte.length);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  126 */     return (Inet4Address)a(paramArrayOfbyte);
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
/*      */   public static InetAddress a(String paramString) {
/*  142 */     byte[] arrayOfByte = b(paramString);
/*      */ 
/*      */     
/*  145 */     if (arrayOfByte == null) {
/*  146 */       throw a("'%s' is not an IP string literal.", new Object[] { paramString });
/*      */     }
/*      */     
/*  149 */     return a(arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean v(String paramString) {
/*  160 */     return (b(paramString) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] b(String paramString) {
/*  166 */     boolean bool1 = false;
/*  167 */     boolean bool2 = false;
/*  168 */     byte b = -1;
/*  169 */     for (byte b1 = 0; b1 < paramString.length(); b1++) {
/*  170 */       char c = paramString.charAt(b1);
/*  171 */       if (c == '.')
/*  172 */       { bool2 = true; }
/*  173 */       else if (c == ':')
/*  174 */       { if (bool2) {
/*  175 */           return null;
/*      */         }
/*  177 */         bool1 = true; }
/*  178 */       else { if (c == '%') {
/*  179 */           b = b1; break;
/*      */         } 
/*  181 */         if (Character.digit(c, 16) == -1) {
/*  182 */           return null;
/*      */         } }
/*      */     
/*      */     } 
/*      */     
/*  187 */     if (bool1) {
/*  188 */       if (bool2) {
/*  189 */         paramString = au(paramString);
/*  190 */         if (paramString == null) {
/*  191 */           return null;
/*      */         }
/*      */       } 
/*  194 */       if (b != -1) {
/*  195 */         paramString = paramString.substring(0, b);
/*      */       }
/*  197 */       return d(paramString);
/*  198 */     }  if (bool2) {
/*  199 */       if (b != -1) {
/*  200 */         return null;
/*      */       }
/*  202 */       return c(paramString);
/*      */     } 
/*  204 */     return null;
/*      */   }
/*      */   
/*      */   private static byte[] c(String paramString) {
/*  208 */     if (h.c(paramString) + 1 != 4) {
/*  209 */       return null;
/*      */     }
/*      */     
/*  212 */     byte[] arrayOfByte = new byte[4];
/*  213 */     int i = 0;
/*      */ 
/*      */     
/*  216 */     for (byte b = 0; b < 4; b++) {
/*  217 */       int j = paramString.indexOf('.', i);
/*  218 */       if (j == -1) {
/*  219 */         j = paramString.length();
/*      */       }
/*      */       try {
/*  222 */         arrayOfByte[b] = a(paramString, i, j);
/*  223 */       } catch (NumberFormatException numberFormatException) {
/*  224 */         return null;
/*      */       } 
/*  226 */       i = j + 1;
/*      */     } 
/*      */     
/*  229 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[] d(String paramString) {
/*  234 */     int i = i.c(paramString);
/*  235 */     if (i < 2 || i > 8) {
/*  236 */       return null;
/*      */     }
/*  238 */     int j = 8 - i + 1;
/*  239 */     boolean bool = false;
/*      */ 
/*      */     
/*  242 */     for (byte b = 0; b < paramString.length() - 1; b++) {
/*  243 */       if (paramString.charAt(b) == ':' && paramString.charAt(b + 1) == ':') {
/*  244 */         if (bool) {
/*  245 */           return null;
/*      */         }
/*  247 */         bool = true;
/*  248 */         j++;
/*  249 */         if (b == 0) {
/*  250 */           j++;
/*      */         }
/*  252 */         if (b == paramString.length() - 2) {
/*  253 */           j++;
/*      */         }
/*      */       } 
/*      */     } 
/*  257 */     if (paramString.charAt(0) == ':' && paramString.charAt(1) != ':') {
/*  258 */       return null;
/*      */     }
/*  260 */     if (paramString.charAt(paramString.length() - 1) == ':' && paramString
/*  261 */       .charAt(paramString.length() - 2) != ':') {
/*  262 */       return null;
/*      */     }
/*  264 */     if (bool && j <= 0) {
/*  265 */       return null;
/*      */     }
/*  267 */     if (!bool && i + 1 != 8) {
/*  268 */       return null;
/*      */     }
/*      */     
/*  271 */     ByteBuffer byteBuffer = ByteBuffer.allocate(16);
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  276 */       int k = 0;
/*  277 */       if (paramString.charAt(0) == ':') {
/*  278 */         k = 1;
/*      */       }
/*  280 */       while (k < paramString.length()) {
/*  281 */         int m = paramString.indexOf(':', k);
/*  282 */         if (m == -1) {
/*  283 */           m = paramString.length();
/*      */         }
/*  285 */         if (paramString.charAt(k) == ':') {
/*      */           
/*  287 */           for (byte b1 = 0; b1 < j; b1++) {
/*  288 */             byteBuffer.putShort((short)0);
/*      */           }
/*      */         } else {
/*      */           
/*  292 */           byteBuffer.putShort(a(paramString, k, m));
/*      */         } 
/*  294 */         k = m + 1;
/*      */       } 
/*  296 */     } catch (NumberFormatException numberFormatException) {
/*  297 */       return null;
/*      */     } 
/*  299 */     return byteBuffer.array();
/*      */   }
/*      */   
/*      */   private static String au(String paramString) {
/*  303 */     int i = paramString.lastIndexOf(':');
/*  304 */     String str1 = paramString.substring(0, i + 1);
/*  305 */     String str2 = paramString.substring(i + 1);
/*  306 */     byte[] arrayOfByte = c(str2);
/*  307 */     if (arrayOfByte == null) {
/*  308 */       return null;
/*      */     }
/*  310 */     String str3 = Integer.toHexString((arrayOfByte[0] & 0xFF) << 8 | arrayOfByte[1] & 0xFF);
/*  311 */     String str4 = Integer.toHexString((arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF);
/*  312 */     return (new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str3).length() + String.valueOf(str4).length())).append(str1).append(str3).append(":").append(str4).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte a(String paramString, int paramInt1, int paramInt2) {
/*  318 */     int i = paramInt2 - paramInt1;
/*  319 */     if (i <= 0 || i > 3) {
/*  320 */       throw new NumberFormatException();
/*      */     }
/*      */ 
/*      */     
/*  324 */     if (i > 1 && paramString.charAt(paramInt1) == '0') {
/*  325 */       throw new NumberFormatException();
/*      */     }
/*  327 */     int j = 0;
/*  328 */     for (int k = paramInt1; k < paramInt2; k++) {
/*  329 */       j *= 10;
/*  330 */       int m = Character.digit(paramString.charAt(k), 10);
/*  331 */       if (m < 0) {
/*  332 */         throw new NumberFormatException();
/*      */       }
/*  334 */       j += m;
/*      */     } 
/*  336 */     if (j > 255) {
/*  337 */       throw new NumberFormatException();
/*      */     }
/*  339 */     return (byte)j;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static short a(String paramString, int paramInt1, int paramInt2) {
/*  345 */     int i = paramInt2 - paramInt1;
/*  346 */     if (i <= 0 || i > 4) {
/*  347 */       throw new NumberFormatException();
/*      */     }
/*  349 */     int j = 0;
/*  350 */     for (int k = paramInt1; k < paramInt2; k++) {
/*  351 */       j <<= 4;
/*  352 */       j |= Character.digit(paramString.charAt(k), 16);
/*      */     } 
/*  354 */     return (short)j;
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
/*      */   private static InetAddress a(byte[] paramArrayOfbyte) {
/*      */     try {
/*  369 */       return InetAddress.getByAddress(paramArrayOfbyte);
/*  370 */     } catch (UnknownHostException unknownHostException) {
/*  371 */       throw new AssertionError(unknownHostException);
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
/*      */ 
/*      */   
/*      */   public static String a(InetAddress paramInetAddress) {
/*  391 */     D.checkNotNull(paramInetAddress);
/*  392 */     if (paramInetAddress instanceof Inet4Address)
/*      */     {
/*  394 */       return paramInetAddress.getHostAddress();
/*      */     }
/*  396 */     D.checkArgument(paramInetAddress instanceof Inet6Address);
/*  397 */     byte[] arrayOfByte = paramInetAddress.getAddress();
/*  398 */     int[] arrayOfInt = new int[8];
/*  399 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/*  400 */       arrayOfInt[b] = k.a((byte)0, (byte)0, arrayOfByte[2 * b], arrayOfByte[2 * b + 1]);
/*      */     }
/*  402 */     b(arrayOfInt);
/*  403 */     return a(arrayOfInt);
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
/*      */   private static void b(int[] paramArrayOfint) {
/*  415 */     byte b1 = -1;
/*  416 */     int i = -1;
/*  417 */     byte b2 = -1;
/*  418 */     for (byte b = 0; b < paramArrayOfint.length + 1; b++) {
/*  419 */       if (b < paramArrayOfint.length && paramArrayOfint[b] == 0) {
/*  420 */         if (b2 < 0) {
/*  421 */           b2 = b;
/*      */         }
/*  423 */       } else if (b2 >= 0) {
/*  424 */         int j = b - b2;
/*  425 */         if (j > i) {
/*  426 */           b1 = b2;
/*  427 */           i = j;
/*      */         } 
/*  429 */         b2 = -1;
/*      */       } 
/*      */     } 
/*  432 */     if (i >= 2) {
/*  433 */       Arrays.fill(paramArrayOfint, b1, b1 + i, -1);
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
/*      */   private static String a(int[] paramArrayOfint) {
/*  450 */     StringBuilder stringBuilder = new StringBuilder(39);
/*  451 */     boolean bool = false;
/*  452 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*  453 */       boolean bool1 = (paramArrayOfint[b] >= 0) ? true : false;
/*  454 */       if (bool1) {
/*  455 */         if (bool) {
/*  456 */           stringBuilder.append(':');
/*      */         }
/*  458 */         stringBuilder.append(Integer.toHexString(paramArrayOfint[b]));
/*      */       }
/*  460 */       else if (b == 0 || bool) {
/*  461 */         stringBuilder.append("::");
/*      */       } 
/*      */       
/*  464 */       bool = bool1;
/*      */     } 
/*  466 */     return stringBuilder.toString();
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
/*      */   public static String b(InetAddress paramInetAddress) {
/*  489 */     if (paramInetAddress instanceof Inet6Address) {
/*  490 */       String str = a(paramInetAddress); return (new StringBuilder(2 + String.valueOf(str).length())).append("[").append(str).append("]").toString();
/*      */     } 
/*  492 */     return a(paramInetAddress);
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
/*      */   public static InetAddress b(String paramString) {
/*  510 */     InetAddress inetAddress = c(paramString);
/*  511 */     if (inetAddress == null) {
/*  512 */       throw a("Not a valid URI IP literal: '%s'", new Object[] { paramString });
/*      */     }
/*      */     
/*  515 */     return inetAddress;
/*      */   } private static InetAddress c(String paramString) {
/*      */     String str;
/*      */     byte b;
/*  519 */     D.checkNotNull(paramString);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  524 */     if (paramString.startsWith("[") && paramString.endsWith("]")) {
/*  525 */       str = paramString.substring(1, paramString.length() - 1);
/*  526 */       b = 16;
/*      */     } else {
/*  528 */       str = paramString;
/*  529 */       b = 4;
/*      */     } 
/*      */ 
/*      */     
/*  533 */     byte[] arrayOfByte = b(str);
/*  534 */     if (arrayOfByte == null || arrayOfByte.length != b) {
/*  535 */       return null;
/*      */     }
/*      */     
/*  538 */     return a(arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean w(String paramString) {
/*  549 */     return (c(paramString) != null);
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
/*      */   public static boolean a(Inet6Address paramInet6Address) {
/*  571 */     if (!paramInet6Address.isIPv4CompatibleAddress()) {
/*  572 */       return false;
/*      */     }
/*      */     
/*  575 */     byte[] arrayOfByte = paramInet6Address.getAddress();
/*  576 */     if (arrayOfByte[12] == 0 && arrayOfByte[13] == 0 && arrayOfByte[14] == 0 && (arrayOfByte[15] == 0 || arrayOfByte[15] == 1))
/*      */     {
/*      */ 
/*      */       
/*  580 */       return false;
/*      */     }
/*      */     
/*  583 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Inet4Address a(Inet6Address paramInet6Address) {
/*  594 */     D.a(
/*  595 */         a(paramInet6Address), "Address '%s' is not IPv4-compatible.", a(paramInet6Address));
/*      */     
/*  597 */     return a(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
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
/*      */   public static boolean b(Inet6Address paramInet6Address) {
/*  613 */     byte[] arrayOfByte = paramInet6Address.getAddress();
/*  614 */     return (arrayOfByte[0] == 32 && arrayOfByte[1] == 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Inet4Address b(Inet6Address paramInet6Address) {
/*  625 */     D.a(b(paramInet6Address), "Address '%s' is not a 6to4 address.", a(paramInet6Address));
/*      */     
/*  627 */     return a(Arrays.copyOfRange(paramInet6Address.getAddress(), 2, 6));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @a
/*      */   public static final class a
/*      */   {
/*      */     private final Inet4Address c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Inet4Address d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int port;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int flags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public a(Inet4Address param1Inet4Address1, Inet4Address param1Inet4Address2, int param1Int1, int param1Int2) {
/*  662 */       D.a((param1Int1 >= 0 && param1Int1 <= 65535), "port '%s' is out of range (0 <= port <= 0xffff)", param1Int1);
/*      */       
/*  664 */       D.a((param1Int2 >= 0 && param1Int2 <= 65535), "flags '%s' is out of range (0 <= flags <= 0xffff)", param1Int2);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  669 */       this.c = (Inet4Address)x.a(param1Inet4Address1, d.a());
/*  670 */       this.d = (Inet4Address)x.a(param1Inet4Address2, d.a());
/*  671 */       this.port = param1Int1;
/*  672 */       this.flags = param1Int2;
/*      */     }
/*      */     
/*      */     public Inet4Address b() {
/*  676 */       return this.c;
/*      */     }
/*      */     
/*      */     public Inet4Address c() {
/*  680 */       return this.d;
/*      */     }
/*      */     
/*      */     public int getPort() {
/*  684 */       return this.port;
/*      */     }
/*      */     
/*      */     public int getFlags() {
/*  688 */       return this.flags;
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
/*      */   public static boolean c(Inet6Address paramInet6Address) {
/*  701 */     byte[] arrayOfByte = paramInet6Address.getAddress();
/*  702 */     return (arrayOfByte[0] == 32 && arrayOfByte[1] == 1 && arrayOfByte[2] == 0 && arrayOfByte[3] == 0);
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
/*      */   public static a a(Inet6Address paramInet6Address) {
/*  716 */     D.a(c(paramInet6Address), "Address '%s' is not a Teredo address.", a(paramInet6Address));
/*      */     
/*  718 */     byte[] arrayOfByte1 = paramInet6Address.getAddress();
/*  719 */     Inet4Address inet4Address1 = a(Arrays.copyOfRange(arrayOfByte1, 4, 8));
/*      */     
/*  721 */     int i = h.a(arrayOfByte1, 8).readShort() & 0xFFFF;
/*      */ 
/*      */     
/*  724 */     int j = (h.a(arrayOfByte1, 10).readShort() ^ 0xFFFFFFFF) & 0xFFFF;
/*      */     
/*  726 */     byte[] arrayOfByte2 = Arrays.copyOfRange(arrayOfByte1, 12, 16);
/*  727 */     for (byte b = 0; b < arrayOfByte2.length; b++)
/*      */     {
/*  729 */       arrayOfByte2[b] = (byte)(arrayOfByte2[b] ^ 0xFFFFFFFF);
/*      */     }
/*  731 */     Inet4Address inet4Address2 = a(arrayOfByte2);
/*      */     
/*  733 */     return new a(inet4Address1, inet4Address2, j, i);
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
/*      */   public static boolean d(Inet6Address paramInet6Address) {
/*  753 */     if (c(paramInet6Address)) {
/*  754 */       return false;
/*      */     }
/*      */     
/*  757 */     byte[] arrayOfByte = paramInet6Address.getAddress();
/*      */     
/*  759 */     if ((arrayOfByte[8] | 0x3) != 3)
/*      */     {
/*      */ 
/*      */       
/*  763 */       return false;
/*      */     }
/*      */     
/*  766 */     return (arrayOfByte[9] == 0 && arrayOfByte[10] == 94 && arrayOfByte[11] == -2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Inet4Address c(Inet6Address paramInet6Address) {
/*  777 */     D.a(d(paramInet6Address), "Address '%s' is not an ISATAP address.", a(paramInet6Address));
/*      */     
/*  779 */     return a(Arrays.copyOfRange(paramInet6Address.getAddress(), 12, 16));
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
/*      */   public static boolean e(Inet6Address paramInet6Address) {
/*  795 */     return (a(paramInet6Address) || b(paramInet6Address) || c(paramInet6Address));
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
/*      */   public static Inet4Address d(Inet6Address paramInet6Address) {
/*  811 */     if (a(paramInet6Address)) {
/*  812 */       return a(paramInet6Address);
/*      */     }
/*      */     
/*  815 */     if (b(paramInet6Address)) {
/*  816 */       return b(paramInet6Address);
/*      */     }
/*      */     
/*  819 */     if (c(paramInet6Address)) {
/*  820 */       return a(paramInet6Address).c();
/*      */     }
/*      */     
/*  823 */     throw a("'%s' has no embedded IPv4 address.", new Object[] { a(paramInet6Address) });
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
/*      */   public static boolean x(String paramString) {
/*  845 */     byte[] arrayOfByte = b(paramString);
/*  846 */     if (arrayOfByte != null && arrayOfByte.length == 16) {
/*  847 */       byte b; for (b = 0; b < 10; b++) {
/*  848 */         if (arrayOfByte[b] != 0) {
/*  849 */           return false;
/*      */         }
/*      */       } 
/*  852 */       for (b = 10; b < 12; b++) {
/*  853 */         if (arrayOfByte[b] != -1) {
/*  854 */           return false;
/*      */         }
/*      */       } 
/*  857 */       return true;
/*      */     } 
/*  859 */     return false;
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
/*      */   public static Inet4Address a(InetAddress paramInetAddress) {
/*  886 */     if (paramInetAddress instanceof Inet4Address) {
/*  887 */       return (Inet4Address)paramInetAddress;
/*      */     }
/*      */ 
/*      */     
/*  891 */     byte[] arrayOfByte = paramInetAddress.getAddress();
/*  892 */     boolean bool = true;
/*  893 */     for (byte b = 0; b < 15; b++) {
/*  894 */       if (arrayOfByte[b] != 0) {
/*  895 */         bool = false;
/*      */         break;
/*      */       } 
/*      */     } 
/*  899 */     if (bool && arrayOfByte[15] == 1)
/*  900 */       return a; 
/*  901 */     if (bool && arrayOfByte[15] == 0) {
/*  902 */       return b;
/*      */     }
/*      */     
/*  905 */     Inet6Address inet6Address = (Inet6Address)paramInetAddress;
/*  906 */     long l = 0L;
/*  907 */     if (e(inet6Address)) {
/*  908 */       l = d(inet6Address).hashCode();
/*      */     } else {
/*      */       
/*  911 */       l = ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong();
/*      */     } 
/*      */ 
/*      */     
/*  915 */     int i = q.a().a(l).asInt();
/*      */ 
/*      */     
/*  918 */     i |= 0xE0000000;
/*      */ 
/*      */ 
/*      */     
/*  922 */     if (i == -1) {
/*  923 */       i = -2;
/*      */     }
/*      */     
/*  926 */     return a(k.a(i));
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
/*      */   public static int a(InetAddress paramInetAddress) {
/*  948 */     return h.a(a(paramInetAddress).getAddress()).readInt();
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
/*      */   public static BigInteger a(InetAddress paramInetAddress) {
/*  961 */     return new BigInteger(1, paramInetAddress.getAddress());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Inet4Address a(int paramInt) {
/*  971 */     return a(k.a(paramInt));
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
/*      */   public static Inet4Address a(BigInteger paramBigInteger) {
/*  983 */     return (Inet4Address)a(paramBigInteger, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Inet6Address a(BigInteger paramBigInteger) {
/*  994 */     return (Inet6Address)a(paramBigInteger, true);
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
/*      */   private static InetAddress a(BigInteger paramBigInteger, boolean paramBoolean) {
/* 1008 */     D.a((paramBigInteger.signum() >= 0), "BigInteger must be greater than or equal to 0");
/*      */     
/* 1010 */     byte b1 = paramBoolean ? 16 : 4;
/*      */     
/* 1012 */     byte[] arrayOfByte1 = paramBigInteger.toByteArray();
/* 1013 */     byte[] arrayOfByte2 = new byte[b1];
/*      */     
/* 1015 */     int i = Math.max(0, arrayOfByte1.length - b1);
/* 1016 */     int j = arrayOfByte1.length - i;
/* 1017 */     int k = b1 - j;
/*      */ 
/*      */     
/* 1020 */     for (byte b2 = 0; b2 < i; b2++) {
/* 1021 */       if (arrayOfByte1[b2] != 0) {
/* 1022 */         throw a("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", new Object[] {
/*      */ 
/*      */               
/* 1025 */               Integer.valueOf(b1), paramBigInteger
/*      */             });
/*      */       }
/*      */     } 
/*      */     
/* 1030 */     System.arraycopy(arrayOfByte1, i, arrayOfByte2, k, j);
/*      */     
/*      */     try {
/* 1033 */       return InetAddress.getByAddress(arrayOfByte2);
/* 1034 */     } catch (UnknownHostException unknownHostException) {
/* 1035 */       throw new AssertionError(unknownHostException);
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
/*      */   public static InetAddress b(byte[] paramArrayOfbyte) throws UnknownHostException {
/* 1050 */     byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
/* 1051 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 1052 */       arrayOfByte[b] = paramArrayOfbyte[paramArrayOfbyte.length - b - 1];
/*      */     }
/* 1054 */     return InetAddress.getByAddress(arrayOfByte);
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
/*      */   public static InetAddress a(InetAddress paramInetAddress) {
/* 1067 */     byte[] arrayOfByte = paramInetAddress.getAddress();
/* 1068 */     int i = arrayOfByte.length - 1;
/* 1069 */     while (i >= 0 && arrayOfByte[i] == 0) {
/* 1070 */       arrayOfByte[i] = -1;
/* 1071 */       i--;
/*      */     } 
/*      */     
/* 1074 */     D.a((i >= 0), "Decrementing %s would wrap.", paramInetAddress);
/*      */     
/* 1076 */     arrayOfByte[i] = (byte)(arrayOfByte[i] - 1);
/* 1077 */     return a(arrayOfByte);
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
/*      */   public static InetAddress b(InetAddress paramInetAddress) {
/* 1090 */     byte[] arrayOfByte = paramInetAddress.getAddress();
/* 1091 */     int i = arrayOfByte.length - 1;
/* 1092 */     while (i >= 0 && arrayOfByte[i] == -1) {
/* 1093 */       arrayOfByte[i] = 0;
/* 1094 */       i--;
/*      */     } 
/*      */     
/* 1097 */     D.a((i >= 0), "Incrementing %s would wrap.", paramInetAddress);
/*      */     
/* 1099 */     arrayOfByte[i] = (byte)(arrayOfByte[i] + 1);
/* 1100 */     return a(arrayOfByte);
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
/*      */   public static boolean a(InetAddress paramInetAddress) {
/* 1112 */     byte[] arrayOfByte = paramInetAddress.getAddress();
/* 1113 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 1114 */       if (arrayOfByte[b] != -1) {
/* 1115 */         return false;
/*      */       }
/*      */     } 
/* 1118 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static IllegalArgumentException a(String paramString, Object... paramVarArgs) {
/* 1123 */     return new IllegalArgumentException(String.format(Locale.ROOT, paramString, paramVarArgs));
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\l\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */