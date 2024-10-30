/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JComment;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JProperty;
/*     */ import org.apache.xmlbeans.impl.jam.JSourcePosition;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PropertyImpl
/*     */   extends AnnotatedElementImpl
/*     */   implements JProperty
/*     */ {
/*     */   private String mName;
/*     */   private JMethod mGetter;
/*     */   private JMethod mSetter;
/*     */   private JClassRef mTypeRef;
/*     */   
/*     */   public PropertyImpl(String paramString1, JMethod paramJMethod1, JMethod paramJMethod2, String paramString2) {
/*  61 */     super((paramJMethod1 != null) ? (ElementImpl)paramJMethod1.getParent() : (ElementImpl)paramJMethod2.getParent());
/*     */ 
/*     */     
/*  64 */     this.mName = paramString1;
/*  65 */     this.mGetter = paramJMethod1;
/*  66 */     this.mSetter = paramJMethod2;
/*  67 */     ClassImpl classImpl = (paramJMethod1 != null) ? (ClassImpl)paramJMethod1.getContainingClass() : (ClassImpl)paramJMethod2.getContainingClass();
/*     */     
/*  69 */     this.mTypeRef = QualifiedJClassRef.create(paramString2, classImpl);
/*  70 */     initAnnotations();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JClass getType() {
/*  79 */     return this.mTypeRef.getRefClass();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSimpleName() {
/*  86 */     return this.mName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQualifiedName() {
/*  95 */     return getParent().getQualifiedName() + "." + getSimpleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JMethod getSetter() {
/* 102 */     return this.mSetter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JMethod getGetter() {
/* 108 */     return this.mGetter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAnnotation[] getAnnotations() {
/* 118 */     return combine((this.mGetter == null) ? (JAnnotation[])ElementImpl.NO_ANNOTATION : this.mGetter.getAnnotations(), (this.mSetter == null) ? (JAnnotation[])ElementImpl.NO_ANNOTATION : this.mSetter.getAnnotations());
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
/*     */   public void setSetter(JMethod paramJMethod) {
/* 137 */     this.mSetter = paramJMethod;
/*     */   }
/*     */   public void setGetter(JMethod paramJMethod) {
/* 140 */     this.mGetter = paramJMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAnnotation getAnnotation(String paramString) {
/* 147 */     JAnnotation jAnnotation = (this.mGetter != null) ? this.mGetter.getAnnotation(paramString) : null;
/* 148 */     if (jAnnotation != null) return jAnnotation; 
/* 149 */     return (this.mSetter != null) ? this.mSetter.getAnnotation(paramString) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public JComment getComment() {
/* 154 */     if (this.mGetter != null) return this.mGetter.getComment(); 
/* 155 */     if (this.mSetter != null) return this.mSetter.getComment(); 
/* 156 */     return null;
/*     */   }
/*     */   
/*     */   public JSourcePosition getSourcePosition() {
/* 160 */     return (this.mGetter != null) ? this.mGetter.getSourcePosition() : this.mSetter.getSourcePosition();
/*     */   }
/*     */ 
/*     */   
/*     */   public void accept(JVisitor paramJVisitor) {
/* 165 */     if (this.mGetter != null) paramJVisitor.visit(this.mGetter); 
/* 166 */     if (this.mSetter != null) paramJVisitor.visit(this.mSetter);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     return getQualifiedName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void initAnnotations() {
/* 178 */     if (this.mSetter != null) {
/* 179 */       JAnnotation[] arrayOfJAnnotation = this.mSetter.getAnnotations(); byte b;
/* 180 */       for (b = 0; b < arrayOfJAnnotation.length; ) { addAnnotation(arrayOfJAnnotation[b]); b++; }
/* 181 */        arrayOfJAnnotation = this.mSetter.getAllJavadocTags();
/* 182 */       for (b = 0; b < arrayOfJAnnotation.length; ) { addAnnotation(arrayOfJAnnotation[b]); b++; }
/*     */     
/* 184 */     }  if (this.mGetter != null) {
/* 185 */       JAnnotation[] arrayOfJAnnotation = this.mGetter.getAnnotations(); byte b;
/* 186 */       for (b = 0; b < arrayOfJAnnotation.length; ) { addAnnotation(arrayOfJAnnotation[b]); b++; }
/* 187 */        arrayOfJAnnotation = this.mGetter.getAllJavadocTags();
/* 188 */       for (b = 0; b < arrayOfJAnnotation.length; ) { addAnnotation(arrayOfJAnnotation[b]); b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JAnnotation[] combine(JAnnotation[] paramArrayOfJAnnotation1, JAnnotation[] paramArrayOfJAnnotation2) {
/* 198 */     if (paramArrayOfJAnnotation1.length == 0) return paramArrayOfJAnnotation2; 
/* 199 */     if (paramArrayOfJAnnotation2.length == 0) return paramArrayOfJAnnotation1; 
/* 200 */     JAnnotation[] arrayOfJAnnotation = new JAnnotation[paramArrayOfJAnnotation1.length + paramArrayOfJAnnotation2.length];
/* 201 */     System.arraycopy(paramArrayOfJAnnotation1, 0, arrayOfJAnnotation, 0, paramArrayOfJAnnotation1.length);
/* 202 */     System.arraycopy(paramArrayOfJAnnotation2, 0, arrayOfJAnnotation, paramArrayOfJAnnotation1.length, paramArrayOfJAnnotation2.length);
/* 203 */     return arrayOfJAnnotation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JComment[] combine(JComment[] paramArrayOfJComment1, JComment[] paramArrayOfJComment2) {
/* 211 */     if (paramArrayOfJComment1.length == 0) return paramArrayOfJComment2; 
/* 212 */     if (paramArrayOfJComment2.length == 0) return paramArrayOfJComment1; 
/* 213 */     JComment[] arrayOfJComment = new JComment[paramArrayOfJComment1.length + paramArrayOfJComment2.length];
/* 214 */     System.arraycopy(paramArrayOfJComment1, 0, arrayOfJComment, 0, paramArrayOfJComment1.length);
/* 215 */     System.arraycopy(paramArrayOfJComment2, 0, arrayOfJComment, paramArrayOfJComment1.length, paramArrayOfJComment2.length);
/* 216 */     return arrayOfJComment;
/*     */   }
/*     */ 
/*     */   
/*     */   public void accept(MVisitor paramMVisitor) {
/* 221 */     if (this.mGetter != null) paramMVisitor.visit((MMethod)this.mGetter); 
/* 222 */     if (this.mSetter != null) paramMVisitor.visit((MMethod)this.mSetter); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\PropertyImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */