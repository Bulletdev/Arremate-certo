/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AnnotationImpl
/*     */   extends ElementImpl
/*     */   implements MAnnotation
/*     */ {
/*     */   private AnnotationProxy mProxy;
/*  35 */   private Object mAnnotationInstance = null;
/*  36 */   private String mQualifiedName = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnnotationImpl(ElementContext paramElementContext, AnnotationProxy paramAnnotationProxy, String paramString) {
/*  45 */     super(paramElementContext);
/*  46 */     if (paramAnnotationProxy == null) throw new IllegalArgumentException("null proxy"); 
/*  47 */     if (paramString == null) throw new IllegalArgumentException("null qn"); 
/*  48 */     this.mProxy = paramAnnotationProxy;
/*     */ 
/*     */     
/*  51 */     setSimpleName(paramString.substring(paramString.lastIndexOf('.') + 1));
/*  52 */     this.mQualifiedName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getProxy() {
/*  58 */     return this.mProxy;
/*     */   } public JAnnotationValue[] getValues() {
/*  60 */     return this.mProxy.getValues();
/*     */   }
/*     */   public JAnnotationValue getValue(String paramString) {
/*  63 */     return this.mProxy.getValue(paramString);
/*     */   }
/*     */   public Object getAnnotationInstance() {
/*  66 */     return this.mAnnotationInstance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnnotationInstance(Object paramObject) {
/*  72 */     this.mAnnotationInstance = paramObject;
/*     */   }
/*     */   
/*     */   public void setSimpleValue(String paramString, Object paramObject, JClass paramJClass) {
/*  76 */     if (paramString == null) throw new IllegalArgumentException("null name"); 
/*  77 */     if (paramJClass == null) throw new IllegalArgumentException("null type"); 
/*  78 */     if (paramObject == null) throw new IllegalArgumentException("null value"); 
/*  79 */     this.mProxy.setValue(paramString, paramObject, paramJClass);
/*     */   }
/*     */   
/*     */   public MAnnotation createNestedValue(String paramString1, String paramString2) {
/*  83 */     if (paramString1 == null) throw new IllegalArgumentException("null name"); 
/*  84 */     if (paramString2 == null) throw new IllegalArgumentException("null typename"); 
/*  85 */     AnnotationProxy annotationProxy = getContext().createAnnotationProxy(paramString2);
/*  86 */     AnnotationImpl annotationImpl = new AnnotationImpl(getContext(), annotationProxy, paramString2);
/*  87 */     JClass jClass = getContext().getClassLoader().loadClass(paramString2);
/*  88 */     this.mProxy.setValue(paramString1, annotationImpl, jClass);
/*  89 */     return annotationImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MAnnotation[] createNestedValueArray(String paramString1, String paramString2, int paramInt) {
/*  95 */     if (paramString1 == null) throw new IllegalArgumentException("null name"); 
/*  96 */     if (paramString2 == null) throw new IllegalArgumentException("null typename"); 
/*  97 */     if (paramInt < 0) throw new IllegalArgumentException("dimensions = " + paramInt); 
/*  98 */     MAnnotation[] arrayOfMAnnotation = new MAnnotation[paramInt];
/*  99 */     for (byte b = 0; b < arrayOfMAnnotation.length; b++) {
/* 100 */       AnnotationProxy annotationProxy = getContext().createAnnotationProxy(paramString2);
/* 101 */       arrayOfMAnnotation[b] = new AnnotationImpl(getContext(), annotationProxy, paramString2);
/*     */     } 
/* 103 */     JClass jClass = getContext().getClassLoader().loadClass("[L" + paramString2 + ";");
/* 104 */     this.mProxy.setValue(paramString1, arrayOfMAnnotation, jClass);
/* 105 */     return arrayOfMAnnotation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQualifiedName() {
/* 111 */     return this.mQualifiedName;
/*     */   } public void accept(MVisitor paramMVisitor) {
/* 113 */     paramMVisitor.visit(this);
/*     */   } public void accept(JVisitor paramJVisitor) {
/* 115 */     paramJVisitor.visit((JAnnotation)this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\AnnotationImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */