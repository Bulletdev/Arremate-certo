/*      */ package com.google.a.b;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import java.util.Arrays;
/*      */ import java.util.BitSet;
/*      */ import java.util.function.Predicate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public abstract class e
/*      */   implements E<Character>
/*      */ {
/*      */   private static final int ds = 65536;
/*      */   
/*      */   public static e a() {
/*  118 */     return b.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e b() {
/*  127 */     return x.a;
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
/*      */   public static e c() {
/*  145 */     return B.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e d() {
/*  156 */     return f.d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e e() {
/*  165 */     return d.a;
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
/*      */   @Deprecated
/*      */   public static e f() {
/*  178 */     return g.a;
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
/*      */   @Deprecated
/*      */   public static e g() {
/*  191 */     return o.a;
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
/*      */   @Deprecated
/*      */   public static e h() {
/*  204 */     return q.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static e i() {
/*  216 */     return r.a;
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
/*      */   @Deprecated
/*      */   public static e j() {
/*  229 */     return t.a;
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
/*      */   @Deprecated
/*      */   public static e k() {
/*  242 */     return s.a;
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
/*      */   public static e l() {
/*  254 */     return p.a;
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
/*      */   @Deprecated
/*      */   public static e m() {
/*  270 */     return k.a;
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
/*      */   @Deprecated
/*      */   public static e n() {
/*  288 */     return A.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e a(char paramChar) {
/*  295 */     return new l(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e b(char paramChar) {
/*  304 */     return new n(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e a(CharSequence paramCharSequence) {
/*  312 */     switch (paramCharSequence.length()) {
/*      */       case 0:
/*  314 */         return b();
/*      */       case 1:
/*  316 */         return a(paramCharSequence.charAt(0));
/*      */       case 2:
/*  318 */         return a(paramCharSequence.charAt(0), paramCharSequence.charAt(1));
/*      */     } 
/*      */ 
/*      */     
/*  322 */     return new c(paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e b(CharSequence paramCharSequence) {
/*  331 */     return a(paramCharSequence).o();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e a(char paramChar1, char paramChar2) {
/*  342 */     return new j(paramChar1, paramChar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e a(E<? super Character> paramE) {
/*  350 */     return (paramE instanceof e) ? (e)paramE : new i(paramE);
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
/*      */   public e o() {
/*  372 */     return new v(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public e a(e parame) {
/*  379 */     return new a(this, parame);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public e b(e parame) {
/*  386 */     return new y(this, parame);
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
/*      */   public e p() {
/*  399 */     return C.c(this);
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
/*      */   @com.google.a.a.c
/*      */   e q() {
/*  416 */     BitSet bitSet = new BitSet();
/*  417 */     a(bitSet);
/*  418 */     int i = bitSet.cardinality();
/*  419 */     if (i * 2 <= 65536) {
/*  420 */       return a(i, bitSet, toString());
/*      */     }
/*      */     
/*  423 */     bitSet.flip(0, 65536);
/*  424 */     int j = 65536 - i;
/*  425 */     String str1 = ".negate()";
/*  426 */     String str2 = toString();
/*      */ 
/*      */ 
/*      */     
/*  430 */     String.valueOf(str1); String str3 = str2.endsWith(str1) ? str2.substring(0, str2.length() - str1.length()) : ((String.valueOf(str1).length() != 0) ? String.valueOf(str2).concat(String.valueOf(str1)) : new String(String.valueOf(str2)));
/*  431 */     return new w(this, 
/*  432 */         a(j, bitSet, str3), str2)
/*      */       {
/*      */         public String toString() {
/*  435 */           return this.gs;
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static e a(int paramInt, BitSet paramBitSet, String paramString) {
/*      */     char c1;
/*      */     char c2;
/*  447 */     switch (paramInt) {
/*      */       case 0:
/*  449 */         return b();
/*      */       case 1:
/*  451 */         return a((char)paramBitSet.nextSetBit(0));
/*      */       case 2:
/*  453 */         c1 = (char)paramBitSet.nextSetBit(0);
/*  454 */         c2 = (char)paramBitSet.nextSetBit(c1 + 1);
/*  455 */         return a(c1, c2);
/*      */     } 
/*  457 */     return b(paramInt, paramBitSet.length()) ? 
/*  458 */       H.a(paramBitSet, paramString) : 
/*  459 */       new e(paramBitSet, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static boolean b(int paramInt1, int paramInt2) {
/*  465 */     return (paramInt1 <= 1023 && paramInt2 > paramInt1 * 4 * 16);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   void a(BitSet paramBitSet) {
/*  473 */     for (char c = '￿'; c >= '\000'; c--) {
/*  474 */       if (matches((char)c)) {
/*  475 */         paramBitSet.set(c);
/*      */       }
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
/*      */   public boolean a(CharSequence paramCharSequence) {
/*  494 */     return !c(paramCharSequence);
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
/*      */   public boolean b(CharSequence paramCharSequence) {
/*  508 */     for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
/*  509 */       if (!matches(paramCharSequence.charAt(i))) {
/*  510 */         return false;
/*      */       }
/*      */     } 
/*  513 */     return true;
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
/*      */   public boolean c(CharSequence paramCharSequence) {
/*  528 */     return (a(paramCharSequence) == -1);
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
/*      */   public int a(CharSequence paramCharSequence) {
/*  542 */     return a(paramCharSequence, 0);
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
/*      */   public int a(CharSequence paramCharSequence, int paramInt) {
/*  561 */     int i = paramCharSequence.length();
/*  562 */     D.c(paramInt, i);
/*  563 */     for (int j = paramInt; j < i; j++) {
/*  564 */       if (matches(paramCharSequence.charAt(j))) {
/*  565 */         return j;
/*      */       }
/*      */     } 
/*  568 */     return -1;
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
/*      */   public int b(CharSequence paramCharSequence) {
/*  582 */     for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
/*  583 */       if (matches(paramCharSequence.charAt(i))) {
/*  584 */         return i;
/*      */       }
/*      */     } 
/*  587 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int c(CharSequence paramCharSequence) {
/*  596 */     byte b1 = 0;
/*  597 */     for (byte b2 = 0; b2 < paramCharSequence.length(); b2++) {
/*  598 */       if (matches(paramCharSequence.charAt(b2))) {
/*  599 */         b1++;
/*      */       }
/*      */     } 
/*  602 */     return b1;
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
/*      */   public String c(CharSequence paramCharSequence) {
/*  616 */     String str = paramCharSequence.toString();
/*  617 */     int i = a(str);
/*  618 */     if (i == -1) {
/*  619 */       return str;
/*      */     }
/*      */     
/*  622 */     char[] arrayOfChar = str.toCharArray();
/*  623 */     byte b = 1;
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*  628 */       i++;
/*      */       
/*  630 */       while (i != arrayOfChar.length) {
/*      */ 
/*      */         
/*  633 */         if (matches(arrayOfChar[i]))
/*      */         
/*      */         { 
/*      */ 
/*      */ 
/*      */           
/*  639 */           b++; continue; }  arrayOfChar[i - b] = arrayOfChar[i]; i++;
/*      */       }  break;
/*  641 */     }  return new String(arrayOfChar, 0, i - b);
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
/*      */   public String d(CharSequence paramCharSequence) {
/*  655 */     return o().c(paramCharSequence);
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
/*      */   public String a(CharSequence paramCharSequence, char paramChar) {
/*  678 */     String str = paramCharSequence.toString();
/*  679 */     int i = a(str);
/*  680 */     if (i == -1) {
/*  681 */       return str;
/*      */     }
/*  683 */     char[] arrayOfChar = str.toCharArray();
/*  684 */     arrayOfChar[i] = paramChar;
/*  685 */     for (int j = i + 1; j < arrayOfChar.length; j++) {
/*  686 */       if (matches(arrayOfChar[j])) {
/*  687 */         arrayOfChar[j] = paramChar;
/*      */       }
/*      */     } 
/*  690 */     return new String(arrayOfChar);
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
/*      */   public String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  712 */     int i = paramCharSequence2.length();
/*  713 */     if (i == 0) {
/*  714 */       return c(paramCharSequence1);
/*      */     }
/*  716 */     if (i == 1) {
/*  717 */       return a(paramCharSequence1, paramCharSequence2.charAt(0));
/*      */     }
/*      */     
/*  720 */     String str = paramCharSequence1.toString();
/*  721 */     int j = a(str);
/*  722 */     if (j == -1) {
/*  723 */       return str;
/*      */     }
/*      */     
/*  726 */     int k = str.length();
/*  727 */     StringBuilder stringBuilder = new StringBuilder(k * 3 / 2 + 16);
/*      */     
/*  729 */     int m = 0;
/*      */     do {
/*  731 */       stringBuilder.append(str, m, j);
/*  732 */       stringBuilder.append(paramCharSequence2);
/*  733 */       m = j + 1;
/*  734 */       j = a(str, m);
/*  735 */     } while (j != -1);
/*      */     
/*  737 */     stringBuilder.append(str, m, k);
/*  738 */     return stringBuilder.toString();
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
/*      */   public String e(CharSequence paramCharSequence) {
/*  760 */     int i = paramCharSequence.length();
/*      */     
/*      */     byte b;
/*      */     
/*  764 */     for (b = 0; b < i && 
/*  765 */       matches(paramCharSequence.charAt(b)); b++);
/*      */     
/*      */     int j;
/*      */     
/*  769 */     for (j = i - 1; j > b && 
/*  770 */       matches(paramCharSequence.charAt(j)); j--);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  775 */     return paramCharSequence.subSequence(b, j + 1).toString();
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
/*      */   public String f(CharSequence paramCharSequence) {
/*  789 */     int i = paramCharSequence.length();
/*  790 */     for (byte b = 0; b < i; b++) {
/*  791 */       if (!matches(paramCharSequence.charAt(b))) {
/*  792 */         return paramCharSequence.subSequence(b, i).toString();
/*      */       }
/*      */     } 
/*  795 */     return "";
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
/*      */   public String g(CharSequence paramCharSequence) {
/*  809 */     int i = paramCharSequence.length();
/*  810 */     for (int j = i - 1; j >= 0; j--) {
/*  811 */       if (!matches(paramCharSequence.charAt(j))) {
/*  812 */         return paramCharSequence.subSequence(0, j + 1).toString();
/*      */       }
/*      */     } 
/*  815 */     return "";
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
/*      */   public String b(CharSequence paramCharSequence, char paramChar) {
/*  839 */     int i = paramCharSequence.length();
/*  840 */     for (byte b = 0; b < i; b++) {
/*  841 */       char c = paramCharSequence.charAt(b);
/*  842 */       if (matches(c)) {
/*  843 */         if (c == paramChar && (b == i - 1 || !matches(paramCharSequence.charAt(b + 1)))) {
/*      */           
/*  845 */           b++;
/*      */         } else {
/*  847 */           StringBuilder stringBuilder = (new StringBuilder(i)).append(paramCharSequence, 0, b).append(paramChar);
/*  848 */           return a(paramCharSequence, b + 1, i, paramChar, stringBuilder, true);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  853 */     return paramCharSequence.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String c(CharSequence paramCharSequence, char paramChar) {
/*  863 */     int i = paramCharSequence.length();
/*  864 */     byte b = 0;
/*  865 */     int j = i - 1;
/*      */     
/*  867 */     while (b < i && matches(paramCharSequence.charAt(b))) {
/*  868 */       b++;
/*      */     }
/*      */     
/*  871 */     while (j > b && matches(paramCharSequence.charAt(j))) {
/*  872 */       j--;
/*      */     }
/*      */     
/*  875 */     return (b == 0 && j == i - 1) ? 
/*  876 */       b(paramCharSequence, paramChar) : 
/*  877 */       a(paramCharSequence, b, j + 1, paramChar, new StringBuilder(j + 1 - b), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String a(CharSequence paramCharSequence, int paramInt1, int paramInt2, char paramChar, StringBuilder paramStringBuilder, boolean paramBoolean) {
/*  888 */     for (int i = paramInt1; i < paramInt2; i++) {
/*  889 */       char c = paramCharSequence.charAt(i);
/*  890 */       if (matches(c)) {
/*  891 */         if (!paramBoolean) {
/*  892 */           paramStringBuilder.append(paramChar);
/*  893 */           paramBoolean = true;
/*      */         } 
/*      */       } else {
/*  896 */         paramStringBuilder.append(c);
/*  897 */         paramBoolean = false;
/*      */       } 
/*      */     } 
/*  900 */     return paramStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean a(Character paramCharacter) {
/*  910 */     return matches(paramCharacter.charValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  919 */     return super.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String a(char paramChar) {
/*  927 */     String str = "0123456789ABCDEF";
/*  928 */     char[] arrayOfChar = { '\\', 'u', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };
/*  929 */     for (byte b = 0; b < 4; b++) {
/*  930 */       arrayOfChar[5 - b] = str.charAt(paramChar & 0xF);
/*  931 */       paramChar = (char)(paramChar >> 4);
/*      */     } 
/*  933 */     return String.copyValueOf(arrayOfChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static abstract class h
/*      */     extends e
/*      */   {
/*      */     public final e p() {
/*  943 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public e o() {
/*  948 */       return new e.w(this);
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract class u
/*      */     extends h
/*      */   {
/*      */     private final String description;
/*      */     
/*      */     u(String param1String) {
/*  958 */       this.description = D.<String>checkNotNull(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/*  963 */       return this.description;
/*      */     }
/*      */   }
/*      */   
/*      */   static class w
/*      */     extends v
/*      */   {
/*      */     w(e param1e) {
/*  971 */       super(param1e);
/*      */     }
/*      */ 
/*      */     
/*      */     public final e p() {
/*  976 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static final class e
/*      */     extends u
/*      */   {
/*      */     private final BitSet a;
/*      */     
/*      */     private e(BitSet param1BitSet, String param1String) {
/*  987 */       super(param1String);
/*  988 */       if (param1BitSet.length() + 64 < param1BitSet.size()) {
/*  989 */         param1BitSet = (BitSet)param1BitSet.clone();
/*      */       }
/*      */       
/*  992 */       this.a = param1BitSet;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/*  997 */       return this.a.get(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     void a(BitSet param1BitSet) {
/* 1002 */       param1BitSet.or(this.a);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class b
/*      */     extends u
/*      */   {
/* 1011 */     static final b a = new b();
/*      */     
/*      */     private b() {
/* 1014 */       super("CharMatcher.any()");
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1019 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public int a(CharSequence param1CharSequence) {
/* 1024 */       return (param1CharSequence.length() == 0) ? -1 : 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public int a(CharSequence param1CharSequence, int param1Int) {
/* 1029 */       int i = param1CharSequence.length();
/* 1030 */       D.c(param1Int, i);
/* 1031 */       return (param1Int == i) ? -1 : param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public int b(CharSequence param1CharSequence) {
/* 1036 */       return param1CharSequence.length() - 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean b(CharSequence param1CharSequence) {
/* 1041 */       D.checkNotNull(param1CharSequence);
/* 1042 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean c(CharSequence param1CharSequence) {
/* 1047 */       return (param1CharSequence.length() == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public String c(CharSequence param1CharSequence) {
/* 1052 */       D.checkNotNull(param1CharSequence);
/* 1053 */       return "";
/*      */     }
/*      */ 
/*      */     
/*      */     public String a(CharSequence param1CharSequence, char param1Char) {
/* 1058 */       char[] arrayOfChar = new char[param1CharSequence.length()];
/* 1059 */       Arrays.fill(arrayOfChar, param1Char);
/* 1060 */       return new String(arrayOfChar);
/*      */     }
/*      */ 
/*      */     
/*      */     public String a(CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
/* 1065 */       StringBuilder stringBuilder = new StringBuilder(param1CharSequence1.length() * param1CharSequence2.length());
/* 1066 */       for (byte b1 = 0; b1 < param1CharSequence1.length(); b1++) {
/* 1067 */         stringBuilder.append(param1CharSequence2);
/*      */       }
/* 1069 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String b(CharSequence param1CharSequence, char param1Char) {
/* 1074 */       return (param1CharSequence.length() == 0) ? "" : String.valueOf(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public String e(CharSequence param1CharSequence) {
/* 1079 */       D.checkNotNull(param1CharSequence);
/* 1080 */       return "";
/*      */     }
/*      */ 
/*      */     
/*      */     public int c(CharSequence param1CharSequence) {
/* 1085 */       return param1CharSequence.length();
/*      */     }
/*      */ 
/*      */     
/*      */     public e a(e param1e) {
/* 1090 */       return D.<e>checkNotNull(param1e);
/*      */     }
/*      */ 
/*      */     
/*      */     public e b(e param1e) {
/* 1095 */       D.checkNotNull(param1e);
/* 1096 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public e o() {
/* 1101 */       return b();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class x
/*      */     extends u
/*      */   {
/* 1108 */     static final x a = new x();
/*      */     
/*      */     private x() {
/* 1111 */       super("CharMatcher.none()");
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1116 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public int a(CharSequence param1CharSequence) {
/* 1121 */       D.checkNotNull(param1CharSequence);
/* 1122 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     public int a(CharSequence param1CharSequence, int param1Int) {
/* 1127 */       int i = param1CharSequence.length();
/* 1128 */       D.c(param1Int, i);
/* 1129 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     public int b(CharSequence param1CharSequence) {
/* 1134 */       D.checkNotNull(param1CharSequence);
/* 1135 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean b(CharSequence param1CharSequence) {
/* 1140 */       return (param1CharSequence.length() == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean c(CharSequence param1CharSequence) {
/* 1145 */       D.checkNotNull(param1CharSequence);
/* 1146 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public String c(CharSequence param1CharSequence) {
/* 1151 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String a(CharSequence param1CharSequence, char param1Char) {
/* 1156 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String a(CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
/* 1161 */       D.checkNotNull(param1CharSequence2);
/* 1162 */       return param1CharSequence1.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String b(CharSequence param1CharSequence, char param1Char) {
/* 1167 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String e(CharSequence param1CharSequence) {
/* 1172 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String f(CharSequence param1CharSequence) {
/* 1177 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public String g(CharSequence param1CharSequence) {
/* 1182 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public int c(CharSequence param1CharSequence) {
/* 1187 */       D.checkNotNull(param1CharSequence);
/* 1188 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public e a(e param1e) {
/* 1193 */       D.checkNotNull(param1e);
/* 1194 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public e b(e param1e) {
/* 1199 */       return D.<e>checkNotNull(param1e);
/*      */     }
/*      */ 
/*      */     
/*      */     public e o() {
/* 1204 */       return a();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.d
/*      */   static final class B
/*      */     extends u
/*      */   {
/*      */     static final String TABLE = " 　\r   　 \013　   　 \t     \f 　 　　 \n 　";
/*      */ 
/*      */ 
/*      */     
/*      */     static final int dt = 1682554634;
/*      */ 
/*      */     
/* 1222 */     static final int du = Integer.numberOfLeadingZeros(" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".length() - 1);
/*      */     
/* 1224 */     static final B a = new B();
/*      */     
/*      */     B() {
/* 1227 */       super("CharMatcher.whitespace()");
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1232 */       return (" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(1682554634 * param1Char >>> du) == param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1238 */       for (byte b = 0; b < " 　\r   　 \013　   　 \t     \f 　 　　 \n 　".length(); b++) {
/* 1239 */         param1BitSet.set(" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(b));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class f
/*      */     extends e
/*      */   {
/* 1247 */     static final e d = new f();
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1251 */       switch (param1Char) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\013':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */         case '':
/*      */         case ' ':
/*      */         case ' ':
/*      */         case ' ':
/*      */         case ' ':
/*      */         case '　':
/* 1264 */           return true;
/*      */         case ' ':
/* 1266 */           return false;
/*      */       } 
/* 1268 */       return (param1Char >= ' ' && param1Char <= ' ');
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1274 */       return "CharMatcher.breakingWhitespace()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class d
/*      */     extends u
/*      */   {
/* 1281 */     static final d a = new d();
/*      */     
/*      */     d() {
/* 1284 */       super("CharMatcher.ascii()");
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1289 */       return (param1Char <= '');
/*      */     }
/*      */   }
/*      */   
/*      */   private static class z
/*      */     extends e
/*      */   {
/*      */     private final String description;
/*      */     private final char[] b;
/*      */     private final char[] c;
/*      */     
/*      */     z(String param1String, char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
/* 1301 */       this.description = param1String;
/* 1302 */       this.b = param1ArrayOfchar1;
/* 1303 */       this.c = param1ArrayOfchar2;
/* 1304 */       D.checkArgument((param1ArrayOfchar1.length == param1ArrayOfchar2.length));
/* 1305 */       for (byte b = 0; b < param1ArrayOfchar1.length; b++) {
/* 1306 */         D.checkArgument((param1ArrayOfchar1[b] <= param1ArrayOfchar2[b]));
/* 1307 */         if (b + 1 < param1ArrayOfchar1.length) {
/* 1308 */           D.checkArgument((param1ArrayOfchar2[b] < param1ArrayOfchar1[b + 1]));
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1315 */       int i = Arrays.binarySearch(this.b, param1Char);
/* 1316 */       if (i >= 0) {
/* 1317 */         return true;
/*      */       }
/* 1319 */       i = (i ^ 0xFFFFFFFF) - 1;
/* 1320 */       return (i >= 0 && param1Char <= this.c[i]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1326 */       return this.description;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class g
/*      */     extends z
/*      */   {
/*      */     private static final String gt = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static char[] a() {
/* 1344 */       return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
/*      */     }
/*      */     
/*      */     private static char[] b() {
/* 1348 */       char[] arrayOfChar = new char["0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".length()];
/* 1349 */       for (byte b = 0; b < "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".length(); b++) {
/* 1350 */         arrayOfChar[b] = (char)("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(b) + 9);
/*      */       }
/* 1352 */       return arrayOfChar;
/*      */     }
/*      */     
/* 1355 */     static final g a = new g();
/*      */     
/*      */     private g() {
/* 1358 */       super("CharMatcher.digit()", a(), b());
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class o
/*      */     extends e
/*      */   {
/* 1365 */     static final o a = new o();
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1369 */       return Character.isDigit(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1374 */       return "CharMatcher.javaDigit()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class q
/*      */     extends e
/*      */   {
/* 1381 */     static final q a = new q();
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1385 */       return Character.isLetter(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1390 */       return "CharMatcher.javaLetter()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class r
/*      */     extends e
/*      */   {
/* 1397 */     static final r a = new r();
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1401 */       return Character.isLetterOrDigit(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1406 */       return "CharMatcher.javaLetterOrDigit()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class t
/*      */     extends e
/*      */   {
/* 1413 */     static final t a = new t();
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1417 */       return Character.isUpperCase(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1422 */       return "CharMatcher.javaUpperCase()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class s
/*      */     extends e
/*      */   {
/* 1429 */     static final s a = new s();
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1433 */       return Character.isLowerCase(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1438 */       return "CharMatcher.javaLowerCase()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class p
/*      */     extends u
/*      */   {
/* 1445 */     static final p a = new p();
/*      */     
/*      */     private p() {
/* 1448 */       super("CharMatcher.javaIsoControl()");
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1453 */       return (param1Char <= '\037' || (param1Char >= '' && param1Char <= ''));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class k
/*      */     extends z
/*      */   {
/*      */     private static final String gu = "\000­؀؜۝܏࣢ ᠎   ⁦　?﻿￹";
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String gv = "  ­؅؜۝܏࣢ ᠎‏ ⁤⁯　﻿￻";
/*      */ 
/*      */     
/* 1470 */     static final k a = new k();
/*      */     
/*      */     private k() {
/* 1473 */       super("CharMatcher.invisible()", "\000­؀؜۝܏࣢ ᠎   ⁦　?﻿￹".toCharArray(), "  ­؅؜۝܏࣢ ᠎‏ ⁤⁯　﻿￻".toCharArray());
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class A
/*      */     extends z
/*      */   {
/* 1480 */     static final A a = new A();
/*      */     
/*      */     private A() {
/* 1483 */       super("CharMatcher.singleWidth()", "\000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡"
/*      */           
/* 1485 */           .toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ"
/* 1486 */           .toCharArray());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class v
/*      */     extends e
/*      */   {
/*      */     final e e;
/*      */ 
/*      */     
/*      */     v(e param1e) {
/* 1498 */       this.e = D.<e>checkNotNull(param1e);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1503 */       return !this.e.matches(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean b(CharSequence param1CharSequence) {
/* 1508 */       return this.e.c(param1CharSequence);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean c(CharSequence param1CharSequence) {
/* 1513 */       return this.e.b(param1CharSequence);
/*      */     }
/*      */ 
/*      */     
/*      */     public int c(CharSequence param1CharSequence) {
/* 1518 */       return param1CharSequence.length() - this.e.c(param1CharSequence);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1524 */       BitSet bitSet = new BitSet();
/* 1525 */       this.e.a(bitSet);
/* 1526 */       bitSet.flip(0, 65536);
/* 1527 */       param1BitSet.or(bitSet);
/*      */     }
/*      */ 
/*      */     
/*      */     public e o() {
/* 1532 */       return this.e;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1537 */       String str = String.valueOf(this.e); return (new StringBuilder(9 + String.valueOf(str).length())).append(str).append(".negate()").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class a
/*      */     extends e
/*      */   {
/*      */     final e b;
/*      */     final e c;
/*      */     
/*      */     a(e param1e1, e param1e2) {
/* 1548 */       this.b = D.<e>checkNotNull(param1e1);
/* 1549 */       this.c = D.<e>checkNotNull(param1e2);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1554 */       return (this.b.matches(param1Char) && this.c.matches(param1Char));
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1560 */       BitSet bitSet1 = new BitSet();
/* 1561 */       this.b.a(bitSet1);
/* 1562 */       BitSet bitSet2 = new BitSet();
/* 1563 */       this.c.a(bitSet2);
/* 1564 */       bitSet1.and(bitSet2);
/* 1565 */       param1BitSet.or(bitSet1);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1570 */       String str1 = String.valueOf(this.b), str2 = String.valueOf(this.c); return (new StringBuilder(19 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.and(").append(str1).append(", ").append(str2).append(")").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class y
/*      */     extends e
/*      */   {
/*      */     final e b;
/*      */     final e c;
/*      */     
/*      */     y(e param1e1, e param1e2) {
/* 1581 */       this.b = D.<e>checkNotNull(param1e1);
/* 1582 */       this.c = D.<e>checkNotNull(param1e2);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1588 */       this.b.a(param1BitSet);
/* 1589 */       this.c.a(param1BitSet);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1594 */       return (this.b.matches(param1Char) || this.c.matches(param1Char));
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1599 */       String str1 = String.valueOf(this.b), str2 = String.valueOf(this.c); return (new StringBuilder(18 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.or(").append(str1).append(", ").append(str2).append(")").toString();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class l
/*      */     extends h
/*      */   {
/*      */     private final char g;
/*      */ 
/*      */     
/*      */     l(char param1Char) {
/* 1611 */       this.g = param1Char;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1616 */       return (param1Char == this.g);
/*      */     }
/*      */ 
/*      */     
/*      */     public String a(CharSequence param1CharSequence, char param1Char) {
/* 1621 */       return param1CharSequence.toString().replace(this.g, param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public e a(e param1e) {
/* 1626 */       return param1e.matches(this.g) ? this : b();
/*      */     }
/*      */ 
/*      */     
/*      */     public e b(e param1e) {
/* 1631 */       return param1e.matches(this.g) ? param1e : super.b(param1e);
/*      */     }
/*      */ 
/*      */     
/*      */     public e o() {
/* 1636 */       return b(this.g);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1642 */       param1BitSet.set(this.g);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1647 */       String str = e.b(this.g); return (new StringBuilder(18 + String.valueOf(str).length())).append("CharMatcher.is('").append(str).append("')").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class n
/*      */     extends h
/*      */   {
/*      */     private final char g;
/*      */     
/*      */     n(char param1Char) {
/* 1657 */       this.g = param1Char;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1662 */       return (param1Char != this.g);
/*      */     }
/*      */ 
/*      */     
/*      */     public e a(e param1e) {
/* 1667 */       return param1e.matches(this.g) ? super.a(param1e) : param1e;
/*      */     }
/*      */ 
/*      */     
/*      */     public e b(e param1e) {
/* 1672 */       return param1e.matches(this.g) ? a() : this;
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1678 */       param1BitSet.set(0, this.g);
/* 1679 */       param1BitSet.set(this.g + 1, 65536);
/*      */     }
/*      */ 
/*      */     
/*      */     public e o() {
/* 1684 */       return a(this.g);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1689 */       String str = e.b(this.g); return (new StringBuilder(21 + String.valueOf(str).length())).append("CharMatcher.isNot('").append(str).append("')").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static m a(char paramChar1, char paramChar2) {
/* 1694 */     return new m(paramChar1, paramChar2);
/*      */   }
/*      */   
/*      */   public abstract boolean matches(char paramChar);
/*      */   
/*      */   private static final class m extends h {
/*      */     private final char h;
/*      */     private final char i;
/*      */     
/*      */     m(char param1Char1, char param1Char2) {
/* 1704 */       this.h = param1Char1;
/* 1705 */       this.i = param1Char2;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1710 */       return (param1Char == this.h || param1Char == this.i);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1716 */       param1BitSet.set(this.h);
/* 1717 */       param1BitSet.set(this.i);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1722 */       String str1 = e.b(this.h), str2 = e.b(this.i); return (new StringBuilder(21 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.anyOf(\"").append(str1).append(str2).append("\")").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class c
/*      */     extends e
/*      */   {
/*      */     private final char[] chars;
/*      */     
/*      */     public c(CharSequence param1CharSequence) {
/* 1732 */       this.chars = param1CharSequence.toString().toCharArray();
/* 1733 */       Arrays.sort(this.chars);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1738 */       return (Arrays.binarySearch(this.chars, param1Char) >= 0);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1744 */       for (char c1 : this.chars) {
/* 1745 */         param1BitSet.set(c1);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1751 */       StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
/* 1752 */       for (char c1 : this.chars) {
/* 1753 */         stringBuilder.append(e.b(c1));
/*      */       }
/* 1755 */       stringBuilder.append("\")");
/* 1756 */       return stringBuilder.toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class j
/*      */     extends h
/*      */   {
/*      */     private final char e;
/*      */     private final char f;
/*      */     
/*      */     j(char param1Char1, char param1Char2) {
/* 1767 */       D.checkArgument((param1Char2 >= param1Char1));
/* 1768 */       this.e = param1Char1;
/* 1769 */       this.f = param1Char2;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1774 */       return (this.e <= param1Char && param1Char <= this.f);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     void a(BitSet param1BitSet) {
/* 1780 */       param1BitSet.set(this.e, this.f + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1786 */       String str1 = e.b(this.e);
/*      */       
/* 1788 */       String str2 = e.b(this.f); return (new StringBuilder(27 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.inRange('").append(str1).append("', '").append(str2).append("')").toString();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class i
/*      */     extends e
/*      */   {
/*      */     private final E<? super Character> a;
/*      */     
/*      */     i(E<? super Character> param1E) {
/* 1799 */       this.a = D.<E<? super Character>>checkNotNull(param1E);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1804 */       return this.a.b(Character.valueOf(param1Char));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean a(Character param1Character) {
/* 1810 */       return this.a.b(D.checkNotNull(param1Character));
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1815 */       String str = String.valueOf(this.a); return (new StringBuilder(26 + String.valueOf(str).length())).append("CharMatcher.forPredicate(").append(str).append(")").toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */