/*    */ package org.apache.commons.io.input;
/*    */ 
/*    */ import java.io.Reader;
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
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
/*    */ public class CharacterSetFilterReader
/*    */   extends AbstractCharacterFilterReader
/*    */ {
/* 33 */   private static final Set<Integer> EMPTY_SET = Collections.emptySet();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final Set<Integer> skipSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CharacterSetFilterReader(Reader paramReader, Set<Integer> paramSet) {
/* 45 */     super(paramReader);
/* 46 */     this.skipSet = (paramSet == null) ? EMPTY_SET : Collections.<Integer>unmodifiableSet(paramSet);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean filter(int paramInt) {
/* 52 */     return this.skipSet.contains(Integer.valueOf(paramInt));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\CharacterSetFilterReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */