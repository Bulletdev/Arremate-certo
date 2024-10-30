/*     */ package ch.qos.logback.core.joran.util;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.UnsupportedCharsetException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringToObjectConverter
/*     */ {
/*  31 */   private static final Class<?>[] STING_CLASS_PARAMETER = new Class[] { String.class };
/*     */   
/*     */   public static boolean canBeBuiltFromSimpleString(Class<?> paramClass) {
/*  34 */     Package package_ = paramClass.getPackage();
/*  35 */     if (paramClass.isPrimitive())
/*  36 */       return true; 
/*  37 */     if (package_ != null && "java.lang".equals(package_.getName()))
/*  38 */       return true; 
/*  39 */     if (followsTheValueOfConvention(paramClass))
/*  40 */       return true; 
/*  41 */     if (paramClass.isEnum())
/*  42 */       return true; 
/*  43 */     if (isOfTypeCharset(paramClass)) {
/*  44 */       return true;
/*     */     }
/*  46 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object convertArg(ContextAware paramContextAware, String paramString, Class<?> paramClass) {
/*  54 */     if (paramString == null) {
/*  55 */       return null;
/*     */     }
/*  57 */     String str = paramString.trim();
/*  58 */     if (String.class.isAssignableFrom(paramClass))
/*  59 */       return str; 
/*  60 */     if (int.class.isAssignableFrom(paramClass))
/*  61 */       return new Integer(str); 
/*  62 */     if (long.class.isAssignableFrom(paramClass))
/*  63 */       return new Long(str); 
/*  64 */     if (float.class.isAssignableFrom(paramClass))
/*  65 */       return new Float(str); 
/*  66 */     if (double.class.isAssignableFrom(paramClass))
/*  67 */       return new Double(str); 
/*  68 */     if (boolean.class.isAssignableFrom(paramClass)) {
/*  69 */       if ("true".equalsIgnoreCase(str))
/*  70 */         return Boolean.TRUE; 
/*  71 */       if ("false".equalsIgnoreCase(str))
/*  72 */         return Boolean.FALSE; 
/*     */     } else {
/*  74 */       if (paramClass.isEnum())
/*  75 */         return convertToEnum(paramContextAware, str, (Class)paramClass); 
/*  76 */       if (followsTheValueOfConvention(paramClass))
/*  77 */         return convertByValueOfMethod(paramContextAware, paramClass, str); 
/*  78 */       if (isOfTypeCharset(paramClass)) {
/*  79 */         return convertToCharset(paramContextAware, paramString);
/*     */       }
/*     */     } 
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   private static boolean isOfTypeCharset(Class<?> paramClass) {
/*  86 */     return Charset.class.isAssignableFrom(paramClass);
/*     */   }
/*     */   
/*     */   private static Charset convertToCharset(ContextAware paramContextAware, String paramString) {
/*     */     try {
/*  91 */       return Charset.forName(paramString);
/*  92 */     } catch (UnsupportedCharsetException unsupportedCharsetException) {
/*  93 */       paramContextAware.addError("Failed to get charset [" + paramString + "]", unsupportedCharsetException);
/*  94 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Method getValueOfMethod(Class<?> paramClass) {
/*     */     try {
/* 101 */       return paramClass.getMethod("valueOf", STING_CLASS_PARAMETER);
/* 102 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 103 */       return null;
/* 104 */     } catch (SecurityException securityException) {
/* 105 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean followsTheValueOfConvention(Class<?> paramClass) {
/* 110 */     Method method = getValueOfMethod(paramClass);
/* 111 */     if (method == null) {
/* 112 */       return false;
/*     */     }
/* 114 */     int i = method.getModifiers();
/* 115 */     return Modifier.isStatic(i);
/*     */   }
/*     */   
/*     */   private static Object convertByValueOfMethod(ContextAware paramContextAware, Class<?> paramClass, String paramString) {
/*     */     try {
/* 120 */       Method method = paramClass.getMethod("valueOf", STING_CLASS_PARAMETER);
/* 121 */       return method.invoke(null, new Object[] { paramString });
/* 122 */     } catch (Exception exception) {
/* 123 */       paramContextAware.addError("Failed to invoke valueOf{} method in class [" + paramClass.getName() + "] with value [" + paramString + "]");
/* 124 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object convertToEnum(ContextAware paramContextAware, String paramString, Class<? extends Enum> paramClass) {
/* 130 */     return Enum.valueOf(paramClass, paramString);
/*     */   }
/*     */   
/*     */   boolean isBuildableFromSimpleString() {
/* 134 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\jora\\util\StringToObjectConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */