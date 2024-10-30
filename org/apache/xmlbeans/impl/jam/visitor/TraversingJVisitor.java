/*     */ package org.apache.xmlbeans.impl.jam.visitor;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JComment;
/*     */ import org.apache.xmlbeans.impl.jam.JConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.JField;
/*     */ import org.apache.xmlbeans.impl.jam.JInvokable;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JPackage;
/*     */ import org.apache.xmlbeans.impl.jam.JParameter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TraversingJVisitor
/*     */   extends JVisitor
/*     */ {
/*     */   private JVisitor mDelegate;
/*     */   
/*     */   public TraversingJVisitor(JVisitor paramJVisitor) {
/*  61 */     if (paramJVisitor == null) throw new IllegalArgumentException("null jv"); 
/*  62 */     this.mDelegate = paramJVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visit(JPackage paramJPackage) {
/*  69 */     paramJPackage.accept(this.mDelegate);
/*  70 */     JClass[] arrayOfJClass = paramJPackage.getClasses();
/*  71 */     for (byte b = 0; b < arrayOfJClass.length; ) { visit(arrayOfJClass[b]); b++; }
/*  72 */      visitAnnotations((JAnnotatedElement)paramJPackage);
/*  73 */     visitComment((JAnnotatedElement)paramJPackage);
/*     */   }
/*     */   
/*     */   public void visit(JClass paramJClass) {
/*  77 */     paramJClass.accept(this.mDelegate);
/*     */     
/*  79 */     JField[] arrayOfJField = paramJClass.getDeclaredFields(); byte b;
/*  80 */     for (b = 0; b < arrayOfJField.length; ) { visit(arrayOfJField[b]); b++; }
/*     */     
/*  82 */     JConstructor[] arrayOfJConstructor = paramJClass.getConstructors();
/*  83 */     for (b = 0; b < arrayOfJConstructor.length; ) { visit(arrayOfJConstructor[b]); b++; }
/*     */     
/*  85 */     JMethod[] arrayOfJMethod = paramJClass.getMethods();
/*  86 */     for (b = 0; b < arrayOfJMethod.length; ) { visit(arrayOfJMethod[b]); b++; }
/*     */     
/*  88 */     visitAnnotations((JAnnotatedElement)paramJClass);
/*  89 */     visitComment((JAnnotatedElement)paramJClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visit(JField paramJField) {
/*  96 */     paramJField.accept(this.mDelegate);
/*  97 */     visitAnnotations((JAnnotatedElement)paramJField);
/*  98 */     visitComment((JAnnotatedElement)paramJField);
/*     */   }
/*     */   
/*     */   public void visit(JConstructor paramJConstructor) {
/* 102 */     paramJConstructor.accept(this.mDelegate);
/* 103 */     visitParameters((JInvokable)paramJConstructor);
/* 104 */     visitAnnotations((JAnnotatedElement)paramJConstructor);
/* 105 */     visitComment((JAnnotatedElement)paramJConstructor);
/*     */   }
/*     */   
/*     */   public void visit(JMethod paramJMethod) {
/* 109 */     paramJMethod.accept(this.mDelegate);
/* 110 */     visitParameters((JInvokable)paramJMethod);
/* 111 */     visitAnnotations((JAnnotatedElement)paramJMethod);
/* 112 */     visitComment((JAnnotatedElement)paramJMethod);
/*     */   }
/*     */   
/*     */   public void visit(JParameter paramJParameter) {
/* 116 */     paramJParameter.accept(this.mDelegate);
/* 117 */     visitAnnotations((JAnnotatedElement)paramJParameter);
/* 118 */     visitComment((JAnnotatedElement)paramJParameter);
/*     */   }
/*     */   public void visit(JAnnotation paramJAnnotation) {
/* 121 */     paramJAnnotation.accept(this.mDelegate);
/*     */   } public void visit(JComment paramJComment) {
/* 123 */     paramJComment.accept(this.mDelegate);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void visitParameters(JInvokable paramJInvokable) {
/* 129 */     JParameter[] arrayOfJParameter = paramJInvokable.getParameters();
/* 130 */     for (byte b = 0; b < arrayOfJParameter.length; ) { visit(arrayOfJParameter[b]); b++; }
/*     */   
/*     */   }
/*     */   private void visitAnnotations(JAnnotatedElement paramJAnnotatedElement) {
/* 134 */     JAnnotation[] arrayOfJAnnotation = paramJAnnotatedElement.getAnnotations();
/* 135 */     for (byte b = 0; b < arrayOfJAnnotation.length; ) { visit(arrayOfJAnnotation[b]); b++; }
/*     */   
/*     */   }
/*     */   private void visitComment(JAnnotatedElement paramJAnnotatedElement) {
/* 139 */     JComment jComment = paramJAnnotatedElement.getComment();
/* 140 */     if (jComment != null) visit(jComment); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\visitor\TraversingJVisitor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */