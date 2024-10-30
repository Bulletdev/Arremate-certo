/*      */ package org.e;
/*      */ 
/*      */ import java.io.Closeable;
/*      */ import java.io.IOException;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Collection;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.ResourceBundle;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class i
/*      */ {
/*      */   private static final class a
/*      */   {
/*      */     private a() {}
/*      */     
/*      */     protected final Object clone() {
/*  119 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  132 */       return (param1Object == null || param1Object == this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  141 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  151 */       return "null";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  159 */   static final Pattern E = Pattern.compile("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Map<String, Object> map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  172 */   public static final Object NULL = new a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public i() {
/*  184 */     this.map = new HashMap<String, Object>();
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
/*      */   public i(i parami, String... paramVarArgs) {
/*  198 */     this(paramVarArgs.length);
/*  199 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*      */       try {
/*  201 */         d(paramVarArgs[b], parami.d(paramVarArgs[b]));
/*  202 */       } catch (Exception exception) {}
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
/*      */   public i(p paramp) throws g {
/*  217 */     this();
/*      */ 
/*      */ 
/*      */     
/*  221 */     if (paramp.f() != '{') {
/*  222 */       throw paramp.a("A JSONObject text must begin with '{'");
/*      */     }
/*      */     while (true) {
/*  225 */       char c = paramp.f();
/*  226 */       switch (c) {
/*      */         case '\000':
/*  228 */           throw paramp.a("A JSONObject text must end with '}'");
/*      */         case '}':
/*      */           return;
/*      */       } 
/*  232 */       paramp.il();
/*  233 */       String str = paramp.K().toString();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  238 */       c = paramp.f();
/*  239 */       if (c != ':') {
/*  240 */         throw paramp.a("Expected a ':' after a key");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  245 */       if (str != null) {
/*      */         
/*  247 */         if (d(str) != null)
/*      */         {
/*  249 */           throw paramp.a("Duplicate key \"" + str + "\"");
/*      */         }
/*      */         
/*  252 */         Object object = paramp.K();
/*  253 */         if (object != null) {
/*  254 */           c(str, object);
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  260 */       switch (paramp.f()) {
/*      */         case ',':
/*      */         case ';':
/*  263 */           if (paramp.f() == '}') {
/*      */             return;
/*      */           }
/*  266 */           paramp.il(); continue;
/*      */         case '}':
/*      */           return;
/*      */       }  break;
/*      */     } 
/*  271 */     throw paramp.a("Expected a ',' or '}'");
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
/*      */   public i(Map<?, ?> paramMap) {
/*  288 */     if (paramMap == null) {
/*  289 */       this.map = new HashMap<String, Object>();
/*      */     } else {
/*  291 */       this.map = new HashMap<String, Object>(paramMap.size());
/*  292 */       for (Map.Entry<?, ?> entry : paramMap.entrySet()) {
/*  293 */         if (entry.getKey() == null) {
/*  294 */           throw new NullPointerException("Null key.");
/*      */         }
/*  296 */         Object object = entry.getValue();
/*  297 */         if (object != null) {
/*  298 */           this.map.put(String.valueOf(entry.getKey()), M(object));
/*      */         }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public i(Object paramObject) {
/*  363 */     this();
/*  364 */     F(paramObject);
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
/*      */   public i(Object paramObject, String... paramVarArgs) {
/*  382 */     this(paramVarArgs.length);
/*  383 */     Class<?> clazz = paramObject.getClass();
/*  384 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  385 */       String str = paramVarArgs[b];
/*      */       try {
/*  387 */         e(str, clazz.getField(str).get(paramObject));
/*  388 */       } catch (Exception exception) {}
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
/*      */   public i(String paramString) throws g {
/*  406 */     this(new p(paramString));
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
/*      */   public i(String paramString, Locale paramLocale) throws g {
/*  420 */     this();
/*  421 */     ResourceBundle resourceBundle = ResourceBundle.getBundle(paramString, paramLocale, 
/*  422 */         Thread.currentThread().getContextClassLoader());
/*      */ 
/*      */ 
/*      */     
/*  426 */     Enumeration<String> enumeration = resourceBundle.getKeys();
/*  427 */     while (enumeration.hasMoreElements()) {
/*  428 */       String str = (String)enumeration.nextElement();
/*  429 */       if (str != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  435 */         String[] arrayOfString = ((String)str).split("\\.");
/*  436 */         int j = arrayOfString.length - 1;
/*  437 */         i i1 = this;
/*  438 */         for (byte b = 0; b < j; b++) {
/*  439 */           String str1 = arrayOfString[b];
/*  440 */           i i2 = i1.l(str1);
/*  441 */           if (i2 == null) {
/*  442 */             i2 = new i();
/*  443 */             i1.c(str1, i2);
/*      */           } 
/*  445 */           i1 = i2;
/*      */         } 
/*  447 */         i1.c(arrayOfString[j], resourceBundle.getString(str));
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
/*      */   protected i(int paramInt) {
/*  460 */     this.map = new HashMap<String, Object>(paramInt);
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
/*      */   public i a(String paramString, Object paramObject) throws g {
/*  485 */     G(paramObject);
/*  486 */     Object object = d(paramString);
/*  487 */     if (object == null) {
/*  488 */       c(paramString, (paramObject instanceof f) ? (new f())
/*  489 */           .a(paramObject) : paramObject);
/*      */     }
/*  491 */     else if (object instanceof f) {
/*  492 */       ((f)object).a(paramObject);
/*      */     } else {
/*  494 */       c(paramString, (new f()).a(object).a(paramObject));
/*      */     } 
/*  496 */     return this;
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
/*      */   public i b(String paramString, Object paramObject) throws g {
/*  517 */     G(paramObject);
/*  518 */     Object object = d(paramString);
/*  519 */     if (object == null) {
/*  520 */       c(paramString, (new f()).a(paramObject));
/*  521 */     } else if (object instanceof f) {
/*  522 */       c(paramString, ((f)object).a(paramObject));
/*      */     } else {
/*  524 */       throw a(paramString, "JSONArray", null, null);
/*      */     } 
/*  526 */     return this;
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
/*      */   public static String d(double paramDouble) {
/*  538 */     if (Double.isInfinite(paramDouble) || Double.isNaN(paramDouble)) {
/*  539 */       return "null";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  544 */     String str = Double.toString(paramDouble);
/*  545 */     if (str.indexOf('.') > 0 && str.indexOf('e') < 0 && str
/*  546 */       .indexOf('E') < 0) {
/*  547 */       while (str.endsWith("0")) {
/*  548 */         str = str.substring(0, str.length() - 1);
/*      */       }
/*  550 */       if (str.endsWith(".")) {
/*  551 */         str = str.substring(0, str.length() - 1);
/*      */       }
/*      */     } 
/*  554 */     return str;
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
/*      */   public Object get(String paramString) throws g {
/*  567 */     if (paramString == null) {
/*  568 */       throw new g("Null key.");
/*      */     }
/*  570 */     Object object = d(paramString);
/*  571 */     if (object == null) {
/*  572 */       throw new g("JSONObject[" + quote(paramString) + "] not found.");
/*      */     }
/*  574 */     return object;
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
/*      */   public <E extends Enum<E>> E getEnum(Class<E> paramClass, String paramString) throws g {
/*  592 */     E e = (E)a((Class)paramClass, paramString);
/*  593 */     if (e == null)
/*      */     {
/*      */ 
/*      */       
/*  597 */       throw a(paramString, "enum of type " + quote(paramClass.getSimpleName()), null);
/*      */     }
/*  599 */     return e;
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
/*      */   public boolean getBoolean(String paramString) throws g {
/*  613 */     Object object = get(paramString);
/*  614 */     if (object.equals(Boolean.FALSE) || (object instanceof String && ((String)object)
/*      */       
/*  616 */       .equalsIgnoreCase("false")))
/*  617 */       return false; 
/*  618 */     if (object.equals(Boolean.TRUE) || (object instanceof String && ((String)object)
/*      */       
/*  620 */       .equalsIgnoreCase("true"))) {
/*  621 */       return true;
/*      */     }
/*  623 */     throw a(paramString, "Boolean", null);
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
/*      */   public BigInteger a(String paramString) throws g {
/*  637 */     Object object = get(paramString);
/*  638 */     BigInteger bigInteger = a(object, (BigInteger)null);
/*  639 */     if (bigInteger != null) {
/*  640 */       return bigInteger;
/*      */     }
/*  642 */     throw a(paramString, "BigInteger", object, null);
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
/*      */   public BigDecimal getBigDecimal(String paramString) throws g {
/*  659 */     Object object = get(paramString);
/*  660 */     BigDecimal bigDecimal = a(object, (BigDecimal)null);
/*  661 */     if (bigDecimal != null) {
/*  662 */       return bigDecimal;
/*      */     }
/*  664 */     throw a(paramString, "BigDecimal", object, null);
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
/*      */   public double getDouble(String paramString) throws g {
/*  678 */     Object object = get(paramString);
/*  679 */     if (object instanceof Number) {
/*  680 */       return ((Number)object).doubleValue();
/*      */     }
/*      */     try {
/*  683 */       return Double.parseDouble(object.toString());
/*  684 */     } catch (Exception exception) {
/*  685 */       throw a(paramString, "double", exception);
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
/*      */   public float getFloat(String paramString) throws g {
/*  700 */     Object object = get(paramString);
/*  701 */     if (object instanceof Number) {
/*  702 */       return ((Number)object).floatValue();
/*      */     }
/*      */     try {
/*  705 */       return Float.parseFloat(object.toString());
/*  706 */     } catch (Exception exception) {
/*  707 */       throw a(paramString, "float", exception);
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
/*      */   public Number a(String paramString) throws g {
/*  722 */     Object object = get(paramString);
/*      */     try {
/*  724 */       if (object instanceof Number) {
/*  725 */         return (Number)object;
/*      */       }
/*  727 */       return c(object.toString());
/*  728 */     } catch (Exception exception) {
/*  729 */       throw a(paramString, "number", exception);
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
/*      */   public int getInt(String paramString) throws g {
/*  744 */     Object object = get(paramString);
/*  745 */     if (object instanceof Number) {
/*  746 */       return ((Number)object).intValue();
/*      */     }
/*      */     try {
/*  749 */       return Integer.parseInt(object.toString());
/*  750 */     } catch (Exception exception) {
/*  751 */       throw a(paramString, "int", exception);
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
/*      */   public f c(String paramString) throws g {
/*  765 */     Object object = get(paramString);
/*  766 */     if (object instanceof f) {
/*  767 */       return (f)object;
/*      */     }
/*  769 */     throw a(paramString, "JSONArray", null);
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
/*      */   public i j(String paramString) throws g {
/*  782 */     Object object = get(paramString);
/*  783 */     if (object instanceof i) {
/*  784 */       return (i)object;
/*      */     }
/*  786 */     throw a(paramString, "JSONObject", null);
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
/*      */   public long getLong(String paramString) throws g {
/*  800 */     Object object = get(paramString);
/*  801 */     if (object instanceof Number) {
/*  802 */       return ((Number)object).longValue();
/*      */     }
/*      */     try {
/*  805 */       return Long.parseLong(object.toString());
/*  806 */     } catch (Exception exception) {
/*  807 */       throw a(paramString, "long", exception);
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
/*      */   public static String[] a(i parami) {
/*  819 */     if (parami.isEmpty()) {
/*  820 */       return null;
/*      */     }
/*  822 */     return parami.keySet().<String>toArray(new String[parami.length()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] a(Object paramObject) {
/*  833 */     if (paramObject == null) {
/*  834 */       return null;
/*      */     }
/*  836 */     Class<?> clazz = paramObject.getClass();
/*  837 */     Field[] arrayOfField = clazz.getFields();
/*  838 */     int j = arrayOfField.length;
/*  839 */     if (j == 0) {
/*  840 */       return null;
/*      */     }
/*  842 */     String[] arrayOfString = new String[j];
/*  843 */     for (byte b = 0; b < j; b++) {
/*  844 */       arrayOfString[b] = arrayOfField[b].getName();
/*      */     }
/*  846 */     return arrayOfString;
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
/*      */   public String getString(String paramString) throws g {
/*  859 */     Object object = get(paramString);
/*  860 */     if (object instanceof String) {
/*  861 */       return (String)object;
/*      */     }
/*  863 */     throw a(paramString, "string", null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean has(String paramString) {
/*  874 */     return this.map.containsKey(paramString);
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
/*      */   public i k(String paramString) throws g {
/*  893 */     Object object = d(paramString);
/*  894 */     if (object == null) {
/*  895 */       a(paramString, 1);
/*  896 */     } else if (object instanceof Integer) {
/*  897 */       a(paramString, ((Integer)object).intValue() + 1);
/*  898 */     } else if (object instanceof Long) {
/*  899 */       a(paramString, ((Long)object).longValue() + 1L);
/*  900 */     } else if (object instanceof BigInteger) {
/*  901 */       c(paramString, ((BigInteger)object).add(BigInteger.ONE));
/*  902 */     } else if (object instanceof Float) {
/*  903 */       a(paramString, ((Float)object).floatValue() + 1.0F);
/*  904 */     } else if (object instanceof Double) {
/*  905 */       a(paramString, ((Double)object).doubleValue() + 1.0D);
/*  906 */     } else if (object instanceof BigDecimal) {
/*  907 */       c(paramString, ((BigDecimal)object).add(BigDecimal.ONE));
/*      */     } else {
/*  909 */       throw new g("Unable to increment [" + quote(paramString) + "].");
/*      */     } 
/*  911 */     return this;
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
/*      */   public boolean isNull(String paramString) {
/*  924 */     return NULL.equals(d(paramString));
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
/*      */   public Iterator<String> o() {
/*  936 */     return keySet().iterator();
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
/*      */   public Set<String> keySet() {
/*  948 */     return this.map.keySet();
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
/*      */   protected Set<Map.Entry<String, Object>> entrySet() {
/*  964 */     return this.map.entrySet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  973 */     return this.map.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  982 */     return this.map.isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f h() {
/*  993 */     if (this.map.isEmpty()) {
/*  994 */       return null;
/*      */     }
/*  996 */     return new f(this.map.keySet());
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
/*      */   public static String b(Number paramNumber) throws g {
/* 1009 */     if (paramNumber == null) {
/* 1010 */       throw new g("Null pointer");
/*      */     }
/* 1012 */     G(paramNumber);
/*      */ 
/*      */ 
/*      */     
/* 1016 */     String str = paramNumber.toString();
/* 1017 */     if (str.indexOf('.') > 0 && str.indexOf('e') < 0 && str
/* 1018 */       .indexOf('E') < 0) {
/* 1019 */       while (str.endsWith("0")) {
/* 1020 */         str = str.substring(0, str.length() - 1);
/*      */       }
/* 1022 */       if (str.endsWith(".")) {
/* 1023 */         str = str.substring(0, str.length() - 1);
/*      */       }
/*      */     } 
/* 1026 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object d(String paramString) {
/* 1037 */     return (paramString == null) ? null : this.map.get(paramString);
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
/*      */   public <E extends Enum<E>> E a(Class<E> paramClass, String paramString) {
/* 1052 */     return a(paramClass, paramString, (E)null);
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
/*      */   public <E extends Enum<E>> E a(Class<E> paramClass, String paramString, E paramE) {
/*      */     try {
/* 1071 */       Object object = d(paramString);
/* 1072 */       if (NULL.equals(object)) {
/* 1073 */         return paramE;
/*      */       }
/* 1075 */       if (paramClass.isAssignableFrom(object.getClass()))
/*      */       {
/*      */         
/* 1078 */         return (E)object;
/*      */       }
/*      */       
/* 1081 */       return Enum.valueOf(paramClass, object.toString());
/* 1082 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1083 */       return paramE;
/* 1084 */     } catch (NullPointerException nullPointerException) {
/* 1085 */       return paramE;
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
/*      */   public boolean aa(String paramString) {
/* 1098 */     return b(paramString, false);
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
/*      */   public boolean b(String paramString, boolean paramBoolean) {
/* 1113 */     Object object = d(paramString);
/* 1114 */     if (NULL.equals(object)) {
/* 1115 */       return paramBoolean;
/*      */     }
/* 1117 */     if (object instanceof Boolean) {
/* 1118 */       return ((Boolean)object).booleanValue();
/*      */     }
/*      */     
/*      */     try {
/* 1122 */       return getBoolean(paramString);
/* 1123 */     } catch (Exception exception) {
/* 1124 */       return paramBoolean;
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
/*      */   public BigDecimal a(String paramString, BigDecimal paramBigDecimal) {
/* 1143 */     Object object = d(paramString);
/* 1144 */     return a(object, paramBigDecimal);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static BigDecimal a(Object paramObject, BigDecimal paramBigDecimal) {
/* 1154 */     if (NULL.equals(paramObject)) {
/* 1155 */       return paramBigDecimal;
/*      */     }
/* 1157 */     if (paramObject instanceof BigDecimal) {
/* 1158 */       return (BigDecimal)paramObject;
/*      */     }
/* 1160 */     if (paramObject instanceof BigInteger) {
/* 1161 */       return new BigDecimal((BigInteger)paramObject);
/*      */     }
/* 1163 */     if (paramObject instanceof Double || paramObject instanceof Float) {
/* 1164 */       double d = ((Number)paramObject).doubleValue();
/* 1165 */       if (Double.isNaN(d)) {
/* 1166 */         return paramBigDecimal;
/*      */       }
/* 1168 */       return new BigDecimal(((Number)paramObject).doubleValue());
/*      */     } 
/* 1170 */     if (paramObject instanceof Long || paramObject instanceof Integer || paramObject instanceof Short || paramObject instanceof Byte)
/*      */     {
/* 1172 */       return new BigDecimal(((Number)paramObject).longValue());
/*      */     }
/*      */     
/*      */     try {
/* 1176 */       return new BigDecimal(paramObject.toString());
/* 1177 */     } catch (Exception exception) {
/* 1178 */       return paramBigDecimal;
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
/*      */   public BigInteger c(String paramString, BigInteger paramBigInteger) {
/* 1194 */     Object object = d(paramString);
/* 1195 */     return a(object, paramBigInteger);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static BigInteger a(Object paramObject, BigInteger paramBigInteger) {
/* 1205 */     if (NULL.equals(paramObject)) {
/* 1206 */       return paramBigInteger;
/*      */     }
/* 1208 */     if (paramObject instanceof BigInteger) {
/* 1209 */       return (BigInteger)paramObject;
/*      */     }
/* 1211 */     if (paramObject instanceof BigDecimal) {
/* 1212 */       return ((BigDecimal)paramObject).toBigInteger();
/*      */     }
/* 1214 */     if (paramObject instanceof Double || paramObject instanceof Float) {
/* 1215 */       double d = ((Number)paramObject).doubleValue();
/* 1216 */       if (Double.isNaN(d)) {
/* 1217 */         return paramBigInteger;
/*      */       }
/* 1219 */       return (new BigDecimal(d)).toBigInteger();
/*      */     } 
/* 1221 */     if (paramObject instanceof Long || paramObject instanceof Integer || paramObject instanceof Short || paramObject instanceof Byte)
/*      */     {
/* 1223 */       return BigInteger.valueOf(((Number)paramObject).longValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1232 */       String str = paramObject.toString();
/* 1233 */       if (ac(str)) {
/* 1234 */         return (new BigDecimal(str)).toBigInteger();
/*      */       }
/* 1236 */       return new BigInteger(str);
/* 1237 */     } catch (Exception exception) {
/* 1238 */       return paramBigInteger;
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
/*      */   public double a(String paramString) {
/* 1252 */     return b(paramString, Double.NaN);
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
/*      */   public double b(String paramString, double paramDouble) {
/* 1267 */     Number number = b(paramString);
/* 1268 */     if (number == null) {
/* 1269 */       return paramDouble;
/*      */     }
/* 1271 */     return number.doubleValue();
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
/*      */   public float a(String paramString) {
/* 1288 */     return a(paramString, Float.NaN);
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
/*      */   public float a(String paramString, float paramFloat) {
/* 1303 */     Number number = b(paramString);
/* 1304 */     if (number == null) {
/* 1305 */       return paramFloat;
/*      */     }
/* 1307 */     return number.floatValue();
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
/*      */   public int g(String paramString) {
/* 1324 */     return e(paramString, 0);
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
/*      */   public int e(String paramString, int paramInt) {
/* 1339 */     Number number = a(paramString, (Number)null);
/* 1340 */     if (number == null) {
/* 1341 */       return paramInt;
/*      */     }
/* 1343 */     return number.intValue();
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
/*      */   public f d(String paramString) {
/* 1355 */     Object object = d(paramString);
/* 1356 */     return (object instanceof f) ? (f)object : null;
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
/*      */   public i l(String paramString) {
/* 1368 */     Object object = d(paramString);
/* 1369 */     return (object instanceof i) ? (i)object : null;
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
/*      */   public long f(String paramString) {
/* 1382 */     return c(paramString, 0L);
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
/*      */   public long c(String paramString, long paramLong) {
/* 1397 */     Number number = a(paramString, (Number)null);
/* 1398 */     if (number == null) {
/* 1399 */       return paramLong;
/*      */     }
/*      */     
/* 1402 */     return number.longValue();
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
/*      */   public Number b(String paramString) {
/* 1416 */     return a(paramString, (Number)null);
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
/*      */   public Number a(String paramString, Number paramNumber) {
/* 1432 */     Object object = d(paramString);
/* 1433 */     if (NULL.equals(object)) {
/* 1434 */       return paramNumber;
/*      */     }
/* 1436 */     if (object instanceof Number) {
/* 1437 */       return (Number)object;
/*      */     }
/*      */     
/*      */     try {
/* 1441 */       return c(object.toString());
/* 1442 */     } catch (Exception exception) {
/* 1443 */       return paramNumber;
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
/*      */   public String bl(String paramString) {
/* 1457 */     return n(paramString, "");
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
/*      */   public String n(String paramString1, String paramString2) {
/* 1471 */     Object object = d(paramString1);
/* 1472 */     return NULL.equals(object) ? paramString2 : object.toString();
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
/*      */   private void F(Object paramObject) {
/* 1485 */     Class<?> clazz = paramObject.getClass();
/*      */ 
/*      */ 
/*      */     
/* 1489 */     boolean bool = (clazz.getClassLoader() != null) ? true : false;
/*      */     
/* 1491 */     Method[] arrayOfMethod = bool ? clazz.getMethods() : clazz.getDeclaredMethods();
/* 1492 */     for (Method method : arrayOfMethod) {
/* 1493 */       int j = method.getModifiers();
/* 1494 */       if (Modifier.isPublic(j) && 
/* 1495 */         !Modifier.isStatic(j) && (method
/* 1496 */         .getParameterTypes()).length == 0 && 
/* 1497 */         !method.isBridge() && method
/* 1498 */         .getReturnType() != void.class && 
/* 1499 */         ab(method.getName())) {
/* 1500 */         String str = a(method);
/* 1501 */         if (str != null && !str.isEmpty()) {
/*      */           
/* 1503 */           try { Object object = method.invoke(paramObject, new Object[0]);
/* 1504 */             if (object != null) {
/* 1505 */               this.map.put(str, M(object));
/*      */ 
/*      */ 
/*      */               
/* 1509 */               if (object instanceof Closeable) {
/*      */                 try {
/* 1511 */                   ((Closeable)object).close();
/* 1512 */                 } catch (IOException iOException) {}
/*      */               }
/*      */             }
/*      */              }
/* 1516 */           catch (IllegalAccessException illegalAccessException) {  }
/* 1517 */           catch (IllegalArgumentException illegalArgumentException) {  }
/* 1518 */           catch (InvocationTargetException invocationTargetException) {}
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean ab(String paramString) {
/* 1526 */     return (!"getClass".equals(paramString) && !"getDeclaringClass".equals(paramString));
/*      */   }
/*      */   private static String a(Method paramMethod) {
/*      */     String str1;
/* 1530 */     int j = a(paramMethod, (Class)l.class);
/* 1531 */     if (j > 0) {
/* 1532 */       int k = a(paramMethod, (Class)m.class);
/* 1533 */       if (k < 0 || j <= k)
/*      */       {
/*      */         
/* 1536 */         return null;
/*      */       }
/*      */     } 
/* 1539 */     m m = a(paramMethod, m.class);
/* 1540 */     if (m != null && m.value() != null && !m.value().isEmpty()) {
/* 1541 */       return m.value();
/*      */     }
/*      */     
/* 1544 */     String str2 = paramMethod.getName();
/* 1545 */     if (str2.startsWith("get") && str2.length() > 3) {
/* 1546 */       str1 = str2.substring(3);
/* 1547 */     } else if (str2.startsWith("is") && str2.length() > 2) {
/* 1548 */       str1 = str2.substring(2);
/*      */     } else {
/* 1550 */       return null;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1555 */     if (Character.isLowerCase(str1.charAt(0))) {
/* 1556 */       return null;
/*      */     }
/* 1558 */     if (str1.length() == 1) {
/* 1559 */       str1 = str1.toLowerCase(Locale.ROOT);
/* 1560 */     } else if (!Character.isUpperCase(str1.charAt(1))) {
/* 1561 */       str1 = str1.substring(0, 1).toLowerCase(Locale.ROOT) + str1.substring(1);
/*      */     } 
/* 1563 */     return str1;
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
/*      */   private static <A extends Annotation> A a(Method paramMethod, Class<A> paramClass) {
/* 1582 */     if (paramMethod == null || paramClass == null) {
/* 1583 */       return null;
/*      */     }
/*      */     
/* 1586 */     if (paramMethod.isAnnotationPresent(paramClass)) {
/* 1587 */       return paramMethod.getAnnotation(paramClass);
/*      */     }
/*      */ 
/*      */     
/* 1591 */     Class<?> clazz = paramMethod.getDeclaringClass();
/* 1592 */     if (clazz.getSuperclass() == null) {
/* 1593 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1597 */     for (Class<?> clazz1 : clazz.getInterfaces()) {
/*      */       try {
/* 1599 */         Method method = clazz1.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
/* 1600 */         return a(method, paramClass);
/* 1601 */       } catch (SecurityException securityException) {
/*      */       
/* 1603 */       } catch (NoSuchMethodException noSuchMethodException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1609 */       return a(clazz
/* 1610 */           .getSuperclass().getMethod(paramMethod.getName(), paramMethod.getParameterTypes()), paramClass);
/*      */     }
/* 1612 */     catch (SecurityException securityException) {
/* 1613 */       return null;
/* 1614 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 1615 */       return null;
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
/*      */   private static int a(Method paramMethod, Class<? extends Annotation> paramClass) {
/* 1635 */     if (paramMethod == null || paramClass == null) {
/* 1636 */       return -1;
/*      */     }
/*      */     
/* 1639 */     if (paramMethod.isAnnotationPresent(paramClass)) {
/* 1640 */       return 1;
/*      */     }
/*      */ 
/*      */     
/* 1644 */     Class<?> clazz = paramMethod.getDeclaringClass();
/* 1645 */     if (clazz.getSuperclass() == null) {
/* 1646 */       return -1;
/*      */     }
/*      */ 
/*      */     
/* 1650 */     for (Class<?> clazz1 : clazz.getInterfaces()) {
/*      */       try {
/* 1652 */         Method method = clazz1.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
/* 1653 */         int j = a(method, paramClass);
/* 1654 */         if (j > 0)
/*      */         {
/* 1656 */           return j + 1;
/*      */         }
/* 1658 */       } catch (SecurityException securityException) {
/*      */       
/* 1660 */       } catch (NoSuchMethodException noSuchMethodException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1666 */       int j = a(clazz
/* 1667 */           .getSuperclass().getMethod(paramMethod.getName(), paramMethod.getParameterTypes()), paramClass);
/*      */       
/* 1669 */       if (j > 0)
/*      */       {
/* 1671 */         return j + 1;
/*      */       }
/* 1673 */       return -1;
/* 1674 */     } catch (SecurityException securityException) {
/* 1675 */       return -1;
/* 1676 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 1677 */       return -1;
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
/*      */   public i b(String paramString, boolean paramBoolean) throws g {
/* 1695 */     return c(paramString, paramBoolean ? Boolean.TRUE : Boolean.FALSE);
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
/*      */   public i a(String paramString, Collection<?> paramCollection) throws g {
/* 1713 */     return c(paramString, new f(paramCollection));
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
/*      */   public i a(String paramString, double paramDouble) throws g {
/* 1730 */     return c(paramString, Double.valueOf(paramDouble));
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
/*      */   public i a(String paramString, float paramFloat) throws g {
/* 1747 */     return c(paramString, Float.valueOf(paramFloat));
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
/*      */   public i a(String paramString, int paramInt) throws g {
/* 1764 */     return c(paramString, Integer.valueOf(paramInt));
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
/*      */   public i a(String paramString, long paramLong) throws g {
/* 1781 */     return c(paramString, Long.valueOf(paramLong));
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
/*      */   public i b(String paramString, Map<?, ?> paramMap) throws g {
/* 1799 */     return c(paramString, new i(paramMap));
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
/*      */   public i c(String paramString, Object paramObject) throws g {
/* 1819 */     if (paramString == null) {
/* 1820 */       throw new NullPointerException("Null key.");
/*      */     }
/* 1822 */     if (paramObject != null) {
/* 1823 */       G(paramObject);
/* 1824 */       this.map.put(paramString, paramObject);
/*      */     } else {
/* 1826 */       remove(paramString);
/*      */     } 
/* 1828 */     return this;
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
/*      */   public i d(String paramString, Object paramObject) throws g {
/* 1845 */     if (paramString != null && paramObject != null) {
/* 1846 */       if (d(paramString) != null) {
/* 1847 */         throw new g("Duplicate key \"" + paramString + "\"");
/*      */       }
/* 1849 */       return c(paramString, paramObject);
/*      */     } 
/* 1851 */     return this;
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
/*      */   public i e(String paramString, Object paramObject) throws g {
/* 1869 */     if (paramString != null && paramObject != null) {
/* 1870 */       return c(paramString, paramObject);
/*      */     }
/* 1872 */     return this;
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
/*      */   public Object b(String paramString) {
/* 1895 */     return a(new j(paramString));
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
/*      */   public Object a(j paramj) {
/* 1917 */     return paramj.N(this);
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
/*      */   public Object c(String paramString) {
/* 1929 */     return b(new j(paramString));
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
/*      */   public Object b(j paramj) {
/*      */     try {
/* 1942 */       return paramj.N(this);
/* 1943 */     } catch (k k) {
/* 1944 */       return null;
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
/*      */   public static String quote(String paramString) {
/* 1960 */     StringWriter stringWriter = new StringWriter();
/* 1961 */     synchronized (stringWriter.getBuffer()) {
/*      */       
/* 1963 */       return a(paramString, stringWriter).toString();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Writer a(String paramString, Writer paramWriter) throws IOException {
/* 1972 */     if (paramString == null || paramString.isEmpty()) {
/* 1973 */       paramWriter.write("\"\"");
/* 1974 */       return paramWriter;
/*      */     } 
/*      */ 
/*      */     
/* 1978 */     char c = Character.MIN_VALUE;
/*      */ 
/*      */     
/* 1981 */     int j = paramString.length();
/*      */     
/* 1983 */     paramWriter.write(34);
/* 1984 */     for (byte b = 0; b < j; b++) {
/* 1985 */       char c1 = c;
/* 1986 */       c = paramString.charAt(b);
/* 1987 */       switch (c) {
/*      */         case '"':
/*      */         case '\\':
/* 1990 */           paramWriter.write(92);
/* 1991 */           paramWriter.write(c);
/*      */           break;
/*      */         case '/':
/* 1994 */           if (c1 == '<') {
/* 1995 */             paramWriter.write(92);
/*      */           }
/* 1997 */           paramWriter.write(c);
/*      */           break;
/*      */         case '\b':
/* 2000 */           paramWriter.write("\\b");
/*      */           break;
/*      */         case '\t':
/* 2003 */           paramWriter.write("\\t");
/*      */           break;
/*      */         case '\n':
/* 2006 */           paramWriter.write("\\n");
/*      */           break;
/*      */         case '\f':
/* 2009 */           paramWriter.write("\\f");
/*      */           break;
/*      */         case '\r':
/* 2012 */           paramWriter.write("\\r");
/*      */           break;
/*      */         default:
/* 2015 */           if (c < ' ' || (c >= '' && c < ' ') || (c >= ' ' && c < '℀')) {
/*      */             
/* 2017 */             paramWriter.write("\\u");
/* 2018 */             String str = Integer.toHexString(c);
/* 2019 */             paramWriter.write("0000", 0, 4 - str.length());
/* 2020 */             paramWriter.write(str); break;
/*      */           } 
/* 2022 */           paramWriter.write(c);
/*      */           break;
/*      */       } 
/*      */     } 
/* 2026 */     paramWriter.write(34);
/* 2027 */     return paramWriter;
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
/*      */   public Object remove(String paramString) {
/* 2039 */     return this.map.remove(paramString);
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
/*      */   public boolean G(Object paramObject) {
/*      */     try {
/* 2052 */       if (!(paramObject instanceof i)) {
/* 2053 */         return false;
/*      */       }
/* 2055 */       if (!keySet().equals(((i)paramObject).keySet())) {
/* 2056 */         return false;
/*      */       }
/* 2058 */       for (Map.Entry<String, Object> entry : entrySet()) {
/* 2059 */         String str = (String)entry.getKey();
/* 2060 */         Object object1 = entry.getValue();
/* 2061 */         Object object2 = ((i)paramObject).get(str);
/* 2062 */         if (object1 == object2) {
/*      */           continue;
/*      */         }
/* 2065 */         if (object1 == null) {
/* 2066 */           return false;
/*      */         }
/* 2068 */         if (object1 instanceof i) {
/* 2069 */           if (!((i)object1).G(object2))
/* 2070 */             return false;  continue;
/*      */         } 
/* 2072 */         if (object1 instanceof f) {
/* 2073 */           if (!((f)object1).G(object2))
/* 2074 */             return false;  continue;
/*      */         } 
/* 2076 */         if (!object1.equals(object2)) {
/* 2077 */           return false;
/*      */         }
/*      */       } 
/* 2080 */       return true;
/* 2081 */     } catch (Throwable throwable) {
/* 2082 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean ac(String paramString) {
/* 2093 */     return (paramString.indexOf('.') > -1 || paramString.indexOf('e') > -1 || paramString
/* 2094 */       .indexOf('E') > -1 || "-0".equals(paramString));
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
/*      */   protected static Number c(String paramString) throws NumberFormatException {
/* 2108 */     char c = paramString.charAt(0);
/* 2109 */     if ((c >= '0' && c <= '9') || c == '-') {
/*      */       
/* 2111 */       if (ac(paramString)) {
/*      */         
/*      */         try {
/*      */ 
/*      */           
/* 2116 */           BigDecimal bigDecimal = new BigDecimal(paramString);
/* 2117 */           if (c == '-' && BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
/* 2118 */             return Double.valueOf(-0.0D);
/*      */           }
/* 2120 */           return bigDecimal;
/* 2121 */         } catch (NumberFormatException numberFormatException) {
/*      */           
/*      */           try {
/* 2124 */             Double double_ = Double.valueOf(paramString);
/* 2125 */             if (double_.isNaN() || double_.isInfinite()) {
/* 2126 */               throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*      */             }
/* 2128 */             return double_;
/* 2129 */           } catch (NumberFormatException numberFormatException1) {
/* 2130 */             throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/* 2135 */       if (c == '0' && paramString.length() > 1) {
/* 2136 */         char c1 = paramString.charAt(1);
/* 2137 */         if (c1 >= '0' && c1 <= '9') {
/* 2138 */           throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*      */         }
/* 2140 */       } else if (c == '-' && paramString.length() > 2) {
/* 2141 */         char c1 = paramString.charAt(1);
/* 2142 */         char c2 = paramString.charAt(2);
/* 2143 */         if (c1 == '0' && c2 >= '0' && c2 <= '9') {
/* 2144 */           throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2155 */       BigInteger bigInteger = new BigInteger(paramString);
/* 2156 */       if (bigInteger.bitLength() <= 31) {
/* 2157 */         return Integer.valueOf(bigInteger.intValue());
/*      */       }
/* 2159 */       if (bigInteger.bitLength() <= 63) {
/* 2160 */         return Long.valueOf(bigInteger.longValue());
/*      */       }
/* 2162 */       return bigInteger;
/*      */     } 
/* 2164 */     throw new NumberFormatException("val [" + paramString + "] is not a valid number.");
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
/*      */   public static Object e(String paramString) {
/* 2180 */     if ("".equals(paramString)) {
/* 2181 */       return paramString;
/*      */     }
/*      */ 
/*      */     
/* 2185 */     if ("true".equalsIgnoreCase(paramString)) {
/* 2186 */       return Boolean.TRUE;
/*      */     }
/* 2188 */     if ("false".equalsIgnoreCase(paramString)) {
/* 2189 */       return Boolean.FALSE;
/*      */     }
/* 2191 */     if ("null".equalsIgnoreCase(paramString)) {
/* 2192 */       return NULL;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2200 */     char c = paramString.charAt(0);
/* 2201 */     if ((c >= '0' && c <= '9') || c == '-') {
/*      */       try {
/* 2203 */         return c(paramString);
/* 2204 */       } catch (Exception exception) {}
/*      */     }
/*      */     
/* 2207 */     return paramString;
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
/*      */   public static void G(Object paramObject) throws g {
/* 2219 */     if (paramObject != null) {
/* 2220 */       if (paramObject instanceof Double) {
/* 2221 */         if (((Double)paramObject).isInfinite() || ((Double)paramObject).isNaN()) {
/* 2222 */           throw new g("JSON does not allow non-finite numbers.");
/*      */         }
/*      */       }
/* 2225 */       else if (paramObject instanceof Float && ((
/* 2226 */         (Float)paramObject).isInfinite() || ((Float)paramObject).isNaN())) {
/* 2227 */         throw new g("JSON does not allow non-finite numbers.");
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
/*      */   public f b(f paramf) throws g {
/* 2246 */     if (paramf == null || paramf.isEmpty()) {
/* 2247 */       return null;
/*      */     }
/* 2249 */     f f1 = new f();
/* 2250 */     for (byte b = 0; b < paramf.length(); b++) {
/* 2251 */       f1.a(d(paramf.getString(b)));
/*      */     }
/* 2253 */     return f1;
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
/*      */   public String toString() {
/*      */     try {
/* 2272 */       return toString(0);
/* 2273 */     } catch (Exception exception) {
/* 2274 */       return null;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString(int paramInt) throws g {
/* 2305 */     StringWriter stringWriter = new StringWriter();
/* 2306 */     synchronized (stringWriter.getBuffer()) {
/* 2307 */       return a(stringWriter, paramInt, 0).toString();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String m(Object paramObject) throws g {
/* 2340 */     return q.m(paramObject);
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
/*      */   public static Object M(Object paramObject) {
/*      */     try {
/* 2357 */       if (paramObject == null) {
/* 2358 */         return NULL;
/*      */       }
/* 2360 */       if (paramObject instanceof i || paramObject instanceof f || NULL
/* 2361 */         .equals(paramObject) || paramObject instanceof n || paramObject instanceof Byte || paramObject instanceof Character || paramObject instanceof Short || paramObject instanceof Integer || paramObject instanceof Long || paramObject instanceof Boolean || paramObject instanceof Float || paramObject instanceof Double || paramObject instanceof String || paramObject instanceof BigInteger || paramObject instanceof BigDecimal || paramObject instanceof Enum)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2368 */         return paramObject;
/*      */       }
/*      */       
/* 2371 */       if (paramObject instanceof Collection) {
/* 2372 */         Collection<?> collection = (Collection)paramObject;
/* 2373 */         return new f(collection);
/*      */       } 
/* 2375 */       if (paramObject.getClass().isArray()) {
/* 2376 */         return new f(paramObject);
/*      */       }
/* 2378 */       if (paramObject instanceof Map) {
/* 2379 */         Map<?, ?> map = (Map)paramObject;
/* 2380 */         return new i(map);
/*      */       } 
/* 2382 */       Package package_ = paramObject.getClass().getPackage();
/*      */       
/* 2384 */       String str = (package_ != null) ? package_.getName() : "";
/* 2385 */       if (str.startsWith("java.") || str
/* 2386 */         .startsWith("javax.") || paramObject
/* 2387 */         .getClass().getClassLoader() == null) {
/* 2388 */         return paramObject.toString();
/*      */       }
/* 2390 */       return new i(paramObject);
/* 2391 */     } catch (Exception exception) {
/* 2392 */       return null;
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
/*      */   public Writer a(Writer paramWriter) throws g {
/* 2407 */     return a(paramWriter, 0, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   static final Writer a(Writer paramWriter, Object paramObject, int paramInt1, int paramInt2) throws g, IOException {
/* 2412 */     if (paramObject == null || paramObject.equals(null)) {
/* 2413 */       paramWriter.write("null");
/* 2414 */     } else if (paramObject instanceof n) {
/*      */       String str;
/*      */       try {
/* 2417 */         str = ((n)paramObject).eQ();
/* 2418 */       } catch (Exception exception) {
/* 2419 */         throw new g(exception);
/*      */       } 
/* 2421 */       paramWriter.write((str != null) ? str.toString() : quote(paramObject.toString()));
/* 2422 */     } else if (paramObject instanceof Number) {
/*      */       
/* 2424 */       String str = b((Number)paramObject);
/* 2425 */       if (E.matcher(str).matches()) {
/* 2426 */         paramWriter.write(str);
/*      */       }
/*      */       else {
/*      */         
/* 2430 */         a(str, paramWriter);
/*      */       } 
/* 2432 */     } else if (paramObject instanceof Boolean) {
/* 2433 */       paramWriter.write(paramObject.toString());
/* 2434 */     } else if (paramObject instanceof Enum) {
/* 2435 */       paramWriter.write(quote(((Enum)paramObject).name()));
/* 2436 */     } else if (paramObject instanceof i) {
/* 2437 */       ((i)paramObject).a(paramWriter, paramInt1, paramInt2);
/* 2438 */     } else if (paramObject instanceof f) {
/* 2439 */       ((f)paramObject).a(paramWriter, paramInt1, paramInt2);
/* 2440 */     } else if (paramObject instanceof Map) {
/* 2441 */       Map<?, ?> map = (Map)paramObject;
/* 2442 */       (new i(map)).a(paramWriter, paramInt1, paramInt2);
/* 2443 */     } else if (paramObject instanceof Collection) {
/* 2444 */       Collection<?> collection = (Collection)paramObject;
/* 2445 */       (new f(collection)).a(paramWriter, paramInt1, paramInt2);
/* 2446 */     } else if (paramObject.getClass().isArray()) {
/* 2447 */       (new f(paramObject)).a(paramWriter, paramInt1, paramInt2);
/*      */     } else {
/* 2449 */       a(paramObject.toString(), paramWriter);
/*      */     } 
/* 2451 */     return paramWriter;
/*      */   }
/*      */   
/*      */   static final void a(Writer paramWriter, int paramInt) throws IOException {
/* 2455 */     for (byte b = 0; b < paramInt; b++) {
/* 2456 */       paramWriter.write(32);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Writer a(Writer paramWriter, int paramInt1, int paramInt2) throws g {
/*      */     try {
/* 2490 */       boolean bool = false;
/* 2491 */       int j = length();
/* 2492 */       paramWriter.write(123);
/*      */       
/* 2494 */       if (j == 1) {
/* 2495 */         Map.Entry entry = entrySet().iterator().next();
/* 2496 */         String str = (String)entry.getKey();
/* 2497 */         paramWriter.write(quote(str));
/* 2498 */         paramWriter.write(58);
/* 2499 */         if (paramInt1 > 0) {
/* 2500 */           paramWriter.write(32);
/*      */         }
/*      */         try {
/* 2503 */           a(paramWriter, entry.getValue(), paramInt1, paramInt2);
/* 2504 */         } catch (Exception exception) {
/* 2505 */           throw new g("Unable to write JSONObject value for key: " + str, exception);
/*      */         } 
/* 2507 */       } else if (j != 0) {
/* 2508 */         int k = paramInt2 + paramInt1;
/* 2509 */         for (Map.Entry<String, Object> entry : entrySet()) {
/* 2510 */           if (bool) {
/* 2511 */             paramWriter.write(44);
/*      */           }
/* 2513 */           if (paramInt1 > 0) {
/* 2514 */             paramWriter.write(10);
/*      */           }
/* 2516 */           a(paramWriter, k);
/* 2517 */           String str = (String)entry.getKey();
/* 2518 */           paramWriter.write(quote(str));
/* 2519 */           paramWriter.write(58);
/* 2520 */           if (paramInt1 > 0) {
/* 2521 */             paramWriter.write(32);
/*      */           }
/*      */           try {
/* 2524 */             a(paramWriter, entry.getValue(), paramInt1, k);
/* 2525 */           } catch (Exception exception) {
/* 2526 */             throw new g("Unable to write JSONObject value for key: " + str, exception);
/*      */           } 
/* 2528 */           bool = true;
/*      */         } 
/* 2530 */         if (paramInt1 > 0) {
/* 2531 */           paramWriter.write(10);
/*      */         }
/* 2533 */         a(paramWriter, paramInt2);
/*      */       } 
/* 2535 */       paramWriter.write(125);
/* 2536 */       return paramWriter;
/* 2537 */     } catch (IOException iOException) {
/* 2538 */       throw new g(iOException);
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
/*      */   public Map<String, Object> S() {
/* 2552 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 2553 */     for (Map.Entry<String, Object> entry : entrySet()) {
/*      */       Object object;
/* 2555 */       if (entry.getValue() == null || NULL.equals(entry.getValue())) {
/* 2556 */         object = null;
/* 2557 */       } else if (entry.getValue() instanceof i) {
/* 2558 */         object = ((i)entry.getValue()).S();
/* 2559 */       } else if (entry.getValue() instanceof f) {
/* 2560 */         object = ((f)entry.getValue()).toList();
/*      */       } else {
/* 2562 */         object = entry.getValue();
/*      */       } 
/* 2564 */       hashMap.put(entry.getKey(), object);
/*      */     } 
/* 2566 */     return (Map)hashMap;
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
/*      */   private static g a(String paramString1, String paramString2, Throwable paramThrowable) {
/* 2580 */     return new g("JSONObject[" + 
/* 2581 */         quote(paramString1) + "] is not a " + paramString2 + ".", paramThrowable);
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
/*      */   private static g a(String paramString1, String paramString2, Object paramObject, Throwable paramThrowable) {
/* 2597 */     return new g("JSONObject[" + 
/* 2598 */         quote(paramString1) + "] is not a " + paramString2 + " (" + paramObject + ").", paramThrowable);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */