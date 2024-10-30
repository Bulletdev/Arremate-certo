/*     */ package org.a.a.c;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.IllegalFormatConversionException;
/*     */ import java.util.IllegalFormatException;
/*     */ import java.util.MissingFormatArgumentException;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.a.a.c.a.a;
/*     */ import org.a.a.c.a.f;
/*     */ 
/*     */ public class a {
/*     */   private static final String jI = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
/*     */   
/*     */   private static class a {
/*     */     private final int index;
/*     */     private final a a;
/*     */     
/*     */     public a(char param1Char, int param1Int) {
/*  21 */       this.index = param1Int;
/*  22 */       this.a = a.a(param1Char);
/*     */     }
/*     */     
/*     */     int bh() {
/*  26 */       return this.index;
/*     */     }
/*     */     
/*     */     a a() {
/*  30 */       return this.a;
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
/*     */   @f
/*     */   public static String a(String paramString, a... paramVarArgs) throws IllegalFormatException {
/*  43 */     a[] arrayOfA = a(paramString);
/*  44 */     if (arrayOfA.length != paramVarArgs.length) {
/*  45 */       throw new b(paramVarArgs.length, arrayOfA.length);
/*     */     }
/*     */     
/*  48 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  49 */       if (paramVarArgs[b] != arrayOfA[b]) {
/*  50 */         throw new c(paramVarArgs[b], arrayOfA[b]);
/*     */       }
/*     */     } 
/*     */     
/*  54 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void bh(String paramString) throws IllegalFormatException {
/*  60 */     String str = String.format(paramString, (Object[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a[] a(String paramString) throws IllegalFormatException {
/*  70 */     bh(paramString);
/*     */     
/*  72 */     int i = -1;
/*  73 */     byte b = -1;
/*  74 */     int j = -1;
/*     */     
/*  76 */     a[] arrayOfA = a(paramString);
/*  77 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  79 */     for (a a1 : arrayOfA) {
/*  80 */       int k = a1.bh();
/*  81 */       switch (k) {
/*     */         case -1:
/*     */           break;
/*     */         
/*     */         case 0:
/*  86 */           i = ++b;
/*     */           break;
/*     */         default:
/*  89 */           i = k - 1;
/*     */           break;
/*     */       } 
/*  92 */       j = Math.max(j, i);
/*  93 */       hashMap.put(
/*  94 */           Integer.valueOf(i), 
/*  95 */           a.a(
/*  96 */             hashMap.containsKey(Integer.valueOf(i)) ? (a)hashMap.get(Integer.valueOf(i)) : a.l, a1
/*  97 */             .a()));
/*     */     } 
/*     */     
/* 100 */     a[] arrayOfA1 = new a[j + 1];
/* 101 */     for (byte b1 = 0; b1 <= j; b1++) {
/* 102 */       arrayOfA1[b1] = hashMap.containsKey(Integer.valueOf(b1)) ? (a)hashMap.get(Integer.valueOf(b1)) : a.l;
/*     */     }
/* 104 */     return arrayOfA1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   private static Pattern c = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");
/*     */   
/*     */   private static int a(Matcher paramMatcher) {
/*     */     boolean bool;
/* 115 */     String str = paramMatcher.group(1);
/* 116 */     if (str != null) {
/* 117 */       bool = Integer.parseInt(str.substring(0, str.length() - 1));
/*     */     }
/* 119 */     else if (paramMatcher.group(2) != null && paramMatcher.group(2).contains(String.valueOf('<'))) {
/* 120 */       bool = true;
/*     */     } else {
/* 122 */       bool = false;
/*     */     } 
/*     */     
/* 125 */     return bool;
/*     */   }
/*     */   
/*     */   private static char a(Matcher paramMatcher) {
/* 129 */     String str = paramMatcher.group(5);
/* 130 */     if (str == null) {
/* 131 */       return paramMatcher.group(6).charAt(0);
/*     */     }
/* 133 */     return str.charAt(0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static a[] a(String paramString) {
/* 138 */     ArrayList<a> arrayList = new ArrayList();
/* 139 */     Matcher matcher = c.matcher(paramString);
/* 140 */     while (matcher.find()) {
/* 141 */       char c = a(matcher);
/* 142 */       switch (c) {
/*     */         case '%':
/*     */         case 'n':
/*     */           continue;
/*     */       } 
/* 147 */       arrayList.add(new a(c, a(matcher)));
/*     */     } 
/*     */     
/* 150 */     return arrayList.<a>toArray(new a[arrayList.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class b
/*     */     extends MissingFormatArgumentException
/*     */   {
/*     */     private static final long serialVersionUID = 17000126L;
/*     */     
/*     */     private final int hZ;
/*     */     
/*     */     private final int ia;
/*     */ 
/*     */     
/*     */     public b(int param1Int1, int param1Int2) {
/* 165 */       super("-");
/* 166 */       this.hZ = param1Int1;
/* 167 */       this.ia = param1Int2;
/*     */     }
/*     */     
/*     */     public int bi() {
/* 171 */       return this.hZ;
/*     */     }
/*     */     
/*     */     public int bj() {
/* 175 */       return this.ia;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getMessage() {
/* 180 */       return String.format("Expected %d arguments but found %d.", new Object[] { Integer.valueOf(this.hZ), Integer.valueOf(this.ia) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class c
/*     */     extends IllegalFormatConversionException
/*     */   {
/*     */     private static final long serialVersionUID = 17000126L;
/*     */     
/*     */     private final a b;
/*     */     
/*     */     private final a c;
/*     */ 
/*     */     
/*     */     public c(a param1a1, a param1a2) {
/* 196 */       super(
/* 197 */           (param1a1.jJ.length() == 0) ? 45 : param1a1.jJ.charAt(0), 
/* 198 */           (param1a2.c == null) ? Object.class : param1a2.c[0]);
/* 199 */       this.b = param1a1;
/* 200 */       this.c = param1a2;
/*     */     }
/*     */     
/*     */     public a b() {
/* 204 */       return this.b;
/*     */     }
/*     */     
/*     */     public a c() {
/* 208 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getMessage() {
/* 213 */       return String.format("Expected category %s but found %s.", new Object[] { this.b, this.c });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */