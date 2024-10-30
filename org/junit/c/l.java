/*     */ package org.junit.c;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
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
/*     */ public final class l
/*     */ {
/*     */   public static Exception a(Throwable paramThrowable) throws Exception {
/*  46 */     k(paramThrowable);
/*  47 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T extends Throwable> void k(Throwable paramThrowable) throws T {
/*  52 */     throw (T)paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String c(Throwable paramThrowable) {
/*  61 */     StringWriter stringWriter = new StringWriter();
/*  62 */     PrintWriter printWriter = new PrintWriter(stringWriter);
/*  63 */     paramThrowable.printStackTrace(printWriter);
/*  64 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String d(Throwable paramThrowable) {
/*  74 */     List<String> list = d(paramThrowable);
/*  75 */     if (list.isEmpty()) {
/*  76 */       return e(paramThrowable);
/*     */     }
/*     */     
/*  79 */     StringBuilder stringBuilder = new StringBuilder(paramThrowable.toString());
/*  80 */     a(list, stringBuilder);
/*  81 */     a(e(paramThrowable), stringBuilder);
/*  82 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static List<String> d(Throwable paramThrowable) {
/*  86 */     List<StackTraceElement> list = Arrays.asList(paramThrowable.getStackTrace());
/*  87 */     int i = list.size();
/*     */     
/*  89 */     a[] arrayOfA = a.a;
/*  90 */     for (StackTraceElement stackTraceElement : q(list)) {
/*  91 */       a a = arrayOfA.a(stackTraceElement);
/*  92 */       if (a == a.d) {
/*  93 */         ArrayList<String> arrayList = new ArrayList(i + 2);
/*  94 */         arrayList.add("");
/*  95 */         for (StackTraceElement stackTraceElement1 : list.subList(0, i)) {
/*  96 */           arrayList.add("\tat " + stackTraceElement1);
/*     */         }
/*  98 */         if (paramThrowable.getCause() != null) {
/*  99 */           arrayList.add("\t... " + (list.size() - arrayList.size()) + " trimmed");
/*     */         }
/* 101 */         return arrayList;
/*     */       } 
/* 103 */       i--;
/*     */     } 
/* 105 */     return Collections.emptyList();
/*     */   }
/*     */   
/* 108 */   private static final Method g = h();
/*     */   
/*     */   private static Method h() {
/*     */     try {
/* 112 */       return Throwable.class.getMethod("getSuppressed", new Class[0]);
/* 113 */     } catch (Throwable throwable) {
/* 114 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean b(Throwable paramThrowable) {
/* 119 */     if (g == null) {
/* 120 */       return false;
/*     */     }
/*     */     try {
/* 123 */       Throwable[] arrayOfThrowable = (Throwable[])g.invoke(paramThrowable, new Object[0]);
/* 124 */       return (arrayOfThrowable.length != 0);
/* 125 */     } catch (Throwable throwable) {
/* 126 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static List<String> e(Throwable paramThrowable) {
/* 131 */     if (paramThrowable.getCause() != null || b(paramThrowable)) {
/* 132 */       String str = e(paramThrowable);
/* 133 */       BufferedReader bufferedReader = new BufferedReader(new StringReader(str.substring(paramThrowable.toString().length())));
/*     */       
/* 135 */       ArrayList<String> arrayList = new ArrayList();
/*     */       
/*     */       try {
/*     */         String str1;
/* 139 */         while ((str1 = bufferedReader.readLine()) != null) {
/* 140 */           if (str1.startsWith("Caused by: ") || str1.trim().startsWith("Suppressed: ")) {
/* 141 */             arrayList.add(str1);
/* 142 */             while ((str1 = bufferedReader.readLine()) != null) {
/* 143 */               arrayList.add(str1);
/*     */             }
/* 145 */             return arrayList;
/*     */           } 
/*     */         } 
/* 148 */       } catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 153 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   private static String e(Throwable paramThrowable) {
/* 157 */     StringWriter stringWriter = new StringWriter();
/* 158 */     PrintWriter printWriter = new PrintWriter(stringWriter);
/* 159 */     paramThrowable.printStackTrace(printWriter);
/* 160 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(List<String> paramList, StringBuilder paramStringBuilder) {
/* 165 */     for (String str : paramList) {
/* 166 */       paramStringBuilder.append(String.format("%s%n", new Object[] { str }));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static <T> List<T> q(List<T> paramList) {
/* 171 */     return new AbstractList<T>(paramList)
/*     */       {
/*     */         public T get(int param1Int)
/*     */         {
/* 175 */           return this.aC.get(this.aC.size() - param1Int - 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 180 */           return this.aC.size();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private enum a {
/* 186 */     a {
/*     */       public a a(String param2String) {
/* 188 */         if (l.af(param2String)) {
/* 189 */           return b;
/*     */         }
/* 191 */         return this;
/*     */       }
/*     */     },
/* 194 */     b {
/*     */       public a a(String param2String) {
/* 196 */         if (l.ag(param2String))
/* 197 */           return c; 
/* 198 */         if (l.af(param2String)) {
/* 199 */           return this;
/*     */         }
/* 201 */         return (a)a;
/*     */       }
/*     */     },
/* 204 */     c {
/*     */       public a a(String param2String) {
/* 206 */         if (l.ag(param2String))
/* 207 */           return this; 
/* 208 */         if (l.af(param2String))
/*     */         {
/* 210 */           return b;
/*     */         }
/* 212 */         return d;
/*     */       }
/*     */     },
/* 215 */     d {
/*     */       public a a(String param2String) {
/* 217 */         return this;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a a(StackTraceElement param1StackTraceElement) {
/* 226 */       return a(param1StackTraceElement.getClassName() + "." + param1StackTraceElement.getMethodName() + "()");
/*     */     }
/*     */     
/*     */     protected abstract a a(String param1String); }
/* 230 */   private static final String[] m = new String[] { "org.junit.runner.", "org.junit.runners.", "org.junit.experimental.runners.", "org.junit.internal.", "junit." };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 238 */   private static final String[] n = new String[] { "org.junit.internal.StackTracesTest" };
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean ad(String paramString) {
/* 243 */     return (c(paramString, m) && !c(paramString, n));
/*     */   }
/*     */ 
/*     */   
/* 247 */   private static final String[] o = new String[] { "sun.reflect.", "java.lang.reflect.", "jdk.internal.reflect.", "org.junit.rules.RunRules.<init>(", "org.junit.rules.RunRules.applyAll(", "org.junit.runners.RuleContainer.apply(", "junit.framework.TestCase.runBare(" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean ae(String paramString) {
/* 258 */     return c(paramString, o);
/*     */   }
/*     */   
/*     */   private static boolean c(String paramString, String[] paramArrayOfString) {
/* 262 */     for (String str : paramArrayOfString) {
/* 263 */       if (paramString.startsWith(str)) {
/* 264 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 268 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\l.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */