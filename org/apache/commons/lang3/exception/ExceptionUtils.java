/*     */ package org.apache.commons.lang3.exception;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.UndeclaredThrowableException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.ClassUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class ExceptionUtils
/*     */ {
/*     */   private static final int NOT_FOUND = -1;
/*  48 */   private static final String[] CAUSE_METHOD_NAMES = new String[] { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
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
/*     */   static final String WRAPPED_MARKER = " [wrapped] ";
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
/*     */   @Deprecated
/*     */   public static Throwable getCause(Throwable paramThrowable) {
/* 101 */     return getCause(paramThrowable, null);
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
/*     */   @Deprecated
/*     */   public static Throwable getCause(Throwable paramThrowable, String[] paramArrayOfString) {
/* 119 */     if (paramThrowable == null) {
/* 120 */       return null;
/*     */     }
/*     */     
/* 123 */     if (paramArrayOfString == null) {
/* 124 */       Throwable throwable = paramThrowable.getCause();
/* 125 */       if (throwable != null) {
/* 126 */         return throwable;
/*     */       }
/*     */       
/* 129 */       paramArrayOfString = CAUSE_METHOD_NAMES;
/*     */     } 
/*     */     
/* 132 */     for (String str : paramArrayOfString) {
/* 133 */       if (str != null) {
/* 134 */         Throwable throwable = getCauseUsingMethodName(paramThrowable, str);
/* 135 */         if (throwable != null) {
/* 136 */           return throwable;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return null;
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
/*     */   private static Throwable getCauseUsingMethodName(Throwable paramThrowable, String paramString) {
/* 153 */     Method method = null;
/*     */     try {
/* 155 */       method = paramThrowable.getClass().getMethod(paramString, new Class[0]);
/* 156 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {}
/*     */ 
/*     */ 
/*     */     
/* 160 */     if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
/*     */       try {
/* 162 */         return (Throwable)method.invoke(paramThrowable, new Object[0]);
/* 163 */       } catch (IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException illegalAccessException) {}
/*     */     }
/*     */ 
/*     */     
/* 167 */     return null;
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
/*     */   @Deprecated
/*     */   public static String[] getDefaultCauseMethodNames() {
/* 182 */     return (String[])ArrayUtils.clone((Object[])CAUSE_METHOD_NAMES);
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
/*     */   public static String getMessage(Throwable paramThrowable) {
/* 197 */     if (paramThrowable == null) {
/* 198 */       return "";
/*     */     }
/* 200 */     String str1 = ClassUtils.getShortClassName(paramThrowable, null);
/* 201 */     String str2 = paramThrowable.getMessage();
/* 202 */     return str1 + ": " + StringUtils.defaultString(str2);
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
/*     */   public static Throwable getRootCause(Throwable paramThrowable) {
/* 223 */     List<Throwable> list = getThrowableList(paramThrowable);
/* 224 */     return list.isEmpty() ? null : list.get(list.size() - 1);
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
/*     */   public static String getRootCauseMessage(Throwable paramThrowable) {
/* 239 */     Throwable throwable = getRootCause(paramThrowable);
/* 240 */     throwable = (throwable == null) ? paramThrowable : throwable;
/* 241 */     return getMessage(throwable);
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
/*     */   public static String[] getRootCauseStackTrace(Throwable paramThrowable) {
/* 259 */     if (paramThrowable == null) {
/* 260 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*     */     }
/* 262 */     Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
/* 263 */     int i = arrayOfThrowable.length;
/* 264 */     ArrayList<String> arrayList = new ArrayList();
/* 265 */     List<String> list = getStackFrameList(arrayOfThrowable[i - 1]);
/* 266 */     for (int j = i; --j >= 0; ) {
/* 267 */       List<String> list1 = list;
/* 268 */       if (j != 0) {
/* 269 */         list = getStackFrameList(arrayOfThrowable[j - 1]);
/* 270 */         removeCommonFrames(list1, list);
/*     */       } 
/* 272 */       if (j == i - 1) {
/* 273 */         arrayList.add(arrayOfThrowable[j].toString());
/*     */       } else {
/* 275 */         arrayList.add(" [wrapped] " + arrayOfThrowable[j].toString());
/*     */       } 
/* 277 */       arrayList.addAll(list1);
/*     */     } 
/* 279 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
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
/*     */   static List<String> getStackFrameList(Throwable paramThrowable) {
/* 295 */     String str1 = getStackTrace(paramThrowable);
/* 296 */     String str2 = System.lineSeparator();
/* 297 */     StringTokenizer stringTokenizer = new StringTokenizer(str1, str2);
/* 298 */     ArrayList<String> arrayList = new ArrayList();
/* 299 */     boolean bool = false;
/* 300 */     while (stringTokenizer.hasMoreTokens()) {
/* 301 */       String str = stringTokenizer.nextToken();
/*     */       
/* 303 */       int i = str.indexOf("at");
/* 304 */       if (i != -1 && str.substring(0, i).trim().isEmpty()) {
/* 305 */         bool = true;
/* 306 */         arrayList.add(str); continue;
/* 307 */       }  if (bool) {
/*     */         break;
/*     */       }
/*     */     } 
/* 311 */     return arrayList;
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
/*     */   static String[] getStackFrames(String paramString) {
/* 324 */     String str = System.lineSeparator();
/* 325 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, str);
/* 326 */     ArrayList<String> arrayList = new ArrayList();
/* 327 */     while (stringTokenizer.hasMoreTokens()) {
/* 328 */       arrayList.add(stringTokenizer.nextToken());
/*     */     }
/* 330 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
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
/*     */   public static String[] getStackFrames(Throwable paramThrowable) {
/* 347 */     if (paramThrowable == null) {
/* 348 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*     */     }
/* 350 */     return getStackFrames(getStackTrace(paramThrowable));
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
/*     */   public static String getStackTrace(Throwable paramThrowable) {
/* 367 */     StringWriter stringWriter = new StringWriter();
/* 368 */     PrintWriter printWriter = new PrintWriter(stringWriter, true);
/* 369 */     paramThrowable.printStackTrace(printWriter);
/* 370 */     return stringWriter.getBuffer().toString();
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
/*     */   public static int getThrowableCount(Throwable paramThrowable) {
/* 391 */     return getThrowableList(paramThrowable).size();
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
/*     */   public static List<Throwable> getThrowableList(Throwable paramThrowable) {
/* 414 */     ArrayList<Throwable> arrayList = new ArrayList();
/* 415 */     while (paramThrowable != null && !arrayList.contains(paramThrowable)) {
/* 416 */       arrayList.add(paramThrowable);
/* 417 */       paramThrowable = paramThrowable.getCause();
/*     */     } 
/* 419 */     return arrayList;
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
/*     */   public static Throwable[] getThrowables(Throwable paramThrowable) {
/* 442 */     List<Throwable> list = getThrowableList(paramThrowable);
/* 443 */     return list.<Throwable>toArray(ArrayUtils.EMPTY_THROWABLE_ARRAY);
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
/*     */   public static boolean hasCause(Throwable paramThrowable, Class<? extends Throwable> paramClass) {
/* 461 */     if (paramThrowable instanceof UndeclaredThrowableException) {
/* 462 */       paramThrowable = paramThrowable.getCause();
/*     */     }
/* 464 */     return paramClass.isInstance(paramThrowable);
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
/*     */   private static int indexOf(Throwable paramThrowable, Class<? extends Throwable> paramClass, int paramInt, boolean paramBoolean) {
/* 479 */     if (paramThrowable == null || paramClass == null) {
/* 480 */       return -1;
/*     */     }
/* 482 */     if (paramInt < 0) {
/* 483 */       paramInt = 0;
/*     */     }
/* 485 */     Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
/* 486 */     if (paramInt >= arrayOfThrowable.length) {
/* 487 */       return -1;
/*     */     }
/* 489 */     if (paramBoolean) {
/* 490 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/* 491 */         if (paramClass.isAssignableFrom(arrayOfThrowable[i].getClass())) {
/* 492 */           return i;
/*     */         }
/*     */       } 
/*     */     } else {
/* 496 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/* 497 */         if (paramClass.equals(arrayOfThrowable[i].getClass())) {
/* 498 */           return i;
/*     */         }
/*     */       } 
/*     */     } 
/* 502 */     return -1;
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
/*     */   public static int indexOfThrowable(Throwable paramThrowable, Class<? extends Throwable> paramClass) {
/* 520 */     return indexOf(paramThrowable, paramClass, 0, false);
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
/*     */   public static int indexOfThrowable(Throwable paramThrowable, Class<? extends Throwable> paramClass, int paramInt) {
/* 543 */     return indexOf(paramThrowable, paramClass, paramInt, false);
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
/*     */   public static int indexOfType(Throwable paramThrowable, Class<? extends Throwable> paramClass) {
/* 562 */     return indexOf(paramThrowable, paramClass, 0, true);
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
/*     */   public static int indexOfType(Throwable paramThrowable, Class<? extends Throwable> paramClass, int paramInt) {
/* 586 */     return indexOf(paramThrowable, paramClass, paramInt, true);
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
/*     */   public static void printRootCauseStackTrace(Throwable paramThrowable) {
/* 609 */     printRootCauseStackTrace(paramThrowable, System.err);
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
/*     */   public static void printRootCauseStackTrace(Throwable paramThrowable, PrintStream paramPrintStream) {
/* 633 */     if (paramThrowable == null) {
/*     */       return;
/*     */     }
/* 636 */     Objects.requireNonNull(paramPrintStream, "printStream");
/* 637 */     String[] arrayOfString = getRootCauseStackTrace(paramThrowable);
/* 638 */     for (String str : arrayOfString) {
/* 639 */       paramPrintStream.println(str);
/*     */     }
/* 641 */     paramPrintStream.flush();
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
/*     */   public static void printRootCauseStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter) {
/* 665 */     if (paramThrowable == null) {
/*     */       return;
/*     */     }
/* 668 */     Objects.requireNonNull(paramPrintWriter, "printWriter");
/* 669 */     String[] arrayOfString = getRootCauseStackTrace(paramThrowable);
/* 670 */     for (String str : arrayOfString) {
/* 671 */       paramPrintWriter.println(str);
/*     */     }
/* 673 */     paramPrintWriter.flush();
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
/*     */   public static void removeCommonFrames(List<String> paramList1, List<String> paramList2) {
/* 685 */     if (paramList1 == null || paramList2 == null) {
/* 686 */       throw new IllegalArgumentException("The List must not be null");
/*     */     }
/* 688 */     int i = paramList1.size() - 1;
/* 689 */     int j = paramList2.size() - 1;
/* 690 */     while (i >= 0 && j >= 0) {
/*     */ 
/*     */       
/* 693 */       String str1 = paramList1.get(i);
/* 694 */       String str2 = paramList2.get(j);
/* 695 */       if (str1.equals(str2)) {
/* 696 */         paramList1.remove(i);
/*     */       }
/* 698 */       i--;
/* 699 */       j--;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <R> R rethrow(Throwable paramThrowable) {
/* 760 */     return typeErasure(paramThrowable);
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
/*     */   private static <T extends Throwable> T throwableOf(Throwable paramThrowable, Class<T> paramClass, int paramInt, boolean paramBoolean) {
/* 776 */     if (paramThrowable == null || paramClass == null) {
/* 777 */       return null;
/*     */     }
/* 779 */     if (paramInt < 0) {
/* 780 */       paramInt = 0;
/*     */     }
/* 782 */     Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
/* 783 */     if (paramInt >= arrayOfThrowable.length) {
/* 784 */       return null;
/*     */     }
/* 786 */     if (paramBoolean) {
/* 787 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/* 788 */         if (paramClass.isAssignableFrom(arrayOfThrowable[i].getClass())) {
/* 789 */           return paramClass.cast(arrayOfThrowable[i]);
/*     */         }
/*     */       } 
/*     */     } else {
/* 793 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/* 794 */         if (paramClass.equals(arrayOfThrowable[i].getClass())) {
/* 795 */           return paramClass.cast(arrayOfThrowable[i]);
/*     */         }
/*     */       } 
/*     */     } 
/* 799 */     return null;
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
/*     */   public static <T extends Throwable> T throwableOfThrowable(Throwable paramThrowable, Class<T> paramClass) {
/* 819 */     return throwableOf(paramThrowable, paramClass, 0, false);
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
/*     */   public static <T extends Throwable> T throwableOfThrowable(Throwable paramThrowable, Class<T> paramClass, int paramInt) {
/* 844 */     return throwableOf(paramThrowable, paramClass, paramInt, false);
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
/*     */   public static <T extends Throwable> T throwableOfType(Throwable paramThrowable, Class<T> paramClass) {
/* 864 */     return throwableOf(paramThrowable, paramClass, 0, true);
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
/*     */   public static <T extends Throwable> T throwableOfType(Throwable paramThrowable, Class<T> paramClass, int paramInt) {
/* 889 */     return throwableOf(paramThrowable, paramClass, paramInt, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <R, T extends Throwable> R typeErasure(Throwable paramThrowable) throws T {
/* 900 */     throw (T)paramThrowable;
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
/*     */   public static <R> R wrapAndThrow(Throwable paramThrowable) {
/* 925 */     if (paramThrowable instanceof RuntimeException) {
/* 926 */       throw (RuntimeException)paramThrowable;
/*     */     }
/* 928 */     if (paramThrowable instanceof Error) {
/* 929 */       throw (Error)paramThrowable;
/*     */     }
/* 931 */     throw new UndeclaredThrowableException(paramThrowable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\exception\ExceptionUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */