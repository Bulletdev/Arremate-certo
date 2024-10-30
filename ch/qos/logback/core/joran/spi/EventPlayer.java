/*    */ package ch.qos.logback.core.joran.spi;
/*    */ 
/*    */ import ch.qos.logback.core.joran.event.BodyEvent;
/*    */ import ch.qos.logback.core.joran.event.EndEvent;
/*    */ import ch.qos.logback.core.joran.event.SaxEvent;
/*    */ import ch.qos.logback.core.joran.event.StartEvent;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class EventPlayer
/*    */ {
/*    */   final Interpreter interpreter;
/*    */   List<SaxEvent> eventList;
/*    */   int currentIndex;
/*    */   
/*    */   public EventPlayer(Interpreter paramInterpreter) {
/* 31 */     this.interpreter = paramInterpreter;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<SaxEvent> getCopyOfPlayerEventList() {
/* 40 */     return new ArrayList<SaxEvent>(this.eventList);
/*    */   }
/*    */   
/*    */   public void play(List<SaxEvent> paramList) {
/* 44 */     this.eventList = paramList;
/*    */     
/* 46 */     for (this.currentIndex = 0; this.currentIndex < this.eventList.size(); this.currentIndex++) {
/* 47 */       SaxEvent saxEvent = this.eventList.get(this.currentIndex);
/*    */       
/* 49 */       if (saxEvent instanceof StartEvent) {
/* 50 */         this.interpreter.startElement((StartEvent)saxEvent);
/*    */         
/* 52 */         this.interpreter.getInterpretationContext().fireInPlay(saxEvent);
/*    */       } 
/* 54 */       if (saxEvent instanceof BodyEvent) {
/*    */         
/* 56 */         this.interpreter.getInterpretationContext().fireInPlay(saxEvent);
/* 57 */         this.interpreter.characters((BodyEvent)saxEvent);
/*    */       } 
/* 59 */       if (saxEvent instanceof EndEvent) {
/*    */         
/* 61 */         this.interpreter.getInterpretationContext().fireInPlay(saxEvent);
/* 62 */         this.interpreter.endElement((EndEvent)saxEvent);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void addEventsDynamically(List<SaxEvent> paramList, int paramInt) {
/* 69 */     this.eventList.addAll(this.currentIndex + paramInt, paramList);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\EventPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */