/*      */ package org.e;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.lang.reflect.Array;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class f
/*      */   implements Iterable<Object>
/*      */ {
/*      */   private final ArrayList<Object> a;
/*      */   
/*      */   public f() {
/*   95 */     this.a = new ArrayList();
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
/*      */   public f(p paramp) throws g {
/*  107 */     this();
/*  108 */     if (paramp.f() != '[') {
/*  109 */       throw paramp.a("A JSONArray text must start with '['");
/*      */     }
/*      */     
/*  112 */     char c = paramp.f();
/*  113 */     if (c == '\000')
/*      */     {
/*  115 */       throw paramp.a("Expected a ',' or ']'");
/*      */     }
/*  117 */     if (c != ']') {
/*  118 */       paramp.il();
/*      */       while (true) {
/*  120 */         if (paramp.f() == ',') {
/*  121 */           paramp.il();
/*  122 */           this.a.add(i.NULL);
/*      */         } else {
/*  124 */           paramp.il();
/*  125 */           this.a.add(paramp.K());
/*      */         } 
/*  127 */         switch (paramp.f()) {
/*      */           
/*      */           case '\000':
/*  130 */             throw paramp.a("Expected a ',' or ']'");
/*      */           case ',':
/*  132 */             c = paramp.f();
/*  133 */             if (c == '\000')
/*      */             {
/*  135 */               throw paramp.a("Expected a ',' or ']'");
/*      */             }
/*  137 */             if (c == ']') {
/*      */               return;
/*      */             }
/*  140 */             paramp.il(); continue;
/*      */           case ']':
/*      */             return;
/*      */         }  break;
/*      */       } 
/*  145 */       throw paramp.a("Expected a ',' or ']'");
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
/*      */   public f(String paramString) throws g {
/*  162 */     this(new p(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f(Collection<?> paramCollection) {
/*  172 */     if (paramCollection == null) {
/*  173 */       this.a = new ArrayList();
/*      */     } else {
/*  175 */       this.a = new ArrayList(paramCollection.size());
/*  176 */       a(paramCollection, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f(Iterable<?> paramIterable) {
/*  187 */     this();
/*  188 */     if (paramIterable == null) {
/*      */       return;
/*      */     }
/*  191 */     a(paramIterable, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f(f paramf) {
/*  201 */     if (paramf == null) {
/*  202 */       this.a = new ArrayList();
/*      */     }
/*      */     else {
/*      */       
/*  206 */       this.a = new ArrayList(paramf.a);
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
/*      */   public f(Object paramObject) throws g {
/*  223 */     this();
/*  224 */     if (!paramObject.getClass().isArray()) {
/*  225 */       throw new g("JSONArray initial value should be a string or collection or array.");
/*      */     }
/*      */     
/*  228 */     a(paramObject, true);
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
/*      */   public f(int paramInt) throws g {
/*  240 */     if (paramInt < 0) {
/*  241 */       throw new g("JSONArray initial capacity cannot be negative.");
/*      */     }
/*      */     
/*  244 */     this.a = new ArrayList(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public Iterator<Object> iterator() {
/*  249 */     return this.a.iterator();
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
/*      */   public Object get(int paramInt) throws g {
/*  262 */     Object object = h(paramInt);
/*  263 */     if (object == null) {
/*  264 */       throw new g("JSONArray[" + paramInt + "] not found.");
/*      */     }
/*  266 */     return object;
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
/*      */   public boolean getBoolean(int paramInt) throws g {
/*  281 */     Object object = get(paramInt);
/*  282 */     if (object.equals(Boolean.FALSE) || (object instanceof String && ((String)object)
/*      */       
/*  284 */       .equalsIgnoreCase("false")))
/*  285 */       return false; 
/*  286 */     if (object.equals(Boolean.TRUE) || (object instanceof String && ((String)object)
/*      */       
/*  288 */       .equalsIgnoreCase("true"))) {
/*  289 */       return true;
/*      */     }
/*  291 */     throw a(paramInt, "boolean", null);
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
/*      */   public double getDouble(int paramInt) throws g {
/*  305 */     Object object = get(paramInt);
/*  306 */     if (object instanceof Number) {
/*  307 */       return ((Number)object).doubleValue();
/*      */     }
/*      */     try {
/*  310 */       return Double.parseDouble(object.toString());
/*  311 */     } catch (Exception exception) {
/*  312 */       throw a(paramInt, "double", exception);
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
/*      */   public float getFloat(int paramInt) throws g {
/*  327 */     Object object = get(paramInt);
/*  328 */     if (object instanceof Number) {
/*  329 */       return ((Float)object).floatValue();
/*      */     }
/*      */     try {
/*  332 */       return Float.parseFloat(object.toString());
/*  333 */     } catch (Exception exception) {
/*  334 */       throw a(paramInt, "float", exception);
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
/*      */   public Number a(int paramInt) throws g {
/*  349 */     Object object = get(paramInt);
/*      */     try {
/*  351 */       if (object instanceof Number) {
/*  352 */         return (Number)object;
/*      */       }
/*  354 */       return i.c(object.toString());
/*  355 */     } catch (Exception exception) {
/*  356 */       throw a(paramInt, "number", exception);
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
/*      */   public <E extends Enum<E>> E a(Class<E> paramClass, int paramInt) throws g {
/*  375 */     E e = (E)b((Class)paramClass, paramInt);
/*  376 */     if (e == null)
/*      */     {
/*      */ 
/*      */       
/*  380 */       throw a(paramInt, "enum of type " + 
/*  381 */           i.quote(paramClass.getSimpleName()), null);
/*      */     }
/*  383 */     return e;
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
/*      */   public BigDecimal getBigDecimal(int paramInt) throws g {
/*  400 */     Object object = get(paramInt);
/*  401 */     BigDecimal bigDecimal = i.a(object, (BigDecimal)null);
/*  402 */     if (bigDecimal == null) {
/*  403 */       throw a(paramInt, "BigDecimal", object, null);
/*      */     }
/*  405 */     return bigDecimal;
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
/*      */   public BigInteger a(int paramInt) throws g {
/*  419 */     Object object = get(paramInt);
/*  420 */     BigInteger bigInteger = i.a(object, (BigInteger)null);
/*  421 */     if (bigInteger == null) {
/*  422 */       throw a(paramInt, "BigInteger", object, null);
/*      */     }
/*  424 */     return bigInteger;
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
/*      */   public int getInt(int paramInt) throws g {
/*  437 */     Object object = get(paramInt);
/*  438 */     if (object instanceof Number) {
/*  439 */       return ((Number)object).intValue();
/*      */     }
/*      */     try {
/*  442 */       return Integer.parseInt(object.toString());
/*  443 */     } catch (Exception exception) {
/*  444 */       throw a(paramInt, "int", exception);
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
/*      */   public f a(int paramInt) throws g {
/*  459 */     Object object = get(paramInt);
/*  460 */     if (object instanceof f) {
/*  461 */       return (f)object;
/*      */     }
/*  463 */     throw a(paramInt, "JSONArray", null);
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
/*      */   public i b(int paramInt) throws g {
/*  477 */     Object object = get(paramInt);
/*  478 */     if (object instanceof i) {
/*  479 */       return (i)object;
/*      */     }
/*  481 */     throw a(paramInt, "JSONObject", null);
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
/*      */   public long getLong(int paramInt) throws g {
/*  495 */     Object object = get(paramInt);
/*  496 */     if (object instanceof Number) {
/*  497 */       return ((Number)object).longValue();
/*      */     }
/*      */     try {
/*  500 */       return Long.parseLong(object.toString());
/*  501 */     } catch (Exception exception) {
/*  502 */       throw a(paramInt, "long", exception);
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
/*      */   public String getString(int paramInt) throws g {
/*  516 */     Object object = get(paramInt);
/*  517 */     if (object instanceof String) {
/*  518 */       return (String)object;
/*      */     }
/*  520 */     throw a(paramInt, "String", null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean x(int paramInt) {
/*  531 */     return i.NULL.equals(h(paramInt));
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
/*      */   public String bk(String paramString) throws g {
/*  546 */     int i = length();
/*  547 */     if (i == 0) {
/*  548 */       return "";
/*      */     }
/*      */ 
/*      */     
/*  552 */     StringBuilder stringBuilder = new StringBuilder(i.m(this.a.get(0)));
/*      */     
/*  554 */     for (byte b = 1; b < i; b++) {
/*  555 */       stringBuilder.append(paramString)
/*  556 */         .append(i.m(this.a.get(b)));
/*      */     }
/*  558 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  567 */     return this.a.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object h(int paramInt) {
/*  578 */     return (paramInt < 0 || paramInt >= length()) ? null : this.a
/*  579 */       .get(paramInt);
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
/*      */   public boolean y(int paramInt) {
/*  592 */     return a(paramInt, false);
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
/*      */   public boolean a(int paramInt, boolean paramBoolean) {
/*      */     try {
/*  608 */       return getBoolean(paramInt);
/*  609 */     } catch (Exception exception) {
/*  610 */       return paramBoolean;
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
/*      */   public double d(int paramInt) {
/*  624 */     return d(paramInt, Double.NaN);
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
/*      */   public double d(int paramInt, double paramDouble) {
/*  639 */     Number number = a(paramInt, (Number)null);
/*  640 */     if (number == null) {
/*  641 */       return paramDouble;
/*      */     }
/*  643 */     return number.doubleValue();
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
/*      */   public float b(int paramInt) {
/*  660 */     return a(paramInt, Float.NaN);
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
/*      */   public float a(int paramInt, float paramFloat) {
/*  675 */     Number number = a(paramInt, (Number)null);
/*  676 */     if (number == null) {
/*  677 */       return paramFloat;
/*      */     }
/*  679 */     return number.floatValue();
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
/*      */   public int aj(int paramInt) {
/*  696 */     return F(paramInt, 0);
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
/*      */   public int F(int paramInt1, int paramInt2) {
/*  711 */     Number number = a(paramInt1, (Number)null);
/*  712 */     if (number == null) {
/*  713 */       return paramInt2;
/*      */     }
/*  715 */     return number.intValue();
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
/*      */   public <E extends Enum<E>> E b(Class<E> paramClass, int paramInt) {
/*  730 */     return a(paramClass, paramInt, (E)null);
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
/*      */   public <E extends Enum<E>> E a(Class<E> paramClass, int paramInt, E paramE) {
/*      */     try {
/*  749 */       Object object = h(paramInt);
/*  750 */       if (i.NULL.equals(object)) {
/*  751 */         return paramE;
/*      */       }
/*  753 */       if (paramClass.isAssignableFrom(object.getClass()))
/*      */       {
/*      */         
/*  756 */         return (E)object;
/*      */       }
/*      */       
/*  759 */       return Enum.valueOf(paramClass, object.toString());
/*  760 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  761 */       return paramE;
/*  762 */     } catch (NullPointerException nullPointerException) {
/*  763 */       return paramE;
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
/*      */   public BigInteger a(int paramInt, BigInteger paramBigInteger) {
/*  779 */     Object object = h(paramInt);
/*  780 */     return i.a(object, paramBigInteger);
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
/*      */   public BigDecimal a(int paramInt, BigDecimal paramBigDecimal) {
/*  798 */     Object object = h(paramInt);
/*  799 */     return i.a(object, paramBigDecimal);
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
/*      */   public f b(int paramInt) {
/*  811 */     Object object = h(paramInt);
/*  812 */     return (object instanceof f) ? (f)object : null;
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
/*      */   public i c(int paramInt) {
/*  825 */     Object object = h(paramInt);
/*  826 */     return (object instanceof i) ? (i)object : null;
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
/*      */   public long f(int paramInt) {
/*  839 */     return c(paramInt, 0L);
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
/*      */   public long c(int paramInt, long paramLong) {
/*  854 */     Number number = a(paramInt, (Number)null);
/*  855 */     if (number == null) {
/*  856 */       return paramLong;
/*      */     }
/*  858 */     return number.longValue();
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
/*      */   public Number b(int paramInt) {
/*  872 */     return a(paramInt, (Number)null);
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
/*      */   public Number a(int paramInt, Number paramNumber) {
/*  888 */     Object object = h(paramInt);
/*  889 */     if (i.NULL.equals(object)) {
/*  890 */       return paramNumber;
/*      */     }
/*  892 */     if (object instanceof Number) {
/*  893 */       return (Number)object;
/*      */     }
/*      */     
/*  896 */     if (object instanceof String) {
/*      */       try {
/*  898 */         return i.c((String)object);
/*  899 */       } catch (Exception exception) {
/*  900 */         return paramNumber;
/*      */       } 
/*      */     }
/*  903 */     return paramNumber;
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
/*      */   public String s(int paramInt) {
/*  916 */     return i(paramInt, "");
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
/*      */   public String i(int paramInt, String paramString) {
/*  930 */     Object object = h(paramInt);
/*  931 */     return i.NULL.equals(object) ? paramString : object
/*  932 */       .toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a(boolean paramBoolean) {
/*  943 */     return a(paramBoolean ? Boolean.TRUE : Boolean.FALSE);
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
/*      */   public f a(Collection<?> paramCollection) {
/*  957 */     return a(new f(paramCollection));
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
/*      */   public f a(double paramDouble) throws g {
/*  970 */     return a(Double.valueOf(paramDouble));
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
/*      */   public f a(float paramFloat) throws g {
/*  983 */     return a(Float.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f c(int paramInt) {
/*  994 */     return a(Integer.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a(long paramLong) {
/* 1005 */     return a(Long.valueOf(paramLong));
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
/*      */   public f a(Map<?, ?> paramMap) {
/* 1021 */     return a(new i(paramMap));
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
/*      */   public f a(Object paramObject) {
/* 1036 */     i.G(paramObject);
/* 1037 */     this.a.add(paramObject);
/* 1038 */     return this;
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
/*      */   public f a(int paramInt, boolean paramBoolean) throws g {
/* 1055 */     return a(paramInt, paramBoolean ? Boolean.TRUE : Boolean.FALSE);
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
/*      */   public f a(int paramInt, Collection<?> paramCollection) throws g {
/* 1071 */     return a(paramInt, new f(paramCollection));
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
/*      */   public f a(int paramInt, double paramDouble) throws g {
/* 1088 */     return a(paramInt, Double.valueOf(paramDouble));
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
/*      */   public f a(int paramInt, float paramFloat) throws g {
/* 1105 */     return a(paramInt, Float.valueOf(paramFloat));
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
/*      */   public f b(int paramInt1, int paramInt2) throws g {
/* 1122 */     return a(paramInt1, Integer.valueOf(paramInt2));
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
/*      */   public f a(int paramInt, long paramLong) throws g {
/* 1139 */     return a(paramInt, Long.valueOf(paramLong));
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
/*      */   public f a(int paramInt, Map<?, ?> paramMap) throws g {
/* 1158 */     a(paramInt, new i(paramMap));
/* 1159 */     return this;
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
/*      */   public f a(int paramInt, Object paramObject) throws g {
/* 1179 */     if (paramInt < 0) {
/* 1180 */       throw new g("JSONArray[" + paramInt + "] not found.");
/*      */     }
/* 1182 */     if (paramInt < length()) {
/* 1183 */       i.G(paramObject);
/* 1184 */       this.a.set(paramInt, paramObject);
/* 1185 */       return this;
/*      */     } 
/* 1187 */     if (paramInt == length())
/*      */     {
/* 1189 */       return a(paramObject);
/*      */     }
/*      */ 
/*      */     
/* 1193 */     this.a.ensureCapacity(paramInt + 1);
/* 1194 */     while (paramInt != length())
/*      */     {
/* 1196 */       this.a.add(i.NULL);
/*      */     }
/* 1198 */     return a(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f b(Collection<?> paramCollection) {
/* 1209 */     a(paramCollection, false);
/* 1210 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public f a(Iterable<?> paramIterable) {
/* 1221 */     a(paramIterable, false);
/* 1222 */     return this;
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
/*      */   public f a(f paramf) {
/* 1235 */     this.a.addAll(paramf.a);
/* 1236 */     return this;
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
/*      */   public f b(Object paramObject) throws g {
/* 1253 */     a(paramObject, false);
/* 1254 */     return this;
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
/* 1277 */     return a(new j(paramString));
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
/*      */   public Object a(j paramj) {
/* 1300 */     return paramj.N(this);
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
/* 1312 */     return b(new j(paramString));
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
/* 1325 */       return paramj.N(this);
/* 1326 */     } catch (k k) {
/* 1327 */       return null;
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
/*      */   public Object remove(int paramInt) {
/* 1340 */     return (paramInt >= 0 && paramInt < length()) ? this.a
/* 1341 */       .remove(paramInt) : null;
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
/* 1353 */     if (!(paramObject instanceof f)) {
/* 1354 */       return false;
/*      */     }
/* 1356 */     int i = length();
/* 1357 */     if (i != ((f)paramObject).length()) {
/* 1358 */       return false;
/*      */     }
/* 1360 */     for (byte b = 0; b < i; b++) {
/* 1361 */       Object object1 = this.a.get(b);
/* 1362 */       Object object2 = ((f)paramObject).a.get(b);
/* 1363 */       if (object1 != object2) {
/*      */ 
/*      */         
/* 1366 */         if (object1 == null) {
/* 1367 */           return false;
/*      */         }
/* 1369 */         if (object1 instanceof i) {
/* 1370 */           if (!((i)object1).G(object2)) {
/* 1371 */             return false;
/*      */           }
/* 1373 */         } else if (object1 instanceof f) {
/* 1374 */           if (!((f)object1).G(object2)) {
/* 1375 */             return false;
/*      */           }
/* 1377 */         } else if (!object1.equals(object2)) {
/* 1378 */           return false;
/*      */         } 
/*      */       } 
/* 1381 */     }  return true;
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
/*      */   public i a(f paramf) throws g {
/* 1397 */     if (paramf == null || paramf.isEmpty() || isEmpty()) {
/* 1398 */       return null;
/*      */     }
/* 1400 */     i i = new i(paramf.length());
/* 1401 */     for (byte b = 0; b < paramf.length(); b++) {
/* 1402 */       i.c(paramf.getString(b), h(b));
/*      */     }
/* 1404 */     return i;
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
/*      */   public String toString() {
/*      */     try {
/* 1422 */       return toString(0);
/* 1423 */     } catch (Exception exception) {
/* 1424 */       return null;
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
/*      */   public String toString(int paramInt) throws g {
/* 1456 */     StringWriter stringWriter = new StringWriter();
/* 1457 */     synchronized (stringWriter.getBuffer()) {
/* 1458 */       return a(stringWriter, paramInt, 0).toString();
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
/* 1473 */     return a(paramWriter, 0, 0);
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
/*      */   public Writer a(Writer paramWriter, int paramInt1, int paramInt2) throws g {
/*      */     try {
/* 1507 */       boolean bool = false;
/* 1508 */       int i = length();
/* 1509 */       paramWriter.write(91);
/*      */       
/* 1511 */       if (i == 1) {
/*      */         try {
/* 1513 */           i.a(paramWriter, this.a.get(0), paramInt1, paramInt2);
/*      */         }
/* 1515 */         catch (Exception exception) {
/* 1516 */           throw new g("Unable to write JSONArray value at index: 0", exception);
/*      */         } 
/* 1518 */       } else if (i != 0) {
/* 1519 */         int j = paramInt2 + paramInt1;
/*      */         
/* 1521 */         for (byte b = 0; b < i; b++) {
/* 1522 */           if (bool) {
/* 1523 */             paramWriter.write(44);
/*      */           }
/* 1525 */           if (paramInt1 > 0) {
/* 1526 */             paramWriter.write(10);
/*      */           }
/* 1528 */           i.a(paramWriter, j);
/*      */           try {
/* 1530 */             i.a(paramWriter, this.a.get(b), paramInt1, j);
/*      */           }
/* 1532 */           catch (Exception exception) {
/* 1533 */             throw new g("Unable to write JSONArray value at index: " + b, exception);
/*      */           } 
/* 1535 */           bool = true;
/*      */         } 
/* 1537 */         if (paramInt1 > 0) {
/* 1538 */           paramWriter.write(10);
/*      */         }
/* 1540 */         i.a(paramWriter, paramInt2);
/*      */       } 
/* 1542 */       paramWriter.write(93);
/* 1543 */       return paramWriter;
/* 1544 */     } catch (IOException iOException) {
/* 1545 */       throw new g(iOException);
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
/*      */   public List<Object> toList() {
/* 1559 */     ArrayList<List<Object>> arrayList = new ArrayList(this.a.size());
/* 1560 */     for (f f1 : this.a) {
/* 1561 */       if (f1 == null || i.NULL.equals(f1)) {
/* 1562 */         arrayList.add(null); continue;
/* 1563 */       }  if (f1 instanceof f) {
/* 1564 */         arrayList.add(((f)f1).toList()); continue;
/* 1565 */       }  if (f1 instanceof i) {
/* 1566 */         arrayList.add(((i)f1).S()); continue;
/*      */       } 
/* 1568 */       arrayList.add(f1);
/*      */     } 
/*      */     
/* 1571 */     return (List)arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/* 1580 */     return this.a.isEmpty();
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
/*      */   private void a(Collection<?> paramCollection, boolean paramBoolean) {
/* 1594 */     this.a.ensureCapacity(this.a.size() + paramCollection.size());
/* 1595 */     if (paramBoolean) {
/* 1596 */       for (Object object : paramCollection) {
/* 1597 */         a(i.M(object));
/*      */       }
/*      */     } else {
/* 1600 */       for (Object object : paramCollection) {
/* 1601 */         a(object);
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
/*      */   private void a(Iterable<?> paramIterable, boolean paramBoolean) {
/* 1616 */     if (paramBoolean) {
/* 1617 */       for (Object object : paramIterable) {
/* 1618 */         a(i.M(object));
/*      */       }
/*      */     } else {
/* 1621 */       for (Object object : paramIterable) {
/* 1622 */         a(object);
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
/*      */   private void a(Object paramObject, boolean paramBoolean) throws g {
/* 1644 */     if (paramObject.getClass().isArray()) {
/* 1645 */       int i = Array.getLength(paramObject);
/* 1646 */       this.a.ensureCapacity(this.a.size() + i);
/* 1647 */       if (paramBoolean) {
/* 1648 */         for (byte b = 0; b < i; b++) {
/* 1649 */           a(i.M(Array.get(paramObject, b)));
/*      */         }
/*      */       } else {
/* 1652 */         for (byte b = 0; b < i; b++) {
/* 1653 */           a(Array.get(paramObject, b));
/*      */         }
/*      */       } 
/* 1656 */     } else if (paramObject instanceof f) {
/*      */ 
/*      */ 
/*      */       
/* 1660 */       this.a.addAll(((f)paramObject).a);
/* 1661 */     } else if (paramObject instanceof Collection) {
/* 1662 */       a((Collection)paramObject, paramBoolean);
/* 1663 */     } else if (paramObject instanceof Iterable) {
/* 1664 */       a((Iterable)paramObject, paramBoolean);
/*      */     } else {
/* 1666 */       throw new g("JSONArray initial value should be a string or collection or array.");
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
/*      */   private static g a(int paramInt, String paramString, Throwable paramThrowable) {
/* 1682 */     return new g("JSONArray[" + paramInt + "] is not a " + paramString + ".", paramThrowable);
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
/*      */   private static g a(int paramInt, String paramString, Object paramObject, Throwable paramThrowable) {
/* 1699 */     return new g("JSONArray[" + paramInt + "] is not a " + paramString + " (" + paramObject + ").", paramThrowable);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */