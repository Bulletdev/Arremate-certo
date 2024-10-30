/*     */ package ch.qos.logback.core.joran.conditional;
/*     */ 
/*     */ import ch.qos.logback.core.joran.action.Action;
/*     */ import ch.qos.logback.core.joran.event.SaxEvent;
/*     */ import ch.qos.logback.core.joran.spi.ActionException;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.joran.spi.Interpreter;
/*     */ import ch.qos.logback.core.spi.PropertyContainer;
/*     */ import ch.qos.logback.core.util.EnvUtil;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ import org.xml.sax.Attributes;
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
/*     */ public class IfAction
/*     */   extends Action
/*     */ {
/*     */   private static final String CONDITION_ATTR = "condition";
/*     */   public static final String MISSING_JANINO_MSG = "Could not find Janino library on the class path. Skipping conditional processing.";
/*     */   public static final String MISSING_JANINO_SEE = "See also http://logback.qos.ch/codes.html#ifJanino";
/*  36 */   Stack<a> stack = new Stack<a>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/*  41 */     a a = new a();
/*  42 */     boolean bool = this.stack.isEmpty();
/*  43 */     this.stack.push(a);
/*     */     
/*  45 */     if (!bool) {
/*     */       return;
/*     */     }
/*     */     
/*  49 */     paramInterpretationContext.pushObject(this);
/*  50 */     if (!EnvUtil.isJaninoAvailable()) {
/*  51 */       addError("Could not find Janino library on the class path. Skipping conditional processing.");
/*  52 */       addError("See also http://logback.qos.ch/codes.html#ifJanino");
/*     */       
/*     */       return;
/*     */     } 
/*  56 */     a.active = true;
/*  57 */     Condition condition = null;
/*  58 */     String str = paramAttributes.getValue("condition");
/*     */     
/*  60 */     if (!OptionHelper.isEmpty(str)) {
/*  61 */       str = OptionHelper.substVars(str, (PropertyContainer)paramInterpretationContext, (PropertyContainer)this.context);
/*  62 */       PropertyEvalScriptBuilder propertyEvalScriptBuilder = new PropertyEvalScriptBuilder((PropertyContainer)paramInterpretationContext);
/*  63 */       propertyEvalScriptBuilder.setContext(this.context);
/*     */       try {
/*  65 */         condition = propertyEvalScriptBuilder.build(str);
/*  66 */       } catch (Exception exception) {
/*  67 */         addError("Failed to parse condition [" + str + "]", exception);
/*     */       } 
/*     */       
/*  70 */       if (condition != null) {
/*  71 */         a.a = Boolean.valueOf(condition.evaluate());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {
/*  80 */     a a = this.stack.pop();
/*  81 */     if (!a.active) {
/*     */       return;
/*     */     }
/*     */     
/*  85 */     Object object = paramInterpretationContext.peekObject();
/*  86 */     if (object == null) {
/*  87 */       throw new IllegalStateException("Unexpected null object on stack");
/*     */     }
/*  89 */     if (!(object instanceof IfAction)) {
/*  90 */       throw new IllegalStateException("Unexpected object of type [" + object.getClass() + "] on stack");
/*     */     }
/*     */     
/*  93 */     if (object != this) {
/*  94 */       throw new IllegalStateException("IfAction different then current one on stack");
/*     */     }
/*  96 */     paramInterpretationContext.popObject();
/*     */     
/*  98 */     if (a.a == null) {
/*  99 */       addError("Failed to determine \"if then else\" result");
/*     */       
/*     */       return;
/*     */     } 
/* 103 */     Interpreter interpreter = paramInterpretationContext.getJoranInterpreter();
/* 104 */     List<SaxEvent> list = a.I;
/* 105 */     if (!a.a.booleanValue()) {
/* 106 */       list = a.J;
/*     */     }
/*     */ 
/*     */     
/* 110 */     if (list != null)
/*     */     {
/* 112 */       interpreter.getEventPlayer().addEventsDynamically(list, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setThenSaxEventList(List<SaxEvent> paramList) {
/* 118 */     a a = this.stack.firstElement();
/* 119 */     if (a.active) {
/* 120 */       a.I = paramList;
/*     */     } else {
/* 122 */       throw new IllegalStateException("setThenSaxEventList() invoked on inactive IfAction");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setElseSaxEventList(List<SaxEvent> paramList) {
/* 127 */     a a = this.stack.firstElement();
/* 128 */     if (a.active) {
/* 129 */       a.J = paramList;
/*     */     } else {
/* 131 */       throw new IllegalStateException("setElseSaxEventList() invoked on inactive IfAction");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive() {
/* 137 */     if (this.stack == null)
/* 138 */       return false; 
/* 139 */     if (this.stack.isEmpty())
/* 140 */       return false; 
/* 141 */     return ((a)this.stack.peek()).active;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\conditional\IfAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */