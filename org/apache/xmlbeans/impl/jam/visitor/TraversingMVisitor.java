/*     */ package org.apache.xmlbeans.impl.jam.visitor;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MComment;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MPackage;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
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
/*     */ 
/*     */ public class TraversingMVisitor
/*     */   extends MVisitor
/*     */ {
/*     */   private MVisitor mDelegate;
/*     */   
/*     */   public TraversingMVisitor(MVisitor paramMVisitor) {
/*  62 */     if (paramMVisitor == null) throw new IllegalArgumentException("null jv"); 
/*  63 */     this.mDelegate = paramMVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visit(MPackage paramMPackage) {
/*  70 */     paramMPackage.accept(this.mDelegate);
/*  71 */     MClass[] arrayOfMClass = paramMPackage.getMutableClasses();
/*  72 */     for (byte b = 0; b < arrayOfMClass.length; ) { visit(arrayOfMClass[b]); b++; }
/*  73 */      visitAnnotations((MAnnotatedElement)paramMPackage);
/*  74 */     visitComment((MAnnotatedElement)paramMPackage);
/*     */   }
/*     */   
/*     */   public void visit(MClass paramMClass) {
/*  78 */     paramMClass.accept(this.mDelegate);
/*     */     
/*  80 */     MField[] arrayOfMField = paramMClass.getMutableFields(); byte b;
/*  81 */     for (b = 0; b < arrayOfMField.length; ) { visit(arrayOfMField[b]); b++; }
/*     */     
/*  83 */     MConstructor[] arrayOfMConstructor = paramMClass.getMutableConstructors();
/*  84 */     for (b = 0; b < arrayOfMConstructor.length; ) { visit(arrayOfMConstructor[b]); b++; }
/*     */     
/*  86 */     MMethod[] arrayOfMMethod = paramMClass.getMutableMethods();
/*  87 */     for (b = 0; b < arrayOfMMethod.length; ) { visit(arrayOfMMethod[b]); b++; }
/*     */     
/*  89 */     visitAnnotations((MAnnotatedElement)paramMClass);
/*  90 */     visitComment((MAnnotatedElement)paramMClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visit(MField paramMField) {
/*  97 */     paramMField.accept(this.mDelegate);
/*  98 */     visitAnnotations((MAnnotatedElement)paramMField);
/*  99 */     visitComment((MAnnotatedElement)paramMField);
/*     */   }
/*     */   
/*     */   public void visit(MConstructor paramMConstructor) {
/* 103 */     paramMConstructor.accept(this.mDelegate);
/* 104 */     visitParameters((MInvokable)paramMConstructor);
/* 105 */     visitAnnotations((MAnnotatedElement)paramMConstructor);
/* 106 */     visitComment((MAnnotatedElement)paramMConstructor);
/*     */   }
/*     */   
/*     */   public void visit(MMethod paramMMethod) {
/* 110 */     paramMMethod.accept(this.mDelegate);
/* 111 */     visitParameters((MInvokable)paramMMethod);
/* 112 */     visitAnnotations((MAnnotatedElement)paramMMethod);
/* 113 */     visitComment((MAnnotatedElement)paramMMethod);
/*     */   }
/*     */   
/*     */   public void visit(MParameter paramMParameter) {
/* 117 */     paramMParameter.accept(this.mDelegate);
/* 118 */     visitAnnotations((MAnnotatedElement)paramMParameter);
/* 119 */     visitComment((MAnnotatedElement)paramMParameter);
/*     */   }
/*     */   public void visit(MAnnotation paramMAnnotation) {
/* 122 */     paramMAnnotation.accept(this.mDelegate);
/*     */   } public void visit(MComment paramMComment) {
/* 124 */     paramMComment.accept(this.mDelegate);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void visitParameters(MInvokable paramMInvokable) {
/* 130 */     MParameter[] arrayOfMParameter = paramMInvokable.getMutableParameters();
/* 131 */     for (byte b = 0; b < arrayOfMParameter.length; ) { visit(arrayOfMParameter[b]); b++; }
/*     */   
/*     */   }
/*     */   private void visitAnnotations(MAnnotatedElement paramMAnnotatedElement) {
/* 135 */     MAnnotation[] arrayOfMAnnotation = paramMAnnotatedElement.getMutableAnnotations();
/* 136 */     for (byte b = 0; b < arrayOfMAnnotation.length; ) { visit(arrayOfMAnnotation[b]); b++; }
/*     */   
/*     */   }
/*     */   private void visitComment(MAnnotatedElement paramMAnnotatedElement) {
/* 140 */     MComment mComment = paramMAnnotatedElement.getMutableComment();
/* 141 */     if (mComment != null) visit(mComment); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\visitor\TraversingMVisitor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */