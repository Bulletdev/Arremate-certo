/*     */ package org.apache.xmlbeans.impl.jam;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JamUtils
/*     */ {
/*     */   public static final JamUtils getInstance() {
/*  40 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*  44 */   private static final JamUtils INSTANCE = new JamUtils();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Method getMethodOn(JMethod paramJMethod, Class paramClass) throws NoSuchMethodException, ClassNotFoundException {
/*  65 */     if (paramClass == null) throw new IllegalArgumentException("null class"); 
/*  66 */     if (paramJMethod == null) throw new IllegalArgumentException("null method"); 
/*  67 */     Class[] arrayOfClass = null;
/*  68 */     JParameter[] arrayOfJParameter = paramJMethod.getParameters();
/*  69 */     if (arrayOfJParameter != null && arrayOfJParameter.length > 0) {
/*  70 */       arrayOfClass = new Class[arrayOfJParameter.length];
/*  71 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/*  72 */         arrayOfClass[b] = loadClass(arrayOfJParameter[b].getType(), paramClass.getClassLoader());
/*     */       }
/*     */     } 
/*  75 */     return paramClass.getMethod(paramJMethod.getSimpleName(), arrayOfClass);
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
/*     */   public Constructor getConstructorOn(JConstructor paramJConstructor, Class paramClass) throws NoSuchMethodException, ClassNotFoundException {
/*  93 */     if (paramClass == null) throw new IllegalArgumentException("null class"); 
/*  94 */     if (paramJConstructor == null) throw new IllegalArgumentException("null ctor"); 
/*  95 */     Class[] arrayOfClass = null;
/*  96 */     JParameter[] arrayOfJParameter = paramJConstructor.getParameters();
/*  97 */     if (arrayOfJParameter != null && arrayOfJParameter.length > 0) {
/*  98 */       arrayOfClass = new Class[arrayOfJParameter.length];
/*  99 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/* 100 */         arrayOfClass[b] = loadClass(arrayOfJParameter[b].getType(), paramClass.getClassLoader());
/*     */       }
/*     */     } 
/* 103 */     return paramClass.getConstructor(arrayOfClass);
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
/*     */   public Field getFieldOn(JField paramJField, Class paramClass) throws NoSuchFieldException {
/* 118 */     if (paramClass == null) throw new IllegalArgumentException("null class"); 
/* 119 */     if (paramJField == null) throw new IllegalArgumentException("null field"); 
/* 120 */     return paramClass.getField(paramJField.getSimpleName());
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
/*     */   public Class loadClass(JClass paramJClass, ClassLoader paramClassLoader) throws ClassNotFoundException {
/* 133 */     return paramClassLoader.loadClass(paramJClass.getQualifiedName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeInSourceOrder(JElement[] paramArrayOfJElement) {
/* 141 */     if (paramArrayOfJElement == null) throw new IllegalArgumentException("null elements"); 
/* 142 */     Arrays.sort(paramArrayOfJElement, SOURCE_POSITION_COMPARATOR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   private static Comparator SOURCE_POSITION_COMPARATOR = new Comparator()
/*     */     {
/*     */       public int compare(Object param1Object1, Object param1Object2) {
/* 151 */         JSourcePosition jSourcePosition1 = ((JElement)param1Object1).getSourcePosition();
/* 152 */         JSourcePosition jSourcePosition2 = ((JElement)param1Object2).getSourcePosition();
/* 153 */         if (jSourcePosition1 == null) return (jSourcePosition2 == null) ? 0 : -1; 
/* 154 */         if (jSourcePosition2 == null) return 1; 
/* 155 */         return (jSourcePosition1.getLine() < jSourcePosition2.getLine()) ? -1 : ((jSourcePosition1.getLine() > jSourcePosition2.getLine()) ? 1 : 0);
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JamUtils.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */