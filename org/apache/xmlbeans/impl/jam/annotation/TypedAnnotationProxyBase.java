/*     */ package org.apache.xmlbeans.impl.jam.annotation;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.AnnotationValueImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TypedAnnotationProxyBase
/*     */   extends AnnotationProxy
/*     */ {
/*  45 */   private List mValues = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String paramString, Object paramObject, JClass paramJClass) {
/*  67 */     if (paramString == null) throw new IllegalArgumentException("null name"); 
/*  68 */     if (paramObject == null) throw new IllegalArgumentException("null value");
/*     */ 
/*     */     
/*  71 */     if (this.mValues == null) this.mValues = new ArrayList(); 
/*  72 */     this.mValues.add(new AnnotationValueImpl((ElementContext)this.mContext, paramString, paramObject, paramJClass));
/*     */ 
/*     */     
/*  75 */     Method method = getSetterFor(paramString, paramObject.getClass());
/*  76 */     if (method == null)
/*     */       return;  try {
/*  78 */       method.invoke(this, new Object[] { paramObject });
/*  79 */     } catch (IllegalAccessException illegalAccessException) {
/*  80 */       getLogger().warning(illegalAccessException);
/*  81 */     } catch (InvocationTargetException invocationTargetException) {
/*  82 */       getLogger().warning(invocationTargetException);
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
/*     */   public JAnnotationValue[] getValues() {
/*  97 */     if (this.mValues == null) return new JAnnotationValue[0]; 
/*  98 */     JAnnotationValue[] arrayOfJAnnotationValue = new JAnnotationValue[this.mValues.size()];
/*  99 */     this.mValues.toArray((Object[])arrayOfJAnnotationValue);
/* 100 */     return arrayOfJAnnotationValue;
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
/*     */   protected Method getSetterFor(String paramString, Class paramClass) {
/*     */     try {
/* 115 */       return getClass().getMethod("set" + paramString, new Class[] { paramClass });
/*     */     }
/* 117 */     catch (NoSuchMethodException noSuchMethodException) {
/* 118 */       getLogger().warning(noSuchMethodException);
/* 119 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\annotation\TypedAnnotationProxyBase.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */