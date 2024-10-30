/*    */ package org.apache.commons.io.input;
/*    */ 
/*    */ import java.io.Reader;
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
/*    */ public class CharacterFilterReader
/*    */   extends AbstractCharacterFilterReader
/*    */ {
/*    */   private final int skip;
/*    */   
/*    */   public CharacterFilterReader(Reader paramReader, int paramInt) {
/* 39 */     super(paramReader);
/* 40 */     this.skip = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean filter(int paramInt) {
/* 45 */     return (paramInt == this.skip);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\CharacterFilterReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */