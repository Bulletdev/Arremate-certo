/*    */ package org.apache.xmlbeans.impl.jam.internal.javadoc;
/*    */ 
/*    */ import com.sun.javadoc.ClassDoc;
/*    */ import com.sun.javadoc.ExecutableMemberDoc;
/*    */ import com.sun.javadoc.Parameter;
/*    */ import com.sun.javadoc.ProgramElementDoc;
/*    */ import org.apache.xmlbeans.impl.jam.internal.TigerDelegate;
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*    */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class JavadocTigerDelegate
/*    */   extends TigerDelegate
/*    */ {
/*    */   private static final String JAVADOC_DELEGATE_IMPL = "org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegateImpl_150";
/*    */   public static final String ANNOTATION_DEFAULTS_DISABLED_PROPERTY = "ANNOTATION_DEFAULTS_DISABLED_PROPERTY";
/*    */   
/*    */   public static JavadocTigerDelegate create(JamLogger paramJamLogger) {
/* 52 */     if (!isTigerJavadocAvailable(paramJamLogger)) return null;
/*    */     
/*    */     try {
/* 55 */       JavadocTigerDelegate javadocTigerDelegate = (JavadocTigerDelegate)Class.forName("org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegateImpl_150").newInstance();
/*    */       
/* 57 */       javadocTigerDelegate.init(paramJamLogger);
/* 58 */       return javadocTigerDelegate;
/* 59 */     } catch (ClassNotFoundException classNotFoundException) {
/* 60 */       issue14BuildWarning(classNotFoundException, paramJamLogger);
/* 61 */     } catch (IllegalAccessException illegalAccessException) {
/* 62 */       paramJamLogger.error(illegalAccessException);
/* 63 */     } catch (InstantiationException instantiationException) {
/* 64 */       paramJamLogger.error(instantiationException);
/*    */     } 
/* 66 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static JavadocTigerDelegate create(ElementContext paramElementContext) {
/* 74 */     if (!isTigerJavadocAvailable(paramElementContext.getLogger())) return null;
/*    */     
/*    */     try {
/* 77 */       JavadocTigerDelegate javadocTigerDelegate = (JavadocTigerDelegate)Class.forName("org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegateImpl_150").newInstance();
/*    */       
/* 79 */       javadocTigerDelegate.init(paramElementContext);
/* 80 */       return javadocTigerDelegate;
/* 81 */     } catch (ClassNotFoundException classNotFoundException) {
/* 82 */       paramElementContext.getLogger().error(classNotFoundException);
/* 83 */     } catch (IllegalAccessException illegalAccessException) {
/* 84 */       paramElementContext.getLogger().error(illegalAccessException);
/* 85 */     } catch (InstantiationException instantiationException) {
/* 86 */       paramElementContext.getLogger().error(instantiationException);
/*    */     } 
/* 88 */     return null;
/*    */   }
/*    */   
/*    */   public abstract boolean isEnum(ClassDoc paramClassDoc);
/*    */   
/*    */   public abstract void init(JamLogger paramJamLogger);
/*    */   
/*    */   public abstract void populateAnnotationTypeIfNecessary(ClassDoc paramClassDoc, MClass paramMClass, JavadocClassBuilder paramJavadocClassBuilder);
/*    */   
/*    */   public abstract void extractAnnotations(MAnnotatedElement paramMAnnotatedElement, ProgramElementDoc paramProgramElementDoc);
/*    */   
/*    */   public abstract void extractAnnotations(MAnnotatedElement paramMAnnotatedElement, ExecutableMemberDoc paramExecutableMemberDoc, Parameter paramParameter);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\javadoc\JavadocTigerDelegate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */