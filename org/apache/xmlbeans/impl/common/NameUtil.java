/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NameUtil
/*     */ {
/*     */   public static final char HYPHEN = '-';
/*     */   public static final char PERIOD = '.';
/*     */   public static final char COLON = ':';
/*     */   public static final char USCORE = '_';
/*     */   public static final char DOT = '·';
/*     */   public static final char TELEIA = '·';
/*     */   public static final char AYAH = '۝';
/*     */   public static final char ELHIZB = '۞';
/*     */   private static final boolean DEBUG = false;
/*  36 */   private static final Set javaWords = new HashSet(Arrays.asList((Object[])new String[] { "assert", "abstract", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "threadsafe", "throw", "throws", "transient", "true", "try", "void", "volatile", "while" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   private static final Set extraWords = new HashSet(Arrays.asList((Object[])new String[] { "i", "target", "org", "com" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 197 */   private static final Set javaNames = new HashSet(Arrays.asList((Object[])new String[] { "CharSequence", "Cloneable", "Comparable", "Runnable", "Boolean", "Byte", "Character", "Class", "ClassLoader", "Compiler", "Double", "Float", "InheritableThreadLocal", "Integer", "Long", "Math", "Number", "Object", "Package", "Process", "Runtime", "RuntimePermission", "SecurityManager", "Short", "StackTraceElement", "StrictMath", "String", "StringBuffer", "System", "Thread", "ThreadGroup", "ThreadLocal", "Throwable", "Void", "ArithmeticException", "ArrayIndexOutOfBoundsException", "ArrayStoreException", "ClassCastException", "ClassNotFoundException", "CloneNotSupportedException", "Exception", "IllegalAccessException", "IllegalArgumentException", "IllegalMonitorStateException", "IllegalStateException", "IllegalThreadStateException", "IndexOutOfBoundsException", "InstantiationException", "InterruptedException", "NegativeArraySizeException", "NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException", "RuntimeException", "SecurityException", "StringIndexOutOfBoundsException", "UnsupportedOperationException", "AbstractMethodError", "AssertionError", "ClassCircularityError", "ClassFormatError", "Error", "ExceptionInInitializerError", "IllegalAccessError", "IncompatibleClassChangeError", "InstantiationError", "InternalError", "LinkageError", "NoClassDefFoundError", "NoSuchFieldError", "NoSuchMethodError", "OutOfMemoryError", "StackOverflowError", "ThreadDeath", "UnknownError", "UnsatisfiedLinkError", "UnsupportedClassVersionError", "VerifyError", "VirtualMachineError", "BigInteger", "BigDecimal", "Enum", "Date", "GDate", "GDuration", "QName", "List", "XmlObject", "XmlCursor", "XmlBeans", "SchemaType" }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String JAVA_NS_PREFIX = "java:";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String LANG_PREFIX = "java.";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int START = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PUNCT = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int DIGIT = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MARK = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int UPPER = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int LOWER = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int NOCASE = 6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isValidJavaIdentifier(String paramString) {
/* 305 */     if (paramString == null) {
/* 306 */       throw new IllegalArgumentException("id cannot be null");
/*     */     }
/* 308 */     int i = paramString.length();
/* 309 */     if (i == 0) {
/* 310 */       return false;
/*     */     }
/* 312 */     if (javaWords.contains(paramString)) {
/* 313 */       return false;
/*     */     }
/* 315 */     if (!Character.isJavaIdentifierStart(paramString.charAt(0))) {
/* 316 */       return false;
/*     */     }
/* 318 */     for (byte b = 1; b < i; b++) {
/*     */       
/* 320 */       if (!Character.isJavaIdentifierPart(paramString.charAt(b))) {
/* 321 */         return false;
/*     */       }
/*     */     } 
/* 324 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getClassNameFromQName(b paramb) {
/* 329 */     return getClassNameFromQName(paramb, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getClassNameFromQName(b paramb, boolean paramBoolean) {
/* 334 */     String str1 = upperCamelCase(paramb.dT(), paramBoolean);
/*     */     
/* 336 */     String str2 = paramb.getNamespaceURI();
/* 337 */     String str3 = null;
/*     */     
/* 339 */     str3 = getPackageFromNamespace(str2, paramBoolean);
/*     */     
/* 341 */     if (str3 != null) {
/* 342 */       return str3 + "." + str1;
/*     */     }
/* 344 */     return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getNamespaceFromPackage(Class paramClass) {
/* 352 */     Class clazz = paramClass;
/*     */     
/* 354 */     while (clazz.isArray()) {
/* 355 */       clazz = clazz.getComponentType();
/*     */     }
/* 357 */     String str1 = paramClass.getName();
/* 358 */     int i = str1.lastIndexOf('.');
/* 359 */     String str2 = (i < 0) ? "" : str1.substring(0, i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     return "java:" + str2;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isUriSchemeChar(char paramChar) {
/* 378 */     return ((paramChar >= 'a' && paramChar <= 'z') || (paramChar >= 'A' && paramChar <= 'Z') || (paramChar >= '0' && paramChar <= '9') || paramChar == '-' || paramChar == '.' || paramChar == '+');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isUriAlphaChar(char paramChar) {
/* 386 */     return ((paramChar >= 'a' && paramChar <= 'z') || (paramChar >= 'A' && paramChar <= 'Z'));
/*     */   }
/*     */ 
/*     */   
/*     */   private static int findSchemeColon(String paramString) {
/* 391 */     int i = paramString.length();
/* 392 */     if (i == 0)
/* 393 */       return -1; 
/* 394 */     if (!isUriAlphaChar(paramString.charAt(0)))
/* 395 */       return -1; 
/*     */     byte b;
/* 397 */     for (b = 1; b < i && 
/* 398 */       isUriSchemeChar(paramString.charAt(b)); b++);
/*     */     
/* 400 */     if (b == i)
/* 401 */       return -1; 
/* 402 */     if (paramString.charAt(b) != ':') {
/* 403 */       return -1;
/*     */     }
/* 405 */     for (; b < i && 
/* 406 */       paramString.charAt(b) == ':'; b++);
/*     */ 
/*     */     
/* 409 */     return b - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String jls77String(String paramString) {
/* 414 */     StringBuffer stringBuffer = new StringBuffer(paramString);
/* 415 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 420 */       if (!Character.isJavaIdentifierPart(stringBuffer.charAt(b)) || '$' == stringBuffer.charAt(b))
/* 421 */         stringBuffer.setCharAt(b, '_'); 
/*     */     } 
/* 423 */     if (stringBuffer.length() == 0 || !Character.isJavaIdentifierStart(stringBuffer.charAt(0)))
/* 424 */       stringBuffer.insert(0, '_'); 
/* 425 */     if (isJavaReservedWord(paramString))
/* 426 */       stringBuffer.append('_'); 
/* 427 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List splitDNS(String paramString) {
/* 435 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 437 */     int i = paramString.length();
/* 438 */     int j = paramString.lastIndexOf('.');
/* 439 */     for (; j != -1; j--) {
/*     */       
/* 441 */       if (paramString.charAt(j) == '.') {
/* 442 */         arrayList.add(jls77String(paramString.substring(j + 1, i)));
/* 443 */         i = j;
/*     */       } 
/*     */     } 
/* 446 */     arrayList.add(jls77String(paramString.substring(0, i)));
/*     */ 
/*     */     
/* 449 */     if (arrayList.size() >= 3 && ((String)arrayList.get(arrayList.size() - 1)).toLowerCase().equals("www"))
/*     */     {
/* 451 */       arrayList.remove(arrayList.size() - 1);
/*     */     }
/* 453 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String processFilename(String paramString) {
/* 460 */     int i = paramString.lastIndexOf('.');
/* 461 */     if (i > 0 && (i + 1 + 2 == paramString.length() || i + 1 + 3 == paramString.length() || paramString.substring(i + 1).toLowerCase() == "html"))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 466 */       return paramString.substring(0, i);
/*     */     }
/*     */     
/* 469 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getPackageFromNamespace(String paramString) {
/* 474 */     return getPackageFromNamespace(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPackageFromNamespace(String paramString, boolean paramBoolean) {
/* 480 */     if (paramString == null || paramString.length() == 0) {
/* 481 */       return "noNamespace";
/*     */     }
/*     */     
/* 484 */     int i = paramString.length();
/* 485 */     int j = findSchemeColon(paramString);
/* 486 */     ArrayList arrayList = null;
/*     */     
/* 488 */     if (j == i - 1) {
/*     */ 
/*     */       
/* 491 */       arrayList = new ArrayList();
/* 492 */       arrayList.add(paramString.substring(0, j));
/*     */     }
/* 494 */     else if (j >= 0 && paramString.substring(0, j).equals("java")) {
/*     */       
/* 496 */       List list = Arrays.asList(paramString.substring(j + 1).split("\\."));
/*     */     } else {
/*     */       
/* 499 */       arrayList = new ArrayList();
/* 500 */       label42: while (++j < i) {
/*     */         
/* 502 */         while (paramString.charAt(j) == '/')
/* 503 */         { if (++j >= i)
/* 504 */             break label42;  }  int k = j; do {  }
/* 505 */         while (paramString.charAt(j) != '/' && 
/* 506 */           ++j < i);
/* 507 */         int m = j;
/* 508 */         arrayList.add(paramString.substring(k, m));
/*     */       } 
/* 510 */       if (arrayList.size() > 1) {
/* 511 */         arrayList.set(arrayList.size() - 1, processFilename(arrayList.get(arrayList.size() - 1)));
/*     */       }
/* 513 */       if (arrayList.size() > 0) {
/*     */         
/* 515 */         List list = splitDNS(arrayList.get(0));
/* 516 */         arrayList.remove(0);
/* 517 */         arrayList.addAll(0, list);
/*     */       } 
/*     */     } 
/*     */     
/* 521 */     StringBuffer stringBuffer = new StringBuffer();
/* 522 */     for (Iterator iterator = arrayList.iterator(); iterator.hasNext(); ) {
/*     */       
/* 524 */       String str = nonJavaKeyword(lowerCamelCase(iterator.next(), paramBoolean, true));
/* 525 */       if (str.length() > 0) {
/*     */         
/* 527 */         stringBuffer.append(str);
/* 528 */         stringBuffer.append('.');
/*     */       } 
/*     */     } 
/* 531 */     if (stringBuffer.length() == 0)
/* 532 */       return "noNamespace"; 
/* 533 */     if (paramBoolean)
/* 534 */       return stringBuffer.substring(0, stringBuffer.length() - 1).toLowerCase(); 
/* 535 */     return stringBuffer.substring(0, stringBuffer.length() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 540 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 541 */       System.out.println(upperCaseUnderbar(paramArrayOfString[b]));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String upperCaseUnderbar(String paramString) {
/* 552 */     StringBuffer stringBuffer = new StringBuffer();
/* 553 */     List list = splitWords(paramString, false);
/*     */     
/* 555 */     int i = list.size() - 1;
/* 556 */     if (i >= 0 && !Character.isJavaIdentifierStart(((String)list.get(0)).charAt(0)))
/* 557 */       stringBuffer.append("X_"); 
/*     */     int j;
/* 559 */     for (j = 0; j < i; j++) {
/*     */       
/* 561 */       stringBuffer.append(list.get(j));
/* 562 */       stringBuffer.append('_');
/*     */     } 
/*     */     
/* 565 */     if (i >= 0)
/*     */     {
/* 567 */       stringBuffer.append(list.get(i));
/*     */     }
/*     */ 
/*     */     
/* 571 */     j = stringBuffer.length();
/* 572 */     for (byte b = 0; b < j; b++) {
/*     */       
/* 574 */       char c = stringBuffer.charAt(b);
/* 575 */       stringBuffer.setCharAt(b, Character.toUpperCase(c));
/*     */     } 
/*     */     
/* 578 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String upperCamelCase(String paramString) {
/* 589 */     return upperCamelCase(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String upperCamelCase(String paramString, boolean paramBoolean) {
/* 598 */     StringBuffer stringBuffer = new StringBuffer();
/* 599 */     List list = splitWords(paramString, paramBoolean);
/*     */     
/* 601 */     if (list.size() > 0) {
/*     */       
/* 603 */       if (!Character.isJavaIdentifierStart(((String)list.get(0)).charAt(0))) {
/* 604 */         stringBuffer.append("X");
/*     */       }
/* 606 */       Iterator iterator = list.iterator();
/* 607 */       while (iterator.hasNext())
/* 608 */         stringBuffer.append(iterator.next()); 
/*     */     } 
/* 610 */     return stringBuffer.toString();
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
/*     */   public static String lowerCamelCase(String paramString) {
/* 624 */     return lowerCamelCase(paramString, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String lowerCamelCase(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 633 */     StringBuffer stringBuffer = new StringBuffer();
/* 634 */     List list = splitWords(paramString, paramBoolean1);
/*     */     
/* 636 */     if (list.size() > 0) {
/*     */       
/* 638 */       String str = ((String)list.get(0)).toLowerCase();
/* 639 */       char c = str.charAt(0);
/* 640 */       if (!Character.isJavaIdentifierStart(c) && paramBoolean2)
/* 641 */         stringBuffer.append("x"); 
/* 642 */       stringBuffer.append(str);
/*     */       
/* 644 */       Iterator iterator = list.iterator();
/* 645 */       iterator.next();
/* 646 */       while (iterator.hasNext())
/* 647 */         stringBuffer.append(iterator.next()); 
/*     */     } 
/* 649 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String upperCaseFirstLetter(String paramString) {
/* 654 */     if (paramString.length() == 0 || Character.isUpperCase(paramString.charAt(0))) {
/* 655 */       return paramString;
/*     */     }
/* 657 */     StringBuffer stringBuffer = new StringBuffer(paramString);
/* 658 */     stringBuffer.setCharAt(0, Character.toUpperCase(stringBuffer.charAt(0)));
/* 659 */     return stringBuffer.toString();
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
/*     */   private static void addCapped(List paramList, String paramString) {
/* 671 */     if (paramString.length() > 0) {
/* 672 */       paramList.add(upperCaseFirstLetter(paramString));
/*     */     }
/*     */   }
/*     */   
/*     */   public static List splitWords(String paramString, boolean paramBoolean) {
/* 677 */     ArrayList arrayList = new ArrayList();
/* 678 */     int i = paramString.length();
/* 679 */     int j = 0;
/* 680 */     int k = 0;
/* 681 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 683 */       int m = getCharClass(paramString.charAt(b), paramBoolean);
/* 684 */       if (k != 1 && m == 1) {
/*     */         
/* 686 */         addCapped(arrayList, paramString.substring(j, b));
/* 687 */         while ((m = getCharClass(paramString.charAt(b), paramBoolean)) == 1) {
/* 688 */           if (++b >= i) return arrayList; 
/* 689 */         }  j = b;
/*     */       }
/* 691 */       else if (((k == 2) ? true : false) != ((m == 2) ? true : false) || (k == 5 && m != 5) || isLetter(k) != isLetter(m)) {
/*     */ 
/*     */ 
/*     */         
/* 695 */         addCapped(arrayList, paramString.substring(j, b));
/* 696 */         j = b;
/*     */       }
/* 698 */       else if (k == 4 && m == 5 && b > j + 1) {
/*     */         
/* 700 */         addCapped(arrayList, paramString.substring(j, b - 1));
/* 701 */         j = b - 1;
/*     */       } 
/* 703 */       k = m;
/*     */     } 
/* 705 */     addCapped(arrayList, paramString.substring(j));
/* 706 */     return arrayList;
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
/*     */   public static int getCharClass(char paramChar, boolean paramBoolean) {
/* 721 */     if (isPunctuation(paramChar, paramBoolean))
/* 722 */       return 1; 
/* 723 */     if (Character.isDigit(paramChar))
/* 724 */       return 2; 
/* 725 */     if (Character.isUpperCase(paramChar))
/* 726 */       return 4; 
/* 727 */     if (Character.isLowerCase(paramChar))
/* 728 */       return 5; 
/* 729 */     if (Character.isLetter(paramChar))
/* 730 */       return 6; 
/* 731 */     if (Character.isJavaIdentifierPart(paramChar)) {
/* 732 */       return 3;
/*     */     }
/* 734 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isLetter(int paramInt) {
/* 739 */     return (paramInt == 4 || paramInt == 5 || paramInt == 6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isPunctuation(char paramChar, boolean paramBoolean) {
/* 746 */     return (paramChar == '-' || paramChar == '.' || paramChar == ':' || paramChar == '·' || (paramChar == '_' && !paramBoolean) || paramChar == '·' || paramChar == '۝' || paramChar == '۞');
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
/*     */   public static String nonJavaKeyword(String paramString) {
/* 763 */     if (isJavaReservedWord(paramString))
/* 764 */       return 'x' + paramString; 
/* 765 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String nonExtraKeyword(String paramString) {
/* 775 */     if (isExtraReservedWord(paramString, true))
/* 776 */       return paramString + "Value"; 
/* 777 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String nonJavaCommonClassName(String paramString) {
/* 787 */     if (isJavaCommonClassName(paramString))
/* 788 */       return "X" + paramString; 
/* 789 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isJavaReservedWord(String paramString) {
/* 794 */     return isJavaReservedWord(paramString, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isJavaReservedWord(String paramString, boolean paramBoolean) {
/* 799 */     if (paramBoolean)
/* 800 */       paramString = paramString.toLowerCase(); 
/* 801 */     return javaWords.contains(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isExtraReservedWord(String paramString, boolean paramBoolean) {
/* 806 */     if (paramBoolean)
/* 807 */       paramString = paramString.toLowerCase(); 
/* 808 */     return extraWords.contains(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isJavaCommonClassName(String paramString) {
/* 813 */     return javaNames.contains(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\NameUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */