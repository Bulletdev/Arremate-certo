/*      */ package org.apache.commons.lang3.builder;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.Collection;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.WeakHashMap;
/*      */ import org.apache.commons.lang3.ClassUtils;
/*      */ import org.apache.commons.lang3.ObjectUtils;
/*      */ import org.apache.commons.lang3.StringEscapeUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class ToStringStyle
/*      */   implements Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -2587890625525655916L;
/*   84 */   public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   98 */   public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  109 */   public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  121 */   public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  131 */   public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  143 */   public static final ToStringStyle NO_CLASS_NAME_STYLE = new NoClassNameToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  162 */   public static final ToStringStyle JSON_STYLE = new JsonToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  170 */   private static final ThreadLocal<WeakHashMap<Object, Object>> REGISTRY = new ThreadLocal<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Map<Object, Object> getRegistry() {
/*  191 */     return REGISTRY.get();
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
/*      */   static boolean isRegistered(Object paramObject) {
/*  206 */     Map<Object, Object> map = getRegistry();
/*  207 */     return (map != null && map.containsKey(paramObject));
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
/*      */   static void register(Object paramObject) {
/*  220 */     if (paramObject != null) {
/*  221 */       Map<Object, Object> map = getRegistry();
/*  222 */       if (map == null) {
/*  223 */         REGISTRY.set(new WeakHashMap<>());
/*      */       }
/*  225 */       getRegistry().put(paramObject, null);
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
/*      */   static void unregister(Object paramObject) {
/*  242 */     if (paramObject != null) {
/*  243 */       Map<Object, Object> map = getRegistry();
/*  244 */       if (map != null) {
/*  245 */         map.remove(paramObject);
/*  246 */         if (map.isEmpty()) {
/*  247 */           REGISTRY.remove();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useFieldNames = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useClassName = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useShortClassName = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useIdentityHashCode = true;
/*      */ 
/*      */ 
/*      */   
/*  276 */   private String contentStart = "[";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  281 */   private String contentEnd = "]";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  286 */   private String fieldNameValueSeparator = "=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtStart = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtEnd = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  301 */   private String fieldSeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  306 */   private String arrayStart = "{";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  311 */   private String arraySeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean arrayContentDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  321 */   private String arrayEnd = "}";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean defaultFullDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  332 */   private String nullText = "<null>";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  337 */   private String sizeStartText = "<size=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  342 */   private String sizeEndText = ">";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  347 */   private String summaryObjectStartText = "<";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  352 */   private String summaryObjectEndText = ">";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendSuper(StringBuffer paramStringBuffer, String paramString) {
/*  376 */     appendToString(paramStringBuffer, paramString);
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
/*      */   public void appendToString(StringBuffer paramStringBuffer, String paramString) {
/*  390 */     if (paramString != null) {
/*  391 */       int i = paramString.indexOf(this.contentStart) + this.contentStart.length();
/*  392 */       int j = paramString.lastIndexOf(this.contentEnd);
/*  393 */       if (i != j && i >= 0 && j >= 0) {
/*  394 */         if (this.fieldSeparatorAtStart) {
/*  395 */           removeLastFieldSeparator(paramStringBuffer);
/*      */         }
/*  397 */         paramStringBuffer.append(paramString, i, j);
/*  398 */         appendFieldSeparator(paramStringBuffer);
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
/*      */   public void appendStart(StringBuffer paramStringBuffer, Object paramObject) {
/*  410 */     if (paramObject != null) {
/*  411 */       appendClassName(paramStringBuffer, paramObject);
/*  412 */       appendIdentityHashCode(paramStringBuffer, paramObject);
/*  413 */       appendContentStart(paramStringBuffer);
/*  414 */       if (this.fieldSeparatorAtStart) {
/*  415 */         appendFieldSeparator(paramStringBuffer);
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
/*      */   public void appendEnd(StringBuffer paramStringBuffer, Object paramObject) {
/*  428 */     if (!this.fieldSeparatorAtEnd) {
/*  429 */       removeLastFieldSeparator(paramStringBuffer);
/*      */     }
/*  431 */     appendContentEnd(paramStringBuffer);
/*  432 */     unregister(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeLastFieldSeparator(StringBuffer paramStringBuffer) {
/*  442 */     if (StringUtils.endsWith(paramStringBuffer, this.fieldSeparator)) {
/*  443 */       paramStringBuffer.setLength(paramStringBuffer.length() - this.fieldSeparator.length());
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, Object paramObject, Boolean paramBoolean) {
/*  461 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/*  463 */     if (paramObject == null) {
/*  464 */       appendNullText(paramStringBuffer, paramString);
/*      */     } else {
/*      */       
/*  467 */       appendInternal(paramStringBuffer, paramString, paramObject, isFullDetail(paramBoolean));
/*      */     } 
/*      */     
/*  470 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendInternal(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean) {
/*  493 */     if (isRegistered(paramObject) && !(paramObject instanceof Number) && !(paramObject instanceof Boolean) && !(paramObject instanceof Character)) {
/*      */       
/*  495 */       appendCyclicObject(paramStringBuffer, paramString, paramObject);
/*      */       
/*      */       return;
/*      */     } 
/*  499 */     register(paramObject);
/*      */     
/*      */     try {
/*  502 */       if (paramObject instanceof Collection) {
/*  503 */         if (paramBoolean) {
/*  504 */           appendDetail(paramStringBuffer, paramString, (Collection)paramObject);
/*      */         } else {
/*  506 */           appendSummarySize(paramStringBuffer, paramString, ((Collection)paramObject).size());
/*      */         }
/*      */       
/*  509 */       } else if (paramObject instanceof Map) {
/*  510 */         if (paramBoolean) {
/*  511 */           appendDetail(paramStringBuffer, paramString, (Map<?, ?>)paramObject);
/*      */         } else {
/*  513 */           appendSummarySize(paramStringBuffer, paramString, ((Map)paramObject).size());
/*      */         }
/*      */       
/*  516 */       } else if (paramObject instanceof long[]) {
/*  517 */         if (paramBoolean) {
/*  518 */           appendDetail(paramStringBuffer, paramString, (long[])paramObject);
/*      */         } else {
/*  520 */           appendSummary(paramStringBuffer, paramString, (long[])paramObject);
/*      */         }
/*      */       
/*  523 */       } else if (paramObject instanceof int[]) {
/*  524 */         if (paramBoolean) {
/*  525 */           appendDetail(paramStringBuffer, paramString, (int[])paramObject);
/*      */         } else {
/*  527 */           appendSummary(paramStringBuffer, paramString, (int[])paramObject);
/*      */         }
/*      */       
/*  530 */       } else if (paramObject instanceof short[]) {
/*  531 */         if (paramBoolean) {
/*  532 */           appendDetail(paramStringBuffer, paramString, (short[])paramObject);
/*      */         } else {
/*  534 */           appendSummary(paramStringBuffer, paramString, (short[])paramObject);
/*      */         }
/*      */       
/*  537 */       } else if (paramObject instanceof byte[]) {
/*  538 */         if (paramBoolean) {
/*  539 */           appendDetail(paramStringBuffer, paramString, (byte[])paramObject);
/*      */         } else {
/*  541 */           appendSummary(paramStringBuffer, paramString, (byte[])paramObject);
/*      */         }
/*      */       
/*  544 */       } else if (paramObject instanceof char[]) {
/*  545 */         if (paramBoolean) {
/*  546 */           appendDetail(paramStringBuffer, paramString, (char[])paramObject);
/*      */         } else {
/*  548 */           appendSummary(paramStringBuffer, paramString, (char[])paramObject);
/*      */         }
/*      */       
/*  551 */       } else if (paramObject instanceof double[]) {
/*  552 */         if (paramBoolean) {
/*  553 */           appendDetail(paramStringBuffer, paramString, (double[])paramObject);
/*      */         } else {
/*  555 */           appendSummary(paramStringBuffer, paramString, (double[])paramObject);
/*      */         }
/*      */       
/*  558 */       } else if (paramObject instanceof float[]) {
/*  559 */         if (paramBoolean) {
/*  560 */           appendDetail(paramStringBuffer, paramString, (float[])paramObject);
/*      */         } else {
/*  562 */           appendSummary(paramStringBuffer, paramString, (float[])paramObject);
/*      */         }
/*      */       
/*  565 */       } else if (paramObject instanceof boolean[]) {
/*  566 */         if (paramBoolean) {
/*  567 */           appendDetail(paramStringBuffer, paramString, (boolean[])paramObject);
/*      */         } else {
/*  569 */           appendSummary(paramStringBuffer, paramString, (boolean[])paramObject);
/*      */         }
/*      */       
/*  572 */       } else if (paramObject.getClass().isArray()) {
/*  573 */         if (paramBoolean) {
/*  574 */           appendDetail(paramStringBuffer, paramString, (Object[])paramObject);
/*      */         } else {
/*  576 */           appendSummary(paramStringBuffer, paramString, (Object[])paramObject);
/*      */         }
/*      */       
/*      */       }
/*  580 */       else if (paramBoolean) {
/*  581 */         appendDetail(paramStringBuffer, paramString, paramObject);
/*      */       } else {
/*  583 */         appendSummary(paramStringBuffer, paramString, paramObject);
/*      */       } 
/*      */     } finally {
/*      */       
/*  587 */       unregister(paramObject);
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
/*      */   protected void appendCyclicObject(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  604 */     ObjectUtils.identityToString(paramStringBuffer, paramObject);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  617 */     paramStringBuffer.append(paramObject);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Collection<?> paramCollection) {
/*  629 */     if (paramCollection != null && !paramCollection.isEmpty()) {
/*  630 */       paramStringBuffer.append(this.arrayStart);
/*  631 */       byte b = 0;
/*  632 */       for (Object object : paramCollection) {
/*  633 */         appendDetail(paramStringBuffer, paramString, b++, object);
/*      */       }
/*  635 */       paramStringBuffer.append(this.arrayEnd);
/*      */       
/*      */       return;
/*      */     } 
/*  639 */     paramStringBuffer.append(paramCollection);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Map<?, ?> paramMap) {
/*  651 */     paramStringBuffer.append(paramMap);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  664 */     paramStringBuffer.append(this.summaryObjectStartText);
/*  665 */     paramStringBuffer.append(getShortClassName(paramObject.getClass()));
/*  666 */     paramStringBuffer.append(this.summaryObjectEndText);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, long paramLong) {
/*  680 */     appendFieldStart(paramStringBuffer, paramString);
/*  681 */     appendDetail(paramStringBuffer, paramString, paramLong);
/*  682 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, long paramLong) {
/*  694 */     paramStringBuffer.append(paramLong);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, int paramInt) {
/*  708 */     appendFieldStart(paramStringBuffer, paramString);
/*  709 */     appendDetail(paramStringBuffer, paramString, paramInt);
/*  710 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, int paramInt) {
/*  722 */     paramStringBuffer.append(paramInt);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, short paramShort) {
/*  736 */     appendFieldStart(paramStringBuffer, paramString);
/*  737 */     appendDetail(paramStringBuffer, paramString, paramShort);
/*  738 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, short paramShort) {
/*  750 */     paramStringBuffer.append(paramShort);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, byte paramByte) {
/*  764 */     appendFieldStart(paramStringBuffer, paramString);
/*  765 */     appendDetail(paramStringBuffer, paramString, paramByte);
/*  766 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, byte paramByte) {
/*  778 */     paramStringBuffer.append(paramByte);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, char paramChar) {
/*  792 */     appendFieldStart(paramStringBuffer, paramString);
/*  793 */     appendDetail(paramStringBuffer, paramString, paramChar);
/*  794 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, char paramChar) {
/*  806 */     paramStringBuffer.append(paramChar);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, double paramDouble) {
/*  820 */     appendFieldStart(paramStringBuffer, paramString);
/*  821 */     appendDetail(paramStringBuffer, paramString, paramDouble);
/*  822 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, double paramDouble) {
/*  834 */     paramStringBuffer.append(paramDouble);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, float paramFloat) {
/*  848 */     appendFieldStart(paramStringBuffer, paramString);
/*  849 */     appendDetail(paramStringBuffer, paramString, paramFloat);
/*  850 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, float paramFloat) {
/*  862 */     paramStringBuffer.append(paramFloat);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean) {
/*  876 */     appendFieldStart(paramStringBuffer, paramString);
/*  877 */     appendDetail(paramStringBuffer, paramString, paramBoolean);
/*  878 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean) {
/*  890 */     paramStringBuffer.append(paramBoolean);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject, Boolean paramBoolean) {
/*  904 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/*  906 */     if (paramArrayOfObject == null) {
/*  907 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/*  909 */     else if (isFullDetail(paramBoolean)) {
/*  910 */       appendDetail(paramStringBuffer, paramString, paramArrayOfObject);
/*      */     } else {
/*      */       
/*  913 */       appendSummary(paramStringBuffer, paramString, paramArrayOfObject);
/*      */     } 
/*      */     
/*  916 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject) {
/*  931 */     paramStringBuffer.append(this.arrayStart);
/*  932 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*  933 */       Object object = paramArrayOfObject[b];
/*  934 */       appendDetail(paramStringBuffer, paramString, b, object);
/*      */     } 
/*  936 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, int paramInt, Object paramObject) {
/*  950 */     if (paramInt > 0) {
/*  951 */       paramStringBuffer.append(this.arraySeparator);
/*      */     }
/*  953 */     if (paramObject == null) {
/*  954 */       appendNullText(paramStringBuffer, paramString);
/*      */     } else {
/*  956 */       appendInternal(paramStringBuffer, paramString, paramObject, this.arrayContentDetail);
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
/*      */   protected void reflectionAppendArrayDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  970 */     paramStringBuffer.append(this.arrayStart);
/*  971 */     int i = Array.getLength(paramObject);
/*  972 */     for (byte b = 0; b < i; b++) {
/*  973 */       Object object = Array.get(paramObject, b);
/*  974 */       appendDetail(paramStringBuffer, paramString, b, object);
/*      */     } 
/*  976 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject) {
/*  989 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfObject.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOflong, Boolean paramBoolean) {
/* 1005 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1007 */     if (paramArrayOflong == null) {
/* 1008 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1010 */     else if (isFullDetail(paramBoolean)) {
/* 1011 */       appendDetail(paramStringBuffer, paramString, paramArrayOflong);
/*      */     } else {
/*      */       
/* 1014 */       appendSummary(paramStringBuffer, paramString, paramArrayOflong);
/*      */     } 
/*      */     
/* 1017 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOflong) {
/* 1030 */     paramStringBuffer.append(this.arrayStart);
/* 1031 */     for (byte b = 0; b < paramArrayOflong.length; b++) {
/* 1032 */       if (b > 0) {
/* 1033 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1035 */       appendDetail(paramStringBuffer, paramString, paramArrayOflong[b]);
/*      */     } 
/* 1037 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOflong) {
/* 1050 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOflong.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfint, Boolean paramBoolean) {
/* 1066 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1068 */     if (paramArrayOfint == null) {
/* 1069 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1071 */     else if (isFullDetail(paramBoolean)) {
/* 1072 */       appendDetail(paramStringBuffer, paramString, paramArrayOfint);
/*      */     } else {
/*      */       
/* 1075 */       appendSummary(paramStringBuffer, paramString, paramArrayOfint);
/*      */     } 
/*      */     
/* 1078 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfint) {
/* 1091 */     paramStringBuffer.append(this.arrayStart);
/* 1092 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 1093 */       if (b > 0) {
/* 1094 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1096 */       appendDetail(paramStringBuffer, paramString, paramArrayOfint[b]);
/*      */     } 
/* 1098 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfint) {
/* 1111 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfint.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfshort, Boolean paramBoolean) {
/* 1127 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1129 */     if (paramArrayOfshort == null) {
/* 1130 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1132 */     else if (isFullDetail(paramBoolean)) {
/* 1133 */       appendDetail(paramStringBuffer, paramString, paramArrayOfshort);
/*      */     } else {
/*      */       
/* 1136 */       appendSummary(paramStringBuffer, paramString, paramArrayOfshort);
/*      */     } 
/*      */     
/* 1139 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfshort) {
/* 1152 */     paramStringBuffer.append(this.arrayStart);
/* 1153 */     for (byte b = 0; b < paramArrayOfshort.length; b++) {
/* 1154 */       if (b > 0) {
/* 1155 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1157 */       appendDetail(paramStringBuffer, paramString, paramArrayOfshort[b]);
/*      */     } 
/* 1159 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfshort) {
/* 1172 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfshort.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfbyte, Boolean paramBoolean) {
/* 1188 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1190 */     if (paramArrayOfbyte == null) {
/* 1191 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1193 */     else if (isFullDetail(paramBoolean)) {
/* 1194 */       appendDetail(paramStringBuffer, paramString, paramArrayOfbyte);
/*      */     } else {
/*      */       
/* 1197 */       appendSummary(paramStringBuffer, paramString, paramArrayOfbyte);
/*      */     } 
/*      */     
/* 1200 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfbyte) {
/* 1213 */     paramStringBuffer.append(this.arrayStart);
/* 1214 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 1215 */       if (b > 0) {
/* 1216 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1218 */       appendDetail(paramStringBuffer, paramString, paramArrayOfbyte[b]);
/*      */     } 
/* 1220 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfbyte) {
/* 1233 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfbyte.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfchar, Boolean paramBoolean) {
/* 1249 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1251 */     if (paramArrayOfchar == null) {
/* 1252 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1254 */     else if (isFullDetail(paramBoolean)) {
/* 1255 */       appendDetail(paramStringBuffer, paramString, paramArrayOfchar);
/*      */     } else {
/*      */       
/* 1258 */       appendSummary(paramStringBuffer, paramString, paramArrayOfchar);
/*      */     } 
/*      */     
/* 1261 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfchar) {
/* 1274 */     paramStringBuffer.append(this.arrayStart);
/* 1275 */     for (byte b = 0; b < paramArrayOfchar.length; b++) {
/* 1276 */       if (b > 0) {
/* 1277 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1279 */       appendDetail(paramStringBuffer, paramString, paramArrayOfchar[b]);
/*      */     } 
/* 1281 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfchar) {
/* 1294 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfchar.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfdouble, Boolean paramBoolean) {
/* 1310 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1312 */     if (paramArrayOfdouble == null) {
/* 1313 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1315 */     else if (isFullDetail(paramBoolean)) {
/* 1316 */       appendDetail(paramStringBuffer, paramString, paramArrayOfdouble);
/*      */     } else {
/*      */       
/* 1319 */       appendSummary(paramStringBuffer, paramString, paramArrayOfdouble);
/*      */     } 
/*      */     
/* 1322 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfdouble) {
/* 1335 */     paramStringBuffer.append(this.arrayStart);
/* 1336 */     for (byte b = 0; b < paramArrayOfdouble.length; b++) {
/* 1337 */       if (b > 0) {
/* 1338 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1340 */       appendDetail(paramStringBuffer, paramString, paramArrayOfdouble[b]);
/*      */     } 
/* 1342 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfdouble) {
/* 1355 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfdouble.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOffloat, Boolean paramBoolean) {
/* 1371 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1373 */     if (paramArrayOffloat == null) {
/* 1374 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1376 */     else if (isFullDetail(paramBoolean)) {
/* 1377 */       appendDetail(paramStringBuffer, paramString, paramArrayOffloat);
/*      */     } else {
/*      */       
/* 1380 */       appendSummary(paramStringBuffer, paramString, paramArrayOffloat);
/*      */     } 
/*      */     
/* 1383 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOffloat) {
/* 1396 */     paramStringBuffer.append(this.arrayStart);
/* 1397 */     for (byte b = 0; b < paramArrayOffloat.length; b++) {
/* 1398 */       if (b > 0) {
/* 1399 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1401 */       appendDetail(paramStringBuffer, paramString, paramArrayOffloat[b]);
/*      */     } 
/* 1403 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOffloat) {
/* 1416 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOffloat.length);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfboolean, Boolean paramBoolean) {
/* 1432 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1434 */     if (paramArrayOfboolean == null) {
/* 1435 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1437 */     else if (isFullDetail(paramBoolean)) {
/* 1438 */       appendDetail(paramStringBuffer, paramString, paramArrayOfboolean);
/*      */     } else {
/*      */       
/* 1441 */       appendSummary(paramStringBuffer, paramString, paramArrayOfboolean);
/*      */     } 
/*      */     
/* 1444 */     appendFieldEnd(paramStringBuffer, paramString);
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
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfboolean) {
/* 1457 */     paramStringBuffer.append(this.arrayStart);
/* 1458 */     for (byte b = 0; b < paramArrayOfboolean.length; b++) {
/* 1459 */       if (b > 0) {
/* 1460 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1462 */       appendDetail(paramStringBuffer, paramString, paramArrayOfboolean[b]);
/*      */     } 
/* 1464 */     paramStringBuffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfboolean) {
/* 1477 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfboolean.length);
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
/*      */   protected void appendClassName(StringBuffer paramStringBuffer, Object paramObject) {
/* 1489 */     if (this.useClassName && paramObject != null) {
/* 1490 */       register(paramObject);
/* 1491 */       if (this.useShortClassName) {
/* 1492 */         paramStringBuffer.append(getShortClassName(paramObject.getClass()));
/*      */       } else {
/* 1494 */         paramStringBuffer.append(paramObject.getClass().getName());
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
/*      */   protected void appendIdentityHashCode(StringBuffer paramStringBuffer, Object paramObject) {
/* 1506 */     if (isUseIdentityHashCode() && paramObject != null) {
/* 1507 */       register(paramObject);
/* 1508 */       paramStringBuffer.append('@');
/* 1509 */       paramStringBuffer.append(Integer.toHexString(System.identityHashCode(paramObject)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentStart(StringBuffer paramStringBuffer) {
/* 1519 */     paramStringBuffer.append(this.contentStart);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentEnd(StringBuffer paramStringBuffer) {
/* 1528 */     paramStringBuffer.append(this.contentEnd);
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
/*      */   protected void appendNullText(StringBuffer paramStringBuffer, String paramString) {
/* 1540 */     paramStringBuffer.append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldSeparator(StringBuffer paramStringBuffer) {
/* 1549 */     paramStringBuffer.append(this.fieldSeparator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldStart(StringBuffer paramStringBuffer, String paramString) {
/* 1559 */     if (this.useFieldNames && paramString != null) {
/* 1560 */       paramStringBuffer.append(paramString);
/* 1561 */       paramStringBuffer.append(this.fieldNameValueSeparator);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldEnd(StringBuffer paramStringBuffer, String paramString) {
/* 1572 */     appendFieldSeparator(paramStringBuffer);
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
/*      */   protected void appendSummarySize(StringBuffer paramStringBuffer, String paramString, int paramInt) {
/* 1591 */     paramStringBuffer.append(this.sizeStartText);
/* 1592 */     paramStringBuffer.append(paramInt);
/* 1593 */     paramStringBuffer.append(this.sizeEndText);
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
/*      */   protected boolean isFullDetail(Boolean paramBoolean) {
/* 1611 */     if (paramBoolean == null) {
/* 1612 */       return this.defaultFullDetail;
/*      */     }
/* 1614 */     return paramBoolean.booleanValue();
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
/*      */   protected String getShortClassName(Class<?> paramClass) {
/* 1627 */     return ClassUtils.getShortClassName(paramClass);
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
/*      */   protected boolean isUseClassName() {
/* 1641 */     return this.useClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseClassName(boolean paramBoolean) {
/* 1650 */     this.useClassName = paramBoolean;
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
/*      */   protected boolean isUseShortClassName() {
/* 1662 */     return this.useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseShortClassName(boolean paramBoolean) {
/* 1672 */     this.useShortClassName = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseIdentityHashCode() {
/* 1683 */     return this.useIdentityHashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseIdentityHashCode(boolean paramBoolean) {
/* 1692 */     this.useIdentityHashCode = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseFieldNames() {
/* 1703 */     return this.useFieldNames;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseFieldNames(boolean paramBoolean) {
/* 1712 */     this.useFieldNames = paramBoolean;
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
/*      */   protected boolean isDefaultFullDetail() {
/* 1724 */     return this.defaultFullDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setDefaultFullDetail(boolean paramBoolean) {
/* 1734 */     this.defaultFullDetail = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isArrayContentDetail() {
/* 1745 */     return this.arrayContentDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setArrayContentDetail(boolean paramBoolean) {
/* 1754 */     this.arrayContentDetail = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayStart() {
/* 1765 */     return this.arrayStart;
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
/*      */   protected void setArrayStart(String paramString) {
/* 1777 */     if (paramString == null) {
/* 1778 */       paramString = "";
/*      */     }
/* 1780 */     this.arrayStart = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayEnd() {
/* 1791 */     return this.arrayEnd;
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
/*      */   protected void setArrayEnd(String paramString) {
/* 1803 */     if (paramString == null) {
/* 1804 */       paramString = "";
/*      */     }
/* 1806 */     this.arrayEnd = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArraySeparator() {
/* 1817 */     return this.arraySeparator;
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
/*      */   protected void setArraySeparator(String paramString) {
/* 1829 */     if (paramString == null) {
/* 1830 */       paramString = "";
/*      */     }
/* 1832 */     this.arraySeparator = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentStart() {
/* 1843 */     return this.contentStart;
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
/*      */   protected void setContentStart(String paramString) {
/* 1855 */     if (paramString == null) {
/* 1856 */       paramString = "";
/*      */     }
/* 1858 */     this.contentStart = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentEnd() {
/* 1869 */     return this.contentEnd;
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
/*      */   protected void setContentEnd(String paramString) {
/* 1881 */     if (paramString == null) {
/* 1882 */       paramString = "";
/*      */     }
/* 1884 */     this.contentEnd = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldNameValueSeparator() {
/* 1895 */     return this.fieldNameValueSeparator;
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
/*      */   protected void setFieldNameValueSeparator(String paramString) {
/* 1907 */     if (paramString == null) {
/* 1908 */       paramString = "";
/*      */     }
/* 1910 */     this.fieldNameValueSeparator = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldSeparator() {
/* 1921 */     return this.fieldSeparator;
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
/*      */   protected void setFieldSeparator(String paramString) {
/* 1933 */     if (paramString == null) {
/* 1934 */       paramString = "";
/*      */     }
/* 1936 */     this.fieldSeparator = paramString;
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
/*      */   protected boolean isFieldSeparatorAtStart() {
/* 1949 */     return this.fieldSeparatorAtStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtStart(boolean paramBoolean) {
/* 1960 */     this.fieldSeparatorAtStart = paramBoolean;
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
/*      */   protected boolean isFieldSeparatorAtEnd() {
/* 1973 */     return this.fieldSeparatorAtEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtEnd(boolean paramBoolean) {
/* 1984 */     this.fieldSeparatorAtEnd = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getNullText() {
/* 1995 */     return this.nullText;
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
/*      */   protected void setNullText(String paramString) {
/* 2007 */     if (paramString == null) {
/* 2008 */       paramString = "";
/*      */     }
/* 2010 */     this.nullText = paramString;
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
/*      */   protected String getSizeStartText() {
/* 2024 */     return this.sizeStartText;
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
/*      */   protected void setSizeStartText(String paramString) {
/* 2039 */     if (paramString == null) {
/* 2040 */       paramString = "";
/*      */     }
/* 2042 */     this.sizeStartText = paramString;
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
/*      */   protected String getSizeEndText() {
/* 2056 */     return this.sizeEndText;
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
/*      */   protected void setSizeEndText(String paramString) {
/* 2071 */     if (paramString == null) {
/* 2072 */       paramString = "";
/*      */     }
/* 2074 */     this.sizeEndText = paramString;
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
/*      */   protected String getSummaryObjectStartText() {
/* 2088 */     return this.summaryObjectStartText;
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
/*      */   protected void setSummaryObjectStartText(String paramString) {
/* 2103 */     if (paramString == null) {
/* 2104 */       paramString = "";
/*      */     }
/* 2106 */     this.summaryObjectStartText = paramString;
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
/*      */   protected String getSummaryObjectEndText() {
/* 2120 */     return this.summaryObjectEndText;
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
/*      */   protected void setSummaryObjectEndText(String paramString) {
/* 2135 */     if (paramString == null) {
/* 2136 */       paramString = "";
/*      */     }
/* 2138 */     this.summaryObjectEndText = paramString;
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
/*      */   private static final class DefaultToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2173 */       return DEFAULT_STYLE;
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
/*      */   private static final class NoFieldNameToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     NoFieldNameToStringStyle() {
/* 2198 */       setUseFieldNames(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2207 */       return NO_FIELD_NAMES_STYLE;
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
/*      */   private static final class ShortPrefixToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ShortPrefixToStringStyle() {
/* 2232 */       setUseShortClassName(true);
/* 2233 */       setUseIdentityHashCode(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2241 */       return SHORT_PREFIX_STYLE;
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
/*      */   private static final class SimpleToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     SimpleToStringStyle() {
/* 2266 */       setUseClassName(false);
/* 2267 */       setUseIdentityHashCode(false);
/* 2268 */       setUseFieldNames(false);
/* 2269 */       setContentStart("");
/* 2270 */       setContentEnd("");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2278 */       return SIMPLE_STYLE;
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
/*      */   private static final class MultiLineToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MultiLineToStringStyle() {
/* 2302 */       setContentStart("[");
/* 2303 */       setFieldSeparator(System.lineSeparator() + "  ");
/* 2304 */       setFieldSeparatorAtStart(true);
/* 2305 */       setContentEnd(System.lineSeparator() + "]");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2314 */       return MULTI_LINE_STYLE;
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
/*      */   private static final class NoClassNameToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     NoClassNameToStringStyle() {
/* 2339 */       setUseClassName(false);
/* 2340 */       setUseIdentityHashCode(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2349 */       return NO_CLASS_NAME_STYLE;
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
/*      */   private static final class JsonToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String FIELD_NAME_QUOTE = "\"";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     JsonToStringStyle() {
/* 2387 */       setUseClassName(false);
/* 2388 */       setUseIdentityHashCode(false);
/*      */       
/* 2390 */       setContentStart("{");
/* 2391 */       setContentEnd("}");
/*      */       
/* 2393 */       setArrayStart("[");
/* 2394 */       setArrayEnd("]");
/*      */       
/* 2396 */       setFieldSeparator(",");
/* 2397 */       setFieldNameValueSeparator(":");
/*      */       
/* 2399 */       setNullText("null");
/*      */       
/* 2401 */       setSummaryObjectStartText("\"<");
/* 2402 */       setSummaryObjectEndText(">\"");
/*      */       
/* 2404 */       setSizeStartText("\"<size=");
/* 2405 */       setSizeEndText(">\"");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, Object[] param1ArrayOfObject, Boolean param1Boolean) {
/* 2412 */       if (param1String == null) {
/* 2413 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2416 */       if (!isFullDetail(param1Boolean)) {
/* 2417 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2421 */       super.append(param1StringBuffer, param1String, param1ArrayOfObject, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, long[] param1ArrayOflong, Boolean param1Boolean) {
/* 2428 */       if (param1String == null) {
/* 2429 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2432 */       if (!isFullDetail(param1Boolean)) {
/* 2433 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2437 */       super.append(param1StringBuffer, param1String, param1ArrayOflong, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, int[] param1ArrayOfint, Boolean param1Boolean) {
/* 2444 */       if (param1String == null) {
/* 2445 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2448 */       if (!isFullDetail(param1Boolean)) {
/* 2449 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2453 */       super.append(param1StringBuffer, param1String, param1ArrayOfint, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, short[] param1ArrayOfshort, Boolean param1Boolean) {
/* 2460 */       if (param1String == null) {
/* 2461 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2464 */       if (!isFullDetail(param1Boolean)) {
/* 2465 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2469 */       super.append(param1StringBuffer, param1String, param1ArrayOfshort, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, byte[] param1ArrayOfbyte, Boolean param1Boolean) {
/* 2476 */       if (param1String == null) {
/* 2477 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2480 */       if (!isFullDetail(param1Boolean)) {
/* 2481 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2485 */       super.append(param1StringBuffer, param1String, param1ArrayOfbyte, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, char[] param1ArrayOfchar, Boolean param1Boolean) {
/* 2492 */       if (param1String == null) {
/* 2493 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2496 */       if (!isFullDetail(param1Boolean)) {
/* 2497 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2501 */       super.append(param1StringBuffer, param1String, param1ArrayOfchar, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, double[] param1ArrayOfdouble, Boolean param1Boolean) {
/* 2508 */       if (param1String == null) {
/* 2509 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2512 */       if (!isFullDetail(param1Boolean)) {
/* 2513 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2517 */       super.append(param1StringBuffer, param1String, param1ArrayOfdouble, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, float[] param1ArrayOffloat, Boolean param1Boolean) {
/* 2524 */       if (param1String == null) {
/* 2525 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2528 */       if (!isFullDetail(param1Boolean)) {
/* 2529 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2533 */       super.append(param1StringBuffer, param1String, param1ArrayOffloat, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, boolean[] param1ArrayOfboolean, Boolean param1Boolean) {
/* 2540 */       if (param1String == null) {
/* 2541 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2544 */       if (!isFullDetail(param1Boolean)) {
/* 2545 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2549 */       super.append(param1StringBuffer, param1String, param1ArrayOfboolean, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer param1StringBuffer, String param1String, Object param1Object, Boolean param1Boolean) {
/* 2556 */       if (param1String == null) {
/* 2557 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2560 */       if (!isFullDetail(param1Boolean)) {
/* 2561 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2565 */       super.append(param1StringBuffer, param1String, param1Object, param1Boolean);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void appendDetail(StringBuffer param1StringBuffer, String param1String, char param1Char) {
/* 2570 */       appendValueAsString(param1StringBuffer, String.valueOf(param1Char));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void appendDetail(StringBuffer param1StringBuffer, String param1String, Object param1Object) {
/* 2576 */       if (param1Object == null) {
/* 2577 */         appendNullText(param1StringBuffer, param1String);
/*      */         
/*      */         return;
/*      */       } 
/* 2581 */       if (param1Object instanceof String || param1Object instanceof Character) {
/* 2582 */         appendValueAsString(param1StringBuffer, param1Object.toString());
/*      */         
/*      */         return;
/*      */       } 
/* 2586 */       if (param1Object instanceof Number || param1Object instanceof Boolean) {
/* 2587 */         param1StringBuffer.append(param1Object);
/*      */         
/*      */         return;
/*      */       } 
/* 2591 */       String str = param1Object.toString();
/* 2592 */       if (isJsonObject(str) || isJsonArray(str)) {
/* 2593 */         param1StringBuffer.append(param1Object);
/*      */         
/*      */         return;
/*      */       } 
/* 2597 */       appendDetail(param1StringBuffer, param1String, str);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void appendDetail(StringBuffer param1StringBuffer, String param1String, Map<?, ?> param1Map) {
/* 2602 */       if (param1Map != null && !param1Map.isEmpty()) {
/* 2603 */         param1StringBuffer.append(getContentStart());
/*      */         
/* 2605 */         boolean bool = true;
/* 2606 */         for (Map.Entry<?, ?> entry : param1Map.entrySet()) {
/* 2607 */           String str = Objects.toString(entry.getKey(), null);
/* 2608 */           if (str != null) {
/* 2609 */             if (bool) {
/* 2610 */               bool = false;
/*      */             } else {
/* 2612 */               appendFieldEnd(param1StringBuffer, str);
/*      */             } 
/* 2614 */             appendFieldStart(param1StringBuffer, str);
/* 2615 */             Object object = entry.getValue();
/* 2616 */             if (object == null) {
/* 2617 */               appendNullText(param1StringBuffer, str); continue;
/*      */             } 
/* 2619 */             appendInternal(param1StringBuffer, str, object, true);
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2624 */         param1StringBuffer.append(getContentEnd());
/*      */         
/*      */         return;
/*      */       } 
/* 2628 */       param1StringBuffer.append(param1Map);
/*      */     }
/*      */     
/*      */     private boolean isJsonArray(String param1String) {
/* 2632 */       return (param1String.startsWith(getArrayStart()) && param1String
/* 2633 */         .endsWith(getArrayEnd()));
/*      */     }
/*      */     
/*      */     private boolean isJsonObject(String param1String) {
/* 2637 */       return (param1String.startsWith(getContentStart()) && param1String
/* 2638 */         .endsWith(getContentEnd()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void appendValueAsString(StringBuffer param1StringBuffer, String param1String) {
/* 2648 */       param1StringBuffer.append('"').append(StringEscapeUtils.escapeJson(param1String)).append('"');
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void appendFieldStart(StringBuffer param1StringBuffer, String param1String) {
/* 2654 */       if (param1String == null) {
/* 2655 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2659 */       super.appendFieldStart(param1StringBuffer, "\"" + StringEscapeUtils.escapeJson(param1String) + "\"");
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
/*      */     private Object readResolve() {
/* 2671 */       return JSON_STYLE;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\ToStringStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */