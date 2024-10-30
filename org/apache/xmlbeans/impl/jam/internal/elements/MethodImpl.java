/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.Modifier;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JParameter;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
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
/*     */ public final class MethodImpl
/*     */   extends InvokableImpl
/*     */   implements MMethod
/*     */ {
/*  46 */   private JClassRef mReturnTypeRef = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   MethodImpl(String paramString, ClassImpl paramClassImpl) {
/*  52 */     super(paramClassImpl);
/*  53 */     setSimpleName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReturnType(String paramString) {
/*  60 */     this.mReturnTypeRef = QualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnqualifiedReturnType(String paramString) {
/*  65 */     this.mReturnTypeRef = UnqualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReturnType(JClass paramJClass) {
/*  70 */     this.mReturnTypeRef = DirectJClassRef.create(paramJClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JClass getReturnType() {
/*  77 */     if (this.mReturnTypeRef == null) {
/*  78 */       return getClassLoader().loadClass("void");
/*     */     }
/*  80 */     return this.mReturnTypeRef.getRefClass();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFinal() {
/*  85 */     return Modifier.isFinal(getModifiers());
/*     */   }
/*     */   
/*     */   public boolean isStatic() {
/*  89 */     return Modifier.isStatic(getModifiers());
/*     */   }
/*     */   
/*     */   public boolean isAbstract() {
/*  93 */     return Modifier.isAbstract(getModifiers());
/*     */   }
/*     */   
/*     */   public boolean isNative() {
/*  97 */     return Modifier.isNative(getModifiers());
/*     */   }
/*     */   
/*     */   public boolean isSynchronized() {
/* 101 */     return Modifier.isSynchronized(getModifiers());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void accept(MVisitor paramMVisitor) {
/* 107 */     paramMVisitor.visit(this);
/*     */   } public void accept(JVisitor paramJVisitor) {
/* 109 */     paramJVisitor.visit((JMethod)this);
/*     */   }
/*     */   public String getQualifiedName() {
/* 112 */     StringWriter stringWriter = new StringWriter();
/* 113 */     stringWriter.write(Modifier.toString(getModifiers()));
/* 114 */     stringWriter.write(32);
/* 115 */     JClass jClass = getReturnType();
/* 116 */     if (jClass == null) {
/* 117 */       stringWriter.write("void ");
/*     */     } else {
/* 119 */       stringWriter.write(jClass.getQualifiedName());
/* 120 */       stringWriter.write(32);
/*     */     } 
/* 122 */     stringWriter.write(getSimpleName());
/* 123 */     stringWriter.write(40);
/*     */     
/* 125 */     JParameter[] arrayOfJParameter = getParameters();
/* 126 */     if (arrayOfJParameter != null && arrayOfJParameter.length > 0) {
/* 127 */       for (byte b = 0; b < arrayOfJParameter.length; b++) {
/* 128 */         stringWriter.write(arrayOfJParameter[b].getType().getQualifiedName());
/* 129 */         if (b < arrayOfJParameter.length - 1) stringWriter.write(44);
/*     */       
/*     */       } 
/*     */     }
/* 133 */     stringWriter.write(41);
/*     */     
/* 135 */     JClass[] arrayOfJClass = getExceptionTypes();
/* 136 */     if (arrayOfJClass != null && arrayOfJClass.length > 0) {
/* 137 */       stringWriter.write(" throws ");
/* 138 */       for (byte b = 0; b < arrayOfJClass.length; b++) {
/* 139 */         stringWriter.write(arrayOfJClass[b].getQualifiedName());
/* 140 */         if (b < arrayOfJClass.length - 1) stringWriter.write(44);
/*     */       
/*     */       } 
/*     */     } 
/* 144 */     return stringWriter.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\MethodImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */