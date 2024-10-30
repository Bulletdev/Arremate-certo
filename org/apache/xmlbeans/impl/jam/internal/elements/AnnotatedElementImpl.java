/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*     */ import org.apache.xmlbeans.impl.jam.JComment;
/*     */ import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MComment;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AnnotatedElementImpl
/*     */   extends ElementImpl
/*     */   implements MAnnotatedElement
/*     */ {
/*  26 */   private Map mName2Annotation = null;
/*  27 */   private MComment mComment = null;
/*  28 */   private List mAllAnnotations = null;
/*     */ 
/*     */ 
/*     */   
/*     */   protected AnnotatedElementImpl(ElementContext paramElementContext) {
/*  33 */     super(paramElementContext);
/*     */   } protected AnnotatedElementImpl(ElementImpl paramElementImpl) {
/*  35 */     super(paramElementImpl);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JAnnotation[] getAnnotations() {
/*  41 */     return (JAnnotation[])getMutableAnnotations();
/*     */   }
/*     */   
/*     */   public JAnnotation getAnnotation(Class paramClass) {
/*  45 */     return (JAnnotation)getMutableAnnotation(paramClass.getName());
/*     */   }
/*     */   
/*     */   public JAnnotation getAnnotation(String paramString) {
/*  49 */     return (JAnnotation)getMutableAnnotation(paramString);
/*     */   }
/*     */   
/*     */   public JAnnotationValue getAnnotationValue(String paramString) {
/*  53 */     if (this.mName2Annotation == null) return null; 
/*  54 */     paramString = paramString.trim();
/*     */     
/*  56 */     int i = paramString.indexOf('@');
/*  57 */     if (i == -1 || i == paramString.length() - 1) {
/*  58 */       JAnnotation jAnnotation1 = getAnnotation(paramString);
/*  59 */       if (jAnnotation1 == null) return null; 
/*  60 */       return jAnnotation1.getValue("value");
/*     */     } 
/*  62 */     JAnnotation jAnnotation = getAnnotation(paramString.substring(0, i));
/*  63 */     if (jAnnotation == null) return null;
/*     */     
/*  65 */     return jAnnotation.getValue(paramString.substring(i + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getAnnotationProxy(Class paramClass) {
/*  71 */     return getEditableProxy(paramClass);
/*     */   }
/*     */   public JComment getComment() {
/*  74 */     return (JComment)getMutableComment();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JAnnotation[] getAllJavadocTags() {
/*  80 */     if (this.mAllAnnotations == null) return (JAnnotation[])NO_ANNOTATION; 
/*  81 */     JAnnotation[] arrayOfJAnnotation = new JAnnotation[this.mAllAnnotations.size()];
/*  82 */     this.mAllAnnotations.toArray((Object[])arrayOfJAnnotation);
/*  83 */     return arrayOfJAnnotation;
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
/*     */   public AnnotationProxy getEditableProxy(Class paramClass) {
/* 107 */     if (this.mName2Annotation == null) return null; 
/* 108 */     MAnnotation mAnnotation = getMutableAnnotation(paramClass.getName());
/* 109 */     return (mAnnotation == null) ? null : (AnnotationProxy)mAnnotation.getProxy();
/*     */   }
/*     */   
/*     */   public void removeAnnotation(MAnnotation paramMAnnotation) {
/* 113 */     if (this.mName2Annotation != null) this.mName2Annotation.values().remove(paramMAnnotation); 
/*     */   }
/*     */   
/*     */   public MAnnotation[] getMutableAnnotations() {
/* 117 */     if (this.mName2Annotation == null) return new MAnnotation[0]; 
/* 118 */     MAnnotation[] arrayOfMAnnotation = new MAnnotation[this.mName2Annotation.values().size()];
/* 119 */     this.mName2Annotation.values().toArray((Object[])arrayOfMAnnotation);
/* 120 */     return arrayOfMAnnotation;
/*     */   }
/*     */   
/*     */   public MAnnotation getMutableAnnotation(String paramString) {
/* 124 */     if (this.mName2Annotation == null) return null; 
/* 125 */     paramString = paramString.trim();
/* 126 */     return (MAnnotation)this.mName2Annotation.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public MAnnotation findOrCreateAnnotation(String paramString) {
/* 131 */     MAnnotation mAnnotation = getMutableAnnotation(paramString);
/* 132 */     if (mAnnotation != null) return mAnnotation; 
/* 133 */     AnnotationProxy annotationProxy = getContext().createAnnotationProxy(paramString);
/*     */     
/* 135 */     mAnnotation = new AnnotationImpl(getContext(), annotationProxy, paramString);
/* 136 */     if (this.mName2Annotation == null) {
/* 137 */       this.mName2Annotation = new HashMap();
/*     */     }
/* 139 */     this.mName2Annotation.put(mAnnotation.getQualifiedName(), mAnnotation);
/* 140 */     return mAnnotation;
/*     */   }
/*     */   
/*     */   public MAnnotation addLiteralAnnotation(String paramString) {
/* 144 */     if (paramString == null) throw new IllegalArgumentException("null tagname"); 
/* 145 */     paramString = paramString.trim();
/*     */ 
/*     */ 
/*     */     
/* 149 */     AnnotationProxy annotationProxy = getContext().createAnnotationProxy(paramString);
/* 150 */     AnnotationImpl annotationImpl = new AnnotationImpl(getContext(), annotationProxy, paramString);
/* 151 */     if (this.mAllAnnotations == null) this.mAllAnnotations = new ArrayList(); 
/* 152 */     this.mAllAnnotations.add(annotationImpl);
/*     */ 
/*     */     
/* 155 */     if (getMutableAnnotation(paramString) == null) {
/* 156 */       if (this.mName2Annotation == null) this.mName2Annotation = new HashMap(); 
/* 157 */       this.mName2Annotation.put(paramString, annotationImpl);
/*     */     } 
/* 159 */     return annotationImpl;
/*     */   }
/*     */   public MComment getMutableComment() {
/* 162 */     return this.mComment;
/*     */   } public MComment createComment() {
/* 164 */     return this.mComment = new CommentImpl(this);
/*     */   } public void removeComment() {
/* 166 */     this.mComment = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAnnotation(JAnnotation paramJAnnotation) {
/* 174 */     if (this.mName2Annotation == null) {
/* 175 */       this.mName2Annotation = new HashMap();
/* 176 */       this.mName2Annotation.put(paramJAnnotation.getQualifiedName(), paramJAnnotation);
/*     */     }
/* 178 */     else if (this.mName2Annotation.get(paramJAnnotation.getQualifiedName()) == null) {
/* 179 */       this.mName2Annotation.put(paramJAnnotation.getQualifiedName(), paramJAnnotation);
/*     */     } 
/*     */     
/* 182 */     if (this.mAllAnnotations == null) this.mAllAnnotations = new ArrayList(); 
/* 183 */     this.mAllAnnotations.add(paramJAnnotation);
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
/*     */   public MAnnotation addAnnotationForProxy(Class paramClass, AnnotationProxy paramAnnotationProxy) {
/* 199 */     String str = paramClass.getName();
/* 200 */     MAnnotation mAnnotation = getMutableAnnotation(str);
/* 201 */     if (mAnnotation != null) return mAnnotation; 
/* 202 */     mAnnotation = new AnnotationImpl(getContext(), paramAnnotationProxy, str);
/* 203 */     if (this.mName2Annotation == null) {
/* 204 */       this.mName2Annotation = new HashMap();
/*     */     }
/* 206 */     this.mName2Annotation.put(mAnnotation.getQualifiedName(), mAnnotation);
/* 207 */     return mAnnotation;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\AnnotatedElementImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */