/*    */ package ch.qos.logback.core.spi;
/*    */ 
/*    */ import ch.qos.logback.core.helpers.CyclicBuffer;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CyclicBufferTracker<E>
/*    */   extends AbstractComponentTracker<CyclicBuffer<E>>
/*    */ {
/*    */   static final int DEFAULT_NUMBER_OF_BUFFERS = 64;
/*    */   static final int DEFAULT_BUFFER_SIZE = 256;
/* 30 */   int bufferSize = 256;
/*    */ 
/*    */   
/*    */   public CyclicBufferTracker() {
/* 34 */     setMaxComponents(64);
/*    */   }
/*    */   
/*    */   public int getBufferSize() {
/* 38 */     return this.bufferSize;
/*    */   }
/*    */   
/*    */   public void setBufferSize(int paramInt) {
/* 42 */     this.bufferSize = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void processPriorToRemoval(CyclicBuffer<E> paramCyclicBuffer) {
/* 47 */     paramCyclicBuffer.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   protected CyclicBuffer<E> buildComponent(String paramString) {
/* 52 */     return new CyclicBuffer(this.bufferSize);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isComponentStale(CyclicBuffer<E> paramCyclicBuffer) {
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   List<String> liveKeysAsOrderedList() {
/* 62 */     return new ArrayList<String>(this.liveMap.keySet());
/*    */   }
/*    */   
/*    */   List<String> lingererKeysAsOrderedList() {
/* 66 */     return new ArrayList<String>(this.lingerersMap.keySet());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\CyclicBufferTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */