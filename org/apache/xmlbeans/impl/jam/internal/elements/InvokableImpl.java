/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JParameter;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
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
/*     */ public abstract class InvokableImpl
/*     */   extends MemberImpl
/*     */   implements MInvokable
/*     */ {
/*  40 */   private List mExceptionClassRefs = null;
/*  41 */   private List mParameters = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InvokableImpl(ClassImpl paramClassImpl) {
/*  47 */     super(paramClassImpl);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addException(JClass paramJClass) {
/*  54 */     if (paramJClass == null) {
/*  55 */       throw new IllegalArgumentException("null exception class");
/*     */     }
/*  57 */     if (this.mExceptionClassRefs == null) this.mExceptionClassRefs = new ArrayList(); 
/*  58 */     this.mExceptionClassRefs.add(DirectJClassRef.create(paramJClass));
/*     */   }
/*     */   
/*     */   public void addException(String paramString) {
/*  62 */     if (paramString == null) throw new IllegalArgumentException("null qcname"); 
/*  63 */     if (this.mExceptionClassRefs == null) this.mExceptionClassRefs = new ArrayList(); 
/*  64 */     this.mExceptionClassRefs.add(QualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void addUnqualifiedException(String paramString) {
/*  69 */     if (paramString == null) throw new IllegalArgumentException("null qcname"); 
/*  70 */     if (this.mExceptionClassRefs == null) this.mExceptionClassRefs = new ArrayList(); 
/*  71 */     this.mExceptionClassRefs.add(UnqualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeException(String paramString) {
/*  76 */     if (paramString == null) {
/*  77 */       throw new IllegalArgumentException("null classname");
/*     */     }
/*  79 */     if (this.mExceptionClassRefs != null) {
/*  80 */       this.mExceptionClassRefs.remove(paramString);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeException(JClass paramJClass) {
/*  85 */     removeException(paramJClass.getQualifiedName());
/*     */   }
/*     */   
/*     */   public MParameter addNewParameter() {
/*  89 */     if (this.mParameters == null) this.mParameters = new ArrayList(); 
/*  90 */     ParameterImpl parameterImpl = new ParameterImpl(defaultName(this.mParameters.size()), this, "java.lang.Object");
/*     */     
/*  92 */     this.mParameters.add(parameterImpl);
/*  93 */     return parameterImpl;
/*     */   }
/*     */   
/*     */   public void removeParameter(MParameter paramMParameter) {
/*  97 */     if (this.mParameters != null) this.mParameters.remove(paramMParameter); 
/*     */   }
/*     */   
/*     */   public MParameter[] getMutableParameters() {
/* 101 */     if (this.mParameters == null || this.mParameters.size() == 0) {
/* 102 */       return new MParameter[0];
/*     */     }
/* 104 */     MParameter[] arrayOfMParameter = new MParameter[this.mParameters.size()];
/* 105 */     this.mParameters.toArray((Object[])arrayOfMParameter);
/* 106 */     return arrayOfMParameter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JParameter[] getParameters() {
/* 114 */     return (JParameter[])getMutableParameters();
/*     */   }
/*     */   
/*     */   public JClass[] getExceptionTypes() {
/* 118 */     if (this.mExceptionClassRefs == null || this.mExceptionClassRefs.size() == 0) {
/* 119 */       return new JClass[0];
/*     */     }
/* 121 */     JClass[] arrayOfJClass = new JClass[this.mExceptionClassRefs.size()];
/* 122 */     for (byte b = 0; b < arrayOfJClass.length; b++) {
/* 123 */       arrayOfJClass[b] = ((JClassRef)this.mExceptionClassRefs.get(b)).getRefClass();
/*     */     }
/* 125 */     return arrayOfJClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getQualifiedName() {
/* 130 */     StringWriter stringWriter = new StringWriter();
/* 131 */     stringWriter.write(getContainingClass().getQualifiedName());
/* 132 */     stringWriter.write(46);
/* 133 */     stringWriter.write(getSimpleName());
/* 134 */     stringWriter.write(40);
/* 135 */     JParameter[] arrayOfJParameter = getParameters();
/* 136 */     for (byte b = 0; b < arrayOfJParameter.length; b++) {
/* 137 */       stringWriter.write(arrayOfJParameter[b].getType().getQualifiedName());
/* 138 */       if (b < arrayOfJParameter.length - 1) stringWriter.write(", "); 
/*     */     } 
/* 140 */     stringWriter.write(41);
/* 141 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnqualifiedThrows(List paramList) {
/* 149 */     if (paramList == null || paramList.size() == 0) {
/* 150 */       this.mExceptionClassRefs = null;
/*     */       return;
/*     */     } 
/* 153 */     this.mExceptionClassRefs = new ArrayList(paramList.size());
/* 154 */     for (byte b = 0; b < paramList.size(); b++)
/* 155 */       this.mExceptionClassRefs.add(UnqualifiedJClassRef.create(paramList.get(b), (ClassImpl)getContainingClass())); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\InvokableImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */