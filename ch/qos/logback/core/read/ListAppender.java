/*    */ package ch.qos.logback.core.read;
/*    */ 
/*    */ import ch.qos.logback.core.AppenderBase;
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
/*    */ public class ListAppender<E>
/*    */   extends AppenderBase<E>
/*    */ {
/* 23 */   public List<E> list = new ArrayList<E>();
/*    */   
/*    */   protected void append(E paramE) {
/* 26 */     this.list.add(paramE);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\read\ListAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */