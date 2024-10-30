/*      */ package com.google.a.j;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.y;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.io.Reader;
/*      */ import java.io.Writer;
/*      */ import java.math.RoundingMode;
/*      */ import java.util.Arrays;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @b(cl = true)
/*      */ public abstract class b
/*      */ {
/*      */   public static final class d
/*      */     extends IOException
/*      */   {
/*      */     d(String param1String) {
/*  138 */       super(param1String);
/*      */     }
/*      */     
/*      */     d(Throwable param1Throwable) {
/*  142 */       super(param1Throwable);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String encode(byte[] paramArrayOfbyte) {
/*  148 */     return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  156 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
/*  157 */     StringBuilder stringBuilder = new StringBuilder(J(paramInt2));
/*      */     try {
/*  159 */       a(stringBuilder, paramArrayOfbyte, paramInt1, paramInt2);
/*  160 */     } catch (IOException iOException) {
/*  161 */       throw new AssertionError(iOException);
/*      */     } 
/*  163 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   public abstract OutputStream a(Writer paramWriter);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   public final f a(j paramj) {
/*  179 */     D.checkNotNull(paramj);
/*  180 */     return new f(this, paramj)
/*      */       {
/*      */         public OutputStream a() throws IOException {
/*  183 */           return this.f.a(this.a.a());
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
/*  191 */     if (paramInt == paramArrayOfbyte.length) {
/*  192 */       return paramArrayOfbyte;
/*      */     }
/*  194 */     byte[] arrayOfByte = new byte[paramInt];
/*  195 */     System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramInt);
/*  196 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract boolean e(CharSequence paramCharSequence);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final byte[] a(CharSequence paramCharSequence) {
/*      */     try {
/*  217 */       return b(paramCharSequence);
/*  218 */     } catch (d d) {
/*  219 */       throw new IllegalArgumentException(d);
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
/*      */   final byte[] b(CharSequence paramCharSequence) throws d {
/*  231 */     paramCharSequence = a(paramCharSequence);
/*  232 */     byte[] arrayOfByte = new byte[K(paramCharSequence.length())];
/*  233 */     int i = a(arrayOfByte, paramCharSequence);
/*  234 */     return a(arrayOfByte, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   public abstract InputStream a(Reader paramReader);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   public final g a(k paramk) {
/*  250 */     D.checkNotNull(paramk);
/*  251 */     return new g(this, paramk)
/*      */       {
/*      */         public InputStream a() throws IOException {
/*  254 */           return this.f.a(this.a.a());
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   abstract int J(int paramInt);
/*      */ 
/*      */   
/*      */   abstract void a(Appendable paramAppendable, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
/*      */   
/*      */   abstract int K(int paramInt);
/*      */   
/*      */   abstract int a(byte[] paramArrayOfbyte, CharSequence paramCharSequence) throws d;
/*      */   
/*      */   CharSequence a(CharSequence paramCharSequence) {
/*  270 */     return (CharSequence)D.checkNotNull(paramCharSequence);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  320 */   private static final b a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", 
/*      */       
/*  322 */       Character.valueOf('='));
/*      */ 
/*      */   
/*      */   public abstract b a();
/*      */ 
/*      */   
/*      */   public abstract b a(char paramChar);
/*      */ 
/*      */   
/*      */   public abstract b a(String paramString, int paramInt);
/*      */   
/*      */   public abstract b b();
/*      */   
/*      */   public abstract b c();
/*      */   
/*      */   public static b d() {
/*  338 */     return a;
/*      */   }
/*      */   
/*  341 */   private static final b b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", 
/*      */       
/*  343 */       Character.valueOf('='));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static b e() {
/*  360 */     return b;
/*      */   }
/*      */   
/*  363 */   private static final b c = new f("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", 
/*  364 */       Character.valueOf('='));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static b f() {
/*  379 */     return c;
/*      */   }
/*      */   
/*  382 */   private static final b d = new f("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", 
/*  383 */       Character.valueOf('='));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static b g() {
/*  398 */     return d;
/*      */   }
/*      */   
/*  401 */   private static final b e = new b("base16()", "0123456789ABCDEF");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static b h() {
/*  417 */     return e;
/*      */   }
/*      */   
/*      */   private static final class a
/*      */   {
/*      */     private final String name;
/*      */     private final char[] chars;
/*      */     final int mask;
/*      */     final int fH;
/*      */     final int fI;
/*      */     final int fJ;
/*      */     private final byte[] a;
/*      */     private final boolean[] b;
/*      */     
/*      */     a(String param1String, char[] param1ArrayOfchar) {
/*  432 */       this.name = (String)D.checkNotNull(param1String);
/*  433 */       this.chars = (char[])D.checkNotNull(param1ArrayOfchar);
/*      */       try {
/*  435 */         this.fH = com.google.a.k.e.a(param1ArrayOfchar.length, RoundingMode.UNNECESSARY);
/*  436 */       } catch (ArithmeticException arithmeticException) {
/*  437 */         int j = param1ArrayOfchar.length; throw new IllegalArgumentException((new StringBuilder(35)).append("Illegal alphabet length ").append(j).toString(), arithmeticException);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  444 */       int i = Math.min(8, Integer.lowestOneBit(this.fH));
/*      */       try {
/*  446 */         this.fI = 8 / i;
/*  447 */         this.fJ = this.fH / i;
/*  448 */       } catch (ArithmeticException arithmeticException) {
/*  449 */         String.valueOf(new String(param1ArrayOfchar)); throw new IllegalArgumentException((String.valueOf(new String(param1ArrayOfchar)).length() != 0) ? "Illegal alphabet ".concat(String.valueOf(new String(param1ArrayOfchar))) : new String("Illegal alphabet "), arithmeticException);
/*      */       } 
/*      */       
/*  452 */       this.mask = param1ArrayOfchar.length - 1;
/*      */       
/*  454 */       byte[] arrayOfByte = new byte[128];
/*  455 */       Arrays.fill(arrayOfByte, (byte)-1);
/*  456 */       for (byte b1 = 0; b1 < param1ArrayOfchar.length; b1++) {
/*  457 */         char c = param1ArrayOfchar[b1];
/*  458 */         D.a((c < arrayOfByte.length), "Non-ASCII character: %s", c);
/*  459 */         D.a((arrayOfByte[c] == -1), "Duplicate character: %s", c);
/*  460 */         arrayOfByte[c] = (byte)b1;
/*      */       } 
/*  462 */       this.a = arrayOfByte;
/*      */       
/*  464 */       boolean[] arrayOfBoolean = new boolean[this.fI];
/*  465 */       for (byte b2 = 0; b2 < this.fJ; b2++) {
/*  466 */         arrayOfBoolean[com.google.a.k.e.a(b2 * 8, this.fH, RoundingMode.CEILING)] = true;
/*      */       }
/*  468 */       this.b = arrayOfBoolean;
/*      */     }
/*      */     
/*      */     char a(int param1Int) {
/*  472 */       return this.chars[param1Int];
/*      */     }
/*      */     
/*      */     boolean o(int param1Int) {
/*  476 */       return this.b[param1Int % this.fI];
/*      */     }
/*      */     
/*      */     boolean c(char param1Char) {
/*  480 */       return (param1Char <= '' && this.a[param1Char] != -1);
/*      */     }
/*      */     
/*      */     int b(char param1Char) throws b.d {
/*  484 */       if (param1Char > '') {
/*  485 */         String.valueOf(Integer.toHexString(param1Char)); throw new b.d((String.valueOf(Integer.toHexString(param1Char)).length() != 0) ? "Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(param1Char))) : new String("Unrecognized character: 0x"));
/*      */       } 
/*  487 */       byte b = this.a[param1Char];
/*  488 */       if (b == -1) {
/*  489 */         if (param1Char <= ' ' || param1Char == '') {
/*  490 */           String.valueOf(Integer.toHexString(param1Char)); throw new b.d((String.valueOf(Integer.toHexString(param1Char)).length() != 0) ? "Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(param1Char))) : new String("Unrecognized character: 0x"));
/*      */         } 
/*  492 */         throw new b.d((new StringBuilder(25)).append("Unrecognized character: ").append(param1Char).toString());
/*      */       } 
/*      */       
/*  495 */       return b;
/*      */     }
/*      */     
/*      */     private boolean dd() {
/*  499 */       for (char c : this.chars) {
/*  500 */         if (com.google.a.b.c.a(c)) {
/*  501 */           return true;
/*      */         }
/*      */       } 
/*  504 */       return false;
/*      */     }
/*      */     
/*      */     private boolean de() {
/*  508 */       for (char c : this.chars) {
/*  509 */         if (com.google.a.b.c.b(c)) {
/*  510 */           return true;
/*      */         }
/*      */       } 
/*  513 */       return false;
/*      */     }
/*      */     
/*      */     a a() {
/*  517 */       if (!dd()) {
/*  518 */         return this;
/*      */       }
/*  520 */       D.b(!de(), "Cannot call upperCase() on a mixed-case alphabet");
/*  521 */       char[] arrayOfChar = new char[this.chars.length];
/*  522 */       for (byte b = 0; b < this.chars.length; b++) {
/*  523 */         arrayOfChar[b] = com.google.a.b.c.b(this.chars[b]);
/*      */       }
/*  525 */       return new a(String.valueOf(this.name).concat(".upperCase()"), arrayOfChar);
/*      */     }
/*      */ 
/*      */     
/*      */     a b() {
/*  530 */       if (!de()) {
/*  531 */         return this;
/*      */       }
/*  533 */       D.b(!dd(), "Cannot call lowerCase() on a mixed-case alphabet");
/*  534 */       char[] arrayOfChar = new char[this.chars.length];
/*  535 */       for (byte b = 0; b < this.chars.length; b++) {
/*  536 */         arrayOfChar[b] = com.google.a.b.c.a(this.chars[b]);
/*      */       }
/*  538 */       return new a(String.valueOf(this.name).concat(".lowerCase()"), arrayOfChar);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/*  543 */       return (param1Char < this.a.length && this.a[param1Char] != -1);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  548 */       return this.name;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  553 */       if (param1Object instanceof a) {
/*  554 */         a a1 = (a)param1Object;
/*  555 */         return Arrays.equals(this.chars, a1.chars);
/*      */       } 
/*  557 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  562 */       return Arrays.hashCode(this.chars);
/*      */     }
/*      */   }
/*      */   
/*      */   static class f
/*      */     extends b
/*      */   {
/*      */     final b.a a;
/*      */     final Character a;
/*      */     
/*      */     f(String param1String1, String param1String2, Character param1Character) {
/*  573 */       this(new b.a(param1String1, param1String2.toCharArray()), param1Character);
/*      */     } @com.google.b.a.a.b
/*      */     private transient b h; @com.google.b.a.a.b
/*      */     private transient b i; f(b.a param1a, Character param1Character) {
/*  577 */       this.a = (Character)D.checkNotNull(param1a);
/*  578 */       D.a((param1Character == null || 
/*  579 */           !param1a.matches(param1Character.charValue())), "Padding character %s was already in alphabet", param1Character);
/*      */ 
/*      */       
/*  582 */       this.a = param1Character;
/*      */     }
/*      */ 
/*      */     
/*      */     int J(int param1Int) {
/*  587 */       return ((b.a)this.a).fI * com.google.a.k.e.a(param1Int, ((b.a)this.a).fJ, RoundingMode.CEILING);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     public OutputStream a(Writer param1Writer) {
/*  593 */       D.checkNotNull(param1Writer);
/*  594 */       return new OutputStream(this, param1Writer) {
/*  595 */           int fL = 0;
/*  596 */           int fM = 0;
/*  597 */           int fN = 0;
/*      */ 
/*      */           
/*      */           public void write(int param2Int) throws IOException {
/*  601 */             this.fL <<= 8;
/*  602 */             this.fL |= param2Int & 0xFF;
/*  603 */             this.fM += 8;
/*  604 */             while (this.fM >= ((b.a)this.a.a).fH) {
/*  605 */               int i = this.fL >> this.fM - ((b.a)this.a.a).fH & ((b.a)this.a.a).mask;
/*  606 */               this.b.write(this.a.a.a(i));
/*  607 */               this.fN++;
/*  608 */               this.fM -= ((b.a)this.a.a).fH;
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public void flush() throws IOException {
/*  614 */             this.b.flush();
/*      */           }
/*      */ 
/*      */           
/*      */           public void close() throws IOException {
/*  619 */             if (this.fM > 0) {
/*  620 */               int i = this.fL << ((b.a)this.a.a).fH - this.fM & ((b.a)this.a.a).mask;
/*  621 */               this.b.write(this.a.a.a(i));
/*  622 */               this.fN++;
/*  623 */               if (this.a.a != null) {
/*  624 */                 while (this.fN % ((b.a)this.a.a).fI != 0) {
/*  625 */                   this.b.write(this.a.a.charValue());
/*  626 */                   this.fN++;
/*      */                 } 
/*      */               }
/*      */             } 
/*  630 */             this.b.close();
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */     
/*      */     void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*  637 */       D.checkNotNull(param1Appendable);
/*  638 */       D.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length); int i;
/*  639 */       for (i = 0; i < param1Int2; i += ((b.a)this.a).fJ) {
/*  640 */         b(param1Appendable, param1ArrayOfbyte, param1Int1 + i, Math.min(((b.a)this.a).fJ, param1Int2 - i));
/*      */       }
/*      */     }
/*      */     
/*      */     void b(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*  645 */       D.checkNotNull(param1Appendable);
/*  646 */       D.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
/*  647 */       D.checkArgument((param1Int2 <= ((b.a)this.a).fJ));
/*  648 */       long l = 0L; int i;
/*  649 */       for (i = 0; i < param1Int2; i++) {
/*  650 */         l |= (param1ArrayOfbyte[param1Int1 + i] & 0xFF);
/*  651 */         l <<= 8L;
/*      */       } 
/*      */       
/*  654 */       i = (param1Int2 + 1) * 8 - ((b.a)this.a).fH;
/*  655 */       int j = 0;
/*  656 */       while (j < param1Int2 * 8) {
/*  657 */         int k = (int)(l >>> i - j) & ((b.a)this.a).mask;
/*  658 */         param1Appendable.append(this.a.a(k));
/*  659 */         j += ((b.a)this.a).fH;
/*      */       } 
/*  661 */       if (this.a != null) {
/*  662 */         while (j < ((b.a)this.a).fJ * 8) {
/*  663 */           param1Appendable.append(this.a.charValue());
/*  664 */           j += ((b.a)this.a).fH;
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     int K(int param1Int) {
/*  671 */       return (int)((((b.a)this.a).fH * param1Int + 7L) / 8L);
/*      */     }
/*      */ 
/*      */     
/*      */     CharSequence a(CharSequence param1CharSequence) {
/*  676 */       D.checkNotNull(param1CharSequence);
/*  677 */       if (this.a == null) {
/*  678 */         return param1CharSequence;
/*      */       }
/*  680 */       char c = this.a.charValue();
/*      */       int i;
/*  682 */       for (i = param1CharSequence.length() - 1; i >= 0 && 
/*  683 */         param1CharSequence.charAt(i) == c; i--);
/*      */ 
/*      */ 
/*      */       
/*  687 */       return param1CharSequence.subSequence(0, i + 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean e(CharSequence param1CharSequence) {
/*  692 */       D.checkNotNull(param1CharSequence);
/*  693 */       param1CharSequence = a(param1CharSequence);
/*  694 */       if (!this.a.o(param1CharSequence.length())) {
/*  695 */         return false;
/*      */       }
/*  697 */       for (byte b1 = 0; b1 < param1CharSequence.length(); b1++) {
/*  698 */         if (!this.a.c(param1CharSequence.charAt(b1))) {
/*  699 */           return false;
/*      */         }
/*      */       } 
/*  702 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws b.d {
/*  707 */       D.checkNotNull(param1ArrayOfbyte);
/*  708 */       param1CharSequence = a(param1CharSequence);
/*  709 */       if (!this.a.o(param1CharSequence.length())) {
/*  710 */         int j = param1CharSequence.length(); throw new b.d((new StringBuilder(32)).append("Invalid input length ").append(j).toString());
/*      */       } 
/*  712 */       byte b1 = 0; int i;
/*  713 */       for (i = 0; i < param1CharSequence.length(); i += ((b.a)this.a).fI) {
/*  714 */         long l = 0L;
/*  715 */         byte b2 = 0; int j;
/*  716 */         for (j = 0; j < ((b.a)this.a).fI; j++) {
/*  717 */           l <<= ((b.a)this.a).fH;
/*  718 */           if (i + j < param1CharSequence.length()) {
/*  719 */             l |= this.a.b(param1CharSequence.charAt(i + b2++));
/*      */           }
/*      */         } 
/*  722 */         j = ((b.a)this.a).fJ * 8 - b2 * ((b.a)this.a).fH;
/*  723 */         for (int k = (((b.a)this.a).fJ - 1) * 8; k >= j; k -= 8) {
/*  724 */           param1ArrayOfbyte[b1++] = (byte)(int)(l >>> k & 0xFFL);
/*      */         }
/*      */       } 
/*  727 */       return b1;
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     public InputStream a(Reader param1Reader) {
/*  733 */       D.checkNotNull(param1Reader);
/*  734 */       return new InputStream(this, param1Reader) {
/*  735 */           int fL = 0;
/*  736 */           int fM = 0;
/*  737 */           int fO = 0;
/*      */           
/*      */           boolean aZ = false;
/*      */           
/*      */           public int read() throws IOException {
/*      */             while (true) {
/*  743 */               int i = this.b.read();
/*  744 */               if (i == -1) {
/*  745 */                 if (!this.aZ && !this.a.a.o(this.fO)) {
/*  746 */                   int j = this.fO; throw new b.d((new StringBuilder(32)).append("Invalid input length ").append(j).toString());
/*      */                 } 
/*  748 */                 return -1;
/*      */               } 
/*  750 */               this.fO++;
/*  751 */               char c = (char)i;
/*  752 */               if (this.a.a != null && this.a.a.charValue() == c) {
/*  753 */                 if (!this.aZ && (this.fO == 1 || 
/*  754 */                   !this.a.a.o(this.fO - 1))) {
/*  755 */                   int j = this.fO; throw new b.d((new StringBuilder(41)).append("Padding cannot start at index ").append(j).toString());
/*      */                 } 
/*  757 */                 this.aZ = true; continue;
/*  758 */               }  if (this.aZ) {
/*  759 */                 int j = this.fO; throw new b.d((new StringBuilder(61)).append("Expected padding character but found '").append(c).append("' at index ").append(j).toString());
/*      */               } 
/*      */               
/*  762 */               this.fL <<= ((b.a)this.a.a).fH;
/*  763 */               this.fL |= this.a.a.b(c);
/*  764 */               this.fM += ((b.a)this.a.a).fH;
/*      */               
/*  766 */               if (this.fM >= 8) {
/*  767 */                 this.fM -= 8;
/*  768 */                 return this.fL >> this.fM & 0xFF;
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public int read(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) throws IOException {
/*  781 */             D.a(param2Int1, param2Int1 + param2Int2, param2ArrayOfbyte.length);
/*      */             
/*  783 */             int i = param2Int1;
/*  784 */             for (; i < param2Int1 + param2Int2; i++) {
/*  785 */               int j = read();
/*  786 */               if (j == -1) {
/*  787 */                 int k = i - param2Int1;
/*  788 */                 return (k == 0) ? -1 : k;
/*      */               } 
/*  790 */               param2ArrayOfbyte[i] = (byte)j;
/*      */             } 
/*  792 */             return i - param2Int1;
/*      */           }
/*      */ 
/*      */           
/*      */           public void close() throws IOException {
/*  797 */             this.b.close();
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */     
/*      */     public b a() {
/*  804 */       return (this.a == null) ? this : a((b.a)this.a, (Character)null);
/*      */     }
/*      */ 
/*      */     
/*      */     public b a(char param1Char) {
/*  809 */       if (8 % ((b.a)this.a).fH == 0 || (this.a != null && this.a
/*  810 */         .charValue() == param1Char)) {
/*  811 */         return this;
/*      */       }
/*  813 */       return a((b.a)this.a, Character.valueOf(param1Char));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public b a(String param1String, int param1Int) {
/*  819 */       for (byte b1 = 0; b1 < param1String.length(); b1++) {
/*  820 */         D.a(
/*  821 */             !this.a.matches(param1String.charAt(b1)), "Separator (%s) cannot contain alphabet characters", param1String);
/*      */       }
/*      */ 
/*      */       
/*  825 */       if (this.a != null) {
/*  826 */         D.a(
/*  827 */             (param1String.indexOf(this.a.charValue()) < 0), "Separator (%s) cannot contain padding character", param1String);
/*      */       }
/*      */ 
/*      */       
/*  831 */       return new b.e(this, param1String, param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public b b() {
/*  839 */       b b1 = this.h;
/*  840 */       if (b1 == null) {
/*  841 */         b.a a1 = this.a.a();
/*  842 */         b1 = this.h = (a1 == this.a) ? this : a(a1, this.a);
/*      */       } 
/*  844 */       return b1;
/*      */     }
/*      */ 
/*      */     
/*      */     public b c() {
/*  849 */       b b1 = this.i;
/*  850 */       if (b1 == null) {
/*  851 */         b.a a1 = this.a.b();
/*  852 */         b1 = this.i = (a1 == this.a) ? this : a(a1, this.a);
/*      */       } 
/*  854 */       return b1;
/*      */     }
/*      */     
/*      */     b a(b.a param1a, Character param1Character) {
/*  858 */       return new f(param1a, param1Character);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  863 */       StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
/*  864 */       stringBuilder.append(this.a.toString());
/*  865 */       if (8 % ((b.a)this.a).fH != 0) {
/*  866 */         if (this.a == null) {
/*  867 */           stringBuilder.append(".omitPadding()");
/*      */         } else {
/*  869 */           stringBuilder.append(".withPadChar('").append(this.a).append("')");
/*      */         } 
/*      */       }
/*  872 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  877 */       if (param1Object instanceof f) {
/*  878 */         f f1 = (f)param1Object;
/*  879 */         return (this.a.equals(f1.a) && 
/*  880 */           y.equal(this.a, f1.a));
/*      */       } 
/*  882 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  887 */       return this.a.hashCode() ^ y.a(new Object[] { this.a });
/*      */     }
/*      */   }
/*      */   
/*      */   static final class b extends f {
/*  892 */     final char[] f = new char[512];
/*      */     
/*      */     b(String param1String1, String param1String2) {
/*  895 */       this(new b.a(param1String1, param1String2.toCharArray()));
/*      */     }
/*      */     
/*      */     private b(b.a param1a) {
/*  899 */       super(param1a, null);
/*  900 */       D.checkArgument(((b.a.a(param1a)).length == 16));
/*  901 */       for (byte b1 = 0; b1 < 'Ā'; b1++) {
/*  902 */         this.f[b1] = param1a.a(b1 >>> 4);
/*  903 */         this.f[b1 | 0x100] = param1a.a(b1 & 0xF);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*  909 */       D.checkNotNull(param1Appendable);
/*  910 */       D.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
/*  911 */       for (byte b1 = 0; b1 < param1Int2; b1++) {
/*  912 */         int i = param1ArrayOfbyte[param1Int1 + b1] & 0xFF;
/*  913 */         param1Appendable.append(this.f[i]);
/*  914 */         param1Appendable.append(this.f[i | 0x100]);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws b.d {
/*  920 */       D.checkNotNull(param1ArrayOfbyte);
/*  921 */       if (param1CharSequence.length() % 2 == 1) {
/*  922 */         int i = param1CharSequence.length(); throw new b.d((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
/*      */       } 
/*  924 */       byte b1 = 0;
/*  925 */       for (byte b2 = 0; b2 < param1CharSequence.length(); b2 += 2) {
/*  926 */         int i = this.a.b(param1CharSequence.charAt(b2)) << 4 | this.a.b(param1CharSequence.charAt(b2 + 1));
/*  927 */         param1ArrayOfbyte[b1++] = (byte)i;
/*      */       } 
/*  929 */       return b1;
/*      */     }
/*      */ 
/*      */     
/*      */     b a(b.a param1a, Character param1Character) {
/*  934 */       return new b(param1a);
/*      */     }
/*      */   }
/*      */   
/*      */   static final class c extends f {
/*      */     c(String param1String1, String param1String2, Character param1Character) {
/*  940 */       this(new b.a(param1String1, param1String2.toCharArray()), param1Character);
/*      */     }
/*      */     
/*      */     private c(b.a param1a, Character param1Character) {
/*  944 */       super(param1a, param1Character);
/*  945 */       D.checkArgument(((b.a.a(param1a)).length == 64));
/*      */     }
/*      */ 
/*      */     
/*      */     void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*  950 */       D.checkNotNull(param1Appendable);
/*  951 */       D.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
/*  952 */       int i = param1Int1;
/*  953 */       for (int j = param1Int2; j >= 3; j -= 3) {
/*  954 */         int k = (param1ArrayOfbyte[i++] & 0xFF) << 16 | (param1ArrayOfbyte[i++] & 0xFF) << 8 | param1ArrayOfbyte[i++] & 0xFF;
/*  955 */         param1Appendable.append(this.a.a(k >>> 18));
/*  956 */         param1Appendable.append(this.a.a(k >>> 12 & 0x3F));
/*  957 */         param1Appendable.append(this.a.a(k >>> 6 & 0x3F));
/*  958 */         param1Appendable.append(this.a.a(k & 0x3F));
/*      */       } 
/*  960 */       if (i < param1Int1 + param1Int2) {
/*  961 */         b(param1Appendable, param1ArrayOfbyte, i, param1Int1 + param1Int2 - i);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws b.d {
/*  967 */       D.checkNotNull(param1ArrayOfbyte);
/*  968 */       param1CharSequence = a(param1CharSequence);
/*  969 */       if (!this.a.o(param1CharSequence.length())) {
/*  970 */         int i = param1CharSequence.length(); throw new b.d((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
/*      */       } 
/*  972 */       byte b1 = 0;
/*  973 */       for (byte b2 = 0; b2 < param1CharSequence.length(); ) {
/*  974 */         int i = this.a.b(param1CharSequence.charAt(b2++)) << 18;
/*  975 */         i |= this.a.b(param1CharSequence.charAt(b2++)) << 12;
/*  976 */         param1ArrayOfbyte[b1++] = (byte)(i >>> 16);
/*  977 */         if (b2 < param1CharSequence.length()) {
/*  978 */           i |= this.a.b(param1CharSequence.charAt(b2++)) << 6;
/*  979 */           param1ArrayOfbyte[b1++] = (byte)(i >>> 8 & 0xFF);
/*  980 */           if (b2 < param1CharSequence.length()) {
/*  981 */             i |= this.a.b(param1CharSequence.charAt(b2++));
/*  982 */             param1ArrayOfbyte[b1++] = (byte)(i & 0xFF);
/*      */           } 
/*      */         } 
/*      */       } 
/*  986 */       return b1;
/*      */     }
/*      */ 
/*      */     
/*      */     b a(b.a param1a, Character param1Character) {
/*  991 */       return new c(param1a, param1Character);
/*      */     }
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   static Reader a(Reader paramReader, String paramString) {
/*  997 */     D.checkNotNull(paramReader);
/*  998 */     D.checkNotNull(paramString);
/*  999 */     return new Reader(paramReader, paramString)
/*      */       {
/*      */         public int read() throws IOException {
/*      */           int i;
/*      */           do {
/* 1004 */             i = this.a.read();
/* 1005 */           } while (i != -1 && this.gS.indexOf((char)i) >= 0);
/* 1006 */           return i;
/*      */         }
/*      */ 
/*      */         
/*      */         public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/* 1011 */           throw new UnsupportedOperationException();
/*      */         }
/*      */ 
/*      */         
/*      */         public void close() throws IOException {
/* 1016 */           this.a.close();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   static Appendable a(Appendable paramAppendable, String paramString, int paramInt) {
/* 1023 */     D.checkNotNull(paramAppendable);
/* 1024 */     D.checkNotNull(paramString);
/* 1025 */     D.checkArgument((paramInt > 0));
/* 1026 */     return new Appendable(paramInt, paramAppendable, paramString) {
/* 1027 */         int fF = this.fG;
/*      */ 
/*      */         
/*      */         public Appendable append(char param1Char) throws IOException {
/* 1031 */           if (this.fF == 0) {
/* 1032 */             this.b.append(this.gA);
/* 1033 */             this.fF = this.fG;
/*      */           } 
/* 1035 */           this.b.append(param1Char);
/* 1036 */           this.fF--;
/* 1037 */           return this;
/*      */         }
/*      */ 
/*      */         
/*      */         public Appendable append(CharSequence param1CharSequence, int param1Int1, int param1Int2) throws IOException {
/* 1042 */           throw new UnsupportedOperationException();
/*      */         }
/*      */ 
/*      */         
/*      */         public Appendable append(CharSequence param1CharSequence) throws IOException {
/* 1047 */           throw new UnsupportedOperationException();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   static Writer a(Writer paramWriter, String paramString, int paramInt) {
/* 1056 */     Appendable appendable = a(paramWriter, paramString, paramInt);
/* 1057 */     return new Writer(appendable, paramWriter)
/*      */       {
/*      */         public void write(int param1Int) throws IOException {
/* 1060 */           this.c.append((char)param1Int);
/*      */         }
/*      */ 
/*      */         
/*      */         public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/* 1065 */           throw new UnsupportedOperationException();
/*      */         }
/*      */ 
/*      */         
/*      */         public void flush() throws IOException {
/* 1070 */           this.a.flush();
/*      */         }
/*      */ 
/*      */         
/*      */         public void close() throws IOException {
/* 1075 */           this.a.close();
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   static final class e extends b {
/*      */     private final b g;
/*      */     private final String separator;
/*      */     private final int fK;
/*      */     
/*      */     e(b param1b, String param1String, int param1Int) {
/* 1086 */       this.g = (b)D.checkNotNull(param1b);
/* 1087 */       this.separator = (String)D.checkNotNull(param1String);
/* 1088 */       this.fK = param1Int;
/* 1089 */       D.a((param1Int > 0), "Cannot add a separator after every %s chars", param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     CharSequence a(CharSequence param1CharSequence) {
/* 1095 */       return this.g.a(param1CharSequence);
/*      */     }
/*      */ 
/*      */     
/*      */     int J(int param1Int) {
/* 1100 */       int i = this.g.J(param1Int);
/* 1101 */       return i + this.separator
/* 1102 */         .length() * com.google.a.k.e.a(Math.max(0, i - 1), this.fK, RoundingMode.FLOOR);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     public OutputStream a(Writer param1Writer) {
/* 1108 */       return this.g.a(a(param1Writer, this.separator, this.fK));
/*      */     }
/*      */ 
/*      */     
/*      */     void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 1113 */       this.g.a(a(param1Appendable, this.separator, this.fK), param1ArrayOfbyte, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */     
/*      */     int K(int param1Int) {
/* 1118 */       return this.g.K(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean e(CharSequence param1CharSequence) {
/* 1123 */       StringBuilder stringBuilder = new StringBuilder();
/* 1124 */       for (byte b1 = 0; b1 < param1CharSequence.length(); b1++) {
/* 1125 */         char c = param1CharSequence.charAt(b1);
/* 1126 */         if (this.separator.indexOf(c) < 0) {
/* 1127 */           stringBuilder.append(c);
/*      */         }
/*      */       } 
/* 1130 */       return this.g.e(stringBuilder);
/*      */     }
/*      */ 
/*      */     
/*      */     int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws b.d {
/* 1135 */       StringBuilder stringBuilder = new StringBuilder(param1CharSequence.length());
/* 1136 */       for (byte b1 = 0; b1 < param1CharSequence.length(); b1++) {
/* 1137 */         char c = param1CharSequence.charAt(b1);
/* 1138 */         if (this.separator.indexOf(c) < 0) {
/* 1139 */           stringBuilder.append(c);
/*      */         }
/*      */       } 
/* 1142 */       return this.g.a(param1ArrayOfbyte, stringBuilder);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     public InputStream a(Reader param1Reader) {
/* 1148 */       return this.g.a(a(param1Reader, this.separator));
/*      */     }
/*      */ 
/*      */     
/*      */     public b a() {
/* 1153 */       return this.g.a().a(this.separator, this.fK);
/*      */     }
/*      */ 
/*      */     
/*      */     public b a(char param1Char) {
/* 1158 */       return this.g.a(param1Char).a(this.separator, this.fK);
/*      */     }
/*      */ 
/*      */     
/*      */     public b a(String param1String, int param1Int) {
/* 1163 */       throw new UnsupportedOperationException("Already have a separator");
/*      */     }
/*      */ 
/*      */     
/*      */     public b b() {
/* 1168 */       return this.g.b().a(this.separator, this.fK);
/*      */     }
/*      */ 
/*      */     
/*      */     public b c() {
/* 1173 */       return this.g.c().a(this.separator, this.fK);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1178 */       String str1 = String.valueOf(this.g), str2 = this.separator; int i = this.fK; return (new StringBuilder(31 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".withSeparator(\"").append(str2).append("\", ").append(i).append(")").toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */