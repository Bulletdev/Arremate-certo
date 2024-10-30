/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.Modifier;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JField;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MField;
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
/*     */ public final class FieldImpl
/*     */   extends MemberImpl
/*     */   implements MField
/*     */ {
/*     */   private JClassRef mTypeClassRef;
/*     */   
/*     */   FieldImpl(String paramString1, ClassImpl paramClassImpl, String paramString2) {
/*  48 */     super(paramClassImpl);
/*  49 */     setSimpleName(paramString1);
/*  50 */     this.mTypeClassRef = QualifiedJClassRef.create(paramString2, paramClassImpl);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(JClass paramJClass) {
/*  58 */     if (paramJClass == null) throw new IllegalArgumentException("null type"); 
/*  59 */     this.mTypeClassRef = DirectJClassRef.create(paramJClass);
/*     */   }
/*     */   
/*     */   public void setType(String paramString) {
/*  63 */     if (paramString == null) throw new IllegalArgumentException("null qcname"); 
/*  64 */     this.mTypeClassRef = QualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnqualifiedType(String paramString) {
/*  69 */     if (paramString == null) throw new IllegalArgumentException("null ucname"); 
/*  70 */     this.mTypeClassRef = UnqualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JClass getType() {
/*  78 */     if (this.mTypeClassRef == null) throw new IllegalStateException(); 
/*  79 */     return this.mTypeClassRef.getRefClass();
/*     */   }
/*     */   
/*     */   public boolean isFinal() {
/*  83 */     return Modifier.isFinal(getModifiers());
/*     */   }
/*     */   
/*     */   public boolean isStatic() {
/*  87 */     return Modifier.isStatic(getModifiers());
/*     */   }
/*     */   
/*     */   public boolean isVolatile() {
/*  91 */     return Modifier.isVolatile(getModifiers());
/*     */   }
/*     */   
/*     */   public boolean isTransient() {
/*  95 */     return Modifier.isTransient(getModifiers());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void accept(MVisitor paramMVisitor) {
/* 101 */     paramMVisitor.visit(this);
/*     */   } public void accept(JVisitor paramJVisitor) {
/* 103 */     paramJVisitor.visit((JField)this);
/*     */   }
/*     */   public String getQualifiedName() {
/* 106 */     StringWriter stringWriter = new StringWriter();
/* 107 */     stringWriter.write(Modifier.toString(getModifiers()));
/* 108 */     stringWriter.write(32);
/* 109 */     stringWriter.write(getType().getQualifiedName());
/* 110 */     stringWriter.write(32);
/* 111 */     stringWriter.write(getContainingClass().getQualifiedName());
/* 112 */     stringWriter.write(46);
/* 113 */     stringWriter.write(getSimpleName());
/* 114 */     return stringWriter.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\FieldImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */