/*     */ package org.a.a.n;
/*     */ 
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.regex.PatternSyntaxException;
/*     */ import org.a.a.n.a.c;
/*     */ import org.a.c.a.b;
/*     */ import org.a.c.a.c;
/*     */ import org.a.d.a.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private a() {
/*  34 */     throw new Error("do not instantiate");
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
/*     */   public static class a
/*     */     extends Exception
/*     */   {
/*     */     private static final long serialVersionUID = 6266881831979001480L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final PatternSyntaxException a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(PatternSyntaxException param1PatternSyntaxException) {
/*  81 */       this.a = param1PatternSyntaxException;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(String param1String1, String param1String2, int param1Int) {
/*  93 */       this(new PatternSyntaxException(param1String1, param1String2, param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDescription() {
/* 102 */       return this.a.getDescription();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getIndex() {
/* 112 */       return this.a.getIndex();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @b
/*     */     public String getMessage() {
/* 125 */       return this.a.getMessage();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPattern() {
/* 134 */       return this.a.getPattern();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @b
/*     */   @j(eu = true, f = {"#1"}, h = c.class)
/*     */   public static boolean G(String paramString) {
/* 147 */     return a(paramString, 0);
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
/*     */   @b
/*     */   @j(eu = true, f = {"#1"}, h = c.class)
/*     */   public static boolean a(String paramString, int paramInt) {
/*     */     Pattern pattern;
/*     */     try {
/* 166 */       pattern = Pattern.compile(paramString);
/* 167 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 168 */       return false;
/*     */     } 
/* 170 */     return (a(pattern) >= paramInt);
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
/*     */   @b
/*     */   @j(eu = true, f = {"#1"}, h = c.class)
/*     */   public static boolean d(char paramChar) {
/* 187 */     return G(Character.toString(paramChar));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static String aJ(String paramString) {
/* 199 */     return i(paramString, 0);
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
/*     */   @c
/*     */   public static String i(String paramString, int paramInt) {
/*     */     try {
/* 215 */       Pattern pattern = Pattern.compile(paramString);
/* 216 */       int i = a(pattern);
/* 217 */       if (i < paramInt) {
/* 218 */         return a(paramString, paramInt, i);
/*     */       }
/* 220 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 221 */       return patternSyntaxException.getMessage();
/*     */     } 
/* 223 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static PatternSyntaxException a(String paramString) {
/* 235 */     return a(paramString, 0);
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
/*     */   @c
/*     */   public static PatternSyntaxException a(String paramString, int paramInt) {
/*     */     try {
/* 251 */       Pattern pattern = Pattern.compile(paramString);
/* 252 */       int i = a(pattern);
/* 253 */       if (i < paramInt) {
/* 254 */         return new PatternSyntaxException(
/* 255 */             a(paramString, paramInt, i), paramString, -1);
/*     */       }
/* 257 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 258 */       return patternSyntaxException;
/*     */     } 
/* 260 */     return null;
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
/*     */   @c
/*     */   public static String aK(String paramString) {
/* 275 */     return j(paramString, 0);
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
/*     */   @c
/*     */   public static String j(String paramString, int paramInt) {
/*     */     try {
/* 294 */       Pattern pattern = Pattern.compile(paramString);
/* 295 */       int i = a(pattern);
/* 296 */       if (i < paramInt) {
/* 297 */         throw new Error(a(paramString, paramInt, i));
/*     */       }
/* 299 */       return paramString;
/* 300 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 301 */       throw new Error(patternSyntaxException);
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
/*     */   @c
/*     */   private static String a(String paramString, int paramInt1, int paramInt2) {
/* 316 */     return "regex \"" + paramString + "\" has " + paramInt2 + " groups, but " + paramInt1 + " groups are needed.";
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
/*     */   @b
/*     */   private static int a(Pattern paramPattern) {
/* 334 */     return paramPattern.matcher("").groupCount();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\n\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */