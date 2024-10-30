/*    */ package ch.qos.logback.classic.joran.action;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import org.xml.sax.Attributes;
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
/*    */ public class LevelAction
/*    */   extends Action
/*    */ {
/*    */   boolean inError = false;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 37 */     Object object = paramInterpretationContext.peekObject();
/*    */     
/* 39 */     if (!(object instanceof Logger)) {
/* 40 */       this.inError = true;
/* 41 */       addError("For element <level>, could not find a logger at the top of execution stack.");
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     Logger logger = (Logger)object;
/*    */     
/* 47 */     String str1 = logger.getName();
/*    */     
/* 49 */     String str2 = paramInterpretationContext.subst(paramAttributes.getValue("value"));
/*    */ 
/*    */ 
/*    */     
/* 53 */     if ("INHERITED".equalsIgnoreCase(str2) || "NULL".equalsIgnoreCase(str2)) {
/* 54 */       logger.setLevel(null);
/*    */     } else {
/* 56 */       logger.setLevel(Level.toLevel(str2, Level.DEBUG));
/*    */     } 
/*    */     
/* 59 */     addInfo(str1 + " level set to " + logger.getLevel());
/*    */   }
/*    */   
/*    */   public void finish(InterpretationContext paramInterpretationContext) {}
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\LevelAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */