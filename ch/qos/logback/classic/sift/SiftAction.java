/*    */ package ch.qos.logback.classic.sift;
/*    */ 
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.event.InPlayListener;
/*    */ import ch.qos.logback.core.joran.event.SaxEvent;
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.sift.AppenderFactory;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public class SiftAction
/*    */   extends Action
/*    */   implements InPlayListener
/*    */ {
/*    */   List<SaxEvent> seList;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/* 33 */     this.seList = new ArrayList<SaxEvent>();
/* 34 */     paramInterpretationContext.addInPlayListener(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {
/* 39 */     paramInterpretationContext.removeInPlayListener(this);
/* 40 */     Object object = paramInterpretationContext.peekObject();
/* 41 */     if (object instanceof SiftingAppender) {
/* 42 */       SiftingAppender siftingAppender = (SiftingAppender)object;
/* 43 */       Map<String, String> map = paramInterpretationContext.getCopyOfPropertyMap();
/* 44 */       AppenderFactoryUsingJoran appenderFactoryUsingJoran = new AppenderFactoryUsingJoran(this.seList, siftingAppender.getDiscriminatorKey(), map);
/* 45 */       siftingAppender.setAppenderFactory((AppenderFactory)appenderFactoryUsingJoran);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void inPlay(SaxEvent paramSaxEvent) {
/* 50 */     this.seList.add(paramSaxEvent);
/*    */   }
/*    */   
/*    */   public List<SaxEvent> getSeList() {
/* 54 */     return this.seList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\sift\SiftAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */