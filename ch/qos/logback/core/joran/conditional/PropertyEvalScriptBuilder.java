/*    */ package ch.qos.logback.core.joran.conditional;
/*    */ 
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
/*    */ import ch.qos.logback.core.spi.PropertyContainer;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.codehaus.commons.compiler.CompileException;
/*    */ import org.codehaus.janino.ClassBodyEvaluator;
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
/*    */ public class PropertyEvalScriptBuilder
/*    */   extends ContextAwareBase
/*    */ {
/* 29 */   private static String SCRIPT_PREFIX = "public boolean evaluate() { return ";
/* 30 */   private static String SCRIPT_SUFFIX = "; }";
/*    */   
/*    */   final PropertyContainer localPropContainer;
/*    */   
/*    */   Map<String, String> map;
/*    */ 
/*    */   
/*    */   PropertyEvalScriptBuilder(PropertyContainer paramPropertyContainer) {
/* 38 */     this.map = new HashMap<String, String>();
/*    */     this.localPropContainer = paramPropertyContainer;
/*    */   }
/*    */   
/*    */   public Condition build(String paramString) throws IllegalAccessException, CompileException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
/* 43 */     ClassBodyEvaluator classBodyEvaluator = new ClassBodyEvaluator();
/* 44 */     classBodyEvaluator.setImplementedInterfaces(new Class[] { Condition.class });
/* 45 */     classBodyEvaluator.setExtendedClass(PropertyWrapperForScripts.class);
/* 46 */     classBodyEvaluator.setParentClassLoader(ClassBodyEvaluator.class.getClassLoader());
/* 47 */     classBodyEvaluator.cook(SCRIPT_PREFIX + paramString + SCRIPT_SUFFIX);
/*    */     
/* 49 */     Class<Condition> clazz = classBodyEvaluator.getClazz();
/* 50 */     Condition condition = clazz.newInstance();
/* 51 */     Method method = clazz.getMethod("setPropertyContainers", new Class[] { PropertyContainer.class, PropertyContainer.class });
/* 52 */     method.invoke(condition, new Object[] { this.localPropContainer, this.context });
/*    */     
/* 54 */     return condition;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\conditional\PropertyEvalScriptBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */