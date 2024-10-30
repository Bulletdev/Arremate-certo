/*    */ package ch.qos.logback.core.joran.conditional;
/*    */ 
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.event.SaxEvent;
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import java.util.List;
/*    */ import java.util.Stack;
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
/*    */ public abstract class ThenOrElseActionBase
/*    */   extends Action
/*    */ {
/* 30 */   Stack<b> stateStack = new Stack<b>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/* 35 */     if (!weAreActive(paramInterpretationContext)) {
/*    */       return;
/*    */     }
/* 38 */     b b = new b();
/* 39 */     if (paramInterpretationContext.isListenerListEmpty()) {
/* 40 */       paramInterpretationContext.addInPlayListener(b);
/* 41 */       b.as = true;
/*    */     } 
/* 43 */     this.stateStack.push(b);
/*    */   }
/*    */   
/*    */   boolean weAreActive(InterpretationContext paramInterpretationContext) {
/* 47 */     Object object = paramInterpretationContext.peekObject();
/* 48 */     if (!(object instanceof IfAction))
/* 49 */       return false; 
/* 50 */     IfAction ifAction = (IfAction)object;
/* 51 */     return ifAction.isActive();
/*    */   }
/*    */ 
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {
/* 56 */     if (!weAreActive(paramInterpretationContext)) {
/*    */       return;
/*    */     }
/* 59 */     b b = this.stateStack.pop();
/* 60 */     if (b.as) {
/* 61 */       paramInterpretationContext.removeInPlayListener(b);
/* 62 */       Object object = paramInterpretationContext.peekObject();
/* 63 */       if (object instanceof IfAction) {
/* 64 */         IfAction ifAction = (IfAction)object;
/* 65 */         removeFirstAndLastFromList(b.eventList);
/* 66 */         registerEventList(ifAction, b.eventList);
/*    */       } else {
/* 68 */         throw new IllegalStateException("Missing IfAction on top of stack");
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   abstract void registerEventList(IfAction paramIfAction, List<SaxEvent> paramList);
/*    */   
/*    */   void removeFirstAndLastFromList(List<SaxEvent> paramList) {
/* 76 */     paramList.remove(0);
/* 77 */     paramList.remove(paramList.size() - 1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\conditional\ThenOrElseActionBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */