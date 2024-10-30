/*    */ package org.apache.commons.io.output;
/*    */ 
/*    */ import java.io.Writer;
/*    */ import java.util.Collection;
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
/*    */ public class TeeWriter
/*    */   extends ProxyCollectionWriter
/*    */ {
/*    */   public TeeWriter(Collection<Writer> paramCollection) {
/* 40 */     super(paramCollection);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TeeWriter(Writer... paramVarArgs) {
/* 49 */     super(paramVarArgs);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\TeeWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */