/*      */ package org.apache.commons.lang3.builder;
/*      */ 
/*      */ import org.apache.commons.lang3.ObjectUtils;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ToStringBuilder
/*      */   implements Builder<String>
/*      */ {
/*   94 */   private static volatile ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final StringBuffer buffer;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Object object;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final ToStringStyle style;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ToStringStyle getDefaultStyle() {
/*  117 */     return defaultStyle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setDefaultStyle(ToStringStyle paramToStringStyle) {
/*  136 */     defaultStyle = (ToStringStyle)Validate.notNull(paramToStringStyle, "The style must not be null", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object paramObject) {
/*  149 */     return ReflectionToStringBuilder.toString(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object paramObject, ToStringStyle paramToStringStyle) {
/*  162 */     return ReflectionToStringBuilder.toString(paramObject, paramToStringStyle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean) {
/*  176 */     return ReflectionToStringBuilder.toString(paramObject, paramToStringStyle, paramBoolean, false, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> String reflectionToString(T paramT, ToStringStyle paramToStringStyle, boolean paramBoolean, Class<? super T> paramClass) {
/*  197 */     return ReflectionToStringBuilder.toString(paramT, paramToStringStyle, paramBoolean, false, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder(Object paramObject) {
/*  223 */     this(paramObject, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle) {
/*  235 */     this(paramObject, paramToStringStyle, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer) {
/*  250 */     if (paramToStringStyle == null) {
/*  251 */       paramToStringStyle = getDefaultStyle();
/*      */     }
/*  253 */     if (paramStringBuffer == null) {
/*  254 */       paramStringBuffer = new StringBuffer(512);
/*      */     }
/*  256 */     this.buffer = paramStringBuffer;
/*  257 */     this.style = paramToStringStyle;
/*  258 */     this.object = paramObject;
/*      */     
/*  260 */     paramToStringStyle.appendStart(paramStringBuffer, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(boolean paramBoolean) {
/*  273 */     this.style.append(this.buffer, (String)null, paramBoolean);
/*  274 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(boolean[] paramArrayOfboolean) {
/*  287 */     this.style.append(this.buffer, (String)null, paramArrayOfboolean, (Boolean)null);
/*  288 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(byte paramByte) {
/*  301 */     this.style.append(this.buffer, (String)null, paramByte);
/*  302 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(byte[] paramArrayOfbyte) {
/*  315 */     this.style.append(this.buffer, (String)null, paramArrayOfbyte, (Boolean)null);
/*  316 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(char paramChar) {
/*  329 */     this.style.append(this.buffer, (String)null, paramChar);
/*  330 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(char[] paramArrayOfchar) {
/*  343 */     this.style.append(this.buffer, (String)null, paramArrayOfchar, (Boolean)null);
/*  344 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(double paramDouble) {
/*  357 */     this.style.append(this.buffer, (String)null, paramDouble);
/*  358 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(double[] paramArrayOfdouble) {
/*  371 */     this.style.append(this.buffer, (String)null, paramArrayOfdouble, (Boolean)null);
/*  372 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(float paramFloat) {
/*  385 */     this.style.append(this.buffer, (String)null, paramFloat);
/*  386 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(float[] paramArrayOffloat) {
/*  399 */     this.style.append(this.buffer, (String)null, paramArrayOffloat, (Boolean)null);
/*  400 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(int paramInt) {
/*  413 */     this.style.append(this.buffer, (String)null, paramInt);
/*  414 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(int[] paramArrayOfint) {
/*  427 */     this.style.append(this.buffer, (String)null, paramArrayOfint, (Boolean)null);
/*  428 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(long paramLong) {
/*  441 */     this.style.append(this.buffer, (String)null, paramLong);
/*  442 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(long[] paramArrayOflong) {
/*  455 */     this.style.append(this.buffer, (String)null, paramArrayOflong, (Boolean)null);
/*  456 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(Object paramObject) {
/*  469 */     this.style.append(this.buffer, (String)null, paramObject, (Boolean)null);
/*  470 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(Object[] paramArrayOfObject) {
/*  483 */     this.style.append(this.buffer, (String)null, paramArrayOfObject, (Boolean)null);
/*  484 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(short paramShort) {
/*  497 */     this.style.append(this.buffer, (String)null, paramShort);
/*  498 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(short[] paramArrayOfshort) {
/*  511 */     this.style.append(this.buffer, (String)null, paramArrayOfshort, (Boolean)null);
/*  512 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, boolean paramBoolean) {
/*  524 */     this.style.append(this.buffer, paramString, paramBoolean);
/*  525 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, boolean[] paramArrayOfboolean) {
/*  537 */     this.style.append(this.buffer, paramString, paramArrayOfboolean, (Boolean)null);
/*  538 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, boolean[] paramArrayOfboolean, boolean paramBoolean) {
/*  557 */     this.style.append(this.buffer, paramString, paramArrayOfboolean, Boolean.valueOf(paramBoolean));
/*  558 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, byte paramByte) {
/*  570 */     this.style.append(this.buffer, paramString, paramByte);
/*  571 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, byte[] paramArrayOfbyte) {
/*  582 */     this.style.append(this.buffer, paramString, paramArrayOfbyte, (Boolean)null);
/*  583 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, byte[] paramArrayOfbyte, boolean paramBoolean) {
/*  602 */     this.style.append(this.buffer, paramString, paramArrayOfbyte, Boolean.valueOf(paramBoolean));
/*  603 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, char paramChar) {
/*  615 */     this.style.append(this.buffer, paramString, paramChar);
/*  616 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, char[] paramArrayOfchar) {
/*  628 */     this.style.append(this.buffer, paramString, paramArrayOfchar, (Boolean)null);
/*  629 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, char[] paramArrayOfchar, boolean paramBoolean) {
/*  648 */     this.style.append(this.buffer, paramString, paramArrayOfchar, Boolean.valueOf(paramBoolean));
/*  649 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, double paramDouble) {
/*  661 */     this.style.append(this.buffer, paramString, paramDouble);
/*  662 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, double[] paramArrayOfdouble) {
/*  674 */     this.style.append(this.buffer, paramString, paramArrayOfdouble, (Boolean)null);
/*  675 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, double[] paramArrayOfdouble, boolean paramBoolean) {
/*  694 */     this.style.append(this.buffer, paramString, paramArrayOfdouble, Boolean.valueOf(paramBoolean));
/*  695 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, float paramFloat) {
/*  707 */     this.style.append(this.buffer, paramString, paramFloat);
/*  708 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, float[] paramArrayOffloat) {
/*  720 */     this.style.append(this.buffer, paramString, paramArrayOffloat, (Boolean)null);
/*  721 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, float[] paramArrayOffloat, boolean paramBoolean) {
/*  740 */     this.style.append(this.buffer, paramString, paramArrayOffloat, Boolean.valueOf(paramBoolean));
/*  741 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, int paramInt) {
/*  753 */     this.style.append(this.buffer, paramString, paramInt);
/*  754 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, int[] paramArrayOfint) {
/*  766 */     this.style.append(this.buffer, paramString, paramArrayOfint, (Boolean)null);
/*  767 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, int[] paramArrayOfint, boolean paramBoolean) {
/*  786 */     this.style.append(this.buffer, paramString, paramArrayOfint, Boolean.valueOf(paramBoolean));
/*  787 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, long paramLong) {
/*  799 */     this.style.append(this.buffer, paramString, paramLong);
/*  800 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, long[] paramArrayOflong) {
/*  812 */     this.style.append(this.buffer, paramString, paramArrayOflong, (Boolean)null);
/*  813 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, long[] paramArrayOflong, boolean paramBoolean) {
/*  832 */     this.style.append(this.buffer, paramString, paramArrayOflong, Boolean.valueOf(paramBoolean));
/*  833 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object paramObject) {
/*  845 */     this.style.append(this.buffer, paramString, paramObject, (Boolean)null);
/*  846 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object paramObject, boolean paramBoolean) {
/*  860 */     this.style.append(this.buffer, paramString, paramObject, Boolean.valueOf(paramBoolean));
/*  861 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object[] paramArrayOfObject) {
/*  873 */     this.style.append(this.buffer, paramString, paramArrayOfObject, (Boolean)null);
/*  874 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object[] paramArrayOfObject, boolean paramBoolean) {
/*  893 */     this.style.append(this.buffer, paramString, paramArrayOfObject, Boolean.valueOf(paramBoolean));
/*  894 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, short paramShort) {
/*  906 */     this.style.append(this.buffer, paramString, paramShort);
/*  907 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, short[] paramArrayOfshort) {
/*  919 */     this.style.append(this.buffer, paramString, paramArrayOfshort, (Boolean)null);
/*  920 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, short[] paramArrayOfshort, boolean paramBoolean) {
/*  939 */     this.style.append(this.buffer, paramString, paramArrayOfshort, Boolean.valueOf(paramBoolean));
/*  940 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder appendAsObjectToString(Object paramObject) {
/*  953 */     ObjectUtils.identityToString(getStringBuffer(), paramObject);
/*  954 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder appendSuper(String paramString) {
/*  972 */     if (paramString != null) {
/*  973 */       this.style.appendSuper(this.buffer, paramString);
/*      */     }
/*  975 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder appendToString(String paramString) {
/* 1006 */     if (paramString != null) {
/* 1007 */       this.style.appendToString(this.buffer, paramString);
/*      */     }
/* 1009 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject() {
/* 1019 */     return this.object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer getStringBuffer() {
/* 1028 */     return this.buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringStyle getStyle() {
/* 1040 */     return this.style;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1055 */     if (getObject() == null) {
/* 1056 */       getStringBuffer().append(getStyle().getNullText());
/*      */     } else {
/* 1058 */       this.style.appendEnd(getStringBuffer(), getObject());
/*      */     } 
/* 1060 */     return getStringBuffer().toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String build() {
/* 1075 */     return toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\ToStringBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */